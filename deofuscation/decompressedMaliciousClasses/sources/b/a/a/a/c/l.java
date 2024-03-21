package b.a.a.a.c;

import android.os.RemoteException;
import android.util.Log;
import b.a.a.a.d.a;
import b.a.a.a.d.c;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.util.f;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class l extends o {
    private static short[] $ = {5646, 5672, 5695, 5689, 5741, 5669, 5676, 5694, 5669, 5741, 5673, 5676, 5689, 5676, 5741, 5669, 5676, 5694, 5741, 5668, 5667, 5678, 5666, 5695, 5695, 5672, 5678, 5689, 5741, 5665, 5672, 5667, 5674, 5689, 5669, 5741, 5733, 2153, 2170, 2122, 5907, 5947, 5947, 5939, 5944, 5937, 5911, 5937, 5926, 5920, 5949, 5938, 5949, 5943, 5941, 5920, 5937, 5927, 7732, 7730, 7717, 7715, 7799, 7743, 7734, 7716, 7743, 7799, 7731, 7734, 7715, 7734, 7799, 7743, 7734, 7716, 7799, 7742, 7737, 7732, 7736, 7717, 7717, 7730, 7732, 7715, 7799, 7739, 7730, 7737, 7728, 7715, 7743, 7801, 7799, 7739, 7730, 7737, 7728, 7715, 7743, 7786, 7129, 7107, 7135, 7101, 7080, 7080, 7077, 7081, 7101, 7073, 31243, 31267, 31267, 31275, 31264, 31273, 31247, 31273, 31294, 31288, 31269, 31274, 31269, 31279, 31277, 31288, 31273, 31295, 27115, 27084, 27076, 27073, 27080, 27081, 27021, 27097, 27074, 27021, 27082, 27080, 27097, 27021, 27114, 27074, 27074, 27082, 27073, 27080, 27021, 27086, 27080, 27103, 27097, 27076, 27083, 27076, 27086, 27084, 27097, 27080, 27102, 27021, 27083, 27103, 27074, 27072, 27021, 27103, 27080, 27072, 27074, 27097, 27080};

    /* renamed from: a */
    private int f126a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public l(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2.length != 25) {
            int length = bArr2.length;
            boolean z = false;
            String valueOf = String.valueOf(f.a(bArr2, 0, bArr2.length, false));
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
            sb.append($(0, 37, 5709));
            sb.append(length);
            sb.append($(37, 40, 2112));
            sb.append(valueOf);
            Log.wtf($(40, 58, 5972), sb.toString(), new Exception());
            bArr2 = Arrays.copyOfRange(bArr2, 0, 25);
            z = bArr2.length == 25 ? true : z;
            int length2 = bArr2.length;
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append($(58, 102, 7767));
            sb2.append(length2);
            e0.f(z, sb2.toString());
        }
        this.f126a = Arrays.hashCode(bArr2);
    }

    public static byte[] y(String str) {
        try {
            return str.getBytes($(102, 112, 7056));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        a v;
        if (obj != null && (obj instanceof n)) {
            try {
                n nVar = (n) obj;
                if (nVar.s() == hashCode() && (v = nVar.v()) != null) {
                    return Arrays.equals(x(), (byte[]) c.y(v));
                }
                return false;
            } catch (RemoteException e) {
                Log.e($(112, 130, 31308), $(130, 175, 27053), e);
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.f126a;
    }

    @Override // com.google.android.gms.common.internal.n
    public final int s() {
        return hashCode();
    }

    @Override // com.google.android.gms.common.internal.n
    public final a v() {
        return c.z(x());
    }

    abstract byte[] x();
}
