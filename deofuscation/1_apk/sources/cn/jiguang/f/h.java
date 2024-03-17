package cn.jiguang.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class h {
    public static int a(Context context) {
        return a(c(context));
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("wifi".equals(str)) {
            return 1;
        }
        if ("2g".equals(str)) {
            return 2;
        }
        if ("3g".equals(str)) {
            return 3;
        }
        if ("4g".equals(str)) {
            return 4;
        }
        return "5g".equals(str) ? 5 : 0;
    }

    public static String a(int i) {
        cn.jiguang.ar.c.a("TeleonyManagerUtils", "getRadioType - networkType:" + i);
        String str = (i == 4 || i == 7 || i == 5 || i == 6 || i == 12 || i == 14) ? "cdma" : i == 13 ? "lte" : "gsm";
        cn.jiguang.ar.c.a("TeleonyManagerUtils", "getRadioType - radioType:" + str);
        return str;
    }

    public static String a(Context context, int i) {
        String c = c(context);
        cn.jiguang.ar.c.a("TeleonyManagerUtils", "getCurrentNetType - type:" + c);
        if (TextUtils.isEmpty(c)) {
            try {
                Object a = f.a((Class<?>) TelephonyManager.class, "getNetworkClass", new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
                if (((Integer) a).intValue() == 0) {
                    c = "unknown";
                } else if (((Integer) a).intValue() == 1) {
                    c = "2g";
                } else if (((Integer) a).intValue() == 2) {
                    c = "3g";
                } else if (((Integer) a).intValue() == 3) {
                    c = "4g";
                }
                cn.jiguang.ar.c.c("TeleonyManagerUtils", "step2 - type:" + c);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | Exception unused) {
            }
        }
        return TextUtils.isEmpty(c) ? "unknown" : c;
    }

    private static String b(int i) {
        cn.jiguang.ar.c.a("TeleonyManagerUtils", "getNetworkClass networkType:" + i);
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                switch (i) {
                    case 16:
                        return "2g";
                    case 17:
                        return "3g";
                    case 18:
                    case 19:
                        return "4g";
                    case 20:
                        return "5g";
                    default:
                        return "unknown";
                }
        }
    }

    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        String b;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    b = "wifi";
                } else if (activeNetworkInfo.getType() != 0) {
                    return "unknown";
                } else {
                    b = b(activeNetworkInfo.getSubtype());
                }
                return b;
            }
            return "unknown";
        } catch (Exception e) {
            e.printStackTrace();
            return "unknown";
        }
    }

    public static int d(Context context) {
        try {
            return a(b(((TelephonyManager) context.getSystemService("phone")).getNetworkType()));
        } catch (Throwable th) {
            cn.jiguang.ar.c.i("TeleonyManagerUtils", "get getNetworkType error :" + th);
            return 0;
        }
    }
}
