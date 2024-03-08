package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.g;
import androidx.lifecycle.u;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v extends c {
    public final /* synthetic */ u this$0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends c {
        public final /* synthetic */ u this$0;

        public a(u uVar) {
            this.this$0 = uVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            h.f(activity, "activity");
            this.this$0.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            h.f(activity, "activity");
            u uVar = this.this$0;
            int i7 = uVar.f1885f + 1;
            uVar.f1885f = i7;
            if (i7 == 1 && uVar.f1888i) {
                uVar.f1890k.f(g.a.ON_START);
                uVar.f1888i = false;
            }
        }
    }

    public v(u uVar) {
        this.this$0 = uVar;
    }

    @Override // androidx.lifecycle.c, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        h.f(activity, "activity");
    }

    @Override // androidx.lifecycle.c, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        h.f(activity, "activity");
        u uVar = this.this$0;
        int i7 = uVar.f1886g - 1;
        uVar.f1886g = i7;
        if (i7 == 0) {
            Handler handler = uVar.f1889j;
            h.c(handler);
            handler.postDelayed(uVar.f1891l, 700);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        h.f(activity, "activity");
        u.a.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.c, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        h.f(activity, "activity");
        u uVar = this.this$0;
        int i7 = uVar.f1885f - 1;
        uVar.f1885f = i7;
        if (i7 == 0 && uVar.f1887h) {
            uVar.f1890k.f(g.a.ON_STOP);
            uVar.f1888i = true;
        }
    }
}
