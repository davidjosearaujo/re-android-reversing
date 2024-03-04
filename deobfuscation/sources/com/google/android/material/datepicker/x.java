package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.i;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class x implements AdapterView.OnItemClickListener {

    /* renamed from: f */
    public final /* synthetic */ MaterialCalendarGridView f3136f;

    /* renamed from: g */
    public final /* synthetic */ y f3137g;

    public x(y yVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f3137g = yVar;
        this.f3136f = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i7, long j5) {
        w adapter2 = this.f3136f.getAdapter2();
        if (i7 >= adapter2.b() && i7 <= (adapter2.b() + adapter2.f3130f.f3126j) + (-1)) {
            i.d dVar = (i.d) this.f3137g.f3140g;
            if (i.this.Z.f3038h.g(this.f3136f.getAdapter2().getItem(i7).longValue())) {
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
