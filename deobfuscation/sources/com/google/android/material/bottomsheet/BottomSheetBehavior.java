package com.google.android.material.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.s0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import k4.f;
import k4.i;
import l0.z;
import p1.a;
import p1.k0;
import p1.y;
import q1.f;
import x1.c;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c implements e4.b {
    public int A;
    public int B;
    public boolean C;
    public i D;
    public boolean E;
    public final f F;
    public ValueAnimator G;
    public int H;
    public int I;
    public int J;
    public float K;
    public int L;
    public float M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public x1.c R;
    public boolean S;
    public int T;
    public boolean U;
    public float V;
    public int W;
    public int X;
    public int Y;
    public WeakReference Z;

    /* renamed from: a0 */
    public WeakReference f2842a0;

    /* renamed from: b0 */
    public final ArrayList f2843b0;

    /* renamed from: c0 */
    public VelocityTracker f2844c0;

    /* renamed from: d0 */
    public e4.f f2845d0;

    /* renamed from: e0 */
    public int f2846e0;

    /* renamed from: f */
    public int f2847f;

    /* renamed from: f0 */
    public int f2848f0;

    /* renamed from: g */
    public boolean f2849g;

    /* renamed from: g0 */
    public boolean f2850g0;

    /* renamed from: h */
    public float f2851h;

    /* renamed from: h0 */
    public HashMap f2852h0;

    /* renamed from: i */
    public int f2853i;

    /* renamed from: i0 */
    public final SparseIntArray f2854i0;

    /* renamed from: j */
    public int f2855j;

    /* renamed from: j0 */
    public final c f2856j0;

    /* renamed from: k */
    public boolean f2857k;

    /* renamed from: l */
    public int f2858l;
    public int m;

    /* renamed from: n */
    public k4.f f2859n;

    /* renamed from: o */
    public ColorStateList f2860o;

    /* renamed from: p */
    public int f2861p;

    /* renamed from: q */
    public int f2862q;

    /* renamed from: r */
    public int f2863r;
    public boolean s;

    /* renamed from: t */
    public boolean f2864t;

    /* renamed from: u */
    public boolean f2865u;

    /* renamed from: v */
    public boolean f2866v;

    /* renamed from: w */
    public boolean f2867w;

    /* renamed from: x */
    public boolean f2868x;

    /* renamed from: y */
    public boolean f2869y;

    /* renamed from: z */
    public boolean f2870z;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f2871f;

        /* renamed from: g */
        public final /* synthetic */ int f2872g;

        public a(View view, int i7) {
            this.f2871f = view;
            this.f2872g = i7;
        }

        public final void run() {
            BottomSheetBehavior.this.N(this.f2871f, this.f2872g, false);
        }
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public final void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.L(5);
            WeakReference weakReference = BottomSheetBehavior.this.Z;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ((View) BottomSheetBehavior.this.Z.get()).requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.AbstractC0134c {
        public c() {
        }

        public final int a(View view, int i7) {
            return view.getLeft();
        }

        public final int b(View view, int i7) {
            return a0.e.k(i7, BottomSheetBehavior.this.D(), d());
        }

        public final int d() {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.N ? bottomSheetBehavior.Y : bottomSheetBehavior.L;
        }

        public final void f(int i7) {
            if (i7 == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.P) {
                    bottomSheetBehavior.L(1);
                }
            }
        }

        public final void g(View view, int i7, int i8) {
            BottomSheetBehavior.this.z(i8);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
            if (java.lang.Math.abs(r5.getTop() - r4.f2875a.D()) < java.lang.Math.abs(r5.getTop() - r4.f2875a.J)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b2, code lost:
            if (java.lang.Math.abs(r6 - r4.f2875a.J) < java.lang.Math.abs(r6 - r4.f2875a.L)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d0, code lost:
            if (java.lang.Math.abs(r6 - r7.I) < java.lang.Math.abs(r6 - r4.f2875a.L)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00df, code lost:
            if (r6 < java.lang.Math.abs(r6 - r7.L)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00f2, code lost:
            if (java.lang.Math.abs(r6 - r0) < java.lang.Math.abs(r6 - r4.f2875a.L)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
            if (r6 > r4.f2875a.J) goto L7;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void h(android.view.View r5, float r6, float r7) {
            /*
                Method dump skipped, instructions count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.h(android.view.View, float, float):void");
        }

        public final boolean i(View view, int i7) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i8 = bottomSheetBehavior.Q;
            if (i8 == 1 || bottomSheetBehavior.f2850g0) {
                return false;
            }
            if (i8 == 3 && bottomSheetBehavior.f2846e0 == i7) {
                WeakReference weakReference = bottomSheetBehavior.f2842a0;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            System.currentTimeMillis();
            WeakReference weakReference2 = BottomSheetBehavior.this.Z;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public void a(View view) {
        }

        public abstract void b(View view);

        public abstract void c(View view, int i7);
    }

    /* loaded from: classes.dex */
    public static class e extends Kotlin_2.a {
        public static final Parcelable.Creator CREATOR = new a();

        /* renamed from: h */
        public final int f2876h;

        /* renamed from: i */
        public int f2877i;

        /* renamed from: j */
        public boolean f2878j;

        /* renamed from: k */
        public boolean f2879k;

        /* renamed from: l */
        public boolean f2880l;

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator {
            public final Object createFromParcel(Parcel parcel) {
                return new e(parcel, (ClassLoader) null);
            }

            public final Object[] newArray(int i7) {
                return new e[i7];
            }

            public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2876h = parcel.readInt();
            this.f2877i = parcel.readInt();
            this.f2878j = parcel.readInt() == 1;
            this.f2879k = parcel.readInt() == 1;
            this.f2880l = parcel.readInt() == 1;
        }

        public e(AbsSavedState absSavedState, BottomSheetBehavior bottomSheetBehavior) {
            super(absSavedState);
            this.f2876h = bottomSheetBehavior.Q;
            this.f2877i = bottomSheetBehavior.f2855j;
            this.f2878j = bottomSheetBehavior.f2849g;
            this.f2879k = bottomSheetBehavior.N;
            this.f2880l = bottomSheetBehavior.O;
        }

        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeInt(this.f2876h);
            parcel.writeInt(this.f2877i);
            parcel.writeInt(this.f2878j ? 1 : 0);
            parcel.writeInt(this.f2879k ? 1 : 0);
            parcel.writeInt(this.f2880l ? 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a */
        public int f2881a;

        /* renamed from: b */
        public boolean f2882b;

        /* renamed from: c */
        public final a f2883c = new a();

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            public final void run() {
                f fVar = f.this;
                fVar.f2882b = false;
                x1.c cVar = BottomSheetBehavior.this.R;
                if (cVar != null && cVar.g()) {
                    f fVar2 = f.this;
                    fVar2.a(fVar2.f2881a);
                    return;
                }
                f fVar3 = f.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.Q == 2) {
                    bottomSheetBehavior.L(fVar3.f2881a);
                }
            }
        }

        public f() {
        }

        public final void a(int i7) {
            WeakReference weakReference = BottomSheetBehavior.this.Z;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f2881a = i7;
            if (this.f2882b) {
                return;
            }
            a aVar = this.f2883c;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.m((View) BottomSheetBehavior.this.Z.get(), aVar);
            this.f2882b = true;
        }
    }

    public BottomSheetBehavior() {
        this.f2847f = 0;
        this.f2849g = true;
        this.f2861p = -1;
        this.f2862q = -1;
        this.F = new f();
        this.K = 0.5f;
        this.M = -1.0f;
        this.P = true;
        this.Q = 4;
        this.V = 0.1f;
        this.f2843b0 = new ArrayList();
        this.f2848f0 = -1;
        this.f2854i0 = new SparseIntArray();
        this.f2856j0 = new c();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i7;
        this.f2847f = 0;
        this.f2849g = true;
        this.f2861p = -1;
        this.f2862q = -1;
        this.F = new f();
        this.K = 0.5f;
        this.M = -1.0f;
        this.P = true;
        this.Q = 4;
        this.V = 0.1f;
        this.f2843b0 = new ArrayList();
        this.f2848f0 = -1;
        this.f2854i0 = new SparseIntArray();
        this.f2856j0 = new c();
        this.m = context.getResources().getDimensionPixelSize(2131100350);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4917b);
        int i8 = 3;
        if (obtainStyledAttributes.hasValue(3)) {
            this.f2860o = g4.c.a(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(21)) {
            this.D = new i(i.b(context, attributeSet, 2130903166, 2131886906));
        }
        if (this.D != null) {
            k4.f fVar = new k4.f(this.D);
            this.f2859n = fVar;
            fVar.i(context);
            ColorStateList colorStateList = this.f2860o;
            if (colorStateList != null) {
                this.f2859n.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f2859n.setTint(typedValue.data);
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(x(), 1.0f);
        this.G = ofFloat;
        ofFloat.setDuration(500L);
        this.G.addUpdateListener(new r3.a(this));
        this.M = obtainStyledAttributes.getDimension(2, -1.0f);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f2861p = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2862q = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(9);
        if (peekValue == null || (i7 = peekValue.data) != -1) {
            J(obtainStyledAttributes.getDimensionPixelSize(9, -1));
        } else {
            J(i7);
        }
        I(obtainStyledAttributes.getBoolean(8, false));
        this.s = obtainStyledAttributes.getBoolean(13, false);
        boolean z6 = obtainStyledAttributes.getBoolean(6, true);
        if (this.f2849g != z6) {
            this.f2849g = z6;
            if (this.Z != null) {
                w();
            }
            L((this.f2849g && this.Q == 6) ? i8 : this.Q);
            P(this.Q, true);
            O();
        }
        this.O = obtainStyledAttributes.getBoolean(12, false);
        this.P = obtainStyledAttributes.getBoolean(4, true);
        this.f2847f = obtainStyledAttributes.getInt(10, 0);
        float f7 = obtainStyledAttributes.getFloat(7, 0.5f);
        if (f7 <= 0.0f || f7 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.K = f7;
        if (this.Z != null) {
            this.J = (int) ((1.0f - f7) * this.Y);
        }
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(5);
        H((peekValue2 == null || peekValue2.type != 16) ? obtainStyledAttributes.getDimensionPixelOffset(5, 0) : peekValue2.data);
        this.f2853i = obtainStyledAttributes.getInt(11, 500);
        this.f2864t = obtainStyledAttributes.getBoolean(17, false);
        this.f2865u = obtainStyledAttributes.getBoolean(18, false);
        this.f2866v = obtainStyledAttributes.getBoolean(19, false);
        this.f2867w = obtainStyledAttributes.getBoolean(20, true);
        this.f2868x = obtainStyledAttributes.getBoolean(14, false);
        this.f2869y = obtainStyledAttributes.getBoolean(15, false);
        this.f2870z = obtainStyledAttributes.getBoolean(16, false);
        this.C = obtainStyledAttributes.getBoolean(23, true);
        obtainStyledAttributes.recycle();
        this.f2851h = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static View A(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.i.p(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View A = A(viewGroup.getChildAt(i7));
                if (A != null) {
                    return A;
                }
            }
        }
        return null;
    }

    public static BottomSheetBehavior B(FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) layoutParams).f1442a;
            if (cVar instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) cVar;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final int C(int i7, int i8, int i9, int i10) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i7, i8, i10);
        if (i9 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i9 = Math.min(size, i9);
            }
            return View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i9), 1073741824);
    }

    public final int D() {
        if (this.f2849g) {
            return this.I;
        }
        return Math.max(this.H, this.f2867w ? 0 : this.B);
    }

    public final int E(int i7) {
        if (i7 != 3) {
            if (i7 != 4) {
                if (i7 != 5) {
                    if (i7 == 6) {
                        return this.J;
                    }
                    throw new IllegalArgumentException(s0.g("Invalid state to get top offset: ", i7));
                }
                return this.Y;
            }
            return this.L;
        }
        return D();
    }

    public final boolean F() {
        WeakReference weakReference = this.Z;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.Z.get()).getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    public final void G(View view, f.a aVar, int i7) {
        y.h(view, aVar, new r3.c(this, i7));
    }

    public final void H(int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.H = i7;
        P(this.Q, true);
    }

    public final void I(boolean z6) {
        if (this.N != z6) {
            this.N = z6;
            if (!z6 && this.Q == 5) {
                K(4);
            }
            O();
        }
    }

    public final void J(int i7) {
        boolean z6 = true;
        if (i7 == -1) {
            if (!this.f2857k) {
                this.f2857k = true;
            }
            z6 = false;
        } else {
            if (this.f2857k || this.f2855j != i7) {
                this.f2857k = false;
                this.f2855j = Math.max(0, i7);
            }
            z6 = false;
        }
        if (z6) {
            R();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
        if (p1.y.g.b(r4) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void K(int r4) {
        /*
            r3 = this;
            r0 = 1
            if (r4 == r0) goto L74
            r1 = 2
            if (r4 != r1) goto L8
            goto L74
        L8:
            boolean r1 = r3.N
            if (r1 != 0) goto L26
            r1 = 5
            if (r4 != r1) goto L26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Cannot set state: "
            r3.append(r0)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "BottomSheetBehavior"
            android.util.Log.w(r4, r3)
            return
        L26:
            r1 = 6
            if (r4 != r1) goto L37
            boolean r1 = r3.f2849g
            if (r1 == 0) goto L37
            int r1 = r3.E(r4)
            int r2 = r3.I
            if (r1 > r2) goto L37
            r1 = 3
            goto L38
        L37:
            r1 = r4
        L38:
            java.lang.ref.WeakReference r2 = r3.Z
            if (r2 == 0) goto L70
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L43
            goto L70
        L43:
            java.lang.ref.WeakReference r4 = r3.Z
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            com.google.android.material.bottomsheet.BottomSheetBehavior$a r2 = new com.google.android.material.bottomsheet.BottomSheetBehavior$a
            r2.<init>(r4, r1)
            android.view.ViewParent r3 = r4.getParent()
            if (r3 == 0) goto L65
            boolean r3 = r3.isLayoutRequested()
            if (r3 == 0) goto L65
            java.util.WeakHashMap<android.view.View, p1.k0> r3 = p1.y.f5540a
            boolean r3 = p1.y.g.b(r4)
            if (r3 == 0) goto L65
            goto L66
        L65:
            r0 = 0
        L66:
            if (r0 == 0) goto L6c
            r4.post(r2)
            goto L73
        L6c:
            r2.run()
            goto L73
        L70:
            r3.L(r4)
        L73:
            return
        L74:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "STATE_"
            java.lang.StringBuilder r1 = androidx.activity.h.d(r1)
            if (r4 != r0) goto L81
            java.lang.String r4 = "DRAGGING"
            goto L83
        L81:
            java.lang.String r4 = "SETTLING"
        L83:
            java.lang.String r0 = " should not be set externally."
            java.lang.String r4 = androidx.activity.h.c(r1, r4, r0)
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.K(int):void");
    }

    public final void L(int i7) {
        View view;
        if (this.Q == i7) {
            return;
        }
        this.Q = i7;
        WeakReference weakReference = this.Z;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i7 == 3) {
            Q(true);
        } else if (i7 == 6 || i7 == 5 || i7 == 4) {
            Q(false);
        }
        P(i7, true);
        for (int i8 = 0; i8 < this.f2843b0.size(); i8++) {
            ((d) this.f2843b0.get(i8)).c(view, i7);
        }
        O();
    }

    public final boolean M(View view, float f7) {
        if (this.O) {
            return true;
        }
        if (view.getTop() < this.L) {
            return false;
        }
        return Math.abs(((f7 * this.V) + ((float) view.getTop())) - ((float) this.L)) / ((float) y()) > 0.5f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r5 != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r1.q(r5.getLeft(), r0) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void N(android.view.View r5, int r6, boolean r7) {
        /*
            r4 = this;
            int r0 = r4.E(r6)
            x1.c r1 = r4.R
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L34
            if (r7 == 0) goto L17
            int r5 = r5.getLeft()
            boolean r5 = r1.q(r5, r0)
            if (r5 == 0) goto L34
            goto L33
        L17:
            int r7 = r5.getLeft()
            r1.f6458r = r5
            r5 = -1
            r1.f6445c = r5
            boolean r5 = r1.i(r7, r0, r2, r2)
            if (r5 != 0) goto L31
            int r7 = r1.f6443a
            if (r7 != 0) goto L31
            android.view.View r7 = r1.f6458r
            if (r7 == 0) goto L31
            r7 = 0
            r1.f6458r = r7
        L31:
            if (r5 == 0) goto L34
        L33:
            r2 = r3
        L34:
            if (r2 == 0) goto L43
            r5 = 2
            r4.L(r5)
            r4.P(r6, r3)
            com.google.android.material.bottomsheet.BottomSheetBehavior$f r4 = r4.F
            r4.a(r6)
            goto L46
        L43:
            r4.L(r6)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.N(android.view.View, int, boolean):void");
    }

    public final void O() {
        View view;
        int i7;
        f.a aVar;
        int i8;
        WeakReference weakReference = this.Z;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        y.g(view, 524288);
        y.e(view, 0);
        y.g(view, 262144);
        y.e(view, 0);
        y.g(view, 1048576);
        y.e(view, 0);
        int i9 = this.f2854i0.get(0, -1);
        if (i9 != -1) {
            y.g(view, i9);
            y.e(view, 0);
            this.f2854i0.delete(0);
        }
        if (!this.f2849g && this.Q != 6) {
            SparseIntArray sparseIntArray = this.f2854i0;
            String string = view.getResources().getString(2131820577);
            r3.c cVar = new r3.c(this, 6);
            ArrayList c7 = y.c(view);
            int i10 = 0;
            while (true) {
                if (i10 >= c7.size()) {
                    int i11 = 0;
                    int i12 = -1;
                    while (true) {
                        int[] iArr = y.f5541b;
                        if (i11 >= iArr.length || i12 != -1) {
                            break;
                        }
                        int i13 = iArr[i11];
                        boolean z6 = true;
                        for (int i14 = 0; i14 < c7.size(); i14++) {
                            z6 &= ((f.a) c7.get(i14)).a() != i13;
                        }
                        if (z6) {
                            i12 = i13;
                        }
                        i11++;
                    }
                    i8 = i12;
                } else if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((f.a) c7.get(i10)).f5634a).getLabel())) {
                    i8 = ((f.a) c7.get(i10)).a();
                    break;
                } else {
                    i10++;
                }
            }
            if (i8 != -1) {
                f.a aVar2 = new f.a(null, i8, string, cVar, null);
                View.AccessibilityDelegate a7 = y.m.a(view);
                p1.a aVar3 = a7 == null ? null : a7 instanceof a.C0092a ? ((a.C0092a) a7).f5468a : new p1.a(a7);
                if (aVar3 == null) {
                    aVar3 = new p1.a();
                }
                y.i(view, aVar3);
                y.g(view, aVar2.a());
                y.c(view).add(aVar2);
                y.e(view, 0);
            }
            sparseIntArray.put(0, i8);
        }
        if (this.N && this.Q != 5) {
            G(view, f.a.f5631j, 5);
        }
        int i15 = this.Q;
        if (i15 == 3) {
            i7 = this.f2849g ? 4 : 6;
            aVar = f.a.f5630i;
        } else if (i15 != 4) {
            if (i15 != 6) {
                return;
            }
            G(view, f.a.f5630i, 4);
            G(view, f.a.f5629h, 3);
            return;
        } else {
            i7 = this.f2849g ? 3 : 6;
            aVar = f.a.f5629h;
        }
        G(view, aVar, i7);
    }

    public final void P(int i7, boolean z6) {
        ValueAnimator valueAnimator;
        if (i7 == 2) {
            return;
        }
        boolean z7 = this.Q == 3 && (this.C || F());
        if (this.E == z7 || this.f2859n == null) {
            return;
        }
        this.E = z7;
        if (z6 && (valueAnimator = this.G) != null) {
            if (valueAnimator.isRunning()) {
                this.G.reverse();
                return;
            }
            this.G.setFloatValues(this.f2859n.f4720f.f4748j, z7 ? x() : 1.0f);
            this.G.start();
            return;
        }
        ValueAnimator valueAnimator2 = this.G;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.G.cancel();
        }
        k4.f fVar = this.f2859n;
        float x3 = this.E ? x() : 1.0f;
        f.b bVar = fVar.f4720f;
        if (bVar.f4748j != x3) {
            bVar.f4748j = x3;
            fVar.f4724j = true;
            fVar.invalidateSelf();
        }
    }

    public final void Q(boolean z6) {
        WeakReference weakReference = this.Z;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z6) {
                if (this.f2852h0 != null) {
                    return;
                }
                this.f2852h0 = new HashMap(childCount);
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = coordinatorLayout.getChildAt(i7);
                if (childAt != this.Z.get() && z6) {
                    this.f2852h0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z6) {
                return;
            }
            this.f2852h0 = null;
        }
    }

    public final void R() {
        View view;
        if (this.Z != null) {
            w();
            if (this.Q != 4 || (view = (View) this.Z.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    public final void a() {
        e4.f fVar = this.f2845d0;
        if (fVar == null) {
            return;
        }
        androidx.activity.b bVar = fVar.f3766f;
        fVar.f3766f = null;
        if (bVar == null || Build.VERSION.SDK_INT < 34) {
            K(this.N ? 5 : 4);
        } else if (!this.N) {
            AnimatorSet a7 = fVar.a();
            a7.setDuration(n3.a.b(fVar.f3764c, fVar.f3765d, bVar.f405c));
            a7.start();
            K(4);
        } else {
            b bVar2 = new b();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(fVar.f3763b, View.TRANSLATION_Y, fVar.f3763b.getScaleY() * fVar.f3763b.getHeight());
            ofFloat.setInterpolator(new c2.b());
            ofFloat.setDuration(n3.a.b(fVar.f3764c, fVar.f3765d, bVar.f405c));
            ofFloat.addListener(new e4.e(fVar));
            ofFloat.addListener(bVar2);
            ofFloat.start();
        }
    }

    public final void b(androidx.activity.b bVar) {
        e4.f fVar = this.f2845d0;
        if (fVar == null) {
            return;
        }
        fVar.f3766f = bVar;
    }

    public final void c(androidx.activity.b bVar) {
        e4.f fVar = this.f2845d0;
        if (fVar == null) {
            return;
        }
        if (fVar.f3766f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        androidx.activity.b bVar2 = fVar.f3766f;
        fVar.f3766f = bVar;
        if (bVar2 == null) {
            return;
        }
        fVar.b(bVar.f405c);
    }

    public final void d() {
        e4.f fVar = this.f2845d0;
        if (fVar == null) {
            return;
        }
        if (fVar.f3766f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        androidx.activity.b bVar = fVar.f3766f;
        fVar.f3766f = null;
        if (bVar == null) {
            return;
        }
        AnimatorSet a7 = fVar.a();
        a7.setDuration(fVar.e);
        a7.start();
    }

    public final void g(CoordinatorLayout.f fVar) {
        this.Z = null;
        this.R = null;
        this.f2845d0 = null;
    }

    public final void j() {
        this.Z = null;
        this.R = null;
        this.f2845d0 = null;
    }

    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i7;
        x1.c cVar;
        if (!view.isShown() || !this.P) {
            this.S = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2846e0 = -1;
            this.f2848f0 = -1;
            VelocityTracker velocityTracker = this.f2844c0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2844c0 = null;
            }
        }
        if (this.f2844c0 == null) {
            this.f2844c0 = VelocityTracker.obtain();
        }
        this.f2844c0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x3 = (int) motionEvent.getX();
            this.f2848f0 = (int) motionEvent.getY();
            if (this.Q != 2) {
                WeakReference weakReference = this.f2842a0;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.l(view2, x3, this.f2848f0)) {
                    this.f2846e0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f2850g0 = true;
                }
            }
            this.S = this.f2846e0 == -1 && !coordinatorLayout.l(view, x3, this.f2848f0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2850g0 = false;
            this.f2846e0 = -1;
            if (this.S) {
                this.S = false;
                return false;
            }
        }
        if (this.S || (cVar = this.R) == null || !cVar.r(motionEvent)) {
            WeakReference weakReference2 = this.f2842a0;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            return (actionMasked != 2 || view3 == null || this.S || this.Q == 1 || coordinatorLayout.l(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.R == null || (i7 = this.f2848f0) == -1 || Math.abs(((float) i7) - motionEvent.getY()) <= ((float) this.R.f6444b)) ? false : true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fe, code lost:
        if (r9 == (-1)) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0104, code lost:
        if (r9 == (-1)) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0107, code lost:
        r11 = java.lang.Math.min(r11, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010b, code lost:
        r8.W = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016f A[LOOP:0: B:80:0x0167->B:82:0x016f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean l(androidx.coordinatorlayout.widget.CoordinatorLayout r9, android.view.View r10, int r11) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(C(i7, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, this.f2861p, marginLayoutParams.width), C(i9, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, this.f2862q, marginLayoutParams.height));
        return true;
    }

    public final boolean n(View view) {
        WeakReference weakReference = this.f2842a0;
        return (weakReference == null || view != weakReference.get() || this.Q == 3) ? false : true;
    }

    public final void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int[] iArr, int i9) {
        int i10;
        if (i9 == 1) {
            return;
        }
        WeakReference weakReference = this.f2842a0;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i11 = top - i8;
        if (i8 > 0) {
            if (i11 < D()) {
                int D = top - D();
                iArr[1] = D;
                int i12 = -D;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                view.offsetTopAndBottom(i12);
                i10 = 3;
                L(i10);
            } else if (!this.P) {
                return;
            } else {
                iArr[1] = i8;
                int i13 = -i8;
                WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                view.offsetTopAndBottom(i13);
                L(1);
            }
        } else if (i8 < 0 && !view2.canScrollVertically(-1)) {
            int i14 = this.L;
            if (i11 > i14 && !this.N) {
                int i15 = top - i14;
                iArr[1] = i15;
                int i16 = -i15;
                WeakHashMap<View, k0> weakHashMap3 = y.f5540a;
                view.offsetTopAndBottom(i16);
                i10 = 4;
                L(i10);
            } else if (!this.P) {
                return;
            } else {
                iArr[1] = i8;
                int i132 = -i8;
                WeakHashMap<View, k0> weakHashMap22 = y.f5540a;
                view.offsetTopAndBottom(i132);
                L(1);
            }
        }
        z(view.getTop());
        this.T = i8;
        this.U = true;
    }

    public final void p(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9, int[] iArr) {
    }

    public final void r(View view, Parcelable parcelable) {
        e eVar = (e) parcelable;
        int i7 = this.f2847f;
        if (i7 != 0) {
            if (i7 == -1 || (i7 & 1) == 1) {
                this.f2855j = eVar.f2877i;
            }
            if (i7 == -1 || (i7 & 2) == 2) {
                this.f2849g = eVar.f2878j;
            }
            if (i7 == -1 || (i7 & 4) == 4) {
                this.N = eVar.f2879k;
            }
            if (i7 == -1 || (i7 & 8) == 8) {
                this.O = eVar.f2880l;
            }
        }
        int i8 = eVar.f2876h;
        if (i8 == 1 || i8 == 2) {
            this.Q = 4;
        } else {
            this.Q = i8;
        }
    }

    public final Parcelable s(View view) {
        return new e(View.BaseSavedState.EMPTY_STATE, this);
    }

    public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7, int i8) {
        this.T = 0;
        this.U = false;
        return (i7 & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r5.getTop() <= r3.J) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
        if (java.lang.Math.abs(r4 - r3.I) < java.lang.Math.abs(r4 - r3.L)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
        if (r4 < java.lang.Math.abs(r4 - r3.L)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
        if (java.lang.Math.abs(r4 - r1) < java.lang.Math.abs(r4 - r3.L)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
        if (java.lang.Math.abs(r4 - r3.J) < java.lang.Math.abs(r4 - r3.L)) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(androidx.coordinatorlayout.widget.CoordinatorLayout r4, android.view.View r5, android.view.View r6, int r7) {
        /*
            r3 = this;
            int r4 = r5.getTop()
            int r7 = r3.D()
            r0 = 3
            if (r4 != r7) goto Lf
            r3.L(r0)
            return
        Lf:
            java.lang.ref.WeakReference r4 = r3.f2842a0
            if (r4 == 0) goto Lb6
            java.lang.Object r4 = r4.get()
            if (r6 != r4) goto Lb6
            boolean r4 = r3.U
            if (r4 != 0) goto L1f
            goto Lb6
        L1f:
            int r4 = r3.T
            r6 = 4
            r7 = 6
            if (r4 <= 0) goto L35
            boolean r4 = r3.f2849g
            if (r4 == 0) goto L2b
            goto Lb0
        L2b:
            int r4 = r5.getTop()
            int r6 = r3.J
            if (r4 <= r6) goto Lb0
            goto Lad
        L35:
            boolean r4 = r3.N
            if (r4 == 0) goto L56
            android.view.VelocityTracker r4 = r3.f2844c0
            if (r4 != 0) goto L3f
            r4 = 0
            goto L4e
        L3f:
            r1 = 1000(0x3e8, float:1.401E-42)
            float r2 = r3.f2851h
            r4.computeCurrentVelocity(r1, r2)
            android.view.VelocityTracker r4 = r3.f2844c0
            int r1 = r3.f2846e0
            float r4 = r4.getYVelocity(r1)
        L4e:
            boolean r4 = r3.M(r5, r4)
            if (r4 == 0) goto L56
            r0 = 5
            goto Lb0
        L56:
            int r4 = r3.T
            if (r4 != 0) goto L93
            int r4 = r5.getTop()
            boolean r1 = r3.f2849g
            if (r1 == 0) goto L74
            int r7 = r3.I
            int r7 = r4 - r7
            int r7 = java.lang.Math.abs(r7)
            int r1 = r3.L
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            if (r7 >= r4) goto Laf
            goto Lb0
        L74:
            int r1 = r3.J
            if (r4 >= r1) goto L83
            int r6 = r3.L
            int r6 = r4 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r4 >= r6) goto Lad
            goto Lb0
        L83:
            int r0 = r4 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r3.L
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            if (r0 >= r4) goto Laf
            goto Lad
        L93:
            boolean r4 = r3.f2849g
            if (r4 == 0) goto L98
            goto Laf
        L98:
            int r4 = r5.getTop()
            int r0 = r3.J
            int r0 = r4 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r3.L
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            if (r0 >= r4) goto Laf
        Lad:
            r0 = r7
            goto Lb0
        Laf:
            r0 = r6
        Lb0:
            r4 = 0
            r3.N(r5, r0, r4)
            r3.U = r4
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.u(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z6 = false;
        if (view.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            int i7 = this.Q;
            if (i7 == 1 && actionMasked == 0) {
                return true;
            }
            x1.c cVar = this.R;
            if (cVar != null && (this.P || i7 == 1)) {
                cVar.k(motionEvent);
            }
            if (actionMasked == 0) {
                this.f2846e0 = -1;
                this.f2848f0 = -1;
                VelocityTracker velocityTracker = this.f2844c0;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f2844c0 = null;
                }
            }
            if (this.f2844c0 == null) {
                this.f2844c0 = VelocityTracker.obtain();
            }
            this.f2844c0.addMovement(motionEvent);
            if (this.R != null && (this.P || this.Q == 1)) {
                z6 = true;
            }
            if (z6 && actionMasked == 2 && !this.S) {
                float abs = Math.abs(this.f2848f0 - motionEvent.getY());
                x1.c cVar2 = this.R;
                if (abs > cVar2.f6444b) {
                    cVar2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
                }
            }
            return !this.S;
        }
        return false;
    }

    public final void w() {
        int y6 = y();
        if (this.f2849g) {
            this.L = Math.max(this.Y - y6, this.I);
        } else {
            this.L = this.Y - y6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float x() {
        /*
            r5 = this;
            k4.f r0 = r5.f2859n
            r1 = 0
            if (r0 == 0) goto L7a
            java.lang.ref.WeakReference r0 = r5.Z
            if (r0 == 0) goto L7a
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L7a
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L7a
            java.lang.ref.WeakReference r0 = r5.Z
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.F()
            if (r2 == 0) goto L7a
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L7a
            k4.f r2 = r5.f2859n
            k4.f$b r3 = r2.f4720f
            k4.i r3 = r3.f4740a
            k4.c r3 = r3.e
            android.graphics.RectF r2 = r2.h()
            float r2 = r3.a(r2)
            android.view.RoundedCorner r3 = p1.a0.c(r0)
            if (r3 == 0) goto L4e
            int r3 = r3.getRadius()
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L4e
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L4e
            float r3 = r3 / r2
            goto L4f
        L4e:
            r3 = r1
        L4f:
            k4.f r5 = r5.f2859n
            k4.f$b r2 = r5.f4720f
            k4.i r2 = r2.f4740a
            k4.c r2 = r2.f4764f
            android.graphics.RectF r5 = r5.h()
            float r5 = r2.a(r5)
            r2 = 1
            android.view.RoundedCorner r0 = r0.getRoundedCorner(r2)
            if (r0 == 0) goto L75
            int r0 = r0.getRadius()
            float r0 = (float) r0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L75
            int r2 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r2 <= 0) goto L75
            float r1 = r0 / r5
        L75:
            float r5 = java.lang.Math.max(r3, r1)
            return r5
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.x():float");
    }

    public final int y() {
        int i7;
        int i8;
        if (this.f2857k) {
            i7 = Math.min(Math.max(this.f2858l, this.Y - ((this.X * 9) / 16)), this.W);
        } else if (!this.s && !this.f2864t && (i8 = this.f2863r) > 0) {
            return Math.max(this.f2855j, i8 + this.m);
        } else {
            i7 = this.f2855j;
        }
        return i7 + this.A;
    }

    public final void z(int i7) {
        View view = (View) this.Z.get();
        if (view == null || this.f2843b0.isEmpty()) {
            return;
        }
        int i8 = this.L;
        if (i7 <= i8 && i8 != D()) {
            D();
        }
        for (int i9 = 0; i9 < this.f2843b0.size(); i9++) {
            ((d) this.f2843b0.get(i9)).b(view);
        }
    }
}
