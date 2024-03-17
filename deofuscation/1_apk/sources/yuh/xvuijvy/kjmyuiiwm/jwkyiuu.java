package yuh.xvuijvy.kjmyuiiwm;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import fje.ymqnpel.dtdenfufv.pusey.edoyrufkrqodlup;
import juw.khdqwmf.xftkgphgq.fhyu.mapChineseStringToObject;
import pls.hqmkfei.nxskrnoon.fwwsp.ContextWrapper;
import vie.dwhyiud.voxxndgyo.sooyh.DexLoader;

/* compiled from: StubApp.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class jwkyiuu extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        new ContextWrapper(base).nppijhnxmrmur();
        new DexLoader(base).ylnvvxuduw();
        edoyrufkrqodlup.mfre(this, mapChineseStringToObject.empty, "yuh.xvuijvy.kjmyuiiwm.jwkyiuu");
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        edoyrufkrqodlup.ejwddyukndniutjiyingwouyl(this, "yuh.xvuijvy.kjmyuiiwm.jwkyiuu");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return edoyrufkrqodlup.gpimkfxrpndmtdxmkmeqye(this, "yuh.xvuijvy.kjmyuiiwm.jwkyiuu");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return "com.zjxyxnvvp.nxvxchltf";
    }
}
