package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class a extends l {
    private static short[] $ = {128, 162, 162, 174, 180, 175, 181, 128, 162, 162, 164, 178, 178, 174, 179, 8083, 8100, 8108, 8110, 8117, 8100, 8161, 8096, 8098, 8098, 8110, 8116, 8111, 8117, 8161, 8096, 8098, 8098, 8100, 8114, 8114, 8110, 8115, 8161, 8113, 8115, 8110, 8099, 8096, 8099, 8109, 8120, 8161, 8101, 8104, 8100, 8101};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static Account x(k kVar) {
        long clearCallingIdentity;
        if (kVar != null) {
            try {
                clearCallingIdentity = Binder.clearCallingIdentity();
                return kVar.h();
            } catch (RemoteException unused) {
                Log.w($(0, 15, 193), $(15, 52, 8129));
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
