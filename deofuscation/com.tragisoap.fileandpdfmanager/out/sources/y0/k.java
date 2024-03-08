package y0;

import java.util.ArrayList;
import w0.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class k extends d {

    /* renamed from: s0  reason: collision with root package name */
    public ArrayList<d> f6591s0 = new ArrayList<>();

    @Override // y0.d
    public void D() {
        this.f6591s0.clear();
        super.D();
    }

    @Override // y0.d
    public final void G(c cVar) {
        super.G(cVar);
        int size = this.f6591s0.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f6591s0.get(i7).G(cVar);
        }
    }

    public void R() {
        ArrayList<d> arrayList = this.f6591s0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                d dVar = this.f6591s0.get(i7);
                if (dVar instanceof k) {
                    ((k) dVar).R();
                }
            }
        }
    }
}
