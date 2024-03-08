package r3;

import android.content.res.TypedArray;
import android.view.View;
import com.google.android.material.bottomsheet.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ b f5902f;

    public d(b bVar) {
        this.f5902f = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar = this.f5902f;
        if (bVar.f2890o && bVar.isShowing()) {
            b bVar2 = this.f5902f;
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
