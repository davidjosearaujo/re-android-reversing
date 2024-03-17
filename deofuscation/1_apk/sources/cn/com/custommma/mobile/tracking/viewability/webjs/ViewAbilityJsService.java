package cn.com.custommma.mobile.tracking.viewability.webjs;

import android.content.Context;
import android.view.View;
import cn.com.custommma.mobile.tracking.bean.Company;
import cn.com.custommma.mobile.tracking.util.Logger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbilityJsService {
    private static final int monitorInterval = 200;
    private boolean isTaskStarted;
    private Context mContext;
    private ScheduledExecutorService scheduledExecutorService;
    private HashMap<String, ViewAbilityJsExplorer> viewabilityWorkers = new HashMap<>();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public final class MonitorTask extends TimerTask {
        private MonitorTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                for (String str : ViewAbilityJsService.this.viewabilityWorkers.keySet()) {
                    ((ViewAbilityJsExplorer) ViewAbilityJsService.this.viewabilityWorkers.get(str)).onExplore();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ViewAbilityJsService(Context context) {
        this.scheduledExecutorService = null;
        this.isTaskStarted = false;
        this.mContext = context;
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        DataCacheManager.getInstance(this.mContext).clearnExpiredData();
        this.isTaskStarted = false;
    }

    public void addTrack(String str, View view, Company company, boolean z) {
        synchronized (ViewAbilityJsService.class) {
            if (!this.isTaskStarted) {
                this.scheduledExecutorService.scheduleWithFixedDelay(new MonitorTask(), 0L, 200L, TimeUnit.MILLISECONDS);
                this.isTaskStarted = true;
            }
            View view2 = view != null ? (View) new WeakReference(view).get() : null;
            if (view2 == null) {
                Logger.w("the adView is null.");
            }
            ViewAbilityJsExplorer viewAbilityJsExplorer = this.viewabilityWorkers.get(company.name);
            if (viewAbilityJsExplorer == null) {
                viewAbilityJsExplorer = new ViewAbilityJsExplorer(this.mContext, company);
                this.viewabilityWorkers.put(company.name, viewAbilityJsExplorer);
            }
            viewAbilityJsExplorer.addExplorerTask(str, view2, z);
        }
    }
}
