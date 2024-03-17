package com.hunantv.oversea.me.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.me.adapter.MainMeAdapter;
import com.hunantv.oversea.me.view.main.MainHeadTitleView;
import com.hunantv.oversea.me.view.main.UserHeadCardView;
import com.hunantv.oversea.me.viewmodels.MainMeViewModel;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.e;
import j.l.c.k.c;
import j.l.c.k.h.a;
import j.l.c.k.l.c.g;
import j.l.c.k.n.d.h;
import j.l.c.k.n.d.i;
import r.a.b.c;

@SuppressLint({"ViewConstructor"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MainMePage extends SkinnableFrameLayout implements i.a {
    public static final String g = "MainMeLogTag";
    private static final /* synthetic */ c.b h = null;
    private MainHeadTitleView a;
    private RecyclerView b;
    private LinearLayoutManagerWrapper c;
    private i d;
    private LifecycleOwner e;
    private MainMeAdapter f;

    static {
        b0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MainMePage(Context context, @NonNull LifecycleOwner lifecycleOwner) {
        super(context);
        this.e = lifecycleOwner;
        setBackgroundResource(c.f.me_skin_color_page_bg);
        this.b = new RecyclerView(context);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(context, 1, false);
        this.c = linearLayoutManagerWrapper;
        this.b.setLayoutManager(linearLayoutManagerWrapper);
        this.b.setOverScrollMode(2);
        RecyclerView recyclerView = this.b;
        i iVar = new i(this);
        this.d = iVar;
        recyclerView.addOnScrollListener(iVar);
        MainHeadTitleView mainHeadTitleView = new MainHeadTitleView(context);
        this.a = mainHeadTitleView;
        mainHeadTitleView.setTitle(a.g() ? e.T() : j.l.a.a.a().getString(c.r.me_title));
        addView(this.b, new FrameLayout.LayoutParams(-1, -1));
        addView(this.a, new FrameLayout.LayoutParams(-1, -2));
    }

    private static /* synthetic */ void b0() {
        r.a.c.c.e eVar = new r.a.c.c.e("MainMePage.java", MainMePage.class);
        h = eVar.H("method-execution", eVar.E("1", "setUnReadMsg", "com.hunantv.oversea.me.ui.main.MainMePage", "int", "unReadMsg", "", "void"), 116);
    }

    public static final /* synthetic */ void c0(MainMePage mainMePage, int i, r.a.b.c cVar) {
        if (i > 0) {
            mainMePage.a.w0();
        } else {
            mainMePage.a.n0();
        }
    }

    public void G(float f) {
        this.a.setAlpha(f);
    }

    public /* synthetic */ void i(boolean z) {
        h.a(this, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setData(MainMeViewModel.c cVar) {
        if (cVar == null || cVar.a == null) {
            return;
        }
        if (this.f == null) {
            MainMeAdapter mainMeAdapter = new MainMeAdapter(getContext(), this.e);
            this.f = mainMeAdapter;
            this.b.setAdapter(mainMeAdapter);
        }
        this.f.update(cVar.a);
    }

    public void setOnTitleClickListener(MainHeadTitleView.a aVar) {
        MainHeadTitleView mainHeadTitleView = this.a;
        if (mainHeadTitleView != null) {
            mainHeadTitleView.setOnTitleClickListener(aVar);
        }
    }

    @WithTryCatchRuntime
    public void setUnReadMsg(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(h, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    public void setUserInfo(@Nullable UserInfo userInfo) {
        if (!a.g()) {
            this.b.scrollToPosition(0);
            this.a.setAlpha(0.0f);
        }
        this.a.setTitle((!a.g() || userInfo == null) ? j.l.a.a.a().getString(c.r.me_title) : userInfo.nickname);
        MainMeAdapter mainMeAdapter = this.f;
        if (mainMeAdapter == null || mainMeAdapter.j() == -1) {
            return;
        }
        MainMeAdapter mainMeAdapter2 = this.f;
        mainMeAdapter2.notifyItemChanged(mainMeAdapter2.j(), new UserHeadCardView.a(a.g(), userInfo));
    }
}
