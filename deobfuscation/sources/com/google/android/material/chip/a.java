package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import d4.l;
import g4.d;
import j1.a;
import j1.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import k4.f;
import k4.i;
import k4.j;
import linc.com.amplituda.ErrorCode;
import n3.g;

/* loaded from: classes.dex */
public final class a extends f implements Drawable.Callback, l.b {
    public static final int[] N0 = {16842910};
    public static final ShapeDrawable O0 = new ShapeDrawable(new OvalShape());
    public int A0;
    public ColorFilter B0;
    public PorterDuffColorFilter C0;
    public ColorStateList D0;
    public ColorStateList E;
    public PorterDuff.Mode E0;
    public ColorStateList F;
    public int[] F0;
    public float G;
    public boolean G0;
    public float H;
    public ColorStateList H0;
    public ColorStateList I;
    public WeakReference<InterfaceC0033a> I0;
    public float J;
    public TextUtils.TruncateAt J0;
    public ColorStateList K;
    public boolean K0;
    public CharSequence L;
    public int L0;
    public boolean M;
    public boolean M0;
    public Drawable N;
    public ColorStateList O;
    public float P;
    public boolean Q;
    public boolean R;
    public Drawable S;
    public RippleDrawable T;
    public ColorStateList U;
    public float V;
    public SpannableStringBuilder W;
    public boolean X;
    public boolean Y;
    public Drawable Z;

    /* renamed from: a0 */
    public ColorStateList f3008a0;

    /* renamed from: b0 */
    public g f3009b0;

    /* renamed from: c0 */
    public g f3010c0;

    /* renamed from: d0 */
    public float f3011d0;

    /* renamed from: e0 */
    public float f3012e0;

    /* renamed from: f0 */
    public float f3013f0;

    /* renamed from: g0 */
    public float f3014g0;

    /* renamed from: h0 */
    public float f3015h0;

    /* renamed from: i0 */
    public float f3016i0;

    /* renamed from: j0 */
    public float f3017j0;

    /* renamed from: k0 */
    public float f3018k0;

    /* renamed from: l0 */
    public final Context f3019l0;

    /* renamed from: m0 */
    public final Paint f3020m0;

    /* renamed from: n0 */
    public final Paint.FontMetrics f3021n0;

    /* renamed from: o0 */
    public final RectF f3022o0;

    /* renamed from: p0 */
    public final PointF f3023p0;

    /* renamed from: q0 */
    public final Path f3024q0;

    /* renamed from: r0 */
    public final l f3025r0;

    /* renamed from: s0 */
    public int f3026s0;

    /* renamed from: t0 */
    public int f3027t0;

    /* renamed from: u0 */
    public int f3028u0;

    /* renamed from: v0 */
    public int f3029v0;

    /* renamed from: w0 */
    public int f3030w0;

    /* renamed from: x0 */
    public int f3031x0;

    /* renamed from: y0 */
    public boolean f3032y0;

    /* renamed from: z0 */
    public int f3033z0;

