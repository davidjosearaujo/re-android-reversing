package j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import java.lang.reflect.Method;
import p1.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends b implements MenuItem {

    /* renamed from: d */
    public final k1.b f4559d;
    public Method e;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends p1.b {

        /* renamed from: b */
        public final ActionProvider f4560b;

        public a(ActionProvider actionProvider) {
            c.this = r1;
            this.f4560b = actionProvider;
        }

        @Override // p1.b
        public final boolean a() {
            return this.f4560b.hasSubMenu();
        }

        @Override // p1.b
        public final View c() {
            return this.f4560b.onCreateActionView();
        }

        @Override // p1.b
        public final boolean e() {
            return this.f4560b.onPerformDefaultAction();
        }

        @Override // p1.b
        public final void f(m mVar) {
            this.f4560b.onPrepareSubMenu(c.this.d(mVar));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d */
        public b.a f4562d;

        public b(c cVar, ActionProvider actionProvider) {
            super(actionProvider);
        }

        @Override // p1.b
        public final boolean b() {
            return this.f4560b.isVisible();
        }

        @Override // p1.b
        public final View d(MenuItem menuItem) {
            return this.f4560b.onCreateActionView(menuItem);
        }

        @Override // p1.b
        public final boolean g() {
            return this.f4560b.overridesItemVisibility();
        }

        @Override // p1.b
        public final void h(h.a aVar) {
            this.f4562d = aVar;
            this.f4560b.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public final void onActionProviderVisibilityChanged(boolean z6) {
            b.a aVar = this.f4562d;
            if (aVar != null) {
                f fVar = h.this.f614n;
                fVar.f585h = true;
                fVar.p(true);
            }
        }
    }

    /* renamed from: j.c$c */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0070c extends FrameLayout implements i.b {

        /* renamed from: f */
        public final CollapsibleActionView f4563f;

        public C0070c(View view) {
            super(view.getContext());
            this.f4563f = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // i.b
        public final void onActionViewCollapsed() {
            this.f4563f.onActionViewCollapsed();
        }

        @Override // i.b
        public final void onActionViewExpanded() {
            this.f4563f.onActionViewExpanded();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a */
        public final MenuItem.OnActionExpandListener f4564a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            c.this = r1;
            this.f4564a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f4564a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f4564a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        public final MenuItem.OnMenuItemClickListener f4566a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            c.this = r1;
            this.f4566a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return this.f4566a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, k1.b bVar) {
        super(context);
        if (bVar != null) {
            this.f4559d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return this.f4559d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return this.f4559d.expandActionView();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        p1.b b2 = this.f4559d.b();
        if (b2 instanceof a) {
            return ((a) b2).f4560b;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View actionView = this.f4559d.getActionView();
        return actionView instanceof C0070c ? (View) ((C0070c) actionView).f4563f : actionView;
    }

    @Override // android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f4559d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f4559d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f4559d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f4559d.getGroupId();
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f4559d.getIcon();
    }

    @Override // android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f4559d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f4559d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f4559d.getIntent();
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f4559d.getItemId();
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f4559d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f4559d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f4559d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f4559d.getOrder();
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return d(this.f4559d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f4559d.getTitle();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return this.f4559d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f4559d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f4559d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f4559d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return this.f4559d.isCheckable();
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return this.f4559d.isChecked();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return this.f4559d.isEnabled();
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return this.f4559d.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this, actionProvider);
        k1.b bVar2 = this.f4559d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i7) {
        this.f4559d.setActionView(i7);
        View actionView = this.f4559d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f4559d.setActionView(new C0070c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0070c(view);
        }
        this.f4559d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c7) {
        this.f4559d.setAlphabeticShortcut(c7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c7, int i7) {
        this.f4559d.setAlphabeticShortcut(c7, i7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z6) {
        this.f4559d.setCheckable(z6);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z6) {
        this.f4559d.setChecked(z6);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f4559d.mo11setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z6) {
        this.f4559d.setEnabled(z6);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i7) {
        this.f4559d.setIcon(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f4559d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4559d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f4559d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f4559d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c7) {
        this.f4559d.setNumericShortcut(c7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c7, int i7) {
        this.f4559d.setNumericShortcut(c7, i7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f4559d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f4559d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c7, char c8) {
        this.f4559d.setShortcut(c7, c8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f4559d.setShortcut(c7, c8, i7, i8);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i7) {
        this.f4559d.setShowAsAction(i7);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i7) {
        this.f4559d.setShowAsActionFlags(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i7) {
        this.f4559d.setTitle(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f4559d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4559d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f4559d.mo12setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z6) {
        return this.f4559d.setVisible(z6);
    }
}
