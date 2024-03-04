package f;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import f.s;

/* loaded from: classes.dex */
public class n extends androidx.activity.l implements e {

    /* renamed from: i */
    public h f4001i;

    /* renamed from: j */
    public final m f4002j;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public n(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 2130903436(0x7f03018c, float:1.741369E38)
            if (r6 != 0) goto L15
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r3 = r5.getTheme()
            r3.resolveAttribute(r1, r2, r0)
            int r2 = r2.resourceId
            goto L16
        L15:
            r2 = r6
        L16:
            r4.<init>(r5, r2)
            f.m r2 = new f.m
            r2.<init>(r4)
            r4.f4002j = r2
            f.g r4 = r4.f()
            if (r6 != 0) goto L34
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            r5.resolveAttribute(r1, r6, r0)
            int r6 = r6.resourceId
        L34:
            r5 = r4
            f.h r5 = (f.h) r5
            r5.Z = r6
            r4.n()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.n.<init>(android.content.Context, int):void");
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        f().c(view, layoutParams);
    }

    @Override // f.e
    public final void d() {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        f().o();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getWindow().getDecorView();
        m mVar = this.f4002j;
        if (mVar == null) {
            return false;
        }
        return mVar.a(keyEvent);
    }

    public final g f() {
        if (this.f4001i == null) {
            s.a aVar = g.f3929f;
            this.f4001i = new h(getContext(), getWindow(), this, this);
        }
        return this.f4001i;
    }

    @Override // android.app.Dialog
    public final <T extends View> T findViewById(int i7) {
        return (T) f().e(i7);
    }

    @Override // f.e
    public final void g() {
    }

    public final boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        f().k();
    }

    @Override // f.e
    public final void j() {
    }

    @Override // androidx.activity.l, android.app.Dialog
    public void onCreate(Bundle bundle) {
        f().j();
        super.onCreate(bundle);
        f().n();
    }

    @Override // androidx.activity.l, android.app.Dialog
    public final void onStop() {
        super.onStop();
        f().r();
    }

    @Override // android.app.Dialog
    public void setContentView(int i7) {
        f().u(i7);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        f().v(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        f().w(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i7) {
        super.setTitle(i7);
        f().z(getContext().getString(i7));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        f().z(charSequence);
    }
}
