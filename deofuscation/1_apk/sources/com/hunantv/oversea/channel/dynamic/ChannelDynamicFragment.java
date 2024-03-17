package com.hunantv.oversea.channel.dynamic;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.facebook.GraphResponse;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.huawei.agconnect.exception.AGCServerException;
import com.hunantv.imgo.base.RootFragment;
import com.hunantv.imgo.nightmode.SkinModel;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.imgo.widget.MgFrescoImageView;
import com.hunantv.oversea.business.ad.huge.HugeMananger;
import com.hunantv.oversea.channel.dynamic.common.DynamicHelper;
import com.hunantv.oversea.channel.dynamic.data.ModuleData;
import com.hunantv.oversea.channel.dynamic.listener.DynamicInnerOnScrollListener;
import com.hunantv.oversea.channel.dynamic.manager.ChannelStyleManger;
import com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter;
import com.hunantv.oversea.channel.dynamic.render.banner.BannerHelper;
import com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner;
import com.hunantv.oversea.channel.dynamic.video.VideoPreviewManager;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.hunantv.oversea.channel.selected.SelectedFragment;
import com.hunantv.oversea.channel.selected.data.ChannelListEntity;
import com.hunantv.oversea.channel.widget.ChannelEmptyLayout;
import com.hunantv.oversea.channel.widget.ChannelRefreshLayout;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.widget.MGRefreshLayout;
import com.mgtv.widget.recyclerview.MGRecyclerView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import j.l.a.b0.b0;
import j.l.a.b0.v;
import j.l.a.b0.z;
import j.l.c.a.e.a.a;
import j.l.c.c.b;
import j.l.c.c.c.a0;
import j.l.c.c.c.c0;
import j.l.c.c.c.d0;
import j.l.c.c.c.e0;
import j.l.c.c.c.f0;
import j.l.c.c.c.g0;
import j.l.c.c.c.h;
import j.l.c.c.c.h0;
import j.l.c.c.c.i;
import j.l.c.c.c.i0;
import j.l.c.c.c.j0;
import j.l.c.c.c.j1;
import j.l.c.c.c.k;
import j.l.c.c.c.k0;
import j.l.c.c.c.l;
import j.l.c.c.c.l0;
import j.l.c.c.c.m;
import j.l.c.c.c.m0;
import j.l.c.c.c.m1.g;
import j.l.c.c.c.n;
import j.l.c.c.c.n0;
import j.l.c.c.c.o;
import j.l.c.c.c.o0;
import j.l.c.c.c.p;
import j.l.c.c.c.p0;
import j.l.c.c.c.q;
import j.l.c.c.c.q0;
import j.l.c.c.c.r;
import j.l.c.c.c.r1.e.d;
import j.l.c.c.c.s;
import j.l.c.c.c.t;
import j.l.c.c.c.u;
import j.l.c.c.c.w;
import j.l.c.c.c.x;
import j.l.c.c.c.y;
import j.l.c.c.d.e;
import j.s.j.y0;
import j.y.a.a.c.j;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelDynamicFragment extends RootFragment implements g, e, j1, d, Observer<j.l.c.c.d.d> {
    private static final /* synthetic */ c.b A2 = null;
    private static final /* synthetic */ c.b B2 = null;
    private static final /* synthetic */ c.b C1 = null;
    private static final /* synthetic */ c.b C2 = null;
    private static final /* synthetic */ c.b D2 = null;
    private static final String E = "ChannelDynamicFragment";
    private static final /* synthetic */ c.b E2 = null;
    private static final int F = 1;
    private static final /* synthetic */ c.b F2 = null;
    private static final /* synthetic */ c.b G2 = null;
    private static final /* synthetic */ c.b H2 = null;
    private static final /* synthetic */ c.b I2 = null;
    private static final /* synthetic */ c.b J2 = null;
    private static final /* synthetic */ c.b K0 = null;
    private static final /* synthetic */ c.b K1 = null;
    private static final /* synthetic */ c.b K2 = null;
    private static final /* synthetic */ c.b L2 = null;
    private static final /* synthetic */ c.b M2 = null;
    private static final /* synthetic */ c.b N2 = null;
    private static final /* synthetic */ c.b O2 = null;
    private static final /* synthetic */ c.b P2 = null;
    private static final int k0 = 2;
    private static final /* synthetic */ c.b k1 = null;
    private static final /* synthetic */ c.b p2 = null;
    private static final /* synthetic */ c.b q2 = null;
    private static final /* synthetic */ c.b r2 = null;
    private static final /* synthetic */ c.b s2 = null;
    private static final /* synthetic */ c.b t2 = null;
    private static final /* synthetic */ c.b u2 = null;
    private static final /* synthetic */ c.b v2 = null;
    private static final /* synthetic */ c.b w2 = null;
    private static final /* synthetic */ c.b x1 = null;
    private static final /* synthetic */ c.b x2 = null;
    private static final /* synthetic */ c.b y1 = null;
    private static final /* synthetic */ c.b y2 = null;
    private static final /* synthetic */ c.b z2 = null;
    public long A;
    private j.l.c.c.c.u1.u.a C;
    public RelativeLayout a;
    public MgFrescoImageView b;
    public ChannelRefreshLayout c;
    public ChannelEmptyLayout d;
    public MGRecyclerView e;
    public ChannelDynamicAdapter f;
    public LinearLayoutManagerWrapper g;
    public FrameLayout h;
    public DynamicAdPresenter j;
    public ChannelDynamicPresenter k;
    public String m;
    public int n;
    public int q;
    public j.l.c.c.c.s1.e i = ChannelStyleManger.m();
    public b l = new b(this, null);
    private int o = 0;
    private boolean p = true;
    private int r = -1;
    public int s = -1;
    public boolean t = true;
    private volatile String u = "";
    private volatile String v = "";
    private boolean w = false;
    private boolean x = false;
    public AtomicBoolean y = new AtomicBoolean(false);
    private boolean z = false;
    private long B = -1;
    private DynamicInnerOnScrollListener D = new DynamicInnerOnScrollListener(this);

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class MultiPurposeListener extends j.y.a.a.f.g {
        private static final /* synthetic */ c.b b = null;
        private static final /* synthetic */ c.b c = null;
        private static final /* synthetic */ c.b d = null;
        private static final /* synthetic */ c.b e = null;
        @NonNull
        private final WeakReference<ChannelDynamicFragment> a;

        static {
            a();
        }

        public MultiPurposeListener(@NonNull ChannelDynamicFragment channelDynamicFragment) {
            this.a = new WeakReference<>(channelDynamicFragment);
        }

        private static /* synthetic */ void a() {
            r.a.c.c.e eVar = new r.a.c.c.e("ChannelDynamicFragment.java", MultiPurposeListener.class);
            b = eVar.H("method-execution", eVar.E("1", "onHeaderMoving", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment$MultiPurposeListener", "com.scwang.smartrefresh.layout.api.RefreshHeader:boolean:float:int:int:int", "header:isDragging:percent:offset:headerHeight:maxDragHeight", "", "void"), 1333);
            c = eVar.H("method-execution", eVar.E("1", "onLoadMore", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment$MultiPurposeListener", "com.scwang.smartrefresh.layout.api.RefreshLayout", "refreshLayout", "", "void"), 1345);
            d = eVar.H("method-execution", eVar.E("1", com.alipay.sdk.widget.d.p, "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment$MultiPurposeListener", "com.scwang.smartrefresh.layout.api.RefreshLayout", "refreshLayout", "", "void"), 1360);
            e = eVar.H("method-execution", eVar.E("1", "onStateChanged", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment$MultiPurposeListener", "com.scwang.smartrefresh.layout.api.RefreshLayout:com.scwang.smartrefresh.layout.constant.RefreshState:com.scwang.smartrefresh.layout.constant.RefreshState", "refreshLayout:oldState:newState", "", "void"), 1370);
        }

        public static final /* synthetic */ void b(MultiPurposeListener multiPurposeListener, j.y.a.a.c.g gVar, boolean z, float f, int i, int i2, int i3, c cVar) {
            ChannelDynamicFragment channelDynamicFragment = multiPurposeListener.a.get();
            if (channelDynamicFragment == null) {
                return;
            }
            channelDynamicFragment.q = i;
            channelDynamicFragment.onHeaderMoving(i, f, z);
        }

        public static final /* synthetic */ void c(MultiPurposeListener multiPurposeListener, j jVar, c cVar) {
            v.p(ChannelDynamicFragment.E, "MultiPurposeListener.onLoadMore");
            if (j.l.a.s.a.h() == 2) {
                jVar.I();
                return;
            }
            ChannelDynamicFragment channelDynamicFragment = multiPurposeListener.a.get();
            if (channelDynamicFragment == null) {
                return;
            }
            channelDynamicFragment.onLoadMore();
        }

        public static final /* synthetic */ void e(MultiPurposeListener multiPurposeListener, j jVar, c cVar) {
            v.p(ChannelDynamicFragment.E, "MultiPurposeListener.onRefresh");
            ChannelDynamicFragment channelDynamicFragment = multiPurposeListener.a.get();
            if (channelDynamicFragment != null) {
                channelDynamicFragment.onRefreshBegin();
            }
        }

        public static final /* synthetic */ void f(MultiPurposeListener multiPurposeListener, j jVar, RefreshState refreshState, RefreshState refreshState2, c cVar) {
            super.onStateChanged(jVar, refreshState, refreshState2);
            v.p(ChannelDynamicFragment.E, "MultiPurposeListener.onStateChanged:" + refreshState2);
            ChannelDynamicFragment channelDynamicFragment = multiPurposeListener.a.get();
            if (channelDynamicFragment == null) {
                return;
            }
            if (refreshState2 != RefreshState.TwoLevelReleased && refreshState2 != RefreshState.TwoLevelFinish) {
                if (refreshState2 == RefreshState.None) {
                    channelDynamicFragment.onRefreshNone();
                } else if (refreshState2 == RefreshState.PullDownToRefresh) {
                    channelDynamicFragment.onPullDownToRefresh();
                } else if (refreshState2 == RefreshState.Refreshing || refreshState2 == RefreshState.PullDownCanceled) {
                    channelDynamicFragment.onRefreshing();
                }
            }
            if (refreshState2.isTwoLevel) {
                return;
            }
            channelDynamicFragment.updateRefreshAdTitle(refreshState2.isDragging);
        }

        @WithTryCatchRuntime
        public void onHeaderMoving(j.y.a.a.c.g gVar, boolean z, float f, int i, int i2, int i3) {
            LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n0(new Object[]{this, gVar, r.a.c.b.e.a(z), r.a.c.b.e.i(f), r.a.c.b.e.k(i), r.a.c.b.e.k(i2), r.a.c.b.e.k(i3), r.a.c.c.e.y(b, this, this, new Object[]{gVar, r.a.c.b.e.a(z), r.a.c.b.e.i(f), r.a.c.b.e.k(i), r.a.c.b.e.k(i2), r.a.c.b.e.k(i3)})}).e(69648));
        }

        @WithTryCatchRuntime
        public void onLoadMore(@NonNull j jVar) {
            LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o0(new Object[]{this, jVar, r.a.c.c.e.w(c, this, this, jVar)}).e(69648));
        }

        @WithTryCatchRuntime
        public void onRefresh(@NonNull j jVar) {
            LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new p0(new Object[]{this, jVar, r.a.c.c.e.w(d, this, this, jVar)}).e(69648));
        }

        @WithTryCatchRuntime
        public void onStateChanged(@NonNull j jVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
            LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new q0(new Object[]{this, jVar, refreshState, refreshState2, r.a.c.c.e.y(e, this, this, new Object[]{jVar, refreshState, refreshState2})}).e(69648));
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChannelDynamicFragment.this.onEmptyClick();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b implements e {
        private final WeakReference<e> a;

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }

        public Map<String, j.u.e.c.i.d> I() {
            e eVar = this.a.get();
            if (eVar != null) {
                return eVar.I();
            }
            return null;
        }

        public String K() {
            e eVar = this.a.get();
            return eVar != null ? eVar.K() : "";
        }

        public boolean O() {
            e eVar = this.a.get();
            if (eVar != null) {
                return eVar.O();
            }
            return false;
        }

        public boolean T() {
            e eVar = this.a.get();
            if (eVar != null) {
                return eVar.T();
            }
            return false;
        }

        public void V(j.l.c.c.d.a aVar) {
            e eVar = this.a.get();
            if (eVar != null) {
                eVar.V(aVar);
            }
        }

        public Fragment b() {
            e eVar = this.a.get();
            if (eVar != null) {
                return eVar.b();
            }
            return null;
        }

        public String b0(int i) {
            e eVar = this.a.get();
            return eVar != null ? eVar.b0(i) : "";
        }

        public Activity getCurrentActivity() {
            e eVar = this.a.get();
            if (eVar != null) {
                return eVar.getCurrentActivity();
            }
            return null;
        }

        public boolean isDestroyed() {
            e eVar = this.a.get();
            if (eVar != null) {
                return eVar.isDestroyed();
            }
            return false;
        }

        public String j0() {
            e eVar = this.a.get();
            return eVar != null ? eVar.j0() : "";
        }

        public boolean n0() {
            e eVar = this.a.get();
            if (eVar != null) {
                return eVar.n0();
            }
            return false;
        }

        private b(e eVar) {
            this.a = new WeakReference<>(eVar);
        }
    }

    static {
        ajc$preClinit();
    }

    private boolean B0(boolean z, boolean z3) {
        return b0.g() || z || z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0191 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void C0(com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment r19, r.a.b.c r20) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment.C0(com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment, r.a.b.c):void");
    }

    public static final /* synthetic */ void D0(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        if (channelDynamicFragment.g == null || !channelDynamicFragment.O()) {
            return;
        }
        int findFirstVisibleItemPosition = channelDynamicFragment.g.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = channelDynamicFragment.g.findLastVisibleItemPosition();
        ChannelDynamicPresenter channelDynamicPresenter = channelDynamicFragment.k;
        if (channelDynamicPresenter != null) {
            channelDynamicPresenter.findRequestAd(findFirstVisibleItemPosition, findLastVisibleItemPosition);
        }
    }

    public static final /* synthetic */ ViewPager E0(ChannelDynamicFragment channelDynamicFragment, ViewGroup viewGroup, c cVar) {
        ViewPager findViewPage;
        if (viewGroup instanceof ViewPager) {
            return (ViewPager) viewGroup;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewPager childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewPager) {
                return childAt;
            }
            if ((childAt instanceof ViewGroup) && (findViewPage = channelDynamicFragment.findViewPage((ViewGroup) childAt)) != null) {
                return findViewPage;
            }
        }
        return null;
    }

    @Nullable
    private SelectedFragment G0() {
        if (getParentFragment() instanceof SelectedFragment) {
            return (SelectedFragment) getParentFragment();
        }
        return null;
    }

    public static final /* synthetic */ void I0(ChannelDynamicFragment channelDynamicFragment, View view, j.v.g.d.a aVar, c cVar) {
        ChannelDynamicPresenter channelDynamicPresenter;
        int i;
        if (aVar == null) {
            return;
        }
        if ((aVar instanceof j.v.g.d.d) && j.l.c.c.c.m1.a.a(view)) {
            j.v.g.d.d dVar = (j.v.g.d.d) aVar;
            LinearLayoutManagerWrapper linearLayoutManagerWrapper = channelDynamicFragment.g;
            if (linearLayoutManagerWrapper == null || (i = ((j.v.g.d.b) dVar).a) < 0 || i >= linearLayoutManagerWrapper.getItemCount()) {
                return;
            }
            View findViewByPosition = channelDynamicFragment.g.findViewByPosition(((j.v.g.d.b) dVar).a);
            ChannelDynamicPresenter channelDynamicPresenter2 = channelDynamicFragment.k;
            if (channelDynamicPresenter2 != null) {
                channelDynamicPresenter2.handleClickAction(findViewByPosition, view, dVar);
            }
        } else if (!(aVar instanceof j.v.g.d.e) || (channelDynamicPresenter = channelDynamicFragment.k) == null) {
        } else {
            channelDynamicPresenter.handleContainerExposure((j.v.g.d.e) aVar);
        }
    }

    private boolean K0() {
        ModuleData.ChannelBean F0 = F0();
        return F0 != null && F0.isIndividualColor();
    }

    public static final /* synthetic */ boolean L0(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        SelectedFragment G0 = channelDynamicFragment.G0();
        return G0 != null && G0.getCurrentTabIndex() == channelDynamicFragment.n;
    }

    public static final /* synthetic */ void N0(ChannelDynamicFragment channelDynamicFragment, int i, c cVar) {
        j.l.c.c.c.u1.u.a aVar = channelDynamicFragment.C;
        if (aVar != null) {
            aVar.b(channelDynamicFragment.e, i);
        }
    }

    public static final /* synthetic */ void O0(ChannelDynamicFragment channelDynamicFragment, boolean z, c cVar) {
        j.l.c.c.c.u1.u.a aVar = channelDynamicFragment.C;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public static final /* synthetic */ void P0(ChannelDynamicFragment channelDynamicFragment, j.l.c.c.d.d dVar, c cVar) {
        if (dVar != null && TextUtils.equals("load_dsl_style_success", ((j.l.a.m.b.b) dVar).b) && ((j.l.a.m.b.b) dVar).f && !channelDynamicFragment.J0()) {
            channelDynamicFragment.j(0, false);
        }
    }

    public static final /* synthetic */ void Q0(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        if (b0.e() && channelDynamicFragment.k != null) {
            SkinnableFrameLayout skinnableFrameLayout = channelDynamicFragment.d;
            if (skinnableFrameLayout != null) {
                skinnableFrameLayout.setVisibility(8);
            }
            if (channelDynamicFragment.i.isEmpty()) {
                channelDynamicFragment.i.requestStyle();
            }
            if (j.l.a.b0.j.a(channelDynamicFragment.k.t())) {
                channelDynamicFragment.c.Q();
            }
        }
    }

    public static final /* synthetic */ void R0(ChannelDynamicFragment channelDynamicFragment, int i, float f, boolean z, c cVar) {
        SelectedFragment G0;
        if (channelDynamicFragment.c == null || (G0 = channelDynamicFragment.G0()) == null) {
            return;
        }
        channelDynamicFragment.setTranslationFloorY(i, G0);
    }

    public static final /* synthetic */ void S0(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        ChannelDynamicPresenter channelDynamicPresenter = channelDynamicFragment.k;
        if (channelDynamicPresenter != null) {
            channelDynamicPresenter.getMore();
        }
    }

    public static final /* synthetic */ void T0(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        v.c(E, "onPullDownToRefresh");
        channelDynamicFragment.y.getAndSet(true);
    }

    public static final /* synthetic */ void U0(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        j.l.a.n.m.a.d("30", E, "正在刷新refreshing");
        MGRecyclerView mGRecyclerView = channelDynamicFragment.e;
        if (mGRecyclerView != null && mGRecyclerView.getScrollState() == 0) {
            channelDynamicFragment.c1(false);
        } else {
            channelDynamicFragment.x = true;
        }
    }

    public static final /* synthetic */ void V0(ChannelDynamicFragment channelDynamicFragment, boolean z, c cVar) {
        j.l.a.n.m.a.d("30", E, "刷新结束" + z);
        ChannelRefreshLayout channelRefreshLayout = channelDynamicFragment.c;
        if (channelRefreshLayout != null) {
            channelRefreshLayout.r0(z);
            channelDynamicFragment.c.m0(z);
        }
    }

    public static final /* synthetic */ void W0(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        channelDynamicFragment.setViewPageTouchAllowed(true);
        channelDynamicFragment.w = false;
        ChannelRefreshLayout channelRefreshLayout = channelDynamicFragment.c;
        if (channelRefreshLayout != null) {
            channelRefreshLayout.setAutoRefresh(false);
        }
        v.c(E, "onRefreshNone");
        channelDynamicFragment.y.getAndSet(false);
    }

    public static final /* synthetic */ void X0(ChannelDynamicFragment channelDynamicFragment, c cVar) {
    }

    public static final /* synthetic */ void Y0(ChannelDynamicFragment channelDynamicFragment, int i, c cVar) {
        channelDynamicFragment.o = i;
        if (i == 0) {
            channelDynamicFragment.findFocusItemForVideoPreview();
            channelDynamicFragment.findRequestAd();
            channelDynamicFragment.notifyBannerScrollChanged(i);
            ChannelDynamicAdapter channelDynamicAdapter = channelDynamicFragment.f;
            if (channelDynamicAdapter != null) {
                channelDynamicAdapter.onLinkageScrollIdle();
            }
        }
        if (i == 0 && channelDynamicFragment.x) {
            channelDynamicFragment.c1(false);
            channelDynamicFragment.x = false;
        }
    }

    public static final /* synthetic */ void Z0(ChannelDynamicFragment channelDynamicFragment, int i, c cVar) {
        if (channelDynamicFragment.getRealVisible()) {
            SelectedFragment G0 = channelDynamicFragment.G0();
            if (G0 != null) {
                boolean refreshHeadFrame = G0.refreshHeadFrame();
                if (channelDynamicFragment.i()) {
                    channelDynamicFragment.t = refreshHeadFrame;
                    if (!channelDynamicFragment.B() || !channelDynamicFragment.K0()) {
                        G0.updateMainUI(refreshHeadFrame);
                    }
                } else {
                    channelDynamicFragment.t = true;
                }
            }
            DynamicAdPresenter dynamicAdPresenter = channelDynamicFragment.j;
            if (dynamicAdPresenter != null) {
                dynamicAdPresenter.j(channelDynamicFragment.e, 0, i);
            }
            ChannelDynamicAdapter channelDynamicAdapter = channelDynamicFragment.f;
            if (channelDynamicAdapter != null) {
                channelDynamicAdapter.onLinkageScrolled(0, i);
            }
        }
    }

    public static final /* synthetic */ void a1(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        Bundle arguments = channelDynamicFragment.getArguments();
        if (arguments == null) {
            return;
        }
        String string = arguments.getString("bundler_h5_fontcolor", "");
        String string2 = arguments.getString("bundle_h5_bgcolor", "");
        String string3 = arguments.getString("bundler_bg_img", "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return;
        }
        channelDynamicFragment.a.setBackgroundColor(z.e(string2, channelDynamicFragment.mContext.getResources().getColor(b.f.channel_background_v2)));
        channelDynamicFragment.m1(string3);
    }

    private static /* synthetic */ void ajc$preClinit() {
        r.a.c.c.e eVar = new r.a.c.c.e("ChannelDynamicFragment.java", ChannelDynamicFragment.class);
        K0 = eVar.H("method-execution", eVar.E("2", "preUpdateChannelBackground", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), (int) AGCServerException.UNKNOW_EXCEPTION);
        k1 = eVar.H("method-execution", eVar.E("2", "updateChannelBackground", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 522);
        t2 = eVar.H("method-execution", eVar.E("2", "updateRefreshAdTitle", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "boolean", "isDragging", "", "void"), 757);
        u2 = eVar.H("method-execution", eVar.E("2", "setTranslationFloorY", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "int:com.hunantv.oversea.channel.selected.SelectedFragment", "offset:fragment", "", "void"), 767);
        v2 = eVar.H("method-execution", eVar.E("1", "onScrolled", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "int", "dy", "", "void"), 782);
        w2 = eVar.H("method-execution", eVar.E("1", "onScrollStateChanged", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "int", "newState", "", "void"), 824);
        x2 = eVar.H("method-execution", eVar.E("2", "onHeaderMoving", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "int:float:boolean", "offset:percent:isDraging", "", "void"), 854);
        y2 = eVar.H("method-execution", eVar.E("1", "resetHeadAlpha", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "float", "alpha", "", "void"), 870);
        z2 = eVar.H("method-execution", eVar.E("2", "isUseOperationPostion", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "boolean"), 883);
        A2 = eVar.H("method-execution", eVar.E("1", "startHuguSmallVideo", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "boolean", "hasHuguAd", "", "void"), 955);
        B2 = eVar.H("method-execution", eVar.E("1", "onChanged", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "com.hunantv.oversea.channel.msg.DynamicChannelEvent", "event", "", "void"), 1029);
        C2 = eVar.H("method-execution", eVar.E("4", "setChannelIndex", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "boolean:boolean", "isRefresh:isCache", "", "void"), 1156);
        x1 = eVar.H("method-execution", eVar.E("4", "onEmptyClick", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 635);
        D2 = eVar.H("method-execution", eVar.E("4", "updateHeader", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 1219);
        E2 = eVar.H("method-execution", eVar.E("4", "updateStyleFlag", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 1231);
        F2 = eVar.H("method-execution", eVar.E("2", "updateAutoPlayFlag", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "com.google.gson.JsonObject", "data", "", "void"), 1255);
        G2 = eVar.H("method-execution", eVar.E("2", "updateHeaderColor", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 1274);
        H2 = eVar.H("method-execution", eVar.E("2", "updateUIColor", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 1285);
        I2 = eVar.H("method-execution", eVar.E("2", "updateMainUI", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 1301);
        J2 = eVar.H("method-execution", eVar.E("2", "setRefreshLayoutTopPadding", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "int", "topHeight", "", "void"), 1404);
        K2 = eVar.H("method-execution", eVar.E("2", "setViewPageTouchAllowed", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "boolean", "enable", "", "void"), 1421);
        L2 = eVar.H("method-execution", eVar.E("1", "findFocusItemForVideoPreview", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 1433);
        M2 = eVar.H("method-execution", eVar.E("2", "findRequestAd", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 1575);
        y1 = eVar.H("method-execution", eVar.E("1", "handleAction", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "android.view.View:com.mgtv.dynamicview.action.Action", "clickView:action", "", "void"), 659);
        N2 = eVar.H("method-execution", eVar.E("2", "notifyBannerScrollChanged", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "int", "newState", "", "void"), 1590);
        O2 = eVar.H("method-execution", eVar.E("2", "notifyBannerVisible", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "boolean", "visible", "", "void"), 1600);
        P2 = eVar.H("method-execution", eVar.E("0", "findViewPage", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "android.view.ViewGroup", ViewHierarchyConstants.VIEW_KEY, "", "androidx.viewpager.widget.ViewPager"), 1651);
        C1 = eVar.H("method-execution", eVar.E("4", "onRefreshComplete", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "boolean", GraphResponse.SUCCESS_KEY, "", "void"), 687);
        K1 = eVar.H("method-execution", eVar.E("2", "onLoadMore", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 699);
        p2 = eVar.H("method-execution", eVar.E("2", "onRefreshBegin", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 709);
        q2 = eVar.H("method-execution", eVar.E("2", "onRefreshNone", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 725);
        r2 = eVar.H("method-execution", eVar.E("2", "onPullDownToRefresh", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 739);
        s2 = eVar.H("method-execution", eVar.E("2", "onRefreshing", "com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment", "", "", "", "void"), 749);
    }

    public static final /* synthetic */ void e1(ChannelDynamicFragment channelDynamicFragment, float f, c cVar) {
        SelectedFragment G0 = channelDynamicFragment.G0();
        if (G0 != null) {
            if (!channelDynamicFragment.isUseOperationPostion()) {
                f = 1.0f;
            }
            G0.onHeaderAlpha(f);
        }
    }

    @WithTryCatchRuntime
    private void findRequestAd() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g0(new Object[]{this, r.a.c.c.e.v(M2, this, this)}).e(69648));
    }

    public static final /* synthetic */ void g1(ChannelDynamicFragment channelDynamicFragment, boolean z, boolean z3, c cVar) {
        ChannelDynamicPresenter channelDynamicPresenter = channelDynamicFragment.k;
        if (channelDynamicPresenter != null) {
            ChannelDynamicAdapter channelDynamicAdapter = channelDynamicFragment.f;
            if (channelDynamicAdapter != null) {
                if (z) {
                    channelDynamicAdapter.notifyDataSetChanged();
                } else {
                    channelDynamicAdapter.i(channelDynamicPresenter.y(), true);
                }
            }
            channelDynamicFragment.k.l();
        }
        if (z3 || !channelDynamicFragment.isFragmentVisible) {
            return;
        }
        channelDynamicFragment.e.postDelayed(new j.l.c.c.c.b(channelDynamicFragment), AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS);
    }

    public static final /* synthetic */ void h1(ChannelDynamicFragment channelDynamicFragment, int i, c cVar) {
        RelativeLayout.LayoutParams layoutParams;
        MGRefreshLayout mGRefreshLayout = channelDynamicFragment.c;
        if (mGRefreshLayout != null) {
            mGRefreshLayout.setPadding(0, i, 0, 0);
        }
        SkinnableFrameLayout skinnableFrameLayout = channelDynamicFragment.d;
        if (skinnableFrameLayout == null || (layoutParams = (RelativeLayout.LayoutParams) skinnableFrameLayout.getLayoutParams()) == null || layoutParams.topMargin == i) {
            return;
        }
        layoutParams.topMargin = i;
        channelDynamicFragment.d.setLayoutParams(layoutParams);
    }

    public static final /* synthetic */ void i1(ChannelDynamicFragment channelDynamicFragment, int i, SelectedFragment selectedFragment, c cVar) {
        if (channelDynamicFragment.c == null) {
            return;
        }
        int i2 = 0;
        if (!channelDynamicFragment.t() && (i2 = channelDynamicFragment.r) == 0) {
            i2 = selectedFragment.getHeadHeight();
        }
        View refreshHeader = channelDynamicFragment.c.getRefreshHeader();
        if (refreshHeader != null) {
            refreshHeader.setTranslationY(Math.min((i - refreshHeader.getHeight()) + i2, channelDynamicFragment.c.getLayout().getHeight() - refreshHeader.getHeight()));
        }
    }

    @WithTryCatchRuntime
    private boolean isUseOperationPostion() {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new s(new Object[]{this, r.a.c.c.e.v(z2, this, this)}).e(69648)));
    }

    public static final /* synthetic */ void j1(ChannelDynamicFragment channelDynamicFragment, boolean z, c cVar) {
        SelectedFragment G0 = channelDynamicFragment.G0();
        if (G0 != null) {
            G0.setViewPageTouchAllowed(z);
        }
    }

    public static final /* synthetic */ void k1(ChannelDynamicFragment channelDynamicFragment, boolean z, c cVar) {
        LinearLayoutManagerWrapper linearLayoutManagerWrapper;
        if (z && ChannelListEntity.isSelectedChannel(channelDynamicFragment.K()) && (linearLayoutManagerWrapper = channelDynamicFragment.g) != null) {
            View childAt = linearLayoutManagerWrapper.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                DynamicBanner findViewPage = channelDynamicFragment.findViewPage((ViewGroup) childAt);
                if (findViewPage instanceof DynamicBanner) {
                    findViewPage.startLastItem();
                    channelDynamicFragment.findFocusItemForVideoPreview();
                }
            }
        }
    }

    public static final /* synthetic */ void l1(ChannelDynamicFragment channelDynamicFragment, JsonObject jsonObject, c cVar) {
        if (jsonObject != null) {
            JsonElement jsonElement = jsonObject.get("navbarBgColor");
            if (jsonElement instanceof JsonPrimitive) {
                channelDynamicFragment.u = jsonElement.getAsString();
            }
            JsonElement jsonElement2 = jsonObject.get("navbarHlColor");
            if (jsonElement2 instanceof JsonPrimitive) {
                channelDynamicFragment.v = jsonElement2.getAsString();
            }
            v.c(E, "updateAutoPlayFlag mBgColor: " + channelDynamicFragment.u + ", mFontColor: " + channelDynamicFragment.v);
        }
    }

    private void m1(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.setVisibility(0);
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str));
            PipelineDraweeControllerBuilder oldController = Fresco.newDraweeControllerBuilder().setOldController(this.b.getController());
            oldController.setUri(Uri.parse(str));
            oldController.setImageRequest(newBuilderWithSource.build());
            oldController.setAutoPlayAnimations(true);
            this.b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP);
            this.b.getHierarchy().setActualImageFocusPoint(new PointF(0.0f, 0.0f));
            this.b.setController(oldController.build());
            return;
        }
        this.b.setVisibility(8);
    }

    public static final /* synthetic */ void n1(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        String str;
        ModuleData.ChannelBean F0 = channelDynamicFragment.F0();
        String str2 = null;
        if (F0 == null || !F0.isIndividualChannel()) {
            str = null;
        } else {
            str2 = F0.navbarBgColor;
            str = F0.bgImg;
        }
        if (!TextUtils.isEmpty(str2)) {
            channelDynamicFragment.a.setBackgroundColor(z.e(str2, channelDynamicFragment.mContext.getResources().getColor(b.f.channel_background_v2)));
        } else {
            channelDynamicFragment.a.setBackgroundResource(b.f.channel_background_v2);
        }
        channelDynamicFragment.m1(str);
    }

    @WithTryCatchRuntime
    private void notifyBannerScrollChanged(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i0(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(N2, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    @WithTryCatchRuntime
    private void notifyBannerVisible(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j0(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(O2, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    public static final /* synthetic */ void o1(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        j.l.c.c.d.a aVar = new j.l.c.c.d.a("MSG_MAIN_UI");
        aVar.h = new String[]{channelDynamicFragment.v, channelDynamicFragment.u};
        channelDynamicFragment.V(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onHeaderMoving(int i, float f, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new q(new Object[]{this, r.a.c.b.e.k(i), r.a.c.b.e.i(f), r.a.c.b.e.a(z), r.a.c.c.e.y(x2, this, this, new Object[]{r.a.c.b.e.k(i), r.a.c.b.e.i(f), r.a.c.b.e.a(z)})}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onLoadMore() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.g(new Object[]{this, r.a.c.c.e.v(K1, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onPullDownToRefresh() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.j(new Object[]{this, r.a.c.c.e.v(r2, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onRefreshBegin() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h(new Object[]{this, r.a.c.c.e.v(p2, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onRefreshNone() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, r.a.c.c.e.v(q2, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onRefreshing() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{this, r.a.c.c.e.v(s2, this, this)}).e(69648));
    }

    public static final /* synthetic */ void p1(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        channelDynamicFragment.updateStyleFlag();
        if (channelDynamicFragment.t()) {
            channelDynamicFragment.C(0);
        }
        channelDynamicFragment.updateHeaderColor();
    }

    @WithTryCatchRuntime
    private void preUpdateChannelBackground() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{this, r.a.c.c.e.v(K0, this, this)}).e(69648));
    }

    public static final /* synthetic */ void q1(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        SelectedFragment G0 = channelDynamicFragment.G0();
        if (G0 == null || !channelDynamicFragment.isFragmentVisible) {
            return;
        }
        G0.updateMainUI();
    }

    public static final /* synthetic */ void r1(ChannelDynamicFragment channelDynamicFragment, boolean z, c cVar) {
    }

    public static final /* synthetic */ void s1(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        ChannelDynamicPresenter channelDynamicPresenter;
        Map map = channelDynamicFragment.i.getMap();
        channelDynamicFragment.s = -1;
        if (map == null || (channelDynamicPresenter = channelDynamicFragment.k) == null || j.l.a.b0.j.a(channelDynamicPresenter.t())) {
            return;
        }
        ModuleData.DataBean.DSLBean dSLBean = channelDynamicFragment.k.t().get(0);
        j.v.g.i.d dVar = (j.v.g.i.d) map.get(dSLBean.DSLID);
        if (DynamicHelper.d(dVar)) {
            channelDynamicFragment.s = 1;
            channelDynamicFragment.t = channelDynamicFragment.computeVerticalScrollOffset() > channelDynamicFragment.a0();
        } else if (DynamicHelper.isAdBanner(dVar)) {
            channelDynamicFragment.s = 2;
            channelDynamicFragment.t = channelDynamicFragment.computeVerticalScrollOffset() > channelDynamicFragment.a0();
        } else if (DynamicHelper.c(dVar)) {
            channelDynamicFragment.updateAutoPlayFlag(dSLBean.data);
        }
    }

    @WithTryCatchRuntime
    private void setRefreshLayoutTopPadding(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d0(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(J2, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    @WithTryCatchRuntime
    private void setTranslationFloorY(int i, SelectedFragment selectedFragment) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n(new Object[]{this, r.a.c.b.e.k(i), selectedFragment, r.a.c.c.e.x(u2, this, this, r.a.c.b.e.k(i), selectedFragment)}).e(69648));
    }

    @WithTryCatchRuntime
    private void setViewPageTouchAllowed(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new e0(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(K2, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    public static final /* synthetic */ void t1(ChannelDynamicFragment channelDynamicFragment, c cVar) {
        try {
            if (channelDynamicFragment.O()) {
                channelDynamicFragment.updateMainUI();
                ChannelRefreshLayout channelRefreshLayout = channelDynamicFragment.c;
                if (channelRefreshLayout == null) {
                    return;
                }
                channelRefreshLayout.x1(channelDynamicFragment.u, channelDynamicFragment.v);
                channelDynamicFragment.c.w1("", channelDynamicFragment.v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @WithTryCatchRuntime
    private void updateAutoPlayFlag(JsonObject jsonObject) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.z(new Object[]{this, jsonObject, r.a.c.c.e.w(F2, this, this, jsonObject)}).e(69648));
    }

    @WithTryCatchRuntime
    private void updateChannelBackground() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new w(new Object[]{this, r.a.c.c.e.v(k1, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    private void updateHeaderColor() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a0(new Object[]{this, r.a.c.c.e.v(G2, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    private void updateMainUI() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new c0(new Object[]{this, r.a.c.c.e.v(I2, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void updateRefreshAdTitle(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new m(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(t2, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    @WithTryCatchRuntime
    private void updateUIColor() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.b0(new Object[]{this, r.a.c.c.e.v(H2, this, this)}).e(69648));
    }

    public boolean B() {
        ModuleData.ChannelBean F0 = F0();
        return F0 != null && F0.isIndividualChannel();
    }

    public void C(int i) {
        this.r = i;
        setRefreshLayoutTopPadding(i);
    }

    public boolean D() {
        return false;
    }

    public boolean E(String str) {
        return false;
    }

    public boolean F() {
        return i() && this.t;
    }

    public ModuleData.ChannelBean F0() {
        ChannelDynamicPresenter channelDynamicPresenter = this.k;
        if (channelDynamicPresenter != null) {
            return channelDynamicPresenter.r();
        }
        return null;
    }

    public void H(boolean z) {
        onRefreshComplete(z);
        if (J0()) {
            l(1);
            return;
        }
        l(0);
        if (z) {
            setChannelIndex(false, false);
        }
    }

    public ViewGroup H0() {
        return this.h;
    }

    public Map<String, j.u.e.c.i.d> I() {
        DynamicAdPresenter dynamicAdPresenter = this.j;
        if (dynamicAdPresenter == null) {
            return null;
        }
        return dynamicAdPresenter.h();
    }

    public boolean J0() {
        ChannelDynamicPresenter channelDynamicPresenter = this.k;
        return channelDynamicPresenter == null || j.l.a.b0.j.a(channelDynamicPresenter.t()) || this.i.isEmpty();
    }

    @Nullable
    public String K() {
        ChannelDynamicPresenter channelDynamicPresenter = this.k;
        if (channelDynamicPresenter == null) {
            return null;
        }
        return channelDynamicPresenter.q();
    }

    public void L(int i, int i2) {
        ChannelDynamicAdapter channelDynamicAdapter = this.f;
        if (channelDynamicAdapter == null) {
            return;
        }
        if (i < 0 || i2 < 0 || i > i2) {
            channelDynamicAdapter.notifyDataSetChanged();
        } else if (i == i2) {
            channelDynamicAdapter.notifyItemChanged(i);
        } else {
            channelDynamicAdapter.notifyItemRangeChanged(i, (i2 - i) + 1);
        }
    }

    public RecyclerView M() {
        return this.e;
    }

    public void M0() {
        if (this.p) {
            Log.d(E, "refreshChannelIndex first:" + this.m);
            this.p = false;
            d1(true, true);
        }
    }

    public boolean O() {
        return getRealVisible();
    }

    public void P(boolean z) {
    }

    public boolean T() {
        return this.o == 0;
    }

    public void V(j.l.c.c.d.a aVar) {
        String str;
        String str2;
        DynamicAdPresenter dynamicAdPresenter;
        j.u.e.c.i.d adLoader;
        if (aVar == null) {
            return;
        }
        String str3 = aVar.a;
        str3.hashCode();
        char c = 65535;
        boolean z = true;
        switch (str3.hashCode()) {
            case -273841535:
                if (str3.equals("MSG_REFRESH_CHANNEL")) {
                    c = 0;
                    break;
                }
                break;
            case 74992636:
                if (str3.equals("MSG_MAIN_UI")) {
                    c = 1;
                    break;
                }
                break;
            case 1355185788:
                if (str3.equals("MSG_DYNAMIC_MODULE_EXPOSURE")) {
                    c = 2;
                    break;
                }
                break;
            case 1844633576:
                if (str3.equals("MSG_BANNER_EXPOSURED")) {
                    c = 3;
                    break;
                }
                break;
            case 2035252993:
                if (str3.equals("MSG_UPDATE_POSITION")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                c1(false);
                return;
            case 1:
                ModuleData.ChannelBean F0 = F0();
                if (F0 != null && F0.isIndividualChannel()) {
                    str = F0.navbarBgColor;
                    str2 = F0.navbarHlColor;
                } else {
                    String[] strArr = aVar.h;
                    if (strArr == null || strArr.length != 2) {
                        str = "";
                        str2 = str;
                        z = false;
                    } else {
                        str2 = strArr[0];
                        str = strArr[1];
                    }
                }
                this.v = "";
                this.u = "";
                try {
                    if (z.a(str2) && z.a(str)) {
                        this.u = str;
                        this.v = str2;
                    }
                    if (z) {
                        updateUIColor();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 2:
                ChannelDynamicPresenter channelDynamicPresenter = this.k;
                if (channelDynamicPresenter != null) {
                    channelDynamicPresenter.reportModuleExposure(aVar.c, (ModuleData.DataBean.DSLBean) aVar.i);
                    return;
                }
                return;
            case 3:
                ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean = null;
                Object obj = aVar.i;
                if (obj instanceof List) {
                    List list = (List) obj;
                    int size = list.size();
                    int[] iArr = aVar.c;
                    if (size > iArr[0]) {
                        moduleDataBean = (ChannelIndexEntity.DataBean.ModuleDataBean) list.get(iArr[0]);
                    }
                } else if (obj instanceof ChannelIndexEntity.DataBean.ModuleDataBean) {
                    moduleDataBean = (ChannelIndexEntity.DataBean.ModuleDataBean) obj;
                }
                if (BannerHelper.isAdImageResExist(moduleDataBean) && ((!HugeMananger.h().hasHugeData() || aVar.c[1] != 0) && O() && (dynamicAdPresenter = this.j) != null && (adLoader = dynamicAdPresenter.getAdLoader(moduleDataBean)) != null && !moduleDataBean.isBannerExpose)) {
                    moduleDataBean.isBannerExpose = true;
                    adLoader.q();
                }
                findFocusItemForVideoPreview();
                return;
            case 4:
                int i = aVar.b;
                L(i, i);
                return;
            default:
                return;
        }
    }

    public boolean Y() {
        return false;
    }

    @Nullable
    public /* bridge */ /* synthetic */ Activity a() {
        return super.getActivity();
    }

    public int a0() {
        return (t() ? j.l.a.b0.j0.n(this.mContext) : (j.l.a.b0.j0.n(this.mContext) * 9) / 16) / 3;
    }

    public Fragment b() {
        return this;
    }

    public String b0(int i) {
        ModuleData.DataBean.DSLBean dSLBean = this.k.t().get(i);
        return dSLBean != null ? dSLBean.moduleEntityId : "";
    }

    public void b1(String str, j.u.e.c.i.d dVar) {
        DynamicAdPresenter dynamicAdPresenter = this.j;
        if (dynamicAdPresenter != null) {
            dynamicAdPresenter.m(str, dVar);
        }
    }

    public void c(boolean z) {
        ChannelRefreshLayout channelRefreshLayout = this.c;
        if (channelRefreshLayout != null) {
            channelRefreshLayout.m0(z);
        }
    }

    public void c1(boolean z) {
        d1(z, false);
    }

    public int computeVerticalScrollOffset() {
        MGRecyclerView mGRecyclerView = this.e;
        if (mGRecyclerView != null) {
            return mGRecyclerView.computeVerticalScrollOffset();
        }
        return 0;
    }

    public void d1(boolean z, boolean z3) {
        SelectedFragment G0;
        if (!z3 && !this.isFragmentVisible) {
            Log.d(E, "refreshChannelIndex isFragmentVisible false:" + this.m);
            return;
        }
        ChannelDynamicPresenter channelDynamicPresenter = this.k;
        if (channelDynamicPresenter != null) {
            channelDynamicPresenter.refresh();
        }
        if (z || (G0 = G0()) == null) {
            return;
        }
        G0.getChannelListData();
    }

    public void e(boolean z) {
        ChannelRefreshLayout channelRefreshLayout = this.c;
        if (channelRefreshLayout != null) {
            channelRefreshLayout.r0(z);
        }
    }

    public j.l.c.c.c.s1.e f() {
        return this.i;
    }

    public void f1(j.l.c.c.c.u1.u.a aVar) {
        this.C = aVar;
    }

    @WithTryCatchRuntime
    public void findFocusItemForVideoPreview() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f0(new Object[]{this, r.a.c.c.e.v(L2, this, this)}).e(69648));
    }

    @Nullable
    @WithTryCatchRuntime
    public ViewPager findViewPage(ViewGroup viewGroup) {
        return (ViewPager) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k0(new Object[]{this, viewGroup, r.a.c.c.e.w(P2, this, this, viewGroup)}).e(69648));
    }

    @Nullable
    public Activity getCurrentActivity() {
        return this.mActivity;
    }

    public int getUpShrinkage() {
        SelectedFragment G0 = G0();
        if (G0 == null || !t()) {
            return 0;
        }
        return G0.getHeadHeight();
    }

    @WithTryCatchRuntime
    public void handleAction(View view, j.v.g.d.a aVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l0(new Object[]{this, view, aVar, r.a.c.c.e.x(y1, this, this, view, aVar)}).e(69648));
    }

    public boolean i() {
        int i = this.s;
        return i == 1 || i == 2;
    }

    public void i0() {
    }

    public void j(int i, boolean z) {
        ChannelDynamicPresenter channelDynamicPresenter = this.k;
        if (channelDynamicPresenter != null) {
            MGRecyclerView mGRecyclerView = this.e;
            channelDynamicPresenter.R(mGRecyclerView == null ? 0 : mGRecyclerView.getHeight());
        }
        DynamicInnerOnScrollListener dynamicInnerOnScrollListener = this.D;
        if (dynamicInnerOnScrollListener != null) {
            MGRecyclerView mGRecyclerView2 = this.e;
            dynamicInnerOnScrollListener.a(mGRecyclerView2 == null ? 0 : mGRecyclerView2.getHeight());
        }
        onRefreshComplete(i == 0);
        if (ChannelListEntity.isSelectedChannel(this.m) && !z) {
            a.b.a();
            a.b.c(i == 0 ? "0" : "1");
        }
        if (J0()) {
            l(1);
            return;
        }
        l(0);
        if (i == 0) {
            ChannelRefreshLayout channelRefreshLayout = this.c;
            if (channelRefreshLayout != null) {
                channelRefreshLayout.b1(false);
            }
            ChannelDynamicPresenter channelDynamicPresenter2 = this.k;
            if (channelDynamicPresenter2 != null) {
                channelDynamicPresenter2.k();
            }
            ChannelDynamicAdapter channelDynamicAdapter = this.f;
            if (channelDynamicAdapter != null) {
                channelDynamicAdapter.o(F0());
            }
            if (!z) {
                this.u = "";
                this.v = "";
            }
            setChannelIndex(true, z);
            updateHeader();
            updateChannelBackground();
        }
    }

    @Nullable
    public String j0() {
        ChannelDynamicPresenter channelDynamicPresenter = this.k;
        if (channelDynamicPresenter == null) {
            return null;
        }
        return channelDynamicPresenter.p();
    }

    public void l(int i) {
        ChannelEmptyLayout channelEmptyLayout;
        y0.q(this.d, i > 0 ? 0 : 8);
        if (i <= 0 || (channelEmptyLayout = this.d) == null) {
            return;
        }
        channelEmptyLayout.setContentOnClickListener(new a());
    }

    public boolean l0() {
        return J0();
    }

    public boolean n() {
        return false;
    }

    public boolean n0() {
        return j.l.a.t.b.a().c() && ChannelListEntity.isSelectedChannel(this.m);
    }

    public void o0() {
        onRefreshComplete(true);
        ChannelRefreshLayout channelRefreshLayout = this.c;
        if (channelRefreshLayout != null) {
            channelRefreshLayout.n0();
        }
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public int obtainLayoutResourceId() {
        return b.m.fragment_channel_dynamic;
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onDestroy() {
        super.onDestroy();
        ChannelDynamicPresenter channelDynamicPresenter = this.k;
        if (channelDynamicPresenter != null) {
            channelDynamicPresenter.m();
            this.k = null;
        }
    }

    @WithTryCatchRuntime
    public void onEmptyClick() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h0(new Object[]{this, r.a.c.c.e.v(x1, this, this)}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onGrayModeChange() {
        j.l.a.b0.q.k(getView(), n0());
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            VideoPreviewManager.k().g(j.l.a.b0.c0.g(K(), 0), false);
        }
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onInitializeData(@Nullable Bundle bundle) {
        super.onInitializeData(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            l(1);
            return;
        }
        j.l.a.m.b.g.b(j.l.c.c.d.d.class).h(this, this);
        this.m = arguments.getString("bundle_channel_id");
        String string = arguments.getString("bundle_channel_fid");
        this.n = arguments.getInt("bundle_channel_position");
        this.j = new DynamicAdPresenter(this.l);
        ChannelDynamicPresenter channelDynamicPresenter = new ChannelDynamicPresenter(this, this.l, this.m, this.j);
        this.k = channelDynamicPresenter;
        channelDynamicPresenter.Q(string);
        ChannelDynamicAdapter channelDynamicAdapter = new ChannelDynamicAdapter(this.l, this.i, this.k.t());
        this.f = channelDynamicAdapter;
        channelDynamicAdapter.o(F0());
        this.f.p(new j.l.c.c.c.a(this));
        this.e.setAdapter(this.f);
        if (!j.l.a.b0.j.a(this.k.t())) {
            updateHeader();
        }
        if (isUseOperationPostion()) {
            M0();
        }
        preUpdateChannelBackground();
        j.l.a.b0.q.k(getView(), n0());
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onInitializeUI(View view, @Nullable Bundle bundle) {
        super.onInitializeUI(view, bundle);
        this.a = (RelativeLayout) view.findViewById(b.j.rl_channel_container);
        this.b = (MgFrescoImageView) view.findViewById(b.j.channel_bg_img);
        this.c = (ChannelRefreshLayout) view.findViewById(b.j.channel_refresh);
        this.d = (ChannelEmptyLayout) view.findViewById(b.j.emptyLayoutChannel);
        this.h = (FrameLayout) view.findViewById(b.j.fl_scroll_ad_container);
        SelectedFragment G0 = G0();
        if (G0 != null) {
            int i = this.r;
            if (i == 0) {
                i = G0.getHeadHeight();
            }
            C(i);
        }
        MGRecyclerView mGRecyclerView = new MGRecyclerView(this.mContext);
        this.e = mGRecyclerView;
        mGRecyclerView.setClipChildren(false);
        this.e.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.c.X0(50.0f);
        this.c.N(this.e, -1, -1);
        this.c.d1(new MultiPurposeListener(this));
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getActivity());
        this.g = linearLayoutManagerWrapper;
        linearLayoutManagerWrapper.setOrientation(1);
        this.e.setLayoutManager(this.g);
        this.e.clearOnScrollListeners();
        this.e.addOnScrollListener(this.D);
        long h = j.l.a.b0.f0.h("channel_cache_time", 300);
        this.A = h;
        this.A = Math.max(h, 300L) * 1000;
        if (getArguments() == null || !ChannelListEntity.isSelectedChannel(getArguments().getString("bundle_channel_id"))) {
            return;
        }
        a.b.d();
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onNightModeChange(SkinModel skinModel) {
        super.onNightModeChange(skinModel);
        DynamicAdPresenter dynamicAdPresenter = this.j;
        if (dynamicAdPresenter != null) {
            dynamicAdPresenter.updateAdView();
        }
        ChannelDynamicAdapter channelDynamicAdapter = this.f;
        if (channelDynamicAdapter != null) {
            channelDynamicAdapter.notifyDataSetChanged();
        }
    }

    @WithTryCatchRuntime
    public void onRefreshComplete(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new m0(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(C1, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    public void onScrollDepthChanged(int i, int i2) {
        ChannelDynamicPresenter channelDynamicPresenter = this.k;
        if (channelDynamicPresenter != null) {
            channelDynamicPresenter.R(Math.max(channelDynamicPresenter.v(), i2));
        }
    }

    @WithTryCatchRuntime
    public void onScrollStateChanged(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new p(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(w2, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    public void onScrollTwoScreen(boolean z) {
    }

    @WithTryCatchRuntime
    public void onScrolled(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(v2, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    public void onStop() {
        super.onStop();
        VideoPreviewManager.k().g(j.l.a.b0.c0.g(K(), 0), false);
        s();
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onVisibleChanged(boolean z) {
        super.onVisibleChanged(z);
        VideoPreviewManager.k().h(z);
        notifyBannerVisible(z);
        if (z) {
            if (this.z) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.B;
                long j2 = currentTimeMillis - j;
                if (j != -1 && j2 > this.A) {
                    v.c(E, "over " + (j2 / 1000) + " seconds passed, need refresh channel " + K());
                    this.i.requestStyle();
                    c1(false);
                }
            }
            this.z = true;
            M0();
            this.o = 0;
            updateHeaderColor();
            findFocusItemForVideoPreview();
            findRequestAd();
            resetHeadAlpha(1.0f);
        } else {
            if (this.z) {
                this.B = System.currentTimeMillis();
                v.c(E, "channel " + K() + " invisible to user, lastVisibleTime:" + this.B);
            }
            ChannelDynamicPresenter channelDynamicPresenter = this.k;
            if (channelDynamicPresenter != null) {
                channelDynamicPresenter.reportContainerExposure();
            }
            VideoPreviewManager.k().m(j.l.a.b0.c0.g(K(), 0));
            VideoPreviewManager.k().n();
        }
        DynamicAdPresenter dynamicAdPresenter = this.j;
        if (dynamicAdPresenter != null) {
            dynamicAdPresenter.notifyAdVisible(z);
        }
    }

    public void q(int i) {
    }

    public boolean q0() {
        return false;
    }

    public void r(int i, int i2) {
        ChannelDynamicAdapter channelDynamicAdapter;
        if (i < 0 || i2 < 0 || i > i2 || (channelDynamicAdapter = this.f) == null) {
            return;
        }
        if (i == i2) {
            channelDynamicAdapter.notifyItemRemoved(i);
        } else {
            channelDynamicAdapter.notifyItemRangeRemoved(i, (i2 - i) + 1);
        }
        if (i < this.f.getItemCount() - 1) {
            ChannelDynamicAdapter channelDynamicAdapter2 = this.f;
            channelDynamicAdapter2.notifyItemRangeChanged(i, channelDynamicAdapter2.getItemCount() - i);
        }
    }

    public String r0() {
        return t() ? "#FF000000" : this.u;
    }

    public void refresh() {
        MGRecyclerView mGRecyclerView = this.e;
        if (mGRecyclerView == null || mGRecyclerView.getChildCount() <= 0) {
            return;
        }
        this.e.scrollToPosition(0);
    }

    @WithTryCatchRuntime
    public void resetHeadAlpha(float f) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new r(new Object[]{this, r.a.c.b.e.i(f), r.a.c.c.e.w(y2, this, this, r.a.c.b.e.i(f))}).e(69648));
    }

    public void s() {
    }

    @WithTryCatchRuntime
    public void setChannelIndex(boolean z, boolean z3) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.v(new Object[]{this, r.a.c.b.e.a(z), r.a.c.b.e.a(z3), r.a.c.c.e.x(C2, this, this, r.a.c.b.e.a(z), r.a.c.b.e.a(z3))}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            return;
        }
        VideoPreviewManager.k().g(j.l.a.b0.c0.g(K(), 0), false);
    }

    @WithTryCatchRuntime
    public void startHuguSmallVideo(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new t(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(A2, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    public boolean t() {
        return this.s == 1;
    }

    @WithTryCatchRuntime
    public void updateHeader() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new x(new Object[]{this, r.a.c.c.e.v(D2, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void updateStyleFlag() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new y(new Object[]{this, r.a.c.c.e.v(E2, this, this)}).e(69648));
    }

    public String x() {
        return t() ? "#FFFFFFFF" : this.v;
    }

    @WithTryCatchRuntime
    public void onChanged(j.l.c.c.d.d dVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new u(new Object[]{this, dVar, r.a.c.c.e.w(B2, this, this, dVar)}).e(69648));
    }
}
