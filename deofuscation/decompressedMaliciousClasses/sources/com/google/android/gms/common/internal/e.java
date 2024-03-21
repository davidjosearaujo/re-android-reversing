package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class e {

    /* renamed from: a */
    private static final Object f254a = new Object();

    /* renamed from: b */
    private static e f255b;

    public static e c(Context context) {
        synchronized (f254a) {
            if (f255b == null) {
                f255b = new g(context.getApplicationContext());
            }
        }
        return f255b;
    }

    public final void a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        d(new f(str, str2), serviceConnection, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean b(f fVar, ServiceConnection serviceConnection, String str);

    protected abstract void d(f fVar, ServiceConnection serviceConnection, String str);
}
