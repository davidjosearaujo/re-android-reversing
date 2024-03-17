package cn.com.custommma.mobile.tracking.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.custommma.mobile.tracking.api.Constant;
import cn.com.custommma.mobile.tracking.bean.Argument;
import cn.com.custommma.mobile.tracking.bean.Company;
import cn.mmachina.mobile.SignUtils;
import com.hunantv.imgo.log.MLog;
import j.l.c.e0.a.a.f;
import j.u.e.c.c;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CommonUtil {
    public static String encodingUTF8(String str) {
        if (str != null) {
            try {
            } catch (UnsupportedEncodingException unused) {
                return "";
            }
        }
        return URLEncoder.encode(str, "utf-8");
    }

    public static String getHostURL(String str) {
        try {
            Matcher matcher = Pattern.compile("^([\\w\\d]+):\\/\\/([\\w\\d\\-_]+(?:\\.[\\w\\d\\-_]+)*)").matcher(str);
            return matcher.find() ? matcher.group(0) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String getImeiInnner(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return f.e();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMD5(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                str = new BigInteger(1, messageDigest.digest()).toString(16);
                while (str.length() < 32) {
                    str = "0" + str;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    private static String getMainUrl(String str) {
        String host = Uri.parse(str).getHost();
        return str.substring(str.indexOf(host) + host.length());
    }

    private static String getModel() {
        return Build.MODEL;
    }

    public static String getSignature(String str, long j, String str2, String str3, boolean z) {
        try {
            if (z) {
                return mmaSigWithAndroid(str, j, str2, str3);
            }
            return SignUtils.mmaSdkSign(str, j, str2, str3);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isConnected(Context context, int i) {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(i)) == null) {
                return false;
            }
            return networkInfo.isAvailable();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1)) == null) {
            return false;
        }
        return networkInfo.isAvailable();
    }

    public static String md5(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                str = new BigInteger(1, messageDigest.digest()).toString(16);
                while (str.length() < 32) {
                    str = "0" + str;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    private static String mmaSigWithAndroid(String str, long j, String str2, String str3) {
        String valueOf;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String host = Uri.parse(str2).getHost();
        int i = 0;
        int i2 = (!TextUtils.isEmpty(host) && str2.contains(host)) ? 1 : 0;
        String mainUrl = getMainUrl(str2);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - j <= 9 && currentTimeMillis >= j) {
            valueOf = String.valueOf(j);
        } else {
            valueOf = String.valueOf(currentTimeMillis);
        }
        String str5 = "0";
        String str6 = "";
        if (str3 != null) {
            String imeiInnner = getImeiInnner(c.b());
            if (!TextUtils.isEmpty(imeiInnner)) {
                if (mainUrl.contains(imeiInnner) || mainUrl.contains(getMD5(imeiInnner))) {
                    str6 = getMD5(imeiInnner);
                    str5 = "1";
                } else {
                    str5 = "2";
                }
            }
        }
        String model = getModel();
        if (TextUtils.isEmpty("com.hunantv.imgo.activity")) {
            i2 = 0;
        } else {
            str6 = str6 + getMD5("com.hunantv.imgo.activity");
        }
        if (TextUtils.isEmpty(model)) {
            i2 = 0;
        } else {
            str6 = str6 + getMD5(model);
        }
        if (!TextUtils.isEmpty(str)) {
            str6 = str6 + getMD5(str);
            i = i2;
        }
        String md5 = getMD5(str6 + getMD5(valueOf));
        if ((Long.parseLong(valueOf) & 1) == 0) {
            str4 = getMD5(mainUrl) + md5 + "be001211ca8a1e78749c03656a2bc07f4a6238eee08ced35edd6e9ff7e3b800a";
        } else {
            str4 = "be001211ca8a1e78749c03656a2bc07f4a6238eee08ced35edd6e9ff7e3b800a" + getMD5(mainUrl) + md5;
        }
        return getMD5(str4) + MLog.a.b + str5 + String.valueOf(i);
    }

    public static Map<String, String> removeExistArgmentAndGetRedirectURL(String str, List<String> list, String str2, String str3, String str4) {
        List<String> sortByLength = sortByLength(list);
        HashMap hashMap = new HashMap();
        for (String str5 : sortByLength) {
            if (str.contains(str2 + str5)) {
                if (str5.equals(str4)) {
                    Matcher matcher = Pattern.compile(str2 + str5 + "[^" + str2 + "]*").matcher(str);
                    if (matcher.find()) {
                        String group = matcher.group(0);
                        group.replace(str2 + str5, "");
                    }
                }
                str = str.replaceAll(str2 + str5 + str3 + "[^" + str2 + "]*", "");
            }
        }
        hashMap.put(Constant.TRACKING_URL, str);
        return hashMap;
    }

    public static String removeExistEvent(String str, List<String> list, String str2, String str3) {
        for (String str4 : list) {
            if (str.contains(str2 + str4)) {
                Logger.d("mma_" + str2 + str4 + str3 + "[^" + str2 + "]*");
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str4);
                sb.append(str3);
                sb.append("[^");
                sb.append(str2);
                sb.append("]*");
                str = str.replaceAll(sb.toString(), "");
            }
        }
        return str;
    }

    private static List<String> sortByLength(List list) {
        Collections.sort(list, new Comparator<String>() { // from class: cn.com.custommma.mobile.tracking.util.CommonUtil.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.length() > str2.length() ? -1 : 1;
            }
        });
        return list;
    }

    public static String encodingUTF8(String str, Argument argument, Company company) {
        try {
            if (company.sswitch.encrypt.containsKey(argument.key) && "md5".equalsIgnoreCase(company.sswitch.encrypt.get(argument.key))) {
                str = md5(str);
            }
            return !argument.urlEncode ? str == null ? "" : str : str == null ? "" : URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return "";
        }
    }
}
