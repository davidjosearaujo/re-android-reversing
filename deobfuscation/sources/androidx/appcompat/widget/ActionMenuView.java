package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.l0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ActionMenuView extends l0 implements f.b, androidx.appcompat.view.menu.k {
    public f.a A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public e F;

    /* renamed from: u */
    public androidx.appcompat.view.menu.f f703u;

    /* renamed from: v */
    public Context f704v;

    /* renamed from: w */
    public int f705w;

    /* renamed from: x */
    public boolean f706x;

    /* renamed from: y */
    public androidx.appcompat.widget.c f707y;

    /* renamed from: z */
    public j.a f708z;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();

        boolean b();
    }

    /* loaded from: classes.dex */
    public static class b implements j.a {
        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z6) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends l0.a {
        @ViewDebug.ExportedProperty

        /* renamed from: a */
        public boolean f709a;
        @ViewDebug.ExportedProperty

        /* renamed from: b */
        public int f710b;
        @ViewDebug.ExportedProperty

        /* renamed from: c */
        public int f711c;
        @ViewDebug.ExportedProperty

        /* renamed from: d */
        public boolean f712d;
        @ViewDebug.ExportedProperty
        public boolean e;

        /* renamed from: f */
        public boolean f713f;

        public c() {
            super(-2, -2);
            this.f709a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f709a = cVar.f709a;
        }
    }

    /* loaded from: classes.dex */
    public class d implements f.a {
        public d() {
            ActionMenuView.this = r1;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            boolean z6;
            boolean onMenuItemSelected;
            e eVar = ActionMenuView.this.F;
            if (eVar != null) {
                Toolbar.a aVar = (Toolbar.a) eVar;
                Iterator<p1.j> it = Toolbar.this.L.f5491a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z6 = false;
                        break;
                    } else if (it.next().b()) {
                        z6 = true;
                        break;
                    }
                }
                if (z6) {
                    onMenuItemSelected = true;
                } else {
                    Toolbar.h hVar = Toolbar.this.N;
                    onMenuItemSelected = hVar != null ? f.u.this.f4021b.onMenuItemSelected(0, menuItem) : false;
                }
                return onMenuItemSelected;
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f fVar) {
            f.a aVar = ActionMenuView.this.A;
            if (aVar != null) {
                aVar.b(fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
    }

    public ActionMenuView() {
        throw null;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f7 = context.getResources().getDisplayMetrics().density;
        this.D = (int) (56.0f * f7);
        this.E = (int) (f7 * 4.0f);
        this.f704v = context;
        this.f705w = 0;
    }

    public static c j(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            c cVar = new c();
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
            return cVar;
        }
        c cVar2 = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar2).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar2).gravity = 16;
        }
        return cVar2;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean a(androidx.appcompat.view.menu.h hVar) {
        return this.f703u.q(hVar, null, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public final void b(androidx.appcompat.view.menu.f fVar) {
        this.f703u = fVar;
    }

    @Override // androidx.appcompat.widget.l0, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.l0
    public final l0.a f() {
        c cVar = new c();
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.l0
    public final l0.a g(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.l0, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        c cVar = new c();
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.l0, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.l0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    public Menu getMenu() {
        if (this.f703u == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
            this.f703u = fVar;
            fVar.e = new d();
            androidx.appcompat.widget.c cVar = new androidx.appcompat.widget.c(context);
            this.f707y = cVar;
            cVar.f842q = true;
            cVar.f843r = true;
            j.a aVar = this.f708z;
            if (aVar == null) {
                aVar = new b();
            }
            cVar.f533j = aVar;
            this.f703u.b(cVar, this.f704v);
            androidx.appcompat.widget.c cVar2 = this.f707y;
            cVar2.m = this;
            this.f703u = cVar2.f531h;
        }
        return this.f703u;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        androidx.appcompat.widget.c cVar = this.f707y;
        c.d dVar = cVar.f839n;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (cVar.f841p) {
            return cVar.f840o;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f705w;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.l0
    public final /* bridge */ /* synthetic */ l0.a h(ViewGroup.LayoutParams layoutParams) {
        return j(layoutParams);
    }

    public final boolean k(int i7) {
        boolean z6 = false;
        if (i7 == 0) {
            return false;
        }
        View childAt = getChildAt(i7 - 1);
        View childAt2 = getChildAt(i7);
        if (i7 < getChildCount() && (childAt instanceof a)) {
            z6 = false | ((a) childAt).a();
        }
        return (i7 <= 0 || !(childAt2 instanceof a)) ? z6 : z6 | ((a) childAt2).b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.c cVar = this.f707y;
        if (cVar != null) {
            cVar.f();
            if (this.f707y.g()) {
                this.f707y.d();
                this.f707y.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.c cVar = this.f707y;
        if (cVar != null) {
            cVar.d();
            c.a aVar = cVar.f849y;
            if (aVar == null || !aVar.b()) {
                return;
            }
            aVar.f635j.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.l0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        int width;
        int i11;
        if (!this.B) {
            super.onLayout(z6, i7, i8, i9, i10);
            return;
        }
        int childCount = getChildCount();
        int i12 = (i10 - i8) / 2;
        int dividerWidth = getDividerWidth();
        int i13 = i9 - i7;
        int paddingRight = (i13 - getPaddingRight()) - getPaddingLeft();
        boolean a7 = g1.a(this);
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f709a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (k(i16)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a7) {
                        i11 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = i11 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        i11 = width - measuredWidth;
                    }
                    int i17 = i12 - (measuredHeight / 2);
                    childAt.layout(i11, i17, width, measuredHeight + i17);
                    paddingRight -= measuredWidth;
                    i14 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    k(i16);
                    i15++;
                }
            }
        }
        if (childCount == 1 && i14 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i18 = (i13 / 2) - (measuredWidth2 / 2);
            int i19 = i12 - (measuredHeight2 / 2);
            childAt2.layout(i18, i19, measuredWidth2 + i18, measuredHeight2 + i19);
            return;
        }
        int i20 = i15 - (i14 ^ 1);
        int max = Math.max(0, i20 > 0 ? paddingRight / i20 : 0);
        if (a7) {
            int width2 = getWidth() - getPaddingRight();
            for (int i21 = 0; i21 < childCount; i21++) {
                View childAt3 = getChildAt(i21);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f709a) {
                    int i22 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i23 = i12 - (measuredHeight3 / 2);
                    childAt3.layout(i22 - measuredWidth3, i23, i22, measuredHeight3 + i23);
                    width2 = i22 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i24 = 0; i24 < childCount; i24++) {
            View childAt4 = getChildAt(i24);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f709a) {
                int i25 = paddingLeft + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i26 = i12 - (measuredHeight4 / 2);
                childAt4.layout(i25, i26, i25 + measuredWidth4, measuredHeight4 + i26);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + max + i25;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r12v31 */
    @Override // androidx.appcompat.widget.l0, android.view.View
    public final void onMeasure(int i7, int i8) {
        int i9;
        int i10;
        ?? r12;
        int i11;
        int i12;
        int i13;
        int i14;
        androidx.appcompat.view.menu.f fVar;
        boolean z6 = this.B;
        boolean z7 = View.MeasureSpec.getMode(i7) == 1073741824;
        this.B = z7;
        if (z6 != z7) {
            this.C = 0;
        }
        int size = View.MeasureSpec.getSize(i7);
        if (this.B && (fVar = this.f703u) != null && size != this.C) {
            this.C = size;
            fVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.B || childCount <= 0) {
            for (int i15 = 0; i15 < childCount; i15++) {
                c cVar = (c) getChildAt(i15).getLayoutParams();
                ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
            }
            super.onMeasure(i7, i8);
            return;
        }
        int mode = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i7);
        int size3 = View.MeasureSpec.getSize(i8);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, paddingBottom, -2);
        int i16 = size2 - paddingRight;
        int i17 = this.D;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = (i19 / i18) + i17;
        int childCount2 = getChildCount();
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        boolean z8 = false;
        int i25 = 0;
        long j5 = 0;
        while (i24 < childCount2) {
            View childAt = getChildAt(i24);
            int i26 = size3;
            if (childAt.getVisibility() == 8) {
                i12 = mode;
                i11 = i16;
                i13 = paddingBottom;
            } else {
                boolean z9 = childAt instanceof ActionMenuItemView;
                int i27 = i22 + 1;
                if (z9) {
                    int i28 = this.E;
                    i10 = i27;
                    r12 = 0;
                    childAt.setPadding(i28, 0, i28, 0);
                } else {
                    i10 = i27;
                    r12 = 0;
                }
                c cVar2 = (c) childAt.getLayoutParams();
                cVar2.f713f = r12;
                cVar2.f711c = r12;
                cVar2.f710b = r12;
                cVar2.f712d = r12;
                ((LinearLayout.LayoutParams) cVar2).leftMargin = r12;
                ((LinearLayout.LayoutParams) cVar2).rightMargin = r12;
                cVar2.e = z9 && ((ActionMenuItemView) childAt).p();
                int i29 = cVar2.f709a ? 1 : i18;
                i11 = i16;
                c cVar3 = (c) childAt.getLayoutParams();
                i12 = mode;
                i13 = paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z9 ? (ActionMenuItemView) childAt : null;
                boolean z10 = actionMenuItemView != null && actionMenuItemView.p();
                if (i29 <= 0 || (z10 && i29 < 2)) {
                    i14 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i29 * i20, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i14 = measuredWidth / i20;
                    if (measuredWidth % i20 != 0) {
                        i14++;
                    }
                    if (z10 && i14 < 2) {
                        i14 = 2;
                    }
                }
                cVar3.f712d = !cVar3.f709a && z10;
                cVar3.f710b = i14;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i20 * i14, 1073741824), makeMeasureSpec);
                i23 = Math.max(i23, i14);
                if (cVar2.f712d) {
                    i25++;
                }
                if (cVar2.f709a) {
                    z8 = true;
                }
                i18 -= i14;
                i21 = Math.max(i21, childAt.getMeasuredHeight());
                if (i14 == 1) {
                    j5 |= 1 << i24;
                }
                i22 = i10;
            }
            i24++;
            size3 = i26;
            paddingBottom = i13;
            i16 = i11;
            mode = i12;
        }
        int i30 = mode;
        int i31 = i16;
        int i32 = size3;
        boolean z11 = z8 && i22 == 2;
        boolean z12 = false;
        while (i25 > 0 && i18 > 0) {
            int i33 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            int i34 = 0;
            long j7 = 0;
            for (int i35 = 0; i35 < childCount2; i35++) {
                c cVar4 = (c) getChildAt(i35).getLayoutParams();
                if (cVar4.f712d) {
                    int i36 = cVar4.f710b;
                    if (i36 < i33) {
                        j7 = 1 << i35;
                        i33 = i36;
                        i34 = 1;
                    } else if (i36 == i33) {
                        i34++;
                        j7 |= 1 << i35;
                    }
                }
            }
            j5 |= j7;
            if (i34 > i18) {
                break;
            }
            int i37 = i33 + 1;
            int i38 = 0;
            while (i38 < childCount2) {
                View childAt2 = getChildAt(i38);
                c cVar5 = (c) childAt2.getLayoutParams();
                int i39 = childMeasureSpec;
                int i40 = childCount2;
                long j8 = 1 << i38;
                if ((j7 & j8) != 0) {
                    if (z11 && cVar5.e && i18 == 1) {
                        int i41 = this.E;
                        childAt2.setPadding(i41 + i20, 0, i41, 0);
                    }
                    cVar5.f710b++;
                    cVar5.f713f = true;
                    i18--;
                } else if (cVar5.f710b == i37) {
                    j5 |= j8;
                }
                i38++;
                childMeasureSpec = i39;
                childCount2 = i40;
            }
            z12 = true;
        }
        int i42 = childMeasureSpec;
        int i43 = childCount2;
        boolean z13 = !z8 && i22 == 1;
        if (i18 <= 0 || j5 == 0 || (i18 >= i22 - 1 && !z13 && i23 <= 1)) {
            i9 = i43;
        } else {
            float bitCount = Long.bitCount(j5);
            if (!z13) {
                if ((j5 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).e) {
                    bitCount -= 0.5f;
                }
                int i44 = i43 - 1;
                if ((j5 & (1 << i44)) != 0 && !((c) getChildAt(i44).getLayoutParams()).e) {
                    bitCount -= 0.5f;
                }
            }
            int i45 = bitCount > 0.0f ? (int) ((i18 * i20) / bitCount) : 0;
            boolean z14 = z12;
            i9 = i43;
            for (int i46 = 0; i46 < i9; i46++) {
                if ((j5 & (1 << i46)) != 0) {
                    View childAt3 = getChildAt(i46);
                    c cVar6 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar6.f711c = i45;
                        cVar6.f713f = true;
                        if (i46 == 0 && !cVar6.e) {
                            ((LinearLayout.LayoutParams) cVar6).leftMargin = (-i45) / 2;
                        }
                        z14 = true;
                    } else {
                        if (cVar6.f709a) {
                            cVar6.f711c = i45;
                            cVar6.f713f = true;
                            ((LinearLayout.LayoutParams) cVar6).rightMargin = (-i45) / 2;
                            z14 = true;
                        } else {
                            if (i46 != 0) {
                                ((LinearLayout.LayoutParams) cVar6).leftMargin = i45 / 2;
                            }
                            if (i46 != i9 - 1) {
                                ((LinearLayout.LayoutParams) cVar6).rightMargin = i45 / 2;
                            }
                        }
                    }
                }
            }
            z12 = z14;
        }
        if (z12) {
            for (int i47 = 0; i47 < i9; i47++) {
                View childAt4 = getChildAt(i47);
                c cVar7 = (c) childAt4.getLayoutParams();
                if (cVar7.f713f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar7.f710b * i20) + cVar7.f711c, 1073741824), i42);
                }
            }
        }
        setMeasuredDimension(i31, i30 != 1073741824 ? i21 : i32);
    }

    public void setExpandedActionViewsExclusive(boolean z6) {
        this.f707y.f846v = z6;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.F = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        androidx.appcompat.widget.c cVar = this.f707y;
        c.d dVar = cVar.f839n;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        cVar.f841p = true;
        cVar.f840o = drawable;
    }

    public void setOverflowReserved(boolean z6) {
        this.f706x = z6;
    }

    public void setPopupTheme(int i7) {
        if (this.f705w != i7) {
            this.f705w = i7;
            if (i7 == 0) {
                this.f704v = getContext();
            } else {
                this.f704v = new ContextThemeWrapper(getContext(), i7);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.f707y = cVar;
        cVar.m = this;
        this.f703u = cVar.f531h;
    }
}
