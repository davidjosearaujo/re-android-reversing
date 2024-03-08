package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.h0;
import com.google.android.material.internal.CheckableImageButton;
import d4.s;
import e4.j;
import g1.a;
import j1.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import k2.l;
import k4.f;
import k4.i;
import linc.com.amplituda.ErrorCode;
import o4.n;
import o4.o;
import o4.p;
import o4.r;
import o4.u;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] G0 = {new int[]{16842919}, new int[0]};
    public int A;
    public boolean A0;
    public k2.d B;
    public boolean B0;
    public k2.d C;
    public ValueAnimator C0;
    public ColorStateList D;
    public boolean D0;
    public ColorStateList E;
    public boolean E0;
    public ColorStateList F;
    public ColorStateList G;
    public boolean H;
    public CharSequence I;
    public boolean J;
    public k4.f K;
    public k4.f L;
    public StateListDrawable M;
    public boolean N;
    public k4.f O;
    public k4.f P;
    public i Q;
    public boolean R;
    public final int S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a0 */
    public int f3269a0;

    /* renamed from: b0 */
    public int f3270b0;

    /* renamed from: c0 */
    public int f3271c0;

    /* renamed from: f */
    public final FrameLayout f3274f;

    /* renamed from: g */
    public final u f3276g;

    /* renamed from: g0 */
    public Typeface f3277g0;

    /* renamed from: h */
    public final a f3278h;

    /* renamed from: h0 */
    public ColorDrawable f3279h0;

    /* renamed from: i */
    public EditText f3280i;

    /* renamed from: i0 */
    public int f3281i0;

    /* renamed from: j */
    public CharSequence f3282j;

    /* renamed from: k0 */
    public ColorDrawable f3285k0;

    /* renamed from: l0 */
    public int f3287l0;

    /* renamed from: m0 */
    public Drawable f3288m0;

    /* renamed from: n0 */
    public ColorStateList f3290n0;

    /* renamed from: o0 */
    public ColorStateList f3292o0;

    /* renamed from: p */
    public boolean f3293p;

    /* renamed from: p0 */
    public int f3294p0;

    /* renamed from: q */
    public int f3295q;

    /* renamed from: q0 */
    public int f3296q0;

    /* renamed from: r */
    public boolean f3297r;

    /* renamed from: r0 */
    public int f3298r0;

    /* renamed from: s0 */
    public ColorStateList f3299s0;

    /* renamed from: t */
    public c0 f3300t;

    /* renamed from: t0 */
    public int f3301t0;

    /* renamed from: u */
    public int f3302u;

    /* renamed from: u0 */
    public int f3303u0;

    /* renamed from: v */
    public int f3304v;

    /* renamed from: v0 */
    public int f3305v0;

    /* renamed from: w */
    public CharSequence f3306w;

    /* renamed from: w0 */
    public int f3307w0;

    /* renamed from: x */
    public boolean f3308x;

    /* renamed from: x0 */
    public int f3309x0;

    /* renamed from: y */
    public c0 f3310y;

    /* renamed from: y0 */
    public boolean f3311y0;

    /* renamed from: z */
    public ColorStateList f3312z;

    /* renamed from: z0 */
    public final d4.c f3313z0;

    /* renamed from: k */
    public int f3284k = -1;

    /* renamed from: l */
    public int f3286l = -1;
    public int m = -1;

    /* renamed from: n */
    public int f3289n = -1;

    /* renamed from: o */
    public final o f3291o = new o(this);
    public e s = new c0.e(2);

    /* renamed from: d0 */
    public final Rect f3272d0 = new Rect();

    /* renamed from: e0 */
    public final Rect f3273e0 = new Rect();

    /* renamed from: f0 */
    public final RectF f3275f0 = new RectF();

    /* renamed from: j0 */
    public final LinkedHashSet<f> f3283j0 = new LinkedHashSet<>();
    public boolean F0 = false;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements TextWatcher {
        public a() {
            TextInputLayout.this = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.u(!textInputLayout.E0, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f3293p) {
                textInputLayout2.n(editable);
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.f3308x) {
                textInputLayout3.v(editable);
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Runnable {
        public b() {
            TextInputLayout.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = TextInputLayout.this.f3278h;
            aVar.f3326l.performClick();
            aVar.f3326l.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
            TextInputLayout.this = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f3313z0.k(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d extends p1.a {

        /* renamed from: d */
        public final TextInputLayout f3317d;

        public d(TextInputLayout textInputLayout) {
            this.f3317d = textInputLayout;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
            if (r2 != null) goto L_0x00a4;
         */
        @Override // p1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d(android.view.View r14, q1.f r15) {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.d.d(android.view.View, q1.f):void");
        }

        @Override // p1.a
        public final void e(View view, AccessibilityEvent accessibilityEvent) {
            super.e(view, accessibilityEvent);
            this.f3317d.f3278h.b().o(accessibilityEvent);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface e {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface g {
        void a();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class h extends w1.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: h */
        public CharSequence f3318h;

        /* renamed from: i */
        public boolean f3319i;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i7) {
                return new h[i7];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3318h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f3319i = parcel.readInt() != 1 ? false : true;
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // java.lang.Object
        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("TextInputLayout.SavedState{");
            d7.append(Integer.toHexString(System.identityHashCode(this)));
            d7.append(" error=");
            d7.append((Object) this.f3318h);
            d7.append("}");
            return d7.toString();
        }

        @Override // w1.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            TextUtils.writeToParcel(this.f3318h, parcel, i7);
            parcel.writeInt(this.f3319i ? 1 : 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v35, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TextInputLayout(android.content.Context r20, android.util.AttributeSet r21) {
        /*
            Method dump skipped, instructions count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private Drawable getEditTextBoxBackground() {
        int i7;
        EditText editText = this.f3280i;
        if (editText instanceof AutoCompleteTextView) {
            if (!(editText.getInputType() != 0)) {
                int v6 = q2.a.v(this.f3280i, 2130903290);
                int i8 = this.T;
                if (i8 == 2) {
                    Context context = getContext();
                    k4.f fVar = this.K;
                    int[][] iArr = G0;
                    TypedValue c7 = g4.b.c(2130903330, context, "TextInputLayout");
                    int i9 = c7.resourceId;
                    if (i9 != 0) {
                        Object obj = g1.a.f4192a;
                        i7 = a.d.a(context, i9);
                    } else {
                        i7 = c7.data;
                    }
                    k4.f fVar2 = new k4.f(fVar.f4720f.f4740a);
                    int F = q2.a.F(v6, i7, 0.1f);
                    fVar2.k(new ColorStateList(iArr, new int[]{F, 0}));
                    fVar2.setTint(i7);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{F, i7});
                    k4.f fVar3 = new k4.f(fVar.f4720f.f4740a);
                    fVar3.setTint(-1);
                    return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, fVar2, fVar3), fVar});
                } else if (i8 != 1) {
                    return null;
                } else {
                    k4.f fVar4 = this.K;
                    int i10 = this.f3271c0;
                    return new RippleDrawable(new ColorStateList(G0, new int[]{q2.a.F(v6, i10, 0.1f), i10}), fVar4, fVar4);
                }
            }
        }
        return this.K;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.M == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.M = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.M.addState(new int[0], f(false));
        }
        return this.M;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.L == null) {
            this.L = f(true);
        }
        return this.L;
    }

    public static void k(ViewGroup viewGroup, boolean z6) {
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroup.getChildAt(i7);
            childAt.setEnabled(z6);
            if (childAt instanceof ViewGroup) {
                k((ViewGroup) childAt, z6);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f3280i == null) {
            if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f3280i = editText;
            int i7 = this.f3284k;
            if (i7 != -1) {
                setMinEms(i7);
            } else {
                setMinWidth(this.m);
            }
            int i8 = this.f3286l;
            if (i8 != -1) {
                setMaxEms(i8);
            } else {
                setMaxWidth(this.f3289n);
            }
            this.N = false;
            i();
            setTextInputAccessibilityDelegate(new d(this));
            this.f3313z0.m(this.f3280i.getTypeface());
            d4.c cVar = this.f3313z0;
            float textSize = this.f3280i.getTextSize();
            if (cVar.f3580h != textSize) {
                cVar.f3580h = textSize;
                cVar.h(false);
            }
            d4.c cVar2 = this.f3313z0;
            float letterSpacing = this.f3280i.getLetterSpacing();
            if (cVar2.W != letterSpacing) {
                cVar2.W = letterSpacing;
                cVar2.h(false);
            }
            int gravity = this.f3280i.getGravity();
            d4.c cVar3 = this.f3313z0;
            int i9 = (gravity & -113) | 48;
            if (cVar3.f3579g != i9) {
                cVar3.f3579g = i9;
                cVar3.h(false);
            }
            d4.c cVar4 = this.f3313z0;
            if (cVar4.f3577f != gravity) {
                cVar4.f3577f = gravity;
                cVar4.h(false);
            }
            this.f3280i.addTextChangedListener(new a());
            if (this.f3290n0 == null) {
                this.f3290n0 = this.f3280i.getHintTextColors();
            }
            if (this.H) {
                if (TextUtils.isEmpty(this.I)) {
                    CharSequence hint = this.f3280i.getHint();
                    this.f3282j = hint;
                    setHint(hint);
                    this.f3280i.setHint((CharSequence) null);
                }
                this.J = true;
            }
            p();
            if (this.f3300t != null) {
                n(this.f3280i.getText());
            }
            r();
            this.f3291o.b();
            this.f3276g.bringToFront();
            this.f3278h.bringToFront();
            Iterator<f> it = this.f3283j0.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            this.f3278h.m();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            u(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.I)) {
            this.I = charSequence;
            d4.c cVar = this.f3313z0;
            if (charSequence == null || !TextUtils.equals(cVar.A, charSequence)) {
                cVar.A = charSequence;
                cVar.B = null;
                Bitmap bitmap = cVar.E;
                if (bitmap != null) {
                    bitmap.recycle();
                    cVar.E = null;
                }
                cVar.h(false);
            }
            if (!this.f3311y0) {
                j();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z6) {
        if (this.f3308x != z6) {
            if (z6) {
                c0 c0Var = this.f3310y;
                if (c0Var != null) {
                    this.f3274f.addView(c0Var);
                    this.f3310y.setVisibility(0);
                }
            } else {
                c0 c0Var2 = this.f3310y;
                if (c0Var2 != null) {
                    c0Var2.setVisibility(8);
                }
                this.f3310y = null;
            }
            this.f3308x = z6;
        }
    }

    public final void a(float f7) {
        if (this.f3313z0.f3570b != f7) {
            if (this.C0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.C0 = valueAnimator;
                valueAnimator.setInterpolator(j.d(getContext(), 2130903884, n3.a.f5162b));
                this.C0.setDuration((long) j.c(getContext(), 2130903874, 167));
                this.C0.addUpdateListener(new c());
            }
            this.C0.setFloatValues(this.f3313z0.f3570b, f7);
            this.C0.start();
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f3274f.addView(view, layoutParams2);
            this.f3274f.setLayoutParams(layoutParams);
            t();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i7, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r7 = this;
            k4.f r0 = r7.K
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            k4.f$b r1 = r0.f4720f
            k4.i r1 = r1.f4740a
            k4.i r2 = r7.Q
            if (r1 == r2) goto L_0x0010
            r0.setShapeAppearanceModel(r2)
        L_0x0010:
            int r0 = r7.T
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L_0x0027
            int r0 = r7.V
            if (r0 <= r2) goto L_0x0022
            int r0 = r7.f3270b0
            if (r0 == 0) goto L_0x0022
            r0 = r4
            goto L_0x0023
        L_0x0022:
            r0 = r3
        L_0x0023:
            if (r0 == 0) goto L_0x0027
            r0 = r4
            goto L_0x0028
        L_0x0027:
            r0 = r3
        L_0x0028:
            if (r0 == 0) goto L_0x004b
            k4.f r0 = r7.K
            int r1 = r7.V
            float r1 = (float) r1
            int r5 = r7.f3270b0
            k4.f$b r6 = r0.f4720f
            r6.f4749k = r1
            r0.invalidateSelf()
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r5)
            k4.f$b r5 = r0.f4720f
            android.content.res.ColorStateList r6 = r5.f4743d
            if (r6 == r1) goto L_0x004b
            r5.f4743d = r1
            int[] r1 = r0.getState()
            r0.onStateChange(r1)
        L_0x004b:
            int r0 = r7.f3271c0
            int r1 = r7.T
            if (r1 != r4) goto L_0x0062
            r0 = 2130903330(0x7f030122, float:1.7413475E38)
            android.content.Context r1 = r7.getContext()
            int r0 = q2.a.u(r1, r0, r3)
            int r1 = r7.f3271c0
            int r0 = i1.a.b(r1, r0)
        L_0x0062:
            r7.f3271c0 = r0
            k4.f r1 = r7.K
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.k(r0)
            k4.f r0 = r7.O
            if (r0 == 0) goto L_0x00a3
            k4.f r1 = r7.P
            if (r1 != 0) goto L_0x0076
            goto L_0x00a3
        L_0x0076:
            int r1 = r7.V
            if (r1 <= r2) goto L_0x007f
            int r1 = r7.f3270b0
            if (r1 == 0) goto L_0x007f
            r3 = r4
        L_0x007f:
            if (r3 == 0) goto L_0x00a0
            android.widget.EditText r1 = r7.f3280i
            boolean r1 = r1.isFocused()
            if (r1 == 0) goto L_0x008c
            int r1 = r7.f3294p0
            goto L_0x008e
        L_0x008c:
            int r1 = r7.f3270b0
        L_0x008e:
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.k(r1)
            k4.f r0 = r7.P
            int r1 = r7.f3270b0
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.k(r1)
        L_0x00a0:
            r7.invalidate()
        L_0x00a3:
            r7.s()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.b():void");
    }

    public final int c() {
        float d7;
        if (!this.H) {
            return 0;
        }
        int i7 = this.T;
        if (i7 == 0) {
            d7 = this.f3313z0.d();
        } else if (i7 != 2) {
            return 0;
        } else {
            d7 = this.f3313z0.d() / 2.0f;
        }
        return (int) d7;
    }

    public final k2.d d() {
        k2.d dVar = new k2.d();
        dVar.f4634h = (long) j.c(getContext(), 2130903876, 87);
        dVar.f4635i = j.d(getContext(), 2130903886, n3.a.f5161a);
        return dVar;
    }

    @Override // android.view.View, android.view.ViewGroup
    @TargetApi(ErrorCode.INVALID_AUDIO_INPUT_STREAM_IO_CODE)
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i7) {
        EditText editText = this.f3280i;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i7);
            return;
        }
        if (this.f3282j != null) {
            boolean z6 = this.J;
            this.J = false;
            CharSequence hint = editText.getHint();
            this.f3280i.setHint(this.f3282j);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i7);
            } finally {
                this.f3280i.setHint(hint);
                this.J = z6;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i7);
            onProvideAutofillVirtualStructure(viewStructure, i7);
            viewStructure.setChildCount(this.f3274f.getChildCount());
            for (int i8 = 0; i8 < this.f3274f.getChildCount(); i8++) {
                View childAt = this.f3274f.getChildAt(i8);
                ViewStructure newChild = viewStructure.newChild(i8);
                childAt.dispatchProvideAutofillStructure(newChild, i7);
                if (childAt == this.f3280i) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.E0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.E0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        k4.f fVar;
        super.draw(canvas);
        if (this.H) {
            d4.c cVar = this.f3313z0;
            cVar.getClass();
            int save = canvas.save();
            if (cVar.B != null && cVar.e.width() > 0.0f && cVar.e.height() > 0.0f) {
                cVar.N.setTextSize(cVar.G);
                float f7 = cVar.f3587p;
                float f8 = cVar.f3588q;
                float f9 = cVar.F;
                if (f9 != 1.0f) {
                    canvas.scale(f9, f9, f7, f8);
                }
                boolean z6 = true;
                if (cVar.f3575d0 <= 1 || cVar.C) {
                    z6 = false;
                }
                if (z6) {
                    float lineStart = cVar.f3587p - ((float) cVar.Y.getLineStart(0));
                    int alpha = cVar.N.getAlpha();
                    canvas.translate(lineStart, f8);
                    float f10 = (float) alpha;
                    cVar.N.setAlpha((int) (cVar.f3571b0 * f10));
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 31) {
                        TextPaint textPaint = cVar.N;
                        float f11 = cVar.H;
                        float f12 = cVar.I;
                        float f13 = cVar.J;
                        int i8 = cVar.K;
                        textPaint.setShadowLayer(f11, f12, f13, i1.a.c(i8, (Color.alpha(i8) * textPaint.getAlpha()) / 255));
                    }
                    cVar.Y.draw(canvas);
                    cVar.N.setAlpha((int) (cVar.f3569a0 * f10));
                    if (i7 >= 31) {
                        TextPaint textPaint2 = cVar.N;
                        float f14 = cVar.H;
                        float f15 = cVar.I;
                        float f16 = cVar.J;
                        int i9 = cVar.K;
                        textPaint2.setShadowLayer(f14, f15, f16, i1.a.c(i9, (Color.alpha(i9) * textPaint2.getAlpha()) / 255));
                    }
                    int lineBaseline = cVar.Y.getLineBaseline(0);
                    CharSequence charSequence = cVar.f3573c0;
                    float f17 = (float) lineBaseline;
                    canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f17, cVar.N);
                    if (i7 >= 31) {
                        cVar.N.setShadowLayer(cVar.H, cVar.I, cVar.J, cVar.K);
                    }
                    String trim = cVar.f3573c0.toString().trim();
                    if (trim.endsWith("…")) {
                        trim = trim.substring(0, trim.length() - 1);
                    }
                    cVar.N.setAlpha(alpha);
                    canvas.drawText(trim, 0, Math.min(cVar.Y.getLineEnd(0), trim.length()), 0.0f, f17, (Paint) cVar.N);
                } else {
                    canvas.translate(f7, f8);
                    cVar.Y.draw(canvas);
                }
                canvas.restoreToCount(save);
            }
        }
        if (this.P != null && (fVar = this.O) != null) {
            fVar.draw(canvas);
            if (this.f3280i.isFocused()) {
                Rect bounds = this.P.getBounds();
                Rect bounds2 = this.O.getBounds();
                float f18 = this.f3313z0.f3570b;
                int centerX = bounds2.centerX();
                bounds.left = n3.a.b(centerX, bounds2.left, f18);
                bounds.right = n3.a.b(centerX, bounds2.right, f18);
                this.P.draw(canvas);
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void drawableStateChanged() {
        boolean z6;
        boolean z7;
        ColorStateList colorStateList;
        if (!this.D0) {
            boolean z8 = true;
            this.D0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            d4.c cVar = this.f3313z0;
            if (cVar != null) {
                cVar.L = drawableState;
                ColorStateList colorStateList2 = cVar.f3583k;
                if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = cVar.f3582j) != null && colorStateList.isStateful())) {
                    cVar.h(false);
                    z7 = true;
                } else {
                    z7 = false;
                }
                z6 = z7 | false;
            } else {
                z6 = false;
            }
            if (this.f3280i != null) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (!y.g.c(this) || !isEnabled()) {
                    z8 = false;
                }
                u(z8, false);
            }
            r();
            x();
            if (z6) {
                invalidate();
            }
            this.D0 = false;
        }
    }

    public final boolean e() {
        return this.H && !TextUtils.isEmpty(this.I) && (this.K instanceof o4.h);
    }

    public final k4.f f(boolean z6) {
        int i7;
        float dimensionPixelOffset = (float) getResources().getDimensionPixelOffset(2131100384);
        float f7 = z6 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f3280i;
        float popupElevation = editText instanceof r ? ((r) editText).getPopupElevation() : (float) getResources().getDimensionPixelOffset(2131099985);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(2131100321);
        i.a aVar = new i.a();
        aVar.e(f7);
        aVar.f(f7);
        aVar.c(dimensionPixelOffset);
        aVar.d(dimensionPixelOffset);
        i iVar = new i(aVar);
        ColorStateList colorStateList = null;
        EditText editText2 = this.f3280i;
        if (editText2 instanceof r) {
            colorStateList = ((r) editText2).getDropDownBackgroundTintList();
        }
        Context context = getContext();
        if (colorStateList == null) {
            String str = k4.f.C;
            TypedValue c7 = g4.b.c(2130903330, context, k4.f.class.getSimpleName());
            int i8 = c7.resourceId;
            if (i8 != 0) {
                Object obj = g1.a.f4192a;
                i7 = a.d.a(context, i8);
            } else {
                i7 = c7.data;
            }
            colorStateList = ColorStateList.valueOf(i7);
        }
        k4.f fVar = new k4.f();
        fVar.i(context);
        fVar.k(colorStateList);
        fVar.j(popupElevation);
        fVar.setShapeAppearanceModel(iVar);
        f.b bVar = fVar.f4720f;
        if (bVar.f4746h == null) {
            bVar.f4746h = new Rect();
        }
        fVar.f4720f.f4746h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        fVar.invalidateSelf();
        return fVar;
    }

    public final int g(int i7, boolean z6) {
        return ((z6 || getPrefixText() == null) ? (!z6 || getSuffixText() == null) ? this.f3280i.getCompoundPaddingLeft() : this.f3278h.c() : this.f3276g.a()) + i7;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f3280i;
        if (editText == null) {
            return super.getBaseline();
        }
        int baseline = editText.getBaseline();
        return c() + getPaddingTop() + baseline;
    }

    public k4.f getBoxBackground() {
        int i7 = this.T;
        if (i7 == 1 || i7 == 2) {
            return this.K;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f3271c0;
    }

    public int getBoxBackgroundMode() {
        return this.T;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.U;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return (s.a(this) ? this.Q.f4766h : this.Q.f4765g).a(this.f3275f0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return (s.a(this) ? this.Q.f4765g : this.Q.f4766h).a(this.f3275f0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return (s.a(this) ? this.Q.e : this.Q.f4764f).a(this.f3275f0);
    }

    public float getBoxCornerRadiusTopStart() {
        return (s.a(this) ? this.Q.f4764f : this.Q.e).a(this.f3275f0);
    }

    public int getBoxStrokeColor() {
        return this.f3298r0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f3299s0;
    }

    public int getBoxStrokeWidth() {
        return this.W;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f3269a0;
    }

    public int getCounterMaxLength() {
        return this.f3295q;
    }

    public CharSequence getCounterOverflowDescription() {
        c0 c0Var;
        if (!this.f3293p || !this.f3297r || (c0Var = this.f3300t) == null) {
            return null;
        }
        return c0Var.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.E;
    }

    public ColorStateList getCounterTextColor() {
        return this.D;
    }

    public ColorStateList getCursorColor() {
        return this.F;
    }

    public ColorStateList getCursorErrorColor() {
        return this.G;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f3290n0;
    }

    public EditText getEditText() {
        return this.f3280i;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f3278h.f3326l.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f3278h.f3326l.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f3278h.f3331r;
    }

    public int getEndIconMode() {
        return this.f3278h.f3327n;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f3278h.s;
    }

    public CheckableImageButton getEndIconView() {
        return this.f3278h.f3326l;
    }

    public CharSequence getError() {
        o oVar = this.f3291o;
        if (oVar.f5382q) {
            return oVar.f5381p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f3291o.f5384t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f3291o.s;
    }

    public int getErrorCurrentTextColors() {
        c0 c0Var = this.f3291o.f5383r;
        if (c0Var != null) {
            return c0Var.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f3278h.f3322h.getDrawable();
    }

    public CharSequence getHelperText() {
        o oVar = this.f3291o;
        if (oVar.f5388x) {
            return oVar.f5387w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        c0 c0Var = this.f3291o.f5389y;
        if (c0Var != null) {
            return c0Var.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.H) {
            return this.I;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f3313z0.d();
    }

    public final int getHintCurrentCollapsedTextColor() {
        d4.c cVar = this.f3313z0;
        return cVar.e(cVar.f3583k);
    }

    public ColorStateList getHintTextColor() {
        return this.f3292o0;
    }

    public e getLengthCounter() {
        return this.s;
    }

    public int getMaxEms() {
        return this.f3286l;
    }

    public int getMaxWidth() {
        return this.f3289n;
    }

    public int getMinEms() {
        return this.f3284k;
    }

    public int getMinWidth() {
        return this.m;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3278h.f3326l.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3278h.f3326l.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f3308x) {
            return this.f3306w;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.A;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f3312z;
    }

    public CharSequence getPrefixText() {
        return this.f3276g.f5411h;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f3276g.f5410g.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f3276g.f5410g;
    }

    public i getShapeAppearanceModel() {
        return this.Q;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f3276g.f5412i.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f3276g.f5412i.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f3276g.f5415l;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f3276g.m;
    }

    public CharSequence getSuffixText() {
        return this.f3278h.f3333u;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f3278h.f3334v.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f3278h.f3334v;
    }

    public Typeface getTypeface() {
        return this.f3277g0;
    }

    public final int h(int i7, boolean z6) {
        return i7 - ((z6 || getSuffixText() == null) ? (!z6 || getPrefixText() == null) ? this.f3280i.getCompoundPaddingRight() : this.f3276g.a() : this.f3278h.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.i():void");
    }

    public final void j() {
        float f7;
        float f8;
        float f9;
        float f10;
        if (e()) {
            RectF rectF = this.f3275f0;
            d4.c cVar = this.f3313z0;
            int width = this.f3280i.getWidth();
            int gravity = this.f3280i.getGravity();
            boolean b2 = cVar.b(cVar.A);
            cVar.C = b2;
            if (gravity == 17 || (gravity & 7) == 1) {
                f10 = ((float) width) / 2.0f;
                f9 = cVar.Z / 2.0f;
            } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !b2 : b2) {
                f10 = (float) cVar.f3574d.right;
                f9 = cVar.Z;
            } else {
                f7 = (float) cVar.f3574d.left;
                float max = Math.max(f7, (float) cVar.f3574d.left);
                rectF.left = max;
                Rect rect = cVar.f3574d;
                rectF.top = (float) rect.top;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f8 = (((float) width) / 2.0f) + (cVar.Z / 2.0f);
                } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (cVar.C) {
                        f8 = cVar.Z + max;
                    }
                    f8 = (float) rect.right;
                } else {
                    if (!cVar.C) {
                        f8 = cVar.Z + max;
                    }
                    f8 = (float) rect.right;
                }
                rectF.right = Math.min(f8, (float) rect.right);
                rectF.bottom = cVar.d() + ((float) cVar.f3574d.top);
                if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
                    float f11 = rectF.left;
                    float f12 = (float) this.S;
                    rectF.left = f11 - f12;
                    rectF.right += f12;
                    rectF.offset((float) (-getPaddingLeft()), (((float) (-getPaddingTop())) - (rectF.height() / 2.0f)) + ((float) this.V));
                    o4.h hVar = (o4.h) this.K;
                    hVar.getClass();
                    hVar.o(rectF.left, rectF.top, rectF.right, rectF.bottom);
                    return;
                }
            }
            f7 = f10 - f9;
            float max2 = Math.max(f7, (float) cVar.f3574d.left);
            rectF.left = max2;
            Rect rect2 = cVar.f3574d;
            rectF.top = (float) rect2.top;
            if (gravity != 17) {
            }
            f8 = (((float) width) / 2.0f) + (cVar.Z / 2.0f);
            rectF.right = Math.min(f8, (float) rect2.right);
            rectF.bottom = cVar.d() + ((float) cVar.f3574d.top);
            if (rectF.width() > 0.0f) {
            }
        }
    }

    public final void l(TextView textView, int i7) {
        boolean z6 = true;
        try {
            textView.setTextAppearance(i7);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z6 = false;
            }
        } catch (Exception unused) {
        }
        if (z6) {
            textView.setTextAppearance(2131886493);
            Context context = getContext();
            Object obj = g1.a.f4192a;
            textView.setTextColor(a.d.a(context, 2131034194));
        }
    }

    public final boolean m() {
        o oVar = this.f3291o;
        return oVar.f5380o == 1 && oVar.f5383r != null && !TextUtils.isEmpty(oVar.f5381p);
    }

    public final void n(Editable editable) {
        ((c0.e) this.s).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z6 = this.f3297r;
        int i7 = this.f3295q;
        String str = null;
        if (i7 == -1) {
            this.f3300t.setText(String.valueOf(length));
            this.f3300t.setContentDescription(null);
            this.f3297r = false;
        } else {
            this.f3297r = length > i7;
            Context context = getContext();
            this.f3300t.setContentDescription(context.getString(this.f3297r ? 2131820588 : 2131820587, Integer.valueOf(length), Integer.valueOf(this.f3295q)));
            if (z6 != this.f3297r) {
                o();
            }
            n1.a c7 = n1.a.c();
            c0 c0Var = this.f3300t;
            String string = getContext().getString(2131820589, Integer.valueOf(length), Integer.valueOf(this.f3295q));
            n1.d dVar = c7.f5113c;
            if (string != null) {
                str = c7.d(string, dVar).toString();
            }
            c0Var.setText(str);
        }
        if (this.f3280i != null && z6 != this.f3297r) {
            u(false, false);
            x();
            r();
        }
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        c0 c0Var = this.f3300t;
        if (c0Var != null) {
            l(c0Var, this.f3297r ? this.f3302u : this.f3304v);
            if (!this.f3297r && (colorStateList2 = this.D) != null) {
                this.f3300t.setTextColor(colorStateList2);
            }
            if (this.f3297r && (colorStateList = this.E) != null) {
                this.f3300t.setTextColor(colorStateList);
            }
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3313z0.g(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int max;
        this.f3278h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z6 = false;
        this.F0 = false;
        if (this.f3280i != null && this.f3280i.getMeasuredHeight() < (max = Math.max(this.f3278h.getMeasuredHeight(), this.f3276g.getMeasuredHeight()))) {
            this.f3280i.setMinimumHeight(max);
            z6 = true;
        }
        boolean q6 = q();
        if (z6 || q6) {
            this.f3280i.post(new androidx.activity.d(12, this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019c  */
    @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i7, int i8) {
        EditText editText;
        super.onMeasure(i7, i8);
        if (!this.F0) {
            this.f3278h.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.F0 = true;
        }
        if (!(this.f3310y == null || (editText = this.f3280i) == null)) {
            this.f3310y.setGravity(editText.getGravity());
            this.f3310y.setPadding(this.f3280i.getCompoundPaddingLeft(), this.f3280i.getCompoundPaddingTop(), this.f3280i.getCompoundPaddingRight(), this.f3280i.getCompoundPaddingBottom());
        }
        this.f3278h.m();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f6374f);
        setError(hVar.f3318h);
        if (hVar.f3319i) {
            post(new b());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i7) {
        super.onRtlPropertiesChanged(i7);
        boolean z6 = true;
        if (i7 != 1) {
            z6 = false;
        }
        if (z6 != this.R) {
            float a7 = this.Q.e.a(this.f3275f0);
            float a8 = this.Q.f4764f.a(this.f3275f0);
            float a9 = this.Q.f4766h.a(this.f3275f0);
            float a10 = this.Q.f4765g.a(this.f3275f0);
            i iVar = this.Q;
            g6.i iVar2 = iVar.f4760a;
            g6.i iVar3 = iVar.f4761b;
            g6.i iVar4 = iVar.f4763d;
            g6.i iVar5 = iVar.f4762c;
            i.a aVar = new i.a();
            aVar.f4771a = iVar3;
            float b2 = i.a.b(iVar3);
            if (b2 != -1.0f) {
                aVar.e(b2);
            }
            aVar.f4772b = iVar2;
            float b7 = i.a.b(iVar2);
            if (b7 != -1.0f) {
                aVar.f(b7);
            }
            aVar.f4774d = iVar5;
            float b8 = i.a.b(iVar5);
            if (b8 != -1.0f) {
                aVar.c(b8);
            }
            aVar.f4773c = iVar4;
            float b9 = i.a.b(iVar4);
            if (b9 != -1.0f) {
                aVar.d(b9);
            }
            aVar.e(a8);
            aVar.f(a7);
            aVar.c(a10);
            aVar.d(a9);
            i iVar6 = new i(aVar);
            this.R = z6;
            setShapeAppearanceModel(iVar6);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (m()) {
            hVar.f3318h = getError();
        }
        a aVar = this.f3278h;
        boolean z6 = true;
        if (!(aVar.f3327n != 0) || !aVar.f3326l.isChecked()) {
            z6 = false;
        }
        hVar.f3319i = z6;
        return hVar;
    }

    public final void p() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.F;
        if (colorStateList2 == null) {
            Context context = getContext();
            TypedValue a7 = g4.b.a(context, 2130903289);
            colorStateList2 = null;
            if (a7 != null) {
                int i7 = a7.resourceId;
                if (i7 != 0) {
                    colorStateList2 = g1.a.c(context, i7);
                } else {
                    int i8 = a7.data;
                    if (i8 != 0) {
                        colorStateList2 = ColorStateList.valueOf(i8);
                    }
                }
            }
        }
        EditText editText = this.f3280i;
        if (editText != null && editText.getTextCursorDrawable() != null) {
            Drawable mutate = this.f3280i.getTextCursorDrawable().mutate();
            if ((m() || (this.f3300t != null && this.f3297r)) && (colorStateList = this.G) != null) {
                colorStateList2 = colorStateList;
            }
            a.b.h(mutate, colorStateList2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
        if (r6.d() != false) goto L_0x009f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009d, code lost:
        if (r10.f3278h.f3333u != null) goto L_0x009f;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q() {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q():boolean");
    }

    public final void r() {
        Drawable background;
        int i7;
        c0 c0Var;
        EditText editText = this.f3280i;
        if (editText != null && this.T == 0 && (background = editText.getBackground()) != null) {
            int[] iArr = h0.f914a;
            Drawable mutate = background.mutate();
            if (m()) {
                i7 = getErrorCurrentTextColors();
            } else if (!this.f3297r || (c0Var = this.f3300t) == null) {
                mutate.clearColorFilter();
                this.f3280i.refreshDrawableState();
                return;
            } else {
                i7 = c0Var.getCurrentTextColor();
            }
            mutate.setColorFilter(androidx.appcompat.widget.j.c(i7, PorterDuff.Mode.SRC_IN));
        }
    }

    public final void s() {
        EditText editText = this.f3280i;
        if (editText != null && this.K != null) {
            if ((this.N || editText.getBackground() == null) && this.T != 0) {
                Drawable editTextBoxBackground = getEditTextBoxBackground();
                EditText editText2 = this.f3280i;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.d.q(editText2, editTextBoxBackground);
                this.N = true;
            }
        }
    }

    public void setBoxBackgroundColor(int i7) {
        if (this.f3271c0 != i7) {
            this.f3271c0 = i7;
            this.f3301t0 = i7;
            this.f3305v0 = i7;
            this.f3307w0 = i7;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i7) {
        Context context = getContext();
        Object obj = g1.a.f4192a;
        setBoxBackgroundColor(a.d.a(context, i7));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f3301t0 = defaultColor;
        this.f3271c0 = defaultColor;
        this.f3303u0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f3305v0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f3307w0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i7) {
        if (i7 != this.T) {
            this.T = i7;
            if (this.f3280i != null) {
                i();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i7) {
        this.U = i7;
    }

    public void setBoxCornerFamily(int i7) {
        i iVar = this.Q;
        iVar.getClass();
        i.a aVar = new i.a(iVar);
        k4.c cVar = this.Q.e;
        g6.i o6 = q2.a.o(i7);
        aVar.f4771a = o6;
        float b2 = i.a.b(o6);
        if (b2 != -1.0f) {
            aVar.e(b2);
        }
        aVar.e = cVar;
        k4.c cVar2 = this.Q.f4764f;
        g6.i o7 = q2.a.o(i7);
        aVar.f4772b = o7;
        float b7 = i.a.b(o7);
        if (b7 != -1.0f) {
            aVar.f(b7);
        }
        aVar.f4775f = cVar2;
        k4.c cVar3 = this.Q.f4766h;
        g6.i o8 = q2.a.o(i7);
        aVar.f4774d = o8;
        float b8 = i.a.b(o8);
        if (b8 != -1.0f) {
            aVar.c(b8);
        }
        aVar.f4777h = cVar3;
        k4.c cVar4 = this.Q.f4765g;
        g6.i o9 = q2.a.o(i7);
        aVar.f4773c = o9;
        float b9 = i.a.b(o9);
        if (b9 != -1.0f) {
            aVar.d(b9);
        }
        aVar.f4776g = cVar4;
        this.Q = new i(aVar);
        b();
    }

    public void setBoxStrokeColor(int i7) {
        if (this.f3298r0 != i7) {
            this.f3298r0 = i7;
            x();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (colorStateList.isStateful()) {
            this.f3294p0 = colorStateList.getDefaultColor();
            this.f3309x0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f3296q0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else {
            if (this.f3298r0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            x();
        }
        this.f3298r0 = defaultColor;
        x();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f3299s0 != colorStateList) {
            this.f3299s0 = colorStateList;
            x();
        }
    }

    public void setBoxStrokeWidth(int i7) {
        this.W = i7;
        x();
    }

    public void setBoxStrokeWidthFocused(int i7) {
        this.f3269a0 = i7;
        x();
    }

    public void setBoxStrokeWidthFocusedResource(int i7) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i7));
    }

    public void setBoxStrokeWidthResource(int i7) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i7));
    }

    public void setCounterEnabled(boolean z6) {
        if (this.f3293p != z6) {
            Editable editable = null;
            if (z6) {
                c0 c0Var = new c0(getContext(), null);
                this.f3300t = c0Var;
                c0Var.setId(2131296866);
                Typeface typeface = this.f3277g0;
                if (typeface != null) {
                    this.f3300t.setTypeface(typeface);
                }
                this.f3300t.setMaxLines(1);
                this.f3291o.a(this.f3300t, 2);
                p1.g.h((ViewGroup.MarginLayoutParams) this.f3300t.getLayoutParams(), getResources().getDimensionPixelOffset(2131100412));
                o();
                if (this.f3300t != null) {
                    EditText editText = this.f3280i;
                    if (editText != null) {
                        editable = editText.getText();
                    }
                    n(editable);
                }
            } else {
                this.f3291o.g(this.f3300t, 2);
                this.f3300t = null;
            }
            this.f3293p = z6;
        }
    }

    public void setCounterMaxLength(int i7) {
        if (this.f3295q != i7) {
            if (i7 <= 0) {
                i7 = -1;
            }
            this.f3295q = i7;
            if (this.f3293p && this.f3300t != null) {
                EditText editText = this.f3280i;
                n(editText == null ? null : editText.getText());
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i7) {
        if (this.f3302u != i7) {
            this.f3302u = i7;
            o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i7) {
        if (this.f3304v != i7) {
            this.f3304v = i7;
            o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            o();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            p();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            if (m() || (this.f3300t != null && this.f3297r)) {
                p();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f3290n0 = colorStateList;
        this.f3292o0 = colorStateList;
        if (this.f3280i != null) {
            u(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z6) {
        k(this, z6);
        super.setEnabled(z6);
    }

    public void setEndIconActivated(boolean z6) {
        this.f3278h.f3326l.setActivated(z6);
    }

    public void setEndIconCheckable(boolean z6) {
        this.f3278h.f3326l.setCheckable(z6);
    }

    public void setEndIconContentDescription(int i7) {
        a aVar = this.f3278h;
        CharSequence text = i7 != 0 ? aVar.getResources().getText(i7) : null;
        if (aVar.f3326l.getContentDescription() != text) {
            aVar.f3326l.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i7) {
        a aVar = this.f3278h;
        Drawable a7 = i7 != 0 ? g.a.a(aVar.getContext(), i7) : null;
        aVar.f3326l.setImageDrawable(a7);
        if (a7 != null) {
            n.a(aVar.f3320f, aVar.f3326l, aVar.f3329p, aVar.f3330q);
            n.c(aVar.f3320f, aVar.f3326l, aVar.f3329p);
        }
    }

    public void setEndIconMinSize(int i7) {
        a aVar = this.f3278h;
        if (i7 < 0) {
            aVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        } else if (i7 != aVar.f3331r) {
            aVar.f3331r = i7;
            CheckableImageButton checkableImageButton = aVar.f3326l;
            checkableImageButton.setMinimumWidth(i7);
            checkableImageButton.setMinimumHeight(i7);
            CheckableImageButton checkableImageButton2 = aVar.f3322h;
            checkableImageButton2.setMinimumWidth(i7);
            checkableImageButton2.setMinimumHeight(i7);
        }
    }

    public void setEndIconMode(int i7) {
        this.f3278h.g(i7);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        a aVar = this.f3278h;
        CheckableImageButton checkableImageButton = aVar.f3326l;
        View.OnLongClickListener onLongClickListener = aVar.f3332t;
        checkableImageButton.setOnClickListener(onClickListener);
        n.d(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        a aVar = this.f3278h;
        aVar.f3332t = onLongClickListener;
        CheckableImageButton checkableImageButton = aVar.f3326l;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        n.d(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        a aVar = this.f3278h;
        aVar.s = scaleType;
        aVar.f3326l.setScaleType(scaleType);
        aVar.f3322h.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        a aVar = this.f3278h;
        if (aVar.f3329p != colorStateList) {
            aVar.f3329p = colorStateList;
            n.a(aVar.f3320f, aVar.f3326l, colorStateList, aVar.f3330q);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        a aVar = this.f3278h;
        if (aVar.f3330q != mode) {
            aVar.f3330q = mode;
            n.a(aVar.f3320f, aVar.f3326l, aVar.f3329p, mode);
        }
    }

    public void setEndIconVisible(boolean z6) {
        this.f3278h.h(z6);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f3291o.f5382q) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        o oVar = this.f3291o;
        if (!isEmpty) {
            oVar.c();
            oVar.f5381p = charSequence;
            oVar.f5383r.setText(charSequence);
            int i7 = oVar.f5379n;
            if (i7 != 1) {
                oVar.f5380o = 1;
            }
            oVar.i(i7, oVar.f5380o, oVar.h(oVar.f5383r, charSequence));
            return;
        }
        oVar.f();
    }

    public void setErrorAccessibilityLiveRegion(int i7) {
        o oVar = this.f3291o;
        oVar.f5384t = i7;
        c0 c0Var = oVar.f5383r;
        if (c0Var != null) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.g.f(c0Var, i7);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        o oVar = this.f3291o;
        oVar.s = charSequence;
        c0 c0Var = oVar.f5383r;
        if (c0Var != null) {
            c0Var.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z6) {
        o oVar = this.f3291o;
        if (oVar.f5382q != z6) {
            oVar.c();
            if (z6) {
                c0 c0Var = new c0(oVar.f5373g, null);
                oVar.f5383r = c0Var;
                c0Var.setId(2131296867);
                oVar.f5383r.setTextAlignment(5);
                Typeface typeface = oVar.B;
                if (typeface != null) {
                    oVar.f5383r.setTypeface(typeface);
                }
                int i7 = oVar.f5385u;
                oVar.f5385u = i7;
                c0 c0Var2 = oVar.f5383r;
                if (c0Var2 != null) {
                    oVar.f5374h.l(c0Var2, i7);
                }
                ColorStateList colorStateList = oVar.f5386v;
                oVar.f5386v = colorStateList;
                c0 c0Var3 = oVar.f5383r;
                if (!(c0Var3 == null || colorStateList == null)) {
                    c0Var3.setTextColor(colorStateList);
                }
                CharSequence charSequence = oVar.s;
                oVar.s = charSequence;
                c0 c0Var4 = oVar.f5383r;
                if (c0Var4 != null) {
                    c0Var4.setContentDescription(charSequence);
                }
                int i8 = oVar.f5384t;
                oVar.f5384t = i8;
                c0 c0Var5 = oVar.f5383r;
                if (c0Var5 != null) {
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    y.g.f(c0Var5, i8);
                }
                oVar.f5383r.setVisibility(4);
                oVar.a(oVar.f5383r, 0);
            } else {
                oVar.f();
                oVar.g(oVar.f5383r, 0);
                oVar.f5383r = null;
                oVar.f5374h.r();
                oVar.f5374h.x();
            }
            oVar.f5382q = z6;
        }
    }

    public void setErrorIconDrawable(int i7) {
        a aVar = this.f3278h;
        aVar.i(i7 != 0 ? g.a.a(aVar.getContext(), i7) : null);
        n.c(aVar.f3320f, aVar.f3322h, aVar.f3323i);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f3278h.i(drawable);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        a aVar = this.f3278h;
        CheckableImageButton checkableImageButton = aVar.f3322h;
        View.OnLongClickListener onLongClickListener = aVar.f3325k;
        checkableImageButton.setOnClickListener(onClickListener);
        n.d(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        a aVar = this.f3278h;
        aVar.f3325k = onLongClickListener;
        CheckableImageButton checkableImageButton = aVar.f3322h;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        n.d(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        a aVar = this.f3278h;
        if (aVar.f3323i != colorStateList) {
            aVar.f3323i = colorStateList;
            n.a(aVar.f3320f, aVar.f3322h, colorStateList, aVar.f3324j);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        a aVar = this.f3278h;
        if (aVar.f3324j != mode) {
            aVar.f3324j = mode;
            n.a(aVar.f3320f, aVar.f3322h, aVar.f3323i, mode);
        }
    }

    public void setErrorTextAppearance(int i7) {
        o oVar = this.f3291o;
        oVar.f5385u = i7;
        c0 c0Var = oVar.f5383r;
        if (c0Var != null) {
            oVar.f5374h.l(c0Var, i7);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        o oVar = this.f3291o;
        oVar.f5386v = colorStateList;
        c0 c0Var = oVar.f5383r;
        if (c0Var != null && colorStateList != null) {
            c0Var.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z6) {
        if (this.A0 != z6) {
            this.A0 = z6;
            u(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.f3291o.f5388x) {
                setHelperTextEnabled(true);
            }
            o oVar = this.f3291o;
            oVar.c();
            oVar.f5387w = charSequence;
            oVar.f5389y.setText(charSequence);
            int i7 = oVar.f5379n;
            if (i7 != 2) {
                oVar.f5380o = 2;
            }
            oVar.i(i7, oVar.f5380o, oVar.h(oVar.f5389y, charSequence));
        } else if (this.f3291o.f5388x) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        o oVar = this.f3291o;
        oVar.A = colorStateList;
        c0 c0Var = oVar.f5389y;
        if (c0Var != null && colorStateList != null) {
            c0Var.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z6) {
        o oVar = this.f3291o;
        if (oVar.f5388x != z6) {
            oVar.c();
            if (z6) {
                c0 c0Var = new c0(oVar.f5373g, null);
                oVar.f5389y = c0Var;
                c0Var.setId(2131296868);
                oVar.f5389y.setTextAlignment(5);
                Typeface typeface = oVar.B;
                if (typeface != null) {
                    oVar.f5389y.setTypeface(typeface);
                }
                oVar.f5389y.setVisibility(4);
                c0 c0Var2 = oVar.f5389y;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.g.f(c0Var2, 1);
                int i7 = oVar.f5390z;
                oVar.f5390z = i7;
                c0 c0Var3 = oVar.f5389y;
                if (c0Var3 != null) {
                    c0Var3.setTextAppearance(i7);
                }
                ColorStateList colorStateList = oVar.A;
                oVar.A = colorStateList;
                c0 c0Var4 = oVar.f5389y;
                if (!(c0Var4 == null || colorStateList == null)) {
                    c0Var4.setTextColor(colorStateList);
                }
                oVar.a(oVar.f5389y, 1);
                oVar.f5389y.setAccessibilityDelegate(new p(oVar));
            } else {
                oVar.c();
                int i8 = oVar.f5379n;
                if (i8 == 2) {
                    oVar.f5380o = 0;
                }
                oVar.i(i8, oVar.f5380o, oVar.h(oVar.f5389y, ""));
                oVar.g(oVar.f5389y, 1);
                oVar.f5389y = null;
                oVar.f5374h.r();
                oVar.f5374h.x();
            }
            oVar.f5388x = z6;
        }
    }

    public void setHelperTextTextAppearance(int i7) {
        o oVar = this.f3291o;
        oVar.f5390z = i7;
        c0 c0Var = oVar.f5389y;
        if (c0Var != null) {
            c0Var.setTextAppearance(i7);
        }
    }

    public void setHint(int i7) {
        setHint(i7 != 0 ? getResources().getText(i7) : null);
    }

    public void setHint(CharSequence charSequence) {
        if (this.H) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z6) {
        this.B0 = z6;
    }

    public void setHintEnabled(boolean z6) {
        if (z6 != this.H) {
            this.H = z6;
            if (!z6) {
                this.J = false;
                if (!TextUtils.isEmpty(this.I) && TextUtils.isEmpty(this.f3280i.getHint())) {
                    this.f3280i.setHint(this.I);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f3280i.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.I)) {
                        setHint(hint);
                    }
                    this.f3280i.setHint((CharSequence) null);
                }
                this.J = true;
            }
            if (this.f3280i != null) {
                t();
            }
        }
    }

    public void setHintTextAppearance(int i7) {
        d4.c cVar = this.f3313z0;
        g4.d dVar = new g4.d(cVar.f3568a.getContext(), i7);
        ColorStateList colorStateList = dVar.f4257j;
        if (colorStateList != null) {
            cVar.f3583k = colorStateList;
        }
        float f7 = dVar.f4258k;
        if (f7 != 0.0f) {
            cVar.f3581i = f7;
        }
        ColorStateList colorStateList2 = dVar.f4249a;
        if (colorStateList2 != null) {
            cVar.U = colorStateList2;
        }
        cVar.S = dVar.e;
        cVar.T = dVar.f4253f;
        cVar.R = dVar.f4254g;
        cVar.V = dVar.f4256i;
        g4.a aVar = cVar.f3595y;
        if (aVar != null) {
            aVar.f4248h = true;
        }
        d4.b bVar = new d4.b(cVar);
        dVar.a();
        cVar.f3595y = new g4.a(bVar, dVar.f4260n);
        dVar.c(cVar.f3568a.getContext(), cVar.f3595y);
        cVar.h(false);
        this.f3292o0 = this.f3313z0.f3583k;
        if (this.f3280i != null) {
            u(false, false);
            t();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f3292o0 != colorStateList) {
            if (this.f3290n0 == null) {
                d4.c cVar = this.f3313z0;
                if (cVar.f3583k != colorStateList) {
                    cVar.f3583k = colorStateList;
                    cVar.h(false);
                }
            }
            this.f3292o0 = colorStateList;
            if (this.f3280i != null) {
                u(false, false);
            }
        }
    }

    public void setLengthCounter(e eVar) {
        this.s = eVar;
    }

    public void setMaxEms(int i7) {
        this.f3286l = i7;
        EditText editText = this.f3280i;
        if (editText != null && i7 != -1) {
            editText.setMaxEms(i7);
        }
    }

    public void setMaxWidth(int i7) {
        this.f3289n = i7;
        EditText editText = this.f3280i;
        if (editText != null && i7 != -1) {
            editText.setMaxWidth(i7);
        }
    }

    public void setMaxWidthResource(int i7) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i7));
    }

    public void setMinEms(int i7) {
        this.f3284k = i7;
        EditText editText = this.f3280i;
        if (editText != null && i7 != -1) {
            editText.setMinEms(i7);
        }
    }

    public void setMinWidth(int i7) {
        this.m = i7;
        EditText editText = this.f3280i;
        if (editText != null && i7 != -1) {
            editText.setMinWidth(i7);
        }
    }

    public void setMinWidthResource(int i7) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i7));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i7) {
        a aVar = this.f3278h;
        aVar.f3326l.setContentDescription(i7 != 0 ? aVar.getResources().getText(i7) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i7) {
        a aVar = this.f3278h;
        aVar.f3326l.setImageDrawable(i7 != 0 ? g.a.a(aVar.getContext(), i7) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z6) {
        a aVar = this.f3278h;
        if (z6 && aVar.f3327n != 1) {
            aVar.g(1);
        } else if (!z6) {
            aVar.g(0);
        } else {
            aVar.getClass();
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        a aVar = this.f3278h;
        aVar.f3329p = colorStateList;
        n.a(aVar.f3320f, aVar.f3326l, colorStateList, aVar.f3330q);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        a aVar = this.f3278h;
        aVar.f3330q = mode;
        n.a(aVar.f3320f, aVar.f3326l, aVar.f3329p, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        Editable editable = null;
        if (this.f3310y == null) {
            c0 c0Var = new c0(getContext(), null);
            this.f3310y = c0Var;
            c0Var.setId(2131296869);
            c0 c0Var2 = this.f3310y;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.s(c0Var2, 2);
            k2.d d7 = d();
            this.B = d7;
            d7.f4633g = 67;
            this.C = d();
            setPlaceholderTextAppearance(this.A);
            setPlaceholderTextColor(this.f3312z);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f3308x) {
                setPlaceholderTextEnabled(true);
            }
            this.f3306w = charSequence;
        }
        EditText editText = this.f3280i;
        if (editText != null) {
            editable = editText.getText();
        }
        v(editable);
    }

    public void setPlaceholderTextAppearance(int i7) {
        this.A = i7;
        c0 c0Var = this.f3310y;
        if (c0Var != null) {
            c0Var.setTextAppearance(i7);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f3312z != colorStateList) {
            this.f3312z = colorStateList;
            c0 c0Var = this.f3310y;
            if (c0Var != null && colorStateList != null) {
                c0Var.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        u uVar = this.f3276g;
        uVar.getClass();
        uVar.f5411h = TextUtils.isEmpty(charSequence) ? null : charSequence;
        uVar.f5410g.setText(charSequence);
        uVar.e();
    }

    public void setPrefixTextAppearance(int i7) {
        this.f3276g.f5410g.setTextAppearance(i7);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f3276g.f5410g.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(i iVar) {
        k4.f fVar = this.K;
        if (fVar != null && fVar.f4720f.f4740a != iVar) {
            this.Q = iVar;
            b();
        }
    }

    public void setStartIconCheckable(boolean z6) {
        this.f3276g.f5412i.setCheckable(z6);
    }

    public void setStartIconContentDescription(int i7) {
        setStartIconContentDescription(i7 != 0 ? getResources().getText(i7) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        u uVar = this.f3276g;
        if (uVar.f5412i.getContentDescription() != charSequence) {
            uVar.f5412i.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i7) {
        setStartIconDrawable(i7 != 0 ? g.a.a(getContext(), i7) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f3276g.b(drawable);
    }

    public void setStartIconMinSize(int i7) {
        u uVar = this.f3276g;
        if (i7 < 0) {
            uVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        } else if (i7 != uVar.f5415l) {
            uVar.f5415l = i7;
            CheckableImageButton checkableImageButton = uVar.f5412i;
            checkableImageButton.setMinimumWidth(i7);
            checkableImageButton.setMinimumHeight(i7);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        u uVar = this.f3276g;
        CheckableImageButton checkableImageButton = uVar.f5412i;
        View.OnLongClickListener onLongClickListener = uVar.f5416n;
        checkableImageButton.setOnClickListener(onClickListener);
        n.d(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        u uVar = this.f3276g;
        uVar.f5416n = onLongClickListener;
        CheckableImageButton checkableImageButton = uVar.f5412i;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        n.d(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        u uVar = this.f3276g;
        uVar.m = scaleType;
        uVar.f5412i.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        u uVar = this.f3276g;
        if (uVar.f5413j != colorStateList) {
            uVar.f5413j = colorStateList;
            n.a(uVar.f5409f, uVar.f5412i, colorStateList, uVar.f5414k);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        u uVar = this.f3276g;
        if (uVar.f5414k != mode) {
            uVar.f5414k = mode;
            n.a(uVar.f5409f, uVar.f5412i, uVar.f5413j, mode);
        }
    }

    public void setStartIconVisible(boolean z6) {
        this.f3276g.c(z6);
    }

    public void setSuffixText(CharSequence charSequence) {
        a aVar = this.f3278h;
        aVar.getClass();
        aVar.f3333u = TextUtils.isEmpty(charSequence) ? null : charSequence;
        aVar.f3334v.setText(charSequence);
        aVar.n();
    }

    public void setSuffixTextAppearance(int i7) {
        this.f3278h.f3334v.setTextAppearance(i7);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f3278h.f3334v.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(d dVar) {
        EditText editText = this.f3280i;
        if (editText != null) {
            y.i(editText, dVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f3277g0) {
            this.f3277g0 = typeface;
            this.f3313z0.m(typeface);
            o oVar = this.f3291o;
            if (typeface != oVar.B) {
                oVar.B = typeface;
                c0 c0Var = oVar.f5383r;
                if (c0Var != null) {
                    c0Var.setTypeface(typeface);
                }
                c0 c0Var2 = oVar.f5389y;
                if (c0Var2 != null) {
                    c0Var2.setTypeface(typeface);
                }
            }
            c0 c0Var3 = this.f3300t;
            if (c0Var3 != null) {
                c0Var3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        if (this.T != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3274f.getLayoutParams();
            int c7 = c();
            if (c7 != layoutParams.topMargin) {
                layoutParams.topMargin = c7;
                this.f3274f.requestLayout();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.u(boolean, boolean):void");
    }

    public final void v(Editable editable) {
        ((c0.e) this.s).getClass();
        if ((editable != null ? editable.length() : 0) != 0 || this.f3311y0) {
            c0 c0Var = this.f3310y;
            if (c0Var != null && this.f3308x) {
                c0Var.setText((CharSequence) null);
                l.a(this.f3274f, this.C);
                this.f3310y.setVisibility(4);
            }
        } else if (this.f3310y != null && this.f3308x && !TextUtils.isEmpty(this.f3306w)) {
            this.f3310y.setText(this.f3306w);
            l.a(this.f3274f, this.B);
            this.f3310y.setVisibility(0);
            this.f3310y.bringToFront();
            announceForAccessibility(this.f3306w);
        }
    }

    public final void w(boolean z6, boolean z7) {
        int defaultColor = this.f3299s0.getDefaultColor();
        int colorForState = this.f3299s0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f3299s0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z6) {
            this.f3270b0 = colorForState2;
        } else if (z7) {
            this.f3270b0 = colorForState;
        } else {
            this.f3270b0 = defaultColor;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x() {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.x():void");
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f3278h.f3326l.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f3278h.f3326l.setImageDrawable(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        a aVar = this.f3278h;
        if (aVar.f3326l.getContentDescription() != charSequence) {
            aVar.f3326l.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        a aVar = this.f3278h;
        aVar.f3326l.setImageDrawable(drawable);
        if (drawable != null) {
            n.a(aVar.f3320f, aVar.f3326l, aVar.f3329p, aVar.f3330q);
            n.c(aVar.f3320f, aVar.f3326l, aVar.f3329p);
        }
    }
}
