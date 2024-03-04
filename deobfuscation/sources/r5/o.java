package r5;

import r5.b;

/* loaded from: classes.dex */
public abstract class o extends b implements x5.f {

    /* renamed from: l */
    public final boolean f5923l;

    public o() {
        super(b.a.f5916f, null, null, null, false);
        this.f5923l = false;
    }

    public o(Object obj, Class cls, String str, String str2) {
        super(obj, cls, str, str2, true);
        this.f5923l = false;
    }

    public final x5.a c() {
        if (this.f5923l) {
            return this;
        }
        x5.a aVar = this.f5910f;
        if (aVar == null) {
            aVar = a();
            this.f5910f = aVar;
        }
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return b().equals(oVar.b()) && this.f5913i.equals(oVar.f5913i) && this.f5914j.equals(oVar.f5914j) && h.a(this.f5911g, oVar.f5911g);
        } else if (obj instanceof x5.f) {
            return obj.equals(c());
        } else {
            return false;
        }
    }

    public final int hashCode() {
        int hashCode = this.f5913i.hashCode();
        return this.f5914j.hashCode() + ((hashCode + (b().hashCode() * 31)) * 31);
    }

    public final String toString() {
        x5.a c7 = c();
        return c7 != this ? c7.toString() : androidx.activity.h.c(androidx.activity.h.d("property "), this.f5913i, " (Kotlin reflection is not available)");
    }
}
