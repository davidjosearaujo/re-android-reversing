package y4;

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

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b */
    public static final e f6705b = new e(new a());

    /* renamed from: a */
    public final Map<String, Set<i6.g>> f6706a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final LinkedHashMap f6707a = new LinkedHashMap();
    }

    public e(a aVar) {
        LinkedHashMap linkedHashMap = aVar.f6707a;
        byte[] bArr = z4.h.f6955a;
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

    public static i6.g c(X509Certificate x509Certificate) {
        i6.g d7 = i6.g.d(x509Certificate.getPublicKey().getEncoded());
        byte[] bArr = z4.h.f6955a;
        try {
            return i6.g.d(MessageDigest.getInstance("SHA-1").digest((byte[]) d7.f4501f.clone()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public final void a(String str, ArrayList arrayList) {
        Set<i6.g> set;
        Set<i6.g> set2 = this.f6706a.get(str);
        int indexOf = str.indexOf(46);
        if (indexOf != str.lastIndexOf(46)) {
            Map<String, Set<i6.g>> map = this.f6706a;
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
        if (set2 == null) {
            return;
        }
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
        for (i6.g gVar : set2) {
            sb.append("\n    sha1/");
            sb.append(gVar.a());
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }
}
