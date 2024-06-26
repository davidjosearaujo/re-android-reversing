package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class StreamProcessor {
    public static int readPackedInt(InputStream inputStream, int i, boolean z) throws IOException {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int read = inputStream.read();
            if (read == -1) {
                throw new IOException("no more bytes");
            }
            if (z) {
                i2 = (read & JfifUtil.MARKER_FIRST_BYTE) << (i4 * 8);
            } else {
                i3 <<= 8;
                i2 = read & JfifUtil.MARKER_FIRST_BYTE;
            }
            i3 |= i2;
        }
        return i3;
    }
}
