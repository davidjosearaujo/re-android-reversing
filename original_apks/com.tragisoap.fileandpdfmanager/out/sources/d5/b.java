package d5;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final b f3647a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f3648b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static ArrayList a(X509Certificate x509Certificate) {
        List<String> b2 = b(x509Certificate, 7);
        List<String> b7 = b(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(b7.size() + b2.size());
        arrayList.addAll(b2);
        arrayList.addAll(b7);
        return arrayList;
    }

    public static List<String> b(X509Certificate x509Certificate, int i7) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (!(list == null || list.size() < 2 || (num = (Integer) list.get(0)) == null || num.intValue() != i7 || (str = (String) list.get(1)) == null)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x018f, code lost:
        r15 = androidx.activity.h.d("Unexpected end of DN: ");
        r15.append(r3.f3641a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a1, code lost:
        throw new java.lang.IllegalStateException(r15.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c9, code lost:
        r0 = r0 + 1;
        r3.f3643c = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ce, code lost:
        if (r0 >= r3.f3642b) goto L_0x01d7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d4, code lost:
        if (r3.f3646g[r0] != ' ') goto L_0x01d7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01d7, code lost:
        r4 = r3.f3646g;
        r5 = r3.f3644d;
        r0 = new java.lang.String(r4, r5, r3.e - r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(java.lang.String r14, java.security.cert.X509Certificate r15) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.b.c(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    public static boolean d(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return c(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
