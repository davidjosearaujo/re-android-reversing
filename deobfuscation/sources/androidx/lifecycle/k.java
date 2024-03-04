package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.w;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    public static final AtomicBoolean f1873a = new AtomicBoolean(false);

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.lifecycle.c, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            r5.h.f(activity, "activity");
            int i7 = w.f1893g;
            w.b.b(activity);
        }
    }
}
