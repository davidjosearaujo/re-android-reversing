package androidx.compose.ui.platform;

import android.content.Context;

/* loaded from: classes.dex */
public final class i extends r5.i implements q5.l<p.l, Object> {

    /* renamed from: g */
    public final /* synthetic */ Context f1180g;

    /* renamed from: h */
    public final /* synthetic */ j f1181h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, j jVar) {
        super(1);
        this.f1180g = context;
        this.f1181h = jVar;
    }

    @Override // q5.l
    public final Object k(p.l lVar) {
        r5.h.f(lVar, "$this$DisposableEffect");
        this.f1180g.getApplicationContext().registerComponentCallbacks(this.f1181h);
        return new a0.b(this.f1180g, this.f1181h);
    }
}
