package com.google.android.material.datepicker;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class k extends RecyclerView.k {

    /* renamed from: a */
    public final Calendar f3089a = e0.e(null);

    /* renamed from: b */
    public final Calendar f3090b = e0.e(null);

    /* renamed from: c */
    public final /* synthetic */ i f3091c;

    public k(i iVar) {
        this.f3091c = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public final void e(Canvas canvas, RecyclerView recyclerView) {
        if ((recyclerView.getAdapter() instanceof g0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            g0 g0Var = (g0) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (o1.c<Long, Long> cVar : this.f3091c.Y.e()) {
                cVar.getClass();
            }
        }
    }
}
