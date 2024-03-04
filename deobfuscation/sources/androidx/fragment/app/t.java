package androidx.fragment.app;

import androidx.fragment.app.n;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a */
    public static final o.h<ClassLoader, o.h<String, Class<?>>> f1763a = new o.h<>();

    public static Class<?> b(ClassLoader classLoader, String str) {
        o.h<ClassLoader, o.h<String, Class<?>>> hVar = f1763a;
        o.h<String, Class<?>> orDefault = hVar.getOrDefault(classLoader, null);
        if (orDefault == null) {
            orDefault = new o.h<>();
            hVar.put(classLoader, orDefault);
        }
        Class<?> orDefault2 = orDefault.getOrDefault(str, null);
        if (orDefault2 == null) {
            Class<?> cls = Class.forName(str, false, classLoader);
            orDefault.put(str, cls);
            return cls;
        }
        return orDefault2;
    }

    public static Class<? extends n> c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e) {
            throw new n.c("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e7) {
            throw new n.c("Unable to instantiate fragment " + str + ": make sure class name exists", e7);
        }
    }

    public n a(String str) {
        throw null;
    }
}
