package com.hunantv.media.player.libnative;

import java.io.IOException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IMGTVMediaDataSource {
    public static final int IMGTVJS_IOBUFFER_NO_EXIST = -2019071501;
    public static final int IMGTVMDS_ERROR_AJEXIT = -2018111410;
    public static final int IMGTVMDS_ERROR_EAGAIN = -2018102640;
    public static final int IMGTVMDS_ERROR_EOF = -2018102641;
    public static final int IMGTVMDS_ERROR_OPEN_TIMEOUT = -2018102642;
    public static final int IMGTVMDS_ERROR_READ_TIMEOUT = -2018102643;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface IInfoListener {
        void onSourceInfoUpdate(Object obj);
    }

    void close(String str) throws IOException;

    String getDataSourceUrl();

    long getSize(String str) throws IOException;

    int getVideoSourceType();

    long readAt(String str, byte[] bArr, long j, long j2) throws IOException;

    void release();

    void setInfoListener(IInfoListener iInfoListener);

    void setLogTag(String str);
}
