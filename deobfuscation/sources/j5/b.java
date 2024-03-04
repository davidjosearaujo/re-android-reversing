package j5;

import f5.e;
import i5.d;
import k5.g;
import q5.p;
import r5.h;
import r5.v;

/* loaded from: classes.dex */
public final class b extends g {

    /* renamed from: g */
    public int f4593g;

    /* renamed from: h */
    public final /* synthetic */ p f4594h;

    /* renamed from: i */
    public final /* synthetic */ Object f4595i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Object obj, d dVar, p pVar) {
        super(dVar);
        this.f4594h = pVar;
        this.f4595i = obj;
        h.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // k5.a
    public final Object s(Object obj) {
        int i7 = this.f4593g;
        if (i7 != 0) {
            if (i7 == 1) {
                this.f4593g = 2;
                e.b(obj);
                return obj;
            }
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
        this.f4593g = 1;
        e.b(obj);
        h.d(this.f4594h, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        p pVar = this.f4594h;
        v.b(2, pVar);
        return pVar.i(this.f4595i, this);
    }
}
