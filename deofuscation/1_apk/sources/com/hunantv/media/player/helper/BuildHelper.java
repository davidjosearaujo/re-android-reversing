package com.hunantv.media.player.helper;

import android.media.CamcorderProfile;
import android.os.Build;
import android.text.TextUtils;
import c.a.a.b.d.e;
import com.hunantv.media.player.pragma.DebugLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BuildHelper {
    public static final String ABI_ARM = "armeabi";
    public static final String ABI_ARM64_V8A = "arm64-v8a";
    public static final String ABI_ARMv7a = "armeabi-v7a";
    public static final String ABI_X86 = "x86";
    public static int ANDROID_M = 23;
    public static int ANDROID_N = 24;
    public static int ANDROID_N_MR1 = 25;
    public static int ANDROID_O = 26;
    public static int ANDROID_P = 28;
    public static int ANDROID_Q = 29;
    public static int ANDROID_R = 30;
    public static int ANDROID_S = 31;
    public static int ANDROID_T = 33;
    public static int ANDROID_UNKNOWN = 27;
    public static int FROYO = 8;
    public static int GINGERBREAD = 9;
    public static int GINGERBREAD_MR1 = 10;
    public static int HONEYCOMB = 11;
    public static int HONEYCOMB_MR1 = 12;
    public static int HONEYCOMB_MR2 = 13;
    public static int ICE_CREAM_SANDWICH = 14;
    public static int ICE_CREAM_SANDWICH_MR1 = 15;
    public static int JELLY_BEAN = 16;
    public static int JELLY_BEAN_MR1 = 17;
    public static int JELLY_BEAN_MR2 = 18;
    public static int KITKAT = 19;
    public static int KITKAT_MR1 = 20;
    public static int LOLLIPOP = 21;
    public static int LOLLIPOP_MR1 = 22;
    private static String[] mBlackListModes = {"virtual machine", "CHM-TL"};

    private static boolean findX86(String str) {
        try {
            String parseCpuInfo = parseCpuInfo(str, "model name");
            if (parseCpuInfo == null || !parseCpuInfo.contains("intel")) {
                String parseCpuInfo2 = parseCpuInfo(str, "vendor_id");
                if (parseCpuInfo2 != null) {
                    return parseCpuInfo2.contains("intel");
                }
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x003d: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:17:0x003c */
    public static int getCpuFrequence() {
        BufferedReader bufferedReader;
        IOException e;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream()));
            } catch (IOException e2) {
                bufferedReader = null;
                e = e2;
            } catch (Throwable th) {
                th = th;
                e.a(closeable2);
                throw th;
            }
            try {
                int parseInt = Integer.parseInt(bufferedReader.readLine());
                e.a(bufferedReader);
                return parseInt;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                e.a(bufferedReader);
                return 0;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            e.a(closeable2);
            throw th;
        }
    }

    public static int getDecodeSupportMaxHeight() {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        if (camcorderProfile != null) {
            return camcorderProfile.videoFrameHeight;
        }
        String str = Build.MODEL;
        if (str.startsWith("SM-N900")) {
            return 1080;
        }
        return str.equals("HTC Desire X") ? 480 : 0;
    }

    public static int getDecodeSupportMaxWidth() {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        if (camcorderProfile != null) {
            return camcorderProfile.videoFrameWidth;
        }
        String str = Build.MODEL;
        if (str.startsWith("SM-N900")) {
            return 1920;
        }
        return str.equals("HTC Desire X") ? 800 : 0;
    }

    public static final String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static final String getModel() {
        return Build.MODEL;
    }

    public static boolean getNeedSpecialSurface() {
        int i;
        String str = Build.MODEL;
        return str.startsWith("SM-N900") || str.startsWith("GT-N710") || (i = Build.VERSION.SDK_INT) == 14 || i == 15;
    }

    public static int getNumCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static final String getParsedCpuAbiInfo() {
        StringBuilder sb = new StringBuilder();
        String _cpu_abi = get_CPU_ABI();
        if (!TextUtils.isEmpty(_cpu_abi)) {
            sb.append("CPU ABI : ");
            sb.append(_cpu_abi);
            sb.append("\n");
        }
        String _cpu_abi2 = get_CPU_ABI2();
        if (!TextUtils.isEmpty(_cpu_abi)) {
            sb.append("CPU ABI2 : ");
            sb.append(_cpu_abi2);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static final int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static final String get_CPU_ABI() {
        return Build.CPU_ABI;
    }

    public static final String get_CPU_ABI2() {
        try {
            Field declaredField = Build.class.getDeclaredField("CPU_ABI2");
            if (declaredField == null) {
                return null;
            }
            Object obj = declaredField.get(null);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final boolean isApi11_HoneyComb() {
        int sDKVersion = getSDKVersion();
        return sDKVersion >= HONEYCOMB && sDKVersion <= HONEYCOMB_MR2;
    }

    public static final boolean isApi11_HoneyCombOrLater() {
        return getSDKVersion() >= HONEYCOMB;
    }

    public static final boolean isApi14_IceCreamSandwich() {
        int sDKVersion = getSDKVersion();
        return sDKVersion == ICE_CREAM_SANDWICH && sDKVersion <= ICE_CREAM_SANDWICH_MR1;
    }

    public static final boolean isApi14_IceCreamSandwichOrLater() {
        return getSDKVersion() >= ICE_CREAM_SANDWICH;
    }

    public static final boolean isApi16_JellyBean() {
        return getSDKVersion() == JELLY_BEAN;
    }

    public static final boolean isApi16_JellyBeanOrLater() {
        return getSDKVersion() >= JELLY_BEAN;
    }

    public static final boolean isApi17_JellyBeanMR1() {
        return getSDKVersion() == JELLY_BEAN_MR1;
    }

    public static final boolean isApi17_JellyBeanMR1OrLater() {
        return getSDKVersion() >= JELLY_BEAN_MR1;
    }

    public static final boolean isApi18_JellyBeanMR2() {
        return getSDKVersion() == JELLY_BEAN_MR2;
    }

    public static final boolean isApi18_JellyBeanMR2OrLater() {
        return getSDKVersion() >= JELLY_BEAN_MR2;
    }

    public static final boolean isApi19_KitKat() {
        return getSDKVersion() == KITKAT;
    }

    public static final boolean isApi19_KitKatOrLater() {
        return getSDKVersion() >= KITKAT;
    }

    public static final boolean isApi20_KitKatMR1() {
        return getSDKVersion() == KITKAT_MR1;
    }

    public static final boolean isApi20_KitKatMR1OrLater() {
        return getSDKVersion() >= KITKAT_MR1;
    }

    public static final boolean isApi21_LOLLIPOPO() {
        return getSDKVersion() == LOLLIPOP;
    }

    public static final boolean isApi21_LollipopOrLater() {
        return getSDKVersion() >= LOLLIPOP;
    }

    public static final boolean isApi22_LollipopMR1() {
        return getSDKVersion() == LOLLIPOP_MR1;
    }

    public static final boolean isApi22_LollipopMR1OrLater() {
        return getSDKVersion() >= LOLLIPOP_MR1;
    }

    public static final boolean isApi23_AndroidM() {
        return getSDKVersion() == ANDROID_M;
    }

    public static final boolean isApi23_AndroidMOrLater() {
        return getSDKVersion() >= ANDROID_M;
    }

    public static final boolean isApi24_AndroidN() {
        return getSDKVersion() == ANDROID_N;
    }

    public static final boolean isApi24_AndroidNOrLater() {
        return getSDKVersion() >= ANDROID_N;
    }

    public static final boolean isApi25_AndroidNMR1() {
        return getSDKVersion() == ANDROID_N_MR1;
    }

    public static final boolean isApi25_AndroidNMR1OrLater() {
        return getSDKVersion() >= ANDROID_N_MR1;
    }

    public static final boolean isApi26_AndroidO() {
        return getSDKVersion() == ANDROID_O;
    }

    public static final boolean isApi26_AndroidOOrLater() {
        return getSDKVersion() >= ANDROID_O;
    }

    public static final boolean isApi28_PieOrLater() {
        return getSDKVersion() >= ANDROID_P;
    }

    public static final boolean isApi29_LollipopOrLater() {
        return getSDKVersion() >= ANDROID_Q;
    }

    public static final boolean isApi30_AndroidROrLater() {
        return getSDKVersion() >= ANDROID_R;
    }

    public static final boolean isApi31_AndroidSOrLater() {
        return getSDKVersion() >= ANDROID_S;
    }

    public static final boolean isApi9_GingerBread() {
        int sDKVersion = getSDKVersion();
        return sDKVersion >= FROYO && sDKVersion <= GINGERBREAD_MR1;
    }

    public static final boolean isApi9_GingerBreadOrLater() {
        return getSDKVersion() >= GINGERBREAD;
    }

    public static final boolean isApiLess18_JellyBeanMR2() {
        return getSDKVersion() < JELLY_BEAN_MR2;
    }

    public static final boolean isIceCreamSandwich() {
        int sDKVersion = getSDKVersion();
        return sDKVersion >= ICE_CREAM_SANDWICH && sDKVersion <= ICE_CREAM_SANDWICH_MR1;
    }

    public static boolean isImgdsBlackList() {
        String str = Build.MODEL;
        if (str != null) {
            for (String str2 : mBlackListModes) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isX86FromCpuinfo() {
        BufferedReader bufferedReader;
        Exception e;
        boolean z = false;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")), 1000);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (findX86(readLine.toLowerCase())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        e.a(bufferedReader);
                        return z;
                    }
                }
            } catch (Exception e3) {
                bufferedReader = null;
                e = e3;
            } catch (Throwable th) {
                th = th;
                e.a(bufferedReader2);
                throw th;
            }
            e.a(bufferedReader);
            return z;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            e.a(bufferedReader2);
            throw th;
        }
    }

    private static String parseCpuInfo(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile(str2 + "\\s+\\:\\s*(.*)").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean supportABI(String str) {
        String[] strArr;
        if (Build.VERSION.SDK_INT < 21 || (strArr = Build.SUPPORTED_ABIS) == null || strArr.length <= 0) {
            String _cpu_abi = get_CPU_ABI();
            if (TextUtils.isEmpty(_cpu_abi) || !_cpu_abi.equalsIgnoreCase(str)) {
                String _cpu_abi2 = get_CPU_ABI2();
                return !TextUtils.isEmpty(_cpu_abi2) && _cpu_abi2.equalsIgnoreCase(str);
            }
            return true;
        }
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean supportARM() {
        return supportABI(ABI_ARM);
    }

    public static boolean supportARM64v8a() {
        return supportABI(ABI_ARM64_V8A);
    }

    public static boolean supportARMv7a() {
        return supportABI(ABI_ARMv7a);
    }

    public static boolean supportX86() {
        String str;
        boolean supportABI = supportABI(ABI_X86);
        if (!supportABI && isApi16_JellyBeanOrLater()) {
            supportABI = MediaCodecHelp.isIntelMediaCodec();
            if (supportABI) {
                str = "isIntelMediaCodec";
            } else if (isX86FromCpuinfo()) {
                supportABI = true;
                str = "isX86FromCpuinfo";
            }
            DebugLog.i("ImgoPlayerLibJava", str);
        }
        return supportABI;
    }

    public static String[] supportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        String str = Build.CPU_ABI2;
        return !TextUtils.isEmpty(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }
}
