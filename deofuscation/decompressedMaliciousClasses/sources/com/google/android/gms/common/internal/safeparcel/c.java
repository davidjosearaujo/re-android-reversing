package com.google.android.gms.common.internal.safeparcel;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class c extends RuntimeException {
    private static short[] $ = {8351, 8431, 8414, 8397, 8412, 8410, 8403, 8325, 8351, 8399, 8400, 8396, 8322, 1954, 2033, 2027, 2040, 2023, 1983};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(java.lang.String r8, android.os.Parcel r9) {
        /*
            r7 = this;
            r3 = r7
            r4 = r8
            r5 = r9
            int r0 = r5.dataPosition()
            int r5 = r5.dataSize()
            java.lang.String r1 = java.lang.String.valueOf(r4)
            int r1 = r1.length()
            int r1 = r1 + 41
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r4)
            r7 = 0
            r8 = 13
            r9 = 8383(0x20bf, float:1.1747E-41)
            java.lang.String r4 = $(r7, r8, r9)
            r2.append(r4)
            r2.append(r0)
            r7 = 13
            r8 = 19
            r9 = 1922(0x782, float:2.693E-42)
            java.lang.String r4 = $(r7, r8, r9)
            r2.append(r4)
            r2.append(r5)
            java.lang.String r4 = r2.toString()
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.c.<init>(java.lang.String, android.os.Parcel):void");
    }
}
