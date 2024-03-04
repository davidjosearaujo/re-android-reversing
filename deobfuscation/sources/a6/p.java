package a6;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a */
    public final Object f326a;

    /* renamed from: b */
    public final q5.l<Throwable, f5.g> f327b;

    /* JADX WARN: Multi-variable type inference failed */
    public p(Object obj, q5.l<? super Throwable, f5.g> lVar) {
        this.f326a = obj;
        this.f327b = lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return r5.h.a(this.f326a, pVar.f326a) && r5.h.a(this.f327b, pVar.f327b);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f326a;
        return this.f327b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("CompletedWithCancellation(result=");
        d7.append(this.f326a);
        d7.append(", onCancellation=");
        d7.append(this.f327b);
        d7.append(')');
        return d7.toString();
    }
}
