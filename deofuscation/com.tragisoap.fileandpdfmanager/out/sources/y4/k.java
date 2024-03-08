package y4;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import z4.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final String f6741a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Certificate> f6742b;

    /* renamed from: c  reason: collision with root package name */
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
            List f7 = certificateArr != null ? h.f(certificateArr) : Collections.emptyList();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            return new k(cipherSuite, f7, localCertificates != null ? h.f(localCertificates) : Collections.emptyList());
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f6741a.equals(kVar.f6741a) && this.f6742b.equals(kVar.f6742b) && this.f6743c.equals(kVar.f6743c);
    }

    public final int hashCode() {
        int hashCode = this.f6742b.hashCode();
        return this.f6743c.hashCode() + ((hashCode + ((this.f6741a.hashCode() + 527) * 31)) * 31);
    }
}
