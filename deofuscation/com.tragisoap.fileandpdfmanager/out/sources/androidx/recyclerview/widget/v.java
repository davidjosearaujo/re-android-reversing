package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;
import q1.f;
import q1.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v extends p1.a {

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f2277d;
    public final a e;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends p1.a {

        /* renamed from: d  reason: collision with root package name */
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
        public final g b(View view) {
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
        public final void d(@SuppressLint({"InvalidNullabilityOverride"}) View view, @SuppressLint({"InvalidNullabilityOverride"}) f fVar) {
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
            if (!(!recyclerView.f2001z || recyclerView.G || recyclerView.f1971j.g())) {
                RecyclerView recyclerView2 = (RecyclerView) view;
                if (recyclerView2.getLayoutManager() != null) {
                    recyclerView2.getLayoutManager().T(accessibilityEvent);
                }
            }
        }
    }

    @Override // p1.a
    public final void d(@SuppressLint({"InvalidNullabilityOverride"}) View view, @SuppressLint({"InvalidNullabilityOverride"}) f fVar) {
        this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
        RecyclerView recyclerView = this.f2277d;
        if (!(!recyclerView.f2001z || recyclerView.G || recyclerView.f1971j.g()) && this.f2277d.getLayoutManager() != null) {
            RecyclerView.l layoutManager = this.f2277d.getLayoutManager();
            RecyclerView recyclerView2 = layoutManager.f2034b;
            layoutManager.U(recyclerView2.f1967h, recyclerView2.f1974k0, fVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8 A[ADDED_TO_REGION] */
    @Override // p1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(@android.annotation.SuppressLint({"InvalidNullabilityOverride"}) android.view.View r5, int r6, @android.annotation.SuppressLint({"InvalidNullabilityOverride"}) android.os.Bundle r7) {
        /*
            r4 = this;
            boolean r5 = super.g(r5, r6, r7)
            r7 = 1
            if (r5 == 0) goto L_0x0008
            return r7
        L_0x0008:
            androidx.recyclerview.widget.RecyclerView r5 = r4.f2277d
            boolean r0 = r5.f2001z
            r1 = 0
            if (r0 == 0) goto L_0x001e
            boolean r0 = r5.G
            if (r0 != 0) goto L_0x001e
            androidx.recyclerview.widget.a r5 = r5.f1971j
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r5 = r1
            goto L_0x001f
        L_0x001e:
            r5 = r7
        L_0x001f:
            if (r5 != 0) goto L_0x00c2
            androidx.recyclerview.widget.RecyclerView r5 = r4.f2277d
            androidx.recyclerview.widget.RecyclerView$l r5 = r5.getLayoutManager()
            if (r5 == 0) goto L_0x00c2
            androidx.recyclerview.widget.RecyclerView r4 = r4.f2277d
            androidx.recyclerview.widget.RecyclerView$l r4 = r4.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView r5 = r4.f2034b
            androidx.recyclerview.widget.RecyclerView$r r5 = r5.f1967h
            int r5 = r4.f2045o
            int r0 = r4.f2044n
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            androidx.recyclerview.widget.RecyclerView r3 = r4.f2034b
            android.graphics.Matrix r3 = r3.getMatrix()
            boolean r3 = r3.isIdentity()
            if (r3 == 0) goto L_0x0058
            androidx.recyclerview.widget.RecyclerView r3 = r4.f2034b
            boolean r3 = r3.getGlobalVisibleRect(r2)
            if (r3 == 0) goto L_0x0058
            int r5 = r2.height()
            int r0 = r2.width()
        L_0x0058:
            r2 = 4096(0x1000, float:5.74E-42)
            if (r6 == r2) goto L_0x008d
            r2 = 8192(0x2000, float:1.14794E-41)
            if (r6 == r2) goto L_0x0063
            r5 = r1
            r6 = r5
            goto L_0x00b6
        L_0x0063:
            androidx.recyclerview.widget.RecyclerView r6 = r4.f2034b
            r2 = -1
            boolean r6 = r6.canScrollVertically(r2)
            if (r6 == 0) goto L_0x0078
            int r6 = r4.F()
            int r5 = r5 - r6
            int r6 = r4.C()
            int r5 = r5 - r6
            int r5 = -r5
            goto L_0x0079
        L_0x0078:
            r5 = r1
        L_0x0079:
            androidx.recyclerview.widget.RecyclerView r6 = r4.f2034b
            boolean r6 = r6.canScrollHorizontally(r2)
            if (r6 == 0) goto L_0x00b5
            int r6 = r4.D()
            int r0 = r0 - r6
            int r6 = r4.E()
            int r0 = r0 - r6
            int r6 = -r0
            goto L_0x00b6
        L_0x008d:
            androidx.recyclerview.widget.RecyclerView r6 = r4.f2034b
            boolean r6 = r6.canScrollVertically(r7)
            if (r6 == 0) goto L_0x00a0
            int r6 = r4.F()
            int r5 = r5 - r6
            int r6 = r4.C()
            int r5 = r5 - r6
            goto L_0x00a1
        L_0x00a0:
            r5 = r1
        L_0x00a1:
            androidx.recyclerview.widget.RecyclerView r6 = r4.f2034b
            boolean r6 = r6.canScrollHorizontally(r7)
            if (r6 == 0) goto L_0x00b5
            int r6 = r4.D()
            int r0 = r0 - r6
            int r6 = r4.E()
            int r6 = r0 - r6
            goto L_0x00b6
        L_0x00b5:
            r6 = r1
        L_0x00b6:
            if (r5 != 0) goto L_0x00bc
            if (r6 != 0) goto L_0x00bc
            r7 = r1
            goto L_0x00c1
        L_0x00bc:
            androidx.recyclerview.widget.RecyclerView r4 = r4.f2034b
            r4.i0(r6, r5, r7)
        L_0x00c1:
            return r7
        L_0x00c2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.v.g(android.view.View, int, android.os.Bundle):boolean");
    }
}
