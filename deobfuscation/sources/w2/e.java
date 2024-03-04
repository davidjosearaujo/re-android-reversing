package w2;

import java.io.InputStream;
import java.net.URL;
import p2.h;
import v2.f;
import v2.n;
import v2.o;
import v2.r;

/* loaded from: classes.dex */
public final class e implements n<URL, InputStream> {

    /* renamed from: a */
    public final n<f, InputStream> f6398a;

    /* loaded from: classes.dex */
    public static class a implements o<URL, InputStream> {
        @Override // v2.o
        public final n<URL, InputStream> b(r rVar) {
            return new e(rVar.b(f.class, InputStream.class));
        }
    }

    public e(n<f, InputStream> nVar) {
        this.f6398a = nVar;
    }

    @Override // v2.n
    public final n.a<InputStream> a(URL url, int i7, int i8, h hVar) {
        return this.f6398a.a(new f(url), i7, i8, hVar);
    }

    @Override // v2.n
    public final /* bridge */ /* synthetic */ boolean b(URL url) {
        return true;
    }
}
