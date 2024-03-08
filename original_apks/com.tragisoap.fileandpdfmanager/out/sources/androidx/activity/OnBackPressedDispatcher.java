package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.x;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import g5.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a */
    public final Runnable f383a;

    /* renamed from: b */
    public final o1.a<Boolean> f384b;

    /* renamed from: c */
    public final h<n> f385c;

    /* renamed from: d */
    public n f386d;
    public OnBackInvokedCallback e;

    /* renamed from: f */
    public OnBackInvokedDispatcher f387f;

    /* renamed from: g */
    public boolean f388g;

    /* renamed from: h */
    public boolean f389h;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class LifecycleOnBackPressedCancellable implements l, c {

        /* renamed from: f */
        public final g f390f;

        /* renamed from: g */
        public final n f391g;

        /* renamed from: h */
        public c f392h;

        /* renamed from: i */
        public final /* synthetic */ OnBackPressedDispatcher f393i;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, g gVar, x.c cVar) {
            r5.h.f(cVar, "onBackPressedCallback");
            this.f393i = onBackPressedDispatcher;
            this.f390f = gVar;
            this.f391g = cVar;
            gVar.a(this);
        }

        @Override // androidx.lifecycle.l
        public final void c(n nVar, g.a aVar) {
            if (aVar == g.a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = this.f393i;
                n nVar2 = this.f391g;
                onBackPressedDispatcher.getClass();
                r5.h.f(nVar2, "onBackPressedCallback");
                onBackPressedDispatcher.f385c.addLast(nVar2);
                c cVar = new c(nVar2);
                nVar2.f429b.add(cVar);
                onBackPressedDispatcher.d();
                nVar2.f430c = new v(onBackPressedDispatcher);
                this.f392h = cVar;
            } else if (aVar == g.a.ON_STOP) {
                c cVar2 = this.f392h;
                if (cVar2 != null) {
                    cVar2.cancel();
                }
            } else if (aVar == g.a.ON_DESTROY) {
                cancel();
            }
        }

        @Override // androidx.activity.c
        public final void cancel() {
            this.f390f.c(this);
            n nVar = this.f391g;
            nVar.getClass();
            nVar.f429b.remove(this);
            c cVar = this.f392h;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f392h = null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a */
        public static final a f394a = new a();

        public final OnBackInvokedCallback a(q5.a<f5.g> aVar) {
            r5.h.f(aVar, "onBackInvoked");
            return new t(0, aVar);
        }

        public final void b(Object obj, int i7, Object obj2) {
            r5.h.f(obj, "dispatcher");
            r5.h.f(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i7, (OnBackInvokedCallback) obj2);
        }

        public final void c(Object obj, Object obj2) {
            r5.h.f(obj, "dispatcher");
            r5.h.f(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: a */
        public static final b f395a = new b();

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a */
            public final /* synthetic */ q5.l<b, f5.g> f396a;

            /* renamed from: b */
            public final /* synthetic */ q5.l<b, f5.g> f397b;

            /* renamed from: c */
            public final /* synthetic */ q5.a<f5.g> f398c;

            /* renamed from: d */
            public final /* synthetic */ q5.a<f5.g> f399d;

            /* JADX WARN: Multi-variable type inference failed */
            public a(q5.l<? super b, f5.g> lVar, q5.l<? super b, f5.g> lVar2, q5.a<f5.g> aVar, q5.a<f5.g> aVar2) {
                this.f396a = lVar;
                this.f397b = lVar2;
                this.f398c = aVar;
                this.f399d = aVar2;
            }

            public final void onBackCancelled() {
                this.f399d.d();
            }

            public final void onBackInvoked() {
                this.f398c.d();
            }

            public final void onBackProgressed(BackEvent backEvent) {
                r5.h.f(backEvent, "backEvent");
                this.f397b.k(new b(backEvent));
            }

            public final void onBackStarted(BackEvent backEvent) {
                r5.h.f(backEvent, "backEvent");
                this.f396a.k(new b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(q5.l<? super b, f5.g> lVar, q5.l<? super b, f5.g> lVar2, q5.a<f5.g> aVar, q5.a<f5.g> aVar2) {
            r5.h.f(lVar, "onBackStarted");
            r5.h.f(lVar2, "onBackProgressed");
            r5.h.f(aVar, "onBackInvoked");
            r5.h.f(aVar2, "onBackCancelled");
            return new a(lVar, lVar2, aVar, aVar2);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class c implements c {

        /* renamed from: f */
        public final n f400f;

        public c(n nVar) {
            OnBackPressedDispatcher.this = r1;
            this.f400f = nVar;
        }

        @Override // androidx.activity.c
        public final void cancel() {
            OnBackPressedDispatcher.this.f385c.remove(this.f400f);
            if (r5.h.a(OnBackPressedDispatcher.this.f386d, this.f400f)) {
                this.f400f.getClass();
                OnBackPressedDispatcher.this.f386d = null;
            }
            n nVar = this.f400f;
            nVar.getClass();
            nVar.f429b.remove(this);
            q5.a<f5.g> aVar = this.f400f.f430c;
            if (aVar != null) {
                aVar.d();
            }
            this.f400f.f430c = null;
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public final void a(n nVar, x.c cVar) {
        r5.h.f(cVar, "onBackPressedCallback");
        o k6 = nVar.k();
        if (k6.f1876d != g.b.DESTROYED) {
            cVar.f429b.add(new LifecycleOnBackPressedCancellable(this, k6, cVar));
            d();
            cVar.f430c = new q5.a<f5.g>(this) { // from class: androidx.activity.u
                @Override // q5.a
                public final f5.g d() {
                    ((OnBackPressedDispatcher) this.f5911g).d();
                    return f5.g.f4141a;
                }
            };
        }
    }

    public final void b() {
        n nVar;
        n nVar2 = this.f386d;
        if (nVar2 == null) {
            h<n> hVar = this.f385c;
            ListIterator<n> listIterator = hVar.listIterator(hVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    nVar = null;
                    break;
                }
                nVar = listIterator.previous();
                if (nVar.f428a) {
                    break;
                }
            }
            nVar2 = nVar;
        }
        this.f386d = null;
        if (nVar2 != null) {
            nVar2.a();
            return;
        }
        Runnable runnable = this.f383a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void c(boolean z6) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f387f;
        OnBackInvokedCallback onBackInvokedCallback = this.e;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            if (z6 && !this.f388g) {
                a.f394a.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.f388g = true;
            } else if (!z6 && this.f388g) {
                a.f394a.c(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f388g = false;
            }
        }
    }

    public final void d() {
        boolean z6 = this.f389h;
        h<n> hVar = this.f385c;
        boolean z7 = false;
        if (!(hVar instanceof Collection) || !hVar.isEmpty()) {
            Iterator<n> it = hVar.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f428a) {
                        z7 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.f389h = z7;
        if (z7 != z6) {
            o1.a<Boolean> aVar = this.f384b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z7));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                c(z7);
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f383a = runnable;
        this.f384b = null;
        this.f385c = new h<>();
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33) {
            this.e = i7 >= 34 ? b.f395a.a(new o(this), new p(this), new q(this), new r(this)) : a.f394a.a(new s(this));
        }
    }
}
