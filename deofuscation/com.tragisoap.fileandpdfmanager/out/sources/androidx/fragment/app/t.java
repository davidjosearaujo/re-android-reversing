package androidx.fragment.app;

import androidx.fragment.app.n;
import o.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static final h<ClassLoader, h<String, Class<?>>> f1763a = new h<>();

    public static Class<?> b(ClassLoader classLoader, String str) {
        h<ClassLoader, h<String, Class<?>>> hVar = f1763a;
        h<String, Class<?>> orDefault = hVar.getOrDefault(classLoader, null);
        if (orDefault == null) {
            orDefault = new h<>();
            hVar.put(classLoader, orDefault);
        }
        Class<?> orDefault2 = orDefault.getOrDefault(str, null);
        if (orDefault2 != null) {
            return orDefault2;
        }
        Class<?> cls = Class.forName(str, false, classLoader);
        orDefault.put(str, cls);
        return cls;
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
