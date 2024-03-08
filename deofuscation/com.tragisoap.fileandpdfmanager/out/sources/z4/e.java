package z4;

import androidx.activity.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f6937a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6938b;

    /* renamed from: c  reason: collision with root package name */
    public final Class[] f6939c;

    public e(Class<?> cls, String str, Class... clsArr) {
        this.f6937a = cls;
        this.f6938b = str;
        this.f6939c = clsArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
        if ((r4.getModifiers() & 1) == 0) goto L_0x0013;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.reflect.Method a(java.lang.Class<?> r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.f6938b
            r1 = 0
            if (r0 == 0) goto L_0x0026
            java.lang.Class[] r2 = r3.f6939c
            java.lang.reflect.Method r4 = r4.getMethod(r0, r2)     // Catch: NoSuchMethodException -> 0x0013
            int r0 = r4.getModifiers()     // Catch: NoSuchMethodException -> 0x0014
            r0 = r0 & 1
            if (r0 != 0) goto L_0x0014
        L_0x0013:
            r4 = r1
        L_0x0014:
            if (r4 == 0) goto L_0x0025
            java.lang.Class<?> r3 = r3.f6937a
            if (r3 == 0) goto L_0x0025
            java.lang.Class r0 = r4.getReturnType()
            boolean r3 = r3.isAssignableFrom(r0)
            if (r3 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = r4
        L_0x0026:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.e.a(java.lang.Class):java.lang.reflect.Method");
    }

    public final Object b(T t5, Object... objArr) {
        Method a7 = a(t5.getClass());
        if (a7 != null) {
            try {
                return a7.invoke(t5, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a7);
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            StringBuilder d7 = h.d("Method ");
            d7.append(this.f6938b);
            d7.append(" not supported for object ");
            d7.append(t5);
            throw new AssertionError(d7.toString());
        }
    }

    public final void c(Object obj, Object... objArr) {
        try {
            Method a7 = a(obj.getClass());
            if (a7 != null) {
                try {
                    a7.invoke(obj, objArr);
                } catch (IllegalAccessException unused) {
                }
            }
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
