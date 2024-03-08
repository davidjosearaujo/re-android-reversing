package p4;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.c0;
import g4.b;
import l0.z;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends c0 {
    public a(Context context, AttributeSet attributeSet) {
        super(q4.a.a(context, attributeSet, 16842884, 0), attributeSet, 16842884);
        Context context2 = getContext();
        boolean z6 = true;
        if (b.b(context2, 2130904186, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = z.s;
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, 16842884, 0);
            int q6 = q(context2, obtainStyledAttributes, 1, 2);
            obtainStyledAttributes.recycle();
            if (!(q6 == -1 ? false : z6)) {
                TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, 16842884, 0);
                int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
                obtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    p(resourceId, theme);
                }
            }
        }
    }

    public static int q(Context context, TypedArray typedArray, int... iArr) {
        int i7 = -1;
        for (int i8 = 0; i8 < iArr.length && i7 < 0; i8++) {
            int i9 = iArr[i8];
            TypedValue typedValue = new TypedValue();
            if (!typedArray.getValue(i9, typedValue) || typedValue.type != 2) {
                i7 = typedArray.getDimensionPixelSize(i9, -1);
            } else {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                i7 = obtainStyledAttributes.getDimensionPixelSize(0, -1);
                obtainStyledAttributes.recycle();
            }
        }
        return i7;
    }

    public final void p(int i7, Resources.Theme theme) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i7, z.f4931r);
        int q6 = q(getContext(), obtainStyledAttributes, 1, 2);
        obtainStyledAttributes.recycle();
        if (q6 >= 0) {
            setLineHeight(q6);
        }
    }

    @Override // androidx.appcompat.widget.c0, android.widget.TextView
    public final void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        if (b.b(context, 2130904186, true)) {
            p(i7, context.getTheme());
        }
    }
}
