package b.a.a.a.e;

import android.os.Parcel;
import b.a.a.a.f.b;
import b.a.a.a.f.f;
import b.a.a.a.f.i;
import b.a.a.a.f.k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class x0 extends x1 implements w0 {
    private static short[] $ = {6764, 6752, 6754, 6689, 6760, 6752, 6752, 6760, 6755, 6762, 6689, 6766, 6753, 6763, 6781, 6752, 6758, 6763, 6689, 6760, 6754, 6780, 6689, 6780, 6766, 6761, 6762, 6779, 6774, 6753, 6762, 6779, 6689, 6758, 6753, 6779, 6762, 6781, 6753, 6766, 6755, 6689, 6726, 6748, 6766, 6761, 6762, 6779, 6774, 6721, 6762, 6779, 6732, 6766, 6755, 6755, 6765, 6766, 6764, 6756, 6780};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public x0() {
        attachInterface(this, $(0, 61, 6671));
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (w(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                r((Status) y1.a(parcel, Status.CREATOR), (f) y1.a(parcel, f.CREATOR));
                throw null;
            case ModuleDescriptor.MODULE_VERSION /* 2 */:
                d(parcel.readString());
                throw null;
            case 3:
                l((Status) y1.a(parcel, Status.CREATOR), (b) y1.a(parcel, b.CREATOR));
                throw null;
            case 4:
                n((Status) y1.a(parcel, Status.CREATOR), y1.e(parcel));
                return true;
            case 5:
            case 9:
            default:
                return false;
            case 6:
                f((Status) y1.a(parcel, Status.CREATOR), (k) y1.a(parcel, k.CREATOR));
                throw null;
            case 7:
                k((Status) y1.a(parcel, Status.CREATOR), y1.e(parcel));
                throw null;
            case 8:
                t((Status) y1.a(parcel, Status.CREATOR), (i) y1.a(parcel, i.CREATOR));
                throw null;
            case 10:
                i((Status) y1.a(parcel, Status.CREATOR), y1.e(parcel));
                throw null;
            case 11:
                o((Status) y1.a(parcel, Status.CREATOR));
                throw null;
            case 12:
                e((Status) y1.a(parcel, Status.CREATOR), y1.e(parcel));
                throw null;
        }
    }
}
