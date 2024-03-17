package com.hunantv.oversea.channel.dynamic.render.banner;

import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.hunantv.imgo.widget.MgFrescoImageView;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.j0;
import j.l.a.b0.z;
import j.l.c.c.b;
import j.l.c.c.c.u1.u.b;
import j.v.h.d;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BannerAdRectHolder extends b {
    private static final /* synthetic */ c.b b = null;
    private static final /* synthetic */ c.b c = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends ViewOutlineProvider {
        public final /* synthetic */ float a;

        public a(float f) {
            this.a = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    static {
        b();
    }

    public BannerAdRectHolder(@NonNull View view) {
        super(view);
    }

    private static /* synthetic */ void b() {
        e eVar = new e("BannerAdRectHolder.java", BannerAdRectHolder.class);
        b = eVar.H("method-execution", eVar.E("1", "render", "com.hunantv.oversea.channel.dynamic.render.banner.BannerAdRectHolder", "com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean:float", "moduleDataBean:borderRadius", "", "void"), 45);
        c = eVar.H("method-execution", eVar.E("2", "showIcon", "com.hunantv.oversea.channel.dynamic.render.banner.BannerAdRectHolder", "android.widget.TextView:com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean", "tvIcon:moduleDataBean", "", "void"), 72);
    }

    public static final /* synthetic */ void c(BannerAdRectHolder bannerAdRectHolder, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, float f, c cVar) {
        View view = ((b) bannerAdRectHolder).a;
        j.v.h.e.A((MgFrescoImageView) view.findViewById(b.j.ivImage), moduleDataBean.getImgUrl(false), d.M(j.v.h.e.c).L0(Integer.valueOf(b.h.bg_image_placeholder)).V0(2).w0(), (j.v.h.j.d) null);
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new a(f));
            view.setClipToOutline(true);
        }
        bannerAdRectHolder.showIcon((TextView) view.findViewById(b.j.subIcon), moduleDataBean);
        ((TextView) view.findViewById(b.j.tvName)).setText(moduleDataBean.name);
        ((TextView) view.findViewById(b.j.subTitle)).setText(moduleDataBean.subName);
        view.setTag(b.j.dsl_tag_item_native_module, moduleDataBean);
    }

    public static final /* synthetic */ void d(BannerAdRectHolder bannerAdRectHolder, TextView textView, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, c cVar) {
        if (textView == null) {
            return;
        }
        if (moduleDataBean != null && !TextUtils.isEmpty(moduleDataBean.rightCorner) && !TextUtils.isEmpty(moduleDataBean.cornerType) && z.a(moduleDataBean.cornerType)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(j0.b(textView.getContext(), 3.0f));
            gradientDrawable.setColor(z.e(moduleDataBean.cornerType, 0));
            textView.setBackground(gradientDrawable);
            textView.setText(moduleDataBean.rightCorner);
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    @WithTryCatchRuntime
    private void showIcon(TextView textView, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.u.d(new Object[]{this, textView, moduleDataBean, e.x(c, this, this, textView, moduleDataBean)}).e(69648));
    }

    public View a(View view) {
        return view;
    }

    @WithTryCatchRuntime
    public void render(ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, float f) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.u.c(new Object[]{this, moduleDataBean, r.a.c.b.e.i(f), e.x(b, this, this, moduleDataBean, r.a.c.b.e.i(f))}).e(69648));
    }
}
