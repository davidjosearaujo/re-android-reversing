package b.a.a.a.e;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.a.d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.h0;
import com.google.android.gms.common.internal.w0;
import java.util.HashSet;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class g0 extends m1 implements e.b, e.c {
    private static short[] $ = {1817, 1827, 1837, 1828, 1895, 1827, 1828, 1898, 1849, 1855, 1833, 1833, 1839, 1839, 1838, 1839, 1838, 1898, 1853, 1827, 1854, 1826, 1898, 1848, 1839, 1849, 1829, 1830, 1852, 1839, 1898, 1835, 1833, 1833, 1829, 1855, 1828, 1854, 1898, 1836, 1835, 1827, 1830, 1855, 1848, 1839, 1904, 1898, 5543, 5533, 5523, 5530, 5565, 5530, 5559, 5531, 5531, 5510, 5520, 5533, 5530, 5525, 5504, 5531, 5510};
    private static a.b<? extends i1, j1> i = e1.c;

    /* renamed from: a */
    private final Context f153a;

    /* renamed from: b */
    private final Handler f154b;
    private final a.b<? extends i1, j1> c = i;
    private final boolean d = true;
    private Set<Scope> e;
    private w0 f;
    private i1 g;
    private i0 h;

    private static String $(int i2, int i3, int i4) {
        char[] cArr = new char[i3 - i2];
        for (int i5 = 0; i5 < i3 - i2; i5++) {
            cArr[i5] = (char) ($[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    public g0(Context context, Handler handler) {
        this.f153a = context;
        this.f154b = handler;
    }

    public final void z(u1 u1Var) {
        b.a.a.a.c.a d = u1Var.d();
        if (d.h()) {
            h0 c = u1Var.c();
            d = c.c();
            if (!d.h()) {
                String valueOf = String.valueOf(d);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append($(0, 48, 1866));
                sb.append(valueOf);
                Log.wtf($(48, 65, 5620), sb.toString(), new Exception());
            } else {
                this.h.a(c.d(), this.e);
                this.g.e();
            }
        }
        this.h.c(d);
        this.g.e();
    }

    public final void A() {
        i1 i1Var = this.g;
        if (i1Var != null) {
            i1Var.e();
        }
    }

    @Override // com.google.android.gms.common.api.e.b
    public final void a(int i2) {
        this.g.e();
    }

    @Override // com.google.android.gms.common.api.e.c
    public final void b(b.a.a.a.c.a aVar) {
        this.h.c(aVar);
    }

    @Override // com.google.android.gms.common.api.e.b
    public final void c(Bundle bundle) {
        this.g.k(this);
    }

    @Override // b.a.a.a.e.n1
    public final void m(u1 u1Var) {
        this.f154b.post(new h0(this, u1Var));
    }

    public final void y(i0 i0Var) {
        i1 i1Var = this.g;
        if (i1Var != null) {
            i1Var.e();
        }
        if (this.d) {
            GoogleSignInOptions f = d.a(this.f153a).f();
            HashSet hashSet = f == null ? new HashSet() : new HashSet(f.d());
            this.e = hashSet;
            this.f = new w0(null, hashSet, null, 0, null, null, null, j1.i);
        }
        this.f.b(Integer.valueOf(System.identityHashCode(this)));
        a.b<? extends i1, j1> bVar = this.c;
        Context context = this.f153a;
        Looper looper = this.f154b.getLooper();
        w0 w0Var = this.f;
        i1 i1Var2 = (i1) bVar.a(context, looper, w0Var, w0Var.g(), this, this);
        this.g = i1Var2;
        this.h = i0Var;
        i1Var2.f();
    }
}
