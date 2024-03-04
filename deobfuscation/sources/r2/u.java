package r2;

import l3.a;
import l3.d;

/* loaded from: classes.dex */
public final class u<Z> implements v<Z>, a.d {

    /* renamed from: j */
    public static final a.c f5871j = l3.a.a(20, new a());

    /* renamed from: f */
    public final d.a f5872f = new d.a();

    /* renamed from: g */
    public v<Z> f5873g;

    /* renamed from: h */
    public boolean f5874h;

    /* renamed from: i */
    public boolean f5875i;

    /* loaded from: classes.dex */
    public class a implements a.b<u<?>> {
        @Override // l3.a.b
        public final u<?> a() {
            return new u<>();
        }
    }

    public final synchronized void a() {
        this.f5872f.a();
        if (!this.f5874h) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f5874h = false;
        if (this.f5875i) {
            recycle();
        }
    }

    @Override // r2.v
    public final int b() {
        return this.f5873g.b();
    }

    @Override // r2.v
    public final Class<Z> c() {
        return this.f5873g.c();
    }

    @Override // l3.a.d
    public final d.a d() {
        return this.f5872f;
    }

    @Override // r2.v
    public final Z get() {
        return this.f5873g.get();
    }

    @Override // r2.v
    public final synchronized void recycle() {
        this.f5872f.a();
        this.f5875i = true;
        if (!this.f5874h) {
            this.f5873g.recycle();
            this.f5873g = null;
            f5871j.a(this);
        }
    }
}
