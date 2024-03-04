package m5;

import java.lang.reflect.Method;
import r5.h;

/* loaded from: classes.dex */
public class a {

    /* renamed from: m5.a$a */
    /* loaded from: classes.dex */
    public static final class C0080a {

        /* renamed from: a */
        public static final Method f5093a;

        /* JADX WARN: Code restructure failed: missing block: B:98:0x0030, code lost:
            if (r5.h.a(r7.length == 1 ? r7[0] : null, java.lang.Throwable.class) != false) goto L11;
         */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                r5.h.c(r1)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            Lc:
                r5 = 0
                if (r4 >= r2) goto L3b
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = r5.h.a(r7, r8)
                r8 = 1
                if (r7 == 0) goto L33
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r9 = "getParameterTypes(...)"
                r5.h.e(r7, r9)
                int r9 = r7.length
                if (r9 != r8) goto L2c
                r5 = r7[r3]
            L2c:
                boolean r5 = r5.h.a(r5, r0)
                if (r5 == 0) goto L33
                goto L34
            L33:
                r8 = r3
            L34:
                if (r8 == 0) goto L38
                r5 = r6
                goto L3b
            L38:
                int r4 = r4 + 1
                goto Lc
            L3b:
                m5.a.C0080a.f5093a = r5
                int r0 = r1.length
            L3e:
                if (r3 >= r0) goto L52
                r2 = r1[r3]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = r5.h.a(r2, r4)
                if (r2 == 0) goto L4f
                goto L52
            L4f:
                int r3 = r3 + 1
                goto L3e
            L52:
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
