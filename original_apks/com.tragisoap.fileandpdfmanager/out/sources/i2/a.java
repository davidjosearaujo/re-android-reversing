package i2;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f4472d;
    public static final Object e = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final Context f4475c;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f4474b = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f4473a = new HashMap();

    public a(Context context) {
        this.f4475c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f4472d == null) {
            synchronized (e) {
                if (f4472d == null) {
                    f4472d = new a(context);
                }
            }
        }
        return f4472d;
    }

    public final void a(Bundle bundle) {
        String string = this.f4475c.getString(2131820571);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f4474b.add(cls);
                        }
                    }
                }
                Iterator it = this.f4474b.iterator();
                while (it.hasNext()) {
                    b((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e7) {
                throw new c(e7);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        if (j2.a.a()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } finally {
                Trace.endSection();
            }
        }
        if (!hashSet.contains(cls)) {
            if (!this.f4473a.containsKey(cls)) {
                hashSet.add(cls);
                b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends b<?>>> a7 = bVar.a();
                if (!a7.isEmpty()) {
                    for (Class<? extends b<?>> cls2 : a7) {
                        if (!this.f4473a.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                obj = bVar.b(this.f4475c);
                hashSet.remove(cls);
                this.f4473a.put(cls, obj);
            } else {
                obj = this.f4473a.get(cls);
            }
            return obj;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
    }
}
