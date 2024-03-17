package com.hunantv.oversea.me.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.k.d.q;
import j.l.c.k.m.j;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class AccountSecurityAdapter extends j.l.a.w.a<j.l.c.k.e.a> {
    private static final /* synthetic */ c.b e = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ RecyclerView.ViewHolder a;

        public a(RecyclerView.ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AccountSecurityAdapter.this.p() != null) {
                AccountSecurityAdapter.this.p().onItemClick(view, this.a.getAdapterPosition());
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ j.l.c.k.e.b a;
        public final /* synthetic */ RecyclerView.ViewHolder b;

        public b(j.l.c.k.e.b bVar, RecyclerView.ViewHolder viewHolder) {
            this.a = bVar;
            this.b = viewHolder;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.a.e = z;
            if (AccountSecurityAdapter.this.p() != null) {
                AccountSecurityAdapter.this.p().onItemClick(compoundButton, this.b.getAdapterPosition());
            }
        }
    }

    static {
        D();
    }

    public AccountSecurityAdapter(@Nullable Context context) {
        super(context);
    }

    private static /* synthetic */ void D() {
        e eVar = new e("AccountSecurityAdapter.java", AccountSecurityAdapter.class);
        e = eVar.H("method-execution", eVar.E("1", "onBindViewHolder", "com.hunantv.oversea.me.adapter.AccountSecurityAdapter", "androidx.recyclerview.widget.RecyclerView$ViewHolder:int", "holder:position", "", "void"), 72);
    }

    public static final /* synthetic */ void E(AccountSecurityAdapter accountSecurityAdapter, RecyclerView.ViewHolder viewHolder, int i, c cVar) {
        j.l.c.k.e.b bVar;
        if (accountSecurityAdapter.l() == null || (bVar = (j.l.c.k.e.a) accountSecurityAdapter.getItem(i)) == null) {
            return;
        }
        int b2 = bVar.b();
        if (3 != b2) {
            if (4 == b2) {
                j.l.c.k.e.b bVar2 = bVar;
                q.d dVar = (q.d) viewHolder;
                dVar.a.setText(bVar2.d());
                j.g(dVar.b, 8);
                dVar.c.setOnCheckedChangeListener(null);
                dVar.c.setChecked(bVar2.e);
                dVar.c.setOnCheckedChangeListener(new b(bVar2, viewHolder));
                return;
            }
            return;
        }
        q.c cVar2 = (q.c) viewHolder;
        j.l.c.k.e.b bVar3 = bVar;
        cVar2.a.setText(bVar3.d());
        j.g(cVar2.d, bVar3.e() ? 0 : 4);
        String c = bVar3.c();
        if (TextUtils.isEmpty(c)) {
            cVar2.b.setVisibility(8);
        } else {
            cVar2.b.setVisibility(0);
            cVar2.b.setText(c);
        }
        ((RecyclerView.ViewHolder) cVar2).itemView.setOnClickListener(new a(viewHolder));
    }

    public void F(int i, @Nullable String str, @Nullable String str2) {
        List o = o();
        if (o == null || o.isEmpty()) {
            return;
        }
        int size = o.size();
        j.l.c.k.e.a aVar = null;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            j.l.c.k.e.a aVar2 = (j.l.c.k.e.a) o.get(i3);
            if (i == aVar2.a()) {
                i2 = i3;
                aVar = aVar2;
                break;
            }
            i3++;
        }
        if (aVar != null && 3 == aVar.b()) {
            j.l.c.k.e.b bVar = (j.l.c.k.e.b) aVar;
            bVar.h(str);
            bVar.g(str2);
            notifyItemChanged(i2);
        }
    }

    public void destroy() {
        List<j.l.c.k.e.a> o = o();
        if (o != null && !o.isEmpty()) {
            for (j.l.c.k.e.a aVar : o) {
                aVar.destroy();
            }
        }
        super.destroy();
    }

    public int getItemViewType(int i) {
        j.l.c.k.e.a aVar = (j.l.c.k.e.a) getItem(i);
        if (aVar == null) {
            return 0;
        }
        return aVar.b();
    }

    @WithTryCatchRuntime
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.d.j(new Object[]{this, viewHolder, r.a.c.b.e.k(i), e.x(e, this, this, viewHolder, r.a.c.b.e.k(i))}).e(69648));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context l = l();
        if (l == null) {
            return null;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return new q.d(l, viewGroup);
                }
                return new q.c(l, viewGroup);
            }
            return new q.g(l, viewGroup);
        }
        return new q.i(l, viewGroup, 0);
    }
}
