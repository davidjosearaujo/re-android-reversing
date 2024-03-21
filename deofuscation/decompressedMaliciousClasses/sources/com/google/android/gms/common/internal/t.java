package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class t implements r {
    private static short[] $ = {2856, 2852, 2854, 2917, 2860, 2852, 2852, 2860, 2855, 2862, 2917, 2858, 2853, 2863, 2873, 2852, 2850, 2863, 2917, 2860, 2854, 2872, 2917, 2856, 2852, 2854, 2854, 2852, 2853, 2917, 2850, 2853, 2879, 2862, 2873, 2853, 2858, 2855, 2917, 2818, 2828, 2854, 2872, 2840, 2862, 2873, 2877, 2850, 2856, 2862, 2825, 2873, 2852, 2848, 2862, 2873};

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f277a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(IBinder iBinder) {
        this.f277a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f277a;
    }

    @Override // com.google.android.gms.common.internal.r
    public final void j(p pVar, b1 b1Var) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken($(0, 56, 2891));
            obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
            if (b1Var != null) {
                obtain.writeInt(1);
                b1Var.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f277a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
