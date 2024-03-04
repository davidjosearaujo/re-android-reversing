package o0;

/* loaded from: classes.dex */
public final class q<T> {

    /* renamed from: a */
    public final String f5269a;

    /* renamed from: b */
    public final q5.p<T, T, T> f5270b;

    /* JADX WARN: Multi-variable type inference failed */
    public q(String str, q5.p<? super T, ? super T, ? extends T> pVar) {
        r5.h.f(pVar, "mergePolicy");
        this.f5269a = str;
        this.f5270b = pVar;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("SemanticsPropertyKey: ");
        d7.append(this.f5269a);
        return d7.toString();
    }
}
