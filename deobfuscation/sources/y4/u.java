package y4;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a */
    public final a f6818a;

    /* renamed from: b */
    public final Proxy f6819b;

    /* renamed from: c */
    public final InetSocketAddress f6820c;

    public u(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f6818a = aVar;
        this.f6819b = proxy;
        this.f6820c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f6818a.equals(uVar.f6818a) && this.f6819b.equals(uVar.f6819b) && this.f6820c.equals(uVar.f6820c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f6819b.hashCode();
        return this.f6820c.hashCode() + ((hashCode + ((this.f6818a.hashCode() + 527) * 31)) * 31);
    }
}
