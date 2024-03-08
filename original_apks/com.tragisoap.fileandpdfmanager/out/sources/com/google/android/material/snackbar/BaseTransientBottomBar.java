package com.google.android.material.snackbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import d4.s;
import j1.a;
import java.util.WeakHashMap;
import k4.f;
import k4.i;
import l0.z;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f3253a = 0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: n  reason: collision with root package name */
        public final b f3254n = new b(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f3254n.getClass();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    synchronized (m4.a.a().f5091a) {
                    }
                }
            } else if (coordinatorLayout.l(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                synchronized (m4.a.a().f5091a) {
                }
            }
            return super.k(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public final boolean w(View view) {
            this.f3254n.getClass();
            return view instanceof c;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 0) {
                ((BaseTransientBottomBar) message.obj).getClass();
                throw null;
            } else if (i7 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).getClass();
                throw null;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.getClass();
            swipeDismissBehavior.f2810k = Math.min(Math.max(0.0f, 0.1f), 1.0f);
            swipeDismissBehavior.f2811l = Math.min(Math.max(0.0f, 0.6f), 1.0f);
            swipeDismissBehavior.f2808i = 0;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends FrameLayout {

        /* renamed from: o  reason: collision with root package name */
        public static final a f3255o = new a();

        /* renamed from: f  reason: collision with root package name */
        public BaseTransientBottomBar<?> f3256f;

        /* renamed from: g  reason: collision with root package name */
        public i f3257g;

        /* renamed from: h  reason: collision with root package name */
        public int f3258h;

        /* renamed from: i  reason: collision with root package name */
        public final float f3259i;

        /* renamed from: j  reason: collision with root package name */
        public final float f3260j;

        /* renamed from: k  reason: collision with root package name */
        public final int f3261k;

        /* renamed from: l  reason: collision with root package name */
        public final int f3262l;
        public ColorStateList m;

        /* renamed from: n  reason: collision with root package name */
        public PorterDuff.Mode f3263n;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Context context, AttributeSet attributeSet) {
            super(q4.a.a(context, attributeSet, 0, 0), attributeSet);
            GradientDrawable gradientDrawable;
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, z.f4937y);
            if (obtainStyledAttributes.hasValue(6)) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.i.s(this, (float) obtainStyledAttributes.getDimensionPixelSize(6, 0));
            }
            this.f3258h = obtainStyledAttributes.getInt(2, 0);
            if (obtainStyledAttributes.hasValue(8) || obtainStyledAttributes.hasValue(9)) {
                this.f3257g = new i(i.b(context2, attributeSet, 0, 0));
            }
            this.f3259i = obtainStyledAttributes.getFloat(3, 1.0f);
            setBackgroundTintList(g4.c.a(context2, obtainStyledAttributes, 4));
            setBackgroundTintMode(s.b(obtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
            this.f3260j = obtainStyledAttributes.getFloat(1, 1.0f);
            this.f3261k = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            this.f3262l = obtainStyledAttributes.getDimensionPixelSize(7, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f3255o);
            setFocusable(true);
            if (getBackground() == null) {
                int F = q2.a.F(q2.a.v(this, 2130903330), q2.a.v(this, 2130903308), getBackgroundOverlayColorAlpha());
                i iVar = this.f3257g;
                if (iVar != null) {
                    int i7 = BaseTransientBottomBar.f3253a;
                    f fVar = new f(iVar);
                    fVar.k(ColorStateList.valueOf(F));
                    gradientDrawable = fVar;
                } else {
                    Resources resources = getResources();
                    int i8 = BaseTransientBottomBar.f3253a;
                    float dimension = resources.getDimension(2131100396);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setShape(0);
                    gradientDrawable2.setCornerRadius(dimension);
                    gradientDrawable2.setColor(F);
                    gradientDrawable = gradientDrawable2;
                }
                ColorStateList colorStateList = this.m;
                if (colorStateList != null) {
                    a.b.h(gradientDrawable, colorStateList);
                }
                WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                y.d.q(this, gradientDrawable);
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f3256f = baseTransientBottomBar;
        }

        public float getActionTextColorAlpha() {
            return this.f3260j;
        }

        public int getAnimationMode() {
            return this.f3258h;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f3259i;
        }

        public int getMaxInlineActionWidth() {
            return this.f3262l;
        }

        public int getMaxWidth() {
            return this.f3261k;
        }

        @Override // android.view.View, android.view.ViewGroup
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f3256f;
            if (baseTransientBottomBar == null) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.h.c(this);
                return;
            }
            baseTransientBottomBar.getClass();
            throw null;
        }

        @Override // android.view.View, android.view.ViewGroup
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f3256f != null) {
                synchronized (m4.a.a().f5091a) {
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
        public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
            super.onLayout(z6, i7, i8, i9, i10);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i7, int i8) {
            int i9;
            super.onMeasure(i7, i8);
            if (this.f3261k > 0 && getMeasuredWidth() > (i9 = this.f3261k)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), i8);
            }
        }

        public void setAnimationMode(int i7) {
            this.f3258h = i7;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.m == null)) {
                drawable = drawable.mutate();
                a.b.h(drawable, this.m);
                a.b.i(drawable, this.f3263n);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.m = colorStateList;
            if (getBackground() != null) {
                Drawable mutate = getBackground().mutate();
                a.b.h(mutate, colorStateList);
                a.b.i(mutate, this.f3263n);
                if (mutate != getBackground()) {
                    super.setBackgroundDrawable(mutate);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f3263n = mode;
            if (getBackground() != null) {
                Drawable mutate = getBackground().mutate();
                a.b.i(mutate, mode);
                if (mutate != getBackground()) {
                    super.setBackgroundDrawable(mutate);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                if (this.f3256f != null) {
                    int i7 = BaseTransientBottomBar.f3253a;
                    throw null;
                }
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f3255o);
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        LinearInterpolator linearInterpolator = n3.a.f5161a;
        new Handler(Looper.getMainLooper(), new a());
    }
}
