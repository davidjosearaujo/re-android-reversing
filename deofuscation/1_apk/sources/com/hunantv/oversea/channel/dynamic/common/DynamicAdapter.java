package com.hunantv.oversea.channel.dynamic.common;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.yoga.android.YogaLayout;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.channel.dynamic.data.ModuleData;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.dynamicview.widget.BackgroundView;
import com.mgtv.dynamicview.widget.MgCardContainer;
import j.l.a.b0.q;
import j.l.c.c.b;
import j.l.c.c.c.s1.e;
import j.v.g.k.d;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicAdapter extends RecyclerView.Adapter<a> {
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    public Activity a;
    public e b;
    public List<ModuleData.DataBean.DSLBean> c;
    private d d;
    private SparseArray<String> e = new SparseArray<>();
    private ModuleData.ChannelBean f;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends RecyclerView.ViewHolder {
        private final SparseArray<View> a;

        public a(View view) {
            super(view);
            this.a = new SparseArray<>();
        }

        public <V extends View> V b(int i) {
            V v = (V) this.a.get(i);
            if (v == null) {
                V v2 = (V) ((RecyclerView.ViewHolder) this).itemView.findViewById(i);
                this.a.put(i, v2);
                return v2;
            }
            return v;
        }
    }

    static {
        f();
    }

    public DynamicAdapter(Activity activity, e eVar, List<ModuleData.DataBean.DSLBean> list) {
        this.a = activity;
        this.b = eVar;
        this.c = list;
    }

    private static /* synthetic */ void f() {
        r.a.c.c.e eVar = new r.a.c.c.e("DynamicAdapter.java", DynamicAdapter.class);
        g = eVar.H("method-execution", eVar.E("4", "rendWithData", "com.hunantv.oversea.channel.dynamic.common.DynamicAdapter", "android.view.View:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean:int", "view:data:position", "", "void"), (int) EventClickData.u.t1);
        h = eVar.H("method-execution", eVar.E("2", "setCardStyle", "com.hunantv.oversea.channel.dynamic.common.DynamicAdapter", "com.mgtv.dynamicview.widget.MgCardContainer:int:int", "itemView:cardFlag:card", "", "void"), (int) Opcodes.IF_ACMPEQ);
    }

    public static final /* synthetic */ void m(DynamicAdapter dynamicAdapter, View view, ModuleData.DataBean.DSLBean dSLBean, int i, c cVar) {
        if (view == null) {
            return;
        }
        j.v.g.k.e eVar = (j.v.g.k.e) view.getTag(b.j.dsl_tag_data_binder);
        if (eVar != null) {
            eVar.rendWithData(view, dSLBean.data, dynamicAdapter.d, i);
        }
        if (view instanceof BackgroundView) {
            j.v.g.k.e eVar2 = (j.v.g.k.e) view.getTag(b.j.dsl_tag_data_binder_background_view);
        }
    }

    public static final /* synthetic */ void n(DynamicAdapter dynamicAdapter, MgCardContainer mgCardContainer, int i, int i2, c cVar) {
        j.v.g.i.d dVar;
        int i3 = 0;
        View childAt = mgCardContainer.getChildAt(0);
        if (childAt == null || (dVar = (j.v.g.i.d) childAt.getTag(b.j.dsl_tag_style)) == null) {
            return;
        }
        if ("1".equals(dVar.k)) {
            i3 = 1;
        } else if ("5".equals(dVar.k)) {
            i3 = 5;
        }
        if (i == 0) {
            i = i3;
        }
        if (i != 0 || i2 == 0) {
            i2 = i;
        }
        if (i2 != 0) {
            mgCardContainer.k0(i2);
        } else {
            mgCardContainer.c0();
        }
    }

    @WithTryCatchRuntime
    private void setCardStyle(MgCardContainer mgCardContainer, int i, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.m1.d(new Object[]{this, mgCardContainer, r.a.c.b.e.k(i), r.a.c.b.e.k(i2), r.a.c.c.e.y(h, this, this, new Object[]{mgCardContainer, r.a.c.b.e.k(i), r.a.c.b.e.k(i2)})}).e(69648));
    }

    public boolean g() {
        return false;
    }

    public int getItemCount() {
        List<ModuleData.DataBean.DSLBean> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long getItemId(int i) {
        return i;
    }

    public int getItemViewType(int i) {
        ModuleData.DataBean.DSLBean dSLBean;
        List<ModuleData.DataBean.DSLBean> list = this.c;
        if (list == null || i >= list.size() || (dSLBean = this.c.get(i)) == null || !dSLBean.isValid()) {
            return 0;
        }
        j.v.g.i.d a2 = this.b.a(dSLBean.DSLID);
        String str = a2 != null ? a2.c : null;
        int hashCode = (dSLBean.DSLID + str).hashCode();
        this.e.put(hashCode, dSLBean.DSLID);
        return hashCode;
    }

    public void h(List<ModuleData.DataBean.DSLBean> list) {
        this.c = list;
        notifyDataSetChanged();
    }

    public void i(List<ModuleData.DataBean.DSLBean> list, boolean z) {
        DiffUtil.calculateDiff(new j.l.c.c.c.m1.e(list, this.c), z).dispatchUpdatesTo(this);
    }

    /* renamed from: j */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        onBindViewHolder(aVar, i, new ArrayList());
    }

    @Override // 
    /* renamed from: k */
    public void onBindViewHolder(@NonNull a aVar, int i, @NonNull List<Object> list) {
        ModuleData.DataBean.DSLBean dSLBean;
        List<ModuleData.DataBean.DSLBean> list2 = this.c;
        if (list2 == null || i >= list2.size() || (dSLBean = this.c.get(i)) == null) {
            return;
        }
        View view = ((RecyclerView.ViewHolder) aVar).itemView;
        if (view instanceof MgCardContainer) {
            setCardStyle((MgCardContainer) view, dSLBean.cardFlag, dSLBean.card);
        }
        View view2 = ((RecyclerView.ViewHolder) aVar).itemView;
        if (view2 instanceof ViewGroup) {
            View childAt = ((ViewGroup) view2).getChildAt(0);
            if (childAt instanceof YogaLayout) {
                YogaLayout yogaLayout = (YogaLayout) childAt;
                yogaLayout.getYogaNode().setHeight(Float.NaN);
                yogaLayout.getYogaNode().setWidth(Float.NaN);
            }
        }
        List<Integer> c = this.b.c(dSLBean.DSLID);
        if (c == null || c.size() == 0) {
            return;
        }
        for (Integer num : c) {
            rendWithData(aVar.b(num.intValue()), dSLBean, i);
        }
    }

    @NonNull
    /* renamed from: l */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View g2 = this.b.g(this.a, this.e.get(i), this.f);
        if (g2 == null) {
            g2 = new View(this.a);
            g2.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, 1));
        }
        if (g()) {
            q.k(g2, true);
        }
        return new a(g2);
    }

    public void o(ModuleData.ChannelBean channelBean) {
        this.f = channelBean;
    }

    public void p(d dVar) {
        this.d = dVar;
    }

    @WithTryCatchRuntime
    public void rendWithData(View view, ModuleData.DataBean.DSLBean dSLBean, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.m1.c(new Object[]{this, view, dSLBean, r.a.c.b.e.k(i), r.a.c.c.e.y(g, this, this, new Object[]{view, dSLBean, r.a.c.b.e.k(i)})}).e(69648));
    }
}
