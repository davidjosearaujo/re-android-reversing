package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.i;
import java.util.Calendar;
import java.util.WeakHashMap;
import p1.k0;
import p1.x;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class y extends RecyclerView.d<a> {

    /* renamed from: d */
    public final a f3138d;
    public final d<?> e;

    /* renamed from: f */
    public final f f3139f;

    /* renamed from: g */
    public final i.e f3140g;

    /* renamed from: h */
    public final int f3141h;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends RecyclerView.a0 {

        /* renamed from: u */
        public final TextView f3142u;

        /* renamed from: v */
        public final MaterialCalendarGridView f3143v;

        public a(LinearLayout linearLayout, boolean z6) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(2131296627);
            this.f3142u = textView;
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            new x().e(textView, Boolean.TRUE);
            this.f3143v = (MaterialCalendarGridView) linearLayout.findViewById(2131296622);
            if (!z6) {
                textView.setVisibility(8);
            }
        }
    }

    public y(ContextThemeWrapper contextThemeWrapper, d dVar, a aVar, f fVar, i.d dVar2) {
        v vVar = aVar.f3036f;
        v vVar2 = aVar.f3037g;
        v vVar3 = aVar.f3039i;
        if (vVar.f3122f.compareTo(vVar3.f3122f) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (vVar3.f3122f.compareTo(vVar2.f3122f) <= 0) {
            int i7 = w.f3129l;
            int i8 = i.f3075k0;
            this.f3141h = (contextThemeWrapper.getResources().getDimensionPixelSize(2131100275) * i7) + (r.W(contextThemeWrapper) ? contextThemeWrapper.getResources().getDimensionPixelSize(2131100275) : 0);
            this.f3138d = aVar;
            this.e = dVar;
            this.f3139f = fVar;
            this.f3140g = dVar2;
            if (!this.f2022a.a()) {
                this.f2023b = true;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final int a() {
        return this.f3138d.f3042l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final long b(int i7) {
        Calendar c7 = e0.c(this.f3138d.f3036f.f3122f);
        c7.add(2, i7);
        return new v(c7).f3122f.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final void d(a aVar, int i7) {
        a aVar2 = aVar;
        Calendar c7 = e0.c(this.f3138d.f3036f.f3122f);
        c7.add(2, i7);
        v vVar = new v(c7);
        aVar2.f3142u.setText(vVar.j());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar2.f3143v.findViewById(2131296622);
        if (materialCalendarGridView.getAdapter() == null || !vVar.equals(materialCalendarGridView.getAdapter().f3130f)) {
            w wVar = new w(vVar, this.e, this.f3138d, this.f3139f);
            materialCalendarGridView.setNumColumns(vVar.f3125i);
            materialCalendarGridView.setAdapter((ListAdapter) wVar);
        } else {
            materialCalendarGridView.invalidate();
            w a7 = materialCalendarGridView.getAdapter();
            for (Long l6 : a7.f3132h) {
                a7.e(materialCalendarGridView, l6.longValue());
            }
            d<?> dVar = a7.f3131g;
            if (dVar != null) {
                for (Long l7 : dVar.k()) {
                    a7.e(materialCalendarGridView, l7.longValue());
                }
                a7.f3132h = a7.f3131g.k();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new x(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final RecyclerView.a0 e(RecyclerView recyclerView) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(recyclerView.getContext()).inflate(2131492954, (ViewGroup) recyclerView, false);
        if (!r.W(recyclerView.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.m(-1, this.f3141h));
        return new a(linearLayout, true);
    }
}
