package r2;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import k3.i;
import p2.f;
import p2.h;
import p2.l;
import s2.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class x implements f {

    /* renamed from: j  reason: collision with root package name */
    public static final i<Class<?>, byte[]> f5885j = new i<>(50);

    /* renamed from: b  reason: collision with root package name */
    public final b f5886b;

    /* renamed from: c  reason: collision with root package name */
    public final f f5887c;

    /* renamed from: d  reason: collision with root package name */
    public final f f5888d;
    public final int e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5889f;

    /* renamed from: g  reason: collision with root package name */
    public final Class<?> f5890g;

    /* renamed from: h  reason: collision with root package name */
    public final h f5891h;

    /* renamed from: i  reason: collision with root package name */
    public final l<?> f5892i;

    public x(b bVar, f fVar, f fVar2, int i7, int i8, l<?> lVar, Class<?> cls, h hVar) {
        this.f5886b = bVar;
        this.f5887c = fVar;
        this.f5888d = fVar2;
        this.e = i7;
        this.f5889f = i8;
        this.f5892i = lVar;
        this.f5890g = cls;
        this.f5891h = hVar;
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f5886b.d();
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f5889f).array();
        this.f5888d.a(messageDigest);
        this.f5887c.a(messageDigest);
        messageDigest.update(bArr);
        l<?> lVar = this.f5892i;
        if (lVar != null) {
            lVar.a(messageDigest);
        }
        this.f5891h.a(messageDigest);
        i<Class<?>, byte[]> iVar = f5885j;
        byte[] a7 = iVar.a(this.f5890g);
        if (a7 == null) {
            a7 = this.f5890g.getName().getBytes(f.f5564a);
            iVar.d(this.f5890g, a7);
        }
        messageDigest.update(a7);
        this.f5886b.put(bArr);
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f5889f == xVar.f5889f && this.e == xVar.e && k3.l.b(this.f5892i, xVar.f5892i) && this.f5890g.equals(xVar.f5890g) && this.f5887c.equals(xVar.f5887c) && this.f5888d.equals(xVar.f5888d) && this.f5891h.equals(xVar.f5891h);
    }

    @Override // p2.f
    public final int hashCode() {
        int hashCode = ((((this.f5888d.hashCode() + (this.f5887c.hashCode() * 31)) * 31) + this.e) * 31) + this.f5889f;
        l<?> lVar = this.f5892i;
        if (lVar != null) {
            hashCode = (hashCode * 31) + lVar.hashCode();
        }
        int hashCode2 = this.f5890g.hashCode();
        return this.f5891h.hashCode() + ((hashCode2 + (hashCode * 31)) * 31);
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("ResourceCacheKey{sourceKey=");
        d7.append(this.f5887c);
        d7.append(", signature=");
        d7.append(this.f5888d);
        d7.append(", width=");
        d7.append(this.e);
        d7.append(", height=");
        d7.append(this.f5889f);
        d7.append(", decodedResourceClass=");
        d7.append(this.f5890g);
        d7.append(", transformation='");
        d7.append(this.f5892i);
        d7.append('\'');
        d7.append(", options=");
        d7.append(this.f5891h);
        d7.append('}');
        return d7.toString();
    }
}
