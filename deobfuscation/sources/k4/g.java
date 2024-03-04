package k4;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g implements c {

    /* renamed from: a */
    public final float f4758a;

    public g(float f7) {
        this.f4758a = f7;
    }

    @Override // k4.c
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f4758a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f4758a == ((g) obj).f4758a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4758a)});
    }
}
