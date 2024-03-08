package m2;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import o.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a {

    /* renamed from: a */
    public final b<String, Method> f5080a;

    /* renamed from: b */
    public final b<String, Method> f5081b;

    /* renamed from: c */
    public final b<String, Class> f5082c;

    public a(b<String, Method> bVar, b<String, Method> bVar2, b<String, Class> bVar3) {
        this.f5080a = bVar;
        this.f5081b = bVar2;
        this.f5082c = bVar3;
    }

    public abstract b a();

    public final Class b(Class<? extends c> cls) {
        Class orDefault = this.f5082c.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f5082c.put(cls.getName(), cls2);
        return cls2;
    }

    public final Method c(String str) {
        Method orDefault = this.f5080a.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f5080a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) {
        Method orDefault = this.f5081b.getOrDefault(cls.getName(), null);
        if (orDefault != null) {
            return orDefault;
        }
        Class b2 = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = b2.getDeclaredMethod("write", cls, a.class);
        this.f5081b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e();

    public abstract byte[] f();

    public abstract CharSequence g();

    public abstract boolean h(int i7);

    public abstract int i();

    public abstract <T extends Parcelable> T j();

    public abstract String k();

    public final <T extends c> T l() {
        String k6 = k();
        if (k6 == null) {
            return null;
        }
        try {
            return (T) ((c) c(k6).invoke(null, a()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e7);
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e8);
        } catch (InvocationTargetException e9) {
            if (e9.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e9.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e9);
        }
    }

    public abstract void m(int i7);

    public abstract void n(boolean z6);

    public abstract void o(byte[] bArr);

    public abstract void p(CharSequence charSequence);

    public abstract void q(int i7);

    public abstract void r(Parcelable parcelable);

    public abstract void s(String str);

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(c cVar) {
        if (cVar == null) {
            s(null);
            return;
        }
        try {
            s(b(cVar.getClass()).getName());
            b a7 = a();
            try {
                d(cVar.getClass()).invoke(null, cVar, a7);
                a7.u();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e7) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e7);
            } catch (NoSuchMethodException e8) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e8);
            } catch (InvocationTargetException e9) {
                if (e9.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e9.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e9);
            }
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e10);
        }
    }
}
