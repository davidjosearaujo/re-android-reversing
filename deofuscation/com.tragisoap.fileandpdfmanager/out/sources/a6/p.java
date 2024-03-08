package a6;

import f5.g;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final Object f326a;

    /* renamed from: b  reason: collision with root package name */
    public final l<Throwable, g> f327b;

    /* JADX WARN: Multi-variable type inference failed */
    public p(Object obj, l<? super Throwable, g> lVar) {
        this.f326a = obj;
        this.f327b = lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return h.a(this.f326a, pVar.f326a) && h.a(this.f327b, pVar.f327b);
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
