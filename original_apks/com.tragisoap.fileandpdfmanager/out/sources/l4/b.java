package l4;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends d {

    /* renamed from: a  reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f5031a;

    public b(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f5031a = sideSheetBehavior;
    }

    @Override // l4.d
    public final int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // l4.d
    public final float b(int i7) {
        float f7 = (float) this.f5031a.f3238r;
        return (f7 - ((float) i7)) / (f7 - ((float) d()));
    }

    @Override // l4.d
    public final int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // l4.d
    public final int d() {
        SideSheetBehavior<? extends View> sideSheetBehavior = this.f5031a;
        return Math.max(0, (sideSheetBehavior.f3238r - sideSheetBehavior.f3237q) - sideSheetBehavior.f3239t);
    }

    @Override // l4.d
    public final int e() {
        return this.f5031a.f3238r;
    }

    @Override // l4.d
    public final int f() {
        return this.f5031a.f3238r;
    }

    @Override // l4.d
    public final int g() {
        return d();
    }

    @Override // l4.d
    public final <V extends View> int h(V v6) {
        return v6.getLeft() - this.f5031a.f3239t;
    }

    @Override // l4.d
    public final int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // l4.d
    public final int j() {
        return 0;
    }

    @Override // l4.d
    public final boolean k(float f7) {
        return f7 < 0.0f;
    }

    @Override // l4.d
    public final boolean l(View view) {
        return view.getLeft() > (d() + this.f5031a.f3238r) / 2;
    }

    @Override // l4.d
    public final boolean m(float f7, float f8) {
        if (Math.abs(f7) > Math.abs(f8)) {
            float abs = Math.abs(f7);
            this.f5031a.getClass();
            if (abs > ((float) 500)) {
                return true;
            }
        }
        return false;
    }

    @Override // l4.d
    public final boolean n(View view, float f7) {
        float abs = Math.abs((f7 * this.f5031a.f3236p) + ((float) view.getRight()));
        this.f5031a.getClass();
        return abs > 0.5f;
    }

    @Override // l4.d
    public final void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        marginLayoutParams.rightMargin = i7;
    }

    @Override // l4.d
    public final void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i7, int i8) {
        int i9 = this.f5031a.f3238r;
        if (i7 <= i9) {
            marginLayoutParams.rightMargin = i9 - i7;
        }
    }
}
