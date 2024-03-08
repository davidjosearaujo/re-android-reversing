package androidx.activity;

import android.window.OnBackInvokedCallback;
import q5.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class t implements OnBackInvokedCallback {

    /* renamed from: a */
    public final /* synthetic */ int f461a;

    /* renamed from: b */
    public final /* synthetic */ Object f462b;

    public /* synthetic */ t(int i7, Object obj) {
        this.f461a = i7;
        this.f462b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f461a) {
            case 0:
                a aVar = (a) this.f462b;
                h.f(aVar, "$onBackInvoked");
                aVar.d();
                return;
            case 1:
                ((f.h) this.f462b).Q();
                return;
            default:
                ((Runnable) this.f462b).run();
                return;
        }
    }
}
