package a5;

import a5.d;
import java.io.IOException;

/* loaded from: classes.dex */
public final class k extends z4.d {

    /* renamed from: g */
    public final /* synthetic */ t f192g;

    /* renamed from: h */
    public final /* synthetic */ d.e f193h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(d.e eVar, Object[] objArr, t tVar) {
        super("OkHttp %s ACK Settings", objArr);
        this.f193h = eVar;
        this.f192g = tVar;
    }

    @Override // z4.d
    public final void a() {
        try {
            d.this.f160w.r(this.f192g);
        } catch (IOException unused) {
        }
    }
}
