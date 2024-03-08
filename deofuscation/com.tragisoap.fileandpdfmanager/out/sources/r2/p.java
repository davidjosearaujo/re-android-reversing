package r2;

import java.security.MessageDigest;
import java.util.Map;
import k3.b;
import p2.f;
import p2.h;
import p2.l;
import q2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p implements f {

    /* renamed from: b  reason: collision with root package name */
    public final Object f5845b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5846c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5847d;
    public final Class<?> e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f5848f;

    /* renamed from: g  reason: collision with root package name */
    public final f f5849g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Class<?>, l<?>> f5850h;

    /* renamed from: i  reason: collision with root package name */
    public final h f5851i;

    /* renamed from: j  reason: collision with root package name */
    public int f5852j;

    public p(Object obj, f fVar, int i7, int i8, b bVar, Class cls, Class cls2, h hVar) {
        a.i(obj);
        this.f5845b = obj;
        if (fVar != null) {
            this.f5849g = fVar;
            this.f5846c = i7;
            this.f5847d = i8;
            a.i(bVar);
            this.f5850h = bVar;
            if (cls != null) {
                this.e = cls;
                if (cls2 != null) {
                    this.f5848f = cls2;
                    a.i(hVar);
                    this.f5851i = hVar;
                    return;
                }
                throw new NullPointerException("Transcode class must not be null");
            }
            throw new NullPointerException("Resource class must not be null");
        }
        throw new NullPointerException("Signature must not be null");
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f5845b.equals(pVar.f5845b) && this.f5849g.equals(pVar.f5849g) && this.f5847d == pVar.f5847d && this.f5846c == pVar.f5846c && this.f5850h.equals(pVar.f5850h) && this.e.equals(pVar.e) && this.f5848f.equals(pVar.f5848f) && this.f5851i.equals(pVar.f5851i);
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
