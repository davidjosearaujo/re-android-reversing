package y2;

import a3.c;
import a3.e;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import p2.h;
import p2.j;
import r2.v;
import s2.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f6596a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final j f6597b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f6598c;

    public a(e eVar, d dVar) {
        this.f6597b = eVar;
        this.f6598c = dVar;
    }

    @Override // p2.j
    public final boolean a(Object obj, h hVar) {
        switch (this.f6596a) {
            case 0:
                return this.f6597b.a(obj, hVar);
            default:
                return "android.resource".equals(((Uri) obj).getScheme());
        }
    }

    @Override // p2.j
    public final v b(Object obj, int i7, int i8, h hVar) {
        switch (this.f6596a) {
            case 0:
                v b2 = this.f6597b.b(obj, i7, i8, hVar);
                Resources resources = (Resources) this.f6598c;
                if (b2 == null) {
                    return null;
                }
                return new d(resources, b2);
            default:
                v c7 = ((e) this.f6597b).c((Uri) obj, hVar);
                if (c7 == null) {
                    return null;
                }
                return m.a((d) this.f6598c, (Drawable) ((c) c7).get(), i7, i8);
        }
    }

    public a(Resources resources, j jVar) {
        this.f6598c = resources;
        this.f6597b = jVar;
    }
}
