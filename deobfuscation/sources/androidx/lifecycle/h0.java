package androidx.lifecycle;

import android.view.View;

/* loaded from: classes.dex */
public final class h0 extends r5.i implements q5.l<View, n> {

    /* renamed from: g */
    public static final h0 f1869g = new h0();

    public h0() {
        super(1);
    }

    @Override // q5.l
    public final n k(View view) {
        View view2 = view;
        r5.h.f(view2, "viewParent");
        Object tag = view2.getTag(2131296915);
        if (tag instanceof n) {
            return (n) tag;
        }
        return null;
    }
}
