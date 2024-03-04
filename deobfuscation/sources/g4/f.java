package g4;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;

/* loaded from: classes.dex */
public final class f {
    public static Typeface a(Configuration configuration, Typeface typeface) {
        int i7;
        if (Build.VERSION.SDK_INT < 31 || (i7 = configuration.fontWeightAdjustment) == Integer.MAX_VALUE || i7 == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, a0.e.k(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }
}