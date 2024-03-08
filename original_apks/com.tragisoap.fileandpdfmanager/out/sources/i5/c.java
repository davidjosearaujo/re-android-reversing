package i5;

import i5.f;
import java.io.Serializable;
import q5.p;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c implements f, Serializable {

    /* renamed from: f  reason: collision with root package name */
    public final f f4482f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b f4483g;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements p<String, f.b, String> {

        /* renamed from: g  reason: collision with root package name */
        public static final a f4484g = new a();

        public a() {
            super(2);
        }

        @Override // q5.p
        public final String i(String str, f.b bVar) {
            String str2 = str;
            f.b bVar2 = bVar;
            h.f(str2, "acc");
            h.f(bVar2, "element");
            if (str2.length() == 0) {
                return bVar2.toString();
            }
            return str2 + ", " + bVar2;
        }
    }

    public c(f.b bVar, f fVar) {
        h.f(fVar, "left");
        h.f(bVar, "element");
        this.f4482f = fVar;
        this.f4483g = bVar;
    }

    @Override // i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        h.f(cVar, "key");
        while (true) {
            E e = (E) this.f4483g.e(cVar);
            if (e != null) {
                return e;
            }
            f fVar = this.f4482f;
            if (!(fVar instanceof c)) {
                return (E) fVar.e(cVar);
            }
            this = (c) fVar;
        }
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        boolean z6;
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            cVar.getClass();
            int i7 = 2;
            c cVar2 = cVar;
            int i8 = 2;
            while (true) {
                f fVar = cVar2.f4482f;
                cVar2 = fVar instanceof c ? (c) fVar : null;
                if (cVar2 == null) {
                    break;
                }
                i8++;
            }
            c cVar3 = this;
            while (true) {
                f fVar2 = cVar3.f4482f;
                cVar3 = fVar2 instanceof c ? (c) fVar2 : null;
                if (cVar3 == null) {
                    break;
                }
                i7++;
            }
            if (i8 != i7) {
                return false;
            }
            while (true) {
                f.b bVar = this.f4483g;
                if (h.a(cVar.e(bVar.getKey()), bVar)) {
                    f fVar3 = this.f4482f;
                    if (!(fVar3 instanceof c)) {
                        h.d(fVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        f.b bVar2 = (f.b) fVar3;
                        z6 = h.a(cVar.e(bVar2.getKey()), bVar2);
                        break;
                    }
                    this = (c) fVar3;
                } else {
                    z6 = false;
                    break;
                }
            }
            if (!z6) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.f4483g.hashCode() + this.f4482f.hashCode();
    }

    @Override // i5.f
    public final f k(f.c<?> cVar) {
        h.f(cVar, "key");
        if (this.f4483g.e(cVar) != null) {
            return this.f4482f;
        }
        f k6 = this.f4482f.k(cVar);
        return k6 == this.f4482f ? this : k6 == g.f4488f ? this.f4483g : new c(this.f4483g, k6);
    }

    @Override // i5.f
    public final <R> R q(R r6, p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) pVar.i((Object) this.f4482f.q(r6, pVar), this.f4483g);
    }

    @Override // i5.f
    public final f s(f fVar) {
        return f.a.a(this, fVar);
    }

    @Override // java.lang.Object
    public final String toString() {
        return '[' + ((String) q("", a.f4484g)) + ']';
    }
}
