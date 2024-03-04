package i6;

import java.io.IOException;

/* loaded from: classes.dex */
public final class a implements u {

    /* renamed from: f */
    public final /* synthetic */ u f4489f;

    /* renamed from: g */
    public final /* synthetic */ c f4490g;

    public a(o oVar, m mVar) {
        this.f4490g = oVar;
        this.f4489f = mVar;
    }

    @Override // i6.u
    public final w c() {
        return this.f4490g;
    }

    @Override // i6.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f4490g.i();
        try {
            try {
                this.f4489f.close();
                this.f4490g.k(true);
            } catch (IOException e) {
                throw this.f4490g.j(e);
            }
        } catch (Throwable th) {
            this.f4490g.k(false);
            throw th;
        }
    }

    @Override // i6.u, java.io.Flushable
    public final void flush() {
        this.f4490g.i();
        try {
            try {
                this.f4489f.flush();
                this.f4490g.k(true);
            } catch (IOException e) {
                throw this.f4490g.j(e);
            }
        } catch (Throwable th) {
            this.f4490g.k(false);
            throw th;
        }
    }

    @Override // i6.u
    public final void h(d dVar, long j5) {
        this.f4490g.i();
        try {
            try {
                this.f4489f.h(dVar, j5);
                this.f4490g.k(true);
            } catch (IOException e) {
                throw this.f4490g.j(e);
            }
        } catch (Throwable th) {
            this.f4490g.k(false);
            throw th;
        }
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("AsyncTimeout.sink(");
        d7.append(this.f4489f);
        d7.append(")");
        return d7.toString();
    }
}
