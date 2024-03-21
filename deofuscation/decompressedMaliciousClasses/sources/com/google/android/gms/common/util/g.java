package com.google.android.gms.common.util;

import android.os.Build;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class g {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 20;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
