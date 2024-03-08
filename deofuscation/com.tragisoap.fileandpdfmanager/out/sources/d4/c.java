package d4;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.s0;
import c2.b;
import g4.a;
import g4.f;
import java.util.WeakHashMap;
import n1.e;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {
    public CharSequence A;
    public CharSequence B;
    public boolean C;
    public Bitmap E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int[] L;
    public boolean M;
    public final TextPaint N;
    public final TextPaint O;
    public TimeInterpolator P;
    public TimeInterpolator Q;
    public float R;
    public float S;
    public float T;
    public ColorStateList U;
    public float V;
    public float W;
    public float X;
    public StaticLayout Y;
    public float Z;

    /* renamed from: a */
    public final View f3568a;

    /* renamed from: a0 */
    public float f3569a0;

    /* renamed from: b */
    public float f3570b;

    /* renamed from: b0 */
    public float f3571b0;

    /* renamed from: c0 */
    public CharSequence f3573c0;

    /* renamed from: j */
    public ColorStateList f3582j;

    /* renamed from: k */
    public ColorStateList f3583k;

    /* renamed from: l */
    public float f3584l;
    public float m;

    /* renamed from: n */
    public float f3585n;

    /* renamed from: o */
    public float f3586o;

    /* renamed from: p */
    public float f3587p;

    /* renamed from: q */
    public float f3588q;

    /* renamed from: r */
    public Typeface f3589r;
    public Typeface s;

    /* renamed from: t */
    public Typeface f3590t;

    /* renamed from: u */
    public Typeface f3591u;

    /* renamed from: v */
    public Typeface f3592v;

    /* renamed from: w */
    public Typeface f3593w;

    /* renamed from: x */
    public Typeface f3594x;

    /* renamed from: y */
    public a f3595y;

    /* renamed from: f */
    public int f3577f = 16;

    /* renamed from: g */
    public int f3579g = 16;

    /* renamed from: h */
    public float f3580h = 15.0f;

    /* renamed from: i */
    public float f3581i = 15.0f;

    /* renamed from: z */
    public TextUtils.TruncateAt f3596z = TextUtils.TruncateAt.END;
    public boolean D = true;

    /* renamed from: d0 */
    public int f3575d0 = 1;

    /* renamed from: e0 */
    public float f3576e0 = 1.0f;

    /* renamed from: f0 */
    public int f3578f0 = 1;

    /* renamed from: d */
    public final Rect f3574d = new Rect();

    /* renamed from: c */
    public final Rect f3572c = new Rect();
    public final RectF e = new RectF();

    public c(View view) {
        this.f3568a = view;
        TextPaint textPaint = new TextPaint(129);
        this.N = textPaint;
        this.O = new TextPaint(textPaint);
        g(view.getContext().getResources().getConfiguration());
    }

    public static int a(int i7, int i8, float f7) {
        float f8 = 1.0f - f7;
        return Color.argb(Math.round((((float) Color.alpha(i8)) * f7) + (((float) Color.alpha(i7)) * f8)), Math.round((((float) Color.red(i8)) * f7) + (((float) Color.red(i7)) * f8)), Math.round((((float) Color.green(i8)) * f7) + (((float) Color.green(i7)) * f8)), Math.round((((float) Color.blue(i8)) * f7) + (((float) Color.blue(i7)) * f8)));
    }

    public static float f(float f7, float f8, float f9, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f9 = timeInterpolator.getInterpolation(f9);
        }
        LinearInterpolator linearInterpolator = n3.a.f5161a;
        return s0.f(f8, f7, f9, f7);
    }

    public final boolean b(CharSequence charSequence) {
        View view = this.f3568a;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        boolean z6 = true;
        if (y.e.d(view) != 1) {
            z6 = false;
        }
        if (!this.D) {
            return z6;
        }
        return (z6 ? e.f5125d : e.f5124c).b(charSequence, charSequence.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0110, code lost:
        if (r4 != false) goto L_0x0112;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(float r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.c.c(float, boolean):void");
    }

    public final float d() {
        TextPaint textPaint = this.O;
        textPaint.setTextSize(this.f3581i);
        textPaint.setTypeface(this.f3589r);
        textPaint.setLetterSpacing(this.V);
        return -this.O.ascent();
    }

    public final int e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.L;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void g(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f3590t;
            if (typeface != null) {
                this.s = f.a(configuration, typeface);
            }
            Typeface typeface2 = this.f3593w;
            if (typeface2 != null) {
                this.f3592v = f.a(configuration, typeface2);
            }
            Typeface typeface3 = this.s;
            if (typeface3 == null) {
                typeface3 = this.f3590t;
            }
            this.f3589r = typeface3;
            Typeface typeface4 = this.f3592v;
            if (typeface4 == null) {
                typeface4 = this.f3593w;
            }
            this.f3591u = typeface4;
            h(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(boolean r14) {
        /*
            Method dump skipped, instructions count: 559
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.c.h(boolean):void");
    }

    public final void i(ColorStateList colorStateList) {
        if (this.f3583k != colorStateList || this.f3582j != colorStateList) {
            this.f3583k = colorStateList;
            this.f3582j = colorStateList;
            h(false);
        }
    }

    public final boolean j(Typeface typeface) {
        a aVar = this.f3595y;
        if (aVar != null) {
            aVar.f4248h = true;
        }
        if (this.f3590t == typeface) {
            return false;
        }
        this.f3590t = typeface;
        Typeface a7 = f.a(this.f3568a.getContext().getResources().getConfiguration(), typeface);
        this.s = a7;
        if (a7 == null) {
            a7 = this.f3590t;
        }
        this.f3589r = a7;
        return true;
    }

    public final void k(float f7) {
        int i7;
        TextPaint textPaint;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        } else if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        if (f7 != this.f3570b) {
            this.f3570b = f7;
            this.e.left = f((float) this.f3572c.left, (float) this.f3574d.left, f7, this.P);
            this.e.top = f(this.f3584l, this.m, f7, this.P);
            this.e.right = f((float) this.f3572c.right, (float) this.f3574d.right, f7, this.P);
            this.e.bottom = f((float) this.f3572c.bottom, (float) this.f3574d.bottom, f7, this.P);
            this.f3587p = f(this.f3585n, this.f3586o, f7, this.P);
            this.f3588q = f(this.f3584l, this.m, f7, this.P);
            l(f7);
            b bVar = n3.a.f5162b;
            this.f3569a0 = 1.0f - f(0.0f, 1.0f, 1.0f - f7, bVar);
            View view = this.f3568a;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.k(view);
            this.f3571b0 = f(1.0f, 0.0f, f7, bVar);
            y.d.k(this.f3568a);
            ColorStateList colorStateList = this.f3583k;
            ColorStateList colorStateList2 = this.f3582j;
            if (colorStateList != colorStateList2) {
                textPaint = this.N;
                i7 = a(e(colorStateList2), e(this.f3583k), f7);
            } else {
                textPaint = this.N;
                i7 = e(colorStateList);
            }
            textPaint.setColor(i7);
            float f8 = this.V;
            float f9 = this.W;
            if (f8 != f9) {
                this.N.setLetterSpacing(f(f9, f8, f7, bVar));
            } else {
                this.N.setLetterSpacing(f8);
            }
            this.H = f(0.0f, this.R, f7, null);
            this.I = f(0.0f, this.S, f7, null);
            this.J = f(0.0f, this.T, f7, null);
            int a7 = a(e(null), e(this.U), f7);
            this.K = a7;
            this.N.setShadowLayer(this.H, this.I, this.J, a7);
            y.d.k(this.f3568a);
        }
    }

    public final void l(float f7) {
        c(f7, false);
        View view = this.f3568a;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.k(view);
    }

    public final void m(Typeface typeface) {
        boolean z6;
        boolean j7 = j(typeface);
        if (this.f3593w != typeface) {
            this.f3593w = typeface;
            Typeface a7 = f.a(this.f3568a.getContext().getResources().getConfiguration(), typeface);
            this.f3592v = a7;
            if (a7 == null) {
                a7 = this.f3593w;
            }
            this.f3591u = a7;
            z6 = true;
        } else {
            z6 = false;
        }
        if (j7 || z6) {
            h(false);
        }
    }
}
