package a.a.a.a;

import a.a.a.a.u;
import a.a.a.b.a;
import a.a.a.d.d;
import a.a.a.d.i;
import android.os.Bundle;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class v extends u {
    private static short[] $ = {4170, 4201, 4199, 4194, 4195, 4212, 4171, 4199, 4200, 4199, 4193, 4195, 4212, 1557, 1588, 1570, 1573, 1571, 1598, 1576, 1592, 1599, 1590, 1649, 1552, 1586, 1573, 1592, 1575, 1588, 1649, 1592, 1599, 1649, 517, 548, 562, 565, 563, 558, 568, 552, 559, 550, 609, 520, 559, 544, 546, 565, 552, 567, 548, 609, 552, 559, 609, 4472, 4443, 4437, 4432, 4433, 4422, 4473, 4437, 4442, 4437, 4435, 4433, 4422, 4444, 4459, 4474, 4463, 4455, 4448, 4455, 4448, 4457, 4398, 4455, 4448, 4398, 1562, 1559, 1536, 1559, 9546, 9576, 9573, 9573, 9580, 9581, 9513, 9581, 9574, 9563, 9580, 9597, 9576, 9568, 9575, 9513, 9598, 9569, 9580, 9575, 9513, 9575, 9574, 9597, 9513, 9594, 9597, 9576, 9595, 9597, 9580, 9581, 9523, 9513, 6890, 6857, 6855, 6850, 6851, 6868, 6891, 6855, 6856, 6855, 6849, 6851, 6868, 5148, 5179, 5166, 5181, 5179, 5158, 5153, 5160, 5231, 5158, 5153, 5231, 7763, 7774, 7753, 7774, 7375, 7405, 7392, 7392, 7401, 7400, 7340, 7400, 7395, 7391, 7416, 7405, 7422, 7416, 7340, 7419, 7396, 7401, 7394, 7340, 7405, 7392, 7422, 7401, 7405, 7400, 7413, 7340, 7423, 7416, 7405, 7422, 7416, 7401, 7400, 7350, 7340, 9588, 9559, 9561, 9564, 9565, 9546, 9589, 9561, 9558, 9561, 9567, 9565, 9546, 1547, 1580, 1591, 1576, 1576, 1585, 1590, 1599, 1656, 1585, 1590, 1656, 1983, 1970, 1957, 1970, 352, 322, 335, 335, 326, 327, 259, 327, 332, 368, 343, 332, 339, 259, 340, 331, 326, 333, 259, 333, 332, 343, 259, 336, 343, 322, 337, 343, 326, 327, 281, 259, 306, 296, 5741, 5741, 5742, 544, 544, 544, 544, 6437, 6407, 6416, 6413, 6418, 6401, 6468, 6440, 6411, 6405, 6400, 6401, 6422, 6423, 6494, 3093, 3122, 3133, 3135, 3112, 3125, 3114, 3129, 3196, 3088, 3123, 3133, 3128, 3129, 3118, 3119, 3174, 3004, 2963, 2964, 2963, 2953, 2962, 2975, 2974, 3034, 2984, 2975, 2958, 2971, 2963, 2964, 2963, 2964, 2973, 3034, 2963, 2964, 3034, 4803, 4832, 4846, 4843, 4842, 4861, 4802, 4846, 4833, 4846, 4840, 4842, 4861, 18890, 18921, 18919, 18914, 18915, 18932, 18891, 18919, 18920, 18919, 18913, 18915, 18932, 18941, 21292, 21349, 21346, 21292, 22140, 22140};
    static boolean g;

    /* renamed from: a  reason: collision with root package name */
    final i<a> f74a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    final i<a> f75b = new i<>();
    final String c;
    boolean d;
    boolean e;
    l f;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    final class a implements a.b<Object>, a.AbstractC0000a<Object> {
        private static short[] $ = {2207, 2206, 2236, 2207, 2193, 2196, 2230, 2201, 2206, 2201, 2179, 2200, 2197, 2196, 6482, 6513, 6527, 6522, 6523, 6508, 6483, 6527, 6512, 6527, 6521, 6523, 6508, 3110, 3110, 3177, 3176, 3146, 3177, 3175, 3170, 3136, 3183, 3176, 3183, 3189, 3182, 3171, 3170, 3110, 3183, 3176, 3110, 6168, 6146, 2491, 2456, 2454, 2451, 2450, 2437, 2490, 2454, 2457, 2454, 2448, 2450, 2437, 4780, 4780, 4808, 4841, 4863, 4856, 4862, 4835, 4853, 4837, 4834, 4843, 4790, 4780, 9504, 9504, 9554, 9573, 9587, 9573, 9588, 9588, 9577, 9582, 9575, 9530, 9504, 9824, 9825, 9795, 9824, 9838, 9835, 9834, 9853, 9821, 9834, 9852, 9834, 9851, 2879, 2843, 2870, 2927, 3507, 3582, 3538, 3553, 3572, 3552, 3502, 6419, 6461, 6431, 6418, 6418, 6428, 6431, 6429, 6421, 6413, 6467, 3630, 3599, 3628, 3618, 3623, 3622, 3633, 3710, 6121, 6121, 9256, 9229, 9252, 9267, 9248, 9217, 9252, 9265, 9252, 9336, 4913, 4913, 4988, 4949, 4980, 4989, 4984, 4967, 4980, 4963, 4980, 4981, 4949, 4976, 4965, 4976, 4908, 6458, 6419, 6454, 6435, 6454, 6506, 6489, 6503, 6464, 6485, 6470, 6464, 6481, 6480, 6409, 1672, 1733, 1786, 1741, 1752, 1735, 1754, 1756, 1766, 1741, 1744, 1756, 1787, 1756, 1737, 1754, 1756, 1685, 7960, 8021, 8060, 8029, 8011, 8012, 8010, 8023, 8001, 8029, 8028, 7941, 1992, 2039, 1984, 2001, 1988, 1996, 1995, 1996, 1995, 1986, 1944, 7592, 7653, 7642, 7661, 7676, 7657, 7649, 7654, 7649, 7654, 7663, 7643, 7676, 7657, 7674, 7676, 7661, 7660, 7605, 7262, 7187, 7218, 7191, 7181, 7178, 7195, 7184, 7195, 7180, 7212, 7195, 7193, 7191, 7181, 7178, 7195, 7180, 7195, 7194, 7235, 7459, 7446, 7453, 7447, 7450, 7453, 7444, 7507, 7487, 7452, 7442, 7447, 7446, 7425, 7507, 2556, 6255, 6255, 6153, 6182, 6177, 6182, 6204, 6183, 6186, 6187, 6255, 6173, 6186, 6203, 6190, 6182, 6177, 6182, 6177, 6184, 6261, 6255, 1814, 1845, 1851, 1854, 1855, 1832, 1815, 1851, 1844, 1851, 1853, 1855, 1832, 6922, 6922, 7032, 6991, 7006, 6987, 6979, 6980, 6979, 6980, 6989, 6928, 6922, 7710, 7741, 7731, 7734, 7735, 7712, 7711, 7731, 7740, 7731, 7733, 7735, 7712, 1825, 1825, 1874, 1909, 1888, 1907, 1909, 1896, 1903, 1894, 1851, 1825, 7232, 7267, 7277, 7272, 7273, 7294, 7233, 7277, 7266, 7277, 7275, 7273, 7294, 9969, 9948, 9940, 9947, 9949, 9930, 9886, 9932, 9947, 9930, 9931, 9932, 9936, 9947, 9946, 9886, 9944, 9932, 9937, 9939, 9886, 9937, 9936, 9981, 9932, 9947, 9951, 9930, 9947, 9970, 9937, 9951, 9946, 9947, 9932, 9886, 9939, 9931, 9933, 9930, 9886, 9936, 9937, 9930, 9886, 9948, 9947, 9886, 9951, 9886, 9936, 9937, 9936, 9875, 9933, 9930, 9951, 9930, 9943, 9949, 9886, 9943, 9936, 9936, 9947, 9932, 9886, 9939, 9947, 9939, 9948, 9947, 9932, 9886, 9949, 9938, 9951, 9933, 9933, 9860, 9886, 4949, 4949, 4902, 4865, 4890, 4869, 4869, 4892, 4891, 4882, 4943, 4949, 1552, 1587, 1597, 1592, 1593, 1582, 1553, 1597, 1586, 1597, 1595, 1593, 1582, 16516, 16551, 16553, 16556, 16557, 16570, 16513, 16550, 16558, 16551, 16563, 29421, 29422, 28941, 28951, 28941, 17447, 17447};

        /* renamed from: a  reason: collision with root package name */
        final int f76a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f77b;
        u.a<Object> c;
        a.a.a.b.a<Object> d;
        boolean e;
        boolean f;
        Object g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        a n;
        final /* synthetic */ v o;

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        void a(a.a.a.b.a<Object> aVar, Object obj) {
            if (this.c != null) {
                String str = null;
                l lVar = this.o.f;
                if (lVar != null) {
                    n nVar = lVar.d;
                    str = nVar.s;
                    nVar.s = $(0, 14, 2288);
                }
                try {
                    if (v.g) {
                        String $2 = $(14, 27, 6430);
                        Log.v($2, $(27, 47, 3078) + aVar + $(47, 49, 6178) + aVar.a(obj));
                    }
                    this.c.b(aVar, obj);
                    this.f = true;
                } finally {
                    l lVar2 = this.o.f;
                    if (lVar2 != null) {
                        lVar2.d.s = str;
                    }
                }
            }
        }

        void b() {
            String str;
            boolean z = v.g;
            String $2 = $(49, 62, 2551);
            if (z) {
                Log.v($2, $(62, 76, 4748) + this);
            }
            this.l = true;
            boolean z2 = this.f;
            this.f = false;
            if (this.c != null && this.d != null && this.e && z2) {
                if (v.g) {
                    Log.v($2, $(76, 89, 9472) + this);
                }
                l lVar = this.o.f;
                if (lVar != null) {
                    n nVar = lVar.d;
                    str = nVar.s;
                    nVar.s = $(89, 102, 9743);
                } else {
                    str = null;
                }
                try {
                    this.c.a(this.d);
                } finally {
                    l lVar2 = this.o.f;
                    if (lVar2 != null) {
                        lVar2.d.s = str;
                    }
                }
            }
            this.c = null;
            this.g = null;
            this.e = false;
            a.a.a.b.a<Object> aVar = this.d;
            if (aVar != null) {
                if (this.m) {
                    this.m = false;
                    aVar.h(this);
                    this.d.i(this);
                }
                this.d.e();
            }
            a aVar2 = this.n;
            if (aVar2 != null) {
                aVar2.b();
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print($(102, 106, 2898));
            printWriter.print(this.f76a);
            printWriter.print($(106, 113, 3475));
            printWriter.println(this.f77b);
            printWriter.print(str);
            printWriter.print($(113, 124, 6526));
            printWriter.println(this.c);
            printWriter.print(str);
            printWriter.print($(124, 132, 3651));
            printWriter.println(this.d);
            a.a.a.b.a<Object> aVar = this.d;
            String $2 = $(132, 134, 6089);
            if (aVar != null) {
                aVar.b(str + $2, fileDescriptor, printWriter, strArr);
            }
            if (this.e || this.f) {
                printWriter.print(str);
                printWriter.print($(134, 144, 9285));
                printWriter.print(this.e);
                printWriter.print($(144, 161, 4881));
                printWriter.println(this.f);
                printWriter.print(str);
                printWriter.print($(161, 167, 6487));
                printWriter.println(this.g);
            }
            printWriter.print(str);
            printWriter.print($(167, 176, 6452));
            printWriter.print(this.h);
            printWriter.print($(176, 194, 1704));
            printWriter.print(this.k);
            printWriter.print($(194, 206, 7992));
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print($(206, 217, 1957));
            printWriter.print(this.i);
            printWriter.print($(217, 236, 7560));
            printWriter.print(this.j);
            printWriter.print($(236, 257, 7294));
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println($(257, 272, 7539));
                printWriter.print(this.n);
                printWriter.println($(272, 273, 2502));
                a aVar2 = this.n;
                aVar2.c(str + $2, fileDescriptor, printWriter, strArr);
            }
        }

        void d() {
            if (this.i) {
                if (v.g) {
                    Log.v($(295, 308, 1882), $(273, 295, 6223) + this);
                }
                this.i = false;
                boolean z = this.h;
                if (z != this.j && !z) {
                    h();
                }
            }
            if (this.h && this.e && !this.k) {
                a(this.d, this.g);
            }
        }

        void e() {
            if (this.h && this.k) {
                this.k = false;
                if (this.e && !this.i) {
                    a(this.d, this.g);
                }
            }
        }

        void f() {
            if (v.g) {
                Log.v($(321, 334, 7762), $(308, 321, 6954) + this);
            }
            this.i = true;
            this.j = this.h;
            this.h = false;
            this.c = null;
        }

        void g() {
            u.a<Object> aVar;
            if (this.i && this.j) {
                this.h = true;
            } else if (!this.h) {
                this.h = true;
                if (v.g) {
                    Log.v($(346, 359, 7180), $(334, 346, 1793) + this);
                }
                if (this.d == null && (aVar = this.c) != null) {
                    this.d = aVar.c(this.f76a, this.f77b);
                }
                a.a.a.b.a<Object> aVar2 = this.d;
                if (aVar2 == null) {
                    return;
                }
                if (!aVar2.getClass().isMemberClass() || Modifier.isStatic(this.d.getClass().getModifiers())) {
                    if (!this.m) {
                        this.d.c(this.f76a, this);
                        this.d.d(this);
                        this.m = true;
                    }
                    this.d.f();
                    throw null;
                }
                throw new IllegalArgumentException($(359, 440, 9918) + this.d);
            }
        }

        void h() {
            a.a.a.b.a<Object> aVar;
            if (v.g) {
                Log.v($(452, 465, 1628), $(440, 452, 4981) + this);
            }
            this.h = false;
            if (!this.i && (aVar = this.d) != null && this.m) {
                this.m = false;
                aVar.h(this);
                this.d.i(this);
                this.d.g();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append($(465, 476, 16584));
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append($(476, 478, 29389));
            sb.append(this.f76a);
            sb.append($(478, 481, 28973));
            d.a(this.d, sb);
            sb.append($(481, 483, 17498));
            return sb.toString();
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(String str, l lVar, boolean z) {
        this.c = str;
        this.f = lVar;
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        boolean z = this.e;
        String $2 = $(0, 13, 4102);
        if (!z) {
            if (g) {
                Log.v($2, $(13, 34, 1617) + this);
            }
            for (int j = this.f74a.j() - 1; j >= 0; j--) {
                this.f74a.k(j).b();
            }
            this.f74a.a();
        }
        if (g) {
            Log.v($2, $(34, 57, 577) + this);
        }
        for (int j2 = this.f75b.j() - 1; j2 >= 0; j2--) {
            this.f75b.k(j2).b();
        }
        this.f75b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        for (int j = this.f74a.j() - 1; j >= 0; j--) {
            this.f74a.k(j).k = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        for (int j = this.f74a.j() - 1; j >= 0; j--) {
            this.f74a.k(j).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        boolean z = g;
        String $2 = $(57, 70, 4404);
        if (z) {
            Log.v($2, $(70, 83, 4366) + this);
        }
        if (!this.d) {
            RuntimeException runtimeException = new RuntimeException($(83, 87, 1650));
            runtimeException.fillInStackTrace();
            Log.w($2, $(87, 121, 9481) + this, runtimeException);
            return;
        }
        this.e = true;
        this.d = false;
        for (int j = this.f74a.j() - 1; j >= 0; j--) {
            this.f74a.k(j).f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        boolean z = g;
        String $2 = $(121, 134, 6822);
        if (z) {
            Log.v($2, $(134, 146, 5199) + this);
        }
        if (this.d) {
            RuntimeException runtimeException = new RuntimeException($(146, 150, 7739));
            runtimeException.fillInStackTrace();
            Log.w($2, $(150, 187, 7308) + this, runtimeException);
            return;
        }
        this.d = true;
        for (int j = this.f74a.j() - 1; j >= 0; j--) {
            this.f74a.k(j).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        boolean z = g;
        String $2 = $(187, 200, 9528);
        if (z) {
            Log.v($2, $(200, 212, 1624) + this);
        }
        if (!this.d) {
            RuntimeException runtimeException = new RuntimeException($(212, 216, 2007));
            runtimeException.fillInStackTrace();
            Log.w($2, $(216, 248, 291) + this, runtimeException);
            return;
        }
        for (int j = this.f74a.j() - 1; j >= 0; j--) {
            this.f74a.k(j).h();
        }
        this.d = false;
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int j = this.f74a.j();
        String $2 = $(248, 250, 264);
        String $3 = $(250, 253, 5709);
        String $4 = $(253, 257, 512);
        if (j > 0) {
            printWriter.print(str);
            printWriter.println($(257, 272, 6500));
            String str2 = str + $4;
            for (int i = 0; i < this.f74a.j(); i++) {
                a k = this.f74a.k(i);
                printWriter.print(str);
                printWriter.print($3);
                printWriter.print(this.f74a.g(i));
                printWriter.print($2);
                printWriter.println(k.toString());
                k.c(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f75b.j() > 0) {
            printWriter.print(str);
            printWriter.println($(272, 289, 3164));
            String str3 = str + $4;
            for (int i2 = 0; i2 < this.f75b.j(); i2++) {
                a k2 = this.f75b.k(i2);
                printWriter.print(str);
                printWriter.print($3);
                printWriter.print(this.f75b.g(i2));
                printWriter.print($2);
                printWriter.println(k2.toString());
                k2.c(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.e) {
            if (g) {
                Log.v($(311, 324, 4751), $(289, 311, 3066) + this);
            }
            this.e = false;
            for (int j = this.f74a.j() - 1; j >= 0; j--) {
                this.f74a.k(j).d();
            }
        }
    }

    public boolean i() {
        int j = this.f74a.j();
        boolean z = false;
        for (int i = 0; i < j; i++) {
            a k = this.f74a.k(i);
            z |= k.h && !k.f;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(l lVar) {
        this.f = lVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append($(324, 338, 18822));
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append($(338, 342, 21260));
        d.a(this.f, sb);
        sb.append($(342, 344, 22017));
        return sb.toString();
    }
}
