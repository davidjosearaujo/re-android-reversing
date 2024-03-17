package cn.jpush.android.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.ac.e;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.webview.bridge.HostJsScope;
import com.alibaba.fastjson.asm.Label;
import com.facebook.common.util.UriUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import j.l.c.e0.a.a.a;
import j.l.c.e0.a.a.h;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SystemAlertHelper {
    private static int a = 400;
    private static int b = 600;
    private static ImageButton c;
    private static WindowManager d;
    private static WebView e;

    private static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            Logger.d("SystemAlertHelper", "width : " + displayMetrics.widthPixels);
            Logger.d("SystemAlertHelper", "height : " + displayMetrics.heightPixels);
            Logger.d("SystemAlertHelper", "density : " + displayMetrics.density);
            Logger.d("SystemAlertHelper", "densityDpi : " + displayMetrics.densityDpi);
            Logger.d("SystemAlertHelper", "xdpi : " + displayMetrics.xdpi);
            Logger.d("SystemAlertHelper", "ydpi : " + displayMetrics.ydpi);
            return displayMetrics;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, WindowManager windowManager, WebView webView, ImageButton imageButton) {
        int i;
        int i2;
        DisplayMetrics a2 = a(context);
        if (a2 != null) {
            int i3 = (a2.widthPixels * 3) / 4;
            a = i3;
            int i4 = a2.heightPixels / 2;
            b = i4;
            i = i3 / 2;
            i2 = -(i4 / 2);
        } else {
            i = 200;
            i2 = -300;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.gravity = 17;
        layoutParams.type = CommonConstant.RETCODE.SIGN_IN_PARAMS_ERROR;
        layoutParams.flags |= 552;
        layoutParams.width = a;
        layoutParams.height = b;
        layoutParams.x = -1;
        layoutParams.y = -1;
        h.a(webView, layoutParams);
        windowManager.addView(webView, layoutParams);
        imageButton.setBackgroundColor(context.getResources().getColor(17170445));
        imageButton.setImageBitmap(getImageFromAssetsFile(context, "jpush_close.png"));
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.y = i2;
        layoutParams.x = i;
        h.a(imageButton, layoutParams);
        windowManager.addView(imageButton, layoutParams);
    }

    public static void close() {
        WindowManager windowManager = d;
        if (windowManager == null) {
            return;
        }
        try {
            WebView webView = e;
            if (webView != null) {
                h.b(webView);
                windowManager.removeView(webView);
            }
            ImageButton imageButton = c;
            if (imageButton != null) {
                WindowManager windowManager2 = d;
                h.b(imageButton);
                windowManager2.removeView(imageButton);
            }
        } catch (Throwable unused) {
        }
        d = null;
        e = null;
        c = null;
    }

    public static Bitmap getImageFromAssetsFile(Context context, String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static int getWindowHeight() {
        return b;
    }

    public static int getWindowWidth() {
        return a;
    }

    public static void startActivityByName(WebView webView, String str, String str2) {
        Context appContext;
        Logger.d("SystemAlertHelper", "action --- startActivityByName--------activityName : " + str + "----- params : " + str2);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("SystemAlertHelper", "The activity name is null or empty, Give up..");
        }
        if (webView == null || (appContext = JPushConstants.getAppContext(webView.getContext())) == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                Intent intent = new Intent(webView.getContext(), cls);
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                a.h(intent);
                appContext.startActivity(intent);
                close();
            }
        } catch (Exception unused) {
            Logger.ee("SystemAlertHelper", "The activity name is invalid, Give up..");
        }
    }

    public static void systemAlert() {
    }

    public static void systemAlert(final Context context, final d dVar) {
        new Handler(Looper.getMainLooper()).post(new e("SystemAlertHelper#systemAlert") { // from class: cn.jpush.android.api.SystemAlertHelper.1
            @Override // cn.jpush.android.ac.e
            @SuppressLint({"NewApi"})
            public void a() {
                String str = dVar.V;
                if (TextUtils.isEmpty(str)) {
                    Logger.e("SystemAlertHelper", " not Rich Notification");
                    return;
                }
                WindowManager unused = SystemAlertHelper.d = (WindowManager) context.getSystemService("window");
                WebView unused2 = SystemAlertHelper.e = new WebView(context);
                ImageButton unused3 = SystemAlertHelper.c = new ImageButton(context);
                SystemAlertHelper.b(context, SystemAlertHelper.d, SystemAlertHelper.e, SystemAlertHelper.c);
                SystemAlertHelper.e.setHorizontalScrollBarEnabled(false);
                SystemAlertHelper.e.setVerticalScrollBarEnabled(false);
                SystemAlertHelper.e.setScrollbarFadingEnabled(true);
                SystemAlertHelper.e.setScrollBarStyle(33554432);
                cn.jpush.android.ac.a.a(SystemAlertHelper.e.getSettings());
                cn.jpush.android.ac.a.a(SystemAlertHelper.e);
                SystemAlertHelper.e.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
                SystemAlertHelper.e.setWebViewClient(new cn.jpush.android.ui.a(dVar, context));
                if (!TextUtils.isEmpty(str) && str.startsWith(UriUtil.HTTP_SCHEME)) {
                    SystemAlertHelper.e.loadUrl(str);
                }
                SystemAlertHelper.c.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.api.SystemAlertHelper.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SystemAlertHelper.close();
                    }
                });
            }
        });
    }
}
