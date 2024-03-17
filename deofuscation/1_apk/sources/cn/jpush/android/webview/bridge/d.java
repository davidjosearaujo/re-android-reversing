package cn.jpush.android.webview.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ac.i;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.h;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.u.e;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.alibaba.fastjson.asm.Label;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.hunantv.media.player.subtitle.MediaFormat;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static String f;
    private final WeakReference<Activity> a;
    private final cn.jpush.android.d.d b;
    private e c;
    private boolean d = false;
    private int e = 0;

    public d(Context context, cn.jpush.android.d.d dVar) {
        this.a = new WeakReference<>((Activity) context);
        this.b = dVar;
    }

    private JSONObject a(Context context) {
        String str;
        String str2;
        String str3;
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 86, null, null, new Object[0]);
        String str4 = "";
        if (onEvent instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) onEvent;
            str4 = jSONObject.optString("manufacturer", " ");
            str2 = jSONObject.optString(DeviceRequestsHelper.DEVICE_INFO_MODEL, " ");
            str3 = h.a();
            str = jSONObject.optString("os_version", " ");
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        if (f == null) {
            f = context.getResources().getConfiguration().locale.toString();
            Logger.d("WebViewHelper", "device info language: " + f);
        }
        DisplayMetrics a = i.a(context);
        int i = a.widthPixels;
        int i2 = a.heightPixels;
        float f2 = a.scaledDensity;
        int i3 = context.getResources().getConfiguration().orientation;
        String str5 = i3 == 2 ? "landscape" : "portrait";
        this.e = i3;
        int i4 = (context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0;
        boolean is24HourFormat = DateFormat.is24HourFormat(context);
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("manufacturer", str4);
        jSONObject2.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, str2);
        jSONObject2.put("romUIVersion", str3);
        jSONObject2.put("osVersion", str);
        jSONObject2.put(MediaFormat.KEY_LANGUAGE, f);
        jSONObject2.put("screenW", i);
        jSONObject2.put("screenH", i2);
        jSONObject2.put("scaledDensity", f2);
        jSONObject2.put("orientation", str5);
        jSONObject2.put("currentTime", currentTimeMillis);
        jSONObject2.put("nightMode", i4);
        jSONObject2.put("is24Hour", is24HourFormat ? 1 : 0);
        Logger.d("WebViewHelper", "device info: " + jSONObject2.toString());
        return jSONObject2;
    }

    private void a(String str) {
        int i;
        try {
            try {
                i = Integer.parseInt(str);
            } catch (Exception unused) {
                Logger.e("WebViewHelper", "Invalid actionId from Web - " + str);
                i = 1100;
            }
            cn.jpush.android.helper.c.a(this.b.c, i, JPushConstants.mApplicationContext);
        } catch (Throwable unused2) {
        }
    }

    public int a() {
        return this.e;
    }

    public void a(e eVar) {
        this.c = eVar;
        this.d = false;
    }

    @JavascriptInterface
    public void click(String str, String str2, String str3) {
        Logger.d("WebViewHelper", "Web callback:click - actionId:" + str + ", shouldClose:" + str2 + ", shouldCancelNotification:" + str3);
        try {
            a(str);
            boolean parseBoolean = Boolean.parseBoolean(str2);
            if (Boolean.parseBoolean(str3)) {
                cn.jpush.android.x.c.e(JPushConstants.mApplicationContext, this.b);
            }
            if (!parseBoolean || this.a.get() == null) {
                return;
            }
            this.a.get().finish();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void close() {
        if (this.a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:close");
            this.a.get().finish();
        }
    }

    @JavascriptInterface
    public void createShortcut(String str, String str2, String str3) {
    }

    @JavascriptInterface
    public void download(String str) {
        if (this.a.get() == null) {
            return;
        }
        Logger.d("WebViewHelper", "Web callback:download - " + str);
    }

    @JavascriptInterface
    public void download(String str, String str2) {
        if (this.a.get() == null) {
            return;
        }
        a(str);
        download(str2);
        cn.jpush.android.x.c.e(JPushConstants.mApplicationContext, this.b);
        this.a.get().finish();
    }

    @JavascriptInterface
    public void download(String str, String str2, String str3) {
        Logger.v("WebViewHelper", "msgType from web: " + str3);
        download(str, str2);
    }

    @JavascriptInterface
    public void executeMsgMessage(String str) {
    }

    @JavascriptInterface
    public String getDevInfo() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            Context context = JPushConstants.mApplicationContext;
            if (context == null) {
                return "";
            }
            Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 86, null, null, new Object[0]);
            if (onEvent instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) onEvent;
                str2 = jSONObject.optString("manufacturer", " ");
                str3 = jSONObject.optString(DeviceRequestsHelper.DEVICE_INFO_MODEL, " ");
                str4 = h.a();
                str5 = jSONObject.optString("os_version", " ");
                str = jSONObject.optString(MediaFormat.KEY_LANGUAGE, " ");
            } else {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            }
            DisplayMetrics a = i.a(context);
            int i = a.widthPixels;
            int i2 = a.heightPixels;
            float f2 = a.scaledDensity;
            String str6 = context.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
            int i3 = (context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0;
            int i4 = DateFormat.is24HourFormat(context) ? 1 : 0;
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("manufacturer", str2);
            jSONObject2.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, str3);
            jSONObject2.put("romUIVersion", str4);
            jSONObject2.put("osVersion", str5);
            jSONObject2.put(MediaFormat.KEY_LANGUAGE, str);
            jSONObject2.put("screenW", i);
            jSONObject2.put("screenH", i2);
            jSONObject2.put("scaledDensity", f2);
            jSONObject2.put("orientation", str6);
            jSONObject2.put("currentTime", currentTimeMillis);
            jSONObject2.put("nightMode", i3);
            jSONObject2.put("is24Hour", i4);
            Logger.d("WebViewHelper", "[getDevInfo] device info, " + jSONObject2.toString());
            return jSONObject2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @JavascriptInterface
    public String getNotificationInfo() {
        try {
            Context context = JPushConstants.mApplicationContext;
            if (context == null) {
                return "";
            }
            JSONObject a = a(context);
            Bitmap c = cn.jpush.android.x.c.c(context, context.getPackageName());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            c.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
            String charSequence = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", charSequence);
            jSONObject.put(RemoteMessageConst.Notification.ICON, str);
            Logger.d("WebViewHelper", "appInfo:" + jSONObject.toString());
            JSONObject b = cn.jpush.android.r.d.b(context);
            String c2 = cn.jpush.android.r.d.c(context);
            Logger.d("WebViewHelper", "containerJSON h5Extras:" + c2);
            Logger.d("WebViewHelper", "containerJSON devInfo:" + a);
            Logger.d("WebViewHelper", "containerJSON appInfo:" + jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", a);
            jSONObject2.put("app", jSONObject);
            jSONObject2.put("container", b);
            jSONObject2.put("h5_extras", c2);
            Logger.d("WebViewHelper", "containerJSON:" + jSONObject2.toString());
            return jSONObject2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @JavascriptInterface
    public String getTplData() {
        e eVar = this.c;
        if (eVar != null) {
            String s = eVar.s();
            Logger.d("WebViewHelper", "[getTplData] js get template data: " + s);
            return s;
        }
        return "";
    }

    @JavascriptInterface
    public void inAppClick(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
            String optString = jSONObject.optString(RemoteMessageConst.MessageBody.PARAM);
            Logger.d("WebViewHelper", "h5 click, actionType: " + optInt + ", actionKey: " + optString + ", param: " + str);
            cn.jpush.android.p.a.a().a(this.c, optInt, optString);
        } catch (Throwable th) {
            Logger.w("WebViewHelper", "h5 click failed, " + th.getMessage());
        }
    }

    @JavascriptInterface
    public void onLoadCallback(String str) {
        try {
            Logger.d("WebViewHelper", "onLoadCallback : " + str);
            if (this.d) {
                Logger.d("WebViewHelper", "js callback already, param: " + str);
                return;
            }
            this.d = true;
            Context context = JPushConstants.mApplicationContext;
            if (context == null && this.a.get() != null) {
                context = this.a.get().getApplicationContext();
            }
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_RESULT);
            String optString = jSONObject.optString("msg");
            if (optInt != 0) {
                Logger.ww("WebViewHelper", "msg tpl load failed, code: " + optInt + ", errMsg: " + optString);
            }
            cn.jpush.android.p.a.a().a(context, this.c, optInt);
        } catch (Throwable th) {
            Logger.w("WebViewHelper", "[onLoadCallback] parse param error. " + th.getMessage());
        }
    }

    @JavascriptInterface
    public void reportData(String str) {
        try {
            Context context = JPushConstants.mApplicationContext;
            if (context == null && this.a.get() != null) {
                context = this.a.get().getApplicationContext();
            }
            Logger.d("WebViewHelper", "[reportData] report data: " + str);
            String optString = new JSONObject(str).optString("content");
            if (TextUtils.isEmpty(optString) || this.c == null) {
                return;
            }
            cn.jpush.android.p.a.a().a(context, this.c, optString);
        } catch (Throwable th) {
            Logger.w("WebViewHelper", "[reportData] report data failed. " + th.getMessage());
        }
    }

    @JavascriptInterface
    public void showTitleBar() {
        try {
            if (this.a.get() == null || !(this.a.get() instanceof PushActivity)) {
                return;
            }
            ((PushActivity) this.a.get()).showTitleBar();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void showToast(String str) {
        if (this.a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:showToast - " + str);
            Toast.makeText(this.a.get(), str, 1).show();
        }
    }

    @JavascriptInterface
    public void startActivityByIntent(String str, String str2) {
        Context context = JPushConstants.mApplicationContext;
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            intent.putExtra(JPushInterface.EXTRA_EXTRA, str2);
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            j.l.c.e0.a.a.a.h(intent);
            context.startActivity(intent);
        } catch (Throwable unused) {
            Logger.ee("WebViewHelper", "Unhandle intent : " + str);
        }
    }

    @JavascriptInterface
    public void startActivityByName(String str, String str2) {
        Logger.d("WebViewHelper", "activityName = " + str);
        try {
            if (TextUtils.isEmpty(str)) {
                Logger.ee("WebViewHelper", "The activity name is null or empty, Give up..");
            }
            Context context = JPushConstants.mApplicationContext;
            if (context == null) {
                return;
            }
            try {
                Intent intent = new Intent(context, Class.forName(str));
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                j.l.c.e0.a.a.a.h(intent);
                context.startActivity(intent);
            } catch (Exception unused) {
                Logger.ee("WebViewHelper", "The activity name is invalid, Give up..");
            }
        } catch (Throwable unused2) {
        }
    }

    @JavascriptInterface
    public void startMainActivity(String str) {
        Activity activity = this.a.get();
        if (activity == null) {
            return;
        }
        try {
            activity.finish();
            cn.jpush.android.ac.a.c(activity, str);
        } catch (Exception unused) {
            Logger.ee("WebViewHelper", "startMainActivity failed");
        }
    }

    @JavascriptInterface
    public void startPushActivity(String str) {
        try {
            Logger.d("WebViewHelper", "[startPushActivity]:" + str + ",activity:" + this.a.get());
            if (this.a.get() == null || !(this.a.get() instanceof PopWinActivity)) {
                return;
            }
            ((PopWinActivity) this.a.get()).startPushActivity(str);
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void triggerNativeAction(String str) {
        this.a.get();
    }
}
