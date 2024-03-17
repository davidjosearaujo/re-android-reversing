package com.hunantv.media.drm;

import c.a.a.a.f;
import com.hunantv.media.drm.IDrmManager;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IDrmSession {
    public static final int DRM_STAGE_LICENSE = 2;
    public static final int DRM_STAGE_NONE = 0;
    public static final int DRM_STAGE_PROVISION = 1;
    public static final int ERROR_SESSION_CONFIG_NULL = 100;
    public static final int ERROR_SESSION_DRMMANAGER_NOT_INITED = 103;
    public static final int ERROR_SESSION_DRM_INFO_EMPTY = 217;
    public static final int ERROR_SESSION_DRM_INFO_INVALID = 218;
    public static final int ERROR_SESSION_DRM_LICENSE_URL_EMPTY = 207;
    public static final int ERROR_SESSION_DRM_NULL = 204;
    public static final int ERROR_SESSION_DRM_PSSHS_EMPTY = 208;
    public static final int ERROR_SESSION_DRM_PSSHS_NOT_SUPPORT = 209;
    public static final int ERROR_SESSION_KEY_REQUEST_NULL = 205;
    public static final int ERROR_SESSION_NO_PROVISION = 210;
    public static final int ERROR_SESSION_PROVISION = 200;
    public static final int ERROR_SESSION_PROVISION_ERROR = 213;
    public static final int ERROR_SESSION_PROVISION_ERROR_KEYID_INVALID = 216;
    public static final int ERROR_SESSION_PROVISION_ERROR_WASABI_ERROR = 215;
    public static final int ERROR_SESSION_PROVISION_LICENSE_RESPONSE_EMPTY = 201;
    public static final int ERROR_SESSION_PROVISION_NO_SELECT_DRM = 203;
    public static final int ERROR_SESSION_PROVISION_PROVIDE_ERROR = 212;
    public static final int ERROR_SESSION_PROVISION_PROVIDE_LICENSE_EXCEPTION = 202;
    public static final int ERROR_SESSION_PROVISION_PROVIDE_NONE = 211;
    public static final int ERROR_SESSION_SELECT_DRM_NOT_SUPPORT = 206;
    public static final int ERROR_SESSION_TOKEN_EMPTY = 101;
    public static final int ERROR_SESSION_UNKNOWN_EXCEPTION = 102;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_PROVISIONING = 1;
    public static final int STATUS_PROVISION_ERROR = 3;
    public static final int STATUS_PROVISION_SUCCESS = 2;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnInfoListener {
        void onInfo(IDrmSession iDrmSession, int i, int i2, String str);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnProvisionErrorListener {
        void onError(IDrmSession iDrmSession, int i, String str);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnProvisionSuccessListener {
        void onSuccess(IDrmSession iDrmSession);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnReportListener {
        void onExReport(String str, String str2, String str3, int i);

        void onReport(String str, String str2, String str3);
    }

    void addOnInfoListener(OnInfoListener onInfoListener);

    void addOnProvisionErrorListener(OnProvisionErrorListener onProvisionErrorListener);

    void addOnProvisionSuccessListener(OnProvisionSuccessListener onProvisionSuccessListener);

    void bind(f fVar);

    int close();

    IDrmProxy createProxy();

    int getCurrentStatus();

    int getDrmType();

    String getDrmdi();

    String getDrmt();

    String getErrorCode();

    int getErrorWhat();

    IDrmManager.SessionConfig getSessionConfig();

    boolean isInnerSession();

    boolean isProvisionDone();

    boolean provision();

    void provisionAsync();

    void removeOnInfoListener(OnInfoListener onInfoListener);

    void removeOnProvisionErrorListener(OnProvisionErrorListener onProvisionErrorListener);

    void removeOnProvisionSuccessListener(OnProvisionSuccessListener onProvisionSuccessListener);

    void setDrmLicensePrepared();

    void setIsInnerSession(boolean z);

    void setOnReportListener(OnReportListener onReportListener);
}
