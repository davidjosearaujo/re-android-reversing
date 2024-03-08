package a6;

import f5.g;
import java.util.concurrent.CancellationException;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final Object f318a;

    /* renamed from: b  reason: collision with root package name */
    public final e f319b;

    /* renamed from: c  reason: collision with root package name */
    public final l<Throwable, g> f320c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f321d;
    public final Throwable e;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Object obj, e eVar, l<? super Throwable, g> lVar, Object obj2, Throwable th) {
        this.f318a = obj;
        this.f319b = eVar;
        this.f320c = lVar;
        this.f321d = obj2;
        this.e = th;
    }

    public /* synthetic */ n(Object obj, e eVar, l lVar, CancellationException cancellationException, int i7) {
        this(obj, (i7 & 2) != 0 ? null : eVar, (i7 & 4) != 0 ? null : lVar, (Object) null, (i7 & 16) != 0 ? null : cancellationException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Throwable] */
    public static n a(n nVar, e eVar, CancellationException cancellationException, int i7) {
        Object obj = null;
        Object obj2 = (i7 & 1) != 0 ? nVar.f318a : null;
        if ((i7 & 2) != 0) {
            eVar = nVar.f319b;
        }
        l<Throwable, g> lVar = (i7 & 4) != 0 ? nVar.f320c : null;
        if ((i7 & 8) != 0) {
            obj = nVar.f321d;
        }
        CancellationException cancellationException2 = cancellationException;
        if ((i7 & 16) != 0) {
            cancellationException2 = nVar.e;
        }
        nVar.getClass();
        return new n(obj2, eVar, lVar, obj, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return h.a(this.f318a, nVar.f318a) && h.a(this.f319b, nVar.f319b) && h.a(this.f320c, nVar.f320c) && h.a(this.f321d, nVar.f321d) && h.a(this.e, nVar.e);
    }

    public final int hashCode() {
        Object obj = this.f318a;
        int i7 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        e eVar = this.f319b;
        int hashCode2 = (hashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        l<Throwable, g> lVar = this.f320c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f321d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        if (th != null) {
            i7 = th.hashCode();
        }
        return hashCode4 + i7;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("CompletedContinuation(result=");
        d7.append(this.f318a);
        d7.append(", cancelHandler=");
        d7.append(this.f319b);
        d7.append(", onCancellation=");
        d7.append(this.f320c);
        d7.append(", idempotentResume=");
        d7.append(this.f321d);
        d7.append(", cancelCause=");
        d7.append(this.e);
        d7.append(')');
        return d7.toString();
    }
}
