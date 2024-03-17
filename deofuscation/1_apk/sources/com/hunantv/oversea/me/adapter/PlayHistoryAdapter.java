package com.hunantv.oversea.me.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.hunantv.mpdt.data.EventClickData;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.w.a;
import j.l.c.k.c;
import j.l.c.k.d.w;
import j.l.c.k.d.x;
import j.l.c.k.d.y;
import j.l.c.k.d.z;
import j.l.c.k.e.k;
import j.l.c.k.m.j;
import j.l.c.k.m.m;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PlayHistoryAdapter extends j.l.a.w.a<k> {
    private static final /* synthetic */ c.b f = null;
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private int e;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ RecyclerView.ViewHolder b;

        public a(int i, RecyclerView.ViewHolder viewHolder) {
            this.a = i;
            this.b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayHistoryAdapter.this.p() != null) {
                m.a(String.valueOf(this.a));
                PlayHistoryAdapter.this.p().onItemClick(view, this.b.getAdapterPosition());
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class b extends a.a {
        public ImageView a;
        public TextView b;
        public View c;
        public TextView d;
        public TextView e;
        public ImageView f;

        public b(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(c.j.ivImage);
            this.b = (TextView) view.findViewById(c.j.tvCorner);
            this.c = view.findViewById(c.j.coverView);
            this.d = (TextView) view.findViewById(c.j.tvTitle);
            this.e = (TextView) view.findViewById(c.j.tvUpdateTip);
            this.f = (ImageView) view.findViewById(c.j.ivLocalHistory);
        }
    }

    static {
        B();
    }

    public PlayHistoryAdapter(@NonNull Context context) {
        super(context, new ArrayList());
        this.e = context.getResources().getDimensionPixelSize(c.g.dp_16);
        m.g();
    }

    private static /* synthetic */ void B() {
        e eVar = new e("PlayHistoryAdapter.java", PlayHistoryAdapter.class);
        f = eVar.H("method-execution", eVar.E("1", "onCreateViewHolder", "com.hunantv.oversea.me.adapter.PlayHistoryAdapter", "android.view.ViewGroup:int", "parent:viewType", "", "androidx.recyclerview.widget.RecyclerView$ViewHolder"), 51);
        g = eVar.H("method-execution", eVar.E("1", "onBindViewHolder", "com.hunantv.oversea.me.adapter.PlayHistoryAdapter", "androidx.recyclerview.widget.RecyclerView$ViewHolder:int", "holder:position", "", "void"), 58);
        h = eVar.H("method-execution", eVar.E("2", "displayLocalDownloadIcon", "com.hunantv.oversea.me.adapter.PlayHistoryAdapter", "com.hunantv.oversea.me.data.PlayHistoryBean:android.widget.ImageView", "entity:ivLocalHistory", "", "void"), (int) EventClickData.u.t1);
        i = eVar.H("method-execution", eVar.E("1", "updateData", "com.hunantv.oversea.me.adapter.PlayHistoryAdapter", "java.util.List", "list", "", "void"), (int) EventClickData.u.L0);
    }

    public static final /* synthetic */ void C(PlayHistoryAdapter playHistoryAdapter, k kVar, ImageView imageView, r.a.b.c cVar) {
    }

    public static final /* synthetic */ void D(PlayHistoryAdapter playHistoryAdapter, RecyclerView.ViewHolder viewHolder, int i2, r.a.b.c cVar) {
        k kVar;
        Context l = playHistoryAdapter.l();
        if (l == null || (kVar = (k) playHistoryAdapter.getItem(i2)) == null) {
            return;
        }
        b bVar = (b) viewHolder;
        playHistoryAdapter.F(viewHolder.itemView, i2 == 0 ? playHistoryAdapter.e : 0);
        if (TextUtils.isEmpty(kVar.o)) {
            bVar.a.setImageResource(c.h.shape_placeholder);
        } else {
            j.v.h.e.w(bVar.a, kVar.o);
        }
        bVar.d.setText(kVar.p);
        String f2 = m.f(kVar.f, kVar.h, kVar.j, kVar.k);
        if (f2 != null && kVar.g == 1) {
            bVar.b.setText(f2);
            j.g(bVar.b, 0);
        } else {
            j.g(bVar.b, 8);
        }
        if (kVar.l) {
            j.g(bVar.c, 8);
        } else {
            j.g(bVar.c, 0);
            ((RecyclerView.ViewHolder) bVar).itemView.setOnClickListener(null);
        }
        if (kVar.i) {
            if (m.c(String.valueOf(kVar.a))) {
                j.g(bVar.e, 8);
            } else {
                j.g(bVar.e, 0);
            }
        } else {
            j.g(bVar.e, 8);
        }
        bVar.d.setTextColor(ContextCompat.getColor(l, c.f.skin_color_text_minor));
        bVar.f.setVisibility(8);
        playHistoryAdapter.displayLocalDownloadIcon(kVar, bVar.f);
        viewHolder.itemView.setOnClickListener(new a(kVar.a, viewHolder));
    }

    public static final /* synthetic */ RecyclerView.ViewHolder E(PlayHistoryAdapter playHistoryAdapter, ViewGroup viewGroup, int i2, r.a.b.c cVar) {
        return new b(LayoutInflater.from(playHistoryAdapter.l() == null ? j.l.a.a.a() : playHistoryAdapter.l()).inflate(c.m.me_item_play_history, viewGroup, false));
    }

    private void F(@Nullable View view, int i2) {
        if (view == null) {
            return;
        }
        view.setPadding(i2, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final /* synthetic */ void G(PlayHistoryAdapter playHistoryAdapter, List list, r.a.b.c cVar) {
        List o = playHistoryAdapter.o();
        if (o != null) {
            o.clear();
            o.addAll(list);
        }
        playHistoryAdapter.notifyDataSetChanged();
    }

    @WithTryCatchRuntime
    private void displayLocalDownloadIcon(k kVar, ImageView imageView) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new y(new Object[]{this, kVar, imageView, e.x(h, this, this, kVar, imageView)}).e(69648));
    }

    @WithTryCatchRuntime
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new x(new Object[]{this, viewHolder, r.a.c.b.e.k(i2), e.x(g, this, this, viewHolder, r.a.c.b.e.k(i2))}).e(69648));
    }

    @NonNull
    @WithTryCatchRuntime
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return (RecyclerView.ViewHolder) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new w(new Object[]{this, viewGroup, r.a.c.b.e.k(i2), e.x(f, this, this, viewGroup, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    public void updateData(List<k> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new z(new Object[]{this, list, e.w(i, this, this, list)}).e(69648));
    }
}
