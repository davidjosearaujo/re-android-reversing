package c5;

import a5.d;
import b5.d;
import b5.j;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import d5.b;
import d5.c;
import f.t;
import i6.p;
import i6.r;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import y4.e;
import y4.i;
import y4.k;
import y4.m;
import y4.q;
import y4.r;
import y4.s;
import y4.u;
import z4.f;
import z4.h;

/* loaded from: classes.dex */
public final class a {
    public static SSLSocketFactory m;

    /* renamed from: n */
    public static c f2565n;

    /* renamed from: a */
    public final u f2566a;

    /* renamed from: b */
    public Socket f2567b;

    /* renamed from: c */
    public Socket f2568c;

    /* renamed from: d */
    public k f2569d;
    public q e;

    /* renamed from: f */
    public volatile d f2570f;

    /* renamed from: g */
    public int f2571g;

    /* renamed from: h */
    public r f2572h;

    /* renamed from: i */
    public i6.q f2573i;

    /* renamed from: k */
    public boolean f2575k;

    /* renamed from: j */
    public final ArrayList f2574j = new ArrayList();

    /* renamed from: l */
    public long f2576l = Long.MAX_VALUE;

    public a(u uVar) {
        this.f2566a = uVar;
    }

    public static synchronized c b(SSLSocketFactory sSLSocketFactory) {
        c cVar;
        synchronized (a.class) {
            if (sSLSocketFactory != m) {
                f fVar = f.f6940a;
                f2565n = fVar.g(fVar.f(sSLSocketFactory));
                m = sSLSocketFactory;
            }
            cVar = f2565n;
        }
        return cVar;
    }

