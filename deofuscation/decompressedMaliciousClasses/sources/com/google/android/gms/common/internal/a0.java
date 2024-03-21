package com.google.android.gms.common.internal;

import b.a.a.a.g.d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import java.util.concurrent.TimeUnit;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class a0 implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ f f245a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ d f246b;
    private /* synthetic */ c0 c;
    private /* synthetic */ d0 d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(f fVar, d dVar, c0 c0Var, d0 d0Var) {
        this.f245a = fVar;
        this.f246b = dVar;
        this.c = c0Var;
        this.d = d0Var;
    }

    @Override // com.google.android.gms.common.api.f.a
    public final void a(Status status) {
        if (status.f()) {
            this.f246b.c(this.c.a(this.f245a.a(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f246b.b(this.d.a(status));
    }
}
