package a5;

import a5.b;
import a5.l;
import a5.s;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class d implements Closeable {

    /* renamed from: y */
    public static final ThreadPoolExecutor f144y;

    /* renamed from: f */
    public final y4.q f145f;

    /* renamed from: g */
    public final boolean f146g;

    /* renamed from: h */
    public final AbstractC0004d.a f147h;

    /* renamed from: i */
    public final HashMap f148i;

    /* renamed from: j */
    public final String f149j;

    /* renamed from: k */
    public int f150k;

    /* renamed from: l */
    public int f151l;
    public boolean m;

    /* renamed from: n */
    public final ThreadPoolExecutor f152n;

    /* renamed from: o */
    public final s.a f153o;

    /* renamed from: p */
    public long f154p;

    /* renamed from: q */
    public long f155q;

    /* renamed from: r */
    public t f156r;
    public final t s;

    /* renamed from: t */
    public boolean f157t;

    /* renamed from: u */
    public final v f158u;

    /* renamed from: v */
    public final Socket f159v;

    /* renamed from: w */
    public final a5.c f160w;

    /* renamed from: x */
    public final LinkedHashSet f161x;

    /* loaded from: classes.dex */
    public class a extends z4.d {

        /* renamed from: g */
        public final /* synthetic */ int f162g;

        /* renamed from: h */
        public final /* synthetic */ a5.a f163h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object[] objArr, int i7, a5.a aVar) {
            super("OkHttp %s stream %d", objArr);
            d.this = r1;
            this.f162g = i7;
            this.f163h = aVar;
        }

        @Override // z4.d
        public final void a() {
            try {
                d dVar = d.this;
                dVar.f160w.v(this.f162g, this.f163h);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends z4.d {

        /* renamed from: g */
        public final /* synthetic */ int f165g;

        /* renamed from: h */
        public final /* synthetic */ long f166h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object[] objArr, int i7, long j5) {
            super("OkHttp Window Update %s stream %d", objArr);
            d.this = r1;
            this.f165g = i7;
            this.f166h = j5;
        }

        @Override // z4.d
        public final void a() {
            try {
                d.this.f160w.L(this.f165g, this.f166h);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public Socket f168a;

        /* renamed from: b */
        public String f169b;

        /* renamed from: c */
        public i6.f f170c;

        /* renamed from: d */
        public i6.e f171d;
        public y4.q e = y4.q.f6786i;
    }

    /* renamed from: a5.d$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0004d {

        /* renamed from: a */
        public static final a f172a = new a();

        /* renamed from: a5.d$d$a */
        /* loaded from: classes.dex */
        public static class a extends AbstractC0004d {
        }
    }

    /* loaded from: classes.dex */
    public class e extends z4.d implements b.a {

        /* renamed from: g */
        public final a5.b f173g;

        /* loaded from: classes.dex */
        public class a extends z4.d {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object... objArr) {
                super("OkHttp %s settings", objArr);
                e.this = r1;
            }

            @Override // z4.d
            public final void a() {
                d.this.f147h.getClass();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a5.b bVar) {
            super("OkHttp %s", r3.f149j);
            d.this = r3;
            this.f173g = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // z4.d
        public final void a() {
            a5.a aVar;
            a5.a aVar2;
            a5.a aVar3;
            a5.a aVar4 = a5.a.INTERNAL_ERROR;
            try {
                try {
                    if (!d.this.f146g) {
                        this.f173g.o();
                    }
                    while (this.f173g.S(this)) {
                    }
                    aVar3 = a5.a.NO_ERROR;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    aVar = aVar4;
                    try {
                        d.this.b(aVar, aVar4);
                    } catch (IOException unused2) {
                    }
                    z4.h.b(this.f173g);
                    throw th;
                }
                try {
                    aVar4 = a5.a.CANCEL;
                    d.this.b(aVar3, aVar4);
                    aVar2 = aVar3;
                } catch (IOException unused3) {
                    aVar4 = a5.a.PROTOCOL_ERROR;
                    d dVar = d.this;
                    dVar.b(aVar4, aVar4);
                    aVar2 = dVar;
                    z4.h.b(this.f173g);
                }
                z4.h.b(this.f173g);
            } catch (Throwable th2) {
                aVar = aVar2;
                th = th2;
                d.this.b(aVar, aVar4);
                z4.h.b(this.f173g);
                throw th;
            }
        }

        public final void b(int i7, int i8, i6.f fVar, boolean z6) {
            boolean h7;
            boolean z7;
            boolean z8;
            d dVar = d.this;
            if (dVar.f145f == y4.q.f6787j && i7 != 0 && (i7 & 1) == 0) {
                dVar.getClass();
                i6.d dVar2 = new i6.d();
                long j5 = i8;
                fVar.P(j5);
                fVar.B(dVar2, j5);
                if (dVar2.f4498g == j5) {
                    dVar.f152n.execute(new h(dVar, new Object[]{dVar.f149j, Integer.valueOf(i7)}, i7, dVar2, i8, z6));
                    return;
                }
                throw new IOException(dVar2.f4498g + " != " + i8);
            }
            l d7 = dVar.d(i7);
            if (d7 == null) {
                d.this.k(i7, a5.a.INVALID_STREAM);
                fVar.skip(i8);
                return;
            }
            l.b bVar = d7.f198f;
            long j7 = i8;
            while (true) {
                if (j7 <= 0) {
                    bVar.getClass();
                    break;
                }
                synchronized (l.this) {
                    z7 = bVar.f211j;
                    z8 = bVar.f208g.f4498g + j7 > bVar.f209h;
                }
                if (z8) {
                    fVar.skip(j7);
                    l.this.e(a5.a.FLOW_CONTROL_ERROR);
                    break;
                } else if (z7) {
                    fVar.skip(j7);
                    break;
                } else {
                    long B = fVar.B(bVar.f207f, j7);
                    if (B == -1) {
                        throw new EOFException();
                    }
                    j7 -= B;
                    synchronized (l.this) {
                        i6.d dVar3 = bVar.f208g;
                        boolean z9 = dVar3.f4498g == 0;
                        dVar3.l(bVar.f207f);
                        if (z9) {
                            l.this.notifyAll();
                        }
                    }
                }
            }
            if (z6) {
                synchronized (d7) {
                    d7.f198f.f211j = true;
                    h7 = d7.h();
                    d7.notifyAll();
                }
                if (h7) {
                    return;
                }
                d7.f197d.e(d7.f196c);
            }
        }

        public final void c(int i7, i6.g gVar) {
            l[] lVarArr;
            int length = gVar.f4501f.length;
            synchronized (d.this) {
                lVarArr = (l[]) d.this.f148i.values().toArray(new l[d.this.f148i.size()]);
                d.this.m = true;
            }
            for (l lVar : lVarArr) {
                int i8 = lVar.f196c;
                if (i8 > i7) {
                    if (lVar.f197d.f146g == ((i8 & 1) == 1)) {
                        a5.a aVar = a5.a.REFUSED_STREAM;
                        synchronized (lVar) {
                            if (lVar.f202j == null) {
                                lVar.f202j = aVar;
                                lVar.notifyAll();
                            }
                        }
                        d.this.e(lVar.f196c);
                    } else {
                        continue;
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:311:0x005e A[Catch: all -> 0x0047, TryCatch #1 {all -> 0x0047, blocks: (B:296:0x003f, B:298:0x0045, B:302:0x004a, B:311:0x005e, B:312:0x0065, B:314:0x0067, B:316:0x006d, B:318:0x006f, B:320:0x0076, B:322:0x0078, B:323:0x00aa, B:325:0x00ac, B:326:0x00ad), top: B:371:0x003f }] */
        /* JADX WARN: Removed duplicated region for block: B:314:0x0067 A[Catch: all -> 0x0047, TryCatch #1 {all -> 0x0047, blocks: (B:296:0x003f, B:298:0x0045, B:302:0x004a, B:311:0x005e, B:312:0x0065, B:314:0x0067, B:316:0x006d, B:318:0x006f, B:320:0x0076, B:322:0x0078, B:323:0x00aa, B:325:0x00ac, B:326:0x00ad), top: B:371:0x003f }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void d(boolean r15, boolean r16, int r17, java.util.ArrayList r18, int r19) {
            /*
                Method dump skipped, instructions count: 292
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a5.d.e.d(boolean, boolean, int, java.util.ArrayList, int):void");
        }

        public final void e(int i7, int i8, boolean z6) {
            if (z6) {
                synchronized (d.this) {
                }
                return;
            }
            d dVar = d.this;
            d.f144y.execute(new a5.e(dVar, new Object[]{dVar.f149j, Integer.valueOf(i7), Integer.valueOf(i8)}, i7, i8));
        }

        public final void f(int i7, a5.a aVar) {
            d dVar = d.this;
            if (dVar.f145f == y4.q.f6787j && i7 != 0 && (i7 & 1) == 0) {
                dVar.f152n.execute(new i(dVar, new Object[]{dVar.f149j, Integer.valueOf(i7)}, i7, aVar));
                return;
            }
            l e = dVar.e(i7);
            if (e != null) {
                synchronized (e) {
                    if (e.f202j == null) {
                        e.f202j = aVar;
                        e.notifyAll();
                    }
                }
            }
        }

        public final void g(boolean z6, t tVar) {
            int i7;
            l[] lVarArr;
            long j5;
            int i8;
            synchronized (d.this) {
                try {
                    int b2 = d.this.s.b();
                    if (z6) {
                        t tVar2 = d.this.s;
                        tVar2.f269c = 0;
                        tVar2.f268b = 0;
                        tVar2.f267a = 0;
                        Arrays.fill(tVar2.f270d, 0);
                    }
                    t tVar3 = d.this.s;
                    tVar3.getClass();
                    int i9 = 0;
                    while (true) {
                        boolean z7 = true;
                        if (i9 >= 10) {
                            break;
                        }
                        if (((1 << i9) & tVar.f267a) == 0) {
                            z7 = false;
                        }
                        if (z7) {
                            tVar3.c(i9, tVar.a(i9), tVar.f270d[i9]);
                        }
                        i9++;
                    }
                    d dVar = d.this;
                    if (dVar.f145f == y4.q.f6787j) {
                        d.f144y.execute(new k(this, new Object[]{dVar.f149j}, tVar));
                    }
                    int b7 = d.this.s.b();
                    lVarArr = null;
                    if (b7 == -1 || b7 == b2) {
                        j5 = 0;
                    } else {
                        j5 = b7 - b2;
                        d dVar2 = d.this;
                        if (!dVar2.f157t) {
                            dVar2.f155q += j5;
                            if (j5 > 0) {
                                dVar2.notifyAll();
                            }
                            d.this.f157t = true;
                        }
                        if (!d.this.f148i.isEmpty()) {
                            lVarArr = (l[]) d.this.f148i.values().toArray(new l[d.this.f148i.size()]);
                        }
                    }
                    d.f144y.execute(new a(d.this.f149j));
                } finally {
                }
            }
            if (lVarArr == null || j5 == 0) {
                return;
            }
            for (l lVar : lVarArr) {
                synchronized (lVar) {
                    lVar.f195b += j5;
                    if (i8 > 0) {
                        lVar.notifyAll();
                    }
                }
            }
        }

        public final void h(int i7, long j5) {
            if (i7 == 0) {
                synchronized (d.this) {
                    d dVar = d.this;
                    dVar.f155q += j5;
                    dVar.notifyAll();
                }
                return;
            }
            l d7 = d.this.d(i7);
            if (d7 != null) {
                synchronized (d7) {
                    d7.f195b += j5;
                    if (j5 > 0) {
                        d7.notifyAll();
                    }
                }
            }
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = z4.h.f6955a;
        f144y = new ThreadPoolExecutor(0, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO, 60L, timeUnit, synchronousQueue, new z4.g("OkHttp FramedConnection"));
    }

    public d(c cVar) {
        y4.q qVar = y4.q.f6787j;
        this.f148i = new HashMap();
        System.nanoTime();
        this.f154p = 0L;
        this.f156r = new t();
        t tVar = new t();
        this.s = tVar;
        this.f157t = false;
        this.f161x = new LinkedHashSet();
        y4.q qVar2 = cVar.e;
        this.f145f = qVar2;
        this.f153o = s.f266a;
        this.f146g = true;
        this.f147h = AbstractC0004d.f172a;
        this.f151l = 1;
        if (qVar2 == qVar) {
            this.f151l = 3;
        }
        this.f156r.c(7, 0, 16777216);
        String str = cVar.f169b;
        this.f149j = str;
        if (qVar2 == qVar) {
            this.f158u = new o();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            String format = String.format("OkHttp %s Push Observer", str);
            byte[] bArr = z4.h.f6955a;
            this.f152n = new ThreadPoolExecutor(0, 1, 60L, timeUnit, linkedBlockingQueue, new z4.g(format));
            tVar.c(7, 0, 65535);
            tVar.c(5, 0, 16384);
        } else if (qVar2 != y4.q.f6786i) {
            throw new AssertionError(qVar2);
        } else {
            this.f158u = new u();
            this.f152n = null;
        }
        this.f155q = tVar.b();
        this.f159v = cVar.f168a;
        this.f160w = this.f158u.a(cVar.f171d, true);
        new Thread(new e(this.f158u.b(cVar.f170c, true))).start();
    }

    public final void b(a5.a aVar, a5.a aVar2) {
        int i7;
        l[] lVarArr = null;
        try {
            f(aVar);
            e = null;
        } catch (IOException e7) {
            e = e7;
        }
        synchronized (this) {
            try {
                if (!this.f148i.isEmpty()) {
                    lVarArr = (l[]) this.f148i.values().toArray(new l[this.f148i.size()]);
                    this.f148i.clear();
                    synchronized (this) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (lVarArr != null) {
            for (l lVar : lVarArr) {
                try {
                    lVar.c(aVar2);
                } catch (IOException e8) {
                    if (e != null) {
                        e = e8;
                    }
                }
            }
        }
        try {
            this.f160w.close();
        } catch (IOException e9) {
            if (e == null) {
                e = e9;
            }
        }
        try {
            this.f159v.close();
        } catch (IOException e10) {
            e = e10;
        }
        if (e != null) {
            throw e;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        b(a5.a.NO_ERROR, a5.a.CANCEL);
    }

    public final synchronized l d(int i7) {
        return (l) this.f148i.get(Integer.valueOf(i7));
    }

    public final synchronized l e(int i7) {
        l lVar;
        lVar = (l) this.f148i.remove(Integer.valueOf(i7));
        if (lVar != null && this.f148i.isEmpty()) {
            synchronized (this) {
                System.nanoTime();
            }
        }
        notifyAll();
        return lVar;
    }

    public final void f(a5.a aVar) {
        synchronized (this.f160w) {
            synchronized (this) {
                if (this.m) {
                    return;
                }
                this.m = true;
                this.f160w.I(this.f150k, aVar, z4.h.f6955a);
            }
        }
    }

    public final void flush() {
        this.f160w.flush();
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x002f, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0030, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f160w.O());
        r6 = r2;
        r8.f155q -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(int r9, boolean r10, i6.d r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            a5.c r8 = r8.f160w
            r8.H(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r4 = r8.f155q     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L30
            java.util.HashMap r2 = r8.f148i     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L56
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L56
            a5.c r4 = r8.f160w     // Catch: java.lang.Throwable -> L56
            int r4 = r4.O()     // Catch: java.lang.Throwable -> L56
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f155q     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f155q = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            a5.c r4 = r8.f160w
            if (r10 == 0) goto L51
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = r3
        L52:
            r4.H(r5, r9, r11, r2)
            goto Ld
        L56:
            r9 = move-exception
            goto L5e
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.d.i(int, boolean, i6.d, long):void");
    }

    public final void k(int i7, a5.a aVar) {
        f144y.submit(new a(new Object[]{this.f149j, Integer.valueOf(i7)}, i7, aVar));
    }

    public final void m(int i7, long j5) {
        f144y.execute(new b(new Object[]{this.f149j, Integer.valueOf(i7)}, i7, j5));
    }
}
