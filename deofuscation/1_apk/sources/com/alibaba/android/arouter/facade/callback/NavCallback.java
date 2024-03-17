package com.alibaba.android.arouter.facade.callback;

import com.alibaba.android.arouter.facade.Postcard;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class NavCallback implements NavigationCallback {
    @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
    public abstract void onArrival(Postcard postcard);

    @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
    public void onFound(Postcard postcard) {
    }

    @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
    public void onInterrupt(Postcard postcard) {
    }

    @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
    public void onLost(Postcard postcard) {
    }
}
