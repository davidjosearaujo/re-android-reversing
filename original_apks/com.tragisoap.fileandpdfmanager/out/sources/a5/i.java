package a5;

import z4.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i extends d {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f188g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ d f189h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d dVar, Object[] objArr, int i7, a aVar) {
        super("OkHttp %s Push Reset[%s]", objArr);
        this.f189h = dVar;
        this.f188g = i7;
    }

    @Override // z4.d
    public final void a() {
        this.f189h.f153o.getClass();
        synchronized (this.f189h) {
            this.f189h.f161x.remove(Integer.valueOf(this.f188g));
        }
    }
}