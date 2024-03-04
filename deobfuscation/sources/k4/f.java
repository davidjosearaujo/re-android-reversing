package k4;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import k4.j;
import k4.l;
import linc.com.amplituda.ErrorCode;

/* loaded from: classes.dex */
public class f extends Drawable implements m {
    public static final String C = f.class.getSimpleName();
    public static final Paint D;
    public final RectF A;
    public boolean B;

    /* renamed from: f */
    public b f4720f;

    /* renamed from: g */
    public final l.f[] f4721g;

    /* renamed from: h */
    public final l.f[] f4722h;

    /* renamed from: i */
    public final BitSet f4723i;

    /* renamed from: j */
    public boolean f4724j;

    /* renamed from: k */
    public final Matrix f4725k;

    /* renamed from: l */
    public final Path f4726l;
    public final Path m;

    /* renamed from: n */
    public final RectF f4727n;

    /* renamed from: o */
    public final RectF f4728o;

    /* renamed from: p */
    public final Region f4729p;

    /* renamed from: q */
    public final Region f4730q;

    /* renamed from: r */
    public i f4731r;
    public final Paint s;

    /* renamed from: t */
    public final Paint f4732t;

    /* renamed from: u */
    public final j4.a f4733u;

    /* renamed from: v */
    public final a f4734v;

    /* renamed from: w */
    public final j f4735w;

    /* renamed from: x */
    public PorterDuffColorFilter f4736x;

    /* renamed from: y */
    public PorterDuffColorFilter f4737y;

    /* renamed from: z */
    public int f4738z;

    /* loaded from: classes.dex */
    public class a {
        public a() {
            f.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a */
        public i f4740a;

        /* renamed from: b */
        public a4.a f4741b;

        /* renamed from: c */
        public ColorStateList f4742c;

        /* renamed from: d */
        public ColorStateList f4743d;
        public ColorStateList e;

        /* renamed from: f */
        public ColorStateList f4744f;

        /* renamed from: g */
        public PorterDuff.Mode f4745g;

        /* renamed from: h */
        public Rect f4746h;

        /* renamed from: i */
        public float f4747i;

        /* renamed from: j */
        public float f4748j;

        /* renamed from: k */
        public float f4749k;

        /* renamed from: l */
        public int f4750l;
        public float m;

        /* renamed from: n */
        public float f4751n;

        /* renamed from: o */
        public float f4752o;

        /* renamed from: p */
        public int f4753p;

        /* renamed from: q */
        public int f4754q;

        /* renamed from: r */
        public int f4755r;
        public int s;

        /* renamed from: t */
        public boolean f4756t;

        /* renamed from: u */
        public Paint.Style f4757u;

        public b(b bVar) {
            this.f4742c = null;
            this.f4743d = null;
            this.e = null;
            this.f4744f = null;
            this.f4745g = PorterDuff.Mode.SRC_IN;
            this.f4746h = null;
            this.f4747i = 1.0f;
            this.f4748j = 1.0f;
            this.f4750l = 255;
            this.m = 0.0f;
            this.f4751n = 0.0f;
            this.f4752o = 0.0f;
            this.f4753p = 0;
            this.f4754q = 0;
            this.f4755r = 0;
            this.s = 0;
            this.f4756t = false;
            this.f4757u = Paint.Style.FILL_AND_STROKE;
            this.f4740a = bVar.f4740a;
            this.f4741b = bVar.f4741b;
            this.f4749k = bVar.f4749k;
            this.f4742c = bVar.f4742c;
            this.f4743d = bVar.f4743d;
            this.f4745g = bVar.f4745g;
            this.f4744f = bVar.f4744f;
            this.f4750l = bVar.f4750l;
            this.f4747i = bVar.f4747i;
            this.f4755r = bVar.f4755r;
            this.f4753p = bVar.f4753p;
            this.f4756t = bVar.f4756t;
            this.f4748j = bVar.f4748j;
            this.m = bVar.m;
            this.f4751n = bVar.f4751n;
            this.f4752o = bVar.f4752o;
            this.f4754q = bVar.f4754q;
            this.s = bVar.s;
            this.e = bVar.e;
            this.f4757u = bVar.f4757u;
            if (bVar.f4746h != null) {
                this.f4746h = new Rect(bVar.f4746h);
            }
        }

        public b(i iVar) {
            this.f4742c = null;
            this.f4743d = null;
            this.e = null;
            this.f4744f = null;
            this.f4745g = PorterDuff.Mode.SRC_IN;
            this.f4746h = null;
            this.f4747i = 1.0f;
            this.f4748j = 1.0f;
            this.f4750l = 255;
            this.m = 0.0f;
            this.f4751n = 0.0f;
            this.f4752o = 0.0f;
            this.f4753p = 0;
            this.f4754q = 0;
            this.f4755r = 0;
            this.s = 0;
            this.f4756t = false;
            this.f4757u = Paint.Style.FILL_AND_STROKE;
            this.f4740a = iVar;
            this.f4741b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f(this);
            fVar.f4724j = true;
            return fVar;
        }
    }

