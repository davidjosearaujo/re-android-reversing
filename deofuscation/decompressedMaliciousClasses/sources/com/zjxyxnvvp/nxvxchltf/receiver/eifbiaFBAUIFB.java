package com.zjxyxnvvp.nxvxchltf.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.zjxyxnvvp.nxvxchltf.KAopneaoniAoiasM;
import com.zjxyxnvvp.nxvxchltf.niNOIAdiowanOI;
import com.zjxyxnvvp.nxvxchltf.util.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class eifbiaFBAUIFB extends BroadcastReceiver {
    private static short[] $ = {7141, 7162, 7138, 7152, 7143, 7304, 7332, 7340, 7339, 7314, 7338, 7351, 7342, 7328, 7351, 7423, 7423, 7345, 7332, 7330};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(Context context, boolean z) {
        Thread k = niNOIAdiowanOI.k();
        if (k == null || !k.isAlive() || k.isInterrupted()) {
            context.stopService(new Intent(context, niNOIAdiowanOI.class));
            KAopneaoniAoiasM.b(context);
        }
        if (z) {
            b.t(context);
        }
    }

    public static void b(Context context, boolean z) {
        ((PowerManager) context.getSystemService($(0, 5, 7061))).newWakeLock(1, $(5, 20, 7365)).acquire(120000);
        a(context, z);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
    }
}
