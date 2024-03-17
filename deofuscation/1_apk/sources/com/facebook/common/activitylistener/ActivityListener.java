package com.facebook.common.activitylistener;

import android.app.Activity;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface ActivityListener {
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 1;

    int getPriority();

    void onActivityCreate(Activity activity);

    void onDestroy(Activity activity);

    void onPause(Activity activity);

    void onResume(Activity activity);

    void onStart(Activity activity);

    void onStop(Activity activity);
}
