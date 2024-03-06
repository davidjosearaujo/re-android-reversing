package yuh.xvuijvy.kjmyuiiwm;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import fje.ymqnpel.dtdenfufv.pusey.edoyrufkrqodlup;
import juw.khdqwmf.xftkgphgq.fhyu.ChineseObfuscatedPackageNames;
import pls.hqmkfei.nxskrnoon.fwwsp.setContext;
import vie.dwhyiud.voxxndgyo.sooyh.ojomviuts;

/* compiled from: StubApp.java */
/* loaded from: /home/tiago/Downloads/PDF_Reader_File_Manager/other/1/classes.dex */
public class jwkyiuu extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        new setContext(base).nppijhnxmrmur();
        new ojomviuts(base).ylnvvxuduw();
        edoyrufkrqodlup.mfre(this, ChineseObfuscatedPackageNames.notkmygjwgpqutdlsejxp, ChineseObfuscatedPackageNames.wmvpsjylkomjunuemnomk);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        edoyrufkrqodlup.ejwddyukndniutjiyingwouyl(this, ChineseObfuscatedPackageNames.wmvpsjylkomjunuemnomk);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return edoyrufkrqodlup.gpimkfxrpndmtdxmkmeqye(this, ChineseObfuscatedPackageNames.wmvpsjylkomjunuemnomk);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return ChineseObfuscatedPackageNames.nvoyhpvsvfsr;
    }
}
