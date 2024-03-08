package r5;

import androidx.activity.h;
import r5.b;
import x5.a;
import x5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class o extends b implements f {

    /* renamed from: l  reason: collision with root package name */
    public final boolean f5923l = false;

    public o() {
        super(b.a.f5916f, null, null, null, false);
    }

    public o(Object obj, Class cls, String str, String str2) {
        super(obj, cls, str, str2, true);
    }

    public final a c() {
        if (this.f5923l) {
            return this;
        }
        a aVar = this.f5910f;
        if (aVar == null) {
            aVar = a();
            this.f5910f = aVar;
        }
        return aVar;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return b().equals(oVar.b()) && this.f5913i.equals(oVar.f5913i) && this.f5914j.equals(oVar.f5914j) && h.a(this.f5911g, oVar.f5911g);
        } else if (obj instanceof f) {
            return obj.equals(c());
        } else {
            return false;
        }
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int hashCode = this.f5913i.hashCode();
        return this.f5914j.hashCode() + ((hashCode + (b().hashCode() * 31)) * 31);
    }

    @Override // java.lang.Object
    public final String toString() {
        a c7 = c();
        return c7 != this ? c7.toString() : h.c(h.d("property "), this.f5913i, " (Kotlin reflection is not available)");
    }
}
