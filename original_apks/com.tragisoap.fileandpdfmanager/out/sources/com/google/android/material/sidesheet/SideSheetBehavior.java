package com.google.android.material.sidesheet;

import a0.e;
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
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
import e4.h;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import k4.f;
import k4.i;
import l0.z;
import n3.a;
import p1.k0;
import p1.y;
import q1.f;
import q1.j;
import x1.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c<V> implements e4.b {
    public final LinkedHashSet A;
    public final a B;

    /* renamed from: f */
    public l4.d f3227f;

    /* renamed from: g */
    public f f3228g;

    /* renamed from: h */
    public ColorStateList f3229h;

    /* renamed from: i */
    public i f3230i;

    /* renamed from: j */
    public final SideSheetBehavior<V>.d f3231j;

    /* renamed from: k */
    public float f3232k;

    /* renamed from: l */
    public boolean f3233l;
    public int m;

    /* renamed from: n */
    public x1.c f3234n;

    /* renamed from: o */
    public boolean f3235o;

    /* renamed from: p */
    public float f3236p;

    /* renamed from: q */
    public int f3237q;

    /* renamed from: r */
    public int f3238r;
    public int s;

    /* renamed from: t */
    public int f3239t;

    /* renamed from: u */
    public WeakReference<V> f3240u;

    /* renamed from: v */
    public WeakReference<View> f3241v;

    /* renamed from: w */
    public int f3242w;

    /* renamed from: x */
    public VelocityTracker f3243x;

    /* renamed from: y */
    public e4.i f3244y;

    /* renamed from: z */
    public int f3245z;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends c.AbstractC0134c {
        public a() {
            SideSheetBehavior.this = r1;
        }

        @Override // x1.c.AbstractC0134c
        public final int a(View view, int i7) {
            return e.k(i7, SideSheetBehavior.this.f3227f.g(), SideSheetBehavior.this.f3227f.f());
        }

        @Override // x1.c.AbstractC0134c
        public final int b(View view, int i7) {
            return view.getTop();
        }

        @Override // x1.c.AbstractC0134c
        public final int c(View view) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            return sideSheetBehavior.f3237q + sideSheetBehavior.f3239t;
        }

        @Override // x1.c.AbstractC0134c
        public final void f(int i7) {
            if (i7 == 1) {
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                if (sideSheetBehavior.f3233l) {
                    sideSheetBehavior.y(1);
                }
            }
        }

        @Override // x1.c.AbstractC0134c
        public final void g(View view, int i7, int i8) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            WeakReference<View> weakReference = SideSheetBehavior.this.f3241v;
            View view2 = weakReference != null ? weakReference.get() : null;
            if (!(view2 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) == null)) {
                SideSheetBehavior.this.f3227f.p(marginLayoutParams, view.getLeft(), view.getRight());
                view2.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            if (!sideSheetBehavior.A.isEmpty()) {
                sideSheetBehavior.f3227f.b(i7);
                for (l4.c cVar : sideSheetBehavior.A) {
                    cVar.b();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
            if ((java.lang.Math.abs(r5) > java.lang.Math.abs(r6)) == false) goto L_0x003b;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
            if (java.lang.Math.abs(r5 - r0.f3227f.d()) < java.lang.Math.abs(r5 - r0.f3227f.e())) goto L_0x0058;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
            if (r0.f3227f.l(r4) == false) goto L_0x0058;
         */
        @Override // x1.c.AbstractC0134c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void h(android.view.View r4, float r5, float r6) {
            /*
                r3 = this;
                com.google.android.material.sidesheet.SideSheetBehavior r0 = com.google.android.material.sidesheet.SideSheetBehavior.this
                l4.d r1 = r0.f3227f
                boolean r1 = r1.k(r5)
                r2 = 1
                if (r1 == 0) goto L_0x000c
                goto L_0x0058
            L_0x000c:
                l4.d r1 = r0.f3227f
                boolean r1 = r1.n(r4, r5)
                if (r1 == 0) goto L_0x0025
                l4.d r1 = r0.f3227f
                boolean r5 = r1.m(r5, r6)
                if (r5 != 0) goto L_0x005a
                l4.d r5 = r0.f3227f
                boolean r5 = r5.l(r4)
                if (r5 == 0) goto L_0x0058
                goto L_0x005a
            L_0x0025:
                r1 = 0
                int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r1 == 0) goto L_0x003b
                float r5 = java.lang.Math.abs(r5)
                float r6 = java.lang.Math.abs(r6)
                int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r5 <= 0) goto L_0x0038
                r5 = r2
                goto L_0x0039
            L_0x0038:
                r5 = 0
            L_0x0039:
                if (r5 != 0) goto L_0x005a
            L_0x003b:
                int r5 = r4.getLeft()
                l4.d r6 = r0.f3227f
                int r6 = r6.d()
                int r6 = r5 - r6
                int r6 = java.lang.Math.abs(r6)
                l4.d r0 = r0.f3227f
                int r0 = r0.e()
                int r5 = r5 - r0
                int r5 = java.lang.Math.abs(r5)
                if (r6 >= r5) goto L_0x005a
            L_0x0058:
                r5 = 3
                goto L_0x005b
            L_0x005a:
                r5 = 5
            L_0x005b:
                com.google.android.material.sidesheet.SideSheetBehavior r3 = com.google.android.material.sidesheet.SideSheetBehavior.this
                r3.getClass()
                r3.z(r4, r5, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.a.h(android.view.View, float, float):void");
        }

        @Override // x1.c.AbstractC0134c
        public final boolean i(View view, int i7) {
            WeakReference<V> weakReference;
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            return (sideSheetBehavior.m == 1 || (weakReference = sideSheetBehavior.f3240u) == null || weakReference.get() != view) ? false : true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
            SideSheetBehavior.this = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.y(5);
            WeakReference<V> weakReference = SideSheetBehavior.this.f3240u;
            if (weakReference != null && weakReference.get() != null) {
                SideSheetBehavior.this.f3240u.get().requestLayout();
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends w1.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: h */
        public final int f3248h;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new c(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i7) {
                return new c[i7];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3248h = parcel.readInt();
        }

        public c(AbsSavedState absSavedState, SideSheetBehavior sideSheetBehavior) {
            super(absSavedState);
            this.f3248h = sideSheetBehavior.m;
        }

        @Override // w1.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeInt(this.f3248h);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d {

        /* renamed from: a */
        public int f3249a;

        /* renamed from: b */
        public boolean f3250b;

        /* renamed from: c */
        public final androidx.activity.d f3251c = new androidx.activity.d(10, this);

        public d() {
            SideSheetBehavior.this = r2;
        }

        public final void a(int i7) {
            WeakReference<V> weakReference = SideSheetBehavior.this.f3240u;
            if (weakReference != null && weakReference.get() != null) {
                this.f3249a = i7;
                if (!this.f3250b) {
                    androidx.activity.d dVar = this.f3251c;
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    y.d.m(SideSheetBehavior.this.f3240u.get(), dVar);
                    this.f3250b = true;
                }
            }
        }
    }

    public SideSheetBehavior() {
        this.f3231j = new d();
        this.f3233l = true;
        this.m = 5;
        this.f3236p = 0.1f;
        this.f3242w = -1;
        this.A = new LinkedHashSet();
        this.B = new a();
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3231j = new d();
        this.f3233l = true;
        this.m = 5;
        this.f3236p = 0.1f;
        this.f3242w = -1;
        this.A = new LinkedHashSet();
        this.B = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4936x);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f3229h = g4.c.a(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f3230i = new i(i.b(context, attributeSet, 0, 2131887051));
        }
        if (obtainStyledAttributes.hasValue(5)) {
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            this.f3242w = resourceId;
            WeakReference<View> weakReference = this.f3241v;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f3241v = null;
            WeakReference<V> weakReference2 = this.f3240u;
            if (weakReference2 != null) {
                V v6 = weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    if (y.g.c(v6)) {
                        v6.requestLayout();
                    }
                }
            }
        }
        if (this.f3230i != null) {
            f fVar = new f(this.f3230i);
            this.f3228g = fVar;
            fVar.i(context);
            ColorStateList colorStateList = this.f3229h;
            if (colorStateList != null) {
                this.f3228g.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f3228g.setTint(typedValue.data);
            }
        }
        this.f3232k = obtainStyledAttributes.getDimension(2, -1.0f);
        this.f3233l = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final void A() {
        V v6;
        WeakReference<V> weakReference = this.f3240u;
        if (weakReference != null && (v6 = weakReference.get()) != null) {
            y.g(v6, 262144);
            y.e(v6, 0);
            y.g(v6, 1048576);
            y.e(v6, 0);
            if (this.m != 5) {
                y.h(v6, f.a.f5631j, new j(5) { // from class: l4.e

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f5033b;

                    {
                        this.f5033b = r2;
                    }

                    @Override // q1.j
                    public final boolean a(View view) {
                        SideSheetBehavior.this.x(this.f5033b);
                        return true;
                    }
                });
            }
            if (this.m != 3) {
                y.h(v6, f.a.f5629h, new j(3) { // from class: l4.e

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f5033b;

                    {
                        this.f5033b = r2;
                    }

                    @Override // q1.j
                    public final boolean a(View view) {
                        SideSheetBehavior.this.x(this.f5033b);
                        return true;
                    }
                });
            }
        }
    }

    @Override // e4.b
    public final void a() {
        int i7;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        e4.i iVar = this.f3244y;
        if (iVar != null) {
            androidx.activity.b bVar = iVar.f3766f;
            l4.f fVar = null;
            iVar.f3766f = null;
            int i8 = 5;
            if (bVar == null || Build.VERSION.SDK_INT < 34) {
                x(5);
                return;
            }
            l4.d dVar = this.f3227f;
            if (!(dVar == null || dVar.j() == 0)) {
                i8 = 3;
            }
            b bVar2 = new b();
            WeakReference<View> weakReference = this.f3241v;
            View view = weakReference != null ? weakReference.get() : null;
            if (!(view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null)) {
                fVar = new ValueAnimator.AnimatorUpdateListener(marginLayoutParams, this.f3227f.c(marginLayoutParams), view) { // from class: l4.f

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ViewGroup.MarginLayoutParams f5035b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f5036c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ View f5037d;

                    {
                        this.f5035b = r2;
                        this.f5036c = r3;
                        this.f5037d = r4;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = this.f5035b;
                        int i9 = this.f5036c;
                        View view2 = this.f5037d;
                        sideSheetBehavior.f3227f.o(marginLayoutParams2, a.b(i9, 0, valueAnimator.getAnimatedFraction()));
                        view2.requestLayout();
                    }
                };
            }
            boolean z6 = bVar.f406d == 0;
            V v6 = iVar.f3763b;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            boolean z7 = (Gravity.getAbsoluteGravity(i8, y.e.d(v6)) & 3) == 3;
            float scaleX = iVar.f3763b.getScaleX() * ((float) iVar.f3763b.getWidth());
            ViewGroup.LayoutParams layoutParams = iVar.f3763b.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                i7 = z7 ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin;
            } else {
                i7 = 0;
            }
            float f7 = scaleX + ((float) i7);
            V v7 = iVar.f3763b;
            Property property = View.TRANSLATION_X;
            float[] fArr = new float[1];
            if (z7) {
                f7 = -f7;
            }
            fArr[0] = f7;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(v7, property, fArr);
            if (fVar != null) {
                ofFloat.addUpdateListener(fVar);
            }
            ofFloat.setInterpolator(new c2.b());
            ofFloat.setDuration((long) n3.a.b(iVar.f3764c, iVar.f3765d, bVar.f405c));
            ofFloat.addListener(new h(iVar, z6, i8));
            ofFloat.addListener(bVar2);
            ofFloat.start();
        }
    }

    @Override // e4.b
    public final void b(androidx.activity.b bVar) {
        e4.i iVar = this.f3244y;
        if (iVar != null) {
            iVar.f3766f = bVar;
        }
    }

    @Override // e4.b
    public final void c(androidx.activity.b bVar) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        e4.i iVar = this.f3244y;
        if (iVar != null) {
            l4.d dVar = this.f3227f;
            int i7 = 5;
            if (!(dVar == null || dVar.j() == 0)) {
                i7 = 3;
            }
            if (iVar.f3766f == null) {
                Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
            }
            androidx.activity.b bVar2 = iVar.f3766f;
            iVar.f3766f = bVar;
            if (bVar2 != null) {
                iVar.a(bVar.f405c, i7, bVar.f406d == 0);
            }
            WeakReference<V> weakReference = this.f3240u;
            if (weakReference != null && weakReference.get() != null) {
                V v6 = this.f3240u.get();
                WeakReference<View> weakReference2 = this.f3241v;
                View view = weakReference2 != null ? weakReference2.get() : null;
                if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
                    this.f3227f.o(marginLayoutParams, (int) ((v6.getScaleX() * ((float) this.f3237q)) + ((float) this.f3239t)));
                    view.requestLayout();
                }
            }
        }
    }

    @Override // e4.b
    public final void d() {
        e4.i iVar = this.f3244y;
        if (iVar != null) {
            if (iVar.f3766f == null) {
                Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
            }
            androidx.activity.b bVar = iVar.f3766f;
            iVar.f3766f = null;
            if (bVar != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(iVar.f3763b, View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(iVar.f3763b, View.SCALE_Y, 1.0f));
                V v6 = iVar.f3763b;
                if (v6 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) v6;
                    for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i7), View.SCALE_Y, 1.0f));
                    }
                }
                animatorSet.setDuration((long) iVar.e);
                animatorSet.start();
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void g(CoordinatorLayout.f fVar) {
        this.f3240u = null;
        this.f3234n = null;
        this.f3244y = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void j() {
        this.f3240u = null;
        this.f3234n = null;
        this.f3244y = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean k(CoordinatorLayout coordinatorLayout, V v6, MotionEvent motionEvent) {
        x1.c cVar;
        VelocityTracker velocityTracker;
        if (!((v6.isShown() || y.b(v6) != null) && this.f3233l)) {
            this.f3235o = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.f3243x) != null) {
            velocityTracker.recycle();
            this.f3243x = null;
        }
        if (this.f3243x == null) {
            this.f3243x = VelocityTracker.obtain();
        }
        this.f3243x.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f3245z = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f3235o) {
            this.f3235o = false;
            return false;
        }
        return !this.f3235o && (cVar = this.f3234n) != null && cVar.r(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00f5  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(androidx.coordinatorlayout.widget.CoordinatorLayout r8, V r9, int r10) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i7, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i9, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void r(View view, Parcelable parcelable) {
        int i7 = ((c) parcelable).f3248h;
        if (i7 == 1 || i7 == 2) {
            i7 = 5;
        }
        this.m = i7;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final Parcelable s(View view) {
        return new c(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean v(CoordinatorLayout coordinatorLayout, V v6, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        boolean z6 = false;
        if (!v6.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i7 = this.m;
        if (i7 == 1 && actionMasked == 0) {
            return true;
        }
        x1.c cVar = this.f3234n;
        if (cVar != null && (this.f3233l || i7 == 1)) {
            cVar.k(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f3243x) != null) {
            velocityTracker.recycle();
            this.f3243x = null;
        }
        if (this.f3243x == null) {
            this.f3243x = VelocityTracker.obtain();
        }
        this.f3243x.addMovement(motionEvent);
        x1.c cVar2 = this.f3234n;
        if ((cVar2 != null && (this.f3233l || this.m == 1)) && actionMasked == 2 && !this.f3235o) {
            if ((cVar2 != null && (this.f3233l || this.m == 1)) && Math.abs(((float) this.f3245z) - motionEvent.getX()) > ((float) this.f3234n.f6444b)) {
                z6 = true;
            }
            if (z6) {
                this.f3234n.b(v6, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f3235o;
    }

    public final CoordinatorLayout.f w() {
        V v6;
        WeakReference<V> weakReference = this.f3240u;
        if (weakReference == null || (v6 = weakReference.get()) == null || !(v6.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return null;
        }
        return (CoordinatorLayout.f) v6.getLayoutParams();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (p1.y.g.b(r1) != false) goto L_0x0035;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(int r4) {
        /*
            r3 = this;
            r0 = 1
            if (r4 == r0) goto L_0x0043
            r1 = 2
            if (r4 != r1) goto L_0x0007
            goto L_0x0043
        L_0x0007:
            java.lang.ref.WeakReference<V extends android.view.View> r1 = r3.f3240u
            if (r1 == 0) goto L_0x003f
            java.lang.Object r1 = r1.get()
            if (r1 != 0) goto L_0x0012
            goto L_0x003f
        L_0x0012:
            java.lang.ref.WeakReference<V extends android.view.View> r1 = r3.f3240u
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            h1.g r2 = new h1.g
            r2.<init>(r4, r0, r3)
            android.view.ViewParent r3 = r1.getParent()
            if (r3 == 0) goto L_0x0034
            boolean r3 = r3.isLayoutRequested()
            if (r3 == 0) goto L_0x0034
            java.util.WeakHashMap<android.view.View, p1.k0> r3 = p1.y.f5540a
            boolean r3 = p1.y.g.b(r1)
            if (r3 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            if (r0 == 0) goto L_0x003b
            r1.post(r2)
            goto L_0x0042
        L_0x003b:
            r2.run()
            goto L_0x0042
        L_0x003f:
            r3.y(r4)
        L_0x0042:
            return
        L_0x0043:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "STATE_"
            java.lang.StringBuilder r1 = androidx.activity.h.d(r1)
            if (r4 != r0) goto L_0x0050
            java.lang.String r4 = "DRAGGING"
            goto L_0x0052
        L_0x0050:
            java.lang.String r4 = "SETTLING"
        L_0x0052:
            java.lang.String r0 = " should not be set externally."
            java.lang.String r4 = androidx.activity.h.c(r1, r4, r0)
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.x(int):void");
    }

    public final void y(int i7) {
        V v6;
        if (this.m != i7) {
            this.m = i7;
            WeakReference<V> weakReference = this.f3240u;
            if (!(weakReference == null || (v6 = weakReference.get()) == null)) {
                int i8 = this.m == 5 ? 4 : 0;
                if (v6.getVisibility() != i8) {
                    v6.setVisibility(i8);
                }
                for (l4.c cVar : this.A) {
                    cVar.a();
                }
                A();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r1.q(r0, r4.getTop()) != false) goto L_0x004d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r4 != false) goto L_0x004d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        r2 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(android.view.View r4, int r5, boolean r6) {
        /*
            r3 = this;
            r0 = 3
            if (r5 == r0) goto L_0x0019
            r0 = 5
            if (r5 != r0) goto L_0x000d
            l4.d r0 = r3.f3227f
            int r0 = r0.e()
            goto L_0x001f
        L_0x000d:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Invalid state to get outer edge offset: "
            java.lang.String r4 = androidx.fragment.app.s0.g(r4, r5)
            r3.<init>(r4)
            throw r3
        L_0x0019:
            l4.d r0 = r3.f3227f
            int r0 = r0.d()
        L_0x001f:
            x1.c r1 = r3.f3234n
            r2 = 0
            if (r1 == 0) goto L_0x004e
            if (r6 == 0) goto L_0x0031
            int r4 = r4.getTop()
            boolean r4 = r1.q(r0, r4)
            if (r4 == 0) goto L_0x004e
            goto L_0x004d
        L_0x0031:
            int r6 = r4.getTop()
            r1.f6458r = r4
            r4 = -1
            r1.f6445c = r4
            boolean r4 = r1.i(r0, r6, r2, r2)
            if (r4 != 0) goto L_0x004b
            int r6 = r1.f6443a
            if (r6 != 0) goto L_0x004b
            android.view.View r6 = r1.f6458r
            if (r6 == 0) goto L_0x004b
            r6 = 0
            r1.f6458r = r6
        L_0x004b:
            if (r4 == 0) goto L_0x004e
        L_0x004d:
            r2 = 1
        L_0x004e:
            if (r2 == 0) goto L_0x005a
            r4 = 2
            r3.y(r4)
            com.google.android.material.sidesheet.SideSheetBehavior<V>$d r3 = r3.f3231j
            r3.a(r5)
            goto L_0x005d
        L_0x005a:
            r3.y(r5)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.z(android.view.View, int, boolean):void");
    }
}
