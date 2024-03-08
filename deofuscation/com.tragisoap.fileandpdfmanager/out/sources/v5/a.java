package v5;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends u5.a {
    @Override // u5.a
    public final Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        h.e(current, "current(...)");
        return current;
    }
}
