package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public final class a implements AdapterView.OnItemClickListener {

    /* renamed from: f */
    public final /* synthetic */ AlertController f497f;

    /* renamed from: g */
    public final /* synthetic */ AlertController.b f498g;

    public a(AlertController.b bVar, AlertController alertController) {
        this.f498g = bVar;
        this.f497f = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i7, long j5) {
        this.f498g.f493h.onClick(this.f497f.f464b, i7);
        if (this.f498g.f494i) {
            return;
        }
        this.f497f.f464b.dismiss();
    }
}
