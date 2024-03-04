package p5;

import a0.e;
import java.io.File;
import p5.a;

/* loaded from: classes.dex */
public class c extends e {
    public static final void O(File file) {
        b bVar = b.f5587f;
        a.b bVar2 = new a.b();
        while (true) {
            boolean z6 = true;
            while (bVar2.hasNext()) {
                File next = bVar2.next();
                if (next.delete() || !next.exists()) {
                    if (z6) {
                        break;
                    }
                }
                z6 = false;
            }
            return;
        }
    }
}
