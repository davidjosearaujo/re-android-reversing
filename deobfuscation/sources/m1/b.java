package m1;

import h1.f;
import i1.e;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ a0.e f5041f;

    /* renamed from: g */
    public final /* synthetic */ int f5042g;

    public b(a0.e eVar, int i7) {
        this.f5041f = eVar;
        this.f5042g = i7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a0.e eVar = this.f5041f;
        int i7 = this.f5042g;
        f.e eVar2 = ((e.a) eVar).f4471j0;
        if (eVar2 != null) {
            eVar2.c(i7);
        }
    }
}
