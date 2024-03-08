package p;

import a6.y;
import androidx.compose.ui.platform.j0;
import f5.g;
import i5.f;
import q5.p;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final p f5451a;

    public /* synthetic */ r(f fVar, j0 j0Var) {
        h.f(fVar, "parentCoroutineContext");
        this.f5451a = j0Var;
        y.a(fVar);
    }

    public /* synthetic */ r(p pVar) {
        this.f5451a = pVar;
    }

    public void a() {
        p pVar = this.f5451a;
        synchronized (v.f.f6144b) {
            v.f.f6148g.remove(pVar);
            g gVar = g.f4141a;
        }
    }
}
