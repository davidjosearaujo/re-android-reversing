package com.hunantv.oversea.channel.dynamic.render.ad;

import com.mgmi.ads.api.AdsListener;
import com.mgmi.ads.api.AwayAppType;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.c.u1.t.b;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BaseAdsListener extends AdsListener {
    private static final /* synthetic */ c.b a = null;

    static {
        B();
    }

    private static /* synthetic */ void B() {
        e eVar = new e("BaseAdsListener.java", BaseAdsListener.class);
        a = eVar.H("method-execution", eVar.E("1", "gotoMiniProgram", "com.hunantv.oversea.channel.dynamic.render.ad.BaseAdsListener", "com.mgmi.ads.api.AdsListener$MiniProgramType:java.lang.String:java.lang.String:com.mgmi.ads.api.AwayAppType", "type:orginId:path:awayapptype", "", "void"), 23);
    }

    public static final /* synthetic */ void C(BaseAdsListener baseAdsListener, AdsListener.MiniProgramType miniProgramType, String str, String str2, AwayAppType awayAppType, c cVar) {
        if (miniProgramType == AdsListener.MiniProgramType.TYPE_MINIPROGRAM) {
            AwayAppType awayAppType2 = AwayAppType.AWAY_APP_TYPE_YES;
        }
    }

    @WithTryCatchRuntime
    public void gotoMiniProgram(AdsListener.MiniProgramType miniProgramType, String str, String str2, AwayAppType awayAppType) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b(new Object[]{this, miniProgramType, str, str2, awayAppType, e.y(a, this, this, new Object[]{miniProgramType, str, str2, awayAppType})}).e(69648));
    }
}
