package b.a.a.a.e;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.AbstractC0005a;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class f<O extends a.AbstractC0005a> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f147a = false;

    /* renamed from: b  reason: collision with root package name */
    private final int f148b;
    private final a<O> c;
    private final O d;

    private f(a<O> aVar, O o) {
        this.c = aVar;
        this.d = o;
        this.f148b = Arrays.hashCode(new Object[]{aVar, o});
    }

    public static <O extends a.AbstractC0005a> f<O> a(a<O> aVar, O o) {
        return new f<>(aVar, o);
    }

    public final String b() {
        return this.c.a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return !this.f147a && !fVar.f147a && v.a(this.c, fVar.c) && v.a(this.d, fVar.d);
    }

    public final int hashCode() {
        return this.f148b;
    }
}
