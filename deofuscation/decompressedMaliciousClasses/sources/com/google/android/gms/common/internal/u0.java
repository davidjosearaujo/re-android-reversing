package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import b.a.a.a.c.a;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class u0 extends l0 {
    private static short[] $ = {4916, 4894, 4864, 4912, 4895, 4890, 4886, 4893, 4871, 2521, 2511, 2520, 2524, 2499, 2505, 2511, 2442, 2510, 2511, 2521, 2505, 2520, 2499, 2522, 2526, 2501, 2520, 2442, 2503, 2499, 2521, 2503, 2507, 2526, 2505, 2498, 2448, 2442, 2549, 2467, 2470, 2555, 2549, 740, 754, 741, 737, 766, 756, 754, 695, 743, 741, 760, 757, 758, 757, 763, 750, 695, 755, 766, 754, 755};
    private IBinder g;
    private /* synthetic */ k0 h;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(k0 k0Var, int i, IBinder iBinder, Bundle bundle) {
        super(k0Var, i, bundle);
        this.h = k0Var;
        this.g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.l0
    protected final void e(a aVar) {
        if (this.h.n != null) {
            this.h.n.b(aVar);
        }
        this.h.o(aVar);
    }

    @Override // com.google.android.gms.common.internal.l0
    protected final boolean f() {
        String $2 = $(0, 9, 4979);
        try {
            String interfaceDescriptor = this.g.getInterfaceDescriptor();
            if (!this.h.j().equals(interfaceDescriptor)) {
                String valueOf = String.valueOf(this.h.j());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append($(9, 38, 2474));
                sb.append(valueOf);
                sb.append($(38, 43, 2517));
                sb.append(interfaceDescriptor);
                Log.e($2, sb.toString());
                return false;
            }
            IInterface l = this.h.l(this.g);
            if (l == null || (!(this.h.z(2, 4, l)) && !(this.h.z(3, 4, l)))) {
                return false;
            }
            this.h.q = null;
            Bundle K = this.h.K();
            if (this.h.m == null) {
                return true;
            }
            this.h.m.c(K);
            return true;
        } catch (RemoteException unused) {
            Log.w($2, $(43, 64, 663));
            return false;
        }
    }
}
