package com.hunantv.oversea.me.ui.setting;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.imgo.widget.CustomizeTitleBar;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.me.adapter.MePushSettingAdapter;
import com.hunantv.oversea.me.ui.MeBaseActivity;
import com.hunantv.oversea.report.MGDCManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.w.a;
import j.l.b.e.e.m;
import j.l.c.k.c;
import j.l.c.k.e.l;
import j.l.c.k.l.g.w;
import j.l.c.k.l.g.x;
import j.l.c.k.l.g.y;
import j.l.c.k.m.j;
import j.l.c.k.o.p;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PushSettingActivity extends MeBaseActivity implements a.b {
    private static final /* synthetic */ c.b h = null;
    private CustomizeTitleBar a;
    private RecyclerView b;
    private LinearLayoutManagerWrapper c;
    private MePushSettingAdapter d;
    private p e;
    private y f;
    private m g;

    static {
        ajc$preClinit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0(View view, byte b) {
        if (1 == b) {
            onBackPressed();
        }
    }

    public static final /* synthetic */ void D0(PushSettingActivity pushSettingActivity, View view, int i, c cVar) {
        l lVar = (l) pushSettingActivity.d.getItem(i);
        if (lVar == null) {
            return;
        }
        byte a = lVar.a();
        if (a != 10) {
            if (a != 20) {
                if (a == 21) {
                    pushSettingActivity.f.h(c.j.me_fl_interactive_setting);
                } else if (a != 30 && a != 31 && a != 40) {
                    if (a == 41) {
                        pushSettingActivity.f.g(lVar, pushSettingActivity.e.r(), new y.c() { // from class: com.hunantv.oversea.me.ui.setting.PushSettingActivity.1
                            private static final /* synthetic */ c.b b = null;

                            static {
                                a();
                            }

                            private static /* synthetic */ void a() {
                                e eVar = new e("PushSettingActivity.java", AnonymousClass1.class);
                                b = eVar.H("method-execution", eVar.E("1", "onOptionsPicked", "com.hunantv.oversea.me.ui.setting.PushSettingActivity$1", "java.lang.String:java.lang.String", "untimefrom:untimeto", "", "void"), 128);
                            }

                            public static final /* synthetic */ void b(AnonymousClass1 anonymousClass1, String str, String str2, r.a.b.c cVar2) {
                                PushSettingActivity.this.e.u(str, str2);
                                PushSettingActivity pushSettingActivity2 = PushSettingActivity.this;
                                pushSettingActivity2.F0(str + "-" + str2);
                            }

                            @WithTryCatchRuntime
                            public void onOptionsPicked(String str, String str2) {
                                LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new w(new Object[]{this, str, str2, e.x(b, this, this, str, str2)}).e(69648));
                            }
                        });
                    }
                }
            }
            pushSettingActivity.e.w(lVar);
        } else {
            pushSettingActivity.f.d(j.c());
        }
        pushSettingActivity.E0(lVar);
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("PushSettingActivity.java", PushSettingActivity.class);
        h = eVar.H("method-execution", eVar.E("1", "onItemClick", "com.hunantv.oversea.me.ui.setting.PushSettingActivity", "android.view.View:int", "view:position", "", "void"), 105);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void A0(List list) {
        this.d.setList(list);
        this.d.notifyDataSetChanged();
    }

    public void E0(l lVar) {
        String str;
        String str2;
        if (lVar == null) {
            return;
        }
        byte a = lVar.a();
        String str3 = "";
        if (a != 10) {
            if (a == 20) {
                StringBuilder sb = new StringBuilder();
                sb.append("status=");
                sb.append(lVar.e() ? "0" : "1");
                str3 = sb.toString();
                str = "5";
            } else if (a == 21) {
                str = "6";
            } else if (a == 30) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("status=");
                sb2.append(lVar.e() ? "0" : "1");
                str3 = sb2.toString();
                str = "7";
            } else if (a == 31) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("status=");
                sb3.append(lVar.e() ? "0" : "1");
                str3 = sb3.toString();
                str = "8";
            } else if (a == 40) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("status=");
                sb4.append(lVar.e() ? "0" : "1");
                str3 = sb4.toString();
                str = "9";
            } else if (a != 41) {
                switch (a) {
                    case 51:
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("status=");
                        sb5.append(lVar.e() ? "0" : "1");
                        str3 = sb5.toString();
                        str = "12";
                        break;
                    case 52:
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("status=");
                        sb6.append(lVar.e() ? "0" : "1");
                        str3 = sb6.toString();
                        str = "13";
                        break;
                    case 53:
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("status=");
                        sb7.append(lVar.e() ? "0" : "1");
                        str3 = sb7.toString();
                        str = "14";
                        break;
                    default:
                        str2 = "";
                        break;
                }
                this.g.g(new EventClickData(EventClickData.a.O, str3, str2));
            } else {
                str = "10";
            }
        } else {
            str3 = "type=" + j.l.a.b0.e.r0();
            str = "2";
        }
        String str4 = str3;
        str3 = str;
        str2 = str4;
        this.g.g(new EventClickData(EventClickData.a.O, str3, str2));
    }

    public void F0(String str) {
        this.g.g(new EventClickData(EventClickData.a.O, "11", "stime=" + str));
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public int obtainLayoutResourceId() {
        return c.m.me_activity_push_setting;
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeData(@Nullable Bundle bundle) {
        super.onInitializeData(bundle);
        p pVar = new ViewModelProvider(this).get(p.class);
        this.e = pVar;
        pVar.t();
        this.e.q().observe(this, new j.l.c.k.l.g.l(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.base.RootActivity
    public void onInitializeUI(@Nullable Bundle bundle) {
        super.onInitializeUI(bundle);
        CustomizeTitleBar customizeTitleBar = (CustomizeTitleBar) findViewById(c.j.titleBar);
        this.a = customizeTitleBar;
        customizeTitleBar.setOnComponentClickListener(new j.l.c.k.l.g.m(this));
        this.a.setBackgroundResource(c.h.me_bg_title_bar);
        RecyclerView findViewById = findViewById(c.j.recyclerView);
        this.b = findViewById;
        if (findViewById.getItemAnimator() instanceof DefaultItemAnimator) {
            this.b.getItemAnimator().setSupportsChangeAnimations(false);
        }
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(this);
        this.c = linearLayoutManagerWrapper;
        linearLayoutManagerWrapper.setOrientation(1);
        this.b.setLayoutManager(this.c);
        MePushSettingAdapter mePushSettingAdapter = new MePushSettingAdapter(this);
        this.d = mePushSettingAdapter;
        mePushSettingAdapter.x(this);
        this.b.setAdapter(this.d);
        this.f = new y(this);
        this.g = m.c(j.c());
    }

    @WithTryCatchRuntime
    public void onItemClick(View view, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new x(new Object[]{this, view, r.a.c.b.e.k(i), e.x(h, this, this, view, r.a.c.b.e.k(i))}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootActivity
    public void onResume() {
        MGDCManager.n().enterScene("message_setting", this);
        super.onResume();
        p pVar = this.e;
        if (pVar != null) {
            pVar.o();
        }
        MGDCManager.n().onEvent("page");
    }
}
