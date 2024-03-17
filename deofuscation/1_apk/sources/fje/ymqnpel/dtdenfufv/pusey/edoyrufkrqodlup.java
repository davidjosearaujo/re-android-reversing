package fje.ymqnpel.dtdenfufv.pusey;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import eeu.wuekite.ptluwwjmt.ypxjt.wimupug;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* compiled from: ApplicationHook.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class edoyrufkrqodlup {
    private static Application mxqhfjkdxtmvjurgsnxr;

    public static void mfre(Application application, String delegateApplicationName, String stubApplicationName) {
        if (TextUtils.isEmpty(delegateApplicationName) || stubApplicationName.equals(delegateApplicationName)) {
            mxqhfjkdxtmvjurgsnxr = application;
            return;
        }
        try {
            Context contextImpl = application.getBaseContext();
            ClassLoader classLoader = application.getClassLoader();
            Class<?> applicationClass = classLoader.loadClass(delegateApplicationName);
            Application application2 = (Application) applicationClass.newInstance();
            mxqhfjkdxtmvjurgsnxr = application2;
            wimupug.mjokkyjqmenm(Application.class, application2, new Object[]{contextImpl}, "attach", Context.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ejwddyukndniutjiyingwouyl(Application application, String stubApplicationName) {
        Application application2 = mxqhfjkdxtmvjurgsnxr;
        if (application2 == null || stubApplicationName.equals(application2.getClass().getName())) {
            return;
        }
        try {
            Context contextImpl = application.getBaseContext();
            wimupug.mjokkyjqmenm(contextImpl.getClass(), contextImpl, new Object[]{mxqhfjkdxtmvjurgsnxr}, "setOuterContext", Context.class);
            Object mMainThread = wimupug.yixvfreyetriy(contextImpl.getClass(), contextImpl, "mMainThread");
            wimupug.yiegtikwkhqwt("android.app.ActivityThread", mMainThread, "mInitialApplication", mxqhfjkdxtmvjurgsnxr);
            ArrayList<Application> mAllApplications = (ArrayList) wimupug.yixvfreyetriy("android.app.ActivityThread", mMainThread, "mAllApplications");
            mAllApplications.add(mxqhfjkdxtmvjurgsnxr);
            mAllApplications.remove(application);
            Object loadedApk = wimupug.yixvfreyetriy(contextImpl.getClass(), contextImpl, "mPackageInfo");
            wimupug.yiegtikwkhqwt("android.app.LoadedApk", loadedApk, "mApplication", mxqhfjkdxtmvjurgsnxr);
            ApplicationInfo applicationInfo = (ApplicationInfo) wimupug.yixvfreyetriy("android.app.LoadedApk", loadedApk, "mApplicationInfo");
            applicationInfo.className = mxqhfjkdxtmvjurgsnxr.getClass().getName();
            mxqhfjkdxtmvjurgsnxr.onCreate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Application gpimkfxrpndmtdxmkmeqye(Application application, String stubApplicationName) {
        Application application2 = mxqhfjkdxtmvjurgsnxr;
        if (application2 == null || stubApplicationName.equals(application2.getClass().getName())) {
            return application;
        }
        try {
            Context contextImpl = application.getBaseContext();
            Object loadedApk = wimupug.yixvfreyetriy(contextImpl.getClass(), contextImpl, "mPackageInfo");
            wimupug.yiegtikwkhqwt("android.app.LoadedApk", loadedApk, "mApplication", mxqhfjkdxtmvjurgsnxr);
            Object activityThread = woyqtiqyiiijsojjlgvrkjxv();
            Map<Object, Object> mProviderMap = (Map) wimupug.yixvfreyetriy(activityThread.getClass(), activityThread, "mProviderMap");
            Set<Map.Entry<Object, Object>> entrySet = mProviderMap.entrySet();
            for (Map.Entry<Object, Object> entry : entrySet) {
                ContentProvider contentProvider = (ContentProvider) wimupug.yixvfreyetriy(entry.getValue().getClass(), entry.getValue(), "mLocalProvider");
                if (contentProvider != null) {
                    wimupug.yiegtikwkhqwt("android.content.ContentProvider", contentProvider, "fnjkjldn", mxqhfjkdxtmvjurgsnxr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mxqhfjkdxtmvjurgsnxr;
    }

    private static Object woyqtiqyiiijsojjlgvrkjxv() {
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
