package com.hunantv.oversea.me.ui.scan.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.google.gson.JsonObject;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.hunantv.imgo.net.ImgoHttpParams;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.me.ui.scan.bean.ParseInfo;
import com.hunantv.oversea.me.ui.scan.bean.ScanNotifyEntityBase;
import com.hunantv.oversea.me.ui.scan.bean.ScanNotifyEntityError;
import com.hunantv.oversea.session.global.SessionManager;
import com.hunantv.oversea.xweb.BaseXWebActivity;
import com.hunantv.oversea.xweb.XWebViewFragment;
import com.mgtv.task.http.HttpCallBack;
import j.l.a.b0.o0;
import j.l.a.b0.v;
import j.l.a.e;
import j.l.a.m.b.g;
import j.l.c.k.c;
import j.l.c.k.l.f.b.d;
import j.v.r.m;
import j.v.r.p;
import j.v.r.r;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class MeCaptureWebActivity extends BaseXWebActivity implements d {
    private static final String A = "invoker";
    private static final String B = "ticket";
    private static final String C = "islogin";
    private static final String D = "hunantvphone";
    private static final int E = 0;
    private static final int F = 1;
    public static final int K0 = 17;
    private static final int k0 = 0;
    private static final int k1 = 18;
    private static final String t = "MeCaptureWebActivity";
    private static final boolean u = j.l.a.c.a;
    private static final String v = "extra_url";
    private static final String w = "uid";
    private static final String x = "pic_use";
    private static final String y = "did";
    private static final String z = "from";
    private View n;
    @e
    private String o;
    private String p;
    private String q;
    private String r;
    private r s;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class b extends HttpCallBack<JsonObject> {
        private Reference<MeCaptureWebActivity> d;

        public b(MeCaptureWebActivity meCaptureWebActivity) {
            this.d = new WeakReference(meCaptureWebActivity);
        }

        private MeCaptureWebActivity v() {
            Reference<MeCaptureWebActivity> reference = this.d;
            if (reference == null) {
                return null;
            }
            return reference.get();
        }

        /* renamed from: u */
        public void failed(@Nullable JsonObject jsonObject, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            Message obtainMessage;
            super.failed(jsonObject, i, i2, str, th);
            if (MeCaptureWebActivity.u) {
                Log.e(MeCaptureWebActivity.t, "onError()");
                Log.e(MeCaptureWebActivity.t, "StatusCode:" + i);
                Log.e(MeCaptureWebActivity.t, "ErrorCode:" + i2);
                Log.e(MeCaptureWebActivity.t, "ErrorMessage:" + str);
            }
            c cVar = new c();
            cVar.b = i2;
            cVar.c = String.valueOf(i);
            cVar.d = str;
            BaseXWebActivity v = v();
            if (v == null || v.isFinishing() || (obtainMessage = v.obtainMessage(18)) == null) {
                return;
            }
            obtainMessage.obj = cVar;
            v.sendMessage(obtainMessage);
        }

        /* renamed from: w */
        public void previewCache(JsonObject jsonObject) {
        }

        /* renamed from: x */
        public void success(JsonObject jsonObject) {
            Message obtainMessage;
            ScanNotifyEntityError scanNotifyEntityError;
            String jsonElement = jsonObject == null ? null : jsonObject.toString();
            if (MeCaptureWebActivity.u) {
                Log.e(MeCaptureWebActivity.t, "onSuccess(" + jsonElement + ")");
            }
            ScanNotifyEntityBase scanNotifyEntityBase = (ScanNotifyEntityBase) j.v.j.b.u(jsonElement, ScanNotifyEntityBase.class);
            c cVar = new c();
            cVar.a = scanNotifyEntityBase;
            if (scanNotifyEntityBase != null && scanNotifyEntityBase.err != 0 && (scanNotifyEntityError = (ScanNotifyEntityError) j.v.j.b.u(jsonElement, ScanNotifyEntityError.class)) != null) {
                cVar.a = scanNotifyEntityError;
            }
            BaseXWebActivity v = v();
            if (v == null || v.isFinishing() || (obtainMessage = v.obtainMessage(18)) == null) {
                return;
            }
            obtainMessage.obj = cVar;
            v.sendMessage(obtainMessage);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class c {
        public ScanNotifyEntityBase a;
        public int b;
        public String c;
        public String d;

        private c() {
        }
    }

    private boolean B0() {
        XWebViewFragment xWebViewFragment = ((BaseXWebActivity) this).j;
        return (xWebViewFragment == null || xWebViewFragment.f2() == null) ? false : true;
    }

    private void D0() {
        UserInfo h = SessionManager.g().h();
        if (TextUtils.isEmpty(h == null ? null : h.ticket)) {
            o0.n(c.r.me_login_capture_logout);
        } else if (C0() == null) {
            o0.n(c.r.toast_request_failure_server_busy);
        } else {
            C0().n(true).u("https://nuc.api.mgtv.com/ScanNotify", A0(1), new b(this));
            showLoading();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"StringFormatInvalid"})
    private void E0(c cVar) {
        try {
            if (cVar == null) {
                o0.n(c.r.me_capture_web_toast_login_error);
                return;
            }
            ScanNotifyEntityBase scanNotifyEntityBase = cVar.a;
            if (scanNotifyEntityBase == null) {
                o0.k(getString(c.r.me_capture_web_toast_login_error_detail, new Object[]{String.valueOf(cVar.b), cVar.c, cVar.d}));
                return;
            }
            int i = scanNotifyEntityBase.err;
            if (i != 0) {
                o0.k(getString(c.r.me_capture_web_toast_login_error_detail, new Object[]{String.valueOf(i), scanNotifyEntityBase.status, scanNotifyEntityBase instanceof ScanNotifyEntityError ? ((ScanNotifyEntityError) scanNotifyEntityBase).msg : null}));
            } else {
                o0.n(c.r.me_capture_web_toast_login_success);
                finish();
                j.l.c.k.l.f.a aVar = new j.l.c.k.l.f.a();
                ((j.l.a.m.b.b) aVar).b = "close";
                g.b(j.l.c.k.l.f.a.class).a(aVar);
            }
        } finally {
            hideLoading();
        }
    }

    public static boolean F0(Activity activity, @NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        return K0(activity, intent);
    }

    public static boolean G0(Context context, String str) {
        v.c(t, "open url = " + str);
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent(context, MeCaptureWebActivity.class);
        intent.putExtra("url", str);
        return J0(context, intent);
    }

    private void H0() {
        this.o = null;
        try {
            Uri parse = Uri.parse(((BaseXWebActivity) this).c);
            this.o = parse.getQueryParameter("uid");
            this.p = parse.getQueryParameter(x);
            this.q = parse.getQueryParameter(y);
            this.r = parse.getQueryParameter("from");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean I0(@Nullable View view, int i) {
        if (view == null || view.getVisibility() == i) {
            return false;
        }
        view.setVisibility(i);
        return true;
    }

    public static boolean J0(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            try {
                j.l.c.e0.a.a.a.h(intent);
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean K0(@NonNull Context context, Intent intent) {
        try {
            j.l.c.e0.a.a.a.h(intent);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void hideLoading() {
        I0(this.n, 8);
    }

    private void showLoading() {
        I0(this.n, 0);
    }

    @NonNull
    public ImgoHttpParams A0(int i) {
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        imgoHttpParams.put(A, "hunantvphone");
        imgoHttpParams.put("uid", this.o);
        imgoHttpParams.put(x, this.p);
        imgoHttpParams.put(y, this.q);
        imgoHttpParams.put("from", this.r);
        imgoHttpParams.put(C, Integer.valueOf(i));
        return imgoHttpParams;
    }

    @NonNull
    @MainThread
    public r C0() {
        if (this.s == null) {
            this.s = new r(j.l.a.a.a(), new m(ThreadManager.getNetWorkExecutorService(), false), (p) null);
        }
        return this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void D() {
        v.c(t, "onUnknown 未识别");
        o0.n(c.r.me_capture_web_toast_unknown_url);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void R() {
        v.c(t, "onLogin 登录解析器，登录状态 = " + SessionManager.m());
        if (B0()) {
            w0(false);
            ((BaseXWebActivity) this).j.f2().loadUrl(((BaseXWebActivity) this).c);
        }
        if (SessionManager.m()) {
            ((BaseXWebActivity) this).j.m3(getResources().getString(c.r.me_capture_web_title_login));
            String str = this.r;
            if (str == null || !str.equals("imgoipad")) {
                C0().n(true).x("https://nuc.api.mgtv.com/ScanNotify", A0(0));
                return;
            }
            return;
        }
        j.l.c.k.l.f.a aVar = new j.l.c.k.l.f.a();
        ((j.l.a.m.b.b) aVar).b = "login";
        ((j.l.a.m.b.b) aVar).g = ((BaseXWebActivity) this).c;
        g.b(j.l.c.k.l.f.a.class).a(aVar);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b() {
        v.c(t, "onOpenSiteM 手机 M 站");
        finish();
        j.l.c.k.l.f.a aVar = new j.l.c.k.l.f.a();
        ((j.l.a.m.b.b) aVar).b = "close";
        g.b(j.l.c.k.l.f.a.class).a(aVar);
    }

    public int obtainLayoutResourceId() {
        return c.m.me_activity_capture_web;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@Nullable Bundle bundle) {
        w0(true);
        super/*com.hunantv.imgo.base.RootActivity*/.onCreate(bundle);
        C0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onHandleMessage(Message message) {
        super/*com.hunantv.imgo.base.RootActivity*/.onHandleMessage(message);
        int i = message.what;
        if (i == 17) {
            D0();
        } else if (i != 18) {
        } else {
            Object obj = message.obj;
            E0(obj == null ? null : (c) obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitializeData(@Nullable Bundle bundle) {
        if (u) {
            Log.e(t, "URL: " + ((BaseXWebActivity) this).c);
        }
        if (TextUtils.isEmpty(((BaseXWebActivity) this).c)) {
            finish();
            return;
        }
        H0();
        ParseInfo parseInfo = new ParseInfo();
        parseInfo.url = ((BaseXWebActivity) this).c;
        parseInfo.uid = this.o;
        new j.l.c.k.l.f.b.b(this).parse(parseInfo, this);
    }

    public void onInitializeUI(@Nullable Bundle bundle) {
        super.onInitializeUI(bundle);
        View findViewById = findViewById(c.j.loadingFrame);
        this.n = findViewById;
        I0(findViewById, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean q() {
        v.c(t, "onThirdSchema 跳转第三方");
        boolean F0 = F0(this, ((BaseXWebActivity) this).c);
        if (F0) {
            finish();
            j.l.c.k.l.f.a aVar = new j.l.c.k.l.f.a();
            ((j.l.a.m.b.b) aVar).b = "close";
            g.b(j.l.c.k.l.f.a.class).a(aVar);
        } else if (B0()) {
            w0(false);
            ((BaseXWebActivity) this).j.f2().loadUrl(((BaseXWebActivity) this).c);
        }
        return F0;
    }

    public void r() {
        v.c(t, "onOpenWeb web 解析器");
        if (B0()) {
            w0(false);
            ((BaseXWebActivity) this).j.f2().loadUrl(((BaseXWebActivity) this).c);
        }
        j.l.c.k.l.f.a aVar = new j.l.c.k.l.f.a();
        ((j.l.a.m.b.b) aVar).b = "close";
        g.b(j.l.c.k.l.f.a.class).a(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r0() {
        v.c(t, "onSchema scheme 解析器");
        j.l.c.z.c.d.i(this, ((BaseXWebActivity) this).c);
        finish();
        j.l.c.k.l.f.a aVar = new j.l.c.k.l.f.a();
        ((j.l.a.m.b.b) aVar).b = "close";
        g.b(j.l.c.k.l.f.a.class).a(aVar);
    }
}
