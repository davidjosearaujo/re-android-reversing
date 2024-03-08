package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import n0.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j implements ComponentCallbacks2 {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Configuration f1183f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ a f1184g;

    public j(Configuration configuration, a aVar) {
        this.f1183f = configuration;
        this.f1184g = aVar;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        h.f(configuration, "configuration");
        int updateFrom = this.f1183f.updateFrom(configuration);
        Iterator<Map.Entry<Object, WeakReference<a.C0081a>>> it = this.f1184g.f5107a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, WeakReference<a.C0081a>> next = it.next();
            h.e(next, "it.next()");
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
