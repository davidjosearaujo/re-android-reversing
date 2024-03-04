package e5;

import android.app.Dialog;
import android.view.View;

/* loaded from: classes.dex */
public final class t implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ Dialog f3858f;

    public t(Dialog dialog) {
        this.f3858f = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3858f.dismiss();
    }
}
