package j3;

import androidx.activity.h;
import java.security.MessageDigest;
import p2.f;
import q2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d implements f {

    /* renamed from: b  reason: collision with root package name */
    public final Object f4579b;

    public d(Object obj) {
        a.i(obj);
        this.f4579b = obj;
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(this.f4579b.toString().getBytes(f.f5564a));
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f4579b.equals(((d) obj).f4579b);
        }
        return false;
    }

    @Override // p2.f
    public final int hashCode() {
        return this.f4579b.hashCode();
    }

    public final String toString() {
        StringBuilder d7 = h.d("ObjectKey{object=");
        d7.append(this.f4579b);
        d7.append('}');
        return d7.toString();
    }
}
