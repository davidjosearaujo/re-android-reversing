package e5;

import android.app.Dialog;
import android.view.View;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class t implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Dialog f3858f;

    public t(Dialog dialog) {
        this.f3858f = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3858f.dismiss();
    }
}
