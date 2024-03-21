package b.a.a.a.e;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.AbstractC0005a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.j0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class v<O extends a.AbstractC0005a> implements e.b, e.c {
    private static short[] $ = {1505, 1520, 1513, 1434, 1408, 3784, 3713, 3739, 3784, 3718, 3719, 3740, 3784, 3721, 3742, 3721, 3713, 3716, 3721, 3722, 3716, 3725, 3784, 3719, 3718, 3784, 3740, 3712, 3713, 3739, 3784, 3724, 3725, 3742, 3713, 3723, 3725, 3782, 7874, 7918, 7919, 7919, 7908, 7906, 7925, 7912, 7918, 7919, 7841, 7925, 7912, 7916, 7908, 7909, 7841, 7918, 7924, 7925, 7841, 7926, 7913, 7912, 7917, 7908, 7841, 7926, 7904, 7912, 7925, 7912, 7919, 7910, 7841, 7911, 7918, 7923, 7841, 7878, 7918, 7918, 7910, 7917, 7908, 7841, 7889, 7917, 7904, 7928, 7841, 7922, 7908, 7923, 7927, 7912, 7906, 7908, 7922, 7841, 7924, 7921, 7909, 7904, 7925, 7908, 7841, 7925, 7918, 7841, 7906, 7918, 7916, 7921, 7917, 7908, 7925, 7908, 7855, 7498, 7515, 7490, 7467, 7533, 7530, 7522, 7527, 7534, 7535, 7467, 7551, 7524, 7467, 7528, 7524, 7525, 7525, 7534, 7528, 7551, 7467, 7548, 7523, 7522, 7527, 7534, 7467, 7545, 7534, 7544, 7550, 7526, 7522, 7525, 7532, 7467, 7535, 7550, 7534, 7467, 7551, 7524, 7467, 7530, 7525, 7467, 7550, 7525, 7520, 7525, 7524, 7548, 7525, 7467, 7534, 7545, 7545, 7524, 7545, 7461};

    /* renamed from: b */
    private final a.f f183b;
    private final a.c c;
    private final f<O> d;
    private final p e;
    private final int h;
    private final g0 i;
    private boolean j;
    private /* synthetic */ t l;

    /* renamed from: a */
    private final Queue<a> f182a = new LinkedList();
    private final Set<g> f = new HashSet();
    private final Map<c0<?>, f0> g = new HashMap();
    private b.a.a.a.c.a k = null;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public v(t tVar, d<O> dVar) {
        this.l = tVar;
        a.f c = dVar.c(tVar.m.getLooper(), this);
        this.f183b = c;
        if (c instanceof j0) {
            j0 j0Var = (j0) c;
            this.c = null;
        } else {
            this.c = c;
        }
        this.d = dVar.g();
        this.e = new p();
        this.h = dVar.a();
        if (this.f183b.a()) {
            this.i = dVar.f(tVar.d, tVar.m);
        } else {
            this.i = null;
        }
    }

    private final void k(a aVar) {
        aVar.b(this.e, p());
        try {
            aVar.c(this);
        } catch (DeadObjectException unused) {
            a(1);
            this.f183b.e();
        }
    }

    public static /* synthetic */ void m(v vVar) {
        vVar.t();
    }

    private final void o(b.a.a.a.c.a aVar) {
        for (g gVar : this.f) {
            gVar.a(this.d, aVar);
        }
        this.f.clear();
    }

    public final void s() {
        v();
        o(b.a.a.a.c.a.e);
        x();
        for (f0 f0Var : this.g.values()) {
            try {
                f0Var.f149a.a(this.c, new b.a.a.a.g.d<>());
            } catch (DeadObjectException unused) {
                a(1);
                this.f183b.e();
            } catch (RemoteException unused2) {
            }
        }
        while (this.f183b.d() && !this.f182a.isEmpty()) {
            k(this.f182a.remove());
        }
        y();
    }

    public final void t() {
        v();
        this.j = true;
        this.e.f();
        this.l.m.sendMessageDelayed(Message.obtain(this.l.m, 9, this.d), this.l.f177a);
        this.l.m.sendMessageDelayed(Message.obtain(this.l.m, 11, this.d), this.l.f178b);
        this.l.f = -1;
    }

    private final void x() {
        if (this.j) {
            this.l.m.removeMessages(11, this.d);
            this.l.m.removeMessages(9, this.d);
            this.j = false;
        }
    }

    private final void y() {
        this.l.m.removeMessages(12, this.d);
        this.l.m.sendMessageDelayed(this.l.m.obtainMessage(12, this.d), this.l.c);
    }

    public final void A(Status status) {
        e0.a(this.l.m);
        for (a aVar : this.f182a) {
            aVar.e(status);
        }
        this.f182a.clear();
    }

    @Override // com.google.android.gms.common.api.e.b
    public final void a(int i) {
        if (Looper.myLooper() == this.l.m.getLooper()) {
            t();
        } else {
            this.l.m.post(new x(this));
        }
    }

    @Override // com.google.android.gms.common.api.e.c
    public final void b(b.a.a.a.c.a aVar) {
        e0.a(this.l.m);
        g0 g0Var = this.i;
        if (g0Var != null) {
            g0Var.A();
        }
        v();
        this.l.f = -1;
        o(aVar);
        if (aVar.c() == 4) {
            A(t.o);
        } else if (this.f182a.isEmpty()) {
            this.k = aVar;
        } else {
            synchronized (t.p) {
                if (this.l.j != null && this.l.k.contains(this.d)) {
                    this.l.j.a(aVar, this.h);
                    throw null;
                }
            }
            if (!this.l.j(aVar, this.h)) {
                if (aVar.c() == 18) {
                    this.j = true;
                }
                if (this.j) {
                    this.l.m.sendMessageDelayed(Message.obtain(this.l.m, 9, this.d), this.l.f177a);
                    return;
                }
                String valueOf = String.valueOf(this.d.b());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 38);
                sb.append($(0, 5, 1440));
                sb.append(valueOf);
                sb.append($(5, 38, 3816));
                A(new Status(17, sb.toString()));
            }
        }
    }

    @Override // com.google.android.gms.common.api.e.b
    public final void c(Bundle bundle) {
        if (Looper.myLooper() == this.l.m.getLooper()) {
            s();
        } else {
            this.l.m.post(new w(this));
        }
    }

    public final void d() {
        e0.a(this.l.m);
        if (!this.f183b.d() && !this.f183b.c()) {
            if (this.f183b.i() && this.l.f != 0) {
                t tVar = this.l;
                tVar.f = tVar.e.c(this.l.d);
                if (this.l.f != 0) {
                    b(new b.a.a.a.c.a(this.l.f, null));
                    return;
                }
            }
            y yVar = new y(this.l, this.f183b, this.d);
            if (this.f183b.a()) {
                this.i.y(yVar);
            }
            this.f183b.h(yVar);
        }
    }

    public final int e() {
        return this.h;
    }

    public final boolean f() {
        return this.f183b.d();
    }

    public final void g() {
        e0.a(this.l.m);
        if (this.j) {
            d();
        }
    }

    public final void h() {
        e0.a(this.l.m);
        A(t.n);
        this.e.e();
        for (c0<?> c0Var : this.g.keySet()) {
            i(new d(c0Var, new b.a.a.a.g.d()));
        }
        o(new b.a.a.a.c.a(4));
        this.f183b.e();
    }

    public final void i(a aVar) {
        e0.a(this.l.m);
        if (this.f183b.d()) {
            k(aVar);
            y();
            return;
        }
        this.f182a.add(aVar);
        b.a.a.a.c.a aVar2 = this.k;
        if (aVar2 == null || !aVar2.g()) {
            d();
        } else {
            b(this.k);
        }
    }

    public final void j(g gVar) {
        e0.a(this.l.m);
        this.f.add(gVar);
    }

    public final void n(b.a.a.a.c.a aVar) {
        e0.a(this.l.m);
        this.f183b.e();
        b(aVar);
    }

    public final boolean p() {
        return this.f183b.a();
    }

    public final a.f q() {
        return this.f183b;
    }

    public final void r() {
        e0.a(this.l.m);
        if (this.j) {
            x();
            A(this.l.e.c(this.l.d) == 18 ? new Status(8, $(38, 117, 7809)) : new Status(8, $(117, 178, 7435)));
            this.f183b.e();
        }
    }

    public final Map<c0<?>, f0> u() {
        return this.g;
    }

    public final void v() {
        e0.a(this.l.m);
        this.k = null;
    }

    public final b.a.a.a.c.a w() {
        e0.a(this.l.m);
        return this.k;
    }

    public final void z() {
        e0.a(this.l.m);
        if (this.f183b.d() && this.g.size() == 0) {
            if (this.e.d()) {
                y();
            } else {
                this.f183b.e();
            }
        }
    }
}
