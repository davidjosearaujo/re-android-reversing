package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes.dex */
public final class m0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: f */
    public final /* synthetic */ n0 f980f;

    public m0(n0 n0Var) {
        this.f980f = n0Var;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i7, long j5) {
        i0 i0Var;
        if (i7 == -1 || (i0Var = this.f980f.f986h) == null) {
            return;
        }
        i0Var.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
