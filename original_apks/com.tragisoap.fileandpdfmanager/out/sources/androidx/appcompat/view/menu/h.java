package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import j1.a;
import k1.b;
import p1.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h implements b {
    public p1.b A;
    public MenuItem.OnActionExpandListener B;

    /* renamed from: a */
    public final int f603a;

    /* renamed from: b */
    public final int f604b;

    /* renamed from: c */
    public final int f605c;

    /* renamed from: d */
    public final int f606d;
    public CharSequence e;

    /* renamed from: f */
    public CharSequence f607f;

    /* renamed from: g */
    public Intent f608g;

    /* renamed from: h */
    public char f609h;

    /* renamed from: j */
    public char f611j;

    /* renamed from: l */
    public Drawable f613l;

    /* renamed from: n */
    public f f614n;

    /* renamed from: o */
    public m f615o;

    /* renamed from: p */
    public MenuItem.OnMenuItemClickListener f616p;

    /* renamed from: q */
    public CharSequence f617q;

    /* renamed from: r */
    public CharSequence f618r;

    /* renamed from: y */
    public int f624y;

    /* renamed from: z */
    public View f625z;

    /* renamed from: i */
    public int f610i = 4096;

    /* renamed from: k */
    public int f612k = 4096;
    public int m = 0;
    public ColorStateList s = null;

    /* renamed from: t */
    public PorterDuff.Mode f619t = null;

    /* renamed from: u */
    public boolean f620u = false;

    /* renamed from: v */
    public boolean f621v = false;

    /* renamed from: w */
    public boolean f622w = false;

    /* renamed from: x */
    public int f623x = 16;
    public boolean C = false;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements b.a {
        public a() {
            h.this = r1;
        }
    }

    public h(f fVar, int i7, int i8, int i9, int i10, CharSequence charSequence, int i11) {
        this.f614n = fVar;
        this.f603a = i8;
        this.f604b = i7;
        this.f605c = i9;
        this.f606d = i10;
        this.e = charSequence;
        this.f624y = i11;
    }

    public static void c(int i7, int i8, String str, StringBuilder sb) {
        if ((i7 & i8) == i8) {
            sb.append(str);
        }
    }

    @Override // k1.b
    public final k1.b a(p1.b bVar) {
        p1.b bVar2 = this.A;
        if (bVar2 != null) {
            bVar2.f5469a = null;
        }
        this.f625z = null;
        this.A = bVar;
        this.f614n.p(true);
        p1.b bVar3 = this.A;
        if (bVar3 != null) {
            bVar3.h(new a());
        }
        return this;
    }

    @Override // k1.b
    public final p1.b b() {
        return this.A;
    }

    @Override // k1.b, android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f624y & 8) == 0) {
            return false;
        }
        if (this.f625z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f614n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f622w && (this.f620u || this.f621v)) {
            drawable = drawable.mutate();
            if (this.f620u) {
                a.b.h(drawable, this.s);
            }
            if (this.f621v) {
                a.b.i(drawable, this.f619t);
            }
            this.f622w = false;
        }
        return drawable;
    }

    public final boolean e() {
        p1.b bVar;
        if ((this.f624y & 8) == 0) {
            return false;
        }
        if (this.f625z == null && (bVar = this.A) != null) {
            this.f625z = bVar.d(this);
        }
        return this.f625z != null;
    }

    @Override // k1.b, android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f614n.f(this);
        }
        return false;
    }

    public final void f(boolean z6) {
        this.f623x = z6 ? this.f623x | 32 : this.f623x & -33;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // k1.b, android.view.MenuItem
    public final View getActionView() {
        View view = this.f625z;
        if (view != null) {
            return view;
        }
        p1.b bVar = this.A;
        if (bVar == null) {
            return null;
        }
        View d7 = bVar.d(this);
        this.f625z = d7;
        return d7;
    }

    @Override // k1.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f612k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f611j;
    }

    @Override // k1.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f617q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f604b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f613l;
        if (drawable != null) {
            return d(drawable);
        }
        int i7 = this.m;
        if (i7 == 0) {
            return null;
        }
        Drawable a7 = g.a.a(this.f614n.f579a, i7);
        this.m = 0;
        this.f613l = a7;
        return d(a7);
    }

    @Override // k1.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.s;
    }

    @Override // k1.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f619t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f608g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.f603a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // k1.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f610i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f609h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f605c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f615o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f607f;
        return charSequence != null ? charSequence : this.e;
    }

    @Override // k1.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f618r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f615o != null;
    }

    @Override // k1.b, android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f623x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f623x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f623x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        p1.b bVar = this.A;
        return (bVar == null || !bVar.g()) ? (this.f623x & 8) == 0 : (this.f623x & 8) == 0 && this.A.b();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setActionView(int i7) {
        int i8;
        Context context = this.f614n.f579a;
        View inflate = LayoutInflater.from(context).inflate(i7, (ViewGroup) new LinearLayout(context), false);
        this.f625z = inflate;
        this.A = null;
        if (inflate != null && inflate.getId() == -1 && (i8 = this.f603a) > 0) {
            inflate.setId(i8);
        }
        f fVar = this.f614n;
        fVar.f588k = true;
        fVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c7) {
        if (this.f611j == c7) {
            return this;
        }
        this.f611j = Character.toLowerCase(c7);
        this.f614n.p(false);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c7, int i7) {
        if (this.f611j == c7 && this.f612k == i7) {
            return this;
        }
        this.f611j = Character.toLowerCase(c7);
        this.f612k = KeyEvent.normalizeMetaState(i7);
        this.f614n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z6) {
        int i7 = this.f623x;
        int i8 = (z6 ? 1 : 0) | (i7 & -2);
        this.f623x = i8;
        if (i7 != i8) {
            this.f614n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z6) {
        int i7 = this.f623x;
        int i8 = 2;
        if ((i7 & 4) != 0) {
            f fVar = this.f614n;
            fVar.getClass();
            int i9 = this.f604b;
            int size = fVar.f583f.size();
            fVar.w();
            for (int i10 = 0; i10 < size; i10++) {
                h hVar = fVar.f583f.get(i10);
                if (hVar.f604b == i9) {
                    boolean z7 = true;
                    if (((hVar.f623x & 4) != 0) && hVar.isCheckable()) {
                        if (hVar != this) {
                            z7 = false;
                        }
                        int i11 = hVar.f623x;
                        int i12 = (z7 ? 2 : 0) | (i11 & -3);
                        hVar.f623x = i12;
                        if (i11 != i12) {
                            hVar.f614n.p(false);
                        }
                    }
                }
            }
            fVar.v();
        } else {
            int i13 = i7 & -3;
            if (!z6) {
                i8 = 0;
            }
            int i14 = i8 | i13;
            this.f623x = i14;
            if (i7 != i14) {
                this.f614n.p(false);
            }
        }
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    /* renamed from: setContentDescription */
    public final k1.b mo11setContentDescription(CharSequence charSequence) {
        this.f617q = charSequence;
        this.f614n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z6) {
        this.f623x = z6 ? this.f623x | 16 : this.f623x & -17;
        this.f614n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i7) {
        this.f613l = null;
        this.m = i7;
        this.f622w = true;
        this.f614n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.f613l = drawable;
        this.f622w = true;
        this.f614n.p(false);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.s = colorStateList;
        this.f620u = true;
        this.f622w = true;
        this.f614n.p(false);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f619t = mode;
        this.f621v = true;
        this.f622w = true;
        this.f614n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f608g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c7) {
        if (this.f609h == c7) {
            return this;
        }
        this.f609h = c7;
        this.f614n.p(false);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c7, int i7) {
        if (this.f609h == c7 && this.f610i == i7) {
            return this;
        }
        this.f609h = c7;
        this.f610i = KeyEvent.normalizeMetaState(i7);
        this.f614n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f616p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c7, char c8) {
        this.f609h = c7;
        this.f611j = Character.toLowerCase(c8);
        this.f614n.p(false);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f609h = c7;
        this.f610i = KeyEvent.normalizeMetaState(i7);
        this.f611j = Character.toLowerCase(c8);
        this.f612k = KeyEvent.normalizeMetaState(i8);
        this.f614n.p(false);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    public final void setShowAsAction(int i7) {
        int i8 = i7 & 3;
        if (i8 == 0 || i8 == 1 || i8 == 2) {
            this.f624y = i7;
            f fVar = this.f614n;
            fVar.f588k = true;
            fVar.p(true);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i7) {
        setShowAsAction(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i7) {
        setTitle(this.f614n.f579a.getString(i7));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.f614n.p(false);
        m mVar = this.f615o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f607f = charSequence;
        this.f614n.p(false);
        return this;
    }

    @Override // k1.b, android.view.MenuItem
    /* renamed from: setTooltipText */
    public final k1.b mo12setTooltipText(CharSequence charSequence) {
        this.f618r = charSequence;
        this.f614n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z6) {
        int i7 = this.f623x;
        boolean z7 = false;
        int i8 = (z6 ? 0 : 8) | (i7 & -9);
        this.f623x = i8;
        if (i7 != i8) {
            z7 = true;
        }
        if (z7) {
            f fVar = this.f614n;
            fVar.f585h = true;
            fVar.p(true);
        }
        return this;
    }

    @Override // java.lang.Object
    public final String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // k1.b, android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i7;
        this.f625z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i7 = this.f603a) > 0) {
            view.setId(i7);
        }
        f fVar = this.f614n;
        fVar.f588k = true;
        fVar.p(true);
        return this;
    }
}
