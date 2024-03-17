package com.facebook.cache.common;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface WriterCallback {
    void write(OutputStream outputStream) throws IOException;
}
