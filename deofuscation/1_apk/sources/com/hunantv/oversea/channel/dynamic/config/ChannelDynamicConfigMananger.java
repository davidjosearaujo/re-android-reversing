package com.hunantv.oversea.channel.dynamic.config;

import android.text.TextUtils;
import com.alipay.sdk.util.g;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.c0;
import j.l.a.b0.f0;
import j.l.c.c.c.n1.a;
import j.v.j.b;
import java.io.Serializable;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelDynamicConfigMananger {
    private static final String a = "DYNAMIC_CHANNEL_CONFIG";
    private static final String b = "DYNAMIC_CHANNEL_AD_CONFIG";
    private static final String c = "CHANNEL_MODULE_CONFIG";
    private static final String d = "channel_huge_id";
    private static List<ChannelConfig> e;
    private static int f;
    private static boolean g;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private static final /* synthetic */ c.b j = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class AdInfo implements JsonInterface {
        private static final long serialVersionUID = 4720140802262521062L;
        public String focusId;
        public String hugeId;

        private AdInfo() {
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ChannelConfig extends JsonEntity implements Serializable, JsonInterface {
        public String channelId;
        public String config;

        private ChannelConfig() {
        }
    }

    static {
        a();
        String n = f0.n(a, "");
        if (!TextUtils.isEmpty(n)) {
            e = b.t(n, ChannelConfig.class);
        }
        f = c0.g(f0.n(c, "5"), 5);
        g = TextUtils.equals("1", f0.n(b, "0"));
    }

    private ChannelDynamicConfigMananger() {
    }

    private static /* synthetic */ void a() {
        e eVar = new e("ChannelDynamicConfigMananger.java", ChannelDynamicConfigMananger.class);
        h = eVar.H("method-execution", eVar.E("9", "isDynamicLoad", "com.hunantv.oversea.channel.dynamic.config.ChannelDynamicConfigMananger", "java.lang.String", RemoteMessageConst.Notification.CHANNEL_ID, "", "boolean"), 98);
        i = eVar.H("method-execution", eVar.E("9", "isAdDynamicLoad", "com.hunantv.oversea.channel.dynamic.config.ChannelDynamicConfigMananger", "", "", "", "boolean"), 123);
        j = eVar.H("method-execution", eVar.E("9", "getDynamicLoadMoudelCount", "com.hunantv.oversea.channel.dynamic.config.ChannelDynamicConfigMananger", "", "", "", "int"), 131);
    }

    public static String c(String str) {
        if (str != null) {
            AdInfo adInfo = (AdInfo) b.r("{" + str + g.d, AdInfo.class);
            String str2 = adInfo.focusId;
            j(adInfo.hugeId);
            return str2;
        }
        return null;
    }

    public static String d() {
        return f0.m(d);
    }

    public static final /* synthetic */ boolean f(String str, c cVar) {
        List<ChannelConfig> list = e;
        if (list != null && !list.isEmpty()) {
            for (ChannelConfig channelConfig : e) {
                if (channelConfig != null && TextUtils.equals(channelConfig.channelId, str)) {
                    return TextUtils.equals(channelConfig.config, "1");
                }
            }
        }
        return false;
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f0.y(a, str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e = b.t(str, ChannelConfig.class);
    }

    @WithTryCatchRuntime
    public static int getDynamicLoadMoudelCount() {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.n1.c(new Object[]{e.v(j, (Object) null, (Object) null)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)));
    }

    public static void h(String str) {
        f0.y(b, str);
        g = TextUtils.equals("1", f0.n(b, "0"));
    }

    public static void i(String str) {
        f0.y(c, str);
        f = c0.g(f0.n(c, "5"), 5);
    }

    @WithTryCatchRuntime
    public static boolean isAdDynamicLoad() {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.n1.b(new Object[]{e.v(i, (Object) null, (Object) null)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)));
    }

    @WithTryCatchRuntime
    public static boolean isDynamicLoad(String str) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a(new Object[]{str, e.w(h, (Object) null, (Object) null, str)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)));
    }

    public static void j(String str) {
        if (str == null) {
            str = "";
        }
        f0.y(d, str);
    }
}
