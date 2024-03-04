package k4;

/* loaded from: classes.dex */
public final class d extends g6.i {

    /* renamed from: g */
    public float f4719g;

    public d() {
        super(6);
        this.f4719g = -1.0f;
    }

    @Override // g6.i
    public final void f(float f7, float f8, l lVar) {
        lVar.e(f8 * f7, 180.0f, 90.0f);
        double d7 = f8;
        double d8 = f7;
        lVar.d((float) (Math.sin(Math.toRadians(90.0f)) * d7 * d8), (float) (Math.sin(Math.toRadians(0.0f)) * d7 * d8));
    }
}
