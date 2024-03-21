package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import b.a.a.a.e.x1;
import b.a.a.a.e.y1;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class q extends x1 implements p {
    private static short[] $ = {2951, 2955, 2953, 3018, 2947, 2955, 2955, 2947, 2952, 2945, 3018, 2949, 2954, 2944, 2966, 2955, 2957, 2944, 3018, 2947, 2953, 2967, 3018, 2951, 2955, 2953, 2953, 2955, 2954, 3018, 2957, 2954, 2960, 2945, 2966, 2954, 2949, 2952, 3018, 2989, 2979, 2953, 2967, 2983, 2949, 2952, 2952, 2950, 2949, 2951, 2959, 2967};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public q() {
        attachInterface(this, $(0, 52, 3044));
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (w(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            g(parcel.readInt(), parcel.readStrongBinder(), (Bundle) y1.a(parcel, Bundle.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            u(parcel.readInt(), (Bundle) y1.a(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
