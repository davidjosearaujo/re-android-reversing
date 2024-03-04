package e5;

import android.content.Intent;
import android.view.View;
import com.tragisoap.fileandpdfmanager.PartPDFManager;
import e5.k;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ String f3811f;

    /* renamed from: g */
    public final /* synthetic */ HashMap f3812g;

    /* renamed from: h */
    public final /* synthetic */ k.a f3813h;

    public i(k.a aVar, String str, HashMap hashMap) {
        this.f3813h = aVar;
        this.f3811f = str;
        this.f3812g = hashMap;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3811f.equals("pdf")) {
            k.this.f3819d.startActivity(new Intent(k.this.f3819d, PartPDFManager.class).putExtra("pdfPath", (String) this.f3812g.get("col1Path")));
        } else {
            k.a.q(this.f3813h, (String) this.f3812g.get("col1Path"));
        }
    }
}
