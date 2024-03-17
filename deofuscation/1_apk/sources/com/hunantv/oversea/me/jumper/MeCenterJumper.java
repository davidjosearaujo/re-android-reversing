package com.hunantv.oversea.me.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Label;
import com.facebook.internal.NativeProtocol;
import com.hunantv.oversea.me.data.CardData;
import com.hunantv.oversea.me.ui.area.MeAreaActivity;
import com.hunantv.oversea.me.ui.setting.MeSettingActivity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.n0;
import j.l.a.b0.p0;
import j.l.a.k.b;
import j.l.c.k.f.a;
import j.l.c.k.f.h;
import j.l.c.z.c.d;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeCenterJumper {
    private static final String a = "MeJumper";
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private static final int h = 7;
    private static final int i = 9;
    private static final int j = 10;
    private static final int k = 11;
    private static final int l = 12;
    private static final int m = 13;
    private static final int n = 14;
    private static final int o = 17;
    private static final int p = 19;
    private static final int q = 20;
    private static final int r = 21;
    private static final /* synthetic */ c.b s = null;

    static {
        a();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("MeCenterJumper.java", MeCenterJumper.class);
        s = eVar.H("method-execution", eVar.E("9", "jump", "com.hunantv.oversea.me.jumper.MeCenterJumper", "android.content.Context:com.hunantv.oversea.me.data.CardData$CardModuleData", "ctx:cardModuleData", "", "void"), 71);
    }

    public static final /* synthetic */ void b(Context context, CardData.CardModuleData cardModuleData, c cVar) {
        if (cardModuleData != null && context != null) {
            if (TextUtils.isEmpty(cardModuleData.jumpId) && !TextUtils.isEmpty(cardModuleData.pageUrl)) {
                if (n0.z(cardModuleData.pageUrl)) {
                    d.i(context, cardModuleData.pageUrl);
                } else {
                    j.l.c.k.h.c.b(context, cardModuleData.pageUrl);
                }
                if (TextUtils.isEmpty(cardModuleData.itemId)) {
                    return;
                }
                a.h(cardModuleData.itemId, false);
                return;
            }
            int parseInt = Integer.parseInt(cardModuleData.jumpId);
            String str = "";
            if (parseInt == 2) {
                c(context, MeSettingActivity.class);
                a.k();
            } else if (parseInt == 6) {
                d.i(context, h.c());
            } else if (parseInt != 17) {
                switch (parseInt) {
                    case 9:
                        if (j.l.c.k.h.a.g()) {
                            j.l.c.k.h.c.b(context, "https://www.mgtv.com/v/m/v/2017/cash_coupon/my/");
                        } else {
                            j.l.c.k.h.a.h(context, 5);
                        }
                        str = cardModuleData.itemId;
                        break;
                    case 10:
                        if (cardModuleData != null && !TextUtils.isEmpty(cardModuleData.pageUrl)) {
                            j.l.c.k.h.c.b(context, cardModuleData.pageUrl);
                        } else {
                            j.l.c.k.h.c.b(context, p0.e("https://app.mgtv.com/transfer/index.html?src=intelmgtv&page=tpzs", "abroad", b.b()));
                        }
                        str = cardModuleData.itemId;
                        break;
                    case 11:
                        c(context, MeAreaActivity.class);
                        str = cardModuleData.itemId;
                        break;
                    default:
                        Log.e(a, "unHandle jumper! card module = " + j.v.j.b.E(cardModuleData));
                        break;
                }
            } else {
                d.i(context, h.b());
                a.m("");
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.h(str, false);
            return;
        }
        j.l.a.n.m.a.e("0", a, "CardModuleData or Context is null,no response to click event.");
    }

    private static void c(Context context, Class<? extends Activity> cls) {
        if (context == null || cls == null) {
            return;
        }
        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        j.l.c.e0.a.a.a.h(intent);
        context.startActivity(intent);
    }

    @WithTryCatchRuntime
    public static void jump(Context context, CardData.CardModuleData cardModuleData) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.f.b(new Object[]{context, cardModuleData, e.x(s, (Object) null, (Object) null, context, cardModuleData)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }
}
