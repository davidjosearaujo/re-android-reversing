package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class r extends PopupWindow {
    public r(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.e.O, i7, i8);
        if (obtainStyledAttributes.hasValue(2)) {
            t1.i.c(this, obtainStyledAttributes.getBoolean(2, false));
        }
        setBackgroundDrawable((!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : g.a.a(context, resourceId));
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i7, int i8) {
        super.showAsDropDown(view, i7, i8);
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i7, int i8, int i9) {
        super.showAsDropDown(view, i7, i8, i9);
    }

    @Override // android.widget.PopupWindow
    public final void update(View view, int i7, int i8, int i9, int i10) {
        super.update(view, i7, i8, i9, i10);
    }
}
