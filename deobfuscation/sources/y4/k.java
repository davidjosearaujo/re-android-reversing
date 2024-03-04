package y4;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    public final String f6741a;

    /* renamed from: b */
    public final List<Certificate> f6742b;

    /* renamed from: c */
    public final List<Certificate> f6743c;

    public k(String str, List<Certificate> list, List<Certificate> list2) {
        this.f6741a = str;
        this.f6742b = list;
        this.f6743c = list2;
    }

    public static k a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            try {
                certificateArr = sSLSession.getPeerCertificates();
            } catch (SSLPeerUnverifiedException unused) {
                certificateArr = null;
            }
            List f7 = certificateArr != null ? z4.h.f(certificateArr) : Collections.emptyList();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            return new k(cipherSuite, f7, localCertificates != null ? z4.h.f(localCertificates) : Collections.emptyList());
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            return this.f6741a.equals(kVar.f6741a) && this.f6742b.equals(kVar.f6742b) && this.f6743c.equals(kVar.f6743c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f6742b.hashCode();
        return this.f6743c.hashCode() + ((hashCode + ((this.f6741a.hashCode() + 527) * 31)) * 31);
    }
}
