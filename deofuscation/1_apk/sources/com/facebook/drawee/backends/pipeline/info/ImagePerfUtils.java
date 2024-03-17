package com.facebook.drawee.backends.pipeline.info;

import com.facebook.GraphResponse;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImagePerfUtils {
    private ImagePerfUtils() {
    }

    public static String toString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "error" : "canceled" : GraphResponse.SUCCESS_KEY : "intermediate_available" : "origin_available" : "requested";
    }
}
