package pht.dgrrsrp.hgdtgssvw;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import juw.khdqwmf.xftkgphgq.fhyu.mapChineseStringToObject;

/* compiled from: CoreComponentFactory.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class heeutduthkyehpklhwox extends AppComponentFactory {
    private heeutduthkyehpklhwox mFactory;

    /* compiled from: CoreComponentFactory.java */
    /*
     * loaded from:
     * /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android
     * -reversing/deofuscation/1_apk/classes.dex
     */
    public interface CompatWrapped {
        Object getWrapper();
    }

    static <T> T checkCompatWrapper(T obj) {
        T wrapper;
        if ((obj instanceof CompatWrapped) && (wrapper = (T) ((CompatWrapped) obj).getWrapper()) != null) {
            return wrapper;
        }
        return obj;
    }

    private heeutduthkyehpklhwox getAppComponentFactory() {
        heeutduthkyehpklhwox appComponentFactory = this.mFactory;
        if (appComponentFactory != null) {
            return appComponentFactory;
        }
        String processName = Application.getProcessName();
        if (processName == null || (!processName.contains(":p706584458e5f9d1a8b5a2a45")
                && !processName.contains(":pae386831f66f8811aa550ff6"))) {
            try {
                this.mFactory = (heeutduthkyehpklhwox) Class.forName("pht.dgrrsrp.hgdtgssvw.heeutduthkyehpklhwox")
                        .newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                if (!Process.isIsolated()) {
                    Log.e("LoadedApk", "Unable to instantiate appComponentFactory", e);
                }
                this.mFactory = new heeutduthkyehpklhwox();
            }
        }
        Log.i("LoadedApk", "Fast path. Process name: " + processName);
        heeutduthkyehpklhwox appComponentFactory2 = new heeutduthkyehpklhwox();
        this.mFactory = appComponentFactory2;
        return appComponentFactory2;
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader cl, String className, Intent intent)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) checkCompatWrapper(super.instantiateActivity(cl, className, intent));
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader cl, String className)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) checkCompatWrapper(super.instantiateApplication(cl, className));
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader cl, String className, Intent intent)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) checkCompatWrapper(super.instantiateReceiver(cl, className, intent));
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader cl, String className)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) checkCompatWrapper(super.instantiateProvider(cl, className));
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader cl, String className, Intent intent)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service) checkCompatWrapper(super.instantiateService(cl, className, intent));
    }
}
