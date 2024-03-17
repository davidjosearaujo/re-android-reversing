package com.hunantv.oversea.channel.dynamic.listener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.c.r1.b;
import j.l.c.c.c.r1.d;
import j.l.c.c.c.r1.e.a;
import java.lang.ref.WeakReference;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicInnerOnScrollListener extends a {
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private final WeakReference<ChannelDynamicFragment> d;

    static {
        b();
    }

    public DynamicInnerOnScrollListener(ChannelDynamicFragment channelDynamicFragment) {
        this.d = new WeakReference<>(channelDynamicFragment);
    }

    private static /* synthetic */ void b() {
        e eVar = new e("DynamicInnerOnScrollListener.java", DynamicInnerOnScrollListener.class);
        e = eVar.H("method-execution", eVar.E("1", "onScrolled", "com.hunantv.oversea.channel.dynamic.listener.DynamicInnerOnScrollListener", "androidx.recyclerview.widget.RecyclerView:int:int", "recyclerView:dx:dy", "", "void"), 27);
        f = eVar.H("method-execution", eVar.E("1", "onScrollStateChanged", "com.hunantv.oversea.channel.dynamic.listener.DynamicInnerOnScrollListener", "androidx.recyclerview.widget.RecyclerView:int", "recyclerView:newState", "", "void"), 37);
        g = eVar.H("method-execution", eVar.E("1", "onScrollDepthChanged", "com.hunantv.oversea.channel.dynamic.listener.DynamicInnerOnScrollListener", "int:int", "dy:depth", "", "void"), 47);
        h = eVar.H("method-execution", eVar.E("1", "onScrollTwoScreen", "com.hunantv.oversea.channel.dynamic.listener.DynamicInnerOnScrollListener", "boolean", "flag", "", "void"), 56);
    }

    public static final /* synthetic */ void c(DynamicInnerOnScrollListener dynamicInnerOnScrollListener, int i, int i2, c cVar) {
        ChannelDynamicFragment channelDynamicFragment = dynamicInnerOnScrollListener.d.get();
        if (channelDynamicFragment != null) {
            channelDynamicFragment.onScrollDepthChanged(i, i2);
        }
    }

    public static final /* synthetic */ void d(DynamicInnerOnScrollListener dynamicInnerOnScrollListener, RecyclerView recyclerView, int i, c cVar) {
        super/*androidx.recyclerview.widget.RecyclerView.OnScrollListener*/.onScrollStateChanged(recyclerView, i);
        ChannelDynamicFragment channelDynamicFragment = dynamicInnerOnScrollListener.d.get();
        if (channelDynamicFragment != null) {
            channelDynamicFragment.onScrollStateChanged(i);
        }
    }

    public static final /* synthetic */ void e(DynamicInnerOnScrollListener dynamicInnerOnScrollListener, boolean z, c cVar) {
        ChannelDynamicFragment channelDynamicFragment = dynamicInnerOnScrollListener.d.get();
        if (channelDynamicFragment != null) {
            channelDynamicFragment.onScrollTwoScreen(z);
        }
    }

    public static final /* synthetic */ void f(DynamicInnerOnScrollListener dynamicInnerOnScrollListener, RecyclerView recyclerView, int i, int i2, c cVar) {
        super.onScrolled(recyclerView, i, i2);
        ChannelDynamicFragment channelDynamicFragment = dynamicInnerOnScrollListener.d.get();
        if (channelDynamicFragment != null) {
            if (i2 == 0 && i == 0) {
                return;
            }
            channelDynamicFragment.onScrolled(i2);
        }
    }

    @WithTryCatchRuntime
    public void onScrollDepthChanged(int i, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.r1.c(new Object[]{this, r.a.c.b.e.k(i), r.a.c.b.e.k(i2), e.x(g, this, this, r.a.c.b.e.k(i), r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b(new Object[]{this, recyclerView, r.a.c.b.e.k(i), e.x(f, this, this, recyclerView, r.a.c.b.e.k(i))}).e(69648));
    }

    @WithTryCatchRuntime
    public void onScrollTwoScreen(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{this, r.a.c.b.e.a(z), e.w(h, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    @WithTryCatchRuntime
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.r1.a(new Object[]{this, recyclerView, r.a.c.b.e.k(i), r.a.c.b.e.k(i2), e.y(e, this, this, new Object[]{recyclerView, r.a.c.b.e.k(i), r.a.c.b.e.k(i2)})}).e(69648));
    }
}
