package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.g;
import androidx.lifecycle.k;
import g5.p;
import i2.a;
import i2.b;
import java.util.List;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class ProcessLifecycleInitializer implements b<n> {
    @Override // i2.b
    public final List<Class<? extends b<?>>> a() {
        return p.f4284f;
    }

    @Override // i2.b
    public final n b(Context context) {
        h.f(context, "context");
        a c7 = a.c(context);
        h.e(c7, "getInstance(context)");
        if (c7.f4474b.contains(ProcessLifecycleInitializer.class)) {
            if (!k.f1873a.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                h.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new k.a());
            }
            u uVar = u.m;
            uVar.getClass();
            uVar.f1889j = new Handler();
            uVar.f1890k.f(g.a.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            h.d(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new v(uVar));
            return uVar;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }
}
