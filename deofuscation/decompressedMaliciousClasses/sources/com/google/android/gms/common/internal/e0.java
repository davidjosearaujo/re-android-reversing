package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class e0 {
    private static short[] $ = {5518, 5558, 5552, 5559, 5603, 5537, 5542, 5603, 5536, 5538, 5551, 5551, 5542, 5543, 5603, 5548, 5549, 5603, 5559, 5547, 5542, 5603, 5547, 5538, 5549, 5543, 5551, 5542, 5553, 5603, 5559, 5547, 5553, 5542, 5538, 5543, 2529, 2511, 2512, 2499, 2504, 2438, 2549, 2514, 2516, 2511, 2504, 2497, 2438, 2511, 2517, 2438, 2499, 2507, 2518, 2514, 2527, 2438, 2505, 2516, 2438, 2504, 2515, 2506, 2506, 6656, 6683, 6658, 6658, 6734, 6684, 6667, 6664, 6667, 6684, 6667, 6656, 6669, 6667};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException($(0, 36, 5571));
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void c(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T e(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void f(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static String g(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException($(36, 65, 2470));
    }

    public static String h(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static <T> T i(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException($(65, 79, 6766));
    }
}
