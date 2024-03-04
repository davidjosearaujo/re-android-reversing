package j5;

import f5.e;
import i5.d;
import i5.f;
import q5.p;
import r5.h;
import r5.v;

/* loaded from: classes.dex */
public final class c extends k5.c {

    /* renamed from: i */
    public int f4596i;

    /* renamed from: j */
    public final /* synthetic */ p f4597j;

    /* renamed from: k */
    public final /* synthetic */ Object f4598k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, f fVar, p pVar, Object obj) {
        super(dVar, fVar);
        this.f4597j = pVar;
        this.f4598k = obj;
        h.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // k5.a
    public final Object s(Object obj) {
        int i7 = this.f4596i;
        if (i7 != 0) {
            if (i7 == 1) {
                this.f4596i = 2;
                e.b(obj);
                return obj;
            }
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
        this.f4596i = 1;
        e.b(obj);
        h.d(this.f4597j, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        p pVar = this.f4597j;
        v.b(2, pVar);
        return pVar.i(this.f4598k, this);
    }
}
