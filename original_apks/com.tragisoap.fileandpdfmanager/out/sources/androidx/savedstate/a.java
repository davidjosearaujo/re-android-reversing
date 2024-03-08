package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.savedstate.Recreator;
import h2.c;
import java.util.Iterator;
import java.util.Map;
import l.b;
import r5.h;
@SuppressLint({"RestrictedApi"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: b */
    public boolean f2293b;

    /* renamed from: c */
    public Bundle f2294c;

    /* renamed from: d */
    public boolean f2295d;
    public Recreator.a e;

    /* renamed from: a */
    public final l.b<String, b> f2292a = new l.b<>();

    /* renamed from: f */
    public boolean f2296f = true;

    /* renamed from: androidx.savedstate.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface AbstractC0024a {
        void a(c cVar);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        Bundle a();
    }

    public final Bundle a(String str) {
        h.f(str, "key");
        if (this.f2295d) {
            Bundle bundle = this.f2294c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
            Bundle bundle3 = this.f2294c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f2294c;
            boolean z6 = false;
            if (bundle4 != null && !bundle4.isEmpty()) {
                z6 = true;
            }
            if (!z6) {
                this.f2294c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final b b() {
        Map.Entry entry;
        b bVar;
        Iterator<Map.Entry<String, b>> it = this.f2292a.iterator();
        do {
            b.e eVar = (b.e) it;
            if (!eVar.hasNext()) {
                return null;
            }
            entry = (Map.Entry) eVar.next();
            h.e(entry, "components");
            bVar = (b) entry.getValue();
        } while (!h.a((String) entry.getKey(), "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return bVar;
    }

    public final void c(String str, b bVar) {
        b bVar2;
        h.f(str, "key");
        h.f(bVar, "provider");
        l.b<String, b> bVar3 = this.f2292a;
        b.c<String, b> a7 = bVar3.a(str);
        boolean z6 = true;
        if (a7 != null) {
            bVar2 = a7.f4834g;
        } else {
            b.c<K, V> cVar = new b.c<>(str, bVar);
            bVar3.f4832i++;
            b.c cVar2 = bVar3.f4830g;
            if (cVar2 == null) {
                bVar3.f4829f = cVar;
            } else {
                cVar2.f4835h = cVar;
                cVar.f4836i = cVar2;
            }
            bVar3.f4830g = cVar;
            bVar2 = null;
        }
        if (bVar2 != null) {
            z6 = false;
        }
        if (!z6) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void d() {
        if (this.f2296f) {
            Recreator.a aVar = this.e;
            if (aVar == null) {
                aVar = new Recreator.a(this);
            }
            this.e = aVar;
            try {
                f.a.class.getDeclaredConstructor(new Class[0]);
                Recreator.a aVar2 = this.e;
                if (aVar2 != null) {
                    aVar2.f2291a.add(f.a.class.getName());
                }
            } catch (NoSuchMethodException e) {
                StringBuilder d7 = androidx.activity.h.d("Class ");
                d7.append(f.a.class.getSimpleName());
                d7.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(d7.toString(), e);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }
}
