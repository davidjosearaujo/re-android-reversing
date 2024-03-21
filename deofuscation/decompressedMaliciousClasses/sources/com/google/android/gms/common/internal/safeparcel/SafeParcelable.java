package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public interface SafeParcelable extends Parcelable {
    private static short[] $ = {-26355, -26337, -26344, -26341, -26367, -26354, -26337, -26356, -26339, -26341, -26350, -26337, -26340, -26350, -26341, -26367, -26352, -26357, -26350, -26350, -26367, -26355, -26358, -26356, -26345, -26352, -26343};
    public static String NULL = $(0, 27, -26274);

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }
}
