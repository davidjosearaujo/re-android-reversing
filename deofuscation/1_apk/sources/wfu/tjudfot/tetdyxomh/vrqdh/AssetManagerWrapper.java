package wfu.tjudfot.tetdyxomh.vrqdh;

import android.content.res.AssetManager;
import java.lang.reflect.Method;

/* compiled from: AssetOverrideManager.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AssetManagerWrapper {
    private static AssetManagerWrapper builder;
    private AssetManager assetManager;

    private AssetManagerWrapper() {
        try {
            this.assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAssetPathToGivenAssetManager(AssetManager mgr, String packageResourcePath) {
        try {
            Method method = AssetManager.class.getMethod("addAssetPath", String.class);
            method.invoke(mgr, packageResourcePath);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static AssetManagerWrapper getAssetManagerBuilder() {
        AssetManagerWrapper AssetManagerBuilderVar = builder;
        if (AssetManagerBuilderVar == null) {
            AssetManagerWrapper AssetManagerBuilderVar2 = new AssetManagerWrapper();
            builder = AssetManagerBuilderVar2;
            return AssetManagerBuilderVar2;
        }
        return AssetManagerBuilderVar;
    }

    public static void newInstance() {
        builder = new AssetManagerWrapper();
    }

    public void setAssetPath(String packageResourcePath) {
        try {
            Method method = AssetManager.class.getMethod("addAssetPath", String.class);
            method.invoke(this.assetManager, packageResourcePath);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public AssetManager getAssetManager() {
        return this.assetManager;
    }
}
