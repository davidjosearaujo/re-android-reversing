package p;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class n0 implements d5.c {

    /* renamed from: f */
    public final Object f5443f;

    /* renamed from: g */
    public final Object f5444g;

    public n0(int i7) {
        if (i7 == 3) {
            this.f5443f = new q.e(new Reference[16]);
            this.f5444g = new ReferenceQueue();
        } else if (i7 != 4) {
            this.f5443f = new AtomicReference(t.e.f5997a);
            this.f5444g = new Object();
        } else {
            this.f5443f = new AtomicReference();
            this.f5444g = new o.b();
        }
    }

    @Override // d5.c
    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            TrustAnchor trustAnchor = (TrustAnchor) ((Method) this.f5444g).invoke((X509TrustManager) this.f5443f, x509Certificate);
            if (trustAnchor != null) {
                return trustAnchor.getTrustedCert();
            }
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InvocationTargetException unused2) {
        }
        return null;
    }

    public final Object b() {
        t.d dVar = (t.d) ((AtomicReference) this.f5443f).get();
        int a7 = dVar.a(Thread.currentThread().getId());
        if (a7 >= 0) {
            return dVar.f5996c[a7];
        }
        return null;
    }

    public n0(X509TrustManager x509TrustManager, Method method) {
        this.f5444g = method;
        this.f5443f = x509TrustManager;
    }

    public n0(q.e eVar, l0.p pVar) {
        this.f5443f = eVar;
        this.f5444g = pVar;
    }
}
