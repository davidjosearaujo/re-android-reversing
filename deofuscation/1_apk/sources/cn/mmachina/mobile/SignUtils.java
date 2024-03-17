package cn.mmachina.mobile;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SignUtils {
    static {
        System.loadLibrary("MMASignature");
    }

    public static native String mmaSdkSign(String str, long j, String str2, String str3);
}
