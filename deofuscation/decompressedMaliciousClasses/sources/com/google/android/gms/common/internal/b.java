package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import b.a.a.a.c.c;
import b.a.a.a.c.h;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class b<T extends IInterface> extends k0<T> implements a.f {
    private static short[] $ = {6084, 6137, 6129, 6112, 6127, 6117, 6120, 6127, 6118, 6049, 6130, 6114, 6126, 6129, 6116, 6130, 6049, 6120, 6130, 6049, 6127, 6126, 6133, 6049, 6129, 6116, 6131, 6124, 6120, 6133, 6133, 6116, 6117, 6061, 6049, 6132, 6130, 6116, 6049, 6120, 6124, 6129, 6125, 6120, 6116, 6117, 6049, 6130, 6114, 6126, 6129, 6116, 6130, 6049, 6120, 6127, 6130, 6133, 6116, 6112, 6117};
    private final Set<Scope> t;
    private final Account u;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.content.Context r14, android.os.Looper r15, int r16, com.google.android.gms.common.internal.w0 r17, com.google.android.gms.common.api.e.b r18, com.google.android.gms.common.api.e.c r19) {
        /*
            r13 = this;
            r9 = r13
            r10 = r14
            r11 = r15
            r12 = r16
            r13 = r17
            r14 = r18
            r15 = r19
            com.google.android.gms.common.internal.e r3 = com.google.android.gms.common.internal.e.c(r10)
            b.a.a.a.c.c r4 = b.a.a.a.c.c.j()
            com.google.android.gms.common.internal.e0.i(r14)
            r7 = r14
            com.google.android.gms.common.api.e$b r7 = (com.google.android.gms.common.api.e.b) r7
            com.google.android.gms.common.internal.e0.i(r15)
            r8 = r15
            com.google.android.gms.common.api.e$c r8 = (com.google.android.gms.common.api.e.c) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.b.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.w0, com.google.android.gms.common.api.e$b, com.google.android.gms.common.api.e$c):void");
    }

    private b(Context context, Looper looper, e eVar, c cVar, int i, w0 w0Var, e.b bVar, e.c cVar2) {
        super(context, looper, eVar, cVar, i, bVar == null ? null : new c(bVar), cVar2 == null ? null : new d(cVar2), w0Var.f());
        this.u = w0Var.a();
        Set<Scope> d = w0Var.d();
        U(d);
        for (Scope scope : d) {
            if (!d.contains(scope)) {
                throw new IllegalStateException($(0, 61, 6017));
            }
        }
        this.t = d;
    }

    @Override // com.google.android.gms.common.internal.k0
    public h[] O() {
        return new h[0];
    }

    @Override // com.google.android.gms.common.internal.k0
    public final Set<Scope> S() {
        return this.t;
    }

    protected Set<Scope> U(Set<Scope> set) {
        return set;
    }

    @Override // com.google.android.gms.common.internal.k0
    public final Account m() {
        return this.u;
    }
}
