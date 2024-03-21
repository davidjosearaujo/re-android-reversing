package b.a.a.a.e;

import com.google.android.gms.common.api.Status;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class l0 {
    private static short[] $ = {3518, 3458, 3471, 3530, 3465, 3461, 3460, 3460, 3471, 3465, 3486, 3459, 3461, 3460, 3530, 3486, 3461, 3530, 3501, 3461, 3461, 3469, 3462, 3471, 3530, 3514, 3462, 3467, 3475, 3530, 3481, 3471, 3480, 3484, 3459, 3465, 3471, 3481, 3530, 3485, 3467, 3481, 3530, 3462, 3461, 3481, 3486};

    /* renamed from: a  reason: collision with root package name */
    public static final Status f166a = new Status(8, $(0, 47, 3562));

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }
}
