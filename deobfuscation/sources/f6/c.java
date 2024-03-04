package f6;

/* loaded from: classes.dex */
public final class c implements a6.x {

    /* renamed from: f */
    public final i5.f f4145f;

    public c(i5.f fVar) {
        this.f4145f = fVar;
    }

    @Override // a6.x
    public final i5.f l() {
        return this.f4145f;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("CoroutineScope(coroutineContext=");
        d7.append(this.f4145f);
        d7.append(')');
        return d7.toString();
    }
}
