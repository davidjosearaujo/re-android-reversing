package com.facebook.cache.common;

import android.net.Uri;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DebuggingCacheKey extends SimpleCacheKey {
    @Nullable
    private final Object mCallerContext;
    private final Uri mSourceUri;

    public DebuggingCacheKey(String str, @Nullable Object obj, Uri uri) {
        super(str);
        this.mCallerContext = obj;
        this.mSourceUri = uri;
    }

    @Nullable
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }
}
