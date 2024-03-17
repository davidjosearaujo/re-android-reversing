package cn.com.custommma.mobile.tracking.viewability.origin;

import android.os.Bundle;
import android.view.View;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface ViewAbilityPresenter {
    void addViewAbilityMonitor(Bundle bundle, View view);

    void stopForStrongInteract(String str);

    void stopViewAbilityMonitor(String str);
}
