package b.a.a.a.e;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class h implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final h e = new h();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f155a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f156b = new AtomicBoolean();
    private final ArrayList<i> c = new ArrayList<>();
    private boolean d = false;

    private h() {
    }

    public static void a(Application application) {
        synchronized (e) {
            if (!e.d) {
                application.registerActivityLifecycleCallbacks(e);
                application.registerComponentCallbacks(e);
                e.d = true;
            }
        }
    }

    private final void d(boolean z) {
        synchronized (e) {
            ArrayList<i> arrayList = this.c;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                i iVar = arrayList.get(i);
                i++;
                iVar.a(z);
            }
        }
    }

    public static h e() {
        return e;
    }

    public final void b(i iVar) {
        synchronized (e) {
            this.c.add(iVar);
        }
    }

    @TargetApi(16)
    public final boolean c(boolean z) {
        if (!this.f156b.get()) {
            if (!g.b()) {
                return true;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f156b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f155a.set(true);
            }
        }
        return this.f155a.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f155a.compareAndSet(true, false);
        this.f156b.set(true);
        if (compareAndSet) {
            d(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f155a.compareAndSet(true, false);
        this.f156b.set(true);
        if (compareAndSet) {
            d(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f155a.compareAndSet(false, true)) {
            this.f156b.set(true);
            d(true);
        }
    }
}
