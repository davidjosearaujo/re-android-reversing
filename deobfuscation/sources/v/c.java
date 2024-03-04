package v;

import p.n0;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a */
    public e f6126a;

    /* renamed from: b */
    public int f6127b;

    /* renamed from: c */
    public int f6128c;

    public c(int i7, e eVar) {
        int i8;
        int a7;
        this.f6126a = eVar;
        this.f6127b = i7;
        int i9 = -1;
        if (i7 != 0) {
            e c7 = c();
            n0 n0Var = f.f6143a;
            r5.h.f(c7, "invalid");
            int[] iArr = c7.f6137i;
            int i10 = 0;
            if (iArr != null) {
                i7 = iArr[0];
            } else {
                long j5 = c7.f6135g;
                if (j5 != 0) {
                    i8 = c7.f6136h;
                } else {
                    j5 = c7.f6134f;
                    i8 = j5 != 0 ? c7.f6136h + 64 : i8;
                }
                if ((4294967295L & j5) == 0) {
                    j5 >>= 32;
                    i10 = 32;
                }
                if ((65535 & j5) == 0) {
                    i10 += 16;
                    j5 >>= 16;
                }
                if ((255 & j5) == 0) {
                    i10 += 8;
                    j5 >>= 8;
                }
                if ((15 & j5) == 0) {
                    i10 += 4;
                    j5 >>= 4;
                }
                if ((1 & j5) != 0) {
                    i9 = i10;
                } else if ((2 & j5) != 0) {
                    i9 = i10 + 1;
                } else if ((4 & j5) != 0) {
                    i9 = i10 + 2;
                } else if ((8 & j5) != 0) {
                    i9 = i10 + 3;
                }
                i7 = i8 + i9;
            }
            synchronized (f.f6144b) {
                a7 = f.e.a(i7);
            }
            i9 = a7;
        }
        this.f6128c = i9;
    }

    public void a() {
        synchronized (f.f6144b) {
            int i7 = this.f6128c;
            if (i7 >= 0) {
                f.m(i7);
                this.f6128c = -1;
            }
            f5.g gVar = f5.g.f4141a;
        }
    }

    public int b() {
        return this.f6127b;
    }

    public e c() {
        return this.f6126a;
    }

    public abstract q5.l<Object, f5.g> d();

    public abstract boolean e();

    public int f() {
        return 0;
    }

    public abstract q5.l<Object, f5.g> g();

    public abstract void h(k kVar);

    public void i(int i7) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot".toString());
    }
}
