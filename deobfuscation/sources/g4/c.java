package g4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.a1;

/* loaded from: classes.dex */
public final class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        ColorStateList c7;
        return (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0 || (c7 = g1.a.c(context, resourceId)) == null) ? typedArray.getColorStateList(i7) : c7;
    }

    public static ColorStateList b(Context context, a1 a1Var, int i7) {
        int i8;
        ColorStateList c7;
        return (!a1Var.l(i7) || (i8 = a1Var.i(i7, 0)) == 0 || (c7 = g1.a.c(context, i8)) == null) ? a1Var.b(i7) : c7;
    }

    public static Drawable c(Context context, TypedArray typedArray, int i7) {
        int resourceId;
        Drawable a7;
        return (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0 || (a7 = g.a.a(context, resourceId)) == null) ? typedArray.getDrawable(i7) : a7;
    }

    public static boolean d(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }
}
