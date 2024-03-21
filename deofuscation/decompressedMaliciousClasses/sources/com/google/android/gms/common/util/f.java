package com.google.android.gms.common.util;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class f {
    private static short[] $ = {2845, 2824, 2828, 2912, 2818, 5427, 5414, 5422, 5454, 5420, 9899, 9894, 8587, 8590, 8603, 8601, 8691};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static String a(byte[] bArr, int i, int i2, boolean z) {
        String str;
        if (bArr == null || bArr.length == 0 || i2 <= 0 || i2 > bArr.length) {
            return null;
        }
        StringBuilder sb = new StringBuilder((((i2 + 16) - 1) / 16) * 57);
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        while (i5 > 0) {
            if (i3 == 0) {
                str = i2 < 65536 ? String.format($(0, 5, 2872), Integer.valueOf(i4)) : String.format($(5, 10, 5398), Integer.valueOf(i4));
            } else {
                if (i3 == 8) {
                    str = $(10, 12, 9867);
                }
                sb.append(String.format($(12, 17, 8619), Integer.valueOf(bArr[i4] & 255)));
                i5--;
                i3++;
                if (i3 != 16 || i5 == 0) {
                    sb.append('\n');
                    i3 = 0;
                }
                i4++;
            }
            sb.append(str);
            sb.append(String.format($(12, 17, 8619), Integer.valueOf(bArr[i4] & 255)));
            i5--;
            i3++;
            if (i3 != 16) {
            }
            sb.append('\n');
            i3 = 0;
            i4++;
        }
        return sb.toString();
    }
}
