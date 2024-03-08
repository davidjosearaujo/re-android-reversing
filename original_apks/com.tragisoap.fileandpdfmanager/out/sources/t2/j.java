package t2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import k3.i;
import k3.l;
import l3.a;
import l3.d;
import p2.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final i<f, String> f6059a = new i<>(1000);

    /* renamed from: b  reason: collision with root package name */
    public final a.c f6060b = l3.a.a(10, new a());

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements a.b<b> {
        @Override // l3.a.b
        public final b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b implements a.d {

        /* renamed from: f  reason: collision with root package name */
        public final MessageDigest f6061f;

        /* renamed from: g  reason: collision with root package name */
        public final d.a f6062g = new d.a();

        public b(MessageDigest messageDigest) {
            this.f6061f = messageDigest;
        }

        @Override // l3.a.d
        public final d.a d() {
            return this.f6062g;
        }
    }

    public final String a(f fVar) {
        String a7;
        synchronized (this.f6059a) {
            a7 = this.f6059a.a(fVar);
        }
        if (a7 == null) {
            Object b2 = this.f6060b.b();
            q2.a.i(b2);
            b bVar = (b) b2;
            try {
                fVar.a(bVar.f6061f);
                byte[] digest = bVar.f6061f.digest();
                char[] cArr = l.f4713b;
                synchronized (cArr) {
                    for (int i7 = 0; i7 < digest.length; i7++) {
                        int i8 = digest[i7] & 255;
                        int i9 = i7 * 2;
                        char[] cArr2 = l.f4712a;
                        cArr[i9] = cArr2[i8 >>> 4];
                        cArr[i9 + 1] = cArr2[i8 & 15];
                    }
                    a7 = new String(cArr);
                }
            } finally {
                this.f6060b.a(bVar);
            }
        }
        synchronized (this.f6059a) {
            this.f6059a.d(fVar, a7);
        }
        return a7;
    }
}
