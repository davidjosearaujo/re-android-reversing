package r2;

import android.os.SystemClock;
import android.util.Log;
import androidx.fragment.app.s0;
import com.bumptech.glide.g;
import com.bumptech.glide.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import l3.a;
import l3.d;
import p.p;
import p2.f;
import p2.k;
import r2.h;
import r2.m;
import r2.n;
import r2.q;
import y2.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j<R> implements h.a, Runnable, Comparable<j<?>>, a.d {
    public Object A;
    public Thread B;
    public f C;
    public f D;
    public Object E;
    public p2.a F;
    public com.bumptech.glide.load.data.d<?> G;
    public volatile h H;
    public volatile boolean I;
    public volatile boolean J;
    public boolean K;

    /* renamed from: i */
    public final d f5765i;

    /* renamed from: j */
    public final o1.d<j<?>> f5766j;
    public g m;

    /* renamed from: n */
    public f f5769n;

    /* renamed from: o */
    public i f5770o;

    /* renamed from: p */
    public p f5771p;

    /* renamed from: q */
    public int f5772q;

    /* renamed from: r */
    public int f5773r;
    public l s;

    /* renamed from: t */
    public p2.h f5774t;

    /* renamed from: u */
    public a<R> f5775u;

    /* renamed from: v */
    public int f5776v;

    /* renamed from: w */
    public int f5777w;

    /* renamed from: x */
    public int f5778x;

    /* renamed from: y */
    public long f5779y;

    /* renamed from: z */
    public boolean f5780z;

    /* renamed from: f */
    public final i<R> f5762f = new i<>();

    /* renamed from: g */
    public final ArrayList f5763g = new ArrayList();

    /* renamed from: h */
    public final d.a f5764h = new d.a();

    /* renamed from: k */
    public final c<?> f5767k = new c<>();

    /* renamed from: l */
    public final e f5768l = new e();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a<R> {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class b<Z> {

        /* renamed from: a */
        public final p2.a f5781a;

        public b(p2.a aVar) {
            j.this = r1;
            this.f5781a = aVar;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c<Z> {

        /* renamed from: a */
        public f f5783a;

        /* renamed from: b */
        public k<Z> f5784b;

        /* renamed from: c */
        public u<Z> f5785c;
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface d {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e {

        /* renamed from: a */
        public boolean f5786a;

        /* renamed from: b */
        public boolean f5787b;

        /* renamed from: c */
        public boolean f5788c;

        public final boolean a() {
            return (this.f5788c || this.f5787b) && this.f5786a;
        }
    }

    public j(d dVar, a.c cVar) {
        this.f5765i = dVar;
        this.f5766j = cVar;
    }

    @Override // r2.h.a
    public final void a() {
        n(2);
    }

    @Override // r2.h.a
    public final void b(f fVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, p2.a aVar) {
        dVar.b();
        r rVar = new r("Fetching data failed", Collections.singletonList(exc));
        Class<?> a7 = dVar.a();
        rVar.f5862g = fVar;
        rVar.f5863h = aVar;
        rVar.f5864i = a7;
        this.f5763g.add(rVar);
        if (Thread.currentThread() != this.B) {
            n(2);
        } else {
            o();
        }
    }

    @Override // r2.h.a
    public final void c(f fVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, p2.a aVar, f fVar2) {
        this.C = fVar;
        this.E = obj;
        this.G = dVar;
        this.F = aVar;
        this.D = fVar2;
        boolean z6 = false;
        if (fVar != this.f5762f.a().get(0)) {
            z6 = true;
        }
        this.K = z6;
        if (Thread.currentThread() != this.B) {
            n(3);
        } else {
            g();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(j<?> jVar) {
        j<?> jVar2 = jVar;
        int ordinal = this.f5770o.ordinal() - jVar2.f5770o.ordinal();
        return ordinal == 0 ? this.f5776v - jVar2.f5776v : ordinal;
    }

    @Override // l3.a.d
    public final d.a d() {
        return this.f5764h;
    }

    public final <Data> v<R> e(com.bumptech.glide.load.data.d<?> dVar, Data data, p2.a aVar) {
        if (data == null) {
            return null;
        }
        try {
            int i7 = k3.h.f4702b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            v<R> f7 = f(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                j("Decoded result " + f7, elapsedRealtimeNanos, null);
            }
            return f7;
        } finally {
            dVar.b();
        }
    }

    public final <Data> v<R> f(Data data, p2.a aVar) {
        t<Data, ?, R> c7 = this.f5762f.c(data.getClass());
        p2.h hVar = this.f5774t;
        boolean z6 = aVar == p2.a.RESOURCE_DISK_CACHE || this.f5762f.f5761r;
        p2.g<Boolean> gVar = l.f6625i;
        Boolean bool = (Boolean) hVar.c(gVar);
        if (bool == null || (bool.booleanValue() && !z6)) {
            hVar = new p2.h();
            hVar.f5569b.i(this.f5774t.f5569b);
            hVar.f5569b.put(gVar, Boolean.valueOf(z6));
        }
        com.bumptech.glide.load.data.e f7 = this.m.a().f(data);
        try {
            return c7.a(this.f5772q, this.f5773r, hVar, f7, new b(aVar));
        } finally {
            f7.b();
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        v vVar;
        boolean a7;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j7 = this.f5779y;
            StringBuilder d7 = androidx.activity.h.d("data: ");
            d7.append(this.E);
            d7.append(", cache key: ");
            d7.append(this.C);
            d7.append(", fetcher: ");
            d7.append(this.G);
            j("Retrieved data", j7, d7.toString());
        }
        u uVar = null;
        try {
            vVar = e(this.G, this.E, this.F);
        } catch (r e7) {
            f fVar = this.D;
            p2.a aVar = this.F;
            e7.f5862g = fVar;
            e7.f5863h = aVar;
            e7.f5864i = null;
            this.f5763g.add(e7);
            vVar = null;
        }
        if (vVar != null) {
            p2.a aVar2 = this.F;
            boolean z6 = this.K;
            if (vVar instanceof s) {
                ((s) vVar).a();
            }
            boolean z7 = false;
            if (this.f5767k.f5785c != null) {
                uVar = (u) u.f5871j.b();
                q2.a.i(uVar);
                uVar.f5875i = false;
                uVar.f5874h = true;
                uVar.f5873g = vVar;
                vVar = uVar;
            }
            k(vVar == 1 ? 1 : 0, aVar2, z6);
            this.f5777w = 5;
            c<?> cVar = this.f5767k;
            if (cVar.f5785c != null) {
                z7 = true;
            }
            if (z7) {
                d dVar = this.f5765i;
                p2.h hVar = this.f5774t;
                cVar.getClass();
                try {
                    ((m.c) dVar).a().b(cVar.f5783a, new g(cVar.f5784b, cVar.f5785c, hVar));
                    cVar.f5785c.a();
                } catch (Throwable th) {
                    cVar.f5785c.a();
                    throw th;
                }
            }
            if (uVar != null) {
                uVar.a();
            }
            e eVar = this.f5768l;
            synchronized (eVar) {
                eVar.f5787b = true;
                a7 = eVar.a();
            }
            if (a7) {
                m();
                return;
            }
            return;
        }
        o();
    }

    public final h h() {
        int a7 = p.a(this.f5777w);
        if (a7 == 1) {
            return new w(this.f5762f, this);
        }
        if (a7 == 2) {
            i<R> iVar = this.f5762f;
            return new e(iVar.a(), iVar, this);
        } else if (a7 == 3) {
            return new a0(this.f5762f, this);
        } else {
            if (a7 == 5) {
                return null;
            }
            StringBuilder d7 = androidx.activity.h.d("Unrecognized stage: ");
            d7.append(androidx.activity.h.f(this.f5777w));
            throw new IllegalStateException(d7.toString());
        }
    }

    public final int i(int i7) {
        if (i7 != 0) {
            int i8 = i7 - 1;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 == 2) {
                        return this.f5780z ? 6 : 4;
                    }
                    if (i8 == 3 || i8 == 5) {
                        return 6;
                    }
                    StringBuilder d7 = androidx.activity.h.d("Unrecognized stage: ");
                    d7.append(androidx.activity.h.f(i7));
                    throw new IllegalArgumentException(d7.toString());
                } else if (this.s.a()) {
                    return 3;
                } else {
                    return i(3);
                }
            } else if (this.s.b()) {
                return 2;
            } else {
                return i(2);
            }
        } else {
            throw null;
        }
    }

    public final void j(String str, long j7, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(k3.h.a(j7));
        sb.append(", load key: ");
        sb.append(this.f5771p);
        sb.append(str2 != null ? s0.h(", ", str2) : "");
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(v<R> vVar, p2.a aVar, boolean z6) {
        q();
        n nVar = (n) this.f5775u;
        synchronized (nVar) {
            nVar.f5833v = vVar;
            nVar.f5834w = aVar;
            nVar.D = z6;
        }
        synchronized (nVar) {
            nVar.f5820g.a();
            if (nVar.C) {
                nVar.f5833v.recycle();
                nVar.g();
            } else if (nVar.f5819f.f5844f.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else if (!nVar.f5835x) {
                n.c cVar = nVar.f5823j;
                v<?> vVar2 = nVar.f5833v;
                boolean z7 = nVar.f5830r;
                f fVar = nVar.f5829q;
                q.a aVar2 = nVar.f5821h;
                cVar.getClass();
                nVar.A = new q<>(vVar2, z7, true, fVar, aVar2);
                nVar.f5835x = true;
                n.e eVar = nVar.f5819f;
                eVar.getClass();
                ArrayList<n.d> arrayList = new ArrayList(eVar.f5844f);
                nVar.e(arrayList.size() + 1);
                f fVar2 = nVar.f5829q;
                q<?> qVar = nVar.A;
                m mVar = (m) nVar.f5824k;
                synchronized (mVar) {
                    if (qVar != null) {
                        if (qVar.f5853f) {
                            mVar.f5802g.a(fVar2, qVar);
                        }
                    }
                    androidx.appcompat.widget.l lVar = mVar.f5797a;
                    lVar.getClass();
                    Map map = (Map) (nVar.f5832u ? lVar.f964g : lVar.f963f);
                    if (nVar.equals(map.get(fVar2))) {
                        map.remove(fVar2);
                    }
                }
                for (n.d dVar : arrayList) {
                    dVar.f5843b.execute(new n.b(dVar.f5842a));
                }
                nVar.c();
            } else {
                throw new IllegalStateException("Already have resource");
            }
        }
    }

    public final void l() {
        boolean a7;
        q();
        r rVar = new r("Failed to load resource", new ArrayList(this.f5763g));
        n nVar = (n) this.f5775u;
        synchronized (nVar) {
            nVar.f5836y = rVar;
        }
        synchronized (nVar) {
            nVar.f5820g.a();
            if (nVar.C) {
                nVar.g();
            } else if (nVar.f5819f.f5844f.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else if (!nVar.f5837z) {
                nVar.f5837z = true;
                f fVar = nVar.f5829q;
                n.e eVar = nVar.f5819f;
                eVar.getClass();
                ArrayList<n.d> arrayList = new ArrayList(eVar.f5844f);
                nVar.e(arrayList.size() + 1);
                m mVar = (m) nVar.f5824k;
                synchronized (mVar) {
                    androidx.appcompat.widget.l lVar = mVar.f5797a;
                    lVar.getClass();
                    Map map = (Map) (nVar.f5832u ? lVar.f964g : lVar.f963f);
                    if (nVar.equals(map.get(fVar))) {
                        map.remove(fVar);
                    }
                }
                for (n.d dVar : arrayList) {
                    dVar.f5843b.execute(new n.a(dVar.f5842a));
                }
                nVar.c();
            } else {
                throw new IllegalStateException("Already failed once");
            }
        }
        e eVar2 = this.f5768l;
        synchronized (eVar2) {
            eVar2.f5788c = true;
            a7 = eVar2.a();
        }
        if (a7) {
            m();
        }
    }

    public final void m() {
        e eVar = this.f5768l;
        synchronized (eVar) {
            eVar.f5787b = false;
            eVar.f5786a = false;
            eVar.f5788c = false;
        }
        c<?> cVar = this.f5767k;
        cVar.f5783a = null;
        cVar.f5784b = null;
        cVar.f5785c = null;
        i<R> iVar = this.f5762f;
        iVar.f5748c = null;
        iVar.f5749d = null;
        iVar.f5757n = null;
        iVar.f5751g = null;
        iVar.f5755k = null;
        iVar.f5753i = null;
        iVar.f5758o = null;
        iVar.f5754j = null;
        iVar.f5759p = null;
        iVar.f5746a.clear();
        iVar.f5756l = false;
        iVar.f5747b.clear();
        iVar.m = false;
        this.I = false;
        this.m = null;
        this.f5769n = null;
        this.f5774t = null;
        this.f5770o = null;
        this.f5771p = null;
        this.f5775u = null;
        this.f5777w = 0;
        this.H = null;
        this.B = null;
        this.C = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.f5779y = 0;
        this.J = false;
        this.A = null;
        this.f5763g.clear();
        this.f5766j.a(this);
    }

    public final void n(int i7) {
        this.f5778x = i7;
        n nVar = (n) this.f5775u;
        (nVar.s ? nVar.f5826n : nVar.f5831t ? nVar.f5827o : nVar.m).execute(this);
    }

    public final void o() {
        this.B = Thread.currentThread();
        int i7 = k3.h.f4702b;
        this.f5779y = SystemClock.elapsedRealtimeNanos();
        boolean z6 = false;
        while (!this.J && this.H != null && !(z6 = this.H.e())) {
            this.f5777w = i(this.f5777w);
            this.H = h();
            if (this.f5777w == 4) {
                n(2);
                return;
            }
        }
        if ((this.f5777w == 6 || this.J) && !z6) {
            l();
        }
    }

    public final void p() {
        int a7 = p.a(this.f5778x);
        if (a7 == 0) {
            this.f5777w = i(1);
            this.H = h();
        } else if (a7 != 1) {
            if (a7 == 2) {
                g();
                return;
            }
            StringBuilder d7 = androidx.activity.h.d("Unrecognized run reason: ");
            d7.append(s0.m(this.f5778x));
            throw new IllegalStateException(d7.toString());
        }
        o();
    }

    public final void q() {
        Throwable th;
        this.f5764h.a();
        if (this.I) {
            if (this.f5763g.isEmpty()) {
                th = null;
            } else {
                ArrayList arrayList = this.f5763g;
                th = (Throwable) arrayList.get(arrayList.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.I = true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 1, insn: 0x0060: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:31:0x0065, block:B:29:0x0060
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    @Override // java.lang.Runnable
    public final void run() {
        /*
            r5 = this;
            java.lang.String r0 = "DecodeJob"
            com.bumptech.glide.load.data.d<?> r1 = r5.G
            boolean r2 = r5.J     // Catch: d -> 0x0013, all -> 0x0011
            if (r2 == 0) goto L_0x0015
            r5.l()     // Catch: d -> 0x0013, all -> 0x0011
            if (r1 == 0) goto L_0x0010
            r1.b()
        L_0x0010:
            return
        L_0x0011:
            r2 = move-exception
            goto L_0x001e
        L_0x0013:
            r5 = move-exception
            goto L_0x005f
        L_0x0015:
            r5.p()     // Catch: d -> 0x0013, all -> 0x0011
            if (r1 == 0) goto L_0x001d
            r1.b()
        L_0x001d:
            return
        L_0x001e:
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r0, r3)     // Catch: all -> 0x004a
            if (r3 == 0) goto L_0x004c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: all -> 0x004a
            r3.<init>()     // Catch: all -> 0x004a
            java.lang.String r4 = "DecodeJob threw unexpectedly, isCancelled: "
            r3.append(r4)     // Catch: all -> 0x004a
            boolean r4 = r5.J     // Catch: all -> 0x004a
            r3.append(r4)     // Catch: all -> 0x004a
            java.lang.String r4 = ", stage: "
            r3.append(r4)     // Catch: all -> 0x004a
            int r4 = r5.f5777w     // Catch: all -> 0x004a
            java.lang.String r4 = androidx.activity.h.f(r4)     // Catch: all -> 0x004a
            r3.append(r4)     // Catch: all -> 0x004a
            java.lang.String r3 = r3.toString()     // Catch: all -> 0x004a
            android.util.Log.d(r0, r3, r2)     // Catch: all -> 0x004a
            goto L_0x004c
        L_0x004a:
            r5 = move-exception
            goto L_0x0060
        L_0x004c:
            int r0 = r5.f5777w     // Catch: all -> 0x004a
            r3 = 5
            if (r0 == r3) goto L_0x0059
            java.util.ArrayList r0 = r5.f5763g     // Catch: all -> 0x004a
            r0.add(r2)     // Catch: all -> 0x004a
            r5.l()     // Catch: all -> 0x004a
        L_0x0059:
            boolean r5 = r5.J     // Catch: all -> 0x004a
            if (r5 != 0) goto L_0x005e
            throw r2     // Catch: all -> 0x004a
        L_0x005e:
            throw r2     // Catch: all -> 0x004a
        L_0x005f:
            throw r5     // Catch: all -> 0x004a
        L_0x0060:
            if (r1 == 0) goto L_0x0065
            r1.b()
        L_0x0065:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.j.run():void");
    }
}
