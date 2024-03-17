package com.huawei.android.hms.pps.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import java.util.concurrent.LinkedBlockingQueue;

@Keep
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class a implements ServiceConnection {
    @Keep
    public boolean a = false;
    @Keep
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    @Keep
    public final native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Override // android.content.ServiceConnection
    @Keep
    public final native void onServiceDisconnected(ComponentName componentName);
}
