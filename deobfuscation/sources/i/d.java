package i;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionBarContextView;
import i.a;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class d extends a implements f.a {

    /* renamed from: h */
    public Context f4410h;

    /* renamed from: i */
    public ActionBarContextView f4411i;

    /* renamed from: j */
    public a.InterfaceC0067a f4412j;

    /* renamed from: k */
    public WeakReference<View> f4413k;

    /* renamed from: l */
    public boolean f4414l;
    public androidx.appcompat.view.menu.f m;

    public d(Context context, ActionBarContextView actionBarContextView, a.InterfaceC0067a interfaceC0067a) {
        this.f4410h = context;
        this.f4411i = actionBarContextView;
        this.f4412j = interfaceC0067a;
        androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(actionBarContextView.getContext());
        fVar.f589l = 1;
        this.m = fVar;
        fVar.e = this;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        return this.f4412j.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final void b(androidx.appcompat.view.menu.f fVar) {
        i();
        androidx.appcompat.widget.c cVar = this.f4411i.f808i;
        if (cVar != null) {
            cVar.l();
        }
    }

    @Override // i.a
    public final void c() {
        if (this.f4414l) {
            return;
        }
        this.f4414l = true;
        this.f4412j.c(this);
    }

    @Override // i.a
    public final View d() {
        WeakReference<View> weakReference = this.f4413k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // i.a
    public final androidx.appcompat.view.menu.f e() {
        return this.m;
    }

    @Override // i.a
    public final MenuInflater f() {
        return new f(this.f4411i.getContext());
    }

    @Override // i.a
    public final CharSequence g() {
        return this.f4411i.getSubtitle();
    }

    @Override // i.a
    public final CharSequence h() {
        return this.f4411i.getTitle();
    }

    @Override // i.a
    public final void i() {
        this.f4412j.d(this, this.m);
    }

    @Override // i.a
    public final boolean j() {
        return this.f4411i.f678x;
    }

    @Override // i.a
    public final void k(View view) {
        this.f4411i.setCustomView(view);
        this.f4413k = view != null ? new WeakReference<>(view) : null;
    }

    @Override // i.a
    public final void l(int i7) {
        m(this.f4410h.getString(i7));
    }

    @Override // i.a
    public final void m(CharSequence charSequence) {
        this.f4411i.setSubtitle(charSequence);
    }

    @Override // i.a
    public final void n(int i7) {
        o(this.f4410h.getString(i7));
    }

    @Override // i.a
    public final void o(CharSequence charSequence) {
        this.f4411i.setTitle(charSequence);
    }

    @Override // i.a
    public final void p(boolean z6) {
        this.f4404g = z6;
        this.f4411i.setTitleOptional(z6);
    }
}
