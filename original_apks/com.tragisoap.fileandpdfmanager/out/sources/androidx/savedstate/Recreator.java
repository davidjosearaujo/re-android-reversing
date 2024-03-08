package androidx.savedstate;

import android.os.Bundle;
import androidx.fragment.app.s0;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.savedstate.a;
import h2.c;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class Recreator implements l {

    /* renamed from: f  reason: collision with root package name */
    public final c f2290f;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashSet f2291a = new LinkedHashSet();

        public a(a aVar) {
            h.f(aVar, "registry");
            aVar.c("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.a.b
        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f2291a));
            return bundle;
        }
    }

    public Recreator(c cVar) {
        h.f(cVar, "owner");
        this.f2290f = cVar;
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        if (aVar == g.a.ON_CREATE) {
            nVar.k().c(this);
            Bundle a7 = this.f2290f.b().a("androidx.savedstate.Restarter");
            if (a7 != null) {
                ArrayList<String> stringArrayList = a7.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    for (String str : stringArrayList) {
                        try {
                            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.AbstractC0024a.class);
                            h.e(asSubclass, "{\n                Class.…class.java)\n            }");
                            try {
                                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                                    h.e(newInstance, "{\n                constr…wInstance()\n            }");
                                    ((a.AbstractC0024a) newInstance).a(this.f2290f);
                                } catch (Exception e) {
                                    throw new RuntimeException(s0.h("Failed to instantiate ", str), e);
                                }
                            } catch (NoSuchMethodException e7) {
                                StringBuilder d7 = androidx.activity.h.d("Class ");
                                d7.append(asSubclass.getSimpleName());
                                d7.append(" must have default constructor in order to be automatically recreated");
                                throw new IllegalStateException(d7.toString(), e7);
                            }
                        } catch (ClassNotFoundException e8) {
                            throw new RuntimeException("Class " + str + " wasn't found", e8);
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
