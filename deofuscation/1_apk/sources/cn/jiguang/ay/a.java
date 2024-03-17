package cn.jiguang.ay;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;

@TargetApi(21)
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends ConnectivityManager.NetworkCallback {
    private static volatile a b;
    private NetworkRequest a;

    private a() {
        try {
            this.a = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("ConnectionStateMonitor", "init network request error, " + th.getMessage());
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public void a(Context context) {
        if (context == null || this.a == null) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(this.a, this);
                cn.jiguang.ar.c.c("ConnectionStateMonitor", "start network listen...");
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("ConnectionStateMonitor", "enable connectivity error, " + th.getMessage());
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        String str = "";
        if (network != null) {
            try {
                str = network.toString();
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("ConnectionStateMonitor", "[onAvailable] error, " + th.getMessage());
                return;
            }
        }
        cn.jiguang.ar.c.c("ConnectionStateMonitor", "[onAvailable] network is connected, netId: " + str);
        Context appContext = JConstants.getAppContext(null);
        if (appContext == null) {
            cn.jiguang.ar.c.c("ConnectionStateMonitor", "[onAvailable] context is null, can not handle network change event");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("connected", true);
        JCoreManager.onEvent(appContext, "", 80, null, bundle, new Object[0]);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        String str = "";
        if (network != null) {
            try {
                str = network.toString();
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("ConnectionStateMonitor", "[onLost] error, " + th.getMessage());
                return;
            }
        }
        cn.jiguang.ar.c.h("ConnectionStateMonitor", "[onLost] network is disconnected, netId: " + str);
        Context appContext = JConstants.getAppContext(null);
        if (appContext == null) {
            cn.jiguang.ar.c.c("ConnectionStateMonitor", "[onLost] context is null, can not handle network change event");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("connected", false);
        JCoreManager.onEvent(appContext, "", 80, null, bundle, new Object[0]);
    }
}
