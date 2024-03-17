package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import cn.jiguang.ak.a;
import cn.jiguang.ap.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DaemonService extends Service {
    private static final String TAG = "DaemonService";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class MyBinder extends Binder {
        public MyBinder() {
        }

        public DaemonService getService() {
            return DaemonService.this;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        e.a(getApplicationContext(), intent != null ? intent.getExtras() : null, 2);
        return new MyBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a.a(TAG, "action onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        a.a(TAG, "action onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        e.a(getApplicationContext(), intent != null ? intent.getExtras() : null, 1);
        return super.onStartCommand(intent, i, i2);
    }
}
