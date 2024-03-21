package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class i implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ SharedPreferences f300a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f301b;
    private /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SharedPreferences sharedPreferences, String str, String str2) {
        this.f300a = sharedPreferences;
        this.f301b = str;
        this.c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        return this.f300a.getString(this.f301b, this.c);
    }
}
