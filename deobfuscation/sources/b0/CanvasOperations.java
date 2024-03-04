package b0;

/* renamed from: b0.d */
/* loaded from: classes.dex */
public interface CanvasOperations {
    default void a(a0.c cVar, PaintBase paintBase) {
        r5.h.f(paintBase, "paint");
        drawRect(cVar.f26a, cVar.f27b, cVar.f28c, cVar.f29d, paintBase);
    }

    /* renamed from: b */
    void translate(float dx, float dy);

    /* renamed from: c */
    void restore();

    /* renamed from: d */
    void drawRect(float left, float right, float top, float bottom, PaintBase paintBase);

    /* renamed from: e */
    void save();

    void f();

    void g();
}
