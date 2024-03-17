package com.hunantv.media.source;

import android.content.Context;
import com.hunantv.media.player.loader.ImgoLibLoader;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoCacheLibLoader {
    public static boolean isLibsLoaded() {
        return ImgoLibLoader.getInstance().isDsLibLoaded() && ImgoLibLoader.getInstance().isCacheLibLoaded();
    }

    public static synchronized boolean loadLibs(Context context) {
        synchronized (ImgoCacheLibLoader.class) {
        }
        return false;
    }
}
