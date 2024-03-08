package e5;

import android.view.View;
import e5.v;
import java.util.HashMap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ HashMap f3856f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ v.a f3857g;

    public s(v.a aVar, HashMap hashMap) {
        this.f3857g = aVar;
        this.f3856f = hashMap;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v.a.q(this.f3857g, (String) this.f3856f.get("col2Path"));
    }
}
