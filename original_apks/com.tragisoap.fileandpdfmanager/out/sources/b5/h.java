package b5;

import i6.d;
import i6.e;
import i6.f;
import i6.q;
import i6.v;
import i6.w;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h implements v {

    /* renamed from: f  reason: collision with root package name */
    public boolean f2425f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f f2426g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ e f2427h;

    public h(f fVar, b bVar, q qVar) {
        this.f2426g = fVar;
        this.f2427h = qVar;
    }

    @Override // i6.v
    public final long B(d dVar, long j7) {
        try {
            long B = this.f2426g.B(dVar, j7);
            if (B == -1) {
                if (!this.f2425f) {
                    this.f2425f = true;
                    this.f2427h.close();
                }
                return -1;
            }
            dVar.d(this.f2427h.a(), dVar.f4498g - B, B);
            this.f2427h.F();
            return B;
        } catch (IOException e) {
            if (!this.f2425f) {
                this.f2425f = true;
                throw null;
            }
            throw e;
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
