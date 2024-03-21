package a.a.a.a;

import a.a.a.a.h;
import a.a.a.a.n;
import a.a.a.d.e;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class b extends r implements n.e {
    private static short[] $ = {543, 593, 592, 584, 543, 8226, 8248, 8303, 8313, 8299, 8248, 2431, 2397, 2386, 2331, 2376, 2332, 2399, 2388, 2397, 2386, 2395, 2393, 2332, 2376, 2397, 2395, 2332, 2387, 2394, 2332, 2394, 2382, 2397, 2395, 2385, 2393, 2386, 2376, 2332, 508, 478, 465, 408, 459, 415, 476, 471, 478, 465, 472, 474, 415, 476, 464, 465, 459, 478, 470, 465, 474, 461, 415, 502, 507, 415, 464, 473, 415, 473, 461, 478, 472, 466, 474, 465, 459, 415, 1369, 1403, 1396, 1341, 1390, 1338, 1403, 1406, 1406, 1338, 1404, 1384, 1403, 1405, 1399, 1407, 1396, 1390, 1338, 4311, 4224, 4254, 4227, 4255, 4311, 4227, 4246, 4240, 4311, 6455, 6499, 6520, 6455, 6516, 6520, 6521, 6499, 6518, 6526, 6521, 6514, 6501, 6455, 6497, 6526, 6514, 6496, 6455, 6496, 6526, 6499, 6527, 6455, 6521, 6520, 6455, 6526, 6515, 927, 939, 952, 958, 948, 956, 951, 941, 1017, 5971, 5918, 5894, 5888, 5895, 5971, 5905, 5910, 5971, 5906, 5971, 5891, 5894, 5905, 5919, 5914, 5904, 5971, 5888, 5895, 5906, 5895, 5914, 5904, 5971, 5904, 5919, 5906, 5888, 5888, 5971, 5895, 5916, 5971, 5905, 5910, 5971, 5971, 5891, 5889, 5916, 5891, 5910, 5889, 5919, 5898, 5971, 5889, 5910, 5904, 5889, 5910, 5906, 5895, 5910, 5911, 5971, 5909, 5889, 5916, 5918, 7257, 7184, 7191, 7178, 7181, 7192, 7191, 7194, 7196, 7257, 7178, 7181, 7192, 7181, 7196, 7255, 6365, 6394, 6369, 6325, 6319, 7600, 7556, 7575, 7569, 7579, 7571, 7576, 7554, 7611, 7575, 7576, 7575, 7569, 7571, 7556, 8728, 8748, 8767, 8761, 8755, 8763, 8752, 8746, 8723, 8767, 8752, 8767, 8761, 8763, 8748, 4641, 4630, 4622, 4627, 4675, 4621, 4614, 4624, 4631, 4618, 4621, 4612, 4675, 4618, 4621, 4675, 9918, 9980, 9959, 9918, 8600, 8623, 8631, 8618, 8698, 8628, 8639, 8617, 8622, 8627, 8628, 8637, 8698, 8629, 8636, 8698, 5724, 5640, 5651, 5724, 115, 95, 93, 93, 89, 68, 10, 16, 8530, 8550, 8565, 8563, 8569, 8561, 8570, 8544, 8537, 8565, 8570, 8565, 8563, 8561, 8550, 5752, 5752, 8387, 8399, 8397, 8397, 8393, 8404, 8320, 8385, 8396, 8402, 8389, 8385, 8388, 8409, 8320, 8387, 8385, 8396, 8396, 8389, 8388, 9584, 9555, 9596, 9584, 9592, 9504, 9362, 9439, 9467, 9436, 9430, 9431, 9418, 9359, 5614, 5539, 5517, 5537, 5539, 5539, 5543, 5562, 5562, 5547, 5546, 5619, 3776, 3833, 3807, 3788, 3779, 3806, 3780, 3801, 3780, 3778, 3779, 3728, 3726, 3384, 3445, 3404, 3434, 3449, 3446, 3435, 3441, 3436, 3441, 3447, 3446, 3403, 3436, 3425, 3444, 3453, 3365, 3387, 2749, 2709, 2750, 2724, 2741, 2722, 2705, 2750, 2745, 2749, 2797, 2803, 7422, 7347, 7323, 7334, 7351, 7338, 7327, 7344, 7351, 7347, 7395, 7421, 4582, 4571, 4580, 4603, 4558, 4581, 4607, 4590, 4601, 4554, 4581, 4578, 4582, 4534, 4520, 5659, 5718, 5739, 5716, 5707, 5758, 5699, 5714, 5711, 5754, 5717, 5714, 5718, 5638, 5656, 9784, 9751, 9767, 9776, 9780, 9777, 9750, 9767, 9760, 9784, 9783, 9729, 9788, 9761, 9785, 9776, 9735, 9776, 9766, 9832, 9846, 2364, 2417, 2398, 2414, 2425, 2429, 2424, 2399, 2414, 2409, 2417, 2430, 2376, 2421, 2408, 2416, 2425, 2376, 2425, 2404, 2408, 2337, 2283, 2244, 2292, 2275, 2279, 2274, 2245, 2292, 2291, 2283, 2276, 2261, 2286, 2281, 2292, 2290, 2258, 2287, 2290, 2282, 2275, 2260, 2275, 2293, 2235, 2213, 6712, 6773, 6746, 6762, 6781, 6777, 6780, 6747, 6762, 6765, 6773, 6778, 6731, 6768, 6775, 6762, 6764, 6732, 6769, 6764, 6772, 6781, 6732, 6781, 6752, 6764, 6693, 3918, 3953, 3940, 3955, 3936, 3957, 3944, 3950, 3951, 3954, 3899, 8930, 8930, 8930, 8930, 5948, 5938, 5947, 5986, 3228, 3209, 3209, 3228, 3230, 3221, 496, 497, 480, 501, 503, 508, 806, 829, 826, 802, 696, 697, 692, 693, 8219, 8204, 8196, 8198, 8223, 8204, 8881, 8870, 8883, 8879, 8866, 8864, 8870, 9059, 9062, 9062, 2448, 2443, 2450, 2450, 6488, 6488, 6455, 6408, 6488, 6491, 1617, 1611, 7626, 7775, 7764, 7758, 7775, 7752, 7803, 7764, 7763, 7767, 7687, 7705, 5849, 5788, 5761, 5776, 5773, 5816, 5783, 5776, 5780, 5828, 5850, 4047, 4048, 4047, 4090, 4049, 4043, 4058, 4045, 4094, 4049, 4054, 4050, 3970, 3996, 7833, 7881, 7894, 7881, 7932, 7873, 7888, 7885, 7928, 7895, 7888, 7892, 7812, 7834, 736, 731, 734, 731, 730, 706, 731, 661, 726, 728, 721, 655, 661, 8407, 8428, 8425, 8428, 8429, 8437, 8428, 8354, 8417, 8431, 8422, 8376, 8354, 20909, 20878, 20876, 20868, 20924, 20891, 20878, 20876, 20868, 20906, 20865, 20891, 20893, 20886, 20884, 18869, 18870, 28724, 20076};

    /* renamed from: a */
    final n f2a;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    String j;
    boolean k;
    int m;
    CharSequence n;
    int o;
    CharSequence p;
    ArrayList<String> q;
    ArrayList<String> r;

    /* renamed from: b */
    ArrayList<a> f3b = new ArrayList<>();
    int l = -1;
    boolean s = false;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static final class a {

        /* renamed from: a */
        int f4a;

        /* renamed from: b */
        h f5b;
        int c;
        int d;
        int e;
        int f;
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static {
        int i = Build.VERSION.SDK_INT;
    }

    public b(n nVar) {
        this.f2a = nVar;
    }

    private void i(int i, h hVar, String str, int i2) {
        Class<?> cls = hVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException($(136, 145, 985) + cls.getCanonicalName() + $(145, 206, 6003) + $(206, 222, 7289));
        }
        hVar.p = this.f2a;
        String $2 = $(0, 5, 575);
        String $3 = $(5, 11, 8216);
        if (str != null) {
            String str2 = hVar.w;
            if (str2 == null || str.equals(str2)) {
                hVar.w = str;
            } else {
                throw new IllegalStateException($(11, 40, 2364) + hVar + $3 + hVar.w + $2 + str);
            }
        }
        if (i != 0) {
            if (i != -1) {
                int i3 = hVar.u;
                if (i3 == 0 || i3 == i) {
                    hVar.u = i;
                    hVar.v = i;
                } else {
                    throw new IllegalStateException($(40, 78, 447) + hVar + $3 + hVar.u + $2 + i);
                }
            } else {
                throw new IllegalArgumentException($(78, 97, 1306) + hVar + $(97, 107, 4343) + str + $(107, 136, 6423));
            }
        }
        a aVar = new a();
        aVar.f4a = i2;
        aVar.f5b = hVar;
        f(aVar);
    }

    private static boolean r(a aVar) {
        h hVar = aVar.f5b;
        return hVar.j && hVar.F != null && !hVar.y && !hVar.x && hVar.G();
    }

    @Override // a.a.a.a.n.e
    public boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        if (n.B) {
            Log.v($(227, 242, 7670), $(222, 227, 6287) + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.i) {
            return true;
        }
        this.f2a.h(this);
        return true;
    }

    @Override // a.a.a.a.r
    public r b(h hVar, String str) {
        i(0, hVar, str, 1);
        return this;
    }

    @Override // a.a.a.a.r
    public int c() {
        return h(false);
    }

    @Override // a.a.a.a.r
    public int d() {
        return h(true);
    }

    @Override // a.a.a.a.r
    public r e(h hVar) {
        a aVar = new a();
        aVar.f4a = 3;
        aVar.f5b = hVar;
        f(aVar);
        return this;
    }

    public void f(a aVar) {
        this.f3b.add(aVar);
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
    }

    public void g(int i) {
        if (this.i) {
            boolean z = n.B;
            String $2 = $(242, 257, 8798);
            if (z) {
                Log.v($2, $(257, 273, 4707) + this + $(273, 277, 9886) + i);
            }
            int size = this.f3b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.f3b.get(i2);
                h hVar = aVar.f5b;
                if (hVar != null) {
                    hVar.o += i;
                    if (n.B) {
                        Log.v($2, $(277, 293, 8666) + aVar.f5b + $(293, 297, 5756) + aVar.f5b.o);
                    }
                }
            }
        }
    }

    int h(boolean z) {
        if (!this.k) {
            if (n.B) {
                String $2 = $(305, 320, 8468);
                Log.v($2, $(297, 305, 48) + this);
                j($(320, 322, 5720), null, new PrintWriter(new e($2)), null);
            }
            this.k = true;
            this.l = this.i ? this.f2a.j(this) : -1;
            this.f2a.Y(this, z);
            return this.l;
        }
        throw new IllegalStateException($(322, 343, 8352));
    }

    public void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        k(str, printWriter, true);
    }

    public void k(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print($(343, 349, 9501));
            printWriter.print(this.j);
            printWriter.print($(349, 357, 9394));
            printWriter.print(this.l);
            printWriter.print($(357, 369, 5582));
            printWriter.println(this.k);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print($(369, 382, 3757));
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print($(382, 401, 3352));
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.c == 0 && this.d == 0)) {
                printWriter.print(str);
                printWriter.print($(401, 413, 2768));
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print($(413, 425, 7390));
                printWriter.println(Integer.toHexString(this.d));
            }
            if (!(this.e == 0 && this.f == 0)) {
                printWriter.print(str);
                printWriter.print($(425, 440, 4491));
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print($(440, 455, 5691));
                printWriter.println(Integer.toHexString(this.f));
            }
            if (!(this.m == 0 && this.n == null)) {
                printWriter.print(str);
                printWriter.print($(455, 476, 9813));
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print($(476, 498, 2332));
                printWriter.println(this.n);
            }
            if (!(this.o == 0 && this.p == null)) {
                printWriter.print(str);
                printWriter.print($(498, 524, 2182));
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print($(524, 551, 6680));
                printWriter.println(this.p);
            }
        }
        if (!this.f3b.isEmpty()) {
            printWriter.print(str);
            printWriter.println($(551, 562, 3841));
            String str3 = str + $(562, 566, 8898);
            int size = this.f3b.size();
            for (int i = 0; i < size; i++) {
                a aVar = this.f3b.get(i);
                switch (aVar.f4a) {
                    case 0:
                        str2 = $(606, 610, 2526);
                        break;
                    case 1:
                        str2 = $(603, 606, 8994);
                        break;
                    case ModuleDescriptor.MODULE_VERSION /* 2 */:
                        str2 = $(596, 603, 8931);
                        break;
                    case 3:
                        str2 = $(590, 596, 8265);
                        break;
                    case 4:
                        str2 = $(586, 590, 752);
                        break;
                    case 5:
                        str2 = $(582, 586, 885);
                        break;
                    case 6:
                        str2 = $(576, 582, 436);
                        break;
                    case 7:
                        str2 = $(570, 576, 3293);
                        break;
                    default:
                        str2 = $(566, 570, 5983) + aVar.f4a;
                        break;
                }
                printWriter.print(str);
                printWriter.print($(610, 616, 6520));
                printWriter.print(i);
                printWriter.print($(616, 618, 1643));
                printWriter.print(str2);
                printWriter.print($(618, 619, 7658));
                printWriter.println(aVar.f5b);
                if (z) {
                    if (!(aVar.c == 0 && aVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print($(619, 630, 7738));
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print($(630, 641, 5881));
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print($(641, 655, 4031));
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print($(655, 669, 7865));
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    public void l() {
        int size = this.f3b.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f3b.get(i);
            h hVar = aVar.f5b;
            hVar.N0(this.g, this.h);
            int i2 = aVar.f4a;
            if (i2 == 1) {
                hVar.M0(aVar.c);
                this.f2a.i(hVar, false);
            } else if (i2 == 3) {
                hVar.M0(aVar.d);
                this.f2a.H0(hVar);
            } else if (i2 == 4) {
                hVar.M0(aVar.d);
                this.f2a.n0(hVar);
            } else if (i2 == 5) {
                hVar.M0(aVar.c);
                this.f2a.T0(hVar);
            } else if (i2 == 6) {
                hVar.M0(aVar.d);
                this.f2a.q(hVar);
            } else if (i2 == 7) {
                hVar.M0(aVar.c);
                this.f2a.l(hVar);
            } else {
                throw new IllegalArgumentException($(669, 682, 693) + aVar.f4a);
            }
            if (!this.s && aVar.f4a != 1) {
                this.f2a.w0(hVar);
            }
        }
        if (!this.s) {
            n nVar = this.f2a;
            nVar.x0(nVar.l, true);
        }
    }

    public void m() {
        for (int size = this.f3b.size() - 1; size >= 0; size--) {
            a aVar = this.f3b.get(size);
            h hVar = aVar.f5b;
            hVar.N0(n.L0(this.g), this.h);
            int i = aVar.f4a;
            if (i == 1) {
                hVar.M0(aVar.f);
                this.f2a.H0(hVar);
            } else if (i == 3) {
                hVar.M0(aVar.e);
                this.f2a.i(hVar, false);
            } else if (i == 4) {
                hVar.M0(aVar.e);
                this.f2a.T0(hVar);
            } else if (i == 5) {
                hVar.M0(aVar.f);
                this.f2a.n0(hVar);
            } else if (i == 6) {
                hVar.M0(aVar.e);
                this.f2a.l(hVar);
            } else if (i == 7) {
                hVar.M0(aVar.f);
                this.f2a.q(hVar);
            } else {
                throw new IllegalArgumentException($(682, 695, 8322) + aVar.f4a);
            }
            if (!this.s && aVar.f4a != 3) {
                this.f2a.w0(hVar);
            }
        }
        if (!this.s) {
            n nVar = this.f2a;
            nVar.x0(nVar.l, true);
        }
    }

    public void n(ArrayList<h> arrayList) {
        int i = 0;
        while (i < this.f3b.size()) {
            a aVar = this.f3b.get(i);
            int i2 = aVar.f4a;
            if (i2 != 1) {
                if (i2 == 2) {
                    h hVar = aVar.f5b;
                    int i3 = hVar.v;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        h hVar2 = arrayList.get(size);
                        if (hVar2.v == i3) {
                            if (hVar2 == hVar) {
                                z = true;
                            } else {
                                a aVar2 = new a();
                                aVar2.f4a = 3;
                                aVar2.f5b = hVar2;
                                aVar2.c = aVar.c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.f3b.add(i, aVar2);
                                arrayList.remove(hVar2);
                                i++;
                            }
                        }
                    }
                    if (z) {
                        this.f3b.remove(i);
                        i--;
                    } else {
                        aVar.f4a = 1;
                        arrayList.add(hVar);
                    }
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(aVar.f5b);
                } else if (i2 != 7) {
                }
                i++;
            }
            arrayList.add(aVar.f5b);
            i++;
        }
    }

    public String o() {
        return this.j;
    }

    public boolean p(int i) {
        int size = this.f3b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f3b.get(i2).f5b.v == i) {
                return true;
            }
        }
        return false;
    }

    public boolean q(ArrayList<b> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f3b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = this.f3b.get(i4).f5b.v;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    b bVar = arrayList.get(i6);
                    int size2 = bVar.f3b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        if (bVar.f3b.get(i7).f5b.v == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public boolean s() {
        for (int i = 0; i < this.f3b.size(); i++) {
            if (r(this.f3b.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void t(h.e eVar) {
        for (int i = 0; i < this.f3b.size(); i++) {
            a aVar = this.f3b.get(i);
            if (r(aVar)) {
                aVar.f5b.O0(eVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append($(695, 710, 20975));
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.l >= 0) {
            sb.append($(710, 712, 18837));
            sb.append(this.l);
        }
        if (this.j != null) {
            sb.append($(712, 713, 28692));
            sb.append(this.j);
        }
        sb.append($(713, 714, 19985));
        return sb.toString();
    }

    public void u(ArrayList<h> arrayList) {
        for (int i = 0; i < this.f3b.size(); i++) {
            a aVar = this.f3b.get(i);
            int i2 = aVar.f4a;
            if (i2 != 1) {
                if (i2 == 3 || i2 == 6) {
                    arrayList.add(aVar.f5b);
                } else if (i2 != 7) {
                }
            }
            arrayList.remove(aVar.f5b);
        }
    }
}
