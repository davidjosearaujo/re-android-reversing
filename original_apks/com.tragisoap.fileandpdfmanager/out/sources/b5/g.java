package b5;

import b5.j;
import i6.d;
import i6.f;
import i6.k;
import i6.u;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import y4.c;
import y4.e;
import y4.h;
import y4.l;
import y4.m;
import y4.o;
import y4.p;
import y4.q;
import y4.r;
import y4.s;
import y4.t;
import z4.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g {

    /* renamed from: p */
    public static final a f2411p = new a();

    /* renamed from: a */
    public final p f2412a;

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

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends t {
        @Override // y4.t
        public final long d() {
            return 0;
        }

        @Override // y4.t
        public final o e() {
            return null;
        }

        @Override // y4.t
        public final f f() {
            return new d();
        }
    }

    public g(p pVar, r rVar, boolean z6, boolean z7, boolean z8, p pVar2, m mVar, s sVar) {
        p pVar3;
        e eVar;
        HostnameVerifier hostnameVerifier;
        this.f2412a = pVar;
        this.f2418h = rVar;
        this.f2417g = z6;
        this.m = z7;
        this.f2423n = z8;
        if (pVar2 != null) {
            pVar3 = pVar2;
        } else {
            h hVar = pVar.s;
            SSLSocketFactory sSLSocketFactory = null;
            if (rVar.f6790a.f6747a.equals("https")) {
                sSLSocketFactory = pVar.f6773o;
                hostnameVerifier = pVar.f6774p;
                eVar = pVar.f6775q;
            } else {
                hostnameVerifier = null;
                eVar = null;
            }
            m mVar2 = rVar.f6790a;
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
        if ((i7 < 100 || i7 >= 200) && i7 != 204 && i7 != 304) {
            return true;
        }
        j.a aVar = j.f2428a;
        return j.a(sVar.f6803f) != -1 || "chunked".equalsIgnoreCase(sVar.c("Transfer-Encoding"));
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

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (r5.getTime() < r1.getTime()) goto L_0x016b;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.g.d():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r0 == false) goto L_0x0062;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0060, code lost:
        if (r11 != false) goto L_0x0063;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0064, code lost:
        if (r1 != false) goto L_0x0067;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0066, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006b, code lost:
        if (r10.f2412a.f6780w != false) goto L_0x006e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
        return new b5.g(r10.f2412a, r10.f2418h, r10.f2417g, r10.m, r10.f2423n, a(), (b5.m) r10.f2422l, r10.f2414c);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b5.g e(b5.n r11) {
        /*
            r10 = this;
            b5.p r0 = r10.f2413b
            c5.a r1 = r0.f2448d
            if (r1 == 0) goto L_0x000b
            java.io.IOException r1 = r11.f2437f
            r0.a(r1)
        L_0x000b:
            b5.o r0 = r0.f2447c
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003e
            int r3 = r0.f2443g
            java.util.List<java.net.InetSocketAddress> r4 = r0.f2442f
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x001d
            r3 = r1
            goto L_0x001e
        L_0x001d:
            r3 = r2
        L_0x001e:
            if (r3 != 0) goto L_0x003b
            int r3 = r0.e
            java.util.List<java.net.Proxy> r4 = r0.f2441d
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x002c
            r3 = r1
            goto L_0x002d
        L_0x002c:
            r3 = r2
        L_0x002d:
            if (r3 != 0) goto L_0x003b
            java.util.ArrayList r0 = r0.f2444h
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r0 = r2
            goto L_0x003c
        L_0x003b:
            r0 = r1
        L_0x003c:
            if (r0 == 0) goto L_0x0062
        L_0x003e:
            java.io.IOException r11 = r11.f2437f
            boolean r0 = r11 instanceof java.net.ProtocolException
            if (r0 == 0) goto L_0x0045
            goto L_0x005d
        L_0x0045:
            boolean r0 = r11 instanceof java.io.InterruptedIOException
            if (r0 == 0) goto L_0x004c
            boolean r11 = r11 instanceof java.net.SocketTimeoutException
            goto L_0x0060
        L_0x004c:
            boolean r0 = r11 instanceof javax.net.ssl.SSLHandshakeException
            if (r0 == 0) goto L_0x0059
            java.lang.Throwable r0 = r11.getCause()
            boolean r0 = r0 instanceof java.security.cert.CertificateException
            if (r0 == 0) goto L_0x0059
            goto L_0x005d
        L_0x0059:
            boolean r11 = r11 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r11 == 0) goto L_0x005f
        L_0x005d:
            r11 = r2
            goto L_0x0060
        L_0x005f:
            r11 = r1
        L_0x0060:
            if (r11 != 0) goto L_0x0063
        L_0x0062:
            r1 = r2
        L_0x0063:
            r11 = 0
            if (r1 != 0) goto L_0x0067
            return r11
        L_0x0067:
            y4.p r0 = r10.f2412a
            boolean r0 = r0.f6780w
            if (r0 != 0) goto L_0x006e
            return r11
        L_0x006e:
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

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r0 == false) goto L_0x0050;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
        if ((!(r11 instanceof java.net.ProtocolException) && !(r11 instanceof java.io.InterruptedIOException)) != false) goto L_0x0051;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0052, code lost:
        if (r2 != false) goto L_0x0055;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0054, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
        if (r10.f2412a.f6780w != false) goto L_0x005c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005b, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:
        return new b5.g(r10.f2412a, r10.f2418h, r10.f2417g, r10.m, r10.f2423n, a(), null, r10.f2414c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r1 == 1) goto L_0x0050;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b5.g f(java.io.IOException r11) {
        /*
            r10 = this;
            b5.p r0 = r10.f2413b
            c5.a r1 = r0.f2448d
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0010
            int r1 = r1.f2571g
            r0.a(r11)
            if (r1 != r2) goto L_0x0010
            goto L_0x0050
        L_0x0010:
            b5.o r0 = r0.f2447c
            if (r0 == 0) goto L_0x0041
            int r1 = r0.f2443g
            java.util.List<java.net.InetSocketAddress> r4 = r0.f2442f
            int r4 = r4.size()
            if (r1 >= r4) goto L_0x0020
            r1 = r2
            goto L_0x0021
        L_0x0020:
            r1 = r3
        L_0x0021:
            if (r1 != 0) goto L_0x003e
            int r1 = r0.e
            java.util.List<java.net.Proxy> r4 = r0.f2441d
            int r4 = r4.size()
            if (r1 >= r4) goto L_0x002f
            r1 = r2
            goto L_0x0030
        L_0x002f:
            r1 = r3
        L_0x0030:
            if (r1 != 0) goto L_0x003e
            java.util.ArrayList r0 = r0.f2444h
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r0 = r3
            goto L_0x003f
        L_0x003e:
            r0 = r2
        L_0x003f:
            if (r0 == 0) goto L_0x0050
        L_0x0041:
            boolean r0 = r11 instanceof java.net.ProtocolException
            if (r0 == 0) goto L_0x0046
            goto L_0x004a
        L_0x0046:
            boolean r11 = r11 instanceof java.io.InterruptedIOException
            if (r11 == 0) goto L_0x004c
        L_0x004a:
            r11 = r3
            goto L_0x004d
        L_0x004c:
            r11 = r2
        L_0x004d:
            if (r11 == 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r2 = r3
        L_0x0051:
            r11 = 0
            if (r2 != 0) goto L_0x0055
            return r11
        L_0x0055:
            y4.p r0 = r10.f2412a
            boolean r0 = r0.f6780w
            if (r0 != 0) goto L_0x005c
            return r11
        L_0x005c:
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

    public final boolean g(m mVar) {
        m mVar2 = this.f2418h.f6790a;
        return mVar2.f6750d.equals(mVar.f6750d) && mVar2.e == mVar.e && mVar2.f6747a.equals(mVar.f6747a);
    }

    public final void h() {
        s.a aVar;
        i iVar;
        u uVar;
        String str;
        if (this.f2424o == null) {
            if (this.f2415d == null) {
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
                                        str = value.get(0);
                                    } else {
                                        StringBuilder sb = new StringBuilder();
                                        int size = value.size();
                                        for (int i7 = 0; i7 < size; i7++) {
                                            if (i7 > 0) {
                                                sb.append("; ");
                                            }
                                            sb.append(value.get(i7));
                                        }
                                        str = sb.toString();
                                    }
                                    aVar2.f6797c.a(key, str);
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
                p.a aVar3 = b.f6935b;
                p pVar = this.f2412a;
                aVar3.getClass();
                pVar.getClass();
                System.currentTimeMillis();
                c cVar = new c(a7, null);
                if (cVar.f2375a != null) {
                    c cVar2 = a7.f6794f;
                    if (cVar2 == null) {
                        cVar2 = c.a(a7.f6792c);
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
                if (rVar2 != null) {
                    boolean z6 = !rVar2.f6791b.equals("GET");
                    p pVar2 = this.f2413b;
                    p pVar3 = this.f2412a;
                    int i8 = pVar3.f6781x;
                    int i9 = pVar3.f6782y;
                    int i10 = pVar3.f6783z;
                    boolean z7 = pVar3.f6780w;
                    pVar2.getClass();
                    try {
                        c5.a c7 = pVar2.c(i8, i9, i10, z7, z6);
                        if (c7.f2570f != null) {
                            iVar = new e(pVar2, c7.f2570f);
                        } else {
                            c7.f2568c.setSoTimeout(i9);
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            c7.f2572h.c().g((long) i9, timeUnit);
                            c7.f2573i.c().g((long) i10, timeUnit);
                            iVar = new d(pVar2, c7.f2572h, c7.f2573i);
                        }
                        synchronized (pVar2.f2446b) {
                            c7.f2571g++;
                            pVar2.f2449f = iVar;
                        }
                        this.f2415d = iVar;
                        iVar.e(this);
                        if (this.m && a0.e.w(this.f2419i.f6791b) && this.f2422l == null) {
                            j.a aVar4 = j.f2428a;
                            long a8 = j.a(a7.f6792c);
                            if (!this.f2417g) {
                                this.f2415d.a(this.f2419i);
                                uVar = this.f2415d.b(this.f2419i, a8);
                            } else if (a8 > 2147483647L) {
                                throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                            } else if (a8 != -1) {
                                this.f2415d.a(this.f2419i);
                                this.f2422l = new m((int) a8);
                                return;
                            } else {
                                uVar = new m();
                            }
                            this.f2422l = uVar;
                        }
                    } catch (IOException e7) {
                        throw new n(e7);
                    }
                } else {
                    s sVar = this.f2420j;
                    if (sVar != null) {
                        aVar = new s.a(sVar);
                        aVar.f6809a = this.f2418h;
                        aVar.c(i(this.f2414c));
                        s i11 = i(this.f2420j);
                        if (i11 != null) {
                            s.a.b("cacheResponse", i11);
                        }
                        aVar.f6816i = i11;
                    } else {
                        aVar = new s.a();
                        aVar.f6809a = this.f2418h;
                        aVar.c(i(this.f2414c));
                        aVar.f6810b = q.f6785h;
                        aVar.f6811c = 504;
                        aVar.f6812d = "Unsatisfiable Request (only-if-cached)";
                        aVar.f6814g = f2411p;
                    }
                    s a9 = aVar.a();
                    this.f2421k = a9;
                    this.f2421k = j(a9);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final s j(s sVar) {
        t tVar;
        if (!this.f2416f || !"gzip".equalsIgnoreCase(this.f2421k.c("Content-Encoding")) || (tVar = sVar.f6804g) == null) {
            return sVar;
        }
        k kVar = new k(tVar.f());
        l.a c7 = sVar.f6803f.c();
        c7.d("Content-Encoding");
        c7.d("Content-Length");
        l lVar = new l(c7);
        s.a aVar = new s.a(sVar);
        aVar.f6813f = lVar.c();
        aVar.f6814g = new k(lVar, i6.p.a(kVar));
        return aVar.a();
    }
}
