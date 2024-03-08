package e6;

import d6.c0;
import d6.u;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class t extends u<Integer> implements c0<Integer> {
    public t(int i7) {
        l(Integer.valueOf(i7));
    }

    @Override // d6.c0
    public final Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            Object[] objArr = this.m;
            h.c(objArr);
            valueOf = Integer.valueOf(((Number) objArr[((int) ((this.f3736n + ((long) ((int) ((q() + ((long) this.f3738p)) - this.f3736n)))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return valueOf;
    }
}
