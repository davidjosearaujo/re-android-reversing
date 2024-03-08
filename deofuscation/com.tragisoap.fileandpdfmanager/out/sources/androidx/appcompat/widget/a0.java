package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import h1.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
import t1.j;
import t1.l;
import t1.m;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a0 {

    /* renamed from: a */
    public final TextView f815a;

    /* renamed from: b */
    public y0 f816b;

    /* renamed from: c */
    public y0 f817c;

    /* renamed from: d */
    public y0 f818d;
    public y0 e;

    /* renamed from: f */
    public y0 f819f;

    /* renamed from: g */
    public y0 f820g;

    /* renamed from: h */
    public y0 f821h;

    /* renamed from: i */
    public final d0 f822i;

    /* renamed from: j */
    public int f823j = 0;

    /* renamed from: k */
    public int f824k = -1;

    /* renamed from: l */
    public Typeface f825l;
    public boolean m;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends f.e {

        /* renamed from: a */
        public final /* synthetic */ int f826a;

        /* renamed from: b */
        public final /* synthetic */ int f827b;

        /* renamed from: c */
        public final /* synthetic */ WeakReference f828c;

        public a(int i7, int i8, WeakReference weakReference) {
            a0.this = r1;
            this.f826a = i7;
            this.f827b = i8;
            this.f828c = weakReference;
        }

        @Override // h1.f.e
        public final void c(int i7) {
        }

        @Override // h1.f.e
        public final void d(Typeface typeface) {
            int i7 = this.f826a;
            if (i7 != -1) {
                typeface = e.a(typeface, i7, (this.f827b & 2) != 0);
            }
            a0 a0Var = a0.this;
            WeakReference weakReference = this.f828c;
            if (a0Var.m) {
                a0Var.f825l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView != null) {
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    if (y.g.b(textView)) {
                        textView.post(new b0(textView, typeface, a0Var.f823j));
                    } else {
                        textView.setTypeface(typeface, a0Var.f823j);
                    }
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i7, int i8, int i9, int i10) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
        }

        public static void c(TextView textView, int[] iArr, int i7) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e {
        public static Typeface a(Typeface typeface, int i7, boolean z6) {
            return Typeface.create(typeface, i7, z6);
        }
    }

    public a0(TextView textView) {
        this.f815a = textView;
        this.f822i = new d0(textView);
    }

    public static y0 c(Context context, j jVar, int i7) {
        ColorStateList h7;
        synchronized (jVar) {
            h7 = jVar.f941a.h(context, i7);
        }
        if (h7 == null) {
            return null;
        }
        y0 y0Var = new y0();
        y0Var.f1075d = true;
        y0Var.f1072a = h7;
        return y0Var;
    }

    public final void a(Drawable drawable, y0 y0Var) {
        if (drawable != null && y0Var != null) {
            j.e(drawable, y0Var, this.f815a.getDrawableState());
        }
    }

    public final void b() {
        if (!(this.f816b == null && this.f817c == null && this.f818d == null && this.e == null)) {
            Drawable[] compoundDrawables = this.f815a.getCompoundDrawables();
            a(compoundDrawables[0], this.f816b);
            a(compoundDrawables[1], this.f817c);
            a(compoundDrawables[2], this.f818d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f819f != null || this.f820g != null) {
            Drawable[] a7 = b.a(this.f815a);
            a(a7[0], this.f819f);
            a(a7[2], this.f820g);
        }
    }

    public final ColorStateList d() {
        y0 y0Var = this.f821h;
        if (y0Var != null) {
            return y0Var.f1072a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        y0 y0Var = this.f821h;
        if (y0Var != null) {
            return y0Var.f1073b;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public final void f(AttributeSet attributeSet, int i7) {
        String str;
        String str2;
        boolean z6;
        boolean z7;
        int i8;
        int i9;
        int i10;
        int resourceId;
        int i11;
        Context context = this.f815a.getContext();
        j a7 = j.a();
        int[] iArr = a0.e.D;
        a1 m = a1.m(context, attributeSet, iArr, i7);
        TextView textView = this.f815a;
        Context context2 = textView.getContext();
        TypedArray typedArray = m.f831b;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.m.d(textView, context2, iArr, attributeSet, typedArray, i7, 0);
        int i12 = m.i(0, -1);
        if (m.l(3)) {
            this.f816b = c(context, a7, m.i(3, 0));
        }
        if (m.l(1)) {
            this.f817c = c(context, a7, m.i(1, 0));
        }
        if (m.l(4)) {
            this.f818d = c(context, a7, m.i(4, 0));
        }
        if (m.l(2)) {
            this.e = c(context, a7, m.i(2, 0));
        }
        if (m.l(5)) {
            this.f819f = c(context, a7, m.i(5, 0));
        }
        if (m.l(6)) {
            this.f820g = c(context, a7, m.i(6, 0));
        }
        m.n();
        boolean z8 = this.f815a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (i12 != -1) {
            a1 a1Var = new a1(context, context.obtainStyledAttributes(i12, a0.e.S));
            if (z8 || !a1Var.l(14)) {
                z7 = false;
                z6 = false;
            } else {
                z7 = a1Var.a(14, false);
                z6 = true;
            }
            j(context, a1Var);
            if (a1Var.l(15)) {
                str2 = a1Var.j(15);
                i11 = 13;
            } else {
                i11 = 13;
                str2 = null;
            }
            str = a1Var.l(i11) ? a1Var.j(i11) : null;
            a1Var.n();
        } else {
            z7 = false;
            z6 = false;
            str2 = null;
            str = null;
        }
        a1 a1Var2 = new a1(context, context.obtainStyledAttributes(attributeSet, a0.e.S, i7, 0));
        if (!z8 && a1Var2.l(14)) {
            z7 = a1Var2.a(14, false);
            z6 = true;
        }
        if (a1Var2.l(15)) {
            str2 = a1Var2.j(15);
        }
        if (a1Var2.l(13)) {
            str = a1Var2.j(13);
        }
        if (a1Var2.l(0) && a1Var2.d(0, -1) == 0) {
            this.f815a.setTextSize(0, 0.0f);
        }
        j(context, a1Var2);
        a1Var2.n();
        if (!z8 && z6) {
            this.f815a.setAllCaps(z7);
        }
        Typeface typeface = this.f825l;
        if (typeface != null) {
            if (this.f824k == -1) {
                this.f815a.setTypeface(typeface, this.f823j);
            } else {
                this.f815a.setTypeface(typeface);
            }
        }
        if (str != null) {
            d.d(this.f815a, str);
        }
        if (str2 != null) {
            c.b(this.f815a, c.a(str2));
        }
        d0 d0Var = this.f822i;
        Context context3 = d0Var.f890i;
        int[] iArr2 = a0.e.E;
        TypedArray obtainStyledAttributes = context3.obtainStyledAttributes(attributeSet, iArr2, i7, 0);
        TextView textView2 = d0Var.f889h;
        y.m.d(textView2, textView2.getContext(), iArr2, attributeSet, obtainStyledAttributes, i7, 0);
        if (obtainStyledAttributes.hasValue(5)) {
            d0Var.f883a = obtainStyledAttributes.getInt(5, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(4) ? obtainStyledAttributes.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(2) ? obtainStyledAttributes.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(1) ? obtainStyledAttributes.getDimension(1, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(3) && (resourceId = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            int length = obtainTypedArray.length();
            int[] iArr3 = new int[length];
            if (length > 0) {
                for (int i13 = 0; i13 < length; i13++) {
                    iArr3[i13] = obtainTypedArray.getDimensionPixelSize(i13, -1);
                }
                d0Var.f887f = d0.a(iArr3);
                d0Var.c();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!d0Var.d()) {
            d0Var.f883a = 0;
        } else if (d0Var.f883a == 1) {
            if (!d0Var.f888g) {
                DisplayMetrics displayMetrics = d0Var.f890i.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i10 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i10 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i10, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                d0Var.e(dimension2, dimension3, dimension);
            }
            d0Var.b();
        }
        Method method = g1.f908a;
        d0 d0Var2 = this.f822i;
        if (d0Var2.f883a != 0) {
            int[] iArr4 = d0Var2.f887f;
            if (iArr4.length > 0) {
                if (((float) d.a(this.f815a)) != -1.0f) {
                    d.b(this.f815a, Math.round(this.f822i.f886d), Math.round(this.f822i.e), Math.round(this.f822i.f885c), 0);
                } else {
                    d.c(this.f815a, iArr4, 0);
                }
            }
        }
        a1 a1Var3 = new a1(context, context.obtainStyledAttributes(attributeSet, a0.e.E));
        int i14 = a1Var3.i(8, -1);
        Drawable b2 = i14 != -1 ? a7.b(context, i14) : null;
        int i15 = a1Var3.i(13, -1);
        Drawable b7 = i15 != -1 ? a7.b(context, i15) : null;
        int i16 = a1Var3.i(9, -1);
        Drawable b8 = i16 != -1 ? a7.b(context, i16) : null;
        int i17 = a1Var3.i(6, -1);
        Drawable b9 = i17 != -1 ? a7.b(context, i17) : null;
        int i18 = a1Var3.i(10, -1);
        Drawable b10 = i18 != -1 ? a7.b(context, i18) : null;
        int i19 = a1Var3.i(7, -1);
        Drawable b11 = i19 != -1 ? a7.b(context, i19) : null;
        if (b10 != null || b11 != null) {
            Drawable[] a8 = b.a(this.f815a);
            TextView textView3 = this.f815a;
            if (b10 == null) {
                b10 = a8[0];
            }
            if (b7 == null) {
                b7 = a8[1];
            }
            if (b11 == null) {
                b11 = a8[2];
            }
            if (b9 == null) {
                b9 = a8[3];
            }
            b.b(textView3, b10, b7, b11, b9);
        } else if (!(b2 == null && b7 == null && b8 == null && b9 == null)) {
            Drawable[] a9 = b.a(this.f815a);
            Drawable drawable = a9[0];
            if (drawable == null && a9[2] == null) {
                Drawable[] compoundDrawables = this.f815a.getCompoundDrawables();
                TextView textView4 = this.f815a;
                if (b2 == null) {
                    b2 = compoundDrawables[0];
                }
                if (b7 == null) {
                    b7 = compoundDrawables[1];
                }
                if (b8 == null) {
                    b8 = compoundDrawables[2];
                }
                if (b9 == null) {
                    b9 = compoundDrawables[3];
                }
                textView4.setCompoundDrawablesWithIntrinsicBounds(b2, b7, b8, b9);
            } else {
                TextView textView5 = this.f815a;
                if (b7 == null) {
                    b7 = a9[1];
                }
                Drawable drawable2 = a9[2];
                if (b9 == null) {
                    b9 = a9[3];
                }
                b.b(textView5, drawable, b7, drawable2, b9);
            }
        }
        if (a1Var3.l(11)) {
            ColorStateList b12 = a1Var3.b(11);
            TextView textView6 = this.f815a;
            textView6.getClass();
            l.f(textView6, b12);
        }
        if (a1Var3.l(12)) {
            i8 = -1;
            PorterDuff.Mode b13 = h0.b(a1Var3.h(12, -1), null);
            TextView textView7 = this.f815a;
            textView7.getClass();
            l.g(textView7, b13);
        } else {
            i8 = -1;
        }
        int d7 = a1Var3.d(15, i8);
        int d8 = a1Var3.d(18, i8);
        int d9 = a1Var3.d(19, i8);
        a1Var3.n();
        if (d7 != i8) {
            TextView textView8 = this.f815a;
            a0.e.h(d7);
            m.d(textView8, d7);
        }
        if (d8 != i8) {
            TextView textView9 = this.f815a;
            a0.e.h(d8);
            Paint.FontMetricsInt fontMetricsInt = textView9.getPaint().getFontMetricsInt();
            int i20 = j.a(textView9) ? fontMetricsInt.bottom : fontMetricsInt.descent;
            if (d8 > Math.abs(i20)) {
                textView9.setPadding(textView9.getPaddingLeft(), textView9.getPaddingTop(), textView9.getPaddingRight(), d8 - i20);
            }
            i9 = -1;
        } else {
            i9 = i8;
        }
        if (d9 != i9) {
            TextView textView10 = this.f815a;
            a0.e.h(d9);
            int fontMetricsInt2 = textView10.getPaint().getFontMetricsInt(null);
            if (d9 != fontMetricsInt2) {
                textView10.setLineSpacing((float) (d9 - fontMetricsInt2), 1.0f);
            }
        }
    }

    public final void g(Context context, int i7) {
        String j7;
        a1 a1Var = new a1(context, context.obtainStyledAttributes(i7, a0.e.S));
        if (a1Var.l(14)) {
            this.f815a.setAllCaps(a1Var.a(14, false));
        }
        if (a1Var.l(0) && a1Var.d(0, -1) == 0) {
            this.f815a.setTextSize(0, 0.0f);
        }
        j(context, a1Var);
        if (a1Var.l(13) && (j7 = a1Var.j(13)) != null) {
            d.d(this.f815a, j7);
        }
        a1Var.n();
        Typeface typeface = this.f825l;
        if (typeface != null) {
            this.f815a.setTypeface(typeface, this.f823j);
        }
    }

    public final void h(ColorStateList colorStateList) {
        if (this.f821h == null) {
            this.f821h = new y0();
        }
        y0 y0Var = this.f821h;
        y0Var.f1072a = colorStateList;
        y0Var.f1075d = colorStateList != null;
        this.f816b = y0Var;
        this.f817c = y0Var;
        this.f818d = y0Var;
        this.e = y0Var;
        this.f819f = y0Var;
        this.f820g = y0Var;
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.f821h == null) {
            this.f821h = new y0();
        }
        y0 y0Var = this.f821h;
        y0Var.f1073b = mode;
        y0Var.f1074c = mode != null;
        this.f816b = y0Var;
        this.f817c = y0Var;
        this.f818d = y0Var;
        this.e = y0Var;
        this.f819f = y0Var;
        this.f820g = y0Var;
    }

    public final void j(Context context, a1 a1Var) {
        String j7;
        Typeface typeface;
        Typeface typeface2;
        this.f823j = a1Var.h(2, this.f823j);
        int h7 = a1Var.h(11, -1);
        this.f824k = h7;
        boolean z6 = false;
        if (h7 != -1) {
            this.f823j = (this.f823j & 2) | 0;
        }
        int i7 = 10;
        if (a1Var.l(10) || a1Var.l(12)) {
            this.f825l = null;
            if (a1Var.l(12)) {
                i7 = 12;
            }
            int i8 = this.f824k;
            int i9 = this.f823j;
            if (!context.isRestricted()) {
                try {
                    Typeface g2 = a1Var.g(i7, this.f823j, new a(i8, i9, new WeakReference(this.f815a)));
                    if (g2 != null) {
                        if (this.f824k != -1) {
                            g2 = e.a(Typeface.create(g2, 0), this.f824k, (this.f823j & 2) != 0);
                        }
                        this.f825l = g2;
                    }
                    this.m = this.f825l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f825l == null && (j7 = a1Var.j(i7)) != null) {
                if (this.f824k != -1) {
                    Typeface create = Typeface.create(j7, 0);
                    int i10 = this.f824k;
                    if ((this.f823j & 2) != 0) {
                        z6 = true;
                    }
                    typeface = e.a(create, i10, z6);
                } else {
                    typeface = Typeface.create(j7, this.f823j);
                }
                this.f825l = typeface;
            }
        } else if (a1Var.l(1)) {
            this.m = false;
            int h8 = a1Var.h(1, 1);
            if (h8 == 1) {
                typeface2 = Typeface.SANS_SERIF;
            } else if (h8 == 2) {
                typeface2 = Typeface.SERIF;
            } else if (h8 == 3) {
                typeface2 = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.f825l = typeface2;
        }
    }
}
