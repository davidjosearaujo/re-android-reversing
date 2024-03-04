package u5;

import java.util.Random;
import r5.h;

/* loaded from: classes.dex */
public final class b extends u5.a {

    /* renamed from: h */
    public final a f6118h = new a();

    /* loaded from: classes.dex */
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
