package com.hunantv.media.utils;

import android.net.Uri;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class Utils {
    public static boolean isLocalUri(Uri uri) {
        return (uri == null || uri.getPath() == null || !uri.getPath().toLowerCase().contains("file:/")) ? false : true;
    }
}
