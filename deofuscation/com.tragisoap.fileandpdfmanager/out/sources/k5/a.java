package k5;

import f5.g;
import i5.d;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import k5.f;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a implements d<Object>, d, Serializable {

    /* renamed from: f */
    public final d<Object> f4817f;

    public a(d<Object> dVar) {
        this.f4817f = dVar;
    }

    @Override // k5.d
    public d g() {
        d<Object> dVar = this.f4817f;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [i5.d, i5.d<java.lang.Object>, java.lang.Object] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // i5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(java.lang.Object r3) {
        /*
            r2 = this;
        L_0x0000:
            k5.a r2 = (k5.a) r2
            i5.d<java.lang.Object> r0 = r2.f4817f
            r5.h.c(r0)
            java.lang.Object r3 = r2.s(r3)     // Catch: all -> 0x0010
            j5.a r1 = j5.a.f4591f     // Catch: all -> 0x0010
            if (r3 != r1) goto L_0x0015
            return
        L_0x0010:
            r3 = move-exception
            f5.d$a r3 = f5.e.a(r3)
        L_0x0015:
            r2.t()
            boolean r2 = r0 instanceof k5.a
            if (r2 == 0) goto L_0x001e
            r2 = r0
            goto L_0x0000
        L_0x001e:
            r0.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.a.o(java.lang.Object):void");
    }

    public d<g> p(Object obj, d<?> dVar) {
        h.f(dVar, "completion");
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
        if (v6 <= 1) {
            int i8 = -1;
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                i7 = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                i7 = -1;
            }
            if (i7 >= 0) {
                i8 = eVar.l()[i7];
            }
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
                            str2 = (String) invoke3;
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
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v6 + ". Please update the Kotlin standard library.").toString());
    }

    public abstract Object s(Object obj);

    public void t() {
    }

    @Override // java.lang.Object
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
