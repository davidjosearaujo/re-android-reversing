package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f256a;

    /* renamed from: b  reason: collision with root package name */
    private final String f257b;
    private final ComponentName c = null;

    public f(String str, String str2) {
        e0.g(str);
        this.f256a = str;
        e0.g(str2);
        this.f257b = str2;
    }

    public final ComponentName a() {
        return this.c;
    }

    public final String b() {
        return this.f257b;
    }

    public final Intent c() {
        return this.f256a != null ? new Intent(this.f256a).setPackage(this.f257b) : new Intent().setComponent(this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return v.a(this.f256a, fVar.f256a) && v.a(this.f257b, fVar.f257b) && v.a(this.c, fVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f256a, this.f257b, this.c});
    }

    public final String toString() {
        String str = this.f256a;
        return str == null ? this.c.flattenToString() : str;
    }
}
