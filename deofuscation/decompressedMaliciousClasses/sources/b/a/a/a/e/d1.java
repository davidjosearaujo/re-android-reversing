package b.a.a.a.e;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.w0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class d1 extends b<y0> {
    private static short[] $ = {5463, 5467, 5465, 5402, 5459, 5467, 5467, 5459, 5464, 5457, 5402, 5461, 5466, 5456, 5446, 5467, 5469, 5456, 5402, 5459, 5465, 5447, 5402, 5447, 5461, 5458, 5457, 5440, 5453, 5466, 5457, 5440, 5402, 5447, 5457, 5446, 5442, 5469, 5463, 5457, 5402, 5479, 5472, 5493, 5478, 5472, 8200, 8196, 8198, 8261, 8204, 8196, 8196, 8204, 8199, 8206, 8261, 8202, 8197, 8207, 8217, 8196, 8194, 8207, 8261, 8204, 8198, 8216, 8261, 8216, 8202, 8205, 8206, 8223, 8210, 8197, 8206, 8223, 8261, 8194, 8197, 8223, 8206, 8217, 8197, 8202, 8199, 8261, 8226, 8248, 8202, 8205, 8206, 8223, 8210, 8229, 8206, 8223, 8248, 8206, 8217, 8221, 8194, 8200, 8206, 2554, 2550, 2548, 2487, 2558, 2550, 2550, 2558, 2549, 2556, 2487, 2552, 2551, 2557, 2539, 2550, 2544, 2557, 2487, 2558, 2548, 2538, 2487, 2538, 2552, 2559, 2556, 2541, 2528, 2551, 2556, 2541, 2487, 2544, 2551, 2541, 2556, 2539, 2551, 2552, 2549, 2487, 2512, 2506, 2552, 2559, 2556, 2541, 2528, 2519, 2556, 2541, 2506, 2556, 2539, 2543, 2544, 2554, 2556};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public d1(Context context, Looper looper, w0 w0Var, e.b bVar, e.c cVar) {
        super(context, looper, 45, w0Var, bVar, cVar);
    }

    @Override // com.google.android.gms.common.internal.k0
    protected final String g() {
        return $(0, 46, 5428);
    }

    @Override // com.google.android.gms.common.internal.k0
    public final String j() {
        return $(46, 105, 8299);
    }

    @Override // com.google.android.gms.common.internal.k0
    public final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface($(105, 164, 2457));
        return queryLocalInterface instanceof y0 ? (y0) queryLocalInterface : new z0(iBinder);
    }
}
