package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.activity.result.f;
import d.a;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ int f413f;

    /* renamed from: g */
    public final /* synthetic */ a.C0043a f414g;

    /* renamed from: h */
    public final /* synthetic */ ComponentActivity.a f415h;

    public i(ComponentActivity.a aVar, int i7, a.C0043a c0043a) {
        this.f415h = aVar;
        this.f413f = i7;
        this.f414g = c0043a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        androidx.activity.result.b<O> bVar;
        ComponentActivity.a aVar = this.f415h;
        int i7 = this.f413f;
        T t5 = this.f414g.f3548a;
        String str = (String) aVar.f446a.get(Integer.valueOf(i7));
        if (str == null) {
            return;
        }
        f.a aVar2 = (f.a) aVar.e.get(str);
        if (aVar2 == null || (bVar = aVar2.f452a) == 0) {
            aVar.f451g.remove(str);
            aVar.f450f.put(str, t5);
        } else if (aVar.f449d.remove(str)) {
            bVar.a(t5);
        }
    }
}
