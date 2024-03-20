package fje.ymqnpel.dtdenfufv.pusey;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import eeu.wuekite.ptluwwjmt.ypxjt.ObjectHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* compiled from: ApplicationHook.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ObjectProxy {
    private static Application baseApplication;

    public static void initBuilder(Application application, String delegateApplicationName,
            String stubApplicationName) {
        if (TextUtils.isEmpty(delegateApplicationName) || stubApplicationName.equals(delegateApplicationName)) {
            baseApplication = application;
            return;
        }
        try {
            Context contextImpl = application.getBaseContext();
            ClassLoader classLoader = application.getClassLoader();
            Class<?> applicationClass = classLoader.loadClass(delegateApplicationName);
            Application application2 = (Application) applicationClass.newInstance();
            baseApplication = application2;
            ObjectHandler.methodCaller(Application.class, application2, new Object[] { contextImpl }, "attach",
                    Context.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void threadActiviySwap(Application application, String stubApplicationName) {
        Application application2 = baseApplication;
        if (application2 == null || stubApplicationName.equals(application2.getClass().getName())) {
            return;
        }
        try {
            Context contextImpl = application.getBaseContext();
            ObjectHandler.methodCaller(contextImpl.getClass(), contextImpl, new Object[] { baseApplication },
                    "setOuterContext", Context.class);
            Object mMainThread = ObjectHandler.attributeGetter(contextImpl.getClass(), contextImpl, "mMainThread");
            ObjectHandler.attributeSetter("android.app.ActivityThread", mMainThread, "mInitialApplication",
                    baseApplication);
            ArrayList<Application> mAllApplications = (ArrayList) ObjectHandler.classAttributeGetter(
                    "android.app.ActivityThread",
                    mMainThread, "mAllApplications");
            mAllApplications.add(baseApplication);
            mAllApplications.remove(application);
            Object loadedApk = ObjectHandler.attributeGetter(contextImpl.getClass(), contextImpl, "mPackageInfo");
            ObjectHandler.attributeSetter("android.app.LoadedApk", loadedApk, "mApplication", baseApplication);
            ApplicationInfo applicationInfo = (ApplicationInfo) ObjectHandler.classAttributeGetter(
                    "android.app.LoadedApk",
                    loadedApk, "mApplicationInfo");
            applicationInfo.className = baseApplication.getClass().getName();
            baseApplication.onCreate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Application setContentProvider(Application application, String stubApplicationName) {
        Application application2 = baseApplication;
        if (application2 == null || stubApplicationName.equals(application2.getClass().getName())) {
            return application;
        }
        try {
            Context contextImpl = application.getBaseContext();
            Object loadedApk = ObjectHandler.attributeGetter(contextImpl.getClass(), contextImpl, "mPackageInfo");
            ObjectHandler.attributeSetter("android.app.LoadedApk", loadedApk, "mApplication", baseApplication);
            Object activityThread = getCurrentActivityThread();
            Map<Object, Object> mProviderMap = (Map) ObjectHandler.attributeGetter(activityThread.getClass(),
                    activityThread,
                    "mProviderMap");
            Set<Map.Entry<Object, Object>> entrySet = mProviderMap.entrySet();
            for (Map.Entry<Object, Object> entry : entrySet) {
                ContentProvider contentProvider = (ContentProvider) ObjectHandler.attributeGetter(
                        entry.getValue().getClass(),
                        entry.getValue(), "mLocalProvider");
                if (contentProvider != null) {
                    ObjectHandler.attributeSetter("android.content.ContentProvider", contentProvider, "fnjkjldn",
                            baseApplication);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseApplication;
    }

    private static Object getCurrentActivityThread() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
