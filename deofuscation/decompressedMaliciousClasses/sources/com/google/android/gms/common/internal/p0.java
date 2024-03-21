package com.google.android.gms.common.internal;

import android.util.Log;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class p0<TListener> {
    private static short[] $ = {6693, 6671, 6673, 6689, 6670, 6667, 6663, 6668, 6678, 311, 277, 280, 280, 278, 277, 279, 287, 340, 260, 262, 283, 268, 269, 340, 5469, 5407, 5400, 5396, 5395, 5402, 5469, 5391, 5400, 5384, 5390, 5400, 5401, 5459, 5469, 5417, 5397, 5396, 5390, 5469, 5396, 5390, 5469, 5395, 5394, 5385, 5469, 5390, 5404, 5403, 5400, 5459};

    /* renamed from: a  reason: collision with root package name */
    private TListener f271a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f272b = false;
    private /* synthetic */ k0 c;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public p0(k0 k0Var, TListener tlistener) {
        this.c = k0Var;
        this.f271a = tlistener;
    }

    public final void a() {
        synchronized (this) {
            this.f271a = null;
        }
    }

    public final void b() {
        a();
        synchronized (this.c.j) {
            this.c.j.remove(this);
        }
    }

    public final void c() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.f271a;
            if (this.f272b) {
                String $2 = $(0, 9, 6754);
                String valueOf = String.valueOf(this);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append($(9, 24, 372));
                sb.append(valueOf);
                sb.append($(24, 56, 5501));
                Log.w($2, sb.toString());
            }
        }
        if (tlistener != null) {
            try {
                d(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.f272b = true;
        }
        b();
    }

    protected abstract void d(TListener tlistener);
}
