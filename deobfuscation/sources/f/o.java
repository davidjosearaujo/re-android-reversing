package f;

import android.app.Dialog;

/* loaded from: classes.dex */
public class o extends androidx.fragment.app.m {
    @Override // androidx.fragment.app.m
    public Dialog Q() {
        return new n(j(), this.f1680b0);
    }

    @Override // androidx.fragment.app.m
    public final void S(Dialog dialog, int i7) {
        if (!(dialog instanceof n)) {
            super.S(dialog, i7);
            return;
        }
        n nVar = (n) dialog;
        if (i7 != 1 && i7 != 2) {
            if (i7 != 3) {
                return;
            }
            dialog.getWindow().addFlags(24);
        }
        nVar.f().t(1);
    }
}
