package f;

import android.app.Dialog;
import androidx.fragment.app.m;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class o extends m {
    @Override // androidx.fragment.app.m
    public Dialog Q() {
        return new n(j(), this.f1680b0);
    }

    @Override // androidx.fragment.app.m
    public final void S(Dialog dialog, int i7) {
        if (dialog instanceof n) {
            n nVar = (n) dialog;
            if (!(i7 == 1 || i7 == 2)) {
                if (i7 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            nVar.f().t(1);
            return;
        }
        super.S(dialog, i7);
    }
}
