package b5;

import b5.j;
import i6.u;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import y4.l;
import y4.p;
import y4.q;
import y4.r;
import y4.s;
import y4.t;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: p */
    public static final a f2411p = new a();

    /* renamed from: a */
    public final y4.p f2412a;

    /* renamed from: b */
    public final p f2413b;

    /* renamed from: c */
    public final s f2414c;

    /* renamed from: d */
    public i f2415d;
    public long e = -1;

    /* renamed from: f */
    public boolean f2416f;

    /* renamed from: g */
    public final boolean f2417g;

    /* renamed from: h */
    public final r f2418h;

    /* renamed from: i */
    public r f2419i;

    /* renamed from: j */
    public s f2420j;

    /* renamed from: k */
    public s f2421k;

    /* renamed from: l */
    public u f2422l;
    public final boolean m;

    /* renamed from: n */
    public final boolean f2423n;

    /* renamed from: o */
    public c f2424o;

    /* loaded from: classes.dex */
    public static class a extends t {
        @Override // y4.t
        public final long d() {
            return 0L;
        }

        @Override // y4.t
        public final y4.o e() {
            return null;
        }

        @Override // y4.t
        public final i6.f f() {
            return new i6.d();
        }
    }

    public g(y4.p pVar, r rVar, boolean z6, boolean z7, boolean z8, p pVar2, m mVar, s sVar) {
        p pVar3;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        y4.e eVar;
        this.f2412a = pVar;
        this.f2418h = rVar;
        this.f2417g = z6;
        this.m = z7;
        this.f2423n = z8;
        if (pVar2 != null) {
            pVar3 = pVar2;
        } else {
            y4.h hVar = pVar.s;
            if (rVar.f6790a.f6747a.equals("https")) {
                SSLSocketFactory sSLSocketFactory2 = pVar.f6773o;
                hostnameVerifier = pVar.f6774p;
                sSLSocketFactory = sSLSocketFactory2;
                eVar = pVar.f6775q;
            } else {
                sSLSocketFactory = null;
                hostnameVerifier = null;
                eVar = null;
            }
            y4.m mVar2 = rVar.f6790a;
            pVar3 = new p(hVar, new y4.a(mVar2.f6750d, mVar2.e, pVar.f6777t, pVar.f6772n, sSLSocketFactory, hostnameVerifier, eVar, pVar.f6776r, pVar.f6766g, pVar.f6767h, pVar.f6768i, pVar.f6771l));
        }
        this.f2413b = pVar3;
        this.f2422l = mVar;
        this.f2414c = sVar;
    }

    public static boolean b(s sVar) {
        if (sVar.f6799a.f6791b.equals("HEAD")) {
            return false;
        }
        int i7 = sVar.f6801c;
        if ((i7 >= 100 && i7 < 200) || i7 == 204 || i7 == 304) {
            j.a aVar = j.f2428a;
            return j.a(sVar.f6803f) != -1 || "chunked".equalsIgnoreCase(sVar.c("Transfer-Encoding"));
        }
        return true;
    }

    public static s i(s sVar) {
        if (sVar == null || sVar.f6804g == null) {
            return sVar;
        }
        s.a d7 = sVar.d();
        d7.f6814g = null;
        return d7.a();
    }

    public final p a() {
        u uVar = this.f2422l;
        if (uVar != null) {
            z4.h.b(uVar);
        }
        s sVar = this.f2421k;
        if (sVar != null) {
            z4.h.b(sVar.f6804g);
        } else {
            this.f2413b.b(true, false, true);
        }
        return this.f2413b;
    }

    public final s c() {
        c5.a aVar;
        this.f2415d.d();
        s.a g2 = this.f2415d.g();
        g2.f6809a = this.f2419i;
        p pVar = this.f2413b;
        synchronized (pVar) {
            aVar = pVar.f2448d;
        }
        g2.e = aVar.f2569d;
        g2.f6813f.e(j.f2429b, Long.toString(this.e));
        g2.f6813f.e(j.f2430c, Long.toString(System.currentTimeMillis()));
        s a7 = g2.a();
        if (!this.f2423n) {
            s.a aVar2 = new s.a(a7);
            aVar2.f6814g = this.f2415d.f(a7);
            a7 = aVar2.a();
        }
        if ("close".equalsIgnoreCase(a7.f6799a.a("Connection")) || "close".equalsIgnoreCase(a7.c("Connection"))) {
            this.f2413b.b(true, false, false);
        }
        return a7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:456:0x0169, code lost:
        if (r5.getTime() < r1.getTime()) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:432:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:511:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 674
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.g.d():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x003c, code lost:
        if (r0 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0060, code lost:
        if (r11 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0062, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0064, code lost:
        if (r1 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0066, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x006b, code lost:
        if (r10.f2412a.f6780w != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x006d, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0089, code lost:
        return new b5.g(r10.f2412a, r10.f2418h, r10.f2417g, r10.m, r10.f2423n, a(), (b5.m) r10.f2422l, r10.f2414c);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final b5.g e(b5.n r11) {
        /*
            r10 = this;
            b5.p r0 = r10.f2413b
            c5.a r1 = r0.f2448d
            if (r1 == 0) goto Lb
            java.io.IOException r1 = r11.f2437f
            r0.a(r1)
        Lb:
            b5.o r0 = r0.f2447c
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L3e
            int r3 = r0.f2443g
            java.util.List<java.net.InetSocketAddress> r4 = r0.f2442f
            int r4 = r4.size()
            if (r3 >= r4) goto L1d
            r3 = r1
            goto L1e
        L1d:
            r3 = r2
        L1e:
            if (r3 != 0) goto L3b
            int r3 = r0.e
            java.util.List<java.net.Proxy> r4 = r0.f2441d
            int r4 = r4.size()
            if (r3 >= r4) goto L2c
            r3 = r1
            goto L2d
        L2c:
            r3 = r2
        L2d:
            if (r3 != 0) goto L3b
            java.util.ArrayList r0 = r0.f2444h
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L39
            goto L3b
        L39:
            r0 = r2
            goto L3c
        L3b:
            r0 = r1
        L3c:
            if (r0 == 0) goto L62
        L3e:
            java.io.IOException r11 = r11.f2437f
            boolean r0 = r11 instanceof java.net.ProtocolException
            if (r0 == 0) goto L45
            goto L5d
        L45:
            boolean r0 = r11 instanceof java.io.InterruptedIOException
            if (r0 == 0) goto L4c
            boolean r11 = r11 instanceof java.net.SocketTimeoutException
            goto L60
        L4c:
            boolean r0 = r11 instanceof javax.net.ssl.SSLHandshakeException
            if (r0 == 0) goto L59
            java.lang.Throwable r0 = r11.getCause()
            boolean r0 = r0 instanceof java.security.cert.CertificateException
            if (r0 == 0) goto L59
            goto L5d
        L59:
            boolean r11 = r11 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r11 == 0) goto L5f
        L5d:
            r11 = r2
            goto L60
        L5f:
            r11 = r1
        L60:
            if (r11 != 0) goto L63
        L62:
            r1 = r2
        L63:
            r11 = 0
            if (r1 != 0) goto L67
            return r11
        L67:
            y4.p r0 = r10.f2412a
            boolean r0 = r0.f6780w
            if (r0 != 0) goto L6e
            return r11
        L6e:
            b5.p r7 = r10.a()
            b5.g r11 = new b5.g
            y4.p r2 = r10.f2412a
            y4.r r3 = r10.f2418h
            boolean r4 = r10.f2417g
            boolean r5 = r10.m
            boolean r6 = r10.f2423n
            i6.u r0 = r10.f2422l
            r8 = r0
            b5.m r8 = (b5.m) r8
            y4.s r9 = r10.f2414c
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.g.e(b5.n):b5.g");
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x000d, code lost:
        if (r1 == 1) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x003f, code lost:
        if (r0 == false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x004d, code lost:
        if ((((r11 instanceof java.net.ProtocolException) || (r11 instanceof java.io.InterruptedIOException)) ? false : true) != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0050, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0052, code lost:
        if (r2 != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0054, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0059, code lost:
        if (r10.f2412a.f6780w != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x005b, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0073, code lost:
        return new b5.g(r10.f2412a, r10.f2418h, r10.f2417g, r10.m, r10.f2423n, a(), null, r10.f2414c);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final b5.g f(java.io.IOException r11) {
        /*
            r10 = this;
            b5.p r0 = r10.f2413b
            c5.a r1 = r0.f2448d
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L10
            int r1 = r1.f2571g
            r0.a(r11)
            if (r1 != r2) goto L10
            goto L50
        L10:
            b5.o r0 = r0.f2447c
            if (r0 == 0) goto L41
            int r1 = r0.f2443g
            java.util.List<java.net.InetSocketAddress> r4 = r0.f2442f
            int r4 = r4.size()
            if (r1 >= r4) goto L20
            r1 = r2
            goto L21
        L20:
            r1 = r3
        L21:
            if (r1 != 0) goto L3e
            int r1 = r0.e
            java.util.List<java.net.Proxy> r4 = r0.f2441d
            int r4 = r4.size()
            if (r1 >= r4) goto L2f
            r1 = r2
            goto L30
        L2f:
            r1 = r3
        L30:
            if (r1 != 0) goto L3e
            java.util.ArrayList r0 = r0.f2444h
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L3c
            goto L3e
        L3c:
            r0 = r3
            goto L3f
        L3e:
            r0 = r2
        L3f:
            if (r0 == 0) goto L50
        L41:
            boolean r0 = r11 instanceof java.net.ProtocolException
            if (r0 == 0) goto L46
            goto L4a
        L46:
            boolean r11 = r11 instanceof java.io.InterruptedIOException
            if (r11 == 0) goto L4c
        L4a:
            r11 = r3
            goto L4d
        L4c:
            r11 = r2
        L4d:
            if (r11 == 0) goto L50
            goto L51
        L50:
            r2 = r3
        L51:
            r11 = 0
            if (r2 != 0) goto L55
            return r11
        L55:
            y4.p r0 = r10.f2412a
            boolean r0 = r0.f6780w
            if (r0 != 0) goto L5c
            return r11
        L5c:
            b5.p r7 = r10.a()
            b5.g r11 = new b5.g
            y4.p r2 = r10.f2412a
            y4.r r3 = r10.f2418h
            boolean r4 = r10.f2417g
            boolean r5 = r10.m
            boolean r6 = r10.f2423n
            y4.s r9 = r10.f2414c
            r8 = 0
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.g.f(java.io.IOException):b5.g");
    }

    public final boolean g(y4.m mVar) {
        y4.m mVar2 = this.f2418h.f6790a;
        return mVar2.f6750d.equals(mVar.f6750d) && mVar2.e == mVar.e && mVar2.f6747a.equals(mVar.f6747a);
    }

    public final void h() {
        s.a aVar;
        i dVar;
        u b2;
        String sb;
        if (this.f2424o != null) {
            return;
        }
        if (this.f2415d != null) {
            throw new IllegalStateException();
        }
        r rVar = this.f2418h;
        rVar.getClass();
        r.a aVar2 = new r.a(rVar);
        if (rVar.a("Host") == null) {
            aVar2.f6797c.e("Host", z4.h.e(rVar.f6790a));
        }
        if (rVar.a("Connection") == null) {
            aVar2.f6797c.e("Connection", "Keep-Alive");
        }
        if (rVar.a("Accept-Encoding") == null) {
            this.f2416f = true;
            aVar2.f6797c.e("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.f2412a.m;
        if (cookieHandler != null) {
            Map<String, List<String>> d7 = j.d(aVar2.a().f6792c);
            try {
                URI uri = rVar.e;
                if (uri == null) {
                    uri = rVar.f6790a.o();
                    rVar.e = uri;
                }
                for (Map.Entry<String, List<String>> entry : cookieHandler.get(uri, d7).entrySet()) {
                    String key = entry.getKey();
                    if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                        if (!entry.getValue().isEmpty()) {
                            List<String> value = entry.getValue();
                            if (value.size() == 1) {
                                sb = value.get(0);
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                int size = value.size();
                                for (int i7 = 0; i7 < size; i7++) {
                                    if (i7 > 0) {
                                        sb2.append("; ");
                                    }
                                    sb2.append(value.get(i7));
                                }
                                sb = sb2.toString();
                            }
                            aVar2.f6797c.a(key, sb);
                        }
                    }
                }
            } catch (IllegalStateException e) {
                throw new IOException(e.getMessage());
            }
        }
        if (rVar.a("User-Agent") == null) {
            aVar2.f6797c.e("User-Agent", "okhttp/2.7.5");
        }
        r a7 = aVar2.a();
        p.a aVar3 = z4.b.f6935b;
        y4.p pVar = this.f2412a;
        aVar3.getClass();
        pVar.getClass();
        System.currentTimeMillis();
        c cVar = new c(a7, null);
        if (cVar.f2375a != null) {
            y4.c cVar2 = a7.f6794f;
            if (cVar2 == null) {
                cVar2 = y4.c.a(a7.f6792c);
                a7.f6794f = cVar2;
            }
            if (cVar2.f6695j) {
                cVar = new c(null, null);
            }
        }
        this.f2424o = cVar;
        this.f2419i = cVar.f2375a;
        this.f2420j = cVar.f2376b;
        r rVar2 = this.f2419i;
        if (rVar2 == null) {
            s sVar = this.f2420j;
            if (sVar != null) {
                aVar = new s.a(sVar);
                aVar.f6809a = this.f2418h;
                aVar.c(i(this.f2414c));
                s i8 = i(this.f2420j);
                if (i8 != null) {
                    s.a.b("cacheResponse", i8);
                }
                aVar.f6816i = i8;
            } else {
                aVar = new s.a();
                aVar.f6809a = this.f2418h;
                aVar.c(i(this.f2414c));
                aVar.f6810b = q.f6785h;
                aVar.f6811c = 504;
                aVar.f6812d = "Unsatisfiable Request (only-if-cached)";
                aVar.f6814g = f2411p;
            }
            s a8 = aVar.a();
            this.f2421k = a8;
            this.f2421k = j(a8);
            return;
        }
        boolean z6 = !rVar2.f6791b.equals("GET");
        p pVar2 = this.f2413b;
        y4.p pVar3 = this.f2412a;
        int i9 = pVar3.f6781x;
        int i10 = pVar3.f6782y;
        int i11 = pVar3.f6783z;
        boolean z7 = pVar3.f6780w;
        pVar2.getClass();
        try {
            c5.a c7 = pVar2.c(i9, i10, i11, z7, z6);
            if (c7.f2570f != null) {
                dVar = new e(pVar2, c7.f2570f);
            } else {
                c7.f2568c.setSoTimeout(i10);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                c7.f2572h.c().g(i10, timeUnit);
                c7.f2573i.c().g(i11, timeUnit);
                dVar = new d(pVar2, c7.f2572h, c7.f2573i);
            }
            synchronized (pVar2.f2446b) {
                c7.f2571g++;
                pVar2.f2449f = dVar;
            }
            this.f2415d = dVar;
            dVar.e(this);
            if (this.m && a0.e.w(this.f2419i.f6791b) && this.f2422l == null) {
                j.a aVar4 = j.f2428a;
                long a9 = j.a(a7.f6792c);
                if (!this.f2417g) {
                    this.f2415d.a(this.f2419i);
                    b2 = this.f2415d.b(this.f2419i, a9);
                } else if (a9 > 2147483647L) {
                    throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                } else {
                    if (a9 != -1) {
                        this.f2415d.a(this.f2419i);
                        this.f2422l = new m((int) a9);
                        return;
                    }
                    b2 = new m();
                }
                this.f2422l = b2;
            }
        } catch (IOException e7) {
            throw new n(e7);
        }
    }

    public final s j(s sVar) {
        t tVar;
        if (this.f2416f && "gzip".equalsIgnoreCase(this.f2421k.c("Content-Encoding")) && (tVar = sVar.f6804g) != null) {
            i6.k kVar = new i6.k(tVar.f());
            l.a c7 = sVar.f6803f.c();
            c7.d("Content-Encoding");
            c7.d("Content-Length");
            y4.l lVar = new y4.l(c7);
            s.a aVar = new s.a(sVar);
            aVar.f6813f = lVar.c();
            aVar.f6814g = new k(lVar, i6.p.a(kVar));
            return aVar.a();
        }
        return sVar;
    }
}
