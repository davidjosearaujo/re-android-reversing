package e5;

import android.view.View;
import e5.v;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class s implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ HashMap f3856f;

    /* renamed from: g */
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
