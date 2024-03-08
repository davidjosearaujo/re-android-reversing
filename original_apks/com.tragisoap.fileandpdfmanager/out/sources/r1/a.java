package r1;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {
    public static Interpolator a(float f7, float f8) {
        return new PathInterpolator(f7, f8);
    }

    public static Interpolator b(float f7, float f8, float f9, float f10) {
        return new PathInterpolator(f7, f8, f9, f10);
    }

    public static Interpolator c(Path path) {
        return new PathInterpolator(path);
    }
}
