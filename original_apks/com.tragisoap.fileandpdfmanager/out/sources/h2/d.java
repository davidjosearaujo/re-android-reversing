package h2;

import android.view.View;
import android.view.ViewParent;
import q5.l;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends i implements l<View, View> {

    /* renamed from: g  reason: collision with root package name */
    public static final d f4378g = new d();

    public d() {
        super(1);
    }

    @Override // q5.l
    public final View k(View view) {
        View view2 = view;
        h.f(view2, "view");
        ViewParent parent = view2.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
