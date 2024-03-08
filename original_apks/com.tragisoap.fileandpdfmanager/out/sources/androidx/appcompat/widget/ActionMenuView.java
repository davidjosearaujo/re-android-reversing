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
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.l0;
import f.u;
import java.util.Iterator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ActionMenuView extends l0 implements f.b, k {
    public f.a A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public e F;

    /* renamed from: u */
    public f f703u;

    /* renamed from: v */
    public Context f704v;

    /* renamed from: w */
    public int f705w;

    /* renamed from: x */
    public boolean f706x;

    /* renamed from: y */
    public c f707y;

    /* renamed from: z */
    public j.a f708z;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        boolean a();

        boolean b();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b implements j.a {
        @Override // androidx.appcompat.view.menu.j.a
        public final void a(f fVar, boolean z6) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(f fVar) {
            return false;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d implements f.a {
        public d() {
            ActionMenuView.this = r1;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(f fVar, MenuItem menuItem) {
            boolean z6;
            boolean z7;
            e eVar = ActionMenuView.this.F;
            if (eVar == null) {
                return false;
            }
            Toolbar.a aVar = (Toolbar.a) eVar;
            Iterator<p1.j> it = Toolbar.this.L.f5491a.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().b()) {
                        z6 = true;
                        break;
                    }
                } else {
                    z6 = false;
                    break;
                }
            }
            if (z6) {
                z7 = true;
            } else {
                Toolbar.h hVar = Toolbar.this.N;
                z7 = hVar != null ? u.this.f4021b.onMenuItemSelected(0, menuItem) : false;
            }
            return z7;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(f fVar) {
            f.a aVar = ActionMenuView.this.A;
            if (aVar != null) {
                aVar.b(fVar);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
        if (layoutParams != null) {
            c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
            if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
                ((LinearLayout.LayoutParams) cVar).gravity = 16;
            }
            return cVar;
        }
        c cVar2 = new c();
        ((LinearLayout.LayoutParams) cVar2).gravity = 16;
        return cVar2;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean a(h hVar) {
        return this.f703u.q(hVar, null, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public final void b(f fVar) {
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
            f fVar = new f(context);
            this.f703u = fVar;
            fVar.e = new d();
            c cVar = new c(context);
            this.f707y = cVar;
            cVar.f842q = true;
            cVar.f843r = true;
            j.a aVar = this.f708z;
            if (aVar == null) {
                aVar = new b();
            }
            cVar.f533j = aVar;
            this.f703u.b(cVar, this.f704v);
            c cVar2 = this.f707y;
            cVar2.m = this;
            this.f703u = cVar2.f531h;
        }
        return this.f703u;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        c cVar = this.f707y;
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
        c cVar = this.f707y;
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
        c cVar = this.f707y;
        if (cVar != null) {
            cVar.d();
            c.a aVar = cVar.f849y;
            if (aVar != null && aVar.b()) {
                aVar.f635j.dismiss();
            }
        }
    }

    @Override // androidx.appcompat.widget.l0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        if (!this.B) {
            super.onLayout(z6, i7, i8, i9, i10);
            return;
        }
        int childCount = getChildCount();
        int i13 = (i10 - i8) / 2;
        int dividerWidth = getDividerWidth();
        int i14 = i9 - i7;
        int paddingRight = (i14 - getPaddingRight()) - getPaddingLeft();
        boolean a7 = g1.a(this);
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f709a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (k(i17)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a7) {
                        i11 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        i12 = i11 + measuredWidth;
                    } else {
                        i12 = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        i11 = i12 - measuredWidth;
                    }
                    int i18 = i13 - (measuredHeight / 2);
                    childAt.layout(i11, i18, i12, measuredHeight + i18);
                    paddingRight -= measuredWidth;
                    i15 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    k(i17);
                    i16++;
                }
            }
        }
        if (childCount == 1 && i15 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i19 = (i14 / 2) - (measuredWidth2 / 2);
            int i20 = i13 - (measuredHeight2 / 2);
            childAt2.layout(i19, i20, measuredWidth2 + i19, measuredHeight2 + i20);
            return;
        }
        int i21 = i16 - (i15 ^ 1);
        int max = Math.max(0, i21 > 0 ? paddingRight / i21 : 0);
        if (a7) {
            int width = getWidth() - getPaddingRight();
            for (int i22 = 0; i22 < childCount; i22++) {
                View childAt3 = getChildAt(i22);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f709a) {
                    int i23 = width - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i24 = i13 - (measuredHeight3 / 2);
                    childAt3.layout(i23 - measuredWidth3, i24, i23, measuredHeight3 + i24);
                    width = i23 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i25 = 0; i25 < childCount; i25++) {
            View childAt4 = getChildAt(i25);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f709a) {
                int i26 = paddingLeft + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i27 = i13 - (measuredHeight4 / 2);
                childAt4.layout(i26, i27, i26 + measuredWidth4, measuredHeight4 + i27);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + max + i26;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r12v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // androidx.appcompat.widget.l0, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r30, int r31) {
        /*
            Method dump skipped, instructions count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.onMeasure(int, int):void");
    }

    public void setExpandedActionViewsExclusive(boolean z6) {
        this.f707y.f846v = z6;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.F = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        c cVar = this.f707y;
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

    public void setPresenter(c cVar) {
        this.f707y = cVar;
        cVar.m = this;
        this.f703u = cVar.f531h;
    }
}
