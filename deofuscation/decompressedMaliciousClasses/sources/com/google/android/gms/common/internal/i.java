package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class i {
    private static short[] $ = {534, 522, 522, 526, 525, 580, 593, 593, 526, 530, 523, 525, 592, 537, 529, 529, 537, 530, 539, 592, 541, 529, 531, 593, 2479, 2469, 2494, 2479, 2464, 2473, 2495, 11793, 11806, 11801, 11795, 4057, 4040, 4042, 4034, 4040, 4046, 4044, 3374, 3361, 3371, 3389, 3360, 3366, 3371, 3425, 3388, 3370, 3387, 3387, 3366, 3361, 3368, 3388, 3425, 3342, 3359, 3359, 3331, 3334, 3340, 3342, 3355, 3334, 3328, 3329, 3344, 3339, 3338, 3355, 3342, 3334, 3331, 3356, 3344, 3356, 3338, 3355, 3355, 3334, 3329, 3336, 3356, 5707, 5703, 5701, 5638, 5711, 5703, 5703, 5711, 5700, 5709, 5638, 5705, 5702, 5708, 5722, 5703, 5697, 5708, 5638, 5707, 5700, 5703, 5707, 5699, 5727, 5703, 5722, 5699, 5638, 5696, 5703, 5701, 5709, 5638, 5757, 5752, 5740, 5737, 5756, 5741, 5751, 5737, 5734, 5740, 5754, 5735, 5729, 5740, 5751, 5759, 5741, 5737, 5754, 5751, 5737, 5739, 5756, 5729, 5735, 5734, 1960, 1956, 1958, 2021, 1964, 1956, 1956, 1964, 1959, 1966, 2021, 1962, 1957, 1967, 1977, 1956, 1954, 1967, 2021, 1980, 1966, 1962, 1977, 1962, 1961, 1959, 1966, 2021, 1962, 1979, 1979, 4567, 4568, 4562, 4548, 4569, 4575, 4562, 4504, 4575, 4568, 4546, 4563, 4568, 4546, 4504, 4567, 4565, 4546, 4575, 4569, 4568, 4504, 4576, 4607, 4595, 4577, 9828, 9832, 9851, 9826, 9836, 9853, 9779, 9766, 9766, 9837, 9836, 9853, 9832, 9824, 9829, 9850, 4691, 4702, 163, 176, 178, 190, 163, 178, 186, 180, 189, 186, 183, 1043, 1055, 1053, 1118, 1041, 1054, 1044, 1026, 1055, 1049, 1044, 1118, 1030, 1045, 1054, 1044, 1049, 1054, 1047};

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f264a;

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f265b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static {
        Uri parse = Uri.parse($(0, 24, 638));
        f264a = parse;
        f265b = parse.buildUpon().appendPath($(24, 31, 2508)).appendPath($(31, 35, 11895)).build();
    }

    public static Intent a(String str) {
        Uri fromParts = Uri.fromParts($(35, 42, 4009), str, null);
        Intent intent = new Intent($(42, 87, 3407));
        intent.setData(fromParts);
        return intent;
    }

    public static Intent b() {
        Intent intent = new Intent($(87, 147, 5672));
        intent.setPackage($(147, 178, 1995));
        return intent;
    }

    public static Intent c(String str, String str2) {
        Intent intent = new Intent($(178, 204, 4534));
        Uri.Builder appendQueryParameter = Uri.parse($(204, 220, 9737)).buildUpon().appendQueryParameter($(220, 222, 4666), str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter($(222, 233, 211), str2);
        }
        intent.setData(appendQueryParameter.build());
        intent.setPackage($(233, 252, 1136));
        intent.addFlags(524288);
        return intent;
    }
}
