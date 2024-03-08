package m1;

import a0.e;
import android.os.Handler;
import i1.e;
import m1.k;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: a */
    public final e f5043a;

    /* renamed from: b */
    public final Handler f5044b;

    public c(e.a aVar, Handler handler) {
        this.f5043a = aVar;
        this.f5044b = handler;
    }

    public final void a(k.a aVar) {
        int i7 = aVar.f5065b;
        if (i7 == 0) {
            this.f5044b.post(new a(this.f5043a, aVar.f5064a));
            return;
        }
        this.f5044b.post(new b(this.f5043a, i7));
    }
}
