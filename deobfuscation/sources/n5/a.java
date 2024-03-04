package n5;

import r5.h;

/* loaded from: classes.dex */
public class a extends m5.a {

    /* renamed from: n5.a$a */
    /* loaded from: classes.dex */
    public static final class C0085a {

        /* renamed from: a */
        public static final Integer f5179a;

        /* JADX WARN: Removed duplicated region for block: B:69:0x001b  */
        static {
            /*
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L18
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L18
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L18
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L18
                if (r2 == 0) goto L18
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L18
                goto L19
            L18:
                r1 = r0
            L19:
                if (r1 == 0) goto L27
                int r2 = r1.intValue()
                if (r2 <= 0) goto L23
                r2 = 1
                goto L24
            L23:
                r2 = 0
            L24:
                if (r2 == 0) goto L27
                r0 = r1
            L27:
                n5.a.C0085a.f5179a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n5.a.C0085a.<clinit>():void");
        }
    }

    @Override // m5.a
    public final void a(Throwable th, Throwable th2) {
        h.f(th, "cause");
        h.f(th2, "exception");
        Integer num = C0085a.f5179a;
        if (num == null || num.intValue() >= 19) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
