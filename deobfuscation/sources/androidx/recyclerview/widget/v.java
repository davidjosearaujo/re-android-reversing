package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class v extends p1.a {

    /* renamed from: d */
    public final RecyclerView f2277d;
    public final a e;

    /* loaded from: classes.dex */
    public static class a extends p1.a {

        /* renamed from: d */
        public final v f2278d;
        public WeakHashMap e = new WeakHashMap();

        public a(v vVar) {
            this.f2278d = vVar;
        }

        @Override // p1.a
        public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
            p1.a aVar = (p1.a) this.e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // p1.a
        public final q1.g b(View view) {
            p1.a aVar = (p1.a) this.e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // p1.a
        public final void c(View view, AccessibilityEvent accessibilityEvent) {
            p1.a aVar = (p1.a) this.e.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                super.c(view, accessibilityEvent);
            }
        }

        @Override // p1.a
        public final void d(@SuppressLint({"InvalidNullabilityOverride"}) View view, @SuppressLint({"InvalidNullabilityOverride"}) q1.f fVar) {
            RecyclerView recyclerView = this.f2278d.f2277d;
            if (!(!recyclerView.f2001z || recyclerView.G || recyclerView.f1971j.g()) && this.f2278d.f2277d.getLayoutManager() != null) {
                this.f2278d.f2277d.getLayoutManager().V(view, fVar);
                p1.a aVar = (p1.a) this.e.get(view);
                if (aVar != null) {
                    aVar.d(view, fVar);
                    return;
                }
            }
            this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
        }

        @Override // p1.a
        public final void e(View view, AccessibilityEvent accessibilityEvent) {
            p1.a aVar = (p1.a) this.e.get(view);
            if (aVar != null) {
                aVar.e(view, accessibilityEvent);
            } else {
                super.e(view, accessibilityEvent);
            }
        }

        @Override // p1.a
        public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            p1.a aVar = (p1.a) this.e.get(viewGroup);
            return aVar != null ? aVar.f(viewGroup, view, accessibilityEvent) : super.f(viewGroup, view, accessibilityEvent);
        }

        @Override // p1.a
        public final boolean g(@SuppressLint({"InvalidNullabilityOverride"}) View view, int i7, @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
            RecyclerView recyclerView = this.f2278d.f2277d;
            if ((!recyclerView.f2001z || recyclerView.G || recyclerView.f1971j.g()) || this.f2278d.f2277d.getLayoutManager() == null) {
                return super.g(view, i7, bundle);
            }
            p1.a aVar = (p1.a) this.e.get(view);
            if (aVar != null) {
                if (aVar.g(view, i7, bundle)) {
                    return true;
                }
            } else if (super.g(view, i7, bundle)) {
                return true;
            }
            RecyclerView.r rVar = this.f2278d.f2277d.getLayoutManager().f2034b.f1967h;
            return false;
        }

        @Override // p1.a
        public final void h(View view, int i7) {
            p1.a aVar = (p1.a) this.e.get(view);
            if (aVar != null) {
                aVar.h(view, i7);
            } else {
                super.h(view, i7);
            }
        }

        @Override // p1.a
        public final void i(View view, AccessibilityEvent accessibilityEvent) {
            p1.a aVar = (p1.a) this.e.get(view);
            if (aVar != null) {
                aVar.i(view, accessibilityEvent);
            } else {
                super.i(view, accessibilityEvent);
            }
        }
    }

    public v(RecyclerView recyclerView) {
        this.f2277d = recyclerView;
        a aVar = this.e;
        this.e = aVar == null ? new a(this) : aVar;
    }

    @Override // p1.a
    public final void c(@SuppressLint({"InvalidNullabilityOverride"}) View view, @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = this.f2277d;
            if (!recyclerView.f2001z || recyclerView.G || recyclerView.f1971j.g()) {
                return;
            }
            RecyclerView recyclerView2 = (RecyclerView) view;
            if (recyclerView2.getLayoutManager() != null) {
                recyclerView2.getLayoutManager().T(accessibilityEvent);
            }
        }
    }

    @Override // p1.a
    public final void d(@SuppressLint({"InvalidNullabilityOverride"}) View view, @SuppressLint({"InvalidNullabilityOverride"}) q1.f fVar) {
        this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
        RecyclerView recyclerView = this.f2277d;
        if ((!recyclerView.f2001z || recyclerView.G || recyclerView.f1971j.g()) || this.f2277d.getLayoutManager() == null) {
            return;
        }
        RecyclerView.l layoutManager = this.f2277d.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f2034b;
        layoutManager.U(recyclerView2.f1967h, recyclerView2.f1974k0, fVar);
    }

    @Override // p1.a
    public final boolean g(@SuppressLint({"InvalidNullabilityOverride"}) View view, int i7, @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
        int F;
        int D;
        if (super.g(view, i7, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f2277d;
        if ((!recyclerView.f2001z || recyclerView.G || recyclerView.f1971j.g()) || this.f2277d.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.l layoutManager = this.f2277d.getLayoutManager();
        RecyclerView.r rVar = layoutManager.f2034b.f1967h;
        int i8 = layoutManager.f2045o;
        int i9 = layoutManager.f2044n;
        Rect rect = new Rect();
        if (layoutManager.f2034b.getMatrix().isIdentity() && layoutManager.f2034b.getGlobalVisibleRect(rect)) {
            i8 = rect.height();
            i9 = rect.width();
        }
        if (i7 == 4096) {
            F = layoutManager.f2034b.canScrollVertically(1) ? (i8 - layoutManager.F()) - layoutManager.C() : 0;
            if (layoutManager.f2034b.canScrollHorizontally(1)) {
                D = (i9 - layoutManager.D()) - layoutManager.E();
            }
            D = 0;
        } else if (i7 != 8192) {
            F = 0;
            D = 0;
        } else {
            F = layoutManager.f2034b.canScrollVertically(-1) ? -((i8 - layoutManager.F()) - layoutManager.C()) : 0;
            if (layoutManager.f2034b.canScrollHorizontally(-1)) {
                D = -((i9 - layoutManager.D()) - layoutManager.E());
            }
            D = 0;
        }
        if (F == 0 && D == 0) {
            return false;
        }
        layoutManager.f2034b.i0(D, F, true);
        return true;
    }
}
