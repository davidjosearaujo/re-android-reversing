package r2;

import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
public final class p implements p2.f {

    /* renamed from: b */
    public final Object f5845b;

    /* renamed from: c */
    public final int f5846c;

    /* renamed from: d */
    public final int f5847d;
    public final Class<?> e;

    /* renamed from: f */
    public final Class<?> f5848f;

    /* renamed from: g */
    public final p2.f f5849g;

    /* renamed from: h */
    public final Map<Class<?>, p2.l<?>> f5850h;

    /* renamed from: i */
    public final p2.h f5851i;

    /* renamed from: j */
    public int f5852j;

    public p(Object obj, p2.f fVar, int i7, int i8, k3.b bVar, Class cls, Class cls2, p2.h hVar) {
        q2.a.i(obj);
        this.f5845b = obj;
        if (fVar == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.f5849g = fVar;
        this.f5846c = i7;
        this.f5847d = i8;
        q2.a.i(bVar);
        this.f5850h = bVar;
        if (cls == null) {
            throw new NullPointerException("Resource class must not be null");
        }
        this.e = cls;
        if (cls2 == null) {
            throw new NullPointerException("Transcode class must not be null");
        }
        this.f5848f = cls2;
        q2.a.i(hVar);
        this.f5851i = hVar;
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            return this.f5845b.equals(pVar.f5845b) && this.f5849g.equals(pVar.f5849g) && this.f5847d == pVar.f5847d && this.f5846c == pVar.f5846c && this.f5850h.equals(pVar.f5850h) && this.e.equals(pVar.e) && this.f5848f.equals(pVar.f5848f) && this.f5851i.equals(pVar.f5851i);
        }
        return false;
    }

    @Override // p2.f
    public final int hashCode() {
        if (this.f5852j == 0) {
            int hashCode = this.f5845b.hashCode();
            this.f5852j = hashCode;
            int hashCode2 = ((((this.f5849g.hashCode() + (hashCode * 31)) * 31) + this.f5846c) * 31) + this.f5847d;
            this.f5852j = hashCode2;
            int hashCode3 = this.f5850h.hashCode() + (hashCode2 * 31);
            this.f5852j = hashCode3;
            int hashCode4 = this.e.hashCode() + (hashCode3 * 31);
            this.f5852j = hashCode4;
            int hashCode5 = this.f5848f.hashCode() + (hashCode4 * 31);
            this.f5852j = hashCode5;
            this.f5852j = this.f5851i.hashCode() + (hashCode5 * 31);
        }
        return this.f5852j;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("EngineKey{model=");
        d7.append(this.f5845b);
        d7.append(", width=");
        d7.append(this.f5846c);
        d7.append(", height=");
        d7.append(this.f5847d);
        d7.append(", resourceClass=");
        d7.append(this.e);
        d7.append(", transcodeClass=");
        d7.append(this.f5848f);
        d7.append(", signature=");
        d7.append(this.f5849g);
        d7.append(", hashCode=");
        d7.append(this.f5852j);
        d7.append(", transformations=");
        d7.append(this.f5850h);
        d7.append(", options=");
        d7.append(this.f5851i);
        d7.append('}');
        return d7.toString();
    }
}
