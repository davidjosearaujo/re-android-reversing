package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import java.io.Closeable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class CloseableImage implements Closeable, ImageInfo {
    private static final String TAG = "CloseableImage";

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        FLog.w(TAG, "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public QualityInfo getQualityInfo() {
        return ImmutableQualityInfo.FULL_QUALITY;
    }

    public abstract int getSizeInBytes();

    public abstract boolean isClosed();

    public boolean isStateful() {
        return false;
    }
}