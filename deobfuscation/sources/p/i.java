package p;

import android.view.Choreographer;
import i5.f;

/* loaded from: classes.dex */
public final class i implements t {

    /* renamed from: f */
    public static final i f5434f = new i();

    @k5.e(c = "androidx.compose.runtime.DefaultChoreographerFrameClock$choreographer$1", f = "ActualAndroid.android.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends k5.i implements q5.p {
        public a(i5.d dVar) {
            super(2, dVar);
        }

        public final Object i(Object obj, Object obj2) {
            a6.x xVar = (a6.x) obj;
            return new a((i5.d) obj2).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            return new a(dVar);
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            f5.e.b(obj);
            return Choreographer.getInstance();
        }
    }

    static {
        g6.c cVar = a6.h0.f297a;
        Choreographer choreographer = (Choreographer) a0.e.D(f6.m.f4172a.W(), new a(null));
    }

    public final f.b e(f.c cVar) {
        r5.h.f(cVar, "key");
        return f.b.a.a(this, cVar);
    }

    public final i5.f k(f.c cVar) {
        r5.h.f(cVar, "key");
        return f.b.a.b(this, cVar);
    }

    public final Object q(Object obj, q5.p pVar) {
        return pVar.i(obj, this);
    }

    public final i5.f s(i5.f fVar) {
        r5.h.f(fVar, "context");
        return f.a.a(this, fVar);
    }
}
