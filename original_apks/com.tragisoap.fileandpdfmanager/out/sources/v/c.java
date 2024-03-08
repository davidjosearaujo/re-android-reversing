package v;

import f5.g;
import p.n0;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class c {

    /* renamed from: a */
    public e f6126a;

    /* renamed from: b */
    public int f6127b;

    /* renamed from: c */
    public int f6128c;

    public c(int i7, e eVar) {
        int i8;
        this.f6126a = eVar;
        this.f6127b = i7;
        int i9 = -1;
        if (i7 != 0) {
            e c7 = c();
            n0 n0Var = f.f6143a;
            h.f(c7, "invalid");
            int[] iArr = c7.f6137i;
            int i10 = 0;
            if (iArr != null) {
                i7 = iArr[0];
            } else {
                long j7 = c7.f6135g;
                if (j7 != 0) {
                    i8 = c7.f6136h;
                } else {
                    j7 = c7.f6134f;
                    i8 = j7 != 0 ? c7.f6136h + 64 : i8;
                }
                if ((4294967295L & j7) == 0) {
                    j7 >>= 32;
                    i10 = 32;
                }
                if ((65535 & j7) == 0) {
                    i10 += 16;
                    j7 >>= 16;
                }
                if ((255 & j7) == 0) {
                    i10 += 8;
                    j7 >>= 8;
                }
                if ((15 & j7) == 0) {
                    i10 += 4;
                    j7 >>= 4;
                }
                if ((1 & j7) != 0) {
                    i9 = i10;
                } else if ((2 & j7) != 0) {
                    i9 = i10 + 1;
                } else if ((4 & j7) != 0) {
                    i9 = i10 + 2;
                } else if ((8 & j7) != 0) {
                    i9 = i10 + 3;
                }
                i7 = i8 + i9;
            }
            synchronized (f.f6144b) {
                i9 = f.e.a(i7);
            }
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
            g gVar = g.f4141a;
        }
    }

    public int b() {
        return this.f6127b;
    }

    public e c() {
        return this.f6126a;
    }

    public abstract l<Object, g> d();

    public abstract boolean e();

    public int f() {
        return 0;
    }

    public abstract l<Object, g> g();

    public abstract void h(k kVar);

    public void i(int i7) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot".toString());
    }
}
