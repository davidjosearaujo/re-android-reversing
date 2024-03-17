package com.hunantv.oversea.channel.dynamic.render;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.gson.JsonObject;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.business.ad.huge.HugeMananger;
import com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment;
import com.hunantv.oversea.channel.dynamic.render.ad.BaseAdsListener;
import com.hunantv.oversea.channel.dynamic.render.ad.HugeAdBannerBean;
import com.hunantv.oversea.channel.dynamic.render.banner.ChannelAdBannerLayout;
import com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.hunantv.oversea.channel.selected.data.ChannelListEntity;
import com.mgmi.ads.api.AdWidgetInfoImp;
import com.mgmi.ads.api.AdsListener;
import com.mgmi.ads.api.AwayAppType;
import com.mgmi.ads.api.ExposeErrorType;
import com.mgmi.reporter.ConvertionType;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.c0;
import j.l.a.b0.n0;
import j.l.a.c0.d;
import j.l.c.c.b;
import j.l.c.c.c.u1.e;
import j.l.c.c.c.u1.f;
import j.l.c.c.c.u1.g;
import j.l.c.c.c.u1.h;
import j.l.c.c.c.u1.i;
import j.l.c.c.c.u1.j;
import j.s.j.y0;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicAdBannerRender extends e {
    private static final String l = "DynamicAdBannerRender";
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private static final /* synthetic */ c.b p = null;
    private ChannelAdBannerLayout d;
    private ChannelIndexEntity.DataBean.ModuleDataBean e;
    private d f;
    private j.u.e.c.i.d g;
    private JsonObject h;
    private j.v.g.k.d i;
    private int j;
    private View.OnClickListener k;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DynamicAdBannerRender.this.i != null) {
                j.l.c.c.c.t1.b bVar = new j.l.c.c.c.t1.b("AD_BANNER_CLICK");
                ((j.v.g.d.d) bVar).e = String.valueOf(9000189);
                DynamicAdBannerRender.this.i.a(view, bVar);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends d.f {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, String str, String str2) {
            super(dVar);
            this.b = str;
            this.c = str2;
        }

        public void onLeftButtonClicked() {
            super.onLeftButtonClicked();
            j.u.o.a.i().e(j.l.a.a.a(), this.b, ConvertionType.CONVERTION_TYPE_USER_CANCEL_DOWNLOAD, (String) null, (String) null);
            y0.a(DynamicAdBannerRender.this.f);
        }

        public void onRightButtonClicked() {
            super.onRightButtonClicked();
            y0.a(DynamicAdBannerRender.this.f);
            j.v.k.g.b.h().A(((e) DynamicAdBannerRender.this).b.getCurrentActivity(), this.b, this.c);
        }
    }

    static {
        k();
    }

    public DynamicAdBannerRender(j.l.c.c.c.s1.e eVar) {
        super(eVar);
        this.k = new a();
    }

    @WithTryCatchRuntime
    private void addHugeAdBean() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, r.a.c.c.e.v(o, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    private void getAdData() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g(new Object[]{this, r.a.c.c.e.v(m, this, this)}).e(69648));
    }

    public static final /* synthetic */ void j(DynamicAdBannerRender dynamicAdBannerRender, c cVar) {
        ChannelIndexEntity.DataBean.ModuleDataBean newInstanceEntity = HugeAdBannerBean.newInstanceEntity();
        if (newInstanceEntity != null && dynamicAdBannerRender.n(((e) dynamicAdBannerRender).b.K()) && dynamicAdBannerRender.j == 0) {
            dynamicAdBannerRender.d.n0(newInstanceEntity, dynamicAdBannerRender.e);
            dynamicAdBannerRender.e = newInstanceEntity;
        }
    }

    private static /* synthetic */ void k() {
        r.a.c.c.e eVar = new r.a.c.c.e("DynamicAdBannerRender.java", DynamicAdBannerRender.class);
        m = eVar.H("method-execution", eVar.E("2", "getAdData", "com.hunantv.oversea.channel.dynamic.render.DynamicAdBannerRender", "", "", "", "void"), 109);
        n = eVar.H("method-execution", eVar.E("2", "setBannerAutoScroll", "com.hunantv.oversea.channel.dynamic.render.DynamicAdBannerRender", "boolean", "autoScroll", "", "void"), 235);
        o = eVar.H("method-execution", eVar.E("2", "addHugeAdBean", "com.hunantv.oversea.channel.dynamic.render.DynamicAdBannerRender", "", "", "", "void"), 264);
        p = eVar.H("method-execution", eVar.E("2", "showDownloadDialog", "com.hunantv.oversea.channel.dynamic.render.DynamicAdBannerRender", "java.lang.String:java.lang.String", "url:adUUID", "", "void"), 361);
    }

    public static final /* synthetic */ void m(DynamicAdBannerRender dynamicAdBannerRender, c cVar) {
        final Activity currentActivity;
        j.l.c.c.d.e eVar = ((e) dynamicAdBannerRender).b;
        if (eVar == null || (currentActivity = eVar.getCurrentActivity()) == null || !dynamicAdBannerRender.n(((e) dynamicAdBannerRender).b.K())) {
            return;
        }
        j.u.s.g gVar = new j.u.s.g();
        gVar.c0(j.l.c.x.t0.a.a().d());
        gVar.b0(j.l.c.x.t0.a.a().c());
        j.u.e.c.i.e eVar2 = new j.u.e.c.i.e();
        final long focusAid = dynamicAdBannerRender.d.getFocusAid();
        eVar2.M(gVar.K(focusAid).Q(c0.f(((e) dynamicAdBannerRender).b.K())).N(j.l.a.k.b.a()));
        eVar2.p("ADS_TYPE_SLIDEBANNER");
        eVar2.E(new BaseAdsListener() { // from class: com.hunantv.oversea.channel.dynamic.render.DynamicAdBannerRender.1
            private static final /* synthetic */ c.b e = null;

            static {
                B();
            }

            private static /* synthetic */ void B() {
                r.a.c.c.e eVar3 = new r.a.c.c.e("DynamicAdBannerRender.java", AnonymousClass1.class);
                e = eVar3.H("method-execution", eVar3.E("1", "onAdListener", "com.hunantv.oversea.channel.dynamic.render.DynamicAdBannerRender$1", "com.mgmi.ads.api.AdsListener$AdsEventType:com.mgmi.ads.api.AdWidgetInfoImp", "type:infoImp", "", "void"), (int) EventClickData.u.q1);
            }

            public static final /* synthetic */ void D(AnonymousClass1 anonymousClass1, AdsListener.AdsEventType adsEventType, AdWidgetInfoImp adWidgetInfoImp, c cVar2) {
                super.onAdListener(adsEventType, adWidgetInfoImp);
                if (!AdsListener.AdsEventType.AD_REQUEST_NET_CALLBACK.equals(adsEventType)) {
                    j.l.a.o.a.a(-1, DynamicAdBannerRender.l, "onAdListener aid=" + focusAid + " type=" + adsEventType);
                }
                if (AdsListener.AdsEventType.AD_REQUEST_SUCCESS.equals(adsEventType)) {
                    if (adWidgetInfoImp == null || DynamicAdBannerRender.this.g == null) {
                        return;
                    }
                    if (HugeMananger.h().hasHugeData() && DynamicAdBannerRender.this.j == 0) {
                        if (DynamicAdBannerRender.this.g != null) {
                            DynamicAdBannerRender.this.g.W(ExposeErrorType.EXPOSE_ERROR_HUGE_SEAT);
                            return;
                        }
                        return;
                    }
                    ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean = new ChannelIndexEntity.DataBean.ModuleDataBean();
                    moduleDataBean.adJump = "0".equals(adWidgetInfoImp.getClickThrought()) ? 2 : 1;
                    moduleDataBean.phoneImgUrl = adWidgetInfoImp.getResourceUrl();
                    moduleDataBean.adJumpUrl = adWidgetInfoImp.getClickUrl();
                    moduleDataBean.adOrigin = adWidgetInfoImp.getAdOrigin();
                    moduleDataBean.adAwayAppType = adWidgetInfoImp.getAwayAppType() == null ? 0 : adWidgetInfoImp.getAwayAppType().ordinal();
                    moduleDataBean.name = adWidgetInfoImp.getTitleText();
                    moduleDataBean.adUUID = adWidgetInfoImp.getUuid();
                    moduleDataBean.subName = adWidgetInfoImp.getDiscription();
                    moduleDataBean.bgColor = String.format("%08x", Integer.valueOf(adWidgetInfoImp.getAidColor()));
                    moduleDataBean.fontColor = "#ffffffff";
                    if (adWidgetInfoImp.isAdLogEnnable()) {
                        moduleDataBean.rightCorner = j.l.a.a.a().getResources().getString(b.r.mgmi_template_ad);
                        moduleDataBean.cornerType = "#9A000000";
                    }
                    moduleDataBean.adLogEnnable = adWidgetInfoImp.isAdLogEnnable();
                    moduleDataBean.videoGroup = "A";
                    moduleDataBean.aid = 9000189L;
                    if (adWidgetInfoImp.getResType() == 1 || adWidgetInfoImp.getResType() == 2) {
                        j.l.a.n.m.a.d("30", DynamicAdBannerRender.l, "onAdListener isBannerAdVideo type:" + adWidgetInfoImp.getResType());
                        moduleDataBean.isBannerAdVideo = true;
                    }
                    moduleDataBean.adResType = adWidgetInfoImp.getResType();
                    DynamicAdBannerRender.this.d.n0(moduleDataBean, DynamicAdBannerRender.this.e);
                    DynamicAdBannerRender.this.e = moduleDataBean;
                    if (!(((e) DynamicAdBannerRender.this).b.b() instanceof ChannelDynamicFragment) || DynamicAdBannerRender.this.g == null) {
                        return;
                    }
                    ((ChannelDynamicFragment) ((e) DynamicAdBannerRender.this).b.b()).b1(String.valueOf(moduleDataBean.hashCode()), DynamicAdBannerRender.this.g);
                } else if (AdsListener.AdsEventType.START_PLAY_SLIDE_AD.equals(adsEventType)) {
                    DynamicAdBannerRender.this.setBannerAutoScroll(false);
                } else if (AdsListener.AdsEventType.SLIDE_AD_FINISH.equals(adsEventType) || AdsListener.AdsEventType.SLIDE_AD_PLAY_ERROR.equals(adsEventType)) {
                    DynamicAdBannerRender.this.setBannerAutoScroll(true);
                } else {
                    if (AdsListener.AdsEventType.JUMP_SCHEMA.equals(adsEventType)) {
                        String clickUrl = adWidgetInfoImp == null ? "" : adWidgetInfoImp.getClickUrl();
                        String uuid = adWidgetInfoImp != null ? adWidgetInfoImp.getUuid() : "";
                        AwayAppType awayAppType = adWidgetInfoImp == null ? AwayAppType.AWAY_APP_TYPE_YES : adWidgetInfoImp.getAwayAppType();
                        if (n0.z(clickUrl)) {
                            j.l.c.z.c.d.e().a(((e) DynamicAdBannerRender.this).b.getCurrentActivity(), clickUrl, (Bundle) null);
                        } else if (n0.v(clickUrl)) {
                            DynamicAdBannerRender.this.showDownloadDialog(clickUrl, uuid);
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putString("url", clickUrl);
                            bundle.putString("adUUID", uuid);
                            bundle.putInt("away_app_type", awayAppType.ordinal());
                            bundle.putBoolean("isad", true);
                            j.l.c.j0.b.a(((e) DynamicAdBannerRender.this).b.getCurrentActivity(), bundle);
                        }
                    } else if (AdsListener.AdsEventType.JUMP_HARFSCREEN_SCHEMA.equals(adsEventType)) {
                        String clickUrl2 = adWidgetInfoImp == null ? null : adWidgetInfoImp.getClickUrl();
                        String uuid2 = adWidgetInfoImp != null ? adWidgetInfoImp.getUuid() : null;
                        if (TextUtils.isEmpty(clickUrl2)) {
                            return;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("url", clickUrl2);
                        bundle2.putString("adUUID", uuid2);
                        bundle2.putInt("screenOritention", 1);
                        bundle2.putBoolean("isad", true);
                        j.l.c.j0.b.a(((e) DynamicAdBannerRender.this).b.getCurrentActivity(), bundle2);
                    }
                }
            }

            public boolean o() {
                return !currentActivity.isDestroyed();
            }

            @WithTryCatchRuntime
            public void onAdListener(AdsListener.AdsEventType adsEventType, AdWidgetInfoImp adWidgetInfoImp) {
                LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, adsEventType, adWidgetInfoImp, r.a.c.c.e.x(e, this, this, adsEventType, adWidgetInfoImp)}).e(69648));
            }
        });
        j.u.e.c.i.d dVar = dynamicAdBannerRender.g;
        if (dVar == null) {
            j.u.e.c.i.d c = j.u.n.d.b.i().c(currentActivity, eVar2);
            if (c != null) {
                c.G(eVar2);
                dynamicAdBannerRender.g = c;
                return;
            }
            return;
        }
        dVar.G(eVar2);
    }

    private boolean n(String str) {
        return ((e) this).b != null && ChannelListEntity.isSelectedChannel(str);
    }

    public static final /* synthetic */ void o(DynamicAdBannerRender dynamicAdBannerRender, boolean z, c cVar) {
        j.l.c.c.d.e eVar;
        ChannelAdBannerLayout channelAdBannerLayout = dynamicAdBannerRender.d;
        if (channelAdBannerLayout == null || channelAdBannerLayout.a == null) {
            return;
        }
        if (z && (eVar = ((e) dynamicAdBannerRender).b) != null && eVar.O()) {
            dynamicAdBannerRender.d.a.startAutoScroll();
        } else {
            dynamicAdBannerRender.d.a.I();
        }
    }

    public static final /* synthetic */ void p(DynamicAdBannerRender dynamicAdBannerRender, String str, String str2, c cVar) {
        try {
            y0.a(dynamicAdBannerRender.f);
            d dVar = new d(((e) dynamicAdBannerRender).b.getCurrentActivity());
            dynamicAdBannerRender.f = dVar;
            dVar.m(j.l.a.a.a().getString(b.r.confirm_download)).n(b.r.reboot_app_dlg_btn_cancel).q(b.r.reboot_app_dlg_btn_ok).h(true).p(new b(dynamicAdBannerRender.f, str2, str));
            dynamicAdBannerRender.f.c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void setBannerAutoScroll(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(n, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void showDownloadDialog(String str, String str2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j(new Object[]{this, str, str2, r.a.c.c.e.x(p, this, this, str, str2)}).e(69648));
    }

    @Nullable
    public View l(Activity activity, int i) {
        if (activity == null) {
            return null;
        }
        ChannelAdBannerLayout channelAdBannerLayout = (ChannelAdBannerLayout) LayoutInflater.from(activity).inflate(i, (ViewGroup) null);
        this.d = channelAdBannerLayout;
        channelAdBannerLayout.setExtendOnclick(this.k);
        this.d.setStyleManager(((e) this).c);
        return this.d;
    }

    public void rendWithData(View view, JsonObject jsonObject, j.v.g.k.d dVar, int i) {
        super.rendWithData(view, jsonObject, dVar, i);
        if (((e) this).b == null) {
            return;
        }
        HugeMananger.h().u(false);
        this.j = i;
        if (this.h != jsonObject) {
            this.d.setScrollInterval(DynamicBanner.s2);
            this.d.t(jsonObject.getAsJsonArray("items"), dVar, i);
            this.h = jsonObject;
            addHugeAdBean();
            getAdData();
            this.i = dVar;
        }
    }

    public void setChannelCenter(j.l.c.c.d.e eVar) {
        super.setChannelCenter(eVar);
        ChannelAdBannerLayout channelAdBannerLayout = this.d;
        if (channelAdBannerLayout != null) {
            channelAdBannerLayout.setChannelCenter(eVar);
        }
    }
}
