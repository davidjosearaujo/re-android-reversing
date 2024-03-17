package com.hunantv.oversea.channel.dynamic.render.banner;

import android.view.View;
import android.view.ViewGroup;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.n.m.a;
import j.l.c.c.c.u1.u.f;
import j.l.c.c.c.u1.u.g;
import j.l.c.c.c.u1.u.h;
import j.l.c.c.c.u1.u.i;
import j.u.e.c.i.d;
import java.util.Map;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BannerAdVideoHelper {
    private static final String b = "BannerAdVideoHelper";
    private static final /* synthetic */ c.b c = null;
    private static final /* synthetic */ c.b d = null;
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private d a;

    static {
        a();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("BannerAdVideoHelper.java", BannerAdVideoHelper.class);
        c = eVar.H("method-execution", eVar.E("1", "renderAdView", "com.hunantv.oversea.channel.dynamic.render.banner.BannerAdVideoHelper", "com.hunantv.oversea.channel.msg.IChannelCenter:android.view.View:com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean:boolean", "channelCenter:parentView:data:isBigBanner", "", "void"), 34);
        d = eVar.H("method-execution", eVar.E("1", "notifyAdChanged", "com.hunantv.oversea.channel.dynamic.render.banner.BannerAdVideoHelper", "com.hunantv.oversea.channel.msg.IChannelCenter:java.lang.Object:boolean", "channelCenter:data:isBigBanner", "", "void"), 52);
        e = eVar.H("method-execution", eVar.E("1", "notifyAdVisible", "com.hunantv.oversea.channel.dynamic.render.banner.BannerAdVideoHelper", "com.hunantv.oversea.channel.msg.IChannelCenter:java.lang.Object:boolean:boolean", "channelCenter:data:isBigBanner:isAttachedToWindow", "", "void"), 86);
        f = eVar.H("method-execution", eVar.E("2", "getAdLoader", "com.hunantv.oversea.channel.dynamic.render.banner.BannerAdVideoHelper", "com.hunantv.oversea.channel.msg.IChannelCenter:com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean:boolean", "channelCenter:data:isBigBanner", "", "com.mgmi.ads.api.adsloader.AdsLoaderInterface"), 114);
    }

    public static final /* synthetic */ d b(BannerAdVideoHelper bannerAdVideoHelper, j.l.c.c.d.e eVar, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, boolean z, c cVar) {
        Map I;
        if (eVar == null || moduleDataBean == null || !moduleDataBean.isBannerAdVideo || (I = eVar.I()) == null) {
            return null;
        }
        return (d) I.get(String.valueOf(moduleDataBean.hashCode()));
    }

    public static final /* synthetic */ void c(BannerAdVideoHelper bannerAdVideoHelper, j.l.c.c.d.e eVar, Object obj, boolean z, c cVar) {
        boolean z2;
        d dVar;
        if (obj instanceof ChannelIndexEntity.DataBean.ModuleDataBean) {
            ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean = (ChannelIndexEntity.DataBean.ModuleDataBean) obj;
            z2 = moduleDataBean.isBannerAdVideo;
            dVar = bannerAdVideoHelper.getAdLoader(eVar, moduleDataBean, z);
        } else {
            z2 = false;
            dVar = null;
        }
        if (dVar != null) {
            bannerAdVideoHelper.a = dVar;
            if (z2 && eVar.O()) {
                a.d("30", b, "notifyAdChanged resume");
                dVar.resume();
                return;
            }
            a.d("30", b, "notifyAdChanged pause by invisible");
            dVar.B();
        } else if (bannerAdVideoHelper.a != null) {
            a.d("30", b, "notifyAdChanged pause");
            bannerAdVideoHelper.a.B();
            bannerAdVideoHelper.a = null;
        }
    }

    public static final /* synthetic */ void d(BannerAdVideoHelper bannerAdVideoHelper, j.l.c.c.d.e eVar, Object obj, boolean z, boolean z2, c cVar) {
        d dVar;
        boolean z3;
        if (obj instanceof ChannelIndexEntity.DataBean.ModuleDataBean) {
            ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean = (ChannelIndexEntity.DataBean.ModuleDataBean) obj;
            z3 = moduleDataBean.isBannerAdVideo;
            dVar = bannerAdVideoHelper.getAdLoader(eVar, moduleDataBean, z);
        } else {
            dVar = null;
            z3 = false;
        }
        if (dVar != null) {
            bannerAdVideoHelper.a = dVar;
            if (z3 && z2 && eVar.O()) {
                a.d("30", b, "notifyAdVisible isAttachedToWindow true");
                dVar.resume();
                return;
            }
            a.d("30", b, "notifyAdVisible isAttachedToWindow false");
            dVar.B();
        }
    }

    public static final /* synthetic */ void e(BannerAdVideoHelper bannerAdVideoHelper, j.l.c.c.d.e eVar, View view, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, boolean z, c cVar) {
        d adLoader;
        if (eVar == null || view == null || moduleDataBean == null || (adLoader = bannerAdVideoHelper.getAdLoader(eVar, moduleDataBean, z)) == null || !moduleDataBean.isBannerAdVideo || !(view instanceof ViewGroup)) {
            return;
        }
        adLoader.g((ViewGroup) view);
    }

    @WithTryCatchRuntime
    private d getAdLoader(j.l.c.c.d.e eVar, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, boolean z) {
        return (d) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, eVar, moduleDataBean, r.a.c.b.e.a(z), e.y(f, this, this, new Object[]{eVar, moduleDataBean, r.a.c.b.e.a(z)})}).e(69648));
    }

    @WithTryCatchRuntime
    public void notifyAdChanged(j.l.c.c.d.e eVar, Object obj, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g(new Object[]{this, eVar, obj, r.a.c.b.e.a(z), e.y(d, this, this, new Object[]{eVar, obj, r.a.c.b.e.a(z)})}).e(69648));
    }

    @WithTryCatchRuntime
    public void notifyAdVisible(j.l.c.c.d.e eVar, Object obj, boolean z, boolean z2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h(new Object[]{this, eVar, obj, r.a.c.b.e.a(z), r.a.c.b.e.a(z2), e.y(e, this, this, new Object[]{eVar, obj, r.a.c.b.e.a(z), r.a.c.b.e.a(z2)})}).e(69648));
    }

    @WithTryCatchRuntime
    public void renderAdView(j.l.c.c.d.e eVar, View view, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, eVar, view, moduleDataBean, r.a.c.b.e.a(z), e.y(c, this, this, new Object[]{eVar, view, moduleDataBean, r.a.c.b.e.a(z)})}).e(69648));
    }
}
