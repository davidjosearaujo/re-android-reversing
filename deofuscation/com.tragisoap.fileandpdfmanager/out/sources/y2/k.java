package y2;

import p2.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class k {

    /* renamed from: c  reason: collision with root package name */
    public static final d f6618c;
    public static final d e;

    /* renamed from: f  reason: collision with root package name */
    public static final g<k> f6620f;

    /* renamed from: a  reason: collision with root package name */
    public static final e f6616a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final c f6617b = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final f f6619d = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f6621g = true;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
            return 1.0f / ((float) Integer.highestOneBit(min));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends k {
        @Override // y2.k
        public final int a(int i7, int i8, int i9, int i10) {
            return 1;
        }

        @Override // y2.k
        public final float b(int i7, int i8, int i9, int i10) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i8) / ((float) i10), ((float) i7) / ((float) i9)));
            int i11 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i11 = 0;
            }
            return 1.0f / ((float) (max << i11));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d extends k {
        @Override // y2.k
        public final int a(int i7, int i8, int i9, int i10) {
            return 2;
        }

        @Override // y2.k
        public final float b(int i7, int i8, int i9, int i10) {
            return Math.max(((float) i9) / ((float) i7), ((float) i10) / ((float) i8));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e extends k {
        @Override // y2.k
        public final int a(int i7, int i8, int i9, int i10) {
            return k.f6621g ? 2 : 1;
        }

        @Override // y2.k
        public final float b(int i7, int i8, int i9, int i10) {
            if (k.f6621g) {
                return Math.min(((float) i9) / ((float) i7), ((float) i10) / ((float) i8));
            }
            int max = Math.max(i8 / i10, i7 / i9);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
        d dVar = new d();
        f6618c = dVar;
        e = dVar;
        f6620f = g.a(dVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
    }

    public abstract int a(int i7, int i8, int i9, int i10);

    public abstract float b(int i7, int i8, int i9, int i10);
}
