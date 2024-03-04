package e6;

import d6.c0;

/* loaded from: classes.dex */
public final class t extends d6.u<Integer> implements c0<Integer> {
    public t(int i7) {
        l(Integer.valueOf(i7));
    }

    @Override // d6.c0
    public final Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            Object[] objArr = this.m;
            r5.h.c(objArr);
            valueOf = Integer.valueOf(((Number) objArr[((int) ((this.f3736n + ((int) ((q() + this.f3738p) - this.f3736n))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return valueOf;
    }
}
