package y0;

import java.util.ArrayList;
import z0.o;

/* loaded from: classes.dex */
public class i extends d implements h {

    /* renamed from: s0 */
    public d[] f6583s0 = new d[4];

    /* renamed from: t0 */
    public int f6584t0 = 0;

    public final void R(int i7, o oVar, ArrayList arrayList) {
        for (int i8 = 0; i8 < this.f6584t0; i8++) {
            oVar.a(this.f6583s0[i8]);
        }
        for (int i9 = 0; i9 < this.f6584t0; i9++) {
            z0.i.a(this.f6583s0[i9], i7, arrayList, oVar);
        }
    }

    @Override // y0.h
    public void a() {
    }
}
