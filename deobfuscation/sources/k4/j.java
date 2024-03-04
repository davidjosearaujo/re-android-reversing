package k4;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;
import k4.f;
import k4.l;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a */
    public final l[] f4782a = new l[4];

    /* renamed from: b */
    public final Matrix[] f4783b = new Matrix[4];

    /* renamed from: c */
    public final Matrix[] f4784c = new Matrix[4];

    /* renamed from: d */
    public final PointF f4785d = new PointF();
    public final Path e = new Path();

    /* renamed from: f */
    public final Path f4786f = new Path();

    /* renamed from: g */
    public final l f4787g = new l();

    /* renamed from: h */
    public final float[] f4788h = new float[2];

    /* renamed from: i */
    public final float[] f4789i = new float[2];

    /* renamed from: j */
    public final Path f4790j = new Path();

    /* renamed from: k */
    public final Path f4791k = new Path();

    /* renamed from: l */
    public boolean f4792l = true;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public static final j f4793a = new j();
    }

    public j() {
        for (int i7 = 0; i7 < 4; i7++) {
            this.f4782a[i7] = new l();
            this.f4783b[i7] = new Matrix();
            this.f4784c[i7] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    public final void a(i iVar, float f7, RectF rectF, f.a aVar, Path path) {
        int i7;
        int i8;
        float[] fArr;
        float centerX;
        float f8;
        int i9;
        e eVar;
        l lVar;
        Matrix matrix;
        Path path2;
        boolean z6;
        float f9;
        float f10;
        path.rewind();
        this.e.rewind();
        this.f4786f.rewind();
        this.f4786f.addRect(rectF, Path.Direction.CW);
        ?? r6 = 0;
        int i10 = 0;
        while (true) {
            i7 = 3;
            if (i10 >= 4) {
                break;
            }
            c cVar = i10 != 1 ? i10 != 2 ? i10 != 3 ? iVar.f4764f : iVar.e : iVar.f4766h : iVar.f4765g;
            g6.i iVar2 = i10 != 1 ? i10 != 2 ? i10 != 3 ? iVar.f4761b : iVar.f4760a : iVar.f4763d : iVar.f4762c;
            l lVar2 = this.f4782a[i10];
            iVar2.getClass();
            iVar2.f(f7, cVar.a(rectF), lVar2);
            int i11 = i10 + 1;
            float f11 = (i11 % 4) * 90;
            this.f4783b[i10].reset();
            PointF pointF = this.f4785d;
            if (i10 == 1) {
                f9 = rectF.right;
            } else if (i10 != 2) {
                f9 = i10 != 3 ? rectF.right : rectF.left;
                f10 = rectF.top;
                pointF.set(f9, f10);
                Matrix matrix2 = this.f4783b[i10];
                PointF pointF2 = this.f4785d;
                matrix2.setTranslate(pointF2.x, pointF2.y);
                this.f4783b[i10].preRotate(f11);
                float[] fArr2 = this.f4788h;
                l lVar3 = this.f4782a[i10];
                fArr2[0] = lVar3.f4798c;
                fArr2[1] = lVar3.f4799d;
                this.f4783b[i10].mapPoints(fArr2);
                this.f4784c[i10].reset();
                Matrix matrix3 = this.f4784c[i10];
                float[] fArr3 = this.f4788h;
                matrix3.setTranslate(fArr3[0], fArr3[1]);
                this.f4784c[i10].preRotate(f11);
                i10 = i11;
            } else {
                f9 = rectF.left;
            }
            f10 = rectF.bottom;
            pointF.set(f9, f10);
            Matrix matrix22 = this.f4783b[i10];
            PointF pointF22 = this.f4785d;
            matrix22.setTranslate(pointF22.x, pointF22.y);
            this.f4783b[i10].preRotate(f11);
            float[] fArr22 = this.f4788h;
            l lVar32 = this.f4782a[i10];
            fArr22[0] = lVar32.f4798c;
            fArr22[1] = lVar32.f4799d;
            this.f4783b[i10].mapPoints(fArr22);
            this.f4784c[i10].reset();
            Matrix matrix32 = this.f4784c[i10];
            float[] fArr32 = this.f4788h;
            matrix32.setTranslate(fArr32[0], fArr32[1]);
            this.f4784c[i10].preRotate(f11);
            i10 = i11;
        }
        int i12 = 0;
        for (i8 = 4; i12 < i8; i8 = 4) {
            float[] fArr4 = this.f4788h;
            l lVar4 = this.f4782a[i12];
            fArr4[r6] = lVar4.f4796a;
            fArr4[1] = lVar4.f4797b;
            this.f4783b[i12].mapPoints(fArr4);
            float[] fArr5 = this.f4788h;
            if (i12 == 0) {
                path.moveTo(fArr5[r6], fArr5[1]);
            } else {
                path.lineTo(fArr5[r6], fArr5[1]);
            }
            this.f4782a[i12].c(this.f4783b[i12], path);
            if (aVar != null) {
                l lVar5 = this.f4782a[i12];
                Matrix matrix4 = this.f4783b[i12];
                BitSet bitSet = f.this.f4723i;
                lVar5.getClass();
                bitSet.set(i12, (boolean) r6);
                l.f[] fVarArr = f.this.f4721g;
                lVar5.b(lVar5.f4800f);
                fVarArr[i12] = new k(new ArrayList(lVar5.f4802h), new Matrix(matrix4));
            }
            int i13 = i12 + 1;
            int i14 = i13 % 4;
            float[] fArr6 = this.f4788h;
            l lVar6 = this.f4782a[i12];
            fArr6[r6] = lVar6.f4798c;
            fArr6[1] = lVar6.f4799d;
            this.f4783b[i12].mapPoints(fArr6);
            float[] fArr7 = this.f4789i;
            l lVar7 = this.f4782a[i14];
            fArr7[r6] = lVar7.f4796a;
            fArr7[1] = lVar7.f4797b;
            this.f4783b[i14].mapPoints(fArr7);
            float f12 = this.f4788h[r6];
            float[] fArr8 = this.f4789i;
            int i15 = i12;
            float max = Math.max(((float) Math.hypot(f12 - fArr8[r6], fArr[1] - fArr8[1])) - 0.001f, 0.0f);
            float[] fArr9 = this.f4788h;
            l lVar8 = this.f4782a[i15];
            fArr9[0] = lVar8.f4798c;
            fArr9[1] = lVar8.f4799d;
            this.f4783b[i15].mapPoints(fArr9);
            if (i15 == 1 || i15 == i7) {
                centerX = rectF.centerX();
                f8 = this.f4788h[0];
            } else {
                centerX = rectF.centerY();
                f8 = this.f4788h[1];
            }
            float abs = Math.abs(centerX - f8);
            this.f4787g.e(0.0f, 270.0f, 0.0f);
            if (i15 == 1) {
                i9 = 3;
                eVar = iVar.f4769k;
            } else if (i15 != 2) {
                i9 = 3;
                eVar = i15 != 3 ? iVar.f4768j : iVar.f4767i;
            } else {
                i9 = 3;
                eVar = iVar.f4770l;
            }
            eVar.a(max, abs, f7, this.f4787g);
            this.f4790j.reset();
            this.f4787g.c(this.f4784c[i15], this.f4790j);
            if (this.f4792l && (b(this.f4790j, i15) || b(this.f4790j, i14))) {
                Path path3 = this.f4790j;
                path3.op(path3, this.f4786f, Path.Op.DIFFERENCE);
                float[] fArr10 = this.f4788h;
                l lVar9 = this.f4787g;
                fArr10[0] = lVar9.f4796a;
                fArr10[1] = lVar9.f4797b;
                this.f4784c[i15].mapPoints(fArr10);
                Path path4 = this.e;
                float[] fArr11 = this.f4788h;
                path4.moveTo(fArr11[0], fArr11[1]);
                lVar = this.f4787g;
                matrix = this.f4784c[i15];
                path2 = this.e;
            } else {
                lVar = this.f4787g;
                matrix = this.f4784c[i15];
                path2 = path;
            }
            lVar.c(matrix, path2);
            if (aVar != null) {
                l lVar10 = this.f4787g;
                Matrix matrix5 = this.f4784c[i15];
                lVar10.getClass();
                z6 = false;
                f.this.f4723i.set(i15 + 4, false);
                l.f[] fVarArr2 = f.this.f4722h;
                lVar10.b(lVar10.f4800f);
                fVarArr2[i15] = new k(new ArrayList(lVar10.f4802h), new Matrix(matrix5));
            } else {
                z6 = false;
            }
            i7 = i9;
            i12 = i13;
            r6 = z6;
        }
        path.close();
        this.e.close();
        if (this.e.isEmpty()) {
            return;
        }
        path.op(this.e, Path.Op.UNION);
    }

    public final boolean b(Path path, int i7) {
        this.f4791k.reset();
        this.f4782a[i7].c(this.f4783b[i7], this.f4791k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f4791k.computeBounds(rectF, true);
        path.op(this.f4791k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
