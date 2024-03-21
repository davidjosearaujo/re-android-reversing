package com.google.android.gms.common.internal;

import b.a.a.a.g.c;
import b.a.a.a.g.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.j;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final d0 f286a = new z();

    public static <R extends j, T extends i<R>> c<T> a(f<R> fVar, T t) {
        return b(fVar, new b0(t));
    }

    private static <R extends j, T> c<T> b(f<R> fVar, c0<R, T> c0Var) {
        d0 d0Var = f286a;
        d dVar = new d();
        fVar.b(new a0(fVar, dVar, c0Var, d0Var));
        return dVar.a();
    }
}
