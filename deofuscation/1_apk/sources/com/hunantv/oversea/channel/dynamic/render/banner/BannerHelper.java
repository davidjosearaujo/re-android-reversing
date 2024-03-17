package com.hunantv.oversea.channel.dynamic.render.banner;

import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.n0;
import j.l.c.c.c.u1.u.j;
import j.l.c.c.c.u1.u.k;
import java.util.Iterator;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BannerHelper {
    private static final /* synthetic */ c.b a = null;
    private static final /* synthetic */ c.b b = null;

    static {
        a();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("BannerHelper.java", BannerHelper.class);
        a = eVar.H("method-execution", eVar.E("9", "isAdImageResExist", "com.hunantv.oversea.channel.dynamic.render.banner.BannerHelper", "java.util.List", "mModules", "", "boolean"), 24);
        b = eVar.H("method-execution", eVar.E("9", "isAdImageResExist", "com.hunantv.oversea.channel.dynamic.render.banner.BannerHelper", "com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean", "moduleDataBean", "", "boolean"), 43);
    }

    public static final /* synthetic */ boolean b(List list, c cVar) {
        if (list == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (isAdImageResExist((ChannelIndexEntity.DataBean.ModuleDataBean) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ boolean c(ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, c cVar) {
        if (moduleDataBean == null) {
            return false;
        }
        return (n0.y(moduleDataBean.adJumpUrl) && moduleDataBean.adJump == 0) ? false : true;
    }

    @WithTryCatchRuntime
    public static boolean isAdImageResExist(@Nullable List<ChannelIndexEntity.DataBean.ModuleDataBean> list) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j(new Object[]{list, e.w(a, (Object) null, (Object) null, list)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)));
    }

    @WithTryCatchRuntime
    public static boolean isAdImageResExist(@Nullable ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{moduleDataBean, e.w(b, (Object) null, (Object) null, moduleDataBean)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)));
    }
}
