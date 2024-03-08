package g4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import androidx.activity.h;
import androidx.activity.result.c;
import h1.f;
import l0.z;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a */
    public final ColorStateList f4249a;

    /* renamed from: b */
    public final String f4250b;

    /* renamed from: c */
    public final int f4251c;

    /* renamed from: d */
    public final int f4252d;
    public final float e;

    /* renamed from: f */
    public final float f4253f;

    /* renamed from: g */
    public final float f4254g;

    /* renamed from: h */
    public final boolean f4255h;

    /* renamed from: i */
    public final float f4256i;

    /* renamed from: j */
    public ColorStateList f4257j;

    /* renamed from: k */
    public float f4258k;

    /* renamed from: l */
    public final int f4259l;
    public boolean m = false;

    /* renamed from: n */
    public Typeface f4260n;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends f.e {

        /* renamed from: a */
        public final /* synthetic */ c f4261a;

        public a(c cVar) {
            d.this = r1;
            this.f4261a = cVar;
        }

        @Override // h1.f.e
        public final void c(int i7) {
            d.this.m = true;
            this.f4261a.l(i7);
        }

        @Override // h1.f.e
        public final void d(Typeface typeface) {
            d dVar = d.this;
            dVar.f4260n = Typeface.create(typeface, dVar.f4251c);
            d dVar2 = d.this;
            dVar2.m = true;
            this.f4261a.m(dVar2.f4260n, false);
        }
    }

    public d(Context context, int i7) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i7, z.f4938z);
        this.f4258k = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f4257j = c.a(context, obtainStyledAttributes, 3);
        c.a(context, obtainStyledAttributes, 4);
        c.a(context, obtainStyledAttributes, 5);
        this.f4251c = obtainStyledAttributes.getInt(2, 0);
        this.f4252d = obtainStyledAttributes.getInt(1, 1);
        int i8 = 12;
        i8 = 10;
        if (!obtainStyledAttributes.hasValue(12)) {
        }
        this.f4259l = obtainStyledAttributes.getResourceId(i8, 0);
        this.f4250b = obtainStyledAttributes.getString(i8);
        obtainStyledAttributes.getBoolean(14, false);
        this.f4249a = c.a(context, obtainStyledAttributes, 6);
        this.e = obtainStyledAttributes.getFloat(7, 0.0f);
        this.f4253f = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f4254g = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i7, z.f4931r);
        this.f4255h = obtainStyledAttributes2.hasValue(0);
        this.f4256i = obtainStyledAttributes2.getFloat(0, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        if (this.f4260n == null && (str = this.f4250b) != null) {
            this.f4260n = Typeface.create(str, this.f4251c);
        }
        if (this.f4260n == null) {
            int i7 = this.f4252d;
            this.f4260n = i7 != 1 ? i7 != 2 ? i7 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.f4260n = Typeface.create(this.f4260n, this.f4251c);
        }
    }

    public final Typeface b(Context context) {
        if (this.m) {
            return this.f4260n;
        }
        if (!context.isRestricted()) {
            try {
                int i7 = this.f4259l;
                ThreadLocal<TypedValue> threadLocal = f.f4353a;
                Typeface a7 = context.isRestricted() ? null : f.a(context, i7, new TypedValue(), 0, null, false, false);
                this.f4260n = a7;
                if (a7 != null) {
                    this.f4260n = Typeface.create(a7, this.f4251c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                StringBuilder d7 = h.d("Error loading font ");
                d7.append(this.f4250b);
                Log.d("TextAppearance", d7.toString(), e);
            }
        }
        a();
        this.m = true;
        return this.f4260n;
    }

    public final void c(Context context, c cVar) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i7 = this.f4259l;
        if (i7 == 0) {
            this.m = true;
        }
        if (this.m) {
            cVar.m(this.f4260n, true);
            return;
        }
        try {
            a aVar = new a(cVar);
            ThreadLocal<TypedValue> threadLocal = f.f4353a;
            if (context.isRestricted()) {
                aVar.a(-4);
            } else {
                f.a(context, i7, new TypedValue(), 0, aVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            cVar.l(1);
        } catch (Exception e) {
            StringBuilder d7 = h.d("Error loading font ");
            d7.append(this.f4250b);
            Log.d("TextAppearance", d7.toString(), e);
            this.m = true;
            cVar.l(-3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.content.Context r8) {
        /*
            r7 = this;
            int r1 = r7.f4259l
            if (r1 == 0) goto L_0x001c
            java.lang.ThreadLocal<android.util.TypedValue> r7 = h1.f.f4353a
            boolean r7 = r8.isRestricted()
            if (r7 == 0) goto L_0x000d
            goto L_0x001c
        L_0x000d:
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1
            r0 = r8
            android.graphics.Typeface r7 = h1.f.a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x001d
        L_0x001c:
            r7 = 0
        L_0x001d:
            if (r7 == 0) goto L_0x0021
            r7 = 1
            goto L_0x0022
        L_0x0021:
            r7 = 0
        L_0x0022:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.d.d(android.content.Context):boolean");
    }

    public final void e(Context context, TextPaint textPaint, c cVar) {
        f(context, textPaint, cVar);
        ColorStateList colorStateList = this.f4257j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f7 = this.f4254g;
        float f8 = this.e;
        float f9 = this.f4253f;
        ColorStateList colorStateList2 = this.f4249a;
        textPaint.setShadowLayer(f7, f8, f9, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(Context context, TextPaint textPaint, c cVar) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.f4260n);
        c(context, new e(this, context, textPaint, cVar));
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface a7 = f.a(context.getResources().getConfiguration(), typeface);
        if (a7 != null) {
            typeface = a7;
        }
        textPaint.setTypeface(typeface);
        int i7 = this.f4251c & (~typeface.getStyle());
        textPaint.setFakeBoldText((i7 & 1) != 0);
        textPaint.setTextSkewX((i7 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f4258k);
        if (this.f4255h) {
            textPaint.setLetterSpacing(this.f4256i);
        }
    }
}
