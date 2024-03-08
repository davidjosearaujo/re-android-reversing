package com.google.android.material.datepicker;

import android.view.View;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ i f3096f;

    public n(i iVar) {
        this.f3096f = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i iVar = this.f3096f;
        int i7 = iVar.f3078c0;
        if (i7 == 2) {
            iVar.T(1);
        } else if (i7 == 1) {
            iVar.T(2);
        }
    }
}
