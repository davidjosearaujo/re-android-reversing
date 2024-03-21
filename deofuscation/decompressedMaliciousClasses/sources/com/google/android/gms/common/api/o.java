package com.google.android.gms.common.api;

import android.os.Looper;
import b.a.a.a.e.e;
import b.a.a.a.e.j0;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.e0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class o {
    private static short[] $ = {4973, 4938, 4959, 4938, 4939, 4941, 4987, 4934, 4957, 4955, 4942, 4938, 4951, 4945, 4944, 4979, 4959, 4942, 4942, 4955, 4940, 4894, 4947, 4939, 4941, 4938, 4894, 4944, 4945, 4938, 4894, 4956, 4955, 4894, 4944, 4939, 4946, 4946, 4880};

    /* renamed from: a  reason: collision with root package name */
    private j0 f241a;

    /* renamed from: b  reason: collision with root package name */
    private Looper f242b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public final o a(j0 j0Var) {
        e0.e(j0Var, $(0, 39, 4926));
        this.f241a = j0Var;
        return this;
    }

    public final d.a b() {
        if (this.f241a == null) {
            this.f241a = new e();
        }
        if (this.f242b == null) {
            this.f242b = Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper();
        }
        return new d.a(this.f241a, this.f242b);
    }
}
