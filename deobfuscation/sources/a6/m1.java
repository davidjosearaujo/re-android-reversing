package a6;

/* loaded from: classes.dex */
public final class m1 extends u {

    /* renamed from: h */
    public static final /* synthetic */ int f317h = 0;

    static {
        new m1();
    }

    @Override // a6.u
    public final void U(i5.f fVar, Runnable runnable) {
        q1 q1Var = (q1) fVar.e(q1.f329g);
        if (q1Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        q1Var.getClass();
    }

    @Override // a6.u
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
