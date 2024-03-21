package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class e implements Callable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ SharedPreferences f296a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f297b;
    private /* synthetic */ Integer c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f296a = sharedPreferences;
        this.f297b = str;
        this.c = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() {
        return Integer.valueOf(this.f296a.getInt(this.f297b, this.c.intValue()));
    }
}
