package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.activity.result.b;
import androidx.activity.result.f;
import d.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f413f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ a.C0043a f414g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity.a f415h;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public i(ComponentActivity.a aVar, int i7, a.C0043a aVar2) {
        this.f415h = aVar;
        this.f413f = i7;
        this.f414g = aVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        b<O> bVar;
        ComponentActivity.a aVar = this.f415h;
        int i7 = this.f413f;
        T t5 = this.f414g.f3548a;
        String str = (String) aVar.f446a.get(Integer.valueOf(i7));
        if (str != null) {
            f.a aVar2 = (f.a) aVar.e.get(str);
            if (aVar2 == null || (bVar = aVar2.f452a) == 0) {
                aVar.f451g.remove(str);
                aVar.f450f.put(str, t5);
            } else if (aVar.f449d.remove(str)) {
                bVar.a(t5);
            }
        }
    }
}
