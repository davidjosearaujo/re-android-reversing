package a5;

import a5.s;
import java.io.IOException;

/* loaded from: classes.dex */
public final class h extends z4.d {

    /* renamed from: g */
    public final /* synthetic */ int f184g;

    /* renamed from: h */
    public final /* synthetic */ i6.d f185h;

    /* renamed from: i */
    public final /* synthetic */ int f186i;

    /* renamed from: j */
    public final /* synthetic */ d f187j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d dVar, Object[] objArr, int i7, i6.d dVar2, int i8, boolean z6) {
        super("OkHttp %s Push Data[%s]", objArr);
        this.f187j = dVar;
        this.f184g = i7;
        this.f185h = dVar2;
        this.f186i = i8;
    }

    @Override // z4.d
    public final void a() {
        try {
            s.a aVar = this.f187j.f153o;
            i6.d dVar = this.f185h;
            int i7 = this.f186i;
            aVar.getClass();
            dVar.skip(i7);
            this.f187j.f160w.v(this.f184g, a.CANCEL);
            synchronized (this.f187j) {
                this.f187j.f161x.remove(Integer.valueOf(this.f184g));
            }
        } catch (IOException unused) {
        }
    }
}
