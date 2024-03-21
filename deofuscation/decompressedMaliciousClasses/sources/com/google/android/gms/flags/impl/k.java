package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class k implements Callable<SharedPreferences> {
    private static short[] $ = {24681, 24673, 24673, 24681, 24674, 24683, 24657, 24701, 24682, 24677, 24657, 24680, 24674, 24687, 24681, 24701};

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f303a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this.f303a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() {
        return this.f303a.getSharedPreferences($(0, 16, 24590), 0);
    }
}
