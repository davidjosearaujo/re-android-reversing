package a6;

/* loaded from: classes.dex */
public final class j0 extends e {

    /* renamed from: f */
    public final /* synthetic */ int f301f;

    /* renamed from: g */
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
                ((q5.l) this.f302g).k(th);
                return;
        }
    }

    @Override // q5.l
    public final /* bridge */ /* synthetic */ f5.g k(Throwable th) {
        switch (this.f301f) {
            case 0:
                c(th);
                return f5.g.f4141a;
            default:
                c(th);
                return f5.g.f4141a;
        }
    }

    public final String toString() {
        switch (this.f301f) {
            case 0:
                StringBuilder d7 = androidx.activity.h.d("DisposeOnCancel[");
                d7.append((i0) this.f302g);
                d7.append(']');
                return d7.toString();
            default:
                StringBuilder d8 = androidx.activity.h.d("InvokeOnCancel[");
                d8.append(((q5.l) this.f302g).getClass().getSimpleName());
                d8.append('@');
                d8.append(a0.c(this));
                d8.append(']');
                return d8.toString();
        }
    }
}
