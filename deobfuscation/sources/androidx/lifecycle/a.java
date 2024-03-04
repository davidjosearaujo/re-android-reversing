package androidx.lifecycle;

import androidx.lifecycle.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c */
    public static a f1841c = new a();

    /* renamed from: a */
    public final HashMap f1842a = new HashMap();

    /* renamed from: b */
    public final HashMap f1843b = new HashMap();

    @Deprecated
    /* renamed from: androidx.lifecycle.a$a */
    /* loaded from: classes.dex */
    public static class C0017a {

        /* renamed from: a */
        public final HashMap f1844a = new HashMap();

        /* renamed from: b */
        public final Map<b, g.a> f1845b;

        public C0017a(HashMap hashMap) {
            this.f1845b = hashMap;
            for (Map.Entry entry : hashMap.entrySet()) {
                g.a aVar = (g.a) entry.getValue();
                List list = (List) this.f1844a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f1844a.put(aVar, list);
                }
                list.add((b) entry.getKey());
            }
        }

        public static void a(List<b> list, n nVar, g.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    b bVar = list.get(size);
                    bVar.getClass();
                    try {
                        int i7 = bVar.f1846a;
                        if (i7 == 0) {
                            bVar.f1847b.invoke(obj, new Object[0]);
                        } else if (i7 == 1) {
                            bVar.f1847b.invoke(obj, nVar);
                        } else if (i7 == 2) {
                            bVar.f1847b.invoke(obj, nVar, aVar);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e7) {
                        throw new RuntimeException("Failed to call observer method", e7.getCause());
                    }
                }
            }
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a */
        public final int f1846a;

        /* renamed from: b */
        public final Method f1847b;

        public b(int i7, Method method) {
            this.f1846a = i7;
            this.f1847b = method;
            method.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f1846a == bVar.f1846a && this.f1847b.getName().equals(bVar.f1847b.getName());
            }
            return false;
        }

        public final int hashCode() {
            return this.f1847b.getName().hashCode() + (this.f1846a * 31);
        }
    }

    public static void c(HashMap hashMap, b bVar, g.a aVar, Class cls) {
        g.a aVar2 = (g.a) hashMap.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                hashMap.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.f1847b;
        StringBuilder d7 = androidx.activity.h.d("Method ");
        d7.append(method.getName());
        d7.append(" in ");
        d7.append(cls.getName());
        d7.append(" already declared with different @OnLifecycleEvent value: previous value ");
        d7.append(aVar2);
        d7.append(", new value ");
        d7.append(aVar);
        throw new IllegalArgumentException(d7.toString());
    }

    public final C0017a a(Class<?> cls, Method[] methodArr) {
        int i7;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            hashMap.putAll(b(superclass).f1845b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, g.a> entry : b(cls2).f1845b.entrySet()) {
                c(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z6 = false;
        for (Method method : methodArr) {
            t tVar = (t) method.getAnnotation(t.class);
            if (tVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i7 = 0;
                } else if (!n.class.isAssignableFrom(parameterTypes[0])) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i7 = 1;
                }
                g.a value = tVar.value();
                if (parameterTypes.length > 1) {
                    if (!g.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != g.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i7 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                c(hashMap, new b(i7, method), value, cls);
                z6 = true;
            }
        }
        C0017a c0017a = new C0017a(hashMap);
        this.f1842a.put(cls, c0017a);
        this.f1843b.put(cls, Boolean.valueOf(z6));
        return c0017a;
    }

    public final C0017a b(Class<?> cls) {
        C0017a c0017a = (C0017a) this.f1842a.get(cls);
        return c0017a != null ? c0017a : a(cls, null);
    }
}
