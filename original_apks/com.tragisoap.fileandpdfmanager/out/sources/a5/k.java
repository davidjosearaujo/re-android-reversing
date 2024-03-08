package a5;

import a5.d;
import java.io.IOException;
import z4.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k extends d {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ t f192g;

    /* renamed from: h  reason: collision with root package name */
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
