package b5;

import b5.j;
import i6.u;
import i6.v;
import i6.w;
import java.io.EOFException;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import y4.l;
import y4.q;
import y4.r;
import y4.s;

/* loaded from: classes.dex */
public final class d implements i {

    /* renamed from: a */
    public final p f2377a;

    /* renamed from: b */
    public final i6.f f2378b;

    /* renamed from: c */
    public final i6.e f2379c;

    /* renamed from: d */
    public g f2380d;
    public int e = 0;

    /* loaded from: classes.dex */
    public abstract class a implements v {

        /* renamed from: f */
        public final i6.j f2381f;

        /* renamed from: g */
        public boolean f2382g;

        public a() {
            d.this = r2;
            this.f2381f = new i6.j(r2.f2378b.c());
        }

        public final void b() {
            if (d.this.e != 5) {
                StringBuilder d7 = androidx.activity.h.d("state: ");
                d7.append(d.this.e);
                throw new IllegalStateException(d7.toString());
            }
            i6.j jVar = this.f2381f;
            w wVar = jVar.e;
            jVar.e = w.f4537d;
            wVar.a();
            wVar.b();
            d dVar = d.this;
            dVar.e = 6;
            p pVar = dVar.f2377a;
            if (pVar != null) {
                pVar.d(dVar);
            }
        }

        @Override // i6.v
        public final w c() {
            return this.f2381f;
        }

        public final void d() {
            d dVar = d.this;
            if (dVar.e == 6) {
                return;
            }
            dVar.e = 6;
            p pVar = dVar.f2377a;
            if (pVar != null) {
                pVar.b(true, false, false);
                d dVar2 = d.this;
                dVar2.f2377a.d(dVar2);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class b implements u {

        /* renamed from: f */
        public final i6.j f2384f;

        /* renamed from: g */
        public boolean f2385g;

        public b() {
            d.this = r2;
            this.f2384f = new i6.j(r2.f2379c.c());
        }

        @Override // i6.u
        public final w c() {
            return this.f2384f;
        }

        @Override // i6.u, java.io.Closeable, java.lang.AutoCloseable
        public final synchronized void close() {
            if (this.f2385g) {
                return;
            }
            this.f2385g = true;
            d.this.f2379c.Q("0\r\n\r\n");
            d dVar = d.this;
            i6.j jVar = this.f2384f;
            dVar.getClass();
            w wVar = jVar.e;
            jVar.e = w.f4537d;
            wVar.a();
            wVar.b();
            d.this.e = 3;
        }

        @Override // i6.u, java.io.Flushable
        public final synchronized void flush() {
            if (this.f2385g) {
                return;
            }
            d.this.f2379c.flush();
        }

        @Override // i6.u
        public final void h(i6.d dVar, long j5) {
            if (this.f2385g) {
                throw new IllegalStateException("closed");
            }
            if (j5 == 0) {
                return;
            }
            d.this.f2379c.g(j5);
            d.this.f2379c.Q("\r\n");
            d.this.f2379c.h(dVar, j5);
            d.this.f2379c.Q("\r\n");
        }
    }

    /* loaded from: classes.dex */
    public class c extends a {

        /* renamed from: i */
        public long f2387i;

        /* renamed from: j */
        public boolean f2388j;

        /* renamed from: k */
        public final g f2389k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar) {
            super();
            d.this = r3;
            this.f2387i = -1L;
            this.f2388j = true;
            this.f2389k = gVar;
        }

        @Override // i6.v
        public final long B(i6.d dVar, long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (this.f2382g) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f2388j) {
                    long j7 = this.f2387i;
                    if (j7 == 0 || j7 == -1) {
                        if (j7 != -1) {
                            d.this.f2378b.t();
                        }
                        try {
                            this.f2387i = d.this.f2378b.T();
                            String trim = d.this.f2378b.t().trim();
                            if (this.f2387i < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f2387i + trim + "\"");
                            }
                            if (this.f2387i == 0) {
                                this.f2388j = false;
                                g gVar = this.f2389k;
                                y4.l i7 = d.this.i();
                                CookieHandler cookieHandler = gVar.f2412a.m;
                                if (cookieHandler != null) {
                                    r rVar = gVar.f2418h;
                                    rVar.getClass();
                                    try {
                                        URI uri = rVar.e;
                                        if (uri == null) {
                                            uri = rVar.f6790a.o();
                                            rVar.e = uri;
                                        }
                                        cookieHandler.put(uri, j.d(i7));
                                    } catch (IllegalStateException e) {
                                        throw new IOException(e.getMessage());
                                    }
                                }
                                b();
                            }
                            if (!this.f2388j) {
                                return -1L;
                            }
                        } catch (NumberFormatException e7) {
                            throw new ProtocolException(e7.getMessage());
                        }
                    }
                    long B = d.this.f2378b.B(dVar, Math.min(j5, this.f2387i));
                    if (B != -1) {
                        this.f2387i -= B;
                        return B;
                    }
                    d();
                    throw new ProtocolException("unexpected end of stream");
                }
                return -1L;
            }
        }

