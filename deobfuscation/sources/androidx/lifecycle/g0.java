package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class g0 extends r5.i implements q5.l<View, View> {

    /* renamed from: g */
    public static final g0 f1868g = new g0();

    public g0() {
        super(1);
    }

    @Override // q5.l
    public final View k(View view) {
        View view2 = view;
        r5.h.f(view2, "currentView");
        ViewParent parent = view2.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
