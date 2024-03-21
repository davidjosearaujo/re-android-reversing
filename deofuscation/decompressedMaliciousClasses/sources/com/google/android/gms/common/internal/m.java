package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import b.a.a.a.e.w1;
import b.a.a.a.e.y1;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class m extends w1 implements k {
    private static short[] $ = {47, 35, 33, 98, 43, 35, 35, 43, 32, 41, 98, 45, 34, 40, 62, 35, 37, 40, 98, 43, 33, 63, 98, 47, 35, 33, 33, 35, 34, 98, 37, 34, 56, 41, 62, 34, 45, 32, 98, 5, 13, 47, 47, 35, 57, 34, 56, 13, 47, 47, 41, 63, 63, 35, 62};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(IBinder iBinder) {
        super(iBinder, $(0, 55, 76));
    }

    @Override // com.google.android.gms.common.internal.k
    public final Account h() {
        Parcel b2 = b(2, a());
        Account account = (Account) y1.a(b2, Account.CREATOR);
        b2.recycle();
        return account;
    }
}
