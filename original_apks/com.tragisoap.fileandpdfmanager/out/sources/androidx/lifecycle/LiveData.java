package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.m;
import androidx.fragment.app.x;
import androidx.lifecycle.g;
import java.util.Map;
import l.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class LiveData<T> {

    /* renamed from: j */
    public static final Object f1823j = new Object();

    /* renamed from: d */
    public boolean f1827d;
    public volatile Object e;

    /* renamed from: f */
    public volatile Object f1828f;

    /* renamed from: h */
    public boolean f1830h;

    /* renamed from: i */
    public boolean f1831i;

    /* renamed from: a */
    public final Object f1824a = new Object();

    /* renamed from: b */
    public l.b<s<? super T>, LiveData<T>.b> f1825b = new l.b<>();

    /* renamed from: c */
    public int f1826c = 0;

    /* renamed from: g */
    public int f1829g = -1;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.b implements l {
        public LifecycleBoundObserver() {
            throw null;
        }

        @Override // androidx.lifecycle.l
        public final void c(n nVar, g.a aVar) {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData.b
        public final void d() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData.b
        public final boolean e() {
            throw null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends LiveData<T>.b {
        public a(LiveData liveData, m.d dVar) {
            super(dVar);
        }

        @Override // androidx.lifecycle.LiveData.b
        public final boolean e() {
            return true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public abstract class b {

        /* renamed from: f */
        public final s<? super T> f1832f;

        /* renamed from: g */
        public boolean f1833g;

        /* renamed from: h */
        public int f1834h = -1;

        public b(m.d dVar) {
            LiveData.this = r1;
            this.f1832f = dVar;
        }

        public final void a(boolean z6) {
            if (z6 != this.f1833g) {
                this.f1833g = z6;
                LiveData liveData = LiveData.this;
                int i7 = z6 ? 1 : -1;
                int i8 = liveData.f1826c;
                liveData.f1826c = i7 + i8;
                if (!liveData.f1827d) {
                    liveData.f1827d = true;
                    while (true) {
                        try {
                            int i9 = liveData.f1826c;
                            if (i8 == i9) {
                                break;
                            }
                            boolean z7 = i8 == 0 && i9 > 0;
                            boolean z8 = i8 > 0 && i9 == 0;
                            if (z7) {
                                liveData.e();
                            } else if (z8) {
                                liveData.f();
                            }
                            i8 = i9;
                        } finally {
                            liveData.f1827d = false;
                        }
                    }
                }
                if (this.f1833g) {
                    LiveData.this.c(this);
                }
            }
        }

        public void d() {
        }

        public abstract boolean e();
    }

    public LiveData() {
        Object obj = f1823j;
        this.f1828f = obj;
        this.e = obj;
    }

    public static void a(String str) {
        k.b.p().f4608f.getClass();
        if (!(Looper.getMainLooper().getThread() == Thread.currentThread())) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    public final void b(LiveData<T>.b bVar) {
        if (bVar.f1833g) {
            if (!bVar.e()) {
                bVar.a(false);
                return;
            }
            int i7 = bVar.f1834h;
            int i8 = this.f1829g;
            if (i7 < i8) {
                bVar.f1834h = i8;
                s<? super T> sVar = bVar.f1832f;
                Object obj = this.e;
                m.d dVar = (m.d) sVar;
                dVar.getClass();
                if (((n) obj) != null) {
                    m mVar = m.this;
                    if (mVar.f1682d0) {
                        View M = mVar.M();
                        if (M.getParent() != null) {
                            throw new IllegalStateException("DialogFragment can not be attached to a container view");
                        } else if (m.this.f1686h0 != null) {
                            if (x.K(3)) {
                                Log.d("FragmentManager", "DialogFragment " + dVar + " setting the content view on " + m.this.f1686h0);
                            }
                            m.this.f1686h0.setContentView(M);
                        }
                    }
                }
            }
        }
    }

    public final void c(LiveData<T>.b bVar) {
        if (this.f1830h) {
            this.f1831i = true;
            return;
        }
        this.f1830h = true;
        do {
            this.f1831i = false;
            if (bVar == null) {
                l.b<s<? super T>, LiveData<T>.b> bVar2 = this.f1825b;
                bVar2.getClass();
                b.d dVar = new b.d();
                bVar2.f4831h.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((b) ((Map.Entry) dVar.next()).getValue());
                    if (this.f1831i) {
                        break;
                    }
                }
            } else {
                b(bVar);
                bVar = null;
            }
        } while (this.f1831i);
        this.f1830h = false;
    }

    public final void d(m.d dVar) {
        LiveData<T>.b bVar;
        a("observeForever");
        a aVar = new a(this, dVar);
        l.b<s<? super T>, LiveData<T>.b> bVar2 = this.f1825b;
        b.c<s<? super T>, LiveData<T>.b> a7 = bVar2.a(dVar);
        if (a7 != null) {
            bVar = a7.f4834g;
        } else {
            b.c<K, V> cVar = new b.c<>(dVar, aVar);
            bVar2.f4832i++;
            b.c cVar2 = (b.c<s<? super T>, LiveData<T>.b>) bVar2.f4830g;
            if (cVar2 == null) {
                bVar2.f4829f = cVar;
            } else {
                cVar2.f4835h = cVar;
                cVar.f4836i = cVar2;
            }
            bVar2.f4830g = cVar;
            bVar = null;
        }
        LiveData<T>.b bVar3 = bVar;
        if (bVar3 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (bVar3 == null) {
            aVar.a(true);
        }
    }

    public void e() {
    }

    public void f() {
    }

    public void g(s<? super T> sVar) {
        a("removeObserver");
        LiveData<T>.b b2 = this.f1825b.b(sVar);
        if (b2 != null) {
            b2.d();
            b2.a(false);
        }
    }
}
