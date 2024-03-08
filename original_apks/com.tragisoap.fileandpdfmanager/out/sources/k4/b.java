package k4;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public final c f4717a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4718b;

    public b(float f7, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f4717a;
            f7 += ((b) cVar).f4718b;
        }
        this.f4717a = cVar;
        this.f4718b = f7;
    }

    @Override // k4.c
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f4717a.a(rectF) + this.f4718b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4717a.equals(bVar.f4717a) && this.f4718b == bVar.f4718b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4717a, Float.valueOf(this.f4718b)});
    }
}
