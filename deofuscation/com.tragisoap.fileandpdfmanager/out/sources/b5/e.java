package b5;

import a5.d;
import a5.l;
import a5.m;
import i6.g;
import i6.i;
import i6.p;
import i6.u;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import y4.l;
import y4.q;
import y4.r;
import y4.s;
import z4.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e implements i {
    public static final List<g> e;

    /* renamed from: f  reason: collision with root package name */
    public static final List<g> f2399f;

    /* renamed from: g  reason: collision with root package name */
    public static final List<g> f2400g;

    /* renamed from: h  reason: collision with root package name */
    public static final List<g> f2401h;

    /* renamed from: a  reason: collision with root package name */
    public final p f2402a;

    /* renamed from: b  reason: collision with root package name */
    public final d f2403b;

    /* renamed from: c  reason: collision with root package name */
    public g f2404c;

    /* renamed from: d  reason: collision with root package name */
    public l f2405d;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends i {
        public a(l.b bVar) {
            super(bVar);
        }

        @Override // i6.i, i6.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            e eVar = e.this;
            eVar.f2402a.d(eVar);
            super.close();
        }
    }

    static {
        g b2 = g.b("connection");
        g b7 = g.b("host");
        g b8 = g.b("keep-alive");
        g b9 = g.b("proxy-connection");
        g b10 = g.b("transfer-encoding");
        g b11 = g.b("te");
        g b12 = g.b("encoding");
        g b13 = g.b("upgrade");
        g gVar = m.e;
        g gVar2 = m.f215f;
        g gVar3 = m.f216g;
        g gVar4 = m.f217h;
        g gVar5 = m.f218i;
        g gVar6 = m.f219j;
        e = h.f(b2, b7, b8, b9, b10, gVar, gVar2, gVar3, gVar4, gVar5, gVar6);
        f2399f = h.f(b2, b7, b8, b9, b10);
        f2400g = h.f(b2, b7, b8, b9, b11, b10, b12, b13, gVar, gVar2, gVar3, gVar4, gVar5, gVar6);
        f2401h = h.f(b2, b7, b8, b9, b11, b10, b12, b13);
    }

    public e(p pVar, d dVar) {
        this.f2402a = pVar;
        this.f2403b = dVar;
    }

    @Override // b5.i
    public final void a(r rVar) {
        ArrayList arrayList;
        int i7;
        l lVar;
        if (this.f2405d == null) {
            g gVar = this.f2404c;
            if (gVar.e == -1) {
                gVar.e = System.currentTimeMillis();
                this.f2404c.getClass();
                boolean w6 = a0.e.w(rVar.f6791b);
                if (this.f2403b.f145f == q.f6787j) {
                    y4.l lVar2 = rVar.f6792c;
                    arrayList = new ArrayList((lVar2.f6744a.length / 2) + 4);
                    arrayList.add(new m(m.e, rVar.f6791b));
                    arrayList.add(new m(m.f215f, l.a(rVar.f6790a)));
                    arrayList.add(new m(m.f217h, h.e(rVar.f6790a)));
                    arrayList.add(new m(m.f216g, rVar.f6790a.f6747a));
                    int length = lVar2.f6744a.length / 2;
                    for (int i8 = 0; i8 < length; i8++) {
                        g b2 = g.b(lVar2.b(i8).toLowerCase(Locale.US));
                        if (!f2400g.contains(b2)) {
                            arrayList.add(new m(b2, lVar2.d(i8)));
                        }
                    }
                } else {
                    y4.l lVar3 = rVar.f6792c;
                    arrayList = new ArrayList((lVar3.f6744a.length / 2) + 5);
                    arrayList.add(new m(m.e, rVar.f6791b));
                    arrayList.add(new m(m.f215f, l.a(rVar.f6790a)));
                    arrayList.add(new m(m.f219j, "HTTP/1.1"));
                    arrayList.add(new m(m.f218i, h.e(rVar.f6790a)));
                    arrayList.add(new m(m.f216g, rVar.f6790a.f6747a));
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    int length2 = lVar3.f6744a.length / 2;
                    for (int i9 = 0; i9 < length2; i9++) {
                        g b7 = g.b(lVar3.b(i9).toLowerCase(Locale.US));
                        if (!e.contains(b7)) {
                            String d7 = lVar3.d(i9);
                            if (linkedHashSet.add(b7)) {
                                arrayList.add(new m(b7, d7));
                            } else {
                                int i10 = 0;
                                while (true) {
                                    if (i10 >= arrayList.size()) {
                                        break;
                                    } else if (((m) arrayList.get(i10)).f220a.equals(b7)) {
                                        arrayList.set(i10, new m(b7, ((m) arrayList.get(i10)).f221b.f() + (char) 0 + d7));
                                        break;
                                    } else {
                                        i10++;
                                    }
                                }
                            }
                        }
                    }
                }
                d dVar = this.f2403b;
                boolean z6 = !w6;
                synchronized (dVar.f160w) {
                    synchronized (dVar) {
                        if (!dVar.m) {
                            i7 = dVar.f151l;
                            dVar.f151l = i7 + 2;
                            lVar = new l(i7, dVar, z6, false, arrayList);
                            if (lVar.h()) {
                                dVar.f148i.put(Integer.valueOf(i7), lVar);
                                synchronized (dVar) {
                                }
                            }
                        } else {
                            throw new IOException("shutdown");
                        }
                    }
                    dVar.f160w.A(z6, false, i7, arrayList);
                }
                if (!w6) {
                    dVar.f160w.flush();
                }
                this.f2405d = lVar;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                lVar.f200h.g((long) this.f2404c.f2412a.f6782y, timeUnit);
                this.f2405d.f201i.g((long) this.f2404c.f2412a.f6783z, timeUnit);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // b5.i
    public final u b(r rVar, long j7) {
        return this.f2405d.g();
    }

    @Override // b5.i
    public final void c(m mVar) {
        l.a g2 = this.f2405d.g();
        mVar.getClass();
        i6.d dVar = new i6.d();
        i6.d dVar2 = mVar.f2435h;
        dVar2.d(dVar, 0, dVar2.f4498g);
        g2.h(dVar, dVar.f4498g);
    }

    @Override // b5.i
    public final void d() {
        this.f2405d.g().close();
    }

    @Override // b5.i
    public final void e(g gVar) {
        this.f2404c = gVar;
    }

    @Override // b5.i
    public final k f(s sVar) {
        return new k(sVar.f6803f, p.a(new a(this.f2405d.f198f)));
    }

    @Override // b5.i
    public final s.a g() {
        q qVar = q.f6787j;
        q qVar2 = this.f2403b.f145f;
        List<m> f7 = this.f2405d.f();
        String str = null;
        if (qVar2 == qVar) {
            ArrayList arrayList = new ArrayList(20);
            int size = f7.size();
            for (int i7 = 0; i7 < size; i7++) {
                g gVar = f7.get(i7).f220a;
                String f8 = f7.get(i7).f221b.f();
                if (gVar.equals(m.f214d)) {
                    str = f8;
                } else if (!f2401h.contains(gVar)) {
                    String f9 = gVar.f();
                    l.a.c(f9, f8);
                    arrayList.add(f9);
                    arrayList.add(f8.trim());
                }
            }
            if (str != null) {
                q.a a7 = q.a.a("HTTP/1.1 " + str);
                s.a aVar = new s.a();
                aVar.f6810b = qVar;
                aVar.f6811c = a7.f5590b;
                aVar.f6812d = (String) a7.f5592d;
                l.a aVar2 = new l.a();
                Collections.addAll(aVar2.f6745a, (String[]) arrayList.toArray(new String[arrayList.size()]));
                aVar.f6813f = aVar2;
                return aVar;
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
        ArrayList arrayList2 = new ArrayList(20);
        int size2 = f7.size();
        String str2 = "HTTP/1.1";
        for (int i8 = 0; i8 < size2; i8++) {
            g gVar2 = f7.get(i8).f220a;
            String f10 = f7.get(i8).f221b.f();
            int i9 = 0;
            while (i9 < f10.length()) {
                int indexOf = f10.indexOf(0, i9);
                if (indexOf == -1) {
                    indexOf = f10.length();
                }
                String substring = f10.substring(i9, indexOf);
                if (gVar2.equals(m.f214d)) {
                    str = substring;
                } else if (gVar2.equals(m.f219j)) {
                    str2 = substring;
                } else if (!f2399f.contains(gVar2)) {
                    String f11 = gVar2.f();
                    l.a.c(f11, substring);
                    arrayList2.add(f11);
                    arrayList2.add(substring.trim());
                }
                i9 = indexOf + 1;
            }
        }
        if (str != null) {
            q.a a8 = q.a.a(str2 + " " + str);
            s.a aVar3 = new s.a();
            aVar3.f6810b = q.f6786i;
            aVar3.f6811c = a8.f5590b;
            aVar3.f6812d = (String) a8.f5592d;
            l.a aVar4 = new l.a();
            Collections.addAll(aVar4.f6745a, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            aVar3.f6813f = aVar4;
            return aVar3;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }
}