package com.hunantv.oversea.channel.selected;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Opcodes;
import com.alipay.sdk.util.f;
import com.facebook.GraphResponse;
import com.hunantv.imgo.global.AgeDataModel;
import com.hunantv.imgo.net.ImgoHttpCallBack;
import com.hunantv.imgo.net.ImgoHttpParams;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment;
import com.hunantv.oversea.channel.selected.adapter.SelectedAdapter;
import com.hunantv.oversea.channel.selected.data.ChannelListEntity;
import com.hunantv.oversea.channel.selected.list.ChannelListDataManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.task.http.HttpResponseObject;
import j.l.a.b0.c0;
import j.l.c.a.e.a.a;
import j.l.c.c.c.q1.b;
import j.l.c.c.f.j0;
import j.l.c.c.f.k0;
import j.l.c.c.f.l0;
import j.l.c.c.f.m0;
import j.l.c.c.f.n0;
import j.l.c.c.f.o0;
import j.l.c.c.f.p0;
import j.l.c.c.f.q0;
import j.l.c.c.f.r0;
import j.l.c.c.f.s0;
import j.l.c.c.f.t0;
import j.v.r.r;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import r.a.b.c;
import r.a.c.b.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SelectedPresenter {
    private static final String f = "SelectedPresenter";
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private static final /* synthetic */ c.b j = null;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private final r a;
    private Context b;
    private t0 c;
    @Nullable
    private ChannelListEntity d;
    private AtomicBoolean e = new AtomicBoolean(false);

    static {
        g();
    }

    public SelectedPresenter(Context context, @NonNull r rVar, t0 t0Var) {
        this.a = rVar;
        this.b = context;
        this.c = t0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public boolean checkNavData(@Nullable ChannelListEntity channelListEntity, @Nullable ChannelListEntity channelListEntity2) {
        return e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new m0(new Object[]{this, channelListEntity, channelListEntity2, r.a.c.c.e.x(l, this, this, channelListEntity, channelListEntity2)}).e(69648)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void filterInvalidData(@Nullable ChannelListEntity channelListEntity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new s0(new Object[]{this, channelListEntity, r.a.c.c.e.w(k, this, this, channelListEntity)}).e(69648));
    }

    private static /* synthetic */ void g() {
        r.a.c.c.e eVar = new r.a.c.c.e("SelectedPresenter.java", SelectedPresenter.class);
        g = eVar.H("method-execution", eVar.E("0", "loadCacheList", "com.hunantv.oversea.channel.selected.SelectedPresenter", "", "", "", "void"), 64);
        h = eVar.H("method-execution", eVar.E("1", "requestChannelList", "com.hunantv.oversea.channel.selected.SelectedPresenter", "boolean", "enableMemory", "", "void"), 83);
        i = eVar.H("method-execution", eVar.E("0", "getChannelMapping", "com.hunantv.oversea.channel.selected.SelectedPresenter", "com.hunantv.oversea.channel.selected.data.ChannelListEntity$DataBean", "data", "", "com.hunantv.oversea.channel.selected.adapter.SelectedAdapter$AdapterData"), 200);
        j = eVar.H("method-execution", eVar.E("2", "getDynamicData", "com.hunantv.oversea.channel.selected.SelectedPresenter", "com.hunantv.oversea.channel.selected.data.ChannelListEntity$DataBean", "data", "", "com.hunantv.oversea.channel.selected.adapter.SelectedAdapter$AdapterData"), (int) IDrmSession.ERROR_SESSION_DRM_PSSHS_NOT_SUPPORT);
        k = eVar.H("method-execution", eVar.E("2", "filterInvalidData", "com.hunantv.oversea.channel.selected.SelectedPresenter", "com.hunantv.oversea.channel.selected.data.ChannelListEntity", "resultData", "", "void"), 231);
        l = eVar.H("method-execution", eVar.E("2", "checkNavData", "com.hunantv.oversea.channel.selected.SelectedPresenter", "com.hunantv.oversea.channel.selected.data.ChannelListEntity:com.hunantv.oversea.channel.selected.data.ChannelListEntity", "cacheDatas:newDatas", "", "boolean"), 253);
        m = eVar.H("method-execution", eVar.E("1", "checkNavDataBySort", "com.hunantv.oversea.channel.selected.SelectedPresenter", "com.hunantv.oversea.channel.selected.data.ChannelListEntity:com.hunantv.oversea.channel.selected.data.ChannelListEntity", "cacheDatas:newDatas", "", "boolean"), 296);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public SelectedAdapter.a getDynamicData(@NonNull ChannelListEntity.DataBean dataBean) {
        return (SelectedAdapter.a) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new r0(new Object[]{this, dataBean, r.a.c.c.e.w(j, this, this, dataBean)}).e(69648));
    }

    public static final /* synthetic */ boolean h(SelectedPresenter selectedPresenter, ChannelListEntity channelListEntity, ChannelListEntity channelListEntity2, c cVar) {
        List<ChannelListEntity.DataBean> list;
        if (channelListEntity == null || channelListEntity2 == null || (list = channelListEntity.data) == null || channelListEntity2.data == null || list.isEmpty() || channelListEntity2.data.isEmpty()) {
            return true;
        }
        List<ChannelListEntity.DataBean> list2 = channelListEntity.data;
        List<ChannelListEntity.DataBean> list3 = channelListEntity2.data;
        int size = list3.size();
        if (size != list2.size()) {
            return true;
        }
        for (int i2 = 0; i2 < size; i2++) {
            ChannelListEntity.DataBean dataBean = list2.get(i2);
            ChannelListEntity.DataBean dataBean2 = list3.get(i2);
            if (dataBean == null || dataBean2 == null || !dataBean.checkEquals(dataBean2)) {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ boolean i(SelectedPresenter selectedPresenter, ChannelListEntity channelListEntity, ChannelListEntity channelListEntity2, c cVar) {
        List<ChannelListEntity.DataBean> list;
        List<ChannelListEntity.DataBean> list2;
        int size;
        int size2;
        boolean z;
        if (channelListEntity == null || channelListEntity2 == null || (list = channelListEntity.data) == null || (list2 = channelListEntity2.data) == null || (size = list2.size()) != (size2 = list.size())) {
            return true;
        }
        do {
            size--;
            if (size >= size2) {
                return true;
            }
            ChannelListEntity.DataBean dataBean = list.get(size);
            ChannelListEntity.DataBean dataBean2 = list2.get(size);
            if (dataBean2 != null && c0.g(dataBean2.customPosition, 1) == 0 && !dataBean2.checkEquals(dataBean)) {
                return true;
            }
            Iterator<ChannelListEntity.DataBean> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (dataBean.checkEquals(it.next())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return true;
            }
        } while (size > 0);
        return false;
    }

    public static final /* synthetic */ void j(SelectedPresenter selectedPresenter, ChannelListEntity channelListEntity, c cVar) {
        List<ChannelListEntity.DataBean> list;
        if (channelListEntity == null || (list = channelListEntity.data) == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        while (i2 < channelListEntity.data.size()) {
            ChannelListEntity.DataBean dataBean = channelListEntity.data.get(i2);
            if (dataBean != null && (TextUtils.isEmpty(dataBean.vclassId) || TextUtils.isEmpty(dataBean.title))) {
                channelListEntity.data.remove(dataBean);
                i2 = 0;
            }
            i2++;
        }
    }

    public static final /* synthetic */ SelectedAdapter.a l(SelectedPresenter selectedPresenter, ChannelListEntity.DataBean dataBean, c cVar) {
        Bundle bundle = new Bundle();
        bundle.putString("bundle_channel_id", dataBean.vclassId);
        bundle.putString("bundle_channel_fid", dataBean.fstlvlId);
        if (TextUtils.equals(dataBean.isCustomShow, "1")) {
            bundle.putString("bundler_h5_fontcolor", dataBean.navbarHlColor);
            bundle.putString("bundle_h5_bgcolor", dataBean.navbarBgColor);
            bundle.putString("bundler_bg_img", dataBean.bgImg);
        }
        SelectedAdapter.a aVar = new SelectedAdapter.a(null, bundle);
        aVar.a = ChannelDynamicFragment.class;
        aVar.c = true;
        return aVar;
    }

    public static final /* synthetic */ void m(SelectedPresenter selectedPresenter, c cVar) {
        List<ChannelListEntity.DataBean> list;
        ChannelListEntity e = ChannelListDataManager.h().e();
        selectedPresenter.d = e;
        if (e != null && (list = e.data) != null && list.size() > 0) {
            t0 t0Var = selectedPresenter.c;
            if (t0Var != null) {
                t0Var.updateChannelList(e, false);
                return;
            }
            return;
        }
        a.b.b();
    }

    public static final /* synthetic */ void n(SelectedPresenter selectedPresenter, boolean z, c cVar) {
        if (selectedPresenter.e.get()) {
            return;
        }
        selectedPresenter.e.getAndSet(true);
        b bVar = new b("https://dc.bz.mgtv.com/dynamic/v1/channel/vrsList");
        bVar.b(j.l.a.b0.e.B0());
        bVar.b(j.l.a.b0.e.Y());
        bVar.b("5.0");
        bVar.b("10100001");
        bVar.b(j.l.a.k.b.b());
        bVar.b("12");
        bVar.b("0");
        bVar.b(String.valueOf(AgeDataModel.b().a().ordinal()));
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        ChannelListEntity channelListEntity = selectedPresenter.d;
        imgoHttpParams.put(com.alipay.sdk.tid.a.k, Long.valueOf(channelListEntity == null ? 0L : channelListEntity.timestamp));
        imgoHttpParams.put("subchannelFlag", "2");
        j.l.a.n.m.a.d("30", f, "频道列表数据请求:参数" + imgoHttpParams.getParams().toString());
        selectedPresenter.a.n(true);
        if (z) {
            selectedPresenter.a.o();
        }
        selectedPresenter.a.u(bVar.toString(), imgoHttpParams, new ImgoHttpCallBack<ChannelListEntity>() { // from class: com.hunantv.oversea.channel.selected.SelectedPresenter.1
            private static final /* synthetic */ c.b f = null;
            private static final /* synthetic */ c.b g = null;
            private static final /* synthetic */ c.b h = null;
            public long d;

            static {
                w();
            }

            public static final /* synthetic */ void A(AnonymousClass1 anonymousClass1, ChannelListEntity channelListEntity2, c cVar2) {
                if (anonymousClass1.r() != null && !TextUtils.isEmpty(anonymousClass1.r().getFinalUrl())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("频道列表数据请求成功上报:");
                    sb.append(channelListEntity2 != null ? channelListEntity2.reportString() : "-1");
                    j.l.a.n.m.a.d("30", SelectedPresenter.f, sb.toString());
                    if (channelListEntity2 != null) {
                        SelectedPresenter.this.filterInvalidData(channelListEntity2);
                        ChannelListDataManager.h().saveAndGetChannelListEntity(channelListEntity2);
                        SelectedPresenter selectedPresenter2 = SelectedPresenter.this;
                        if (selectedPresenter2.checkNavData(selectedPresenter2.d, channelListEntity2)) {
                            SelectedPresenter.this.d = channelListEntity2;
                            SelectedPresenter.this.d.data = ChannelListDataManager.h().getChannelData();
                            if (SelectedPresenter.this.c != null) {
                                SelectedPresenter.this.c.updateChannelList(channelListEntity2, true);
                                return;
                            }
                            return;
                        }
                        j.l.a.n.m.a.d("30", SelectedPresenter.f, "频道列表数据: 无更新");
                        return;
                    }
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("频道列表数据请求成功上报:缓存数据过滤:");
                sb2.append(channelListEntity2 != null ? channelListEntity2.reportString() : "-1");
                j.l.a.n.m.a.d("30", SelectedPresenter.f, sb2.toString());
            }

            private static /* synthetic */ void w() {
                r.a.c.c.e eVar = new r.a.c.c.e("SelectedPresenter.java", AnonymousClass1.class);
                f = eVar.H("method-execution", eVar.E("1", GraphResponse.SUCCESS_KEY, "com.hunantv.oversea.channel.selected.SelectedPresenter$1", "com.hunantv.oversea.channel.selected.data.ChannelListEntity", "resultData", "", "void"), 126);
                g = eVar.H("method-execution", eVar.E("1", f.j, "com.hunantv.oversea.channel.selected.SelectedPresenter$1", "com.hunantv.oversea.channel.selected.data.ChannelListEntity:int:int:java.lang.String:java.lang.Throwable", "resultData:httpStatus:code:info:e", "", "void"), (int) Opcodes.IF_ICMPEQ);
                h = eVar.H("method-execution", eVar.E("1", "onCancelled", "com.hunantv.oversea.channel.selected.SelectedPresenter$1", "com.mgtv.task.http.HttpResponseObject:java.lang.Object:java.lang.Throwable", "result:extra:exception", "", "void"), (int) Opcodes.GETSTATIC);
            }

            public static final /* synthetic */ void x(AnonymousClass1 anonymousClass1, ChannelListEntity channelListEntity2, int i2, int i3, String str, Throwable th, c cVar2) {
                super.failed(channelListEntity2, i2, i3, str, th);
                StringBuilder sb = new StringBuilder();
                sb.append("频道列表数据请求失败:httpStatus:");
                sb.append(i2);
                sb.append(" code:");
                sb.append(i3);
                sb.append(" info:");
                sb.append(str);
                sb.append(" error:");
                sb.append(th == null ? "" : th.getMessage());
                j.l.a.n.m.a.d("30", SelectedPresenter.f, sb.toString());
                if (SelectedPresenter.this.c != null) {
                    SelectedPresenter.this.c.updateChannelList((ChannelListEntity) null, true);
                }
            }

            public static final /* synthetic */ void y(AnonymousClass1 anonymousClass1, HttpResponseObject httpResponseObject, Object obj, Throwable th, c cVar2) {
                super.onCancelled(httpResponseObject, obj, th);
                if ((SelectedPresenter.this.d == null || SelectedPresenter.this.d.data == null) && SelectedPresenter.this.c != null) {
                    SelectedPresenter.this.c.updateChannelList((ChannelListEntity) null, true);
                }
            }

            public void a() {
                this.d = System.currentTimeMillis();
            }

            @Override // com.hunantv.imgo.net.ImgoHttpCallBack
            /* renamed from: z */
            public void previewCache(ChannelListEntity channelListEntity2) {
                j.l.a.n.m.a.d("30", SelectedPresenter.f, "previewCache");
            }

            @WithTryCatchRuntime
            public void failed(@Nullable ChannelListEntity channelListEntity2, int i2, int i3, @Nullable String str, @Nullable Throwable th) {
                LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k0(new Object[]{this, channelListEntity2, e.k(i2), e.k(i3), str, th, r.a.c.c.e.y(g, this, this, new Object[]{channelListEntity2, e.k(i2), e.k(i3), str, th})}).e(69648));
            }

            @WithTryCatchRuntime
            public void onCancelled(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
                LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l0(new Object[]{this, httpResponseObject, obj, th, r.a.c.c.e.y(h, this, this, new Object[]{httpResponseObject, obj, th})}).e(69648));
            }

            @Override // com.hunantv.imgo.net.ImgoHttpCallBack
            public void onPostExecute(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
                super.onPostExecute(httpResponseObject, obj, th);
                SelectedPresenter.this.e.getAndSet(false);
            }

            @WithTryCatchRuntime
            public void success(ChannelListEntity channelListEntity2) {
                LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j0(new Object[]{this, channelListEntity2, r.a.c.c.e.w(f, this, this, channelListEntity2)}).e(69648));
            }
        });
    }

    @WithTryCatchRuntime
    public boolean checkNavDataBySort(@Nullable ChannelListEntity channelListEntity, @Nullable ChannelListEntity channelListEntity2) {
        return e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n0(new Object[]{this, channelListEntity, channelListEntity2, r.a.c.c.e.x(m, this, this, channelListEntity, channelListEntity2)}).e(69648)));
    }

    @WithTryCatchRuntime
    public SelectedAdapter.a getChannelMapping(@NonNull ChannelListEntity.DataBean dataBean) {
        return (SelectedAdapter.a) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new q0(new Object[]{this, dataBean, r.a.c.c.e.w(i, this, this, dataBean)}).e(69648));
    }

    @WithTryCatchRuntime
    public void loadCacheList() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o0(new Object[]{this, r.a.c.c.e.v(g, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void requestChannelList(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new p0(new Object[]{this, e.a(z), r.a.c.c.e.w(h, this, this, e.a(z))}).e(69648));
    }
}
