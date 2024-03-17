package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PushService extends Service {
    private static final String TAG = "PushService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
