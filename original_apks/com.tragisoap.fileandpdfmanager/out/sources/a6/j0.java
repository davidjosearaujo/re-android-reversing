package a6;

import androidx.activity.h;
import f5.g;
import q5.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j0 extends e {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f301f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f302g;

    public /* synthetic */ j0(int i7, Object obj) {
        this.f301f = i7;
        this.f302g = obj;
    }

    @Override // a6.f
    public final void c(Throwable th) {
        switch (this.f301f) {
            case 0:
                ((i0) this.f302g).a();
                return;
            default:
                ((l) this.f302g).k(th);
                return;
        }
    }

    @Override // q5.l
    public final /* bridge */ /* synthetic */ g k(Throwable th) {
        switch (this.f301f) {
            case 0:
                c(th);
                return g.f4141a;
            default:
                c(th);
                return g.f4141a;
        }
    }

    public final String toString() {
        switch (this.f301f) {
            case 0:
                StringBuilder d7 = h.d("DisposeOnCancel[");
                d7.append((i0) this.f302g);
                d7.append(']');
                return d7.toString();
            default:
                StringBuilder d8 = h.d("InvokeOnCancel[");
                d8.append(((l) this.f302g).getClass().getSimpleName());
                d8.append('@');
                d8.append(a0.c(this));
                d8.append(']');
                return d8.toString();
        }
    }
}
