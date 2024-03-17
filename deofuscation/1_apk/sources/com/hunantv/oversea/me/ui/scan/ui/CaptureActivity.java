package com.hunantv.oversea.me.ui.scan.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hunantv.imgo.base.RootActivity;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.mpdt.statistics.bigdata.PVSourceEvent;
import com.hunantv.oversea.login.compat.LoginEntry;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.report.MGDCManager;
import com.hunantv.oversea.report.ReportManager;
import com.hunantv.oversea.report.data.pv.lob.BasePvLob;
import com.hunantv.oversea.report.data.pv.lob.DefaultLob;
import com.hunantv.oversea.session.global.SessionManager;
import com.mgcapture.zxing.FullScreenCaptureLayout;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.o0;
import j.l.a.m.b.b;
import j.l.a.m.b.g;
import j.l.c.h.e;
import j.l.c.k.c;
import j.l.c.z.c.d;
import j.t.c.c;
import j.v.r.m;
import j.v.r.p;
import j.v.r.r;
import r.a.b.c;

@Route(path = "/mgtv/MeLoginCaptureActivity")
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CaptureActivity extends RootActivity implements c.g, Observer<j.l.c.k.l.f.a> {
    private static final /* synthetic */ c.b j = null;
    @Nullable
    private e b;
    @Nullable
    @j.l.a.e
    private String c;
    @j.l.a.e
    private boolean d;
    private j.t.c.c e;
    private r g;
    private ImageView h;
    private FullScreenCaptureLayout i;
    private boolean a = SessionManager.m();
    private Handler f = new Handler();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            CaptureActivity.this = r1;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CaptureActivity.this.e == null || TextUtils.isEmpty(this.a)) {
                return;
            }
            CaptureActivity.this.e.m(Uri.parse(this.a));
        }
    }

    static {
        ajc$preClinit();
    }

    /* renamed from: B0 */
    public /* synthetic */ void m11C0(View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: D0 */
    public /* synthetic */ void m12E0(UserInfo userInfo) {
        if (isFinishing()) {
            return;
        }
        boolean n = SessionManager.n(userInfo);
        if (!this.a && n && !TextUtils.isEmpty(this.c)) {
            MeCaptureWebActivity.G0(this, this.c);
            this.c = null;
        }
        this.a = n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G0(@Nullable String str) {
        if (y0(str)) {
            d.i(this, str);
            finish();
        } else if (!TextUtils.isEmpty(str) && MeCaptureWebActivity.G0(this, str)) {
            if (SessionManager.m()) {
                return;
            }
            H0();
        } else {
            o0.n(c.r.unknown_error);
            I0();
        }
    }

    private void H0() {
        if (this.b != null) {
            return;
        }
        this.b = new j.l.c.k.l.f.c.c(this);
        SessionManager.g().d(this.b);
    }

    private void J0() {
        if (this.b == null) {
            return;
        }
        SessionManager.g().s(this.b);
        this.b = null;
    }

    private static /* synthetic */ void ajc$preClinit() {
        r.a.c.c.e eVar = new r.a.c.c.e("CaptureActivity.java", CaptureActivity.class);
        j = eVar.H("method-execution", eVar.E("2", MgtvMediaPlayer.DataSourceInfo.INIT_VALUE, "com.hunantv.oversea.me.ui.scan.ui.CaptureActivity", "", "", "", "void"), (int) EventClickData.u.n1);
    }

    @WithTryCatchRuntime
    private void init() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.l.f.c.d(new Object[]{this, r.a.c.c.e.v(j, this, this)}).e(69648));
    }

    public static final /* synthetic */ void x0(CaptureActivity captureActivity, r.a.b.c cVar) {
        captureActivity.i.setVisibility(0);
        captureActivity.f.postDelayed(new j.l.c.k.l.f.c.a(captureActivity), 200L);
        DefaultLob defaultLob = new DefaultLob();
        ((BasePvLob) defaultLob).cpid = "0";
        ReportManager.b().reportPv("user_scanQRCode", defaultLob);
        PVSourceEvent.e(j.l.a.a.a()).q(PVSourceEvent.s0, "0", "", "", "", "");
    }

    private boolean y0(@Nullable String str) {
        return (str == null || TextUtils.isEmpty(str) || !str.startsWith("omgotv://")) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: z0 */
    public /* synthetic */ void m10A0() {
        if (this.e == null) {
            j.t.c.c cVar = new j.t.c.c(this, this.i);
            this.e = cVar;
            cVar.u(getIntent(), (Bundle) null);
            this.e.F(this);
            this.e.l();
        }
        this.e.A();
        this.i.resume();
    }

    /* renamed from: F0 */
    public void onChanged(j.l.c.k.l.f.a aVar) {
        if (TextUtils.equals("login", ((b) aVar).b)) {
            w0(((b) aVar).g);
        } else if (TextUtils.equals("close", ((b) aVar).b)) {
            finish();
        }
    }

    public final void I0() {
        this.e.E();
    }

    public void K(String str) {
        if (this.d) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            o0.n(c.r.me_login_capture_cancel);
        } else {
            G0(str);
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public final int obtainLayoutResourceId() {
        return c.m.me_activity_capture;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 1) {
            if (intent != null && intent.getData() != null) {
                j.l.c.k.l.f.d.d.a.a(new a(intent.getData().toString()));
            } else {
                Log.e(this.TAG, "onActivityResult() null == data");
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.hunantv.imgo.base.RootActivity, com.hunantv.imgo.nightmode.SkinnableActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        v0();
        g.b(j.l.c.k.l.f.a.class).h(this, this);
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onDestroy() {
        super.onDestroy();
        J0();
        this.c = null;
        j.t.c.c cVar = this.e;
        if (cVar != null) {
            cVar.F((c.g) null);
            this.e.x();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        super.onInitializeUI(bundle);
        this.i = findViewById(c.j.captureLayout);
        ImageView imageView = (ImageView) findViewById(c.j.ivLeft);
        this.h = imageView;
        imageView.setOnClickListener(new j.l.c.k.l.f.c.b(this));
        getWindow().setFlags(128, 128);
        init();
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.i.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onPause() {
        super.onPause();
        this.d = true;
        j.t.c.c cVar = this.e;
        if (cVar != null) {
            cVar.y();
        }
        this.i.pause();
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        j.t.c.c cVar = this.e;
        if (cVar != null) {
            cVar.z(i, strArr, iArr);
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        super.onResume();
        DefaultLob defaultLob = new DefaultLob();
        ((BasePvLob) defaultLob).cpid = "0";
        ReportManager.b().reportPv("user_scanQRCode", defaultLob);
        MGDCManager.n().enterScene("my_scan", this);
        MGDCManager.n().onEvent("page");
        this.d = false;
        j.t.c.c cVar = this.e;
        if (cVar != null) {
            cVar.A();
        }
        this.i.resume();
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j.t.c.c cVar = this.e;
        if (cVar != null) {
            cVar.B(bundle);
        }
    }

    @NonNull
    @MainThread
    public r v0() {
        if (this.g == null) {
            this.g = new r(j.l.a.a.a(), new m(ThreadManager.getNetWorkExecutorService(), false), (p) null);
        }
        return this.g;
    }

    public void w0(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c = str;
        LoginEntry.c(5);
    }
}
