package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;
import j.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b1 implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final a f837f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ c1 f838g;

    public b1(c1 c1Var) {
        this.f838g = c1Var;
        this.f837f = new a(c1Var.f865a.getContext(), c1Var.f872i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c1 c1Var = this.f838g;
        Window.Callback callback = c1Var.f875l;
        if (callback != null && c1Var.m) {
            callback.onMenuItemSelected(0, this.f837f);
        }
    }
}
