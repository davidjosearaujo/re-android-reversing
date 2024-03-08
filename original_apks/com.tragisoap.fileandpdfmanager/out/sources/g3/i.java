package g3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.g;
import h3.f;
import i3.a;
import i3.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import k3.e;
import k3.h;
import k3.l;
import l3.d;
import r2.m;
import r2.r;
import r2.v;
import v2.k;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i<R> implements d, f, h {
    public static final boolean D = Log.isLoggable("GlideRequest", 2);
    public int A;
    public boolean B;
    public RuntimeException C;

    /* renamed from: a */
    public final String f4217a;

    /* renamed from: b */
    public final d.a f4218b;

    /* renamed from: c */
    public final Object f4219c;

    /* renamed from: d */
    public final f<R> f4220d;
    public final e e;

    /* renamed from: f */
    public final Context f4221f;

    /* renamed from: g */
    public final g f4222g;

    /* renamed from: h */
    public final Object f4223h;

    /* renamed from: i */
    public final Class<R> f4224i;

    /* renamed from: j */
    public final a<?> f4225j;

    /* renamed from: k */
    public final int f4226k;

    /* renamed from: l */
    public final int f4227l;
    public final com.bumptech.glide.i m;

    /* renamed from: n */
    public final h3.g<R> f4228n;

    /* renamed from: o */
    public final List<f<R>> f4229o;

    /* renamed from: p */
    public final b<? super R> f4230p;

    /* renamed from: q */
    public final Executor f4231q;

    /* renamed from: r */
    public v<R> f4232r;
    public m.d s;

    /* renamed from: t */
    public long f4233t;

    /* renamed from: u */
    public volatile m f4234u;

    /* renamed from: v */
    public int f4235v;

    /* renamed from: w */
    public Drawable f4236w;

    /* renamed from: x */
    public Drawable f4237x;

    /* renamed from: y */
    public Drawable f4238y;

    /* renamed from: z */
    public int f4239z;

    public i(Context context, g gVar, Object obj, Object obj2, Class cls, a aVar, int i7, int i8, com.bumptech.glide.i iVar, h3.g gVar2, ArrayList arrayList, e eVar, m mVar, a.C0068a aVar2) {
        e.a aVar3 = e.f4697a;
        this.f4217a = D ? String.valueOf(hashCode()) : null;
        this.f4218b = new d.a();
        this.f4219c = obj;
        this.f4221f = context;
        this.f4222g = gVar;
        this.f4223h = obj2;
        this.f4224i = cls;
        this.f4225j = aVar;
        this.f4226k = i7;
        this.f4227l = i8;
        this.m = iVar;
        this.f4228n = gVar2;
        this.f4220d = null;
        this.f4229o = arrayList;
        this.e = eVar;
        this.f4234u = mVar;
        this.f4230p = aVar2;
        this.f4231q = aVar3;
        this.f4235v = 1;
        if (this.C == null && gVar.f2637h.f2640a.containsKey(com.bumptech.glide.e.class)) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // g3.d
    public final boolean a() {
        boolean z6;
        synchronized (this.f4219c) {
            z6 = this.f4235v == 4;
        }
        return z6;
    }

    @Override // h3.f
    public final void b(int i7, int i8) {
        Object obj;
        Throwable th;
        int i9 = i7;
        this.f4218b.a();
        Object obj2 = this.f4219c;
        synchronized (obj2) {
            try {
                boolean z6 = D;
                if (z6) {
                    k("Got onSizeReady in " + h.a(this.f4233t));
                }
                if (this.f4235v == 3) {
                    this.f4235v = 2;
                    float f7 = this.f4225j.f4194g;
                    if (i9 != Integer.MIN_VALUE) {
                        i9 = Math.round(((float) i9) * f7);
                    }
                    this.f4239z = i9;
                    this.A = i8 == Integer.MIN_VALUE ? i8 : Math.round(f7 * ((float) i8));
                    if (z6) {
                        k("finished setup for calling load in " + h.a(this.f4233t));
                    }
                    m mVar = this.f4234u;
                    g gVar = this.f4222g;
                    Object obj3 = this.f4223h;
                    a<?> aVar = this.f4225j;
                    try {
                        obj = obj2;
                        try {
                            this.s = mVar.b(gVar, obj3, aVar.f4203q, this.f4239z, this.A, aVar.f4209x, this.f4224i, this.m, aVar.f4195h, aVar.f4208w, aVar.f4204r, aVar.D, aVar.f4207v, aVar.f4200n, aVar.B, aVar.E, aVar.C, this, this.f4231q);
                            if (this.f4235v != 2) {
                                this.s = null;
                            }
                            if (z6) {
                                k("finished onSizeReady in " + h.a(this.f4233t));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            while (true) {
                                try {
                                    break;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = obj2;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                obj = obj2;
            }
        }
    }

    @Override // g3.d
    public final boolean c() {
        boolean z6;
        synchronized (this.f4219c) {
            z6 = this.f4235v == 6;
        }
        return z6;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002f A[Catch: all -> 0x004e, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0011, B:10:0x0013, B:12:0x001b, B:14:0x001f, B:16:0x0023, B:22:0x002f, B:23:0x0038, B:24:0x003a, B:28:0x0046, B:29:0x004d), top: B:33:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // g3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f4219c
            monitor-enter(r0)
            boolean r1 = r5.B     // Catch: all -> 0x004e
            if (r1 != 0) goto L_0x0046
            l3.d$a r1 = r5.f4218b     // Catch: all -> 0x004e
            r1.a()     // Catch: all -> 0x004e
            int r1 = r5.f4235v     // Catch: all -> 0x004e
            r2 = 6
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch: all -> 0x004e
            return
        L_0x0013:
            r5.d()     // Catch: all -> 0x004e
            r2.v<R> r1 = r5.f4232r     // Catch: all -> 0x004e
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r5.f4232r = r3     // Catch: all -> 0x004e
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            g3.e r3 = r5.e     // Catch: all -> 0x004e
            if (r3 == 0) goto L_0x002c
            boolean r3 = r3.e(r5)     // Catch: all -> 0x004e
            if (r3 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r3 = 0
            goto L_0x002d
        L_0x002c:
            r3 = 1
        L_0x002d:
            if (r3 == 0) goto L_0x0038
            h3.g<R> r3 = r5.f4228n     // Catch: all -> 0x004e
            android.graphics.drawable.Drawable r4 = r5.e()     // Catch: all -> 0x004e
            r3.i(r4)     // Catch: all -> 0x004e
        L_0x0038:
            r5.f4235v = r2     // Catch: all -> 0x004e
            monitor-exit(r0)     // Catch: all -> 0x004e
            if (r1 == 0) goto L_0x0045
            r2.m r5 = r5.f4234u
            r5.getClass()
            r2.m.e(r1)
        L_0x0045:
            return
        L_0x0046:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: all -> 0x004e
            java.lang.String r1 = "You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead."
            r5.<init>(r1)     // Catch: all -> 0x004e
            throw r5     // Catch: all -> 0x004e
        L_0x004e:
            r5 = move-exception
            monitor-exit(r0)     // Catch: all -> 0x004e
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.i.clear():void");
    }

    public final void d() {
        if (!this.B) {
            this.f4218b.a();
            this.f4228n.e(this);
            m.d dVar = this.s;
            if (dVar != null) {
                synchronized (m.this) {
                    dVar.f5816a.h(dVar.f5817b);
                }
                this.s = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    public final Drawable e() {
        int i7;
        if (this.f4237x == null) {
            a<?> aVar = this.f4225j;
            Drawable drawable = aVar.f4199l;
            this.f4237x = drawable;
            if (drawable == null && (i7 = aVar.m) > 0) {
                this.f4237x = j(i7);
            }
        }
        return this.f4237x;
    }

    @Override // g3.d
    public final void f() {
        int i7;
        synchronized (this.f4219c) {
            try {
                if (!this.B) {
                    this.f4218b.a();
                    int i8 = h.f4702b;
                    this.f4233t = SystemClock.elapsedRealtimeNanos();
                    int i9 = 3;
                    if (this.f4223h == null) {
                        if (l.i(this.f4226k, this.f4227l)) {
                            this.f4239z = this.f4226k;
                            this.A = this.f4227l;
                        }
                        if (this.f4238y == null) {
                            a<?> aVar = this.f4225j;
                            Drawable drawable = aVar.f4205t;
                            this.f4238y = drawable;
                            if (drawable == null && (i7 = aVar.f4206u) > 0) {
                                this.f4238y = j(i7);
                            }
                        }
                        if (this.f4238y == null) {
                            i9 = 5;
                        }
                        l(new r("Received null model"), i9);
                        return;
                    }
                    int i10 = this.f4235v;
                    if (i10 != 2) {
                        boolean z6 = false;
                        if (i10 == 4) {
                            n(this.f4232r, p2.a.MEMORY_CACHE, false);
                            return;
                        }
                        List<f<R>> list = this.f4229o;
                        if (list != null) {
                            for (f<R> fVar : list) {
                                if (fVar instanceof c) {
                                    ((c) fVar).getClass();
                                }
                            }
                        }
                        this.f4235v = 3;
                        if (l.i(this.f4226k, this.f4227l)) {
                            b(this.f4226k, this.f4227l);
                        } else {
                            this.f4228n.f(this);
                        }
                        int i11 = this.f4235v;
                        if (i11 == 2 || i11 == 3) {
                            e eVar = this.e;
                            if (eVar == null || eVar.d(this)) {
                                z6 = true;
                            }
                            if (z6) {
                                this.f4228n.g(e());
                            }
                        }
                        if (D) {
                            k("finished run method in " + h.a(this.f4233t));
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // g3.d
    public final boolean g(d dVar) {
        int i7;
        int i8;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        com.bumptech.glide.i iVar;
        int size;
        int i9;
        int i10;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        com.bumptech.glide.i iVar2;
        int size2;
        if (!(dVar instanceof i)) {
            return false;
        }
        synchronized (this.f4219c) {
            i7 = this.f4226k;
            i8 = this.f4227l;
            obj = this.f4223h;
            cls = this.f4224i;
            aVar = this.f4225j;
            iVar = this.m;
            List<f<R>> list = this.f4229o;
            size = list != null ? list.size() : 0;
        }
        i iVar3 = (i) dVar;
        synchronized (iVar3.f4219c) {
            i9 = iVar3.f4226k;
            i10 = iVar3.f4227l;
            obj2 = iVar3.f4223h;
            cls2 = iVar3.f4224i;
            aVar2 = iVar3.f4225j;
            iVar2 = iVar3.m;
            List<f<R>> list2 = iVar3.f4229o;
            size2 = list2 != null ? list2.size() : 0;
        }
        if (i7 != i9 || i8 != i10) {
            return false;
        }
        char[] cArr = l.f4712a;
        return (obj == null ? obj2 == null : obj instanceof k ? ((k) obj).a() : obj.equals(obj2)) && cls.equals(cls2) && aVar.equals(aVar2) && iVar == iVar2 && size == size2;
    }

    public final boolean h() {
        e eVar = this.e;
        return eVar == null || !eVar.getRoot().a();
    }

    @Override // g3.d
    public final boolean i() {
        boolean z6;
        synchronized (this.f4219c) {
            z6 = this.f4235v == 4;
        }
        return z6;
    }

    @Override // g3.d
    public final boolean isRunning() {
        boolean z6;
        synchronized (this.f4219c) {
            int i7 = this.f4235v;
            if (!(i7 == 2 || i7 == 3)) {
                z6 = false;
            }
            z6 = true;
        }
        return z6;
    }

    public final Drawable j(int i7) {
        Resources.Theme theme = this.f4225j.f4211z;
        if (theme == null) {
            theme = this.f4221f.getTheme();
        }
        g gVar = this.f4222g;
        return a3.b.a(gVar, gVar, i7, theme);
    }

    public final void k(String str) {
        Log.v("GlideRequest", str + " this: " + this.f4217a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008b A[Catch: all -> 0x0098, TryCatch #2 {, blocks: (B:4:0x0008, B:6:0x0011, B:8:0x0045, B:9:0x0048, B:11:0x0052, B:12:0x0055, B:59:0x00de, B:60:0x00e0, B:14:0x0059, B:16:0x005d, B:17:0x0062, B:19:0x0068, B:21:0x0078, B:23:0x007c, B:27:0x0088, B:29:0x008b, B:31:0x008f, B:37:0x009d, B:39:0x00a1, B:41:0x00a5, B:43:0x00ad, B:45:0x00b1, B:46:0x00b7, B:48:0x00bb, B:50:0x00bf, B:52:0x00c7, B:54:0x00cb, B:55:0x00d1, B:57:0x00d5, B:58:0x00d9), top: B:65:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(r2.r r6, int r7) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.i.l(r2.r, int):void");
    }

    public final void m(v vVar, Object obj, p2.a aVar) {
        boolean z6;
        h();
        this.f4235v = 4;
        this.f4232r = vVar;
        if (this.f4222g.f2638i <= 3) {
            StringBuilder d7 = androidx.activity.h.d("Finished loading ");
            d7.append(obj.getClass().getSimpleName());
            d7.append(" from ");
            d7.append(aVar);
            d7.append(" for ");
            d7.append(this.f4223h);
            d7.append(" with size [");
            d7.append(this.f4239z);
            d7.append("x");
            d7.append(this.A);
            d7.append("] in ");
            d7.append(h.a(this.f4233t));
            d7.append(" ms");
            Log.d("Glide", d7.toString());
        }
        e eVar = this.e;
        if (eVar != null) {
            eVar.b(this);
        }
        boolean z7 = true;
        this.B = true;
        try {
            List<f<R>> list = this.f4229o;
            if (list != null) {
                z6 = false;
                for (f<R> fVar : list) {
                    z6 |= fVar.a();
                }
            } else {
                z6 = false;
            }
            f<R> fVar2 = this.f4220d;
            if (fVar2 == null || !fVar2.a()) {
                z7 = false;
            }
            if (!z7 && !z6) {
                this.f4230p.getClass();
                this.f4228n.j(obj);
            }
        } finally {
            this.B = false;
        }
    }

    public final void n(v<?> vVar, p2.a aVar, boolean z6) {
        Throwable th;
        this.f4218b.a();
        v<?> vVar2 = null;
        try {
            synchronized (this.f4219c) {
                try {
                    this.s = null;
                    if (vVar == null) {
                        l(new r("Expected to receive a Resource<R> with an object of " + this.f4224i + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = vVar.get();
                    try {
                        if (obj != null && this.f4224i.isAssignableFrom(obj.getClass())) {
                            e eVar = this.e;
                            if (!(eVar == null || eVar.j(this))) {
                                this.f4232r = null;
                                this.f4235v = 4;
                                this.f4234u.getClass();
                                m.e(vVar);
                            }
                            m(vVar, obj, aVar);
                            return;
                        }
                        this.f4232r = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.f4224i);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(vVar);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        l(new r(sb.toString()), 5);
                        this.f4234u.getClass();
                        m.e(vVar);
                    } catch (Throwable th2) {
                        th = th2;
                        vVar2 = vVar;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            if (vVar2 != null) {
                this.f4234u.getClass();
                m.e(vVar2);
            }
            throw th4;
        }
    }

    @Override // g3.d
    public final void pause() {
        synchronized (this.f4219c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public final String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.f4219c) {
            obj = this.f4223h;
            cls = this.f4224i;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
