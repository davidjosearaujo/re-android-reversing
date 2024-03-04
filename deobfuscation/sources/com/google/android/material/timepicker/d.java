package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import k4.i;
import l0.z;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public class d extends ConstraintLayout {

    /* renamed from: v */
    public final c f3370v;

    /* renamed from: w */
    public int f3371w;

    /* renamed from: x */
    public k4.f f3372x;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.android.material.timepicker.c] */
    public d(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        LayoutInflater.from(context).inflate(2131492935, this);
        k4.f fVar = new k4.f();
        this.f3372x = fVar;
        k4.g gVar = new k4.g(0.5f);
        i iVar = fVar.f4720f.f4740a;
        iVar.getClass();
        i.a aVar = new i.a(iVar);
        aVar.e = gVar;
        aVar.f4775f = gVar;
        aVar.f4776g = gVar;
        aVar.f4777h = gVar;
        fVar.setShapeAppearanceModel(new i(aVar));
        this.f3372x.k(ColorStateList.valueOf(-1));
        k4.f fVar2 = this.f3372x;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.q(this, fVar2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4933u, i7, 0);
        this.f3371w = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f3370v = new Runnable() { // from class: com.google.android.material.timepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.k();
            }
        };
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i7, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            view.setId(y.e.a());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f3370v);
            handler.post(this.f3370v);
        }
    }

    public void k() {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.b(this);
        HashMap hashMap = new HashMap();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getId() != 2131296387 && !"skip".equals(childAt.getTag())) {
                int i8 = (Integer) childAt.getTag(2131296602);
                if (i8 == null) {
                    i8 = 1;
                }
                if (!hashMap.containsKey(i8)) {
                    hashMap.put(i8, new ArrayList());
                }
                ((List) hashMap.get(i8)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            List<View> list = (List) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            int i9 = this.f3371w;
            if (intValue == 2) {
                i9 = Math.round(i9 * 0.66f);
            }
            float f7 = 0.0f;
            for (View view : list) {
                int id = view.getId();
                if (!cVar.f1325c.containsKey(Integer.valueOf(id))) {
                    cVar.f1325c.put(Integer.valueOf(id), new c.a());
                }
                c.b bVar = cVar.f1325c.get(Integer.valueOf(id)).f1329d;
                bVar.f1380z = 2131296387;
                bVar.A = i9;
                bVar.B = f7;
                f7 += 360.0f / list.size();
            }
        }
        cVar.a(this);
        setConstraintSet(null);
        requestLayout();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        k();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f3370v);
            handler.post(this.f3370v);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i7) {
        this.f3372x.k(ColorStateList.valueOf(i7));
    }
}
