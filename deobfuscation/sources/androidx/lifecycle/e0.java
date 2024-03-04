package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a */
    public final LinkedHashMap f1859a = new LinkedHashMap();

    public final void a() {
        for (c0 c0Var : this.f1859a.values()) {
            c0Var.getClass();
            HashMap hashMap = c0Var.f1854a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    for (Object obj : c0Var.f1854a.values()) {
                        c0.a(obj);
                    }
                }
            }
            LinkedHashSet linkedHashSet = c0Var.f1855b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    for (Closeable closeable : c0Var.f1855b) {
                        c0.a(closeable);
                    }
                }
            }
            c0Var.b();
        }
        this.f1859a.clear();
    }
}
