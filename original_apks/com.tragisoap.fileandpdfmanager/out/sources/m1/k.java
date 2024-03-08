package m1;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o.f;
import o.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k {

    /* renamed from: b */
    public static final ThreadPoolExecutor f5061b;

    /* renamed from: a */
    public static final f<String, Typeface> f5060a = new f<>(16);

    /* renamed from: c */
    public static final Object f5062c = new Object();

    /* renamed from: d */
    public static final h<String, ArrayList<o1.a<a>>> f5063d = new h<>();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a */
        public final Typeface f5064a;

        /* renamed from: b */
        public final int f5065b;

        public a(int i7) {
            this.f5064a = null;
            this.f5065b = i7;
        }

        @SuppressLint({"WrongConstant"})
        public a(Typeface typeface) {
            this.f5064a = typeface;
            this.f5065b = 0;
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new n());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f5061b = threadPoolExecutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m1.k.a a(java.lang.String r6, android.content.Context r7, m1.f r8, int r9) {
        /*
            o.f<java.lang.String, android.graphics.Typeface> r0 = m1.k.f5060a
            java.lang.Object r0 = r0.a(r6)
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0
            if (r0 == 0) goto L_0x0010
            m1.k$a r6 = new m1.k$a
            r6.<init>(r0)
            return r6
        L_0x0010:
            m1.l r8 = m1.e.a(r7, r8)     // Catch: NameNotFoundException -> 0x005e
            int r0 = r8.f5066a
            r1 = -3
            r2 = 1
            if (r0 == 0) goto L_0x001f
            if (r0 == r2) goto L_0x001d
            goto L_0x0034
        L_0x001d:
            r0 = -2
            goto L_0x003d
        L_0x001f:
            m1.m[] r0 = r8.f5067b
            if (r0 == 0) goto L_0x003c
            int r3 = r0.length
            if (r3 != 0) goto L_0x0027
            goto L_0x003c
        L_0x0027:
            int r2 = r0.length
            r3 = 0
            r4 = r3
        L_0x002a:
            if (r4 >= r2) goto L_0x003b
            r5 = r0[r4]
            int r5 = r5.e
            if (r5 == 0) goto L_0x0038
            if (r5 >= 0) goto L_0x0036
        L_0x0034:
            r0 = r1
            goto L_0x003d
        L_0x0036:
            r0 = r5
            goto L_0x003d
        L_0x0038:
            int r4 = r4 + 1
            goto L_0x002a
        L_0x003b:
            r2 = r3
        L_0x003c:
            r0 = r2
        L_0x003d:
            if (r0 == 0) goto L_0x0045
            m1.k$a r6 = new m1.k$a
            r6.<init>(r0)
            return r6
        L_0x0045:
            m1.m[] r8 = r8.f5067b
            android.graphics.Typeface r7 = i1.e.a(r7, r8, r9)
            if (r7 == 0) goto L_0x0058
            o.f<java.lang.String, android.graphics.Typeface> r8 = m1.k.f5060a
            r8.b(r6, r7)
            m1.k$a r6 = new m1.k$a
            r6.<init>(r7)
            return r6
        L_0x0058:
            m1.k$a r6 = new m1.k$a
            r6.<init>(r1)
            return r6
        L_0x005e:
            m1.k$a r6 = new m1.k$a
            r7 = -1
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.k.a(java.lang.String, android.content.Context, m1.f, int):m1.k$a");
    }
}
