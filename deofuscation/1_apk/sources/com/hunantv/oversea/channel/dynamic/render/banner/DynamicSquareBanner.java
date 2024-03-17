package com.hunantv.oversea.channel.dynamic.render.banner;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonObject;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.channel.dynamic.business.jump.JumpKind;
import com.hunantv.oversea.channel.dynamic.render.collect.CollectReportHelper;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.j0;
import j.l.b.e.e.o;
import j.l.c.c.b;
import j.l.c.c.c.m1.h;
import j.l.c.c.c.u1.u.b;
import j.l.c.c.c.u1.u.g0;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicSquareBanner extends DynamicBanner {
    public static final float K2 = 1.0f;
    private static final /* synthetic */ c.b L2 = null;
    public a J2;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void onExposureBanner(boolean z);
    }

    static {
        G();
    }

    public DynamicSquareBanner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static /* synthetic */ void G() {
        e eVar = new e("DynamicSquareBanner.java", DynamicSquareBanner.class);
        L2 = eVar.H("method-execution", eVar.E("4", "reportCollectShow", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicSquareBanner", "java.lang.Object", "object", "", "void"), 73);
    }

    public static final /* synthetic */ void i0(DynamicSquareBanner dynamicSquareBanner, Object obj, c cVar) {
        if (obj instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) obj;
            String d = h.d(jsonObject, "jumpKind");
            String d2 = h.d(jsonObject, "jumpId");
            String d3 = h.d(jsonObject, "childId");
            if (TextUtils.equals(d, JumpKind.KIND_COLLECT.toString()) || TextUtils.equals(d, JumpKind.KIND_COLLECT_VIDEO.toString())) {
                d3 = "";
            } else {
                if (!TextUtils.equals(d, JumpKind.KIND_PL_VIDEO.toString())) {
                    if (TextUtils.equals(d, JumpKind.KIND_SVIDEO.toString())) {
                        d3 = d2;
                    } else {
                        d3 = "";
                        d2 = d3;
                    }
                }
                d2 = "";
            }
            if (TextUtils.isEmpty(d2)) {
                d2 = "";
            }
            String str = TextUtils.isEmpty(d3) ? "" : d3;
            String str2 = "&" + str + "&" + d2;
            if (CollectReportHelper.getExposure(str2)) {
                return;
            }
            CollectReportHelper.putExposure(str2, true);
            o.a(j.l.a.a.a()).h(j.l.c.x.t0.a.a().i, j.l.c.x.t0.a.a().m, "", EventClickData.i.H0, "smod=1&vid=" + str + "&cid=" + d2);
        }
    }

    @Override // com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner
    public b K(View view) {
        return new j.l.c.c.c.u1.u.e(view);
    }

    @Override // com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner
    public void S(boolean z) {
        a aVar = this.J2;
        if (aVar != null) {
            aVar.onExposureBanner(z);
        }
    }

    @Override // com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner
    public int getBannerAdLayoutId() {
        return b.m.item_template_dynamic_ad_banner_image_sqaure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner
    public void h0(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        if (size != 0 && size != this.m) {
            this.m = size;
        }
        int n = j0.n(j.l.a.a.a());
        int paddingLeft = (n - getPaddingLeft()) - getPaddingRight();
        float f = this.q;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        setMeasuredDimension(n, (int) (paddingLeft / f));
    }

    @Override // com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner
    @WithTryCatchRuntime
    public void reportCollectShow(Object obj) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g0(new Object[]{this, obj, e.w(L2, this, this, obj)}).e(69648));
    }

    public void setOnExposureBannerListener(a aVar) {
        this.J2 = aVar;
    }
}
