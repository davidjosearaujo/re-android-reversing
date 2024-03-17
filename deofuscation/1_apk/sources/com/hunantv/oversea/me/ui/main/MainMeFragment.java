package com.hunantv.oversea.me.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.hunantv.imgo.base.RootFragment;
import com.hunantv.imgo.nightmode.SkinModel;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.me.view.main.MainHeadTitleView;
import com.hunantv.oversea.me.viewmodels.MainMeViewModel;
import com.hunantv.oversea.report.MGDCManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.v;
import j.l.c.a.f.a.b;
import j.l.c.k.c;
import j.l.c.k.h.a;
import j.l.c.k.l.c.f;
import j.l.d.d;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MainMeFragment extends RootFragment implements MainHeadTitleView.a {
    private static final String c = "MainMeFragment";
    private static final /* synthetic */ c.b d = null;
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private MainMePage a;
    private MainMeViewModel b;

    static {
        ajc$preClinit();
    }

    public static final /* synthetic */ void A0(MainMeFragment mainMeFragment, View view, c cVar) {
        if (!a.g()) {
            a.h(mainMeFragment.getActivity(), 5);
            return;
        }
        new d.c().a("/mgtv/MeMessageCenterActivity").g().g(mainMeFragment.getContext());
        j.l.c.k.f.a.f(mainMeFragment.b.m() > 0 ? "1" : "2");
        mainMeFragment.b.j();
    }

    public static final /* synthetic */ void B0(MainMeFragment mainMeFragment, View view, c cVar) {
        new d.c().a("/mgtv/MeLoginCaptureActivity").g().g(mainMeFragment.getContext());
        j.l.c.k.f.a.j();
    }

    public static final /* synthetic */ void C0(MainMeFragment mainMeFragment, boolean z, c cVar) {
        super.onVisibleChanged(z);
        v.g(c, "onVisibleChanged : " + z);
        if (z) {
            a.k();
            mainMeFragment.b.q();
            mainMeFragment.a.setUnReadMsg(mainMeFragment.b.m());
        }
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("MainMeFragment.java", MainMeFragment.class);
        d = eVar.H("method-execution", eVar.E("1", "onVisibleChanged", "com.hunantv.oversea.me.ui.main.MainMeFragment", "boolean", "visible", "", "void"), 114);
        e = eVar.H("method-execution", eVar.E("1", "onScanClick", "com.hunantv.oversea.me.ui.main.MainMeFragment", "android.view.View", ViewHierarchyConstants.VIEW_KEY, "", "void"), (int) EventClickData.u.t1);
        f = eVar.H("method-execution", eVar.E("1", "onMessageClick", "com.hunantv.oversea.me.ui.main.MainMeFragment", "android.view.View", ViewHierarchyConstants.VIEW_KEY, "", "void"), (int) EventClickData.u.Q0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(MainMeViewModel.c cVar) {
        this.a.setData(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(UserInfo userInfo) {
        this.a.setUserInfo(userInfo);
        if (!getRealVisible() || a.g()) {
            return;
        }
        this.b.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(Integer num) {
        this.a.setUnReadMsg(num.intValue());
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public int obtainLayoutResourceId() {
        return c.m.me_frag_main;
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b.n().F((j.l.c.a.f.a.c) null);
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        j.l.c.k.f.d.c();
        MGDCManager.n().enterScene("personal_home", this);
        MGDCManager.n().onEvent("page");
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onInitializeData(@Nullable Bundle bundle) {
        super.onInitializeData(bundle);
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onInitializeUI(View view, @Nullable Bundle bundle) {
        super.onInitializeUI(view, bundle);
        MainMePage mainMePage = new MainMePage(getActivity() == null ? view.getContext() : getActivity(), this);
        this.a = mainMePage;
        mainMePage.setOnTitleClickListener(this);
        ((FrameLayout) view.findViewById(c.j.me_fl_main)).addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
        MainMeViewModel mainMeViewModel = new ViewModelProvider(this).get(MainMeViewModel.class);
        this.b = mainMeViewModel;
        mainMeViewModel.l().observe(this, new j.l.c.k.l.c.a(this));
        this.b.o().observe(this, new j.l.c.k.l.c.b(this));
        this.b.n().observe(this, new j.l.c.k.l.c.c(this));
    }

    @Override // com.hunantv.oversea.me.view.main.MainHeadTitleView.a
    @WithTryCatchRuntime
    public void onMessageClick(View view) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, view, e.w(f, this, this, view)}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onNightModeChange(SkinModel skinModel) {
        super.onNightModeChange(skinModel);
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onResume() {
        super.onResume();
        if (getRealVisible()) {
            j.l.c.k.f.d.c();
            MGDCManager.n().enterScene("personal_home", this);
            MGDCManager.n().onEvent("page");
        }
    }

    @Override // com.hunantv.oversea.me.view.main.MainHeadTitleView.a
    @WithTryCatchRuntime
    public void onScanClick(View view) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.l.c.e(new Object[]{this, view, e.w(e, this, this, view)}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    @WithTryCatchRuntime
    public void onVisibleChanged(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.l.c.d(new Object[]{this, r.a.c.b.e.a(z), e.w(d, this, this, r.a.c.b.e.a(z))}).e(69648));
    }
}
