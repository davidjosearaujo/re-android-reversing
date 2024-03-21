package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class s0 implements ServiceConnection {
    private static short[] $ = {-22731, -22727, -22725, -22664, -22735, -22727, -22727, -22735, -22726, -22733, -22664, -22729, -22728, -22734, -22748, -22727, -22721, -22734, -22664, -22735, -22725, -22747, -22664, -22731, -22727, -22725, -22725, -22727, -22728, -22664, -22721, -22728, -22750, -22733, -22748, -22728, -22729, -22726, -22664, -22753, -22767, -22725, -22747, -22779, -22733, -22748, -22752, -22721, -22731, -22733, -22764, -22748, -22727, -22723, -22733, -22748};

    /* renamed from: a  reason: collision with root package name */
    private final int f275a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ k0 f276b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public s0(k0 k0Var, int i) {
        this.f276b = k0Var;
        this.f275a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        r rVar;
        k0 k0Var = this.f276b;
        if (iBinder == null) {
            k0Var.C(16);
            return;
        }
        synchronized (k0Var.f) {
            k0 k0Var2 = this.f276b;
            if (iBinder == null) {
                rVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface($(0, 56, -22698));
                rVar = (queryLocalInterface == null || !(queryLocalInterface instanceof r)) ? new t(iBinder) : (r) queryLocalInterface;
            }
            k0Var2.g = rVar;
        }
        this.f276b.t(0, null, this.f275a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f276b.f) {
            this.f276b.g = null;
        }
        Handler handler = this.f276b.d;
        handler.sendMessage(handler.obtainMessage(6, this.f275a, 1));
    }
}
