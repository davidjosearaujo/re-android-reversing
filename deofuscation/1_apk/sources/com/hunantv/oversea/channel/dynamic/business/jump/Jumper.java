package com.hunantv.oversea.channel.dynamic.business.jump;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.mgmi.ads.api.AwayAppType;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.c0.d;
import j.l.c.c.b;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class Jumper {
    public static final String a = "report_fpa";
    public static final String b = "is_ad";
    public static final String c = "is_banner_ad";
    private static Jumper d;
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private static final /* synthetic */ c.b g = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends d.f {
        public final /* synthetic */ d b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, d dVar2, Context context, String str) {
            super(dVar);
            this.b = dVar2;
            this.c = context;
            this.d = str;
        }

        public void onLeftButtonClicked() {
            super.onLeftButtonClicked();
            this.b.dismiss();
        }

        public void onRightButtonClicked() {
            super.onRightButtonClicked();
            this.b.dismiss();
            Jumper.this.jumpOtherApp(this.c, this.d);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JumpKind.values().length];
            a = iArr;
            try {
                iArr[JumpKind.KIND_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JumpKind.KIND_OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JumpKind.KIND_H5.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JumpKind.KIND_BROWSER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        b();
    }

    private static /* synthetic */ void b() {
        e eVar = new e("Jumper.java", Jumper.class);
        e = eVar.H("method-execution", eVar.E("1", "jumpFromChannel", "com.hunantv.oversea.channel.dynamic.business.jump.Jumper", "android.content.Context:com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean:java.lang.Object", "context:bean:dataCollect", "", "void"), 60);
        f = eVar.H("method-execution", eVar.E("1", "jumpOtherAppByAd", "com.hunantv.oversea.channel.dynamic.business.jump.Jumper", "android.content.Context:java.lang.String:int", "context:pageUrl:adAwayAppType", "", "void"), (int) EventClickData.u.r1);
        g = eVar.H("method-execution", eVar.E("2", "jumpOtherApp", "com.hunantv.oversea.channel.dynamic.business.jump.Jumper", "android.content.Context:java.lang.String", "context:pageUrl", "", "void"), (int) EventClickData.u.E1);
    }

    public static Jumper c() {
        if (d == null) {
            synchronized (Jumper.class) {
                if (d == null) {
                    d = new Jumper();
                }
            }
        }
        return d;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void d(com.hunantv.oversea.channel.dynamic.business.jump.Jumper r3, android.content.Context r4, com.hunantv.oversea.channel.net.entity.ChannelIndexEntity.DataBean.ModuleDataBean r5, java.lang.Object r6, r.a.b.c r7) {
        /*
            if (r5 == 0) goto Lab
            if (r4 != 0) goto L6
            goto Lab
        L6:
            r7 = 0
            if (r6 == 0) goto L30
            boolean r0 = r6 instanceof java.util.HashMap
            if (r0 == 0) goto L2a
            java.util.HashMap r6 = (java.util.HashMap) r6
            java.lang.String r7 = "is_ad"
            boolean r7 = r6.containsKey(r7)
            java.lang.String r0 = "is_banner_ad"
            boolean r0 = r6.containsKey(r0)
            java.lang.String r1 = "report_fpa"
            boolean r2 = r6.containsKey(r1)
            if (r2 == 0) goto L31
            java.lang.Object r6 = r6.get(r1)
            java.lang.String r6 = (java.lang.String) r6
            goto L31
        L2a:
            boolean r0 = r6 instanceof java.lang.String
            if (r0 == 0) goto L30
            java.lang.String r6 = (java.lang.String) r6
        L30:
            r0 = 0
        L31:
            int[] r6 = com.hunantv.oversea.channel.dynamic.business.jump.Jumper.b.a
            java.lang.String r1 = r5.jumpKind
            com.hunantv.oversea.channel.dynamic.business.jump.JumpKind r1 = com.hunantv.oversea.channel.dynamic.business.jump.JumpKind.from(r1)
            int r1 = r1.ordinal()
            r6 = r6[r1]
            r1 = 2
            r2 = 0
            if (r6 == r1) goto L9a
            r1 = 3
            if (r6 == r1) goto L5c
            r1 = 4
            if (r6 == r1) goto L4a
            goto Lab
        L4a:
            if (r7 == 0) goto L56
            if (r0 == 0) goto L56
            java.lang.String r6 = r5.pageUrl
            int r5 = r5.adAwayAppType
            r3.jumpOtherAppByAd(r4, r6, r5)
            goto Lab
        L56:
            java.lang.String r5 = r5.pageUrl
            r3.jumpOtherApp(r4, r5)
            goto Lab
        L5c:
            java.lang.String r3 = r5.pageUrl
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto Lab
            java.lang.String r3 = r5.pageUrl
            boolean r3 = j.l.a.b0.n0.z(r3)
            if (r3 == 0) goto L76
            j.l.c.z.c.d r3 = j.l.c.z.c.d.e()
            java.lang.String r5 = r5.pageUrl
            r3.a(r4, r5, r2)
            goto Lab
        L76:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r6 = r5.pageUrl
            java.lang.String r7 = "url"
            r3.putString(r7, r6)
            java.lang.String r6 = r5.adUUID
            java.lang.String r7 = "adUUID"
            r3.putString(r7, r6)
            int r5 = r5.adAwayAppType
            java.lang.String r6 = "away_app_type"
            r3.putInt(r6, r5)
            r5 = 1
            java.lang.String r6 = "isad"
            r3.putBoolean(r6, r5)
            j.l.c.j0.b.a(r4, r3)
            goto Lab
        L9a:
            java.lang.String r3 = r5.pageUrl
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto Lab
            j.l.c.z.c.d r3 = j.l.c.z.c.d.e()
            java.lang.String r5 = r5.pageUrl
            r3.a(r4, r5, r2)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.oversea.channel.dynamic.business.jump.Jumper.d(com.hunantv.oversea.channel.dynamic.business.jump.Jumper, android.content.Context, com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean, java.lang.Object, r.a.b.c):void");
    }

    public static final /* synthetic */ void e(Jumper jumper, Context context, String str, int i, c cVar) {
        if (i == AwayAppType.AWAY_APP_TYPE_NO.ordinal()) {
            jumper.jumpOtherApp(context, str);
            return;
        }
        d dVar = new d(context);
        dVar.m(j.l.a.a.a().getString(b.r.confim_leave_mgtv)).n(b.r.me_setting_confirm_dialog_btn_cancel).q(b.r.reboot_app_dlg_btn_ok).s(true).h(true).p(new a(dVar, dVar, context, str));
        dVar.c();
    }

    public static final /* synthetic */ void f(Jumper jumper, Context context, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            j.l.c.e0.a.a.a.h(intent);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void jumpOtherApp(Context context, String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.l1.b.c(new Object[]{this, context, str, e.x(g, this, this, context, str)}).e(69648));
    }

    @WithTryCatchRuntime
    public void jumpFromChannel(@Nullable Context context, @Nullable ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, @Nullable Object obj) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.l1.b.a(new Object[]{this, context, moduleDataBean, obj, e.y(e, this, this, new Object[]{context, moduleDataBean, obj})}).e(69648));
    }

    @WithTryCatchRuntime
    public void jumpOtherAppByAd(Context context, String str, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.l1.b.b(new Object[]{this, context, str, r.a.c.b.e.k(i), e.y(f, this, this, new Object[]{context, str, r.a.c.b.e.k(i)})}).e(69648));
    }
}
