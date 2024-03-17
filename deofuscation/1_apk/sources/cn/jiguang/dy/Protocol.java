package cn.jiguang.dy;

import cn.jiguang.ar.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class Protocol {
    private static final String TAG = "Protocol";
    public static final String soName = "jcore282";

    static {
        try {
            System.loadLibrary("jcore282");
        } catch (Throwable th) {
            c.i("PushProtocol", "System.loadLibrary::jcore282" + th);
        }
    }

    public native int getVersion(int i);
}
