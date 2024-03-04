package p1;

import android.view.View;
import android.view.ViewGroup;

@k5.e(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", l = {119, 121}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class f0 extends k5.h implements q5.p {

    /* renamed from: h */
    public ViewGroup f5482h;

    /* renamed from: i */
    public View f5483i;

    /* renamed from: j */
    public int f5484j;

    /* renamed from: k */
    public int f5485k;

    /* renamed from: l */
    public int f5486l;
    public /* synthetic */ Object m;

    /* renamed from: n */
    public final /* synthetic */ ViewGroup f5487n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(ViewGroup viewGroup, i5.d dVar) {
        super(dVar);
        this.f5487n = viewGroup;
    }

    public final Object i(Object obj, Object obj2) {
        return ((f0) p((y5.f) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        f0 f0Var = new f0(this.f5487n, dVar);
        f0Var.m = obj;
        return f0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0094 -> B:55:0x0096). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x009b -> B:57:0x009d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(java.lang.Object r11) {
        /*
            r10 = this;
            j5.a r0 = Kotlin_1.a.f4591f
            int r1 = r10.f5486l
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            int r1 = r10.f5485k
            int r4 = r10.f5484j
            android.view.ViewGroup r5 = r10.f5482h
            java.lang.Object r6 = r10.m
            y5.f r6 = (y5.f) r6
            f5.e.b(r11)
            goto L96
        L1b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L23:
            int r1 = r10.f5485k
            int r4 = r10.f5484j
            android.view.View r5 = r10.f5483i
            android.view.ViewGroup r6 = r10.f5482h
            java.lang.Object r7 = r10.m
            y5.f r7 = (y5.f) r7
            f5.e.b(r11)
            r11 = r7
            goto L60
        L34:
            f5.e.b(r11)
            java.lang.Object r11 = r10.m
            y5.f r11 = (y5.f) r11
            android.view.ViewGroup r1 = r10.f5487n
            r4 = 0
            int r5 = r1.getChildCount()
        L42:
            if (r4 >= r5) goto L9f
            android.view.View r6 = r1.getChildAt(r4)
            r10.m = r11
            r10.f5482h = r1
            r10.f5483i = r6
            r10.f5484j = r4
            r10.f5485k = r5
            r10.f5486l = r3
            r11.b(r6, r10)
            j5.a r7 = Kotlin_1.a.f4591f
            if (r7 != r0) goto L5c
            return r0
        L5c:
            r9 = r6
            r6 = r1
            r1 = r5
            r5 = r9
        L60:
            boolean r7 = r5 instanceof android.view.ViewGroup
            if (r7 == 0) goto L9b
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            p1.f0 r7 = new p1.f0
            r8 = 0
            r7.<init>(r5, r8)
            r10.m = r11
            r10.f5482h = r6
            r10.f5483i = r8
            r10.f5484j = r4
            r10.f5485k = r1
            r10.f5486l = r2
            r11.getClass()
            y5.e r5 = new y5.e
            r5.<init>()
            i5.d r7 = q2.a.p(r5, r5, r7)
            r5.f6843i = r7
            java.lang.Object r5 = r11.d(r5, r10)
            j5.a r7 = Kotlin_1.a.f4591f
            if (r5 != r7) goto L8f
            goto L91
        L8f:
            f5.g r5 = f5.g.f4141a
        L91:
            if (r5 != r0) goto L94
            return r0
        L94:
            r5 = r6
            r6 = r11
        L96:
            r11 = r6
            r9 = r5
            r5 = r1
            r1 = r9
            goto L9d
        L9b:
            r5 = r1
            r1 = r6
        L9d:
            int r4 = r4 + r3
            goto L42
        L9f:
            f5.g r10 = f5.g.f4141a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.f0.s(java.lang.Object):java.lang.Object");
    }
}
