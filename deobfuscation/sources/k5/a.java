package k5;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import k5.f;

/* loaded from: classes.dex */
public abstract class a implements i5.d, d, Serializable {

    /* renamed from: f */
    public final i5.d f4817f;

    public a(i5.d dVar) {
        this.f4817f = dVar;
    }

    public d g() {
        i5.d dVar = this.f4817f;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(Object obj) {
        while (true) {
            a aVar = this;
            i5.d dVar = aVar.f4817f;
            r5.h.c(dVar);
            try {
                obj = aVar.s(obj);
                if (obj == Kotlin_1.a.f4591f) {
                    return;
                }
            } catch (Throwable th) {
                obj = f5.e.a(th);
            }
            aVar.t();
            if (!(dVar instanceof a)) {
                dVar.o(obj);
                return;
            }
            this = dVar;
        }
    }

    public i5.d p(Object obj, i5.d dVar) {
        r5.h.f(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public StackTraceElement q() {
        int i7;
        String str;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str2 = null;
        if (eVar == null) {
            return null;
        }
        int v6 = eVar.v();
        if (v6 > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v6 + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            i7 = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            i7 = -1;
        }
        int i8 = i7 >= 0 ? eVar.l()[i7] : -1;
        f.a aVar = f.f4822b;
        if (aVar == null) {
            try {
                f.a aVar2 = new f.a(Class.class.getDeclaredMethod("getModule", new Class[0]), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
                f.f4822b = aVar2;
                aVar = aVar2;
            } catch (Exception unused2) {
                aVar = f.f4821a;
                f.f4822b = aVar;
            }
        }
        if (aVar != f.f4821a) {
            Method method = aVar.f4823a;
            Object invoke = method != null ? method.invoke(getClass(), new Object[0]) : null;
            if (invoke != null) {
                Method method2 = aVar.f4824b;
                Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
                if (invoke2 != null) {
                    Method method3 = aVar.f4825c;
                    Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
                    if (invoke3 instanceof String) {
                        str2 = invoke3;
                    }
                }
            }
        }
        if (str2 == null) {
            str = eVar.c();
        } else {
            str = str2 + '/' + eVar.c();
        }
        return new StackTraceElement(str, eVar.m(), eVar.f(), i8);
    }

    public abstract Object s(Object obj);

    public void t() {
    }

    public String toString() {
        StringBuilder d7 = androidx.activity.h.d("Continuation at ");
        Object q6 = q();
        if (q6 == null) {
            q6 = getClass().getName();
        }
        d7.append(q6);
        return d7.toString();
    }
}
