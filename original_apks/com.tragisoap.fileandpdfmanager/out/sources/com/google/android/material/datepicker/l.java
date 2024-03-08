package com.google.android.material.datepicker;

import android.view.View;
import p1.a;
import q1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends a {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i f3092d;

    public l(i iVar) {
        this.f3092d = iVar;
    }

    @Override // p1.a
    public final void d(View view, f fVar) {
        this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
        fVar.f5624a.setHintText(this.f3092d.q(this.f3092d.f3085j0.getVisibility() == 0 ? 2131820704 : 2131820702));
    }
}
