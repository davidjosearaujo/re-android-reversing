package cn.com.custommma.mobile.tracking.viewability.origin.sniffer;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import cn.com.custommma.mobile.tracking.api.Countly;
import cn.com.custommma.mobile.tracking.util.klog.KLog;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityEventListener;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AbilityWorker implements AbilityCallback {
    private static final int CACHEINDEX_AMOUNT = 10;
    private ViewAbilityConfig config;
    private HashMap<String, ViewAbilityExplorer> explorers;
    private long inspectIntervial;
    private StoreManager mCacheManager;
    private Context mContext;
    private ViewAbilityEventListener mmaSdk;
    private ScheduledFuture<?> scheduledFuture = null;
    private int cacheIndex = 0;
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public final class WorkTask extends TimerTask {
        private WorkTask() {
        }

        private void cacheWorks() {
            try {
                for (String str : AbilityWorker.this.explorers.keySet()) {
                    AbilityWorker.this.mCacheManager.setObject(str, (ViewAbilityExplorer) AbilityWorker.this.explorers.get(str));
                }
                AbilityWorker.this.cacheIndex = 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int size = AbilityWorker.this.explorers.size();
                if (size == 0) {
                    return;
                }
                ArrayList<String> arrayList = new ArrayList();
                KLog.v("<-----------------------------Time Line Begin [" + Thread.currentThread().getId() + "]--------------------------------------------------->");
                for (String str : AbilityWorker.this.explorers.keySet()) {
                    ViewAbilityExplorer viewAbilityExplorer = (ViewAbilityExplorer) AbilityWorker.this.explorers.get(str);
                    AbilityStatus abilityStatus = viewAbilityExplorer.getAbilityStatus();
                    if (abilityStatus == AbilityStatus.UPLOADED) {
                        arrayList.add(str);
                    } else if (abilityStatus == AbilityStatus.EXPLORERING) {
                        viewAbilityExplorer.onExplore(AbilityWorker.this.mContext);
                    }
                }
                for (String str2 : arrayList) {
                    AbilityWorker.this.explorers.remove(str2);
                }
                if (AbilityWorker.this.cacheIndex > 10) {
                    cacheWorks();
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                AbilityWorker.access$408(AbilityWorker.this);
                KLog.d("index:" + AbilityWorker.this.cacheIndex + " cost:" + currentTimeMillis2 + "ms, workExplorers length:" + size);
                StringBuilder sb = new StringBuilder();
                sb.append("<-----------------------------Time Line end [");
                sb.append(Thread.currentThread().getId());
                sb.append("]--------------------------------------------------->");
                KLog.v(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public AbilityWorker(Context context, ViewAbilityEventListener viewAbilityEventListener, ViewAbilityConfig viewAbilityConfig) {
        this.mContext = context;
        this.config = viewAbilityConfig;
        this.mmaSdk = viewAbilityEventListener;
        this.inspectIntervial = viewAbilityConfig.getInspectInterval();
        KLog.w("********************************************");
        KLog.i("AbilityWorker Constructor on Thread:[" + Thread.currentThread().getId() + "]");
        StringBuilder sb = new StringBuilder();
        sb.append("inspect interival:");
        sb.append(this.inspectIntervial);
        KLog.i(sb.toString());
        KLog.i("exposeValidDuration:" + viewAbilityConfig.getExposeValidDuration());
        KLog.i("MaxDuration:" + viewAbilityConfig.getMaxDuration());
        KLog.i("coverRate scale:" + viewAbilityConfig.getCoverRateScale());
        KLog.i("MaxUploadAmount:" + viewAbilityConfig.getMaxUploadAmount());
        KLog.w("********************************************");
        this.explorers = new HashMap<>();
        this.mCacheManager = new StoreManager(context);
        activeWorkflow();
        loadAndUploadCachedWorks();
    }

    public static /* synthetic */ int access$408(AbilityWorker abilityWorker) {
        int i = abilityWorker.cacheIndex;
        abilityWorker.cacheIndex = i + 1;
        return i;
    }

    private void activeWorkflow() {
        try {
            this.scheduledFuture = this.scheduledExecutorService.scheduleWithFixedDelay(new WorkTask(), 0L, this.inspectIntervial, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAndUploadCachedWorks() {
        try {
            List<ViewAbilityExplorer> all = this.mCacheManager.getAll();
            if (all != null) {
                for (ViewAbilityExplorer viewAbilityExplorer : all) {
                    KLog.i("load cache explore item:" + viewAbilityExplorer.toString());
                    viewAbilityExplorer.breakToUpload(this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addWorker(String str, View view, String str2, String str3, ViewAbilityStats viewAbilityStats) {
        try {
            ViewAbilityExplorer viewAbilityExplorer = this.explorers.get(str3);
            KLog.d("addWorker->ID:" + str3 + " existExplore:" + viewAbilityExplorer + "  url:" + str + "  adView" + view);
            if (viewAbilityExplorer != null) {
                KLog.w("当前广告位:" + str3 + " 已经存在,停止监测并UPLOAD,当前任务重新开启!");
                viewAbilityExplorer.breakToUpload();
                this.explorers.remove(str3);
            }
            ViewAbilityExplorer viewAbilityExplorer2 = new ViewAbilityExplorer(str3, str, view, str2, this.config, viewAbilityStats);
            viewAbilityExplorer2.setAbilityCallback(this);
            this.explorers.put(str3, viewAbilityExplorer2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityCallback
    public void onFinished(String str) {
        this.mCacheManager.removeObject(str);
    }

    @Override // cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityCallback
    public void onSend(final String str) {
        new Thread(new Runnable() { // from class: cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityWorker.1
            @Override // java.lang.Runnable
            public void run() {
                AbilityWorker.this.mmaSdk.onEventPresent(str);
                KLog.v(",ID:" + str + "监测完成,移除对应的数据");
                if (Countly.LOCAL_TEST) {
                    AbilityWorker.this.mContext.sendBroadcast(new Intent(Countly.ACTION_STATS_VIEWABILITY));
                }
            }
        }).start();
    }

    public void stopWorker(String str) {
        ViewAbilityExplorer viewAbilityExplorer = this.explorers.get(str);
        KLog.d("stopWorker->ID:" + str + " existExplore:" + viewAbilityExplorer);
        if (viewAbilityExplorer != null) {
            KLog.w("当前广告位:" + str + " 存在,停止监测并UPLOAD!");
            viewAbilityExplorer.stop();
            this.explorers.remove(str);
        }
    }

    public void stopWorkerForStrongInteract(String str) {
        ViewAbilityExplorer viewAbilityExplorer = this.explorers.get(str);
        KLog.d("stopWorker->ID:" + str + " existExplore:" + viewAbilityExplorer);
        if (viewAbilityExplorer != null) {
            KLog.w("当前广告位:" + str + " 存在,产生强交互行为，满足可视，停止监测并UPLOAD!");
            viewAbilityExplorer.setStrongInteract(true);
            try {
                viewAbilityExplorer.breakToUpload();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
