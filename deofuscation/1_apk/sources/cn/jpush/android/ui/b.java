package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.ac.g;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.webview.bridge.HostJsScope;
import cn.jpush.android.webview.bridge.d;
import java.io.File;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends ProxyActivityAction {
    public static d a;
    private String b;
    private WebView c;
    private cn.jpush.android.d.d d = null;

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d a2 = cn.jpush.android.x.c.a(activity.getApplicationContext(), activity.getIntent());
        if (a2 != null) {
            return a2;
        }
        Logger.dd("PopWinActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        return cn.jpush.android.ab.b.a(activity, uri, "");
    }

    private void a() {
        try {
            g.a(this.c, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{a, "JPushWeb"});
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.e("PopWinActivityImpl", "addJavascriptInterface failed:" + th.toString());
        }
    }

    private void a(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                cn.jpush.android.d.d a2 = a(activity, activity.getIntent());
                this.d = a2;
                if (a2 != null) {
                    this.b = a2.c;
                    b(activity);
                    c(activity);
                    cn.jpush.android.k.a.a(activity);
                } else {
                    Logger.ww("PopWinActivityImpl", "Warning，null message entity! Close PopWinActivity!");
                    activity.finish();
                }
                return;
            } catch (Throwable th) {
                Logger.ee("PopWinActivityImpl", "Extra data is not serializable!");
                th.printStackTrace();
            }
        } else {
            Logger.ww("PopWinActivityImpl", "PopWinActivity get NULL intent!");
        }
        activity.finish();
    }

    private void b(Activity activity) {
        int identifier = activity.getResources().getIdentifier("jpush_popwin_layout", "layout", activity.getPackageName());
        if (identifier == 0) {
            Logger.ee("PopWinActivityImpl", "Please add layout resource jpush_popwin_layout.xml to res/layout !");
            activity.finish();
            return;
        }
        activity.setContentView(identifier);
        int identifier2 = activity.getResources().getIdentifier("wvPopwin", "id", activity.getPackageName());
        if (identifier2 == 0) {
            Logger.ee("PopWinActivityImpl", "Please use default code in jpush_popwin_layout.xml!");
            activity.finish();
            return;
        }
        WebView webView = (WebView) activity.findViewById(identifier2);
        this.c = webView;
        if (webView == null) {
            Logger.ee("PopWinActivityImpl", "Can not get webView in layout file!");
            activity.finish();
            return;
        }
        webView.setScrollbarFadingEnabled(true);
        this.c.setScrollBarStyle(33554432);
        WebSettings settings = this.c.getSettings();
        settings.setAllowFileAccess(true);
        settings.setDomStorageEnabled(true);
        cn.jpush.android.ac.a.a(settings);
        cn.jpush.android.ac.a.a(this.c);
        settings.setSavePassword(false);
        this.c.setBackgroundColor(0);
        a = new d(activity, this.d);
        if (Build.VERSION.SDK_INT >= 17) {
            Logger.dd("PopWinActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
            a();
        }
        this.c.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
        this.c.setWebViewClient(new a(this.d, activity));
        HostJsScope.setWebViewHelper(a);
    }

    private void c(Activity activity) {
        cn.jpush.android.d.d dVar = this.d;
        String str = dVar.X;
        String str2 = dVar.V;
        Logger.d("PopWinActivityImpl", "showUrl = " + str2);
        if (TextUtils.isEmpty(str) || !new File(str.replace("file://", "")).exists()) {
            this.c.loadUrl(str2);
        } else {
            this.c.loadUrl(str);
        }
        cn.jpush.android.helper.c.a(this.b, 1000, activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        cn.jpush.android.helper.c.a(this.b, 1006, activity.getApplicationContext());
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.ac.a.e(activity);
        a(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        WebView webView = this.c;
        if (webView != null) {
            webView.removeAllViews();
            this.c.destroy();
            this.c = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || !str.equals("start_push_activity") || this.d == null || this.c == null) {
            return;
        }
        String string = bundle.getString("url");
        if (!TextUtils.isEmpty(string)) {
            this.d.V = string;
            Intent intent = new Intent(activity, PushActivity.class);
            intent.putExtra("msg_data", this.d.c());
            intent.putExtra(PushActivity.FROM_OTHER_WAY, true);
            intent.setFlags(335544320);
            j.l.c.e0.a.a.a.h(intent);
            activity.startActivity(intent);
        }
        activity.finish();
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        WebView webView = this.c;
        if (webView == null || Build.VERSION.SDK_INT < 11) {
            return;
        }
        webView.onPause();
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onRestart(Activity activity) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onResume(Activity activity) {
        WebView webView = this.c;
        if (webView != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                webView.onResume();
            }
            HostJsScope.setWebViewHelper(a);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStart(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStop(Activity activity) {
    }
}
