package i0;

import androidx.activity.h;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public final float f4458a;

    /* renamed from: b */
    public final float f4459b;

    /* renamed from: c */
    public final long f4460c;

    public b(float f7, float f8, long j5) {
        this.f4458a = f7;
        this.f4459b = f8;
        this.f4460c = j5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.f4458a == this.f4458a) {
                if ((bVar.f4459b == this.f4459b) && bVar.f4460c == this.f4460c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Float.hashCode(this.f4459b);
        return Long.hashCode(this.f4460c) + ((hashCode + (Float.hashCode(this.f4458a) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder d7 = h.d("RotaryScrollEvent(verticalScrollPixels=");
        d7.append(this.f4458a);
        d7.append(",horizontalScrollPixels=");
        d7.append(this.f4459b);
        d7.append(",uptimeMillis=");
        d7.append(this.f4460c);
        d7.append(')');
        return d7.toString();
    }
}
