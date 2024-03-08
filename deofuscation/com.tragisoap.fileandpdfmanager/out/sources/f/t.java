package f;

import android.content.res.Resources;
import d3.b;
import d5.c;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.security.auth.x500.X500Principal;
import p2.d;
import p2.h;
import r2.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class t implements d, b, c {

    /* renamed from: f  reason: collision with root package name */
    public final Object f4019f;

    public /* synthetic */ t() {
        this.f4019f = new AtomicInteger(0);
    }

    public /* synthetic */ t(Resources resources) {
        this.f4019f = resources;
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
    public final v b(v vVar, h hVar) {
        Resources resources = (Resources) this.f4019f;
        if (vVar == null) {
            return null;
        }
        return new y2.d(resources, vVar);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 2, insn: 0x004d: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:23:0x004d
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    @Override // p2.d
    public final boolean c(
    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 2, insn: 0x004d: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:23:0x004d
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r5v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:233)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:209)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:162)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:364)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
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
        L_0x0014:
            r4 = 9
            if (r2 >= r4) goto L_0x00a7
            int r4 = r11.size()
            r5 = 1
            int r4 = r4 - r5
            java.lang.Object r4 = r11.get(r4)
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4
            java.lang.Object r6 = r10.f4019f
            d5.c r6 = (d5.c) r6
            java.security.cert.X509Certificate r6 = r6.a(r4)
            if (r6 == 0) goto L_0x005a
            int r3 = r11.size()
            if (r3 > r5) goto L_0x003a
            boolean r3 = r4.equals(r6)
            if (r3 != 0) goto L_0x003d
        L_0x003a:
            r11.add(r6)
        L_0x003d:
            java.security.Principal r3 = r6.getIssuerDN()
            java.security.Principal r4 = r6.getSubjectDN()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x004d
        L_0x004b:
            r3 = r1
            goto L_0x0055
        L_0x004d:
            java.security.PublicKey r3 = r6.getPublicKey()     // Catch: GeneralSecurityException -> 0x004b
            r6.verify(r3)     // Catch: GeneralSecurityException -> 0x004b
            r3 = r5
        L_0x0055:
            if (r3 == 0) goto L_0x0058
            return r11
        L_0x0058:
            r3 = r5
            goto L_0x008a
        L_0x005a:
            java.util.Iterator r6 = r0.iterator()
        L_0x005e:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x008d
            java.lang.Object r7 = r6.next()
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7
            java.security.Principal r8 = r4.getIssuerDN()
            java.security.Principal r9 = r7.getSubjectDN()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x007a
        L_0x0078:
            r8 = r1
            goto L_0x0082
        L_0x007a:
            java.security.PublicKey r8 = r7.getPublicKey()     // Catch: GeneralSecurityException -> 0x0078
            r4.verify(r8)     // Catch: GeneralSecurityException -> 0x0078
            r8 = r5
        L_0x0082:
            if (r8 == 0) goto L_0x005e
            r6.remove()
            r11.add(r7)
        L_0x008a:
            int r2 = r2 + 1
            goto L_0x0014
        L_0x008d:
            if (r3 == 0) goto L_0x0090
            return r11
        L_0x0090:
            javax.net.ssl.SSLPeerUnverifiedException r10 = new javax.net.ssl.SSLPeerUnverifiedException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Failed to find a trusted cert that signed "
            r11.append(r0)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x00a7:
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
