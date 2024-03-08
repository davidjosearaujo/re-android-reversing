package y4;

import androidx.fragment.app.s0;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import y4.m;
import z4.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a */
    public final m f6677a;

    /* renamed from: b */
    public final j f6678b;

    /* renamed from: c */
    public final SocketFactory f6679c;

    /* renamed from: d */
    public final b f6680d;
    public final List<q> e;

    /* renamed from: f */
    public final List<i> f6681f;

    /* renamed from: g */
    public final ProxySelector f6682g;

    /* renamed from: h */
    public final Proxy f6683h;

    /* renamed from: i */
    public final SSLSocketFactory f6684i;

    /* renamed from: j */
    public final HostnameVerifier f6685j;

    /* renamed from: k */
    public final e f6686k;

    public a(String str, int i7, j jVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, e eVar, b bVar, Proxy proxy, List<q> list, List<i> list2, ProxySelector proxySelector) {
        m.a aVar = new m.a();
        String str2 = "https";
        String str3 = sSLSocketFactory != null ? str2 : "http";
        if (str3.equalsIgnoreCase("http")) {
            str2 = "http";
        } else if (!str3.equalsIgnoreCase(str2)) {
            throw new IllegalArgumentException(s0.h("unexpected scheme: ", str3));
        }
        aVar.f6754a = str2;
        if (str != null) {
            String b2 = m.a.b(0, str.length(), str);
            if (b2 != null) {
                aVar.f6757d = b2;
                if (i7 <= 0 || i7 > 65535) {
                    throw new IllegalArgumentException(s0.g("unexpected port: ", i7));
                }
                aVar.e = i7;
                this.f6677a = aVar.a();
                if (jVar != null) {
                    this.f6678b = jVar;
                    if (socketFactory != null) {
                        this.f6679c = socketFactory;
                        if (bVar != null) {
                            this.f6680d = bVar;
                            if (list != null) {
                                byte[] bArr = h.f6955a;
                                this.e = Collections.unmodifiableList(new ArrayList(list));
                                if (list2 != null) {
                                    this.f6681f = Collections.unmodifiableList(new ArrayList(list2));
                                    if (proxySelector != null) {
                                        this.f6682g = proxySelector;
                                        this.f6683h = proxy;
                                        this.f6684i = sSLSocketFactory;
                                        this.f6685j = hostnameVerifier;
                                        this.f6686k = eVar;
                                        return;
                                    }
                                    throw new IllegalArgumentException("proxySelector == null");
                                }
                                throw new IllegalArgumentException("connectionSpecs == null");
                            }
                            throw new IllegalArgumentException("protocols == null");
                        }
                        throw new IllegalArgumentException("authenticator == null");
                    }
                    throw new IllegalArgumentException("socketFactory == null");
                }
                throw new IllegalArgumentException("dns == null");
            }
            throw new IllegalArgumentException(s0.h("unexpected host: ", str));
        }
        throw new IllegalArgumentException("host == null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6677a.equals(aVar.f6677a) && this.f6678b.equals(aVar.f6678b) && this.f6680d.equals(aVar.f6680d) && this.e.equals(aVar.e) && this.f6681f.equals(aVar.f6681f) && this.f6682g.equals(aVar.f6682g) && h.d(this.f6683h, aVar.f6683h) && h.d(this.f6684i, aVar.f6684i) && h.d(this.f6685j, aVar.f6685j) && h.d(this.f6686k, aVar.f6686k);
    }

    public final int hashCode() {
        int hashCode = this.f6678b.hashCode();
        int hashCode2 = (this.f6682g.hashCode() + ((this.f6681f.hashCode() + ((this.e.hashCode() + ((this.f6680d.hashCode() + ((hashCode + ((this.f6677a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        Proxy proxy = this.f6683h;
        int i7 = 0;
        int hashCode3 = (hashCode2 + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f6684i;
        int hashCode4 = (hashCode3 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f6685j;
        int hashCode5 = (hashCode4 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        e eVar = this.f6686k;
        if (eVar != null) {
            i7 = eVar.hashCode();
        }
        return hashCode5 + i7;
    }
}
