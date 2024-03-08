package i6;

import androidx.activity.h;
import java.io.IOException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements u {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ u f4489f;

    /* renamed from: g  reason: collision with root package name */
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
        try {
            this.f4490g.i();
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
        try {
            this.f4490g.i();
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
    public final void h(d dVar, long j7) {
        try {
            this.f4490g.i();
            try {
                this.f4489f.h(dVar, j7);
                this.f4490g.k(true);
            } catch (IOException e) {
                throw this.f4490g.j(e);
            }
        } catch (Throwable th) {
            this.f4490g.k(false);
            throw th;
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("AsyncTimeout.sink(");
        d7.append(this.f4489f);
        d7.append(")");
        return d7.toString();
    }
}
