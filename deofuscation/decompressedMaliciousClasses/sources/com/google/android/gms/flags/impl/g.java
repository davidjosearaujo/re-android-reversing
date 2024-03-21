package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class g implements Callable<Long> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ SharedPreferences f298a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f299b;
    private /* synthetic */ Long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SharedPreferences sharedPreferences, String str, Long l) {
        this.f298a = sharedPreferences;
        this.f299b = str;
        this.c = l;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() {
        return Long.valueOf(this.f298a.getLong(this.f299b, this.c.longValue()));
    }
}
