package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.g;
import androidx.lifecycle.k;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements i2.b<n> {
    @Override // i2.b
    public final List<Class<? extends i2.b<?>>> a() {
        return g5.p.f4284f;
    }

    @Override // i2.b
    public final n b(Context context) {
        r5.h.f(context, "context");
        i2.a c7 = i2.a.c(context);
        r5.h.e(c7, "getInstance(context)");
        if (c7.f4474b.contains(ProcessLifecycleInitializer.class)) {
            if (!k.f1873a.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                r5.h.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new k.a());
            }
            u uVar = u.m;
            uVar.getClass();
            uVar.f1889j = new Handler();
            uVar.f1890k.f(g.a.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            r5.h.d(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new v(uVar));
            return uVar;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }
}