    static {
        Paint paint = new Paint(1);
        D = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public f() {
        this(new i());
    }

    public f(Context context, AttributeSet attributeSet, int i7, int i8) {
        this(i.b(context, attributeSet, i7, i8).a());
    }

    public f(b bVar) {
        j jVar;
        this.f4721g = new l.f[4];
        this.f4722h = new l.f[4];
        this.f4723i = new BitSet(8);
        this.f4725k = new Matrix();
        this.f4726l = new Path();
        this.m = new Path();
        this.f4727n = new RectF();
        this.f4728o = new RectF();
        this.f4729p = new Region();
        this.f4730q = new Region();
        Paint paint = new Paint(1);
        this.s = paint;
        Paint paint2 = new Paint(1);
        this.f4732t = paint2;
        this.f4733u = new j4.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            jVar = j.a.f4793a;
        } else {
            jVar = new j();
        }
        this.f4735w = jVar;
        this.A = new RectF();
        this.B = true;
        this.f4720f = bVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m();
        l(getState());
        this.f4734v = new a();
    }

    public f(i iVar) {
        this(new b(iVar));
    }

    public final void b(RectF rectF, Path path) {
        j jVar = this.f4735w;
        b bVar = this.f4720f;
        jVar.a(bVar.f4740a, bVar.f4748j, rectF, this.f4734v, path);
        if (this.f4720f.f4747i != 1.0f) {
            this.f4725k.reset();
            Matrix matrix = this.f4725k;
            float f7 = this.f4720f.f4747i;
            matrix.setScale(f7, f7, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f4725k);
        }
        path.computeBounds(this.A, true);
    }

    public final PorterDuffColorFilter c(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z6) {
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(getState(), 0);
            if (z6) {
                colorForState = d(colorForState);
            }
            this.f4738z = colorForState;
            return new PorterDuffColorFilter(colorForState, mode);
        }
        if (z6) {
            int color = paint.getColor();
            int d7 = d(color);
            this.f4738z = d7;
            if (d7 != color) {
                return new PorterDuffColorFilter(d7, PorterDuff.Mode.SRC_IN);
            }
        }
        return null;
    }

