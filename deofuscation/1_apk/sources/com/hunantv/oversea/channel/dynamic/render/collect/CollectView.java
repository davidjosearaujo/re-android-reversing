package com.hunantv.oversea.channel.dynamic.render.collect;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.google.gson.JsonObject;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import com.hunantv.imgo.nightmode.view.SkinnableImageView;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.channel.dynamic.business.jump.JumpKind;
import com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.b.e.e.m;
import j.l.c.c.b;
import j.l.c.c.c.u1.v.f;
import j.l.c.c.c.u1.v.g;
import j.l.c.c.c.u1.v.i;
import j.l.c.c.c.u1.v.j;
import j.l.c.c.c.u1.v.k;
import j.l.c.c.c.u1.v.l;
import j.v.g.k.d;
import j.v.g.k.h;
import j.v.r.r;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CollectView extends SkinnableFrameLayout implements h, View.OnClickListener {
    private static final /* synthetic */ c.b j = null;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private static final /* synthetic */ c.b p = null;
    private static final /* synthetic */ c.b q = null;
    private JsonObject a;
    private int b;
    private String c;
    private String d;
    private VideoCollectPresenter e;
    private r f;
    private ImageView g;
    private boolean h;
    private VideoCollectPresenter.f i;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements VideoCollectPresenter.f {
        public a() {
        }

        @Override // com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter.f
        public void a(boolean z) {
            if (z) {
                CollectView.this.e0(false);
            }
        }

        @Override // com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter.f
        public void b(boolean z) {
            if (z) {
                CollectView.this.e0(true);
            }
        }
    }

    static {
        c0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectView(Context context) {
        super(context);
        this.i = new a();
        this.e = new VideoCollectPresenter();
        removeAllViews();
        j.l.a.t.h skinnableImageView = new SkinnableImageView(context);
        this.g = skinnableImageView;
        skinnableImageView.setImageResource(b.h.selector_channel_collect);
        addView(this.g);
    }

    private static /* synthetic */ void c0() {
        e eVar = new e("CollectView.java", CollectView.class);
        j = eVar.H("method-execution", eVar.E("1", "rendWithRawData", "com.hunantv.oversea.channel.dynamic.render.collect.CollectView", "com.google.gson.JsonObject:com.mgtv.dynamicview.render.CommBridge:int", "jsonObject:commBridge:listIndex", "", "void"), 70);
        k = eVar.H("method-execution", eVar.E("2", "setData", "com.hunantv.oversea.channel.dynamic.render.collect.CollectView", "java.lang.String:java.lang.String:java.lang.String", "jumpKind:jumpId:childId", "", "void"), 86);
        l = eVar.H("method-execution", eVar.E("2", "queryCollectState", "com.hunantv.oversea.channel.dynamic.render.collect.CollectView", "int", "videoType", "", "void"), (int) EventClickData.u.I0);
        m = eVar.H("method-execution", eVar.E("2", "updateUI", "com.hunantv.oversea.channel.dynamic.render.collect.CollectView", "boolean", "isCollected", "", "void"), 150);
        n = eVar.H("method-execution", eVar.E("2", "updateCollectState", "com.hunantv.oversea.channel.dynamic.render.collect.CollectView", "boolean", "isCollected", "", "void"), (int) Opcodes.IF_ICMPEQ);
        o = eVar.H("method-execution", eVar.E("1", "onClick", "com.hunantv.oversea.channel.dynamic.render.collect.CollectView", "android.view.View", "v", "", "void"), (int) EventClickData.u.E1);
        p = eVar.H("method-execution", eVar.E("2", "hideView", "com.hunantv.oversea.channel.dynamic.render.collect.CollectView", "", "", "", "void"), (int) IDrmSession.ERROR_SESSION_DRM_NULL);
        q = eVar.H("method-execution", eVar.E("2", "reportCollectClick", "com.hunantv.oversea.channel.dynamic.render.collect.CollectView", "boolean", "isCollected", "", "void"), 236);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void d0(CollectView collectView, c cVar) {
        collectView.setOnClickListener((View.OnClickListener) null);
        Log.d("kylingo", "hideView");
        if (collectView.getVisibility() != 0) {
            return;
        }
        ViewParent parent = collectView.getParent();
        if (parent instanceof YogaLayout) {
            YogaNode yogaNodeForView = ((YogaLayout) parent).getYogaNodeForView(collectView);
            collectView.setVisibility(4);
            yogaNodeForView.setWidth(0.0f);
            yogaNodeForView.dirty();
        }
    }

    public static final /* synthetic */ void g0(CollectView collectView, View view, c cVar) {
        collectView.reportCollectClick(collectView.h);
        if (!collectView.h) {
            collectView.e.addToCollect(collectView.f, collectView.c, collectView.d, collectView.i);
        } else {
            collectView.e.removeFromCollect(collectView.f, collectView.b, collectView.c, collectView.d, collectView.i);
        }
    }

    private String getCollectKey() {
        return this.b + "&" + this.c + "&" + this.d;
    }

    public static final /* synthetic */ void h0(CollectView collectView, int i, c cVar) {
        r rVar = collectView.f;
        if (rVar == null) {
            return;
        }
        collectView.e.findCollect(rVar, i, collectView.c, collectView.d, new j.l.c.c.c.u1.v.a(collectView));
    }

    @WithTryCatchRuntime
    private void hideView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, e.v(p, this, this)}).e(69648));
    }

    public static final /* synthetic */ void i0(CollectView collectView, JsonObject jsonObject, d dVar, int i, c cVar) {
        if (jsonObject == null) {
            return;
        }
        collectView.a = jsonObject;
        collectView.setData(j.l.c.c.c.m1.h.d(jsonObject, "jumpKind"), j.l.c.c.c.m1.h.d(jsonObject, "jumpId"), j.l.c.c.c.m1.h.d(jsonObject, "childId"));
    }

    public static final /* synthetic */ void k0(CollectView collectView, boolean z, c cVar) {
        String str = z ? "2" : "1";
        m.c(j.l.a.a.a()).g(new EventClickData(EventClickData.a.P, "1", "status=" + str + "&perman=1&vid=" + collectView.c + "&cid=" + collectView.d));
    }

    public static final /* synthetic */ void m0(CollectView collectView, String str, String str2, String str3, c cVar) {
        boolean z;
        collectView.setOnClickListener(collectView);
        int i = 3;
        if (!TextUtils.equals(str, JumpKind.KIND_COLLECT.toString()) && !TextUtils.equals(str, JumpKind.KIND_COLLECT_VIDEO.toString())) {
            if (TextUtils.equals(str, JumpKind.KIND_PL_VIDEO.toString())) {
                collectView.c = str3;
            } else if (TextUtils.equals(str, JumpKind.KIND_SVIDEO.toString())) {
                collectView.c = str2;
            } else {
                collectView.hideView();
                z = false;
            }
            z = true;
        } else {
            collectView.d = str2;
            z = true;
            i = 1;
        }
        if (TextUtils.isEmpty(collectView.d)) {
            collectView.d = "";
        }
        if (TextUtils.isEmpty(collectView.c)) {
            collectView.c = "";
        }
        collectView.b = i;
        if (VideoCollectPresenter.getCollectStatus(collectView.getCollectKey())) {
            collectView.updateCollectState(true);
        } else if (z) {
            if (VideoCollectPresenter.e(collectView.getCollectKey())) {
                collectView.e0(false);
                return;
            }
            VideoCollectPresenter.h(collectView.getCollectKey(), false);
            collectView.queryCollectState(i);
        }
    }

    public static final /* synthetic */ void o0(CollectView collectView, boolean z, c cVar) {
        if (collectView.h == z) {
            return;
        }
        collectView.h = z;
        ImageView imageView = collectView.g;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    public static final /* synthetic */ void p0(CollectView collectView, boolean z, c cVar) {
        VideoCollectPresenter.h(collectView.getCollectKey(), z);
        collectView.updateCollectState(z);
    }

    @WithTryCatchRuntime
    private void queryCollectState(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j(new Object[]{this, r.a.c.b.e.k(i), e.w(l, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    @WithTryCatchRuntime
    private void reportCollectClick(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g(new Object[]{this, r.a.c.b.e.a(z), e.w(q, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    @WithTryCatchRuntime
    private void setData(String str, String str2, String str3) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, str, str2, str3, e.y(k, this, this, new Object[]{str, str2, str3})}).e(69648));
    }

    @WithTryCatchRuntime
    private void updateCollectState(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{this, r.a.c.b.e.a(z), e.w(n, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    /* renamed from: updateUI */
    public void f0(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{this, r.a.c.b.e.a(z), e.w(m, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    @Override // android.view.View.OnClickListener
    @WithTryCatchRuntime
    public void onClick(View view) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.v.e(new Object[]{this, view, e.w(o, this, this, view)}).e(69648));
    }

    @WithTryCatchRuntime
    public void rendWithRawData(JsonObject jsonObject, d dVar, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.v.h(new Object[]{this, jsonObject, dVar, r.a.c.b.e.k(i), e.y(j, this, this, new Object[]{jsonObject, dVar, r.a.c.b.e.k(i)})}).e(69648));
    }

    public void setTaskStarter(r rVar) {
        this.f = rVar;
    }
}
