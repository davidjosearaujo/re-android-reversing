package androidx.fragment.app;

import androidx.fragment.app.q0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ List f1592f;

    /* renamed from: g */
    public final /* synthetic */ q0.b f1593g;

    /* renamed from: h */
    public final /* synthetic */ l f1594h;

    public c(l lVar, ArrayList arrayList, q0.b bVar) {
        this.f1594h = lVar;
        this.f1592f = arrayList;
        this.f1593g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1592f.contains(this.f1593g)) {
            this.f1592f.remove(this.f1593g);
            l lVar = this.f1594h;
            q0.b bVar = this.f1593g;
            lVar.getClass();
            s0.a(bVar.f1748a, bVar.f1750c.J);
        }
    }
}
