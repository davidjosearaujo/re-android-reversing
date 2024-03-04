package com.google.android.material.datepicker;

import android.view.View;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ y f3073f;

    /* renamed from: g */
    public final /* synthetic */ i f3074g;

    public h(i iVar, y yVar) {
        this.f3074g = iVar;
        this.f3073f = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int M0 = this.f3074g.Q().M0() - 1;
        if (M0 >= 0) {
            i iVar = this.f3074g;
            Calendar c7 = e0.c(this.f3073f.f3138d.f3036f.f3122f);
            c7.add(2, M0);
            iVar.S(new v(c7));
        }
    }
}
