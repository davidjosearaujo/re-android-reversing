package l4;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: a */
    public final SideSheetBehavior<? extends View> f5030a;

    public a(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f5030a = sideSheetBehavior;
    }

    @Override // l4.d
    public final int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // l4.d
    public final float b(int i7) {
        float e = e();
        return (i7 - e) / (d() - e);
    }

    @Override // l4.d
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // l4.d
    public final int d() {
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f5030a;
        return Math.max(0, sideSheetBehavior.s + sideSheetBehavior.f3239t);
    }

    @Override // l4.d
    public final int e() {
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f5030a;
        return (-sideSheetBehavior.f3237q) - sideSheetBehavior.f3239t;
    }

    @Override // l4.d
    public final int f() {
        return this.f5030a.f3239t;
    }

    @Override // l4.d
    public final int g() {
        return -this.f5030a.f3237q;
    }

    @Override // l4.d
    public final <V extends View> int h(V v6) {
        return v6.getRight() + this.f5030a.f3239t;
    }

    @Override // l4.d
    public final int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // l4.d
    public final int j() {
        return 1;
    }

    @Override // l4.d
    public final boolean k(float f7) {
        return f7 > 0.0f;
    }

    @Override // l4.d
    public final boolean l(View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    @Override // l4.d
    public final boolean m(float f7, float f8) {
        if (Math.abs(f7) > Math.abs(f8)) {
            float abs = Math.abs(f7);
            this.f5030a.getClass();
            if (abs > 500) {
                return true;
            }
        }
        return false;
    }

    @Override // l4.d
    public final boolean n(View view, float f7) {
        float abs = Math.abs((f7 * this.f5030a.f3236p) + view.getLeft());
        this.f5030a.getClass();
        return abs > 0.5f;
    }

    @Override // l4.d
    public final void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        marginLayoutParams.leftMargin = i7;
    }

    @Override // l4.d
    public final void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i7, int i8) {
        if (i7 <= this.f5030a.f3238r) {
            marginLayoutParams.leftMargin = i8;
        }
    }
}
