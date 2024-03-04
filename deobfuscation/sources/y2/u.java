package y2;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import y2.l;
import y2.r;

/* loaded from: classes.dex */
public final class u implements p2.j<InputStream, Bitmap> {

    /* renamed from: a */
    public final l f6658a;

    /* renamed from: b */
    public final s2.b f6659b;

    /* loaded from: classes.dex */
    public static class a implements l.b {

        /* renamed from: a */
        public final t f6660a;

        /* renamed from: b */
        public final k3.d f6661b;

        public a(t tVar, k3.d dVar) {
            this.f6660a = tVar;
            this.f6661b = dVar;
        }

        @Override // y2.l.b
        public final void a(Bitmap bitmap, s2.d dVar) {
            IOException iOException = this.f6661b.f4696g;
            if (iOException != null) {
                if (bitmap != null) {
                    dVar.e(bitmap);
                }
                throw iOException;
            }
        }

        @Override // y2.l.b
        public final void b() {
            t tVar = this.f6660a;
            synchronized (tVar) {
                tVar.f6654h = tVar.f6652f.length;
            }
        }
    }

    public u(l lVar, s2.b bVar) {
        this.f6658a = lVar;
        this.f6659b = bVar;
    }

    @Override // p2.j
    public final boolean a(InputStream inputStream, p2.h hVar) {
        this.f6658a.getClass();
        return true;
    }

    @Override // p2.j
    public final r2.v<Bitmap> b(InputStream inputStream, int i7, int i8, p2.h hVar) {
        boolean z6;
        t tVar;
        k3.d dVar;
        InputStream inputStream2 = inputStream;
        if (inputStream2 instanceof t) {
            tVar = (t) inputStream2;
            z6 = false;
        } else {
            z6 = true;
            tVar = new t(inputStream2, this.f6659b);
        }
        ArrayDeque arrayDeque = k3.d.f4694h;
        synchronized (arrayDeque) {
            dVar = (k3.d) arrayDeque.poll();
        }
        if (dVar == null) {
            dVar = new k3.d();
        }
        dVar.f4695f = tVar;
        k3.j jVar = new k3.j(dVar);
        a aVar = new a(tVar, dVar);
        try {
            l lVar = this.f6658a;
            d a7 = lVar.a(new r.b(lVar.f6630c, jVar, lVar.f6631d), i7, i8, hVar, aVar);
            dVar.f4696g = null;
            dVar.f4695f = null;
            synchronized (arrayDeque) {
                arrayDeque.offer(dVar);
            }
            if (z6) {
                tVar.d();
            }
            return a7;
        } catch (Throwable th) {
            dVar.f4696g = null;
            dVar.f4695f = null;
            ArrayDeque arrayDeque2 = k3.d.f4694h;
            synchronized (arrayDeque2) {
                arrayDeque2.offer(dVar);
                if (z6) {
                    tVar.d();
                }
                throw th;
            }
        }
    }
}
