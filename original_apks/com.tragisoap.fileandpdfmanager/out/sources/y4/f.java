package y4;

import z4.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
            if (h.d(this.f6708a, fVar.f6708a) && h.d(this.f6709b, fVar.f6709b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f6709b;
        int i7 = 0;
        int hashCode = (899 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6708a;
        if (str2 != null) {
            i7 = str2.hashCode();
        }
        return hashCode + i7;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6708a);
        sb.append(" realm=\"");
        return androidx.activity.h.c(sb, this.f6709b, "\"");
    }
}
