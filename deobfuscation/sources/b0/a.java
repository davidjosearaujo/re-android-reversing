package b0;

import android.graphics.Canvas;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public Canvas f2336a = b.f2337a;

    public a() {
        new Rect();
        new Rect();
    }

    @Override // b0.d
    public final void b(float f7, float f8) {
        this.f2336a.translate(f7, f8);
    }

    @Override // b0.d
    public final void c() {
        this.f2336a.restore();
    }

    @Override // b0.d
    public final void d(float f7, float f8, float f9, float f10, c cVar) {
        r5.h.f(cVar, "paint");
        this.f2336a.drawRect(f7, f8, f9, f10, cVar.f2338a);
    }

    @Override // b0.d
    public final void e() {
        this.f2336a.save();
    }

    @Override // b0.d
    public final void f() {
        Canvas canvas = this.f2336a;
        r5.h.f(canvas, "canvas");
        e.f2339a.a(canvas, false);
    }

    @Override // b0.d
    public final void g() {
        Canvas canvas = this.f2336a;
        r5.h.f(canvas, "canvas");
        e.f2339a.a(canvas, true);
    }
}
