package k3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class i<T, Y> {

    /* renamed from: a */
    public final LinkedHashMap f4703a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    public long f4704b;

    /* renamed from: c */
    public long f4705c;

    /* loaded from: classes.dex */
    public static final class a<Y> {

        /* renamed from: a */
        public final Y f4706a;

        /* renamed from: b */
        public final int f4707b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(int i7, Object obj) {
            this.f4706a = obj;
            this.f4707b = i7;
        }
    }

    public i(long j5) {
        this.f4704b = j5;
    }

    public final synchronized Y a(T t5) {
        a aVar;
        aVar = (a) this.f4703a.get(t5);
        return aVar != null ? aVar.f4706a : null;
    }

    public int b(Y y6) {
        return 1;
    }

    public void c(T t5, Y y6) {
    }

    public final synchronized Y d(T t5, Y y6) {
        int b2 = b(y6);
        long j5 = b2;
        if (j5 >= this.f4704b) {
            c(t5, y6);
            return null;
        }
        if (y6 != null) {
            this.f4705c += j5;
        }
        a aVar = (a) this.f4703a.put(t5, y6 == null ? null : new a(b2, y6));
        if (aVar != null) {
            this.f4705c -= aVar.f4707b;
            if (!aVar.f4706a.equals(y6)) {
                c(t5, aVar.f4706a);
            }
        }
        e(this.f4704b);
        return aVar != null ? aVar.f4706a : null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void e(long j5) {
        while (this.f4705c > j5) {
            Iterator it = this.f4703a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            a aVar = (a) entry.getValue();
            this.f4705c -= aVar.f4707b;
            Object key = entry.getKey();
            it.remove();
            c(key, aVar.f4706a);
        }
    }
}
