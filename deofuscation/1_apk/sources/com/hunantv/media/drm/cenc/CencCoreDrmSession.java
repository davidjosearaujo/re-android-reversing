package com.hunantv.media.drm.cenc;

import android.media.MediaDrm;
import android.os.Build;
import android.util.Base64;
import c.a.a.b.c.a;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmConstans;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.drm.utils.MgtvDrmUtils;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.utils.ByteUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CencCoreDrmSession {
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_NONE = 0;
    private static final String TAG = "CencCoreDrmSession";
    private static final Set<UUID> sCandidateDRMSet = new HashSet<UUID>() { // from class: com.hunantv.media.drm.cenc.CencCoreDrmSession.1
        {
            add(MgtvDrmConstans.CHINADRM_UUID);
        }
    };
    public MediaDrm drm;
    public List<MgtvDrmParams.DrmInfo> drmInfoList;
    public byte[] drmSessionId;
    private OnDoLicenseListener licenseListener;
    public Map<UUID, MgtvDrmUtils.PSSH> psshMap;
    public String selectedLicenseUrl;
    public MgtvDrmUtils.PSSH selectedPssh;
    public UUID selectedUUID;
    public Object locker = new Object();
    public volatile int status = 0;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnDoLicenseListener {
        void onFailed(int i, String str);

        void onSuccess();
    }

    public CencCoreDrmSession(Map<UUID, MgtvDrmUtils.PSSH> map, List<MgtvDrmParams.DrmInfo> list) {
        this.psshMap = map;
        this.drmInfoList = list;
        selectDrmSolution(map, list);
    }

    public CencCoreDrmSession(Map<UUID, MgtvDrmUtils.PSSH> map, List<MgtvDrmParams.DrmInfo> list, OnDoLicenseListener onDoLicenseListener) {
        this.psshMap = map;
        this.drmInfoList = list;
        this.licenseListener = onDoLicenseListener;
        selectDrmSolution(map, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doLicenseListenerFailed(int i, String str) {
        if (this.status != 1) {
            this.status = 1;
            OnDoLicenseListener onDoLicenseListener = this.licenseListener;
            if (onDoLicenseListener != null) {
                onDoLicenseListener.onFailed(i, str);
            }
        }
    }

    private static String getContentType(UUID uuid) {
        return MgtvDrmConstans.PLAYREADY_UUID.equals(uuid) ? "text/xml" : (MgtvDrmConstans.CLEARKEY_UUID.equals(uuid) || MgtvDrmConstans.CHINADRM_UUID.equals(uuid)) ? RequestParams.APPLICATION_JSON : RequestParams.APPLICATION_OCTET_STREAM;
    }

    private String getLicenseUrl(UUID uuid) {
        for (MgtvDrmParams.DrmInfo drmInfo : this.drmInfoList) {
            if (drmInfo != null && MgtvDrmUtils.sCommercialDrmSolutionValueMap.get(uuid).equalsIgnoreCase(drmInfo.drmSolution)) {
                return drmInfo.licenseUrl;
            }
        }
        return null;
    }

    private void selectDrmSolution(Map<UUID, MgtvDrmUtils.PSSH> map, List<MgtvDrmParams.DrmInfo> list) {
        int i;
        String str;
        if (map == null || map.size() <= 0) {
            i = 208;
            str = "pssh empty";
        } else {
            if (map.containsKey(MgtvDrmConstans.MARLIN_UUID)) {
                DebugLog.i(TAG, "pssh contains marlin uuid");
            }
            if (map.containsKey(MgtvDrmConstans.CHINADRM_UUID)) {
                DebugLog.i(TAG, "pssh contains chinadrm uuid");
            }
            if (map.containsKey(MgtvDrmConstans.WIDEVINE_UUID)) {
                DebugLog.i(TAG, "pssh contains widevine uuid");
            }
            for (UUID uuid : sCandidateDRMSet) {
                if (map.containsKey(uuid) && MgtvDrmUtils.isCryptoSchemeSupported(uuid)) {
                    String licenseUrl = getLicenseUrl(uuid);
                    if (!StringUtil.isEmpty(licenseUrl)) {
                        this.selectedUUID = uuid;
                        this.selectedPssh = map.get(uuid);
                        this.selectedLicenseUrl = licenseUrl;
                        DebugLog.i(TAG, "pssh select" + uuid);
                        return;
                    }
                }
            }
            i = IDrmSession.ERROR_SESSION_DRM_PSSHS_NOT_SUPPORT;
            str = "pssh not support";
        }
        doLicenseListenerFailed(i, str);
    }

    public void close() {
        DebugLog.i(TAG, "close in");
        synchronized (this.locker) {
            MediaDrm mediaDrm = this.drm;
            if (mediaDrm != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    byte[] bArr = this.drmSessionId;
                    if (bArr != null && bArr.length > 0) {
                        mediaDrm.closeSession(bArr);
                    }
                    this.drm.release();
                }
                this.licenseListener = null;
                this.drm = null;
            }
        }
        DebugLog.i(TAG, "close out");
    }

    public void doLicense() {
        MgtvDrmUtils.PSSH pssh;
        List list;
        DebugLog.i(TAG, "doLicense in");
        synchronized (this.locker) {
            if (this.status == 1) {
                return;
            }
            UUID uuid = this.selectedUUID;
            if (uuid == null || this.selectedPssh == null) {
                DebugLog.e(TAG, "drm selected null");
                doLicenseListenerFailed(IDrmSession.ERROR_SESSION_PROVISION_NO_SELECT_DRM, "");
                return;
            }
            try {
                if (Build.VERSION.SDK_INT < 18 || !MediaDrm.isCryptoSchemeSupported(uuid)) {
                    DebugLog.e(TAG, "error: request license not support yet");
                    doLicenseListenerFailed(IDrmSession.ERROR_SESSION_SELECT_DRM_NOT_SUPPORT, "");
                } else {
                    MediaDrm mediaDrm = new MediaDrm(this.selectedUUID);
                    this.drm = mediaDrm;
                    byte[] openSession = mediaDrm.openSession();
                    this.drmSessionId = openSession;
                    MediaDrm.KeyRequest keyRequest = this.drm.getKeyRequest(openSession, this.selectedPssh.rawData, "video/mp4", 1, new HashMap<>());
                    if (keyRequest == null) {
                        DebugLog.e(TAG, "doLicense keyRequest is null");
                        doLicenseListenerFailed(IDrmSession.ERROR_SESSION_KEY_REQUEST_NULL, "");
                        return;
                    }
                    String str = null;
                    HashMap hashMap = new HashMap();
                    if (MgtvDrmConstans.CHINADRM_UUID.equals(this.selectedUUID) && (pssh = this.selectedPssh) != null && (list = pssh.key_ids) != null && list.size() > 0) {
                        str = new String(Base64.decode((String) this.selectedPssh.key_ids.get(0), 0));
                        hashMap.put(SDKConstants.PARAM_KEY, str);
                    }
                    String contentType = getContentType(this.selectedUUID);
                    DebugLog.i(TAG, "doLicense selectedUrl:" + this.selectedLicenseUrl + " ,key=" + str);
                    a.i(this.selectedLicenseUrl, hashMap, contentType, keyRequest.getData(), true, new a.d() { // from class: com.hunantv.media.drm.cenc.CencCoreDrmSession.2
                        public void onFailed(String str2, int i) {
                            DebugLog.e(CencCoreDrmSession.TAG, "request license onFailed err:" + i);
                            CencCoreDrmSession cencCoreDrmSession = CencCoreDrmSession.this;
                            cencCoreDrmSession.doLicenseListenerFailed(i, "url:" + str2);
                        }

                        public void onSuccess(String str2, int i, byte[] bArr) {
                            CencCoreDrmSession cencCoreDrmSession;
                            int i2;
                            StringBuilder sb;
                            String str3;
                            synchronized (CencCoreDrmSession.this.locker) {
                                DebugLog.i(CencCoreDrmSession.TAG, "request license onSuccess code:" + i);
                                if (ByteUtil.isEmpty(bArr)) {
                                    DebugLog.e(CencCoreDrmSession.TAG, "error: response license empty");
                                    cencCoreDrmSession = CencCoreDrmSession.this;
                                    i2 = 201;
                                    sb = new StringBuilder();
                                    sb.append("url:");
                                    sb.append(str2);
                                } else {
                                    cencCoreDrmSession = CencCoreDrmSession.this;
                                    MediaDrm mediaDrm2 = cencCoreDrmSession.drm;
                                    if (mediaDrm2 != null) {
                                        try {
                                            mediaDrm2.provideKeyResponse(cencCoreDrmSession.drmSessionId, bArr);
                                            if (CencCoreDrmSession.this.licenseListener != null) {
                                                CencCoreDrmSession.this.licenseListener.onSuccess();
                                            }
                                        } catch (Exception e) {
                                            DebugLog.e(CencCoreDrmSession.TAG, "error: provideKeyResponse exception " + e.getMessage());
                                            CencCoreDrmSession cencCoreDrmSession2 = CencCoreDrmSession.this;
                                            i2 = IDrmSession.ERROR_SESSION_PROVISION_PROVIDE_LICENSE_EXCEPTION;
                                            str3 = e.getMessage() + " url:" + str2;
                                            cencCoreDrmSession = cencCoreDrmSession2;
                                        }
                                    } else {
                                        i2 = IDrmSession.ERROR_SESSION_DRM_NULL;
                                        sb = new StringBuilder();
                                        sb.append("url:");
                                        sb.append(str2);
                                    }
                                }
                                str3 = sb.toString();
                                cencCoreDrmSession.doLicenseListenerFailed(i2, str3);
                            }
                        }
                    });
                }
            } catch (Exception e) {
                DebugLog.e(TAG, "error: dolicense exception " + e.getMessage());
                doLicenseListenerFailed(200, e.getMessage());
            }
            DebugLog.i(TAG, "doLicense out");
        }
    }

    public byte[] getDrmSessionId() {
        return this.drmSessionId;
    }

    public UUID getSelectedUUID() {
        return this.selectedUUID;
    }

    public void setOnDoLicenseListener(OnDoLicenseListener onDoLicenseListener) {
        synchronized (this.locker) {
            this.licenseListener = onDoLicenseListener;
        }
    }
}
