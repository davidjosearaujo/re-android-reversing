package b6;

import a6.b1;
import a6.h;
import a6.h0;
import a6.u0;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.s0;
import f6.m;
import g6.c;
import i5.f;
import java.util.concurrent.CancellationException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends f {
    private volatile e _immediate;

    /* renamed from: h */
    public final Handler f2454h;

    /* renamed from: i */
    public final String f2455i;

    /* renamed from: j */
    public final boolean f2456j;

    /* renamed from: k */
    public final e f2457k;

    public e() {
        throw null;
    }

    public e(Handler handler) {
        this(handler, null, false);
    }

    @Override // a6.d0
    public final void J(long j7, h hVar) {
        c cVar = new c(hVar, this);
        Handler handler = this.f2454h;
        if (j7 > 4611686018427387903L) {
            j7 = 4611686018427387903L;
        }
        if (handler.postDelayed(cVar, j7)) {
            hVar.w(new d(this, cVar));
        } else {
            X(hVar.f296j, cVar);
        }
    }

    @Override // a6.u
    public final void U(f fVar, Runnable runnable) {
        if (!this.f2454h.post(runnable)) {
            X(fVar, runnable);
        }
    }

    @Override // a6.u
    public final boolean V() {
        return !this.f2456j || !r5.h.a(Looper.myLooper(), this.f2454h.getLooper());
    }

    @Override // a6.b1
    public final b1 W() {
        return this.f2457k;
    }

    public final void X(f fVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        u0 u0Var = (u0) fVar.e(u0.b.f341f);
        if (u0Var != null) {
            u0Var.d(cancellationException);
        }
        h0.f298b.U(fVar, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && ((e) obj).f2454h == this.f2454h;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f2454h);
    }

    @Override // a6.b1, a6.u
    public final String toString() {
        String str;
        b1 b1Var;
        c cVar = h0.f297a;
        b1 b1Var2 = m.f4172a;
        if (this == b1Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                b1Var = b1Var2.W();
            } catch (UnsupportedOperationException unused) {
                b1Var = null;
            }
            str = this == b1Var ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String str2 = this.f2455i;
        if (str2 == null) {
            str2 = this.f2454h.toString();
        }
        return this.f2456j ? s0.h(str2, ".immediate") : str2;
    }

    public e(Handler handler, String str, boolean z6) {
        this.f2454h = handler;
        this.f2455i = str;
        this.f2456j = z6;
        this._immediate = z6 ? this : null;
        e eVar = this._immediate;
        if (eVar == null) {
            eVar = new e(handler, str, true);
            this._immediate = eVar;
        }
        this.f2457k = eVar;
    }
}
