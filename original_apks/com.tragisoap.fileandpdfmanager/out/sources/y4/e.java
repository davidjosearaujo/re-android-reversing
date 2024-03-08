package y4;

import i6.g;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import z4.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f6705b = new e(new a());

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Set<g>> f6706a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap f6707a = new LinkedHashMap();
    }

    public e(a aVar) {
        LinkedHashMap linkedHashMap = aVar.f6707a;
        byte[] bArr = h.f6955a;
        this.f6706a = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
    }

    public static String b(X509Certificate x509Certificate) {
        if (x509Certificate instanceof X509Certificate) {
            StringBuilder d7 = androidx.activity.h.d("sha1/");
            d7.append(c(x509Certificate).a());
            return d7.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static g c(X509Certificate x509Certificate) {
        g d7 = g.d(x509Certificate.getPublicKey().getEncoded());
        byte[] bArr = h.f6955a;
        try {
            return g.d(MessageDigest.getInstance("SHA-1").digest((byte[]) d7.f4501f.clone()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public final void a(String str, ArrayList arrayList) {
        Set<g> set;
        Set<g> set2 = this.f6706a.get(str);
        int indexOf = str.indexOf(46);
        if (indexOf != str.lastIndexOf(46)) {
            Map<String, Set<g>> map = this.f6706a;
            StringBuilder d7 = androidx.activity.h.d("*.");
            d7.append(str.substring(indexOf + 1));
            set = map.get(d7.toString());
        } else {
            set = null;
        }
        if (set2 == null && set == null) {
            set2 = null;
        } else if (set2 != null && set != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll(set2);
            linkedHashSet.addAll(set);
            set2 = linkedHashSet;
        } else if (set2 == null) {
            set2 = set;
        }
        if (set2 != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (set2.contains(c((X509Certificate) arrayList.get(i7)))) {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size2 = arrayList.size();
            for (int i8 = 0; i8 < size2; i8++) {
                X509Certificate x509Certificate = (X509Certificate) arrayList.get(i8);
                sb.append("\n    ");
                sb.append(b(x509Certificate));
                sb.append(": ");
                sb.append(x509Certificate.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            for (g gVar : set2) {
                sb.append("\n    sha1/");
                sb.append(gVar.a());
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }
}
