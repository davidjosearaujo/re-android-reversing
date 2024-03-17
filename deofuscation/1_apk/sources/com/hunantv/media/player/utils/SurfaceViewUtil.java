package com.hunantv.media.player.utils;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.PixelCopy;
import android.view.SurfaceView;
import androidx.annotation.RequiresApi;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SurfaceViewUtil {
    @RequiresApi(api = 24)
    public static Bitmap getSnapshot(SurfaceView surfaceView, int i, int i2) {
        Bitmap createScaledBitmap;
        if (surfaceView == null || i <= 0 || i2 <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        PixelCopy.request(surfaceView, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.hunantv.media.player.utils.SurfaceViewUtil.1
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public void onPixelCopyFinished(int i3) {
            }
        }, surfaceView.getHandler());
        if ((surfaceView.getWidth() == i && surfaceView.getHeight() == i2) || (createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, i, i2, true)) == null || createScaledBitmap.equals(createBitmap)) {
            return createBitmap;
        }
        createBitmap.recycle();
        return createScaledBitmap;
    }

    public static boolean isSnapshotSupport() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
