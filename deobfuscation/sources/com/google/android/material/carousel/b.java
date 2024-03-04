package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public final float f2951a;

    /* renamed from: b */
    public final List<C0032b> f2952b;

    /* renamed from: c */
    public final int f2953c;

    /* renamed from: d */
    public final int f2954d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final float f2955a;

        /* renamed from: b */
        public final float f2956b;

        /* renamed from: d */
        public C0032b f2958d;
        public C0032b e;

        /* renamed from: c */
        public final ArrayList f2957c = new ArrayList();

        /* renamed from: f */
        public int f2959f = -1;

        /* renamed from: g */
        public int f2960g = -1;

        /* renamed from: h */
        public float f2961h = 0.0f;

        /* renamed from: i */
        public int f2962i = -1;

        public a(float f7, float f8) {
            this.f2955a = f7;
            this.f2956b = f8;
        }

        public final void a(float f7, float f8, float f9, boolean z6, boolean z7) {
            float f10;
            float abs;
            float f11 = f9 / 2.0f;
            float f12 = f7 - f11;
            float f13 = f11 + f7;
            float f14 = this.f2956b;
            if (f13 > f14) {
                abs = Math.abs(f13 - Math.max(f13 - f9, f14));
            } else if (f12 >= 0.0f) {
                f10 = 0.0f;
                b(f7, f8, f9, z6, z7, f10);
            } else {
                abs = Math.abs(f12 - Math.min(f12 + f9, 0.0f));
            }
            f10 = abs;
            b(f7, f8, f9, z6, z7, f10);
        }

        public final void b(float f7, float f8, float f9, boolean z6, boolean z7, float f10) {
            if (f9 <= 0.0f) {
                return;
            }
            if (z7) {
                if (z6) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i7 = this.f2962i;
                if (i7 != -1 && i7 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f2962i = this.f2957c.size();
            }
            C0032b c0032b = new C0032b(Float.MIN_VALUE, f7, f8, f9, z7, f10);
            C0032b c0032b2 = this.f2958d;
            if (z6) {
                if (c0032b2 == null) {
                    this.f2958d = c0032b;
                    this.f2959f = this.f2957c.size();
                }
                if (this.f2960g != -1 && this.f2957c.size() - this.f2960g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f9 != this.f2958d.f2966d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.e = c0032b;
                this.f2960g = this.f2957c.size();
            } else if (c0032b2 == null && f9 < this.f2961h) {
                throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
            } else {
                if (this.e != null && f9 > this.f2961h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f2961h = f9;
            this.f2957c.add(c0032b);
        }

        public final void c(float f7, float f8, float f9, int i7, boolean z6) {
            if (i7 <= 0 || f9 <= 0.0f) {
                return;
            }
            for (int i8 = 0; i8 < i7; i8++) {
                a((i8 * f9) + f7, f8, f9, z6, false);
            }
        }

        public final b d() {
            if (this.f2958d != null) {
                ArrayList arrayList = new ArrayList();
                for (int i7 = 0; i7 < this.f2957c.size(); i7++) {
                    C0032b c0032b = (C0032b) this.f2957c.get(i7);
                    float f7 = this.f2958d.f2964b;
                    float f8 = this.f2955a;
                    arrayList.add(new C0032b((i7 * f8) + (f7 - (this.f2959f * f8)), c0032b.f2964b, c0032b.f2965c, c0032b.f2966d, c0032b.e, c0032b.f2967f));
                }
                return new b(this.f2955a, arrayList, this.f2959f, this.f2960g);
            }
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
    }

    /* renamed from: com.google.android.material.carousel.b$b */
    /* loaded from: classes.dex */
    public static final class C0032b {

        /* renamed from: a */
        public final float f2963a;

        /* renamed from: b */
        public final float f2964b;

        /* renamed from: c */
        public final float f2965c;

        /* renamed from: d */
        public final float f2966d;
        public final boolean e;

        /* renamed from: f */
        public final float f2967f;

        public C0032b(float f7, float f8, float f9, float f10, boolean z6, float f11) {
            this.f2963a = f7;
            this.f2964b = f8;
            this.f2965c = f9;
            this.f2966d = f10;
            this.e = z6;
            this.f2967f = f11;
        }
    }

    public b(float f7, ArrayList arrayList, int i7, int i8) {
        this.f2951a = f7;
        this.f2952b = Collections.unmodifiableList(arrayList);
        this.f2953c = i7;
        this.f2954d = i8;
    }

    public final C0032b a() {
        return this.f2952b.get(this.f2953c);
    }

    public final C0032b b() {
        return this.f2952b.get(0);
    }

    public final C0032b c() {
        return this.f2952b.get(this.f2954d);
    }

    public final C0032b d() {
        List<C0032b> list = this.f2952b;
        return list.get(list.size() - 1);
    }
}
