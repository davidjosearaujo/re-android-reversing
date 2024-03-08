package z0;

import java.util.Iterator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class g extends f {
    public int m;

    public g(p pVar) {
        super(pVar);
        this.e = pVar instanceof l ? 2 : 3;
    }

    @Override // z0.f
    public final void d(int i7) {
        if (!this.f6880j) {
            this.f6880j = true;
            this.f6877g = i7;
            Iterator it = this.f6881k.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                dVar.a(dVar);
            }
        }
    }
}
