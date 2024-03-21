package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import b.a.a.a.c.a;
import b.a.a.a.c.h;
import b.a.a.a.c.j;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class k0<T extends IInterface> {
    private static short[] $ = {2332, 2352, 2353, 2347, 2362, 2343, 2347, 2431, 2354, 2346, 2348, 2347, 2431, 2353, 2352, 2347, 2431, 2365, 2362, 2431, 2353, 2346, 2355, 2355, 2720, 2691, 2691, 2716, 2697, 2718, 2764, 2689, 2713, 2719, 2712, 2764, 2690, 2691, 2712, 2764, 2702, 2697, 2764, 2690, 2713, 2688, 2688, 5052, 5018, 5023, 5002, 5021, 5017, 4998, 5020, 4992, 5021, 5071, 4994, 5018, 5020, 5019, 5071, 4993, 4992, 5019, 5071, 5005, 5002, 5071, 4993, 5018, 4995, 4995, 4047, 4062, 4039, 4014, 4079, 4088, 4079, 4071, 4066, 4079, 4076, 4071, 4066, 4071, 4090, 4087, 4014, 4067, 4091, 4093, 4090, 4014, 4064, 4065, 4090, 4014, 4076, 4075, 4014, 4064, 4091, 4066, 4066, 1808, 1850, 1828, 1812, 1851, 1854, 1842, 1849, 1827, 2055, 2085, 2088, 2088, 2093, 2090, 2083, 2148, 2087, 2091, 2090, 2090, 2081, 2087, 2096, 2156, 2157, 2148, 2099, 2092, 2093, 2088, 2081, 2148, 2103, 2096, 2093, 2088, 2088, 2148, 2087, 2091, 2090, 2090, 2081, 2087, 2096, 2081, 2080, 2152, 2148, 2089, 2093, 2103, 2103, 2093, 2090, 2083, 2148, 2080, 2093, 2103, 2087, 2091, 2090, 2090, 2081, 2087, 2096, 2156, 2157, 2148, 2082, 2091, 2102, 2148, 1317, 1386, 1387, 1317, 165, 143, 145, 161, 142, 139, 135, 140, 150, 6058, 6065, 6078, 6077, 6067, 6074, 6143, 6059, 6064, 6143, 6076, 6064, 6065, 6065, 6074, 6076, 6059, 6143, 6059, 6064, 6143, 6060, 6074, 6061, 6057, 6070, 6076, 6074, 6117, 6143, 7785, 7718, 7719, 7785, 2535, 2539, 2537, 2474, 2531, 2539, 2539, 2531, 2536, 2529, 2474, 2533, 2538, 2528, 2550, 2539, 2541, 2528, 2474, 2531, 2537, 2551, 3068, 3037, 3014, 2962, 3025, 3037, 3036, 3036, 3031, 3025, 3014, 3031, 3030, 2972, 2962, 3057, 3027, 3038, 3038, 2962, 3025, 3037, 3036, 3036, 3031, 3025, 3014, 2970, 2971, 2962, 3027, 3036, 3030, 2962, 3013, 3027, 3035, 3014, 2962, 3028, 3037, 3008, 2962, 3037, 3036, 3057, 3037, 3036, 3036, 3031, 3025, 3014, 3031, 3030, 2970, 2971, 2962, 3014, 3037, 2962, 3024, 3031, 2962, 3025, 3027, 3038, 3038, 3031, 3030, 2972, 6480, 6527, 6522, 6518, 6525, 6503, 6451, 6522, 6496, 6451, 6512, 6524, 6525, 6525, 6518, 6512, 6503, 6518, 6519, 6451, 6513, 6502, 6503, 6451, 6496, 6518, 6497, 6501, 6522, 6512, 6518, 6451, 6522, 6496, 6451, 6525, 6502, 6527, 6527, 3027, 3027, 2955, 2954, 2953, 2958, 2970, 2947, 2971, 3023, 2958, 2956, 2956, 2944, 2970, 2945, 2971, 3025, 3025, 9127, 9131, 9129, 9194, 9123, 9131, 9131, 9123, 9128, 9121, 9569, 9547, 9557, 9573, 9546, 9551, 9539, 9544, 9554, 6499, 6493, 6507, 6524, 6520, 6503, 6509, 6507, 6476, 6524, 6497, 6501, 6507, 6524, 6446, 6503, 6525, 6446, 6496, 6523, 6498, 6498, 6434, 6446, 6509, 6498, 6503, 6507, 6496, 6522, 6446, 6506, 6503, 6525, 6509, 6497, 6496, 6496, 6507, 6509, 6522, 6507, 6506, 7900, 7926, 7912, 7896, 7927, 7922, 7934, 7925, 7919, 7642, 7636, 7678, 7648, 7616, 7670, 7649, 7653, 7674, 7664, 7670, 7633, 7649, 7676, 7672, 7670, 7649, 7613, 7668, 7670, 7655, 7616, 7670, 7649, 7653, 7674, 7664, 7670, 7603, 7669, 7666, 7674, 7679, 7670, 7671, 4641, 4619, 4629, 4645, 4618, 4623, 4611, 4616, 4626, 7146, 7140, 7118, 7120, 7152, 7110, 7121, 7125, 7114, 7104, 7110, 7137, 7121, 7116, 7112, 7110, 7121, 7053, 7108, 7110, 7127, 7152, 7110, 7121, 7125, 7114, 7104, 7110, 7043, 7109, 7106, 7114, 7119, 7110, 7111, 6329, 6293, 6292, 6292, 6303, 6297, 6286, 6291, 6293, 6292, 6362, 6282, 6280, 6293, 6301, 6280, 6303, 6281, 6281, 6362, 6297, 6299, 6294, 6294, 6296, 6299, 6297, 6289, 6281, 6362, 6297, 6299, 6292, 6292, 6293, 6286, 6362, 6296, 6303, 6362, 6292, 6287, 6294, 6294, 6356};

    /* renamed from: a */
    private j f268a;

    /* renamed from: b */
    private final Context f269b;
    private final e c;
    final Handler d;
    private r g;
    protected q0 h;
    private T i;
    private s0 k;
    private final m0 m;
    private final n0 n;
    private final int o;
    private final String p;
    private final Object e = new Object();
    private final Object f = new Object();
    private final ArrayList<p0<?>> j = new ArrayList<>();
    private int l = 1;
    private a q = null;
    private boolean r = false;
    protected AtomicInteger s = new AtomicInteger(0);

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public k0(Context context, Looper looper, e eVar, j jVar, int i, m0 m0Var, n0 n0Var, String str) {
        e0.e(context, $(0, 24, 2399));
        this.f269b = context;
        e0.e(looper, $(24, 47, 2796));
        e0.e(eVar, $(47, 74, 5103));
        this.c = eVar;
        e0.e(jVar, $(74, 107, 3982));
        this.d = new o0(this, looper);
        this.o = i;
        this.m = m0Var;
        this.n = n0Var;
        this.p = str;
    }

    public final void C(int i) {
        int i2;
        if (N()) {
            i2 = 5;
            this.r = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.d;
        handler.sendMessage(handler.obtainMessage(i2, this.s.get(), 16));
    }

    private final String M() {
        String str = this.p;
        return str == null ? this.f269b.getClass().getName() : str;
    }

    private final boolean N() {
        boolean z;
        synchronized (this.e) {
            z = this.l == 3;
        }
        return z;
    }

    public final boolean T() {
        if (this.r || TextUtils.isEmpty(j()) || TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(j());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void v(int i, T t) {
        e0.d((i == 4) == (t != null));
        synchronized (this.e) {
            this.l = i;
            this.i = t;
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (!(this.k == null || this.f268a == null)) {
                        String $2 = $(107, 116, 1879);
                        String valueOf = String.valueOf(this.f268a.b());
                        String valueOf2 = String.valueOf(this.f268a.a());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(valueOf2).length());
                        sb.append($(116, 182, 2116));
                        sb.append(valueOf);
                        sb.append($(182, 186, 1285));
                        sb.append(valueOf2);
                        Log.e($2, sb.toString());
                        this.c.a(this.f268a.b(), this.f268a.a(), this.k, M());
                        this.s.incrementAndGet();
                    }
                    this.k = new s0(this, this.s.get());
                    j jVar = new j(L(), g(), false);
                    this.f268a = jVar;
                    if (!this.c.b(new f(jVar.b(), this.f268a.a()), this.k, M())) {
                        String $3 = $(186, 195, 226);
                        String valueOf3 = String.valueOf(this.f268a.b());
                        String valueOf4 = String.valueOf(this.f268a.a());
                        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 34 + String.valueOf(valueOf4).length());
                        sb2.append($(195, 225, 6111));
                        sb2.append(valueOf3);
                        sb2.append($(225, 229, 7753));
                        sb2.append(valueOf4);
                        Log.e($3, sb2.toString());
                        t(16, null, this.s.get());
                    }
                } else if (i == 4) {
                    w(t);
                }
            } else if (this.k != null) {
                this.c.a(g(), L(), this.k, M());
                this.k = null;
            }
        }
    }

    public final boolean z(int i, int i2, T t) {
        synchronized (this.e) {
            if (this.l != i) {
                return false;
            }
            v(i2, t);
            return true;
        }
    }

    public final void B(int i) {
        Handler handler = this.d;
        handler.sendMessage(handler.obtainMessage(6, this.s.get(), i));
    }

    protected Bundle J() {
        return new Bundle();
    }

    public Bundle K() {
        return null;
    }

    protected String L() {
        return $(229, 251, 2436);
    }

    public abstract h[] O();

    protected final void P() {
        if (!d()) {
            throw new IllegalStateException($(251, 321, 2994));
        }
    }

    public final T Q() {
        T t;
        synchronized (this.e) {
            if (this.l != 5) {
                P();
                e0.b(this.i != null, $(321, 360, 6419));
                t = this.i;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    public boolean R() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Set<Scope> S();

    @Override // com.google.android.gms.common.api.a.f
    public boolean a() {
        return false;
    }

    public final void b(k kVar, Set<Scope> set) {
        Throwable e;
        Bundle J = J();
        b1 b1Var = new b1(this.o);
        b1Var.d = this.f269b.getPackageName();
        b1Var.g = J;
        if (set != null) {
            b1Var.f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (a()) {
            b1Var.h = m() != null ? m() : new Account($(360, 379, 3055), $(379, 389, 9156));
            if (kVar != null) {
                b1Var.e = kVar.asBinder();
            }
        } else if (R()) {
            b1Var.h = m();
        }
        b1Var.i = O();
        try {
            synchronized (this.f) {
                if (this.g != null) {
                    this.g.j(new r0(this, this.s.get()), b1Var);
                } else {
                    Log.w($(389, 398, 9510), $(398, 441, 6414));
                }
            }
        } catch (DeadObjectException e2) {
            Log.w($(485, 494, 4710), $(494, 529, 7075), e2);
            B(1);
        } catch (RemoteException e3) {
            e = e3;
            Log.w($(441, 450, 7835), $(450, 485, 7571), e);
            u(8, null, null, this.s.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w($(441, 450, 7835), $(450, 485, 7571), e);
            u(8, null, null, this.s.get());
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this.e) {
            if (!(this.l == 2 || this.l == 3)) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    public final boolean d() {
        boolean z;
        synchronized (this.e) {
            z = this.l == 4;
        }
        return z;
    }

    public void e() {
        this.s.incrementAndGet();
        synchronized (this.j) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                this.j.get(i).a();
            }
            this.j.clear();
        }
        synchronized (this.f) {
            this.g = null;
        }
        v(1, null);
    }

    protected abstract String g();

    public void h(q0 q0Var) {
        e0.e(q0Var, $(529, 574, 6394));
        this.h = q0Var;
        v(2, null);
    }

    public boolean i() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String j();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T l(IBinder iBinder);

    public abstract Account m();

    public final Context n() {
        return this.f269b;
    }

    public void o(a aVar) {
        aVar.c();
        System.currentTimeMillis();
    }

    public final void p(int i) {
        System.currentTimeMillis();
    }

    public final void t(int i, Bundle bundle, int i2) {
        Handler handler = this.d;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new v0(this, i, null)));
    }

    public void u(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.d;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new u0(this, i, iBinder, bundle)));
    }

    protected void w(T t) {
        System.currentTimeMillis();
    }
}
