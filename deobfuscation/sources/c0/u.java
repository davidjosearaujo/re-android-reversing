package c0;

/* loaded from: classes.dex */
public final class u extends c {
    public u() {
        super("Generic XYZ", b.f2463b, 14);
    }

    public static float i(float f7) {
        return w5.d.W(f7, -2.0f, 2.0f);
    }

    @Override // c0.c
    public final float[] a(float[] fArr) {
        fArr[0] = i(fArr[0]);
        fArr[1] = i(fArr[1]);
        fArr[2] = i(fArr[2]);
        return fArr;
    }

    @Override // c0.c
    public final float b(int i7) {
        return 2.0f;
    }

    @Override // c0.c
    public final float c(int i7) {
        return -2.0f;
    }

    @Override // c0.c
    public final long e(float f7, float f8, float f9) {
        float i7 = i(f7);
        float i8 = i(f8);
        return (Float.floatToIntBits(i8) & 4294967295L) | (Float.floatToIntBits(i7) << 32);
    }

    @Override // c0.c
    public final float[] f(float[] fArr) {
        fArr[0] = i(fArr[0]);
        fArr[1] = i(fArr[1]);
        fArr[2] = i(fArr[2]);
        return fArr;
    }

    @Override // c0.c
    public final float g(float f7, float f8, float f9) {
        return i(f9);
    }

    @Override // c0.c
    public final long h(float f7, float f8, float f9, float f10, c cVar) {
        r5.h.f(cVar, "colorSpace");
        return a0.e.a(i(f7), i(f8), i(f9), f10, cVar);
    }
}
