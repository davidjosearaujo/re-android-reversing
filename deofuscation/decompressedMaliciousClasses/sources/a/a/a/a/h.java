package a.a.a.a;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class h implements ComponentCallbacks, View.OnCreateContextMenuListener {
    private static short[] $ = {3773, 3832, 3824, 3821, 3817, 3812, 3773, 3838, 3826, 3827, 3822, 3817, 3823, 3816, 3838, 3817, 3826, 3823, 3773, 3817, 3829, 3836, 3817, 3773, 3828, 3822, 3773, 3821, 3816, 3839, 3825, 3828, 3838, 5580, 5590, 5531, 5527, 5533, 5523, 5590, 5509, 5507, 5508, 5523, 5590, 5525, 5530, 5527, 5509, 5509, 5590, 5528, 5527, 5531, 5523, 5590, 5523, 5518, 5535, 5509, 5506, 5509, 5594, 5590, 5535, 5509, 5590, 5510, 5507, 5524, 5530, 5535, 5525, 5594, 5590, 5527, 5528, 5522, 5590, 5534, 5527, 5509, 5590, 5527, 5528, 5290, 5265, 5278, 5277, 5267, 5274, 5343, 5259, 5264, 5343, 5270, 5265, 5260, 5259, 5278, 5265, 5259, 5270, 5278, 5259, 5274, 5343, 5273, 5261, 5278, 5272, 5266, 5274, 5265, 5259, 5343, 10565, 10609, 10594, 10596, 10606, 10598, 10605, 10615, 10531, 7858, 7926, 7931, 7926, 7858, 7932, 7933, 7910, 7858, 7921, 7923, 7934, 7934, 7858, 7910, 7930, 7904, 7933, 7911, 7925, 7930, 7858, 7910, 7933, 7858, 7905, 7911, 7906, 7927, 7904, 7868, 7933, 7932, 7872, 7927, 7905, 7911, 7935, 7927, 7866, 7867, 8016, 8031, 8021, 8003, 8030, 8024, 8021, 7947, 8002, 8004, 8001, 8001, 8030, 8003, 8005, 7947, 8023, 8003, 8016, 8022, 8028, 8020, 8031, 8005, 8002, 11285, 11297, 11314, 11316, 11326, 11318, 11325, 11303, 11379, 1954, 2022, 2027, 2022, 1954, 2028, 2029, 2038, 1954, 2017, 2019, 2030, 2030, 1954, 2038, 2026, 2032, 2029, 2039, 2021, 2026, 1954, 2038, 2029, 1954, 2033, 2039, 2034, 2023, 2032, 1964, 2029, 2028, 2001, 2038, 2019, 2032, 2038, 1962, 1963, 6101, 6113, 6130, 6132, 6142, 6134, 6141, 6119, 6067, 6824, 6892, 6881, 6892, 6824, 6886, 6887, 6908, 6824, 6891, 6889, 6884, 6884, 6824, 6908, 6880, 6906, 6887, 6909, 6895, 6880, 6824, 6908, 6887, 6824, 6907, 6909, 6904, 6893, 6906, 6822, 6887, 6886, 6875, 6908, 6887, 6904, 6816, 6817, 11326, 11313, 11323, 11309, 11312, 11318, 11323, 11365, 11308, 11306, 11311, 11311, 11312, 11309, 11307, 11365, 11321, 11309, 11326, 11320, 11314, 11322, 11313, 11307, 11308, 5042, 4998, 5013, 5011, 5017, 5009, 5018, 4992, 5076, 1952, 2020, 2025, 2020, 1952, 2030, 2031, 2036, 1952, 2019, 2017, 2028, 2028, 1952, 2036, 2024, 2034, 2031, 2037, 2023, 2024, 1952, 2036, 2031, 1952, 2035, 2037, 2032, 2021, 2034, 1966, 2031, 2030, 2006, 2025, 2021, 2039, 2003, 2036, 2017, 2036, 2021, 2002, 2021, 2035, 2036, 2031, 2034, 2021, 2020, 1960, 1961, 1008, 10462, 10449, 10459, 10445, 10448, 10454, 10459, 10373, 10457, 10445, 10462, 10456, 10450, 10458, 10449, 10443, 10373, 3496, 3470, 3461, 3477, 3474, 3483, 3548, 3464, 3475, 3548, 3471, 3481, 3464, 3548, 3485, 3548, 3470, 3481, 3468, 3472, 3485, 3487, 3481, 3473, 3481, 3474, 3464, 3548, 3471, 3464, 3485, 3470, 3464, 3500, 3475, 3471, 3464, 3468, 3475, 3474, 3481, 3480, 3513, 3474, 3464, 3481, 3470, 3496, 3470, 3485, 3474, 3471, 3477, 3464, 3477, 3475, 3474, 3548, 3475, 3474, 3548, 905, 930, 918, 901, 899, 905, 897, 906, 912, 941, 896, 985, 967, 6771, 6718, 6672, 6716, 6717, 6695, 6706, 6714, 6717, 6710, 6689, 6682, 6711, 6766, 6768, 4226, 4303, 4342, 4291, 4293, 4255, 6519, 6473, 6510, 6523, 6510, 6527, 6439, 1748, 1689, 1725, 1690, 1680, 1681, 1676, 1737, 5068, 4993, 5051, 4996, 4995, 5073, 3099, 3158, 3193, 3162, 3160, 3152, 3176, 3151, 3162, 3160, 3152, 3189, 3166, 3144, 3151, 3154, 3157, 3164, 3078, 6252, 6208, 6245, 6245, 6244, 6245, 6204, 7456, 7533, 7506, 7525, 7533, 7535, 7542, 7529, 7534, 7527, 7485, 6581, 6648, 6611, 6631, 6650, 6648, 6617, 6644, 6636, 6650, 6624, 6625, 6568, 7214, 7267, 7239, 7264, 7234, 7279, 7287, 7265, 7291, 7290, 7219, 6135, 6098, 6131, 6142, 6142, 6143, 6132, 6055, 6671, 6722, 6763, 6730, 6747, 6734, 6732, 6727, 6730, 6731, 6674, 493, 416, 384, 424, 419, 440, 411, 420, 446, 420, 431, 417, 424, 496, 2429, 2352, 2325, 2364, 2350, 2320, 2360, 2355, 2344, 2400, 8047, 8016, 8039, 8054, 8035, 8043, 8044, 8011, 8044, 8049, 8054, 8035, 8044, 8033, 8039, 7999, 8248, 8309, 8266, 8317, 8300, 8313, 8305, 8310, 8305, 8310, 8319, 8229, 4461, 4384, 4376, 4414, 4392, 4415, 4379, 4388, 4414, 4388, 4399, 4385, 4392, 4357, 4388, 4387, 4409, 4464, 169, 130, 182, 165, 163, 169, 161, 170, 176, 137, 165, 170, 165, 163, 161, 182, 249, 7023, 6986, 7021, 7025, 7030, 6975, 2578, 2607, 2590, 2573, 2586, 2577, 2571, 2617, 2573, 2590, 2584, 2578, 2586, 2577, 2571, 2626, 3529, 3557, 3542, 3523, 3537, 3529, 3521, 3530, 3536, 3543, 3481, 7719, 7705, 7723, 7740, 7727, 7726, 7692, 7736, 7723, 7725, 7719, 7727, 7716, 7742, 7705, 7742, 7723, 7742, 7727, 7799, 5957, 6011, 5961, 5982, 5965, 5964, 6014, 5953, 5965, 5983, 6011, 5980, 5961, 5980, 5965, 5909, 4785, 4744, 4797, 4782, 4795, 4793, 4776, 4833, 3569, 3516, 3461, 3504, 3491, 3510, 3508, 3493, 3459, 3508, 3488, 3492, 3508, 3490, 3493, 3474, 3518, 3509, 3508, 3564, 3569, 3538, 3577, 3556, 3560, 3549, 3570, 3573, 3569, 3489, 4198, 4168, 4196, 4197, 4223, 4202, 4194, 4197, 4206, 4217, 4150, 8135, 8188, 8131, 8143, 8157, 8087, 2143, 2171, 2140, 2140, 2135, 2112, 2148, 2139, 2135, 2117, 2063, 6408, 6436, 6411, 6412, 6408, 6404, 6417, 6412, 6411, 6402, 6436, 6418, 6404, 6428, 6488, 3523, 3581, 3546, 3535, 3546, 3531, 3567, 3528, 3546, 3531, 3548, 3567, 3520, 3527, 3523, 3535, 3546, 3527, 3520, 3529, 3475, 5257, 5257, 2025, 1994, 1988, 1985, 1984, 2007, 1925, 2024, 1988, 1995, 1988, 1986, 1984, 2007, 1951, 1622, 1661, 1660, 1657, 1649, 1589, 1027, 3904, 3956, 3943, 3937, 3947, 3939, 3944, 3954, 3878, 4203, 4143, 4130, 4143, 4203, 4133, 4132, 4159, 4203, 4136, 4138, 4135, 4135, 4203, 4159, 4131, 4153, 4132, 4158, 4140, 4131, 4203, 4159, 4132, 4203, 4152, 4158, 4155, 4142, 4153, 4197, 4132, 4133, 4106, 4136, 4159, 4130, 4157, 4130, 4159, 4146, 4104, 4153, 4142, 4138, 4159, 4142, 4143, 4195, 4194, 7565, 7609, 7594, 7596, 7590, 7598, 7589, 7615, 7659, 1873, 1813, 1816, 1813, 1873, 1823, 1822, 1797, 1873, 1810, 1808, 1821, 1821, 1873, 1797, 1817, 1795, 1822, 1796, 1814, 1817, 1873, 1797, 1822, 1873, 1794, 1796, 1793, 1812, 1795, 1887, 1822, 1823, 1842, 1795, 1812, 1808, 1797, 1812, 1881, 1880, 10756, 10800, 10787, 10789, 10799, 10791, 10796, 10806, 10850, 8053, 7985, 7996, 7985, 8053, 7995, 7994, 7969, 8053, 7990, 7988, 7993, 
    7993, 8053, 7969, 7997, 7975, 7994, 7968, 7986, 7997, 8053, 7969, 7994, 8053, 7974, 7968, 7973, 7984, 7975, 8059, 7994, 7995, 7953, 7984, 7974, 7969, 7975, 7994, 7980, 8061, 8060, 7161, 7117, 7134, 7128, 7122, 7130, 7121, 7115, 7071, 11732, 11664, 11677, 11664, 11732, 11674, 11675, 11648, 11732, 11671, 11669, 11672, 11672, 11732, 11648, 11676, 11654, 11675, 11649, 11667, 11676, 11732, 11648, 11675, 11732, 11655, 11649, 11652, 11665, 11654, 11738, 11675, 11674, 11696, 11665, 11655, 11648, 11654, 11675, 11661, 11682, 11677, 11665, 11651, 11740, 11741, 18750, 18749, 29864, 29921, 29932, 29877, 29880, 29936, 18287, 5237, 5185, 5202, 5204, 5214, 5206, 5213, 5191, 5139, 6170, 6228, 6229, 6222, 6170, 6235, 6222, 6222, 6235, 6233, 6226, 6239, 6238, 6170, 6222, 6229, 6170, 6267, 6233, 6222, 6227, 6220, 6227, 6222, 6211, 2193, 2234, 2235, 2238, 2230, 2290, 2196, 2208, 2227, 2229, 2239, 2231, 2236, 2214, 2207, 2227, 2236, 2227, 2229, 2231, 2208, 2290, 2237, 2228, 2290, 7176, 7263, 7241, 7259, 7176, 7238, 7239, 7260, 7176, 10434, 10374, 10375, 10385, 10390, 10384, 10381, 10395, 10375, 10374, 10434, 10371, 10380, 10374, 10434, 10390, 10378, 10379, 10385, 10434, 10372, 10384, 10371, 10373, 10383, 10375, 10380, 10390, 10434, 10379, 10385, 10434, 10380, 10381, 10390, 10434, 10384, 10375, 10390, 10371, 10379, 10380, 10379, 10380, 10373, 10434, 10379, 10380, 10385, 10390, 10371, 10380, 10369, 10375, 4237, 4281, 4266, 4268, 4262, 4270, 4261, 4287, 4331, 6060, 6120, 6117, 6120, 6060, 6114, 6115, 6136, 6060, 6127, 6125, 6112, 6112, 6060, 6136, 6116, 6142, 6115, 6137, 6123, 6116, 6060, 6136, 6115, 6060, 6143, 6137, 6140, 6121, 6142, 6050, 6115, 6114, 6088, 6121, 6136, 6125, 6127, 6116, 6052, 6053, 11077, 11121, 11106, 11108, 11118, 11110, 11117, 11127, 11043, 3781, 3713, 3724, 3713, 3781, 3723, 3722, 3729, 3781, 3718, 3716, 3721, 3721, 3781, 3729, 3725, 3735, 3722, 3728, 3714, 3725, 3781, 3729, 3722, 3781, 3734, 3728, 3733, 3712, 3735, 3787, 3722, 3723, 3765, 3716, 3728, 3734, 3712, 3789, 3788};
    private static final a.a.a.d.h<String, Class<?>> Q = new a.a.a.d.h<>();
    static final Object R = new Object();
    boolean A;
    boolean B;
    boolean D;
    ViewGroup E;
    View F;
    View G;
    boolean H;
    v J;
    boolean K;
    boolean L;
    c M;
    boolean N;
    boolean O;
    float P;

    /* renamed from: b */
    Bundle f20b;
    SparseArray<Parcelable> c;
    String e;
    Bundle f;
    h g;
    int i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    int o;
    n p;
    l q;
    n r;
    o s;
    h t;
    int u;
    int v;
    String w;
    boolean x;
    boolean y;
    boolean z;

    /* renamed from: a */
    int f19a = 0;
    int d = -1;
    int h = -1;
    boolean C = true;
    boolean I = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a implements Runnable {
        a() {
            h.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.b();
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class b extends j {
        private static short[] $ = {1570, 1558, 1541, 1539, 1545, 1537, 1546, 1552, 1604, 1536, 1547, 1537, 1559, 1604, 1546, 1547, 1552, 1604, 1548, 1541, 1554, 1537, 1604, 1541, 1604, 1554, 1549, 1537, 1555};

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        b() {
            h.this = r5;
        }

        @Override // a.a.a.a.j
        public View a(int i) {
            View view = h.this.F;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException($(0, 29, 1636));
        }

        @Override // a.a.a.a.j
        public boolean b() {
            return h.this.F != null;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class c {

        /* renamed from: a */
        View f23a;

        /* renamed from: b */
        int f24b;
        int c;
        int d;
        int e;
        private Object g;
        private Object i;
        private Object k;
        private Boolean l;
        private Boolean m;
        boolean p;
        e q;
        boolean r;
        private Object f = null;
        private Object h = null;
        private Object j = null;
        n0 n = null;
        n0 o = null;

        c() {
            Object obj = h.R;
            this.g = obj;
            this.i = obj;
            this.k = obj;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class d extends RuntimeException {
        public d(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface e {
        void a();

        void b();
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static h B(Context context, String str) {
        return C(context, str, null);
    }

    public static h C(Context context, String str, Bundle bundle) {
        String $2 = $(0, 33, 3741);
        String $3 = $(33, 85, 5622);
        String $4 = $(85, 116, 5375);
        try {
            Class<?> cls = Q.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                Q.put(str, cls);
            }
            h hVar = (h) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(hVar.getClass().getClassLoader());
                hVar.f = bundle;
            }
            return hVar;
        } catch (ClassNotFoundException e2) {
            throw new d($4 + str + $3 + $2, e2);
        } catch (IllegalAccessException e3) {
            throw new d($4 + str + $3 + $2, e3);
        } catch (InstantiationException e4) {
            throw new d($4 + str + $3 + $2, e4);
        }
    }

    public static boolean H(Context context, String str) {
        try {
            Class<?> cls = Q.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                Q.put(str, cls);
            }
            return h.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void b() {
        c cVar = this.M;
        e eVar = null;
        if (cVar != null) {
            cVar.p = false;
            eVar = cVar.q;
            cVar.q = null;
        }
        if (eVar != null) {
            eVar.a();
        }
    }

    private c d() {
        if (this.M == null) {
            this.M = new c();
        }
        return this.M;
    }

    public void A() {
        this.d = -1;
        this.e = null;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = 0;
        this.p = null;
        this.r = null;
        this.q = null;
        this.u = 0;
        this.v = 0;
        this.w = null;
        this.x = false;
        this.y = false;
        this.A = false;
        this.J = null;
        this.K = false;
        this.L = false;
    }

    public void A0(boolean z) {
        d0(z);
        n nVar = this.r;
        if (nVar != null) {
            nVar.Q(z);
        }
    }

    public boolean B0(Menu menu) {
        boolean z = false;
        if (this.x) {
            return false;
        }
        if (this.B && this.C) {
            z = true;
            e0(menu);
        }
        n nVar = this.r;
        return nVar != null ? z | nVar.R(menu) : z;
    }

    public void C0() {
        n nVar = this.r;
        if (nVar != null) {
            nVar.S();
        }
        this.f19a = 2;
        if (this.K) {
            this.K = false;
            if (!this.L) {
                this.L = true;
                this.J = this.q.k(this.e, false, false);
            }
            if (this.J == null) {
                return;
            }
            if (this.q.l()) {
                this.J.d();
            } else {
                this.J.f();
            }
        }
    }

    void D() {
        n nVar = new n();
        this.r = nVar;
        nVar.k(this.q, new b(), this);
    }

    public void D0() {
        n nVar = this.r;
        if (nVar != null) {
            nVar.A0();
            this.r.a0();
        }
        this.f19a = 5;
        this.D = false;
        g0();
        if (this.D) {
            n nVar2 = this.r;
            if (nVar2 != null) {
                nVar2.T();
                this.r.a0();
                return;
            }
            return;
        }
        throw new o0($(116, 125, 10499) + this + $(125, 166, 7826));
    }

    public boolean E() {
        c cVar = this.M;
        if (cVar == null) {
            return false;
        }
        return cVar.r;
    }

    public void E0(Bundle bundle) {
        Parcelable M0;
        h0(bundle);
        n nVar = this.r;
        if (nVar != null && (M0 = nVar.M0()) != null) {
            bundle.putParcelable($(166, 191, 7985), M0);
        }
    }

    public final boolean F() {
        return this.o > 0;
    }

    public void F0() {
        n nVar = this.r;
        if (nVar != null) {
            nVar.A0();
            this.r.a0();
        }
        this.f19a = 4;
        this.D = false;
        i0();
        if (this.D) {
            n nVar2 = this.r;
            if (nVar2 != null) {
                nVar2.U();
            }
            v vVar = this.J;
            if (vVar != null) {
                vVar.c();
                return;
            }
            return;
        }
        throw new o0($(191, 200, 11347) + this + $(200, 240, 1922));
    }

    public boolean G() {
        c cVar = this.M;
        if (cVar == null) {
            return false;
        }
        return cVar.p;
    }

    public void G0() {
        n nVar = this.r;
        if (nVar != null) {
            nVar.V();
        }
        this.f19a = 3;
        this.D = false;
        j0();
        if (!this.D) {
            throw new o0($(240, 249, 6035) + this + $(249, 288, 6792));
        }
    }

    public void H0(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable($(288, 313, 11359))) != null) {
            if (this.r == null) {
                D();
            }
            this.r.J0(parcelable, this.s);
            this.s = null;
            this.r.u();
        }
    }

    public void I(Bundle bundle) {
        this.D = true;
    }

    public final void I0(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.c;
        if (sparseArray != null) {
            this.G.restoreHierarchyState(sparseArray);
            this.c = null;
        }
        this.D = false;
        l0(bundle);
        if (!this.D) {
            throw new o0($(313, 322, 5108) + this + $(322, 374, 1920));
        }
    }

    public void J(int i, int i2, Intent intent) {
    }

    public void J0(View view) {
        d().f23a = view;
    }

    @Deprecated
    public void K(Activity activity) {
        this.D = true;
    }

    public void K0(boolean z) {
        d().r = z;
    }

    public void L(Context context) {
        this.D = true;
        l lVar = this.q;
        Activity g = lVar == null ? null : lVar.g();
        if (g != null) {
            this.D = false;
            K(g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    public final void L0(int i, h hVar) {
        h hVar2;
        String str;
        StringBuilder sb;
        this.d = i;
        if (hVar != null) {
            sb = new StringBuilder();
            sb.append(hVar.e);
            hVar2 = 374;
            str = $(374, 375, 970);
        } else {
            sb = new StringBuilder();
            hVar2 = 375;
            str = $(375, 392, 10431);
        }
        sb.append(str);
        sb.append(this.d);
        this.e = sb.toString();
    }

    public void M(h hVar) {
    }

    public void M0(int i) {
        if (this.M != null || i != 0) {
            d().c = i;
        }
    }

    public boolean N(MenuItem menuItem) {
        return false;
    }

    public void N0(int i, int i2) {
        if (this.M != null || i != 0 || i2 != 0) {
            d();
            c cVar = this.M;
            cVar.d = i;
            cVar.e = i2;
        }
    }

    public void O(Bundle bundle) {
        this.D = true;
        H0(bundle);
        n nVar = this.r;
        if (nVar != null && !nVar.o0(1)) {
            this.r.u();
        }
    }

    public void O0(e eVar) {
        d();
        e eVar2 = this.M.q;
        if (eVar != eVar2) {
            if (eVar == null || eVar2 == null) {
                c cVar = this.M;
                if (cVar.p) {
                    cVar.q = eVar;
                }
                if (eVar != null) {
                    eVar.b();
                    return;
                }
                return;
            }
            throw new IllegalStateException($(392, 453, 3580) + this);
        }
    }

    public Animation P(int i, boolean z, int i2) {
        return null;
    }

    public void P0(int i) {
        d().f24b = i;
    }

    public void Q(Menu menu, MenuInflater menuInflater) {
    }

    public void Q0() {
        n nVar = this.p;
        if (nVar == null || nVar.m == null) {
            d().p = false;
        } else if (Looper.myLooper() != this.p.m.j().getLooper()) {
            this.p.m.j().postAtFrontOfQueue(new a());
        } else {
            b();
        }
    }

    public View R(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void S() {
        this.D = true;
        if (!this.L) {
            this.L = true;
            this.J = this.q.k(this.e, this.K, false);
        }
        v vVar = this.J;
        if (vVar != null) {
            vVar.a();
        }
    }

    public void T() {
    }

    public void U() {
        this.D = true;
    }

    public void V() {
        this.D = true;
    }

    public void W(boolean z) {
    }

    @Deprecated
    public void X(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.D = true;
    }

    public void Y(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.D = true;
        l lVar = this.q;
        Activity g = lVar == null ? null : lVar.g();
        if (g != null) {
            this.D = false;
            X(g, attributeSet, bundle);
        }
    }

    public void Z(boolean z) {
    }

    public boolean a0(MenuItem menuItem) {
        return false;
    }

    public void b0(Menu menu) {
    }

    public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print($(453, 466, 996));
        printWriter.print(Integer.toHexString(this.u));
        printWriter.print($(466, 481, 6739));
        printWriter.print(Integer.toHexString(this.v));
        printWriter.print($(481, 487, 4258));
        printWriter.println(this.w);
        printWriter.print(str);
        printWriter.print($(487, 494, 6426));
        printWriter.print(this.f19a);
        printWriter.print($(494, 502, 1780));
        printWriter.print(this.d);
        printWriter.print($(502, 508, 5100));
        printWriter.print(this.e);
        printWriter.print($(508, 527, 3131));
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print($(527, 534, 6145));
        printWriter.print(this.j);
        printWriter.print($(534, 545, 7424));
        printWriter.print(this.k);
        printWriter.print($(545, 558, 6549));
        printWriter.print(this.l);
        printWriter.print($(558, 569, 7182));
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print($(569, 577, 6042));
        printWriter.print(this.x);
        printWriter.print($(577, 588, 6703));
        printWriter.print(this.y);
        printWriter.print($(588, 602, 461));
        printWriter.print(this.C);
        printWriter.print($(602, 612, 2397));
        printWriter.println(this.B);
        printWriter.print(str);
        printWriter.print($(612, 628, 7938));
        printWriter.print(this.z);
        printWriter.print($(628, 640, 8216));
        printWriter.print(this.A);
        printWriter.print($(640, 658, 4429));
        printWriter.println(this.I);
        if (this.p != null) {
            printWriter.print(str);
            printWriter.print($(658, 675, 196));
            printWriter.println(this.p);
        }
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print($(675, 681, 6914));
            printWriter.println(this.q);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print($(681, 697, 2687));
            printWriter.println(this.t);
        }
        if (this.f != null) {
            printWriter.print(str);
            printWriter.print($(697, 708, 3492));
            printWriter.println(this.f);
        }
        if (this.f20b != null) {
            printWriter.print(str);
            printWriter.print($(708, 728, 7754));
            printWriter.println(this.f20b);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print($(728, 744, 5928));
            printWriter.println(this.c);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print($(744, 752, 4828));
            printWriter.print(this.g);
            printWriter.print($(752, 772, 3537));
            printWriter.println(this.i);
        }
        if (q() != 0) {
            printWriter.print(str);
            printWriter.print($(772, 782, 3484));
            printWriter.println(q());
        }
        if (this.E != null) {
            printWriter.print(str);
            printWriter.print($(782, 793, 4107));
            printWriter.println(this.E);
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print($(793, 799, 8106));
            printWriter.println(this.F);
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print($(799, 810, 2098));
            printWriter.println(this.F);
        }
        if (i() != null) {
            printWriter.print(str);
            printWriter.print($(810, 825, 6501));
            printWriter.println(i());
            printWriter.print(str);
            printWriter.print($(825, 846, 3502));
            printWriter.println(y());
        }
        v vVar = this.J;
        String $2 = $(846, 848, 5289);
        if (vVar != null) {
            printWriter.print(str);
            printWriter.println($(848, 863, 1957));
            v vVar2 = this.J;
            vVar2.g(str + $2, fileDescriptor, printWriter, strArr);
        }
        if (this.r != null) {
            printWriter.print(str);
            printWriter.println($(863, 869, 1557) + this.r + $(869, 870, 1081));
            n nVar = this.r;
            nVar.b(str + $2, fileDescriptor, printWriter, strArr);
        }
    }

    public void c0() {
        this.D = true;
    }

    public void d0(boolean z) {
    }

    public h e(String str) {
        if (str.equals(this.e)) {
            return this;
        }
        n nVar = this.r;
        if (nVar != null) {
            return nVar.g0(str);
        }
        return null;
    }

    public void e0(Menu menu) {
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final i f() {
        l lVar = this.q;
        if (lVar == null) {
            return null;
        }
        return (i) lVar.g();
    }

    public void f0(int i, String[] strArr, int[] iArr) {
    }

    public boolean g() {
        c cVar = this.M;
        if (cVar == null || cVar.m == null) {
            return true;
        }
        return this.M.m.booleanValue();
    }

    public void g0() {
        this.D = true;
    }

    public boolean h() {
        c cVar = this.M;
        if (cVar == null || cVar.l == null) {
            return true;
        }
        return this.M.l.booleanValue();
    }

    public void h0(Bundle bundle) {
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return super.hashCode();
    }

    public View i() {
        c cVar = this.M;
        if (cVar == null) {
            return null;
        }
        return cVar.f23a;
    }

    public void i0() {
        this.D = true;
        if (!this.K) {
            this.K = true;
            if (!this.L) {
                this.L = true;
                this.J = this.q.k(this.e, true, false);
            }
            v vVar = this.J;
            if (vVar != null) {
                vVar.e();
            }
        }
    }

    public final m j() {
        if (this.r == null) {
            D();
            int i = this.f19a;
            if (i >= 5) {
                this.r.T();
            } else if (i >= 4) {
                this.r.U();
            } else if (i >= 2) {
                this.r.r();
            } else if (i >= 1) {
                this.r.u();
            }
        }
        return this.r;
    }

    public void j0() {
        this.D = true;
    }

    public Object k() {
        c cVar = this.M;
        if (cVar == null) {
            return null;
        }
        return cVar.f;
    }

    public void k0(View view, Bundle bundle) {
    }

    public n0 l() {
        c cVar = this.M;
        if (cVar == null) {
            return null;
        }
        return cVar.n;
    }

    public void l0(Bundle bundle) {
        this.D = true;
    }

    public Object m() {
        c cVar = this.M;
        if (cVar == null) {
            return null;
        }
        return cVar.h;
    }

    public void m0(Bundle bundle) {
        n nVar = this.r;
        if (nVar != null) {
            nVar.A0();
        }
        this.f19a = 2;
        this.D = false;
        I(bundle);
        if (this.D) {
            n nVar2 = this.r;
            if (nVar2 != null) {
                nVar2.r();
                return;
            }
            return;
        }
        throw new o0($(870, 879, 3846) + this + $(879, 929, 4171));
    }

    public n0 n() {
        c cVar = this.M;
        if (cVar == null) {
            return null;
        }
        return cVar.o;
    }

    public void n0(Configuration configuration) {
        onConfigurationChanged(configuration);
        n nVar = this.r;
        if (nVar != null) {
            nVar.s(configuration);
        }
    }

    public final m o() {
        return this.p;
    }

    public boolean o0(MenuItem menuItem) {
        if (this.x) {
            return false;
        }
        if (N(menuItem)) {
            return true;
        }
        n nVar = this.r;
        return nVar != null && nVar.t(menuItem);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.D = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        f().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.D = true;
    }

    public LayoutInflater p(Bundle bundle) {
        LayoutInflater p = this.q.p();
        j();
        n nVar = this.r;
        nVar.m0();
        a.a.a.e.a.a(p, nVar);
        return p;
    }

    public void p0(Bundle bundle) {
        n nVar = this.r;
        if (nVar != null) {
            nVar.A0();
        }
        this.f19a = 1;
        this.D = false;
        O(bundle);
        if (!this.D) {
            throw new o0($(929, 938, 7627) + this + $(938, 979, 1905));
        }
    }

    public int q() {
        c cVar = this.M;
        if (cVar == null) {
            return 0;
        }
        return cVar.c;
    }

    public boolean q0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.x) {
            return false;
        }
        if (this.B && this.C) {
            z = true;
            Q(menu, menuInflater);
        }
        n nVar = this.r;
        return nVar != null ? z | nVar.v(menu, menuInflater) : z;
    }

    public int r() {
        c cVar = this.M;
        if (cVar == null) {
            return 0;
        }
        return cVar.d;
    }

    public View r0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n nVar = this.r;
        if (nVar != null) {
            nVar.A0();
        }
        return R(layoutInflater, viewGroup, bundle);
    }

    public int s() {
        c cVar = this.M;
        if (cVar == null) {
            return 0;
        }
        return cVar.e;
    }

    public void s0() {
        n nVar = this.r;
        if (nVar != null) {
            nVar.w();
        }
        this.f19a = 0;
        this.D = false;
        S();
        if (this.D) {
            this.r = null;
            return;
        }
        throw new o0($(979, 988, 10818) + this + $(988, 1030, 8021));
    }

    public Object t() {
        c cVar = this.M;
        if (cVar == null) {
            return null;
        }
        return cVar.i == R ? m() : this.M.i;
    }

    public void t0() {
        n nVar = this.r;
        if (nVar != null) {
            nVar.x();
        }
        this.f19a = 1;
        this.D = false;
        U();
        if (this.D) {
            v vVar = this.J;
            if (vVar != null) {
                vVar.b();
                return;
            }
            return;
        }
        throw new o0($(1030, 1039, 7103) + this + $(1039, 1085, 11764));
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        a.a.a.d.d.a(this, sb);
        if (this.d >= 0) {
            sb.append($(1085, 1087, 18718));
            sb.append(this.d);
        }
        if (this.u != 0) {
            sb.append($(1087, 1093, 29832));
            sb.append(Integer.toHexString(this.u));
        }
        if (this.w != null) {
            sb.append($(1093, 1094, 18255));
            sb.append(this.w);
        }
        sb.append('}');
        return sb.toString();
    }

    public final Resources u() {
        l lVar = this.q;
        if (lVar != null) {
            return lVar.h().getResources();
        }
        throw new IllegalStateException($(1094, 1103, 5171) + this + $(1103, 1128, 6202));
    }

    public void u0() {
        this.D = false;
        V();
        if (this.D) {
            n nVar = this.r;
            if (nVar == null) {
                return;
            }
            if (this.A) {
                nVar.w();
                this.r = null;
                return;
            }
            throw new IllegalStateException($(1128, 1153, 2258) + this + $(1153, 1162, 7208) + $(1162, 1216, 10466));
        }
        throw new o0($(1216, 1225, 4299) + this + $(1225, 1266, 6028));
    }

    public Object v() {
        c cVar = this.M;
        if (cVar == null) {
            return null;
        }
        return cVar.g == R ? k() : this.M.g;
    }

    public void v0() {
        onLowMemory();
        n nVar = this.r;
        if (nVar != null) {
            nVar.y();
        }
    }

    public Object w() {
        c cVar = this.M;
        if (cVar == null) {
            return null;
        }
        return cVar.j;
    }

    public void w0(boolean z) {
        Z(z);
        n nVar = this.r;
        if (nVar != null) {
            nVar.z(z);
        }
    }

    public Object x() {
        c cVar = this.M;
        if (cVar == null) {
            return null;
        }
        return cVar.k == R ? w() : this.M.k;
    }

    public boolean x0(MenuItem menuItem) {
        if (this.x) {
            return false;
        }
        if (this.B && this.C && a0(menuItem)) {
            return true;
        }
        n nVar = this.r;
        return nVar != null && nVar.N(menuItem);
    }

    public int y() {
        c cVar = this.M;
        if (cVar == null) {
            return 0;
        }
        return cVar.f24b;
    }

    public void y0(Menu menu) {
        if (!this.x) {
            if (this.B && this.C) {
                b0(menu);
            }
            n nVar = this.r;
            if (nVar != null) {
                nVar.O(menu);
            }
        }
    }

    public View z() {
        return this.F;
    }

    public void z0() {
        n nVar = this.r;
        if (nVar != null) {
            nVar.P();
        }
        this.f19a = 4;
        this.D = false;
        c0();
        if (!this.D) {
            throw new o0($(1266, 1275, 11011) + this + $(1275, 1315, 3813));
        }
    }
}
