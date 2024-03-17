package com.hunantv.oversea.me.ui.setting;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.hunantv.imgo.nightmode.view.SkinnableRelativeLayout;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.oversea.me.adapter.MeSettingAdapter;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.j;
import j.l.c.k.c;
import j.l.c.k.e.h;
import j.l.c.k.l.g.i;
import j.l.c.k.l.g.v;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

@SuppressLint({"ViewConstructor"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeSettingPage extends SkinnableRelativeLayout {
    private static final /* synthetic */ c.b h = null;
    private CustomizeTitleBar a;
    private RecyclerView b;
    private LinearLayoutManagerWrapper c;
    private MeSettingAdapter d;
    private FrameLayout e;
    private boolean f;
    private boolean g;

    static {
        n0();
    }

    public MeSettingPage(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        r0(appCompatActivity);
    }

    private static /* synthetic */ void n0() {
        e eVar = new e("MeSettingPage.java", MeSettingPage.class);
        h = eVar.H("method-execution", eVar.E("1", "refreshSettingItems", "com.hunantv.oversea.me.ui.setting.MeSettingPage", "java.util.List", "settingItems", "", "void"), 84);
    }

    private void q0(List<h> list) {
        if (j.a(list)) {
            return;
        }
        int indexOf = this.f ? list.indexOf(this.d.B((byte) 21)) : -1;
        int indexOf2 = this.g ? list.indexOf(this.d.B((byte) 51)) : -1;
        if (indexOf > 0) {
            this.b.scrollToPosition(indexOf);
        } else if (indexOf2 <= 0) {
            return;
        } else {
            this.b.scrollToPosition(indexOf2);
        }
        this.b.post(new j.l.c.k.l.g.h(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r0(AppCompatActivity appCompatActivity) {
        setBackgroundResource(c.f.me_skin_color_page_bg);
        LayoutInflater.from(appCompatActivity).inflate(c.m.me_activity_setting, (ViewGroup) this);
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(c.j.titleBar);
        this.a = customizeTitleBar;
        customizeTitleBar.setOnComponentClickListener(new i(appCompatActivity));
        this.a.setBackgroundResource(c.h.me_bg_title_bar);
        RecyclerView findViewById = findViewById(c.j.recyclerView);
        this.b = findViewById;
        if (findViewById.getItemAnimator() instanceof DefaultItemAnimator) {
            this.b.getItemAnimator().setSupportsChangeAnimations(false);
        }
        this.e = (FrameLayout) findViewById(c.j.loadingFrame);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(appCompatActivity);
        this.c = linearLayoutManagerWrapper;
        linearLayoutManagerWrapper.setOrientation(1);
        this.b.setLayoutManager(this.c);
        MeSettingAdapter meSettingAdapter = new MeSettingAdapter(appCompatActivity);
        this.d = meSettingAdapter;
        this.b.setAdapter(meSettingAdapter);
        if (appCompatActivity.getIntent() != null) {
            this.f = appCompatActivity.getIntent().getBooleanExtra("extra_highlight_traffic_download", false);
            this.g = appCompatActivity.getIntent().getBooleanExtra("extra_highlight_playrecord_sync", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void u0() {
        MeSettingAdapter meSettingAdapter;
        if (this.b == null || (meSettingAdapter = this.d) == null) {
            return;
        }
        if (this.f) {
            meSettingAdapter.S();
        }
        if (this.g) {
            this.d.R();
        }
        this.d.notifyDataSetChanged();
        this.f = false;
        this.g = false;
    }

    public static /* synthetic */ void v0(AppCompatActivity appCompatActivity, View view, byte b) {
        if (1 == b) {
            appCompatActivity.onBackPressed();
        }
    }

    public static final /* synthetic */ void x0(MeSettingPage meSettingPage, List list, r.a.b.c cVar) {
        MeSettingAdapter meSettingAdapter = meSettingPage.d;
        if (meSettingAdapter != null) {
            meSettingAdapter.setList(list);
            meSettingPage.d.notifyDataSetChanged();
            if (meSettingPage.f || meSettingPage.g) {
                meSettingPage.q0(list);
            }
        }
    }

    public void o0() {
        j.l.c.k.m.j.g(this.e, 8);
    }

    @WithTryCatchRuntime
    public void refreshSettingItems(List<h> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new v(new Object[]{this, list, e.w(h, this, this, list)}).e(69648));
    }

    public void setOnSettingItemClickListener(MeSettingAdapter.b bVar) {
        MeSettingAdapter meSettingAdapter = this.d;
        if (meSettingAdapter != null) {
            meSettingAdapter.Q(bVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
        if (r1 != 42) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void w0(j.l.c.k.e.i r4) {
        /*
            r3 = this;
            com.hunantv.oversea.me.adapter.MeSettingAdapter r0 = r3.d
            if (r0 != 0) goto L5
            return
        L5:
            byte r1 = r4.a
            j.l.c.k.e.h r0 = r0.B(r1)
            if (r0 != 0) goto Le
            return
        Le:
            byte r1 = r0.a()
            r2 = 12
            if (r1 == r2) goto L4a
            r2 = 51
            if (r1 == r2) goto L44
            r2 = 61
            if (r1 == r2) goto L4a
            r2 = 63
            if (r1 == r2) goto L37
            r2 = 81
            if (r1 == r2) goto L37
            r2 = 22
            if (r1 == r2) goto L4a
            r2 = 23
            if (r1 == r2) goto L4a
            r2 = 41
            if (r1 == r2) goto L44
            r2 = 42
            if (r1 == r2) goto L44
            goto L4f
        L37:
            boolean r1 = r0.e()
            boolean r4 = r4.d
            if (r1 != r4) goto L40
            return
        L40:
            r0.h(r4)
            goto L4f
        L44:
            boolean r4 = r4.c
            r0.k(r4)
            goto L4f
        L4a:
            java.lang.String r4 = r4.b
            r0.i(r4)
        L4f:
            com.hunantv.oversea.me.adapter.MeSettingAdapter r4 = r3.d
            r4.t(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.oversea.me.ui.setting.MeSettingPage.w0(j.l.c.k.e.i):void");
    }

    public void y0() {
        j.l.c.k.m.j.g(this.e, 0);
    }
}
