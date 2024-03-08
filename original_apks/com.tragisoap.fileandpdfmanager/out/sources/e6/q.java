package e6;

import a6.u0;
import f6.r;
import i5.f;
import q5.p;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q extends i implements p<Integer, f.b, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ o<?> f3914g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o<?> oVar) {
        super(2);
        this.f3914g = oVar;
    }

    @Override // q5.p
    public final Integer i(Integer num, f.b bVar) {
        int intValue = num.intValue();
        f.b bVar2 = bVar;
        f.c<?> key = bVar2.getKey();
        f.b e = this.f3914g.f3908j.e(key);
        int i7 = u0.f340a;
        if (key != u0.b.f341f) {
            return Integer.valueOf(bVar2 != e ? Integer.MIN_VALUE : intValue + 1);
        }
        u0 u0Var = (u0) e;
        u0 u0Var2 = (u0) bVar2;
        while (true) {
            if (u0Var2 != null) {
                if (u0Var2 == u0Var || !(u0Var2 instanceof r)) {
                    break;
                }
                u0Var2 = u0Var2.getParent();
            } else {
                u0Var2 = null;
                break;
            }
        }
        if (u0Var2 == u0Var) {
            if (u0Var != null) {
                intValue++;
            }
            return Integer.valueOf(intValue);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + u0Var2 + ", expected child of " + u0Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
