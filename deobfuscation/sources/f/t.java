package f;

import android.content.res.Resources;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class t implements p2.d, d3.b, d5.c {

    /* renamed from: f */
    public final Object f4019f;

    public /* synthetic */ t() {
        this.f4019f = new AtomicInteger(0);
    }

    public /* synthetic */ t(Object obj) {
        this.f4019f = obj;
    }

    public /* synthetic */ t(X509Certificate[] x509CertificateArr) {
        this.f4019f = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            List list = (List) ((Map) this.f4019f).get(subjectX500Principal);
            if (list == null) {
                list = new ArrayList(1);
                ((Map) this.f4019f).put(subjectX500Principal, list);
            }
            list.add(x509Certificate);
        }
    }

    @Override // d5.c
    public final X509Certificate a(X509Certificate x509Certificate) {
        List<X509Certificate> list = (List) ((Map) this.f4019f).get(x509Certificate.getIssuerX500Principal());
        if (list == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : list) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // d3.b
    public final r2.v b(r2.v vVar, p2.h hVar) {
        Resources resources = (Resources) this.f4019f;
        if (vVar == null) {
            return null;
        }
        return new y2.d(resources, vVar);
    }

    @Override // p2.d
    public final boolean c(Object obj, File file, p2.h hVar) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = (InputStream) obj;
        byte[] bArr = (byte[]) ((s2.b) this.f4019f).c(65536, byte[].class);
        boolean z6 = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        ((s2.b) this.f4019f).put(bArr);
                        return z6;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        ((s2.b) this.f4019f).put(bArr);
                        throw th;
                    }
                }
                fileOutputStream.close();
                z6 = true;
                fileOutputStream.close();
            } catch (IOException e7) {
                e = e7;
            }
            ((s2.b) this.f4019f).put(bArr);
            return z6;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0084 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.ArrayList e(java.util.List r11) {
        /*
            r10 = this;
            java.util.ArrayDeque r0 = new java.util.ArrayDeque
            r0.<init>(r11)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.lang.Object r1 = r0.removeFirst()
            r11.add(r1)
            r1 = 0
            r2 = r1
            r3 = r2
        L14:
            r4 = 9
            if (r2 >= r4) goto La7
            int r4 = r11.size()
            r5 = 1
            int r4 = r4 - r5
            java.lang.Object r4 = r11.get(r4)
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4
            java.lang.Object r6 = r10.f4019f
            d5.c r6 = (d5.c) r6
            java.security.cert.X509Certificate r6 = r6.a(r4)
            if (r6 == 0) goto L5a
            int r3 = r11.size()
            if (r3 > r5) goto L3a
            boolean r3 = r4.equals(r6)
            if (r3 != 0) goto L3d
        L3a:
            r11.add(r6)
        L3d:
            java.security.Principal r3 = r6.getIssuerDN()
            java.security.Principal r4 = r6.getSubjectDN()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L4d
        L4b:
            r3 = r1
            goto L55
        L4d:
            java.security.PublicKey r3 = r6.getPublicKey()     // Catch: java.security.GeneralSecurityException -> L4b
            r6.verify(r3)     // Catch: java.security.GeneralSecurityException -> L4b
            r3 = r5
        L55:
            if (r3 == 0) goto L58
            return r11
        L58:
            r3 = r5
            goto L8a
        L5a:
            java.util.Iterator r6 = r0.iterator()
        L5e:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L8d
            java.lang.Object r7 = r6.next()
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7
            java.security.Principal r8 = r4.getIssuerDN()
            java.security.Principal r9 = r7.getSubjectDN()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L7a
        L78:
            r8 = r1
            goto L82
        L7a:
            java.security.PublicKey r8 = r7.getPublicKey()     // Catch: java.security.GeneralSecurityException -> L78
            r4.verify(r8)     // Catch: java.security.GeneralSecurityException -> L78
            r8 = r5
        L82:
            if (r8 == 0) goto L5e
            r6.remove()
            r11.add(r7)
        L8a:
            int r2 = r2 + 1
            goto L14
        L8d:
            if (r3 == 0) goto L90
            return r11
        L90:
            javax.net.ssl.SSLPeerUnverifiedException r10 = new javax.net.ssl.SSLPeerUnverifiedException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Failed to find a trusted cert that signed "
            r11.append(r0)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        La7:
            javax.net.ssl.SSLPeerUnverifiedException r10 = new javax.net.ssl.SSLPeerUnverifiedException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Certificate chain too long: "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: f.t.e(java.util.List):java.util.ArrayList");
    }
}
