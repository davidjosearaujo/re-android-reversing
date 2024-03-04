package d6;

/* loaded from: classes.dex */
public final class w extends e6.c<u<?>> {

    /* renamed from: a */
    public long f3750a = -1;

    /* renamed from: b */
    public a6.h f3751b;

    @Override // e6.c
    public final boolean a(e6.b bVar) {
        u uVar = (u) bVar;
        if (this.f3750a >= 0) {
            return false;
        }
        long j5 = uVar.f3736n;
        if (j5 < uVar.f3737o) {
            uVar.f3737o = j5;
        }
        this.f3750a = j5;
        return true;
    }

    @Override // e6.c
    public final i5.d[] b(e6.b bVar) {
        long j5 = this.f3750a;
        this.f3750a = -1L;
        this.f3751b = null;
        return ((u) bVar).w(j5);
    }
}
