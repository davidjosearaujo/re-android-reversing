package y4;

import java.net.CookieHandler;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.Deque;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public final p f6701a;

    /* renamed from: b */
    public boolean f6702b;

    /* renamed from: c */
    public r f6703c;

    /* renamed from: d */
    public b5.g f6704d;

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
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, null);
                        p.C = sSLContext.getSocketFactory();
                    } catch (GeneralSecurityException unused) {
                        throw new AssertionError();
                    }
                }
                sSLSocketFactory = p.C;
            }
            pVar2.f6773o = sSLSocketFactory;
        }
        if (pVar2.f6774p == null) {
            pVar2.f6774p = d5.b.f3647a;
        }
        if (pVar2.f6775q == null) {
            pVar2.f6775q = e.f6705b;
        }
        if (pVar2.f6776r == null) {
            pVar2.f6776r = b5.a.f2374a;
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
            if (this.f6702b) {
                throw new IllegalStateException("Already Executed");
            }
            this.f6702b = true;
        }
        try {
            v.d dVar = this.f6701a.f6765f;
            synchronized (dVar) {
                ((Deque) dVar.e).add(this);
            }
            s b2 = b();
            v.d dVar2 = this.f6701a.f6765f;
            synchronized (dVar2) {
                if (!((Deque) dVar2.e).remove(this)) {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            }
            return b2;
        } catch (Throwable th) {
            v.d dVar3 = this.f6701a.f6765f;
            synchronized (dVar3) {
                if (((Deque) dVar3.e).remove(this)) {
                    throw th;
                }
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:430:0x00c0, code lost:
        if (r8.equals("HEAD") == false) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:440:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:497:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0151 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final y4.s b() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.d.b():y4.s");
    }
}