    public final int d(int i7) {
        int i8;
        b bVar = this.f4720f;
        float f7 = bVar.f4751n + bVar.f4752o + bVar.m;
        a4.a aVar = bVar.f4741b;
        if (aVar == null || !aVar.f129a) {
            return i7;
        }
        if (i1.a.c(i7, 255) == aVar.f132d) {
            float f8 = aVar.e;
            float min = (f8 <= 0.0f || f7 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f7 / f8)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
            int alpha = Color.alpha(i7);
            int F = q2.a.F(i1.a.c(i7, 255), aVar.f130b, min);
            if (min > 0.0f && (i8 = aVar.f131c) != 0) {
                F = i1.a.b(i1.a.c(i8, a4.a.f128f), F);
            }
            return i1.a.c(F, alpha);
        }
        return i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:317:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0222  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.f.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas) {
        if (this.f4723i.cardinality() > 0) {
            Log.w(C, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f4720f.f4755r != 0) {
            canvas.drawPath(this.f4726l, this.f4733u.f4584a);
        }
        for (int i7 = 0; i7 < 4; i7++) {
            l.f fVar = this.f4721g[i7];
            j4.a aVar = this.f4733u;
            int i8 = this.f4720f.f4754q;
            Matrix matrix = l.f.f4815b;
            fVar.a(matrix, aVar, i8, canvas);
            this.f4722h[i7].a(matrix, this.f4733u, this.f4720f.f4754q, canvas);
        }
        if (this.B) {
            b bVar = this.f4720f;
            int sin = (int) (Math.sin(Math.toRadians(bVar.s)) * bVar.f4755r);
            b bVar2 = this.f4720f;
            int cos = (int) (Math.cos(Math.toRadians(bVar2.s)) * bVar2.f4755r);
            canvas.translate(-sin, -cos);
            canvas.drawPath(this.f4726l, D);
            canvas.translate(sin, cos);
        }
    }

    public final void f(Canvas canvas, Paint paint, Path path, i iVar, RectF rectF) {
        if (!iVar.d(rectF)) {
            canvas.drawPath(path, paint);
            return;
        }
        float a7 = iVar.f4764f.a(rectF) * this.f4720f.f4748j;
        canvas.drawRoundRect(rectF, a7, a7, paint);
    }

    public void g(Canvas canvas) {
        Paint paint = this.f4732t;
        Path path = this.m;
        i iVar = this.f4731r;
        this.f4728o.set(h());
        Paint.Style style = this.f4720f.f4757u;
        float strokeWidth = (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && (this.f4732t.getStrokeWidth() > 0.0f ? 1 : (this.f4732t.getStrokeWidth() == 0.0f ? 0 : -1)) > 0 ? this.f4732t.getStrokeWidth() / 2.0f : 0.0f;
        this.f4728o.inset(strokeWidth, strokeWidth);
        f(canvas, paint, path, iVar, this.f4728o);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4720f.f4750l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f4720f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(ErrorCode.FILE_NOT_FOUND_IO_CODE)
    public void getOutline(Outline outline) {
        b bVar = this.f4720f;
        if (bVar.f4753p == 2) {
            return;
        }
        if (bVar.f4740a.d(h())) {
            outline.setRoundRect(getBounds(), this.f4720f.f4740a.e.a(h()) * this.f4720f.f4748j);
            return;
        }
        b(h(), this.f4726l);
        outline.setPath(this.f4726l);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f4720f.f4746h;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        this.f4729p.set(getBounds());
        b(h(), this.f4726l);
        this.f4730q.setPath(this.f4726l, this.f4729p);
        this.f4729p.op(this.f4730q, Region.Op.DIFFERENCE);
        return this.f4729p;
    }

    public final RectF h() {
        this.f4727n.set(getBounds());
        return this.f4727n;
    }

    public final void i(Context context) {
        this.f4720f.f4741b = new a4.a(context);
        n();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f4724j = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f4720f.f4744f) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f4720f.e) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f4720f.f4743d) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f4720f.f4742c) != null && colorStateList4.isStateful())));
    }

    public final void j(float f7) {
        b bVar = this.f4720f;
        if (bVar.f4751n != f7) {
            bVar.f4751n = f7;
            n();
        }
    }

    public final void k(ColorStateList colorStateList) {
        b bVar = this.f4720f;
        if (bVar.f4742c != colorStateList) {
            bVar.f4742c = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean l(int[] iArr) {
        boolean z6;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f4720f.f4742c == null || color2 == (colorForState2 = this.f4720f.f4742c.getColorForState(iArr, (color2 = this.s.getColor())))) {
            z6 = false;
        } else {
            this.s.setColor(colorForState2);
            z6 = true;
        }
        if (this.f4720f.f4743d == null || color == (colorForState = this.f4720f.f4743d.getColorForState(iArr, (color = this.f4732t.getColor())))) {
            return z6;
        }
        this.f4732t.setColor(colorForState);
        return true;
    }

    public final boolean m() {
        PorterDuffColorFilter porterDuffColorFilter = this.f4736x;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f4737y;
        b bVar = this.f4720f;
        this.f4736x = c(bVar.f4744f, bVar.f4745g, this.s, true);
        b bVar2 = this.f4720f;
        this.f4737y = c(bVar2.e, bVar2.f4745g, this.f4732t, false);
        b bVar3 = this.f4720f;
        if (bVar3.f4756t) {
            this.f4733u.a(bVar3.f4744f.getColorForState(getState(), 0));
        }
        return (o1.b.a(porterDuffColorFilter, this.f4736x) && o1.b.a(porterDuffColorFilter2, this.f4737y)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f4720f = new b(this.f4720f);
        return this;
    }

    public final void n() {
        b bVar = this.f4720f;
        float f7 = bVar.f4751n + bVar.f4752o;
        bVar.f4754q = (int) Math.ceil(0.75f * f7);
        this.f4720f.f4755r = (int) Math.ceil(f7 * 0.25f);
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f4724j = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, d4.l.b
    public boolean onStateChange(int[] iArr) {
        boolean z6 = l(iArr) || m();
        if (z6) {
            invalidateSelf();
        }
        return z6;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        b bVar = this.f4720f;
        if (bVar.f4750l != i7) {
            bVar.f4750l = i7;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4720f.getClass();
        super.invalidateSelf();
    }

    @Override // k4.m
    public final void setShapeAppearanceModel(i iVar) {
        this.f4720f.f4740a = iVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i7) {
        setTintList(ColorStateList.valueOf(i7));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f4720f.f4744f = colorStateList;
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f4720f;
        if (bVar.f4745g != mode) {
            bVar.f4745g = mode;
            m();
            super.invalidateSelf();
        }
    }
}
