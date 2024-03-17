package wfu.tjudfot.tetdyxomh.vrqdh;

import android.content.res.AssetManager;
import java.lang.reflect.Method;

/* compiled from: AssetOverrideManager.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class wyfqsyeuxsjfsxwpltif {
    private static wyfqsyeuxsjfsxwpltif edrrlnfry;
    private AssetManager hsoejmprquqdtkpgwl;

    private wyfqsyeuxsjfsxwpltif() {
        try {
            this.hsoejmprquqdtkpgwl = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void kivrflkqjwpdouen(AssetManager mgr, String packageResourcePath) {
        try {
            Method method = AssetManager.class.getMethod("addAssetPath", String.class);
            method.invoke(mgr, packageResourcePath);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static wyfqsyeuxsjfsxwpltif mtudyenyoei() {
        wyfqsyeuxsjfsxwpltif wyfqsyeuxsjfsxwpltifVar = edrrlnfry;
        if (wyfqsyeuxsjfsxwpltifVar == null) {
            wyfqsyeuxsjfsxwpltif wyfqsyeuxsjfsxwpltifVar2 = new wyfqsyeuxsjfsxwpltif();
            edrrlnfry = wyfqsyeuxsjfsxwpltifVar2;
            return wyfqsyeuxsjfsxwpltifVar2;
        }
        return wyfqsyeuxsjfsxwpltifVar;
    }

    public static void newInstance() {
        edrrlnfry = new wyfqsyeuxsjfsxwpltif();
    }

    public void kivrflkqjwpdouen(String packageResourcePath) {
        try {
            Method method = AssetManager.class.getMethod("addAssetPath", String.class);
            method.invoke(this.hsoejmprquqdtkpgwl, packageResourcePath);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public AssetManager getAssetManager() {
        return this.hsoejmprquqdtkpgwl;
    }
}
