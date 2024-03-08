package a6;

import g5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class l0 extends u {

    /* renamed from: k */
    public static final /* synthetic */ int f306k = 0;

    /* renamed from: h */
    public long f307h;

    /* renamed from: i */
    public boolean f308i;

    /* renamed from: j */
    public h<g0<?>> f309j;

    public final void W(boolean z6) {
        long j7 = this.f307h - (z6 ? 4294967296L : 1);
        this.f307h = j7;
        if (j7 <= 0 && this.f308i) {
            shutdown();
        }
    }

    public final void X(g0<?> g0Var) {
        h<g0<?>> hVar = this.f309j;
        if (hVar == null) {
            hVar = new h<>();
            this.f309j = hVar;
        }
        hVar.addLast(g0Var);
    }

    public final void Y(boolean z6) {
        this.f307h = (z6 ? 4294967296L : 1) + this.f307h;
        if (!z6) {
            this.f308i = true;
        }
    }

    public final boolean Z() {
        return this.f307h >= 4294967296L;
    }

    public long a0() {
        return !b0() ? Long.MAX_VALUE : 0;
    }

    public final boolean b0() {
        h<g0<?>> hVar = this.f309j;
        if (hVar == null) {
            return false;
        }
        g0<?> removeFirst = hVar.isEmpty() ? null : hVar.removeFirst();
        if (removeFirst == null) {
            return false;
        }
        removeFirst.run();
        return true;
    }

    public void shutdown() {
    }
}
