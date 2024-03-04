package b5;

import i6.q;
import i6.v;
import i6.w;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class h implements v {

    /* renamed from: f */
    public boolean f2425f;

    /* renamed from: g */
    public final /* synthetic */ i6.f f2426g;

    /* renamed from: h */
    public final /* synthetic */ i6.e f2427h;

    public h(i6.f fVar, b bVar, q qVar) {
        this.f2426g = fVar;
        this.f2427h = qVar;
    }

    @Override // i6.v
    public final long B(i6.d dVar, long j5) {
        try {
            long B = this.f2426g.B(dVar, j5);
            if (B != -1) {
                dVar.d(this.f2427h.a(), dVar.f4498g - B, B);
                this.f2427h.F();
                return B;
            }
            if (!this.f2425f) {
                this.f2425f = true;
                this.f2427h.close();
            }
            return -1L;
        } catch (IOException e) {
            if (this.f2425f) {
                throw e;
            }
            this.f2425f = true;
            throw null;
        }
    }

    @Override // i6.v
    public final w c() {
        return this.f2426g.c();
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z6;
        if (!this.f2425f) {
            try {
                z6 = z4.h.i(this, 100, TimeUnit.MILLISECONDS);
            } catch (IOException unused) {
                z6 = false;
            }
            if (!z6) {
                this.f2425f = true;
                throw null;
            }
        }
        this.f2426g.close();
    }
}
