package com.google.android.gms.common.internal;

import android.os.Parcel;
import b.a.a.a.d.a;
import b.a.a.a.e.x1;
import b.a.a.a.e.y1;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class o extends x1 implements n {
    private static short[] $ = {8812, 8800, 8802, 8737, 8808, 8800, 8800, 8808, 8803, 8810, 8737, 8814, 8801, 8811, 8829, 8800, 8806, 8811, 8737, 8808, 8802, 8828, 8737, 8812, 8800, 8802, 8802, 8800, 8801, 8737, 8806, 8801, 8827, 8810, 8829, 8801, 8814, 8803, 8737, 8774, 8780, 8810, 8829, 8827, 8779, 8814, 8827, 8814};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public o() {
        attachInterface(this, $(0, 48, 8719));
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (w(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            a v = v();
            parcel2.writeNoException();
            y1.b(parcel2, v);
        } else if (i != 2) {
            return false;
        } else {
            int s = s();
            parcel2.writeNoException();
            parcel2.writeInt(s);
        }
        return true;
    }
}
