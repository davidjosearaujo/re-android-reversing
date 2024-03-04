package a6;

import i5.e;
import i5.f;

/* loaded from: classes.dex */
public abstract class u extends i5.a implements i5.e {

    /* renamed from: g */
    public static final a f338g = new a();

    /* loaded from: classes.dex */
    public static final class a extends i5.b<i5.e, u> {

        /* renamed from: a6.u$a$a */
        /* loaded from: classes.dex */
        public static final class C0005a extends r5.i implements q5.l<f.b, u> {

            /* renamed from: g */
            public static final C0005a f339g = new C0005a();

            public C0005a() {
                super(1);
            }

            @Override // q5.l
            public final u k(f.b bVar) {
                f.b bVar2 = bVar;
                if (bVar2 instanceof u) {
                    return (u) bVar2;
                }
                return null;
            }
        }

        public a() {
            super(e.a.f4486f, C0005a.f339g);
        }
    }

    public u() {
        super(e.a.f4486f);
    }

    @Override // i5.e
    public final f6.f K(k5.c cVar) {
        return new f6.f(this, cVar);
    }

    public abstract void U(i5.f fVar, Runnable runnable);

    public boolean V() {
        return !(this instanceof m1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // i5.a, i5.f.b, i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        ?? r32;
        r5.h.f(cVar, "key");
        if (cVar instanceof i5.b) {
            i5.b bVar = (i5.b) cVar;
            f.c<?> cVar2 = this.f4479f;
            r5.h.f(cVar2, "key");
            if (!(cVar2 == bVar || bVar.f4481g == cVar2)) {
                return null;
            }
            f.b bVar2 = (f.b) bVar.f4480f.k(this);
            boolean z6 = bVar2 instanceof f.b;
            r32 = bVar2;
            if (!z6) {
                return null;
            }
        } else {
            this = this;
            if (e.a.f4486f != cVar) {
                r32 = 0;
            }
        }
        return r32;
    }

    @Override // i5.e
    public final void f(i5.d<?> dVar) {
        f6.f fVar = (f6.f) dVar;
        do {
        } while (f6.f.m.get(fVar) == a0.b.B);
        Object obj = f6.f.m.get(fVar);
        h hVar = obj instanceof h ? (h) obj : null;
        if (hVar != null) {
            hVar.q();
        }
    }

    @Override // i5.a, i5.f
    public final i5.f k(f.c<?> cVar) {
        r5.h.f(cVar, "key");
        if (cVar instanceof i5.b) {
            i5.b bVar = (i5.b) cVar;
            f.c<?> cVar2 = this.f4479f;
            r5.h.f(cVar2, "key");
            if (!(cVar2 == bVar || bVar.f4481g == cVar2) || ((f.b) bVar.f4480f.k(this)) == null) {
                return this;
            }
        } else if (e.a.f4486f != cVar) {
            return this;
        }
        return i5.g.f4488f;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + a0.c(this);
    }
}
