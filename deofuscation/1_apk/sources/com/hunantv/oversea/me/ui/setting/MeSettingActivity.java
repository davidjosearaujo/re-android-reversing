package com.hunantv.oversea.me.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hunantv.oversea.business.update.notice.UpdateNoticeObserver;
import com.hunantv.oversea.me.adapter.MeSettingAdapter;
import com.hunantv.oversea.me.ui.MeBaseActivity;
import com.hunantv.oversea.me.ui.account.MeAccountSecurityActivity;
import com.hunantv.oversea.report.MGDCManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.downloader.DownloadManager;
import com.mgtv.oversea.setting.appconfig.AppConfigManager;
import j.l.a.b0.e0;
import j.l.a.b0.o0;
import j.l.c.k.c;
import j.l.c.k.e.h;
import j.l.c.k.e.o;
import j.l.c.k.l.g.d;
import j.l.c.k.l.g.t;
import j.l.c.k.l.g.u;
import j.l.c.k.m.i;
import j.l.c.k.m.j;
import j.l.c.k.m.n;
import j.l.c.k.o.q;
import j.l.c.k.p.e;
import java.util.List;
import r.a.b.c;

@Route(path = "/mgtv/MeSettingActivity")
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeSettingActivity extends MeBaseActivity implements MeSettingAdapter.b {
    private static final /* synthetic */ c.b d = null;
    private MeSettingPage a;
    private u b;
    private q c;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends e.c {
        public a() {
            MeSettingActivity.this = r1;
        }

        public void a(int i) {
            MeSettingActivity.this.L0(i);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends e.c {
        public b() {
            MeSettingActivity.this = r1;
        }

        public void a(int i) {
            i.o(i);
            MeSettingActivity.this.c.K();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c extends e.c {
        public c() {
            MeSettingActivity.this = r1;
        }

        public void a(int i) {
            MeSettingActivity.this.c.j(i);
        }
    }

    static {
        ajc$preClinit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean A0() {
        if (ContextCompat.checkSelfPermission(j.c(), e0.d()) == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(this, new String[]{e0.d()}, 0);
        return false;
    }

    /* renamed from: E0 */
    public /* synthetic */ void m13F0(o oVar) {
        String[] strArr;
        if (oVar == null || (strArr = oVar.a) == null) {
            return;
        }
        this.b.f(strArr, oVar.b, new c());
    }

    /* renamed from: G0 */
    public /* synthetic */ void m14H0(View view) {
        this.c.k();
    }

    private void I0() {
        if (A0()) {
            this.c.l().observe(this, new j.l.c.k.l.g.c(this));
        }
    }

    private void J0(byte b2, boolean z) {
        int i;
        if (j.l.c.k.h.a.g()) {
            if (this.c.E(b2, z)) {
                return;
            }
            o0.n(c.r.toast_request_failure_server_busy);
            return;
        }
        if (b2 == 41) {
            this.c.M((byte) 41);
            i = c.r.me_setting_confirm_dialog_title_msg_comment;
        } else if (b2 == 42) {
            this.c.M((byte) 42);
            i = c.r.me_setting_confirm_dialog_title_msg_like;
        } else if (b2 == 51) {
            this.c.M((byte) 51);
            i = c.r.me_setting_confirm_dialog_title_syn;
        } else {
            i = -1;
        }
        if (i != -1) {
            this.b.h(i);
        }
    }

    public void K0(int i) {
        Log.e("Setting", "onPageStatus， status = " + i);
        if (i == 0) {
            hideLoading();
        } else if (i == 1) {
            showLoading();
        }
    }

    public void L0(int i) {
        if (i == 0 || i == 1) {
            if (i == 0) {
                AppConfigManager.k().p();
            }
            i.w(i);
            this.c.L();
        }
    }

    public void M0(j.l.c.k.e.i iVar) {
        if (iVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(iVar.e)) {
            o0.o(iVar.e);
        }
        this.a.w0(iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void N0(MeSettingActivity meSettingActivity, View view, h hVar, int i, r.a.b.c cVar) {
        if (hVar == null || i == -1) {
            return;
        }
        byte a2 = hVar.a();
        if (a2 == 7) {
            meSettingActivity.b.d();
        } else if (a2 == 51) {
            meSettingActivity.J0((byte) 51, hVar.g());
        } else if (a2 == 61) {
            meSettingActivity.b.e(new d(meSettingActivity));
        } else if (a2 == 81) {
            if (j.l.c.k.h.a.g()) {
                meSettingActivity.startActivity(new Intent((Context) meSettingActivity, (Class<?>) MeAccountSecurityActivity.class));
                n.a();
                meSettingActivity.c.H((byte) 81, false);
                return;
            }
            j.l.c.k.h.a.h(meSettingActivity, 0);
        } else if (a2 == 83) {
            MePrivacySettingActivity.startMe(meSettingActivity);
        } else if (a2 == 31) {
            meSettingActivity.startActivity(new Intent((Context) meSettingActivity, (Class<?>) PushSettingActivity.class));
        } else if (a2 == 32) {
            i.y(hVar.g());
        } else if (a2 == 41) {
            meSettingActivity.J0((byte) 41, hVar.g());
        } else if (a2 != 42) {
            switch (a2) {
                case 11:
                    i.x(hVar.g());
                    return;
                case 12:
                    meSettingActivity.b.i(new a());
                    return;
                case 13:
                    i.v(hVar.g());
                    return;
                default:
                    switch (a2) {
                        case 21:
                            boolean g = hVar.g();
                            i.n(g);
                            i.r(true);
                            i.q(false);
                            DownloadManager.h().downloaderPushEvent(g ? 22 : 23, "");
                            return;
                        case 22:
                            meSettingActivity.I0();
                            return;
                        case 23:
                            meSettingActivity.b.g(new b());
                            return;
                        default:
                            switch (a2) {
                                case 63:
                                    j.l.c.k.h.c.b(meSettingActivity, j.v.o.a.d.d.b.l("MangoTV"));
                                    j.l.c.a.h.a.d.c().g("MeSetting");
                                    return;
                                case 64:
                                    j.l.c.k.h.c.b(meSettingActivity, j.v.o.a.d.d.b.g());
                                    return;
                                case 65:
                                    j.l.c.k.h.c.b(meSettingActivity, j.v.o.a.d.d.b.m());
                                    return;
                                case 66:
                                    j.l.c.k.h.c.b(meSettingActivity, j.v.o.a.d.d.b.i());
                                    return;
                                case 67:
                                    j.l.c.k.h.c.b(meSettingActivity, j.v.o.a.d.d.b.h());
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } else {
            meSettingActivity.J0((byte) 42, hVar.g());
        }
    }

    public void O0(List<h> list) {
        this.a.refreshSettingItems(list);
        this.c.G();
    }

    private static /* synthetic */ void ajc$preClinit() {
        r.a.c.c.e eVar = new r.a.c.c.e("MeSettingActivity.java", MeSettingActivity.class);
        d = eVar.H("method-execution", eVar.E("1", "onSettingItemClick", "com.hunantv.oversea.me.ui.setting.MeSettingActivity", "android.view.View:com.hunantv.oversea.me.data.MeSettingItem:int", "view:settingItem:position", "", "void"), 123);
    }

    public void hideLoading() {
        Log.e("Setting", "hideLoading");
        this.a.o0();
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        MeSettingPage meSettingPage = new MeSettingPage(this);
        this.a = meSettingPage;
        meSettingPage.setOnSettingItemClickListener(this);
        setContentView(this.a);
        return -1;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        super.onInitializeUI(bundle);
        q qVar = new ViewModelProvider(this).get(q.class);
        this.c = qVar;
        qVar.c().observe(this, new j.l.c.k.l.g.b(this));
        this.c.s().observe(this, new j.l.c.k.l.g.e(this));
        this.c.n().observe(this, new j.l.c.k.l.g.a(this));
        this.c.o().observe(this, new j.l.c.k.l.g.a(this));
        this.c.m().observe(this, new j.l.c.k.l.g.a(this));
        this.b = new u(this);
        j.l.c.a.h.a.d.c().h("MeSetting", new UpdateNoticeObserver(this) { // from class: com.hunantv.oversea.me.ui.setting.MeSettingActivity.1
            {
                MeSettingActivity.this = this;
            }

            public void d(j.l.c.a.h.a.c cVar, boolean z) {
                MeSettingActivity.this.c.H((byte) 63, z);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(i, strArr, iArr);
        if (strArr.length == 0 || !e0.d().equals(strArr[0])) {
            return;
        }
        if (iArr.length != 0 && iArr[0] != -1) {
            I0();
        } else {
            o0.o(getString(c.r.storage_permission_denied_toast));
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        super.onResume();
        j.l.c.k.f.d.f();
        MGDCManager.n().enterScene("my_settings", this);
        MGDCManager.n().onEvent("page");
    }

    @Override // com.hunantv.oversea.me.adapter.MeSettingAdapter.b
    @WithTryCatchRuntime
    public void onSettingItemClick(View view, @Nullable h hVar, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new t(new Object[]{this, view, hVar, r.a.c.b.e.k(i), r.a.c.c.e.y(d, this, this, new Object[]{view, hVar, r.a.c.b.e.k(i)})}).e(69648));
    }

    public void showLoading() {
        Log.e("Setting", "showLoading");
        this.a.y0();
    }
}
