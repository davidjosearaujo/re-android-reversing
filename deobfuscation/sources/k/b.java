package k;

/* loaded from: classes.dex */
public final class b extends androidx.activity.result.c {

    /* renamed from: g */
    public static volatile b f4607g;

    /* renamed from: f */
    public c f4608f = new c();

    public static b p() {
        if (f4607g != null) {
            return f4607g;
        }
        synchronized (b.class) {
            if (f4607g == null) {
                f4607g = new b();
            }
        }
        return f4607g;
    }
}
