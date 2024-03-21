package com.zjxyxnvvp.nxvxchltf.k;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class a implements com.zjxyxnvvp.nxvxchltf.h.b.a {
    private static short[] $ = {7679, 7596, 7679, 7608, 8432, 8444, 8445, 8437, 8442, 8436, 3371, 3367, 3366, 3374, 3361, 3375, 594, 513, 594, 533, 7614, 7602, 7603, 7611, 7604, 7610, 3991, 3995, 3994, 3986, 3997, 3987, 8141, 8129, 8128, 8136, 8135, 8137, 2736, 2748, 2749, 2741, 2746, 2740, 4753, 4765, 4764, 4756, 4763, 4757};

    /* renamed from: a  reason: collision with root package name */
    private static final String f348a = Pattern.quote($(0, 4, 7555));

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Override // com.zjxyxnvvp.nxvxchltf.h.b.a
    public void a(Context context, String str) {
        c(context, str, "");
    }

    @Override // com.zjxyxnvvp.nxvxchltf.h.b.a
    public synchronized List<String> b(Context context, String str) {
        String e = e(context, str);
        if (e == null) {
            return Collections.emptyList();
        }
        String[] split = e.split(f348a);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!str2.isEmpty()) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    @Override // com.zjxyxnvvp.nxvxchltf.h.b.a
    public void c(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences($(4, 10, 8339), 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    @Override // com.zjxyxnvvp.nxvxchltf.h.b.a
    public synchronized void d(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences($(10, 16, 3400), 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, (sharedPreferences.getString(str, "") + str2) + $(16, 20, 558));
        edit.apply();
    }

    @Override // com.zjxyxnvvp.nxvxchltf.h.b.a
    public String e(Context context, String str) {
        return context.getSharedPreferences($(20, 26, 7645), 0).getString(str, null);
    }

    @Override // com.zjxyxnvvp.nxvxchltf.h.b.a
    public long f(Context context, String str) {
        return context.getSharedPreferences($(26, 32, 4084), 0).getLong(str, -1);
    }

    @Override // com.zjxyxnvvp.nxvxchltf.h.b.a
    public boolean g(Context context, String str) {
        return context.getSharedPreferences($(32, 38, 8110), 0).getBoolean(str, false);
    }

    @Override // com.zjxyxnvvp.nxvxchltf.h.b.a
    public void h(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences($(38, 44, 2771), 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    @Override // com.zjxyxnvvp.nxvxchltf.h.b.a
    public void i(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences($(44, 50, 4850), 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }
}
