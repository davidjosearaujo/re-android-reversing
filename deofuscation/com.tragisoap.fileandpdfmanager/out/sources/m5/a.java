package m5;

import java.lang.reflect.Method;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class a {

    /* renamed from: m5.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0080a {

        /* renamed from: a  reason: collision with root package name */
        public static final Method f5093a;

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
            if (r5.h.a(r5, java.lang.Throwable.class) != false) goto L_0x0034;
         */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                r5.h.c(r1)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            L_0x000c:
                r5 = 0
                if (r4 >= r2) goto L_0x003b
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = r5.h.a(r7, r8)
                r8 = 1
                if (r7 == 0) goto L_0x0033
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r9 = "getParameterTypes(...)"
                r5.h.e(r7, r9)
                int r9 = r7.length
                if (r9 != r8) goto L_0x002c
                r5 = r7[r3]
            L_0x002c:
                boolean r5 = r5.h.a(r5, r0)
                if (r5 == 0) goto L_0x0033
                goto L_0x0034
            L_0x0033:
                r8 = r3
            L_0x0034:
                if (r8 == 0) goto L_0x0038
                r5 = r6
                goto L_0x003b
            L_0x0038:
                int r4 = r4 + 1
                goto L_0x000c
            L_0x003b:
                m5.a.C0080a.f5093a = r5
                int r0 = r1.length
            L_0x003e:
                if (r3 >= r0) goto L_0x0052
                r2 = r1[r3]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = r5.h.a(r2, r4)
                if (r2 == 0) goto L_0x004f
                goto L_0x0052
            L_0x004f:
                int r3 = r3 + 1
                goto L_0x003e
            L_0x0052:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m5.a.C0080a.<clinit>():void");
        }
    }

    public void a(Throwable th, Throwable th2) {
        h.f(th, "cause");
        h.f(th2, "exception");
        Method method = C0080a.f5093a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
