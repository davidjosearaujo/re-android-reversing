package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class d {
    private static int a(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void b(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void c(Parcel parcel, int i) {
        b(parcel, i);
    }

    public static void d(Parcel parcel, int i, long j) {
        n(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void e(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int a2 = a(parcel, i);
            parcel.writeBundle(bundle);
            b(parcel, a2);
        }
    }

    public static void f(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int a2 = a(parcel, i);
            parcel.writeStrongBinder(iBinder);
            b(parcel, a2);
        }
    }

    public static void g(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int a2 = a(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            b(parcel, a2);
        } else if (z) {
            n(parcel, i, 0);
        }
    }

    public static void h(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int a2 = a(parcel, i);
            parcel.writeString(str);
            b(parcel, a2);
        } else if (z) {
            n(parcel, i, 0);
        }
    }

    public static void i(Parcel parcel, int i, boolean z) {
        n(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void j(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int a2 = a(parcel, i);
            parcel.writeByteArray(bArr);
            b(parcel, a2);
        }
    }

    public static <T extends Parcelable> void k(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int a2 = a(parcel, i);
            int length = tArr.length;
            parcel.writeInt(length);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    m(parcel, t, i2);
                }
            }
            b(parcel, a2);
        }
    }

    public static void l(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int a2 = a(parcel, i);
            parcel.writeStringArray(strArr);
            b(parcel, a2);
        }
    }

    private static <T extends Parcelable> void m(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void n(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | -65536);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    public static void o(Parcel parcel, int i, int i2) {
        n(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static <T extends Parcelable> void p(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int a2 = a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                T t = list.get(i2);
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    m(parcel, t, 0);
                }
            }
            b(parcel, a2);
        } else if (z) {
            n(parcel, i, 0);
        }
    }

    public static int q(Parcel parcel) {
        return a(parcel, 20293);
    }
}
