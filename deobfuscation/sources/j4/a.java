package j4;

import android.graphics.Paint;
import android.graphics.Path;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: i */
    public static final int[] f4580i = new int[3];

    /* renamed from: j */
    public static final float[] f4581j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k */
    public static final int[] f4582k = new int[4];

    /* renamed from: l */
    public static final float[] f4583l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a */
    public final Paint f4584a;

    /* renamed from: b */
    public final Paint f4585b;

    /* renamed from: c */
    public final Paint f4586c;

    /* renamed from: d */
    public int f4587d;
    public int e;

    /* renamed from: f */
    public int f4588f;

    /* renamed from: g */
    public final Path f4589g = new Path();

    /* renamed from: h */
    public final Paint f4590h;

    public a() {
        Paint paint = new Paint();
        this.f4590h = paint;
        this.f4584a = new Paint();
        a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f4585b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f4586c = new Paint(paint2);
    }

    public final void a(int i7) {
        this.f4587d = i1.a.c(i7, 68);
        this.e = i1.a.c(i7, 20);
        this.f4588f = i1.a.c(i7, 0);
        this.f4584a.setColor(this.f4587d);
    }
}