    public final void a(int i7, int i8, int i9, z4.a aVar) {
        int b2;
        SSLSocket sSLSocket;
        q qVar = q.f6785h;
        this.f2567b.setSoTimeout(i8);
        try {
            f.f6940a.c(this.f2567b, this.f2566a.f6820c, i7);
            this.f2572h = p.a(p.c(this.f2567b));
            this.f2573i = new i6.q(p.b(this.f2567b));
            u uVar = this.f2566a;
            if (uVar.f6818a.f6684i != null) {
                if (uVar.f6819b.type() == Proxy.Type.HTTP) {
                    r.a aVar2 = new r.a();
                    m mVar = this.f2566a.f6818a.f6677a;
                    if (mVar == null) {
                        throw new IllegalArgumentException("url == null");
                    }
                    aVar2.f6795a = mVar;
                    aVar2.f6797c.e("Host", h.e(mVar));
                    aVar2.f6797c.e("Proxy-Connection", "Keep-Alive");
                    aVar2.f6797c.e("User-Agent", "okhttp/2.7.5");
                    y4.r a7 = aVar2.a();
                    m mVar2 = a7.f6790a;
                    StringBuilder d7 = androidx.activity.h.d("CONNECT ");
                    d7.append(mVar2.f6750d);
                    d7.append(":");
                    d7.append(mVar2.e);
                    d7.append(" HTTP/1.1");
                    String sb = d7.toString();
                    do {
                        i6.r rVar = this.f2572h;
                        b5.d dVar = new b5.d(null, rVar, this.f2573i);
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        rVar.c().g(i8, timeUnit);
                        this.f2573i.c().g(i9, timeUnit);
                        dVar.k(a7.f6792c, sb);
                        dVar.d();
                        s.a j5 = dVar.j();
                        j5.f6809a = a7;
                        s a8 = j5.a();
                        j.a aVar3 = j.f2428a;
                        long a9 = j.a(a8.f6803f);
                        if (a9 == -1) {
                            a9 = 0;
                        }
                        d.e h7 = dVar.h(a9);
                        h.i(h7, SubsamplingScaleImageView.TILE_SIZE_AUTO, timeUnit);
                        h7.close();
                        int i10 = a8.f6801c;
                        if (i10 != 200) {
                            if (i10 != 407) {
                                StringBuilder d8 = androidx.activity.h.d("Unexpected response code for CONNECT: ");
                                d8.append(a8.f6801c);
                                throw new IOException(d8.toString());
                            }
                            u uVar2 = this.f2566a;
                            a7 = j.c(uVar2.f6818a.f6680d, a8, uVar2.f6819b);
                        } else if (!this.f2572h.f4526f.x() || !this.f2573i.f4523f.x()) {
                            throw new IOException("TLS tunnel buffered too many bytes!");
                        }
                    } while (a7 != null);
                    throw new IOException("Failed to authenticate with proxy");
                }
                y4.a aVar4 = this.f2566a.f6818a;
                SSLSocketFactory sSLSocketFactory = aVar4.f6684i;
                try {
                    try {
                        Socket socket = this.f2567b;
                        m mVar3 = aVar4.f6677a;
                        sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, mVar3.f6750d, mVar3.e, true);
                        try {
                            i a10 = aVar.a(sSLSocket);
                            if (a10.f6733b) {
                                f.f6940a.b(sSLSocket, aVar4.f6677a.f6750d, aVar4.e);
                            }
                            sSLSocket.startHandshake();
                            k a11 = k.a(sSLSocket.getSession());
                            if (!aVar4.f6685j.verify(aVar4.f6677a.f6750d, sSLSocket.getSession())) {
                                X509Certificate x509Certificate = (X509Certificate) a11.f6742b.get(0);
                                throw new SSLPeerUnverifiedException("Hostname " + aVar4.f6677a.f6750d + " not verified:\n    certificate: " + e.b(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + b.a(x509Certificate));
                            }
                            if (aVar4.f6686k != e.f6705b) {
                                aVar4.f6686k.a(aVar4.f6677a.f6750d, new t(b(aVar4.f6684i)).e(a11.f6742b));
                            }
                            String d9 = a10.f6733b ? f.f6940a.d(sSLSocket) : null;
                            this.f2568c = sSLSocket;
                            this.f2572h = p.a(p.c(sSLSocket));
                            this.f2573i = new i6.q(p.b(this.f2568c));
                            this.f2569d = a11;
                            if (d9 != null) {
                                qVar = q.a(d9);
                            }
                            this.e = qVar;
                            f.f6940a.a(sSLSocket);
                        } catch (AssertionError e) {
                            e = e;
                            if (!h.h(e)) {
                                throw e;
                            }
                            throw new IOException(e);
                        } catch (Throwable th) {
                            th = th;
                            if (sSLSocket != null) {
                                f.f6940a.a(sSLSocket);
                            }
                            h.c(sSLSocket);
                            throw th;
                        }
                    } catch (AssertionError e7) {
                        e = e7;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sSLSocket = null;
                }
            } else {
                this.e = qVar;
                this.f2568c = this.f2567b;
            }
            q qVar2 = this.e;
            if (qVar2 == q.f6786i || qVar2 == q.f6787j) {
                this.f2568c.setSoTimeout(0);
                d.c cVar = new d.c();
                Socket socket2 = this.f2568c;
                String str = this.f2566a.f6818a.f6677a.f6750d;
                i6.r rVar2 = this.f2572h;
                i6.q qVar3 = this.f2573i;
                cVar.f168a = socket2;
                cVar.f169b = str;
                cVar.f170c = rVar2;
                cVar.f171d = qVar3;
                cVar.e = this.e;
                a5.d dVar2 = new a5.d(cVar);
                dVar2.f160w.y();
                dVar2.f160w.w(dVar2.f156r);
                if (dVar2.f156r.b() != 65536) {
                    dVar2.f160w.L(0, b2 - 65536);
                }
                this.f2570f = dVar2;
            }
        } catch (ConnectException unused) {
            StringBuilder d10 = androidx.activity.h.d("Failed to connect to ");
            d10.append(this.f2566a.f6820c);
            throw new ConnectException(d10.toString());
        }
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("Connection{");
        d7.append(this.f2566a.f6818a.f6677a.f6750d);
        d7.append(":");
        d7.append(this.f2566a.f6818a.f6677a.e);
        d7.append(", proxy=");
        d7.append(this.f2566a.f6819b);
        d7.append(" hostAddress=");
        d7.append(this.f2566a.f6820c);
        d7.append(" cipherSuite=");
        k kVar = this.f2569d;
        d7.append(kVar != null ? kVar.f6741a : "none");
        d7.append(" protocol=");
        d7.append(this.e);
        d7.append('}');
        return d7.toString();
    }
}
