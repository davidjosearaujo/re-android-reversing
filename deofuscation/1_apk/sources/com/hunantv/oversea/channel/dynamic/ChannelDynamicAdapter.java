package com.hunantv.oversea.channel.dynamic;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hunantv.oversea.channel.dynamic.common.DynamicAdapter;
import com.hunantv.oversea.channel.dynamic.data.ModuleData;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.dynamicview.widget.DynamicInnerListView;
import j.l.c.c.b;
import j.l.c.c.c.d;
import j.l.c.c.c.f;
import j.l.c.c.c.u1.l;
import j.l.c.c.d.e;
import java.lang.ref.WeakReference;
import java.util.List;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelDynamicAdapter extends DynamicAdapter {
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private e i;
    private WeakReference<DynamicInnerListView.c> j;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ DynamicAdapter.a a;
        public final /* synthetic */ ModuleData.DataBean.DSLBean b;

        public a(DynamicAdapter.a aVar, ModuleData.DataBean.DSLBean dSLBean) {
            this.a = aVar;
            this.b = dSLBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChannelDynamicAdapter.this.reportModuleExposure(((RecyclerView.ViewHolder) this.a).itemView, this.b);
        }
    }

    static {
        f();
    }

    public ChannelDynamicAdapter(@NonNull e eVar, j.l.c.c.c.s1.e eVar2, @NonNull List<ModuleData.DataBean.DSLBean> list) {
        super(eVar.getCurrentActivity(), eVar2, list);
        this.i = eVar;
    }

    private static /* synthetic */ void f() {
        r.a.c.c.e eVar = new r.a.c.c.e("ChannelDynamicAdapter.java", ChannelDynamicAdapter.class);
        k = eVar.H("method-execution", eVar.E("1", "rendWithData", "com.hunantv.oversea.channel.dynamic.ChannelDynamicAdapter", "android.view.View:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean:int", "view:data:position", "", "void"), 67);
        l = eVar.H("method-execution", eVar.E("2", "reportModuleExposure", "com.hunantv.oversea.channel.dynamic.ChannelDynamicAdapter", "android.view.View:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "itemView:data", "", "void"), 86);
        m = eVar.H("method-execution", eVar.E("1", "onLinkageScrolled", "com.hunantv.oversea.channel.dynamic.ChannelDynamicAdapter", "int:int", "dx:dy", "", "void"), 106);
        n = eVar.H("method-execution", eVar.E("1", "onLinkageScrollIdle", "com.hunantv.oversea.channel.dynamic.ChannelDynamicAdapter", "", "", "", "void"), 119);
    }

    public static final /* synthetic */ void r(ChannelDynamicAdapter channelDynamicAdapter, c cVar) {
        DynamicInnerListView.c cVar2;
        WeakReference<DynamicInnerListView.c> weakReference = channelDynamicAdapter.j;
        if (weakReference == null || (cVar2 = weakReference.get()) == null) {
            return;
        }
        cVar2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void reportModuleExposure(View view, ModuleData.DataBean.DSLBean dSLBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{this, view, dSLBean, r.a.c.c.e.x(l, this, this, view, dSLBean)}).e(69648));
    }

    public static final /* synthetic */ void s(ChannelDynamicAdapter channelDynamicAdapter, int i, int i2, c cVar) {
        DynamicInnerListView.c cVar2;
        WeakReference<DynamicInnerListView.c> weakReference = channelDynamicAdapter.j;
        if (weakReference == null || (cVar2 = weakReference.get()) == null) {
            return;
        }
        cVar2.b(i, i2);
    }

    public static final /* synthetic */ void t(ChannelDynamicAdapter channelDynamicAdapter, View view, ModuleData.DataBean.DSLBean dSLBean, int i, c cVar) {
        DynamicInnerListView.c onLinkageListener;
        if (view != null) {
            l lVar = (j.v.g.k.e) view.getTag(b.j.dsl_tag_data_binder);
            if (lVar instanceof l) {
                lVar.setChannelCenter(channelDynamicAdapter.i);
            }
            if ((view instanceof DynamicInnerListView) && (onLinkageListener = ((DynamicInnerListView) view).getOnLinkageListener()) != null) {
                channelDynamicAdapter.j = new WeakReference<>(onLinkageListener);
            }
        }
        super.rendWithData(view, dSLBean, i);
    }

    public static final /* synthetic */ void u(ChannelDynamicAdapter channelDynamicAdapter, View view, ModuleData.DataBean.DSLBean dSLBean, c cVar) {
        if (view == null || dSLBean == null || TextUtils.isEmpty(dSLBean.moduleEntityId)) {
            return;
        }
        j.l.c.c.d.a aVar = new j.l.c.c.d.a("MSG_DYNAMIC_MODULE_EXPOSURE");
        aVar.c = new int[]{view.getLeft(), view.getTop()};
        aVar.i = dSLBean;
        e eVar = channelDynamicAdapter.i;
        if (eVar != null) {
            eVar.V(aVar);
        }
    }

    @Override // com.hunantv.oversea.channel.dynamic.common.DynamicAdapter
    public boolean g() {
        e eVar = this.i;
        return eVar != null && eVar.n0();
    }

    @Override // com.hunantv.oversea.channel.dynamic.common.DynamicAdapter
    /* renamed from: k */
    public void onBindViewHolder(@NonNull DynamicAdapter.a aVar, int i, @NonNull List<Object> list) {
        ModuleData.DataBean.DSLBean dSLBean;
        super.onBindViewHolder(aVar, i, list);
        List<ModuleData.DataBean.DSLBean> list2 = this.c;
        if (list2 == null || i >= list2.size() || (dSLBean = this.c.get(i)) == null) {
            return;
        }
        ((RecyclerView.ViewHolder) aVar).itemView.post(new a(aVar, dSLBean));
    }

    @WithTryCatchRuntime
    public void onLinkageScrollIdle() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, r.a.c.c.e.v(n, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void onLinkageScrolled(int i, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.e(new Object[]{this, r.a.c.b.e.k(i), r.a.c.b.e.k(i2), r.a.c.c.e.x(m, this, this, r.a.c.b.e.k(i), r.a.c.b.e.k(i2))}).e(69648));
    }

    @Override // com.hunantv.oversea.channel.dynamic.common.DynamicAdapter
    @WithTryCatchRuntime
    public void rendWithData(View view, ModuleData.DataBean.DSLBean dSLBean, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.c(new Object[]{this, view, dSLBean, r.a.c.b.e.k(i), r.a.c.c.e.y(k, this, this, new Object[]{view, dSLBean, r.a.c.b.e.k(i)})}).e(69648));
    }
}
