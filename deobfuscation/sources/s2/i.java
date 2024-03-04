package s2;

import android.util.Log;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class i implements s2.b {

    /* renamed from: a */
    public final g<a, Object> f5940a = new g<>();

    /* renamed from: b */
    public final b f5941b = new b();

    /* renamed from: c */
    public final HashMap f5942c = new HashMap();

    /* renamed from: d */
    public final HashMap f5943d = new HashMap();
    public final int e;

    /* renamed from: f */
    public int f5944f;

    /* loaded from: classes.dex */
    public static final class a implements l {

        /* renamed from: a */
        public final b f5945a;

        /* renamed from: b */
        public int f5946b;

        /* renamed from: c */
        public Class<?> f5947c;

        public a(b bVar) {
            this.f5945a = bVar;
        }

        @Override // s2.l
        public final void a() {
            this.f5945a.c(this);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f5946b == aVar.f5946b && this.f5947c == aVar.f5947c;
            }
            return false;
        }

        public final int hashCode() {
            int i7 = this.f5946b * 31;
            Class<?> cls = this.f5947c;
            return i7 + (cls != null ? cls.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("Key{size=");
            d7.append(this.f5946b);
            d7.append("array=");
            d7.append(this.f5947c);
            d7.append('}');
            return d7.toString();
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends c<a> {
        @Override // s2.c
        public final a a() {
            return new a(this);
        }
    }

    public i(int i7) {
        this.e = i7;
    }

    @Override // s2.b
    public final synchronized void a(int i7) {
        try {
            if (i7 >= 40) {
                b();
            } else if (i7 >= 20 || i7 == 15) {
                f(this.e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // s2.b
    public final synchronized void b() {
        f(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x002f A[Catch: all -> 0x0053, TryCatch #0 {, blocks: (B:87:0x0001, B:89:0x0013, B:91:0x0017, B:97:0x0023, B:102:0x002f, B:104:0x004d, B:103:0x0040), top: B:110:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0040 A[Catch: all -> 0x0053, TryCatch #0 {, blocks: (B:87:0x0001, B:89:0x0013, B:91:0x0017, B:97:0x0023, B:102:0x002f, B:104:0x004d, B:103:0x0040), top: B:110:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0023 A[Catch: all -> 0x0053, TryCatch #0 {, blocks: (B:87:0x0001, B:89:0x0013, B:91:0x0017, B:97:0x0023, B:102:0x002f, B:104:0x004d, B:103:0x0040), top: B:110:0x0001 }] */
    @Override // s2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized <T> T c(int r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.NavigableMap r0 = r5.i(r7)     // Catch: java.lang.Throwable -> L53
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L53
            java.lang.Object r0 = r0.ceilingKey(r1)     // Catch: java.lang.Throwable -> L53
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L53
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2c
            int r3 = r5.f5944f     // Catch: java.lang.Throwable -> L53
            if (r3 == 0) goto L20
            int r4 = r5.e     // Catch: java.lang.Throwable -> L53
            int r4 = r4 / r3
            r3 = 2
            if (r4 < r3) goto L1e
            goto L20
        L1e:
            r3 = r2
            goto L21
        L20:
            r3 = r1
        L21:
            if (r3 != 0) goto L2d
            int r3 = r0.intValue()     // Catch: java.lang.Throwable -> L53
            int r4 = r6 * 8
            if (r3 > r4) goto L2c
            goto L2d
        L2c:
            r1 = r2
        L2d:
            if (r1 == 0) goto L40
            s2.i$b r6 = r5.f5941b     // Catch: java.lang.Throwable -> L53
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L53
            s2.l r6 = r6.b()     // Catch: java.lang.Throwable -> L53
            s2.i$a r6 = (s2.i.a) r6     // Catch: java.lang.Throwable -> L53
            r6.f5946b = r0     // Catch: java.lang.Throwable -> L53
            r6.f5947c = r7     // Catch: java.lang.Throwable -> L53
            goto L4d
        L40:
            s2.i$b r0 = r5.f5941b     // Catch: java.lang.Throwable -> L53
            s2.l r0 = r0.b()     // Catch: java.lang.Throwable -> L53
            s2.i$a r0 = (s2.i.a) r0     // Catch: java.lang.Throwable -> L53
            r0.f5946b = r6     // Catch: java.lang.Throwable -> L53
            r0.f5947c = r7     // Catch: java.lang.Throwable -> L53
            r6 = r0
        L4d:
            java.lang.Object r6 = r5.h(r6, r7)     // Catch: java.lang.Throwable -> L53
            monitor-exit(r5)
            return r6
        L53:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.i.c(int, java.lang.Class):java.lang.Object");
    }

    @Override // s2.b
    public final synchronized Object d() {
        a b2;
        b2 = this.f5941b.b();
        b2.f5946b = 8;
        b2.f5947c = byte[].class;
        return h(b2, byte[].class);
    }

    public final void e(int i7, Class<?> cls) {
        NavigableMap<Integer, Integer> i8 = i(cls);
        Integer num = i8.get(Integer.valueOf(i7));
        if (num != null) {
            if (num.intValue() == 1) {
                i8.remove(Integer.valueOf(i7));
                return;
            } else {
                i8.put(Integer.valueOf(i7), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i7 + ", this: " + this);
    }

    public final void f(int i7) {
        while (this.f5944f > i7) {
            Object c7 = this.f5940a.c();
            q2.a.i(c7);
            s2.a g2 = g(c7.getClass());
            this.f5944f -= g2.c() * g2.b(c7);
            e(g2.b(c7), c7.getClass());
            if (Log.isLoggable(g2.a(), 2)) {
                String a7 = g2.a();
                StringBuilder d7 = androidx.activity.h.d("evicted: ");
                d7.append(g2.b(c7));
                Log.v(a7, d7.toString());
            }
        }
    }

    public final <T> s2.a<T> g(Class<T> cls) {
        s2.a<T> aVar = (s2.a) this.f5943d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new h();
            } else if (!cls.equals(byte[].class)) {
                StringBuilder d7 = androidx.activity.h.d("No array pool found for: ");
                d7.append(cls.getSimpleName());
                throw new IllegalArgumentException(d7.toString());
            } else {
                aVar = new f();
            }
            this.f5943d.put(cls, aVar);
        }
        return aVar;
    }

    public final <T> T h(a aVar, Class<T> cls) {
        s2.a<T> g2 = g(cls);
        T t5 = (T) this.f5940a.a(aVar);
        if (t5 != null) {
            this.f5944f -= g2.c() * g2.b(t5);
            e(g2.b(t5), cls);
        }
        if (t5 == null) {
            if (Log.isLoggable(g2.a(), 2)) {
                String a7 = g2.a();
                StringBuilder d7 = androidx.activity.h.d("Allocated ");
                d7.append(aVar.f5946b);
                d7.append(" bytes");
                Log.v(a7, d7.toString());
            }
            return g2.newArray(aVar.f5946b);
        }
        return t5;
    }

    public final NavigableMap<Integer, Integer> i(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f5942c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f5942c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // s2.b
    public final synchronized <T> void put(T t5) {
        Class<?> cls = t5.getClass();
        s2.a<T> g2 = g(cls);
        int b2 = g2.b(t5);
        int c7 = g2.c() * b2;
        int i7 = 1;
        if (c7 <= this.e / 2) {
            a b7 = this.f5941b.b();
            b7.f5946b = b2;
            b7.f5947c = cls;
            this.f5940a.b(b7, t5);
            NavigableMap<Integer, Integer> i8 = i(cls);
            Integer num = i8.get(Integer.valueOf(b7.f5946b));
            Integer valueOf = Integer.valueOf(b7.f5946b);
            if (num != null) {
                i7 = 1 + num.intValue();
            }
            i8.put(valueOf, Integer.valueOf(i7));
            this.f5944f += c7;
            f(this.e);
        }
    }
}
