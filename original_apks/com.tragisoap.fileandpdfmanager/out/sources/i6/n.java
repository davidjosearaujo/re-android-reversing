package i6;

import androidx.activity.h;
import java.io.InputStream;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n implements v {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ w f4519f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ InputStream f4520g;

    public n(InputStream inputStream, o oVar) {
        this.f4519f = oVar;
        this.f4520g = inputStream;
    }

    @Override // i6.v
    public final long B(d dVar, long j7) {
        int i7 = (j7 > 0 ? 1 : (j7 == 0 ? 0 : -1));
        if (i7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        } else if (i7 == 0) {
            return 0;
        } else {
            this.f4519f.f();
            s p6 = dVar.p(1);
            int read = this.f4520g.read(p6.f4529a, p6.f4531c, (int) Math.min(j7, (long) (2048 - p6.f4531c)));
            if (read == -1) {
                return -1;
            }
            p6.f4531c += read;
            long j8 = (long) read;
            dVar.f4498g += j8;
            return j8;
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

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("source(");
        d7.append(this.f4520g);
        d7.append(")");
        return d7.toString();
    }
}
