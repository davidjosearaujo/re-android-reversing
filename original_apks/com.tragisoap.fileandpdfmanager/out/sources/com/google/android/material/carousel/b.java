package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final float f2951a;

    /* renamed from: b  reason: collision with root package name */
    public final List<C0032b> f2952b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2953c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2954d;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final float f2955a;

        /* renamed from: b  reason: collision with root package name */
        public final float f2956b;

        /* renamed from: d  reason: collision with root package name */
        public C0032b f2958d;
        public C0032b e;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList f2957c = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        public int f2959f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2960g = -1;

        /* renamed from: h  reason: collision with root package name */
        public float f2961h = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        public int f2962i = -1;

        public a(float f7, float f8) {
            this.f2955a = f7;
            this.f2956b = f8;
        }

        public final void a(float f7, float f8, float f9, boolean z6, boolean z7) {
            float f10;
            float f11 = f9 / 2.0f;
            float f12 = f7 - f11;
            float f13 = f11 + f7;
            float f14 = this.f2956b;
            if (f13 > f14) {
                f10 = Math.abs(f13 - Math.max(f13 - f9, f14));
            } else if (f12 < 0.0f) {
                f10 = Math.abs(f12 - Math.min(f12 + f9, 0.0f));
            } else {
                f10 = 0.0f;
                b(f7, f8, f9, z6, z7, f10);
            }
            b(f7, f8, f9, z6, z7, f10);
        }

        public final void b(float f7, float f8, float f9, boolean z6, boolean z7, float f10) {
            if (f9 > 0.0f) {
                if (z7) {
                    if (!z6) {
                        int i7 = this.f2962i;
                        if (i7 == -1 || i7 == 0) {
                            this.f2962i = this.f2957c.size();
                        } else {
                            throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                        }
                    } else {
                        throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                    }
                }
                C0032b bVar = new C0032b(Float.MIN_VALUE, f7, f8, f9, z7, f10);
                C0032b bVar2 = this.f2958d;
                if (z6) {
                    if (bVar2 == null) {
                        this.f2958d = bVar;
                        this.f2959f = this.f2957c.size();
                    }
                    if (this.f2960g != -1 && this.f2957c.size() - this.f2960g > 1) {
                        throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                    } else if (f9 == this.f2958d.f2966d) {
                        this.e = bVar;
                        this.f2960g = this.f2957c.size();
                    } else {
                        throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                    }
                } else if (bVar2 == null && f9 < this.f2961h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                } else if (this.e != null && f9 > this.f2961h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
                this.f2961h = f9;
                this.f2957c.add(bVar);
            }
        }

        public final void c(float f7, float f8, float f9, int i7, boolean z6) {
            if (i7 > 0 && f9 > 0.0f) {
                for (int i8 = 0; i8 < i7; i8++) {
                    a((((float) i8) * f9) + f7, f8, f9, z6, false);
                }
            }
        }

        public final b d() {
            if (this.f2958d != null) {
                ArrayList arrayList = new ArrayList();
                for (int i7 = 0; i7 < this.f2957c.size(); i7++) {
                    C0032b bVar = (C0032b) this.f2957c.get(i7);
                    float f7 = this.f2958d.f2964b;
                    float f8 = this.f2955a;
                    arrayList.add(new C0032b((((float) i7) * f8) + (f7 - (((float) this.f2959f) * f8)), bVar.f2964b, bVar.f2965c, bVar.f2966d, bVar.e, bVar.f2967f));
                }
                return new b(this.f2955a, arrayList, this.f2959f, this.f2960g);
            }
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
    }

    /* renamed from: com.google.android.material.carousel.b$b  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0032b {

        /* renamed from: a  reason: collision with root package name */
        public final float f2963a;

        /* renamed from: b  reason: collision with root package name */
        public final float f2964b;

        /* renamed from: c  reason: collision with root package name */
        public final float f2965c;

        /* renamed from: d  reason: collision with root package name */
        public final float f2966d;
        public final boolean e;

        /* renamed from: f  reason: collision with root package name */
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
