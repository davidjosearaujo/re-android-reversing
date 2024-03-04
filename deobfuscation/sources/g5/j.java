package g5;

import java.util.Collection;

/* loaded from: classes.dex */
public class j extends q2.a {
    public static final int V(Iterable iterable) {
        r5.h.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
