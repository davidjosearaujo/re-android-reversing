package com.alibaba.android.arouter.launcher;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ARouter {
    public static final String AUTO_INJECT = "wmHzgD4lOj5o4241";
    public static final String RAW_URI = "NTeRQWvye18AkPd6G";
    private static volatile boolean hasInit;
    private static volatile ARouter instance;
    public static ILogger logger;

    private ARouter() {
    }

    @Deprecated
    public static void attachBaseContext() {
        _ARouter.attachBaseContext();
    }

    @Deprecated
    public static boolean canAutoInject() {
        return _ARouter.canAutoInject();
    }

    public static boolean debuggable() {
        return _ARouter.debuggable();
    }

    @Deprecated
    public static synchronized void enableAutoInject() {
        synchronized (ARouter.class) {
            _ARouter.enableAutoInject();
        }
    }

    public static ARouter getInstance() {
        if (hasInit) {
            if (instance == null) {
                synchronized (ARouter.class) {
                    if (instance == null) {
                        instance = new ARouter();
                    }
                }
            }
            return instance;
        }
        throw new InitException("ARouter::Init::Invoke init(context) first!");
    }

    public static void init(Application application) {
        if (hasInit) {
            return;
        }
        ILogger iLogger = _ARouter.logger;
        logger = iLogger;
        iLogger.info("ARouter::", "ARouter init start.");
        hasInit = _ARouter.init(application);
        if (hasInit) {
            _ARouter.afterInit();
        }
        _ARouter.logger.info("ARouter::", "ARouter init over.");
    }

    public static boolean isMonitorMode() {
        return _ARouter.isMonitorMode();
    }

    public static synchronized void monitorMode() {
        synchronized (ARouter.class) {
            _ARouter.monitorMode();
        }
    }

    public static synchronized void openDebug() {
        synchronized (ARouter.class) {
            _ARouter.openDebug();
        }
    }

    public static synchronized void openLog() {
        synchronized (ARouter.class) {
            _ARouter.openLog();
        }
    }

    public static synchronized void printStackTrace() {
        synchronized (ARouter.class) {
            _ARouter.printStackTrace();
        }
    }

    public static synchronized void setExecutor(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (ARouter.class) {
            _ARouter.setExecutor(threadPoolExecutor);
        }
    }

    public static void setLogger(ILogger iLogger) {
        _ARouter.setLogger(iLogger);
    }

    public boolean addRouteGroup(IRouteGroup iRouteGroup) {
        return _ARouter.getInstance().addRouteGroup(iRouteGroup);
    }

    public Postcard build(String str) {
        return _ARouter.getInstance().build(str);
    }

    public synchronized void destroy() {
        _ARouter.destroy();
        hasInit = false;
    }

    public void inject(Object obj) {
        _ARouter.inject(obj);
    }

    public <T> T navigation(Class<? extends T> cls) {
        return (T) _ARouter.getInstance().navigation(cls);
    }

    @Deprecated
    public Postcard build(String str, String str2) {
        return _ARouter.getInstance().build(str, str2, Boolean.FALSE);
    }

    public Object navigation(Context context, Postcard postcard, int i, NavigationCallback navigationCallback) {
        return _ARouter.getInstance().navigation(context, postcard, i, navigationCallback);
    }

    public Postcard build(Uri uri) {
        return _ARouter.getInstance().build(uri);
    }
}
