package com.hunantv.media.player.pragma;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import c.a.a.a.f;
import com.alibaba.android.arouter.utils.Consts;
import com.hunantv.imgo.entity.JumpAction;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.report.ReportParams;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PlayerConfig {
    public static String Crash_Path = null;
    public static final String IMGO4_LIB_VERSION = "5.5.5";
    public static final int IMGO_LOG_LEVEL_DEBUG = 3;
    public static final int IMGO_LOG_LEVEL_DEFAULT = 1;
    public static final int IMGO_LOG_LEVEL_ERROR = 6;
    public static final int IMGO_LOG_LEVEL_FATAL = 7;
    public static final int IMGO_LOG_LEVEL_INFO = 4;
    public static final int IMGO_LOG_LEVEL_SILENT = 8;
    public static final int IMGO_LOG_LEVEL_UNKNOWN = 0;
    public static final int IMGO_LOG_LEVEL_VERBOSE = 2;
    public static final int IMGO_LOG_LEVEL_WARN = 5;
    public static final int IMGO_LOG_REPORT_BRIEF = 1;
    public static final int IMGO_LOG_REPORT_DETAIL = 2;
    public static final int IMGO_LOG_REPORT_NONE = 0;
    public static final String IMGO_REPORT_VER = "2.0.2";
    public static final String IMGO_VERSION_TIME = "20231010";
    public static final String MGTVPLAER4_VERSION = "25.5";
    private static String PackageName = null;
    private static String VersionName = null;
    public static Boolean mMTK_Chip_use_systemplayer = Boolean.FALSE;
    private static String sGifUserAgent = null;
    public static int use_log_level = 3;
    public static int use_report_level;
    private String mProxyType = "0";

    public static synchronized String getGifUserAgent(Context context) {
        String str;
        synchronized (PlayerConfig.class) {
            if (StringUtil.isEmpty(sGifUserAgent)) {
                String packageNameOnce = getPackageNameOnce(context);
                String versionNameOnce = getVersionNameOnce(context);
                sGifUserAgent = "ImgoMediaPlayerLib/" + packageNameOnce + ".V" + versionNameOnce + " (Linux;Android " + Build.VERSION.RELEASE + "(" + Build.VERSION.SDK_INT + ")) gif/" + getLibFullVersion();
            }
            str = sGifUserAgent;
        }
        return str;
    }

    public static String getLibFullVersion() {
        String str;
        int B = f.B();
        if (B > 0) {
            str = Consts.DOT + B;
        } else {
            str = "";
        }
        return (IMGO4_LIB_VERSION + "_2") + str + Consts.DOT + IMGO_VERSION_TIME;
    }

    public static String getPackageNameOnce(Context context) {
        if (context == null) {
            return "";
        }
        if (PackageName == null) {
            PackageName = context.getPackageName();
        }
        return PackageName;
    }

    public static String getVersionNameOnce(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        if (VersionName == null) {
            if (ReportParams.GlobalSet.getsAppVersionName() == null || ReportParams.GlobalSet.getsAppVersionName().trim().equals("")) {
                PackageInfo packageInfo = null;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(getPackageNameOnce(context), 0);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if (packageInfo != null) {
                    str = packageInfo.versionName;
                }
            } else {
                str = ReportParams.GlobalSet.getsAppVersionName();
            }
            VersionName = str;
        }
        return VersionName;
    }

    public static void setPlayerCodecFailedMTKSysPlayer(Boolean bool) {
        mMTK_Chip_use_systemplayer = bool;
    }

    public static void setPlayerCrachRecordPath(String str) {
        Crash_Path = str;
    }

    public static void setPlayerDebug(boolean z) {
        use_report_level = z ? 1 : 0;
        use_log_level = 3;
    }

    public static void setPlayerDebugInfo(int i) {
        use_report_level = i;
    }

    public static void setPlayerDebugLogLevel(int i) {
        use_log_level = i;
    }

    public String getUserAgent(Context context, int i) {
        String str = i == 1 ? "ffmpeg" : i == 2 ? "mediacodecNative" : (i != 3 && i == 0) ? "system" : JumpAction.STR_ACTION_SPLIT;
        String packageNameOnce = getPackageNameOnce(context);
        String versionNameOnce = getVersionNameOnce(context);
        return "ImgoMediaPlayerLib/" + packageNameOnce + ".V" + versionNameOnce + " (Linux;Android " + Build.VERSION.RELEASE + "(" + Build.VERSION.SDK_INT + ")) " + str + "/" + this.mProxyType + "/" + getLibFullVersion() + ".oversea";
    }

    public void setProxyType(String str) {
        this.mProxyType = str;
    }
}
