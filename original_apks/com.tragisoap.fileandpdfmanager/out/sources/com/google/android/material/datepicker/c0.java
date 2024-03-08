package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class c0 extends LinearLayoutManager {
    public c0(int i7) {
        super(i7);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final void y0(RecyclerView recyclerView, int i7) {
        b0 b0Var = new b0(recyclerView.getContext());
        b0Var.f2072a = i7;
        z0(b0Var);
    }
}
