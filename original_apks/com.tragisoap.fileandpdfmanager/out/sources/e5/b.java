package e5;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tragisoap.fileandpdfmanager.FileManagerItemActivity;
import e5.g;
import e5.k;
import e5.p;
import e5.v;
import java.util.HashMap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ int f3787f;

    /* renamed from: g */
    public final /* synthetic */ HashMap f3788g;

    /* renamed from: h */
    public final /* synthetic */ RecyclerView.a0 f3789h;

    public /* synthetic */ b(RecyclerView.a0 a0Var, HashMap hashMap, int i7) {
        this.f3787f = i7;
        this.f3789h = a0Var;
        this.f3788g = hashMap;
    }

    public /* synthetic */ b(HashMap hashMap, g.a aVar) {
        this.f3787f = 0;
        this.f3788g = hashMap;
        this.f3789h = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3787f) {
            case 0:
                HashMap hashMap = this.f3788g;
                g.a aVar = (g.a) this.f3789h;
                if (!g.f3797j.contains(hashMap)) {
                    g.f3797j.add(hashMap);
                } else {
                    g.f3797j.remove(hashMap);
                }
                aVar.A.setChecked(g.f3797j.contains(hashMap));
                TextView textView = FileManagerItemActivity.N;
                textView.setText(g.f3797j.size() + "");
                FileManagerItemActivity.O.setVisibility(g.f3797j.size() > 0 ? 0 : 8);
                return;
            case 1:
                k.a aVar2 = (k.a) this.f3789h;
                aVar2.r(aVar2.C, aVar2.D, this.f3788g, 2);
                return;
            case 2:
                p.a aVar3 = (p.a) this.f3789h;
                aVar3.q(aVar3.C, aVar3.D, this.f3788g, 1);
                return;
            default:
                v.a aVar4 = (v.a) this.f3789h;
                aVar4.r(aVar4.C, aVar4.D, this.f3788g, 1);
                return;
        }
    }
}
