package cn.com.custommma.mobile.tracking.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.com.custommma.mobile.tracking.api.Constant;
import cn.com.custommma.mobile.tracking.bean.Applist;
import cn.com.custommma.mobile.tracking.bean.Company;
import cn.jpush.android.local.JPushConstants;
import com.hunantv.imgo.entity.JumpAction;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AppListUploader {
    private static final String JSON_ANDROIDID = "androidid";
    private static final String JSON_APPLIST = "applist";
    private static final String JSON_BUNDLEID = "bundleid";
    private static final String JSON_IMEI = "imei";
    private static final String JSON_MAC = "mac";
    private static final String JSON_SDKV = "sdkv";
    private static final String JSON_SOURCE = "sdk";
    private static final String JSON_TIME = "time";
    private static final String SOURCE_TYPE = "MMASDK";
    private static boolean isUploading;
    private static Context mContext;
    private static AppListUploader mInstance;
    private long lastUploadTime;

    private AppListUploader(Context context) {
        mContext = context;
        this.lastUploadTime = -1L;
    }

    private void checkIsNeedUpload(String str, final Company company) {
        String str2;
        Applist applist = company.applist;
        if (applist == null || TextUtils.isEmpty(applist.uploadUrl) || applist.uploadTime <= 0) {
            return;
        }
        final String str3 = company.domain.url + SharedPreferencedUtil.SP_OTHER_KEY_LASTUPLOADTIME_SUFFIX;
        if (this.lastUploadTime < 0) {
            this.lastUploadTime = SharedPreferencedUtil.getLong(mContext, SharedPreferencedUtil.SP_NAME_OTHER, str3);
        }
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > this.lastUploadTime + (applist.uploadTime * 60 * 60)) {
            isUploading = true;
            if (!applist.uploadUrl.startsWith(JPushConstants.HTTPS_PRE) && !applist.uploadUrl.startsWith(JPushConstants.HTTP_PRE)) {
                try {
                    URL url = new URL(str);
                    str2 = url.getProtocol() + JumpAction.STR_SCHEM_SPLIT + url.getHost() + applist.uploadUrl;
                } catch (Exception unused) {
                    str2 = JPushConstants.HTTP_PRE + company.domain.url + applist.uploadUrl;
                }
            } else {
                str2 = applist.uploadUrl;
            }
            final String str4 = str2;
            new Thread(new Runnable() { // from class: cn.com.custommma.mobile.tracking.util.AppListUploader.1
                @Override // java.lang.Runnable
                public void run() {
                    String jSONObject;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray applist2 = DeviceInfoUtil.getApplist(AppListUploader.mContext);
                        Map<String, String> deviceInfo = DeviceInfoUtil.getDeviceInfo(AppListUploader.mContext);
                        jSONObject2.put("time", String.valueOf(System.currentTimeMillis()));
                        jSONObject2.put("sdk", AppListUploader.SOURCE_TYPE);
                        jSONObject2.put(AppListUploader.JSON_BUNDLEID, AppListUploader.mContext.getPackageName());
                        jSONObject2.put(AppListUploader.JSON_SDKV, Constant.TRACKING_SDKVS_VALUE);
                        jSONObject2.put(AppListUploader.JSON_MAC, CommonUtil.md5(deviceInfo.get(Constant.TRACKING_MAC)));
                        jSONObject2.put(AppListUploader.JSON_IMEI, CommonUtil.md5(deviceInfo.get(Constant.TRACKING_IMEI)));
                        jSONObject2.put(AppListUploader.JSON_ANDROIDID, CommonUtil.md5(deviceInfo.get(Constant.TRACKING_ANDROIDID)));
                        jSONObject2.put(AppListUploader.JSON_APPLIST, applist2);
                        try {
                            jSONObject = Base64.encodeToString(jSONObject2.toString().getBytes("utf-8"), 2);
                        } catch (UnsupportedEncodingException unused2) {
                            jSONObject = jSONObject2.toString();
                        }
                        if (DeviceInfoUtil.isNetworkAvailable(AppListUploader.mContext) && ConnectUtil.getInstance().performPost(str4, jSONObject, company.applist.useGzip) != null) {
                            AppListUploader.this.lastUploadTime = currentTimeMillis;
                            SharedPreferencedUtil.putLong(AppListUploader.mContext, SharedPreferencedUtil.SP_NAME_OTHER, str3, currentTimeMillis);
                        }
                    } catch (Exception unused3) {
                    } catch (Throwable th) {
                        boolean unused4 = AppListUploader.isUploading = false;
                        throw th;
                    }
                    boolean unused5 = AppListUploader.isUploading = false;
                }
            }).start();
        }
    }

    public static AppListUploader getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AppListUploader.class) {
                if (mInstance == null) {
                    mInstance = new AppListUploader(context);
                }
            }
        }
        return mInstance;
    }

    public synchronized void sync(String str, Company company) {
        if (isUploading) {
            return;
        }
        checkIsNeedUpload(str, company);
    }
}
