package cn.com.custommma.mobile.tracking.viewability.origin.sniffer;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import cn.com.custommma.mobile.tracking.util.klog.KLog;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityEventListener;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityPresenter;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityService;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AbilityEngine implements ViewAbilityPresenter {
    private static final int MESSAGE_ONEXPOSE = 258;
    private static final int MESSAGE_ONSTOP = 259;
    private static final int MESSAGE_STOPFORSTRONGINTERACT = 260;
    private AbilityHandler engineHandler;
    private Context mContext;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class AbilityHandler extends Handler {
        private AbilityWorker abilityWorker;
        private final Lock mStartLock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AbilityHandler(Looper looper, ViewAbilityConfig viewAbilityConfig, ViewAbilityEventListener viewAbilityEventListener) {
            super(looper);
            AbilityEngine.this = r1;
            this.mStartLock = new ReentrantLock();
            this.abilityWorker = new AbilityWorker(r1.mContext, viewAbilityEventListener, viewAbilityConfig);
        }

        private void handlerViewAbilityMonitor(View view, Bundle bundle) {
            if (view == null) {
                KLog.w("adView 已经被释放...");
                return;
            }
            this.abilityWorker.addWorker(bundle.getString(ViewAbilityService.BUNDLE_ADURL), view, bundle.getString(ViewAbilityService.BUNDLE_IMPRESSIONID), bundle.getString(ViewAbilityService.BUNDLE_EXPLORERID), (ViewAbilityStats) bundle.getSerializable(ViewAbilityService.BUNDLE_VBRESULT));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mStartLock.lock();
            try {
                try {
                    switch (message.what) {
                        case AbilityEngine.MESSAGE_ONEXPOSE /* 258 */:
                            handlerViewAbilityMonitor((View) message.obj, message.getData());
                            break;
                        case AbilityEngine.MESSAGE_ONSTOP /* 259 */:
                            this.abilityWorker.stopWorker((String) message.obj);
                            break;
                        case AbilityEngine.MESSAGE_STOPFORSTRONGINTERACT /* 260 */:
                            this.abilityWorker.stopWorkerForStrongInteract((String) message.obj);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.mStartLock.unlock();
            }
        }
    }

    public AbilityEngine(Context context, ViewAbilityEventListener viewAbilityEventListener, ViewAbilityConfig viewAbilityConfig) {
        this.engineHandler = null;
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread(AbilityEngine.class.getCanonicalName());
        handlerThread.setPriority(10);
        handlerThread.start();
        this.engineHandler = new AbilityHandler(handlerThread.getLooper(), viewAbilityConfig, viewAbilityEventListener);
    }

    @Override // cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityPresenter
    public void addViewAbilityMonitor(Bundle bundle, View view) {
        Message obtainMessage = this.engineHandler.obtainMessage(MESSAGE_ONEXPOSE);
        obtainMessage.obj = view;
        obtainMessage.setData(bundle);
        this.engineHandler.sendMessage(obtainMessage);
    }

    @Override // cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityPresenter
    public void stopForStrongInteract(String str) {
        Message obtainMessage = this.engineHandler.obtainMessage(MESSAGE_STOPFORSTRONGINTERACT);
        obtainMessage.obj = str;
        this.engineHandler.sendMessage(obtainMessage);
    }

    @Override // cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityPresenter
    public void stopViewAbilityMonitor(String str) {
        Message obtainMessage = this.engineHandler.obtainMessage(MESSAGE_ONSTOP);
        obtainMessage.obj = str;
        this.engineHandler.sendMessage(obtainMessage);
    }
}
