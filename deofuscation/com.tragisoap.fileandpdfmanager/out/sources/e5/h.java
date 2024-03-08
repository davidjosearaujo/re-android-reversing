package e5;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import e5.k;
import e5.p;
import e5.v;
import java.util.HashMap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ int f3808f;

    /* renamed from: g */
    public final /* synthetic */ HashMap f3809g;

    /* renamed from: h */
    public final /* synthetic */ RecyclerView.a0 f3810h;

    public /* synthetic */ h(RecyclerView.a0 a0Var, HashMap hashMap, int i7) {
        this.f3808f = i7;
        this.f3810h = a0Var;
        this.f3809g = hashMap;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3808f) {
            case 0:
                k.a aVar = (k.a) this.f3810h;
                aVar.r(aVar.C, aVar.D, this.f3809g, 1);
                return;
            case 1:
                p.a aVar2 = (p.a) this.f3810h;
                aVar2.q(aVar2.C, aVar2.D, this.f3809g, 2);
                return;
            default:
                v.a aVar3 = (v.a) this.f3810h;
                aVar3.r(aVar3.C, aVar3.D, this.f3809g, 2);
                return;
        }
    }
}
