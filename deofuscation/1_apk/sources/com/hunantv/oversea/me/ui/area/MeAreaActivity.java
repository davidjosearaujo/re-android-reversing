package com.hunantv.oversea.me.ui.area;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.imgo.widget.CommonLoadingFrame;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.business.manager.area.AreaInfo;
import com.hunantv.oversea.me.ui.MeBaseActivity;
import com.hunantv.oversea.report.MGDCManager;
import com.mgtv.widget.recyclerview.MGRecyclerView;
import j.l.c.a.f.a.b;
import j.l.c.k.c;
import j.l.c.k.d.p;
import j.l.c.k.e.d;
import j.l.c.k.e.e;
import j.l.c.k.g.m;
import j.l.c.k.l.b.a;
import j.l.c.k.m.j;
import j.l.c.k.o.m;

@Route(path = "/mgtv/MeAreaActivity")
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeAreaActivity extends MeBaseActivity {
    public static final String e = "lang";
    private CommonLoadingFrame a;
    private p b;
    private m c;
    private j.l.b.e.e.m d;

    /* renamed from: A0 */
    public /* synthetic */ void m6B0(View view, int i) {
        e eVar = (d) this.b.getItem(i);
        if (eVar instanceof e) {
            AreaInfo l = b.n().l();
            StringBuilder sb = new StringBuilder();
            sb.append("reflang=");
            sb.append(l != null ? Integer.valueOf(l.areaCode) : "");
            sb.append("&lang=");
            e eVar2 = eVar;
            sb.append(eVar2.b());
            this.d.g(new EventClickData("lang", "1", sb.toString()));
            this.c.i(eVar2);
        }
    }

    /* renamed from: C0 */
    public /* synthetic */ void m7D0(m.a aVar) {
        this.b.setList(aVar.a);
        this.b.notifyDataSetChanged();
    }

    /* renamed from: E0 */
    public /* synthetic */ void m8F0(Integer num) {
        if (num.intValue() == 1) {
            j.g(this.a, 0);
        } else if (num.intValue() == 0) {
            j.g(this.a, 8);
        } else if (num.intValue() == 4) {
            finish();
        }
    }

    /* renamed from: y0 */
    public /* synthetic */ void m9z0(View view, byte b) {
        if (1 == b) {
            finish();
        }
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        return c.m.me_activity_area;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        super.onInitializeUI(bundle);
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(c.j.titleBar);
        customizeTitleBar.setBackgroundResource(c.h.me_bg_title_bar);
        customizeTitleBar.setOnComponentClickListener(new a(this));
        MGRecyclerView findViewById = findViewById(c.j.recyclerView);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(this);
        linearLayoutManagerWrapper.setOrientation(1);
        findViewById.setLayoutManager(linearLayoutManagerWrapper);
        p pVar = new p(this);
        this.b = pVar;
        findViewById.setAdapter(pVar);
        this.b.x(new j.l.c.k.l.b.d(this));
        this.a = (CommonLoadingFrame) findViewById(c.j.loadingFrame);
        j.l.c.k.o.m mVar = new ViewModelProvider(this).get(j.l.c.k.o.m.class);
        this.c = mVar;
        mVar.j().observe(this, new j.l.c.k.l.b.b(this));
        this.c.c().observe(this, new j.l.c.k.l.b.c(this));
        this.d = j.l.b.e.e.m.c(j.c());
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        super.onResume();
        j.l.c.k.f.d.b();
        MGDCManager.n().enterScene("language_switch", this);
        MGDCManager.n().onEvent("page");
    }
}
