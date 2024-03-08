package y4;

import a5.t;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import v.d;
import z4.b;
import z4.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p implements Cloneable {
    public static final List<q> A = h.f(q.f6787j, q.f6786i, q.f6785h);
    public static final List<i> B = h.f(i.e, i.f6730f, i.f6731g);
    public static SSLSocketFactory C;

    /* renamed from: f */
    public d f6765f;

    /* renamed from: g */
    public Proxy f6766g;

    /* renamed from: h */
    public List<q> f6767h;

    /* renamed from: i */
    public List<i> f6768i;

    /* renamed from: j */
    public final ArrayList f6769j;

    /* renamed from: k */
    public final ArrayList f6770k;

    /* renamed from: l */
    public ProxySelector f6771l;
    public CookieHandler m;

    /* renamed from: n */
    public SocketFactory f6772n;

    /* renamed from: o */
    public SSLSocketFactory f6773o;

    /* renamed from: p */
    public HostnameVerifier f6774p;

    /* renamed from: q */
    public e f6775q;

    /* renamed from: r */
    public b f6776r;
    public h s;

    /* renamed from: t */
    public j f6777t;

    /* renamed from: u */
    public boolean f6778u;

    /* renamed from: v */
    public boolean f6779v;

    /* renamed from: w */
    public boolean f6780w;

    /* renamed from: x */
    public int f6781x;

    /* renamed from: y */
    public int f6782y;

    /* renamed from: z */
    public int f6783z;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends b {
        public final c5.a a(h hVar, a aVar, b5.p pVar) {
            int i7;
            Iterator it = hVar.e.iterator();
            while (it.hasNext()) {
                c5.a aVar2 = (c5.a) it.next();
                int size = aVar2.f2574j.size();
                a5.d dVar = aVar2.f2570f;
                if (dVar != null) {
                    synchronized (dVar) {
                        t tVar = dVar.s;
                        i7 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                        if ((tVar.f267a & 16) != 0) {
                            i7 = tVar.f270d[4];
                        }
                    }
                } else {
                    i7 = 1;
                }
                if (size < i7 && aVar.equals(aVar2.f2566a.f6818a) && !aVar2.f2575k) {
                    pVar.getClass();
                    aVar2.f2574j.add(new WeakReference(pVar));
                    return aVar2;
                }
            }
            return null;
        }
    }

    static {
        b.f6935b = new a();
    }

    public p() {
        this.f6769j = new ArrayList();
        this.f6770k = new ArrayList();
        this.f6778u = true;
        this.f6779v = true;
        this.f6780w = true;
        this.f6781x = 10000;
        this.f6782y = 10000;
        this.f6783z = 10000;
        new LinkedHashSet();
        this.f6765f = new d(1);
    }

    public p(p pVar) {
        ArrayList arrayList = new ArrayList();
        this.f6769j = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f6770k = arrayList2;
        this.f6778u = true;
        this.f6779v = true;
        this.f6780w = true;
        this.f6781x = 10000;
        this.f6782y = 10000;
        this.f6783z = 10000;
        pVar.getClass();
        this.f6765f = pVar.f6765f;
        this.f6766g = pVar.f6766g;
        this.f6767h = pVar.f6767h;
        this.f6768i = pVar.f6768i;
        arrayList.addAll(pVar.f6769j);
        arrayList2.addAll(pVar.f6770k);
        this.f6771l = pVar.f6771l;
        this.m = pVar.m;
        pVar.getClass();
        this.f6772n = pVar.f6772n;
        this.f6773o = pVar.f6773o;
        this.f6774p = pVar.f6774p;
        this.f6775q = pVar.f6775q;
        this.f6776r = pVar.f6776r;
        this.s = pVar.s;
        this.f6777t = pVar.f6777t;
        this.f6778u = pVar.f6778u;
        this.f6779v = pVar.f6779v;
        this.f6780w = pVar.f6780w;
        this.f6781x = pVar.f6781x;
        this.f6782y = pVar.f6782y;
        this.f6783z = pVar.f6783z;
    }

    @Override // java.lang.Object
    public final Object clone() {
        return new p(this);
    }
}
