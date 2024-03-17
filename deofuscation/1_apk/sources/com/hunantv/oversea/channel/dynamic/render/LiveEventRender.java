package com.hunantv.oversea.channel.dynamic.render;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonObject;
import com.hunantv.imgo.net.ImgoHttpCallBack;
import com.hunantv.imgo.net.ImgoHttpParams;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.oversea.channel.dynamic.render.entity.DynamicLiveEventEntity;
import com.hunantv.oversea.channel.dynamic.render.entity.QuerySubscribeEntity;
import com.hunantv.oversea.login.compat.LoginEntry;
import com.hunantv.oversea.session.global.SessionManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.json.JsonVoid;
import j.l.a.b0.f0;
import j.l.a.b0.l;
import j.l.a.b0.o0;
import j.l.b.e.e.m;
import j.l.c.c.b;
import j.l.c.c.c.u1.e;
import j.l.c.c.c.u1.n;
import j.l.c.c.c.u1.o;
import j.l.c.c.c.u1.p;
import j.l.c.c.c.u1.q;
import j.l.c.c.c.u1.s;
import j.v.r.r;
import java.util.Iterator;
import java.util.List;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LiveEventRender extends e {
    private static final String k = "5";
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private static final /* synthetic */ c.b p = null;
    private RecyclerView d;
    private j.v.u.a<DynamicLiveEventEntity.Data> e;
    private r f;
    private Context g;
    private JsonObject h;
    private List<DynamicLiveEventEntity.Data> i;
    private j.l.c.c.c.u1.w.b j;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class LiveEventAdapter extends j.v.u.a<DynamicLiveEventEntity.Data> {
        private static final String i = "yyyy-MM-dd HH:mm:ss";
        private static final String j = "MM/dd";
        private static final String k = "HH:mm";
        private static final /* synthetic */ c.b l = null;
        private static final /* synthetic */ c.b m = null;

        static {
            y();
        }

        public LiveEventAdapter(List<DynamicLiveEventEntity.Data> list, LayoutInflater layoutInflater) {
            super(list, layoutInflater);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: B */
        public /* synthetic */ void C(DynamicLiveEventEntity.Data data, j.l.a.c0.e eVar, boolean z, boolean z2) {
            if (!z) {
                if (z2) {
                    data.isSubscribed = false;
                    updateSubscribeView(eVar, data);
                }
            } else if (z2) {
                data.isSubscribed = true;
                updateSubscribeView(eVar, data);
                LiveEventRender.this.handleSubscribeSuccess();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: D */
        public /* synthetic */ void E(DynamicLiveEventEntity.Data data, j.l.a.c0.e eVar, View view) {
            boolean z = !data.isSubscribed;
            LiveEventRender liveEventRender = LiveEventRender.this;
            liveEventRender.requestAddRemoveSubscribe(liveEventRender.e(), z, data.activityId, new j.l.c.c.c.u1.c(this, data, eVar));
            m.c(j.l.a.a.a()).k(z ? "32" : "33", "activityid=" + data.activityId);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final /* synthetic */ void F(com.hunantv.oversea.channel.dynamic.render.LiveEventRender.LiveEventAdapter r3, j.l.a.c0.e r4, int r5, com.hunantv.oversea.channel.dynamic.render.entity.DynamicLiveEventEntity.Data r6, java.util.List r7, r.a.b.c r8) {
            /*
                if (r4 == 0) goto L7d
                if (r6 != 0) goto L6
                goto L7d
            L6:
                r5 = 0
                java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch: java.text.ParseException -> L3d
                java.lang.String r8 = "yyyy-MM-dd HH:mm:ss"
                java.util.Locale r0 = java.util.Locale.getDefault()     // Catch: java.text.ParseException -> L3d
                r7.<init>(r8, r0)     // Catch: java.text.ParseException -> L3d
                java.lang.String r8 = r6.date     // Catch: java.text.ParseException -> L3d
                java.util.Date r7 = r7.parse(r8)     // Catch: java.text.ParseException -> L3d
                if (r7 == 0) goto L3b
                java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat     // Catch: java.text.ParseException -> L3d
                java.lang.String r0 = "HH:mm"
                java.util.Locale r1 = java.util.Locale.getDefault()     // Catch: java.text.ParseException -> L3d
                r8.<init>(r0, r1)     // Catch: java.text.ParseException -> L3d
                java.lang.String r8 = r8.format(r7)     // Catch: java.text.ParseException -> L3d
                java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch: java.text.ParseException -> L39
                java.lang.String r1 = "MM/dd"
                java.util.Locale r2 = java.util.Locale.getDefault()     // Catch: java.text.ParseException -> L39
                r0.<init>(r1, r2)     // Catch: java.text.ParseException -> L39
                java.lang.String r5 = r0.format(r7)     // Catch: java.text.ParseException -> L39
                goto L42
            L39:
                r7 = move-exception
                goto L3f
            L3b:
                r7 = r5
                goto L44
            L3d:
                r7 = move-exception
                r8 = r5
            L3f:
                r7.printStackTrace()
            L42:
                r7 = r5
                r5 = r8
            L44:
                boolean r8 = android.text.TextUtils.isEmpty(r5)
                if (r8 == 0) goto L4c
                java.lang.String r5 = "00:00"
            L4c:
                boolean r8 = android.text.TextUtils.isEmpty(r7)
                if (r8 == 0) goto L54
                java.lang.String r7 = "01/01"
            L54:
                int r8 = j.l.c.c.b.j.tvLiveHallTime
                r4.l(r8, r5)
                int r5 = j.l.c.c.b.j.tvLiveHallDate
                r4.l(r5, r7)
                int r5 = j.l.c.c.b.j.tvLiveHallTitle
                java.lang.String r7 = r6.name
                r4.l(r5, r7)
                int r5 = j.l.c.c.b.j.tvLiveHallSubTitle
                java.lang.String r7 = r6.name
                r4.l(r5, r7)
                android.view.View r5 = r4.e()
                if (r5 == 0) goto L7a
                j.l.c.c.c.u1.b r7 = new j.l.c.c.c.u1.b
                r7.<init>(r3, r6)
                r5.setOnClickListener(r7)
            L7a:
                r3.updateSubscribeView(r4, r6)
            L7d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hunantv.oversea.channel.dynamic.render.LiveEventRender.LiveEventAdapter.F(com.hunantv.oversea.channel.dynamic.render.LiveEventRender$LiveEventAdapter, j.l.a.c0.e, int, com.hunantv.oversea.channel.dynamic.render.entity.DynamicLiveEventEntity$Data, java.util.List, r.a.b.c):void");
        }

        public static final /* synthetic */ void G(LiveEventAdapter liveEventAdapter, j.l.a.c0.e eVar, DynamicLiveEventEntity.Data data, r.a.b.c cVar) {
            boolean z = data.isSubscribed;
            LinearLayout linearLayout = (LinearLayout) eVar.b(b.j.llSubscribe);
            TextView textView = (TextView) eVar.b(b.j.tvSubscribe);
            if (z) {
                linearLayout.setBackgroundResource(b.h.bg_live_subscribe_selected);
                textView.setText(b.r.channel_item_timeline_ordered);
                textView.setTextColor(j.l.a.a.a().getResources().getColor(b.f.color_FFFFFF_50));
            } else {
                linearLayout.setBackgroundResource(b.h.bg_live_subscribe_selected);
                textView.setText(b.r.channel_item_timeline_order);
                textView.setTextColor(j.l.a.a.a().getResources().getColor(b.f.color_FF4500));
            }
            linearLayout.setOnClickListener(new j.l.c.c.c.u1.a(liveEventAdapter, data, eVar));
        }

        @WithTryCatchRuntime
        private void updateSubscribeView(j.l.a.c0.e eVar, DynamicLiveEventEntity.Data data) {
            LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new s(new Object[]{this, eVar, data, r.a.c.c.e.x(m, this, this, eVar, data)}).e(69648));
        }

        private static /* synthetic */ void y() {
            r.a.c.c.e eVar = new r.a.c.c.e("LiveEventRender.java", LiveEventAdapter.class);
            l = eVar.H("method-execution", eVar.E("1", "setUI", "com.hunantv.oversea.channel.dynamic.render.LiveEventRender$LiveEventAdapter", "com.hunantv.imgo.widget.CommonViewHolder:int:com.hunantv.oversea.channel.dynamic.render.entity.DynamicLiveEventEntity$Data:java.util.List", "holder:itemPosition:data:payLoads", "", "void"), 128);
            m = eVar.H("method-execution", eVar.E("2", "updateSubscribeView", "com.hunantv.oversea.channel.dynamic.render.LiveEventRender$LiveEventAdapter", "com.hunantv.imgo.widget.CommonViewHolder:com.hunantv.oversea.channel.dynamic.render.entity.DynamicLiveEventEntity$Data", "holder:data", "", "void"), 170);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: z */
        public /* synthetic */ void A(DynamicLiveEventEntity.Data data, View view) {
            j.l.c.z.c.d.e().a(LiveEventRender.this.g, data.jumpUrl, (Bundle) null);
        }

        public int obtainLayoutResourceID(int i2) {
            return b.m.item_dynamic_live_event;
        }

        @WithTryCatchRuntime
        public void setUI(j.l.a.c0.e eVar, int i2, DynamicLiveEventEntity.Data data, @NonNull List list) {
            LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.r(new Object[]{this, eVar, r.a.c.b.e.k(i2), data, list, r.a.c.c.e.y(l, this, this, new Object[]{eVar, r.a.c.b.e.k(i2), data, list})}).e(69648));
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends ImgoHttpCallBack<JsonVoid> {
        public final /* synthetic */ d d;
        public final /* synthetic */ boolean e;

        public a(d dVar, boolean z) {
            this.d = dVar;
            this.e = z;
        }

        /* renamed from: w */
        public void failed(@Nullable JsonVoid jsonVoid, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(jsonVoid, i, i2, str, th);
            d dVar = this.d;
            if (dVar != null) {
                dVar.a(this.e, false);
            }
            if (this.e) {
                if (str == null) {
                    str = j.l.a.a.a().getString(b.r.channel_ordered_fail);
                }
                o0.o(str);
            } else if (TextUtils.isEmpty(str)) {
            } else {
                o0.o(str);
            }
        }

        public void success(JsonVoid jsonVoid) {
            d dVar = this.d;
            if (dVar != null) {
                dVar.a(this.e, true);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends ImgoHttpCallBack<QuerySubscribeEntity> {
        public b() {
        }

        /* renamed from: w */
        public void success(QuerySubscribeEntity querySubscribeEntity) {
            List<QuerySubscribeEntity.DataBean> list;
            if (querySubscribeEntity == null || (list = querySubscribeEntity.data) == null) {
                return;
            }
            LiveEventRender.this.updateAllFollowState(list);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c implements DialogInterface.OnShowListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface d {
        void a(boolean z, boolean z2);
    }

    static {
        d();
    }

    public LiveEventRender(j.l.c.c.c.s1.e eVar) {
        super(eVar);
    }

    private static /* synthetic */ void d() {
        r.a.c.c.e eVar = new r.a.c.c.e("LiveEventRender.java", LiveEventRender.class);
        l = eVar.H("method-execution", eVar.E("1", "requestAddRemoveSubscribe", "com.hunantv.oversea.channel.dynamic.render.LiveEventRender", "com.mgtv.task.TaskStarter:boolean:java.lang.String:com.hunantv.oversea.channel.dynamic.render.LiveEventRender$OnSubscribeCallback", "starter:isSubscribe:aid:callback", "", "void"), 214);
        m = eVar.H("method-execution", eVar.E("2", "requestAllSubscribeState", "com.hunantv.oversea.channel.dynamic.render.LiveEventRender", "", "", "", "void"), 258);
        n = eVar.H("method-execution", eVar.E("2", "updateAllFollowState", "com.hunantv.oversea.channel.dynamic.render.LiveEventRender", "java.util.List", "queryList", "", "void"), 315);
        o = eVar.H("method-execution", eVar.E("2", "handleSubscribeSuccess", "com.hunantv.oversea.channel.dynamic.render.LiveEventRender", "", "", "", "void"), 337);
        p = eVar.H("method-execution", eVar.E("2", "showSubscribeAlertDialog", "com.hunantv.oversea.channel.dynamic.render.LiveEventRender", "", "", "", "void"), 357);
    }

    public static final /* synthetic */ void f(LiveEventRender liveEventRender, r.a.b.c cVar) {
        if ("1".equals(j.l.a.b0.e.r0())) {
            o0.o(j.l.a.a.a().getResources().getString(b.r.channel_ordered_success));
            return;
        }
        int g = l.g();
        int g2 = f0.g("PREF_KEY_PLAYBILL_SUBSCRIBE_ALERT_DATE");
        if (g > 0 && g2 > 0 && g - g2 <= 7) {
            o0.o(j.l.a.a.a().getResources().getString(b.r.channel_ordered_success));
        } else {
            liveEventRender.showSubscribeAlertDialog();
        }
    }

    public static final /* synthetic */ void g(LiveEventRender liveEventRender, r rVar, boolean z, String str, d dVar, r.a.b.c cVar) {
        if (!SessionManager.m()) {
            LoginEntry.c(7100);
        } else if (rVar == null) {
        } else {
            String str2 = z ? "https://yy.bz.mgtv.com/yy/sub" : "https://yy.bz.mgtv.com/yy/unsub";
            ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
            imgoHttpParams.put("aid", str);
            imgoHttpParams.put("type", "5");
            rVar.n(true).u(str2, imgoHttpParams, new a(dVar, z));
        }
    }

    public static final /* synthetic */ void h(LiveEventRender liveEventRender, r.a.b.c cVar) {
        r e;
        List<DynamicLiveEventEntity.Data> list;
        if (!SessionManager.m() || (e = liveEventRender.e()) == null || (list = liveEventRender.i) == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int size = liveEventRender.i.size();
        for (int i = 0; i < size; i++) {
            String str = liveEventRender.i.get(i).activityId;
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                sb2.append("5");
                if (i != size - 1) {
                    sb.append(",");
                    sb2.append(",");
                }
            }
        }
        if (sb.length() <= 0) {
            return;
        }
        String sb3 = sb.toString();
        String sb4 = sb2.toString();
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        imgoHttpParams.put("aids", sb3);
        imgoHttpParams.put("types", sb4);
        e.n(true).u("https://yy.bz.mgtv.com/yy/query/type", imgoHttpParams, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void handleSubscribeSuccess() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new p(new Object[]{this, r.a.c.c.e.v(o, this, this)}).e(69648));
    }

    public static final /* synthetic */ void i(LiveEventRender liveEventRender, r.a.b.c cVar) {
        Context context = liveEventRender.g;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        j.l.c.c.c.u1.w.b bVar = liveEventRender.j;
        if (bVar != null && bVar.isShowing()) {
            liveEventRender.j.dismiss();
        }
        if (liveEventRender.j == null) {
            j.l.c.c.c.u1.w.b bVar2 = new j.l.c.c.c.u1.w.b(liveEventRender.g);
            liveEventRender.j = bVar2;
            bVar2.setOnShowListener(new c());
        }
        liveEventRender.j.show();
    }

    public static final /* synthetic */ void j(LiveEventRender liveEventRender, List list, r.a.b.c cVar) {
        List<DynamicLiveEventEntity.Data> list2 = liveEventRender.i;
        if (list2 == null || list2.size() == 0 || list == null || list.size() == 0) {
            return;
        }
        for (DynamicLiveEventEntity.Data data : liveEventRender.i) {
            boolean z = false;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(data.activityId, ((QuerySubscribeEntity.DataBean) it.next()).aid)) {
                    z = true;
                }
            }
            data.isSubscribed = z;
        }
        liveEventRender.e.notifyDataSetChanged();
    }

    @WithTryCatchRuntime
    private void requestAllSubscribeState() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n(new Object[]{this, r.a.c.c.e.v(m, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    private void showSubscribeAlertDialog() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new q(new Object[]{this, r.a.c.c.e.v(p, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void updateAllFollowState(List<QuerySubscribeEntity.DataBean> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o(new Object[]{this, list, r.a.c.c.e.w(n, this, this, list)}).e(69648));
    }

    public r e() {
        if (this.f == null) {
            this.f = new r(j.l.a.a.a(), new j.v.r.m(ThreadManager.getNetWorkExecutorService(), false), (j.v.r.p) null);
        }
        return this.f;
    }

    public void rendWithData(View view, JsonObject jsonObject, j.v.g.k.d dVar, int i) {
        super.rendWithData(view, jsonObject, dVar, i);
        if (jsonObject == null || this.h == jsonObject) {
            return;
        }
        this.h = jsonObject;
        this.g = view.getContext();
        DynamicLiveEventEntity dynamicLiveEventEntity = (DynamicLiveEventEntity) j.v.j.b.w(jsonObject, DynamicLiveEventEntity.class);
        if (dynamicLiveEventEntity != null) {
            this.i = dynamicLiveEventEntity.items;
        }
        List<DynamicLiveEventEntity.Data> list = this.i;
        if (list == null || list.size() == 0) {
            return;
        }
        RecyclerView findViewById = view.findViewById(b.j.rv_channel_live_event);
        this.d = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManagerWrapper(this.g, 1, false));
        LiveEventAdapter liveEventAdapter = new LiveEventAdapter(this.i, LayoutInflater.from(this.g));
        this.e = liveEventAdapter;
        this.d.setAdapter(liveEventAdapter);
        requestAllSubscribeState();
    }

    @WithTryCatchRuntime
    public void requestAddRemoveSubscribe(r rVar, boolean z, String str, d dVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.m(new Object[]{this, rVar, r.a.c.b.e.a(z), str, dVar, r.a.c.c.e.y(l, this, this, new Object[]{rVar, r.a.c.b.e.a(z), str, dVar})}).e(69648));
    }
}
