package m1;

import android.graphics.Typeface;
import h1.f;
import i1.e;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ a0.e f5039f;

    /* renamed from: g */
    public final /* synthetic */ Typeface f5040g;

    public a(a0.e eVar, Typeface typeface) {
        this.f5039f = eVar;
        this.f5040g = typeface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a0.e eVar = this.f5039f;
        Typeface typeface = this.f5040g;
        f.e eVar2 = ((e.a) eVar).f4471j0;
        if (eVar2 != null) {
            eVar2.d(typeface);
        }
    }
}
