package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class b {
    private static short[] $ = {1591, 1550, 1565, 1546, 1546, 1565, 1561, 1564, 1624, 1561, 1556, 1556, 1559, 1551, 1565, 1564, 1624, 1547, 1553, 1538, 1565, 1624, 1565, 1558, 1564, 1605, 4208, 4173, 4165, 4176, 4182, 4161, 4176, 4177, 4117, 4166, 4188, 4175, 4176, 4117, 6670, 6729, 6721, 6746, 6670, 6709, 6717, 6693, 6765, 4902, 4429, 4464, 4472, 4461, 4459, 4476, 4461, 4460, 4392, 4455, 4458, 4450, 4461, 4459, 4476, 4392, 4448, 4461, 4457, 4460, 4461, 4474, 4390, 4392, 4431, 4455, 4476, 4392, 4408, 4464, 5048, 4994, 5009, 5006, 5067, 5017, 5006, 5002, 5007, 5067, 4994, 5016, 5067, 4994, 4997, 5021, 5002, 4999, 4994, 5007, 5067, 5016, 5023, 5002, 5017, 5023, 5078, 6530, 6599, 6604, 6598, 6559};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static String[] a(Parcel parcel, int i) {
        int c = c(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (c == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + c);
        return createStringArray;
    }

    public static void b(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            StringBuilder sb = new StringBuilder(37);
            sb.append($(0, 26, 1656));
            sb.append(i);
            throw new c(sb.toString(), parcel);
        }
    }

    public static int c(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T d(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int c = c(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (c == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + c);
        return createFromParcel;
    }

    private static void e(Parcel parcel, int i, int i2) {
        int c = c(parcel, i);
        if (c != i2) {
            String valueOf = String.valueOf(Integer.toHexString(c));
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46);
            sb.append($(26, 40, 4149));
            sb.append(i2);
            sb.append($(40, 45, 6702));
            sb.append(c);
            sb.append($(45, 49, 6677));
            sb.append(valueOf);
            sb.append($(49, 50, 4879));
            throw new c(sb.toString(), parcel);
        }
    }

    public static void f(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + c(parcel, i));
    }

    public static <T> T[] g(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int c = c(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (c == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + c);
        return tArr;
    }

    public static <T> ArrayList<T> h(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int c = c(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (c == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + c);
        return createTypedArrayList;
    }

    public static boolean i(Parcel parcel, int i) {
        e(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int j(Parcel parcel) {
        int readInt = parcel.readInt();
        int c = c(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String $2 = $(50, 80, 4360);
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new c(valueOf.length() != 0 ? $2.concat(valueOf) : new String($2), parcel);
        }
        int i = c + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append($(80, 107, 5099));
        sb.append(dataPosition);
        sb.append($(107, 112, 6562));
        sb.append(i);
        throw new c(sb.toString(), parcel);
    }

    public static int k(Parcel parcel, int i) {
        e(parcel, i, 4);
        return parcel.readInt();
    }

    public static long l(Parcel parcel, int i) {
        e(parcel, i, 8);
        return parcel.readLong();
    }

    public static String m(Parcel parcel, int i) {
        int c = c(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (c == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + c);
        return readString;
    }

    public static IBinder n(Parcel parcel, int i) {
        int c = c(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (c == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + c);
        return readStrongBinder;
    }

    public static Bundle o(Parcel parcel, int i) {
        int c = c(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (c == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + c);
        return readBundle;
    }

    public static byte[] p(Parcel parcel, int i) {
        int c = c(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (c == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + c);
        return createByteArray;
    }
}
