package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import b.a.a.a.e.p0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class u {
    private static short[] $ = {4479, 4467, 4465, 4402, 4475, 4467, 4467, 4475, 4464, 4473, 4402, 4477, 4460, 4460, 4402, 4469, 4472, 797, 785, 787, 848, 793, 785, 785, 793, 786, 795, 848, 799, 784, 794, 780, 785, 791, 794, 848, 793, 787, 781, 848, 776, 795, 780, 781, 791, 785, 784, 4058, 4082, 4067, 4086, 4083, 4086, 4067, 4086, 4033, 4086, 4091, 4066, 4082, 4037, 4082, 4086, 4083, 4082, 4069, 3951, 3923, 3922, 3912, 3867, 3912, 3923, 3924, 3918, 3927, 3935, 3867, 3925, 3934, 3917, 3934, 3913, 3867, 3923, 3930, 3915, 3915, 3934, 3925, 3861};

    /* renamed from: a  reason: collision with root package name */
    private static Object f279a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f280b;
    private static int c;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static int a(Context context) {
        b(context);
        return c;
    }

    private static void b(Context context) {
        Bundle bundle;
        synchronized (f279a) {
            if (!f280b) {
                f280b = true;
                try {
                    bundle = p0.b(context).a(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf($(47, 66, 3991), $(66, 91, 3899), e);
                }
                if (bundle != null) {
                    bundle.getString($(0, 17, 4380));
                    c = bundle.getInt($(17, 47, 894));
                }
            }
        }
    }
}
