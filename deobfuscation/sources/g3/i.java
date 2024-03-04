package g3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import i3.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import k3.e;
import k3.l;
import l3.d;
import r2.m;
import r2.r;
import r2.v;
import v2.k;

/* loaded from: classes.dex */
public final class i<R> implements d, h3.f, h {
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
    public final com.bumptech.glide.g f4222g;

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
    public final i3.b<? super R> f4230p;

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

    public i(Context context, com.bumptech.glide.g gVar, Object obj, Object obj2, Class cls, a aVar, int i7, int i8, com.bumptech.glide.i iVar, h3.g gVar2, ArrayList arrayList, e eVar, m mVar, a.C0068a c0068a) {
        e.a aVar2 = k3.e.f4697a;
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
        this.f4230p = c0068a;
        this.f4231q = aVar2;
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
        int i9 = i7;
        this.f4218b.a();
        Object obj2 = this.f4219c;
        synchronized (obj2) {
            try {
                boolean z6 = D;
                if (z6) {
                    k("Got onSizeReady in " + k3.h.a(this.f4233t));
                }
                if (this.f4235v == 3) {
                    this.f4235v = 2;
                    float f7 = this.f4225j.f4194g;
                    if (i9 != Integer.MIN_VALUE) {
                        i9 = Math.round(i9 * f7);
                    }
                    this.f4239z = i9;
                    this.A = i8 == Integer.MIN_VALUE ? i8 : Math.round(f7 * i8);
                    if (z6) {
                        k("finished setup for calling load in " + k3.h.a(this.f4233t));
                    }
                    m mVar = this.f4234u;
                    com.bumptech.glide.g gVar = this.f4222g;
                    Object obj3 = this.f4223h;
                    a<?> aVar = this.f4225j;
                    try {
                        obj = obj2;
                    } catch (Throwable th) {
                        th = th;
                        obj = obj2;
                    }
                    try {
                        this.s = mVar.b(gVar, obj3, aVar.f4203q, this.f4239z, this.A, aVar.f4209x, this.f4224i, this.m, aVar.f4195h, aVar.f4208w, aVar.f4204r, aVar.D, aVar.f4207v, aVar.f4200n, aVar.B, aVar.E, aVar.C, this, this.f4231q);
                        if (this.f4235v != 2) {
                            this.s = null;
                        }
                        if (z6) {
                            k("finished onSizeReady in " + k3.h.a(this.f4233t));
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
                }
            } catch (Throwable th4) {
                th = th4;
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

    /* JADX WARN: Removed duplicated region for block: B:127:0x002f A[Catch: all -> 0x004e, TryCatch #0 {, blocks: (B:109:0x0003, B:111:0x0007, B:113:0x0011, B:115:0x0013, B:117:0x001b, B:119:0x001f, B:121:0x0023, B:127:0x002f, B:128:0x0038, B:129:0x003a, B:133:0x0046, B:134:0x004d), top: B:138:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    @Override // g3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f4219c
            monitor-enter(r0)
            boolean r1 = r5.B     // Catch: java.lang.Throwable -> L4e
            if (r1 != 0) goto L46
            l3.d$a r1 = r5.f4218b     // Catch: java.lang.Throwable -> L4e
            r1.a()     // Catch: java.lang.Throwable -> L4e
            int r1 = r5.f4235v     // Catch: java.lang.Throwable -> L4e
            r2 = 6
            if (r1 != r2) goto L13
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            return
        L13:
            r5.d()     // Catch: java.lang.Throwable -> L4e
            r2.v<R> r1 = r5.f4232r     // Catch: java.lang.Throwable -> L4e
            r3 = 0
            if (r1 == 0) goto L1e
            r5.f4232r = r3     // Catch: java.lang.Throwable -> L4e
            goto L1f
        L1e:
            r1 = r3
        L1f:
            g3.e r3 = r5.e     // Catch: java.lang.Throwable -> L4e
            if (r3 == 0) goto L2c
            boolean r3 = r3.e(r5)     // Catch: java.lang.Throwable -> L4e
            if (r3 == 0) goto L2a
            goto L2c
        L2a:
            r3 = 0
            goto L2d
        L2c:
            r3 = 1
        L2d:
            if (r3 == 0) goto L38
            h3.g<R> r3 = r5.f4228n     // Catch: java.lang.Throwable -> L4e
            android.graphics.drawable.Drawable r4 = r5.e()     // Catch: java.lang.Throwable -> L4e
            r3.i(r4)     // Catch: java.lang.Throwable -> L4e
        L38:
            r5.f4235v = r2     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L45
            r2.m r5 = r5.f4234u
            r5.getClass()
            r2.m.e(r1)
        L45:
            return
        L46:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = "You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead."
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L4e
            throw r5     // Catch: java.lang.Throwable -> L4e
        L4e:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.i.clear():void");
    }

    public final void d() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
        this.f4218b.a();
        this.f4228n.e(this);
        m.d dVar = this.s;
        if (dVar != null) {
            synchronized (m.this) {
                dVar.f5816a.h(dVar.f5817b);
            }
            this.s = null;
        }
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
                if (this.B) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f4218b.a();
                int i8 = k3.h.f4702b;
                this.f4233t = SystemClock.elapsedRealtimeNanos();
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
                    l(new r("Received null model"), this.f4238y == null ? 5 : 3);
                    return;
                }
                int i9 = this.f4235v;
                if (i9 == 2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                boolean z6 = false;
                if (i9 == 4) {
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
                int i10 = this.f4235v;
                if (i10 == 2 || i10 == 3) {
                    e eVar = this.e;
                    if ((eVar == null || eVar.d(this)) ? true : true) {
                        this.f4228n.g(e());
                    }
                }
                if (D) {
                    k("finished run method in " + k3.h.a(this.f4233t));
                }
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
        if (dVar instanceof i) {
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
            if (i7 == i9 && i8 == i10) {
                char[] cArr = l.f4712a;
                return (obj == null ? obj2 == null : obj instanceof k ? ((k) obj).a() : obj.equals(obj2)) && cls.equals(cls2) && aVar.equals(aVar2) && iVar == iVar2 && size == size2;
            }
            return false;
        }
        return false;
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
            z6 = i7 == 2 || i7 == 3;
        }
        return z6;
    }

    public final Drawable j(int i7) {
        Resources.Theme theme = this.f4225j.f4211z;
        if (theme == null) {
            theme = this.f4221f.getTheme();
        }
        com.bumptech.glide.g gVar = this.f4222g;
        return a3.b.a(gVar, gVar, i7, theme);
    }

    public final void k(String str) {
        Log.v("GlideRequest", str + " this: " + this.f4217a);
    }

    /* JADX WARN: Removed duplicated region for block: B:245:0x008b A[Catch: all -> 0x0098, TryCatch #2 {, blocks: (B:220:0x0008, B:222:0x0011, B:224:0x0045, B:225:0x0048, B:227:0x0052, B:228:0x0055, B:277:0x00de, B:278:0x00e0, B:230:0x0059, B:232:0x005d, B:233:0x0062, B:235:0x0068, B:237:0x0078, B:239:0x007c, B:243:0x0088, B:245:0x008b, B:247:0x008f, B:255:0x009d, B:257:0x00a1, B:259:0x00a5, B:261:0x00ad, B:263:0x00b1, B:264:0x00b7, B:266:0x00bb, B:268:0x00bf, B:270:0x00c7, B:272:0x00cb, B:273:0x00d1, B:275:0x00d5, B:276:0x00d9), top: B:285:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(r2.r r6, int r7) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
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
            d7.append(k3.h.a(this.f4233t));
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
            if (!(z7 | z6)) {
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
                            if (eVar == null || eVar.j(this)) {
                                m(vVar, obj, aVar);
                                return;
                            }
                            this.f4232r = null;
                            this.f4235v = 4;
                            this.f4234u.getClass();
                            m.e(vVar);
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
