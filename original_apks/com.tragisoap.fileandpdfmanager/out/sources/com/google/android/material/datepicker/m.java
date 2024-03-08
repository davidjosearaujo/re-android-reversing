package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m extends RecyclerView.p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y f3093a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialButton f3094b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i f3095c;

    public m(i iVar, y yVar, MaterialButton materialButton) {
        this.f3095c = iVar;
        this.f3093a = yVar;
        this.f3094b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public final void a(RecyclerView recyclerView, int i7) {
        if (i7 == 0) {
            recyclerView.announceForAccessibility(this.f3094b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public final void b(RecyclerView recyclerView, int i7, int i8) {
        LinearLayoutManager Q = this.f3095c.Q();
        int L0 = i7 < 0 ? Q.L0() : Q.M0();
        i iVar = this.f3095c;
        Calendar c7 = e0.c(this.f3093a.f3138d.f3036f.f3122f);
        c7.add(2, L0);
        iVar.f3077b0 = new v(c7);
        MaterialButton materialButton = this.f3094b;
        Calendar c8 = e0.c(this.f3093a.f3138d.f3036f.f3122f);
        c8.add(2, L0);
        c8.set(5, 1);
        Calendar c9 = e0.c(c8);
        c9.get(2);
        c9.get(1);
        c9.getMaximum(7);
        c9.getActualMaximum(5);
        c9.getTimeInMillis();
        materialButton.setText(e0.b("yMMMM", Locale.getDefault()).format(new Date(c9.getTimeInMillis())));
    }
}
