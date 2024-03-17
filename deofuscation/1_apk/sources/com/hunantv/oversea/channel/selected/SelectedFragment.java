package com.hunantv.oversea.channel.selected;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.facebook.imageutils.JfifUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.hunantv.imgo.base.RootFragment;
import com.hunantv.imgo.nightmode.SkinModel;
import com.hunantv.imgo.nightmode.SkinnableActivity;
import com.hunantv.imgo.nightmode.view.SkinnableImageView;
import com.hunantv.imgo.nightmode.view.SkinnableLinearLayout;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.imgo.widget.BeautifyTextView;
import com.hunantv.media.recoder.GifRecorder;
import com.hunantv.media.report.ReportParams;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.business.ad.huge.HugeMananger;
import com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment;
import com.hunantv.oversea.channel.dynamic.manager.ChannelStyleManger;
import com.hunantv.oversea.channel.selected.adapter.SelectedAdapter;
import com.hunantv.oversea.channel.selected.data.ChannelListEntity;
import com.hunantv.oversea.channel.selected.delegate.DragLayoutDelegate;
import com.hunantv.oversea.channel.selected.view.ChannelTabProvider;
import com.hunantv.oversea.channel.widget.ChannelDragLayout;
import com.hunantv.oversea.channel.widget.ChannelEmptyLayout;
import com.hunantv.oversea.main.common.layerconf.LayerConfDelegate;
import com.hunantv.oversea.report.MGDCManager;
import com.hunantv.oversea.report.ReportManager;
import com.hunantv.oversea.report.data.pv.lob.BasePvLob;
import com.hunantv.oversea.report.data.pv.lob.VodPvLob;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.widget.MgViewPager;
import com.mgtv.widget.smarttablayout.MGSmartTabLayout;
import j.l.a.b0.j0;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.b0.z;
import j.l.a.e;
import j.l.a.u.d;
import j.l.c.c.b;
import j.l.c.c.c.j1;
import j.l.c.c.d.f;
import j.l.c.c.f.a0;
import j.l.c.c.f.b0;
import j.l.c.c.f.c0;
import j.l.c.c.f.d;
import j.l.c.c.f.d0;
import j.l.c.c.f.e0;
import j.l.c.c.f.f0;
import j.l.c.c.f.g;
import j.l.c.c.f.g0;
import j.l.c.c.f.h;
import j.l.c.c.f.h0;
import j.l.c.c.f.i;
import j.l.c.c.f.i0;
import j.l.c.c.f.j;
import j.l.c.c.f.k;
import j.l.c.c.f.l;
import j.l.c.c.f.n;
import j.l.c.c.f.o;
import j.l.c.c.f.s;
import j.l.c.c.f.t;
import j.l.c.c.f.t0;
import j.l.c.c.f.u;
import j.l.c.c.f.w;
import j.l.c.c.f.x;
import j.l.c.c.f.y;
import j.l.d.d;
import j.s.j.y0;
import j.v.r.m;
import j.v.r.p;
import j.v.r.r;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SelectedFragment extends RootFragment implements t0, d, LayerConfDelegate.c {
    public static final int HEIGHT_STATUS_BAR;
    private static final int MSG_GET_CHANNEL_LIST = 1;
    private static final int MSG_UPDATE_MAIN_UI = 16;
    private static final int REQUEST_DELAY_TIME = 2000;
    private static final /* synthetic */ c.b ajc$tjp_0 = null;
    private static final /* synthetic */ c.b ajc$tjp_1 = null;
    private static final /* synthetic */ c.b ajc$tjp_10 = null;
    private static final /* synthetic */ c.b ajc$tjp_11 = null;
    private static final /* synthetic */ c.b ajc$tjp_12 = null;
    private static final /* synthetic */ c.b ajc$tjp_13 = null;
    private static final /* synthetic */ c.b ajc$tjp_14 = null;
    private static final /* synthetic */ c.b ajc$tjp_15 = null;
    private static final /* synthetic */ c.b ajc$tjp_16 = null;
    private static final /* synthetic */ c.b ajc$tjp_17 = null;
    private static final /* synthetic */ c.b ajc$tjp_18 = null;
    private static final /* synthetic */ c.b ajc$tjp_19 = null;
    private static final /* synthetic */ c.b ajc$tjp_2 = null;
    private static final /* synthetic */ c.b ajc$tjp_20 = null;
    private static final /* synthetic */ c.b ajc$tjp_21 = null;
    private static final /* synthetic */ c.b ajc$tjp_22 = null;
    private static final /* synthetic */ c.b ajc$tjp_23 = null;
    private static final /* synthetic */ c.b ajc$tjp_24 = null;
    private static final /* synthetic */ c.b ajc$tjp_25 = null;
    private static final /* synthetic */ c.b ajc$tjp_26 = null;
    private static final /* synthetic */ c.b ajc$tjp_27 = null;
    private static final /* synthetic */ c.b ajc$tjp_28 = null;
    private static final /* synthetic */ c.b ajc$tjp_29 = null;
    private static final /* synthetic */ c.b ajc$tjp_3 = null;
    private static final /* synthetic */ c.b ajc$tjp_30 = null;
    private static final /* synthetic */ c.b ajc$tjp_4 = null;
    private static final /* synthetic */ c.b ajc$tjp_5 = null;
    private static final /* synthetic */ c.b ajc$tjp_6 = null;
    private static final /* synthetic */ c.b ajc$tjp_7 = null;
    private static final /* synthetic */ c.b ajc$tjp_8 = null;
    private static final /* synthetic */ c.b ajc$tjp_9 = null;
    private SelectedAdapter mAdapter;
    private ChannelListEntity mChannelListEntity;
    private ChannelTabProvider mChannelTabProvider;
    private String mCurrentChannelId;
    @e
    private int mCurrentTabIndex;
    private DragLayoutDelegate mDragLayoutDelegate;
    private ChannelEmptyLayout mEmptyLayout;
    private LinearLayout mHeadFrame;
    private LayerConfDelegate mLayerConfDelegate;
    private SelectedPresenter mPresenter;
    private View mStatusBarPlaceholder;
    private m mTaskManager;
    private r mTaskStarter;
    private MGSmartTabLayout stlChannel;
    private MgViewPager vpPager;
    private List<SelectedAdapter.a> dataList = new ArrayList();
    private SparseArray<ChannelListEntity.DataBean> mChannelDataMap = new SparseArray<>();
    private int mHomeIndex = -1;
    private Drawable mMuteHeadDrawable = null;
    private String mCurrentFontColor = null;
    private String mCurrentBgColor = null;
    private String mCurrentChannelCpid = "";
    private Observer<j.l.c.c.d.c> mObserver = new a();
    private View.OnClickListener mEmptyClickListener = new c();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements Observer<j.l.c.c.d.c> {
        public a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable j.l.c.c.d.c cVar) {
            if (cVar != null && TextUtils.equals(((j.l.a.m.b.b) cVar).b, "other_pop_show")) {
                SelectedFragment.this.mDragLayoutDelegate.showDragEnter();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            SelectedFragment.this.invokePageSelected(i);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SelectedFragment.this.mEmptyLayout != null) {
                SelectedFragment.this.mEmptyLayout.setVisibility(8);
            }
            SelectedFragment.this.loadNetData(false);
        }
    }

    static {
        ajc$preClinit();
        HEIGHT_STATUS_BAR = j0.p(j.l.a.a.a());
    }

    @WithTryCatchRuntime
    private void addChannel(@NonNull ChannelListEntity.DataBean dataBean, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.e(new Object[]{this, dataBean, r.a.c.b.e.k(i), r.a.c.c.e.x(ajc$tjp_5, this, this, dataBean, r.a.c.b.e.k(i))}).e(69648));
    }

    public static final /* synthetic */ void addChannel_aroundBody10(SelectedFragment selectedFragment, ChannelListEntity.DataBean dataBean, int i, r.a.b.c cVar) {
        selectedFragment.dataList.add(selectedFragment.mPresenter.getChannelMapping(dataBean));
        selectedFragment.mChannelDataMap.put(i, dataBean);
    }

    private static /* synthetic */ void ajc$preClinit() {
        r.a.c.c.e eVar = new r.a.c.c.e("SelectedFragment.java", SelectedFragment.class);
        ajc$tjp_0 = eVar.H("method-execution", eVar.E("1", "onCreate", "com.hunantv.oversea.channel.selected.SelectedFragment", "android.os.Bundle", "savedInstanceState", "", "void"), (int) EventClickData.u.C1);
        ajc$tjp_1 = eVar.H("method-execution", eVar.E("1", "onHandleMessage", "com.hunantv.oversea.channel.selected.SelectedFragment", "android.os.Message", "msg", "", "void"), 237);
        ajc$tjp_10 = eVar.H("method-execution", eVar.E("2", "findChannelIndex", "com.hunantv.oversea.channel.selected.SelectedFragment", "java.lang.String", RemoteMessageConst.Notification.CHANNEL_ID, "", "int"), 482);
        ajc$tjp_11 = eVar.H("method-execution", eVar.E("2", "findHomeIndex", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "void"), 499);
        ajc$tjp_12 = eVar.H("method-execution", eVar.E("1", "updateMainUI", "com.hunantv.oversea.channel.selected.SelectedFragment", "boolean", "forDefault", "", "void"), 529);
        ajc$tjp_13 = eVar.H("method-execution", eVar.E("2", "innerUpdateMainUI", "com.hunantv.oversea.channel.selected.SelectedFragment", "boolean", "forceDefault", "", "void"), (int) ReportParams.MAX_LEAVE_VALID_TIME);
        ajc$tjp_14 = eVar.H("method-execution", eVar.E("2", "updateScaningColor", "com.hunantv.oversea.channel.selected.SelectedFragment", "java.lang.String:boolean", "fontColor:isDynamicSpecialStyle", "", "void"), 624);
        ajc$tjp_15 = eVar.H("method-execution", eVar.E("2", "updateNavUI", "com.hunantv.oversea.channel.selected.SelectedFragment", "int:android.content.res.ColorStateList", "bgColor:preColor", "", "void"), 655);
        ajc$tjp_16 = eVar.H("method-execution", eVar.E("2", "resetIndexTopLayout", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "void"), 678);
        ajc$tjp_17 = eVar.H("method-execution", eVar.E("2", "refreshHeadContent", "com.hunantv.oversea.channel.selected.SelectedFragment", "int", "paddingColor", "", "void"), 697);
        ajc$tjp_18 = eVar.H("method-execution", eVar.E("1", "refreshHeadFrame", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "boolean"), 716);
        ajc$tjp_19 = eVar.H("method-execution", eVar.E("1", "getCurrentTabIndex", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "int"), 745);
        ajc$tjp_2 = eVar.H("method-execution", eVar.E("4", "loadNetData", "com.hunantv.oversea.channel.selected.SelectedFragment", "boolean", "enableMemory", "", "void"), 273);
        ajc$tjp_20 = eVar.H("method-execution", eVar.E("1", "getUpShrinkage", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "int"), 753);
        ajc$tjp_21 = eVar.H("method-execution", eVar.E("2", "getVisibleIndex", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "com.hunantv.oversea.channel.dynamic.IChannelIndex"), 762);
        ajc$tjp_22 = eVar.H("method-execution", eVar.E("1", "onKeyDown", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "boolean"), 778);
        ajc$tjp_23 = eVar.H("method-execution", eVar.E("1", "getHeadHeight", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "int"), 792);
        ajc$tjp_24 = eVar.H("method-execution", eVar.E("1", "onHeaderAlpha", "com.hunantv.oversea.channel.selected.SelectedFragment", "float", "percent", "", "void"), 802);
        ajc$tjp_25 = eVar.H("method-execution", eVar.E("1", "setViewPageTouchAllowed", "com.hunantv.oversea.channel.selected.SelectedFragment", "boolean", "enable", "", "void"), 812);
        ajc$tjp_26 = eVar.H("method-execution", eVar.E("1", "resetSpecailBanner", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "void"), 847);
        ajc$tjp_27 = eVar.H("method-execution", eVar.E("1", "getHugMaxHeight", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "int"), 858);
        ajc$tjp_28 = eVar.H("method-execution", eVar.E("1", "reportChannelPagePV", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "void"), 909);
        ajc$tjp_29 = eVar.H("method-execution", eVar.E("2", "reportChannelPagePV", "com.hunantv.oversea.channel.selected.SelectedFragment", "int", "position", "", "void"), 917);
        ajc$tjp_3 = eVar.H("method-execution", eVar.E("1", "updateChannelList", "com.hunantv.oversea.channel.selected.SelectedFragment", "com.hunantv.oversea.channel.selected.data.ChannelListEntity:boolean", "channelListEntity:fromNetwork", "", "void"), 279);
        ajc$tjp_30 = eVar.H("method-execution", eVar.E("2", "checkSelectedSingleGray", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "void"), 970);
        ajc$tjp_4 = eVar.H("method-execution", eVar.E("2", "setChannelListAndIndex", "com.hunantv.oversea.channel.selected.SelectedFragment", "boolean", "fromNetwork", "", "void"), (int) GifRecorder.ERR_RESON_MAKE_GIF_ERROR);
        ajc$tjp_5 = eVar.H("method-execution", eVar.E("2", "addChannel", "com.hunantv.oversea.channel.selected.SelectedFragment", "com.hunantv.oversea.channel.selected.data.ChannelListEntity$DataBean:int", "data:index", "", "void"), 359);
        ajc$tjp_6 = eVar.H("method-execution", eVar.E("2", "initAdapter", "com.hunantv.oversea.channel.selected.SelectedFragment", "", "", "", "void"), 369);
        ajc$tjp_7 = eVar.H("method-execution", eVar.E("2", "invokePageSelected", "com.hunantv.oversea.channel.selected.SelectedFragment", "int", "position", "", "void"), 399);
        ajc$tjp_8 = eVar.H("method-execution", eVar.E("1", "switchToChannel", "com.hunantv.oversea.channel.selected.SelectedFragment", "java.lang.String", RemoteMessageConst.Notification.CHANNEL_ID, "", "void"), 439);
        ajc$tjp_9 = eVar.H("method-execution", eVar.E("2", "findTabIndex", "com.hunantv.oversea.channel.selected.SelectedFragment", "boolean", "fromNetwork", "", "int"), 460);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void checkSelectedSingleGray() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g0(new Object[]{this, r.a.c.c.e.v(ajc$tjp_30, this, this)}).e(69648));
    }

    public static final /* synthetic */ void checkSelectedSingleGray_aroundBody60(SelectedFragment selectedFragment, r.a.b.c cVar) {
        boolean isSelectedSingleGray = selectedFragment.isSelectedSingleGray();
        Object tag = selectedFragment.mHeadFrame.getTag(b.j.home_jx_style);
        if (tag == null || ((Boolean) tag).booleanValue() != isSelectedSingleGray) {
            q.k(selectedFragment.mHeadFrame, isSelectedSingleGray);
            if (selectedFragment.getParentFragment() instanceof f) {
                selectedFragment.getParentFragment().c0();
            }
        }
    }

    @WithTryCatchRuntime
    private int findChannelIndex(String str) {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{this, str, r.a.c.c.e.w(ajc$tjp_10, this, this, str)}).e(69648)));
    }

    public static final /* synthetic */ int findChannelIndex_aroundBody20(SelectedFragment selectedFragment, String str, r.a.b.c cVar) {
        if (!TextUtils.isEmpty(str) && selectedFragment.dataList != null) {
            for (int i = 0; i < selectedFragment.dataList.size(); i++) {
                if (TextUtils.equals(str, selectedFragment.dataList.get(i).e)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @WithTryCatchRuntime
    private void findHomeIndex() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{this, r.a.c.c.e.v(ajc$tjp_11, this, this)}).e(69648));
    }

    public static final /* synthetic */ void findHomeIndex_aroundBody22(SelectedFragment selectedFragment, r.a.b.c cVar) {
        ChannelListEntity channelListEntity = selectedFragment.mChannelListEntity;
        if (channelListEntity != null && channelListEntity.data != null) {
            for (int i = 0; i < selectedFragment.mChannelListEntity.data.size(); i++) {
                ChannelListEntity.DataBean dataBean = selectedFragment.mChannelListEntity.data.get(i);
                if (!TextUtils.isEmpty(dataBean.vclassId) && ChannelListEntity.isSelectedChannel(dataBean.vclassId)) {
                    selectedFragment.mHomeIndex = i;
                    return;
                }
            }
            return;
        }
        selectedFragment.mHomeIndex = -1;
    }

    @WithTryCatchRuntime
    private int findTabIndex(boolean z) {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(ajc$tjp_9, this, this, r.a.c.b.e.a(z))}).e(69648)));
    }

    public static final /* synthetic */ int findTabIndex_aroundBody18(SelectedFragment selectedFragment, boolean z, r.a.b.c cVar) {
        int i = selectedFragment.mCurrentTabIndex;
        String str = selectedFragment.TAG;
        j.l.a.n.m.a.d("30", str, "findTabIndex mCurrentChannelId:" + selectedFragment.mCurrentChannelId + ", fromNetwork:" + z);
        if (z && !TextUtils.isEmpty(selectedFragment.mCurrentChannelId)) {
            int findChannelIndex = selectedFragment.findChannelIndex(selectedFragment.mCurrentChannelId);
            SelectedAdapter selectedAdapter = selectedFragment.mAdapter;
            if (selectedAdapter != null && findChannelIndex < selectedAdapter.getCount() && findChannelIndex >= 0) {
                String str2 = selectedFragment.TAG;
                j.l.a.n.m.a.d("30", str2, "findTabIndex mCurrentTabIndex:" + selectedFragment.mCurrentTabIndex + ", findIndex:" + findChannelIndex);
                i = findChannelIndex;
            }
            selectedFragment.mCurrentChannelId = null;
        }
        return i;
    }

    public static final /* synthetic */ int getCurrentTabIndex_aroundBody38(SelectedFragment selectedFragment, r.a.b.c cVar) {
        if (selectedFragment.getRealVisible()) {
            return selectedFragment.mCurrentTabIndex;
        }
        return -1;
    }

    public static final /* synthetic */ int getHeadHeight_aroundBody46(SelectedFragment selectedFragment, r.a.b.c cVar) {
        LinearLayout linearLayout = selectedFragment.mHeadFrame;
        if (linearLayout == null) {
            return 0;
        }
        return linearLayout.getHeight();
    }

    public static final /* synthetic */ int getHugMaxHeight_aroundBody54(SelectedFragment selectedFragment, r.a.b.c cVar) {
        int headHeight = selectedFragment.getHeadHeight() - selectedFragment.getUpShrinkage();
        return !d.b.b ? headHeight - (HEIGHT_STATUS_BAR / 2) : headHeight;
    }

    public static final /* synthetic */ int getUpShrinkage_aroundBody40(SelectedFragment selectedFragment, r.a.b.c cVar) {
        j1 visibleIndex = selectedFragment.getVisibleIndex();
        if (visibleIndex != null) {
            return visibleIndex.getUpShrinkage();
        }
        return 0;
    }

    @WithTryCatchRuntime
    private j1 getVisibleIndex() {
        return (j1) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new w(new Object[]{this, r.a.c.c.e.v(ajc$tjp_21, this, this)}).e(69648));
    }

    public static final /* synthetic */ j1 getVisibleIndex_aroundBody42(SelectedFragment selectedFragment, r.a.b.c cVar) {
        SelectedAdapter selectedAdapter = selectedFragment.mAdapter;
        if (selectedAdapter == null) {
            return null;
        }
        j1 currentFragment = selectedAdapter.getCurrentFragment(selectedFragment.vpPager.getCurrentItem());
        if (currentFragment instanceof j1) {
            return currentFragment;
        }
        return null;
    }

    @WithTryCatchRuntime
    private void initAdapter() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.f(new Object[]{this, r.a.c.c.e.v(ajc$tjp_6, this, this)}).e(69648));
    }

    public static final /* synthetic */ void initAdapter_aroundBody12(SelectedFragment selectedFragment, r.a.b.c cVar) {
        SelectedAdapter selectedAdapter = selectedFragment.mAdapter;
        if (selectedAdapter == null) {
            SelectedAdapter selectedAdapter2 = new SelectedAdapter(selectedFragment.getChildFragmentManager(), selectedFragment.dataList);
            selectedFragment.mAdapter = selectedAdapter2;
            selectedFragment.vpPager.setAdapter(selectedAdapter2);
            selectedFragment.vpPager.setOffscreenPageLimit(1);
            selectedFragment.stlChannel.setOnPageChangeListener(new b());
            return;
        }
        selectedAdapter.notifyDataSetChanged();
    }

    private void initTaskStarter() {
        this.mTaskManager = new m(ThreadManager.getNetWorkExecutorService(), false);
        this.mTaskStarter = new r(getActivity(), this.mTaskManager, (p) null);
    }

    @WithTryCatchRuntime
    private void innerUpdateMainUI(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(ajc$tjp_13, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    public static final /* synthetic */ void innerUpdateMainUI_aroundBody26(SelectedFragment selectedFragment, boolean z, r.a.b.c cVar) {
        int color;
        int alphaComponent;
        int i;
        if (selectedFragment.isDestroyed()) {
            return;
        }
        selectedFragment.resetIndexTopLayout();
        j1 visibleIndex = selectedFragment.getVisibleIndex();
        String str = "";
        String r0 = (z || visibleIndex == null) ? "" : visibleIndex.r0();
        String x = (z || visibleIndex == null) ? "" : visibleIndex.x();
        selectedFragment.stlChannel.post(new j.l.c.c.f.a(selectedFragment));
        String str2 = selectedFragment.TAG;
        v.c(str2, "mCurrentBgColor:" + selectedFragment.mCurrentBgColor + "  mCurrentFontColor:  fontColor:" + x + "  bgColor:" + r0 + BeautifyTextView.c + z);
        boolean z2 = true;
        if (TextUtils.equals(r0, selectedFragment.mCurrentBgColor) && TextUtils.equals(selectedFragment.mCurrentFontColor, x)) {
            if (visibleIndex == null || !visibleIndex.t() || visibleIndex.F() || visibleIndex.D()) {
                return;
            }
            j.v.q.c.a(selectedFragment.getActivity(), 2).b(selectedFragment.getActivity(), true);
            selectedFragment.refreshHeadContent(z.e(r0, 0));
            return;
        }
        if ((TextUtils.isEmpty(x) && TextUtils.isEmpty(r0)) || (visibleIndex != null && visibleIndex.F())) {
            ((SkinnableLinearLayout) selectedFragment.mHeadFrame).clearDynamicStyle();
            if (selectedFragment.getActivity() != null) {
                selectedFragment.getActivity().refreshStatusBar();
            }
            if (Build.VERSION.SDK_INT < 23) {
                if (j.l.a.t.e.m().s()) {
                    selectedFragment.mStatusBarPlaceholder.setBackgroundColor(-16777216);
                } else {
                    selectedFragment.mStatusBarPlaceholder.setBackgroundColor(0);
                }
            }
            Resources resources = selectedFragment.getResources();
            int i2 = b.f.color_oversea_channel_normal;
            color = resources.getColor(i2);
            int color2 = selectedFragment.getResources().getColor(i2);
            alphaComponent = selectedFragment.getResources().getColor(b.f.color_oversea_channel_unselect);
            i = color2;
            r0 = "";
        } else {
            color = selectedFragment.getResources().getColor(b.f.color_v60_bg_primary);
            if (!TextUtils.isEmpty(r0)) {
                color = z.e(r0, color);
            }
            int e = z.e(x, selectedFragment.getResources().getColor(b.f.color_oversea_channel_normal));
            alphaComponent = ColorUtils.setAlphaComponent(e, 154);
            selectedFragment.refreshHeadContent(color);
            if (visibleIndex != null && visibleIndex.D() && (selectedFragment.getActivity() instanceof SkinnableActivity)) {
                selectedFragment.getActivity().refreshStatusBar();
            } else {
                j.v.q.c.a(selectedFragment.getActivity(), 2).b(selectedFragment.getActivity(), true);
            }
            String str3 = x;
            i = e;
            str = str3;
        }
        selectedFragment.updateNavUI(color, new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{i, alphaComponent}));
        selectedFragment.updateScaningColor(str, (visibleIndex == null || !visibleIndex.t() || visibleIndex.F()) ? false : false);
        selectedFragment.mCurrentBgColor = r0;
        selectedFragment.mCurrentFontColor = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void invokePageSelected(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(ajc$tjp_7, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    public static final /* synthetic */ void invokePageSelected_aroundBody14(SelectedFragment selectedFragment, int i, r.a.b.c cVar) {
        selectedFragment.mCurrentTabIndex = i;
        selectedFragment.mChannelTabProvider.refreshView(i);
        SelectedAdapter.a f = selectedFragment.mAdapter.f(i);
        if (f == null) {
            selectedFragment.updateMainUI(true);
            selectedFragment.mCurrentChannelId = null;
        } else {
            if (f.a == ChannelDynamicFragment.class) {
                selectedFragment.updateMainUI(false);
            } else {
                selectedFragment.updateMainUI(true);
            }
            selectedFragment.mCurrentChannelId = f.e;
        }
        if (i == selectedFragment.mHomeIndex) {
            j.l.c.c.d.c cVar2 = new j.l.c.c.d.c();
            ((j.l.a.m.b.b) cVar2).b = "enter_main_page";
            j.l.a.m.b.g.b(j.l.c.c.d.c.class).a(cVar2);
        } else {
            j.l.c.c.d.c cVar3 = new j.l.c.c.d.c();
            ((j.l.a.m.b.b) cVar3).b = "enter_LEAVE_page";
            j.l.a.m.b.g.b(j.l.c.c.d.c.class).a(cVar3);
        }
        selectedFragment.mDragLayoutDelegate.f(i);
        selectedFragment.reportChannelPagePV(i);
    }

    private void loadCacheData() {
        this.mPresenter.loadCacheList();
    }

    public static final /* synthetic */ void onCreate_aroundBody0(SelectedFragment selectedFragment, Bundle bundle, r.a.b.c cVar) {
        super.onCreate(bundle);
        MGDCManager.n().registerDSource("channel", "SelectedFragment", selectedFragment);
        ChannelStyleManger.m().init();
    }

    public static final /* synthetic */ void onHandleMessage_aroundBody2(SelectedFragment selectedFragment, Message message, r.a.b.c cVar) {
        super.onHandleMessage(message);
        int i = message.what;
        if (i == 1) {
            j.l.a.n.m.a.d("30", selectedFragment.TAG, "requestChannelList");
            selectedFragment.loadNetData(true);
        } else if (i != 16) {
        } else {
            Object obj = message.obj;
            selectedFragment.innerUpdateMainUI(obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false);
        }
    }

    public static final /* synthetic */ void onHeaderAlpha_aroundBody48(SelectedFragment selectedFragment, float f, r.a.b.c cVar) {
        y0.j(selectedFragment.mHeadFrame, f);
        y0.q(selectedFragment.mHeadFrame, f == 0.0f ? 4 : 0);
    }

    public static final /* synthetic */ boolean onKeyDown_aroundBody44(SelectedFragment selectedFragment, r.a.b.c cVar) {
        j1 visibleIndex = selectedFragment.getVisibleIndex();
        if (visibleIndex != null) {
            return visibleIndex.q0();
        }
        return false;
    }

    @WithTryCatchRuntime
    private void refreshHeadContent(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.r(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(ajc$tjp_17, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    public static final /* synthetic */ void refreshHeadContent_aroundBody34(SelectedFragment selectedFragment, int i, r.a.b.c cVar) {
        j1 visibleIndex = selectedFragment.getVisibleIndex();
        if (i != 0 && (visibleIndex == null || !visibleIndex.t() || visibleIndex.F())) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(selectedFragment.getResources().getColor(b.f.transparent)), new ColorDrawable(i)});
            layerDrawable.setLayerInset(1, 0, 0, 0, (visibleIndex == null || !visibleIndex.i()) ? 0 : selectedFragment.getUpShrinkage());
            selectedFragment.mHeadFrame.setBackground(layerDrawable);
            return;
        }
        selectedFragment.mHeadFrame.setBackgroundColor(0);
    }

    public static final /* synthetic */ boolean refreshHeadFrame_aroundBody36(SelectedFragment selectedFragment, r.a.b.c cVar) {
        j1 visibleIndex = selectedFragment.getVisibleIndex();
        if (visibleIndex != null && visibleIndex.i()) {
            if (!visibleIndex.t()) {
                return visibleIndex.computeVerticalScrollOffset() > visibleIndex.a0();
            }
            float computeVerticalScrollOffset = (visibleIndex.computeVerticalScrollOffset() * 1.0f) / visibleIndex.a0();
            boolean z = ((double) computeVerticalScrollOffset) > 0.2d;
            if (selectedFragment.mMuteHeadDrawable == null) {
                Drawable mutate = selectedFragment.mHeadFrame.getBackground().mutate();
                selectedFragment.mMuteHeadDrawable = mutate;
                selectedFragment.mHeadFrame.setBackground(mutate);
            }
            Drawable drawable = selectedFragment.mMuteHeadDrawable;
            if (drawable != null) {
                drawable.setAlpha((int) Math.min(255.0f, computeVerticalScrollOffset * 255.0f));
            }
            return z;
        }
        Drawable background = selectedFragment.mHeadFrame.getBackground();
        if (background != null) {
            background.setAlpha(JfifUtil.MARKER_FIRST_BYTE);
        }
        return false;
    }

    public static final /* synthetic */ void reportChannelPagePV_aroundBody58(SelectedFragment selectedFragment, int i, r.a.b.c cVar) {
        ChannelListEntity channelListEntity;
        List<ChannelListEntity.DataBean> list;
        boolean isEmpty;
        String str = "";
        try {
            if (selectedFragment.vpPager != null && (channelListEntity = selectedFragment.mChannelListEntity) != null && (list = channelListEntity.data) != null && !list.isEmpty()) {
                if (i < 0) {
                    i = selectedFragment.vpPager.getCurrentItem();
                }
                if (i >= 0 && i < selectedFragment.mChannelListEntity.data.size()) {
                    ChannelListEntity.DataBean dataBean = selectedFragment.mChannelListEntity.data.get(i);
                    if (dataBean == null) {
                        if (isEmpty) {
                            return;
                        }
                        return;
                    }
                    str = String.valueOf(dataBean.vclassId);
                    j.l.c.x.t0.a.a().r = dataBean.cid;
                    selectedFragment.mCurrentChannelCpid = str;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (!j.v.e.a.d.b.f().i) {
                        j.v.e.a.d.b.f().g(j.l.a.a.a());
                    }
                    VodPvLob vodPvLob = new VodPvLob();
                    ((BasePvLob) vodPvLob).cpid = str;
                    vodPvLob.cid = j.l.c.x.t0.a.a().r;
                    ReportManager.b().reportPv("ch_channel", vodPvLob);
                    MGDCManager.n().enterScene("channel", selectedFragment);
                    MGDCManager.n().onEvent("page");
                    return;
                }
                if (TextUtils.isEmpty("")) {
                    return;
                }
                if (!j.v.e.a.d.b.f().i) {
                    j.v.e.a.d.b.f().g(j.l.a.a.a());
                }
                VodPvLob vodPvLob2 = new VodPvLob();
                ((BasePvLob) vodPvLob2).cpid = "";
                vodPvLob2.cid = j.l.c.x.t0.a.a().r;
                ReportManager.b().reportPv("ch_channel", vodPvLob2);
                MGDCManager.n().enterScene("channel", selectedFragment);
                MGDCManager.n().onEvent("page");
                return;
            }
            if (TextUtils.isEmpty("")) {
                return;
            }
            if (!j.v.e.a.d.b.f().i) {
                j.v.e.a.d.b.f().g(j.l.a.a.a());
            }
            VodPvLob vodPvLob3 = new VodPvLob();
            ((BasePvLob) vodPvLob3).cpid = "";
            vodPvLob3.cid = j.l.c.x.t0.a.a().r;
            ReportManager.b().reportPv("ch_channel", vodPvLob3);
            MGDCManager.n().enterScene("channel", selectedFragment);
            MGDCManager.n().onEvent("page");
        } finally {
            if (!TextUtils.isEmpty(str)) {
                if (!j.v.e.a.d.b.f().i) {
                    j.v.e.a.d.b.f().g(j.l.a.a.a());
                }
                VodPvLob vodPvLob4 = new VodPvLob();
                ((BasePvLob) vodPvLob4).cpid = str;
                vodPvLob4.cid = j.l.c.x.t0.a.a().r;
                ReportManager.b().reportPv("ch_channel", vodPvLob4);
                MGDCManager.n().enterScene("channel", selectedFragment);
                MGDCManager.n().onEvent("page");
            }
        }
    }

    @WithTryCatchRuntime
    private void resetIndexTopLayout() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.q(new Object[]{this, r.a.c.c.e.v(ajc$tjp_16, this, this)}).e(69648));
    }

    public static final /* synthetic */ void resetIndexTopLayout_aroundBody32(SelectedFragment selectedFragment, r.a.b.c cVar) {
        if (selectedFragment.getChildFragmentManager().getFragments().isEmpty()) {
            return;
        }
        for (j1 j1Var : selectedFragment.getChildFragmentManager().getFragments()) {
            if ((j1Var instanceof j1) && selectedFragment.mHeadFrame != null) {
                j1 j1Var2 = j1Var;
                j1Var2.C(j1Var2.i() ? selectedFragment.mHeadFrame.getHeight() - selectedFragment.getUpShrinkage() : selectedFragment.mHeadFrame.getHeight());
            }
        }
    }

    public static final /* synthetic */ void resetSpecailBanner_aroundBody52(SelectedFragment selectedFragment, r.a.b.c cVar) {
        j1 visibleIndex = selectedFragment.getVisibleIndex();
        if (visibleIndex == null || !HugeMananger.h().hasHugeData()) {
            return;
        }
        visibleIndex.startHuguSmallVideo(true);
    }

    @WithTryCatchRuntime
    private void setChannelListAndIndex(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i0(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(ajc$tjp_4, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    public static final /* synthetic */ void setChannelListAndIndex_aroundBody8(SelectedFragment selectedFragment, boolean z, r.a.b.c cVar) {
        if (selectedFragment.mChannelTabProvider == null) {
            ChannelTabProvider channelTabProvider = new ChannelTabProvider(selectedFragment.getActivity() == null ? j.l.a.a.a() : selectedFragment.getActivity());
            selectedFragment.mChannelTabProvider = channelTabProvider;
            selectedFragment.stlChannel.setCustomTabView(channelTabProvider);
        }
        selectedFragment.mChannelTabProvider.f(selectedFragment.mChannelListEntity);
        selectedFragment.dataList.clear();
        ChannelListEntity channelListEntity = selectedFragment.mChannelListEntity;
        if (channelListEntity != null && channelListEntity.data != null) {
            int i = -1;
            for (int i2 = 0; i2 < selectedFragment.mChannelListEntity.data.size(); i2++) {
                ChannelListEntity.DataBean dataBean = selectedFragment.mChannelListEntity.data.get(i2);
                if (!TextUtils.isEmpty(dataBean.vclassId) && !TextUtils.isEmpty(dataBean.title)) {
                    selectedFragment.addChannel(dataBean, i2);
                    if (TextUtils.equals(dataBean.isDefault, "1") && i == -1) {
                        selectedFragment.mCurrentTabIndex = i2;
                        i = i2;
                    }
                }
            }
        }
        selectedFragment.initAdapter();
        selectedFragment.vpPager.clearOnPageChangeListeners();
        selectedFragment.stlChannel.setViewPager(selectedFragment.vpPager);
        int findTabIndex = selectedFragment.findTabIndex(z);
        selectedFragment.vpPager.setCurrentItem(findTabIndex);
        selectedFragment.mChannelTabProvider.refreshView(findTabIndex);
        if (findTabIndex == 0) {
            selectedFragment.reportChannelPagePV(findTabIndex);
        }
        selectedFragment.findHomeIndex();
        boolean isEmpty = selectedFragment.dataList.isEmpty();
        selectedFragment.mEmptyLayout.setVisibility(isEmpty ? 0 : 8);
        selectedFragment.mEmptyLayout.setContentOnClickListener(isEmpty ? selectedFragment.mEmptyClickListener : null);
    }

    public static final /* synthetic */ void setViewPageTouchAllowed_aroundBody50(SelectedFragment selectedFragment, boolean z, r.a.b.c cVar) {
        MgViewPager mgViewPager = selectedFragment.vpPager;
        if (mgViewPager != null) {
            mgViewPager.setTouchAllowed(z);
        }
    }

    public static final /* synthetic */ void switchToChannel_aroundBody16(SelectedFragment selectedFragment, String str, r.a.b.c cVar) {
        ChannelListEntity channelListEntity;
        if (str == null || str.isEmpty() || (channelListEntity = selectedFragment.mChannelListEntity) == null || channelListEntity.data == null) {
            return;
        }
        for (int i = 0; i < selectedFragment.mChannelListEntity.data.size(); i++) {
            if (str.equals(selectedFragment.mChannelListEntity.data.get(i).vclassId)) {
                selectedFragment.mCurrentTabIndex = i;
                selectedFragment.vpPager.setCurrentItem(i);
                return;
            }
        }
    }

    public static final /* synthetic */ void updateChannelList_aroundBody6(SelectedFragment selectedFragment, ChannelListEntity channelListEntity, boolean z, r.a.b.c cVar) {
        if (selectedFragment.isDetached() || selectedFragment.isDestroyed()) {
            return;
        }
        if (channelListEntity != null && channelListEntity.data != null) {
            selectedFragment.mChannelListEntity = channelListEntity;
            selectedFragment.setChannelListAndIndex(z);
        } else if (selectedFragment.dataList.isEmpty()) {
            selectedFragment.mEmptyLayout.setVisibility(0);
            selectedFragment.mEmptyLayout.setContentOnClickListener(selectedFragment.mEmptyClickListener);
        }
    }

    public static final /* synthetic */ void updateMainUI_aroundBody24(SelectedFragment selectedFragment, boolean z, r.a.b.c cVar) {
        selectedFragment.removeMessages(16);
        selectedFragment.sendMessage(16, Boolean.valueOf(z));
    }

    @WithTryCatchRuntime
    private void updateNavUI(@ColorInt int i, @Nullable ColorStateList colorStateList) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.p(new Object[]{this, r.a.c.b.e.k(i), colorStateList, r.a.c.c.e.x(ajc$tjp_15, this, this, r.a.c.b.e.k(i), colorStateList)}).e(69648));
    }

    public static final /* synthetic */ void updateNavUI_aroundBody30(SelectedFragment selectedFragment, int i, ColorStateList colorStateList, r.a.b.c cVar) {
        if (selectedFragment.stlChannel == null || selectedFragment.mAdapter == null) {
            return;
        }
        j1 visibleIndex = selectedFragment.getVisibleIndex();
        boolean z = i == 0 && colorStateList == null;
        ChannelTabProvider channelTabProvider = selectedFragment.mChannelTabProvider;
        if (channelTabProvider != null) {
            channelTabProvider.refreshViewColor(z, colorStateList, (visibleIndex == null || !visibleIndex.t() || visibleIndex.F()) ? false : true);
            if (visibleIndex != null && visibleIndex.B()) {
                selectedFragment.mChannelTabProvider.refreshIndicatorColor(false, colorStateList);
            } else {
                selectedFragment.mChannelTabProvider.refreshIndicatorColor(true, null);
            }
        }
    }

    @WithTryCatchRuntime
    private void updateScaningColor(String str, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o(new Object[]{this, str, r.a.c.b.e.a(z), r.a.c.c.e.x(ajc$tjp_14, this, this, str, r.a.c.b.e.a(z))}).e(69648));
    }

    public static final /* synthetic */ void updateScaningColor_aroundBody28(SelectedFragment selectedFragment, String str, boolean z, r.a.b.c cVar) {
        if (selectedFragment.getView() != null) {
            ImageView imageView = (ImageView) selectedFragment.getView().findViewById(b.j.iv_channel_top_scan);
            if (TextUtils.isEmpty(str)) {
                if (imageView instanceof SkinnableImageView) {
                    ((SkinnableImageView) imageView).clearDynamicColor();
                    return;
                }
                return;
            }
            int e = z.e(str, selectedFragment.mContext.getResources().getColor(b.f.skin_color_title_text_primary));
            if (z) {
                e = ColorUtils.setAlphaComponent(e, 154);
            }
            ColorStateList valueOf = ColorStateList.valueOf(e);
            Drawable a2 = j.v.s.a.b.a.a(b.h.ic_channel_top_scan);
            if (a2 != null) {
                j.v.s.a.b.a.d(imageView, a2, valueOf);
            }
        }
    }

    public static /* synthetic */ void v0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(View view) {
        new d.c().a("/mgtv/MeLoginCaptureActivity").g().g(getContext());
    }

    public void getChannelListData() {
        removeMessages(1);
        sendMessage(1, (Object) 2000);
    }

    @WithTryCatchRuntime
    public int getCurrentTabIndex() {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new t(new Object[]{this, r.a.c.c.e.v(ajc$tjp_19, this, this)}).e(69648)));
    }

    @WithTryCatchRuntime
    public int getHeadHeight() {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new y(new Object[]{this, r.a.c.c.e.v(ajc$tjp_23, this, this)}).e(69648)));
    }

    @WithTryCatchRuntime
    public int getHugMaxHeight() {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new c0(new Object[]{this, r.a.c.c.e.v(ajc$tjp_27, this, this)}).e(69648)));
    }

    public LayerConfDelegate getLayerConfDelegate() {
        return this.mLayerConfDelegate;
    }

    @WithTryCatchRuntime
    public int getUpShrinkage() {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.v(new Object[]{this, r.a.c.c.e.v(ajc$tjp_20, this, this)}).e(69648)));
    }

    public boolean isAtHome() {
        String str = this.TAG;
        Log.d(str, "isAtHome: mCurrentTabIndex=" + this.mCurrentTabIndex + ",mHomeIndex=" + this.mHomeIndex);
        return this.mCurrentTabIndex == this.mHomeIndex;
    }

    public boolean isSelectedSingleGray() {
        j.l.c.c.d.e visibleIndex = getVisibleIndex();
        if (visibleIndex instanceof j.l.c.c.d.e) {
            return visibleIndex.n0();
        }
        return false;
    }

    public boolean isTrulyVisible() {
        return this.isFragmentVisible;
    }

    @WithTryCatchRuntime
    public void loadNetData(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f0(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(ajc$tjp_2, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public int obtainLayoutResourceId() {
        return b.m.fragment_selected;
    }

    @Override // com.hunantv.imgo.base.RootFragment
    @WithTryCatchRuntime
    public void onCreate(Bundle bundle) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j(new Object[]{this, bundle, r.a.c.c.e.w(ajc$tjp_0, this, this, bundle)}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onDestroy() {
        super.onDestroy();
        j.l.a.m.b.g.b(j.l.c.c.d.c.class).e(this.mObserver);
        m mVar = this.mTaskManager;
        if (mVar != null) {
            mVar.s((j.v.r.l) null);
        }
        this.mTaskStarter = null;
    }

    public void onDissmiss() {
        j.l.c.c.d.c cVar = new j.l.c.c.d.c();
        ((j.l.a.m.b.b) cVar).b = "vip_pop_show";
        j.l.a.m.b.g.b(j.l.c.c.d.c.class).a(cVar);
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onGrayModeChange() {
        checkSelectedSingleGray();
        super.onGrayModeChange();
    }

    @Override // com.hunantv.imgo.base.RootFragment
    @WithTryCatchRuntime
    public void onHandleMessage(Message message) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new u(new Object[]{this, message, r.a.c.c.e.w(ajc$tjp_1, this, this, message)}).e(69648));
    }

    @WithTryCatchRuntime
    public void onHeaderAlpha(float f) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.z(new Object[]{this, r.a.c.b.e.i(f), r.a.c.c.e.w(ajc$tjp_24, this, this, r.a.c.b.e.i(f))}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onInitializeData(@Nullable Bundle bundle) {
        super.onInitializeData(bundle);
        initTaskStarter();
        this.mPresenter = new SelectedPresenter(getActivity(), this.mTaskStarter, this);
        loadCacheData();
        loadNetData(false);
        LayerConfDelegate layerConfDelegate = new LayerConfDelegate(this);
        this.mLayerConfDelegate = layerConfDelegate;
        layerConfDelegate.g(this);
        j.l.a.m.b.g.b(j.l.c.c.d.c.class).h(this, this.mObserver);
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onInitializeUI(View view, @Nullable Bundle bundle) {
        super.onInitializeUI(view, bundle);
        HugeMananger.h().z(true);
        ((ViewGroup) view.findViewById(b.j.rl_selected_top)).setOnClickListener(j.l.c.c.f.c.a);
        ((ImageView) view.findViewById(b.j.iv_channel_top_logo)).setImageResource(b.h.ic_channel_mango_tv_logo);
        View findViewById = view.findViewById(b.j.view_selected_status_bar);
        this.mStatusBarPlaceholder = findViewById;
        findViewById.getLayoutParams().height = HEIGHT_STATUS_BAR;
        this.mHeadFrame = (LinearLayout) view.findViewById(b.j.ll_selected_head_frame);
        this.stlChannel = view.findViewById(b.j.stl_selected_channel);
        this.vpPager = view.findViewById(b.j.vp_selected_channel);
        this.mEmptyLayout = (ChannelEmptyLayout) view.findViewById(b.j.emptyLayoutSelected);
        this.mDragLayoutDelegate = new DragLayoutDelegate(getContext(), (ChannelDragLayout) view.findViewById(b.j.layoutDragEnter), this);
        ((ImageView) view.findViewById(b.j.iv_channel_top_scan)).setOnClickListener(new j.l.c.c.f.b(this));
        new j.l.c.c.f.z0.b().a(view.findViewById(b.j.channel_vip_enter));
    }

    @WithTryCatchRuntime
    public boolean onKeyDown() {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new x(new Object[]{this, r.a.c.c.e.v(ajc$tjp_22, this, this)}).e(69648)));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onNightModeChange(SkinModel skinModel) {
        super.onNightModeChange(skinModel);
        this.mMuteHeadDrawable = null;
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onVisibleChanged(boolean z) {
        super.onVisibleChanged(z);
        if (z) {
            reportChannelPagePV();
        }
    }

    @WithTryCatchRuntime
    public boolean refreshHeadFrame() {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new s(new Object[]{this, r.a.c.c.e.v(ajc$tjp_18, this, this)}).e(69648)));
    }

    @WithTryCatchRuntime
    public void reportChannelPagePV() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d0(new Object[]{this, r.a.c.c.e.v(ajc$tjp_28, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void resetSpecailBanner() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b0(new Object[]{this, r.a.c.c.e.v(ajc$tjp_26, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void setViewPageTouchAllowed(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a0(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(ajc$tjp_25, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    @WithTryCatchRuntime
    public void switchToChannel(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h(new Object[]{this, str, r.a.c.c.e.w(ajc$tjp_8, this, this, str)}).e(69648));
    }

    @WithTryCatchRuntime
    public void updateChannelList(@Nullable ChannelListEntity channelListEntity, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h0(new Object[]{this, channelListEntity, r.a.c.b.e.a(z), r.a.c.c.e.x(ajc$tjp_3, this, this, channelListEntity, r.a.c.b.e.a(z))}).e(69648));
    }

    public void updateMainUI() {
        updateMainUI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void reportChannelPagePV(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new e0(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(ajc$tjp_29, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    @WithTryCatchRuntime
    public void updateMainUI(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.m(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(ajc$tjp_12, this, this, r.a.c.b.e.a(z))}).e(69648));
    }
}
