package l0;

import Graphics_1.PaintBase;
import android.graphics.Paint;
import x.a;

/* loaded from: classes.dex */
public final class h extends w {

    /* renamed from: o */
    public static final PaintBase f4854o;

    /* renamed from: n */
    public final j0 f4855n;

    /* loaded from: classes.dex */
    public final class a extends u {
        public a(h hVar) {
            super(hVar);
        }
    }

    static {
        PaintBase paintBase = new PaintBase();
        long j5 = Graphics_1.f.f2341b;
        Paint paint = paintBase.paint;
        r5.h.f(paint, "$this$setNativeColor");
        paint.setColor(a0.e.F(j5));
        Paint paint2 = paintBase.paint;
        r5.h.f(paint2, "<this>");
        paint2.setStrokeWidth(1.0f);
        Paint paint3 = paintBase.paint;
        r5.h.f(paint3, "$this$setNativeStyle");
        paint3.setStyle(Paint.Style.STROKE);
        f4854o = paintBase;
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

    public final a.b q() {
        return this.f4855n;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
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
            if (r1 == 0) goto L43
            boolean r1 = r0.B(r8)
            if (r1 == 0) goto L25
            r12 = r22
        L23:
            r1 = r11
            goto L46
        L25:
            if (r21 == 0) goto L43
            long r1 = r16.p()
            float r1 = r0.h(r8, r1)
            boolean r2 = java.lang.Float.isInfinite(r1)
            if (r2 != 0) goto L3d
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L3d
            r1 = r11
            goto L3e
        L3d:
            r1 = 0
        L3e:
            if (r1 == 0) goto L43
            r1 = 0
            r12 = r1
            goto L23
        L43:
            r1 = 0
            r12 = r22
        L46:
            if (r1 == 0) goto Lc2
            int r13 = r10.f4845h
            l0.o r0 = r0.f4888h
            q.e r0 = r0.e()
            int r1 = r0.f5605h
            if (r1 <= 0) goto Lc0
            int r1 = r1 - r11
            T[] r14 = r0.f5603f
            r15 = r1
        L58:
            r0 = r14[r15]
            r6 = r0
            l0.o r6 = (l0.o) r6
            boolean r0 = r6.j()
            if (r0 == 0) goto Lb6
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
            if (r2 >= 0) goto L8b
            boolean r0 = a0.b.n(r0)
            if (r0 == 0) goto L8b
            r0 = 1
            goto L8c
        L8b:
            r0 = 0
        L8c:
            if (r0 != 0) goto L90
            r0 = 1
            goto La1
        L90:
            l0.v r0 = r11.s
            l0.w r0 = r0.f4884b
            r1 = 16
            boolean r1 = l0.a0.b(r1)
            x.a$b r0 = r0.s(r1)
            if (r0 != 0) goto La5
            r0 = 0
        La1:
            if (r0 != 0) goto Lb6
            r0 = 1
            goto Lb7
        La5:
            x.a$b r0 = r0.f6420a
            r0.getClass()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitLocalDescendants called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        Lb6:
            r0 = 0
        Lb7:
            if (r0 != 0) goto Lc0
            int r15 = r15 + (-1)
            if (r15 >= 0) goto Lbe
            goto Lc0
        Lbe:
            r11 = 1
            goto L58
        Lc0:
            r10.f4845h = r13
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.h.w(l0.w$d, long, l0.g, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z(Graphics_1.CanvasOperations r7) {
        /*
            r6 = this;
            java.lang.String r0 = "canvas"
            r5.h.f(r7, r0)
            l0.o r0 = r6.f4888h
            l0.c0 r0 = a0.e.B(r0)
            l0.o r1 = r6.f4888h
            q.e r1 = r1.e()
            int r2 = r1.f5605h
            if (r2 <= 0) goto L29
            r3 = 0
            T[] r1 = r1.f5603f
        L18:
            r4 = r1[r3]
            l0.o r4 = (l0.o) r4
            boolean r5 = r4.j()
            if (r5 == 0) goto L25
            r4.a(r7)
        L25:
            int r3 = r3 + 1
            if (r3 < r2) goto L18
        L29:
            boolean r0 = r0.getShowLayoutBounds()
            if (r0 == 0) goto L34
            b0.c r0 = l0.h.f4854o
            r6.m(r7, r0)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.h.z(b0.d):void");
    }
}
