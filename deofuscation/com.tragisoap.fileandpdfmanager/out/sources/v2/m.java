package v2;

import java.util.ArrayDeque;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    public final l f6218a = new l();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a<A> {

        /* renamed from: d  reason: collision with root package name */
        public static final ArrayDeque f6219d = new ArrayDeque(0);

        /* renamed from: a  reason: collision with root package name */
        public int f6220a;

        /* renamed from: b  reason: collision with root package name */
        public int f6221b;

        /* renamed from: c  reason: collision with root package name */
        public A f6222c;

        static {
            char[] cArr = l.f4712a;
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
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6221b == aVar.f6221b && this.f6220a == aVar.f6220a && this.f6222c.equals(aVar.f6222c);
        }

        public final int hashCode() {
            return this.f6222c.hashCode() + (((this.f6220a * 31) + this.f6221b) * 31);
        }
    }
}
