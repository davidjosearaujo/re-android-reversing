package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import b.a.a.a.e.t0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f302a;

    public static SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f302a == null) {
                f302a = (SharedPreferences) t0.a(new k(context));
            }
            sharedPreferences = f302a;
        }
        return sharedPreferences;
    }
}
