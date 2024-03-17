package com.hunantv.oversea.channel.dynamic.render.ad;

import com.facebook.internal.NativeProtocol;
import com.hunantv.oversea.business.ad.huge.HugeMananger;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.mgmi.ads.api.AwayAppType;
import com.mgmi.ads.api.adview.HugeBootAdView;
import com.mgmi.net.bean.CustomBootAdBean;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.a;
import j.l.c.c.b;
import j.l.c.c.c.u1.t.l;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class HugeAdBannerBean {
    private static final /* synthetic */ c.b a = null;

    static {
        a();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("HugeAdBannerBean.java", HugeAdBannerBean.class);
        a = eVar.H("method-execution", eVar.E("9", "newInstanceEntity", "com.hunantv.oversea.channel.dynamic.render.ad.HugeAdBannerBean", "", "", "", "com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean"), 23);
    }

    public static final /* synthetic */ ChannelIndexEntity.DataBean.ModuleDataBean b(c cVar) {
        if (HugeMananger.h().hasHugeData() && HugeMananger.h().b()) {
            HugeBootAdView g = HugeMananger.h().g();
            ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean = new ChannelIndexEntity.DataBean.ModuleDataBean();
            moduleDataBean.phoneImgUrl = g.getPicUrl();
            moduleDataBean.imgHVUrl = g.getThumbnail();
            CustomBootAdBean adJumpData = g.getAdJumpData();
            if (adJumpData != null) {
                moduleDataBean.adJumpUrl = adJumpData.getClickUrl();
                moduleDataBean.jumpId = adJumpData.jumpid;
                moduleDataBean.jumpKind = adJumpData.jumpkind;
                moduleDataBean.childId = adJumpData.childId;
                moduleDataBean.pageUrl = adJumpData.pageUrl;
                moduleDataBean.adAwayAppType = adJumpData.getAwayAppType() == AwayAppType.AWAY_APP_TYPE_NO ? 1 : 0;
            }
            moduleDataBean.adJump = 3;
            moduleDataBean.adOrigin = g.getOrigin();
            moduleDataBean.bgColor = String.format("%08x", Integer.valueOf(g.getAidColor()));
            moduleDataBean.videoId = "0";
            moduleDataBean.videoUrl = g.getSmallVideoPath();
            HugeMananger.h().y(moduleDataBean.videoUrl);
            moduleDataBean.fontColor = "#ffffffff";
            moduleDataBean.videoGroup = "A";
            moduleDataBean.adLogEnnable = g.w1();
            if (g.w1()) {
                moduleDataBean.rightCorner = a.a().getResources().getString(b.r.mgmi_template_ad);
                moduleDataBean.cornerType = "#9A000000";
            }
            return moduleDataBean;
        }
        return null;
    }

    @WithTryCatchRuntime
    public static ChannelIndexEntity.DataBean.ModuleDataBean newInstanceEntity() {
        return (ChannelIndexEntity.DataBean.ModuleDataBean) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{e.v(a, (Object) null, (Object) null)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }
}
