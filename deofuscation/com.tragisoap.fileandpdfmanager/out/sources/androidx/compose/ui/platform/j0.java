package androidx.compose.ui.platform;

import a6.x;
import f5.g;
import i5.d;
import j5.a;
import k5.e;
import k5.i;
import q5.p;
@e(c = "androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1", f = "Wrapper.android.kt", l = {155}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j0 extends i implements p<x, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public int f1185j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WrappedComposition f1186k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(WrappedComposition wrappedComposition, d<? super j0> dVar) {
        super(2, dVar);
        this.f1186k = wrappedComposition;
    }

    @Override // q5.p
    public final Object i(x xVar, d<? super g> dVar) {
        return ((j0) p(xVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        return new j0(this.f1186k, dVar);
    }

    @Override // k5.a
    public final Object s(Object obj) {
        a aVar = a.f4591f;
        int i7 = this.f1185j;
        if (i7 == 0) {
            f5.e.b(obj);
            this.f1186k.getClass();
            this.f1185j = 1;
            throw null;
        } else if (i7 == 1) {
            f5.e.b(obj);
            return g.f4141a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
