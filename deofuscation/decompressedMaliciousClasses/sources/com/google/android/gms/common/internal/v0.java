package com.google.android.gms.common.internal;

import android.os.Bundle;
import b.a.a.a.c.a;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class v0 extends l0 {
    private /* synthetic */ k0 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(k0 k0Var, int i, Bundle bundle) {
        super(k0Var, i, null);
        this.g = k0Var;
    }

    @Override // com.google.android.gms.common.internal.l0
    protected final void e(a aVar) {
        this.g.h.b(aVar);
        this.g.o(aVar);
    }

    @Override // com.google.android.gms.common.internal.l0
    protected final boolean f() {
        this.g.h.b(a.e);
        return true;
    }
}
