package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;
import o1.c;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: f */
    public final Calendar f3034f = e0.e(null);

    /* renamed from: g */
    public final boolean f3035g;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (r.W(getContext())) {
            setNextFocusLeftId(2131296369);
            setNextFocusRightId(2131296398);
        }
        this.f3035g = r.X(getContext(), 2130903917);
        y.i(this, new p());
    }

    /* renamed from: a */
    public final w getAdapter() {
        return (w) super.getAdapter();
    }

    public final View b(int i7) {
        return getChildAt(i7 - getFirstVisiblePosition());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w a7 = getAdapter();
        d<?> dVar = a7.f3131g;
        c cVar = a7.f3133i;
        int max = Math.max(a7.b(), getFirstVisiblePosition());
        int min = Math.min((a7.b() + a7.f3130f.f3126j) - 1, getLastVisiblePosition());
        a7.getItem(max);
        a7.getItem(min);
        for (c<Long, Long> cVar2 : dVar.e()) {
            cVar2.getClass();
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z6, int i7, Rect rect) {
        int i8;
        if (z6) {
            if (i7 == 33) {
                w a7 = getAdapter();
                i8 = (a7.b() + a7.f3130f.f3126j) - 1;
            } else if (i7 == 130) {
                i8 = getAdapter().b();
            } else {
                super.onFocusChanged(true, i7, rect);
                return;
            }
            setSelection(i8);
            return;
        }
        super.onFocusChanged(false, i7, rect);
    }

    @Override // android.widget.GridView, android.view.KeyEvent.Callback, android.widget.AbsListView, android.view.View
    public final boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (!super.onKeyDown(i7, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i7) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i7, int i8) {
        if (this.f3035g) {
            super.onMeasure(i7, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i7, i8);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof w) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), w.class.getCanonicalName()));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i7) {
        if (i7 < getAdapter().b()) {
            i7 = getAdapter().b();
        }
        super.setSelection(i7);
    }
}
