package n3;

import android.animation.TypeEvaluator;
import androidx.fragment.app.s0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements TypeEvaluator<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final b f5165a = new b();

    @Override // android.animation.TypeEvaluator
    public final Integer evaluate(float f7, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f8 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
        float f9 = s0.f(((float) ((intValue2 >> 24) & 255)) / 255.0f, f8, f7, f8);
        float f10 = s0.f(pow4, pow, f7, pow);
        float f11 = s0.f((float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d), pow2, f7, pow2);
        float f12 = s0.f((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d), pow3, f7, pow3);
        int round = Math.round(((float) Math.pow((double) f10, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow((double) f12, 0.45454545454545453d)) * 255.0f) | round | (Math.round(f9 * 255.0f) << 24) | (Math.round(((float) Math.pow((double) f11, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
