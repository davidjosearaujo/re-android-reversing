package androidx.compose.ui.platform;

@k5.e(c = "androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1", f = "Wrapper.android.kt", l = {155}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class j0 extends k5.i implements q5.p {

    /* renamed from: j */
    public int f1185j;

    /* renamed from: k */
    public final /* synthetic */ WrappedComposition f1186k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(WrappedComposition wrappedComposition, i5.d dVar) {
        super(2, dVar);
        this.f1186k = wrappedComposition;
    }

    public final Object i(Object obj, Object obj2) {
        return ((j0) p((a6.x) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        return new j0(this.f1186k, dVar);
    }

    public final Object s(Object obj) {
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        int i7 = this.f1185j;
        if (i7 != 0) {
            if (i7 == 1) {
                f5.e.b(obj);
                return f5.g.f4141a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        f5.e.b(obj);
        this.f1186k.getClass();
        this.f1185j = 1;
        throw null;
    }
}
