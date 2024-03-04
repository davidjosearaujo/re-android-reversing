package n3;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.s0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final LinearInterpolator f5161a = new LinearInterpolator();

    /* renamed from: b */
    public static final c2.b f5162b = new c2.b();

    /* renamed from: c */
    public static final c2.a f5163c = new c2.a();

    /* renamed from: d */
    public static final c2.c f5164d = new c2.c();
    public static final DecelerateInterpolator e = new DecelerateInterpolator();

    public static float a(float f7, float f8, float f9, float f10, float f11) {
        return f11 <= f9 ? f7 : f11 >= f10 ? f8 : s0.f(f8, f7, (f11 - f9) / (f10 - f9), f7);
    }

    public static int b(int i7, int i8, float f7) {
        return Math.round(f7 * (i8 - i7)) + i7;
    }
}
