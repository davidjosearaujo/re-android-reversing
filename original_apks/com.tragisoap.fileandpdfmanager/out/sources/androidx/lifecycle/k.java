package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.w;
import java.util.concurrent.atomic.AtomicBoolean;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f1873a = new AtomicBoolean(false);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends c {
        @Override // androidx.lifecycle.c, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            h.f(activity, "activity");
            int i7 = w.f1893g;
            w.b.b(activity);
        }
    }
}
