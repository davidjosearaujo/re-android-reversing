package q4;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import i.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f5670a = {16842752, 2130904227};

    /* renamed from: b  reason: collision with root package name */
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
        resourceId2 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
        }
        if (resourceId2 != 0) {
            cVar.getTheme().applyStyle(resourceId2, true);
        }
        return cVar;
    }
}
