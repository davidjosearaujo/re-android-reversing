package p1;

import android.view.View;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class x extends y.b<Boolean> {
    public x() {
        super(2131296823, Boolean.class, 0, 28);
    }

    @Override // p1.y.b
    public final Boolean b(View view) {
        return Boolean.valueOf(y.l.c(view));
    }

    @Override // p1.y.b
    public final void c(View view, Boolean bool) {
        y.l.g(view, bool.booleanValue());
    }

    @Override // p1.y.b
    public final boolean f(Boolean bool, Boolean bool2) {
        return !y.b.a(bool, bool2);
    }
}
