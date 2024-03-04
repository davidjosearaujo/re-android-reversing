package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public final class g extends BaseAdapter {

    /* renamed from: f */
    public final Calendar f3068f;

    /* renamed from: g */
    public final int f3069g;

    /* renamed from: h */
    public final int f3070h;

    public g() {
        Calendar e = e0.e(null);
        this.f3068f = e;
        this.f3069g = e.getMaximum(7);
        this.f3070h = e.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3069g;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i7) {
        int i8 = this.f3069g;
        if (i7 >= i8) {
            return null;
        }
        int i9 = i7 + this.f3070h;
        if (i9 > i8) {
            i9 -= i8;
        }
        return Integer.valueOf(i9);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i7) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public final View getView(int i7, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2131492950, viewGroup, false);
        }
        Calendar calendar = this.f3068f;
        int i8 = i7 + this.f3070h;
        int i9 = this.f3069g;
        if (i8 > i9) {
            i8 -= i9;
        }
        calendar.set(7, i8);
        textView.setText(this.f3068f.getDisplayName(7, 4, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(2131820678), this.f3068f.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public g(int i7) {
        Calendar e = e0.e(null);
        this.f3068f = e;
        this.f3069g = e.getMaximum(7);
        this.f3070h = i7;
    }
}
