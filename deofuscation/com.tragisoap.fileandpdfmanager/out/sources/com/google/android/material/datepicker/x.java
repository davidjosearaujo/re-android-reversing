package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.i;
import java.util.Iterator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class x implements AdapterView.OnItemClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f3136f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ y f3137g;

    public x(y yVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f3137g = yVar;
        this.f3136f = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
        w a7 = this.f3136f.getAdapter();
        if (i7 >= a7.b() && i7 <= (a7.b() + a7.f3130f.f3126j) + -1) {
            i.d dVar = (i.d) this.f3137g.f3140g;
            if (i.this.Z.f3038h.g(this.f3136f.getAdapter().getItem(i7).longValue())) {
                i.this.Y.a();
                Iterator it = i.this.W.iterator();
                while (it.hasNext()) {
                    ((z) it.next()).a(i.this.Y.l());
                }
                i.this.f3081f0.getAdapter().c();
                RecyclerView recyclerView = i.this.f3080e0;
                if (recyclerView != null) {
                    recyclerView.getAdapter().c();
                }
            }
        }
    }
}
