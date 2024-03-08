package a6;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class x0 extends z0 {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f344h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(u0 u0Var) {
        super(true);
        boolean z6 = true;
        U(u0Var);
        k kVar = (k) z0.f347g.get(this);
        l lVar = kVar instanceof l ? (l) kVar : null;
        z6 = false;
        if (lVar != null) {
            do {
                z0 r6 = lVar.r();
                if (r6.M()) {
                    break;
                }
                k kVar2 = (k) z0.f347g.get(r6);
                if (kVar2 instanceof l) {
                    lVar = (l) kVar2;
                    continue;
                } else {
                    lVar = null;
                    continue;
                }
            } while (lVar != null);
        }
        this.f344h = z6;
    }

    @Override // a6.z0
    public final boolean M() {
        return this.f344h;
    }

    @Override // a6.z0
    public final boolean O() {
        return true;
    }
}
