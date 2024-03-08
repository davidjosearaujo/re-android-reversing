package i5;

import i5.e;
import q5.p;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface f {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: i5.f$a$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class C0069a extends i implements p<f, b, f> {

            /* renamed from: g */
            public static final C0069a f4487g = new C0069a();

            public C0069a() {
                super(2);
            }

            @Override // q5.p
            public final f i(f fVar, b bVar) {
                c cVar;
                f fVar2 = fVar;
                b bVar2 = bVar;
                h.f(fVar2, "acc");
                h.f(bVar2, "element");
                f k6 = fVar2.k(bVar2.getKey());
                g gVar = g.f4488f;
                if (k6 == gVar) {
                    return bVar2;
                }
                int i7 = e.f4485c;
                e.a aVar = e.a.f4486f;
                e eVar = (e) k6.e(aVar);
                if (eVar == null) {
                    cVar = new c(bVar2, k6);
                } else {
                    f k7 = k6.k(aVar);
                    if (k7 == gVar) {
                        return new c(eVar, bVar2);
                    }
                    cVar = new c(eVar, new c(bVar2, k7));
                }
                return cVar;
            }
        }

        public static f a(f fVar, f fVar2) {
            h.f(fVar2, "context");
            return fVar2 == g.f4488f ? fVar : (f) fVar2.q(fVar, C0069a.f4487g);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b extends f {

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class a {
            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E a(b bVar, c<E> cVar) {
                h.f(cVar, "key");
                if (h.a(bVar.getKey(), cVar)) {
                    return bVar;
                }
                return null;
            }

            public static f b(b bVar, c<?> cVar) {
                h.f(cVar, "key");
                return h.a(bVar.getKey(), cVar) ? g.f4488f : bVar;
            }
        }

        @Override // i5.f
        <E extends b> E e(c<E> cVar);

        c<?> getKey();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface c<E extends b> {
    }

    <E extends b> E e(c<E> cVar);

    f k(c<?> cVar);

    <R> R q(R r6, p<? super R, ? super b, ? extends R> pVar);

    f s(f fVar);
}
