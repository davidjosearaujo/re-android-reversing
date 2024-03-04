package i6;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class n implements v {

    /* renamed from: f */
    public final /* synthetic */ w f4519f;

    /* renamed from: g */
    public final /* synthetic */ InputStream f4520g;

    public n(InputStream inputStream, o oVar) {
        this.f4519f = oVar;
        this.f4520g = inputStream;
    }

    @Override // i6.v
    public final long B(d dVar, long j5) {
        int i7 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
        if (i7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (i7 == 0) {
            return 0L;
        } else {
            this.f4519f.f();
            s p6 = dVar.p(1);
            int read = this.f4520g.read(p6.f4529a, p6.f4531c, (int) Math.min(j5, 2048 - p6.f4531c));
            if (read == -1) {
                return -1L;
            }
            p6.f4531c += read;
            long j7 = read;
            dVar.f4498g += j7;
            return j7;
        }
    }

    @Override // i6.v
    public final w c() {
        return this.f4519f;
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f4520g.close();
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("source(");
        d7.append(this.f4520g);
        d7.append(")");
        return d7.toString();
    }
}
