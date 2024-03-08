package d6;

import a6.h;
import e6.b;
import e6.c;
import i5.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class w extends c<u<?>> {

    /* renamed from: a  reason: collision with root package name */
    public long f3750a = -1;

    /* renamed from: b  reason: collision with root package name */
    public h f3751b;

    @Override // e6.c
    public final boolean a(b bVar) {
        u uVar = (u) bVar;
        if (this.f3750a >= 0) {
            return false;
        }
        long j7 = uVar.f3736n;
        if (j7 < uVar.f3737o) {
            uVar.f3737o = j7;
        }
        this.f3750a = j7;
        return true;
    }

    @Override // e6.c
    public final d[] b(b bVar) {
        long j7 = this.f3750a;
        this.f3750a = -1;
        this.f3751b = null;
        return ((u) bVar).w(j7);
    }
}
