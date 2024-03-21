package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class e {
    private static short[] $ = {2477, 2466, 2472, 2494, 2467, 2469, 2472, 2530, 2468, 2477, 2494, 2472, 2491, 2477, 2494, 2473, 2530, 2488, 2485, 2492, 2473, 2530, 2491, 2477, 2488, 2479, 2468, 6094, 6083, 6019, 6090, 6082, 6082, 6090, 6081, 6088, 5009, 5022, 5012, 4994, 5023, 5017, 5012, 5086, 5016, 5009, 4994, 5012, 4999, 5009, 4994, 5013, 5086, 4996, 5001, 4992, 5013, 5086, 5017, 5023, 4996, 3983, 3968, 3978, 3996, 3969, 3975, 3978, 4032, 3974, 3983, 3996, 3978, 3993, 3983, 3996, 3979, 4032, 3994, 3991, 3998, 3979, 4032, 3979, 3971, 3980, 3979, 3978, 3978, 3979, 3978};

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f290a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f291b;
    private static Boolean c;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @TargetApi(20)
    public static boolean a(Context context) {
        if (f290a == null) {
            f290a = Boolean.valueOf(g.d() && context.getPackageManager().hasSystemFeature($(0, 27, 2508)));
        }
        return f290a.booleanValue();
    }

    @TargetApi(24)
    public static boolean b(Context context) {
        return (!g.a() || c(context)) && a(context);
    }

    @TargetApi(21)
    public static boolean c(Context context) {
        if (f291b == null) {
            f291b = Boolean.valueOf(g.e() && context.getPackageManager().hasSystemFeature($(27, 36, 6061)));
        }
        return f291b.booleanValue();
    }

    public static boolean d(Context context) {
        if (c == null) {
            c = Boolean.valueOf(context.getPackageManager().hasSystemFeature($(36, 61, 5104)) || context.getPackageManager().hasSystemFeature($(61, 91, 4078)));
        }
        return c.booleanValue();
    }
}
