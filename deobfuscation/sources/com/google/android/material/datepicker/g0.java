package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public final class g0 extends RecyclerView.d<a> {

    /* renamed from: d */
    public final i<?> f3071d;

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.a0 {

        /* renamed from: u */
        public final TextView f3072u;

        public a(TextView textView) {
            super(textView);
            this.f3072u = textView;
        }
    }

    public g0(i<?> iVar) {
        this.f3071d = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final int a() {
        return this.f3071d.Z.f3041k;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final void d(a aVar, int i7) {
        a aVar2 = aVar;
        int i8 = this.f3071d.Z.f3036f.f3124h + i7;
        aVar2.f3072u.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i8)));
        TextView textView = aVar2.f3072u;
        Context context = textView.getContext();
        textView.setContentDescription(e0.d().get(1) == i8 ? String.format(context.getString(2131820684), Integer.valueOf(i8)) : String.format(context.getString(2131820685), Integer.valueOf(i8)));
        c cVar = this.f3071d.f3079d0;
        Calendar d7 = e0.d();
        b bVar = d7.get(1) == i8 ? cVar.f3058f : cVar.f3057d;
        for (Long l6 : this.f3071d.Y.k()) {
            d7.setTimeInMillis(l6.longValue());
            if (d7.get(1) == i8) {
                bVar = cVar.e;
            }
        }
        bVar.b(aVar2.f3072u);
        aVar2.f3072u.setOnClickListener(new f0(this, i8));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final RecyclerView.a0 e(RecyclerView recyclerView) {
        return new a((TextView) LayoutInflater.from(recyclerView.getContext()).inflate(2131492958, (ViewGroup) recyclerView, false));
    }
}
