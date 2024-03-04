package m1;

import java.util.ArrayList;
import m1.k;

/* loaded from: classes.dex */
public final class j implements o1.a<k.a> {

    /* renamed from: a */
    public final /* synthetic */ String f5059a;

    public j(String str) {
        this.f5059a = str;
    }

    @Override // o1.a
    public final void accept(k.a aVar) {
        k.a aVar2 = aVar;
        synchronized (k.f5062c) {
            o.h<String, ArrayList<o1.a<k.a>>> hVar = k.f5063d;
            ArrayList<o1.a<k.a>> orDefault = hVar.getOrDefault(this.f5059a, null);
            if (orDefault == null) {
                return;
            }
            hVar.remove(this.f5059a);
            for (int i7 = 0; i7 < orDefault.size(); i7++) {
                orDefault.get(i7).accept(aVar2);
            }
        }
    }
}
