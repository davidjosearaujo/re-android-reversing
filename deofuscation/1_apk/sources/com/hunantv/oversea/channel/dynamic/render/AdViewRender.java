package com.hunantv.oversea.channel.dynamic.render;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import com.hunantv.oversea.channel.dynamic.manager.ChannelStyleManger;
import com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.dynamicview.widget.MgCardContainer;
import j.l.a.a;
import j.l.a.b0.j0;
import j.l.c.c.c.m1.h;
import j.l.c.c.c.u1.e;
import j.u.e.c.i.d;
import java.util.Map;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AdViewRender extends e {
    private static final /* synthetic */ c.b e = null;
    private d d;

    static {
        a();
    }

    public AdViewRender(j.l.c.c.c.s1.e eVar) {
        super(eVar);
    }

    private static /* synthetic */ void a() {
        r.a.c.c.e eVar = new r.a.c.c.e("AdViewRender.java", AdViewRender.class);
        e = eVar.H("method-execution", eVar.E("1", "rendWithData", "com.hunantv.oversea.channel.dynamic.render.AdViewRender", "android.view.View:com.google.gson.JsonObject:com.mgtv.dynamicview.render.CommBridge:int", "view:jsonObject:commBridge:listIndex", "", "void"), 39);
    }

    @NonNull
    private String b(int i, JsonObject jsonObject) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        if (jsonObject != null) {
            sb.append("-");
            sb.append(jsonObject.hashCode());
        }
        return sb.toString();
    }

    private void c(View view) {
        if (view == null) {
            return;
        }
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.height = 1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
        }
        if (view.getParent() instanceof MgCardContainer) {
            view.getParent().c0();
        }
    }

    public static final /* synthetic */ void d(AdViewRender adViewRender, View view, JsonObject jsonObject, j.v.g.k.d dVar, int i, c cVar) {
        super.rendWithData(view, jsonObject, dVar, i);
        adViewRender.c(view);
        if (((e) adViewRender).b == null || jsonObject == null) {
            return;
        }
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        if (h.b(jsonObject, DynamicAdEntity.FIELD_AD_STATE) != 3 && h.b(jsonObject, "aid") > 0) {
            Map I = ((e) adViewRender).b.I();
            if (I != null) {
                adViewRender.d = (d) I.get(adViewRender.b(i, jsonObject));
            }
            if (adViewRender.d != null) {
                adViewRender.e(view);
                adViewRender.d.g(viewGroup);
                if (((e) adViewRender).b.T()) {
                    adViewRender.d.resume();
                }
            }
        }
    }

    private void e(View view) {
        if (view == null) {
            return;
        }
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.height = -2;
            int b = j0.b(a.a(), 5.0f);
            marginLayoutParams.bottomMargin = b;
            marginLayoutParams.topMargin = b;
            int b2 = j0.b(a.a(), 10.0f);
            marginLayoutParams.rightMargin = b2;
            marginLayoutParams.leftMargin = b2;
        }
        if ((((e) this).c instanceof ChannelStyleManger) && (view.getParent() instanceof MgCardContainer)) {
            view.getParent().k0(1);
        }
    }

    @WithTryCatchRuntime
    public void rendWithData(View view, JsonObject jsonObject, j.v.g.k.d dVar, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.d(new Object[]{this, view, jsonObject, dVar, r.a.c.b.e.k(i), r.a.c.c.e.y(e, this, this, new Object[]{view, jsonObject, dVar, r.a.c.b.e.k(i)})}).e(69648));
    }
}
