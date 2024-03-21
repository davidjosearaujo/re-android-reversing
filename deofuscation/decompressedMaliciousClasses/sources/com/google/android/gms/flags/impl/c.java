package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class c implements Callable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ SharedPreferences f294a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f295b;
    private /* synthetic */ Boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f294a = sharedPreferences;
        this.f295b = str;
        this.c = bool;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() {
        return Boolean.valueOf(this.f294a.getBoolean(this.f295b, this.c.booleanValue()));
    }
}
