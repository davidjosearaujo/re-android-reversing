package cn.com.custommma.mobile.tracking.util;

import android.content.Context;
import android.text.TextUtils;
import cn.com.custommma.mobile.tracking.api.Constant;
import cn.com.custommma.mobile.tracking.bean.OfflineCache;
import cn.com.custommma.mobile.tracking.bean.SDK;
import java.io.ByteArrayInputStream;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SdkConfigUpdateUtil {
    private static String configURL;
    private static boolean isUpdating;
    private static SDK sdkConfig;

    private static boolean checkNeedUpdate(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long j = SharedPreferencedUtil.getLong(context, SharedPreferencedUtil.SP_NAME_OTHER, SharedPreferencedUtil.SP_OTHER_KEY_UPDATE_TIME);
            if (currentTimeMillis >= j) {
                return (CommonUtil.isConnected(context, 1) && ((currentTimeMillis - j) > 86400000L ? 1 : ((currentTimeMillis - j) == 86400000L ? 0 : -1)) >= 0) || (CommonUtil.isConnected(context, 0) && ((currentTimeMillis - j) > Constant.TIME_THREE_DAY ? 1 : ((currentTimeMillis - j) == Constant.TIME_THREE_DAY ? 0 : -1)) >= 0);
            }
            SharedPreferencedUtil.putLong(context, SharedPreferencedUtil.SP_NAME_OTHER, SharedPreferencedUtil.SP_OTHER_KEY_UPDATE_TIME, currentTimeMillis);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static SDK getSDKConfig(Context context) {
        SDK sdk = sdkConfig;
        if (sdk == null || sdk.companies == null) {
            SDK sDKFromCache = getSDKFromCache(context);
            sdkConfig = sDKFromCache;
            if (sDKFromCache == null && !TextUtils.isEmpty(configURL)) {
                sync(context, configURL);
            }
        }
        return sdkConfig;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0037, code lost:
        if (r4 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0039, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0047, code lost:
        if (r4 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x004a, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static cn.com.custommma.mobile.tracking.bean.SDK getSDKFromCache(android.content.Context r4) {
        /*
            r0 = 0
            java.lang.String r1 = "cn.com.mma.mobile.tracking.sdkconfig"
            java.lang.String r2 = "trackingConfig"
            java.lang.String r1 = cn.com.custommma.mobile.tracking.util.SharedPreferencedUtil.getString(r4, r1, r2)     // Catch: java.lang.Exception -> L4b
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45
            if (r2 != 0) goto L1a
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45
            goto L25
        L1a:
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45
            java.lang.String r1 = "sdkconfig.xml"
            java.io.InputStream r4 = r4.open(r1)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L45
        L25:
            if (r4 == 0) goto L36
            cn.com.custommma.mobile.tracking.bean.SDK r1 = cn.com.custommma.mobile.tracking.util.XmlUtil.doParser(r4)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L34
            initOffLineCache(r1)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L47
            goto L37
        L2f:
            r1 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
            goto L3f
        L34:
            r1 = r0
            goto L47
        L36:
            r1 = r0
        L37:
            if (r4 == 0) goto L4a
        L39:
            r4.close()     // Catch: java.lang.Exception -> L4b
            goto L4a
        L3d:
            r4 = move-exception
            r1 = r0
        L3f:
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.lang.Exception -> L4b
        L44:
            throw r4     // Catch: java.lang.Exception -> L4b
        L45:
            r4 = r0
            r1 = r4
        L47:
            if (r4 == 0) goto L4a
            goto L39
        L4a:
            return r1
        L4b:
            r4 = move-exception
            r4.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.util.SdkConfigUpdateUtil.getSDKFromCache(android.content.Context):cn.com.custommma.mobile.tracking.bean.SDK");
    }

    public static void initOffLineCache(SDK sdk) {
        if (sdk != null) {
            try {
                OfflineCache offlineCache = sdk.offlineCache;
                if (offlineCache != null) {
                    if (!TextUtils.isEmpty(offlineCache.length)) {
                        Constant.OFFLINECACHE_LENGTH = Integer.parseInt(sdk.offlineCache.length);
                    }
                    if (!TextUtils.isEmpty(sdk.offlineCache.queueExpirationSecs)) {
                        Constant.OFFLINECACHE_QUEUEEXPIRATIONSECS = Integer.parseInt(sdk.offlineCache.queueExpirationSecs);
                    }
                    if (TextUtils.isEmpty(sdk.offlineCache.timeout)) {
                        return;
                    }
                    Constant.OFFLINECACHE_TIMEOUT = Integer.parseInt(sdk.offlineCache.timeout);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void sync(final Context context, final String str) {
        synchronized (SdkConfigUpdateUtil.class) {
            if (isUpdating) {
                return;
            }
            boolean checkNeedUpdate = checkNeedUpdate(context);
            Logger.d(" update sdkconfig sync1" + str + "checkNeedUpdate" + checkNeedUpdate);
            if (!TextUtils.isEmpty(str) && checkNeedUpdate) {
                configURL = str;
                isUpdating = true;
                new Thread(new Runnable() { // from class: cn.com.custommma.mobile.tracking.util.SdkConfigUpdateUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            try {
                                if (DeviceInfoUtil.isNetworkAvailable(context)) {
                                    Logger.d(" update sdkconfig configUrl" + str);
                                    byte[] performGet = ConnectUtil.getInstance().performGet(str);
                                    Logger.d(" update sdkconfig buffer" + performGet);
                                    if (performGet != null) {
                                        SDK unused = SdkConfigUpdateUtil.sdkConfig = XmlUtil.doParser(new ByteArrayInputStream(performGet));
                                        Logger.d(" sdkConfig" + SdkConfigUpdateUtil.sdkConfig);
                                        if (SdkConfigUpdateUtil.sdkConfig != null && SdkConfigUpdateUtil.sdkConfig.companies != null && SdkConfigUpdateUtil.sdkConfig.companies.size() > 0) {
                                            Logger.d(" sdkConfig22222222" + SdkConfigUpdateUtil.sdkConfig);
                                            String str2 = new String(performGet);
                                            Logger.d(" response" + str2);
                                            if (!TextUtils.isEmpty(str2)) {
                                                Logger.d(" response" + str2);
                                                SharedPreferencedUtil.putString(context, SharedPreferencedUtil.SP_NAME_CONFIG, SharedPreferencedUtil.SP_CONFIG_KEY_FILE, str2);
                                                SharedPreferencedUtil.putLong(context, SharedPreferencedUtil.SP_NAME_OTHER, SharedPreferencedUtil.SP_OTHER_KEY_UPDATE_TIME, System.currentTimeMillis());
                                                Logger.d("Successful update sdkconfig files");
                                            }
                                            SdkConfigUpdateUtil.initOffLineCache(SdkConfigUpdateUtil.sdkConfig);
                                        }
                                    } else {
                                        Logger.d("upload配置文件没有成功");
                                    }
                                }
                            } catch (Exception e) {
                                Logger.w("Online update sdkconfig failed!:" + e.getMessage());
                            }
                        } finally {
                            boolean unused2 = SdkConfigUpdateUtil.isUpdating = false;
                        }
                    }
                }).start();
            }
        }
    }
}
