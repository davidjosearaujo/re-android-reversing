package c6;

import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final b f2615b = new b();

    /* renamed from: a  reason: collision with root package name */
    public final Object f2616a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends b {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f2617a;

        public a(Throwable th) {
            this.f2617a = th;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof a) && h.a(this.f2617a, ((a) obj).f2617a);
        }

        public final int hashCode() {
            Throwable th = this.f2617a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // c6.i.b
        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("Closed(");
            d7.append(this.f2617a);
            d7.append(')');
            return d7.toString();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ i(Object obj) {
        this.f2616a = obj;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof i) && h.a(this.f2616a, ((i) obj).f2616a);
    }

    public final int hashCode() {
        Object obj = this.f2616a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f2616a;
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
