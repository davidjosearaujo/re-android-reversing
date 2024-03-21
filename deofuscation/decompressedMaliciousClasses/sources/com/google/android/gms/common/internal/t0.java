package com.google.android.gms.common.internal;

import b.a.a.a.c.a;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class t0 implements q0 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ k0 f278a;

    public t0(k0 k0Var) {
        this.f278a = k0Var;
    }

    @Override // com.google.android.gms.common.internal.q0
    public final void b(a aVar) {
        if (aVar.h()) {
            k0 k0Var = this.f278a;
            k0Var.b(null, k0Var.S());
        } else if (this.f278a.n != null) {
            this.f278a.n.b(aVar);
        }
    }
}
