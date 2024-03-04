package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.x;
import java.util.HashSet;

/* loaded from: classes.dex */
public class q extends androidx.fragment.app.n {
    public final com.bumptech.glide.manager.a W;
    public final a X;
    public final HashSet Y;
    public q Z;

    /* renamed from: a0 */
    public com.bumptech.glide.n f2733a0;

    /* renamed from: b0 */
    public androidx.fragment.app.n f2734b0;

    /* loaded from: classes.dex */
    public class a implements m {
        public a() {
            q.this = r1;
        }

        public final String toString() {
            return super.toString() + "{fragment=" + q.this + "}";
        }
    }

    public q() {
        com.bumptech.glide.manager.a aVar = new com.bumptech.glide.manager.a();
        this.X = new a();
        this.Y = new HashSet();
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
        q e = com.bumptech.glide.b.b(context).f2627j.e(xVar);
        this.Z = e;
        if (equals(e)) {
            return;
        }
        this.Z.Y.add(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.n] */
    @Override // androidx.fragment.app.n
    public final void s(Context context) {
        super.s(context);
        q qVar = this;
        while (true) {
            ?? r02 = qVar.f1718z;
            if (r02 == 0) {
                break;
            }
            qVar = r02;
        }
        x xVar = qVar.f1715w;
        if (xVar == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
                return;
            }
            return;
        }
        try {
            P(j(), xVar);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // androidx.fragment.app.n
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        androidx.fragment.app.n nVar = this.f1718z;
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
