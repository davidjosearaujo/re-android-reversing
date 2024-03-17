package com.hunantv.oversea.channel.dynamic.business.second;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hunantv.imgo.base.RootActivity;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.oversea.report.MGDCManager;
import com.hunantv.oversea.report.ReportManager;
import com.hunantv.oversea.report.data.pv.lob.BasePvLob;
import com.hunantv.oversea.report.data.pv.lob.ChannelPvLob;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.b;
import j.l.c.e0.a.a.a;
import r.a.b.c;
import r.a.c.c.e;

@Route(path = "/channel/ChannelDynamicSecondActivity")
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelDynamicSecondActivity extends RootActivity {
    private static final /* synthetic */ c.b ajc$tjp_0 = null;
    public String mChannelId;
    private CustomizeTitleBar mCustomizeTitleBar;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("ChannelDynamicSecondActivity.java", ChannelDynamicSecondActivity.class);
        ajc$tjp_0 = eVar.H("method-execution", eVar.E("1", "setChannelTitle", "com.hunantv.oversea.channel.dynamic.business.second.ChannelDynamicSecondActivity", "java.lang.String", "channelTitle", "", "void"), 84);
    }

    public static final /* synthetic */ void setChannelTitle_aroundBody0(ChannelDynamicSecondActivity channelDynamicSecondActivity, String str, c cVar) {
        CustomizeTitleBar customizeTitleBar = channelDynamicSecondActivity.mCustomizeTitleBar;
        if (customizeTitleBar != null) {
            customizeTitleBar.setTitleText(str);
        }
    }

    public static void start(Context context, String str) {
        Intent intent = new Intent(context, ChannelDynamicSecondActivity.class);
        intent.putExtra("bundle_channel_id", str);
        a.h(intent);
        context.startActivity(intent);
    }

    /* renamed from: u0 */
    public /* synthetic */ void m5v0(View view, byte b) {
        if (b == 1) {
            finish();
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        return b.m.activity_channel_dynamic_second;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(b.j.tv_channel_dynamic_second);
        this.mCustomizeTitleBar = customizeTitleBar;
        customizeTitleBar.setOnComponentClickListener(new j.l.c.c.c.l1.d.a(this));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        ChannelDynamicSecondFragment channelDynamicSecondFragment = new ChannelDynamicSecondFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("bundle_channel_id", this.mChannelId);
        channelDynamicSecondFragment.setArguments(bundle2);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(b.j.fl_channel_dynamic, channelDynamicSecondFragment);
        beginTransaction.commitNowAllowingStateLoss();
        MGDCManager.n().enterScene("subchannel", this);
        MGDCManager.n().registerDSource("SecondChannelId", this);
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onIntentAction(Intent intent, @Nullable Bundle bundle) {
        this.mChannelId = intent.getStringExtra("bundle_channel_id");
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        super.onResume();
        ChannelPvLob channelPvLob = new ChannelPvLob();
        ((BasePvLob) channelPvLob).cpid = this.mChannelId;
        if (TextUtils.equals(ReportManager.b().a, "ch_channel")) {
            channelPvLob.cid = j.l.c.x.t0.a.a().r;
        }
        ReportManager.b().reportPv("ch_secondlist", channelPvLob);
        MGDCManager.n().onEvent("page");
    }

    @WithTryCatchRuntime
    public void setChannelTitle(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.l1.d.b(new Object[]{this, str, e.w(ajc$tjp_0, this, this, str)}).e(69648));
    }
}
