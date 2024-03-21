package b.a.a.a.e;

import a.a.a.d.a;
import b.a.a.a.g.d;
import com.google.android.gms.common.api.m;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final a<f<?>, b.a.a.a.c.a> f151a;

    /* renamed from: b  reason: collision with root package name */
    private final d<Void> f152b;
    private int c;
    private boolean d;

    public final void a(f<?> fVar, b.a.a.a.c.a aVar) {
        this.f151a.put(fVar, aVar);
        this.c--;
        if (!aVar.h()) {
            this.d = true;
        }
        if (this.c != 0) {
            return;
        }
        if (this.d) {
            this.f152b.b(new m(this.f151a));
            return;
        }
        this.f152b.c(null);
    }

    public final Set<f<?>> b() {
        return this.f151a.keySet();
    }
}
