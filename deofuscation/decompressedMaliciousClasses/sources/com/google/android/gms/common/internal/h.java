package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import b.a.a.a.c.f.a;
import java.util.HashSet;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class h implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ServiceConnection> f260a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private int f261b = 2;
    private boolean c;
    private IBinder d;
    private final f e;
    private ComponentName f;
    private /* synthetic */ g g;

    public h(g gVar, f fVar) {
        this.g = gVar;
        this.e = fVar;
    }

    public final IBinder a() {
        return this.d;
    }

    public final ComponentName b() {
        return this.f;
    }

    public final int c() {
        return this.f261b;
    }

    public final boolean d() {
        return this.c;
    }

    public final void e(ServiceConnection serviceConnection, String str) {
        a unused = this.g.f;
        Context unused2 = this.g.d;
        this.e.c();
        this.f260a.add(serviceConnection);
    }

    public final boolean f(ServiceConnection serviceConnection) {
        return this.f260a.contains(serviceConnection);
    }

    public final void g(ServiceConnection serviceConnection, String str) {
        a unused = this.g.f;
        Context unused2 = this.g.d;
        this.f260a.remove(serviceConnection);
    }

    public final void h(String str) {
        this.f261b = 3;
        a unused = this.g.f;
        boolean a2 = a.a(this.g.d, str, this.e.c(), this, 129);
        this.c = a2;
        if (a2) {
            this.g.e.sendMessageDelayed(this.g.e.obtainMessage(1, this.e), this.g.h);
            return;
        }
        this.f261b = 2;
        try {
            a unused2 = this.g.f;
            this.g.d.unbindService(this);
        } catch (IllegalArgumentException unused3) {
        }
    }

    public final void i(String str) {
        this.g.e.removeMessages(1, this.e);
        a unused = this.g.f;
        this.g.d.unbindService(this);
        this.c = false;
        this.f261b = 2;
    }

    public final boolean j() {
        return this.f260a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.c) {
            this.g.e.removeMessages(1, this.e);
            this.d = iBinder;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.f260a) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f261b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.c) {
            this.g.e.removeMessages(1, this.e);
            this.d = null;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.f260a) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f261b = 2;
        }
    }
}
