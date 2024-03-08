package r0;

import l0.z;
import q2.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u {

    /* renamed from: a */
    public final g f5707a;

    /* renamed from: b */
    public final n f5708b;

    /* renamed from: c */
    public final int f5709c;

    /* renamed from: d */
    public final int f5710d;
    public final Object e;

    public u(g gVar, n nVar, int i7, int i8, Object obj) {
        h.f(nVar, "fontWeight");
        this.f5707a = gVar;
        this.f5708b = nVar;
        this.f5709c = i7;
        this.f5710d = i8;
        this.e = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (!h.a(this.f5707a, uVar.f5707a) || !h.a(this.f5708b, uVar.f5708b)) {
            return false;
        }
        if (!(this.f5709c == uVar.f5709c)) {
            return false;
        }
        return (this.f5710d == uVar.f5710d) && h.a(this.e, uVar.e);
    }

    public final int hashCode() {
        g gVar = this.f5707a;
        int i7 = 0;
        int hashCode = gVar == null ? 0 : gVar.hashCode();
        int hashCode2 = (Integer.hashCode(this.f5710d) + ((Integer.hashCode(this.f5709c) + (((hashCode * 31) + this.f5708b.f5702f) * 31)) * 31)) * 31;
        Object obj = this.e;
        if (obj != null) {
            i7 = obj.hashCode();
        }
        return hashCode2 + i7;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("TypefaceRequest(fontFamily=");
        d7.append(this.f5707a);
        d7.append(", fontWeight=");
        d7.append(this.f5708b);
        d7.append(", fontStyle=");
        d7.append((Object) a.U(this.f5709c));
        d7.append(", fontSynthesis=");
        d7.append((Object) z.q(this.f5710d));
        d7.append(", resourceLoaderCacheKey=");
        d7.append(this.e);
        d7.append(')');
        return d7.toString();
    }
}
