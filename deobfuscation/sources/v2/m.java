package v2;

import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class m<A, B> {

    /* renamed from: a */
    public final l f6218a = new l();

    /* loaded from: classes.dex */
    public static final class a<A> {

        /* renamed from: d */
        public static final ArrayDeque f6219d;

        /* renamed from: a */
        public int f6220a;

        /* renamed from: b */
        public int f6221b;

        /* renamed from: c */
        public A f6222c;

        static {
            char[] cArr = k3.l.f4712a;
            f6219d = new ArrayDeque(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static a a(Object obj) {
            a aVar;
            ArrayDeque arrayDeque = f6219d;
            synchronized (arrayDeque) {
                aVar = (a) arrayDeque.poll();
            }
            if (aVar == null) {
                aVar = new a();
            }
            aVar.f6222c = obj;
            aVar.f6221b = 0;
            aVar.f6220a = 0;
            return aVar;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f6221b == aVar.f6221b && this.f6220a == aVar.f6220a && this.f6222c.equals(aVar.f6222c);
            }
            return false;
        }

        public final int hashCode() {
            return this.f6222c.hashCode() + (((this.f6220a * 31) + this.f6221b) * 31);
        }
    }
}
