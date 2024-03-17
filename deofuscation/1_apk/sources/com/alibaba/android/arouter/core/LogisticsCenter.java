package com.alibaba.android.arouter.core;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.MapUtils;
import com.alibaba.android.arouter.utils.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LogisticsCenter {
    public static ThreadPoolExecutor executor;
    private static Context mContext;
    private static boolean registerByPlugin;

    /* renamed from: com.alibaba.android.arouter.core.LogisticsCenter$1 */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType;

        static {
            int[] iArr = new int[RouteType.values().length];
            $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType = iArr;
            try {
                iArr[RouteType.PROVIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static synchronized void addRouteGroupDynamic(String str, IRouteGroup iRouteGroup) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        synchronized (LogisticsCenter.class) {
            if (Warehouse.groupsIndex.containsKey(str)) {
                Warehouse.groupsIndex.get(str).getConstructor(new Class[0]).newInstance(new Object[0]).loadInto(Warehouse.routes);
                Warehouse.groupsIndex.remove(str);
            }
            if (iRouteGroup != null) {
                iRouteGroup.loadInto(Warehouse.routes);
            }
        }
    }

    public static Postcard buildProvider(String str) {
        RouteMeta routeMeta = Warehouse.providersIndex.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    public static synchronized void completion(Postcard postcard) {
        synchronized (LogisticsCenter.class) {
            if (postcard != null) {
                RouteMeta routeMeta = Warehouse.routes.get(postcard.getPath());
                if (routeMeta == null) {
                    if (Warehouse.groupsIndex.containsKey(postcard.getGroup())) {
                        try {
                            if (ARouter.debuggable()) {
                                ARouter.logger.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] starts loading, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                            }
                            addRouteGroupDynamic(postcard.getGroup(), null);
                            if (ARouter.debuggable()) {
                                ARouter.logger.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] has already been loaded, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                            }
                            completion(postcard);
                        } catch (Exception e) {
                            throw new HandlerException("ARouter::Fatal exception when loading group meta. [" + e.getMessage() + "]");
                        }
                    } else {
                        throw new NoRouteFoundException("ARouter::There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
                    }
                } else {
                    postcard.setDestination(routeMeta.getDestination());
                    postcard.setType(routeMeta.getType());
                    postcard.setPriority(routeMeta.getPriority());
                    postcard.setExtra(routeMeta.getExtra());
                    Uri uri = postcard.getUri();
                    if (uri != null) {
                        Map<String, String> splitQueryParameters = TextUtils.splitQueryParameters(uri);
                        Map<String, Integer> paramsType = routeMeta.getParamsType();
                        if (MapUtils.isNotEmpty(paramsType)) {
                            for (Map.Entry<String, Integer> entry : paramsType.entrySet()) {
                                setValue(postcard, entry.getValue(), entry.getKey(), splitQueryParameters.get(entry.getKey()));
                            }
                            postcard.getExtras().putStringArray(ARouter.AUTO_INJECT, (String[]) paramsType.keySet().toArray(new String[0]));
                        }
                        postcard.withString(ARouter.RAW_URI, uri.toString());
                    }
                    int i = AnonymousClass1.$SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[routeMeta.getType().ordinal()];
                    if (i == 1) {
                        Class<?> destination = routeMeta.getDestination();
                        IProvider iProvider = Warehouse.providers.get(destination);
                        if (iProvider == null) {
                            try {
                                iProvider = (IProvider) destination.getConstructor(new Class[0]).newInstance(new Object[0]);
                                iProvider.init(mContext);
                                Warehouse.providers.put(destination, iProvider);
                            } catch (Exception e2) {
                                ARouter.logger.error("ARouter::", "Init provider failed!", e2);
                                throw new HandlerException("Init provider failed!");
                            }
                        }
                        postcard.setProvider(iProvider);
                        postcard.greenChannel();
                    } else if (i == 2) {
                        postcard.greenChannel();
                    }
                }
            } else {
                throw new NoRouteFoundException("ARouter::No postcard!");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00b4 A[Catch: Exception -> 0x018f, all -> 0x01b0, TryCatch #1 {Exception -> 0x018f, blocks: (B:65:0x0007, B:67:0x0013, B:90:0x011a, B:92:0x0144, B:93:0x014d, B:95:0x0153, B:68:0x001e, B:70:0x0024, B:73:0x002b, B:78:0x0078, B:79:0x00ae, B:81:0x00b4, B:83:0x00c2, B:84:0x00da, B:86:0x00e2, B:87:0x00fa, B:89:0x0102, B:74:0x004b, B:76:0x0062, B:77:0x0075), top: B:107:0x0007, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void init(android.content.Context r8, java.util.concurrent.ThreadPoolExecutor r9) throws com.alibaba.android.arouter.exception.HandlerException {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.core.LogisticsCenter.init(android.content.Context, java.util.concurrent.ThreadPoolExecutor):void");
    }

    private static void loadRouterMap() {
        registerByPlugin = false;
    }

    private static void markRegisteredByPlugin() {
        if (registerByPlugin) {
            return;
        }
        registerByPlugin = true;
    }

    private static void register(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (newInstance instanceof IRouteRoot) {
                registerRouteRoot((IRouteRoot) newInstance);
            } else if (newInstance instanceof IProviderGroup) {
                registerProvider((IProviderGroup) newInstance);
            } else if (newInstance instanceof IInterceptorGroup) {
                registerInterceptor((IInterceptorGroup) newInstance);
            } else {
                ILogger iLogger = ARouter.logger;
                iLogger.info("ARouter::", "register failed, class name: " + str + " should implements one of IRouteRoot/IProviderGroup/IInterceptorGroup.");
            }
        } catch (Exception e) {
            ILogger iLogger2 = ARouter.logger;
            iLogger2.error("ARouter::", "register class error:" + str, e);
        }
    }

    private static void registerInterceptor(IInterceptorGroup iInterceptorGroup) {
        markRegisteredByPlugin();
        if (iInterceptorGroup != null) {
            iInterceptorGroup.loadInto(Warehouse.interceptorsIndex);
        }
    }

    private static void registerProvider(IProviderGroup iProviderGroup) {
        markRegisteredByPlugin();
        if (iProviderGroup != null) {
            iProviderGroup.loadInto(Warehouse.providersIndex);
        }
    }

    private static void registerRouteRoot(IRouteRoot iRouteRoot) {
        markRegisteredByPlugin();
        if (iRouteRoot != null) {
            iRouteRoot.loadInto(Warehouse.groupsIndex);
        }
    }

    private static void setValue(Postcard postcard, Integer num, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            if (num != null) {
                if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                    postcard.withBoolean(str, Boolean.parseBoolean(str2));
                } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                    postcard.withByte(str, Byte.parseByte(str2));
                } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                    postcard.withShort(str, Short.parseShort(str2));
                } else if (num.intValue() == TypeKind.INT.ordinal()) {
                    postcard.withInt(str, Integer.parseInt(str2));
                } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                    postcard.withLong(str, Long.parseLong(str2));
                } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                    postcard.withFloat(str, Float.parseFloat(str2));
                } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                    postcard.withDouble(str, Double.parseDouble(str2));
                } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                    postcard.withString(str, str2);
                } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                    if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                        postcard.withString(str, str2);
                    } else {
                        postcard.withString(str, str2);
                    }
                }
            } else {
                postcard.withString(str, str2);
            }
        } catch (Throwable th) {
            ILogger iLogger = ARouter.logger;
            iLogger.warning("ARouter::", "LogisticsCenter setValue failed! " + th.getMessage());
        }
    }

    public static void suspend() {
        Warehouse.clear();
    }
}
