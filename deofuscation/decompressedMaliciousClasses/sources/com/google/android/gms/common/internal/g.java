package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import b.a.a.a.c.f.a;
import java.util.HashMap;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class g extends e implements Handler.Callback {
    private static short[] $ = {4710, 4688, 4679, 4675, 4700, 4694, 4688, 4726, 4698, 4699, 4699, 4688, 4694, 4673, 4700, 4698, 4699, 4629, 4696, 4672, 4678, 4673, 4629, 4699, 4698, 4673, 4629, 4695, 4688, 4629, 4699, 4672, 4697, 4697, 8411, 8445, 8438, 8422, 8417, 8424, 8367, 8443, 8416, 8367, 8429, 8422, 8417, 8427, 8367, 8430, 8367, 8392, 8418, 8444, 8412, 8426, 8445, 8441, 8422, 8428, 8426, 8396, 8416, 8417, 8417, 8426, 8428, 8443, 8422, 8416, 8417, 8367, 8443, 8423, 8430, 8443, 8367, 8440, 8430, 8444, 8367, 8430, 8419, 8445, 8426, 8430, 8427, 8438, 8367, 8428, 8416, 8417, 8417, 8426, 8428, 8443, 8426, 8427, 8367, 8429, 8426, 8425, 8416, 8445, 8426, 8353, 8367, 8367, 8428, 8416, 8417, 8425, 8422, 8424, 8370, 2037, 1987, 2004, 2000, 1999, 1989, 1987, 2021, 1993, 1992, 1992, 1987, 1989, 2002, 1999, 1993, 1992, 1926, 1995, 2003, 2005, 2002, 1926, 1992, 1993, 2002, 1926, 1988, 1987, 1926, 1992, 2003, 1994, 1994, 4073, 4047, 4036, 4052, 4051, 4058, 3997, 4041, 4050, 3997, 4040, 4051, 4063, 4052, 4051, 4057, 3997, 4060, 3997, 4090, 4048, 4046, 4078, 4056, 4047, 4043, 4052, 4062, 4056, 4094, 4050, 4051, 4051, 4056, 4062, 4041, 4052, 4050, 4051, 3997, 3997, 4041, 4053, 4060, 4041, 3997, 4042, 4060, 4046, 3997, 4051, 4050, 4041, 3997, 4063, 4050, 4040, 4051, 4057, 3997, 4063, 4056, 4059, 4050, 4047, 4056, 3987, 3997, 3997, 4062, 4050, 4051, 4059, 4052, 4058, 3968, 8823, 8790, 8791, 8796, 8769, 8784, 8778, 8781, 8796, 8791, 8781, 8729, 8794, 8790, 8791, 8791, 8796, 8794, 8781, 8784, 8790, 8791, 8729, 8778, 8781, 8792, 8781, 8780, 8778, 8729, 8799, 8790, 8779, 8729, 8778, 8796, 8779, 8783, 8784, 8794, 8796, 8729, 8794, 8790, 8791, 8799, 8784, 8798, 8707, 8729, 25091, 25129, 25143, 25095, 25128, 25133, 25121, 25130, 25136, 25111, 25137, 25140, 25121, 25142, 25138, 25133, 25143, 25131, 25142, 30867, 30894, 30890, 30882, 30888, 30898, 30899, 30951, 30896, 30886, 30894, 30899, 30894, 30889, 30880, 30951, 30881, 30888, 30901, 30951, 30868, 30882, 30901, 30897, 30894, 30884, 30882, 30852, 30888, 30889, 30889, 30882, 30884, 30899, 30894, 30888, 30889, 30951, 30884, 30886, 30891, 30891, 30885, 30886, 30884, 30892, 30951, 31279, 31284, 31281, 31284, 31285, 31277, 31284, 31901, 31927, 31913, 31897, 31926, 31923, 31935, 31924, 31918, 31881, 31919, 31914, 31935, 31912, 31916, 31923, 31913, 31925, 31912};
    private final Context d;
    private final Handler e;
    private final HashMap<f, h> c = new HashMap<>();
    private final a f = a.b();
    private final long g = 5000;
    private final long h = 300000;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public g(Context context) {
        this.d = context.getApplicationContext();
        this.e = new Handler(context.getMainLooper(), this);
    }

    @Override // com.google.android.gms.common.internal.e
    public final boolean b(f fVar, ServiceConnection serviceConnection, String str) {
        boolean d;
        e0.e(serviceConnection, $(0, 34, 4661));
        synchronized (this.c) {
            h hVar = this.c.get(fVar);
            if (hVar == null) {
                hVar = new h(this, fVar);
                hVar.e(serviceConnection, str);
                hVar.h(str);
                this.c.put(fVar, hVar);
            } else {
                this.e.removeMessages(0, fVar);
                if (!hVar.f(serviceConnection)) {
                    hVar.e(serviceConnection, str);
                    int c = hVar.c();
                    if (c == 1) {
                        serviceConnection.onServiceConnected(hVar.b(), hVar.a());
                    } else if (c == 2) {
                        hVar.h(str);
                    }
                } else {
                    String valueOf = String.valueOf(fVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append($(34, 115, 8335));
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d = hVar.d();
        }
        return d;
    }

    @Override // com.google.android.gms.common.internal.e
    protected final void d(f fVar, ServiceConnection serviceConnection, String str) {
        e0.e(serviceConnection, $(115, 149, 1958));
        synchronized (this.c) {
            h hVar = this.c.get(fVar);
            if (hVar == null) {
                String valueOf = String.valueOf(fVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append($(225, 275, 8761));
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (hVar.f(serviceConnection)) {
                hVar.g(serviceConnection, str);
                if (hVar.j()) {
                    this.e.sendMessageDelayed(this.e.obtainMessage(0, fVar), this.g);
                }
            } else {
                String valueOf2 = String.valueOf(fVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append($(149, 225, 4029));
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.c) {
                f fVar = (f) message.obj;
                h hVar = this.c.get(fVar);
                if (hVar != null && hVar.j()) {
                    if (hVar.d()) {
                        hVar.i($(348, 367, 31962));
                    }
                    this.c.remove(fVar);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.c) {
                f fVar2 = (f) message.obj;
                h hVar2 = this.c.get(fVar2);
                if (hVar2 != null && hVar2.c() == 3) {
                    String $2 = $(275, 294, 25156);
                    String valueOf = String.valueOf(fVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append($(294, 341, 30919));
                    sb.append(valueOf);
                    Log.wtf($2, sb.toString(), new Exception());
                    ComponentName b2 = hVar2.b();
                    if (b2 == null) {
                        b2 = fVar2.a();
                    }
                    if (b2 == null) {
                        b2 = new ComponentName(fVar2.b(), $(341, 348, 31322));
                    }
                    hVar2.onServiceDisconnected(b2);
                }
            }
            return true;
        }
    }
}
