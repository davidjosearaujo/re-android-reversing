package m1;

import a0.e;
import h1.f;
import i1.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f5041f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5042g;

    public b(e eVar, int i7) {
        this.f5041f = eVar;
        this.f5042g = i7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.f5041f;
        int i7 = this.f5042g;
        f.e eVar2 = ((e.a) eVar).f4471j0;
        if (eVar2 != null) {
            eVar2.c(i7);
        }
    }
}
