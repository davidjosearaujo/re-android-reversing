package cn.jpush.android.webview.bridge;

import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import cn.jpush.android.helper.Logger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends WebChromeClient {
    private final String a = "InjectedChromeClient";
    private c b;
    private boolean c;

    public b(String str, Class cls) {
        this.b = new c(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (Build.VERSION.SDK_INT < 17) {
            jsPromptResult.confirm(this.b.a(webView, str2));
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        webView.getSettings().setSavePassword(false);
        if (Build.VERSION.SDK_INT < 17) {
            if (i <= 25) {
                this.c = false;
            } else if (!this.c) {
                Logger.dd("InjectedChromeClient", "Android sdk version lesser than 17, Java—Js interact by injection!");
                webView.loadUrl(this.b.a());
                this.c = true;
                Logger.d("InjectedChromeClient", " inject js interface completely on progress " + i);
            }
        }
        super.onProgressChanged(webView, i);
    }
}
