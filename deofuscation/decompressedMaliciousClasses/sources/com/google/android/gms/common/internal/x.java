package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class x {
    private static short[] $ = {8249, 18753, 18765};

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f283a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f284b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private x(Object obj) {
        e0.i(obj);
        this.f284b = obj;
        this.f283a = new ArrayList();
    }

    public final x a(String str, Object obj) {
        List<String> list = this.f283a;
        e0.i(str);
        String str2 = str;
        String valueOf = String.valueOf(String.valueOf(obj));
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
        sb.append(str2);
        sb.append($(0, 1, 8196));
        sb.append(valueOf);
        list.add(sb.toString());
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.f284b.getClass().getSimpleName());
        sb.append('{');
        int size = this.f283a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.f283a.get(i));
            if (i < size - 1) {
                sb.append($(1, 3, 18797));
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
