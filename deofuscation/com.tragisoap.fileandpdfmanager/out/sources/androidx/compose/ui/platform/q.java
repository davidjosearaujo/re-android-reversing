package androidx.compose.ui.platform;

import f5.g;
import q5.a;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q extends i implements a<g> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1233g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ androidx.savedstate.a f1234h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f1235i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(boolean z6, androidx.savedstate.a aVar, String str) {
        super(0);
        this.f1233g = z6;
        this.f1234h = aVar;
        this.f1235i = str;
    }

    @Override // q5.a
    public final g d() {
        if (this.f1233g) {
            androidx.savedstate.a aVar = this.f1234h;
            String str = this.f1235i;
            aVar.getClass();
            h.f(str, "key");
            aVar.f2292a.b(str);
        }
        return g.f4141a;
    }
}
