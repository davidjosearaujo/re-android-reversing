package k4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import l0.z;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a */
    public g6.i f4760a;

    /* renamed from: b */
    public g6.i f4761b;

    /* renamed from: c */
    public g6.i f4762c;

    /* renamed from: d */
    public g6.i f4763d;
    public c e;

    /* renamed from: f */
    public c f4764f;

    /* renamed from: g */
    public c f4765g;

    /* renamed from: h */
    public c f4766h;

    /* renamed from: i */
    public e f4767i;

    /* renamed from: j */
    public e f4768j;

    /* renamed from: k */
    public e f4769k;

    /* renamed from: l */
    public e f4770l;

    public i() {
        this.f4760a = new h();
        this.f4761b = new h();
        this.f4762c = new h();
        this.f4763d = new h();
        this.e = new k4.a(0.0f);
        this.f4764f = new k4.a(0.0f);
        this.f4765g = new k4.a(0.0f);
        this.f4766h = new k4.a(0.0f);
        this.f4767i = new e();
        this.f4768j = new e();
        this.f4769k = new e();
        this.f4770l = new e();
    }

    public static a a(Context context, int i7, int i8, k4.a aVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i7);
        if (i8 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i8);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(z.f4935w);
        try {
            int i9 = obtainStyledAttributes.getInt(0, 0);
            int i10 = obtainStyledAttributes.getInt(3, i9);
            int i11 = obtainStyledAttributes.getInt(4, i9);
            int i12 = obtainStyledAttributes.getInt(2, i9);
            int i13 = obtainStyledAttributes.getInt(1, i9);
            c c7 = c(obtainStyledAttributes, 5, aVar);
            c c8 = c(obtainStyledAttributes, 8, c7);
            c c9 = c(obtainStyledAttributes, 9, c7);
            c c10 = c(obtainStyledAttributes, 7, c7);
            c c11 = c(obtainStyledAttributes, 6, c7);
            a aVar2 = new a();
            g6.i o6 = q2.a.o(i10);
            aVar2.f4771a = o6;
            float b2 = a.b(o6);
            if (b2 != -1.0f) {
                aVar2.e(b2);
            }
            aVar2.e = c8;
            g6.i o7 = q2.a.o(i11);
            aVar2.f4772b = o7;
            float b7 = a.b(o7);
            if (b7 != -1.0f) {
                aVar2.f(b7);
            }
            aVar2.f4775f = c9;
            g6.i o8 = q2.a.o(i12);
            aVar2.f4773c = o8;
            float b8 = a.b(o8);
            if (b8 != -1.0f) {
                aVar2.d(b8);
            }
            aVar2.f4776g = c10;
            g6.i o9 = q2.a.o(i13);
            aVar2.f4774d = o9;
            float b9 = a.b(o9);
            if (b9 != -1.0f) {
                aVar2.c(b9);
            }
            aVar2.f4777h = c11;
            return aVar2;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static a b(Context context, AttributeSet attributeSet, int i7, int i8) {
        k4.a aVar = new k4.a(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4930q, i7, i8);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static c c(TypedArray typedArray, int i7, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i7);
        if (peekValue == null) {
            return cVar;
        }
        int i8 = peekValue.type;
        return i8 == 5 ? new k4.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i8 == 6 ? new g(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public final boolean d(RectF rectF) {
        boolean z6 = this.f4770l.getClass().equals(e.class) && this.f4768j.getClass().equals(e.class) && this.f4767i.getClass().equals(e.class) && this.f4769k.getClass().equals(e.class);
        float a7 = this.e.a(rectF);
        return z6 && ((this.f4764f.a(rectF) > a7 ? 1 : (this.f4764f.a(rectF) == a7 ? 0 : -1)) == 0 && (this.f4766h.a(rectF) > a7 ? 1 : (this.f4766h.a(rectF) == a7 ? 0 : -1)) == 0 && (this.f4765g.a(rectF) > a7 ? 1 : (this.f4765g.a(rectF) == a7 ? 0 : -1)) == 0) && ((this.f4761b instanceof h) && (this.f4760a instanceof h) && (this.f4762c instanceof h) && (this.f4763d instanceof h));
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public g6.i f4771a;

        /* renamed from: b */
        public g6.i f4772b;

        /* renamed from: c */
        public g6.i f4773c;

        /* renamed from: d */
        public g6.i f4774d;
        public c e;

        /* renamed from: f */
        public c f4775f;

        /* renamed from: g */
        public c f4776g;

        /* renamed from: h */
        public c f4777h;

        /* renamed from: i */
        public e f4778i;

        /* renamed from: j */
        public e f4779j;

        /* renamed from: k */
        public e f4780k;

        /* renamed from: l */
        public e f4781l;

        public a() {
            this.f4771a = new h();
            this.f4772b = new h();
            this.f4773c = new h();
            this.f4774d = new h();
            this.e = new k4.a(0.0f);
            this.f4775f = new k4.a(0.0f);
            this.f4776g = new k4.a(0.0f);
            this.f4777h = new k4.a(0.0f);
            this.f4778i = new e();
            this.f4779j = new e();
            this.f4780k = new e();
            this.f4781l = new e();
        }

        public static float b(g6.i iVar) {
            if (iVar instanceof h) {
                return ((h) iVar).f4759g;
            }
            if (iVar instanceof d) {
                return ((d) iVar).f4719g;
            }
            return -1.0f;
        }

        public final i a() {
            return new i(this);
        }

        public final void c(float f7) {
            this.f4777h = new k4.a(f7);
        }

        public final void d(float f7) {
            this.f4776g = new k4.a(f7);
        }

        public final void e(float f7) {
            this.e = new k4.a(f7);
        }

        public final void f(float f7) {
            this.f4775f = new k4.a(f7);
        }

        public a(i iVar) {
            this.f4771a = new h();
            this.f4772b = new h();
            this.f4773c = new h();
            this.f4774d = new h();
            this.e = new k4.a(0.0f);
            this.f4775f = new k4.a(0.0f);
            this.f4776g = new k4.a(0.0f);
            this.f4777h = new k4.a(0.0f);
            this.f4778i = new e();
            this.f4779j = new e();
            this.f4780k = new e();
            this.f4781l = new e();
            this.f4771a = iVar.f4760a;
            this.f4772b = iVar.f4761b;
            this.f4773c = iVar.f4762c;
            this.f4774d = iVar.f4763d;
            this.e = iVar.e;
            this.f4775f = iVar.f4764f;
            this.f4776g = iVar.f4765g;
            this.f4777h = iVar.f4766h;
            this.f4778i = iVar.f4767i;
            this.f4779j = iVar.f4768j;
            this.f4780k = iVar.f4769k;
            this.f4781l = iVar.f4770l;
        }
    }

    public i(a aVar) {
        this.f4760a = aVar.f4771a;
        this.f4761b = aVar.f4772b;
        this.f4762c = aVar.f4773c;
        this.f4763d = aVar.f4774d;
        this.e = aVar.e;
        this.f4764f = aVar.f4775f;
        this.f4765g = aVar.f4776g;
        this.f4766h = aVar.f4777h;
        this.f4767i = aVar.f4778i;
        this.f4768j = aVar.f4779j;
        this.f4769k = aVar.f4780k;
        this.f4770l = aVar.f4781l;
    }
}
