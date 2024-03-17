package com.hunantv.oversea.me.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.internal.NativeProtocol;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.me.ui.MeBaseActivity;
import com.hunantv.oversea.report.MGDCManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.widget.recyclerview.MGRecyclerView;
import j.l.a.b0.e0;
import j.l.a.b0.f0;
import j.l.c.k.c;
import j.l.c.k.d.r;
import j.l.c.k.e.f;
import j.l.c.k.f.e;
import j.l.c.k.l.g.n;
import j.l.c.k.l.g.o;
import j.l.c.k.l.g.p;
import j.l.c.k.l.g.q;
import j.l.c.k.l.g.s;
import j.l.c.k.m.i;
import j.v.q.f.d;
import java.util.ArrayList;
import r.a.b.c;

@Route(path = "/mgtv/MePrivacySettingActivity")
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MePrivacySettingActivity extends MeBaseActivity implements r.c, r.b, CustomizeTitleBar.b {
    public static final String f = "key_me_privacy_setting_rec_switch";
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private static final /* synthetic */ c.b j = null;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private MGRecyclerView a;
    private CustomizeTitleBar b;
    private LinearLayoutManagerWrapper c;
    private r d;
    private b e;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;

        private b() {
        }

        public void a(Context context) {
            d a = j.v.q.c.a(context, 4);
            boolean e = a.e(context, "android.permission.READ_PHONE_STATE");
            boolean e2 = a.e(context, "android.permission.ACCESS_FINE_LOCATION");
            boolean e3 = a.e(context, "android.permission.CAMERA");
            boolean e4 = a.e(context, e0.d());
            if (this.a) {
                if (this.b != e) {
                    e.c(e);
                }
                if (this.c != e2) {
                    e.a(e2);
                }
                if (this.d != e3) {
                    e.d(e3);
                }
                if (this.e != e4) {
                    e.e(e4);
                }
            }
            this.b = e;
            this.c = e2;
            this.d = e3;
            this.e = e4;
            this.a = true;
        }
    }

    static {
        ajc$preClinit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void A0(MePrivacySettingActivity mePrivacySettingActivity, View view, int i2, c cVar) {
        f fVar = (f) mePrivacySettingActivity.d.getItem(i2);
        if (fVar != null) {
            j.l.c.k.h.c.b(mePrivacySettingActivity, fVar.f);
        }
    }

    public static final /* synthetic */ void C0(MePrivacySettingActivity mePrivacySettingActivity, CompoundButton compoundButton, boolean z, int i2, c cVar) {
        if (((f) mePrivacySettingActivity.d.getItem(i2)).g == 1) {
            f0.p(f, z);
            e.f(z);
            return;
        }
        i.u(z);
        j.l.c.l.h.a c = j.l.c.k.k.c.b().c("status_ad_rc");
        if (c != null) {
            c.a(new j.l.c.l.h.b("status_ad_rc", i.i()));
        }
        e.b(z);
    }

    public static final /* synthetic */ void D0(Context context, c cVar) {
        Intent intent = new Intent(context, MePrivacySettingActivity.class);
        j.l.c.e0.a.a.a.h(intent);
        context.startActivity(intent);
    }

    private static /* synthetic */ void ajc$preClinit() {
        r.a.c.c.e eVar = new r.a.c.c.e("MePrivacySettingActivity.java", MePrivacySettingActivity.class);
        g = eVar.H("method-execution", eVar.E("4", "onCreate", "com.hunantv.oversea.me.ui.setting.MePrivacySettingActivity", "android.os.Bundle", "savedInstanceState", "", "void"), 66);
        h = eVar.H("method-execution", eVar.E("2", "initData", "com.hunantv.oversea.me.ui.setting.MePrivacySettingActivity", "", "", "", "void"), 96);
        i = eVar.H("method-execution", eVar.E("1", "onDetailsViewClick", "com.hunantv.oversea.me.ui.setting.MePrivacySettingActivity", "android.view.View:int", "view:position", "", "void"), (int) EventClickData.u.p1);
        j = eVar.H("method-execution", eVar.E("1", "onRightBtnViewClick", "com.hunantv.oversea.me.ui.setting.MePrivacySettingActivity", "android.view.View:int", "view:position", "", "void"), (int) Opcodes.IF_ACMPNE);
        k = eVar.H("method-execution", eVar.E("9", "startMe", "com.hunantv.oversea.me.ui.setting.MePrivacySettingActivity", "android.content.Context", "activity", "", "void"), (int) EventClickData.u.E1);
        l = eVar.H("method-execution", eVar.E("1", "onSwitchCheckedChanged", "com.hunantv.oversea.me.ui.setting.MePrivacySettingActivity", "android.widget.CompoundButton:boolean:int", "buttonView:isChecked:position", "", "void"), (int) Opcodes.GETSTATIC);
    }

    @WithTryCatchRuntime
    private void initData() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new p(new Object[]{this, r.a.c.c.e.v(h, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public static void startMe(Context context) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new s(new Object[]{context, r.a.c.c.e.w(k, (Object) null, (Object) null, context)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void y0(MePrivacySettingActivity mePrivacySettingActivity, c cVar) {
        if (mePrivacySettingActivity.e == null) {
            mePrivacySettingActivity.e = new b();
        }
        mePrivacySettingActivity.e.a(mePrivacySettingActivity);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_phone_title), mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_phone_desc), "android.permission.READ_PHONE_STATE", mePrivacySettingActivity.e.b, 1, j.v.o.a.d.d.b.j("phone")));
        arrayList.add(new f(3));
        arrayList.add(new f(mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_local_title), mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_local_desc), "android.permission.ACCESS_FINE_LOCATION", mePrivacySettingActivity.e.c, 1, j.v.o.a.d.d.b.j("location")));
        arrayList.add(new f(3));
        arrayList.add(new f(mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_camera_title), mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_camera_desc), "android.permission.CAMERA", mePrivacySettingActivity.e.d, 1, j.v.o.a.d.d.b.j("camera")));
        arrayList.add(new f(3));
        arrayList.add(new f(mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_storage_title), mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_storage_desc), e0.d(), mePrivacySettingActivity.e.e, 1, j.v.o.a.d.d.b.j("file")));
        arrayList.add(new f(3));
        arrayList.add(new f(mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_ad_title), mePrivacySettingActivity.getString(c.r.me_setting_privacy_setting_desc_detail), "", i.i(), 2, j.v.o.a.d.d.b.j("ads"), 2));
        mePrivacySettingActivity.d.setList(arrayList);
        mePrivacySettingActivity.d.notifyDataSetChanged();
    }

    @Override // com.hunantv.imgo.widget.CustomizeTitleBar.b
    public void a(View view, byte b2) {
        if (b2 == 1) {
            finish();
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        return c.m.me_activity_privacy_setting;
    }

    @Override // com.hunantv.oversea.me.ui.MeBaseActivity, com.hunantv.imgo.base.RootActivity, com.hunantv.imgo.nightmode.SkinnableActivity
    @WithTryCatchRuntime
    public void onCreate(Bundle bundle) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o(new Object[]{this, bundle, r.a.c.c.e.w(g, this, this, bundle)}).e(69648));
    }

    @WithTryCatchRuntime
    public void onDetailsViewClick(View view, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new q(new Object[]{this, view, r.a.c.b.e.k(i2), r.a.c.c.e.x(i, this, this, view, r.a.c.b.e.k(i2))}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeData(@Nullable Bundle bundle) {
        initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        this.a = findViewById(c.j.recyclerView);
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(c.j.titleBar);
        this.b = customizeTitleBar;
        customizeTitleBar.setBackgroundResource(c.h.me_bg_title_bar);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(this);
        this.c = linearLayoutManagerWrapper;
        linearLayoutManagerWrapper.setOrientation(1);
        this.a.setLayoutManager(this.c);
        r rVar = new r(this);
        this.d = rVar;
        rVar.C(this);
        this.d.B(this);
        this.a.setAdapter(this.d);
        this.b.setOnComponentClickListener(this);
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onRestart() {
        super.onRestart();
        initData();
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        super.onResume();
        j.l.c.k.f.d.e();
        MGDCManager.n().enterScene("set_privacy", this);
        MGDCManager.n().onEvent("page");
    }

    @WithTryCatchRuntime
    public void onRightBtnViewClick(View view, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.l.g.r(new Object[]{this, view, r.a.c.b.e.k(i2), r.a.c.c.e.x(j, this, this, view, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    public void onSwitchCheckedChanged(CompoundButton compoundButton, boolean z, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n(new Object[]{this, compoundButton, r.a.c.b.e.a(z), r.a.c.b.e.k(i2), r.a.c.c.e.y(l, this, this, new Object[]{compoundButton, r.a.c.b.e.a(z), r.a.c.b.e.k(i2)})}).e(69648));
    }
}
