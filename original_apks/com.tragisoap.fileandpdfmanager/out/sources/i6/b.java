package i6;

import androidx.activity.h;
import java.io.IOException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements v {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ v f4491f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ c f4492g;

    public b(o oVar, n nVar) {
        this.f4492g = oVar;
        this.f4491f = nVar;
    }

    @Override // i6.v
    public final long B(d dVar, long j7) {
        try {
            this.f4492g.i();
            try {
                long B = this.f4491f.B(dVar, j7);
                this.f4492g.k(true);
                return B;
            } catch (IOException e) {
                throw this.f4492g.j(e);
            }
        } catch (Throwable th) {
            this.f4492g.k(false);
            throw th;
        }
    }

    @Override // i6.v
    public final w c() {
        return this.f4492g;
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            try {
                this.f4491f.close();
                this.f4492g.k(true);
            } catch (IOException e) {
                throw this.f4492g.j(e);
            }
        } catch (Throwable th) {
            this.f4492g.k(false);
            throw th;
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("AsyncTimeout.source(");
        d7.append(this.f4491f);
        d7.append(")");
        return d7.toString();
    }
}
