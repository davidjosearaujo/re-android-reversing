package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import androidx.activity.k;
import androidx.lifecycle.g;
import androidx.lifecycle.w;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u implements n {
    public static final u m = new u();

    /* renamed from: f */
    public int f1885f;

    /* renamed from: g */
    public int f1886g;

    /* renamed from: j */
    public Handler f1889j;

    /* renamed from: h */
    public boolean f1887h = true;

    /* renamed from: i */
    public boolean f1888i = true;

    /* renamed from: k */
    public final o f1890k = new o(this);

    /* renamed from: l */
    public final k f1891l = new k(6, this);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {
        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            h.f(activity, "activity");
            h.f(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b implements w.a {
        public b() {
            u.this = r1;
        }

        @Override // androidx.lifecycle.w.a
        public final void a() {
            u uVar = u.this;
            int i7 = uVar.f1885f + 1;
            uVar.f1885f = i7;
            if (i7 == 1 && uVar.f1888i) {
                uVar.f1890k.f(g.a.ON_START);
                uVar.f1888i = false;
            }
        }

        @Override // androidx.lifecycle.w.a
        public final void b() {
        }

        @Override // androidx.lifecycle.w.a
        public final void c() {
            u.this.d();
        }
    }

    public u() {
        new b();
    }

    public final void d() {
        int i7 = this.f1886g + 1;
        this.f1886g = i7;
        if (i7 != 1) {
            return;
        }
        if (this.f1887h) {
            this.f1890k.f(g.a.ON_RESUME);
            this.f1887h = false;
            return;
        }
        Handler handler = this.f1889j;
        h.c(handler);
        handler.removeCallbacks(this.f1891l);
    }

    @Override // androidx.lifecycle.n
    public final o k() {
        return this.f1890k;
    }
}
