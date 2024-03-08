package a5;

import androidx.activity.h;
import i6.d;
import i6.u;
import i6.v;
import i6.w;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l {

    /* renamed from: b  reason: collision with root package name */
    public long f195b;

    /* renamed from: c  reason: collision with root package name */
    public final int f196c;

    /* renamed from: d  reason: collision with root package name */
    public final d f197d;
    public List<m> e;

    /* renamed from: f  reason: collision with root package name */
    public final b f198f;

    /* renamed from: g  reason: collision with root package name */
    public final a f199g;

    /* renamed from: a  reason: collision with root package name */
    public long f194a = 0;

    /* renamed from: h  reason: collision with root package name */
    public final c f200h = new c();

    /* renamed from: i  reason: collision with root package name */
    public final c f201i = new c();

    /* renamed from: j  reason: collision with root package name */
    public a f202j = null;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class a implements u {

        /* renamed from: f  reason: collision with root package name */
        public final d f203f = new d();

        /* renamed from: g  reason: collision with root package name */
        public boolean f204g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f205h;

        public a() {
        }

        public final void b(boolean z6) {
            l lVar;
            long min;
            l lVar2;
            synchronized (l.this) {
                l.this.f201i.i();
                while (true) {
                    lVar = l.this;
                    if (lVar.f195b > 0 || this.f205h || this.f204g || lVar.f202j != null) {
                        break;
                    }
                    try {
                        lVar.wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                lVar.f201i.o();
                l.b(l.this);
                min = Math.min(l.this.f195b, this.f203f.f4498g);
                lVar2 = l.this;
                lVar2.f195b -= min;
            }
            lVar2.f201i.i();
            try {
                l lVar3 = l.this;
                lVar3.f197d.i(lVar3.f196c, z6 && min == this.f203f.f4498g, this.f203f, min);
            } finally {
                l.this.f201i.o();
            }
        }

        @Override // i6.u
        public final w c() {
            return l.this.f201i;
        }

        @Override // i6.u, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            synchronized (l.this) {
                if (!this.f204g) {
                    l lVar = l.this;
                    if (!lVar.f199g.f205h) {
                        if (this.f203f.f4498g > 0) {
                            while (this.f203f.f4498g > 0) {
                                b(true);
                            }
                        } else {
                            lVar.f197d.i(lVar.f196c, true, null, 0);
                        }
                    }
                    synchronized (l.this) {
                        this.f204g = true;
                    }
                    l.this.f197d.flush();
                    l.a(l.this);
                }
            }
        }

        @Override // i6.u, java.io.Flushable
        public final void flush() {
            synchronized (l.this) {
                l.b(l.this);
            }
            while (this.f203f.f4498g > 0) {
                b(false);
                l.this.f197d.flush();
            }
        }

        @Override // i6.u
        public final void h(d dVar, long j7) {
            this.f203f.h(dVar, j7);
            while (this.f203f.f4498g >= 16384) {
                b(false);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class b implements v {

        /* renamed from: f  reason: collision with root package name */
        public final d f207f = new d();

        /* renamed from: g  reason: collision with root package name */
        public final d f208g = new d();

        /* renamed from: h  reason: collision with root package name */
        public final long f209h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f210i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f211j;

        public b(long j7) {
            this.f209h = j7;
        }

        @Override // i6.v
        public final long B(d dVar, long j7) {
            if (j7 >= 0) {
                synchronized (l.this) {
                    d();
                    b();
                    d dVar2 = this.f208g;
                    long j8 = dVar2.f4498g;
                    if (j8 == 0) {
                        return -1;
                    }
                    long B = dVar2.B(dVar, Math.min(j7, j8));
                    l lVar = l.this;
                    long j9 = lVar.f194a + B;
                    lVar.f194a = j9;
                    if (j9 >= ((long) (lVar.f197d.f156r.b() / 2))) {
                        l lVar2 = l.this;
                        lVar2.f197d.m(lVar2.f196c, lVar2.f194a);
                        l.this.f194a = 0;
                    }
                    synchronized (l.this.f197d) {
                        d dVar3 = l.this.f197d;
                        long j10 = dVar3.f154p + B;
                        dVar3.f154p = j10;
                        if (j10 >= ((long) (dVar3.f156r.b() / 2))) {
                            d dVar4 = l.this.f197d;
                            dVar4.m(0, dVar4.f154p);
                            l.this.f197d.f154p = 0;
                        }
                    }
                    return B;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j7);
        }

        public final void b() {
            if (this.f210i) {
                throw new IOException("stream closed");
            } else if (l.this.f202j != null) {
                StringBuilder d7 = h.d("stream was reset: ");
                d7.append(l.this.f202j);
                throw new IOException(d7.toString());
            }
        }

        @Override // i6.v
        public final w c() {
            return l.this.f200h;
        }

        @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            synchronized (l.this) {
                this.f210i = true;
                d dVar = this.f208g;
                dVar.getClass();
                try {
                    dVar.skip(dVar.f4498g);
                    l.this.notifyAll();
                } catch (EOFException e) {
                    throw new AssertionError(e);
                }
            }
            l.a(l.this);
        }

        public final void d() {
            l.this.f200h.i();
            while (this.f208g.f4498g == 0 && !this.f211j && !this.f210i) {
                try {
                    l lVar = l.this;
                    if (lVar.f202j != null) {
                        break;
                    }
                    try {
                        lVar.wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                } finally {
                    l.this.f200h.o();
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c extends i6.c {
        public c() {
        }

        @Override // i6.c
        public final IOException m(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // i6.c
        public final void n() {
            l.this.e(a.CANCEL);
        }

        public final void o() {
            if (l()) {
                throw m(null);
            }
        }
    }

    public l(int i7, d dVar, boolean z6, boolean z7, ArrayList arrayList) {
        if (dVar != null) {
            this.f196c = i7;
            this.f197d = dVar;
            this.f195b = (long) dVar.s.b();
            b bVar = new b((long) dVar.f156r.b());
            this.f198f = bVar;
            a aVar = new a();
            this.f199g = aVar;
            bVar.f211j = z7;
            aVar.f205h = z6;
            return;
        }
        throw new NullPointerException("connection == null");
    }

    public static void a(l lVar) {
        boolean z6;
        boolean h7;
        synchronized (lVar) {
            b bVar = lVar.f198f;
            if (!bVar.f211j && bVar.f210i) {
                a aVar = lVar.f199g;
                if (aVar.f205h || aVar.f204g) {
                    z6 = true;
                    h7 = lVar.h();
                }
            }
            z6 = false;
            h7 = lVar.h();
        }
        if (z6) {
            lVar.c(a.CANCEL);
        } else if (!h7) {
            lVar.f197d.e(lVar.f196c);
        }
    }

    public static void b(l lVar) {
        a aVar = lVar.f199g;
        if (aVar.f204g) {
            throw new IOException("stream closed");
        } else if (aVar.f205h) {
            throw new IOException("stream finished");
        } else if (lVar.f202j != null) {
            StringBuilder d7 = h.d("stream was reset: ");
            d7.append(lVar.f202j);
            throw new IOException(d7.toString());
        }
    }

    public final void c(a aVar) {
        if (d(aVar)) {
            d dVar = this.f197d;
            dVar.f160w.v(this.f196c, aVar);
        }
    }

    public final boolean d(a aVar) {
        synchronized (this) {
            if (this.f202j != null) {
                return false;
            }
            if (this.f198f.f211j && this.f199g.f205h) {
                return false;
            }
            this.f202j = aVar;
            notifyAll();
            this.f197d.e(this.f196c);
            return true;
        }
    }

    public final void e(a aVar) {
        if (d(aVar)) {
            this.f197d.k(this.f196c, aVar);
        }
    }

    public final synchronized List<m> f() {
        List<m> list;
        try {
            this.f200h.i();
            while (this.e == null && this.f202j == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            }
            this.f200h.o();
            list = this.e;
            if (list == null) {
                throw new IOException("stream was reset: " + this.f202j);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    public final a g() {
        synchronized (this) {
            try {
                if (this.e == null) {
                    boolean z6 = true;
                    if (this.f197d.f146g != ((this.f196c & 1) == 1)) {
                        z6 = false;
                    }
                    if (!z6) {
                        throw new IllegalStateException("reply before requesting the sink");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f199g;
    }

    public final synchronized boolean h() {
        if (this.f202j != null) {
            return false;
        }
        b bVar = this.f198f;
        if (bVar.f211j || bVar.f210i) {
            a aVar = this.f199g;
            if (aVar.f205h || aVar.f204g) {
                if (this.e != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
