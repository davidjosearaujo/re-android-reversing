package com.alibaba.android.arouter.launcher;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.core.InstrumentationHook;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.service.PretreatmentService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.thread.DefaultPoolExecutor;
import com.alibaba.android.arouter.utils.DefaultLogger;
import com.alibaba.android.arouter.utils.TextUtils;
import com.alibaba.fastjson.asm.Label;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class _ARouter {
    private static InterceptorService interceptorService;
    private static Context mContext;
    private static Handler mHandler;
    public static ILogger logger = new DefaultLogger("ARouter::");
    private static volatile boolean monitorMode = false;
    private static volatile boolean debuggable = false;
    private static volatile boolean autoInject = false;
    private static volatile _ARouter instance = null;
    private static volatile boolean hasInit = false;
    private static volatile ThreadPoolExecutor executor = DefaultPoolExecutor.getInstance();

    /* renamed from: com.alibaba.android.arouter.launcher._ARouter$4  reason: invalid class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType;

        static {
            int[] iArr = new int[RouteType.values().length];
            $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType = iArr;
            try {
                iArr[RouteType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.PROVIDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.BOARDCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.CONTENT_PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.FRAGMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.METHOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private _ARouter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object _navigation(final Postcard postcard, final int i, final NavigationCallback navigationCallback) {
        final Context context = postcard.getContext();
        int i2 = AnonymousClass4.$SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[postcard.getType().ordinal()];
        if (i2 == 1) {
            final Intent intent = new Intent(context, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (flags != 0) {
                intent.setFlags(flags);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            String action = postcard.getAction();
            if (!TextUtils.isEmpty(action)) {
                intent.setAction(action);
            }
            runInMainThread(new Runnable() { // from class: com.alibaba.android.arouter.launcher._ARouter.3
                @Override // java.lang.Runnable
                public void run() {
                    _ARouter.this.startActivity(i, context, intent, postcard, navigationCallback);
                }
            });
            return null;
        } else if (i2 != 2) {
            if (i2 == 3 || i2 == 4 || i2 == 5) {
                try {
                    Object newInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (newInstance instanceof Fragment) {
                        ((Fragment) newInstance).setArguments(postcard.getExtras());
                    } else if (newInstance instanceof androidx.fragment.app.Fragment) {
                        ((androidx.fragment.app.Fragment) newInstance).setArguments(postcard.getExtras());
                    }
                    return newInstance;
                } catch (Exception e) {
                    ILogger iLogger = logger;
                    iLogger.error("ARouter::", "Fetch fragment instance error, " + TextUtils.formatStackTrace(e.getStackTrace()));
                }
            }
            return null;
        } else {
            return postcard.getProvider();
        }
    }

    public static void afterInit() {
        interceptorService = (InterceptorService) ARouter.getInstance().build("/arouter/service/interceptor").navigation();
    }

    @Deprecated
    public static void attachBaseContext() {
        Log.i("ARouter::", "ARouter start attachBaseContext");
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            declaredField.set(invoke, new InstrumentationHook());
            Log.i("ARouter::", "ARouter hook instrumentation success!");
        } catch (Exception e) {
            Log.e("ARouter::", "ARouter hook instrumentation failed! [" + e.getMessage() + "]");
        }
    }

    @Deprecated
    public static boolean canAutoInject() {
        return autoInject;
    }

    public static boolean debuggable() {
        return debuggable;
    }

    public static synchronized void destroy() {
        synchronized (_ARouter.class) {
            if (debuggable()) {
                hasInit = false;
                LogisticsCenter.suspend();
                logger.info("ARouter::", "ARouter destroy success!");
            } else {
                logger.error("ARouter::", "Destroy can be used in debug mode only!");
            }
        }
    }

    @Deprecated
    public static synchronized void enableAutoInject() {
        synchronized (_ARouter.class) {
            autoInject = true;
        }
    }

    private String extractGroup(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/")) {
            try {
                String substring = str.substring(1, str.indexOf("/", 1));
                if (TextUtils.isEmpty(substring)) {
                    throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
                }
                return substring;
            } catch (Exception e) {
                ILogger iLogger = logger;
                iLogger.warning("ARouter::", "Failed to extract default group! " + e.getMessage());
                return null;
            }
        }
        throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
    }

    public static _ARouter getInstance() {
        if (hasInit) {
            if (instance == null) {
                synchronized (_ARouter.class) {
                    if (instance == null) {
                        instance = new _ARouter();
                    }
                }
            }
            return instance;
        }
        throw new InitException("ARouterCore::Init::Invoke init(context) first!");
    }

    public static synchronized boolean init(Application application) {
        synchronized (_ARouter.class) {
            mContext = application;
            LogisticsCenter.init(application, executor);
            logger.info("ARouter::", "ARouter init success!");
            hasInit = true;
            mHandler = new Handler(Looper.getMainLooper());
        }
        return true;
    }

    public static void inject(Object obj) {
        AutowiredService autowiredService = (AutowiredService) ARouter.getInstance().build("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    public static boolean isMonitorMode() {
        return monitorMode;
    }

    public static synchronized void monitorMode() {
        synchronized (_ARouter.class) {
            monitorMode = true;
            logger.info("ARouter::", "ARouter monitorMode on");
        }
    }

    public static synchronized void openDebug() {
        synchronized (_ARouter.class) {
            debuggable = true;
            logger.info("ARouter::", "ARouter openDebug");
        }
    }

    public static synchronized void openLog() {
        synchronized (_ARouter.class) {
            logger.showLog(true);
            logger.info("ARouter::", "ARouter openLog");
        }
    }

    public static synchronized void printStackTrace() {
        synchronized (_ARouter.class) {
            logger.showStackTrace(true);
            logger.info("ARouter::", "ARouter printStackTrace");
        }
    }

    private void runInMainThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static synchronized void setExecutor(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (_ARouter.class) {
            executor = threadPoolExecutor;
        }
    }

    public static void setLogger(ILogger iLogger) {
        if (iLogger != null) {
            logger = iLogger;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startActivity(int i, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i >= 0) {
            if (context instanceof Activity) {
                ActivityCompat.startActivityForResult((Activity) context, intent, i, postcard.getOptionsBundle());
            } else {
                logger.warning("ARouter::", "Must use [navigation(activity, ...)] to support [startActivityForResult]");
            }
        } else {
            ContextCompat.startActivity(context, intent, postcard.getOptionsBundle());
        }
        if (-1 != postcard.getEnterAnim() && -1 != postcard.getExitAnim() && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001d A[Catch: Exception -> 0x0075, TryCatch #0 {Exception -> 0x0075, blocks: (B:6:0x0007, B:7:0x0017, B:9:0x001d, B:13:0x0038, B:15:0x003e, B:18:0x0049), top: B:24:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean addRouteGroup(com.alibaba.android.arouter.facade.template.IRouteGroup r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ARouter::"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Exception -> L75
            r3.<init>()     // Catch: java.lang.Exception -> L75
            r8.loadInto(r3)     // Catch: java.lang.Exception -> L75
            java.util.Set r4 = r3.entrySet()     // Catch: java.lang.Exception -> L75
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Exception -> L75
        L17:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Exception -> L75
            if (r5 == 0) goto L49
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Exception -> L75
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Exception -> L75
            java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Exception -> L75
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L75
            java.lang.String r6 = r7.extractGroup(r6)     // Catch: java.lang.Exception -> L75
            java.lang.Object r5 = r5.getValue()     // Catch: java.lang.Exception -> L75
            com.alibaba.android.arouter.facade.model.RouteMeta r5 = (com.alibaba.android.arouter.facade.model.RouteMeta) r5     // Catch: java.lang.Exception -> L75
            if (r2 != 0) goto L36
            r2 = r6
        L36:
            if (r2 == 0) goto L48
            boolean r6 = r2.equals(r6)     // Catch: java.lang.Exception -> L75
            if (r6 == 0) goto L48
            java.lang.String r5 = r5.getGroup()     // Catch: java.lang.Exception -> L75
            boolean r5 = r2.equals(r5)     // Catch: java.lang.Exception -> L75
            if (r5 != 0) goto L17
        L48:
            return r1
        L49:
            com.alibaba.android.arouter.core.LogisticsCenter.addRouteGroupDynamic(r2, r8)     // Catch: java.lang.Exception -> L75
            com.alibaba.android.arouter.facade.template.ILogger r8 = com.alibaba.android.arouter.launcher._ARouter.logger     // Catch: java.lang.Exception -> L75
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L75
            r4.<init>()     // Catch: java.lang.Exception -> L75
            java.lang.String r5 = "Add route group ["
            r4.append(r5)     // Catch: java.lang.Exception -> L75
            r4.append(r2)     // Catch: java.lang.Exception -> L75
            java.lang.String r2 = "] finish, "
            r4.append(r2)     // Catch: java.lang.Exception -> L75
            int r2 = r3.size()     // Catch: java.lang.Exception -> L75
            r4.append(r2)     // Catch: java.lang.Exception -> L75
            java.lang.String r2 = " new route meta."
            r4.append(r2)     // Catch: java.lang.Exception -> L75
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Exception -> L75
            r8.info(r0, r2)     // Catch: java.lang.Exception -> L75
            r8 = 1
            return r8
        L75:
            r8 = move-exception
            com.alibaba.android.arouter.facade.template.ILogger r2 = com.alibaba.android.arouter.launcher._ARouter.logger
            java.lang.String r3 = "Add route group dynamic exception!"
            r2.error(r0, r3, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.launcher._ARouter.addRouteGroup(com.alibaba.android.arouter.facade.template.IRouteGroup):boolean");
    }

    public Postcard build(String str) {
        if (!TextUtils.isEmpty(str)) {
            PathReplaceService pathReplaceService = (PathReplaceService) ARouter.getInstance().navigation(PathReplaceService.class);
            if (pathReplaceService != null) {
                str = pathReplaceService.forString(str);
            }
            return build(str, extractGroup(str), Boolean.TRUE);
        }
        throw new HandlerException("ARouter::Parameter is invalid!");
    }

    public <T> T navigation(Class<? extends T> cls) {
        try {
            Postcard buildProvider = LogisticsCenter.buildProvider(cls.getName());
            if (buildProvider == null) {
                buildProvider = LogisticsCenter.buildProvider(cls.getSimpleName());
            }
            if (buildProvider == null) {
                return null;
            }
            buildProvider.setContext(mContext);
            LogisticsCenter.completion(buildProvider);
            return (T) buildProvider.getProvider();
        } catch (NoRouteFoundException e) {
            logger.warning("ARouter::", e.getMessage());
            return null;
        }
    }

    public Postcard build(Uri uri) {
        if (uri != null && !TextUtils.isEmpty(uri.toString())) {
            PathReplaceService pathReplaceService = (PathReplaceService) ARouter.getInstance().navigation(PathReplaceService.class);
            if (pathReplaceService != null) {
                uri = pathReplaceService.forUri(uri);
            }
            return new Postcard(uri.getPath(), extractGroup(uri.getPath()), uri, null);
        }
        throw new HandlerException("ARouter::Parameter invalid!");
    }

    public Object navigation(Context context, final Postcard postcard, final int i, final NavigationCallback navigationCallback) {
        PretreatmentService pretreatmentService = (PretreatmentService) ARouter.getInstance().navigation(PretreatmentService.class);
        if (pretreatmentService == null || pretreatmentService.onPretreatment(context, postcard)) {
            postcard.setContext(context == null ? mContext : context);
            try {
                LogisticsCenter.completion(postcard);
                if (navigationCallback != null) {
                    navigationCallback.onFound(postcard);
                }
                if (!postcard.isGreenChannel()) {
                    interceptorService.doInterceptions(postcard, new InterceptorCallback() { // from class: com.alibaba.android.arouter.launcher._ARouter.2
                        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
                        public void onContinue(Postcard postcard2) {
                            _ARouter.this._navigation(postcard2, i, navigationCallback);
                        }

                        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
                        public void onInterrupt(Throwable th) {
                            NavigationCallback navigationCallback2 = navigationCallback;
                            if (navigationCallback2 != null) {
                                navigationCallback2.onInterrupt(postcard);
                            }
                            ILogger iLogger = _ARouter.logger;
                            iLogger.info("ARouter::", "Navigation failed, termination by interceptor : " + th.getMessage());
                        }
                    });
                    return null;
                }
                return _navigation(postcard, i, navigationCallback);
            } catch (NoRouteFoundException e) {
                logger.warning("ARouter::", e.getMessage());
                if (debuggable()) {
                    runInMainThread(new Runnable() { // from class: com.alibaba.android.arouter.launcher._ARouter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context context2 = _ARouter.mContext;
                            Toast.makeText(context2, "There's no route matched!\n Path = [" + postcard.getPath() + "]\n Group = [" + postcard.getGroup() + "]", 1).show();
                        }
                    });
                }
                if (navigationCallback != null) {
                    navigationCallback.onLost(postcard);
                } else {
                    DegradeService degradeService = (DegradeService) ARouter.getInstance().navigation(DegradeService.class);
                    if (degradeService != null) {
                        degradeService.onLost(context, postcard);
                    }
                }
                return null;
            }
        }
        return null;
    }

    public Postcard build(String str, String str2, Boolean bool) {
        PathReplaceService pathReplaceService;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!bool.booleanValue() && (pathReplaceService = (PathReplaceService) ARouter.getInstance().navigation(PathReplaceService.class)) != null) {
                str = pathReplaceService.forString(str);
            }
            return new Postcard(str, str2);
        }
        throw new HandlerException("ARouter::Parameter is invalid!");
    }
}
