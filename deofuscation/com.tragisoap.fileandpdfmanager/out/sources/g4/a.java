package g4;

import android.graphics.Typeface;
import androidx.activity.result.c;
import d4.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends c {

    /* renamed from: f  reason: collision with root package name */
    public final Typeface f4246f;

    /* renamed from: g  reason: collision with root package name */
    public final AbstractC0059a f4247g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4248h;

    /* renamed from: g4.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface AbstractC0059a {
    }

    public a(b bVar, Typeface typeface) {
        this.f4246f = typeface;
        this.f4247g = bVar;
    }

    @Override // androidx.activity.result.c
    public final void l(int i7) {
        Typeface typeface = this.f4246f;
        if (!this.f4248h) {
            d4.c cVar = ((b) this.f4247g).f3567a;
            if (cVar.j(typeface)) {
                cVar.h(false);
            }
        }
    }

    @Override // androidx.activity.result.c
    public final void m(Typeface typeface, boolean z6) {
        if (!this.f4248h) {
            d4.c cVar = ((b) this.f4247g).f3567a;
            if (cVar.j(typeface)) {
                cVar.h(false);
            }
        }
    }
}
