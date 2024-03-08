package c2;

import android.view.animation.Interpolator;
import androidx.fragment.app.s0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f2516a;

    /* renamed from: b  reason: collision with root package name */
    public final float f2517b;

    public d(float[] fArr) {
        this.f2516a = fArr;
        this.f2517b = 1.0f / ((float) (fArr.length - 1));
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f7) {
        if (f7 >= 1.0f) {
            return 1.0f;
        }
        if (f7 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f2516a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f7), fArr.length - 2);
        float f8 = this.f2517b;
        float[] fArr2 = this.f2516a;
        float f9 = fArr2[min];
        return s0.f(fArr2[min + 1], f9, (f7 - (((float) min) * f8)) / f8, f9);
    }
}
