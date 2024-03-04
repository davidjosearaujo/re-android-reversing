package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class b1 implements View.OnClickListener {

    /* renamed from: f */
    public final j.a f837f;

    /* renamed from: g */
    public final /* synthetic */ c1 f838g;

    public b1(c1 c1Var) {
        this.f838g = c1Var;
        this.f837f = new j.a(c1Var.f865a.getContext(), c1Var.f872i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c1 c1Var = this.f838g;
        Window.Callback callback = c1Var.f875l;
        if (callback == null || !c1Var.m) {
            return;
        }
        callback.onMenuItemSelected(0, this.f837f);
    }
}
