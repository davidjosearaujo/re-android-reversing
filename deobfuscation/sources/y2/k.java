package y2;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a */
    public static final e f6616a;

    /* renamed from: b */
    public static final c f6617b;

    /* renamed from: c */
    public static final d f6618c;

    /* renamed from: d */
    public static final f f6619d;
    public static final d e;

    /* renamed from: f */
    public static final p2.g<k> f6620f;

    /* renamed from: g */
    public static final boolean f6621g;

    /* loaded from: classes.dex */
    public static class a extends k {
        @Override // y2.k
        public final int a(int i7, int i8, int i9, int i10) {
            return 2;
        }

        @Override // y2.k
        public final float b(int i7, int i8, int i9, int i10) {
            int min = Math.min(i8 / i10, i7 / i9);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends k {
        @Override // y2.k
        public final int a(int i7, int i8, int i9, int i10) {
            return 1;
        }

        @Override // y2.k
        public final float b(int i7, int i8, int i9, int i10) {
            int ceil = (int) Math.ceil(Math.max(i8 / i10, i7 / i9));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return 1.0f / (max << (max >= ceil ? 0 : 1));
        }
    }

    /* loaded from: classes.dex */
    public static class c extends k {
        @Override // y2.k
        public final int a(int i7, int i8, int i9, int i10) {
            if (b(i7, i8, i9, i10) == 1.0f) {
                return 2;
            }
            return k.f6616a.a(i7, i8, i9, i10);
        }

        @Override // y2.k
        public final float b(int i7, int i8, int i9, int i10) {
            return Math.min(1.0f, k.f6616a.b(i7, i8, i9, i10));
        }
    }

    /* loaded from: classes.dex */
    public static class d extends k {
        @Override // y2.k
        public final int a(int i7, int i8, int i9, int i10) {
            return 2;
        }

        @Override // y2.k
        public final float b(int i7, int i8, int i9, int i10) {
            return Math.max(i9 / i7, i10 / i8);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends k {
        @Override // y2.k
        public final int a(int i7, int i8, int i9, int i10) {
            return k.f6621g ? 2 : 1;
        }

        @Override // y2.k
        public final float b(int i7, int i8, int i9, int i10) {
            if (k.f6621g) {
                return Math.min(i9 / i7, i10 / i8);
            }
            int max = Math.max(i8 / i10, i7 / i9);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(max);
        }
    }

    /* loaded from: classes.dex */
    public static class f extends k {
        @Override // y2.k
        public final int a(int i7, int i8, int i9, int i10) {
            return 2;
        }

        @Override // y2.k
        public final float b(int i7, int i8, int i9, int i10) {
            return 1.0f;
        }
    }

    static {
        new a();
        new b();
        f6616a = new e();
        f6617b = new c();
        d dVar = new d();
        f6618c = dVar;
        f6619d = new f();
        e = dVar;
        f6620f = p2.g.a(dVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        f6621g = true;
    }

    public abstract int a(int i7, int i8, int i9, int i10);

    public abstract float b(int i7, int i8, int i9, int i10);
}
