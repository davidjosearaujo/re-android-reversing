package com.hunantv.media.player.utils;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SurfaceUtil {
    private static final String TAG = "SurfaceUtil";

    public static Surface create(SurfaceTexture surfaceTexture) {
        try {
            return new Surface(surfaceTexture);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void release(Surface surface) {
        if (surface != null) {
            try {
                surface.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
