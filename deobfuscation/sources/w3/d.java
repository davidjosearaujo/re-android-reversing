package w3;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator<C0130d> {

        /* renamed from: b */
        public static final a f6400b = new a();

        /* renamed from: a */
        public final C0130d f6401a = new C0130d();

        @Override // android.animation.TypeEvaluator
        public final C0130d evaluate(float f7, C0130d c0130d, C0130d c0130d2) {
            C0130d c0130d3 = c0130d;
            C0130d c0130d4 = c0130d2;
            C0130d c0130d5 = this.f6401a;
            float f8 = c0130d3.f6404a;
            float f9 = 1.0f - f7;
            float f10 = (c0130d4.f6404a * f7) + (f8 * f9);
            float f11 = c0130d3.f6405b;
            float f12 = c0130d4.f6405b * f7;
            float f13 = c0130d3.f6406c;
            float f14 = f7 * c0130d4.f6406c;
            c0130d5.f6404a = f10;
            c0130d5.f6405b = f12 + (f11 * f9);
            c0130d5.f6406c = f14 + (f9 * f13);
            return c0130d5;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Property<d, C0130d> {

        /* renamed from: a */
        public static final b f6402a = new b();

        public b() {
            super(C0130d.class, "circularReveal");
        }

        @Override // android.util.Property
        public final C0130d get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        public final void set(d dVar, C0130d c0130d) {
            dVar.setRevealInfo(c0130d);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<d, Integer> {

        /* renamed from: a */
        public static final c f6403a = new c();

        public c() {
            super(Integer.class, "circularRevealScrimColor");
        }

        @Override // android.util.Property
        public final Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public final void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* renamed from: w3.d$d */
    /* loaded from: classes.dex */
    public static class C0130d {

        /* renamed from: a */
        public float f6404a;

        /* renamed from: b */
        public float f6405b;

        /* renamed from: c */
        public float f6406c;

        public C0130d() {
        }

        public C0130d(float f7, float f8, float f9) {
            this.f6404a = f7;
            this.f6405b = f8;
            this.f6406c = f9;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    C0130d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i7);

    void setRevealInfo(C0130d c0130d);
}
