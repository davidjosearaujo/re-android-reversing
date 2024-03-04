package a6;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a */
    public final Object f318a;

    /* renamed from: b */
    public final e f319b;

    /* renamed from: c */
    public final q5.l<Throwable, f5.g> f320c;

    /* renamed from: d */
    public final Object f321d;
    public final Throwable e;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Object obj, e eVar, q5.l<? super Throwable, f5.g> lVar, Object obj2, Throwable th) {
        this.f318a = obj;
        this.f319b = eVar;
        this.f320c = lVar;
        this.f321d = obj2;
        this.e = th;
    }

    public /* synthetic */ n(Object obj, e eVar, q5.l lVar, CancellationException cancellationException, int i7) {
        this(obj, (i7 & 2) != 0 ? null : eVar, (i7 & 4) != 0 ? null : lVar, (Object) null, (i7 & 16) != 0 ? null : cancellationException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Throwable] */
    public static n a(n nVar, e eVar, CancellationException cancellationException, int i7) {
        Object obj = (i7 & 1) != 0 ? nVar.f318a : null;
        if ((i7 & 2) != 0) {
            eVar = nVar.f319b;
        }
        e eVar2 = eVar;
        q5.l<Throwable, f5.g> lVar = (i7 & 4) != 0 ? nVar.f320c : null;
        Object obj2 = (i7 & 8) != 0 ? nVar.f321d : null;
        CancellationException cancellationException2 = cancellationException;
        if ((i7 & 16) != 0) {
            cancellationException2 = nVar.e;
        }
        nVar.getClass();
        return new n(obj, eVar2, lVar, obj2, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            return r5.h.a(this.f318a, nVar.f318a) && r5.h.a(this.f319b, nVar.f319b) && r5.h.a(this.f320c, nVar.f320c) && r5.h.a(this.f321d, nVar.f321d) && r5.h.a(this.e, nVar.e);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f318a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        e eVar = this.f319b;
        int hashCode2 = (hashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        q5.l<Throwable, f5.g> lVar = this.f320c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f321d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
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
