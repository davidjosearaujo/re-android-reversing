package p0;

import androidx.activity.h;
import l0.z;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f5464a = 0;

    static {
        z.h(0, 0);
    }

    public static final int a(long j7) {
        return (int) (j7 & 4294967295L);
    }

    public static String b(long j7) {
        StringBuilder d7 = h.d("TextRange(");
        d7.append((int) (j7 >> 32));
        d7.append(", ");
        d7.append(a(j7));
        d7.append(')');
        return d7.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        ((c) obj).getClass();
        return 0 == 0;
    }

    public final int hashCode() {
        return Long.hashCode(0);
    }

    public final String toString() {
        return b(0);
    }
}
