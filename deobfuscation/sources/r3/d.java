package r3;

import android.content.res.TypedArray;
import android.view.View;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ com.google.android.material.bottomsheet.b f5902f;

    public d(com.google.android.material.bottomsheet.b bVar) {
        this.f5902f = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.google.android.material.bottomsheet.b bVar = this.f5902f;
        if (bVar.f2890o && bVar.isShowing()) {
            com.google.android.material.bottomsheet.b bVar2 = this.f5902f;
            if (!bVar2.f2892q) {
                TypedArray obtainStyledAttributes = bVar2.getContext().obtainStyledAttributes(new int[]{16843611});
                bVar2.f2891p = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
                bVar2.f2892q = true;
            }
            if (bVar2.f2891p) {
                this.f5902f.cancel();
            }
        }
    }
}
