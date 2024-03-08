package k4;

import g6.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends i {

    /* renamed from: g  reason: collision with root package name */
    public float f4719g = -1.0f;

    public d() {
        super(6);
    }

    @Override // g6.i
    public final void f(float f7, float f8, l lVar) {
        lVar.e(f8 * f7, 180.0f, 90.0f);
        double d7 = (double) f8;
        double d8 = (double) f7;
        lVar.d((float) (Math.sin(Math.toRadians((double) 90.0f)) * d7 * d8), (float) (Math.sin(Math.toRadians((double) 0.0f)) * d7 * d8));
    }
}
