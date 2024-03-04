package c0;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a */
    public final float f2511a;

    /* renamed from: b */
    public final float f2512b;

    public t(float f7, float f8) {
        this.f2511a = f7;
        this.f2512b = f8;
    }

    public final float[] a() {
        float f7 = this.f2511a;
        float f8 = this.f2512b;
        return new float[]{f7 / f8, 1.0f, ((1.0f - f7) - f8) / f8};
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return Float.compare(this.f2511a, tVar.f2511a) == 0 && Float.compare(this.f2512b, tVar.f2512b) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.f2512b) + (Float.hashCode(this.f2511a) * 31);
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("WhitePoint(x=");
        d7.append(this.f2511a);
        d7.append(", y=");
        d7.append(this.f2512b);
        d7.append(')');
        return d7.toString();
    }
}
