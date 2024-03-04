package t0;

import androidx.activity.h;

/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: f */
    public final float f6002f;

    /* renamed from: g */
    public final float f6003g;

    public d(float f7, float f8) {
        this.f6002f = f7;
        this.f6003g = f8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return Float.compare(this.f6002f, dVar.f6002f) == 0 && Float.compare(this.f6003g, dVar.f6003g) == 0;
        }
        return false;
    }

    @Override // t0.c
    public final float getDensity() {
        return this.f6002f;
    }

    public final int hashCode() {
        return Float.hashCode(this.f6003g) + (Float.hashCode(this.f6002f) * 31);
    }

    public final String toString() {
        StringBuilder d7 = h.d("DensityImpl(density=");
        d7.append(this.f6002f);
        d7.append(", fontScale=");
        d7.append(this.f6003g);
        d7.append(')');
        return d7.toString();
    }
}
