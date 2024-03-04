package g4;

import android.graphics.Typeface;

/* loaded from: classes.dex */
public final class a extends androidx.activity.result.c {

    /* renamed from: f */
    public final Typeface f4246f;

    /* renamed from: g */
    public final InterfaceC0059a f4247g;

    /* renamed from: h */
    public boolean f4248h;

    /* renamed from: g4.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
    }

    public a(d4.b bVar, Typeface typeface) {
        this.f4246f = typeface;
        this.f4247g = bVar;
    }

    @Override // androidx.activity.result.c
    public final void l(int i7) {
        Typeface typeface = this.f4246f;
        if (this.f4248h) {
            return;
        }
        d4.c cVar = ((d4.b) this.f4247g).f3567a;
        if (cVar.j(typeface)) {
            cVar.h(false);
        }
    }

    @Override // androidx.activity.result.c
    public final void m(Typeface typeface, boolean z6) {
        if (this.f4248h) {
            return;
        }
        d4.c cVar = ((d4.b) this.f4247g).f3567a;
        if (cVar.j(typeface)) {
            cVar.h(false);
        }
    }
}
