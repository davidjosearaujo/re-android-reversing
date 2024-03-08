package a5;

import java.io.IOException;
import z4.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends d {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f176g = true;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f177h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f178i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ d f179j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Object[] objArr, int i7, int i8) {
        super("OkHttp %s ping %08x%08x", objArr);
        this.f179j = dVar;
        this.f177h = i7;
        this.f178i = i8;
    }

    @Override // z4.d
    public final void a() {
        try {
            d dVar = this.f179j;
            boolean z6 = this.f176g;
            int i7 = this.f177h;
            int i8 = this.f178i;
            synchronized (dVar.f160w) {
                dVar.f160w.M(i7, i8, z6);
            }
        } catch (IOException unused) {
        }
    }
}
