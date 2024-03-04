package i6;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a */
    public static s f4535a;

    /* renamed from: b */
    public static long f4536b;

    public static void a(s sVar) {
        if (sVar.f4533f != null || sVar.f4534g != null) {
            throw new IllegalArgumentException();
        }
        if (sVar.f4532d) {
            return;
        }
        synchronized (t.class) {
            long j5 = f4536b + 2048;
            if (j5 > 65536) {
                return;
            }
            f4536b = j5;
            sVar.f4533f = f4535a;
            sVar.f4531c = 0;
            sVar.f4530b = 0;
            f4535a = sVar;
        }
    }

    public static s b() {
        synchronized (t.class) {
            s sVar = f4535a;
            if (sVar != null) {
                f4535a = sVar.f4533f;
                sVar.f4533f = null;
                f4536b -= 2048;
                return sVar;
            }
            return new s();
        }
    }
}
