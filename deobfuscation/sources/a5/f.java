package a5;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f extends z4.d {

    /* renamed from: g */
    public final /* synthetic */ int f180g;

    /* renamed from: h */
    public final /* synthetic */ d f181h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, Object[] objArr, int i7, ArrayList arrayList) {
        super("OkHttp %s Push Request[%s]", objArr);
        this.f181h = dVar;
        this.f180g = i7;
    }

    @Override // z4.d
    public final void a() {
        this.f181h.f153o.getClass();
        try {
            this.f181h.f160w.v(this.f180g, a.CANCEL);
            synchronized (this.f181h) {
                this.f181h.f161x.remove(Integer.valueOf(this.f180g));
            }
        } catch (IOException unused) {
        }
    }
}
