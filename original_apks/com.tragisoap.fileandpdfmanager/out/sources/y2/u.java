package y2;

import android.graphics.Bitmap;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import k3.d;
import p2.h;
import p2.j;
import r2.v;
import s2.b;
import y2.l;
import y2.r;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u implements j<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final l f6658a;

    /* renamed from: b  reason: collision with root package name */
    public final b f6659b;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a implements l.b {

        /* renamed from: a  reason: collision with root package name */
        public final t f6660a;

        /* renamed from: b  reason: collision with root package name */
        public final d f6661b;

        public a(t tVar, d dVar) {
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

    public u(l lVar, b bVar) {
        this.f6658a = lVar;
        this.f6659b = bVar;
    }

    @Override // p2.j
    public final boolean a(InputStream inputStream, h hVar) {
        this.f6658a.getClass();
        return true;
    }

    @Override // p2.j
    public final v<Bitmap> b(InputStream inputStream, int i7, int i8, h hVar) {
        boolean z6;
        t tVar;
        d dVar;
        InputStream inputStream2 = inputStream;
        if (inputStream2 instanceof t) {
            tVar = (t) inputStream2;
            z6 = false;
        } else {
            tVar = new t(inputStream2, this.f6659b);
            z6 = true;
        }
        ArrayDeque arrayDeque = d.f4694h;
        synchronized (arrayDeque) {
            try {
                dVar = (d) arrayDeque.poll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVar == null) {
            dVar = new d();
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
                try {
                    arrayDeque.offer(dVar);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z6) {
                tVar.d();
            }
            return a7;
        } catch (Throwable th3) {
            dVar.f4696g = null;
            dVar.f4695f = null;
            ArrayDeque arrayDeque2 = d.f4694h;
            synchronized (arrayDeque2) {
                try {
                    arrayDeque2.offer(dVar);
                    if (z6) {
                        tVar.d();
                    }
                    throw th3;
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
    }
}
