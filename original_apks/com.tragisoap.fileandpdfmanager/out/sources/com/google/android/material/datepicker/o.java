package com.google.android.material.datepicker;

import android.view.View;
import java.util.Calendar;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ y f3097f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i f3098g;

    public o(i iVar, y yVar) {
        this.f3098g = iVar;
        this.f3097f = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int L0 = this.f3098g.Q().L0() + 1;
        if (L0 < this.f3098g.f3081f0.getAdapter().a()) {
            i iVar = this.f3098g;
            Calendar c7 = e0.c(this.f3097f.f3138d.f3036f.f3122f);
            c7.add(2, L0);
            iVar.S(new v(c7));
        }
    }
}
