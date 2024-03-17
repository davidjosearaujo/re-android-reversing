package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.ac.e;
import cn.jpush.android.ac.g;
import cn.jpush.android.ac.i;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.webview.bridge.HostJsScope;
import cn.jpush.android.webview.bridge.d;
import java.io.File;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c extends ProxyActivityAction {
    public static d a;
    private String d;
    private WebView f;
    private RelativeLayout g;
    private TextView h;
    private ImageButton i;
    private ProgressBar j;
    private a k;
    private int b = 0;
    private boolean c = false;
    private boolean e = false;
    private View.OnClickListener l = new View.OnClickListener() { // from class: cn.jpush.android.ui.c.2
        {
            c.this = this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                try {
                    if (view.getContext() == null || !(view.getContext() instanceof Activity)) {
                        return;
                    }
                    ((Activity) view.getContext()).onBackPressed();
                } catch (Throwable unused) {
                }
            }
        }
    };

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d a2 = cn.jpush.android.x.c.a(activity, activity.getIntent());
        if (a2 != null) {
            return a2;
        }
        Logger.dd("PushActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        Logger.d("PushActivityImpl", "content:" + uri);
        return cn.jpush.android.ab.b.a(activity, uri, "");
    }

    private void a(Activity activity, cn.jpush.android.d.d dVar) {
        if (dVar == null) {
            Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
        } else if (dVar.q == 0) {
            activity.setRequestedOrientation(1);
            b(activity, dVar);
            return;
        } else {
            Logger.w("PushActivityImpl", "Invalid msg type to show - " + dVar.q);
            cn.jpush.android.x.c.e(activity, dVar);
        }
        activity.finish();
    }

    private void b() {
        try {
            g.a(this.f, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{a, "JPushWeb"});
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.e("PushActivityImpl", "addJavascriptInterface failed:" + th.toString());
        }
    }

    private void b(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                this.c = activity.getIntent().getBooleanExtra(PushActivity.FROM_OTHER_WAY, false);
                cn.jpush.android.d.d a2 = a(activity, activity.getIntent());
                if (a2 != null) {
                    this.d = a2.c;
                    this.e = !TextUtils.isEmpty(a2.bb);
                    a(activity, a2);
                    cn.jpush.android.k.a.a(activity);
                    if (this.e) {
                        cn.jpush.android.helper.c.a(this.d, 1311, String.format(Locale.ENGLISH, "{\"url\":\"%s\"}", a2.V), activity.getApplicationContext());
                    }
                } else {
                    Logger.ww("PushActivityImpl", "Warning，null message entity! Close PushActivity!");
                    activity.finish();
                }
                return;
            } catch (Throwable th) {
                Logger.ee("PushActivityImpl", "Extra data is not serializable!");
                th.printStackTrace();
            }
        } else {
            Logger.ww("PushActivityImpl", "PushActivity get NULL intent!");
        }
        activity.finish();
    }

    private void b(Activity activity, cn.jpush.android.d.d dVar) {
        String str;
        Logger.i("PushActivityImpl", "Action: processShow");
        if (dVar != null) {
            if (dVar.aa == 0) {
                this.b = dVar.Y;
                int identifier = activity.getResources().getIdentifier("jpush_webview_layout", "layout", activity.getPackageName());
                if (identifier == 0) {
                    str = "Please add layout resource jpush_webview_layout.xml to res/layout !";
                } else {
                    activity.setContentView(identifier);
                    String str2 = dVar.V;
                    if (cn.jpush.android.ac.a.c(str2)) {
                        String str3 = dVar.X;
                        if (dVar.r) {
                            int identifier2 = activity.getResources().getIdentifier("actionbarLayoutId", "id", activity.getPackageName());
                            if (identifier2 == 0) {
                                str = "Please use default code in jpush_webview_layout.xml!";
                            } else {
                                View findViewById = activity.findViewById(identifier2);
                                if (findViewById != null) {
                                    a(activity, findViewById, dVar);
                                    if (TextUtils.isEmpty(str3) || !new File(str3.replace("file://", "")).exists() || this.c) {
                                        this.f.loadUrl(str2);
                                    } else {
                                        this.f.loadUrl(str3);
                                    }
                                }
                            }
                        }
                        if (!this.c && !this.e) {
                            cn.jpush.android.helper.c.a(this.d, 1000, activity.getApplicationContext());
                        }
                    } else {
                        cn.jpush.android.x.c.e(activity, dVar);
                    }
                }
                Logger.ee("PushActivityImpl", str);
            }
            int i = dVar.Z;
            return;
        }
        Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
        activity.finish();
    }

    private void c(Activity activity) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags &= -1025;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().clearFlags(512);
        } catch (Throwable unused) {
            Logger.w("PushActivityImpl", "quitFullScreen errno");
        }
    }

    public void a() {
        try {
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
                return;
            }
            this.g.setVisibility(0);
            c((Activity) this.g.getContext());
            this.i.setOnClickListener(this.l);
            WebView webView = this.f;
            if (webView != null) {
                webView.postDelayed(new e("PushActivityImpl#showTitleBar") { // from class: cn.jpush.android.ui.c.3
                    {
                        c.this = this;
                    }

                    @Override // cn.jpush.android.ac.e
                    public void a() {
                        try {
                            if (c.this.f != null) {
                                c.this.f.clearHistory();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, 1000L);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Activity activity) {
        activity.finish();
        if (1 == this.b) {
            try {
                ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
                ComponentName componentName = activityManager.getRunningTasks(1).get(0).baseActivity;
                ComponentName componentName2 = activityManager.getRunningTasks(1).get(0).topActivity;
                Logger.d("PushActivityImpl", "baseActivity  = " + componentName.toString());
                Logger.d("PushActivityImpl", "topActivity  = " + componentName2.toString());
                if (componentName == null || componentName2 == null || !componentName2.toString().equals(componentName.toString())) {
                    return;
                }
                cn.jpush.android.ac.a.f(activity);
            } catch (Throwable unused) {
                Logger.ww("PushActivityImpl", "Get running tasks failed.");
                cn.jpush.android.ac.a.f(activity);
            }
        }
    }

    public void a(Activity activity, View view, cn.jpush.android.d.d dVar) {
        try {
            String str = dVar.W;
            view.setFocusable(true);
            int identifier = activity.getResources().getIdentifier("fullWebView", "id", activity.getPackageName());
            if (identifier > 0) {
                ((LinearLayout) view).removeView(activity.findViewById(identifier));
            }
            WebView webView = new WebView(activity.getApplicationContext());
            this.f = webView;
            webView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f.setBackgroundColor(Color.parseColor("#000000"));
            ((LinearLayout) view).addView(this.f);
            this.g = (RelativeLayout) activity.findViewById(activity.getResources().getIdentifier("rlRichpushTitleBar", "id", activity.getPackageName()));
            this.h = (TextView) activity.findViewById(activity.getResources().getIdentifier("tvRichpushTitle", "id", activity.getPackageName()));
            this.i = (ImageButton) activity.findViewById(activity.getResources().getIdentifier("imgRichpushBtnBack", "id", activity.getPackageName()));
            this.j = (ProgressBar) activity.findViewById(activity.getResources().getIdentifier("pushPrograssBar", "id", activity.getPackageName()));
            if (this.f == null || this.g == null || this.h == null || this.i == null) {
                Logger.ee("PushActivityImpl", "Please use default code in jpush_webview_layout.xml!");
                activity.finish();
            }
            if (1 == dVar.Z) {
                this.g.setVisibility(8);
                activity.getWindow().setFlags(1024, 1024);
            } else {
                this.h.setText(str);
                this.i.setOnClickListener(this.l);
                i.a(activity.getApplicationContext(), this.i, true, 10, 6, 10, 6);
            }
            this.f.setScrollbarFadingEnabled(true);
            this.f.setScrollBarStyle(33554432);
            WebSettings settings = this.f.getSettings();
            settings.setAllowFileAccess(true);
            cn.jpush.android.ac.a.a(settings);
            cn.jpush.android.ac.a.a(this.f);
            settings.setSavePassword(false);
            a = new d(activity, dVar);
            if (Build.VERSION.SDK_INT >= 17) {
                Logger.dd("PushActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
                b();
            }
            this.f.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, this.j, this.h));
            a aVar = new a(dVar, activity);
            this.k = aVar;
            aVar.a(this.e);
            this.f.setWebViewClient(this.k);
            HostJsScope.setWebViewHelper(a);
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        WebView webView = this.f;
        if (webView != null && webView.canGoBack()) {
            this.f.goBack();
            return;
        }
        cn.jpush.android.helper.c.a(this.d, this.e ? 1251 : 1006, activity);
        a(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.ac.a.e(activity);
        b(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        if (this.f != null) {
            if (this.e && !TextUtils.isEmpty(this.d) && activity != null) {
                a aVar = this.k;
                cn.jpush.android.helper.c.a(this.d, 1313, String.format(Locale.ENGLISH, "{\"url\":\"%s\"}", aVar != null ? aVar.a() : ""), activity.getApplicationContext());
            }
            ViewParent parent = this.f.getParent();
            if (parent != null) {
                Logger.d("PushActivityImpl", "webview parent view " + parent.toString());
                ((ViewGroup) parent).removeView(this.f);
            }
            this.f.getSettings().setJavaScriptEnabled(false);
            this.f.clearCache(true);
            this.f.clearHistory();
            this.f.clearView();
            this.f.removeAllViews();
            this.f.clearSslPreferences();
            this.f.destroy();
            this.f = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || !str.equals("push_show_titlebar")) {
            return;
        }
        activity.runOnUiThread(new e("PushActivityImpl#onEvent") { // from class: cn.jpush.android.ui.c.1
            {
                c.this = this;
            }

            @Override // cn.jpush.android.ac.e
            public void a() {
                c.this.a();
            }
        });
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
        activity.setIntent(intent);
        b(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        WebView webView = this.f;
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
        WebView webView = this.f;
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
