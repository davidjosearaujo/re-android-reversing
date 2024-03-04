package r5;

/* loaded from: classes.dex */
public class f extends b implements e, x5.c {

    /* renamed from: l */
    public final int f5920l;
    public final int m;

    public f(int i7, Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, (i8 & 1) == 1);
        this.f5920l = i7;
        this.m = i8 >> 1;
    }

    @Override // r5.b
    public final x5.a a() {
        t.f5928a.getClass();
        return this;
    }

    @Override // r5.e
    public final int e() {
        return this.f5920l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [x5.a] */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f5913i.equals(fVar.f5913i) && this.f5914j.equals(fVar.f5914j) && this.m == fVar.m && this.f5920l == fVar.f5920l && h.a(this.f5911g, fVar.f5911g) && h.a(b(), fVar.b());
        } else if (obj instanceof x5.c) {
            ?? r02 = this.f5910f;
            if (r02 == 0) {
                a();
                this.f5910f = this;
            } else {
                this = r02;
            }
            return obj.equals(this);
        } else {
            return false;
        }
    }

    public final int hashCode() {
        return this.f5914j.hashCode() + ((this.f5913i.hashCode() + (b() == null ? 0 : b().hashCode() * 31)) * 31);
    }

    public final String toString() {
        x5.a aVar = this.f5910f;
        if (aVar == null) {
            a();
            this.f5910f = this;
            aVar = this;
        }
        return aVar != this ? aVar.toString() : "<init>".equals(this.f5913i) ? "constructor (Kotlin reflection is not available)" : androidx.activity.h.c(androidx.activity.h.d("function "), this.f5913i, " (Kotlin reflection is not available)");
    }
}
