package p0;

import androidx.activity.h;
import l0.z;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public static final /* synthetic */ int f5464a = 0;

    static {
        z.h(0, 0);
    }

    public static final int a(long j5) {
        return (int) (j5 & 4294967295L);
    }

    public static String b(long j5) {
        StringBuilder d7 = h.d("TextRange(");
        d7.append((int) (j5 >> 32));
        d7.append(", ");
        d7.append(a(j5));
        d7.append(')');
        return d7.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            ((c) obj).getClass();
            return 0 == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(0L);
    }

    public final String toString() {
        return b(0L);
    }
}
