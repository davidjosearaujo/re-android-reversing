package cn.jpush.android.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.ac.g;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.l;
import cn.jpush.android.webview.bridge.HostJsScope;
import com.alibaba.fastjson.JSONStreamContext;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import j.l.c.e0.a.a.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public final cn.jpush.android.u.e a;
    public a b;
    private final l c;
    private WebView d;
    private cn.jpush.android.webview.bridge.d e;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void a(Context context, View view, Object obj);
    }

    public c(l lVar, cn.jpush.android.u.e eVar) {
        this.c = lVar;
        this.a = eVar;
    }

    private void g() {
        try {
            g.a(this.d, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{this.e, "JPushWeb"});
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.e("InAppBindingWrapper", "addJavascriptInterface failed:" + th.toString());
        }
    }

    public WindowManager.LayoutParams a(Context context, l lVar, boolean z, WindowManager windowManager, View view) {
        if (lVar != null && context != null) {
            try {
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(lVar.d(), lVar.e(), z ? Build.VERSION.SDK_INT >= 26 ? 2038 : CommonConstant.RETCODE.SIGN_IN_PARAMS_ERROR : JSONStreamContext.PropertyValue, lVar.b() | 131072 | 32 | 8, -3);
                layoutParams.x = lVar.o();
                layoutParams.y = lVar.n();
                layoutParams.dimAmount = 0.3f;
                layoutParams.gravity = lVar.c();
                layoutParams.windowAnimations = 0;
                Logger.d("InAppBindingWrapper", "dialog view layout param, gravity: " + lVar.c() + ", margin_x: " + lVar.o() + ", margin_y: " + lVar.n());
                h.a(view, layoutParams);
                windowManager.addView(view, layoutParams);
                return layoutParams;
            } catch (Throwable th) {
                Logger.w("InAppBindingWrapper", "[getLayoutParams] error." + th.getMessage());
            }
        }
        h.a(view, (ViewGroup.LayoutParams) null);
        windowManager.addView(view, null);
        return null;
    }

    public void a() {
        try {
            WebView webView = this.d;
            if (webView != null) {
                ViewParent parent = webView.getParent();
                if (parent != null) {
                    Logger.d("InAppBindingWrapper", "webview parent view " + parent.toString());
                    ((ViewGroup) parent).removeView(this.d);
                }
                this.d.getSettings().setJavaScriptEnabled(false);
                this.d.clearCache(true);
                this.d.clearHistory();
                this.d.clearView();
                this.d.removeAllViews();
                this.d.clearSslPreferences();
                this.d.destroy();
                this.d = null;
                Logger.d("InAppBindingWrapper", "webview release completed.");
            }
        } catch (Throwable th) {
            Logger.w("InAppBindingWrapper", "web view destroy failed. error: " + th.getMessage());
        }
    }

    public void a(Context context) {
        this.a.v = System.currentTimeMillis();
    }

    public void a(WindowManager windowManager, Context context) {
        a(context);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public View b() {
        return null;
    }

    public void b(Context context) {
    }

    public cn.jpush.android.u.e c() {
        return this.a;
    }

    public boolean c(Context context) {
        return true;
    }

    public View d() {
        return this.d;
    }

    public boolean d(Context context) {
        String str;
        if (context == null) {
            str = "unexpected error, context is null";
        } else {
            try {
                cn.jpush.android.u.e eVar = this.a;
                if (eVar == null) {
                    Logger.w("InAppBindingWrapper", "unexpected error, message is null");
                    return false;
                }
                String r = eVar.r();
                if (TextUtils.isEmpty(r)) {
                    Logger.w("InAppBindingWrapper", "in-app message web page url is empty, webview inflate failed.");
                    return false;
                }
                Logger.i("InAppBindingWrapper", "webview inflate, templateData: " + this.a.s());
                if (this.d == null) {
                    WebView webView = new WebView(context);
                    this.d = webView;
                    webView.setBackgroundColor(context.getResources().getColor(17170445));
                    Logger.d("InAppBindingWrapper", "create web view xxxxx");
                }
                this.d.setHorizontalScrollBarEnabled(false);
                this.d.setVerticalScrollBarEnabled(false);
                this.d.setScrollbarFadingEnabled(true);
                this.d.setScrollBarStyle(33554432);
                WebSettings settings = this.d.getSettings();
                settings.setAllowFileAccess(true);
                cn.jpush.android.ac.a.a(settings);
                cn.jpush.android.ac.a.a(this.d);
                cn.jpush.android.d.d u = this.a.u();
                cn.jpush.android.webview.bridge.d dVar = new cn.jpush.android.webview.bridge.d(null, u);
                this.e = dVar;
                dVar.a(this.a);
                if (Build.VERSION.SDK_INT >= 17) {
                    Logger.dd("InAppBindingWrapper", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
                    g();
                }
                this.d.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
                this.d.setWebViewClient(new cn.jpush.android.ui.a(u, context));
                HostJsScope.setWebViewHelper(this.e);
                this.d.loadUrl(r);
                Logger.d("InAppBindingWrapper", "in-app message webview load url completed. visibility: " + this.d.getVisibility() + ", url: " + r);
                return true;
            } catch (Throwable th) {
                str = "webview inflate failed. " + th.getMessage();
            }
        }
        Logger.w("InAppBindingWrapper", str);
        return false;
    }

    public cn.jpush.android.webview.bridge.d e() {
        return this.e;
    }

    public l f() {
        return this.c;
    }
}
