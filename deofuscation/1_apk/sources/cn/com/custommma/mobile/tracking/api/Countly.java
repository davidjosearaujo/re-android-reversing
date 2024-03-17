package cn.com.custommma.mobile.tracking.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import cn.com.custommma.mobile.tracking.bean.Company;
import cn.com.custommma.mobile.tracking.bean.SDK;
import cn.com.custommma.mobile.tracking.bean.Switch;
import cn.com.custommma.mobile.tracking.util.DeviceInfoUtil;
import cn.com.custommma.mobile.tracking.util.LocationCollector;
import cn.com.custommma.mobile.tracking.util.Logger;
import cn.com.custommma.mobile.tracking.util.SdkConfigUpdateUtil;
import cn.com.custommma.mobile.tracking.util.SharedPreferencedUtil;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityEventListener;
import j.b0.a.a.a;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class Countly {
    public static String ACTION_STATS_EXPOSE = "ACTION_STATS_EXPOSE";
    public static String ACTION_STATS_SUCCESSED = "ACTION.STATS_SUCCESSED";
    public static String ACTION_STATS_VIEWABILITY = "ACTION.STATS_VIEWABILITY";
    private static final String EVENT_CLICK = "onClick";
    private static final String EVENT_EXPOSE = "onExpose";
    private static final String EVENT_VIEWABILITY_EXPOSE = "onAdViewExpose";
    private static final String EVENT_VIEWABILITY_VIDEOEXPOSE = "onVideoExpose";
    public static boolean ISNEED_OAID = false;
    public static boolean LOCAL_TEST = true;
    public static String OAID = "unknow";
    private static Countly mInstance;
    private Context mContext;
    private RecordEventMessage mUrildBuilder;
    private SendMessageThread sendNormalMessageThread = null;
    private SendMessageThread sendFailedMessageThread = null;
    private Timer normalTimer = null;
    private Timer failedTimer = null;
    private ViewAbilityHandler viewAbilityHandler = null;
    private volatile boolean sIsInitialized = false;
    private boolean isTrackLocation = false;
    public ServiceConnection serviceConnection = new ServiceConnection() { // from class: cn.com.custommma.mobile.tracking.api.Countly.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a m = a.b.m(iBinder);
            try {
                Countly.OAID = m.l();
                m.f();
                Countly.ISNEED_OAID = true;
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private ViewAbilityEventListener viewAbilityEventListener = new ViewAbilityEventListener() { // from class: cn.com.custommma.mobile.tracking.api.Countly.4
        @Override // cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityEventListener
        public void onEventPresent(String str) {
            if (!Countly.this.sIsInitialized || Countly.this.mUrildBuilder == null) {
                return;
            }
            Countly.this.mUrildBuilder.recordEvent(str);
        }
    };

    private boolean isTrackLocation(SDK sdk) {
        if (sdk != null) {
            try {
                List<Company> list = sdk.companies;
                if (list != null) {
                    for (Company company : list) {
                        Switch r0 = company.sswitch;
                        if (r0 != null && r0.isTrackLocation) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static Countly sharedInstance() {
        if (mInstance == null) {
            synchronized (Countly.class) {
                if (mInstance == null) {
                    mInstance = new Countly();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFailedRun() {
        SharedPreferences sharedPreferences;
        try {
            SendMessageThread sendMessageThread = this.sendFailedMessageThread;
            if ((sendMessageThread == null || !sendMessageThread.isAlive()) && (sharedPreferences = SharedPreferencedUtil.getSharedPreferences(this.mContext, SharedPreferencedUtil.SP_NAME_FAILED)) != null && !sharedPreferences.getAll().isEmpty()) {
                SendMessageThread sendMessageThread2 = new SendMessageThread(SharedPreferencedUtil.SP_NAME_FAILED, this.mContext, false);
                this.sendFailedMessageThread = sendMessageThread2;
                sendMessageThread2.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNormalRun() {
        SharedPreferences sharedPreferences;
        try {
            SendMessageThread sendMessageThread = this.sendNormalMessageThread;
            if ((sendMessageThread == null || !sendMessageThread.isAlive()) && (sharedPreferences = SharedPreferencedUtil.getSharedPreferences(this.mContext, SharedPreferencedUtil.SP_NAME_NORMAL)) != null && !sharedPreferences.getAll().isEmpty()) {
                SendMessageThread sendMessageThread2 = new SendMessageThread(SharedPreferencedUtil.SP_NAME_NORMAL, this.mContext, true);
                this.sendNormalMessageThread = sendMessageThread2;
                sendMessageThread2.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startTask() {
        try {
            this.normalTimer.schedule(new TimerTask() { // from class: cn.com.custommma.mobile.tracking.api.Countly.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Countly.this.startNormalRun();
                }
            }, 0L, Constant.ONLINECACHE_QUEUEEXPIRATIONSECS * 1000);
            this.failedTimer.schedule(new TimerTask() { // from class: cn.com.custommma.mobile.tracking.api.Countly.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Countly.this.startFailedRun();
                }
            }, 0L, Constant.OFFLINECACHE_QUEUEEXPIRATIONSECS * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void triggerEvent(String str, String str2, View view, int i) {
        triggerEvent(str, str2, view, 0, i);
    }

    public String getOAID(Context context) {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        context.bindService(intent, this.serviceConnection, 1);
        return OAID;
    }

    public void init(Context context, String str) {
        if (context == null) {
            Logger.e("Countly.init(...) failed:Context can`t be null");
            return;
        }
        Logger.d("Countly init 11111111111: sIsInitialized = " + this.sIsInitialized);
        if (this.sIsInitialized) {
            return;
        }
        this.sIsInitialized = true;
        this.mContext = context.getApplicationContext();
        this.normalTimer = new Timer();
        this.failedTimer = new Timer();
        this.mUrildBuilder = RecordEventMessage.getInstance(context);
        try {
            SDK sDKConfig = SdkConfigUpdateUtil.getSDKConfig(context);
            this.viewAbilityHandler = new ViewAbilityHandler(this.mContext, this.viewAbilityEventListener, sDKConfig);
            if (isTrackLocation(sDKConfig)) {
                this.isTrackLocation = true;
                LocationCollector.getInstance(this.mContext).syncLocation();
            }
            Logger.d("Countly init 11111111111:");
            SdkConfigUpdateUtil.sync(context, str);
            DeviceInfoUtil.getDeviceAdid(context, sDKConfig);
            if (DeviceInfoUtil.getModel().contains("HONOR")) {
                getOAID(context);
            }
        } catch (Exception e) {
            Logger.e("Countly init failed:" + e.getMessage());
        }
        startTask();
    }

    public void onClick(String str) {
        triggerEvent(EVENT_CLICK, str, null, 0);
    }

    public void onExpose(String str) {
        triggerEvent(EVENT_EXPOSE, str, null, 1);
    }

    public void onJSExpose(String str, View view) {
        this.viewAbilityHandler.onJSExpose(str, view, false);
    }

    public void onJSVideoExpose(String str, View view) {
        this.viewAbilityHandler.onJSExpose(str, view, true);
    }

    public void onVideoExpose(String str, View view, int i) {
        triggerEvent(EVENT_VIEWABILITY_VIDEOEXPOSE, str, view, i);
    }

    public void setLogState(boolean z) {
        Logger.DEBUG_LOG = z;
    }

    public void stop(String str) {
        ViewAbilityHandler viewAbilityHandler;
        if (this.sIsInitialized && (viewAbilityHandler = this.viewAbilityHandler) != null) {
            viewAbilityHandler.stop(str);
        } else {
            Logger.e("The method stop(...) should not be called before calling Countly.init(...)");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r4.viewAbilityHandler != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r4.viewAbilityHandler == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        r4.viewAbilityHandler = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
        r4.sIsInitialized = false;
        cn.com.custommma.mobile.tracking.api.Countly.mInstance = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void terminateSDK() {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.util.Timer r2 = r4.normalTimer     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            if (r2 == 0) goto Le
            r2.cancel()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.util.Timer r2 = r4.normalTimer     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r2.purge()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
        Le:
            java.util.Timer r2 = r4.failedTimer     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            if (r2 == 0) goto L1a
            r2.cancel()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            java.util.Timer r2 = r4.failedTimer     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r2.purge()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
        L1a:
            boolean r2 = r4.isTrackLocation     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            if (r2 == 0) goto L27
            android.content.Context r2 = r4.mContext     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            cn.com.custommma.mobile.tracking.util.LocationCollector r2 = cn.com.custommma.mobile.tracking.util.LocationCollector.getInstance(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
            r2.stopSyncLocation()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38
        L27:
            r4.normalTimer = r1
            r4.failedTimer = r1
            r4.sendNormalMessageThread = r1
            r4.sendFailedMessageThread = r1
            r4.mUrildBuilder = r1
            cn.com.custommma.mobile.tracking.api.ViewAbilityHandler r2 = r4.viewAbilityHandler
            if (r2 == 0) goto L4c
            goto L4a
        L36:
            r2 = move-exception
            goto L51
        L38:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L36
            r4.normalTimer = r1
            r4.failedTimer = r1
            r4.sendNormalMessageThread = r1
            r4.sendFailedMessageThread = r1
            r4.mUrildBuilder = r1
            cn.com.custommma.mobile.tracking.api.ViewAbilityHandler r2 = r4.viewAbilityHandler
            if (r2 == 0) goto L4c
        L4a:
            r4.viewAbilityHandler = r1
        L4c:
            r4.sIsInitialized = r0
            cn.com.custommma.mobile.tracking.api.Countly.mInstance = r1
            return
        L51:
            r4.normalTimer = r1
            r4.failedTimer = r1
            r4.sendNormalMessageThread = r1
            r4.sendFailedMessageThread = r1
            r4.mUrildBuilder = r1
            cn.com.custommma.mobile.tracking.api.ViewAbilityHandler r3 = r4.viewAbilityHandler
            if (r3 == 0) goto L61
            r4.viewAbilityHandler = r1
        L61:
            r4.sIsInitialized = r0
            cn.com.custommma.mobile.tracking.api.Countly.mInstance = r1
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.api.Countly.terminateSDK():void");
    }

    private void triggerEvent(String str, String str2, View view, int i, int i2) {
        if (this.sIsInitialized && this.mUrildBuilder != null) {
            if (TextUtils.isEmpty(str2)) {
                Logger.w("The URL parameter is illegal, it can't be null or empty!");
                return;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1351902487:
                    if (str.equals(EVENT_CLICK)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1109256835:
                    if (str.equals(EVENT_EXPOSE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1124865216:
                    if (str.equals(EVENT_VIEWABILITY_VIDEOEXPOSE)) {
                        c = 2;
                        break;
                    }
                    break;
                case 2031079115:
                    if (str.equals(EVENT_VIEWABILITY_EXPOSE)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.viewAbilityHandler.onClick(str2);
                    return;
                case 1:
                    this.viewAbilityHandler.onExpose(str2, view, i2);
                    return;
                case 2:
                    this.viewAbilityHandler.onVideoExpose(str2, view, i);
                    return;
                case 3:
                    this.viewAbilityHandler.onExpose(str2, view);
                    return;
                default:
                    return;
            }
        }
        Logger.e("The method " + str + "(...) should be called before calling Countly.init(...)");
    }

    public void onExpose(String str, View view) {
        triggerEvent(EVENT_VIEWABILITY_EXPOSE, str, view, 0);
    }
}
