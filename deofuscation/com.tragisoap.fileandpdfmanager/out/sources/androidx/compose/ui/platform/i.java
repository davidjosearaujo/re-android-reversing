package androidx.compose.ui.platform;

import a0.b;
import android.content.Context;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i extends r5.i implements l<p.l, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f1180g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ j f1181h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, j jVar) {
        super(1);
        this.f1180g = context;
        this.f1181h = jVar;
    }

    @Override // q5.l
    public final Object k(p.l lVar) {
        h.f(lVar, "$this$DisposableEffect");
        this.f1180g.getApplicationContext().registerComponentCallbacks(this.f1181h);
        return new b(this.f1180g, this.f1181h);
    }
}
