package cn.jiguang.q;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.hunantv.media.player.MgtvMediaPlayer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static String b = "";
    private static String c = "";
    private static final FileFilter d = new FileFilter() { // from class: cn.jiguang.q.b.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i = 3; i < name.length(); i++) {
                    if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
    public static JSONArray a = new JSONArray();

    private static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    for (int i2 = i; i2 < read; i2++) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return a(bArr, i2);
                        }
                    }
                    continue;
                }
                i++;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static int a(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (bArr[i] >= 48 && bArr[i] <= 57) {
                int i2 = i + 1;
                while (i2 < bArr.length && bArr[i2] >= 48 && bArr[i2] <= 57) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    private static long a(String str) {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 4096);
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
            } while (!readLine.contains(str));
            bufferedReader.close();
            return Integer.valueOf(readLine.split("\\s+")[1]).intValue();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String a() {
        if (TextUtils.isEmpty(b)) {
            e();
            return b;
        }
        return b;
    }

    public static String a(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "0*0";
        }
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        return i + "*" + i2;
    }

    public static String a(Context context, int i) {
        if (i != 53) {
            return null;
        }
        try {
            String g = g(context);
            if (TextUtils.isEmpty(g)) {
                g = f(context);
            }
            JSONObject jSONObject = new JSONObject(g);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rom_type", (int) cn.jiguang.n.d.n(context));
            jSONObject2.put("regid", cn.jiguang.n.d.o(context));
            jSONObject.put("rom_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cmd", 53);
            jSONObject3.put("content", jSONObject);
            return jSONObject3.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void a(Context context, String str) {
        cn.jiguang.g.b.a(context, new cn.jiguang.g.a("cn.jpush.preferences.v2", "n_udp_report_device_info", "").a((cn.jiguang.g.a) Base64.encodeToString(str.getBytes(), 2)));
        cn.jiguang.ak.a.a("JDeviceHelper", "save device info:" + str);
    }

    public static double b(Context context) {
        double pow;
        int i;
        Point point = new Point();
        boolean z = context instanceof Activity;
        if (z) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                defaultDisplay.getRealSize(point);
            } else if (i2 >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            pow = Math.pow(point.x / displayMetrics.xdpi, 2.0d);
            i = point.y;
        } else {
            pow = Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d);
            i = displayMetrics.heightPixels;
        }
        return Math.sqrt(pow + Math.pow(i / displayMetrics.ydpi, 2.0d));
    }

    public static String b() {
        if (TextUtils.isEmpty(c)) {
            e();
            return c;
        }
        return c;
    }

    public static int c() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(d).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static long c(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                activityManager.getProcessMemoryInfo(new int[]{0});
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem / 1024;
            }
        } catch (Throwable unused) {
        }
        return a("MemTotal");
    }

    public static int d() {
        int i = -1;
        for (int i2 = 0; i2 < c(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (bArr[i3] >= 48 && bArr[i3] <= 57 && i3 < 128) {
                            i3++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                        if (valueOf.intValue() > i) {
                            i = valueOf.intValue();
                        }
                    } catch (Throwable unused) {
                    }
                    fileInputStream.close();
                }
            } catch (Throwable unused2) {
                return -1;
            }
        }
        if (i == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            int a2 = a("cpu MHz", fileInputStream2) * 1000;
            if (a2 > i) {
                i = a2;
            }
            fileInputStream2.close();
        }
        return i;
    }

    public static long d(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static JSONArray e(Context context) {
        return new JSONArray();
    }

    private static void e() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (new File("/proc/cpuinfo").exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                String str = null;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.contains("Processor")) {
                        int indexOf = readLine.indexOf(CertificateUtil.DELIMITER);
                        if (indexOf >= 0 && indexOf < readLine.length() - 1) {
                            str = readLine.substring(indexOf + 1).trim();
                        }
                        if (str != null && !stringBuffer.toString().contains(str)) {
                            stringBuffer.append(str);
                        }
                    }
                    if (readLine.contains("Hardware")) {
                        try {
                            String trim = readLine.substring(readLine.indexOf(CertificateUtil.DELIMITER) + 1).trim();
                            if (!TextUtils.isEmpty(trim)) {
                                c = trim;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Throwable unused2) {
        }
        b = stringBuffer.toString();
    }

    public static String f(Context context) {
        try {
            cn.jiguang.bc.a a2 = cn.jiguang.bc.a.a(context);
            JSONObject jSONObject = new JSONObject();
            if (cn.jiguang.i.a.a().d(1022)) {
                jSONObject.put("sim_slots", e(context));
            }
            jSONObject.put("packagename", context.getPackageName());
            jSONObject.put(com.alipay.sdk.sys.a.o, cn.jiguang.n.d.b(context));
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, 0);
            jSONObject.put("apkversion", a2.a);
            jSONObject.put("systemversion", a2.b);
            if (cn.jiguang.i.a.a().d(CommonConstant.RETCODE.SIGN_IN_AUTH_SERVER_FAILED)) {
                jSONObject.put("modelnumber", a2.c);
            }
            if (cn.jiguang.i.a.a().d(2001)) {
                jSONObject.put("basebandversion", a2.d);
            }
            jSONObject.put("buildnumber", a2.e);
            jSONObject.put("channel", a2.f);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PushSDKVer", cn.jiguang.n.d.b(0));
            jSONObject2.put("StatisticSDKVer", cn.jiguang.n.d.b(1));
            jSONObject2.put("ShareSDKVer", cn.jiguang.n.d.b(2));
            jSONObject2.put("CoreSDKVer", cn.jiguang.n.d.b(3));
            jSONObject2.put("SspSDKVer", cn.jiguang.n.d.b(4));
            jSONObject2.put("VerificationSDKVer", cn.jiguang.n.d.b(5));
            jSONObject.put("sdkver", jSONObject2);
            jSONObject.put("installation", a2.g);
            jSONObject.put("business", cn.jiguang.n.d.g());
            jSONObject.put("device_id_status", cn.jiguang.n.d.i(context));
            jSONObject.put("device_id", cn.jiguang.n.d.g(context));
            if (cn.jiguang.i.a.a().d(2012)) {
                jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, a2.h);
            }
            if (cn.jiguang.i.a.a().d(MgtvMediaPlayer.MainNotifyHandler.MSG_HTTPDNS_REPORT_PV)) {
                jSONObject.put("android_id", a2.i);
            }
            if (cn.jiguang.i.a.a().d(CommonConstant.RETCODE.SIGN_IN_NETWORK_UNDER_CONTROLED)) {
                jSONObject.put("mac_address", cn.jiguang.n.d.c(context, ""));
            }
            if (cn.jiguang.i.a.a().d(2013)) {
                jSONObject.put("serial_number", a2.j);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String g(Context context) {
        String str;
        String str2 = (String) cn.jiguang.g.b.b(context, new cn.jiguang.g.a("cn.jpush.preferences.v2", "n_udp_report_device_info", ""));
        if (TextUtils.isEmpty(str2)) {
            str = (String) cn.jiguang.g.b.b(context, new cn.jiguang.g.a("cn.jpush.preferences.v2", "udp_report_device_info", ""));
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        } else {
            str = new String(Base64.decode(str2, 2));
        }
        cn.jiguang.ak.a.a("JDeviceHelper", "read deviceinfo:" + str);
        return str;
    }
}
