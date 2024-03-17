package com.hunantv.oversea.channel.dynamic.render.ad;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hunantv.oversea.business.ad.huge.HugeMananger;
import com.hunantv.oversea.channel.dynamic.business.jump.Jumper;
import com.hunantv.oversea.channel.dynamic.data.ModuleData;
import com.hunantv.oversea.channel.dynamic.video.VideoPreviewView;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.mgmi.reporter.ConvertionType;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.n0;
import j.l.a.b0.v;
import j.l.a.c0.d;
import j.l.c.c.b;
import j.l.c.c.c.u1.t.f;
import j.l.c.c.c.u1.t.g;
import j.l.c.c.c.u1.t.h;
import j.l.c.c.c.u1.t.i;
import j.l.c.c.c.u1.t.j;
import j.l.c.c.c.u1.t.k;
import j.l.c.c.d.e;
import j.s.j.y0;
import j.u.e.c.i.d;
import j.v.k.g.b;
import java.util.HashMap;
import java.util.Map;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicAdPresenter {
    private static final String f = "ChannelDynamicPresenter";
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private static final /* synthetic */ c.b j = null;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    public e a;
    private Map<String, d> b = new HashMap();
    private Map<String, Boolean> c = new HashMap();
    private volatile d d;
    private j.l.a.c0.d e;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends d.f {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j.l.a.c0.d dVar, String str, String str2) {
            super(dVar);
            this.b = str;
            this.c = str2;
        }

        public void onLeftButtonClicked() {
            super.onLeftButtonClicked();
            j.u.o.a.i().e(j.l.a.a.a(), this.b, ConvertionType.CONVERTION_TYPE_USER_CANCEL_DOWNLOAD, (String) null, (String) null);
            y0.a(DynamicAdPresenter.this.e);
        }

        public void onRightButtonClicked() {
            super.onRightButtonClicked();
            y0.a(DynamicAdPresenter.this.e);
            b.h().A(DynamicAdPresenter.this.a.getCurrentActivity(), this.b, this.c);
        }
    }

    static {
        b();
    }

    public DynamicAdPresenter(e eVar) {
        this.a = eVar;
    }

    private static /* synthetic */ void b() {
        r.a.c.c.e eVar = new r.a.c.c.e("DynamicAdPresenter.java", DynamicAdPresenter.class);
        g = eVar.H("method-execution", eVar.E("1", "showDownloadDialog", "com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter", "java.lang.String:java.lang.String", "url:adUUID", "", "void"), 75);
        h = eVar.H("method-execution", eVar.E("1", "bannerAdClick", "com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter", "android.view.View:int", "clickView:listIndex", "", "void"), 108);
        i = eVar.H("method-execution", eVar.E("2", "reportBannerAdClick", "com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter", "android.view.View:com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean", "clickView:bean", "", "void"), 154);
        j = eVar.H("method-execution", eVar.E("1", "getAdLoader", "com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter", "com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean", "moduleDataBean", "", "com.mgmi.ads.api.adsloader.AdsLoaderInterface"), 218);
        k = eVar.H("method-execution", eVar.E("1", "notifyAdVisible", "com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter", "boolean", "visible", "", "void"), 226);
        l = eVar.H("method-execution", eVar.E("2", "updateAdVisible", "com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter", "com.mgmi.ads.api.adsloader.AdsLoaderInterface:boolean", "adsLoaderInterface:visible", "", "void"), 246);
        m = eVar.H("method-execution", eVar.E("1", "updateAdView", "com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter", "", "", "", "void"), 257);
        n = eVar.H("method-execution", eVar.E("1", "resumeAd", "com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter", "int:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "listIndex:dslBean", "", "void"), 269);
        o = eVar.H("method-execution", eVar.E("1", "clearAd", "com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter", "", "", "", "void"), 280);
    }

    public static final /* synthetic */ void c(DynamicAdPresenter dynamicAdPresenter, View view, int i2, c cVar) {
        ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean = (ChannelIndexEntity.DataBean.ModuleDataBean) view.getTag(b.j.dsl_tag_item_native_module);
        if (moduleDataBean == null || n0.y(moduleDataBean.adJumpUrl)) {
            if (moduleDataBean != null) {
                dynamicAdPresenter.reportBannerAdClick(view, moduleDataBean);
                String str = moduleDataBean.pageUrl;
                if (!TextUtils.isEmpty(str) && n0.v(str)) {
                    dynamicAdPresenter.showDownloadDialog(str, moduleDataBean.adUUID);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(Jumper.b, Jumper.b);
                hashMap.put(Jumper.c, Jumper.c);
                Jumper.c().jumpFromChannel(dynamicAdPresenter.a.getCurrentActivity(), moduleDataBean, hashMap);
                return;
            }
            return;
        }
        dynamicAdPresenter.reportBannerAdClick(view, moduleDataBean);
        if (1 == moduleDataBean.adJump) {
            Jumper.c().jumpOtherAppByAd(dynamicAdPresenter.a.getCurrentActivity(), moduleDataBean.adJumpUrl, moduleDataBean.adAwayAppType);
        } else if (n0.v(moduleDataBean.adJumpUrl)) {
            dynamicAdPresenter.showDownloadDialog(moduleDataBean.adJumpUrl, moduleDataBean.adUUID);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("url", moduleDataBean.adJumpUrl);
            bundle.putString("adUUID", moduleDataBean.adUUID);
            bundle.putInt("away_app_type", moduleDataBean.adAwayAppType);
            bundle.putBoolean("isad", true);
            j.l.c.j0.b.a(dynamicAdPresenter.a.getCurrentActivity(), bundle);
        }
    }

    public static final /* synthetic */ void d(DynamicAdPresenter dynamicAdPresenter, c cVar) {
        j.u.e.c.i.d value;
        for (Map.Entry<String, j.u.e.c.i.d> entry : dynamicAdPresenter.b.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.finish();
            }
        }
        dynamicAdPresenter.b.clear();
        dynamicAdPresenter.c.clear();
        dynamicAdPresenter.k();
    }

    public static final /* synthetic */ j.u.e.c.i.d e(DynamicAdPresenter dynamicAdPresenter, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, c cVar) {
        if (moduleDataBean == null) {
            return null;
        }
        return dynamicAdPresenter.b.get(String.valueOf(moduleDataBean.hashCode()));
    }

    public static final /* synthetic */ void i(DynamicAdPresenter dynamicAdPresenter, boolean z, c cVar) {
        for (Map.Entry<String, j.u.e.c.i.d> entry : dynamicAdPresenter.b.entrySet()) {
            if (entry != null) {
                j.u.e.c.i.d value = entry.getValue();
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && dynamicAdPresenter.c.containsKey(key)) {
                    j.l.a.n.m.a.d("30", f, "notifyAdVisible filter AdBanner: " + value);
                } else {
                    dynamicAdPresenter.updateAdVisible(value, z);
                    j.l.a.n.m.a.d("30", f, "notifyAdVisible: " + value);
                }
            }
        }
    }

    public static final /* synthetic */ void n(DynamicAdPresenter dynamicAdPresenter, View view, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, c cVar) {
        if (HugeMananger.h().l(moduleDataBean != null ? moduleDataBean.videoUrl : "") && view != null) {
            View findViewById = view.findViewById(b.j.video_preview_frame);
            boolean z = false;
            if (findViewById instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) findViewById;
                int i2 = 0;
                while (true) {
                    if (i2 >= viewGroup.getChildCount()) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof VideoPreviewView) {
                        z = ((VideoPreviewView) childAt).isPlaying();
                        break;
                    }
                    i2++;
                }
            }
            if (z) {
                HugeMananger.h().onHugeVideoClick();
            } else {
                HugeMananger.h().onHugePicClick();
            }
            v.c(f, "reportBannerAdClick huge isVideoClick:" + z);
            return;
        }
        j.u.e.c.i.d adLoader = dynamicAdPresenter.getAdLoader(moduleDataBean);
        if (adLoader != null) {
            adLoader.onClick();
            v.c(f, "reportBannerAdClick adsLoaderInterface onClick");
        }
    }

    public static final /* synthetic */ void o(DynamicAdPresenter dynamicAdPresenter, int i2, ModuleData.DataBean.DSLBean dSLBean, c cVar) {
        j.u.e.c.i.d dVar;
        if (dSLBean == null || dSLBean.data == null || (dVar = dynamicAdPresenter.b.get(dynamicAdPresenter.f(i2, dSLBean))) == null) {
            return;
        }
        dVar.resume();
    }

    public static final /* synthetic */ void q(DynamicAdPresenter dynamicAdPresenter, String str, String str2, c cVar) {
        try {
            y0.a(dynamicAdPresenter.e);
            j.l.a.c0.d dVar = new j.l.a.c0.d(dynamicAdPresenter.a.getCurrentActivity());
            dynamicAdPresenter.e = dVar;
            dVar.m(j.l.a.a.a().getString(b.r.confirm_download)).n(b.r.reboot_app_dlg_btn_cancel).q(b.r.reboot_app_dlg_btn_ok).h(true).p(new a(dynamicAdPresenter.e, str2, str));
            dynamicAdPresenter.e.c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final /* synthetic */ void r(DynamicAdPresenter dynamicAdPresenter, c cVar) {
        j.u.e.c.i.d value;
        for (Map.Entry<String, j.u.e.c.i.d> entry : dynamicAdPresenter.b.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.H();
            }
        }
    }

    @WithTryCatchRuntime
    private void reportBannerAdClick(View view, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, view, moduleDataBean, r.a.c.c.e.x(i, this, this, view, moduleDataBean)}).e(69648));
    }

    public static final /* synthetic */ void s(DynamicAdPresenter dynamicAdPresenter, j.u.e.c.i.d dVar, boolean z, c cVar) {
        if (dVar != null) {
            if (z) {
                dVar.resume();
            } else {
                dVar.B();
            }
        }
    }

    @WithTryCatchRuntime
    private void updateAdVisible(j.u.e.c.i.d dVar, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.t.c(new Object[]{this, dVar, r.a.c.b.e.a(z), r.a.c.c.e.x(l, this, this, dVar, r.a.c.b.e.a(z))}).e(69648));
    }

    @WithTryCatchRuntime
    public void bannerAdClick(View view, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h(new Object[]{this, view, r.a.c.b.e.k(i2), r.a.c.c.e.x(h, this, this, view, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    public void clearAd() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, r.a.c.c.e.v(o, this, this)}).e(69648));
    }

    @NonNull
    public String f(int i2, ModuleData.DataBean.DSLBean dSLBean) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        if (dSLBean != null && dSLBean.data != null) {
            sb.append("-");
            sb.append(dSLBean.data.hashCode());
        }
        return sb.toString();
    }

    public j.u.e.c.i.d g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.b.get(str);
    }

    @Nullable
    @WithTryCatchRuntime
    public j.u.e.c.i.d getAdLoader(@Nullable ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean) {
        return (j.u.e.c.i.d) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j(new Object[]{this, moduleDataBean, r.a.c.c.e.w(j, this, this, moduleDataBean)}).e(69648));
    }

    public Map<String, j.u.e.c.i.d> h() {
        return this.b;
    }

    public void j(ViewGroup viewGroup, int i2, int i3) {
        try {
            if (this.d != null) {
                this.d.P((ViewGroup) null, i2, i3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void k() {
        this.d = null;
    }

    public void l(String str, j.u.e.c.i.d dVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, dVar);
    }

    public void m(String str, j.u.e.c.i.d dVar) {
        this.c.put(str, Boolean.TRUE);
        l(str, dVar);
    }

    @WithTryCatchRuntime
    public void notifyAdVisible(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(k, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    public void p(j.u.e.c.i.d dVar) {
        this.d = dVar;
    }

    @WithTryCatchRuntime
    public void resumeAd(int i2, ModuleData.DataBean.DSLBean dSLBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.t.e(new Object[]{this, r.a.c.b.e.k(i2), dSLBean, r.a.c.c.e.x(n, this, this, r.a.c.b.e.k(i2), dSLBean)}).e(69648));
    }

    @WithTryCatchRuntime
    public void showDownloadDialog(String str, String str2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g(new Object[]{this, str, str2, r.a.c.c.e.x(g, this, this, str, str2)}).e(69648));
    }

    @WithTryCatchRuntime
    public void updateAdView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.t.d(new Object[]{this, r.a.c.c.e.v(m, this, this)}).e(69648));
    }
}
