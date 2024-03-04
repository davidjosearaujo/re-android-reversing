package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;

@k5.e(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", l = {115, 121}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class g0 extends k5.i implements q5.p {

    /* renamed from: j */
    public c6.g f1152j;

    /* renamed from: k */
    public int f1153k;

    /* renamed from: l */
    public /* synthetic */ Object f1154l;
    public final /* synthetic */ ContentResolver m;

    /* renamed from: n */
    public final /* synthetic */ Uri f1155n;

    /* renamed from: o */
    public final /* synthetic */ h0 f1156o;

    /* renamed from: p */
    public final /* synthetic */ c6.e f1157p;

    /* renamed from: q */
    public final /* synthetic */ Context f1158q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(ContentResolver contentResolver, Uri uri, h0 h0Var, c6.e eVar, Context context, i5.d dVar) {
        super(2, dVar);
        this.m = contentResolver;
        this.f1155n = uri;
        this.f1156o = h0Var;
        this.f1157p = eVar;
        this.f1158q = context;
    }

    public final Object i(Object obj, Object obj2) {
        return ((g0) p((d6.d) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        g0 g0Var = new g0(this.m, this.f1155n, this.f1156o, this.f1157p, this.f1158q, dVar);
        g0Var.f1154l = obj;
        return g0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0058 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #0 {all -> 0x0085, blocks: (B:39:0x0012, B:48:0x0040, B:52:0x0050, B:54:0x0058, B:44:0x0025, B:47:0x003a), top: B:62:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0078 -> B:40:0x0015). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(java.lang.Object r9) {
        /*
            r8 = this;
            j5.a r0 = Kotlin_1.a.f4591f
            int r1 = r8.f1153k
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L29
            if (r1 == r2) goto L1f
            if (r1 != r3) goto L17
            c6.g r1 = r8.f1152j
            java.lang.Object r4 = r8.f1154l
            d6.d r4 = (d6.d) r4
            f5.e.b(r9)     // Catch: java.lang.Throwable -> L85
        L15:
            r9 = r4
            goto L40
        L17:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1f:
            c6.g r1 = r8.f1152j
            java.lang.Object r4 = r8.f1154l
            d6.d r4 = (d6.d) r4
            f5.e.b(r9)     // Catch: java.lang.Throwable -> L85
            goto L50
        L29:
            f5.e.b(r9)
            java.lang.Object r9 = r8.f1154l
            d6.d r9 = (d6.d) r9
            android.content.ContentResolver r1 = r8.m
            android.net.Uri r4 = r8.f1155n
            r5 = 0
            androidx.compose.ui.platform.h0 r6 = r8.f1156o
            r1.registerContentObserver(r4, r5, r6)
            c6.e r1 = r8.f1157p     // Catch: java.lang.Throwable -> L85
            c6.g r1 = r1.iterator()     // Catch: java.lang.Throwable -> L85
        L40:
            r8.f1154l = r9     // Catch: java.lang.Throwable -> L85
            r8.f1152j = r1     // Catch: java.lang.Throwable -> L85
            r8.f1153k = r2     // Catch: java.lang.Throwable -> L85
            java.lang.Object r4 = r1.a(r8)     // Catch: java.lang.Throwable -> L85
            if (r4 != r0) goto L4d
            return r0
        L4d:
            r7 = r4
            r4 = r9
            r9 = r7
        L50:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L85
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L85
            if (r9 == 0) goto L7b
            r1.next()     // Catch: java.lang.Throwable -> L85
            android.content.Context r9 = r8.f1158q     // Catch: java.lang.Throwable -> L85
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L85
            java.lang.String r5 = "animator_duration_scale"
            r6 = 1065353216(0x3f800000, float:1.0)
            float r9 = android.provider.Settings.Global.getFloat(r9, r5, r6)     // Catch: java.lang.Throwable -> L85
            java.lang.Float r5 = new java.lang.Float     // Catch: java.lang.Throwable -> L85
            r5.<init>(r9)     // Catch: java.lang.Throwable -> L85
            r8.f1154l = r4     // Catch: java.lang.Throwable -> L85
            r8.f1152j = r1     // Catch: java.lang.Throwable -> L85
            r8.f1153k = r3     // Catch: java.lang.Throwable -> L85
            java.lang.Object r9 = r4.m(r5, r8)     // Catch: java.lang.Throwable -> L85
            if (r9 != r0) goto L15
            return r0
        L7b:
            android.content.ContentResolver r9 = r8.m
            androidx.compose.ui.platform.h0 r8 = r8.f1156o
            r9.unregisterContentObserver(r8)
            f5.g r8 = f5.g.f4141a
            return r8
        L85:
            r9 = move-exception
            android.content.ContentResolver r0 = r8.m
            androidx.compose.ui.platform.h0 r8 = r8.f1156o
            r0.unregisterContentObserver(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.g0.s(java.lang.Object):java.lang.Object");
    }
}
