package p2;

import java.security.MessageDigest;
import k3.b;
import p2.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h implements f {

    /* renamed from: b */
    public final b f5569b = new b();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        int i7 = 0;
        while (true) {
            b bVar = this.f5569b;
            if (i7 < bVar.f5221h) {
                g gVar = (g) bVar.h(i7);
                V l6 = this.f5569b.l(i7);
                g.b<T> bVar2 = gVar.f5566b;
                if (gVar.f5568d == null) {
                    gVar.f5568d = gVar.f5567c.getBytes(f.f5564a);
                }
                bVar2.a(gVar.f5568d, l6, messageDigest);
                i7++;
            } else {
                return;
            }
        }
    }

    public final <T> T c(g<T> gVar) {
        return this.f5569b.containsKey(gVar) ? (T) this.f5569b.getOrDefault(gVar, null) : gVar.f5565a;
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f5569b.equals(((h) obj).f5569b);
        }
        return false;
    }

    @Override // p2.f
    public final int hashCode() {
        return this.f5569b.hashCode();
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("Options{values=");
        d7.append(this.f5569b);
        d7.append('}');
        return d7.toString();
    }
}
