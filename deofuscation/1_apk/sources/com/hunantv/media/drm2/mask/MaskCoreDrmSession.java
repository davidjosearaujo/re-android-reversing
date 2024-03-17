package com.hunantv.media.drm2.mask;

import c.a.a.a.f;
import c.a.a.b.c.a;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.drm.utils.Hex;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.utils.ByteUtil;
import com.mgtv.drm.ILightPlayDrmSession;
import com.mgtv.drm.LightPlayDrmManager;
import java.util.HashMap;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MaskCoreDrmSession {
    public static final int STATUS_CLOSE = 9;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_SUCCESS = 2;
    private static final String TAG = "MaskCoreDrmSession";
    public ILightPlayDrmSession currentLightPlaySession;
    public List<MgtvDrmParams.DrmInfo> drmInfoList;
    private byte[] keyId;
    private OnDoLicenseListener licenseListener;
    public f mPlayer;
    public MgtvDrmParams.DrmInfo selectedDrmInfo;
    public String selectedLicenseUrl;
    public Object locker = new Object();
    public volatile int status = 0;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnDoLicenseListener {
        void onFailed(int i, int i2, String str);

        void onSuccess(int i);
    }

    public MaskCoreDrmSession(byte[] bArr, List<MgtvDrmParams.DrmInfo> list) {
        this.keyId = bArr;
        this.drmInfoList = list;
        init();
    }

    public MaskCoreDrmSession(byte[] bArr, List<MgtvDrmParams.DrmInfo> list, OnDoLicenseListener onDoLicenseListener) {
        this.keyId = bArr;
        this.drmInfoList = list;
        this.licenseListener = onDoLicenseListener;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLicenseInner(boolean z) {
        if (this.status == 1 || this.status == 9) {
            return;
        }
        if (!"6".equals(this.selectedDrmInfo.drmSolution)) {
            doLicenseListenerFailed(IDrmSession.ERROR_SESSION_SELECT_DRM_NOT_SUPPORT, "", 0);
            return;
        }
        DebugLog.i(TAG, "lightplay selected");
        if (LightPlayDrmManager.getInstance().isProvisioned()) {
            doLicenseLightPlay(false);
        } else {
            doProvisionLightPlay();
        }
    }

    private void doLicenseLightPlay(boolean z) {
        try {
            HashMap hashMap = new HashMap();
            byte[] bArr = this.keyId;
            if (bArr != null && bArr.length > 0) {
                String str = new String(Hex.encodeHex(this.keyId));
                hashMap.put("keyid", str);
                ILightPlayDrmSession openSession = LightPlayDrmManager.getInstance().openSession();
                this.currentLightPlaySession = openSession;
                byte[] licenseRequest = openSession.getLicenseRequest();
                String contentType = getContentType();
                DebugLog.i(TAG, "doLicenseLightPlay selectedUrl:" + this.selectedLicenseUrl + " ,keyid=" + str);
                if (StringUtil.isEmpty(this.selectedLicenseUrl)) {
                    doLicenseListenerFailed(MgtvMediaPlayer.MGTVMEDIA_ERROR_EXTRA_DRM_LICENSE_URL_INVALID, "", 0);
                    return;
                } else {
                    a.i(this.selectedLicenseUrl, hashMap, contentType, licenseRequest, true, new a.d() { // from class: com.hunantv.media.drm2.mask.MaskCoreDrmSession.1
                        public void onFailed(String str2, int i) {
                            DebugLog.e(MaskCoreDrmSession.TAG, "request license onFailed err:" + i);
                            MaskCoreDrmSession maskCoreDrmSession = MaskCoreDrmSession.this;
                            maskCoreDrmSession.doLicenseListenerFailed(i, "url:" + str2, 2);
                        }

                        public void onSuccess(String str2, int i, byte[] bArr2) {
                            synchronized (MaskCoreDrmSession.this.locker) {
                                DebugLog.i(MaskCoreDrmSession.TAG, "request license onSuccess code:" + i);
                                if (MaskCoreDrmSession.this.currentLightPlaySession == null) {
                                    DebugLog.i(MaskCoreDrmSession.TAG, "session already close. only return");
                                    return;
                                }
                                if (ByteUtil.isEmpty(bArr2)) {
                                    DebugLog.e(MaskCoreDrmSession.TAG, "error: response license empty");
                                    MaskCoreDrmSession maskCoreDrmSession = MaskCoreDrmSession.this;
                                    maskCoreDrmSession.doLicenseListenerFailed(201, "url:" + str2, 2);
                                } else {
                                    int provideLicenseResponse = MaskCoreDrmSession.this.currentLightPlaySession.provideLicenseResponse(bArr2);
                                    if (provideLicenseResponse == 0) {
                                        DebugLog.i(MaskCoreDrmSession.TAG, "provideLicenseResponse success ");
                                        if (MaskCoreDrmSession.this.licenseListener != null) {
                                            MaskCoreDrmSession.this.licenseListener.onSuccess(1);
                                        }
                                    } else {
                                        DebugLog.e(MaskCoreDrmSession.TAG, "provideLicenseResponse error ret:" + provideLicenseResponse);
                                        MaskCoreDrmSession maskCoreDrmSession2 = MaskCoreDrmSession.this;
                                        maskCoreDrmSession2.doLicenseListenerFailed(provideLicenseResponse, "url:" + str2, 2);
                                    }
                                }
                            }
                        }
                    });
                    return;
                }
            }
            DebugLog.e(TAG, "doLicenseLightPlay keyid invalid:" + this.keyId);
            doLicenseListenerFailed(216, "", 2);
        } catch (Exception e) {
            e.printStackTrace();
            doLicenseListenerFailed(200, e.getMessage(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doLicenseListenerFailed(int i, String str, int i2) {
        if (this.status != 1) {
            this.status = 1;
            int i3 = MgtvMediaPlayer.MGTVMEDIA_ERROR_400802;
            if (i2 == 1) {
                i3 = MgtvMediaPlayer.MGTVMEDIA_ERROR_400803;
            } else if (i2 == 2) {
                i3 = MgtvMediaPlayer.MGTVMEDIA_ERROR_400804;
            }
            OnDoLicenseListener onDoLicenseListener = this.licenseListener;
            if (onDoLicenseListener != null) {
                onDoLicenseListener.onFailed(i3, i, str);
            }
        }
    }

    private static String getContentType() {
        return RequestParams.APPLICATION_JSON;
    }

    private MgtvDrmParams.DrmInfo getDrmInfo(String str) {
        for (MgtvDrmParams.DrmInfo drmInfo : this.drmInfoList) {
            DebugLog.i(TAG, "getDrmInfo:" + drmInfo);
            if (str.equals(drmInfo.drmSolution)) {
                return drmInfo;
            }
        }
        return null;
    }

    private void releaseDRM() {
        ILightPlayDrmSession iLightPlayDrmSession = this.currentLightPlaySession;
        if (iLightPlayDrmSession != null) {
            iLightPlayDrmSession.close();
            this.currentLightPlaySession = null;
        }
    }

    public void autoSelectDrmSolution() {
        int i;
        String str;
        DebugLog.i(TAG, "pssh auto select drm solution in. ");
        List<MgtvDrmParams.DrmInfo> list = this.drmInfoList;
        if (list == null || list.size() <= 0) {
            i = 217;
            str = "drm info empty";
        } else {
            MgtvDrmParams.DrmInfo drmInfo = getDrmInfo("6");
            if (drmInfo != null) {
                this.selectedDrmInfo = drmInfo;
                this.selectedLicenseUrl = drmInfo.licenseUrl;
                DebugLog.i(TAG, "autoSelectDrmSolution selectedLicenseUrl=" + this.selectedLicenseUrl);
                return;
            }
            i = 218;
            str = "drm info invalid";
        }
        doLicenseListenerFailed(i, str, 0);
    }

    public void bindMediaPlayer(f fVar) {
        this.mPlayer = fVar;
    }

    public void close() {
        DebugLog.i(TAG, "close in");
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

    public void doProvisionLightPlay() {
        if (this.status == 1 || this.status == 9) {
            return;
        }
        byte[] provisionRequest = LightPlayDrmManager.getInstance().getProvisionRequest();
        if (provisionRequest == null) {
            doLicenseListenerFailed(IDrmSession.ERROR_SESSION_NO_PROVISION, "provision", 1);
            return;
        }
        HashMap hashMap = new HashMap();
        String contentType = getContentType();
        String str = this.selectedLicenseUrl;
        DebugLog.i(TAG, "doProvision provisionUrl:" + str);
        if (StringUtil.isEmpty(this.selectedLicenseUrl)) {
            doLicenseListenerFailed(MgtvMediaPlayer.MGTVMEDIA_ERROR_EXTRA_DRM_LICENSE_URL_INVALID, "", 0);
        } else {
            a.i(str, hashMap, contentType, provisionRequest, true, new a.d() { // from class: com.hunantv.media.drm2.mask.MaskCoreDrmSession.2
                public void onFailed(String str2, int i) {
                    DebugLog.e(MaskCoreDrmSession.TAG, "doProvision err:" + i);
                    MaskCoreDrmSession maskCoreDrmSession = MaskCoreDrmSession.this;
                    maskCoreDrmSession.doLicenseListenerFailed(i, "url:" + str2, 1);
                }

                public void onSuccess(String str2, int i, byte[] bArr) {
                    MaskCoreDrmSession maskCoreDrmSession;
                    int i2;
                    String str3;
                    synchronized (MaskCoreDrmSession.this.locker) {
                        DebugLog.i(MaskCoreDrmSession.TAG, "doProvision response success");
                        if (ByteUtil.isEmpty(bArr)) {
                            DebugLog.e(MaskCoreDrmSession.TAG, "error: response license empty");
                            maskCoreDrmSession = MaskCoreDrmSession.this;
                            i2 = 201;
                            str3 = "url:" + str2;
                        } else {
                            try {
                                int provideProvisionResponse = LightPlayDrmManager.getInstance().provideProvisionResponse(bArr);
                                if (provideProvisionResponse == 0) {
                                    DebugLog.i(MaskCoreDrmSession.TAG, "LightPlayDrmManager provideProvisionResponse success");
                                    MaskCoreDrmSession.this.doLicenseInner(false);
                                } else {
                                    String str4 = bArr != null ? bArr.length > 100 ? new String(bArr, 0, 100) : new String(bArr) : "";
                                    DebugLog.e(MaskCoreDrmSession.TAG, "LightPlayDrmManager  provideProvisionResponse error :" + provideProvisionResponse);
                                    MaskCoreDrmSession.this.doLicenseListenerFailed(provideProvisionResponse, str4, 1);
                                }
                            } catch (Exception e) {
                                DebugLog.e(MaskCoreDrmSession.TAG, "error: provideKeyResponse exception " + e.getMessage());
                                maskCoreDrmSession = MaskCoreDrmSession.this;
                                i2 = IDrmSession.ERROR_SESSION_PROVISION_PROVIDE_ERROR;
                                str3 = e.getMessage() + " url:" + str2;
                            }
                        }
                        maskCoreDrmSession.doLicenseListenerFailed(i2, str3, 1);
                    }
                }
            });
        }
    }

    public MgtvDrmParams.DrmInfo getSelectedDrmInfo() {
        return this.selectedDrmInfo;
    }

    public void init() {
        if (ImgoLibLoader.getInstance().isMgtvDrmLibLoaded()) {
            return;
        }
        DebugLog.i(TAG, "mgtvdrm lib load failed. not use");
    }

    public void setOnDoLicenseListener(OnDoLicenseListener onDoLicenseListener) {
        synchronized (this.locker) {
            this.licenseListener = onDoLicenseListener;
        }
    }
}
