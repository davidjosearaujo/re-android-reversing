package d6;

import a6.u0;
import i5.d;
import j5.a;
import k5.c;
import k5.e;
@e(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {372, 379, 382}, m = "collect$suspendImpl")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v<T> extends c {

    /* renamed from: i  reason: collision with root package name */
    public u f3744i;

    /* renamed from: j  reason: collision with root package name */
    public d f3745j;

    /* renamed from: k  reason: collision with root package name */
    public w f3746k;

    /* renamed from: l  reason: collision with root package name */
    public u0 f3747l;
    public /* synthetic */ Object m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ u<T> f3748n;

    /* renamed from: o  reason: collision with root package name */
    public int f3749o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u<T> uVar, d<? super v> dVar) {
        super(dVar);
        this.f3748n = uVar;
    }

    @Override // k5.a
    public final Object s(Object obj) {
        this.m = obj;
        this.f3749o |= Integer.MIN_VALUE;
        u.j(this.f3748n, null, this);
        return a.f4591f;
    }
}
