package com.google.android.material.appbar;

import a0.e;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import j1.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l0.z;
import o3.d;
import p1.k;
import p1.k0;
import p1.y;
import q1.f;

/* loaded from: classes.dex */
public final class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: f */
    public int f2751f;

    /* renamed from: g */
    public int f2752g;

    /* renamed from: h */
    public int f2753h;

    /* renamed from: i */
    public int f2754i;

    /* renamed from: j */
    public boolean f2755j;

    /* renamed from: k */
    public int f2756k;

    /* renamed from: l */
    public boolean f2757l;
    public boolean m;

    /* renamed from: n */
    public boolean f2758n;

    /* renamed from: o */
    public boolean f2759o;

    /* renamed from: p */
    public int f2760p;

    /* renamed from: q */
    public WeakReference f2761q;

    /* renamed from: r */
    public ValueAnimator f2762r;
    public int[] s;

    /* renamed from: t */
    public Drawable f2763t;

    /* renamed from: u */
    public Behavior f2764u;

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends o3.a {

        /* renamed from: o */
        public int f2765o;

        /* renamed from: p */
        public int f2766p;

        /* renamed from: q */
        public ValueAnimator f2767q;

        /* renamed from: r */
        public b f2768r;
        public WeakReference s;

        /* renamed from: t */
        public boolean f2769t;

        /* loaded from: classes.dex */
        public class a extends p1.a {
            public a() {
            }

            public final void d(View view, f fVar) {
                this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
                fVar.f5624a.setScrollable(BaseBehavior.this.f2769t);
                fVar.h(ScrollView.class.getName());
            }
        }

        /* loaded from: classes.dex */
        public static class b extends Kotlin_2.a {
            public static final Parcelable.Creator CREATOR = new a();

            /* renamed from: h */
            public boolean f2771h;

            /* renamed from: i */
            public boolean f2772i;

            /* renamed from: j */
            public int f2773j;

            /* renamed from: k */
            public float f2774k;

            /* renamed from: l */
            public boolean f2775l;

            /* loaded from: classes.dex */
            public class a implements Parcelable.ClassLoaderCreator {
                public final Object createFromParcel(Parcel parcel) {
                    return new b(parcel, null);
                }

                public final Object[] newArray(int i7) {
                    return new b[i7];
                }

                public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new b(parcel, classLoader);
                }
            }

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f2771h = parcel.readByte() != 0;
                this.f2772i = parcel.readByte() != 0;
                this.f2773j = parcel.readInt();
                this.f2774k = parcel.readFloat();
                this.f2775l = parcel.readByte() != 0;
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }

            public final void writeToParcel(Parcel parcel, int i7) {
                parcel.writeParcelable(this.f6374f, i7);
                parcel.writeByte(this.f2771h ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f2772i ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f2773j);
                parcel.writeFloat(this.f2774k);
                parcel.writeByte(this.f2775l ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static View G(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = coordinatorLayout.getChildAt(i7);
                if ((childAt instanceof k) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void L(androidx.coordinatorlayout.widget.CoordinatorLayout r7, com.google.android.material.appbar.AppBarLayout r8, int r9, int r10, boolean r11) {
            /*
                int r0 = java.lang.Math.abs(r9)
                int r1 = r8.getChildCount()
                r2 = 0
                r3 = r2
            La:
                r4 = 0
                if (r3 >= r1) goto L21
                android.view.View r5 = r8.getChildAt(r3)
                int r6 = r5.getTop()
                if (r0 < r6) goto L1e
                int r6 = r5.getBottom()
                if (r0 > r6) goto L1e
                goto L22
            L1e:
                int r3 = r3 + 1
                goto La
            L21:
                r5 = r4
            L22:
                r0 = 1
                if (r5 == 0) goto L5e
                android.view.ViewGroup$LayoutParams r1 = r5.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$c r1 = (com.google.android.material.appbar.AppBarLayout.c) r1
                int r1 = r1.f2778a
                r3 = r1 & 1
                if (r3 == 0) goto L5e
                java.util.WeakHashMap<android.view.View, p1.k0> r3 = p1.y.f5540a
                int r3 = p1.y.d.d(r5)
                if (r10 <= 0) goto L4b
                r10 = r1 & 12
                if (r10 == 0) goto L4b
                int r9 = -r9
                int r10 = r5.getBottom()
                int r10 = r10 - r3
                int r1 = r8.getTopInset()
                int r10 = r10 - r1
                if (r9 < r10) goto L5e
                goto L5c
            L4b:
                r10 = r1 & 2
                if (r10 == 0) goto L5e
                int r9 = -r9
                int r10 = r5.getBottom()
                int r10 = r10 - r3
                int r1 = r8.getTopInset()
                int r10 = r10 - r1
                if (r9 < r10) goto L5e
            L5c:
                r9 = r0
                goto L5f
            L5e:
                r9 = r2
            L5f:
                boolean r10 = r8.f2759o
                if (r10 == 0) goto L6b
                android.view.View r9 = G(r7)
                boolean r9 = r8.d(r9)
            L6b:
                boolean r9 = r8.c(r9)
                if (r11 != 0) goto Lb3
                if (r9 == 0) goto Lda
                w0.c r9 = r7.f1424g
                java.lang.Object r9 = r9.f6338b
                o.h r9 = (o.h) r9
                java.lang.Object r9 = r9.getOrDefault(r8, r4)
                java.util.List r9 = (java.util.List) r9
                java.util.ArrayList r10 = r7.f1426i
                r10.clear()
                if (r9 == 0) goto L8b
                java.util.ArrayList r10 = r7.f1426i
                r10.addAll(r9)
            L8b:
                java.util.ArrayList r7 = r7.f1426i
                int r9 = r7.size()
                r10 = r2
            L92:
                if (r10 >= r9) goto Lb1
                java.lang.Object r11 = r7.get(r10)
                android.view.View r11 = (android.view.View) r11
                android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$f r11 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r11
                androidx.coordinatorlayout.widget.CoordinatorLayout$c r11 = r11.f1442a
                boolean r1 = r11 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r1 == 0) goto Lae
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r11 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r11
                int r7 = r11.f5327k
                if (r7 == 0) goto Lb1
                r2 = r0
                goto Lb1
            Lae:
                int r10 = r10 + 1
                goto L92
            Lb1:
                if (r2 == 0) goto Lda
            Lb3:
                android.graphics.drawable.Drawable r7 = r8.getBackground()
                if (r7 == 0) goto Lc0
                android.graphics.drawable.Drawable r7 = r8.getBackground()
                r7.jumpToCurrentState()
            Lc0:
                android.graphics.drawable.Drawable r7 = r8.getForeground()
                if (r7 == 0) goto Lcd
                android.graphics.drawable.Drawable r7 = r8.getForeground()
                r7.jumpToCurrentState()
            Lcd:
                android.animation.StateListAnimator r7 = r8.getStateListAnimator()
                if (r7 == 0) goto Lda
                android.animation.StateListAnimator r7 = r8.getStateListAnimator()
                r7.jumpToCurrentState()
            Lda:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.L(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        public final int A(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        public final int B() {
            return w() + this.f2765o;
        }

        public final void C(View view, CoordinatorLayout coordinatorLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            J(coordinatorLayout, appBarLayout);
            if (appBarLayout.f2759o) {
                appBarLayout.c(appBarLayout.d(G(coordinatorLayout)));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0167  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0190  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int D(androidx.coordinatorlayout.widget.CoordinatorLayout r19, android.view.View r20, int r21, int r22, int r23) {
            /*
                Method dump skipped, instructions count: 412
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void F(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i7) {
            int abs = Math.abs(B() - i7);
            float abs2 = Math.abs(0.0f);
            int round = abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int B = B();
            if (B == i7) {
                ValueAnimator valueAnimator = this.f2767q;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f2767q.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f2767q;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f2767q = valueAnimator3;
                valueAnimator3.setInterpolator(n3.a.e);
                this.f2767q.addUpdateListener(new com.google.android.material.appbar.a(this, coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f2767q.setDuration(Math.min(round, 600));
            this.f2767q.setIntValues(B, i7);
            this.f2767q.start();
        }

        public final void H(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i7, int[] iArr) {
            int i8;
            int i9;
            if (i7 != 0) {
                if (i7 < 0) {
                    i8 = -appBarLayout.getTotalScrollRange();
                    i9 = appBarLayout.getDownNestedPreScrollRange() + i8;
                } else {
                    i8 = -appBarLayout.getUpNestedPreScrollRange();
                    i9 = 0;
                }
                int i10 = i8;
                int i11 = i9;
                if (i10 != i11) {
                    iArr[1] = D(coordinatorLayout, appBarLayout, B() - i7, i10, i11);
                }
            }
            if (appBarLayout.f2759o) {
                appBarLayout.c(appBarLayout.d(view));
            }
        }

        public final b I(Parcelable parcelable, AppBarLayout appBarLayout) {
            int w6 = w();
            int childCount = appBarLayout.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = appBarLayout.getChildAt(i7);
                int bottom = childAt.getBottom() + w6;
                if (childAt.getTop() + w6 <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = Kotlin_2.a.f6373g;
                    }
                    b bVar = new b(parcelable);
                    boolean z6 = w6 == 0;
                    bVar.f2772i = z6;
                    bVar.f2771h = !z6 && (-w6) >= appBarLayout.getTotalScrollRange();
                    bVar.f2773j = i7;
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    bVar.f2775l = bottom == appBarLayout.getTopInset() + y.d.d(childAt);
                    bVar.f2774k = bottom / childAt.getHeight();
                    return bVar;
                }
            }
            return null;
        }

        public final void J(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int B = B() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i7 = 0;
            while (true) {
                if (i7 >= childCount) {
                    i7 = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i7);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                c cVar = (c) childAt.getLayoutParams();
                if ((cVar.f2778a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) cVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) cVar).bottomMargin;
                }
                int i8 = -B;
                if (top <= i8 && bottom >= i8) {
                    break;
                }
                i7++;
            }
            if (i7 >= 0) {
                View childAt2 = appBarLayout.getChildAt(i7);
                c cVar2 = (c) childAt2.getLayoutParams();
                int i9 = cVar2.f2778a;
                if ((i9 & 17) == 17) {
                    int i10 = -childAt2.getTop();
                    int i11 = -childAt2.getBottom();
                    if (i7 == 0) {
                        WeakHashMap<View, k0> weakHashMap = y.f5540a;
                        if (y.d.b(appBarLayout) && y.d.b(childAt2)) {
                            i10 -= appBarLayout.getTopInset();
                        }
                    }
                    if ((i9 & 2) == 2) {
                        WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                        i11 += y.d.d(childAt2);
                    } else {
                        if ((i9 & 5) == 5) {
                            WeakHashMap<View, k0> weakHashMap3 = y.f5540a;
                            int d7 = y.d.d(childAt2) + i11;
                            if (B < d7) {
                                i10 = d7;
                            } else {
                                i11 = d7;
                            }
                        }
                    }
                    if ((i9 & 32) == 32) {
                        i10 += ((LinearLayout.LayoutParams) cVar2).topMargin;
                        i11 -= ((LinearLayout.LayoutParams) cVar2).bottomMargin;
                    }
                    if (B < (i11 + i10) / 2) {
                        i10 = i11;
                    }
                    F(coordinatorLayout, appBarLayout, e.k(i10 + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        public final void K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            View view;
            boolean z6;
            boolean z7;
            y.g(coordinatorLayout, f.a.f5627f.a());
            boolean z8 = false;
            y.e(coordinatorLayout, 0);
            y.g(coordinatorLayout, f.a.f5628g.a());
            y.e(coordinatorLayout, 0);
            if (appBarLayout.getTotalScrollRange() == 0) {
                return;
            }
            int childCount = coordinatorLayout.getChildCount();
            int i7 = 0;
            while (true) {
                view = null;
                if (i7 >= childCount) {
                    break;
                }
                view = coordinatorLayout.getChildAt(i7);
                if (((CoordinatorLayout.f) view.getLayoutParams()).f1442a instanceof ScrollingViewBehavior) {
                    break;
                }
                i7++;
            }
            View view2 = view;
            if (view2 == null) {
                return;
            }
            int childCount2 = appBarLayout.getChildCount();
            int i8 = 0;
            while (true) {
                z6 = true;
                if (i8 >= childCount2) {
                    z7 = false;
                    break;
                } else if (((c) appBarLayout.getChildAt(i8).getLayoutParams()).f2778a != 0) {
                    z7 = true;
                    break;
                } else {
                    i8++;
                }
            }
            if (z7) {
                if (!(y.m.a(coordinatorLayout) != null)) {
                    y.i(coordinatorLayout, new a());
                }
                if (B() != (-appBarLayout.getTotalScrollRange())) {
                    y.h(coordinatorLayout, f.a.f5627f, new com.google.android.material.appbar.c(appBarLayout, false));
                    z8 = true;
                }
                if (B() != 0) {
                    if (view2.canScrollVertically(-1)) {
                        int i9 = -appBarLayout.getDownNestedPreScrollRange();
                        if (i9 != 0) {
                            y.h(coordinatorLayout, f.a.f5628g, new com.google.android.material.appbar.b(this, coordinatorLayout, appBarLayout, view2, i9));
                        }
                    } else {
                        y.h(coordinatorLayout, f.a.f5628g, new com.google.android.material.appbar.c(appBarLayout, true));
                    }
                    this.f2769t = z6;
                }
                z6 = z8;
                this.f2769t = z6;
            }
        }

        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
            int i8;
            int round;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.l(coordinatorLayout, appBarLayout, i7);
            int pendingAction = appBarLayout.getPendingAction();
            b bVar = this.f2768r;
            if (bVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z6 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        i8 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z6) {
                            F(coordinatorLayout, appBarLayout, i8);
                        }
                        E(coordinatorLayout, appBarLayout, i8);
                    } else if ((pendingAction & 1) != 0) {
                        if (z6) {
                            F(coordinatorLayout, appBarLayout, 0);
                        }
                        E(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (bVar.f2771h) {
                i8 = -appBarLayout.getTotalScrollRange();
                E(coordinatorLayout, appBarLayout, i8);
            } else {
                if (!bVar.f2772i) {
                    View childAt = appBarLayout.getChildAt(bVar.f2773j);
                    int i9 = -childAt.getBottom();
                    if (this.f2768r.f2775l) {
                        WeakHashMap<View, k0> weakHashMap = y.f5540a;
                        round = appBarLayout.getTopInset() + y.d.d(childAt) + i9;
                    } else {
                        round = Math.round(childAt.getHeight() * this.f2768r.f2774k) + i9;
                    }
                    E(coordinatorLayout, appBarLayout, round);
                }
                E(coordinatorLayout, appBarLayout, 0);
            }
            appBarLayout.f2756k = 0;
            this.f2768r = null;
            int k6 = e.k(w(), -appBarLayout.getTotalScrollRange(), 0);
            d dVar = this.f5328f;
            if (dVar == null) {
                this.f5329g = k6;
            } else if (dVar.f5333d != k6) {
                dVar.f5333d = k6;
                dVar.a();
            }
            L(coordinatorLayout, appBarLayout, w(), 0, true);
            appBarLayout.f2751f = w();
            if (!appBarLayout.willNotDraw()) {
                WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                y.d.k(appBarLayout);
            }
            K(coordinatorLayout, appBarLayout);
            return true;
        }

        public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height == -2) {
                coordinatorLayout.r(appBarLayout, i7, i8, View.MeasureSpec.makeMeasureSpec(0, 0));
                return true;
            }
            return false;
        }

        public final /* bridge */ /* synthetic */ void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int[] iArr, int i9) {
            H(coordinatorLayout, (AppBarLayout) view, view2, i8, iArr);
        }

        public final void p(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i9 < 0) {
                iArr[1] = D(coordinatorLayout, appBarLayout, B() - i9, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i9 == 0) {
                K(coordinatorLayout, appBarLayout);
            }
        }

        public final void r(View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!(parcelable instanceof b)) {
                this.f2768r = null;
                return;
            }
            b bVar = this.f2768r;
            this.f2768r = (b) parcelable;
        }

        public final Parcelable s(View view) {
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            b I = I(absSavedState, (AppBarLayout) view);
            return I == null ? absSavedState : I;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
            if (((r3.getTotalScrollRange() != 0) && r2.getHeight() - r4.getHeight() <= r3.getHeight()) != false) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean t(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4, android.view.View r5, int r6, int r7) {
            /*
                r1 = this;
                com.google.android.material.appbar.AppBarLayout r3 = (com.google.android.material.appbar.AppBarLayout) r3
                r5 = r6 & 2
                r6 = 1
                r0 = 0
                if (r5 == 0) goto L2c
                boolean r5 = r3.f2759o
                if (r5 != 0) goto L2d
                int r5 = r3.getTotalScrollRange()
                if (r5 == 0) goto L14
                r5 = r6
                goto L15
            L14:
                r5 = r0
            L15:
                if (r5 == 0) goto L28
                int r2 = r2.getHeight()
                int r4 = r4.getHeight()
                int r2 = r2 - r4
                int r3 = r3.getHeight()
                if (r2 > r3) goto L28
                r2 = r6
                goto L29
            L28:
                r2 = r0
            L29:
                if (r2 == 0) goto L2c
                goto L2d
            L2c:
                r6 = r0
            L2d:
                if (r6 == 0) goto L36
                android.animation.ValueAnimator r2 = r1.f2767q
                if (r2 == 0) goto L36
                r2.cancel()
            L36:
                r2 = 0
                r1.s = r2
                r1.f2766p = r7
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.t(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, android.view.View, int, int):boolean");
        }

        public final void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i7) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f2766p == 0 || i7 == 1) {
                J(coordinatorLayout, appBarLayout);
                if (appBarLayout.f2759o) {
                    appBarLayout.c(appBarLayout.d(view2));
                }
            }
            this.s = new WeakReference(view2);
        }

        public final boolean y(View view) {
            View view2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            WeakReference weakReference = this.s;
            return weakReference == null || !((view2 = (View) weakReference.get()) == null || !view2.isShown() || view2.canScrollVertically(-1));
        }

        public final int z(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            return appBarLayout.getTopInset() + (-appBarLayout.getDownNestedScrollRange());
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends o3.b {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4934v);
            this.f5327k = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }

        public final int A(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : view.getMeasuredHeight();
        }

        public final boolean f(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int k6;
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) view2.getLayoutParams()).f1442a;
            if (cVar instanceof BaseBehavior) {
                int bottom = (view2.getBottom() - view.getTop()) + ((BaseBehavior) cVar).f2765o + this.f5326j;
                if (this.f5327k == 0) {
                    k6 = 0;
                } else {
                    float z6 = z(view2);
                    int i7 = this.f5327k;
                    k6 = e.k((int) (z6 * i7), 0, i7);
                }
                int i8 = bottom - k6;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                view.offsetTopAndBottom(i8);
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.f2759o) {
                    appBarLayout.c(appBarLayout.d(view));
                }
            }
            return false;
        }

        public final void i(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                y.g(coordinatorLayout, f.a.f5627f.a());
                y.e(coordinatorLayout, 0);
                y.g(coordinatorLayout, f.a.f5628g.a());
                y.e(coordinatorLayout, 0);
                y.i(coordinatorLayout, null);
            }
        }

        public final boolean q(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z6) {
            AppBarLayout appBarLayout;
            ArrayList e = coordinatorLayout.e(view);
            int size = e.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    appBarLayout = null;
                    break;
                }
                View view2 = (View) e.get(i7);
                if (view2 instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) view2;
                    break;
                }
                i7++;
            }
            if (appBarLayout != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.f5324h;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayout.f2756k = 2 | (z6 ^ true ? 4 : 0) | 8;
                    appBarLayout.requestLayout();
                    return true;
                }
            }
            return false;
        }

        public final AppBarLayout y(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = (View) arrayList.get(i7);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public final float z(View view) {
            int i7;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                CoordinatorLayout.c cVar = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f1442a;
                int B = cVar instanceof BaseBehavior ? ((BaseBehavior) cVar).B() : 0;
                if ((downNestedPreScrollRange == 0 || totalScrollRange + B > downNestedPreScrollRange) && (i7 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (B / i7) + 1.0f;
                }
            }
            return 0.0f;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a {
    }

    /* loaded from: classes.dex */
    public static class b extends a {

        /* renamed from: a */
        public final Rect f2776a = new Rect();

        /* renamed from: b */
        public final Rect f2777b = new Rect();
    }

    /* loaded from: classes.dex */
    public static class c extends LinearLayout.LayoutParams {

        /* renamed from: a */
        public int f2778a;

        /* renamed from: b */
        public b f2779b;

        /* renamed from: c */
        public Interpolator f2780c;

        public c() {
            super(-1, -2);
            this.f2778a = 1;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2778a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4916a);
            this.f2778a = obtainStyledAttributes.getInt(1, 0);
            this.f2779b = obtainStyledAttributes.getInt(0, 0) != 1 ? null : new b();
            if (obtainStyledAttributes.hasValue(2)) {
                this.f2780c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(2, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2778a = 1;
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2778a = 1;
        }

        public c(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2778a = 1;
        }
    }

    public static c a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new c((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public final void b() {
        Behavior behavior = this.f2764u;
        BaseBehavior.b I = (behavior == null || this.f2752g == -1 || this.f2756k != 0) ? null : behavior.I(Kotlin_2.a.f6373g, this);
        this.f2752g = -1;
        this.f2753h = -1;
        this.f2754i = -1;
        if (I != null) {
            Behavior behavior2 = this.f2764u;
            if (behavior2.f2768r != null) {
                return;
            }
            behavior2.f2768r = I;
        }
    }

    public final boolean c(boolean z6) {
        if (!(!this.f2757l) || this.f2758n == z6) {
            return false;
        }
        this.f2758n = z6;
        refreshDrawableState();
        if ((getBackground() instanceof k4.f) && this.f2759o) {
            ValueAnimator valueAnimator = this.f2762r;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
            this.f2762r = ofFloat;
            ofFloat.setDuration(0L);
            this.f2762r.setInterpolator(null);
            this.f2762r.start();
            return true;
        }
        return true;
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public final boolean d(View view) {
        int i7;
        if (this.f2761q == null && (i7 = this.f2760p) != -1) {
            View findViewById = view != null ? view.findViewById(i7) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f2760p);
            }
            if (findViewById != null) {
                this.f2761q = new WeakReference(findViewById);
            }
        }
        WeakReference weakReference = this.f2761q;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2763t != null && getTopInset() > 0) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f2751f);
            this.f2763t.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2763t;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                return !y.d.b(childAt);
            }
            return false;
        }
        return false;
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public CoordinatorLayout.c getBehavior() {
        Behavior behavior = new Behavior();
        this.f2764u = behavior;
        return behavior;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getDownNestedPreScrollRange() {
        /*
            r9 = this;
            int r0 = r9.f2753h
            r1 = -1
            if (r0 == r1) goto L6
            return r0
        L6:
            int r0 = r9.getChildCount()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        Le:
            if (r0 < 0) goto L69
            android.view.View r3 = r9.getChildAt(r0)
            int r4 = r3.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1d
            goto L66
        L1d:
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            com.google.android.material.appbar.AppBarLayout$c r4 = (com.google.android.material.appbar.AppBarLayout.c) r4
            int r5 = r3.getMeasuredHeight()
            int r6 = r4.f2778a
            r7 = r6 & 5
            r8 = 5
            if (r7 != r8) goto L63
            int r7 = r4.topMargin
            int r4 = r4.bottomMargin
            int r7 = r7 + r4
            r4 = r6 & 8
            if (r4 == 0) goto L3f
            java.util.WeakHashMap<android.view.View, p1.k0> r4 = p1.y.f5540a
            int r4 = p1.y.d.d(r3)
        L3d:
            int r4 = r4 + r7
            goto L4e
        L3f:
            r4 = r6 & 2
            if (r4 == 0) goto L4c
            java.util.WeakHashMap<android.view.View, p1.k0> r4 = p1.y.f5540a
            int r4 = p1.y.d.d(r3)
            int r4 = r5 - r4
            goto L3d
        L4c:
            int r4 = r7 + r5
        L4e:
            if (r0 != 0) goto L61
            java.util.WeakHashMap<android.view.View, p1.k0> r6 = p1.y.f5540a
            boolean r3 = p1.y.d.b(r3)
            if (r3 == 0) goto L61
            int r3 = r9.getTopInset()
            int r5 = r5 - r3
            int r4 = java.lang.Math.min(r4, r5)
        L61:
            int r2 = r2 + r4
            goto L66
        L63:
            if (r2 <= 0) goto L66
            goto L69
        L66:
            int r0 = r0 + (-1)
            goto Le
        L69:
            int r0 = java.lang.Math.max(r1, r2)
            r9.f2753h = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.getDownNestedPreScrollRange():int");
    }

    public int getDownNestedScrollRange() {
        int i7 = this.f2754i;
        if (i7 != -1) {
            return i7;
        }
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin + childAt.getMeasuredHeight();
                int i10 = cVar.f2778a;
                if ((i10 & 1) == 0) {
                    break;
                }
                i9 += measuredHeight;
                if ((i10 & 2) != 0) {
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    i9 -= y.d.d(childAt);
                    break;
                }
            }
            i8++;
        }
        int max = Math.max(0, i9);
        this.f2754i = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f2760p;
    }

    public k4.f getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof k4.f) {
            return (k4.f) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        int d7 = y.d.d(this);
        if (d7 == 0) {
            int childCount = getChildCount();
            d7 = childCount >= 1 ? y.d.d(getChildAt(childCount - 1)) : 0;
            if (d7 == 0) {
                return getHeight() / 3;
            }
        }
        return (d7 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f2756k;
    }

    public Drawable getStatusBarForeground() {
        return this.f2763t;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        return 0;
    }

    public final int getTotalScrollRange() {
        int i7 = this.f2752g;
        if (i7 != -1) {
            return i7;
        }
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = cVar.f2778a;
                if ((i10 & 1) == 0) {
                    break;
                }
                int i11 = measuredHeight + ((LinearLayout.LayoutParams) cVar).topMargin + ((LinearLayout.LayoutParams) cVar).bottomMargin + i9;
                if (i8 == 0) {
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    if (y.d.b(childAt)) {
                        i11 -= getTopInset();
                    }
                }
                i9 = i11;
                if ((i10 & 2) != 0) {
                    WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                    i9 -= y.d.d(childAt);
                    break;
                }
            }
            i8++;
        }
        int max = Math.max(0, i9);
        this.f2752g = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof k4.f) {
            q2.a.L(this, (k4.f) background);
        }
    }

    public final int[] onCreateDrawableState(int i7) {
        if (this.s == null) {
            this.s = new int[4];
        }
        int[] iArr = this.s;
        int[] onCreateDrawableState = super.onCreateDrawableState(i7 + iArr.length);
        boolean z6 = this.m;
        iArr[0] = z6 ? 2130904102 : -2130904102;
        iArr[1] = (z6 && this.f2758n) ? 2130904103 : -2130904103;
        iArr[2] = z6 ? 2130904098 : -2130904098;
        iArr[3] = (z6 && this.f2758n) ? 2130904097 : -2130904097;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f2761q;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2761q = null;
    }

    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        boolean z7;
        super.onLayout(z6, i7, i8, i9, i10);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        boolean z8 = true;
        if (y.d.b(this) && e()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                getChildAt(childCount).offsetTopAndBottom(topInset);
            }
        }
        b();
        this.f2755j = false;
        int childCount2 = getChildCount();
        int i11 = 0;
        while (true) {
            if (i11 >= childCount2) {
                break;
            } else if (((c) getChildAt(i11).getLayoutParams()).f2780c != null) {
                this.f2755j = true;
                break;
            } else {
                i11++;
            }
        }
        Drawable drawable = this.f2763t;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f2757l) {
            return;
        }
        if (!this.f2759o) {
            int childCount3 = getChildCount();
            int i12 = 0;
            while (true) {
                if (i12 >= childCount3) {
                    z7 = false;
                    break;
                }
                int i13 = ((c) getChildAt(i12).getLayoutParams()).f2778a;
                if ((i13 & 1) == 1 && (i13 & 10) != 0) {
                    z7 = true;
                    break;
                }
                i12++;
            }
            if (!z7) {
                z8 = false;
            }
        }
        if (this.m != z8) {
            this.m = z8;
            refreshDrawableState();
        }
    }

    public final void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        int mode = View.MeasureSpec.getMode(i8);
        if (mode != 1073741824) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            if (y.d.b(this) && e()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = e.k(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i8));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        b();
    }

    public void setElevation(float f7) {
        super.setElevation(f7);
        Drawable background = getBackground();
        if (background instanceof k4.f) {
            ((k4.f) background).j(f7);
        }
    }

    public void setExpanded(boolean z6) {
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        this.f2756k = (z6 ? 1 : 2) | (y.g.c(this) ? 4 : 0) | 8;
        requestLayout();
    }

    public void setLiftOnScroll(boolean z6) {
        this.f2759o = z6;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f2760p = -1;
        if (view != null) {
            this.f2761q = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.f2761q;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2761q = null;
    }

    public void setLiftOnScrollTargetViewId(int i7) {
        this.f2760p = i7;
        WeakReference weakReference = this.f2761q;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f2761q = null;
    }

    public void setLiftableOverrideEnabled(boolean z6) {
        this.f2757l = z6;
    }

    public void setOrientation(int i7) {
        if (i7 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i7);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f2763t;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f2763t = mutate;
            if (mutate instanceof k4.f) {
                int i7 = ((k4.f) mutate).f4738z;
            } else {
                ColorStateList a7 = z3.a.a(mutate);
                if (a7 != null) {
                    a7.getDefaultColor();
                }
            }
            Drawable drawable3 = this.f2763t;
            boolean z6 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f2763t.setState(getDrawableState());
                }
                Drawable drawable4 = this.f2763t;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                a.c.b(drawable4, y.e.d(this));
                this.f2763t.setVisible(getVisibility() == 0, false);
                this.f2763t.setCallback(this);
            }
            if (this.f2763t != null && getTopInset() > 0) {
                z6 = true;
            }
            setWillNotDraw(!z6);
            WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
            y.d.k(this);
        }
    }

    public void setStatusBarForegroundColor(int i7) {
        setStatusBarForeground(new ColorDrawable(i7));
    }

    public void setStatusBarForegroundResource(int i7) {
        setStatusBarForeground(g.a.a(getContext(), i7));
    }

    @Deprecated
    public void setTargetElevation(float f7) {
        int integer = getResources().getInteger(2131361794);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j5 = integer;
        stateListAnimator.addState(new int[]{16842910, 2130904102, -2130904103}, ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(j5));
        stateListAnimator.addState(new int[]{16842910}, ObjectAnimator.ofFloat(this, "elevation", f7).setDuration(j5));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(0L));
        setStateListAnimator(stateListAnimator);
    }

    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z6 = i7 == 0;
        Drawable drawable = this.f2763t;
        if (drawable != null) {
            drawable.setVisible(z6, false);
        }
    }

    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2763t;
    }

    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }
}
