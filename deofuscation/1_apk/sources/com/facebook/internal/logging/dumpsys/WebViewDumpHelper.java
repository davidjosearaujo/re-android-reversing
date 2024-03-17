package com.facebook.internal.logging.dumpsys;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.security.CertificateUtil;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import n.b0;
import n.l2.v.f0;
import n.l2.v.s0;
import n.u2.u;
import r.e.a.d;

/* compiled from: WebViewDumpHelper.kt */
@b0(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper;", "", "()V", "webViewHTMLs", "", "", "webViews", "", "Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper$WebViewData;", "dump", "", "writer", "Ljava/io/PrintWriter;", "handle", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "Companion", "WebViewData", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"NewApi", "StringFormatUse", "DefaultLocale", "BadMethodUse-java.lang.String.length"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class WebViewDumpHelper {
    @d
    public static final Companion Companion = new Companion(null);
    @d
    public static final String GET_WEBVIEW_HTML_JS_SCRIPT = "(function() {  try {    const leftOf = %d;    const topOf = %d;    const density = %f;    const elements = Array.from(document.querySelectorAll('body, body *'));    for (const el of elements) {      const rect = el.getBoundingClientRect();      const left = Math.round(leftOf + rect.left * density);      const top = Math.round(topOf + rect.top * density);      const width = Math.round(rect.width * density);      const height = Math.round(rect.height * density);      el.setAttribute('data-rect', `${left},${top},${width},${height}`);      const style = window.getComputedStyle(el);      const hidden = style.display === 'none' || style.visibility !== 'visible' || el.getAttribute('hidden') === 'true';      const disabled = el.disabled || el.getAttribute('aria-disabled') === 'true';      const focused = el === document.activeElement;      if (hidden || disabled || focused) {        el.setAttribute('data-flag', `${hidden ? 'H' : ''}${disabled ? 'D' : ''}${focused ? 'F' : ''}`);      } else {        el.removeAttribute('data-flag');      }    }    document.activeElement.setAttribute('focused', 'true');    const doc = document.cloneNode(true);    for (const el of Array.from(doc.querySelectorAll('script, link'))) {      el.remove();    }    for (const el of Array.from(doc.querySelectorAll('*'))) {      el.removeAttribute('class');    }    return doc.getElementsByTagName('body')[0].outerHTML.trim();  } catch (e) {    return 'Failed: ' + e;  }})();";
    private final Set<WebViewData> webViews = new LinkedHashSet();
    private final Map<String, String> webViewHTMLs = new LinkedHashMap();

    /* compiled from: WebViewDumpHelper.kt */
    @b0(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper$Companion;", "", "()V", "GET_WEBVIEW_HTML_JS_SCRIPT", "", "fixHtmlString", "data", "Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper$WebViewData;", "html", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String fixHtmlString(WebViewData webViewData, String str) {
            String k2 = u.k2(u.k2(u.k2(str, "\\u003C", "<", false, 4, (Object) null), "\\n", "", false, 4, (Object) null), "\\\"", "\"", false, 4, (Object) null);
            s0 s0Var = s0.a;
            Objects.requireNonNull(k2, "null cannot be cast to non-null type java.lang.String");
            String substring = k2.substring(1, k2.length() - 1);
            f0.o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String format = String.format("<html id=\"%s\" data-rect=\"%d,%d,%d,%d\">%s</html>", Arrays.copyOf(new Object[]{webViewData.getKey(), Integer.valueOf(webViewData.getLeft()), Integer.valueOf(webViewData.getTop()), Integer.valueOf(webViewData.getWidth()), Integer.valueOf(webViewData.getHeight()), substring}, 6));
            f0.o(format, "java.lang.String.format(format, *args)");
            return format;
        }

        public /* synthetic */ Companion(n.l2.v.u uVar) {
            this();
        }
    }

    /* compiled from: WebViewDumpHelper.kt */
    @b0(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper$WebViewData;", "", "webView", "Landroid/webkit/WebView;", "(Landroid/webkit/WebView;)V", "height", "", "getHeight", "()I", SDKConstants.PARAM_KEY, "", "getKey", "()Ljava/lang/String;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "getLeft", ViewHierarchyConstants.DIMENSION_TOP_KEY, "getTop", "width", "getWidth", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class WebViewData {
        @d
        public static final Companion Companion = new Companion(null);
        private static final int[] location = new int[2];
        private final int height;
        @d
        private final String key;
        private final int left;
        private final int top;
        private final int width;

        /* compiled from: WebViewDumpHelper.kt */
        @b0(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper$WebViewData$Companion;", "", "()V", "location", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(n.l2.v.u uVar) {
                this();
            }
        }

        public WebViewData(@d WebView webView) {
            f0.p(webView, "webView");
            s0 s0Var = s0.a;
            String format = String.format("%s{%s}", Arrays.copyOf(new Object[]{webView.getClass().getName(), Integer.toHexString(webView.hashCode())}, 2));
            f0.o(format, "java.lang.String.format(format, *args)");
            this.key = format;
            int[] iArr = location;
            webView.getLocationOnScreen(iArr);
            this.left = iArr[0];
            this.top = iArr[1];
            this.width = webView.getWidth();
            this.height = webView.getHeight();
        }

        public final int getHeight() {
            return this.height;
        }

        @d
        public final String getKey() {
            return this.key;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getTop() {
            return this.top;
        }

        public final int getWidth() {
            return this.width;
        }
    }

    public final void dump(@d PrintWriter printWriter) {
        f0.p(printWriter, "writer");
        try {
            for (WebViewData webViewData : this.webViews) {
                String str = this.webViewHTMLs.get(webViewData.getKey());
                if (str != null) {
                    printWriter.print("WebView HTML for ");
                    printWriter.print(webViewData);
                    printWriter.println(CertificateUtil.DELIMITER);
                    printWriter.println(Companion.fixHtmlString(webViewData, str));
                }
            }
        } catch (Exception unused) {
        }
        this.webViews.clear();
        this.webViewHTMLs.clear();
    }

    public final void handle(@d WebView webView) {
        f0.p(webView, ViewHierarchyConstants.VIEW_KEY);
        final WebViewData webViewData = new WebViewData(webView);
        this.webViews.add(webViewData);
        Resources resources = webView.getResources();
        f0.o(resources, "view.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        s0 s0Var = s0.a;
        String format = String.format(GET_WEBVIEW_HTML_JS_SCRIPT, Arrays.copyOf(new Object[]{Integer.valueOf(webViewData.getLeft()), Integer.valueOf(webViewData.getTop()), Float.valueOf(displayMetrics.scaledDensity)}, 3));
        f0.o(format, "java.lang.String.format(format, *args)");
        webView.evaluateJavascript(format, new ValueCallback() { // from class: com.facebook.internal.logging.dumpsys.WebViewDumpHelper$handle$1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(String str) {
                Map map;
                map = WebViewDumpHelper.this.webViewHTMLs;
                String key = webViewData.getKey();
                f0.o(str, "html");
                map.put(key, str);
            }
        });
    }
}
