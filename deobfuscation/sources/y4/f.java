package y4;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    public final String f6708a;

    /* renamed from: b */
    public final String f6709b;

    public f(String str, String str2) {
        this.f6708a = str;
        this.f6709b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (z4.h.d(this.f6708a, fVar.f6708a) && z4.h.d(this.f6709b, fVar.f6709b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f6709b;
        int hashCode = (899 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6708a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6708a);
        sb.append(" realm=\"");
        return androidx.activity.h.c(sb, this.f6709b, "\"");
    }
}
