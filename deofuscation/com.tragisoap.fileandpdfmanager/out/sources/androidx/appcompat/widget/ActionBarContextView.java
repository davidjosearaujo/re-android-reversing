package androidx.appcompat.widget;

import a0.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.c;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ActionBarContextView extends a {

    /* renamed from: n */
    public CharSequence f669n;

    /* renamed from: o */
    public CharSequence f670o;

    /* renamed from: p */
    public View f671p;

    /* renamed from: q */
    public View f672q;

    /* renamed from: r */
    public View f673r;
    public LinearLayout s;

    /* renamed from: t */
    public TextView f674t;

    /* renamed from: u */
    public TextView f675u;

    /* renamed from: v */
    public int f676v;

    /* renamed from: w */
    public int f677w;

    /* renamed from: x */
    public boolean f678x;

    /* renamed from: y */
    public int f679y;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: f */
        public final /* synthetic */ i.a f680f;

        public a(i.a aVar) {
            this.f680f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f680f.c();
        }
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130903070);
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f59z, 2130903070, 0);
        Drawable drawable = (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : g.a.a(context, resourceId);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.q(this, drawable);
        this.f676v = obtainStyledAttributes.getResourceId(5, 0);
        this.f677w = obtainStyledAttributes.getResourceId(4, 0);
        this.f809j = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.f679y = obtainStyledAttributes.getResourceId(2, 2131492869);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(i.a r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f671p
            r1 = 0
            if (r0 != 0) goto L_0x0016
            android.content.Context r0 = r5.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = r5.f679y
            android.view.View r0 = r0.inflate(r2, r5, r1)
            r5.f671p = r0
            goto L_0x001e
        L_0x0016:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0021
            android.view.View r0 = r5.f671p
        L_0x001e:
            r5.addView(r0)
        L_0x0021:
            android.view.View r0 = r5.f671p
            r2 = 2131296324(0x7f090044, float:1.8210561E38)
            android.view.View r0 = r0.findViewById(r2)
            r5.f672q = r0
            androidx.appcompat.widget.ActionBarContextView$a r2 = new androidx.appcompat.widget.ActionBarContextView$a
            r2.<init>(r6)
            r0.setOnClickListener(r2)
            androidx.appcompat.view.menu.f r6 = r6.e()
            androidx.appcompat.widget.c r0 = r5.f808i
            if (r0 == 0) goto L_0x004e
            r0.d()
            androidx.appcompat.widget.c$a r0 = r0.f849y
            if (r0 == 0) goto L_0x004e
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x004e
            j.d r0 = r0.f635j
            r0.dismiss()
        L_0x004e:
            androidx.appcompat.widget.c r0 = new androidx.appcompat.widget.c
            android.content.Context r2 = r5.getContext()
            r0.<init>(r2)
            r5.f808i = r0
            r2 = 1
            r0.f842q = r2
            r0.f843r = r2
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r2 = -2
            r3 = -1
            r0.<init>(r2, r3)
            androidx.appcompat.widget.c r2 = r5.f808i
            android.content.Context r3 = r5.f806g
            r6.b(r2, r3)
            androidx.appcompat.widget.c r6 = r5.f808i
            androidx.appcompat.view.menu.k r2 = r6.m
            if (r2 != 0) goto L_0x0086
            android.view.LayoutInflater r3 = r6.f532i
            int r4 = r6.f534k
            android.view.View r1 = r3.inflate(r4, r5, r1)
            androidx.appcompat.view.menu.k r1 = (androidx.appcompat.view.menu.k) r1
            r6.m = r1
            androidx.appcompat.view.menu.f r3 = r6.f531h
            r1.b(r3)
            r6.f()
        L_0x0086:
            androidx.appcompat.view.menu.k r1 = r6.m
            if (r2 == r1) goto L_0x0090
            r2 = r1
            androidx.appcompat.widget.ActionMenuView r2 = (androidx.appcompat.widget.ActionMenuView) r2
            r2.setPresenter(r6)
        L_0x0090:
            androidx.appcompat.widget.ActionMenuView r1 = (androidx.appcompat.widget.ActionMenuView) r1
            r5.f807h = r1
            r6 = 0
            java.util.WeakHashMap<android.view.View, p1.k0> r2 = p1.y.f5540a
            p1.y.d.q(r1, r6)
            androidx.appcompat.widget.ActionMenuView r6 = r5.f807h
            r5.addView(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.f(i.a):void");
    }

    public final void g() {
        if (this.s == null) {
            LayoutInflater.from(getContext()).inflate(2131492864, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.s = linearLayout;
            this.f674t = (TextView) linearLayout.findViewById(2131296315);
            this.f675u = (TextView) this.s.findViewById(2131296314);
            if (this.f676v != 0) {
                this.f674t.setTextAppearance(getContext(), this.f676v);
            }
            if (this.f677w != 0) {
                this.f675u.setTextAppearance(getContext(), this.f677w);
            }
        }
        this.f674t.setText(this.f669n);
        this.f675u.setText(this.f670o);
        boolean z6 = !TextUtils.isEmpty(this.f669n);
        boolean z7 = !TextUtils.isEmpty(this.f670o);
        int i7 = 0;
        this.f675u.setVisibility(z7 ? 0 : 8);
        LinearLayout linearLayout2 = this.s;
        if (!z6 && !z7) {
            i7 = 8;
        }
        linearLayout2.setVisibility(i7);
        if (this.s.getParent() == null) {
            addView(this.s);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f670o;
    }

    public CharSequence getTitle() {
        return this.f669n;
    }

    public final void h() {
        removeAllViews();
        this.f673r = null;
        this.f807h = null;
        this.f808i = null;
        View view = this.f672q;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f808i;
        if (cVar != null) {
            cVar.d();
            c.a aVar = this.f808i.f849y;
            if (aVar != null && aVar.b()) {
                aVar.f635j.dismiss();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        boolean a7 = g1.a(this);
        int paddingRight = a7 ? (i9 - i7) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i10 - i8) - getPaddingTop()) - getPaddingBottom();
        View view = this.f671p;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f671p.getLayoutParams();
            int i11 = a7 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i12 = a7 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i13 = a7 ? paddingRight - i11 : paddingRight + i11;
            int d7 = a.d(this.f671p, i13, paddingTop, paddingTop2, a7) + i13;
            paddingRight = a7 ? d7 - i12 : d7 + i12;
        }
        LinearLayout linearLayout = this.s;
        if (!(linearLayout == null || this.f673r != null || linearLayout.getVisibility() == 8)) {
            paddingRight += a.d(this.s, paddingRight, paddingTop, paddingTop2, a7);
        }
        View view2 = this.f673r;
        if (view2 != null) {
            a.d(view2, paddingRight, paddingTop, paddingTop2, a7);
        }
        int paddingLeft = a7 ? getPaddingLeft() : (i9 - i7) - getPaddingRight();
        ActionMenuView actionMenuView = this.f807h;
        if (actionMenuView != null) {
            a.d(actionMenuView, paddingLeft, paddingTop, paddingTop2, !a7);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        int i9 = 1073741824;
        if (View.MeasureSpec.getMode(i7) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i8) != 0) {
            int size = View.MeasureSpec.getSize(i7);
            int i10 = this.f809j;
            if (i10 <= 0) {
                i10 = View.MeasureSpec.getSize(i8);
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i11 = i10 - paddingBottom;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE);
            View view = this.f671p;
            if (view != null) {
                int c7 = a.c(view, paddingLeft, makeMeasureSpec);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f671p.getLayoutParams();
                paddingLeft = c7 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f807h;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = a.c(this.f807h, paddingLeft, makeMeasureSpec);
            }
            LinearLayout linearLayout = this.s;
            if (linearLayout != null && this.f673r == null) {
                if (this.f678x) {
                    this.s.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.s.getMeasuredWidth();
                    boolean z6 = measuredWidth <= paddingLeft;
                    if (z6) {
                        paddingLeft -= measuredWidth;
                    }
                    this.s.setVisibility(z6 ? 0 : 8);
                } else {
                    paddingLeft = a.c(linearLayout, paddingLeft, makeMeasureSpec);
                }
            }
            View view2 = this.f673r;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i12 = layoutParams.width;
                int i13 = i12 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i12 >= 0) {
                    paddingLeft = Math.min(i12, paddingLeft);
                }
                int i14 = layoutParams.height;
                if (i14 == -2) {
                    i9 = Integer.MIN_VALUE;
                }
                if (i14 >= 0) {
                    i11 = Math.min(i14, i11);
                }
                this.f673r.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(i11, i9));
            }
            if (this.f809j <= 0) {
                int childCount = getChildCount();
                i10 = 0;
                for (int i15 = 0; i15 < childCount; i15++) {
                    int measuredHeight = getChildAt(i15).getMeasuredHeight() + paddingBottom;
                    if (measuredHeight > i10) {
                        i10 = measuredHeight;
                    }
                }
            }
            setMeasuredDimension(size, i10);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i7) {
        this.f809j = i7;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f673r;
        if (view2 != null) {
            removeView(view2);
        }
        this.f673r = view;
        if (!(view == null || (linearLayout = this.s) == null)) {
            removeView(linearLayout);
            this.s = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f670o = charSequence;
        g();
    }

    public void setTitle(CharSequence charSequence) {
        this.f669n = charSequence;
        g();
        y.j(this, charSequence);
    }

    public void setTitleOptional(boolean z6) {
        if (z6 != this.f678x) {
            requestLayout();
        }
        this.f678x = z6;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i7) {
        super.setVisibility(i7);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
