package cn.com.custommma.mobile.tracking.viewability.webjs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.com.custommma.mobile.tracking.api.Countly;
import cn.com.custommma.mobile.tracking.bean.Company;
import cn.com.custommma.mobile.tracking.util.Logger;
import cn.com.custommma.mobile.tracking.util.klog.KLog;
import j.u.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbilityJsExplorer {
    private static final String JS_AUTHORTY_GETJSCACHEDATA = "getJSCacheData";
    private static final String JS_AUTHORTY_SAVEJSCACHEDATA = "saveJSCacheData";
    private static final String JS_AUTHORTY_STOPVIEWABILITY = "stopViewability";
    private static final String JS_INTERFACE_SENDCACHEMESSAGE = "javascript:sendCacheMessage";
    private static final String JS_INTERFACE_SENDMESSAGE = "javascript:sendViewabilityMessage";
    private static final String JS_PARAMS_ADVIEWABILITYID = "AdviewabilityID";
    private static final String JS_PARAMS_CLEAR = "clear";
    private static final String JS_PARAMS_DATA = "data";
    private static final String JS_SCHEME = "mmaViewabilitySDK";
    private String bridgeJs;
    private String companyName;
    private DataCacheManager dataCacheManager;
    private JSBridgeLoader jsBridgeLoader;
    private Context mContext;
    private WebView mWebView;
    private boolean isJavaScriptEnabled = false;
    private HashMap<String, ViewAbilityJsBean> monitorWorkers = new HashMap<>();
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class MyWebViewClient extends WebViewClient {
        private MyWebViewClient() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
            if (r2 == 1) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
            if (r2 == 2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
            onGetJSCacheData(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
            onSaveJSCacheData(r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean handlerWebJsMessage(android.webkit.WebView r8, java.lang.String r9) {
            /*
                r7 = this;
                android.net.Uri r0 = android.net.Uri.parse(r9)     // Catch: java.lang.Exception -> L71
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L71
                r1.<init>()     // Catch: java.lang.Exception -> L71
                java.lang.String r2 = "MyWebViewClient:handlerWebJsMessage:"
                r1.append(r2)     // Catch: java.lang.Exception -> L71
                r1.append(r0)     // Catch: java.lang.Exception -> L71
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L71
                cn.com.custommma.mobile.tracking.util.klog.KLog.d(r1)     // Catch: java.lang.Exception -> L71
                java.lang.String r1 = r0.getScheme()     // Catch: java.lang.Exception -> L71
                java.lang.String r2 = "mmaViewabilitySDK"
                boolean r1 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L71
                if (r1 == 0) goto L75
                java.lang.String r1 = r0.getAuthority()     // Catch: java.lang.Exception -> L71
                r2 = -1
                int r3 = r1.hashCode()     // Catch: java.lang.Exception -> L71
                r4 = -2140382874(0xffffffff806c5966, float:-9.950304E-39)
                r5 = 2
                r6 = 1
                if (r3 == r4) goto L54
                r4 = 180591085(0xac399ed, float:1.8835717E-32)
                if (r3 == r4) goto L4a
                r4 = 917049731(0x36a91183, float:5.038631E-6)
                if (r3 == r4) goto L3f
                goto L5e
            L3f:
                java.lang.String r3 = "stopViewability"
                boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L71
                if (r1 == 0) goto L5e
                r2 = 0
                goto L5e
            L4a:
                java.lang.String r3 = "getJSCacheData"
                boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L71
                if (r1 == 0) goto L5e
                r2 = 2
                goto L5e
            L54:
                java.lang.String r3 = "saveJSCacheData"
                boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L71
                if (r1 == 0) goto L5e
                r2 = 1
            L5e:
                if (r2 == 0) goto L6d
                if (r2 == r6) goto L69
                if (r2 == r5) goto L65
                goto L70
            L65:
                r7.onGetJSCacheData(r0)     // Catch: java.lang.Exception -> L71
                goto L70
            L69:
                r7.onSaveJSCacheData(r0)     // Catch: java.lang.Exception -> L71
                goto L70
            L6d:
                r7.onStopViewability(r0)     // Catch: java.lang.Exception -> L71
            L70:
                return r6
            L71:
                r0 = move-exception
                r0.printStackTrace()
            L75:
                boolean r8 = super.shouldOverrideUrlLoading(r8, r9)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityJsExplorer.MyWebViewClient.handlerWebJsMessage(android.webkit.WebView, java.lang.String):boolean");
        }

        private void onGetJSCacheData(Uri uri) {
            boolean booleanValue;
            if (Build.VERSION.SDK_INT >= 11) {
                booleanValue = uri.getBooleanQueryParameter(ViewAbilityJsExplorer.JS_PARAMS_CLEAR, false);
            } else {
                booleanValue = Boolean.valueOf(uri.getQueryParameter(ViewAbilityJsExplorer.JS_PARAMS_CLEAR)).booleanValue();
            }
            String data = ViewAbilityJsExplorer.this.dataCacheManager.getData(ViewAbilityJsExplorer.this.companyName);
            if (!TextUtils.isEmpty(data)) {
                String format = String.format("javascript:sendCacheMessage(JSON.stringify(%s))", data);
                KLog.d("onGetJSCacheData->clear:" + booleanValue + "  conetent:" + format);
                ViewAbilityJsExplorer.this.mWebView.loadUrl(format);
            }
            if (booleanValue) {
                ViewAbilityJsExplorer.this.dataCacheManager.clearData(ViewAbilityJsExplorer.this.companyName);
            }
        }

        private void onSaveJSCacheData(Uri uri) {
            String queryParameter = uri.getQueryParameter("data");
            if (!TextUtils.isEmpty(queryParameter)) {
                ViewAbilityJsExplorer.this.dataCacheManager.setData(ViewAbilityJsExplorer.this.companyName, queryParameter);
            } else {
                Logger.w("saveJSCacheData protocol params data is empty.");
            }
        }

        private void onStopViewability(Uri uri) throws Exception {
            String queryParameter = uri.getQueryParameter(ViewAbilityJsExplorer.JS_PARAMS_ADVIEWABILITYID);
            if (!TextUtils.isEmpty(queryParameter)) {
                ViewAbilityJsBean viewAbilityJsBean = (ViewAbilityJsBean) ViewAbilityJsExplorer.this.monitorWorkers.get(queryParameter);
                if (viewAbilityJsBean != null) {
                    viewAbilityJsBean.setCompleted(true);
                }
                if (Countly.LOCAL_TEST) {
                    ViewAbilityJsExplorer.this.mContext.sendBroadcast(new Intent(Countly.ACTION_STATS_SUCCESSED));
                    return;
                }
                return;
            }
            Logger.w("stopViewability protocol params adviewabilityid is empty.");
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            if (ViewAbilityJsExplorer.this.mContext instanceof Activity) {
                if (((Activity) ViewAbilityJsExplorer.this.mContext).isDestroyed() || ((Activity) ViewAbilityJsExplorer.this.mContext).isFinishing()) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewAbilityJsExplorer.this.mContext);
                builder.setMessage(b.p.mgmi_ssl_error);
                builder.setPositiveButton(b.p.mgmi_common_confim, new DialogInterface.OnClickListener() { // from class: cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityJsExplorer.MyWebViewClient.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sslErrorHandler.proceed();
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton(b.p.mgmi_common_cancel, new DialogInterface.OnClickListener() { // from class: cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityJsExplorer.MyWebViewClient.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sslErrorHandler.cancel();
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
                return;
            }
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return handlerWebJsMessage(webView, str);
        }
    }

    public ViewAbilityJsExplorer(Context context, Company company) {
        this.mContext = context;
        this.dataCacheManager = DataCacheManager.getInstance(this.mContext);
        this.companyName = company.name;
        JSBridgeLoader jSBridgeLoader = new JSBridgeLoader(context, company);
        this.jsBridgeLoader = jSBridgeLoader;
        this.bridgeJs = jSBridgeLoader.getBridgeJs();
        this.jsBridgeLoader.doUpdate();
        initWebViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initJavaScripts() {
        this.mWebView.loadDataWithBaseURL(null, String.format("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n    <meta charset=\"UTF-8\">\n  <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n  <div id=\"mian\" style=\"width:%dpx;height:%dpx;\">\n <script type=\"text/javascript\">%s</script>\n</div>\n</body>\n</html>", 1, 1, this.bridgeJs), "text/html", "utf-8", null);
    }

    private void initWebViews() {
        this.mainHandler.post(new Runnable() { // from class: cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityJsExplorer.1
            @Override // java.lang.Runnable
            public void run() {
                ViewAbilityJsExplorer.this.mWebView = new WebView(ViewAbilityJsExplorer.this.mContext);
                WebSettings settings = ViewAbilityJsExplorer.this.mWebView.getSettings();
                try {
                    settings.setJavaScriptEnabled(true);
                    settings.setJavaScriptCanOpenWindowsAutomatically(false);
                    settings.setDomStorageEnabled(false);
                    settings.setCacheMode(2);
                    settings.setAllowFileAccess(false);
                    settings.setUseWideViewPort(false);
                    settings.setLoadWithOverviewMode(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ViewAbilityJsExplorer.this.mWebView.clearHistory();
                ViewAbilityJsExplorer.this.mWebView.clearCache(true);
                ViewAbilityJsExplorer.this.isJavaScriptEnabled = settings.getJavaScriptEnabled();
                ViewAbilityJsExplorer.this.mWebView.setWebViewClient(new MyWebViewClient());
                ViewAbilityJsExplorer.this.initJavaScripts();
            }
        });
    }

    public void addExplorerTask(String str, View view, boolean z) {
        if (TextUtils.isEmpty(this.bridgeJs)) {
            this.jsBridgeLoader.doUpdate();
        }
        ViewAbilityJsBean viewAbilityJsBean = new ViewAbilityJsBean(str, view);
        viewAbilityJsBean.setVideo(z);
        this.monitorWorkers.put(viewAbilityJsBean.getAdviewabilityId(), viewAbilityJsBean);
        Logger.d("URL:" + str + " 开启View Ability JS 监测,监测ID:" + viewAbilityJsBean.getAdviewabilityId());
        if (Countly.LOCAL_TEST) {
            this.mContext.sendBroadcast(new Intent(Countly.ACTION_STATS_VIEWABILITY));
        }
    }

    public void onDestory() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.mWebView.clearHistory();
            this.mWebView.clearCache(true);
            ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    public void onExplore() {
        try {
            if (this.isJavaScriptEnabled) {
                this.mainHandler.post(new Runnable() { // from class: cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityJsExplorer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (ViewAbilityJsExplorer.this.mWebView != null || ViewAbilityJsExplorer.this.mWebView.getUrl() != null) {
                                if (ViewAbilityJsExplorer.this.monitorWorkers.isEmpty()) {
                                    return;
                                }
                                ArrayList<String> arrayList = new ArrayList();
                                JSONArray jSONArray = new JSONArray();
                                Iterator it = ViewAbilityJsExplorer.this.monitorWorkers.keySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    ViewAbilityJsBean viewAbilityJsBean = (ViewAbilityJsBean) ViewAbilityJsExplorer.this.monitorWorkers.get((String) it.next());
                                    if (viewAbilityJsBean.isCompleted()) {
                                        arrayList.add(viewAbilityJsBean.getAdviewabilityId());
                                    } else {
                                        jSONArray.put(viewAbilityJsBean.generateUploadEvents(ViewAbilityJsExplorer.this.mContext, viewAbilityJsBean.getAdView() == null));
                                    }
                                }
                                for (String str : arrayList) {
                                    ViewAbilityJsExplorer.this.monitorWorkers.remove(str);
                                }
                                if (jSONArray.length() > 0) {
                                    ViewAbilityJsExplorer.this.mWebView.loadUrl(String.format("javascript:sendViewabilityMessage(%s)", jSONArray.toString()));
                                    return;
                                }
                                return;
                            }
                            Logger.w("The webview is initializing,and this monitoring frame is discarded.");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
