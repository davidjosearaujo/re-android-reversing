package com.google.android.material.datepicker;

import android.view.View;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f0 implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f3066f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ g0 f3067g;

    public f0(g0 g0Var, int i7) {
        this.f3067g = g0Var;
        this.f3066f = i7;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v b2 = v.b(this.f3066f, this.f3067g.f3071d.f3077b0.f3123g);
        a aVar = this.f3067g.f3071d.Z;
        if (b2.f3122f.compareTo(aVar.f3036f.f3122f) < 0) {
            b2 = aVar.f3036f;
        } else {
            if (b2.f3122f.compareTo(aVar.f3037g.f3122f) > 0) {
                b2 = aVar.f3037g;
            }
        }
        this.f3067g.f3071d.S(b2);
        this.f3067g.f3071d.T(1);
    }
}
