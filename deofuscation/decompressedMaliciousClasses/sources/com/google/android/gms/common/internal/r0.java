package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class r0 extends q {
    private static short[] $ = {8235, 8234, 8212, 8235, 8247, 8240, 8205, 8234, 8237, 8240, 8199, 8235, 8233, 8244, 8232, 8225, 8240, 8225, 8292, 8231, 8229, 8234, 8292, 8230, 8225, 8292, 8231, 8229, 8232, 8232, 8225, 8224, 8292, 8235, 8234, 8232, 8253, 8292, 8235, 8234, 8231, 8225, 8292, 8244, 8225, 8246, 8292, 8231, 8229, 8232, 8232, 8292, 8240, 8235, 8292, 8227, 8225, 8240, 8214, 8225, 8233, 8235, 8240, 8225, 8215, 8225, 8246, 8242, 8237, 8231, 8225, 696, 658, 652, 700, 659, 662, 666, 657, 651, 1339, 1324, 1322, 1324, 1312, 1343, 1324, 1325, 1385, 1325, 1324, 1337, 1339, 1324, 1322, 1320, 1341, 1324, 1325, 1385, 1318, 1319, 1288, 1322, 1322, 1318, 1340, 1319, 1341, 1311, 1320, 1317, 1312, 1325, 1320, 1341, 1312, 1318, 1319, 1290, 1318, 1316, 1337, 1317, 1324, 1341, 1324, 1385, 1322, 1320, 1317, 1317, 1323, 1320, 1322, 1314, 1381, 1385, 1312, 1326, 1319, 1318, 1339, 1312, 1319, 1326};

    /* renamed from: a  reason: collision with root package name */
    private k0 f273a;

    /* renamed from: b  reason: collision with root package name */
    private final int f274b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public r0(k0 k0Var, int i) {
        this.f273a = k0Var;
        this.f274b = i;
    }

    @Override // com.google.android.gms.common.internal.p
    public final void g(int i, IBinder iBinder, Bundle bundle) {
        e0.e(this.f273a, $(0, 71, 8260));
        this.f273a.u(i, iBinder, bundle, this.f274b);
        this.f273a = null;
    }

    @Override // com.google.android.gms.common.internal.p
    public final void u(int i, Bundle bundle) {
        Log.wtf($(71, 80, 767), $(80, 146, 1353), new Exception());
    }
}
