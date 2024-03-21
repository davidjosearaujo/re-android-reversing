package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import b.a.a.a.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class l0 extends p0<Boolean> {
    private static short[] $ = {7492, 7505, 7514, 7504, 7517, 7514, 7507, 7549, 7514, 7488, 7505, 7514, 7488, 2472, 2505, 2447, 2440, 2461, 2440, 2437, 2505, 2445, 2444, 2463, 2444, 2437, 2438, 2457, 2444, 2459, 2505, 2444, 2459, 2459, 2438, 2459, 2505, 2433, 2440, 2458, 2505, 2438, 2442, 2442, 2460, 2459, 2459, 2444, 2445, 2503, 2505, 2474, 2433, 2444, 2442, 2434, 2505, 2461, 2433, 2444, 2505, 2437, 2438, 2446, 2458, 2505, 2447, 2438, 2459, 2505, 2447, 2460, 2459, 2461, 2433, 2444, 2459, 2505, 2432, 2439, 2447, 2438, 2459, 2436, 2440, 2461, 2432, 2438, 2439, 2503};
    private int d;
    private Bundle e;
    private /* synthetic */ k0 f;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(k0 k0Var, int i, Bundle bundle) {
        super(k0Var, Boolean.TRUE);
        this.f = k0Var;
        this.d = i;
        this.e = bundle;
    }

    @Override // com.google.android.gms.common.internal.p0
    protected final /* synthetic */ void d(Boolean bool) {
        PendingIntent pendingIntent = null;
        if (bool == null) {
            this.f.v(1, null);
            return;
        }
        int i = this.d;
        if (i != 0) {
            if (i != 10) {
                this.f.v(1, null);
                Bundle bundle = this.e;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable($(0, 13, 7476));
                }
                e(new a(this.d, pendingIntent));
                return;
            }
            this.f.v(1, null);
            throw new IllegalStateException($(13, 90, 2537));
        } else if (!f()) {
            this.f.v(1, null);
            e(new a(8, null));
        }
    }

    protected abstract void e(a aVar);

    protected abstract boolean f();
}
