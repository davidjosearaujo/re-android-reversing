package com.hunantv.media.player.libnative;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoRtmpClient {
    private long mNativeImgoRtmpClient;

    static {
        System.loadLibrary("ImgoRtmpSource");
    }

    public native int close();

    public native int isConnected();

    public native int open(String str);

    public native int read(byte[] bArr, int i, int i2);

    public native int seek(int i);
}
