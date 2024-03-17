package cn.com.custommma.mobile.tracking.viewability.origin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import cn.com.custommma.mobile.tracking.util.klog.KLog;
import cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityEngine;
import cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewAbilityConfig;
import java.lang.ref.WeakReference;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbilityService {
    public static final String BUNDLE_ADURL = "adurl";
    public static final String BUNDLE_EXPLORERID = "explorerID";
    public static final String BUNDLE_IMPRESSIONID = "impressionId";
    public static final String BUNDLE_VBRESULT = "vbresult";
    public static boolean LOCAL_DEBUG = false;
    public static final String LOCAL_TAG = "ViewAbilityService";
    private static int LOG_SWITCH;
    private ViewAbilityPresenter presenter;

    public ViewAbilityService(Context context, ViewAbilityEventListener viewAbilityEventListener, ViewAbilityConfig viewAbilityConfig) {
        this.presenter = null;
        KLog.init(LOCAL_DEBUG, LOCAL_TAG);
        this.presenter = new AbilityEngine(context, viewAbilityEventListener, viewAbilityConfig);
    }

    public void addViewAbilityMonitor(String str, View view, String str2, String str3, ViewAbilityStats viewAbilityStats) {
        View view2 = (View) new WeakReference(view).get();
        if (view2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString(BUNDLE_ADURL, str);
            bundle.putString(BUNDLE_IMPRESSIONID, str2);
            bundle.putString(BUNDLE_EXPLORERID, str3);
            bundle.putSerializable(BUNDLE_VBRESULT, viewAbilityStats);
            this.presenter.addViewAbilityMonitor(bundle, view2);
        }
    }

    public void stopForStrongInteract(String str) {
        this.presenter.stopForStrongInteract(str);
    }

    public void stopViewAbilityMonitor(String str) {
        this.presenter.stopViewAbilityMonitor(str);
    }
}
