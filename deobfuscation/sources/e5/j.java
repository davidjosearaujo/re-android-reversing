package e5;

import android.content.Intent;
import android.view.View;
import com.tragisoap.fileandpdfmanager.PartPDFManager;
import e5.k;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class j implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ String f3814f;

    /* renamed from: g */
    public final /* synthetic */ HashMap f3815g;

    /* renamed from: h */
    public final /* synthetic */ k.a f3816h;

    public j(k.a aVar, String str, HashMap hashMap) {
        this.f3816h = aVar;
        this.f3814f = str;
        this.f3815g = hashMap;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3814f.equals("pdf")) {
            k.this.f3819d.startActivity(new Intent(k.this.f3819d, PartPDFManager.class).putExtra("pdfPath", (String) this.f3815g.get("col2Path")));
        } else {
            k.a.q(this.f3816h, (String) this.f3815g.get("col2Path"));
        }
    }
}
