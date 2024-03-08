package p;

import a6.h0;
import a6.x;
import android.view.Choreographer;
import f5.g;
import f6.m;
import g6.c;
import i5.d;
import i5.f;
import k5.e;
import q5.p;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i implements t {

    /* renamed from: f  reason: collision with root package name */
    public static final i f5434f = new i();

    @e(c = "androidx.compose.runtime.DefaultChoreographerFrameClock$choreographer$1", f = "ActualAndroid.android.kt", l = {}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends k5.i implements p<x, d<? super Choreographer>, Object> {
        public a(d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // q5.p
        public final Object i(x xVar, d<? super Choreographer> dVar) {
            return new a(dVar).s(g.f4141a);
        }

        @Override // k5.a
        public final d<g> p(Object obj, d<?> dVar) {
            return new a(dVar);
        }

        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            f5.e.b(obj);
            return Choreographer.getInstance();
        }
    }

    static {
        c cVar = h0.f297a;
        Choreographer choreographer = (Choreographer) a0.e.D(m.f4172a.W(), new a(null));
    }

    @Override // i5.f.b, i5.f
    public final <E extends f.b> E e(f.c<E> cVar) {
        h.f(cVar, "key");
        return (E) f.b.a.a(this, cVar);
    }

    @Override // i5.f
    public final f k(f.c<?> cVar) {
        h.f(cVar, "key");
        return f.b.a.b(this, cVar);
    }

    @Override // i5.f
    public final <R> R q(R r6, p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) pVar.i(r6, this);
    }

    @Override // i5.f
    public final f s(f fVar) {
        h.f(fVar, "context");
        return f.a.a(this, fVar);
    }
}
