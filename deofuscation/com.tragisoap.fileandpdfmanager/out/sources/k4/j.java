package k4;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final l[] f4782a = new l[4];

    /* renamed from: b  reason: collision with root package name */
    public final Matrix[] f4783b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix[] f4784c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    public final PointF f4785d = new PointF();
    public final Path e = new Path();

    /* renamed from: f  reason: collision with root package name */
    public final Path f4786f = new Path();

    /* renamed from: g  reason: collision with root package name */
    public final l f4787g = new l();

    /* renamed from: h  reason: collision with root package name */
    public final float[] f4788h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    public final float[] f4789i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    public final Path f4790j = new Path();

    /* renamed from: k  reason: collision with root package name */
    public final Path f4791k = new Path();

    /* renamed from: l  reason: collision with root package name */
    public boolean f4792l = true;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
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
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(k4.i r19, float r20, android.graphics.RectF r21, k4.f.a r22, android.graphics.Path r23) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.j.a(k4.i, float, android.graphics.RectF, k4.f$a, android.graphics.Path):void");
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
