package j3;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import k3.l;
import p2.f;

/* loaded from: classes.dex */
public final class a implements f {

    /* renamed from: b */
    public final int f4575b;

    /* renamed from: c */
    public final f f4576c;

    public a(int i7, f fVar) {
        this.f4575b = i7;
        this.f4576c = fVar;
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        this.f4576c.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f4575b).array());
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f4575b == aVar.f4575b && this.f4576c.equals(aVar.f4576c);
        }
        return false;
    }

    @Override // p2.f
    public final int hashCode() {
        return l.g(this.f4575b, this.f4576c);
    }
}
