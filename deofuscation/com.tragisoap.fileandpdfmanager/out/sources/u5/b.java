package u5;

import java.util.Random;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends a {

    /* renamed from: h  reason: collision with root package name */
    public final a f6118h = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public final Random initialValue() {
            return new Random();
        }
    }

    @Override // u5.a
    public final Random a() {
        Random random = this.f6118h.get();
        h.e(random, "get(...)");
        return random;
    }
}
