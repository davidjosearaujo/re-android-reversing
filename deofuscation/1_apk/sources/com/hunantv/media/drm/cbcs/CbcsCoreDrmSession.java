package com.hunantv.media.drm.cbcs;

import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import c.a.a.a.f;
import c.a.a.b.c.a;
import com.facebook.internal.security.CertificateUtil;
import com.hunantv.imgo.entity.JumpAction;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmConstans;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.drm.utils.Hex;
import com.hunantv.media.drm.utils.MgtvDrmUtils;
import com.hunantv.media.drm.wasabi.WasabiDrmSession;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.player.utils.UrlUtil;
import com.hunantv.media.utils.ByteUtil;
import com.mgtv.drm.ILightPlayDrmSession;
import com.mgtv.drm.LightPlayDrmManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CbcsCoreDrmSession {
    private static final UUID[] MULTIDRM_ORDER_0;
    private static final UUID[] MULTIDRM_ORDER_1;
    private static final UUID[] MULTIDRM_ORDER_9;
    public static final int STATUS_CLOSE = 9;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_SUCCESS = 2;
    private static final String TAG = "CbcsCoreDrmSession";
    private static UUID[] sMultiDrmOrder;
    private static Object sMultiDrmOrderLocker;
    private static UUID[] sSpecificMultiDrmOrder;
    public static boolean sUseLightPlayDefaultValue;
    private static boolean useSpecificDrmOrder;
    public ILightPlayDrmSession currentLightPlaySession;
    public WasabiDrmSession currentWasabiSession;
    public MediaDrm drm;
    public List<MgtvDrmParams.DrmInfo> drmInfoList;
    public byte[] drmSessionId;
    private OnDoLicenseListener licenseListener;
    public f mPlayer;
    public UUID[] multiDrmOrder;
    public Map<UUID, MgtvDrmUtils.PSSH> psshMap;
    public MgtvDrmParams.DrmInfo selectedDrmInfo;
    public String selectedLicenseUrl;
    public MgtvDrmUtils.PSSH selectedPssh;
    public UUID selectedUUID;
    public IDrmManager wasabiDrmManager;
    public Object locker = new Object();
    public volatile int status = 0;
    public boolean useLightPlay = sUseLightPlayDefaultValue;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnDoLicenseListener {
        void onFailed(int i, String str);

        void onSuccess(int i);
    }

    static {
        UUID uuid = MgtvDrmConstans.MARLIN_UUID;
        UUID uuid2 = MgtvDrmConstans.WIDEVINE_UUID;
        UUID[] uuidArr = {uuid, uuid2};
        MULTIDRM_ORDER_0 = uuidArr;
        MULTIDRM_ORDER_1 = new UUID[]{uuid2, uuid};
        MULTIDRM_ORDER_9 = new UUID[]{MgtvDrmConstans.CHINADRM_UUID, uuid, uuid2};
        sMultiDrmOrder = uuidArr;
        sMultiDrmOrderLocker = new Object();
        sSpecificMultiDrmOrder = null;
        sUseLightPlayDefaultValue = false;
    }

    public CbcsCoreDrmSession(Map<UUID, MgtvDrmUtils.PSSH> map, List<MgtvDrmParams.DrmInfo> list) {
        this.multiDrmOrder = MULTIDRM_ORDER_0;
        this.psshMap = map;
        this.drmInfoList = list;
        this.multiDrmOrder = getMultiDrmOrder();
        init();
    }

    public CbcsCoreDrmSession(Map<UUID, MgtvDrmUtils.PSSH> map, List<MgtvDrmParams.DrmInfo> list, OnDoLicenseListener onDoLicenseListener) {
        this.multiDrmOrder = MULTIDRM_ORDER_0;
        this.psshMap = map;
        this.drmInfoList = list;
        this.licenseListener = onDoLicenseListener;
        this.multiDrmOrder = getMultiDrmOrder();
        init();
    }

    private void doLicenseFramework(boolean z) {
        List list;
        try {
            if (Build.VERSION.SDK_INT < 18) {
                DebugLog.e(TAG, "error: request license not support yet");
                doLicenseListenerFailed(IDrmSession.ERROR_SESSION_SELECT_DRM_NOT_SUPPORT, "");
                return;
            }
            if (this.drm == null) {
                this.drm = new MediaDrm(this.selectedUUID);
            }
            MediaDrm mediaDrm = this.drm;
            if (mediaDrm != null) {
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
                MgtvDrmUtils.PSSH pssh = this.selectedPssh;
                if (pssh != null && (list = pssh.key_ids) != null && list.size() > 0) {
                    if (MgtvDrmConstans.CHINADRM_UUID.equals(this.selectedUUID)) {
                        str = new String(Base64.decode((String) this.selectedPssh.key_ids.get(0), 0));
                    } else if (MgtvDrmConstans.WIDEVINE_UUID.equals(this.selectedUUID)) {
                        str = new String(Hex.encodeHex((byte[]) this.selectedPssh.key_ids.get(0)));
                    }
                    hashMap.put("keyid", str);
                }
                String contentType = getContentType(this.selectedUUID);
                DebugLog.i(TAG, "doLicense selectedUrl:" + this.selectedLicenseUrl + " ,keyid=" + str);
                a.i(this.selectedLicenseUrl, hashMap, contentType, keyRequest.getData(), true, new a.d() { // from class: com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.3
                    public void onFailed(String str2, int i) {
                        DebugLog.e(CbcsCoreDrmSession.TAG, "request license onFailed err:" + i);
                        CbcsCoreDrmSession cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                        cbcsCoreDrmSession.doLicenseListenerFailed(i, "url:" + str2);
                    }

                    public void onSuccess(String str2, int i, byte[] bArr) {
                        CbcsCoreDrmSession cbcsCoreDrmSession;
                        int i2;
                        StringBuilder sb;
                        String str3;
                        synchronized (CbcsCoreDrmSession.this.locker) {
                            DebugLog.i(CbcsCoreDrmSession.TAG, "request license onSuccess code:" + i);
                            if (ByteUtil.isEmpty(bArr)) {
                                DebugLog.e(CbcsCoreDrmSession.TAG, "error: response license empty");
                                cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                                i2 = 201;
                                sb = new StringBuilder();
                                sb.append("url:");
                                sb.append(str2);
                            } else {
                                cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                                MediaDrm mediaDrm2 = cbcsCoreDrmSession.drm;
                                if (mediaDrm2 != null) {
                                    try {
                                        mediaDrm2.provideKeyResponse(cbcsCoreDrmSession.drmSessionId, bArr);
                                        if (CbcsCoreDrmSession.this.licenseListener != null) {
                                            CbcsCoreDrmSession.this.licenseListener.onSuccess(1);
                                        }
                                    } catch (Exception e) {
                                        DebugLog.e(CbcsCoreDrmSession.TAG, "error: provideKeyResponse exception " + e.getMessage());
                                        CbcsCoreDrmSession cbcsCoreDrmSession2 = CbcsCoreDrmSession.this;
                                        i2 = IDrmSession.ERROR_SESSION_PROVISION_PROVIDE_LICENSE_EXCEPTION;
                                        str3 = e.getMessage() + " url:" + str2;
                                        cbcsCoreDrmSession = cbcsCoreDrmSession2;
                                    }
                                } else {
                                    i2 = IDrmSession.ERROR_SESSION_DRM_NULL;
                                    sb = new StringBuilder();
                                    sb.append("url:");
                                    sb.append(str2);
                                }
                            }
                            str3 = sb.toString();
                            cbcsCoreDrmSession.doLicenseListenerFailed(i2, str3);
                        }
                    }
                });
            }
        } catch (Exception e) {
            DebugLog.e(TAG, "error: dolicense exception " + e.getMessage());
            if (Build.VERSION.SDK_INT < 18 || !(e instanceof NotProvisionedException)) {
                doLicenseListenerFailed(200, e.getMessage());
            } else if (z) {
                DebugLog.e(TAG, "dolicense error try provision first");
                doProvision();
            } else {
                DebugLog.e(TAG, "error: dolicense NotProvisionedException");
                doLicenseListenerFailed(IDrmSession.ERROR_SESSION_NO_PROVISION, e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLicenseInner(boolean z) {
        int i;
        if (this.status == 1 || this.status == 9) {
            return;
        }
        UUID uuid = this.selectedUUID;
        if (uuid == null || this.selectedPssh == null) {
            DebugLog.e(TAG, "drm selected null");
            i = IDrmSession.ERROR_SESSION_PROVISION_NO_SELECT_DRM;
        } else {
            UUID uuid2 = MgtvDrmConstans.CHINADRM_UUID;
            if ((uuid2.equals(uuid) && "4".equals(this.selectedDrmInfo.drmSolution)) || MgtvDrmConstans.WIDEVINE_UUID.equals(this.selectedUUID)) {
                doLicenseFramework(z);
                return;
            } else if (isMarlinSelected()) {
                doLicenseMarlin(z);
                return;
            } else if (uuid2.equals(this.selectedUUID) && "6".equals(this.selectedDrmInfo.drmSolution)) {
                DebugLog.i(TAG, "lightplay selected");
                if (LightPlayDrmManager.getInstance().isProvisioned()) {
                    doLicenseLightPlay(false);
                    return;
                } else {
                    doProvisionLightPlay();
                    return;
                }
            } else {
                i = IDrmSession.ERROR_SESSION_SELECT_DRM_NOT_SUPPORT;
            }
        }
        doLicenseListenerFailed(i, "");
    }

    private void doLicenseLightPlay(boolean z) {
        String str;
        List list;
        try {
            HashMap hashMap = new HashMap();
            MgtvDrmUtils.PSSH pssh = this.selectedPssh;
            if (pssh == null || (list = pssh.key_ids) == null || list.size() <= 0 || !MgtvDrmConstans.CHINADRM_UUID.equals(this.selectedUUID)) {
                str = null;
            } else {
                str = new String(Base64.decode((String) this.selectedPssh.key_ids.get(0), 0));
                hashMap.put("keyid", str);
            }
            ILightPlayDrmSession openSession = LightPlayDrmManager.getInstance().openSession();
            this.currentLightPlaySession = openSession;
            byte[] licenseRequest = openSession.getLicenseRequest();
            String contentType = getContentType(this.selectedUUID);
            DebugLog.i(TAG, "doLicenseLightPlay selectedUrl:" + this.selectedLicenseUrl + " ,keyid=" + str);
            a.i(this.selectedLicenseUrl, hashMap, contentType, licenseRequest, true, new a.d() { // from class: com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.2
                public void onFailed(String str2, int i) {
                    DebugLog.e(CbcsCoreDrmSession.TAG, "request license onFailed err:" + i);
                    CbcsCoreDrmSession cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                    cbcsCoreDrmSession.doLicenseListenerFailed(i, "url:" + str2);
                }

                public void onSuccess(String str2, int i, byte[] bArr) {
                    CbcsCoreDrmSession cbcsCoreDrmSession;
                    int i2;
                    StringBuilder sb;
                    synchronized (CbcsCoreDrmSession.this.locker) {
                        DebugLog.i(CbcsCoreDrmSession.TAG, "request license onSuccess code:" + i);
                        if (CbcsCoreDrmSession.this.currentLightPlaySession == null) {
                            DebugLog.i(CbcsCoreDrmSession.TAG, "session already close. only return");
                            return;
                        }
                        if (ByteUtil.isEmpty(bArr)) {
                            DebugLog.e(CbcsCoreDrmSession.TAG, "error: response license empty");
                            cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                            i2 = 201;
                            sb = new StringBuilder();
                            sb.append("url:");
                            sb.append(str2);
                        } else {
                            int provideLicenseResponse = CbcsCoreDrmSession.this.currentLightPlaySession.provideLicenseResponse(bArr);
                            if (provideLicenseResponse == 0) {
                                DebugLog.i(CbcsCoreDrmSession.TAG, "provideLicenseResponse success ");
                                if (CbcsCoreDrmSession.this.licenseListener != null) {
                                    CbcsCoreDrmSession.this.licenseListener.onSuccess(1);
                                }
                            }
                            DebugLog.e(CbcsCoreDrmSession.TAG, "provideLicenseResponse error ret:" + provideLicenseResponse);
                            cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                            i2 = IDrmSession.ERROR_SESSION_PROVISION_PROVIDE_LICENSE_EXCEPTION;
                            sb = new StringBuilder();
                            sb.append("url:");
                            sb.append(str2);
                        }
                        cbcsCoreDrmSession.doLicenseListenerFailed(i2, sb.toString());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            doLicenseListenerFailed(200, e.getMessage());
        }
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

    private void doLicenseMarlin(boolean z) {
        final String str;
        List list;
        try {
            HashMap hashMap = new HashMap();
            MgtvDrmUtils.PSSH pssh = this.selectedPssh;
            if (pssh == null || (list = pssh.key_ids) == null || list.size() <= 0 || !isMarlinSelected()) {
                str = null;
            } else {
                str = new String(Hex.encodeHex((byte[]) this.selectedPssh.key_ids.get(0)));
                hashMap.put("keyid", str);
            }
            String contentType = getContentType(this.selectedUUID);
            DebugLog.i(TAG, "doLicense selectedUrl:" + this.selectedLicenseUrl + " ,keyid=" + str);
            a.i(this.selectedLicenseUrl, hashMap, contentType, (byte[]) null, true, new a.d() { // from class: com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.1
                public void onFailed(String str2, int i) {
                    DebugLog.e(CbcsCoreDrmSession.TAG, "request license onFailed err:" + i);
                    CbcsCoreDrmSession cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                    cbcsCoreDrmSession.doLicenseListenerFailed(i, "url:" + str2);
                }

                public void onSuccess(String str2, int i, byte[] bArr) {
                    synchronized (CbcsCoreDrmSession.this.locker) {
                        DebugLog.i(CbcsCoreDrmSession.TAG, "request license onSuccess code:" + i);
                        if (ByteUtil.isEmpty(bArr)) {
                            DebugLog.e(CbcsCoreDrmSession.TAG, "error: response license empty");
                            CbcsCoreDrmSession.this.doLicenseListenerFailed(201, "url:" + str2);
                        } else if (CbcsCoreDrmSession.this.isMarlinSelected() && CbcsCoreDrmSession.this.wasabiDrmManager != null) {
                            String str3 = "urn:marlin:kid:" + str;
                            WasabiDrmSession wasabiDrmSession = CbcsCoreDrmSession.this.currentWasabiSession;
                            if (wasabiDrmSession != null) {
                                wasabiDrmSession.close();
                                CbcsCoreDrmSession.this.currentWasabiSession = null;
                            }
                            IDrmManager.SessionConfig sessionConfig = new IDrmManager.SessionConfig(new String(bArr), str3);
                            sessionConfig.tokenNeedDecode = false;
                            CbcsCoreDrmSession cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                            cbcsCoreDrmSession.currentWasabiSession = (WasabiDrmSession) cbcsCoreDrmSession.wasabiDrmManager.genDrmSession(sessionConfig);
                            CbcsCoreDrmSession.this.currentWasabiSession.addOnProvisionSuccessListener(new IDrmSession.OnProvisionSuccessListener() { // from class: com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.1.1
                                @Override // com.hunantv.media.drm.IDrmSession.OnProvisionSuccessListener
                                public void onSuccess(IDrmSession iDrmSession) {
                                    if (CbcsCoreDrmSession.this.licenseListener != null) {
                                        CbcsCoreDrmSession.this.licenseListener.onSuccess(CbcsCoreDrmSession.this.currentWasabiSession.getLic());
                                    }
                                }
                            });
                            CbcsCoreDrmSession.this.currentWasabiSession.addOnProvisionErrorListener(new IDrmSession.OnProvisionErrorListener() { // from class: com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.1.2
                                @Override // com.hunantv.media.drm.IDrmSession.OnProvisionErrorListener
                                public void onError(IDrmSession iDrmSession, int i2, String str4) {
                                    DebugLog.e(CbcsCoreDrmSession.TAG, "onError errorCode:" + i2 + ",msg:" + str4);
                                    CbcsCoreDrmSession cbcsCoreDrmSession2 = CbcsCoreDrmSession.this;
                                    cbcsCoreDrmSession2.doLicenseListenerFailed(215, i2 + CertificateUtil.DELIMITER + str4);
                                }
                            });
                            CbcsCoreDrmSession.this.currentWasabiSession.provisionAsync();
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            doLicenseListenerFailed(200, e.getMessage());
        }
    }

    private static String getContentType(UUID uuid) {
        return MgtvDrmConstans.PLAYREADY_UUID.equals(uuid) ? "text/xml" : (MgtvDrmConstans.CLEARKEY_UUID.equals(uuid) || MgtvDrmConstans.CHINADRM_UUID.equals(uuid)) ? RequestParams.APPLICATION_JSON : RequestParams.APPLICATION_OCTET_STREAM;
    }

    private MgtvDrmParams.DrmInfo getDrmInfo(UUID uuid) {
        for (MgtvDrmParams.DrmInfo drmInfo : this.drmInfoList) {
            Map<UUID, String> drmSolutionValueMap = getDrmSolutionValueMap();
            if (drmInfo != null && drmSolutionValueMap.get(uuid) != null && drmSolutionValueMap.get(uuid).equalsIgnoreCase(drmInfo.drmSolution)) {
                return drmInfo;
            }
        }
        return null;
    }

    private Map<UUID, String> getDrmSolutionValueMap() {
        return this.useLightPlay ? MgtvDrmUtils.sNonCommercialDrmSolutionValueMap : MgtvDrmUtils.sCommercialDrmSolutionValueMap;
    }

    public static UUID[] getMultiDrmOrder() {
        synchronized (sMultiDrmOrderLocker) {
            if (useSpecificDrmOrder) {
                return sSpecificMultiDrmOrder;
            }
            return sMultiDrmOrder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMarlinSelected() {
        return MgtvDrmConstans.MARLIN_UUID.equals(this.selectedUUID);
    }

    private boolean isMarlinValid(UUID uuid) {
        IDrmManager iDrmManager;
        return MgtvDrmConstans.MARLIN_UUID.equals(uuid) && (iDrmManager = this.wasabiDrmManager) != null && iDrmManager.isInited();
    }

    private void releaseDRM() {
        ILightPlayDrmSession iLightPlayDrmSession = this.currentLightPlaySession;
        if (iLightPlayDrmSession != null) {
            iLightPlayDrmSession.close();
            this.currentLightPlaySession = null;
        }
        MediaDrm mediaDrm = this.drm;
        if (mediaDrm != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                byte[] bArr = this.drmSessionId;
                if (bArr != null && bArr.length > 0) {
                    mediaDrm.closeSession(bArr);
                }
                this.drm.release();
            }
            this.drm = null;
        }
    }

    public static void setMultiDrmOrder(int i) {
        sUseLightPlayDefaultValue = false;
        synchronized (sMultiDrmOrderLocker) {
            if (i == 1) {
                sMultiDrmOrder = MULTIDRM_ORDER_1;
            } else if (i != 9) {
                sMultiDrmOrder = MULTIDRM_ORDER_0;
            } else {
                sUseLightPlayDefaultValue = true;
                sMultiDrmOrder = MULTIDRM_ORDER_9;
            }
            UUID[] uuidArr = sMultiDrmOrder;
            if (uuidArr != null) {
                String str = "";
                for (UUID uuid : uuidArr) {
                    str = str + uuid + " , ";
                }
                DebugLog.i(TAG, "setMultiDrmOrder config order:" + i + " MultiDrm Order :" + str);
            }
        }
    }

    public static void setSUseLightPlayDefaultValue(boolean z) {
        sUseLightPlayDefaultValue = z;
    }

    public static void useSpecificDrmOrder(boolean z, UUID[] uuidArr) {
        synchronized (sMultiDrmOrderLocker) {
            useSpecificDrmOrder = z;
            sSpecificMultiDrmOrder = uuidArr;
        }
    }

    public void autoSelectDrmSolution() {
        int i;
        String str;
        String str2;
        DebugLog.i(TAG, "pssh auto select drm solution in. useLightPlay:" + this.useLightPlay);
        Map<UUID, MgtvDrmUtils.PSSH> map = this.psshMap;
        if (map == null || map.size() <= 0) {
            i = 208;
            str = "pssh empty";
        } else {
            UUID uuid = MgtvDrmConstans.MARLIN_UUID;
            if (map.containsKey(uuid)) {
                DebugLog.i(TAG, "pssh contains marlin uuid:" + uuid);
            }
            UUID uuid2 = MgtvDrmConstans.CHINADRM_UUID;
            if (map.containsKey(uuid2)) {
                DebugLog.i(TAG, "pssh contains chinadrm uuid:" + uuid2);
            }
            UUID uuid3 = MgtvDrmConstans.WIDEVINE_UUID;
            if (map.containsKey(uuid3)) {
                DebugLog.i(TAG, "pssh contains widevine uuid:" + uuid3);
            }
            UUID[] uuidArr = this.multiDrmOrder;
            if (uuidArr != null) {
                for (UUID uuid4 : uuidArr) {
                    DebugLog.i(TAG, "pssh check uuid:" + uuid4.toString());
                    if (map.containsKey(uuid4) && (isMarlinValid(uuid4) || this.useLightPlay || MgtvDrmUtils.isCryptoSchemeSupported(uuid4))) {
                        MgtvDrmParams.DrmInfo drmInfo = getDrmInfo(uuid4);
                        if (drmInfo == null || StringUtil.isEmpty(drmInfo.licenseUrl)) {
                            str2 = "autoSelectDrmSolution drminfo invalid. drmInfo:" + drmInfo + ". continue next";
                        } else if (!MgtvDrmConstans.WIDEVINE_UUID.equals(uuid4) || (MgtvDrmUtils.isWidevineSupport() && !isPlayerSWDecoder())) {
                            this.selectedUUID = uuid4;
                            this.selectedPssh = map.get(uuid4);
                            this.selectedDrmInfo = drmInfo;
                            this.selectedLicenseUrl = drmInfo.licenseUrl;
                            DebugLog.i(TAG, "pssh select uuid:" + uuid4);
                            DebugLog.i(TAG, "pssh select url:" + this.selectedLicenseUrl);
                            return;
                        } else {
                            str2 = "autoSelectDrmSolution widevine not support. continue next";
                        }
                        DebugLog.e(TAG, str2);
                    }
                }
            }
            i = IDrmSession.ERROR_SESSION_DRM_PSSHS_NOT_SUPPORT;
            str = "pssh not support";
        }
        doLicenseListenerFailed(i, str);
    }

    public void bindMediaPlayer(f fVar) {
        this.mPlayer = fVar;
    }

    public void bindWasabiDrmManager(IDrmManager iDrmManager) {
        this.wasabiDrmManager = iDrmManager;
    }

    public void close() {
        DebugLog.i(TAG, "close in");
        WasabiDrmSession wasabiDrmSession = this.currentWasabiSession;
        if (wasabiDrmSession != null) {
            wasabiDrmSession.close();
            this.currentWasabiSession = null;
        }
        synchronized (this.locker) {
            this.status = 9;
            releaseDRM();
            this.licenseListener = null;
        }
        DebugLog.i(TAG, "close out");
    }

    public void doLicense() {
        DebugLog.i(TAG, "doLicense in");
        synchronized (this.locker) {
            doLicenseInner(true);
        }
        DebugLog.i(TAG, "doLicense out");
    }

    @RequiresApi(api = 18)
    public void doProvision() {
        MediaDrm.ProvisionRequest provisionRequest;
        if (this.status == 1 || this.status == 9) {
            return;
        }
        MediaDrm mediaDrm = this.drm;
        if (mediaDrm == null || (provisionRequest = mediaDrm.getProvisionRequest()) == null) {
            doLicenseListenerFailed(IDrmSession.ERROR_SESSION_NO_PROVISION, "provision");
            return;
        }
        HashMap hashMap = new HashMap();
        String contentType = getContentType(this.selectedUUID);
        String str = this.selectedLicenseUrl;
        String str2 = str + (UrlUtil.existParams(str) ? "&" : JumpAction.STR_ACTION_SPLIT) + "signedRequest=" + UrlUtil.fromUtf8Bytes(provisionRequest.getData());
        DebugLog.i(TAG, "doProvision provisionUrl:" + str2);
        a.i(str2, hashMap, contentType, (byte[]) null, true, new a.d() { // from class: com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.4
            public void onFailed(String str3, int i) {
                DebugLog.e(CbcsCoreDrmSession.TAG, "doProvision err:" + i);
                CbcsCoreDrmSession cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                cbcsCoreDrmSession.doLicenseListenerFailed(i, "url:" + str3);
            }

            public void onSuccess(String str3, int i, byte[] bArr) {
                CbcsCoreDrmSession cbcsCoreDrmSession;
                int i2;
                StringBuilder sb;
                String str4;
                synchronized (CbcsCoreDrmSession.this.locker) {
                    if (ByteUtil.isEmpty(bArr)) {
                        DebugLog.e(CbcsCoreDrmSession.TAG, "error: response license empty");
                        cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                        i2 = 201;
                        sb = new StringBuilder();
                        sb.append("url:");
                        sb.append(str3);
                    } else {
                        cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                        MediaDrm mediaDrm2 = cbcsCoreDrmSession.drm;
                        if (mediaDrm2 != null) {
                            try {
                                mediaDrm2.provideProvisionResponse(bArr);
                                DebugLog.i("drmtest", "provideProvisionResponse 111 success");
                                CbcsCoreDrmSession.this.doLicenseInner(false);
                            } catch (Exception e) {
                                DebugLog.e("drmtest", "error: provideKeyResponse exception " + e.getMessage());
                                cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                                i2 = IDrmSession.ERROR_SESSION_PROVISION_PROVIDE_ERROR;
                                str4 = e.getMessage() + " url:" + str3;
                            }
                        } else {
                            i2 = IDrmSession.ERROR_SESSION_PROVISION_PROVIDE_NONE;
                            sb = new StringBuilder();
                            sb.append("url:");
                            sb.append(str3);
                        }
                    }
                    str4 = sb.toString();
                    cbcsCoreDrmSession.doLicenseListenerFailed(i2, str4);
                }
            }
        });
    }

    public void doProvisionLightPlay() {
        if (this.status == 1 || this.status == 9) {
            return;
        }
        byte[] provisionRequest = LightPlayDrmManager.getInstance().getProvisionRequest();
        if (provisionRequest == null) {
            doLicenseListenerFailed(IDrmSession.ERROR_SESSION_NO_PROVISION, "provision");
            return;
        }
        HashMap hashMap = new HashMap();
        String contentType = getContentType(this.selectedUUID);
        String str = this.selectedLicenseUrl;
        DebugLog.i(TAG, "doProvision provisionUrl:" + str);
        a.i(str, hashMap, contentType, provisionRequest, true, new a.d() { // from class: com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.5
            public void onFailed(String str2, int i) {
                DebugLog.e(CbcsCoreDrmSession.TAG, "doProvision err:" + i);
                CbcsCoreDrmSession cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                cbcsCoreDrmSession.doLicenseListenerFailed(i, "url:" + str2);
            }

            public void onSuccess(String str2, int i, byte[] bArr) {
                CbcsCoreDrmSession cbcsCoreDrmSession;
                int i2;
                String str3;
                synchronized (CbcsCoreDrmSession.this.locker) {
                    DebugLog.i("drmtest", "doProvision onSuccess response:" + new String(bArr));
                    if (ByteUtil.isEmpty(bArr)) {
                        DebugLog.e(CbcsCoreDrmSession.TAG, "error: response license empty");
                        cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                        i2 = 201;
                        str3 = "url:" + str2;
                    } else {
                        try {
                            int provideProvisionResponse = LightPlayDrmManager.getInstance().provideProvisionResponse(bArr);
                            if (provideProvisionResponse == 0) {
                                DebugLog.i(CbcsCoreDrmSession.TAG, "LightPlayDrmManager provideProvisionResponse success");
                                CbcsCoreDrmSession.this.doLicenseInner(false);
                            } else {
                                DebugLog.e(CbcsCoreDrmSession.TAG, "LightPlayDrmManager  provideProvisionResponse error :" + provideProvisionResponse);
                                CbcsCoreDrmSession.this.doLicenseListenerFailed(IDrmSession.ERROR_SESSION_PROVISION_ERROR, provideProvisionResponse + " url:" + str2);
                            }
                        } catch (Exception e) {
                            DebugLog.e(CbcsCoreDrmSession.TAG, "error: provideKeyResponse exception " + e.getMessage());
                            cbcsCoreDrmSession = CbcsCoreDrmSession.this;
                            i2 = IDrmSession.ERROR_SESSION_PROVISION_PROVIDE_ERROR;
                            str3 = e.getMessage() + " url:" + str2;
                        }
                    }
                    cbcsCoreDrmSession.doLicenseListenerFailed(i2, str3);
                }
            }
        });
    }

    public byte[] getDrmSessionId() {
        return this.drmSessionId;
    }

    public MgtvDrmParams.DrmInfo getSelectedDrmInfo() {
        return this.selectedDrmInfo;
    }

    public UUID getSelectedUUID() {
        return this.selectedUUID;
    }

    public void init() {
        if (ImgoLibLoader.getInstance().isMgtvDrmLibLoaded()) {
            return;
        }
        DebugLog.i(TAG, "mgtvdrm lib load failed. not use");
        this.useLightPlay = false;
    }

    public boolean isPlayerSWDecoder() {
        f fVar = this.mPlayer;
        if (fVar != null) {
            return !fVar.R1();
        }
        return false;
    }

    public void setOnDoLicenseListener(OnDoLicenseListener onDoLicenseListener) {
        synchronized (this.locker) {
            this.licenseListener = onDoLicenseListener;
        }
    }
}
