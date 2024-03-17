package com.hunantv.oversea.me.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.k.c;
import j.l.c.k.d.q;
import j.l.c.k.d.t;
import j.l.c.k.e.l;
import j.l.c.k.m.j;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MePushSettingAdapter extends j.l.a.w.a<l> {
    private static final /* synthetic */ c.b e = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ l a;
        public final /* synthetic */ RecyclerView.ViewHolder b;

        public a(l lVar, RecyclerView.ViewHolder viewHolder) {
            this.a = lVar;
            this.b = viewHolder;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.a.a() != 10) {
                this.a.g(z);
            }
            if (MePushSettingAdapter.this.p() != null) {
                MePushSettingAdapter.this.p().onItemClick(compoundButton, this.b.getAdapterPosition());
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ RecyclerView.ViewHolder a;

        public b(RecyclerView.ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int adapterPosition = this.a.getAdapterPosition();
            if (MePushSettingAdapter.this.p() != null) {
                MePushSettingAdapter.this.p().onItemClick(view, adapterPosition);
            }
        }
    }

    static {
        D();
    }

    public MePushSettingAdapter(@Nullable Context context) {
        super(context);
    }

    private static /* synthetic */ void D() {
        e eVar = new e("MePushSettingAdapter.java", MePushSettingAdapter.class);
        e = eVar.H("method-execution", eVar.E("1", "onBindViewHolder", "com.hunantv.oversea.me.adapter.MePushSettingAdapter", "androidx.recyclerview.widget.RecyclerView$ViewHolder:int", "holder:position", "", "void"), 62);
    }

    public static final /* synthetic */ void E(MePushSettingAdapter mePushSettingAdapter, RecyclerView.ViewHolder viewHolder, int i, c cVar) {
        l lVar;
        if (mePushSettingAdapter.l() == null || (lVar = (l) mePushSettingAdapter.getItem(i)) == null) {
            return;
        }
        int b2 = lVar.b();
        if (b2 == 1) {
            q.e eVar = (q.e) viewHolder;
            eVar.a.setTextSize(0, j.c().getResources().getDimension(c.g.dp_13));
            eVar.a.setText(lVar.d());
        } else if (b2 == 2) {
            q.d dVar = (q.d) viewHolder;
            dVar.a.setText(lVar.d());
            String c = lVar.c();
            if (TextUtils.isEmpty(c)) {
                j.g(dVar.b, 8);
            } else {
                j.g(dVar.b, 0);
                dVar.b.setText(c);
            }
            dVar.c.setOnCheckedChangeListener(null);
            dVar.c.setChecked(lVar.e());
            if (lVar.a() == 10 && lVar.e()) {
                dVar.c.setClickable(false);
            } else {
                dVar.c.setOnCheckedChangeListener(new a(lVar, viewHolder));
            }
        } else if (b2 != 3) {
            if (b2 != 6) {
                return;
            }
            q.e eVar2 = (q.e) viewHolder;
            eVar2.a.setTextSize(0, j.c().getResources().getDimension(c.g.dp_10));
            eVar2.a.setText(lVar.d());
        } else {
            q.c cVar2 = (q.c) viewHolder;
            cVar2.a.setText(lVar.d());
            String c2 = lVar.c();
            if (TextUtils.isEmpty(c2)) {
                j.g(cVar2.b, 8);
            } else {
                j.g(cVar2.b, 0);
                cVar2.b.setText(c2);
            }
            ((RecyclerView.ViewHolder) cVar2).itemView.setOnClickListener(new b(viewHolder));
        }
    }

    public int getItemViewType(int i) {
        l lVar = (l) getItem(i);
        if (lVar == null) {
            return 0;
        }
        return lVar.b();
    }

    @WithTryCatchRuntime
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new t(new Object[]{this, viewHolder, r.a.c.b.e.k(i), e.x(e, this, this, viewHolder, r.a.c.b.e.k(i))}).e(69648));
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context l = l();
        if (l == null) {
            return null;
        }
        if (i != 1) {
            if (i == 2) {
                return new q.d(l, viewGroup);
            }
            if (i == 3) {
                return new q.c(l, viewGroup, true);
            }
            if (i == 5) {
                return new q.i(l, viewGroup, 0);
            }
            if (i != 6) {
                return null;
            }
        }
        return new q.e(l, viewGroup);
    }
}
