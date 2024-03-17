package com.hunantv.oversea.me.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.asm.Opcodes;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.v;
import j.l.c.b0.e;
import j.l.c.k.c;
import j.l.c.k.d.d;
import j.l.c.k.d.f;
import j.l.c.k.d.g;
import j.l.c.k.d.q;
import j.l.c.k.d.u;
import j.l.c.k.e.h;
import java.util.Iterator;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class MeSettingAdapter extends j.l.a.w.a<h> {
    private static final /* synthetic */ c.b j = null;
    private b e;
    @Nullable
    private a f;
    @Nullable
    private Drawable g;
    private boolean h;
    private boolean i;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class a extends e<MeSettingAdapter> {
        private static final int b = 1;

        public a(MeSettingAdapter meSettingAdapter) {
            super(meSettingAdapter);
        }

        /* renamed from: d */
        public void c(@NonNull MeSettingAdapter meSettingAdapter, @NonNull Message message) {
            if (message.what != 1) {
                return;
            }
            meSettingAdapter.D((View) message.obj, message.arg1);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface b {
        void onSettingItemClick(View view, @Nullable h hVar, int i);
    }

    static {
        A();
    }

    public MeSettingAdapter(Context context) {
        super(context);
        this.f = new a(this);
    }

    private static /* synthetic */ void A() {
        r.a.c.c.e eVar = new r.a.c.c.e("MeSettingAdapter.java", MeSettingAdapter.class);
        j = eVar.H("method-execution", eVar.E("1", "onBindViewHolder", "com.hunantv.oversea.me.adapter.MeSettingAdapter", "androidx.recyclerview.widget.RecyclerView$ViewHolder:int", "holder:position", "", "void"), (int) Opcodes.GOTO);
    }

    @Nullable
    private Drawable C() {
        if (this.g == null) {
            Context l = l();
            if (l == null) {
                return null;
            }
            int color = ContextCompat.getColor(l, c.f.color_F06000);
            this.g = new ShapeDrawable(new j.l.a.c0.m.e().f(false).e(color).h(l.getResources().getDimensionPixelSize(c.g.dp_10)));
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(@Nullable View view, int i) {
        if (view == null || i >= 6) {
            return;
        }
        int i2 = i + 1;
        view.setVisibility(i % 2 == 0 ? 0 : 8);
        StringBuilder sb = new StringBuilder();
        sb.append("是否可见：");
        sb.append(view.getVisibility() == 0);
        v.c("MeSettingAdapter", sb.toString());
        if (i2 >= 6) {
            return;
        }
        Message obtainMessage = this.f.obtainMessage(1);
        obtainMessage.obj = view;
        obtainMessage.arg1 = i2;
        this.f.sendMessageDelayed(obtainMessage, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F(h hVar, q.d dVar, CompoundButton compoundButton, boolean z) {
        hVar.k(z);
        b bVar = this.e;
        if (bVar != null) {
            bVar.onSettingItemClick(((RecyclerView.ViewHolder) dVar).itemView, (h) getItem(dVar.getAdapterPosition()), dVar.getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void H(q.d dVar, CompoundButton compoundButton, boolean z) {
        h hVar = (h) getItem(dVar.getAdapterPosition());
        if (hVar != null) {
            hVar.k(z);
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.onSettingItemClick(((RecyclerView.ViewHolder) dVar).itemView, (h) getItem(dVar.getAdapterPosition()), dVar.getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void J(q.c cVar, View view) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.onSettingItemClick(((RecyclerView.ViewHolder) cVar).itemView, (h) getItem(cVar.getAdapterPosition()), cVar.getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void L(q.b bVar, View view) {
        b bVar2 = this.e;
        if (bVar2 != null) {
            bVar2.onSettingItemClick(((RecyclerView.ViewHolder) bVar).itemView, (h) getItem(bVar.getAdapterPosition()), bVar.getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ void N(q.f fVar, View view) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.onSettingItemClick(((RecyclerView.ViewHolder) fVar).itemView, (h) getItem(fVar.getAdapterPosition()), fVar.getAdapterPosition());
        }
    }

    public static final /* synthetic */ void O(MeSettingAdapter meSettingAdapter, RecyclerView.ViewHolder viewHolder, int i, r.a.b.c cVar) {
        h hVar;
        Context l = meSettingAdapter.l();
        if (l == null || (hVar = (h) meSettingAdapter.getItem(i)) == null) {
            return;
        }
        int b2 = hVar.b();
        if (b2 == 1) {
            ((q.e) viewHolder).a.setText(hVar.d());
            return;
        }
        if (b2 != 2) {
            if (b2 != 3) {
                if (b2 == 4) {
                    ((q.b) viewHolder).a.setText(hVar.d());
                    return;
                } else if (b2 != 6) {
                    return;
                } else {
                    q.f fVar = (q.f) viewHolder;
                    fVar.a.setText(hVar.d());
                    fVar.z(hVar.e());
                    return;
                }
            }
            q.c cVar2 = (q.c) viewHolder;
            cVar2.a.setText(hVar.d());
            String c = hVar.c();
            if (TextUtils.isEmpty(c)) {
                cVar2.b.setVisibility(8);
            } else {
                cVar2.b.setVisibility(0);
                cVar2.b.setText(c);
                cVar2.b.setTextColor(ContextCompat.getColor(l, hVar.f() ? c.f.color_F06000 : c.f.color_888888));
            }
            cVar2.c.setVisibility(hVar.e() ? 0 : 8);
            return;
        }
        q.d dVar = (q.d) viewHolder;
        dVar.a.setText(hVar.d());
        String c2 = hVar.c();
        if (TextUtils.isEmpty(c2)) {
            dVar.b.setVisibility(8);
        } else {
            dVar.b.setVisibility(0);
            dVar.b.setText(c2);
        }
        dVar.c.setOnCheckedChangeListener(null);
        dVar.c.setChecked(hVar.g());
        dVar.c.setOnCheckedChangeListener(new g(meSettingAdapter, hVar, dVar));
        if (21 == hVar.a() && meSettingAdapter.i) {
            meSettingAdapter.i = false;
            dVar.d.setBackgroundDrawable(meSettingAdapter.C());
            e eVar = meSettingAdapter.f;
            if (eVar != null) {
                Message obtainMessage = eVar.obtainMessage(1);
                obtainMessage.obj = dVar.d;
                obtainMessage.arg1 = 0;
                meSettingAdapter.f.sendMessage(obtainMessage);
            }
        } else if (51 == hVar.a() && meSettingAdapter.h) {
            meSettingAdapter.h = false;
            dVar.d.setBackgroundDrawable(meSettingAdapter.C());
            e eVar2 = meSettingAdapter.f;
            if (eVar2 != null) {
                Message obtainMessage2 = eVar2.obtainMessage(1);
                obtainMessage2.obj = dVar.d;
                obtainMessage2.arg1 = 0;
                meSettingAdapter.f.sendMessage(obtainMessage2);
            }
        } else {
            dVar.d.setVisibility(8);
        }
    }

    public h B(byte b2) {
        if (s()) {
            return null;
        }
        for (h hVar : o()) {
            if (hVar.a() == b2) {
                return hVar;
            }
        }
        return null;
    }

    public boolean P(byte b2) {
        if (s()) {
            return false;
        }
        Iterator it = o().iterator();
        while (it.hasNext()) {
            if (((h) it.next()).a() == b2) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public void Q(b bVar) {
        this.e = bVar;
    }

    public void R() {
        this.h = true;
    }

    public void S() {
        this.i = true;
    }

    public void destroy() {
        this.g = null;
        super.destroy();
    }

    public int getItemViewType(int i) {
        h hVar = (h) getItem(i);
        if (hVar == null) {
            return 0;
        }
        return hVar.b();
    }

    @WithTryCatchRuntime
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new u(new Object[]{this, viewHolder, r.a.c.b.e.k(i), r.a.c.c.e.x(j, this, this, viewHolder, r.a.c.b.e.k(i))}).e(69648));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context l = l();
        if (l == null) {
            return null;
        }
        switch (i) {
            case 1:
                return new q.e(l, viewGroup);
            case 2:
                q.d dVar = new q.d(l, viewGroup);
                dVar.c.setOnCheckedChangeListener(null);
                dVar.c.setOnCheckedChangeListener(new d(this, dVar));
                return dVar;
            case 3:
                q.c cVar = new q.c(l, viewGroup, true);
                ((RecyclerView.ViewHolder) cVar).itemView.setOnClickListener(new j.l.c.k.d.h(this, cVar));
                return cVar;
            case 4:
                q.b bVar = new q.b(LayoutInflater.from(l).inflate(c.m.me_item_setting_list_button, viewGroup, false));
                ((RecyclerView.ViewHolder) bVar).itemView.setOnClickListener(new j.l.c.k.d.e(this, bVar));
                return bVar;
            case 5:
                return new q.i(l, viewGroup, 0);
            case 6:
                q.f fVar = new q.f(l, viewGroup);
                ((RecyclerView.ViewHolder) fVar).itemView.setOnClickListener(new f(this, fVar));
                return fVar;
            default:
                return null;
        }
    }
}
