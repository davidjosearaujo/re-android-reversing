package o0;

import q5.p;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q<T> {

    /* renamed from: a */
    public final String f5269a;

    /* renamed from: b */
    public final p<T, T, T> f5270b;

    /* JADX WARN: Multi-variable type inference failed */
    public q(String str, p<? super T, ? super T, ? extends T> pVar) {
        h.f(pVar, "mergePolicy");
        this.f5269a = str;
        this.f5270b = pVar;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("SemanticsPropertyKey: ");
        d7.append(this.f5269a);
        return d7.toString();
    }
}
