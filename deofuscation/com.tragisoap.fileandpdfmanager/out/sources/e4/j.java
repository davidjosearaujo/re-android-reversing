package e4;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.activity.h;
import androidx.fragment.app.s0;
import g4.b;
import i1.d;
import r1.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j {
    public static float a(String[] strArr, int i7) {
        float parseFloat = Float.parseFloat(strArr[i7]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static boolean b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        return str.startsWith(sb.toString()) && str.endsWith(")");
    }

    public static int c(Context context, int i7, int i8) {
        TypedValue a7 = b.a(context, i7);
        return (a7 == null || a7.type != 16) ? i8 : a7.data;
    }

    public static TimeInterpolator d(Context context, int i7, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i7, typedValue, true)) {
            return interpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (!(b(valueOf, "cubic-bezier") || b(valueOf, "path"))) {
                return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
            }
            if (b(valueOf, "cubic-bezier")) {
                String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
                if (split.length == 4) {
                    return a.b(a(split, 0), a(split, 1), a(split, 2), a(split, 3));
                }
                StringBuilder d7 = h.d("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
                d7.append(split.length);
                throw new IllegalArgumentException(d7.toString());
            } else if (b(valueOf, "path")) {
                return a.c(d.d(valueOf.substring(5, valueOf.length() - 1)));
            } else {
                throw new IllegalArgumentException(s0.h("Invalid motion easing type: ", valueOf));
            }
        } else {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
    }
}
