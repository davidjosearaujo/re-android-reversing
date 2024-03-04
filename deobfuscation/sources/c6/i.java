package c6;

/* loaded from: classes.dex */
public final class i<T> {

    /* renamed from: b */
    public static final b f2615b = new b();

    /* renamed from: a */
    public final Object f2616a;

    /* loaded from: classes.dex */
    public static final class a extends b {

        /* renamed from: a */
        public final Throwable f2617a;

        public a(Throwable th) {
            this.f2617a = th;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof a) && r5.h.a(this.f2617a, ((a) obj).f2617a);
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

    /* loaded from: classes.dex */
    public static class b {
        public String toString() {
            return "Failed";
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof i) && r5.h.a(this.f2616a, ((i) obj).f2616a);
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
