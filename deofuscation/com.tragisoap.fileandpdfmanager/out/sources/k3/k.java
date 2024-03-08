package k3;

import androidx.activity.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f4709a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f4710b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f4711c;

    public k() {
    }

    public k(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f4709a = cls;
        this.f4710b = cls2;
        this.f4711c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f4709a.equals(kVar.f4709a) && this.f4710b.equals(kVar.f4710b) && l.b(this.f4711c, kVar.f4711c);
    }

    public final int hashCode() {
        int hashCode = (this.f4710b.hashCode() + (this.f4709a.hashCode() * 31)) * 31;
        Class<?> cls = this.f4711c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder d7 = h.d("MultiClassKey{first=");
        d7.append(this.f4709a);
        d7.append(", second=");
        d7.append(this.f4710b);
        d7.append('}');
        return d7.toString();
    }
}
