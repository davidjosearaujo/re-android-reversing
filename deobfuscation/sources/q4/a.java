package q4;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import i.c;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final int[] f5670a = {16842752, 2130904227};

    /* renamed from: b */
    public static final int[] f5671b = {2130903832};

    public static Context a(Context context, AttributeSet attributeSet, int i7, int i8) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f5671b, i7, i8);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        boolean z6 = (context instanceof c) && ((c) context).f4406a == resourceId;
        if (resourceId == 0 || z6) {
            return context;
        }
        c cVar = new c(context, resourceId);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f5670a);
        int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            cVar.getTheme().applyStyle(resourceId2, true);
        }
        return cVar;
    }
}
