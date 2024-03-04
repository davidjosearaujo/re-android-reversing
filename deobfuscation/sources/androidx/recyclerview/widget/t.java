package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.b;

/* loaded from: classes.dex */
public final class t implements b.InterfaceC0022b {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView f2275a;

    public t(RecyclerView recyclerView) {
        this.f2275a = recyclerView;
    }

    public final int a() {
        return this.f2275a.getChildCount();
    }

    public final void b(int i7) {
        View childAt = this.f2275a.getChildAt(i7);
        if (childAt != null) {
            RecyclerView recyclerView = this.f2275a;
            recyclerView.getClass();
            RecyclerView.L(childAt);
            RecyclerView.d dVar = recyclerView.f1984q;
            childAt.clearAnimation();
        }
        this.f2275a.removeViewAt(i7);
    }
}
