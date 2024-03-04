package b6;

import q5.l;
import r5.i;

/* loaded from: classes.dex */
public final class d extends i implements l<Throwable, f5.g> {

    /* renamed from: g */
    public final /* synthetic */ e f2452g;

    /* renamed from: h */
    public final /* synthetic */ Runnable f2453h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, c cVar) {
        super(1);
        this.f2452g = eVar;
        this.f2453h = cVar;
    }

    @Override // q5.l
    public final f5.g k(Throwable th) {
        this.f2452g.f2454h.removeCallbacks(this.f2453h);
        return f5.g.f4141a;
    }
}
