package cn.jpush.android.webview.bridge;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.common.util.UriUtil;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends b {
    private ProgressBar a;
    private TextView b;

    public a(String str, Class cls, ProgressBar progressBar, TextView textView) {
        super(str, cls);
        this.a = progressBar;
        this.b = textView;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setSingleLine(true);
            this.b.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        ProgressBar progressBar = this.a;
        boolean z = false;
        if (progressBar != null) {
            if (100 == i) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                this.a.setProgress(i);
            }
        }
        if (this.b == null || webView.getTitle() == null || webView.getTitle().equals(this.b.getText())) {
            return;
        }
        String title = webView.getTitle();
        if ((title.startsWith(UriUtil.HTTP_SCHEME) || title.startsWith("android-app://") || title.startsWith("file://")) ? true : true) {
            return;
        }
        this.b.setText(webView.getTitle());
    }
}
