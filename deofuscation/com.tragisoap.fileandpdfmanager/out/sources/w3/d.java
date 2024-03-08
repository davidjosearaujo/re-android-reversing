package w3;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface d {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a implements TypeEvaluator<C0130d> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f6400b = new a();

        /* renamed from: a  reason: collision with root package name */
        public final C0130d f6401a = new C0130d();

        @Override // android.animation.TypeEvaluator
        public final C0130d evaluate(float f7, C0130d dVar, C0130d dVar2) {
            C0130d dVar3 = dVar;
            C0130d dVar4 = dVar2;
            C0130d dVar5 = this.f6401a;
            float f8 = dVar3.f6404a;
            float f9 = 1.0f - f7;
            float f10 = (dVar4.f6404a * f7) + (f8 * f9);
            float f11 = dVar3.f6405b;
            float f12 = dVar4.f6405b * f7;
            float f13 = dVar3.f6406c;
            float f14 = f7 * dVar4.f6406c;
            dVar5.f6404a = f10;
            dVar5.f6405b = f12 + (f11 * f9);
            dVar5.f6406c = f14 + (f9 * f13);
            return dVar5;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends Property<d, C0130d> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f6402a = new b();

        public b() {
            super(C0130d.class, "circularReveal");
        }

        @Override // android.util.Property
        public final C0130d get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        public final void set(d dVar, C0130d dVar2) {
            dVar.setRevealInfo(dVar2);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends Property<d, Integer> {

        /* renamed from: a  reason: collision with root package name */
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

    /* renamed from: w3.d$d  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0130d {

        /* renamed from: a  reason: collision with root package name */
        public float f6404a;

        /* renamed from: b  reason: collision with root package name */
        public float f6405b;

        /* renamed from: c  reason: collision with root package name */
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

    void setRevealInfo(C0130d dVar);
}
