package com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags;

import com.google.android.gms.common.util.DynamiteApi;
@DynamiteApi
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class ModuleDescriptor {
    private static short[] $ = {-21879, -21883, -21881, -21820, -21875, -21883, -21883, -21875, -21882, -21873, -21820, -21877, -21884, -21874, -21864, -21883, -21885, -21874, -21820, -21875, -21881, -21863, -21820, -21876, -21882, -21877, -21875, -21863};
    public static String MODULE_ID = $(0, 28, -21782);
    public static final int MODULE_VERSION = 2;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }
}
