package b.a.a.a.e;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.a.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.f0;
import com.google.android.gms.common.internal.t0;
import com.google.android.gms.common.internal.w0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class r1 extends b<p1> implements i1 {
    private static short[] $ = {2986, 2982, 2980, 3047, 2990, 2982, 2982, 2990, 2981, 2988, 3047, 2984, 2983, 2989, 3003, 2982, 2976, 2989, 3047, 2990, 2980, 3002, 3047, 3002, 2976, 2990, 2983, 2976, 2983, 3047, 2976, 2983, 3005, 2988, 3003, 2983, 2984, 2981, 3047, 2986, 2981, 2976, 2988, 2983, 3005, 2971, 2988, 3000, 3004, 2988, 3002, 3005, 2988, 2989, 2952, 2986, 2986, 2982, 3004, 2983, 3005, 5437, 5425, 5427, 5488, 5433, 5425, 5425, 5433, 5426, 5435, 5488, 5439, 5424, 5434, 5420, 5425, 5431, 5434, 5488, 5433, 5427, 5421, 5488, 5437, 5425, 5427, 5427, 5425, 5424, 5488, 5431, 5424, 5418, 5435, 5420, 5424, 5439, 5426, 5488, 5405, 5426, 5431, 5435, 5424, 5418, 5389, 5435, 5418, 5418, 5431, 5424, 5433, 5421, 5488, 5421, 5435, 5421, 5421, 5431, 5425, 5424, 5399, 5434, 7434, 7430, 7428, 7495, 7438, 7430, 7430, 7438, 7429, 7436, 7495, 7432, 7431, 7437, 7451, 7430, 7424, 7437, 7495, 7438, 7428, 7450, 7495, 7450, 7424, 7438, 7431, 7424, 7431, 7495, 7424, 7431, 7453, 7436, 7451, 7431, 7432, 7429, 7495, 7430, 7439, 7439, 7429, 7424, 7431, 7436, 7464, 7434, 7434, 7436, 7450, 7450, 7483, 7436, 7448, 7452, 7436, 7450, 7453, 7436, 7437, 8533, 8537, 8539, 8472, 8529, 8537, 8537, 8529, 8538, 8531, 8472, 8535, 8536, 8530, 8516, 8537, 8543, 8530, 8472, 8529, 8539, 8517, 8472, 8517, 8543, 8529, 8536, 8543, 8536, 8472, 8543, 8536, 8514, 8531, 8516, 8536, 8535, 8538, 8472, 8543, 8530, 8546, 8537, 8541, 8531, 8536, 8548, 8531, 8519, 8515, 8531, 8517, 8514, 8531, 8530, 8681, 8677, 8679, 8612, 8685, 8677, 8677, 8685, 8678, 8687, 8612, 8683, 8676, 8686, 8696, 8677, 8675, 8686, 8612, 8685, 8679, 8697, 8612, 8697, 8675, 8685, 8676, 8675, 8676, 8612, 8675, 8676, 8702, 8687, 8696, 8676, 8683, 8678, 8612, 8697, 8687, 8696, 8700, 8687, 8696, 8649, 8678, 8675, 8687, 8676, 8702, 8643, 8686, 765, 753, 755, 688, 761, 753, 753, 761, 754, 763, 688, 767, 752, 762, 748, 753, 759, 762, 688, 761, 755, 749, 688, 749, 759, 761, 752, 759, 752, 688, 759, 752, 746, 763, 748, 752, 767, 754, 688, 747, 749, 763, 718, 748, 753, 755, 750, 746, 723, 753, 762, 763, 728, 753, 748, 735, 747, 746, 758, 733, 753, 762, 763, 8556, 8544, 8546, 8481, 8552, 8544, 8544, 8552, 8547, 8554, 8481, 8558, 8545, 8555, 8573, 8544, 8550, 8555, 8481, 8552, 8546, 8572, 8481, 8572, 8550, 8552, 8545, 8550, 8545, 8481, 8550, 8545, 8571, 8554, 8573, 8545, 8558, 8547, 8481, 8553, 8544, 8573, 8556, 8554, 8524, 8544, 8555, 8554, 8521, 8544, 8573, 8541, 8554, 8553, 8573, 8554, 8572, 8551, 8539, 8544, 8548, 8554, 8545, 7816, 7812, 7814, 7877, 7820, 7812, 7812, 7820, 7815, 7822, 7877, 7818, 7813, 7823, 7833, 7812, 7810, 7823, 7877, 7820, 7814, 7832, 7877, 7832, 7810, 7820, 7813, 7810, 7813, 7877, 7810, 7813, 7839, 7822, 7833, 7813, 7818, 7815, 7877, 7811, 7812, 7832, 7839, 7822, 7823, 7855, 7812, 7814, 7818, 7810, 7813, 8677, 8681, 8683, 8616, 8673, 8681, 8681, 8673, 8682, 8675, 8616, 8679, 8680, 8674, 8692, 8681, 8687, 8674, 8616, 8673, 8683, 8693, 8616, 8693, 8687, 8673, 8680, 8687, 8680, 8616, 8687, 8680, 8690, 8675, 8692, 8680, 8679, 8682, 8616, 8689, 8679, 8687, 8690, 8640, 8681, 8692, 8647, 8677, 8677, 8675, 8693, 8693, 8658, 8681, 8685, 8675, 8680, 8660, 8675, 8672, 8692, 8675, 8693, 8686, 5458, 5470, 5468, 5407, 5462, 5470, 5470, 5462, 5469, 5460, 5407, 5456, 5471, 5461, 5443, 5470, 5464, 5461, 5407, 5462, 5468, 5442, 5407, 5442, 5464, 5462, 5471, 5464, 5471, 5407, 5464, 5471, 5445, 5460, 5443, 5471, 5456, 5469, 5407, 5456, 5444, 5445, 5465, 5488, 5441, 5464, 5474, 5464, 5462, 5471, 5496, 5471, 5500, 5470, 5461, 5444, 5469, 5460, 5479, 5460, 5443, 5442, 5464, 5470, 5471, 9396, 9400, 9402, 9465, 9392, 9400, 9400, 9392, 9403, 9394, 9465, 9398, 9401, 9395, 9381, 9400, 9406, 9395, 9465, 9392, 9402, 9380, 9465, 9380, 9406, 9392, 9401, 9406, 9401, 9465, 9406, 9401, 9379, 9394, 9381, 9401, 9398, 9403, 9465, 9381, 9394, 9398, 9403, 9364, 9403, 9406, 9394, 9401, 9379, 9371, 9406, 9397, 9381, 9398, 9381, 9390, 9345, 9394, 9381, 9380, 9406, 9400, 9401, 7344, 7356, 7358, 7421, 7348, 7356, 7356, 7348, 7359, 7350, 7421, 7346, 7357, 7351, 7329, 7356, 7354, 7351, 7421, 7348, 7358, 7328, 7421, 7328, 7354, 7348, 7357, 7354, 7357, 7421, 7354, 7357, 7335, 7350, 7329, 7357, 7346, 7359, 7421, 7329, 7350, 7346, 7359, 7312, 7359, 7354, 7350, 7357, 7335, 7299, 7346, 7344, 7352, 7346, 7348, 7350, 7325, 7346, 7358, 7350, 9562, 9558, 9556, 9495, 9566, 9558, 9558, 9566, 9557, 9564, 9495, 9560, 9559, 9565, 9547, 9558, 9552, 9565, 9495, 9566, 9556, 9546, 9495, 9546, 9552, 9566, 9559, 9552, 9559, 9495, 9546, 9564, 9547, 9551, 9552, 9562, 9564, 9495, 9578, 9581, 9592, 9579, 9581, 1720, 1716, 1718, 1781, 1724, 1716, 1716, 1724, 1719, 1726, 1781, 1722, 1717, 1727, 1705, 1716, 1714, 1727, 1781, 1724, 1718, 1704, 1781, 1704, 1714, 1724, 1717, 1714, 1717, 1781, 1714, 1717, 1711, 1726, 1705, 1717, 1722, 1719, 1781, 1682, 1672, 1714, 1724, 1717, 1682, 1717, 1672, 1726, 1705, 1709, 1714, 1720, 1726, 1487, 1522, 1530, 1519, 1513, 1534, 1507, 1508, 1517, 1450, 1515, 1450, 1532, 1515, 1510, 1507, 1518, 1450, 1475, 1497, 1507, 1517, 1508, 1475, 1508, 1481, 1515, 1510, 1510, 1512, 1515, 1513, 1505, 1529, 4787, 4787, 4843, 4842, 4841, 4846, 4858, 4835, 4859, 4783, 4846, 4844, 4844, 4832, 4858, 4833, 4859, 4785, 4785, 3210, 3248, 3262, 3255, 3216, 3255, 3226, 3253, 3248, 3260, 3255, 3245, 3216, 3252, 3241, 3253, 2657, 2646, 2654, 2652, 2631, 2646, 2579, 2624, 2646, 2625, 2629, 2650, 2640, 2646, 2579, 2627, 2625, 2652, 2641, 2642, 2641, 2655, 2634, 2579, 2647, 2650, 2646, 2647, 2579, 2628, 2651, 2646, 2653, 2579, 2624, 2650, 2644, 2653, 2682, 2653, 2579, 2650, 2624, 2579, 2640, 2642, 2655, 2655, 2646, 2647, 8035, 8057, 8003, 8013, 8004, 8035, 8004, 8041, 8011, 8006, 8006, 8008, 8011, 8009, 8001, 8025, 7945, 8005, 8004, 8057, 8003, 8013, 8004, 8035, 8004, 8041, 8005, 8007, 8026, 8006, 8015, 8030, 8015, 7946, 8025, 8002, 8005, 8031, 8006, 8014, 7946, 8008, 8015, 7946, 8015, 8018, 8015, 8009, 8031, 8030, 8015, 8014, 7946, 8012, 8024, 8005, 8007, 7946, 8030, 8002, 8015, 7946, 8025, 
    8011, 8007, 8015, 7946, 8026, 8024, 8005, 8009, 8015, 8025, 8025, 7942, 7946, 8031, 8004, 8015, 8018, 8026, 8015, 8009, 8030, 8015, 8014, 7946, 8056, 8015, 8007, 8005, 8030, 8015, 8047, 8018, 8009, 8015, 8026, 8030, 8003, 8005, 8004, 7940, 9465, 9461, 9463, 9396, 9469, 9461, 9461, 9469, 9462, 9471, 9396, 9467, 9460, 9470, 9448, 9461, 9459, 9470, 9396, 9469, 9463, 9449, 9396, 9449, 9459, 9469, 9460, 9459, 9460, 9396, 9459, 9460, 9454, 9471, 9448, 9460, 9467, 9462, 9396, 9427, 9417, 9459, 9469, 9460, 9427, 9460, 9417, 9471, 9448, 9452, 9459, 9465, 9471};
    private final boolean v;
    private final w0 w;
    private final Bundle x;
    private Integer y;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public r1(Context context, Looper looper, boolean z, w0 w0Var, Bundle bundle, e.b bVar, e.c cVar) {
        super(context, looper, 44, w0Var, bVar, cVar);
        this.v = z;
        this.w = w0Var;
        this.x = bundle;
        this.y = w0Var.h();
    }

    public r1(Context context, Looper looper, boolean z, w0 w0Var, j1 j1Var, e.b bVar, e.c cVar) {
        this(context, looper, true, w0Var, V(w0Var), bVar, cVar);
    }

    public static Bundle V(w0 w0Var) {
        j1 g = w0Var.g();
        Integer h = w0Var.h();
        Bundle bundle = new Bundle();
        bundle.putParcelable($(0, 61, 3017), w0Var.a());
        if (h != null) {
            bundle.putInt($(61, 124, 5470), h.intValue());
        }
        if (g != null) {
            bundle.putBoolean($(124, 185, 7529), g.c());
            bundle.putBoolean($(185, 240, 8502), g.b());
            bundle.putString($(240, 293, 8586), g.a());
            bundle.putBoolean($(293, 356, 670), true);
            bundle.putBoolean($(356, 419, 8463), g.d());
            bundle.putString($(419, 470, 7915), g.e());
            bundle.putBoolean($(470, 534, 8582), g.f());
            if (g.g() != null) {
                bundle.putLong($(534, 599, 5425), g.g().longValue());
            }
            if (g.h() != null) {
                bundle.putLong($(599, 662, 9431), g.h().longValue());
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.k0
    protected final Bundle J() {
        if (!n().getPackageName().equals(this.w.e())) {
            this.x.putString($(662, 722, 7379), this.w.e());
        }
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.k0, com.google.android.gms.common.api.a.f
    public final boolean a() {
        return this.v;
    }

    @Override // b.a.a.a.e.i1
    public final void f() {
        h(new t0(this));
    }

    @Override // com.google.android.gms.common.internal.k0
    protected final String g() {
        return $(722, 765, 9529);
    }

    @Override // com.google.android.gms.common.internal.k0
    public final String j() {
        return $(765, 818, 1755);
    }

    @Override // b.a.a.a.e.i1
    public final void k(n1 n1Var) {
        e0.e(n1Var, $(818, 852, 1418));
        try {
            Account c = this.w.c();
            GoogleSignInAccount googleSignInAccount = null;
            if ($(852, 871, 4751).equals(c.name)) {
                googleSignInAccount = d.a(n()).e();
            }
            ((p1) Q()).p(new s1(new f0(c, this.y.intValue(), googleSignInAccount)), n1Var);
        } catch (RemoteException e) {
            String $2 = $(871, 887, 3289);
            Log.w($2, $(887, 937, 2611));
            try {
                n1Var.m(new u1(8));
            } catch (RemoteException unused) {
                Log.wtf($2, $(937, 1040, 7978), e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.k0
    public final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface($(1040, 1093, 9370));
        return queryLocalInterface instanceof p1 ? (p1) queryLocalInterface : new q1(iBinder);
    }
}
