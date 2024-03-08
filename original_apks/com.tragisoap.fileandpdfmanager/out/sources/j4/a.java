package j4;

import android.graphics.Paint;
import android.graphics.Path;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f4580i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    public static final float[] f4581j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f4582k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f4583l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    public final Paint f4585b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f4586c;

    /* renamed from: d  reason: collision with root package name */
    public int f4587d;
    public int e;

    /* renamed from: f  reason: collision with root package name */
    public int f4588f;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f4590h;

    /* renamed from: g  reason: collision with root package name */
    public final Path f4589g = new Path();

    /* renamed from: a  reason: collision with root package name */
    public final Paint f4584a = new Paint();

    public a() {
        Paint paint = new Paint();
        this.f4590h = paint;
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
