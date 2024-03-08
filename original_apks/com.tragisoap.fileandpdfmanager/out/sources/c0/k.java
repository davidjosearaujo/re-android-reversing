package c0;

import a0.e;
import r5.h;
import w5.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k extends c {

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f2483d;
    public static final float[] e;

    /* renamed from: f  reason: collision with root package name */
    public static final float[] f2484f;

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f2485g;

    static {
        float[] e7 = d.e(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, d.b(a.f2460b.f2461a, new float[]{0.964212f, 1.0f, 0.8251883f}, new float[]{0.95042855f, 1.0f, 1.0889004f}));
        f2483d = e7;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        e = fArr;
        f2484f = d.d(e7);
        f2485g = d.d(fArr);
    }

    public k() {
        super("Oklab", b.f2464c, 17);
    }

    @Override // c0.c
    public final float[] a(float[] fArr) {
        d.g(f2483d, fArr);
        double d7 = (double) 0.33333334f;
        fArr[0] = Math.signum(fArr[0]) * ((float) Math.pow((double) Math.abs(fArr[0]), d7));
        fArr[1] = Math.signum(fArr[1]) * ((float) Math.pow((double) Math.abs(fArr[1]), d7));
        fArr[2] = Math.signum(fArr[2]) * ((float) Math.pow((double) Math.abs(fArr[2]), d7));
        d.g(e, fArr);
        return fArr;
    }

    @Override // c0.c
    public final float b(int i7) {
        return i7 == 0 ? 1.0f : 0.5f;
    }

    @Override // c0.c
    public final float c(int i7) {
        return i7 == 0 ? 0.0f : -0.5f;
    }

    @Override // c0.c
    public final long e(float f7, float f8, float f9) {
        float W = d.W(f7, 0.0f, 1.0f);
        float W2 = d.W(f8, -0.5f, 0.5f);
        float W3 = d.W(f9, -0.5f, 0.5f);
        float[] fArr = f2485g;
        float h7 = d.h(fArr, W, W2, W3);
        float i7 = d.i(fArr, W, W2, W3);
        float j7 = d.j(fArr, W, W2, W3);
        float f10 = h7 * h7 * h7;
        float f11 = i7 * i7 * i7;
        float f12 = j7 * j7 * j7;
        float[] fArr2 = f2484f;
        return (((long) Float.floatToIntBits(d.h(fArr2, f10, f11, f12))) << 32) | (4294967295L & ((long) Float.floatToIntBits(d.i(fArr2, f10, f11, f12))));
    }

    @Override // c0.c
    public final float[] f(float[] fArr) {
        fArr[0] = d.W(fArr[0], 0.0f, 1.0f);
        fArr[1] = d.W(fArr[1], -0.5f, 0.5f);
        fArr[2] = d.W(fArr[2], -0.5f, 0.5f);
        d.g(f2485g, fArr);
        float f7 = fArr[0];
        fArr[0] = f7 * f7 * f7;
        float f8 = fArr[1];
        fArr[1] = f8 * f8 * f8;
        float f9 = fArr[2];
        fArr[2] = f9 * f9 * f9;
        d.g(f2484f, fArr);
        return fArr;
    }

    @Override // c0.c
    public final float g(float f7, float f8, float f9) {
        float W = d.W(f7, 0.0f, 1.0f);
        float W2 = d.W(f8, -0.5f, 0.5f);
        float W3 = d.W(f9, -0.5f, 0.5f);
        float[] fArr = f2485g;
        float h7 = d.h(fArr, W, W2, W3);
        float i7 = d.i(fArr, W, W2, W3);
        float j7 = d.j(fArr, W, W2, W3);
        float f10 = j7 * j7 * j7;
        return d.j(f2484f, h7 * h7 * h7, i7 * i7 * i7, f10);
    }

    @Override // c0.c
    public final long h(float f7, float f8, float f9, float f10, c cVar) {
        h.f(cVar, "colorSpace");
        float[] fArr = f2483d;
        float h7 = d.h(fArr, f7, f8, f9);
        float i7 = d.i(fArr, f7, f8, f9);
        float j7 = d.j(fArr, f7, f8, f9);
        double d7 = (double) 0.33333334f;
        float signum = Math.signum(h7) * ((float) Math.pow((double) Math.abs(h7), d7));
        float signum2 = Math.signum(i7) * ((float) Math.pow((double) Math.abs(i7), d7));
        float signum3 = Math.signum(j7) * ((float) Math.pow((double) Math.abs(j7), d7));
        float[] fArr2 = e;
        return e.a(d.h(fArr2, signum, signum2, signum3), d.i(fArr2, signum, signum2, signum3), d.j(fArr2, signum, signum2, signum3), f10, cVar);
    }
}
