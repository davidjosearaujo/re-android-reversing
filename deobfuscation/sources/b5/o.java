package b5;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import y4.j;
import y4.u;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a */
    public final y4.a f2438a;

    /* renamed from: b */
    public final q.d f2439b;

    /* renamed from: c */
    public Proxy f2440c;

    /* renamed from: d */
    public List<Proxy> f2441d;
    public int e;

    /* renamed from: g */
    public int f2443g;

    /* renamed from: f */
    public List<InetSocketAddress> f2442f = Collections.emptyList();

    /* renamed from: h */
    public final ArrayList f2444h = new ArrayList();

    public o(y4.a aVar, q.d dVar) {
        this.f2441d = Collections.emptyList();
        this.f2438a = aVar;
        this.f2439b = dVar;
        y4.m mVar = aVar.f6677a;
        Proxy proxy = aVar.f6683h;
        if (proxy != null) {
            this.f2441d = Collections.singletonList(proxy);
        } else {
            this.f2441d = new ArrayList();
            List<Proxy> select = aVar.f6682g.select(mVar.o());
            if (select != null) {
                this.f2441d.addAll(select);
            }
            this.f2441d.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.f2441d.add(Proxy.NO_PROXY);
        }
        this.e = 0;
    }

    public final void a(u uVar, IOException iOException) {
        y4.a aVar;
        ProxySelector proxySelector;
        if (uVar.f6819b.type() != Proxy.Type.DIRECT && (proxySelector = (aVar = this.f2438a).f6682g) != null) {
            proxySelector.connectFailed(aVar.f6677a.o(), uVar.f6819b.address(), iOException);
        }
        q.d dVar = this.f2439b;
        synchronized (dVar) {
            ((Set) dVar.f5602b).add(uVar);
        }
    }

    public final u b() {
        boolean contains;
        String str;
        int i7;
        if (!(this.f2443g < this.f2442f.size())) {
            if (!(this.e < this.f2441d.size())) {
                if (!this.f2444h.isEmpty()) {
                    return (u) this.f2444h.remove(0);
                }
                throw new NoSuchElementException();
            }
            if (!(this.e < this.f2441d.size())) {
                StringBuilder d7 = androidx.activity.h.d("No route to ");
                d7.append(this.f2438a.f6677a.f6750d);
                d7.append("; exhausted proxy configurations: ");
                d7.append(this.f2441d);
                throw new SocketException(d7.toString());
            }
            List<Proxy> list = this.f2441d;
            int i8 = this.e;
            this.e = i8 + 1;
            Proxy proxy = list.get(i8);
            this.f2442f = new ArrayList();
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                y4.m mVar = this.f2438a.f6677a;
                str = mVar.f6750d;
                i7 = mVar.e;
            } else {
                SocketAddress address = proxy.address();
                if (!(address instanceof InetSocketAddress)) {
                    StringBuilder d8 = androidx.activity.h.d("Proxy.address() is not an InetSocketAddress: ");
                    d8.append(address.getClass());
                    throw new IllegalArgumentException(d8.toString());
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                InetAddress address2 = inetSocketAddress.getAddress();
                str = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
                i7 = inetSocketAddress.getPort();
            }
            if (i7 < 1 || i7 > 65535) {
                throw new SocketException("No route to " + str + ":" + i7 + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f2442f.add(InetSocketAddress.createUnresolved(str, i7));
            } else {
                ((j.a) this.f2438a.f6678b).getClass();
                if (str == null) {
                    throw new UnknownHostException("hostname == null");
                }
                List asList = Arrays.asList(InetAddress.getAllByName(str));
                int size = asList.size();
                for (int i9 = 0; i9 < size; i9++) {
                    this.f2442f.add(new InetSocketAddress((InetAddress) asList.get(i9), i7));
                }
            }
            this.f2443g = 0;
            this.f2440c = proxy;
        }
        if (!(this.f2443g < this.f2442f.size())) {
            StringBuilder d9 = androidx.activity.h.d("No route to ");
            d9.append(this.f2438a.f6677a.f6750d);
            d9.append("; exhausted inet socket addresses: ");
            d9.append(this.f2442f);
            throw new SocketException(d9.toString());
        }
        List<InetSocketAddress> list2 = this.f2442f;
        int i10 = this.f2443g;
        this.f2443g = i10 + 1;
        u uVar = new u(this.f2438a, this.f2440c, list2.get(i10));
        q.d dVar = this.f2439b;
        synchronized (dVar) {
            contains = ((Set) dVar.f5602b).contains(uVar);
        }
        if (contains) {
            this.f2444h.add(uVar);
            return b();
        }
        return uVar;
    }
}
