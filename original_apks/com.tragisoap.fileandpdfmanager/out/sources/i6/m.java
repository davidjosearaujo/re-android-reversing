package i6;

import androidx.activity.h;
import java.io.OutputStream;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m implements u {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ w f4517f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OutputStream f4518g;

    public m(OutputStream outputStream, o oVar) {
        this.f4517f = oVar;
        this.f4518g = outputStream;
    }

    @Override // i6.u
    public final w c() {
        return this.f4517f;
    }

    @Override // i6.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f4518g.close();
    }

    @Override // i6.u, java.io.Flushable
    public final void flush() {
        this.f4518g.flush();
    }

    @Override // i6.u
    public final void h(d dVar, long j7) {
        x.a(dVar.f4498g, 0, j7);
        while (j7 > 0) {
            this.f4517f.f();
            s sVar = dVar.f4497f;
            int min = (int) Math.min(j7, (long) (sVar.f4531c - sVar.f4530b));
            this.f4518g.write(sVar.f4529a, sVar.f4530b, min);
            int i7 = sVar.f4530b + min;
            sVar.f4530b = i7;
            long j8 = (long) min;
            j7 -= j8;
            dVar.f4498g -= j8;
            if (i7 == sVar.f4531c) {
                dVar.f4497f = sVar.a();
                t.a(sVar);
            }
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("sink(");
        d7.append(this.f4518g);
        d7.append(")");
        return d7.toString();
    }
}
