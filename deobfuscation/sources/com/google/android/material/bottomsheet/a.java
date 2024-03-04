package com.google.android.material.bottomsheet;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.b;
import p1.p;
import p1.p0;

/* loaded from: classes.dex */
public final class a implements p {

    /* renamed from: a */
    public final /* synthetic */ b f2886a;

    public a(b bVar) {
        this.f2886a = bVar;
    }

    @Override // p1.p
    public final p0 a(View view, p0 p0Var) {
        b bVar = this.f2886a;
        b.C0031b c0031b = bVar.f2893r;
        if (c0031b != null) {
            bVar.f2887k.f2843b0.remove(c0031b);
        }
        b bVar2 = this.f2886a;
        bVar2.f2893r = new b.C0031b(bVar2.f2889n, p0Var);
        b bVar3 = this.f2886a;
        bVar3.f2893r.e(bVar3.getWindow());
        b bVar4 = this.f2886a;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = bVar4.f2887k;
        b.C0031b c0031b2 = bVar4.f2893r;
        if (!bottomSheetBehavior.f2843b0.contains(c0031b2)) {
            bottomSheetBehavior.f2843b0.add(c0031b2);
        }
        return p0Var;
    }
}
