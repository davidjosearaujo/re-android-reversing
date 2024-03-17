package com.hunantv.oversea.me.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.hunantv.oversea.me.data.CardData;
import com.hunantv.oversea.me.view.main.PlayHistoryCardView;
import com.hunantv.oversea.me.view.main.UserHeadCardView;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.j0;
import j.l.c.k.d.k;
import j.l.c.k.d.l;
import j.l.c.k.d.m;
import j.l.c.k.d.n;
import j.l.c.k.d.o;
import j.l.c.k.n.d.e;
import j.l.c.k.n.d.f;
import j.l.c.k.n.d.g;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MainMeAdapter extends RecyclerView.Adapter<a> {
    public static final int g = -1;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private static final /* synthetic */ c.b j = null;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private final Context a;
    private final LifecycleOwner b;
    private final List<CardData.CardDataBean> c = new ArrayList();
    private int d = -1;
    private int e = -1;
    private boolean f;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends RecyclerView.ViewHolder {
        private e a;

        public a(e eVar) {
            super(eVar.c());
            this.a = eVar;
        }

        public e z() {
            return this.a;
        }
    }

    static {
        f();
    }

    public MainMeAdapter(Context context, LifecycleOwner lifecycleOwner) {
        this.a = context;
        this.b = lifecycleOwner;
    }

    private static /* synthetic */ void f() {
        r.a.c.c.e eVar = new r.a.c.c.e("MainMeAdapter.java", MainMeAdapter.class);
        h = eVar.H("method-execution", eVar.E("1", "onCreateViewHolder", "com.hunantv.oversea.me.adapter.MainMeAdapter", "android.view.ViewGroup:int", "parent:viewType", "", "com.hunantv.oversea.me.adapter.MainMeAdapter$MeViewHolder"), 56);
        i = eVar.H("method-execution", eVar.E("1", "onBindViewHolder", "com.hunantv.oversea.me.adapter.MainMeAdapter", "com.hunantv.oversea.me.adapter.MainMeAdapter$MeViewHolder:int", "holder:position", "", "void"), 62);
        j = eVar.H("method-execution", eVar.E("1", "onBindViewHolder", "com.hunantv.oversea.me.adapter.MainMeAdapter", "com.hunantv.oversea.me.adapter.MainMeAdapter$MeViewHolder:int:java.util.List", "holder:position:payloads", "", "void"), 83);
        k = eVar.H("method-execution", eVar.E("1", "getItemViewType", "com.hunantv.oversea.me.adapter.MainMeAdapter", "int", "position", "", "int"), 100);
        l = eVar.H("method-execution", eVar.E("1", "update", "com.hunantv.oversea.me.adapter.MainMeAdapter", "java.util.List", "cardDataBeans", "", "void"), 110);
    }

    public static final /* synthetic */ int h(MainMeAdapter mainMeAdapter, int i2, c cVar) {
        if (i2 >= mainMeAdapter.getItemCount()) {
            return f.b((CardData.CardDataBean) null);
        }
        return f.b(mainMeAdapter.c.get(i2));
    }

    public static final /* synthetic */ void k(MainMeAdapter mainMeAdapter, a aVar, int i2, c cVar) {
        if (i2 >= mainMeAdapter.getItemCount()) {
            return;
        }
        e z = aVar.z();
        z.c = mainMeAdapter.f;
        z.e(mainMeAdapter.c.get(i2));
        if (z instanceof UserHeadCardView) {
            mainMeAdapter.d = i2;
        }
        if (z instanceof PlayHistoryCardView) {
            mainMeAdapter.e = i2;
        }
        if (mainMeAdapter.getItemViewType(i2) == 6 && (z instanceof g)) {
            z.c().getLayoutParams().height = j0.b(mainMeAdapter.a, 20.0f);
        }
    }

    public static final /* synthetic */ void l(MainMeAdapter mainMeAdapter, a aVar, int i2, List list, c cVar) {
        if (list.size() > 0) {
            if ((list.get(0) instanceof UserHeadCardView.a) && (aVar.a instanceof UserHeadCardView)) {
                ((UserHeadCardView) aVar.a).j(list);
                return;
            }
            return;
        }
        super.onBindViewHolder(aVar, i2, list);
    }

    public static final /* synthetic */ a m(MainMeAdapter mainMeAdapter, ViewGroup viewGroup, int i2, c cVar) {
        return new a(f.a(mainMeAdapter.a, i2, mainMeAdapter.b));
    }

    public static final /* synthetic */ void o(MainMeAdapter mainMeAdapter, List list, c cVar) {
        if (list == null) {
            return;
        }
        mainMeAdapter.e = -1;
        mainMeAdapter.d = -1;
        mainMeAdapter.c.clear();
        mainMeAdapter.c.addAll(list);
        mainMeAdapter.notifyDataSetChanged();
    }

    @NonNull
    public List<CardData.CardDataBean> g() {
        return this.c;
    }

    public int getItemCount() {
        return this.c.size();
    }

    @WithTryCatchRuntime
    public int getItemViewType(int i2) {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(k, this, this, r.a.c.b.e.k(i2))}).e(69648)));
    }

    public int i() {
        return this.e;
    }

    public int j() {
        return this.d;
    }

    public void n(boolean z) {
        this.f = z;
    }

    @WithTryCatchRuntime
    public void update(List<CardData.CardDataBean> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o(new Object[]{this, list, r.a.c.c.e.w(l, this, this, list)}).e(69648));
    }

    @WithTryCatchRuntime
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2, @NonNull List list) {
        onBindViewHolder((a) viewHolder, i2, (List<Object>) list);
    }

    @NonNull
    @WithTryCatchRuntime
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return (a) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{this, viewGroup, r.a.c.b.e.k(i2), r.a.c.c.e.x(h, this, this, viewGroup, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    public void onBindViewHolder(@NonNull a aVar, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{this, aVar, r.a.c.b.e.k(i2), r.a.c.c.e.x(i, this, this, aVar, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    public void onBindViewHolder(@NonNull a aVar, int i2, @NonNull List<Object> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new m(new Object[]{this, aVar, r.a.c.b.e.k(i2), list, r.a.c.c.e.y(j, this, this, new Object[]{aVar, r.a.c.b.e.k(i2), list})}).e(69648));
    }
}
