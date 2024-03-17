package com.hunantv.media.drm;

import android.app.Application;
import com.hunantv.media.drm.MgtvDrmParams;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IDrmManager {
    public static final int ERROR_DEFAULT = -1;
    public static final int ERROR_NULL = -10;
    public static final int ERROR_NULLPOINT = -11;
    public static final int RES_OK = 0;
    public static final int STATUS_ERROR = 3;
    public static final int STATUS_INITED = 2;
    public static final int STATUS_INITING = 1;
    public static final int STATUS_NONE = 0;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class InitConfig {
        public boolean enableRoot;
        public String initDirPath;

        public InitConfig(String str, boolean z) {
            this.initDirPath = str;
            this.enableRoot = z;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnInitListener {
        void onInitError(String str, String str2);

        void onInitSuccess();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class SessionConfig {
        public static final String DRM_LEVEL_DEFAULT = "0";
        public static final String DRM_LEVEL_MIX = "2";
        public static final String DRM_LEVEL_ONLY_COMMERCIAL = "3";
        public static final String DRM_LEVEL_ONLY_NON_COMMERCIAL = "1";
        public static final String STR_DRM_SOLUTION_LIGHTPLAY = "6";
        public static final String STR_DRM_SOLUTION_MARLIN = "0";
        public static final String STR_DRM_SOLUTION_MARLIN_CBCS = "5";
        public static final String STR_DRM_SOLUTION_WIDEVINE = "2";
        public static final String STR_DRM_SOLUTION_WISEPLAY = "4";
        public static final String STR_DRM_TYPE_AUDIO_MAES = "20";
        public static final String STR_DRM_TYPE_CBCS_HLS = "6";
        public static final String STR_DRM_TYPE_CENC_HLS = "4";
        public static final String STR_DRM_TYPE_MARLIN_BBTS = "0";
        public static final String STR_DRM_TYPE_SM4_HLS = "5";
        public String drmCid;
        public List<MgtvDrmParams.DrmInfo> drmInfoList;
        public String drmLevel;
        public String drmToken;
        public String drmType;
        public boolean tokenNeedDecode = true;

        public SessionConfig(String str, String str2) {
            this.drmToken = str;
            this.drmCid = str2;
        }

        public SessionConfig(String str, String str2, String str3, List<MgtvDrmParams.DrmInfo> list) {
            this.drmToken = str;
            this.drmCid = str2;
            this.drmType = str3;
            this.drmInfoList = list;
            if (!"0".equalsIgnoreCase(str3) || list == null || list.size() <= 0) {
                return;
            }
            for (MgtvDrmParams.DrmInfo drmInfo : list) {
                if ("0".equalsIgnoreCase(drmInfo.drmSolution)) {
                    this.drmToken = drmInfo.drmToken;
                    this.drmCid = drmInfo.drmCid;
                }
            }
        }

        public String toString() {
            return "SessionConfig{drmToken='" + this.drmToken + "', drmCid='" + this.drmCid + "', drmType='" + this.drmType + "', drmLicenseList=" + this.drmInfoList + '}';
        }
    }

    IDrmSession genDrmSession(SessionConfig sessionConfig);

    int getCurrentStatus();

    String getErrorCode();

    String getVersion();

    int init(Application application, InitConfig initConfig);

    boolean isInited();

    boolean isIniting();

    int release();

    void setOnInitListener(OnInitListener onInitListener);
}
