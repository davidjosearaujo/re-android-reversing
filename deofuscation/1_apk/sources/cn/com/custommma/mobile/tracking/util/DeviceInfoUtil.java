package cn.com.custommma.mobile.tracking.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import cn.com.custommma.mobile.tracking.api.Constant;
import cn.com.custommma.mobile.tracking.api.Countly;
import cn.com.custommma.mobile.tracking.bean.Company;
import cn.com.custommma.mobile.tracking.bean.SDK;
import cn.com.custommma.mobile.tracking.util.ConnectUtil;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.yoga.android.BuildConfig;
import j.l.c.e0.a.a.c;
import j.l.c.e0.a.a.f;
import j.s.j.j0;
import j.s.j.s0;
import j.s.j.t;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DeviceInfoUtil {
    private static final String CHAR_SET = "iso-8859-1";
    private static final String SHA1_ALGORITHM = "SHA-1";
    public static String fileName = ".mzcookie.text";
    private static boolean isAdidgeting;
    public static String mainDic = j0.c();
    public static String[] subDics = {"/.aaa/ddd/", "/.bbb/ddd", "/.ccc/ddd"};
    public static String ADID = "unknow";
    public static int cpu_num = 1;
    public static long sd_count = 0;
    public static long system_count = 0;
    private static Map<String, String> deviceInfoParams = null;

    private static String SHA1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA1_ALGORITHM);
            messageDigest.update(str.getBytes(CHAR_SET), 0, str.length());
            return convertToHex(messageDigest.digest());
        } catch (Exception e) {
            Logger.e("ODIN Error generating generating SHA-1: " + e);
            return null;
        }
    }

    public static String appVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    private static boolean checkAdidUpdate(Context context) {
        int i = 0;
        while (true) {
            try {
                String[] strArr = subDics;
                if (i >= strArr.length) {
                    break;
                }
                String str = mainDic + strArr[i];
                if (new File(str).exists() && new File(str, fileName).exists()) {
                    return true;
                }
                i++;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    private static String convertToHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] >>> 4) & 15;
            int i3 = 0;
            while (true) {
                if (i2 >= 0 && i2 <= 9) {
                    stringBuffer.append((char) (i2 + 48));
                } else {
                    stringBuffer.append((char) ((i2 - 10) + 97));
                }
                i2 = bArr[i] & 15;
                int i4 = i3 + 1;
                if (i3 >= 1) {
                    break;
                }
                i3 = i4;
            }
        }
        return stringBuffer.toString();
    }

    public static String getAndroidId(Context context) {
        try {
            return t.c(context);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAppName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static JSONArray getApplist(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            context.getPackageManager();
            List<PackageInfo> c = c.c(0);
            if (c != null) {
                for (PackageInfo packageInfo : c) {
                    StringBuffer stringBuffer = new StringBuffer();
                    boolean z = true;
                    if ((packageInfo.applicationInfo.flags & 1) <= 0) {
                        z = false;
                    }
                    String str = packageInfo.packageName;
                    String str2 = "";
                    String trim = str == null ? "" : str.trim();
                    String str3 = packageInfo.versionName;
                    if (str3 != null) {
                        str2 = str3.trim();
                    }
                    stringBuffer.append(trim);
                    stringBuffer.append(",");
                    stringBuffer.append(str2);
                    stringBuffer.append(",");
                    stringBuffer.append(z ? "1" : "0");
                    jSONArray.put(stringBuffer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray;
    }

    public static String getCarrier(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    public static String getCurrentNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            activeNetworkInfo.getSubtype();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype != 4 && subtype != 1 && subtype != 2) {
                        if (subtype != 3 && subtype != 8 && subtype != 6 && subtype != 5 && subtype != 12 && subtype != 10 && subtype != 9 && subtype != 14 && subtype != 15) {
                            return subtype == 13 ? "4g" : "";
                        }
                        return "3g";
                    }
                    return "2g";
                }
                return "";
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getDevice() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getDeviceAdid(final Context context, SDK sdk) {
        if (isAdidgeting) {
            return "";
        }
        if (checkAdidUpdate(context)) {
            String readAdid = readAdid(context);
            ADID = readAdid;
            if (!TextUtils.isEmpty(readAdid)) {
                return ADID;
            }
        }
        String string = SharedPreferencedUtil.getString(context);
        ADID = string;
        if (!TextUtils.isEmpty(string)) {
            if (!checkAdidUpdate(context)) {
                writeAdid(context, ADID);
            }
            return ADID;
        }
        final String isAdidServerUrl = isAdidServerUrl(sdk);
        if (!checkAdidUpdate(context) && !TextUtils.isEmpty(isAdidServerUrl)) {
            isAdidgeting = true;
            if (isNetworkAvailable(context)) {
                new Thread(new Runnable() { // from class: cn.com.custommma.mobile.tracking.util.DeviceInfoUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DeviceInfoUtil.ADID = ConnectUtil.getInstance().requestID(context, isAdidServerUrl, new ConnectUtil.RequestSuccess() { // from class: cn.com.custommma.mobile.tracking.util.DeviceInfoUtil.1.1
                                {
                                    AnonymousClass1.this = this;
                                }

                                @Override // cn.com.custommma.mobile.tracking.util.ConnectUtil.RequestSuccess
                                public void completed(String str) {
                                    SharedPreferencedUtil.putString(context, str);
                                    DeviceInfoUtil.writeAdid(context, DeviceInfoUtil.ADID);
                                }
                            });
                        } catch (Exception unused) {
                        } catch (Throwable th) {
                            boolean unused2 = DeviceInfoUtil.isAdidgeting = false;
                            throw th;
                        }
                        boolean unused3 = DeviceInfoUtil.isAdidgeting = false;
                    }
                }).start();
            }
            return ADID;
        }
        return ADID;
    }

    public static Map<String, String> getDeviceInfo(Context context) {
        if (deviceInfoParams == null) {
            deviceInfoParams = new HashMap();
            try {
                deviceInfoParams.put(Constant.TRACKING_MAC, getMacAddress(context).replace(CertificateUtil.DELIMITER, "").toUpperCase());
                deviceInfoParams.put(Constant.TRACKING_ANDROIDID, getAndroidId(context));
                deviceInfoParams.put(Constant.TRACKING_OS_VERION, getOSVersion());
                deviceInfoParams.put(Constant.TRACKING_TERM, getDevice());
                deviceInfoParams.put(Constant.TRACKING_NAME, getAppName(context));
                deviceInfoParams.put(Constant.TRACKING_KEY, getPackageName(context));
                deviceInfoParams.put(Constant.TRACKING_SCWH, getResolution(context));
                deviceInfoParams.put(Constant.TRACKING_OS, "0");
                deviceInfoParams.put(Constant.TRACKING_SDKVS, Constant.TRACKING_SDKVS_VALUE);
                deviceInfoParams.put(Constant.TRACKING_AAID, Reflection.getPlayAdId(context));
            } catch (Exception unused) {
            }
        }
        if (Build.VERSION.SDK_INT < 29) {
            deviceInfoParams.put(Constant.TRACKING_IMEI, getImei(context));
            deviceInfoParams.put(Constant.TRACKING_RAWIMEI, getImei(context));
        }
        deviceInfoParams.put(Constant.TRACKING_WIFIBSSID, getWiFiBSSID(context).replace(CertificateUtil.DELIMITER, "").toUpperCase());
        deviceInfoParams.put(Constant.TRACKING_WIFISSID, getWifiSSID(context));
        deviceInfoParams.put(Constant.TRACKING_WIFI, isWifi(context));
        deviceInfoParams.put(Constant.TRACKING_ADID, ADID);
        if (Countly.ISNEED_OAID) {
            deviceInfoParams.put(Constant.TRACKING_OAID, Countly.OAID);
        } else {
            deviceInfoParams.put(Constant.TRACKING_OAID, "unknow");
        }
        return deviceInfoParams;
    }

    public static Map<String, String> getDeviceInfoMk(Context context) {
        Map<String, String> map = deviceInfoParams;
        try {
            if (map == null) {
                deviceInfoParams = new HashMap();
                deviceInfoParams.put(Constant.TRACKING_MAC, getMacAddress(context).replace(CertificateUtil.DELIMITER, "").toUpperCase());
                deviceInfoParams.put(Constant.TRACKING_ANDROIDID, getAndroidId(context));
                deviceInfoParams.put(Constant.TRACKING_OS_VERION, getOSVersion());
                deviceInfoParams.put(Constant.TRACKING_TERM, getDevice());
                deviceInfoParams.put(Constant.TRACKING_NAME, "芒果TV");
                deviceInfoParams.put(Constant.TRACKING_KEY, "com.hunantv.imgo.activity");
                deviceInfoParams.put(Constant.TRACKING_SCWH, getResolution(context));
                deviceInfoParams.put(Constant.TRACKING_OS, "0");
                deviceInfoParams.put(Constant.TRACKING_SDKVS, Constant.TRACKING_SDKVS_VALUE);
                deviceInfoParams.put(Constant.TRACKING_AAID, Reflection.getPlayAdId(context));
            } else {
                map.remove(Constant.TRACKING_KEY);
                deviceInfoParams.remove(Constant.TRACKING_NAME);
                deviceInfoParams.put(Constant.TRACKING_NAME, "芒果TV");
                deviceInfoParams.put(Constant.TRACKING_KEY, "com.hunantv.imgo.activity");
            }
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT < 29) {
            deviceInfoParams.put(Constant.TRACKING_IMEI, getImei(context));
            deviceInfoParams.put(Constant.TRACKING_RAWIMEI, getImei(context));
        }
        deviceInfoParams.put(Constant.TRACKING_WIFIBSSID, getWiFiBSSID(context).replace(CertificateUtil.DELIMITER, "").toUpperCase());
        deviceInfoParams.put(Constant.TRACKING_WIFISSID, getWifiSSID(context));
        deviceInfoParams.put(Constant.TRACKING_WIFI, isWifi(context));
        deviceInfoParams.put(Constant.TRACKING_ADID, ADID);
        if (Countly.ISNEED_OAID) {
            deviceInfoParams.put(Constant.TRACKING_OAID, Countly.OAID);
        } else {
            deviceInfoParams.put(Constant.TRACKING_OAID, "unknow");
        }
        return deviceInfoParams;
    }

    public static String getIP(Context context) {
        try {
            Enumeration<InetAddress> inetAddresses = NetworkInterface.getNetworkInterfaces().nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress nextElement = inetAddresses.nextElement();
                if (!nextElement.isLinkLocalAddress()) {
                    return nextElement.getHostAddress();
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getImei(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return f.e();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getLocale() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    public static String getMacAddress(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getMacWithNetWorkInterface();
        }
        return getMacWithManager(context);
    }

    @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    private static String getMacWithManager(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String getMacWithNetWorkInterface() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "";
    }

    private static String getMainDic() {
        try {
            File externalFilesDir = j.u.e.c.c.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            return externalFilesDir != null ? externalFilesDir.toString() : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getModel() {
        String str = Build.DEVICE;
        String str2 = Build.ID;
        String str3 = Build.DISPLAY;
        String str4 = Build.PRODUCT;
        String str5 = Build.BOARD;
        String str6 = Build.BRAND;
        String str7 = Build.MODEL;
        return str + "," + str2 + "," + str3 + "," + str4 + "," + str5 + "," + str6 + "," + str7;
    }

    public static int getNumCores() {
        int i = cpu_num;
        if (i > 1) {
            return i;
        }
        try {
            int length = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: cn.com.custommma.mobile.tracking.util.DeviceInfoUtil.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
            cpu_num = length;
            return length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static String getODIN1(Context context) {
        try {
            return SHA1(t.c(context));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getOSVersion() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getOperatorName(Context context) {
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        return ("46001".equals(networkOperator) || "46006".equals(networkOperator) || "46009".equals(networkOperator)) ? "中国联通" : ("46000".equals(networkOperator) || "46002".equals(networkOperator) || "46004".equals(networkOperator) || "46007".equals(networkOperator)) ? "中国移动" : ("46003".equals(networkOperator) || "46005".equals(networkOperator) || "46011".equals(networkOperator)) ? "中国电信" : "";
    }

    public static String getPackageName(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        } catch (Exception unused) {
            return "";
        }
    }

    public static long getSDCardCount() {
        return 0L;
    }

    public static long getSystemCount() {
        long j = system_count;
        if (j > 0) {
            return j;
        }
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        long blockSize = statFs.getBlockSize() * statFs.getBlockCount();
        system_count = blockSize;
        return blockSize;
    }

    @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    public static String getWiFiBSSID(Context context) {
        WifiInfo connectionInfo;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return (activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null || TextUtils.isEmpty(connectionInfo.getBSSID())) ? "" : connectionInfo.getBSSID();
        } catch (Exception unused) {
            return "";
        }
    }

    @RequiresPermission("android.permission.ACCESS_WIFI_STATE")
    public static String getWifiSSID(Context context) {
        WifiInfo connectionInfo;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null || TextUtils.isEmpty(connectionInfo.getSSID())) {
                return "";
            }
            String trim = connectionInfo.getSSID().trim();
            if (trim.startsWith("\"")) {
                trim = trim.substring(1);
            }
            return trim.endsWith("\"") ? trim.substring(0, trim.length() - 1) : trim;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String isAdidServerUrl(SDK sdk) {
        if (sdk != null) {
            try {
                List<Company> list = sdk.companies;
                if (list != null) {
                    for (Company company : list) {
                        if ("miaozhen".equals(company.name)) {
                            return company.adidurl;
                        }
                    }
                    return "";
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] allNetworkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String isWifi(Context context) {
        try {
            String currentNetType = getCurrentNetType(context);
            if (TextUtils.isEmpty(currentNetType)) {
                return "2";
            }
            return currentNetType.equals("wifi") ? "1" : "0";
        } catch (Exception e) {
            e.printStackTrace();
            return "2";
        }
    }

    public static String readAdid(Context context) {
        String str = "";
        int i = 0;
        while (true) {
            try {
                String[] strArr = subDics;
                if (i >= strArr.length) {
                    break;
                }
                String str2 = strArr[i];
                File file = new File(mainDic + str2, fileName);
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[1024];
                    StringBuilder sb = new StringBuilder("");
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    fileInputStream.close();
                    str = sb.toString().trim();
                    if (str != null && str != "" && (str = Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("")) != null && str.length() > 0) {
                        return str;
                    }
                }
                i++;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }

    public static boolean writeAdid(Context context, String str) {
        int i = 0;
        boolean z = false;
        while (true) {
            try {
                String[] strArr = subDics;
                if (i >= strArr.length) {
                    break;
                }
                String str2 = mainDic + strArr[i];
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str2, fileName);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                i++;
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return z;
    }

    @RequiresApi(api = 29)
    public static boolean writeAdidByMediaApi(Context context, String str) {
        int i = 0;
        boolean z = false;
        while (true) {
            try {
                String[] strArr = subDics;
                if (i >= strArr.length) {
                    break;
                }
                String str2 = strArr[i];
                String str3 = mainDic + str2;
                s0.x(fileName, str, "text/plain", str2);
                i++;
                z = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return z;
    }
}
