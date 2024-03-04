package j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import g1.a;
import j1.a;

/* loaded from: classes.dex */
public final class a implements k1.b {

    /* renamed from: a */
    public CharSequence f4542a;

    /* renamed from: b */
    public CharSequence f4543b;

    /* renamed from: c */
    public Intent f4544c;

    /* renamed from: d */
    public char f4545d;

    /* renamed from: f */
    public char f4546f;

    /* renamed from: h */
    public Drawable f4548h;

    /* renamed from: i */
    public Context f4549i;

    /* renamed from: j */
    public CharSequence f4550j;

    /* renamed from: k */
    public CharSequence f4551k;
    public int e = 4096;

    /* renamed from: g */
    public int f4547g = 4096;

    /* renamed from: l */
    public ColorStateList f4552l = null;
    public PorterDuff.Mode m = null;

    /* renamed from: n */
    public boolean f4553n = false;

    /* renamed from: o */
    public boolean f4554o = false;

    /* renamed from: p */
    public int f4555p = 16;

    public a(Context context, CharSequence charSequence) {
        this.f4549i = context;
        this.f4542a = charSequence;
    }

    @Override // k1.b
    public final k1.b a(p1.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // k1.b
    public final p1.b b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f4548h;
        if (drawable != null) {
            if (this.f4553n || this.f4554o) {
                this.f4548h = drawable;
                Drawable mutate = drawable.mutate();
                this.f4548h = mutate;
                if (this.f4553n) {
                    a.b.h(mutate, this.f4552l);
                }
                if (this.f4554o) {
                    a.b.i(this.f4548h, this.m);
                }
            }
        }
    }

    @Override // k1.b, android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // k1.b, android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // k1.b, android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // k1.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f4547g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f4546f;
    }

    @Override // k1.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f4550j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f4548h;
    }

    @Override // k1.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f4552l;
    }

    @Override // k1.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f4544c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return 16908332;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // k1.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f4545d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f4542a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f4543b;
        return charSequence != null ? charSequence : this.f4542a;
    }

    @Override // k1.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f4551k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // k1.b, android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f4555p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f4555p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f4555p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f4555p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setActionView(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c7) {
        this.f4546f = Character.toLowerCase(c7);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c7, int i7) {
        this.f4546f = Character.toLowerCase(c7);
        this.f4547g = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z6) {
        this.f4555p = (z6 ? 1 : 0) | (this.f4555p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z6) {
        this.f4555p = (z6 ? 2 : 0) | (this.f4555p & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f4550j = charSequence;
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final k1.b setContentDescription(CharSequence charSequence) {
        this.f4550j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z6) {
        this.f4555p = (z6 ? 16 : 0) | (this.f4555p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i7) {
        Context context = this.f4549i;
        Object obj = g1.a.f4192a;
        this.f4548h = a.c.b(context, i7);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f4548h = drawable;
        c();
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4552l = colorStateList;
        this.f4553n = true;
        c();
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.m = mode;
        this.f4554o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f4544c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c7) {
        this.f4545d = c7;
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c7, int i7) {
        this.f4545d = c7;
        this.e = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c7, char c8) {
        this.f4545d = c7;
        this.f4546f = Character.toLowerCase(c8);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f4545d = c7;
        this.e = KeyEvent.normalizeMetaState(i7);
        this.f4546f = Character.toLowerCase(c8);
        this.f4547g = KeyEvent.normalizeMetaState(i8);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final void setShowAsAction(int i7) {
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i7) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i7) {
        this.f4542a = this.f4549i.getResources().getString(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f4542a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4543b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f4551k = charSequence;
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final k1.b setTooltipText(CharSequence charSequence) {
        this.f4551k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z6) {
        this.f4555p = (this.f4555p & 8) | (z6 ? 0 : 8);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }
}
