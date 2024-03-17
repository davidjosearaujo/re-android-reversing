package cn.jpush.android.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.alibaba.fastjson.asm.Label;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.hunantv.imgo.entity.JumpAction;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends WebViewClient {
    private final d a;
    private final Context b;
    private boolean c = false;
    private String d = "";
    private boolean f = false;
    private Queue<String> e = new PriorityQueue();

    public a(d dVar, Context context) {
        this.a = dVar;
        this.b = context;
    }

    private void a(String str, int i, int i2) {
        d dVar;
        String d;
        try {
            if (!this.f || (dVar = this.a) == null || TextUtils.isEmpty(dVar.bb)) {
                return;
            }
            String str2 = this.a.c;
            if (TextUtils.isEmpty(str2)) {
                d = "";
            } else {
                d = cn.jpush.android.ac.a.d(str2 + i2 + i);
            }
            if (TextUtils.isEmpty(d) || this.e.contains(d)) {
                return;
            }
            this.e.add(d);
            cn.jpush.android.helper.c.a(str2, i, String.format(Locale.ENGLISH, "{\"url\":\"%s\", \"err_code\":\"%d\"}", str, Integer.valueOf(i2)), this.b);
        } catch (Throwable unused) {
            Logger.w("JPushWebViewClient", "report code failed");
        }
    }

    private boolean a(String str) {
        boolean z = false;
        try {
            Intent parseUri = str.startsWith("android-app://") ? Build.VERSION.SDK_INT >= 22 ? Intent.parseUri(str, 2) : null : Intent.parseUri(str, 1);
            Context context = this.b;
            if (context != null && parseUri != null) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && packageManager.resolveActivity(parseUri, 0) == null) {
                    Logger.w("JPushWebViewClient", "open deeplink intent can be not resolved, url: " + str);
                    return true;
                }
                parseUri.addCategory("android.intent.category.BROWSABLE");
                if (!str.startsWith("android-app://")) {
                    parseUri.setComponent(null);
                }
                Intent parseUri2 = Intent.parseUri(str, 0);
                parseUri2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                Context context2 = this.b;
                j.l.c.e0.a.a.a.h(parseUri2);
                context2.startActivity(parseUri2);
                Logger.d("JPushWebViewClient", "h5 open deeplink success, url: " + str);
            }
            z = true;
        } catch (Throwable th) {
            Logger.w("JPushWebViewClient", "[openDeeplink] Bad URI " + str + ": " + th.getMessage());
        }
        int i = TextUtils.isEmpty(this.a.bb) ? 976 : 1214;
        if (!z) {
            i = TextUtils.isEmpty(this.a.bb) ? 977 : 1215;
        }
        cn.jpush.android.helper.c.a(this.a.c, i, this.b);
        return z;
    }

    public String a() {
        return this.d;
    }

    public void a(boolean z) {
        this.f = z;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.d = str;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        a(str, 1312, 0);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        a(str2, 1314, i);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            a(webResourceRequest.getUrl().toString(), 1314, webResourceError.getErrorCode());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (Build.VERSION.SDK_INT >= 21) {
            a(webResourceRequest.getUrl().toString(), 1314, 101);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(sslError.getUrl(), 1314, 102);
        }
        Logger.ww("JPushWebViewClient", "onReceivedSslError stop show:" + webView.getUrl());
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        StringBuilder sb;
        Context context = webView.getContext();
        Logger.i("JPushWebViewClient", "Url vaule is :" + str);
        try {
            webView.getSettings().setSavePassword(false);
            cn.jpush.android.ac.a.a(webView);
            String format = String.format(Locale.ENGLISH, "{\"url\":\"%s\"}", str);
            if (str.endsWith(".mp3")) {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.setDataAndType(Uri.parse(str), "audio/*");
                Context context2 = webView.getContext();
                j.l.c.e0.a.a.a.h(intent);
                context2.startActivity(intent);
                return true;
            }
            if (!str.endsWith(".mp4") && !str.endsWith(".3gp")) {
                if (str.endsWith(".apk")) {
                    Logger.dd("JPushWebViewClient", "google play not allowed");
                    return true;
                }
                int i = 1016;
                if (str.startsWith(UriUtil.HTTP_SCHEME)) {
                    if (!TextUtils.isEmpty(this.a.bb)) {
                        i = 1252;
                    }
                    cn.jpush.android.helper.c.a(this.a.c, i, format, this.b);
                    return false;
                } else if (str.startsWith("mailto")) {
                    if (str.lastIndexOf("direct=") < 0 && !str.startsWith("mailto")) {
                        if (str.indexOf(JumpAction.STR_ACTION_SPLIT) > 0) {
                            sb = new StringBuilder();
                            sb.append(str);
                            sb.append("&direct=false");
                        } else {
                            sb = new StringBuilder();
                            sb.append(str);
                            sb.append("?direct=false");
                        }
                        str = sb.toString();
                        str.lastIndexOf("direct=");
                    }
                    int indexOf = str.indexOf(JumpAction.STR_ACTION_SPLIT);
                    String substring = str.substring(0, indexOf);
                    String substring2 = str.substring(indexOf);
                    Logger.v("JPushWebViewClient", "Uri: " + substring);
                    Logger.v("JPushWebViewClient", "QueryString: " + substring2);
                    Intent intent2 = null;
                    if (substring.startsWith("mailto")) {
                        String[] split = substring.split(CertificateUtil.DELIMITER);
                        if (split.length == 2) {
                            int indexOf2 = substring2.indexOf("&content=");
                            String substring3 = substring2.substring(substring2.indexOf("title=") + 6, indexOf2);
                            String substring4 = substring2.substring(indexOf2 + 9);
                            String[] strArr = {split[1]};
                            Intent intent3 = new Intent("android.intent.action.SEND");
                            intent3.setType("plain/text");
                            intent3.putExtra("android.intent.extra.EMAIL", strArr);
                            intent3.putExtra("android.intent.extra.SUBJECT", substring3);
                            intent3.putExtra("android.intent.extra.TEXT", substring4);
                            intent2 = intent3;
                        }
                    }
                    if (intent2 != null) {
                        j.l.c.e0.a.a.a.h(intent2);
                        context.startActivity(intent2);
                    }
                    cn.jpush.android.helper.c.a(this.a.c, 1016, format, JPushConstants.mApplicationContext);
                    return true;
                } else {
                    return a(str);
                }
            }
            Intent intent4 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent4.setDataAndType(Uri.parse(str), "video/*");
            Context context3 = webView.getContext();
            j.l.c.e0.a.a.a.h(intent4);
            context3.startActivity(intent4);
            return true;
        } catch (Throwable unused) {
            Logger.e("JPushWebViewClient", "Invalid url");
            return true;
        }
    }
}
