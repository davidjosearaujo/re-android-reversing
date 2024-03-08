package androidx.lifecycle;

import android.view.View;
import q5.l;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h0 extends i implements l<View, n> {

    /* renamed from: g  reason: collision with root package name */
    public static final h0 f1869g = new h0();

    public h0() {
        super(1);
    }

    @Override // q5.l
    public final n k(View view) {
        View view2 = view;
        h.f(view2, "viewParent");
        Object tag = view2.getTag(2131296915);
        if (tag instanceof n) {
            return (n) tag;
        }
        return null;
    }
}
