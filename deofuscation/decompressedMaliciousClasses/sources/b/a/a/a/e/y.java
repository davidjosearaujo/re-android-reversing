package b.a.a.a.e;

import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.q0;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class y implements q0, i0 {
    private static short[] $ = {5661, 5685, 5685, 5693, 5686, 5695, 5659, 5674, 5683, 5655, 5691, 5684, 5691, 5693, 5695, 5672, 247, 192, 198, 192, 204, 211, 192, 193, 133, 203, 208, 201, 201, 133, 215, 192, 214, 213, 202, 203, 214, 192, 133, 195, 215, 202, 200, 133, 202, 203, 246, 204, 194, 203, 236, 203, 246, 208, 198, 198, 192, 214, 214};

    /* renamed from: a */
    private final a.f f188a;

    /* renamed from: b */
    private final f<?> f189b;
    private k c = null;
    private Set<Scope> d = null;
    private boolean e = false;
    final /* synthetic */ t f;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public y(t tVar, a.f fVar, f<?> fVar2) {
        this.f = tVar;
        this.f188a = fVar;
        this.f189b = fVar2;
    }

    public final void h() {
        k kVar;
        if (this.e && (kVar = this.c) != null) {
            this.f188a.b(kVar, this.d);
        }
    }

    @Override // b.a.a.a.e.i0
    public final void a(k kVar, Set<Scope> set) {
        if (kVar == null || set == null) {
            Log.wtf($(0, 16, 5722), $(16, 59, 165), new Exception());
            c(new b.a.a.a.c.a(4));
            return;
        }
        this.c = kVar;
        this.d = set;
        h();
    }

    @Override // com.google.android.gms.common.internal.q0
    public final void b(b.a.a.a.c.a aVar) {
        this.f.m.post(new z(this, aVar));
    }

    @Override // b.a.a.a.e.i0
    public final void c(b.a.a.a.c.a aVar) {
        ((v) this.f.i.get(this.f189b)).n(aVar);
    }
}
