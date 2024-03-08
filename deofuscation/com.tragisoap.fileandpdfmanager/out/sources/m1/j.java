package m1;

import java.util.ArrayList;
import m1.k;
import o.h;
import o1.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j implements a<k.a> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5059a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public j(String str) {
        this.f5059a = str;
    }

    @Override // o1.a
    public final void accept(k.a aVar) {
        k.a aVar2 = aVar;
        synchronized (k.f5062c) {
            h<String, ArrayList<a<k.a>>> hVar = k.f5063d;
            ArrayList<a<k.a>> orDefault = hVar.getOrDefault(this.f5059a, null);
            if (orDefault != null) {
                hVar.remove(this.f5059a);
                for (int i7 = 0; i7 < orDefault.size(); i7++) {
                    orDefault.get(i7).accept(aVar2);
                }
            }
        }
    }
}
