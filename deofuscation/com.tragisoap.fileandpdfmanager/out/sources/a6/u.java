package a6;

import i5.b;
import i5.d;
import i5.e;
import i5.f;
import i5.g;
import k5.c;
import q5.l;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class u extends i5.a implements e {

    /* renamed from: g */
    public static final a f338g = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends b<e, u> {

        /* renamed from: a6.u$a$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class C0005a extends i implements l<f.b, u> {

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
    public final f6.f K(c cVar) {
        return new f6.f(this, cVar);
    }

    public abstract void U(f fVar, Runnable runnable);

    public boolean V() {
        return !(this instanceof m1);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [E extends i5.f$b] */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Override // i5.a, i5.f.b, i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        ?? r32;
        h.f(cVar, "key");
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            f.c<?> cVar2 = this.f4479f;
            h.f(cVar2, "key");
            if (!(cVar2 == bVar || bVar.f4481g == cVar2)) {
                return null;
            }
            E e = (E) ((f.b) bVar.f4480f.k(this));
            boolean z6 = e instanceof f.b;
            r32 = e;
            if (!z6) {
                return null;
            }
        } else {
            this = this;
            if (e.a.f4486f != cVar) {
                r32 = null;
            }
        }
        return (E) r32;
    }

    @Override // i5.e
    public final void f(d<?> dVar) {
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
    public final f k(f.c<?> cVar) {
        h.f(cVar, "key");
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            f.c<?> cVar2 = this.f4479f;
            h.f(cVar2, "key");
            if (!(cVar2 == bVar || bVar.f4481g == cVar2) || ((f.b) bVar.f4480f.k(this)) == null) {
                return this;
            }
        } else if (e.a.f4486f != cVar) {
            return this;
        }
        return g.f4488f;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + a0.c(this);
    }
}
