package r2;

import p2.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q<Z> implements v<Z> {

    /* renamed from: f */
    public final boolean f5853f;

    /* renamed from: g */
    public final boolean f5854g;

    /* renamed from: h */
    public final v<Z> f5855h;

    /* renamed from: i */
    public final a f5856i;

    /* renamed from: j */
    public final f f5857j;

    /* renamed from: k */
    public int f5858k;

    /* renamed from: l */
    public boolean f5859l;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        void a(f fVar, q<?> qVar);
    }

    public q(v<Z> vVar, boolean z6, boolean z7, f fVar, a aVar) {
        q2.a.i(vVar);
        this.f5855h = vVar;
        this.f5853f = z6;
        this.f5854g = z7;
        this.f5857j = fVar;
        q2.a.i(aVar);
        this.f5856i = aVar;
    }

    public final synchronized void a() {
        if (!this.f5859l) {
            this.f5858k++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // r2.v
    public final int b() {
        return this.f5855h.b();
    }

    @Override // r2.v
    public final Class<Z> c() {
        return this.f5855h.c();
    }

    public final void d() {
        boolean z6;
        synchronized (this) {
            int i7 = this.f5858k;
            if (i7 > 0) {
                z6 = true;
                int i8 = i7 - 1;
                this.f5858k = i8;
                if (i8 != 0) {
                    z6 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z6) {
            this.f5856i.a(this.f5857j, this);
        }
    }

    @Override // r2.v
    public final Z get() {
        return this.f5855h.get();
    }

    @Override // r2.v
    public final synchronized void recycle() {
        if (this.f5858k > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f5859l) {
            this.f5859l = true;
            if (this.f5854g) {
                this.f5855h.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f5853f + ", listener=" + this.f5856i + ", key=" + this.f5857j + ", acquired=" + this.f5858k + ", isRecycled=" + this.f5859l + ", resource=" + this.f5855h + '}';
    }
}
