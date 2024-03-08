package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p extends q {
    public p(RecyclerView.l lVar) {
        super(lVar);
    }

    @Override // androidx.recyclerview.widget.q
    public final int b(View view) {
        this.f2269a.getClass();
        return view.getBottom() + ((RecyclerView.m) view.getLayoutParams()).f2053b.bottom + ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.q
    public final int c(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f2269a.getClass();
        Rect rect = ((RecyclerView.m) view.getLayoutParams()).f2053b;
        return view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.q
    public final int d(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        this.f2269a.getClass();
        Rect rect = ((RecyclerView.m) view.getLayoutParams()).f2053b;
        return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
    }

    @Override // androidx.recyclerview.widget.q
    public final int e(View view) {
        this.f2269a.getClass();
        return (view.getTop() - ((RecyclerView.m) view.getLayoutParams()).f2053b.top) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.q
    public final int f() {
        return this.f2269a.f2045o;
    }

    @Override // androidx.recyclerview.widget.q
    public final int g() {
        RecyclerView.l lVar = this.f2269a;
        return lVar.f2045o - lVar.C();
    }

    @Override // androidx.recyclerview.widget.q
    public final int h() {
        return this.f2269a.C();
    }

    @Override // androidx.recyclerview.widget.q
    public final int i() {
        return this.f2269a.m;
    }

    @Override // androidx.recyclerview.widget.q
    public final int j() {
        return this.f2269a.f2043l;
    }

    @Override // androidx.recyclerview.widget.q
    public final int k() {
        return this.f2269a.F();
    }

    @Override // androidx.recyclerview.widget.q
    public final int l() {
        RecyclerView.l lVar = this.f2269a;
        return (lVar.f2045o - lVar.F()) - this.f2269a.C();
    }

    @Override // androidx.recyclerview.widget.q
    public final int n(View view) {
        this.f2269a.J(view, this.f2271c);
        return this.f2271c.bottom;
    }

    @Override // androidx.recyclerview.widget.q
    public final int o(View view) {
        this.f2269a.J(view, this.f2271c);
        return this.f2271c.top;
    }

    @Override // androidx.recyclerview.widget.q
    public final void p(int i7) {
        this.f2269a.O(i7);
    }
}
