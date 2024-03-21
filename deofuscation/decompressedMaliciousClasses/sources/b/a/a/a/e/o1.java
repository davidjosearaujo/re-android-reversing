package b.a.a.a.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.a.a.a.c.a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class o1 extends x1 implements n1 {
    private static short[] $ = {657, 669, 671, 732, 661, 669, 669, 661, 670, 663, 732, 659, 668, 662, 640, 669, 667, 662, 732, 661, 671, 641, 732, 641, 667, 661, 668, 667, 668, 732, 667, 668, 646, 663, 640, 668, 659, 670, 732, 699, 673, 667, 661, 668, 699, 668, 689, 659, 670, 670, 656, 659, 657, 665, 641};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public o1() {
        attachInterface(this, $(0, 55, 754));
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Parcelable.Creator creator;
        if (w(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 3) {
            y1.a(parcel, a.CREATOR);
            creator = k1.CREATOR;
        } else if (i == 4 || i == 6) {
            creator = Status.CREATOR;
        } else if (i == 7) {
            y1.a(parcel, Status.CREATOR);
            creator = GoogleSignInAccount.CREATOR;
        } else if (i != 8) {
            return false;
        } else {
            m((u1) y1.a(parcel, u1.CREATOR));
            parcel2.writeNoException();
            return true;
        }
        y1.a(parcel, creator);
        parcel2.writeNoException();
        return true;
    }
}
