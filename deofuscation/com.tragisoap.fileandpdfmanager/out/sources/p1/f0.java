package p1;

import android.view.View;
import android.view.ViewGroup;
import f5.g;
import i5.d;
import k5.e;
import k5.h;
import q5.p;
import y5.f;
@e(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", l = {119, 121}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f0 extends h implements p<f<? super View>, d<? super g>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f5482h;

    /* renamed from: i  reason: collision with root package name */
    public View f5483i;

    /* renamed from: j  reason: collision with root package name */
    public int f5484j;

    /* renamed from: k  reason: collision with root package name */
    public int f5485k;

    /* renamed from: l  reason: collision with root package name */
    public int f5486l;
    public /* synthetic */ Object m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5487n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(ViewGroup viewGroup, d<? super f0> dVar) {
        super(dVar);
        this.f5487n = viewGroup;
    }

    @Override // q5.p
    public final Object i(f<? super View> fVar, d<? super g> dVar) {
        return ((f0) p(fVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        f0 f0Var = new f0(this.f5487n, dVar);
        f0Var.m = obj;
        return f0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    @Override // k5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r11) {
        /*
            r10 = this;
            j5.a r0 = j5.a.f4591f
            int r1 = r10.f5486l
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            int r1 = r10.f5485k
            int r4 = r10.f5484j
            android.view.ViewGroup r5 = r10.f5482h
            java.lang.Object r6 = r10.m
            y5.f r6 = (y5.f) r6
            f5.e.b(r11)
            goto L_0x0096
        L_0x001b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0023:
            int r1 = r10.f5485k
            int r4 = r10.f5484j
            android.view.View r5 = r10.f5483i
            android.view.ViewGroup r6 = r10.f5482h
            java.lang.Object r7 = r10.m
            y5.f r7 = (y5.f) r7
            f5.e.b(r11)
            r11 = r7
            goto L_0x0060
        L_0x0034:
            f5.e.b(r11)
            java.lang.Object r11 = r10.m
            y5.f r11 = (y5.f) r11
            android.view.ViewGroup r1 = r10.f5487n
            r4 = 0
            int r5 = r1.getChildCount()
        L_0x0042:
            if (r4 >= r5) goto L_0x009f
            android.view.View r6 = r1.getChildAt(r4)
            r10.m = r11
            r10.f5482h = r1
            r10.f5483i = r6
            r10.f5484j = r4
            r10.f5485k = r5
            r10.f5486l = r3
            r11.b(r6, r10)
            j5.a r7 = j5.a.f4591f
            if (r7 != r0) goto L_0x005c
            return r0
        L_0x005c:
            r9 = r6
            r6 = r1
            r1 = r5
            r5 = r9
        L_0x0060:
            boolean r7 = r5 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x009b
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
            j5.a r7 = j5.a.f4591f
            if (r5 != r7) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            f5.g r5 = f5.g.f4141a
        L_0x0091:
            if (r5 != r0) goto L_0x0094
            return r0
        L_0x0094:
            r5 = r6
            r6 = r11
        L_0x0096:
            r11 = r6
            r9 = r5
            r5 = r1
            r1 = r9
            goto L_0x009d
        L_0x009b:
            r5 = r1
            r1 = r6
        L_0x009d:
            int r4 = r4 + r3
            goto L_0x0042
        L_0x009f:
            f5.g r10 = f5.g.f4141a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.f0.s(java.lang.Object):java.lang.Object");
    }
}