    /* renamed from: com.google.android.material.chip.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0033a {
        void a();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130903249, 2131887114);
        this.H = -1.0f;
        this.f3020m0 = new Paint(1);
        this.f3021n0 = new Paint.FontMetrics();
        this.f3022o0 = new RectF();
        this.f3023p0 = new PointF();
        this.f3024q0 = new Path();
        this.A0 = 255;
        this.E0 = PorterDuff.Mode.SRC_IN;
        this.I0 = new WeakReference<>(null);
        i(context);
        this.f3019l0 = context;
        l lVar = new l(this);
        this.f3025r0 = lVar;
        this.L = "";
        lVar.f3624a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = N0;
        setState(iArr);
        if (!Arrays.equals(this.F0, iArr)) {
            this.F0 = iArr;
            if (U()) {
                w(getState(), iArr);
            }
        }
        this.K0 = true;
        O0.setTint(-1);
    }

    public static void V(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean t(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean u(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(boolean z6) {
        if (this.Y != z6) {
            boolean S = S();
            this.Y = z6;
            boolean S2 = S();
            if (S != S2) {
                if (S2) {
                    o(this.Z);
                } else {
                    V(this.Z);
                }
                invalidateSelf();
                v();
            }
        }
    }

    @Deprecated
    public final void B(float f7) {
        if (this.H != f7) {
            this.H = f7;
            i iVar = this.f4720f.f4740a;
            iVar.getClass();
            i.a aVar = new i.a(iVar);
            aVar.e(f7);
            aVar.f(f7);
            aVar.d(f7);
            aVar.c(f7);
            setShapeAppearanceModel(new i(aVar));
        }
    }

    public final void C(Drawable drawable) {
        Drawable drawable2 = this.N;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof b) {
            drawable2 = ((b) drawable2).b();
        }
        if (drawable2 != drawable) {
            float q6 = q();
            this.N = drawable != null ? drawable.mutate() : null;
            float q7 = q();
            V(drawable2);
            if (T()) {
                o(this.N);
            }
            invalidateSelf();
            if (q6 != q7) {
                v();
            }
        }
    }

    public final void D(float f7) {
        if (this.P != f7) {
            float q6 = q();
            this.P = f7;
            float q7 = q();
            invalidateSelf();
            if (q6 != q7) {
                v();
            }
        }
    }

    public final void E(ColorStateList colorStateList) {
        this.Q = true;
        if (this.O != colorStateList) {
            this.O = colorStateList;
            if (T()) {
                a.b.h(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void F(boolean z6) {
        if (this.M != z6) {
            boolean T = T();
            this.M = z6;
            boolean T2 = T();
            if (T != T2) {
                if (T2) {
                    o(this.N);
                } else {
                    V(this.N);
                }
                invalidateSelf();
                v();
            }
        }
    }

    public final void G(ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (this.M0) {
                f.b bVar = this.f4720f;
                if (bVar.f4743d != colorStateList) {
                    bVar.f4743d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void H(float f7) {
        if (this.J != f7) {
            this.J = f7;
            this.f3020m0.setStrokeWidth(f7);
            if (this.M0) {
                this.f4720f.f4749k = f7;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void I(Drawable drawable) {
        Drawable drawable2 = this.S;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof b) {
            drawable2 = ((b) drawable2).b();
        }
        if (drawable2 != drawable) {
            float r6 = r();
            this.S = drawable != null ? drawable.mutate() : null;
            ColorStateList colorStateList = this.K;
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.T = new RippleDrawable(colorStateList, this.S, O0);
            float r7 = r();
            V(drawable2);
            if (U()) {
                o(this.S);
            }
            invalidateSelf();
            if (r6 != r7) {
                v();
            }
        }
    }

    public final void J(float f7) {
        if (this.f3017j0 != f7) {
            this.f3017j0 = f7;
            invalidateSelf();
            if (U()) {
                v();
            }
        }
    }

    public final void K(float f7) {
        if (this.V != f7) {
            this.V = f7;
            invalidateSelf();
            if (U()) {
                v();
            }
        }
    }

    public final void L(float f7) {
        if (this.f3016i0 != f7) {
            this.f3016i0 = f7;
            invalidateSelf();
            if (U()) {
                v();
            }
        }
    }

    public final void M(ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            if (U()) {
                a.b.h(this.S, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void N(boolean z6) {
        if (this.R != z6) {
            boolean U = U();
            this.R = z6;
            boolean U2 = U();
            if (U != U2) {
                if (U2) {
                    o(this.S);
                } else {
                    V(this.S);
                }
                invalidateSelf();
                v();
            }
        }
    }

    public final void O(float f7) {
        if (this.f3013f0 != f7) {
            float q6 = q();
            this.f3013f0 = f7;
            float q7 = q();
            invalidateSelf();
            if (q6 != q7) {
                v();
            }
        }
    }

    public final void P(float f7) {
        if (this.f3012e0 != f7) {
            float q6 = q();
            this.f3012e0 = f7;
            float q7 = q();
            invalidateSelf();
            if (q6 != q7) {
                v();
            }
        }
    }

    public final void Q(ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (!this.G0) {
                colorStateList = null;
            } else if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.H0 = colorStateList;
            onStateChange(getState());
        }
    }

    public final void R(d dVar) {
        l lVar = this.f3025r0;
        Context context = this.f3019l0;
        if (lVar.f3628f != dVar) {
            lVar.f3628f = dVar;
            if (dVar != null) {
                dVar.f(context, lVar.f3624a, lVar.f3625b);
                l.b bVar = lVar.e.get();
                if (bVar != null) {
                    lVar.f3624a.drawableState = bVar.getState();
                }
                dVar.e(context, lVar.f3624a, lVar.f3625b);
                lVar.f3627d = true;
            }
            l.b bVar2 = lVar.e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public final boolean S() {
        return this.Y && this.Z != null && this.f3032y0;
    }

    public final boolean T() {
        return this.M && this.N != null;
    }

    public final boolean U() {
        return this.R && this.S != null;
    }

    @Override // d4.l.b
    public final void a() {
        v();
        invalidateSelf();
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float f7;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i7 = this.A0) == 0) {
            return;
        }
        int saveLayerAlpha = i7 < 255 ? canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i7) : 0;
        if (!this.M0) {
            this.f3020m0.setColor(this.f3026s0);
            this.f3020m0.setStyle(Paint.Style.FILL);
            this.f3022o0.set(bounds);
            canvas.drawRoundRect(this.f3022o0, s(), s(), this.f3020m0);
        }
        if (!this.M0) {
            this.f3020m0.setColor(this.f3027t0);
            this.f3020m0.setStyle(Paint.Style.FILL);
            Paint paint = this.f3020m0;
            ColorFilter colorFilter = this.B0;
            if (colorFilter == null) {
                colorFilter = this.C0;
            }
            paint.setColorFilter(colorFilter);
            this.f3022o0.set(bounds);
            canvas.drawRoundRect(this.f3022o0, s(), s(), this.f3020m0);
        }
        if (this.M0) {
            super.draw(canvas);
        }
        if (this.J > 0.0f && !this.M0) {
            this.f3020m0.setColor(this.f3029v0);
            this.f3020m0.setStyle(Paint.Style.STROKE);
            if (!this.M0) {
                Paint paint2 = this.f3020m0;
                ColorFilter colorFilter2 = this.B0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.C0;
                }
                paint2.setColorFilter(colorFilter2);
            }
            RectF rectF = this.f3022o0;
            float f8 = this.J / 2.0f;
            rectF.set(bounds.left + f8, bounds.top + f8, bounds.right - f8, bounds.bottom - f8);
            float f9 = this.H - (this.J / 2.0f);
            canvas.drawRoundRect(this.f3022o0, f9, f9, this.f3020m0);
        }
        this.f3020m0.setColor(this.f3030w0);
        this.f3020m0.setStyle(Paint.Style.FILL);
        this.f3022o0.set(bounds);
        if (this.M0) {
            RectF rectF2 = new RectF(bounds);
            Path path = this.f3024q0;
            j jVar = this.f4735w;
            f.b bVar = this.f4720f;
            jVar.a(bVar.f4740a, bVar.f4748j, rectF2, this.f4734v, path);
            f(canvas, this.f3020m0, this.f3024q0, this.f4720f.f4740a, h());
        } else {
            canvas.drawRoundRect(this.f3022o0, s(), s(), this.f3020m0);
        }
        if (T()) {
            p(bounds, this.f3022o0);
            RectF rectF3 = this.f3022o0;
            float f10 = rectF3.left;
            float f11 = rectF3.top;
            canvas.translate(f10, f11);
            this.N.setBounds(0, 0, (int) this.f3022o0.width(), (int) this.f3022o0.height());
            this.N.draw(canvas);
            canvas.translate(-f10, -f11);
        }
        if (S()) {
            p(bounds, this.f3022o0);
            RectF rectF4 = this.f3022o0;
            float f12 = rectF4.left;
            float f13 = rectF4.top;
            canvas.translate(f12, f13);
            this.Z.setBounds(0, 0, (int) this.f3022o0.width(), (int) this.f3022o0.height());
            this.Z.draw(canvas);
            canvas.translate(-f12, -f13);
        }
        if (!this.K0 || this.L == null) {
            i8 = saveLayerAlpha;
            i9 = 0;
            i10 = 255;
        } else {
            PointF pointF = this.f3023p0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            if (this.L != null) {
                float q6 = q() + this.f3011d0 + this.f3014g0;
                if (a.c.a(this) == 0) {
                    pointF.x = bounds.left + q6;
                    align = Paint.Align.LEFT;
                } else {
                    pointF.x = bounds.right - q6;
                    align = Paint.Align.RIGHT;
                }
                this.f3025r0.f3624a.getFontMetrics(this.f3021n0);
                Paint.FontMetrics fontMetrics = this.f3021n0;
                pointF.y = bounds.centerY() - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            RectF rectF5 = this.f3022o0;
            rectF5.setEmpty();
            if (this.L != null) {
                float q7 = q() + this.f3011d0 + this.f3014g0;
                float r6 = r() + this.f3018k0 + this.f3015h0;
                if (a.c.a(this) == 0) {
                    rectF5.left = bounds.left + q7;
                    f7 = bounds.right - r6;
                } else {
                    rectF5.left = bounds.left + r6;
                    f7 = bounds.right - q7;
                }
                rectF5.right = f7;
                rectF5.top = bounds.top;
                rectF5.bottom = bounds.bottom;
            }
            l lVar = this.f3025r0;
            if (lVar.f3628f != null) {
                lVar.f3624a.drawableState = getState();
                l lVar2 = this.f3025r0;
                lVar2.f3628f.e(this.f3019l0, lVar2.f3624a, lVar2.f3625b);
            }
            this.f3025r0.f3624a.setTextAlign(align);
            boolean z6 = Math.round(this.f3025r0.a(this.L.toString())) > Math.round(this.f3022o0.width());
            if (z6) {
                i11 = canvas.save();
                canvas.clipRect(this.f3022o0);
            } else {
                i11 = 0;
            }
            CharSequence charSequence = this.L;
            if (z6 && this.J0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f3025r0.f3624a, this.f3022o0.width(), this.J0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF2 = this.f3023p0;
            i8 = saveLayerAlpha;
            i9 = 0;
            i10 = 255;
            canvas.drawText(charSequence2, 0, length, pointF2.x, pointF2.y, this.f3025r0.f3624a);
            if (z6) {
                canvas.restoreToCount(i11);
            }
        }
        if (U()) {
            RectF rectF6 = this.f3022o0;
            rectF6.setEmpty();
            if (U()) {
                float f14 = this.f3018k0 + this.f3017j0;
                if (a.c.a(this) == 0) {
                    float f15 = bounds.right - f14;
                    rectF6.right = f15;
                    rectF6.left = f15 - this.V;
                } else {
                    float f16 = bounds.left + f14;
                    rectF6.left = f16;
                    rectF6.right = f16 + this.V;
                }
                float exactCenterY = bounds.exactCenterY();
                float f17 = this.V;
                float f18 = exactCenterY - (f17 / 2.0f);
                rectF6.top = f18;
                rectF6.bottom = f18 + f17;
            }
            RectF rectF7 = this.f3022o0;
            float f19 = rectF7.left;
            float f20 = rectF7.top;
            canvas.translate(f19, f20);
            this.S.setBounds(i9, i9, (int) this.f3022o0.width(), (int) this.f3022o0.height());
            this.T.setBounds(this.S.getBounds());
            this.T.jumpToCurrentState();
            this.T.draw(canvas);
            canvas.translate(-f19, -f20);
        }
        if (this.A0 < i10) {
            canvas.restoreToCount(i8);
        }
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.A0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.B0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.G;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(r() + this.f3025r0.a(this.L.toString()) + q() + this.f3011d0 + this.f3014g0 + this.f3015h0 + this.f3018k0), this.L0);
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    @TargetApi(ErrorCode.FILE_NOT_FOUND_IO_CODE)
    public final void getOutline(Outline outline) {
        if (this.M0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.G, this.H);
        } else {
            outline.setRoundRect(bounds, this.H);
        }
        outline.setAlpha(this.A0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (t(this.E) || t(this.F) || t(this.I)) {
            return true;
        }
        if (this.G0 && t(this.H0)) {
            return true;
        }
        d dVar = this.f3025r0.f3628f;
        if ((dVar == null || (colorStateList = dVar.f4257j) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        return (this.Y && this.Z != null && this.X) || u(this.N) || u(this.Z) || t(this.D0);
    }

    public final void o(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        a.c.b(drawable, a.c.a(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.S) {
            if (drawable.isStateful()) {
                drawable.setState(this.F0);
            }
            a.b.h(drawable, this.U);
            return;
        }
        Drawable drawable2 = this.N;
        if (drawable == drawable2 && this.Q) {
            a.b.h(drawable2, this.O);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i7) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i7);
        if (T()) {
            onLayoutDirectionChanged |= a.c.b(this.N, i7);
        }
        if (S()) {
            onLayoutDirectionChanged |= a.c.b(this.Z, i7);
        }
        if (U()) {
            onLayoutDirectionChanged |= a.c.b(this.S, i7);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i7) {
        boolean onLevelChange = super.onLevelChange(i7);
        if (T()) {
            onLevelChange |= this.N.setLevel(i7);
        }
        if (S()) {
            onLevelChange |= this.Z.setLevel(i7);
        }
        if (U()) {
            onLevelChange |= this.S.setLevel(i7);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // k4.f, android.graphics.drawable.Drawable, d4.l.b
    public final boolean onStateChange(int[] iArr) {
        if (this.M0) {
            super.onStateChange(iArr);
        }
        return w(iArr, this.F0);
    }

    public final void p(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (T() || S()) {
            float f7 = this.f3011d0 + this.f3012e0;
            Drawable drawable = this.f3032y0 ? this.Z : this.N;
            float f8 = this.P;
            if (f8 <= 0.0f && drawable != null) {
                f8 = drawable.getIntrinsicWidth();
            }
            if (a.c.a(this) == 0) {
                float f9 = rect.left + f7;
                rectF.left = f9;
                rectF.right = f9 + f8;
            } else {
                float f10 = rect.right - f7;
                rectF.right = f10;
                rectF.left = f10 - f8;
            }
            Drawable drawable2 = this.f3032y0 ? this.Z : this.N;
            float f11 = this.P;
            if (f11 <= 0.0f && drawable2 != null) {
                float ceil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f3019l0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= ceil) {
                    ceil = drawable2.getIntrinsicHeight();
                }
                f11 = ceil;
            }
            float exactCenterY = rect.exactCenterY() - (f11 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f11;
        }
    }

    public final float q() {
        if (T() || S()) {
            float f7 = this.f3012e0;
            Drawable drawable = this.f3032y0 ? this.Z : this.N;
            float f8 = this.P;
            if (f8 <= 0.0f && drawable != null) {
                f8 = drawable.getIntrinsicWidth();
            }
            return f8 + f7 + this.f3013f0;
        }
        return 0.0f;
    }

    public final float r() {
        if (U()) {
            return this.f3016i0 + this.V + this.f3017j0;
        }
        return 0.0f;
    }

    public final float s() {
        return this.M0 ? this.f4720f.f4740a.e.a(h()) : this.H;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j5);
        }
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    public final void setAlpha(int i7) {
        if (this.A0 != i7) {
            this.A0 = i7;
            invalidateSelf();
        }
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.B0 != colorFilter) {
            this.B0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.D0 != colorStateList) {
            this.D0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.E0 != mode) {
            this.E0 = mode;
            ColorStateList colorStateList = this.D0;
            this.C0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z6, boolean z7) {
        boolean visible = super.setVisible(z6, z7);
        if (T()) {
            visible |= this.N.setVisible(z6, z7);
        }
        if (S()) {
            visible |= this.Z.setVisible(z6, z7);
        }
        if (U()) {
            visible |= this.S.setVisible(z6, z7);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v() {
        InterfaceC0033a interfaceC0033a = this.I0.get();
        if (interfaceC0033a != null) {
            interfaceC0033a.a();
        }
    }

    public final boolean w(int[] iArr, int[] iArr2) {
        boolean z6;
        boolean z7;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.E;
        int d7 = d(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f3026s0) : 0);
        boolean z8 = true;
        if (this.f3026s0 != d7) {
            this.f3026s0 = d7;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.F;
        int d8 = d(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f3027t0) : 0);
        if (this.f3027t0 != d8) {
            this.f3027t0 = d8;
            onStateChange = true;
        }
        int b2 = i1.a.b(d8, d7);
        if ((this.f3028u0 != b2) | (this.f4720f.f4742c == null)) {
            this.f3028u0 = b2;
            k(ColorStateList.valueOf(b2));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.I;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f3029v0) : 0;
        if (this.f3029v0 != colorForState) {
            this.f3029v0 = colorForState;
            onStateChange = true;
        }
        int colorForState2 = (this.H0 == null || !h4.a.a(iArr)) ? 0 : this.H0.getColorForState(iArr, this.f3030w0);
        if (this.f3030w0 != colorForState2) {
            this.f3030w0 = colorForState2;
            if (this.G0) {
                onStateChange = true;
            }
        }
        d dVar = this.f3025r0.f3628f;
        int colorForState3 = (dVar == null || (colorStateList = dVar.f4257j) == null) ? 0 : colorStateList.getColorForState(iArr, this.f3031x0);
        if (this.f3031x0 != colorForState3) {
            this.f3031x0 = colorForState3;
            onStateChange = true;
        }
        int[] state = getState();
        if (state != null) {
            for (int i7 : state) {
                if (i7 == 16842912) {
                    z6 = true;
                    break;
                }
            }
        }
        z6 = false;
        boolean z9 = z6 && this.X;
        if (this.f3032y0 == z9 || this.Z == null) {
            z7 = false;
        } else {
            float q6 = q();
            this.f3032y0 = z9;
            if (q6 != q()) {
                onStateChange = true;
                z7 = true;
            } else {
                z7 = false;
                onStateChange = true;
            }
        }
        ColorStateList colorStateList5 = this.D0;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.f3033z0) : 0;
        if (this.f3033z0 != colorForState4) {
            this.f3033z0 = colorForState4;
            ColorStateList colorStateList6 = this.D0;
            PorterDuff.Mode mode = this.E0;
            this.C0 = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            z8 = onStateChange;
        }
        if (u(this.N)) {
            z8 |= this.N.setState(iArr);
        }
        if (u(this.Z)) {
            z8 |= this.Z.setState(iArr);
        }
        if (u(this.S)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z8 |= this.S.setState(iArr3);
        }
        if (u(this.T)) {
            z8 |= this.T.setState(iArr2);
        }
        if (z8) {
            invalidateSelf();
        }
        if (z7) {
            v();
        }
        return z8;
    }

    public final void x(boolean z6) {
        if (this.X != z6) {
            this.X = z6;
            float q6 = q();
            if (!z6 && this.f3032y0) {
                this.f3032y0 = false;
            }
            float q7 = q();
            invalidateSelf();
            if (q6 != q7) {
                v();
            }
        }
    }

    public final void y(Drawable drawable) {
        if (this.Z != drawable) {
            float q6 = q();
            this.Z = drawable;
            float q7 = q();
            V(this.Z);
            o(this.Z);
            invalidateSelf();
            if (q6 != q7) {
                v();
            }
        }
    }

    public final void z(ColorStateList colorStateList) {
        if (this.f3008a0 != colorStateList) {
            this.f3008a0 = colorStateList;
            if (this.Y && this.Z != null && this.X) {
                a.b.h(this.Z, colorStateList);
            }
            onStateChange(getState());
        }
    }
}
