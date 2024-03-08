package y0;

import androidx.constraintlayout.widget.ConstraintLayout;
import z0.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class j extends i {

    /* renamed from: u0 */
    public int f6585u0 = 0;

    /* renamed from: v0 */
    public int f6586v0 = 0;

    /* renamed from: w0 */
    public int f6587w0 = 0;

    /* renamed from: x0 */
    public int f6588x0 = 0;

    /* renamed from: y0 */
    public int f6589y0 = 0;

    /* renamed from: z0 */
    public int f6590z0 = 0;
    public boolean A0 = false;
    public int B0 = 0;
    public int C0 = 0;
    public b.a D0 = new b.a();
    public b.AbstractC0136b E0 = null;

    public void S(int i7, int i8, int i9, int i10) {
    }

    public final void T(d dVar, int i7, int i8, int i9, int i10) {
        b.AbstractC0136b bVar;
        d dVar2;
        while (true) {
            bVar = this.E0;
            if (bVar != null || (dVar2 = this.W) == null) {
                break;
            }
            this.E0 = ((e) dVar2).f6554w0;
        }
        b.a aVar = this.D0;
        aVar.f6854a = i7;
        aVar.f6855b = i9;
        aVar.f6856c = i8;
        aVar.f6857d = i10;
        ((ConstraintLayout.b) bVar).b(dVar, aVar);
        dVar.O(this.D0.e);
        dVar.L(this.D0.f6858f);
        b.a aVar2 = this.D0;
        dVar.F = aVar2.f6860h;
        int i11 = aVar2.f6859g;
        dVar.f6517d0 = i11;
        dVar.F = i11 > 0;
    }

    @Override // y0.i, y0.h
    public final void a() {
        for (int i7 = 0; i7 < this.f6584t0; i7++) {
            d dVar = this.f6583s0[i7];
            if (dVar != null) {
                dVar.H = true;
            }
        }
    }
}
