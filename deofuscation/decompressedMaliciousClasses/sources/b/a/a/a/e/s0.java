package b.a.a.a.e;

import android.os.IBinder;
import android.os.Parcel;
import b.a.a.a.d.a;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class s0 extends w1 implements q0 {
    private static short[] $ = {5203, 5215, 5213, 5150, 5207, 5215, 5215, 5207, 5212, 5205, 5150, 5201, 5214, 5204, 5186, 5215, 5209, 5204, 5150, 5207, 5213, 5187, 5150, 5206, 5212, 5201, 5207, 5187, 5150, 5241, 5238, 5212, 5201, 5207, 5216, 5186, 5215, 5190, 5209, 5204, 5205, 5186};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(IBinder iBinder) {
        super(iBinder, $(0, 42, 5168));
    }

    @Override // b.a.a.a.e.q0
    public final boolean getBooleanFlagValue(String str, boolean z, int i) {
        Parcel a2 = a();
        a2.writeString(str);
        y1.d(a2, z);
        a2.writeInt(i);
        Parcel b2 = b(2, a2);
        boolean e = y1.e(b2);
        b2.recycle();
        return e;
    }

    @Override // b.a.a.a.e.q0
    public final int getIntFlagValue(String str, int i, int i2) {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeInt(i);
        a2.writeInt(i2);
        Parcel b2 = b(3, a2);
        int readInt = b2.readInt();
        b2.recycle();
        return readInt;
    }

    @Override // b.a.a.a.e.q0
    public final long getLongFlagValue(String str, long j, int i) {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeLong(j);
        a2.writeInt(i);
        Parcel b2 = b(4, a2);
        long readLong = b2.readLong();
        b2.recycle();
        return readLong;
    }

    @Override // b.a.a.a.e.q0
    public final String getStringFlagValue(String str, String str2, int i) {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeInt(i);
        Parcel b2 = b(5, a2);
        String readString = b2.readString();
        b2.recycle();
        return readString;
    }

    @Override // b.a.a.a.e.q0
    public final void init(a aVar) {
        Parcel a2 = a();
        y1.b(a2, aVar);
        c(1, a2);
    }
}
