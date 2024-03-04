package r2;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class f implements p2.f {

    /* renamed from: b */
    public final p2.f f5741b;

    /* renamed from: c */
    public final p2.f f5742c;

    public f(p2.f fVar, p2.f fVar2) {
        this.f5741b = fVar;
        this.f5742c = fVar2;
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        this.f5741b.a(messageDigest);
        this.f5742c.a(messageDigest);
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f5741b.equals(fVar.f5741b) && this.f5742c.equals(fVar.f5742c);
        }
        return false;
    }

    @Override // p2.f
    public final int hashCode() {
        return this.f5742c.hashCode() + (this.f5741b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("DataCacheKey{sourceKey=");
        d7.append(this.f5741b);
        d7.append(", signature=");
        d7.append(this.f5742c);
        d7.append('}');
        return d7.toString();
    }
}
