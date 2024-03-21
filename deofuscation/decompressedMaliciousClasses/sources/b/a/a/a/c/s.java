package b.a.a.a.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.e0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class s {
    private static short[] $ = {65, 105, 105, 97, 106, 99, 85, 111, 97, 104, 103, 114, 115, 116, 99, 80, 99, 116, 111, 96, 111, 99, 116, 8107, 8090, 8088, 8080, 8090, 8092, 8094, 8155, 8083, 8090, 8072, 8155, 8086, 8084, 8073, 8094, 8155, 8079, 8083, 8090, 8085, 8155, 8084, 8085, 8094, 8155, 8072, 8082, 8092, 8085, 8090, 8079, 8078, 8073, 8094, 8149};

    /* renamed from: a  reason: collision with root package name */
    private static s f132a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private s(Context context) {
        context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l a(PackageInfo packageInfo, l... lVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w($(0, 23, 6), $(23, 59, 8187));
            return null;
        }
        m mVar = new m(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < lVarArr.length; i++) {
            if (lVarArr[i].equals(mVar)) {
                return lVarArr[i];
            }
        }
        return null;
    }

    public static s b(Context context) {
        e0.i(context);
        synchronized (s.class) {
            if (f132a == null) {
                k.a(context);
                f132a = new s(context);
            }
        }
        return f132a;
    }
}
