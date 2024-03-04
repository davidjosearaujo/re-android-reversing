package k4;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a */
    public final float f4716a;

    public a(float f7) {
        this.f4716a = f7;
    }

    @Override // k4.c
    public final float a(RectF rectF) {
        return this.f4716a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f4716a == ((a) obj).f4716a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4716a)});
    }
}
