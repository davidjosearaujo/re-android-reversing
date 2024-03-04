package k4;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l {
    @Deprecated

    /* renamed from: a */
    public float f4796a;
    @Deprecated

    /* renamed from: b */
    public float f4797b;
    @Deprecated

    /* renamed from: c */
    public float f4798c;
    @Deprecated

    /* renamed from: d */
    public float f4799d;
    @Deprecated
    public float e;
    @Deprecated

    /* renamed from: f */
    public float f4800f;

    /* renamed from: g */
    public final ArrayList f4801g = new ArrayList();

    /* renamed from: h */
    public final ArrayList f4802h = new ArrayList();

    /* loaded from: classes.dex */
    public static class a extends f {

        /* renamed from: c */
        public final c f4803c;

        public a(c cVar) {
            this.f4803c = cVar;
        }

        @Override // k4.l.f
        public final void a(Matrix matrix, j4.a aVar, int i7, Canvas canvas) {
            c cVar = this.f4803c;
            float f7 = cVar.f4810f;
            float f8 = cVar.f4811g;
            c cVar2 = this.f4803c;
            RectF rectF = new RectF(cVar2.f4807b, cVar2.f4808c, cVar2.f4809d, cVar2.e);
            boolean z6 = f8 < 0.0f;
            Path path = aVar.f4589g;
            if (z6) {
                int[] iArr = j4.a.f4582k;
                iArr[0] = 0;
                iArr[1] = aVar.f4588f;
                iArr[2] = aVar.e;
                iArr[3] = aVar.f4587d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f7, f8);
                path.close();
                float f9 = -i7;
                rectF.inset(f9, f9);
                int[] iArr2 = j4.a.f4582k;
                iArr2[0] = 0;
                iArr2[1] = aVar.f4587d;
                iArr2[2] = aVar.e;
                iArr2[3] = aVar.f4588f;
            }
            float width = rectF.width() / 2.0f;
            if (width <= 0.0f) {
                return;
            }
            float f10 = 1.0f - (i7 / width);
            float[] fArr = j4.a.f4583l;
            fArr[1] = f10;
            fArr[2] = ((1.0f - f10) / 2.0f) + f10;
            aVar.f4585b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, j4.a.f4582k, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            canvas.scale(1.0f, rectF.height() / rectF.width());
            if (!z6) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, aVar.f4590h);
            }
            canvas.drawArc(rectF, f7, f8, true, aVar.f4585b);
            canvas.restore();
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f {

        /* renamed from: c */
        public final d f4804c;

        /* renamed from: d */
        public final float f4805d;
        public final float e;

        public b(d dVar, float f7, float f8) {
            this.f4804c = dVar;
            this.f4805d = f7;
            this.e = f8;
        }

        @Override // k4.l.f
        public final void a(Matrix matrix, j4.a aVar, int i7, Canvas canvas) {
            d dVar = this.f4804c;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(dVar.f4813c - this.e, dVar.f4812b - this.f4805d), 0.0f);
            this.f4816a.set(matrix);
            this.f4816a.preTranslate(this.f4805d, this.e);
            this.f4816a.preRotate(b());
            Matrix matrix2 = this.f4816a;
            aVar.getClass();
            rectF.bottom += i7;
            rectF.offset(0.0f, -i7);
            int[] iArr = j4.a.f4580i;
            iArr[0] = aVar.f4588f;
            iArr[1] = aVar.e;
            iArr[2] = aVar.f4587d;
            Paint paint = aVar.f4586c;
            float f7 = rectF.left;
            paint.setShader(new LinearGradient(f7, rectF.top, f7, rectF.bottom, iArr, j4.a.f4581j, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, aVar.f4586c);
            canvas.restore();
        }

        public final float b() {
            d dVar = this.f4804c;
            return (float) Math.toDegrees(Math.atan((dVar.f4813c - this.e) / (dVar.f4812b - this.f4805d)));
        }
    }

    /* loaded from: classes.dex */
    public static class c extends e {

        /* renamed from: h */
        public static final RectF f4806h = new RectF();
        @Deprecated

        /* renamed from: b */
        public float f4807b;
        @Deprecated

        /* renamed from: c */
        public float f4808c;
        @Deprecated

        /* renamed from: d */
        public float f4809d;
        @Deprecated
        public float e;
        @Deprecated

        /* renamed from: f */
        public float f4810f;
        @Deprecated

        /* renamed from: g */
        public float f4811g;

        public c(float f7, float f8, float f9, float f10) {
            this.f4807b = f7;
            this.f4808c = f8;
            this.f4809d = f9;
            this.e = f10;
        }

        @Override // k4.l.e
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f4814a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f4806h;
            rectF.set(this.f4807b, this.f4808c, this.f4809d, this.e);
            path.arcTo(rectF, this.f4810f, this.f4811g, false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: b */
        public float f4812b;

        /* renamed from: c */
        public float f4813c;

        @Override // k4.l.e
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f4814a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f4812b, this.f4813c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {

        /* renamed from: a */
        public final Matrix f4814a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: b */
        public static final Matrix f4815b = new Matrix();

        /* renamed from: a */
        public final Matrix f4816a = new Matrix();

        public abstract void a(Matrix matrix, j4.a aVar, int i7, Canvas canvas);
    }

    public l() {
        e(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f7, float f8, float f9, float f10, float f11, float f12) {
        c cVar = new c(f7, f8, f9, f10);
        cVar.f4810f = f11;
        cVar.f4811g = f12;
        this.f4801g.add(cVar);
        a aVar = new a(cVar);
        float f13 = f11 + f12;
        boolean z6 = f12 < 0.0f;
        if (z6) {
            f11 = (f11 + 180.0f) % 360.0f;
        }
        float f14 = z6 ? (180.0f + f13) % 360.0f : f13;
        b(f11);
        this.f4802h.add(aVar);
        this.e = f14;
        double d7 = f13;
        this.f4798c = (((f9 - f7) / 2.0f) * ((float) Math.cos(Math.toRadians(d7)))) + ((f7 + f9) * 0.5f);
        this.f4799d = (((f10 - f8) / 2.0f) * ((float) Math.sin(Math.toRadians(d7)))) + ((f8 + f10) * 0.5f);
    }

    public final void b(float f7) {
        float f8 = this.e;
        if (f8 == f7) {
            return;
        }
        float f9 = ((f7 - f8) + 360.0f) % 360.0f;
        if (f9 > 180.0f) {
            return;
        }
        float f10 = this.f4798c;
        float f11 = this.f4799d;
        c cVar = new c(f10, f11, f10, f11);
        cVar.f4810f = this.e;
        cVar.f4811g = f9;
        this.f4802h.add(new a(cVar));
        this.e = f7;
    }

    public final void c(Matrix matrix, Path path) {
        int size = this.f4801g.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((e) this.f4801g.get(i7)).a(matrix, path);
        }
    }

    public final void d(float f7, float f8) {
        d dVar = new d();
        dVar.f4812b = f7;
        dVar.f4813c = f8;
        this.f4801g.add(dVar);
        b bVar = new b(dVar, this.f4798c, this.f4799d);
        b(bVar.b() + 270.0f);
        this.f4802h.add(bVar);
        this.e = bVar.b() + 270.0f;
        this.f4798c = f7;
        this.f4799d = f8;
    }

    public final void e(float f7, float f8, float f9) {
        this.f4796a = 0.0f;
        this.f4797b = f7;
        this.f4798c = 0.0f;
        this.f4799d = f7;
        this.e = f8;
        this.f4800f = (f8 + f9) % 360.0f;
        this.f4801g.clear();
        this.f4802h.clear();
    }
}
