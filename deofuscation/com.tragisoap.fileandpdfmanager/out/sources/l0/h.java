package l0;

import a0.e;
import android.graphics.Paint;
import b0.c;
import b0.f;
import x.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h extends w {

    /* renamed from: o */
    public static final c f4854o;

    /* renamed from: n */
    public final j0 f4855n;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class a extends u {
        public a(h hVar) {
            super(hVar);
        }
    }

    static {
        c cVar = new c();
        long j7 = f.f2341b;
        Paint paint = cVar.f2338a;
        r5.h.f(paint, "$this$setNativeColor");
        paint.setColor(e.F(j7));
        Paint paint2 = cVar.f2338a;
        r5.h.f(paint2, "<this>");
        paint2.setStrokeWidth(1.0f);
        Paint paint3 = cVar.f2338a;
        r5.h.f(paint3, "$this$setNativeStyle");
        paint3.setStyle(Paint.Style.STROKE);
        f4854o = cVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(o oVar) {
        super(oVar);
        r5.h.f(oVar, "layoutNode");
        j0 j0Var = new j0();
        this.f4855n = j0Var;
        j0Var.f6422c = this;
        oVar.getClass();
    }

    @Override // l0.w
    public final a.b q() {
        return this.f4855n;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // l0.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(l0.w.d r17, long r18, l0.g r20, boolean r21, boolean r22) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            r8 = r18
            r10 = r20
            java.lang.String r1 = "hitTestSource"
            r5.h.f(r7, r1)
            java.lang.String r1 = "hitTestResult"
            r5.h.f(r10, r1)
            l0.o r1 = r0.f4888h
            boolean r1 = r7.c(r1)
            r11 = 1
            if (r1 == 0) goto L_0x0043
            boolean r1 = r0.B(r8)
            if (r1 == 0) goto L_0x0025
            r12 = r22
        L_0x0023:
            r1 = r11
            goto L_0x0046
        L_0x0025:
            if (r21 == 0) goto L_0x0043
            long r1 = r16.p()
            float r1 = r0.h(r8, r1)
            boolean r2 = java.lang.Float.isInfinite(r1)
            if (r2 != 0) goto L_0x003d
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x003d
            r1 = r11
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1 = 0
            r12 = r1
            goto L_0x0023
        L_0x0043:
            r1 = 0
            r12 = r22
        L_0x0046:
            if (r1 == 0) goto L_0x00c2
            int r13 = r10.f4845h
            l0.o r0 = r0.f4888h
            q.e r0 = r0.e()
            int r1 = r0.f5605h
            if (r1 <= 0) goto L_0x00c0
            int r1 = r1 - r11
            T[] r14 = r0.f5603f
            r15 = r1
        L_0x0058:
            r0 = r14[r15]
            r6 = r0
            l0.o r6 = (l0.o) r6
            boolean r0 = r6.j()
            if (r0 == 0) goto L_0x00b6
            r0 = r17
            r1 = r6
            r2 = r18
            r4 = r20
            r5 = r21
            r11 = r6
            r6 = r12
            r0.a(r1, r2, r4, r5, r6)
            long r0 = r20.a()
            r2 = 32
            long r2 = r0 >> r2
            int r2 = (int) r2
            float r2 = java.lang.Float.intBitsToFloat(r2)
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x008b
            boolean r0 = a0.b.n(r0)
            if (r0 == 0) goto L_0x008b
            r0 = 1
            goto L_0x008c
        L_0x008b:
            r0 = 0
        L_0x008c:
            if (r0 != 0) goto L_0x0090
            r0 = 1
            goto L_0x00a1
        L_0x0090:
            l0.v r0 = r11.s
            l0.w r0 = r0.f4884b
            r1 = 16
            boolean r1 = l0.a0.b(r1)
            x.a$b r0 = r0.s(r1)
            if (r0 != 0) goto L_0x00a5
            r0 = 0
        L_0x00a1:
            if (r0 != 0) goto L_0x00b6
            r0 = 1
            goto L_0x00b7
        L_0x00a5:
            x.a$b r0 = r0.f6420a
            r0.getClass()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitLocalDescendants called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00b6:
            r0 = 0
        L_0x00b7:
            if (r0 != 0) goto L_0x00c0
            int r15 = r15 + -1
            if (r15 >= 0) goto L_0x00be
            goto L_0x00c0
        L_0x00be:
            r11 = 1
            goto L_0x0058
        L_0x00c0:
            r10.f4845h = r13
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.h.w(l0.w$d, long, l0.g, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // l0.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(b0.d r7) {
        /*
            r6 = this;
            java.lang.String r0 = "canvas"
            r5.h.f(r7, r0)
            l0.o r0 = r6.f4888h
            l0.c0 r0 = a0.e.B(r0)
            l0.o r1 = r6.f4888h
            q.e r1 = r1.e()
            int r2 = r1.f5605h
            if (r2 <= 0) goto L_0x0029
            r3 = 0
            T[] r1 = r1.f5603f
        L_0x0018:
            r4 = r1[r3]
            l0.o r4 = (l0.o) r4
            boolean r5 = r4.j()
            if (r5 == 0) goto L_0x0025
            r4.a(r7)
        L_0x0025:
            int r3 = r3 + 1
            if (r3 < r2) goto L_0x0018
        L_0x0029:
            boolean r0 = r0.getShowLayoutBounds()
            if (r0 == 0) goto L_0x0034
            b0.c r0 = l0.h.f4854o
            r6.m(r7, r0)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.h.z(b0.d):void");
    }
}
