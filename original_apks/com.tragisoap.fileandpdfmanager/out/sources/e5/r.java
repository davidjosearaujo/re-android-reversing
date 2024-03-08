package e5;

import android.view.View;
import e5.v;
import java.util.HashMap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ HashMap f3854f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ v.a f3855g;

    public r(v.a aVar, HashMap hashMap) {
        this.f3855g = aVar;
        this.f3854f = hashMap;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v.a.q(this.f3855g, (String) this.f3854f.get("col1Path"));
    }
}
