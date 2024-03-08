package g3;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements e, d {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4212a;

    /* renamed from: b  reason: collision with root package name */
    public final e f4213b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d f4214c;

    /* renamed from: d  reason: collision with root package name */
    public volatile d f4215d;
    public int e = 3;

    /* renamed from: f  reason: collision with root package name */
    public int f4216f = 3;

    public b(Object obj, e eVar) {
        this.f4212a = obj;
        this.f4213b = eVar;
    }

    @Override // g3.e, g3.d
    public final boolean a() {
        boolean z6;
        synchronized (this.f4212a) {
            if (!this.f4214c.a() && !this.f4215d.a()) {
                z6 = false;
            }
            z6 = true;
        }
        return z6;
    }

    @Override // g3.e
    public final void b(d dVar) {
        synchronized (this.f4212a) {
            if (dVar.equals(this.f4214c)) {
                this.e = 4;
            } else if (dVar.equals(this.f4215d)) {
                this.f4216f = 4;
            }
            e eVar = this.f4213b;
            if (eVar != null) {
                eVar.b(this);
            }
        }
    }

    @Override // g3.d
    public final boolean c() {
        boolean z6;
        synchronized (this.f4212a) {
            z6 = this.e == 3 && this.f4216f == 3;
        }
        return z6;
    }

    @Override // g3.d
    public final void clear() {
        synchronized (this.f4212a) {
            this.e = 3;
            this.f4214c.clear();
            if (this.f4216f != 3) {
                this.f4216f = 3;
                this.f4215d.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015 A[Catch: all -> 0x0038, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x0015, B:14:0x001a, B:15:0x0021, B:17:0x0029, B:24:0x0036), top: B:29:0x0003 }] */
    @Override // g3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(g3.d r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f4212a
            monitor-enter(r0)
            g3.e r1 = r5.f4213b     // Catch: all -> 0x0038
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.d(r5)     // Catch: all -> 0x0038
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = r2
            goto L_0x0013
        L_0x0012:
            r1 = r3
        L_0x0013:
            if (r1 == 0) goto L_0x0036
            int r1 = r5.e     // Catch: all -> 0x0038
            r4 = 5
            if (r1 == r4) goto L_0x0021
            g3.d r5 = r5.f4214c     // Catch: all -> 0x0038
            boolean r5 = r6.equals(r5)     // Catch: all -> 0x0038
            goto L_0x0033
        L_0x0021:
            g3.d r1 = r5.f4215d     // Catch: all -> 0x0038
            boolean r6 = r6.equals(r1)     // Catch: all -> 0x0038
            if (r6 == 0) goto L_0x0032
            int r5 = r5.f4216f     // Catch: all -> 0x0038
            r6 = 4
            if (r5 == r6) goto L_0x0030
            if (r5 != r4) goto L_0x0032
        L_0x0030:
            r5 = r3
            goto L_0x0033
        L_0x0032:
            r5 = r2
        L_0x0033:
            if (r5 == 0) goto L_0x0036
            r2 = r3
        L_0x0036:
            monitor-exit(r0)     // Catch: all -> 0x0038
            return r2
        L_0x0038:
            r5 = move-exception
            monitor-exit(r0)     // Catch: all -> 0x0038
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.b.d(g3.d):boolean");
    }

    @Override // g3.e
    public final boolean e(d dVar) {
        boolean z6;
        boolean z7;
        synchronized (this.f4212a) {
            e eVar = this.f4213b;
            z6 = false;
            if (eVar != null && !eVar.e(this)) {
                z7 = false;
                if (z7 && dVar.equals(this.f4214c)) {
                    z6 = true;
                }
            }
            z7 = true;
            if (z7) {
                z6 = true;
            }
        }
        return z6;
    }

    @Override // g3.d
    public final void f() {
        synchronized (this.f4212a) {
            if (this.e != 1) {
                this.e = 1;
                this.f4214c.f();
            }
        }
    }

    @Override // g3.d
    public final boolean g(d dVar) {
        if (!(dVar instanceof b)) {
            return false;
        }
        b bVar = (b) dVar;
        return this.f4214c.g(bVar.f4214c) && this.f4215d.g(bVar.f4215d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [g3.e] */
    /* JADX WARN: Type inference failed for: r2v4 */
    @Override // g3.e
    public final e getRoot() {
        ?? r22;
        synchronized (this.f4212a) {
            e eVar = this.f4213b;
            this = this;
            if (eVar != null) {
                r22 = eVar.getRoot();
            }
        }
        return r22;
    }

    @Override // g3.e
    public final void h(d dVar) {
        synchronized (this.f4212a) {
            if (!dVar.equals(this.f4215d)) {
                this.e = 5;
                if (this.f4216f != 1) {
                    this.f4216f = 1;
                    this.f4215d.f();
                }
                return;
            }
            this.f4216f = 5;
            e eVar = this.f4213b;
            if (eVar != null) {
                eVar.h(this);
            }
        }
    }

    @Override // g3.d
    public final boolean i() {
        boolean z6;
        synchronized (this.f4212a) {
            if (!(this.e == 4 || this.f4216f == 4)) {
                z6 = false;
            }
            z6 = true;
        }
        return z6;
    }

    @Override // g3.d
    public final boolean isRunning() {
        boolean z6;
        synchronized (this.f4212a) {
            z6 = true;
            if (!(this.e == 1 || this.f4216f == 1)) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // g3.e
    public final boolean j(d dVar) {
        boolean z6;
        synchronized (this.f4212a) {
            e eVar = this.f4213b;
            if (eVar != null && !eVar.j(this)) {
                z6 = false;
            }
            z6 = true;
        }
        return z6;
    }

    @Override // g3.d
    public final void pause() {
        synchronized (this.f4212a) {
            if (this.e == 1) {
                this.e = 2;
                this.f4214c.pause();
            }
            if (this.f4216f == 1) {
                this.f4216f = 2;
                this.f4215d.pause();
            }
        }
    }
}
