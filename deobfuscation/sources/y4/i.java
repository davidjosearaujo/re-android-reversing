package y4;

import androidx.fragment.app.s0;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class i {
    public static final i e;

    /* renamed from: f */
    public static final i f6730f;

    /* renamed from: g */
    public static final i f6731g;

    /* renamed from: a */
    public final boolean f6732a;

    /* renamed from: b */
    public final boolean f6733b;

    /* renamed from: c */
    public final String[] f6734c;

    /* renamed from: d */
    public final String[] f6735d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public boolean f6736a;

        /* renamed from: b */
        public String[] f6737b;

        /* renamed from: c */
        public String[] f6738c;

        /* renamed from: d */
        public boolean f6739d;

        public a(i iVar) {
            this.f6736a = iVar.f6732a;
            this.f6737b = iVar.f6734c;
            this.f6738c = iVar.f6735d;
            this.f6739d = iVar.f6733b;
        }

        public a(boolean z6) {
            this.f6736a = z6;
        }

        public final void a(String... strArr) {
            if (!this.f6736a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f6737b = (String[]) strArr.clone();
        }

        public final void b(String... strArr) {
            if (!this.f6736a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f6738c = (String[]) strArr.clone();
        }

        public final void c(v... vVarArr) {
            if (!this.f6736a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[vVarArr.length];
            for (int i7 = 0; i7 < vVarArr.length; i7++) {
                strArr[i7] = vVarArr[i7].f6826f;
            }
            b(strArr);
        }
    }

    static {
        g[] gVarArr = {g.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, g.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, g.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, g.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, g.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, g.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, g.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, g.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, g.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, g.TLS_RSA_WITH_AES_128_GCM_SHA256, g.TLS_RSA_WITH_AES_128_CBC_SHA, g.TLS_RSA_WITH_AES_256_CBC_SHA, g.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        a aVar = new a(true);
        String[] strArr = new String[13];
        for (int i7 = 0; i7 < 13; i7++) {
            strArr[i7] = gVarArr[i7].f6722f;
        }
        aVar.a(strArr);
        v vVar = v.f6823i;
        aVar.c(v.f6821g, v.f6822h, vVar);
        if (!aVar.f6736a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        aVar.f6739d = true;
        i iVar = new i(aVar);
        e = iVar;
        a aVar2 = new a(iVar);
        aVar2.c(vVar);
        if (!aVar2.f6736a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        aVar2.f6739d = true;
        f6730f = new i(aVar2);
        f6731g = new i(new a(false));
    }

    public i(a aVar) {
        this.f6732a = aVar.f6736a;
        this.f6734c = aVar.f6737b;
        this.f6735d = aVar.f6738c;
        this.f6733b = aVar.f6739d;
    }

    public static boolean b(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                byte[] bArr = z4.h.f6955a;
                if (Arrays.asList(strArr2).contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (this.f6732a) {
            String[] strArr = this.f6735d;
            if (strArr == null || b(strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f6734c;
                return strArr2 == null || b(strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            if (obj == this) {
                return true;
            }
            i iVar = (i) obj;
            boolean z6 = this.f6732a;
            if (z6 != iVar.f6732a) {
                return false;
            }
            return !z6 || (Arrays.equals(this.f6734c, iVar.f6734c) && Arrays.equals(this.f6735d, iVar.f6735d) && this.f6733b == iVar.f6733b);
        }
        return false;
    }

    public final int hashCode() {
        if (this.f6732a) {
            return ((((527 + Arrays.hashCode(this.f6734c)) * 31) + Arrays.hashCode(this.f6735d)) * 31) + (!this.f6733b ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        String str;
        v vVar;
        List f7;
        if (this.f6732a) {
            String[] strArr = this.f6734c;
            List list = null;
            String str2 = "[all enabled]";
            int i7 = 0;
            if (strArr != null) {
                if (strArr == null) {
                    f7 = null;
                } else {
                    g[] gVarArr = new g[strArr.length];
                    int i8 = 0;
                    while (true) {
                        String[] strArr2 = this.f6734c;
                        if (i8 >= strArr2.length) {
                            break;
                        }
                        String str3 = strArr2[i8];
                        if (str3.startsWith("SSL_")) {
                            StringBuilder d7 = androidx.activity.h.d("TLS_");
                            d7.append(str3.substring(4));
                            str3 = d7.toString();
                        }
                        gVarArr[i8] = g.valueOf(str3);
                        i8++;
                    }
                    f7 = z4.h.f(gVarArr);
                }
                str = f7.toString();
            } else {
                str = "[all enabled]";
            }
            String[] strArr3 = this.f6735d;
            if (strArr3 != null) {
                if (strArr3 != null) {
                    v[] vVarArr = new v[strArr3.length];
                    while (true) {
                        String[] strArr4 = this.f6735d;
                        if (i7 < strArr4.length) {
                            String str4 = strArr4[i7];
                            str4.getClass();
                            str4.hashCode();
                            char c7 = 65535;
                            switch (str4.hashCode()) {
                                case -503070503:
                                    if (str4.equals("TLSv1.1")) {
                                        c7 = 0;
                                        break;
                                    }
                                    break;
                                case -503070502:
                                    if (str4.equals("TLSv1.2")) {
                                        c7 = 1;
                                        break;
                                    }
                                    break;
                                case 79201641:
                                    if (str4.equals("SSLv3")) {
                                        c7 = 2;
                                        break;
                                    }
                                    break;
                                case 79923350:
                                    if (str4.equals("TLSv1")) {
                                        c7 = 3;
                                        break;
                                    }
                                    break;
                            }
                            switch (c7) {
                                case 0:
                                    vVar = v.f6822h;
                                    break;
                                case 1:
                                    vVar = v.f6821g;
                                    break;
                                case 2:
                                    vVar = v.f6824j;
                                    break;
                                case 3:
                                    vVar = v.f6823i;
                                    break;
                                default:
                                    throw new IllegalArgumentException(s0.h("Unexpected TLS version: ", str4));
                            }
                            vVarArr[i7] = vVar;
                            i7++;
                        } else {
                            list = z4.h.f(vVarArr);
                        }
                    }
                }
                str2 = list.toString();
            }
            return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.f6733b + ")";
        }
        return "ConnectionSpec()";
    }
}
