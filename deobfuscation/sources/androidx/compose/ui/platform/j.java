package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import n0.a;

/* loaded from: classes.dex */
public final class j implements ComponentCallbacks2 {

    /* renamed from: f */
    public final /* synthetic */ Configuration f1183f;

    /* renamed from: g */
    public final /* synthetic */ n0.a f1184g;

    public j(Configuration configuration, n0.a aVar) {
        this.f1183f = configuration;
        this.f1184g = aVar;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        r5.h.f(configuration, "configuration");
        int updateFrom = this.f1183f.updateFrom(configuration);
        Iterator<Map.Entry<Object, WeakReference<a.C0081a>>> it = this.f1184g.f5107a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, WeakReference<a.C0081a>> next = it.next();
            r5.h.e(next, "it.next()");
            if (next.getValue().get() == null || Configuration.needNewResources(updateFrom, 0)) {
                it.remove();
            }
        }
        this.f1183f.setTo(configuration);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f1184g.f5107a.clear();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i7) {
        this.f1184g.f5107a.clear();
    }
}
