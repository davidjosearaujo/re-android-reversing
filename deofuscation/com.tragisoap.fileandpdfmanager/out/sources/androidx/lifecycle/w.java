package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.g;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class w extends Fragment {

    /* renamed from: g */
    public static final /* synthetic */ int f1893g = 0;

    /* renamed from: f */
    public a f1894f;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {
        public static void a(Activity activity, g.a aVar) {
            h.f(activity, "activity");
            h.f(aVar, "event");
            if (activity instanceof p) {
                ((p) activity).c().f(aVar);
            } else if (activity instanceof n) {
                o k6 = ((n) activity).k();
                if (k6 instanceof o) {
                    k6.f(aVar);
                }
            }
        }

        public static void b(Activity activity) {
            h.f(activity, "activity");
            c.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new c());
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new w(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a();

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class a {
        }

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            h.f(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new c());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            h.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            h.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            h.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            h.f(activity, "activity");
            int i7 = w.f1893g;
            b.a(activity, g.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            h.f(activity, "activity");
            int i7 = w.f1893g;
            b.a(activity, g.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            h.f(activity, "activity");
            int i7 = w.f1893g;
            b.a(activity, g.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            h.f(activity, "activity");
            int i7 = w.f1893g;
            b.a(activity, g.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            h.f(activity, "activity");
            int i7 = w.f1893g;
            b.a(activity, g.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            h.f(activity, "activity");
            int i7 = w.f1893g;
            b.a(activity, g.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            h.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            h.f(activity, "activity");
            h.f(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            h.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            h.f(activity, "activity");
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a aVar = this.f1894f;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f1894f = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        a aVar = this.f1894f;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        a aVar = this.f1894f;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
    }
}
