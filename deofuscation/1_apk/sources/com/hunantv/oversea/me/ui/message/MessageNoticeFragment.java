package com.hunantv.oversea.me.ui.message;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hunantv.imgo.base.RootFragment;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.me.data.MessageGetListNoticeEntity;
import com.hunantv.oversea.me.widget.MeCommonEmptyLayout;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.widget.MGRefreshLayout;
import com.mgtv.widget.recyclerview.MGRecyclerView;
import j.l.a.b0.n0;
import j.l.a.b0.p0;
import j.l.a.k.e;
import j.l.a.w.a;
import j.l.b.e.s.b;
import j.l.c.k.c;
import j.l.c.k.d.v;
import j.l.c.k.f.h;
import j.l.c.k.l.d.f;
import j.l.c.k.l.d.g;
import j.l.c.k.l.d.h;
import j.l.c.k.l.d.i;
import j.l.c.k.o.r;
import j.l.c.k.o.t;
import j.l.c.z.c.d;
import j.y.a.a.c.j;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MessageNoticeFragment extends RootFragment implements a.b {
    private static final String f = "VM";
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private r a;
    public MGRecyclerView b;
    private v c;
    private MGRefreshLayout d;
    private MeCommonEmptyLayout e;

    static {
        ajc$preClinit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void B0(View view) {
        this.d.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0 */
    public /* synthetic */ void D0(j jVar) {
        this.a.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public /* synthetic */ void F0(j jVar) {
        this.a.n();
    }

    public static final /* synthetic */ void G0(MessageNoticeFragment messageNoticeFragment, View view, int i2, c cVar) {
        MessageGetListNoticeEntity.DataEntity.MessageEntity messageEntity = (MessageGetListNoticeEntity.DataEntity.MessageEntity) messageNoticeFragment.c.getItem(i2);
        if (messageEntity == null) {
            return;
        }
        int i3 = messageEntity.linkType;
        if (i3 == 1) {
            messageNoticeFragment.w0(messageEntity.link);
        } else if (i3 == 2) {
            messageNoticeFragment.v0(messageEntity.link);
        } else if (i3 == 3) {
            messageNoticeFragment.u0(messageEntity.link);
        } else if (i3 != 4) {
        } else {
            b c = b.c(messageNoticeFragment.getContext());
            b.n("81101");
            j.l.c.k.h.c.d(messageNoticeFragment.getActivity(), p0.e(c.e(j.v.o.a.d.e.a.g(), e.H, j.l.a.b0.e.v0(), j.l.a.b0.e.n(), f, "", "", "", "", "", "", "", "vip", "0", "", ""), "ftype", "11"));
        }
    }

    public static final /* synthetic */ void H0(MessageNoticeFragment messageNoticeFragment, MessageGetListNoticeEntity messageGetListNoticeEntity, c cVar) {
        messageNoticeFragment.c.i(messageGetListNoticeEntity.data.messageList);
        messageNoticeFragment.c.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(t tVar) {
        int i2 = tVar.a;
        if (i2 == 2) {
            this.d.o0();
        } else if (i2 == 6) {
            this.d.n0();
            this.d.L0(false);
        } else if (i2 == 5) {
            this.d.j0();
        }
        if (tVar.b == 1) {
            j.l.c.k.m.j.g(this.e, 0);
        } else {
            j.l.c.k.m.j.g(this.e, 8);
        }
    }

    public static final /* synthetic */ void J0(MessageNoticeFragment messageNoticeFragment, MessageGetListNoticeEntity messageGetListNoticeEntity, c cVar) {
        messageNoticeFragment.c.j(messageGetListNoticeEntity.data.messageList);
        messageNoticeFragment.c.notifyDataSetChanged();
    }

    private static /* synthetic */ void ajc$preClinit() {
        r.a.c.c.e eVar = new r.a.c.c.e("MessageNoticeFragment.java", MessageNoticeFragment.class);
        g = eVar.H("method-execution", eVar.E("2", "onLoadMoreResult", "com.hunantv.oversea.me.ui.message.MessageNoticeFragment", "com.hunantv.oversea.me.data.MessageGetListNoticeEntity", "messageGetListNoticeEntity", "", "void"), (int) EventClickData.u.m1);
        h = eVar.H("method-execution", eVar.E("2", "onRefreshResult", "com.hunantv.oversea.me.ui.message.MessageNoticeFragment", "com.hunantv.oversea.me.data.MessageGetListNoticeEntity", "messageGetListNoticeEntity", "", "void"), (int) EventClickData.u.K0);
        i = eVar.H("method-execution", eVar.E("1", "onItemClick", "com.hunantv.oversea.me.ui.message.MessageNoticeFragment", "android.view.View:int", "view:position", "", "void"), (int) EventClickData.u.u1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onLoadMoreResult(MessageGetListNoticeEntity messageGetListNoticeEntity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h(new Object[]{this, messageGetListNoticeEntity, r.a.c.c.e.w(g, this, this, messageGetListNoticeEntity)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onRefreshResult(MessageGetListNoticeEntity messageGetListNoticeEntity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, messageGetListNoticeEntity, r.a.c.c.e.w(h, this, this, messageGetListNoticeEntity)}).e(69648));
    }

    private void u0(String str) {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (n0.z(str)) {
            d.i(activity, str);
        } else {
            j.l.c.k.h.c.b(activity, str);
        }
    }

    private void v0(String str) {
        try {
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isFinishing()) {
                JSONObject parseObject = JSON.parseObject(str);
                d.i(activity, j.l.c.k.f.h.a(parseObject.containsKey("jid") ? parseObject.getString("jid") : "", parseObject.containsKey("tid") ? parseObject.getString("tid") : ""));
            }
        } catch (Exception unused) {
            j.l.a.b0.v.c(this.TAG, "gotoLive Exception");
        }
    }

    private void w0(String str) {
        try {
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isFinishing()) {
                JSONObject parseObject = JSON.parseObject(str);
                d.i(getActivity(), j.l.c.k.f.h.d(new h.a().i(parseObject.containsKey("vid") ? parseObject.getString("vid") : "").f(parseObject.containsKey("pid") ? parseObject.getString("pid") : "").b(parseObject.containsKey("cid") ? parseObject.getString("cid") : "").c("-1")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public int obtainLayoutResourceId() {
        return c.m.me_frag_message_notice;
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onInitializeUI(View view, @Nullable Bundle bundle) {
        super.onInitializeUI(view, bundle);
        this.d = view.findViewById(c.j.refreshLayout);
        this.b = view.findViewById(c.j.recyclerView);
        MeCommonEmptyLayout meCommonEmptyLayout = (MeCommonEmptyLayout) view.findViewById(c.j.emptyLayout);
        this.e = meCommonEmptyLayout;
        meCommonEmptyLayout.setText(c.r.message_center_empty_notice);
        this.e.setIcon(c.h.me_icon_empty_view);
        this.e.setContentOnClickListener(new g(this));
        this.d.Q0(true);
        this.d.L0(true);
        this.d.e1(new j.l.c.k.l.d.e(this));
        this.d.c1(new f(this));
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getContext());
        linearLayoutManagerWrapper.setOrientation(1);
        this.b.setLayoutManager(linearLayoutManagerWrapper);
        v vVar = new v(getActivity());
        this.c = vVar;
        vVar.x(this);
        this.b.setAdapter(this.c);
        r rVar = new ViewModelProvider(this).get(r.class);
        this.a = rVar;
        rVar.l().observe(this, new j.l.c.k.l.d.d(this));
        this.a.j().observe(this, new j.l.c.k.l.d.b(this));
        this.a.k().observe(this, new j.l.c.k.l.d.c(this));
        this.d.Q();
    }

    @WithTryCatchRuntime
    public void onItemClick(View view, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.l.d.j(new Object[]{this, view, r.a.c.b.e.k(i2), r.a.c.c.e.x(i, this, this, view, r.a.c.b.e.k(i2))}).e(69648));
    }

    @Override // com.hunantv.imgo.base.RootFragment
    public void onResume() {
        super.onResume();
        j.l.c.k.f.d.g();
    }
}
