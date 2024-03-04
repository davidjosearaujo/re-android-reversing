package s2;

import java.util.ArrayDeque;
import s2.l;

/* loaded from: classes.dex */
public abstract class c<T extends l> {

    /* renamed from: a */
    public final ArrayDeque f5933a;

    public c() {
        char[] cArr = k3.l.f4712a;
        this.f5933a = new ArrayDeque(20);
    }

    public abstract T a();

    public final T b() {
        T t5 = (T) this.f5933a.poll();
        return t5 == null ? a() : t5;
    }

    public final void c(T t5) {
        if (this.f5933a.size() < 20) {
            this.f5933a.offer(t5);
        }
    }
}
