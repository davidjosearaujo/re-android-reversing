package g3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.i;
import g3.a;
import j3.c;
import k3.b;
import p2.f;
import p2.g;
import p2.h;
import r2.l;
import y2.e;
import y2.k;
import y2.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean E;

    /* renamed from: f */
    public int f4193f;

    /* renamed from: j */
    public Drawable f4197j;

    /* renamed from: k */
    public int f4198k;

    /* renamed from: l */
    public Drawable f4199l;
    public int m;

    /* renamed from: r */
    public boolean f4204r;

    /* renamed from: t */
    public Drawable f4205t;

    /* renamed from: u */
    public int f4206u;

    /* renamed from: y */
    public boolean f4210y;

    /* renamed from: z */
    public Resources.Theme f4211z;

    /* renamed from: g */
    public float f4194g = 1.0f;

    /* renamed from: h */
    public l f4195h = l.f5795c;

    /* renamed from: i */
    public i f4196i = i.NORMAL;

    /* renamed from: n */
    public boolean f4200n = true;

    /* renamed from: o */
    public int f4201o = -1;

    /* renamed from: p */
    public int f4202p = -1;

    /* renamed from: q */
    public f f4203q = c.f4578b;
    public boolean s = true;

    /* renamed from: v */
    public h f4207v = new h();

    /* renamed from: w */
    public b f4208w = new b();

    /* renamed from: x */
    public Class<?> f4209x = Object.class;
    public boolean D = true;

    public static boolean e(int i7, int i8) {
        return (i7 & i8) != 0;
    }

    public T a(a<?> aVar) {
        if (this.A) {
            return (T) clone().a(aVar);
        }
        if (e(aVar.f4193f, 2)) {
            this.f4194g = aVar.f4194g;
        }
        if (e(aVar.f4193f, 262144)) {
            this.B = aVar.B;
        }
        if (e(aVar.f4193f, 1048576)) {
            this.E = aVar.E;
        }
        if (e(aVar.f4193f, 4)) {
            this.f4195h = aVar.f4195h;
        }
        if (e(aVar.f4193f, 8)) {
            this.f4196i = aVar.f4196i;
        }
        if (e(aVar.f4193f, 16)) {
            this.f4197j = aVar.f4197j;
            this.f4198k = 0;
            this.f4193f &= -33;
        }
        if (e(aVar.f4193f, 32)) {
            this.f4198k = aVar.f4198k;
            this.f4197j = null;
            this.f4193f &= -17;
        }
        if (e(aVar.f4193f, 64)) {
            this.f4199l = aVar.f4199l;
            this.m = 0;
            this.f4193f &= -129;
        }
        if (e(aVar.f4193f, 128)) {
            this.m = aVar.m;
            this.f4199l = null;
            this.f4193f &= -65;
        }
        if (e(aVar.f4193f, 256)) {
            this.f4200n = aVar.f4200n;
        }
        if (e(aVar.f4193f, 512)) {
            this.f4202p = aVar.f4202p;
            this.f4201o = aVar.f4201o;
        }
        if (e(aVar.f4193f, 1024)) {
            this.f4203q = aVar.f4203q;
        }
        if (e(aVar.f4193f, 4096)) {
            this.f4209x = aVar.f4209x;
        }
        if (e(aVar.f4193f, 8192)) {
            this.f4205t = aVar.f4205t;
            this.f4206u = 0;
            this.f4193f &= -16385;
        }
        if (e(aVar.f4193f, 16384)) {
            this.f4206u = aVar.f4206u;
            this.f4205t = null;
            this.f4193f &= -8193;
        }
        if (e(aVar.f4193f, 32768)) {
            this.f4211z = aVar.f4211z;
        }
        if (e(aVar.f4193f, 65536)) {
            this.s = aVar.s;
        }
        if (e(aVar.f4193f, 131072)) {
            this.f4204r = aVar.f4204r;
        }
        if (e(aVar.f4193f, 2048)) {
            this.f4208w.putAll(aVar.f4208w);
            this.D = aVar.D;
        }
        if (e(aVar.f4193f, 524288)) {
            this.C = aVar.C;
        }
        if (!this.s) {
            this.f4208w.clear();
            this.f4204r = false;
            this.f4193f = this.f4193f & -2049 & -131073;
            this.D = true;
        }
        this.f4193f |= aVar.f4193f;
        this.f4207v.f5569b.i(aVar.f4207v.f5569b);
        j();
        return this;
    }

    /* renamed from: b */
    public T clone() {
        try {
            T t5 = (T) ((a) super.clone());
            h hVar = new h();
            t5.f4207v = hVar;
            hVar.f5569b.i(this.f4207v.f5569b);
            b bVar = new b();
            t5.f4208w = bVar;
            bVar.putAll(this.f4208w);
            t5.f4210y = false;
            t5.A = false;
            return t5;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final T c(Class<?> cls) {
        if (this.A) {
            return (T) clone().c(cls);
        }
        this.f4209x = cls;
        this.f4193f |= 4096;
        j();
        return this;
    }

    public final T d(l lVar) {
        if (this.A) {
            return (T) clone().d(lVar);
        }
        q2.a.i(lVar);
        this.f4195h = lVar;
        this.f4193f |= 4;
        j();
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (Float.compare(aVar.f4194g, this.f4194g) == 0 && this.f4198k == aVar.f4198k && k3.l.b(this.f4197j, aVar.f4197j) && this.m == aVar.m && k3.l.b(this.f4199l, aVar.f4199l) && this.f4206u == aVar.f4206u && k3.l.b(this.f4205t, aVar.f4205t) && this.f4200n == aVar.f4200n && this.f4201o == aVar.f4201o && this.f4202p == aVar.f4202p && this.f4204r == aVar.f4204r && this.s == aVar.s && this.B == aVar.B && this.C == aVar.C && this.f4195h.equals(aVar.f4195h) && this.f4196i == aVar.f4196i && this.f4207v.equals(aVar.f4207v) && this.f4208w.equals(aVar.f4208w) && this.f4209x.equals(aVar.f4209x) && k3.l.b(this.f4203q, aVar.f4203q) && k3.l.b(this.f4211z, aVar.f4211z)) {
                return true;
            }
        }
        return false;
    }

    public final T f() {
        T t5 = (T) g(k.f6617b, new y2.i());
        t5.D = true;
        return t5;
    }

    public final a g(k kVar, e eVar) {
        if (this.A) {
            return clone().g(kVar, eVar);
        }
        g gVar = k.f6620f;
        q2.a.i(kVar);
        k(gVar, kVar);
        return o(eVar, false);
    }

    public final T h(int i7, int i8) {
        if (this.A) {
            return (T) clone().h(i7, i8);
        }
        this.f4202p = i7;
        this.f4201o = i8;
        this.f4193f |= 512;
        j();
        return this;
    }

    @Override // java.lang.Object
    public int hashCode() {
        float f7 = this.f4194g;
        char[] cArr = k3.l.f4712a;
        return k3.l.g(k3.l.g(k3.l.g(k3.l.g(k3.l.g(k3.l.g(k3.l.g(k3.l.h(k3.l.h(k3.l.h(k3.l.h((((k3.l.h(k3.l.g((k3.l.g((k3.l.g(((Float.floatToIntBits(f7) + 527) * 31) + this.f4198k, this.f4197j) * 31) + this.m, this.f4199l) * 31) + this.f4206u, this.f4205t), this.f4200n) * 31) + this.f4201o) * 31) + this.f4202p, this.f4204r), this.s), this.B), this.C), this.f4195h), this.f4196i), this.f4207v), this.f4208w), this.f4209x), this.f4203q), this.f4211z);
    }

    public final a i() {
        i iVar = i.LOW;
        if (this.A) {
            return clone().i();
        }
        this.f4196i = iVar;
        this.f4193f |= 8;
        j();
        return this;
    }

    public final void j() {
        if (this.f4210y) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public final <Y> T k(g<Y> gVar, Y y6) {
        if (this.A) {
            return (T) clone().k(gVar, y6);
        }
        q2.a.i(gVar);
        q2.a.i(y6);
        this.f4207v.f5569b.put(gVar, y6);
        j();
        return this;
    }

    public final T l(f fVar) {
        if (this.A) {
            return (T) clone().l(fVar);
        }
        this.f4203q = fVar;
        this.f4193f |= 1024;
        j();
        return this;
    }

    public final a m() {
        if (this.A) {
            return clone().m();
        }
        this.f4200n = false;
        this.f4193f |= 256;
        j();
        return this;
    }

    public final <Y> T n(Class<Y> cls, p2.l<Y> lVar, boolean z6) {
        if (this.A) {
            return (T) clone().n(cls, lVar, z6);
        }
        q2.a.i(lVar);
        this.f4208w.put(cls, lVar);
        this.s = true;
        int i7 = this.f4193f | 2048 | 65536;
        this.f4193f = i7;
        this.D = false;
        if (z6) {
            this.f4193f = i7 | 131072;
            this.f4204r = true;
        }
        j();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T o(p2.l<Bitmap> lVar, boolean z6) {
        if (this.A) {
            return (T) clone().o(lVar, z6);
        }
        n nVar = new n(lVar, z6);
        n(Bitmap.class, lVar, z6);
        n(Drawable.class, nVar, z6);
        n(BitmapDrawable.class, nVar, z6);
        n(c3.c.class, new c3.e(lVar), z6);
        j();
        return this;
    }

    public final a p() {
        if (this.A) {
            return clone().p();
        }
        this.E = true;
        this.f4193f |= 1048576;
        j();
        return this;
    }
}
