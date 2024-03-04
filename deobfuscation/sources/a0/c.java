package a0;

import androidx.activity.h;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public final float f26a;

    /* renamed from: b */
    public final float f27b;

    /* renamed from: c */
    public final float f28c;

    /* renamed from: d */
    public final float f29d;

    public c(float f7, float f8, float f9, float f10) {
        this.f26a = f7;
        this.f27b = f8;
        this.f28c = f9;
        this.f29d = f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return Float.compare(this.f26a, cVar.f26a) == 0 && Float.compare(this.f27b, cVar.f27b) == 0 && Float.compare(this.f28c, cVar.f28c) == 0 && Float.compare(this.f29d, cVar.f29d) == 0;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Float.hashCode(this.f27b);
        int hashCode2 = Float.hashCode(this.f28c);
        return Float.hashCode(this.f29d) + ((hashCode2 + ((hashCode + (Float.hashCode(this.f26a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder d7 = h.d("Rect.fromLTRB(");
        d7.append(e.H(this.f26a));
        d7.append(", ");
        d7.append(e.H(this.f27b));
        d7.append(", ");
        d7.append(e.H(this.f28c));
        d7.append(", ");
        d7.append(e.H(this.f29d));
        d7.append(')');
        return d7.toString();
    }
}
