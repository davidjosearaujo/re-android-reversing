package androidx.appcompat.view.menu;

import a0.e;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.d1;
import androidx.appcompat.widget.k0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ActionMenuItemView extends c0 implements k.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: l */
    public h f502l;
    public CharSequence m;

    /* renamed from: n */
    public Drawable f503n;

    /* renamed from: o */
    public f.b f504o;

    /* renamed from: p */
    public a f505p;

    /* renamed from: q */
    public b f506q;
    public boolean s;

    /* renamed from: t */
    public int f508t;

    /* renamed from: v */
    public int f510v;

    /* renamed from: r */
    public boolean f507r = q();

    /* renamed from: u */
    public int f509u = -1;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends k0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(r1);
            ActionMenuItemView.this = r1;
        }

        @Override // androidx.appcompat.widget.k0
        public final j.f b() {
            c.a aVar;
            b bVar = ActionMenuItemView.this.f506q;
            if (bVar == null || (aVar = c.this.f849y) == null) {
                return null;
            }
            return aVar.a();
        }

        @Override // androidx.appcompat.widget.k0
        public final boolean c() {
            j.f b2;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            f.b bVar = actionMenuItemView.f504o;
            return bVar != null && bVar.a(actionMenuItemView.f502l) && (b2 = b()) != null && b2.b();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class b {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f58y, 0, 0);
        this.f508t = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.f510v = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean a() {
        return p();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public final boolean b() {
        return p() && this.f502l.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void c(h hVar) {
        this.f502l = hVar;
        setIcon(hVar.getIcon());
        setTitle(hVar.getTitleCondensed());
        setId(hVar.f603a);
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.f505p == null) {
            this.f505p = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.f502l;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        f.b bVar = this.f504o;
        if (bVar != null) {
            bVar.a(this.f502l);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f507r = q();
        r();
    }

    @Override // androidx.appcompat.widget.c0, android.widget.TextView, android.view.View
    public final void onMeasure(int i7, int i8) {
        int i9;
        boolean p6 = p();
        if (p6 && (i9 = this.f509u) >= 0) {
            super.setPadding(i9, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i7, i8);
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f508t) : this.f508t;
        if (mode != 1073741824 && this.f508t > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i8);
        }
        if (!p6 && this.f503n != null) {
            super.setPadding((getMeasuredWidth() - this.f503n.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (!this.f502l.hasSubMenu() || (aVar = this.f505p) == null || !aVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public final boolean p() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean q() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i7 = configuration.screenWidthDp;
        return i7 >= 480 || (i7 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void r() {
        boolean z6 = true;
        boolean z7 = !TextUtils.isEmpty(this.m);
        if (this.f503n != null) {
            if (!((this.f502l.f624y & 4) == 4) || (!this.f507r && !this.s)) {
                z6 = false;
            }
        }
        boolean z8 = z7 & z6;
        CharSequence charSequence = null;
        setText(z8 ? this.m : null);
        CharSequence charSequence2 = this.f502l.f617q;
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = z8 ? null : this.f502l.e;
        }
        setContentDescription(charSequence2);
        CharSequence charSequence3 = this.f502l.f618r;
        if (TextUtils.isEmpty(charSequence3)) {
            if (!z8) {
                charSequence = this.f502l.e;
            }
            d1.a(this, charSequence);
            return;
        }
        d1.a(this, charSequence3);
    }

    public void setCheckable(boolean z6) {
    }

    public void setChecked(boolean z6) {
    }

    public void setExpandedFormat(boolean z6) {
        if (this.s != z6) {
            this.s = z6;
            h hVar = this.f502l;
            if (hVar != null) {
                f fVar = hVar.f614n;
                fVar.f588k = true;
                fVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f503n = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i7 = this.f510v;
            if (intrinsicWidth > i7) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i7) / ((float) intrinsicWidth)));
                intrinsicWidth = i7;
            }
            if (intrinsicHeight > i7) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i7) / ((float) intrinsicHeight)));
            } else {
                i7 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i7);
        }
        setCompoundDrawables(drawable, null, null, null);
        r();
    }

    public void setItemInvoker(f.b bVar) {
        this.f504o = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i7, int i8, int i9, int i10) {
        this.f509u = i7;
        super.setPadding(i7, i8, i9, i10);
    }

    public void setPopupCallback(b bVar) {
        this.f506q = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.m = charSequence;
        r();
    }
}