        @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean z6;
            if (this.f2382g) {
                return;
            }
            if (this.f2388j) {
                try {
                    z6 = z4.h.i(this, 100, TimeUnit.MILLISECONDS);
                } catch (IOException unused) {
                    z6 = false;
                }
                if (!z6) {
                    d();
                }
            }
            this.f2382g = true;
        }
    }

    /* renamed from: b5.d$d */
    /* loaded from: classes.dex */
    public final class C0027d implements u {

        /* renamed from: f */
        public final i6.j f2391f;

        /* renamed from: g */
        public boolean f2392g;

        /* renamed from: h */
        public long f2393h;

        public C0027d(long j5) {
            d.this = r2;
            this.f2391f = new i6.j(r2.f2379c.c());
            this.f2393h = j5;
        }

        @Override // i6.u
        public final w c() {
            return this.f2391f;
        }

        @Override // i6.u, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f2392g) {
                return;
            }
            this.f2392g = true;
            if (this.f2393h > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            d dVar = d.this;
            i6.j jVar = this.f2391f;
            dVar.getClass();
            w wVar = jVar.e;
            jVar.e = w.f4537d;
            wVar.a();
            wVar.b();
            d.this.e = 3;
        }

        @Override // i6.u, java.io.Flushable
        public final void flush() {
            if (this.f2392g) {
                return;
            }
            d.this.f2379c.flush();
        }

        @Override // i6.u
        public final void h(i6.d dVar, long j5) {
            if (this.f2392g) {
                throw new IllegalStateException("closed");
            }
            long j7 = dVar.f4498g;
            byte[] bArr = z4.h.f6955a;
            if ((j5 | 0) < 0 || 0 > j7 || j7 - 0 < j5) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (j5 <= this.f2393h) {
                d.this.f2379c.h(dVar, j5);
                this.f2393h -= j5;
                return;
            }
            StringBuilder d7 = androidx.activity.h.d("expected ");
            d7.append(this.f2393h);
            d7.append(" bytes but received ");
            d7.append(j5);
            throw new ProtocolException(d7.toString());
        }
    }

    /* loaded from: classes.dex */
    public class e extends a {

        /* renamed from: i */
        public long f2395i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j5) {
            super();
            d.this = r3;
            this.f2395i = j5;
            if (j5 == 0) {
                b();
            }
        }

        @Override // i6.v
        public final long B(i6.d dVar, long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (this.f2382g) {
                throw new IllegalStateException("closed");
            } else {
                long j7 = this.f2395i;
                if (j7 == 0) {
                    return -1L;
                }
                long B = d.this.f2378b.B(dVar, Math.min(j7, j5));
                if (B == -1) {
                    d();
                    throw new ProtocolException("unexpected end of stream");
                }
                long j8 = this.f2395i - B;
                this.f2395i = j8;
                if (j8 == 0) {
                    b();
                }
                return B;
            }
        }

        @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            boolean z6;
            if (this.f2382g) {
                return;
            }
            if (this.f2395i != 0) {
                try {
                    z6 = z4.h.i(this, 100, TimeUnit.MILLISECONDS);
                } catch (IOException unused) {
                    z6 = false;
                }
                if (!z6) {
                    d();
                }
            }
            this.f2382g = true;
        }
    }

    /* loaded from: classes.dex */
    public class f extends a {

        /* renamed from: i */
        public boolean f2397i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f() {
            super();
            d.this = r1;
        }

        @Override // i6.v
        public final long B(i6.d dVar, long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (this.f2382g) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f2397i) {
                    return -1L;
                }
                long B = d.this.f2378b.B(dVar, j5);
                if (B == -1) {
                    this.f2397i = true;
                    b();
                    return -1L;
                }
                return B;
            }
        }

        @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f2382g) {
                return;
            }
            if (!this.f2397i) {
                d();
            }
            this.f2382g = true;
        }
    }

    public d(p pVar, i6.f fVar, i6.e eVar) {
        this.f2377a = pVar;
        this.f2378b = fVar;
        this.f2379c = eVar;
    }

    @Override // b5.i
    public final void a(r rVar) {
        c5.a aVar;
        g gVar = this.f2380d;
        if (gVar.e != -1) {
            throw new IllegalStateException();
        }
        gVar.e = System.currentTimeMillis();
        p pVar = this.f2380d.f2413b;
        synchronized (pVar) {
            aVar = pVar.f2448d;
        }
        Proxy.Type type = aVar.f2566a.f6819b.type();
        StringBuilder sb = new StringBuilder();
        sb.append(rVar.f6791b);
        sb.append(' ');
        if (!rVar.f6790a.f6747a.equals("https") && type == Proxy.Type.HTTP) {
            sb.append(rVar.f6790a);
        } else {
            sb.append(l.a(rVar.f6790a));
        }
        sb.append(" HTTP/1.1");
        k(rVar.f6792c, sb.toString());
    }

    @Override // b5.i
    public final u b(r rVar, long j5) {
        if ("chunked".equalsIgnoreCase(rVar.a("Transfer-Encoding"))) {
            if (this.e == 1) {
                this.e = 2;
                return new b();
            }
            StringBuilder d7 = androidx.activity.h.d("state: ");
            d7.append(this.e);
            throw new IllegalStateException(d7.toString());
        } else if (j5 != -1) {
            if (this.e == 1) {
                this.e = 2;
                return new C0027d(j5);
            }
            StringBuilder d8 = androidx.activity.h.d("state: ");
            d8.append(this.e);
            throw new IllegalStateException(d8.toString());
        } else {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    @Override // b5.i
    public final void c(m mVar) {
        if (this.e != 1) {
            StringBuilder d7 = androidx.activity.h.d("state: ");
            d7.append(this.e);
            throw new IllegalStateException(d7.toString());
        }
        this.e = 3;
        i6.e eVar = this.f2379c;
        mVar.getClass();
        i6.d dVar = new i6.d();
        i6.d dVar2 = mVar.f2435h;
        dVar2.d(dVar, 0L, dVar2.f4498g);
        eVar.h(dVar, dVar.f4498g);
    }

    @Override // b5.i
    public final void d() {
        this.f2379c.flush();
    }

    @Override // b5.i
    public final void e(g gVar) {
        this.f2380d = gVar;
    }

    @Override // b5.i
    public final k f(s sVar) {
        v fVar;
        if (!g.b(sVar)) {
            fVar = h(0L);
        } else if ("chunked".equalsIgnoreCase(sVar.c("Transfer-Encoding"))) {
            g gVar = this.f2380d;
            if (this.e != 4) {
                StringBuilder d7 = androidx.activity.h.d("state: ");
                d7.append(this.e);
                throw new IllegalStateException(d7.toString());
            }
            this.e = 5;
            fVar = new c(gVar);
        } else {
            j.a aVar = j.f2428a;
            long a7 = j.a(sVar.f6803f);
            if (a7 != -1) {
                fVar = h(a7);
            } else if (this.e != 4) {
                StringBuilder d8 = androidx.activity.h.d("state: ");
                d8.append(this.e);
                throw new IllegalStateException(d8.toString());
            } else {
                p pVar = this.f2377a;
                if (pVar == null) {
                    throw new IllegalStateException("streamAllocation == null");
                }
                this.e = 5;
                pVar.b(true, false, false);
                fVar = new f();
            }
        }
        return new k(sVar.f6803f, i6.p.a(fVar));
    }

    @Override // b5.i
    public final s.a g() {
        return j();
    }

    public final e h(long j5) {
        if (this.e == 4) {
            this.e = 5;
            return new e(j5);
        }
        StringBuilder d7 = androidx.activity.h.d("state: ");
        d7.append(this.e);
        throw new IllegalStateException(d7.toString());
    }

    public final y4.l i() {
        String str;
        l.a aVar = new l.a();
        while (true) {
            String t5 = this.f2378b.t();
            if (t5.length() == 0) {
                return new y4.l(aVar);
            }
            z4.b.f6935b.getClass();
            int indexOf = t5.indexOf(":", 1);
            if (indexOf != -1) {
                str = t5.substring(0, indexOf);
                t5 = t5.substring(indexOf + 1);
            } else {
                if (t5.startsWith(":")) {
                    t5 = t5.substring(1);
                }
                str = "";
            }
            aVar.b(str, t5);
        }
    }

    public final s.a j() {
        q.a a7;
        s.a aVar;
        int i7 = this.e;
        if (i7 != 1 && i7 != 3) {
            StringBuilder d7 = androidx.activity.h.d("state: ");
            d7.append(this.e);
            throw new IllegalStateException(d7.toString());
        }
        do {
            try {
                a7 = q.a.a(this.f2378b.t());
                aVar = new s.a();
                aVar.f6810b = (q) a7.f5591c;
                aVar.f6811c = a7.f5590b;
                aVar.f6812d = (String) a7.f5592d;
                aVar.f6813f = i().c();
            } catch (EOFException e7) {
                StringBuilder d8 = androidx.activity.h.d("unexpected end of stream on ");
                d8.append(this.f2377a);
                IOException iOException = new IOException(d8.toString());
                iOException.initCause(e7);
                throw iOException;
            }
        } while (a7.f5590b == 100);
        this.e = 4;
        return aVar;
    }

    public final void k(y4.l lVar, String str) {
        if (this.e != 0) {
            StringBuilder d7 = androidx.activity.h.d("state: ");
            d7.append(this.e);
            throw new IllegalStateException(d7.toString());
        }
        this.f2379c.Q(str).Q("\r\n");
        int length = lVar.f6744a.length / 2;
        for (int i7 = 0; i7 < length; i7++) {
            this.f2379c.Q(lVar.b(i7)).Q(": ").Q(lVar.d(i7)).Q("\r\n");
        }
        this.f2379c.Q("\r\n");
        this.e = 1;
    }
}
