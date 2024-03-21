package b.a.a.a.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b.a.a.a.d.a;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class r0 extends x1 implements q0 {
    private static short[] $ = {10175, 10163, 10161, 10226, 10171, 10163, 10163, 10171, 10160, 10169, 10226, 10173, 10162, 10168, 10158, 10163, 10165, 10168, 10226, 10171, 10161, 10159, 10226, 10170, 10160, 10173, 10171, 10159, 10226, 10133, 10138, 10160, 10173, 10171, 10124, 10158, 10163, 10154, 10165, 10168, 10169, 10158, 1727, 1715, 1713, 1778, 1723, 1715, 1715, 1723, 1712, 1721, 1778, 1725, 1714, 1720, 1710, 1715, 1717, 1720, 1778, 1723, 1713, 1711, 1778, 1722, 1712, 1725, 1723, 1711, 1778, 1685, 1690, 1712, 1725, 1723, 1676, 1710, 1715, 1706, 1717, 1720, 1721, 1710};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public r0() {
        attachInterface(this, $(0, 42, 10204));
    }

    public static q0 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface($(42, 84, 1756));
        return queryLocalInterface instanceof q0 ? (q0) queryLocalInterface : new s0(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (w(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            init(a.AbstractBinderC0004a.x(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i == 2) {
            boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), y1.e(parcel), parcel.readInt());
            parcel2.writeNoException();
            y1.d(parcel2, booleanFlagValue);
        } else if (i == 3) {
            int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeInt(intFlagValue);
        } else if (i == 4) {
            long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(longFlagValue);
        } else if (i != 5) {
            return false;
        } else {
            String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeString(stringFlagValue);
        }
        return true;
    }
}
