package a5;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g extends z4.d {

    /* renamed from: g */
    public final /* synthetic */ int f182g;

    /* renamed from: h */
    public final /* synthetic */ d f183h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, Object[] objArr, int i7, ArrayList arrayList, boolean z6) {
        super("OkHttp %s Push Headers[%s]", objArr);
        this.f183h = dVar;
        this.f182g = i7;
    }

    @Override // z4.d
    public final void a() {
        this.f183h.f153o.getClass();
        try {
            this.f183h.f160w.v(this.f182g, a.CANCEL);
            synchronized (this.f183h) {
                this.f183h.f161x.remove(Integer.valueOf(this.f182g));
            }
        } catch (IOException unused) {
        }
    }
}
