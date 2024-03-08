package com.rajat.pdfviewer;

import a0.e;
import a6.x;
import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {

    /* renamed from: a */
    public final x f3470a;

    /* renamed from: b */
    public final v4.a f3471b;

    /* renamed from: c */
    public final String f3472c;

    /* renamed from: d */
    public final a f3473d;
    public String e;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        Context a();

        void b(Exception exc);

        void c(long j7, long j8);

        void d(String str);

        void e();
    }

    public b(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, v4.a aVar, String str, d dVar) {
        h.f(aVar, "headers");
        this.f3470a = lifecycleCoroutineScopeImpl;
        this.f3471b = aVar;
        this.f3472c = str;
        this.f3473d = dVar;
        e.u(lifecycleCoroutineScopeImpl, null, 0, new a(this, null), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.rajat.pdfviewer.b r7, java.lang.String r8, i5.d r9) {
        /*
            r7.getClass()
            boolean r0 = r9 instanceof v4.c
            if (r0 == 0) goto L_0x0016
            r0 = r9
            v4.c r0 = (v4.c) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0016
            int r1 = r1 - r2
            r0.m = r1
            goto L_0x001b
        L_0x0016:
            v4.c r0 = new v4.c
            r0.<init>(r7, r9)
        L_0x001b:
            java.lang.Object r9 = r0.f6272k
            j5.a r1 = j5.a.f4591f
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.String r7 = r0.f6271j
            com.rajat.pdfviewer.b r8 = r0.f6270i
            f5.e.b(r9)
            r9 = r7
            r7 = r8
            goto L_0x00ba
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0039:
            f5.e.b(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r2 = r8.hashCode()
            r9.append(r2)
            java.lang.String r2 = ".pdf"
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            java.lang.String r2 = r7.e
            boolean r2 = r5.h.a(r2, r9)
            if (r2 != 0) goto L_0x007a
            com.rajat.pdfviewer.b$a r2 = r7.f3473d
            android.content.Context r2 = r2.a()
            java.io.File r2 = r2.getCacheDir()
            v4.b r4 = new v4.b
            r4.<init>(r9)
            java.io.File[] r2 = r2.listFiles(r4)
            if (r2 == 0) goto L_0x007a
            r4 = 0
            int r5 = r2.length
        L_0x0070:
            if (r4 >= r5) goto L_0x007a
            r6 = r2[r4]
            r6.delete()
            int r4 = r4 + 1
            goto L_0x0070
        L_0x007a:
            java.io.File r2 = new java.io.File
            com.rajat.pdfviewer.b$a r4 = r7.f3473d
            android.content.Context r4 = r4.a()
            java.io.File r4 = r4.getCacheDir()
            r2.<init>(r4, r9)
            boolean r4 = r2.exists()
            if (r4 == 0) goto L_0x009e
            com.rajat.pdfviewer.b$a r8 = r7.f3473d
            java.lang.String r0 = r2.getAbsolutePath()
            java.lang.String r1 = "getAbsolutePath(...)"
            r5.h.e(r0, r1)
            r8.d(r0)
            goto L_0x00ba
        L_0x009e:
            r0.f6270i = r7
            r0.f6271j = r9
            r0.m = r3
            g6.b r2 = a6.h0.f298b
            com.rajat.pdfviewer.c r3 = new com.rajat.pdfviewer.c
            r4 = 0
            r3.<init>(r7, r9, r8, r4)
            java.lang.Object r8 = a0.e.L(r2, r3, r0)
            j5.a r0 = j5.a.f4591f
            if (r8 != r0) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            f5.g r8 = f5.g.f4141a
        L_0x00b7:
            if (r8 != r1) goto L_0x00ba
            goto L_0x00be
        L_0x00ba:
            r7.e = r9
            f5.g r1 = f5.g.f4141a
        L_0x00be:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rajat.pdfviewer.b.a(com.rajat.pdfviewer.b, java.lang.String, i5.d):java.lang.Object");
    }
}
