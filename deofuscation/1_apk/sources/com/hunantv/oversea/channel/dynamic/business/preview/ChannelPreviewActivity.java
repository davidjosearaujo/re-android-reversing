package com.hunantv.oversea.channel.dynamic.business.preview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hunantv.imgo.base.RootActivity;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.b;
import j.l.c.c.c.l1.c.a;
import r.a.b.c;
import r.a.c.c.e;

@Route(path = "/channel/ChannelPreviewActivity")
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelPreviewActivity extends RootActivity {
    private static final /* synthetic */ c.b c = null;
    public String a;
    private CustomizeTitleBar b;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("ChannelPreviewActivity.java", ChannelPreviewActivity.class);
        c = eVar.H("method-execution", eVar.E("1", "setChannelTitle", "com.hunantv.oversea.channel.dynamic.business.preview.ChannelPreviewActivity", "java.lang.String", "channelTitle", "", "void"), 79);
    }

    /* renamed from: u0 */
    public /* synthetic */ void m4v0(View view, byte b) {
        if (b == 1) {
            finish();
        }
    }

    public static final /* synthetic */ void w0(ChannelPreviewActivity channelPreviewActivity, String str, c cVar) {
        CustomizeTitleBar customizeTitleBar = channelPreviewActivity.b;
        if (customizeTitleBar != null) {
            customizeTitleBar.setTitleText(str);
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        return b.m.activity_channel_preview;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        ChannelPreviewEntity channelPreviewEntity;
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(b.j.tv_channel_preview);
        this.b = customizeTitleBar;
        customizeTitleBar.setOnComponentClickListener(new a(this));
        try {
            channelPreviewEntity = (ChannelPreviewEntity) j.v.j.b.u(this.a, ChannelPreviewEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            channelPreviewEntity = null;
        }
        if (channelPreviewEntity == null) {
            finish();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        DynamicPreviewFragment dynamicPreviewFragment = new DynamicPreviewFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable(DynamicPreviewFragment.Q2, channelPreviewEntity);
        dynamicPreviewFragment.setArguments(bundle2);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(b.j.fl_channel_preview, dynamicPreviewFragment);
        beginTransaction.commitNowAllowingStateLoss();
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onIntentAction(Intent intent, @Nullable Bundle bundle) {
        this.a = intent.getStringExtra("json");
    }

    @WithTryCatchRuntime
    public void setChannelTitle(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.l1.c.b(new Object[]{this, str, e.w(c, this, this, str)}).e(69648));
    }
}
