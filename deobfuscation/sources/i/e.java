package i;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import i.a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends ActionMode {

    /* renamed from: a */
    public final Context f4415a;

    /* renamed from: b */
    public final i.a f4416b;

    /* loaded from: classes.dex */
    public static class a implements a.InterfaceC0067a {

        /* renamed from: a */
        public final ActionMode.Callback f4417a;

        /* renamed from: b */
        public final Context f4418b;

        /* renamed from: c */
        public final ArrayList<e> f4419c = new ArrayList<>();

        /* renamed from: d */
        public final o.h<Menu, Menu> f4420d = new o.h<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f4418b = context;
            this.f4417a = callback;
        }

        @Override // i.a.InterfaceC0067a
        public final boolean a(i.a aVar, MenuItem menuItem) {
            return this.f4417a.onActionItemClicked(e(aVar), new j.c(this.f4418b, (k1.b) menuItem));
        }

        @Override // i.a.InterfaceC0067a
        public final boolean b(i.a aVar, androidx.appcompat.view.menu.f fVar) {
            ActionMode.Callback callback = this.f4417a;
            e e = e(aVar);
            Menu orDefault = this.f4420d.getOrDefault(fVar, null);
            if (orDefault == null) {
                orDefault = new j.e(this.f4418b, fVar);
                this.f4420d.put(fVar, orDefault);
            }
            return callback.onCreateActionMode(e, orDefault);
        }

        @Override // i.a.InterfaceC0067a
        public final void c(i.a aVar) {
            this.f4417a.onDestroyActionMode(e(aVar));
        }

        @Override // i.a.InterfaceC0067a
        public final boolean d(i.a aVar, androidx.appcompat.view.menu.f fVar) {
            ActionMode.Callback callback = this.f4417a;
            e e = e(aVar);
            Menu orDefault = this.f4420d.getOrDefault(fVar, null);
            if (orDefault == null) {
                orDefault = new j.e(this.f4418b, fVar);
                this.f4420d.put(fVar, orDefault);
            }
            return callback.onPrepareActionMode(e, orDefault);
        }

        public final e e(i.a aVar) {
            int size = this.f4419c.size();
            for (int i7 = 0; i7 < size; i7++) {
                e eVar = this.f4419c.get(i7);
                if (eVar != null && eVar.f4416b == aVar) {
                    return eVar;
                }
            }
            e eVar2 = new e(this.f4418b, aVar);
            this.f4419c.add(eVar2);
            return eVar2;
        }
    }

    public e(Context context, i.a aVar) {
        this.f4415a = context;
        this.f4416b = aVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f4416b.c();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f4416b.d();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new j.e(this.f4415a, this.f4416b.e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f4416b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f4416b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f4416b.f4403f;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f4416b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f4416b.f4404g;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f4416b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f4416b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f4416b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i7) {
        this.f4416b.l(i7);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f4416b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f4416b.f4403f = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i7) {
        this.f4416b.n(i7);
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f4416b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z6) {
        this.f4416b.p(z6);
    }
}
