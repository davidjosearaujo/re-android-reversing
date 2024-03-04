package o4;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.n0;

/* loaded from: classes.dex */
public final class q implements AdapterView.OnItemClickListener {

    /* renamed from: f */
    public final /* synthetic */ r f5396f;

    public q(r rVar) {
        this.f5396f = rVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i7, long j5) {
        Object item;
        r rVar = this.f5396f;
        if (i7 < 0) {
            n0 n0Var = rVar.f5397j;
            item = !n0Var.b() ? null : n0Var.f986h.getSelectedItem();
        } else {
            item = rVar.getAdapter().getItem(i7);
        }
        r.a(this.f5396f, item);
        AdapterView.OnItemClickListener onItemClickListener = this.f5396f.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i7 < 0) {
                n0 n0Var2 = this.f5396f.f5397j;
                view = !n0Var2.b() ? null : n0Var2.f986h.getSelectedView();
                n0 n0Var3 = this.f5396f.f5397j;
                i7 = !n0Var3.b() ? -1 : n0Var3.f986h.getSelectedItemPosition();
                n0 n0Var4 = this.f5396f.f5397j;
                j5 = !n0Var4.b() ? Long.MIN_VALUE : n0Var4.f986h.getSelectedItemId();
            }
            onItemClickListener.onItemClick(this.f5396f.f5397j.f986h, view, i7, j5);
        }
        this.f5396f.f5397j.dismiss();
    }
}
