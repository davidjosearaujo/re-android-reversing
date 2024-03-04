package u0;

import a0.b;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import f5.g;
import l0.o;
import p1.n;
import q5.l;
import r5.h;
import t0.c;

/* loaded from: classes.dex */
public class a extends ViewGroup implements n {

    /* renamed from: f */
    public q5.a<g> f6071f;

    /* renamed from: g */
    public q5.a<g> f6072g;

    /* renamed from: h */
    public q5.a<g> f6073h;

    /* renamed from: i */
    public x.a f6074i;

    /* renamed from: j */
    public l<? super x.a, g> f6075j;

    /* renamed from: k */
    public c f6076k;

    /* renamed from: l */
    public l<? super c, g> f6077l;
    public androidx.lifecycle.n m;

    /* renamed from: n */
    public h2.c f6078n;

    /* renamed from: o */
    public l<? super Boolean, g> f6079o;

    @Override // p1.m
    public final void a(View view, View view2, int i7, int i8) {
        h.f(view, "child");
        h.f(view2, "target");
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(null);
        throw null;
    }

    public final c getDensity() {
        return this.f6076k;
    }

    public final View getInteropView() {
        return null;
    }

    public final o getLayoutNode() {
        return null;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        throw null;
    }

    public final androidx.lifecycle.n getLifecycleOwner() {
        return this.m;
    }

    public final x.a getModifier() {
        return this.f6074i;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        throw null;
    }

    public final l<c, g> getOnDensityChanged$ui_release() {
        return this.f6077l;
    }

    public final l<x.a, g> getOnModifierChanged$ui_release() {
        return this.f6075j;
    }

    public final l<Boolean, g> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.f6079o;
    }

    public final q5.a<g> getRelease() {
        return this.f6073h;
    }

    public final q5.a<g> getReset() {
        return this.f6072g;
    }

    public final h2.c getSavedStateRegistryOwner() {
        return this.f6078n;
    }

    public final q5.a<g> getUpdate() {
        return this.f6071f;
    }

    public final View getView() {
        return null;
    }

    @Override // p1.m
    public final void i(View view, int i7) {
        h.f(view, "target");
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        throw null;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        throw null;
    }

    @Override // p1.m
    public final void j(View view, int i7, int i8, int[] iArr, int i9) {
        h.f(view, "target");
        throw null;
    }

    @Override // p1.n
    public final void m(View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        h.f(view, "target");
        throw null;
    }

    @Override // p1.m
    public final void n(View view, int i7, int i8, int i9, int i10, int i11) {
        h.f(view, "target");
        throw null;
    }

    @Override // p1.m
    public final boolean o(View view, View view2, int i7, int i8) {
        h.f(view, "child");
        h.f(view2, "target");
        return ((i7 & 2) == 0 && (i7 & 1) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View view, View view2) {
        h.f(view, "child");
        h.f(view2, "target");
        super.onDescendantInvalidated(view, view2);
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        throw null;
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f7, float f8, boolean z6) {
        h.f(view, "target");
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f7, float f8) {
        h.f(view, "target");
        throw null;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i7) {
        super.onWindowVisibilityChanged(i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z6) {
        l<? super Boolean, g> lVar = this.f6079o;
        if (lVar != null) {
            lVar.k(Boolean.valueOf(z6));
        }
        super.requestDisallowInterceptTouchEvent(z6);
    }

    public final void setDensity(c cVar) {
        h.f(cVar, "value");
        if (cVar != this.f6076k) {
            this.f6076k = cVar;
            l<? super c, g> lVar = this.f6077l;
            if (lVar != null) {
                lVar.k(cVar);
            }
        }
    }

    public final void setLifecycleOwner(androidx.lifecycle.n nVar) {
        if (nVar != this.m) {
            this.m = nVar;
            b.B(this, nVar);
        }
    }

    public final void setModifier(x.a aVar) {
        h.f(aVar, "value");
        if (aVar != this.f6074i) {
            this.f6074i = aVar;
            l<? super x.a, g> lVar = this.f6075j;
            if (lVar != null) {
                lVar.k(aVar);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(l<? super c, g> lVar) {
        this.f6077l = lVar;
    }

    public final void setOnModifierChanged$ui_release(l<? super x.a, g> lVar) {
        this.f6075j = lVar;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(l<? super Boolean, g> lVar) {
        this.f6079o = lVar;
    }

    public final void setRelease(q5.a<g> aVar) {
        h.f(aVar, "<set-?>");
        this.f6073h = aVar;
    }

    public final void setReset(q5.a<g> aVar) {
        h.f(aVar, "<set-?>");
        this.f6072g = aVar;
    }

    public final void setSavedStateRegistryOwner(h2.c cVar) {
        if (cVar != this.f6078n) {
            this.f6078n = cVar;
            b.C(this, cVar);
        }
    }

    public final void setUpdate(q5.a<g> aVar) {
        h.f(aVar, "value");
        this.f6071f = aVar;
        throw null;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }
}
