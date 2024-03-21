package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b.a.a.a.e.a0;
import b.a.a.a.e.f;
import b.a.a.a.e.g0;
import b.a.a.a.e.j;
import b.a.a.a.e.j0;
import b.a.a.a.e.t;
import b.a.a.a.e.v;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.AbstractC0005a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.e0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class d<O extends a.AbstractC0005a> {
    private static short[] $ = {2500, 2559, 2534, 2534, 2474, 2537, 2533, 2532, 2558, 2543, 2546, 2558, 2474, 2531, 2553, 2474, 2532, 2533, 2558, 2474, 2554, 2543, 2552, 2535, 2531, 2558, 2558, 2543, 2542, 2468, 1469, 1420, 1429, 1500, 1425, 1417, 1423, 1416, 1500, 1426, 1427, 1416, 1500, 1438, 1433, 1500, 1426, 1417, 1424, 1424, 1490, 5123, 5173, 5156, 5156, 5177, 5182, 5175, 5155, 5232, 5181, 5157, 5155, 5156, 5232, 5182, 5183, 5156, 5232, 5170, 5173, 5232, 5182, 5157, 5180, 5180, 5227, 5232, 5157, 5155, 5173, 5232, 5123, 5173, 5156, 5156, 5177, 5182, 5175, 5155, 5246, 5140, 5141, 5142, 5137, 5125, 5148, 5124, 5135, 5123, 5141, 5124, 5124, 5145, 5150, 5143, 5123, 5232, 5177, 5182, 5155, 5156, 5173, 5169, 5172, 5246};

    /* renamed from: a */
    private final Context f233a;

    /* renamed from: b */
    private final a<O> f234b;
    private final O c;
    private final f<O> d;
    private final Looper e;
    private final int f;
    private final e g;
    private final Account h;
    protected final t i;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class a {

        /* renamed from: a */
        public final j0 f235a;

        /* renamed from: b */
        public final Account f236b;
        public final Looper c;

        static {
            new o().b();
        }

        private a(j0 j0Var, Account account, Looper looper) {
            this.f235a = j0Var;
            this.f236b = account;
            this.c = looper;
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(android.content.Context r6, com.google.android.gms.common.api.a<O> r7, O r8, b.a.a.a.e.j0 r9) {
        /*
            r5 = this;
            r1 = r5
            r2 = r6
            r3 = r7
            r4 = r8
            r5 = r9
            com.google.android.gms.common.api.o r0 = new com.google.android.gms.common.api.o
            r0.<init>()
            r0.a(r5)
            com.google.android.gms.common.api.d$a r5 = r0.b()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.d.<init>(android.content.Context, com.google.android.gms.common.api.a, com.google.android.gms.common.api.a$a, b.a.a.a.e.j0):void");
    }

    public d(Context context, a<O> aVar, O o, a aVar2) {
        e0.e(context, $(0, 30, 2442));
        e0.e(aVar, $(30, 51, 1532));
        e0.e(aVar2, $(51, 116, 5200));
        this.f233a = context.getApplicationContext();
        this.f234b = aVar;
        this.c = o;
        this.e = aVar2.c;
        this.d = f.a(aVar, o);
        this.g = new a0(this);
        t e = t.e(this.f233a);
        this.i = e;
        this.f = e.s();
        j0 j0Var = aVar2.f235a;
        this.h = aVar2.f236b;
        this.i.g(this);
    }

    private final <A extends a.c, T extends j<? extends j, A>> T d(int i, T t) {
        t.j();
        this.i.d(this, i, t);
        return t;
    }

    public final int a() {
        return this.f;
    }

    public final Looper b() {
        return this.e;
    }

    public a.f c(Looper looper, v<O> vVar) {
        e.a aVar = new e.a(this.f233a);
        aVar.a(this.h);
        return this.f234b.b().a(this.f233a, looper, aVar.b(), this.c, vVar, vVar);
    }

    public final <A extends a.c, T extends j<? extends j, A>> T e(T t) {
        d(0, t);
        return t;
    }

    public g0 f(Context context, Handler handler) {
        return new g0(context, handler);
    }

    public final f<O> g() {
        return this.d;
    }

    public final e h() {
        return this.g;
    }
}
