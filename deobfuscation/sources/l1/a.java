package l1;

import android.os.ext.SdkExtensions;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: l1.a$a */
    /* loaded from: classes.dex */
    public static final class C0076a {

        /* renamed from: a */
        public static final C0076a f4939a = new C0076a();

        public final int a(int i7) {
            return SdkExtensions.getExtensionVersion(i7);
        }
    }

    static {
        C0076a c0076a = C0076a.f4939a;
        c0076a.a(30);
        c0076a.a(31);
        c0076a.a(33);
        c0076a.a(1000000);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean a() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 33
            if (r0 >= r3) goto L3b
            r3 = 32
            if (r0 < r3) goto L3c
            java.lang.String r0 = android.os.Build.VERSION.CODENAME
            java.lang.String r3 = "CODENAME"
            r5.h.e(r0, r3)
            java.lang.String r3 = "REL"
            boolean r3 = r5.h.a(r3, r0)
            if (r3 == 0) goto L1c
            goto L38
        L1c:
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toUpperCase(r3)
            java.lang.String r4 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            r5.h.e(r0, r4)
            java.lang.String r5 = "Tiramisu"
            java.lang.String r3 = r5.toUpperCase(r3)
            r5.h.e(r3, r4)
            int r0 = r0.compareTo(r3)
            if (r0 < 0) goto L38
            r0 = r2
            goto L39
        L38:
            r0 = r1
        L39:
            if (r0 == 0) goto L3c
        L3b:
            r1 = r2
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.a.a():boolean");
    }
}
