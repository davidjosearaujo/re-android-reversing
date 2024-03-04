package l2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import i1.d;
import j1.a;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class g extends l2.f {

    /* renamed from: o */
    public static final PorterDuff.Mode f4967o = PorterDuff.Mode.SRC_IN;

    /* renamed from: g */
    public C0077g f4968g;

    /* renamed from: h */
    public PorterDuffColorFilter f4969h;

    /* renamed from: i */
    public ColorFilter f4970i;

    /* renamed from: j */
    public boolean f4971j;

    /* renamed from: k */
    public boolean f4972k;

    /* renamed from: l */
    public final float[] f4973l;
    public final Matrix m;

    /* renamed from: n */
    public final Rect f4974n;

    /* loaded from: classes.dex */
    public static class a extends e {
        public a() {
        }

        public a(a aVar) {
            super(aVar);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends e {
        public h1.c e;

        /* renamed from: f */
        public float f4975f;

        /* renamed from: g */
        public h1.c f4976g;

        /* renamed from: h */
        public float f4977h;

        /* renamed from: i */
        public float f4978i;

        /* renamed from: j */
        public float f4979j;

        /* renamed from: k */
        public float f4980k;

        /* renamed from: l */
        public float f4981l;
        public Paint.Cap m;

        /* renamed from: n */
        public Paint.Join f4982n;

        /* renamed from: o */
        public float f4983o;

        public b() {
            this.f4975f = 0.0f;
            this.f4977h = 1.0f;
            this.f4978i = 1.0f;
            this.f4979j = 0.0f;
            this.f4980k = 1.0f;
            this.f4981l = 0.0f;
            this.m = Paint.Cap.BUTT;
            this.f4982n = Paint.Join.MITER;
            this.f4983o = 4.0f;
        }

        public b(b bVar) {
            super(bVar);
            this.f4975f = 0.0f;
            this.f4977h = 1.0f;
            this.f4978i = 1.0f;
            this.f4979j = 0.0f;
            this.f4980k = 1.0f;
            this.f4981l = 0.0f;
            this.m = Paint.Cap.BUTT;
            this.f4982n = Paint.Join.MITER;
            this.f4983o = 4.0f;
            this.e = bVar.e;
            this.f4975f = bVar.f4975f;
            this.f4977h = bVar.f4977h;
            this.f4976g = bVar.f4976g;
            this.f4997c = bVar.f4997c;
            this.f4978i = bVar.f4978i;
            this.f4979j = bVar.f4979j;
            this.f4980k = bVar.f4980k;
            this.f4981l = bVar.f4981l;
            this.m = bVar.m;
            this.f4982n = bVar.f4982n;
            this.f4983o = bVar.f4983o;
        }

        @Override // l2.g.d
        public final boolean a() {
            return this.f4976g.b() || this.e.b();
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x0025  */
        @Override // l2.g.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean b(int[] r6) {
            /*
                r5 = this;
                h1.c r0 = r5.f4976g
                boolean r1 = r0.b()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L1c
                android.content.res.ColorStateList r1 = r0.f4340b
                int r4 = r1.getDefaultColor()
                int r1 = r1.getColorForState(r6, r4)
                int r4 = r0.f4341c
                if (r1 == r4) goto L1c
                r0.f4341c = r1
                r0 = r2
                goto L1d
            L1c:
                r0 = r3
            L1d:
                h1.c r5 = r5.e
                boolean r1 = r5.b()
                if (r1 == 0) goto L36
                android.content.res.ColorStateList r1 = r5.f4340b
                int r4 = r1.getDefaultColor()
                int r6 = r1.getColorForState(r6, r4)
                int r1 = r5.f4341c
                if (r6 == r1) goto L36
                r5.f4341c = r6
                goto L37
            L36:
                r2 = r3
            L37:
                r5 = r2 | r0
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: l2.g.b.b(int[]):boolean");
        }

        public float getFillAlpha() {
            return this.f4978i;
        }

        public int getFillColor() {
            return this.f4976g.f4341c;
        }

        public float getStrokeAlpha() {
            return this.f4977h;
        }

        public int getStrokeColor() {
            return this.e.f4341c;
        }

        public float getStrokeWidth() {
            return this.f4975f;
        }

        public float getTrimPathEnd() {
            return this.f4980k;
        }

        public float getTrimPathOffset() {
            return this.f4981l;
        }

        public float getTrimPathStart() {
            return this.f4979j;
        }

        public void setFillAlpha(float f7) {
            this.f4978i = f7;
        }

        public void setFillColor(int i7) {
            this.f4976g.f4341c = i7;
        }

        public void setStrokeAlpha(float f7) {
            this.f4977h = f7;
        }

        public void setStrokeColor(int i7) {
            this.e.f4341c = i7;
        }

        public void setStrokeWidth(float f7) {
            this.f4975f = f7;
        }

        public void setTrimPathEnd(float f7) {
            this.f4980k = f7;
        }

        public void setTrimPathOffset(float f7) {
            this.f4981l = f7;
        }

        public void setTrimPathStart(float f7) {
            this.f4979j = f7;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: p */
        public static final Matrix f4999p = new Matrix();

        /* renamed from: a */
        public final Path f5000a;

        /* renamed from: b */
        public final Path f5001b;

        /* renamed from: c */
        public final Matrix f5002c;

        /* renamed from: d */
        public Paint f5003d;
        public Paint e;

        /* renamed from: f */
        public PathMeasure f5004f;

        /* renamed from: g */
        public final c f5005g;

        /* renamed from: h */
        public float f5006h;

        /* renamed from: i */
        public float f5007i;

        /* renamed from: j */
        public float f5008j;

        /* renamed from: k */
        public float f5009k;

        /* renamed from: l */
        public int f5010l;
        public String m;

        /* renamed from: n */
        public Boolean f5011n;

        /* renamed from: o */
        public final o.b<String, Object> f5012o;

        public f() {
            this.f5002c = new Matrix();
            this.f5006h = 0.0f;
            this.f5007i = 0.0f;
            this.f5008j = 0.0f;
            this.f5009k = 0.0f;
            this.f5010l = 255;
            this.m = null;
            this.f5011n = null;
            this.f5012o = new o.b<>();
            this.f5005g = new c();
            this.f5000a = new Path();
            this.f5001b = new Path();
        }

        public f(f fVar) {
            this.f5002c = new Matrix();
            this.f5006h = 0.0f;
            this.f5007i = 0.0f;
            this.f5008j = 0.0f;
            this.f5009k = 0.0f;
            this.f5010l = 255;
            this.m = null;
            this.f5011n = null;
            o.b<String, Object> bVar = new o.b<>();
            this.f5012o = bVar;
            this.f5005g = new c(fVar.f5005g, bVar);
            this.f5000a = new Path(fVar.f5000a);
            this.f5001b = new Path(fVar.f5001b);
            this.f5006h = fVar.f5006h;
            this.f5007i = fVar.f5007i;
            this.f5008j = fVar.f5008j;
            this.f5009k = fVar.f5009k;
            this.f5010l = fVar.f5010l;
            this.m = fVar.m;
            String str = fVar.m;
            if (str != null) {
                bVar.put(str, this);
            }
            this.f5011n = fVar.f5011n;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r9v19 */
        public final void a(c cVar, Matrix matrix, Canvas canvas, int i7, int i8) {
            boolean z6;
            cVar.f4984a.set(matrix);
            cVar.f4984a.preConcat(cVar.f4992j);
            canvas.save();
            ?? r9 = 0;
            f fVar = this;
            int i9 = 0;
            while (i9 < cVar.f4985b.size()) {
                d dVar = cVar.f4985b.get(i9);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.f4984a, canvas, i7, i8);
                } else if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    float f7 = i7 / fVar.f5008j;
                    float f8 = i8 / fVar.f5009k;
                    float min = Math.min(f7, f8);
                    Matrix matrix2 = cVar.f4984a;
                    fVar.f5002c.set(matrix2);
                    fVar.f5002c.postScale(f7, f8);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    float f9 = (fArr[r9] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot(fArr[r9], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
                    float abs = max > 0.0f ? Math.abs(f9) / max : 0.0f;
                    if (abs != 0.0f) {
                        Path path = this.f5000a;
                        eVar.getClass();
                        path.reset();
                        d.a[] aVarArr = eVar.f4995a;
                        if (aVarArr != null) {
                            d.a.b(aVarArr, path);
                        }
                        Path path2 = this.f5000a;
                        this.f5001b.reset();
                        if (eVar instanceof a) {
                            this.f5001b.setFillType(eVar.f4997c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            this.f5001b.addPath(path2, this.f5002c);
                            canvas.clipPath(this.f5001b);
                        } else {
                            b bVar = (b) eVar;
                            float f10 = bVar.f4979j;
                            if (f10 != 0.0f || bVar.f4980k != 1.0f) {
                                float f11 = bVar.f4981l;
                                float f12 = (f10 + f11) % 1.0f;
                                float f13 = (bVar.f4980k + f11) % 1.0f;
                                if (this.f5004f == null) {
                                    this.f5004f = new PathMeasure();
                                }
                                this.f5004f.setPath(this.f5000a, r9);
                                float length = this.f5004f.getLength();
                                float f14 = f12 * length;
                                float f15 = f13 * length;
                                path2.reset();
                                if (f14 > f15) {
                                    this.f5004f.getSegment(f14, length, path2, true);
                                    this.f5004f.getSegment(0.0f, f15, path2, true);
                                } else {
                                    this.f5004f.getSegment(f14, f15, path2, true);
                                }
                                path2.rLineTo(0.0f, 0.0f);
                            }
                            this.f5001b.addPath(path2, this.f5002c);
                            h1.c cVar2 = bVar.f4976g;
                            if (((cVar2.f4339a != null ? true : r9) || cVar2.f4341c != 0) ? true : r9) {
                                if (this.e == null) {
                                    Paint paint = new Paint(1);
                                    this.e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = this.e;
                                Shader shader = cVar2.f4339a;
                                if (shader != null ? true : r9) {
                                    shader.setLocalMatrix(this.f5002c);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(bVar.f4978i * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i10 = cVar2.f4341c;
                                    float f16 = bVar.f4978i;
                                    PorterDuff.Mode mode = g.f4967o;
                                    paint2.setColor((i10 & 16777215) | (((int) (Color.alpha(i10) * f16)) << 24));
                                }
                                paint2.setColorFilter(null);
                                this.f5001b.setFillType(bVar.f4997c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(this.f5001b, paint2);
                            }
                            h1.c cVar3 = bVar.e;
                            if ((cVar3.f4339a != null) || cVar3.f4341c != 0) {
                                if (this.f5003d == null) {
                                    z6 = true;
                                    Paint paint3 = new Paint(1);
                                    this.f5003d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                } else {
                                    z6 = true;
                                }
                                Paint paint4 = this.f5003d;
                                Paint.Join join = bVar.f4982n;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = bVar.m;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(bVar.f4983o);
                                Shader shader2 = cVar3.f4339a;
                                if (shader2 == null) {
                                    z6 = false;
                                }
                                if (z6) {
                                    shader2.setLocalMatrix(this.f5002c);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(bVar.f4977h * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i11 = cVar3.f4341c;
                                    float f17 = bVar.f4977h;
                                    PorterDuff.Mode mode2 = g.f4967o;
                                    paint4.setColor((i11 & 16777215) | (((int) (Color.alpha(i11) * f17)) << 24));
                                }
                                paint4.setColorFilter(null);
                                paint4.setStrokeWidth(bVar.f4975f * abs * min);
                                canvas.drawPath(this.f5001b, paint4);
                            }
                        }
                    }
                    fVar = this;
                    i9++;
                    r9 = 0;
                }
                i9++;
                r9 = 0;
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f5010l;
        }

        public void setAlpha(float f7) {
            setRootAlpha((int) (f7 * 255.0f));
        }

        public void setRootAlpha(int i7) {
            this.f5010l = i7;
        }
    }

    /* renamed from: l2.g$g */
    /* loaded from: classes.dex */
    public static class C0077g extends Drawable.ConstantState {

        /* renamed from: a */
        public int f5013a;

        /* renamed from: b */
        public f f5014b;

        /* renamed from: c */
        public ColorStateList f5015c;

        /* renamed from: d */
        public PorterDuff.Mode f5016d;
        public boolean e;

        /* renamed from: f */
        public Bitmap f5017f;

        /* renamed from: g */
        public ColorStateList f5018g;

        /* renamed from: h */
        public PorterDuff.Mode f5019h;

        /* renamed from: i */
        public int f5020i;

        /* renamed from: j */
        public boolean f5021j;

        /* renamed from: k */
        public boolean f5022k;

        /* renamed from: l */
        public Paint f5023l;

        public C0077g() {
            this.f5015c = null;
            this.f5016d = g.f4967o;
            this.f5014b = new f();
        }

        public C0077g(C0077g c0077g) {
            this.f5015c = null;
            this.f5016d = g.f4967o;
            if (c0077g != null) {
                this.f5013a = c0077g.f5013a;
                f fVar = new f(c0077g.f5014b);
                this.f5014b = fVar;
                if (c0077g.f5014b.e != null) {
                    fVar.e = new Paint(c0077g.f5014b.e);
                }
                if (c0077g.f5014b.f5003d != null) {
                    this.f5014b.f5003d = new Paint(c0077g.f5014b.f5003d);
                }
                this.f5015c = c0077g.f5015c;
                this.f5016d = c0077g.f5016d;
                this.e = c0077g.e;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f5013a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new g(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new g(this);
        }
    }

    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a */
        public final Drawable.ConstantState f5024a;

        public h(Drawable.ConstantState constantState) {
            this.f5024a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f5024a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f5024a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            g gVar = new g();
            gVar.f4966f = (VectorDrawable) this.f5024a.newDrawable();
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            g gVar = new g();
            gVar.f4966f = (VectorDrawable) this.f5024a.newDrawable(resources);
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            g gVar = new g();
            gVar.f4966f = (VectorDrawable) this.f5024a.newDrawable(resources, theme);
            return gVar;
        }
    }

    public g() {
        this.f4972k = true;
        this.f4973l = new float[9];
        this.m = new Matrix();
        this.f4974n = new Rect();
        this.f4968g = new C0077g();
    }

    public g(C0077g c0077g) {
        this.f4972k = true;
        this.f4973l = new float[9];
        this.m = new Matrix();
        this.f4974n = new Rect();
        this.f4968g = c0077g;
        this.f4969h = a(c0077g.f5015c, c0077g.f5016d);
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.b.b(drawable);
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:264:0x00d3, code lost:
        if ((r15 == r8.getWidth() && r3 == r6.f5017f.getHeight()) == false) goto L66;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.g.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f4966f;
        return drawable != null ? a.C0071a.a(drawable) : this.f4968g.f5014b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f4968g.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f4966f;
        return drawable != null ? a.b.c(drawable) : this.f4970i;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f4966f != null) {
            return new h(this.f4966f.getConstantState());
        }
        this.f4968g.f5013a = getChangingConfigurations();
        return this.f4968g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f4968g.f5014b.f5007i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f4968g.f5014b.f5006h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:479:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x03e2  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void inflate(android.content.res.Resources r23, org.xmlpull.v1.XmlPullParser r24, android.util.AttributeSet r25, android.content.res.Resources.Theme r26) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.g.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f4966f;
        return drawable != null ? a.C0071a.d(drawable) : this.f4968g.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            C0077g c0077g = this.f4968g;
            if (c0077g != null) {
                f fVar = c0077g.f5014b;
                if (fVar.f5011n == null) {
                    fVar.f5011n = Boolean.valueOf(fVar.f5005g.a());
                }
                if (fVar.f5011n.booleanValue() || ((colorStateList = this.f4968g.f5015c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f4971j && super.mutate() == this) {
            this.f4968g = new C0077g(this.f4968g);
            this.f4971j = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z6 = false;
        C0077g c0077g = this.f4968g;
        ColorStateList colorStateList = c0077g.f5015c;
        if (colorStateList != null && (mode = c0077g.f5016d) != null) {
            this.f4969h = a(colorStateList, mode);
            invalidateSelf();
            z6 = true;
        }
        f fVar = c0077g.f5014b;
        if (fVar.f5011n == null) {
            fVar.f5011n = Boolean.valueOf(fVar.f5005g.a());
        }
        if (fVar.f5011n.booleanValue()) {
            boolean b2 = c0077g.f5014b.f5005g.b(iArr);
            c0077g.f5022k |= b2;
            if (b2) {
                invalidateSelf();
                return true;
            }
        }
        return z6;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j5) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j5);
        } else {
            super.scheduleSelf(runnable, j5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i7) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.setAlpha(i7);
        } else if (this.f4968g.f5014b.getRootAlpha() != i7) {
            this.f4968g.f5014b.setRootAlpha(i7);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z6) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.C0071a.e(drawable, z6);
        } else {
            this.f4968g.e = z6;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f4970i = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i7) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            j1.a.a(drawable, i7);
        } else {
            setTintList(ColorStateList.valueOf(i7));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.b.h(drawable, colorStateList);
            return;
        }
        C0077g c0077g = this.f4968g;
        if (c0077g.f5015c != colorStateList) {
            c0077g.f5015c = colorStateList;
            this.f4969h = a(colorStateList, c0077g.f5016d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.b.i(drawable, mode);
            return;
        }
        C0077g c0077g = this.f4968g;
        if (c0077g.f5016d != mode) {
            c0077g.f5016d = mode;
            this.f4969h = a(c0077g.f5015c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z6, boolean z7) {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.setVisible(z6, z7) : super.setVisible(z6, z7);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {

        /* renamed from: a */
        public final Matrix f4984a;

        /* renamed from: b */
        public final ArrayList<d> f4985b;

        /* renamed from: c */
        public float f4986c;

        /* renamed from: d */
        public float f4987d;
        public float e;

        /* renamed from: f */
        public float f4988f;

        /* renamed from: g */
        public float f4989g;

        /* renamed from: h */
        public float f4990h;

        /* renamed from: i */
        public float f4991i;

        /* renamed from: j */
        public final Matrix f4992j;

        /* renamed from: k */
        public int f4993k;

        /* renamed from: l */
        public String f4994l;

        public c() {
            this.f4984a = new Matrix();
            this.f4985b = new ArrayList<>();
            this.f4986c = 0.0f;
            this.f4987d = 0.0f;
            this.e = 0.0f;
            this.f4988f = 1.0f;
            this.f4989g = 1.0f;
            this.f4990h = 0.0f;
            this.f4991i = 0.0f;
            this.f4992j = new Matrix();
            this.f4994l = null;
        }

        @Override // l2.g.d
        public final boolean a() {
            for (int i7 = 0; i7 < this.f4985b.size(); i7++) {
                if (this.f4985b.get(i7).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // l2.g.d
        public final boolean b(int[] iArr) {
            boolean z6 = false;
            for (int i7 = 0; i7 < this.f4985b.size(); i7++) {
                z6 |= this.f4985b.get(i7).b(iArr);
            }
            return z6;
        }

        public final void c() {
            this.f4992j.reset();
            this.f4992j.postTranslate(-this.f4987d, -this.e);
            this.f4992j.postScale(this.f4988f, this.f4989g);
            this.f4992j.postRotate(this.f4986c, 0.0f, 0.0f);
            this.f4992j.postTranslate(this.f4990h + this.f4987d, this.f4991i + this.e);
        }

        public String getGroupName() {
            return this.f4994l;
        }

        public Matrix getLocalMatrix() {
            return this.f4992j;
        }

        public float getPivotX() {
            return this.f4987d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.f4986c;
        }

        public float getScaleX() {
            return this.f4988f;
        }

        public float getScaleY() {
            return this.f4989g;
        }

        public float getTranslateX() {
            return this.f4990h;
        }

        public float getTranslateY() {
            return this.f4991i;
        }

        public void setPivotX(float f7) {
            if (f7 != this.f4987d) {
                this.f4987d = f7;
                c();
            }
        }

        public void setPivotY(float f7) {
            if (f7 != this.e) {
                this.e = f7;
                c();
            }
        }

        public void setRotation(float f7) {
            if (f7 != this.f4986c) {
                this.f4986c = f7;
                c();
            }
        }

        public void setScaleX(float f7) {
            if (f7 != this.f4988f) {
                this.f4988f = f7;
                c();
            }
        }

        public void setScaleY(float f7) {
            if (f7 != this.f4989g) {
                this.f4989g = f7;
                c();
            }
        }

        public void setTranslateX(float f7) {
            if (f7 != this.f4990h) {
                this.f4990h = f7;
                c();
            }
        }

        public void setTranslateY(float f7) {
            if (f7 != this.f4991i) {
                this.f4991i = f7;
                c();
            }
        }

        public c(c cVar, o.b<String, Object> bVar) {
            e aVar;
            this.f4984a = new Matrix();
            this.f4985b = new ArrayList<>();
            this.f4986c = 0.0f;
            this.f4987d = 0.0f;
            this.e = 0.0f;
            this.f4988f = 1.0f;
            this.f4989g = 1.0f;
            this.f4990h = 0.0f;
            this.f4991i = 0.0f;
            Matrix matrix = new Matrix();
            this.f4992j = matrix;
            this.f4994l = null;
            this.f4986c = cVar.f4986c;
            this.f4987d = cVar.f4987d;
            this.e = cVar.e;
            this.f4988f = cVar.f4988f;
            this.f4989g = cVar.f4989g;
            this.f4990h = cVar.f4990h;
            this.f4991i = cVar.f4991i;
            String str = cVar.f4994l;
            this.f4994l = str;
            this.f4993k = cVar.f4993k;
            if (str != null) {
                bVar.put(str, this);
            }
            matrix.set(cVar.f4992j);
            ArrayList<d> arrayList = cVar.f4985b;
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                d dVar = arrayList.get(i7);
                if (dVar instanceof c) {
                    this.f4985b.add(new c((c) dVar, bVar));
                } else {
                    if (dVar instanceof b) {
                        aVar = new b((b) dVar);
                    } else if (!(dVar instanceof a)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    } else {
                        aVar = new a((a) dVar);
                    }
                    this.f4985b.add(aVar);
                    String str2 = aVar.f4996b;
                    if (str2 != null) {
                        bVar.put(str2, aVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e extends d {

        /* renamed from: a */
        public d.a[] f4995a;

        /* renamed from: b */
        public String f4996b;

        /* renamed from: c */
        public int f4997c;

        /* renamed from: d */
        public int f4998d;

        public e() {
            this.f4995a = null;
            this.f4997c = 0;
        }

        public d.a[] getPathData() {
            return this.f4995a;
        }

        public String getPathName() {
            return this.f4996b;
        }

        public void setPathData(d.a[] aVarArr) {
            if (!i1.d.a(this.f4995a, aVarArr)) {
                this.f4995a = i1.d.e(aVarArr);
                return;
            }
            d.a[] aVarArr2 = this.f4995a;
            for (int i7 = 0; i7 < aVarArr.length; i7++) {
                aVarArr2[i7].f4467a = aVarArr[i7].f4467a;
                int i8 = 0;
                while (true) {
                    float[] fArr = aVarArr[i7].f4468b;
                    if (i8 < fArr.length) {
                        aVarArr2[i7].f4468b[i8] = fArr[i8];
                        i8++;
                    }
                }
            }
        }

        public e(e eVar) {
            this.f4995a = null;
            this.f4997c = 0;
            this.f4996b = eVar.f4996b;
            this.f4998d = eVar.f4998d;
            this.f4995a = i1.d.e(eVar.f4995a);
        }
    }
}
