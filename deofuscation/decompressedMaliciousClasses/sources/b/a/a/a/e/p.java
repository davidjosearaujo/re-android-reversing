package b.a.a.a.e;

import b.a.a.a.g.d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.j;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class p {

    /* renamed from: a */
    private final Map<l<?>, Boolean> f169a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b */
    private final Map<d<?>, Boolean> f170b = Collections.synchronizedMap(new WeakHashMap());

    private final void c(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f169a) {
            hashMap = new HashMap(this.f169a);
        }
        synchronized (this.f170b) {
            hashMap2 = new HashMap(this.f170b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((l) entry.getKey()).k(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((d) entry2.getKey()).d(new b(status));
            }
        }
    }

    public final void b(l<? extends j> lVar, boolean z) {
        this.f169a.put(lVar, Boolean.valueOf(z));
        lVar.b(new q(this, lVar));
    }

    public final boolean d() {
        return !this.f169a.isEmpty() || !this.f170b.isEmpty();
    }

    public final void e() {
        c(false, t.n);
    }

    public final void f() {
        c(true, l0.f166a);
    }
}
