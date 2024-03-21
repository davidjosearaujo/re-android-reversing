package b.a.a.a.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import b.a.a.a.b;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class r {
    @Deprecated

    /* renamed from: a */
    public static final int f130a = 11010000;
    private static short[] $ = {1840, 1852, 1854, 1917, 1844, 1852, 1852, 1844, 1855, 1846, 1917, 1842, 1853, 1847, 1825, 1852, 1850, 1847, 1917, 1844, 1854, 1824, 2359, 2335, 2335, 2327, 2332, 2325, 2336, 2332, 2321, 2313, 2339, 2325, 2306, 2310, 2329, 2323, 2325, 2307, 2341, 2308, 2329, 2332, 6286, 6322, 6335, 6394, 6301, 6325, 6325, 6333, 6326, 6335, 6394, 6282, 6326, 6331, 6307, 6394, 6313, 6335, 6312, 6316, 6323, 6329, 6335, 6313, 6394, 6312, 6335, 6313, 6325, 6319, 6312, 6329, 6335, 6313, 6394, 6317, 6335, 6312, 6335, 6394, 6324, 6325, 6318, 6394, 6332, 6325, 6319, 6324, 6334, 6388, 6394, 6297, 6322, 6335, 6329, 6321, 6394, 6307, 6325, 6319, 6312, 6394, 6314, 6312, 6325, 6320, 6335, 6329, 6318, 6394, 6329, 6325, 6324, 6332, 6323, 6333, 6319, 6312, 6331, 6318, 6323, 6325, 6324, 6394, 6318, 6325, 6394, 6335, 6324, 6313, 6319, 6312, 6335, 6394, 6318, 6322, 6331, 6318, 6394, 6318, 6322, 6335, 6394, 6312, 6335, 6313, 6325, 6319, 6312, 6329, 6335, 6313, 6394, 6331, 6312, 6335, 6394, 6323, 6324, 6329, 6326, 6319, 6334, 6335, 6334, 6388, 9143, 9147, 9145, 9210, 9139, 9147, 9147, 9139, 9144, 9137, 9210, 9141, 9146, 9136, 9126, 9147, 9149, 9136, 9210, 9139, 9145, 9127, 3474, 3536, 3527, 3526, 3474, 3540, 3549, 3527, 3548, 3542, 3474, 3521, 3533, 3535, 3468, 3525, 3533, 3533, 3525, 3534, 3527, 3468, 3523, 3532, 3526, 3536, 3533, 3531, 3526, 3468, 3525, 3535, 3537, 3468, 3540, 3527, 3536, 3537, 3531, 3533, 3532, 5416, 5396, 5401, 5468, 5393, 5401, 5384, 5405, 5457, 5400, 5405, 5384, 5405, 5468, 5384, 5405, 5403, 5468, 5397, 5394, 5468, 5381, 5395, 5385, 5390, 5468, 5405, 5388, 5388, 5467, 5391, 5468, 5437, 5394, 5400, 5390, 5395, 5397, 5400, 5425, 5405, 5394, 5397, 5402, 5401, 5391, 5384, 5458, 5380, 5393, 5392, 5468, 5400, 5395, 5401, 5391, 5468, 5394, 5395, 5384, 5468, 5396, 5405, 5386, 5401, 5468, 5384, 5396, 5401, 5468, 5390, 5397, 5403, 5396, 5384, 5468, 5386, 5405, 5392, 5385, 5401, 5458, 5468, 5468, 5433, 5380, 5388, 5401, 5407, 5384, 5401, 5400, 5468, 9646, 9632, 9632, 9689, 9711, 9717, 9632, 9709, 9717, 9715, 9716, 9632, 9704, 9697, 9718, 9701, 9632, 9716, 9704, 9701, 9632, 9702, 9711, 9708, 9708, 9711, 9719, 9705, 9710, 9703, 9632, 9700, 9701, 9699, 9708, 9697, 9714, 9697, 9716, 9705, 9711, 9710, 9632, 9719, 9705, 9716, 9704, 9705, 9710, 9632, 9716, 9704, 9701, 9632, 9660, 9697, 9712, 9712, 9708, 9705, 9699, 9697, 9716, 9705, 9711, 9710, 9662, 9632, 9701, 9708, 9701, 9709, 9701, 9710, 9716, 9658, 9632, 9632, 9632, 9632, 9632, 9660, 9709, 9701, 9716, 9697, 9645, 9700, 9697, 9716, 9697, 9632, 9697, 9710, 9700, 9714, 9711, 9705, 9700, 9658, 9710, 9697, 9709, 9701, 9661, 9634, 4790, 4788, 4853, 4858, 4848, 4838, 4859, 4861, 4848, 4782, 4834, 4853, 4856, 4833, 4849, 4777, 4790, 4820, 4861, 4858, 4832, 4849, 4851, 4849, 4838, 4795, 4851, 4859, 4859, 4851, 4856, 4849, 4811, 4836, 4856, 4853, 4845, 4811, 4839, 4849, 4838, 4834, 4861, 4855, 4849, 4839, 4811, 4834, 4849, 4838, 4839, 4861, 4859, 4858, 4790, 4788, 4795, 4778, 7659, 7562, 7640, 7631, 7643, 7647, 7619, 7640, 7631, 7630, 7562, 7623, 7631, 7646, 7627, 7559, 7630, 7627, 7646, 7627, 7562, 7646, 7627, 7629, 7562, 7619, 7620, 7562, 7635, 7621, 7647, 7640, 7562, 7627, 7642, 7642, 7565, 7641, 7562, 7659, 7620, 7630, 7640, 7621, 7619, 7630, 7655, 7627, 7620, 7619, 7628, 7631, 7641, 7646, 7556, 7634, 7623, 7622, 7562, 7630, 7621, 7631, 7641, 7562, 7620, 7621, 7646, 7562, 7631, 7634, 7619, 7641, 7646, 7556, 7562, 7562, 7667, 7621, 7647, 7562, 7623, 7647, 7641, 7646, 7562, 7618, 7627, 7644, 7631, 7562, 7646, 7618, 7631, 7562, 7628, 7621, 7622, 7622, 7621, 7645, 7619, 7620, 7629, 7562, 7630, 7631, 7625, 7622, 7627, 7640, 7627, 7646, 7619, 7621, 7620, 7562, 7645, 7619, 7646, 7618, 7619, 7620, 7562, 7646, 7618, 7631, 7562, 7574, 7627, 7642, 7642, 7622, 7619, 7625, 7627, 7646, 7619, 7621, 7620, 7572, 7562, 7631, 7622, 7631, 7623, 7631, 7620, 7646, 7568, 7562, 7562, 7562, 7562, 7562, 7574, 7623, 7631, 7646, 7627, 7559, 7630, 7627, 7646, 7627, 7562, 7627, 7620, 7630, 7640, 7621, 7619, 7630, 7568, 7620, 7627, 7623, 7631, 7575, 7560, 7625, 7621, 7623, 7556, 7629, 7621, 7621, 7629, 7622, 7631, 7556, 7627, 7620, 7630, 7640, 7621, 7619, 7630, 7556, 7629, 7623, 7641, 7556, 7644, 7631, 7640, 7641, 7619, 7621, 7620, 7560, 7562, 7627, 7620, 7630, 7640, 7621, 7619, 7630, 7568, 7644, 7627, 7622, 7647, 7631, 7575, 7560, 7658, 7619, 7620, 7646, 7631, 7629, 7631, 7640, 7557, 7629, 7621, 7621, 7629, 7622, 7631, 7669, 7642, 7622, 7627, 7635, 7669, 7641, 7631, 7640, 7644, 7619, 7625, 7631, 7641, 7669, 7644, 7631, 7640, 7641, 7619, 7621, 7620, 7560, 7562, 7557, 7572, 3763, 3775, 3773, 3838, 3761, 3774, 3764, 3746, 3775, 3769, 3764, 3838, 3750, 3765, 3774, 3764, 3769, 3774, 3767, 1749, 1789, 1789, 1781, 1790, 1783, 1714, 1730, 1790, 1779, 1771, 1714, 1729, 1766, 1789, 1760, 1783, 1714, 1787, 1761, 1714, 1791, 1787, 1761, 1761, 1787, 1788, 1781, 1724, 6244, 6220, 6220, 6212, 6223, 6214, 6147, 6259, 6223, 6210, 6234, 6147, 6224, 6214, 6225, 6229, 6218, 6208, 6214, 6224, 6147, 6224, 6218, 6212, 6221, 6210, 6231, 6230, 6225, 6214, 6147, 6218, 6221, 6229, 6210, 6223, 6218, 6215, 6157, 8659, 8699, 8699, 8691, 8696, 8689, 8628, 8644, 8696, 8693, 8685, 8628, 8647, 8672, 8699, 8678, 8689, 8628, 8679, 8701, 8691, 8698, 8693, 8672, 8673, 8678, 8689, 8628, 8701, 8698, 8674, 8693, 8696, 8701, 8688, 8634, 5098, 5058, 5058, 5066, 5057, 5064, 5005, 5117, 5057, 5068, 5076, 5005, 5086, 5064, 5087, 5083, 5060, 5070, 5064, 5086, 5005, 5058, 5080, 5081, 5005, 5058, 5067, 5005, 5065, 5068, 5081, 5064, 4995, 5005, 5005, 5119, 5064, 5084, 5080, 5060, 5087, 5064, 5086, 5005, 4994, 5034, 5034, 5026, 5033, 5024, 5093, 5013, 5033, 5028, 5052, 5093, 5046, 5024, 5047, 5043, 5036, 5030, 5024, 5046, 5093, 5032, 5036, 5046, 5046, 5036, 5035, 5026, 5093, 5042, 5037, 5024, 5035, 5093, 5026, 5024, 5041, 5041, 5036, 5035, 5026, 5093, 5028, 5045, 5045, 5033, 5036, 5030, 5028, 5041, 5036, 5034, 5035, 5093, 5036, 5035, 5027, 5034, 5099, 2473, 2433, 2433, 2441, 2434, 2443, 2510, 2494, 2434, 2447, 2455, 2510, 2461, 2443, 2460, 2456, 2439, 
    2445, 2443, 2461, 2510, 2439, 2461, 2510, 2435, 2439, 2461, 2461, 2439, 2432, 2441, 2496, 4157, 4145, 4147, 4208, 4153, 4145, 4145, 4153, 4146, 4155, 4208, 4159, 4144, 4154, 4140, 4145, 4151, 4154, 4208, 4153, 4147, 4141, 8621, 8609, 8611, 8672, 8617, 8609, 8609, 8617, 8610, 8619, 8672, 8623, 8608, 8618, 8636, 8609, 8615, 8618, 8672, 8617, 8611, 8637, 8072, 8078, 8088, 8079, 5590, 5584, 5591, 5575, 8241, 8230, 8240, 8247, 8241, 8234, 8224, 8247, 8230, 8231, 8220, 8243, 8241, 8236, 8229, 8234, 8239, 8230};

    /* renamed from: b */
    static final AtomicBoolean f131b = new AtomicBoolean();
    private static final AtomicBoolean c = new AtomicBoolean();

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Deprecated
    public static String a(int i) {
        return a.f(i);
    }

    public static Resources b(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication($(0, 22, 1875));
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Deprecated
    public static int c(Context context) {
        String $2;
        String $3 = $(22, 44, 2416);
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(b.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e($3, $(44, 170, 6362));
        }
        String packageName = context.getPackageName();
        String $4 = $(170, 192, 9172);
        boolean equals = $4.equals(packageName);
        String $5 = $(192, 203, 3506);
        if (!equals && !c.get()) {
            int a2 = u.a(context);
            if (a2 == 0) {
                throw new IllegalStateException($(490, 757, 7594));
            } else if (a2 != f130a) {
                int i = f130a;
                String $6 = $(203, 233, 3490);
                StringBuilder sb = new StringBuilder($6.length() + 290);
                sb.append($(233, 326, 5500));
                sb.append(i);
                sb.append($5);
                sb.append(a2);
                sb.append($(326, 432, 9600));
                sb.append($6);
                sb.append($(432, 490, 4756));
                throw new IllegalStateException(sb.toString());
            }
        }
        boolean z = !e.b(context) && !e.d(context);
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo($(757, 776, 3792), 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                $2 = $(776, 805, 1682);
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo($4, 64);
            s.b(context);
            String $7 = $(805, 844, 6179);
            if (z) {
                l a3 = s.a(packageInfo, o.f129a);
                if (a3 == null) {
                    $2 = $(844, 880, 8596);
                    Log.w($3, $2);
                    return 9;
                } else if (s.a(packageInfo2, a3) == null) {
                    Log.w($3, $7);
                    return 9;
                }
            } else if (s.a(packageInfo2, o.f129a) == null) {
                Log.w($3, $7);
                return 9;
            }
            int i2 = f130a;
            int i3 = i2 / 1000;
            int i4 = packageInfo2.versionCode;
            if (i4 / 1000 < i3) {
                StringBuilder sb2 = new StringBuilder(77);
                sb2.append($(880, 924, 5037));
                sb2.append(i2);
                sb2.append($5);
                sb2.append(i4);
                Log.w($3, sb2.toString());
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo($4, 0);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf($3, $(924, 983, 5061), e);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w($3, $(983, 1015, 2542));
            return 1;
        }
    }

    @Deprecated
    public static boolean d(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @Deprecated
    public static boolean e(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return f(context, $(1015, 1037, 4190));
        }
        return false;
    }

    @TargetApi(21)
    static boolean f(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle applicationRestrictions;
        boolean equals = str.equals($(1037, 1059, 8654));
        if (g.e()) {
            for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(sessionInfo.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (equals) {
            return applicationInfo.enabled;
        }
        if (applicationInfo.enabled) {
            if (!(g.c() && (applicationRestrictions = ((UserManager) context.getSystemService($(1059, 1063, 8189))).getApplicationRestrictions(context.getPackageName())) != null && $(1063, 1067, 5538).equals(applicationRestrictions.getString($(1067, 1085, 8259))))) {
                return true;
            }
        }
        return false;
    }
}
