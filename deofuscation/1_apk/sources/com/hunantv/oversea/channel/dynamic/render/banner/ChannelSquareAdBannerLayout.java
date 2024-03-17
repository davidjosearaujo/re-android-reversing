package com.hunantv.oversea.channel.dynamic.render.banner;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import com.hunantv.oversea.channel.dynamic.common.DynamicHelper;
import com.hunantv.oversea.channel.dynamic.render.banner.DynamicSquareBanner;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.b;
import j.l.c.c.c.u1.u.l;
import j.l.c.c.c.u1.u.m;
import j.l.c.c.c.u1.u.n;
import j.l.c.c.c.u1.u.o;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelSquareAdBannerLayout extends ChannelAdBannerLayout implements DynamicSquareBanner.a {
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    @Nullable
    public DynamicSquareBanner b;
    private boolean c;
    public List<View> d;

    static {
        o0();
    }

    public ChannelSquareAdBannerLayout(Context context) {
        super(context);
    }

    @WithTryCatchRuntime
    private void findTagView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o(new Object[]{this, e.v(h, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    private void hideTagView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new m(new Object[]{this, e.v(f, this, this)}).e(69648));
    }

    private static /* synthetic */ void o0() {
        e eVar = new e("ChannelSquareAdBannerLayout.java", ChannelSquareAdBannerLayout.class);
        e = eVar.H("method-execution", eVar.E("1", "onExposureBanner", "com.hunantv.oversea.channel.dynamic.render.banner.ChannelSquareAdBannerLayout", "boolean", "isExtends", "", "void"), 57);
        f = eVar.H("method-execution", eVar.E("2", "hideTagView", "com.hunantv.oversea.channel.dynamic.render.banner.ChannelSquareAdBannerLayout", "", "", "", "void"), 72);
        g = eVar.H("method-execution", eVar.E("2", "showTagView", "com.hunantv.oversea.channel.dynamic.render.banner.ChannelSquareAdBannerLayout", "", "", "", "void"), 86);
        h = eVar.H("method-execution", eVar.E("2", "findTagView", "com.hunantv.oversea.channel.dynamic.render.banner.ChannelSquareAdBannerLayout", "", "", "", "void"), 100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void q0(ChannelSquareAdBannerLayout channelSquareAdBannerLayout, c cVar) {
        if (channelSquareAdBannerLayout.c) {
            return;
        }
        channelSquareAdBannerLayout.c = true;
        ViewParent parent = channelSquareAdBannerLayout.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Object tag = childAt.getTag(b.j.dsl_tag_view_attr_tag);
                if ((tag instanceof String) && TextUtils.equals((String) tag, DynamicHelper.a)) {
                    channelSquareAdBannerLayout.d.add(childAt);
                }
            }
        }
    }

    public static final /* synthetic */ void r0(ChannelSquareAdBannerLayout channelSquareAdBannerLayout, c cVar) {
        List<View> list = channelSquareAdBannerLayout.d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (View view : channelSquareAdBannerLayout.d) {
            view.setVisibility(4);
        }
    }

    @WithTryCatchRuntime
    private void showTagView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n(new Object[]{this, e.v(g, this, this)}).e(69648));
    }

    public static final /* synthetic */ void t0(ChannelSquareAdBannerLayout channelSquareAdBannerLayout, boolean z, c cVar) {
        channelSquareAdBannerLayout.findTagView();
        if (z) {
            channelSquareAdBannerLayout.hideTagView();
        } else {
            channelSquareAdBannerLayout.showTagView();
        }
    }

    public static final /* synthetic */ void u0(ChannelSquareAdBannerLayout channelSquareAdBannerLayout, c cVar) {
        List<View> list = channelSquareAdBannerLayout.d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (View view : channelSquareAdBannerLayout.d) {
            view.setVisibility(0);
        }
    }

    @Override // com.hunantv.oversea.channel.dynamic.render.banner.DynamicSquareBanner.a
    @WithTryCatchRuntime
    public void onExposureBanner(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{this, r.a.c.b.e.a(z), e.w(e, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.oversea.channel.dynamic.render.banner.ChannelAdBannerLayout
    public void onFinishInflate() {
        super.onFinishInflate();
        DynamicSquareBanner dynamicSquareBanner = (DynamicSquareBanner) findViewById(b.j.viewPager);
        this.b = dynamicSquareBanner;
        dynamicSquareBanner.setOnExposureBannerListener(this);
        this.d = new ArrayList();
    }

    public ChannelSquareAdBannerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChannelSquareAdBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
