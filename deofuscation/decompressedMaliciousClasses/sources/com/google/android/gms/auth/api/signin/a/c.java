package com.google.android.gms.auth.api.signin.a;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static int f221b = 31;

    /* renamed from: a  reason: collision with root package name */
    private int f222a = 1;

    public final c a(boolean z) {
        this.f222a = (f221b * this.f222a) + (z ? 1 : 0);
        return this;
    }

    public final int b() {
        return this.f222a;
    }

    public final c c(Object obj) {
        this.f222a = (f221b * this.f222a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }
}
