package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a */
    public static final ThreadLocal<TypedValue> f1057a = new ThreadLocal<>();

    /* renamed from: b */
    public static final int[] f1058b = {-16842910};

    /* renamed from: c */
    public static final int[] f1059c = {16842908};

    /* renamed from: d */
    public static final int[] f1060d = {16842919};
    public static final int[] e = {16842912};

    /* renamed from: f */
    public static final int[] f1061f = new int[0];

    /* renamed from: g */
    public static final int[] f1062g = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a0.e.F);
        try {
            if (!obtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i7) {
        ColorStateList d7 = d(context, i7);
        if (d7 == null || !d7.isStateful()) {
            ThreadLocal<TypedValue> threadLocal = f1057a;
            TypedValue typedValue = threadLocal.get();
            if (typedValue == null) {
                typedValue = new TypedValue();
                threadLocal.set(typedValue);
            }
            context.getTheme().resolveAttribute(16842803, typedValue, true);
            float f7 = typedValue.getFloat();
            int c7 = c(context, i7);
            return i1.a.c(c7, Math.round(Color.alpha(c7) * f7));
        }
        return d7.getColorForState(f1058b, d7.getDefaultColor());
    }

    public static int c(Context context, int i7) {
        int[] iArr = f1062g;
        iArr[0] = i7;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList d(Context context, int i7) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f1062g;
        iArr[0] = i7;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = g1.a.c(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
