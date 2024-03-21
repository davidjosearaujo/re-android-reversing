package com.zjxyxnvvp.nxvxchltf.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class e {
    private static short[] $ = {6440, 6440, 6440, 6440, 6524, 6428, 6428, 6524, 6453, 6453, 6513, 6425, 6425, 6507, 6460, 6460, 3202, 3201, 6316, 6335, 6310, 6310, 6378, 6328, 6319, 6315, 6313, 6306};

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f365a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f366b = new SimpleDateFormat($(0, 16, 6481), Locale.US);
    private static long c;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(String str) {
        b(str, true);
    }

    public static void b(String str, boolean z) {
        if (f365a.size() <= 20) {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = f366b.format(new Date()) + $(16, 18, 3263) + str;
            if (z && f365a.size() > 0 && currentTimeMillis - c < 2000) {
                List<String> list = f365a;
                if (list.get(list.size() - 1).equals(str2)) {
                    return;
                }
            }
            f365a.add(str2);
            if (f365a.size() == 35) {
                f365a.add($(18, 28, 6346));
            }
            c = currentTimeMillis;
        }
    }
}
