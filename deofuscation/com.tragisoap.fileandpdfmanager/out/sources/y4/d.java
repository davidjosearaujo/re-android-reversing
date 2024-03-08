package y4;

import b5.a;
import b5.g;
import d5.b;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.Deque;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final p f6701a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6702b;

    /* renamed from: c  reason: collision with root package name */
    public r f6703c;

    /* renamed from: d  reason: collision with root package name */
    public g f6704d;

    public d(p pVar, r rVar) {
        SSLSocketFactory sSLSocketFactory;
        p pVar2 = new p(pVar);
        if (pVar2.f6771l == null) {
            pVar2.f6771l = ProxySelector.getDefault();
        }
        if (pVar2.m == null) {
            pVar2.m = CookieHandler.getDefault();
        }
        if (pVar2.f6772n == null) {
            pVar2.f6772n = SocketFactory.getDefault();
        }
        if (pVar2.f6773o == null) {
            synchronized (pVar) {
                if (p.C == null) {
                    try {
                        SSLContext instance = SSLContext.getInstance("TLS");
                        instance.init(null, null, null);
                        p.C = instance.getSocketFactory();
                    } catch (GeneralSecurityException unused) {
                        throw new AssertionError();
                    }
                }
                sSLSocketFactory = p.C;
            }
            pVar2.f6773o = sSLSocketFactory;
        }
        if (pVar2.f6774p == null) {
            pVar2.f6774p = b.f3647a;
        }
        if (pVar2.f6775q == null) {
            pVar2.f6775q = e.f6705b;
        }
        if (pVar2.f6776r == null) {
            pVar2.f6776r = a.f2374a;
        }
        if (pVar2.s == null) {
            pVar2.s = h.f6723g;
        }
        if (pVar2.f6767h == null) {
            pVar2.f6767h = p.A;
        }
        if (pVar2.f6768i == null) {
            pVar2.f6768i = p.B;
        }
        if (pVar2.f6777t == null) {
            pVar2.f6777t = j.f6740a;
        }
        this.f6701a = pVar2;
        this.f6703c = rVar;
    }

    public final s a() {
        synchronized (this) {
            try {
                if (!this.f6702b) {
                    this.f6702b = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            v.d dVar = this.f6701a.f6765f;
            synchronized (dVar) {
                ((Deque) dVar.e).add(this);
            }
            s b2 = b();
            v.d dVar2 = this.f6701a.f6765f;
            synchronized (dVar2) {
                try {
                    if (!((Deque) dVar2.e).remove(this)) {
                        throw new AssertionError("Call wasn't in-flight!");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return b2;
        } catch (Throwable th3) {
            v.d dVar3 = this.f6701a.f6765f;
            synchronized (dVar3) {
                try {
                    if (((Deque) dVar3.e).remove(this)) {
                        throw th3;
                    }
                    throw new AssertionError("Call wasn't in-flight!");
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c0, code lost:
        if (r8.equals("HEAD") == false) goto L_0x0104;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final y4.s b() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.d.b():y4.s");
    }
}
