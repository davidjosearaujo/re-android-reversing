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

/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: f */
    public final Calendar f3034f;

    /* renamed from: g */
    public final boolean f3035g;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3034f = e0.e(null);
        if (r.W(getContext())) {
            setNextFocusLeftId(2131296369);
            setNextFocusRightId(2131296398);
        }
        this.f3035g = r.X(getContext(), 2130903917);
        p1.y.i(this, new p());
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: a */
    public final w getAdapter2() {
        return (w) super.getAdapter();
    }

    public final View b(int i7) {
        return getChildAt(i7 - getFirstVisiblePosition());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w adapter2 = getAdapter2();
        d<?> dVar = adapter2.f3131g;
        c cVar = adapter2.f3133i;
        int max = Math.max(adapter2.b(), getFirstVisiblePosition());
        int min = Math.min((adapter2.b() + adapter2.f3130f.f3126j) - 1, getLastVisiblePosition());
        adapter2.getItem(max);
        adapter2.getItem(min);
        for (o1.c<Long, Long> cVar2 : dVar.e()) {
            cVar2.getClass();
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z6, int i7, Rect rect) {
        int b2;
        if (!z6) {
            super.onFocusChanged(false, i7, rect);
            return;
        }
        if (i7 == 33) {
            w adapter2 = getAdapter2();
            b2 = (adapter2.b() + adapter2.f3130f.f3126j) - 1;
        } else if (i7 != 130) {
            super.onFocusChanged(true, i7, rect);
            return;
        } else {
            b2 = getAdapter2().b();
        }
        setSelection(b2);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (super.onKeyDown(i7, keyEvent)) {
            if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().b()) {
                return true;
            }
            if (19 == i7) {
                setSelection(getAdapter2().b());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i7, int i8) {
        if (!this.f3035g) {
            super.onMeasure(i7, i8);
            return;
        }
        super.onMeasure(i7, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof w)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), w.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i7) {
        if (i7 < getAdapter2().b()) {
            i7 = getAdapter2().b();
        }
        super.setSelection(i7);
    }
}
