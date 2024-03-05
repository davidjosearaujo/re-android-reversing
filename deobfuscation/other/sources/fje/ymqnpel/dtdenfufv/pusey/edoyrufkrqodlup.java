package fje.ymqnpel.dtdenfufv.pusey;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import eeu.wuekite.ptluwwjmt.ypxjt.MethodClassWrapper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* compiled from: ApplicationHook.java */
/* loaded from: /home/tiago/Downloads/PDF_Reader_File_Manager/other/1/classes.dex */
public class edoyrufkrqodlup {

    /* renamed from: mxqhfjkdxtmvjurgsnxr */
    private static Application application;

    public static void mfre(Application application2, String delegateApplicationName, String stubApplicationName) {
        if (TextUtils.isEmpty(delegateApplicationName) || stubApplicationName.equals(delegateApplicationName)) {
            application = application2;
            return;
        }
        try {
            Context contextImpl = application2.getBaseContext();
            ClassLoader classLoader = application2.getClassLoader();
            Class<?> applicationClass = classLoader.loadClass(delegateApplicationName);
            Application application3 = (Application) applicationClass.newInstance();
            application = application3;
            MethodClassWrapper.callMethod(Application.class, application3, new Object[]{contextImpl}, "attach", Context.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ejwddyukndniutjiyingwouyl(Application application2, String stubApplicationName) {
        Application application3 = application;
        if (application3 == null || stubApplicationName.equals(application3.getClass().getName())) {
            return;
        }
        try {
            Context contextImpl = application2.getBaseContext();
            MethodClassWrapper.callMethod(contextImpl.getClass(), contextImpl, new Object[]{application}, "setOuterContext", Context.class);
            Object mMainThread = MethodClassWrapper.yixvfreyetriy(contextImpl.getClass(), contextImpl, "mMainThread");
            MethodClassWrapper.yiegtikwkhqwt("android.app.ActivityThread", mMainThread, "mInitialApplication", application);
            ArrayList<Application> mAllApplications = (ArrayList) MethodClassWrapper.yixvfreyetriy("android.app.ActivityThread", mMainThread, "mAllApplications");
            mAllApplications.add(application);
            mAllApplications.remove(application2);
            Object loadedApk = MethodClassWrapper.yixvfreyetriy(contextImpl.getClass(), contextImpl, "mPackageInfo");
            MethodClassWrapper.yiegtikwkhqwt("android.app.LoadedApk", loadedApk, "mApplication", application);
            ApplicationInfo applicationInfo = (ApplicationInfo) MethodClassWrapper.yixvfreyetriy("android.app.LoadedApk", loadedApk, "mApplicationInfo");
            applicationInfo.className = application.getClass().getName();
            application.onCreate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Application gpimkfxrpndmtdxmkmeqye(Application application2, String stubApplicationName) {
        Application application3 = application;
        if (application3 == null || stubApplicationName.equals(application3.getClass().getName())) {
            return application2;
        }
        try {
            Context contextImpl = application2.getBaseContext();
            Object loadedApk = MethodClassWrapper.yixvfreyetriy(contextImpl.getClass(), contextImpl, "mPackageInfo");
            MethodClassWrapper.yiegtikwkhqwt("android.app.LoadedApk", loadedApk, "mApplication", application);
            Object activityThread = woyqtiqyiiijsojjlgvrkjxv();
            Map<Object, Object> mProviderMap = (Map) MethodClassWrapper.yixvfreyetriy(activityThread.getClass(), activityThread, "mProviderMap");
            Set<Map.Entry<Object, Object>> entrySet = mProviderMap.entrySet();
            for (Map.Entry<Object, Object> entry : entrySet) {
                ContentProvider contentProvider = (ContentProvider) MethodClassWrapper.yixvfreyetriy(entry.getValue().getClass(), entry.getValue(), "mLocalProvider");
                if (contentProvider != null) {
                    MethodClassWrapper.yiegtikwkhqwt("android.content.ContentProvider", contentProvider, "fnjkjldn", application);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return application;
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
