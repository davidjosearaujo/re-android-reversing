package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import q2.a;
import r5.h;
import z5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f1883a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap f1884b = new HashMap();

    public static d a(Constructor constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(obj);
            h.e(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return (d) newInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e7) {
            throw new RuntimeException(e7);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    public static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        int Y = i.Y(str, ".", 0, false);
        if (Y >= 0) {
            int length = (str.length() - 1) + 1;
            if (length >= 0) {
                StringBuilder sb2 = new StringBuilder(length);
                int i7 = 0;
                do {
                    sb2.append((CharSequence) str, i7, Y);
                    sb2.append("_");
                    i7 = Y + 1;
                    if (Y >= str.length()) {
                        break;
                    }
                    Y = i.Y(str, ".", i7, false);
                } while (Y > 0);
                sb2.append((CharSequence) str, i7, str.length());
                str = sb2.toString();
                h.e(str, "toString(...)");
            } else {
                throw new OutOfMemoryError();
            }
        }
        return androidx.activity.h.c(sb, str, "_LifecycleAdapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int c(Class cls) {
        Constructor constructor;
        HashMap hashMap;
        boolean z6;
        Integer num = (Integer) f1883a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i7 = 1;
        if (cls.getCanonicalName() != null) {
            List list = null;
            try {
                Package r42 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r42 != null ? r42.getName() : "";
                h.e(name, "fullPackage");
                if (!(name.length() == 0)) {
                    h.e(canonicalName, "name");
                    canonicalName = canonicalName.substring(name.length() + 1);
                    h.e(canonicalName, "this as java.lang.String).substring(startIndex)");
                }
                h.e(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String b2 = b(canonicalName);
                if (!(name.length() == 0)) {
                    b2 = name + '.' + b2;
                }
                constructor = Class.forName(b2).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            i7 = 2;
            if (constructor != null) {
                hashMap = f1884b;
                list = a.G(constructor);
            } else {
                a aVar = a.f1841c;
                Boolean bool = (Boolean) aVar.f1843b.get(cls);
                if (bool != null) {
                    z6 = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i8 = 0;
                        while (true) {
                            if (i8 >= length) {
                                aVar.f1843b.put(cls, Boolean.FALSE);
                                z6 = false;
                                break;
                            } else if (((t) declaredMethods[i8].getAnnotation(t.class)) != null) {
                                aVar.a(cls, declaredMethods);
                                z6 = true;
                                break;
                            } else {
                                i8++;
                            }
                        }
                    } catch (NoClassDefFoundError e7) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e7);
                    }
                }
                if (!z6) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && m.class.isAssignableFrom(superclass)) {
                        h.e(superclass, "superclass");
                        if (c(superclass) != 1) {
                            Object obj = f1884b.get(superclass);
                            h.c(obj);
                            list = new ArrayList((Collection) obj);
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    h.e(interfaces, "klass.interfaces");
                    int length2 = interfaces.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 < length2) {
                            Class<?> cls2 = interfaces[i9];
                            if (cls2 != null && m.class.isAssignableFrom(cls2)) {
                                h.e(cls2, "intrface");
                                if (c(cls2) == 1) {
                                    break;
                                }
                                if (list == null) {
                                    list = new ArrayList();
                                }
                                Object obj2 = f1884b.get(cls2);
                                h.c(obj2);
                                list.addAll((Collection) obj2);
                            }
                            i9++;
                        } else if (list != null) {
                            hashMap = f1884b;
                        }
                    }
                }
            }
            hashMap.put(cls, list);
        }
        f1883a.put(cls, Integer.valueOf(i7));
        return i7;
    }
}
