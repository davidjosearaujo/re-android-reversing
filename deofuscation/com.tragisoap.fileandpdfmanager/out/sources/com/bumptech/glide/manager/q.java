package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.n;
import androidx.fragment.app.x;
import com.bumptech.glide.b;
import java.util.HashSet;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class q extends n {
    public final a W;
    public final a X = new a();
    public final HashSet Y = new HashSet();
    public q Z;

    /* renamed from: a0  reason: collision with root package name */
    public com.bumptech.glide.n f2733a0;

    /* renamed from: b0  reason: collision with root package name */
    public n f2734b0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements m {
        public a() {
        }

        public final String toString() {
            return super.toString() + "{fragment=" + q.this + "}";
        }
    }

    public q() {
        a aVar = new a();
        this.W = aVar;
    }

    @Override // androidx.fragment.app.n
    public final void B() {
        this.H = true;
        this.W.c();
    }

    @Override // androidx.fragment.app.n
    public final void C() {
        this.H = true;
        this.W.e();
    }

    public final void P(Context context, x xVar) {
        q qVar = this.Z;
        if (qVar != null) {
            qVar.Y.remove(this);
            this.Z = null;
        }
        q e = b.b(context).f2627j.e(xVar);
        this.Z = e;
        if (!equals(e)) {
            this.Z.Y.add(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.n] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // androidx.fragment.app.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(android.content.Context r4) {
        /*
            r3 = this;
            super.s(r4)
            r4 = r3
        L_0x0004:
            androidx.fragment.app.n r0 = r4.f1718z
            if (r0 == 0) goto L_0x000a
            r4 = r0
            goto L_0x0004
        L_0x000a:
            androidx.fragment.app.x r4 = r4.f1715w
            r0 = 5
            java.lang.String r1 = "SupportRMFragment"
            if (r4 != 0) goto L_0x001d
            boolean r3 = android.util.Log.isLoggable(r1, r0)
            if (r3 == 0) goto L_0x001c
            java.lang.String r3 = "Unable to register fragment with root, ancestor detached"
            android.util.Log.w(r1, r3)
        L_0x001c:
            return
        L_0x001d:
            android.content.Context r2 = r3.j()     // Catch: IllegalStateException -> 0x0025
            r3.P(r2, r4)     // Catch: IllegalStateException -> 0x0025
            goto L_0x0031
        L_0x0025:
            r3 = move-exception
            boolean r4 = android.util.Log.isLoggable(r1, r0)
            if (r4 == 0) goto L_0x0031
            java.lang.String r4 = "Unable to register fragment with root"
            android.util.Log.w(r1, r4, r3)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.q.s(android.content.Context):void");
    }

    @Override // androidx.fragment.app.n, java.lang.Object
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        n nVar = this.f1718z;
        if (nVar == null) {
            nVar = this.f2734b0;
        }
        sb.append(nVar);
        sb.append("}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.n
    public final void v() {
        this.H = true;
        this.W.b();
        q qVar = this.Z;
        if (qVar != null) {
            qVar.Y.remove(this);
            this.Z = null;
        }
    }

    @Override // androidx.fragment.app.n
    public final void x() {
        this.H = true;
        this.f2734b0 = null;
        q qVar = this.Z;
        if (qVar != null) {
            qVar.Y.remove(this);
            this.Z = null;
        }
    }
}
