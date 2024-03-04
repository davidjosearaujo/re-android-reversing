package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
import q1.f;
import x1.c;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: f */
    public c f2805f;

    /* renamed from: g */
    public boolean f2806g;

    /* renamed from: h */
    public boolean f2807h;

    /* renamed from: i */
    public int f2808i = 2;

    /* renamed from: j */
    public float f2809j = 0.5f;

    /* renamed from: k */
    public float f2810k = 0.0f;

    /* renamed from: l */
    public float f2811l = 0.5f;
    public final a m = new a();

    /* loaded from: classes.dex */
    public class a extends c.AbstractC0134c {

        /* renamed from: a */
        public int f2812a;

        /* renamed from: b */
        public int f2813b = -1;

        public a() {
            SwipeDismissBehavior.this = r1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x0012, code lost:
            if (r0 != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0017, code lost:
            if (r0 != false) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0019, code lost:
            r4 = r4.f2812a;
            r5 = r5.getWidth() + r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0021, code lost:
            r5 = r4.f2812a - r5.getWidth();
            r5 = r4.f2812a;
            r4 = r5;
         */
        @Override // x1.c.AbstractC0134c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int a(android.view.View r5, int r6) {
            /*
                r4 = this;
                java.util.WeakHashMap<android.view.View, p1.k0> r0 = p1.y.f5540a
                int r0 = p1.y.e.d(r5)
                r1 = 1
                if (r0 != r1) goto Lb
                r0 = r1
                goto Lc
            Lb:
                r0 = 0
            Lc:
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r2 = r2.f2808i
                if (r2 != 0) goto L15
                if (r0 == 0) goto L19
                goto L21
            L15:
                if (r2 != r1) goto L2f
                if (r0 == 0) goto L21
            L19:
                int r4 = r4.f2812a
                int r5 = r5.getWidth()
                int r5 = r5 + r4
                goto L3e
            L21:
                int r0 = r4.f2812a
                int r5 = r5.getWidth()
                int r5 = r0 - r5
                int r4 = r4.f2812a
                r3 = r5
                r5 = r4
                r4 = r3
                goto L3e
            L2f:
                int r0 = r4.f2812a
                int r1 = r5.getWidth()
                int r0 = r0 - r1
                int r4 = r4.f2812a
                int r5 = r5.getWidth()
                int r5 = r5 + r4
                r4 = r0
            L3e:
                int r4 = java.lang.Math.max(r4, r6)
                int r4 = java.lang.Math.min(r4, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, int):int");
        }

        @Override // x1.c.AbstractC0134c
        public final int b(View view, int i7) {
            return view.getTop();
        }

        @Override // x1.c.AbstractC0134c
        public final int c(View view) {
            return view.getWidth();
        }

        @Override // x1.c.AbstractC0134c
        public final void e(View view, int i7) {
            this.f2813b = i7;
            this.f2812a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f2807h = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f2807h = false;
            }
        }

        @Override // x1.c.AbstractC0134c
        public final void f(int i7) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // x1.c.AbstractC0134c
        public final void g(View view, int i7, int i8) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f2810k;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f2811l;
            float abs = Math.abs(i7 - this.f2812a);
            if (abs <= width) {
                view.setAlpha(1.0f);
            } else if (abs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((abs - width) / (width2 - width))), 1.0f));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:164:0x0052, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.f2812a) >= java.lang.Math.round(r8.getWidth() * com.google.android.material.behavior.SwipeDismissBehavior.this.f2809j)) goto L36;
         */
        @Override // x1.c.AbstractC0134c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void h(android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r10 = -1
                r7.f2813b = r10
                int r10 = r8.getWidth()
                r0 = 0
                int r1 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L39
                java.util.WeakHashMap<android.view.View, p1.k0> r4 = p1.y.f5540a
                int r4 = p1.y.e.d(r8)
                if (r4 != r2) goto L18
                r4 = r2
                goto L19
            L18:
                r4 = r3
            L19:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r5 = r5.f2808i
                r6 = 2
                if (r5 != r6) goto L21
                goto L54
            L21:
                if (r5 != 0) goto L2d
                if (r4 == 0) goto L2a
                int r1 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r1 >= 0) goto L56
                goto L54
            L2a:
                if (r1 <= 0) goto L56
                goto L54
            L2d:
                if (r5 != r2) goto L56
                if (r4 == 0) goto L34
                if (r1 <= 0) goto L56
                goto L54
            L34:
                int r1 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r1 >= 0) goto L56
                goto L54
            L39:
                int r1 = r8.getLeft()
                int r4 = r7.f2812a
                int r1 = r1 - r4
                int r4 = r8.getWidth()
                float r4 = (float) r4
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r5 = r5.f2809j
                float r4 = r4 * r5
                int r4 = java.lang.Math.round(r4)
                int r1 = java.lang.Math.abs(r1)
                if (r1 < r4) goto L56
            L54:
                r1 = r2
                goto L57
            L56:
                r1 = r3
            L57:
                if (r1 == 0) goto L6d
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 < 0) goto L68
                int r9 = r8.getLeft()
                int r0 = r7.f2812a
                if (r9 >= r0) goto L66
                goto L68
            L66:
                int r0 = r0 + r10
                goto L70
            L68:
                int r9 = r7.f2812a
                int r0 = r9 - r10
                goto L70
            L6d:
                int r0 = r7.f2812a
                r2 = r3
            L70:
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                x1.c r9 = r9.f2805f
                int r10 = r8.getTop()
                boolean r9 = r9.q(r0, r10)
                if (r9 == 0) goto L8b
                com.google.android.material.behavior.SwipeDismissBehavior$b r9 = new com.google.android.material.behavior.SwipeDismissBehavior$b
                com.google.android.material.behavior.SwipeDismissBehavior r7 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r9.<init>(r8, r2)
                java.util.WeakHashMap<android.view.View, p1.k0> r7 = p1.y.f5540a
                p1.y.d.m(r8, r9)
                goto L92
            L8b:
                if (r2 == 0) goto L92
                com.google.android.material.behavior.SwipeDismissBehavior r7 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r7.getClass()
            L92:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.h(android.view.View, float, float):void");
        }

        @Override // x1.c.AbstractC0134c
        public final boolean i(View view, int i7) {
            int i8 = this.f2813b;
            return (i8 == -1 || i8 == i7) && SwipeDismissBehavior.this.w(view);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f */
        public final View f2815f;

        /* renamed from: g */
        public final boolean f2816g;

        public b(View view, boolean z6) {
            SwipeDismissBehavior.this = r1;
            this.f2815f = view;
            this.f2816g = z6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = SwipeDismissBehavior.this.f2805f;
            if (cVar == null || !cVar.g()) {
                if (this.f2816g) {
                    SwipeDismissBehavior.this.getClass();
                    return;
                }
                return;
            }
            View view = this.f2815f;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.m(view, this);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v6, MotionEvent motionEvent) {
        boolean z6 = this.f2806g;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z6 = coordinatorLayout.l(v6, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f2806g = z6;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2806g = false;
        }
        if (z6) {
            if (this.f2805f == null) {
                this.f2805f = new c(coordinatorLayout.getContext(), coordinatorLayout, this.m);
            }
            return !this.f2807h && this.f2805f.r(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean l(CoordinatorLayout coordinatorLayout, V v6, int i7) {
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.d.c(v6) == 0) {
            y.d.s(v6, 1);
            y.g(v6, 1048576);
            y.e(v6, 0);
            if (w(v6)) {
                y.h(v6, f.a.f5631j, new p3.a(this));
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean v(CoordinatorLayout coordinatorLayout, V v6, MotionEvent motionEvent) {
        if (this.f2805f != null) {
            if (this.f2807h && motionEvent.getActionMasked() == 3) {
                return true;
            }
            this.f2805f.k(motionEvent);
            return true;
        }
        return false;
    }

    public boolean w(View view) {
        return true;
    }
}
