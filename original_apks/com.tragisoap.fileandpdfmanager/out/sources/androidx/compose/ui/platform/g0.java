package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import d6.d;
import f5.g;
import k5.e;
import k5.i;
import q5.p;
@e(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", l = {115, 121}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g0 extends i implements p<d<? super Float>, i5.d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public c6.g f1152j;

    /* renamed from: k  reason: collision with root package name */
    public int f1153k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f1154l;
    public final /* synthetic */ ContentResolver m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Uri f1155n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ h0 f1156o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ c6.e<g> f1157p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Context f1158q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(ContentResolver contentResolver, Uri uri, h0 h0Var, c6.e<g> eVar, Context context, i5.d<? super g0> dVar) {
        super(2, dVar);
        this.m = contentResolver;
        this.f1155n = uri;
        this.f1156o = h0Var;
        this.f1157p = eVar;
        this.f1158q = context;
    }

    @Override // q5.p
    public final Object i(d<? super Float> dVar, i5.d<? super g> dVar2) {
        return ((g0) p(dVar, dVar2)).s(g.f4141a);
    }

    @Override // k5.a
    public final i5.d<g> p(Object obj, i5.d<?> dVar) {
        g0 g0Var = new g0(this.m, this.f1155n, this.f1156o, this.f1157p, this.f1158q, dVar);
        g0Var.f1154l = obj;
        return g0Var;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #0 {all -> 0x0085, blocks: (B:7:0x0012, B:12:0x0025, B:14:0x003a, B:15:0x0040, B:19:0x0050, B:21:0x0058), top: B:29:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    @Override // k5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r9) {
        /*
            r8 = this;
            j5.a r0 = j5.a.f4591f
            int r1 = r8.f1153k
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L_0x0029
            if (r1 == r2) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            c6.g r1 = r8.f1152j
            java.lang.Object r4 = r8.f1154l
            d6.d r4 = (d6.d) r4
            f5.e.b(r9)     // Catch: all -> 0x0085
        L_0x0015:
            r9 = r4
            goto L_0x0040
        L_0x0017:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x001f:
            c6.g r1 = r8.f1152j
            java.lang.Object r4 = r8.f1154l
            d6.d r4 = (d6.d) r4
            f5.e.b(r9)     // Catch: all -> 0x0085
            goto L_0x0050
        L_0x0029:
            f5.e.b(r9)
            java.lang.Object r9 = r8.f1154l
            d6.d r9 = (d6.d) r9
            android.content.ContentResolver r1 = r8.m
            android.net.Uri r4 = r8.f1155n
            r5 = 0
            androidx.compose.ui.platform.h0 r6 = r8.f1156o
            r1.registerContentObserver(r4, r5, r6)
            c6.e<f5.g> r1 = r8.f1157p     // Catch: all -> 0x0085
            c6.g r1 = r1.iterator()     // Catch: all -> 0x0085
        L_0x0040:
            r8.f1154l = r9     // Catch: all -> 0x0085
            r8.f1152j = r1     // Catch: all -> 0x0085
            r8.f1153k = r2     // Catch: all -> 0x0085
            java.lang.Object r4 = r1.a(r8)     // Catch: all -> 0x0085
            if (r4 != r0) goto L_0x004d
            return r0
        L_0x004d:
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x0050:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: all -> 0x0085
            boolean r9 = r9.booleanValue()     // Catch: all -> 0x0085
            if (r9 == 0) goto L_0x007b
            r1.next()     // Catch: all -> 0x0085
            android.content.Context r9 = r8.f1158q     // Catch: all -> 0x0085
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch: all -> 0x0085
            java.lang.String r5 = "animator_duration_scale"
            r6 = 1065353216(0x3f800000, float:1.0)
            float r9 = android.provider.Settings.Global.getFloat(r9, r5, r6)     // Catch: all -> 0x0085
            java.lang.Float r5 = new java.lang.Float     // Catch: all -> 0x0085
            r5.<init>(r9)     // Catch: all -> 0x0085
            r8.f1154l = r4     // Catch: all -> 0x0085
            r8.f1152j = r1     // Catch: all -> 0x0085
            r8.f1153k = r3     // Catch: all -> 0x0085
            java.lang.Object r9 = r4.m(r5, r8)     // Catch: all -> 0x0085
            if (r9 != r0) goto L_0x0015
            return r0
        L_0x007b:
            android.content.ContentResolver r9 = r8.m
            androidx.compose.ui.platform.h0 r8 = r8.f1156o
            r9.unregisterContentObserver(r8)
            f5.g r8 = f5.g.f4141a
            return r8
        L_0x0085:
            r9 = move-exception
            android.content.ContentResolver r0 = r8.m
            androidx.compose.ui.platform.h0 r8 = r8.f1156o
            r0.unregisterContentObserver(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.g0.s(java.lang.Object):java.lang.Object");
    }
}
