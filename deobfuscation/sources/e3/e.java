package e3;

import java.lang.reflect.InvocationTargetException;

@Deprecated
/* loaded from: classes.dex */
public final class e {
    public static c a(String str) {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        try {
            try {
                Object newInstance = Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof c) {
                    return (c) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (IllegalAccessException e) {
                b(cls4, e);
                throw null;
            } catch (InstantiationException e7) {
                b(cls3, e7);
                throw null;
            } catch (NoSuchMethodException e8) {
                b(cls2, e8);
                throw null;
            } catch (InvocationTargetException e9) {
                b(cls, e9);
                throw null;
            }
        } catch (ClassNotFoundException e10) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e10);
        }
    }

    public static void b(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }
}
