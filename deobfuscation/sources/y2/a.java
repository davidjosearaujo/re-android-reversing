package y2;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: classes.dex */
public final class a implements p2.j {

    /* renamed from: a */
    public final /* synthetic */ int f6596a = 1;

    /* renamed from: b */
    public final p2.j f6597b;

    /* renamed from: c */
    public final Object f6598c;

    public a(a3.e eVar, s2.d dVar) {
        this.f6597b = eVar;
        this.f6598c = dVar;
    }

    @Override // p2.j
    public final boolean a(Object obj, p2.h hVar) {
        switch (this.f6596a) {
            case 0:
                return this.f6597b.a(obj, hVar);
            default:
                return "android.resource".equals(((Uri) obj).getScheme());
        }
    }

    @Override // p2.j
    public final r2.v b(Object obj, int i7, int i8, p2.h hVar) {
        switch (this.f6596a) {
            case 0:
                r2.v b2 = this.f6597b.b(obj, i7, i8, hVar);
                Resources resources = (Resources) this.f6598c;
                if (b2 == null) {
                    return null;
                }
                return new d(resources, b2);
            default:
                r2.v c7 = ((a3.e) this.f6597b).c((Uri) obj, hVar);
                if (c7 == null) {
                    return null;
                }
                return m.a((s2.d) this.f6598c, (Drawable) ((a3.c) c7).get(), i7, i8);
        }
    }

    public a(Resources resources, p2.j jVar) {
        this.f6598c = resources;
        this.f6597b = jVar;
    }
}
