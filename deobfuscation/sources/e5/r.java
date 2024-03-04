package e5;

import android.view.View;
import e5.v;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class r implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ HashMap f3854f;

    /* renamed from: g */
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
