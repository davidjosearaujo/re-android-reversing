package i6;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static s f4535a;

    /* renamed from: b  reason: collision with root package name */
    public static long f4536b;

    public static void a(s sVar) {
        if (sVar.f4533f != null || sVar.f4534g != null) {
            throw new IllegalArgumentException();
        } else if (!sVar.f4532d) {
            synchronized (t.class) {
                long j7 = f4536b + 2048;
                if (j7 <= 65536) {
                    f4536b = j7;
                    sVar.f4533f = f4535a;
                    sVar.f4531c = 0;
                    sVar.f4530b = 0;
                    f4535a = sVar;
                }
            }
        }
    }

    public static s b() {
        synchronized (t.class) {
            s sVar = f4535a;
            if (sVar == null) {
                return new s();
            }
            f4535a = sVar.f4533f;
            sVar.f4533f = null;
            f4536b -= 2048;
            return sVar;
        }
    }
}
