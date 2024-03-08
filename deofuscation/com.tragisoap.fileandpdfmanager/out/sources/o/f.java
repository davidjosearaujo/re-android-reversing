package o;

import java.util.LinkedHashMap;
import java.util.Locale;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class f<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f5196a;

    /* renamed from: b  reason: collision with root package name */
    public int f5197b;

    /* renamed from: c  reason: collision with root package name */
    public int f5198c;

    /* renamed from: d  reason: collision with root package name */
    public int f5199d;
    public int e;

    public f(int i7) {
        if (i7 > 0) {
            this.f5198c = i7;
            this.f5196a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final V a(K k6) {
        if (k6 != null) {
            synchronized (this) {
                V v6 = this.f5196a.get(k6);
                if (v6 != null) {
                    this.f5199d++;
                    return v6;
                }
                this.e++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V b(K r3, V r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0083
            monitor-enter(r2)
            int r0 = r2.f5197b     // Catch: all -> 0x0080
            int r0 = r0 + 1
            r2.f5197b = r0     // Catch: all -> 0x0080
            java.util.LinkedHashMap<K, V> r0 = r2.f5196a     // Catch: all -> 0x0080
            java.lang.Object r3 = r0.put(r3, r4)     // Catch: all -> 0x0080
            if (r3 == 0) goto L_0x0017
            int r4 = r2.f5197b     // Catch: all -> 0x0080
            int r4 = r4 + -1
            r2.f5197b = r4     // Catch: all -> 0x0080
        L_0x0017:
            monitor-exit(r2)     // Catch: all -> 0x0080
            int r4 = r2.f5198c
        L_0x001a:
            monitor-enter(r2)
            int r0 = r2.f5197b     // Catch: all -> 0x007d
            if (r0 < 0) goto L_0x005e
            java.util.LinkedHashMap<K, V> r0 = r2.f5196a     // Catch: all -> 0x007d
            boolean r0 = r0.isEmpty()     // Catch: all -> 0x007d
            if (r0 == 0) goto L_0x002b
            int r0 = r2.f5197b     // Catch: all -> 0x007d
            if (r0 != 0) goto L_0x005e
        L_0x002b:
            int r0 = r2.f5197b     // Catch: all -> 0x007d
            if (r0 <= r4) goto L_0x005c
            java.util.LinkedHashMap<K, V> r0 = r2.f5196a     // Catch: all -> 0x007d
            boolean r0 = r0.isEmpty()     // Catch: all -> 0x007d
            if (r0 == 0) goto L_0x0038
            goto L_0x005c
        L_0x0038:
            java.util.LinkedHashMap<K, V> r0 = r2.f5196a     // Catch: all -> 0x007d
            java.util.Set r0 = r0.entrySet()     // Catch: all -> 0x007d
            java.util.Iterator r0 = r0.iterator()     // Catch: all -> 0x007d
            java.lang.Object r0 = r0.next()     // Catch: all -> 0x007d
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: all -> 0x007d
            java.lang.Object r1 = r0.getKey()     // Catch: all -> 0x007d
            r0.getValue()     // Catch: all -> 0x007d
            java.util.LinkedHashMap<K, V> r0 = r2.f5196a     // Catch: all -> 0x007d
            r0.remove(r1)     // Catch: all -> 0x007d
            int r0 = r2.f5197b     // Catch: all -> 0x007d
            int r0 = r0 + -1
            r2.f5197b = r0     // Catch: all -> 0x007d
            monitor-exit(r2)     // Catch: all -> 0x007d
            goto L_0x001a
        L_0x005c:
            monitor-exit(r2)     // Catch: all -> 0x007d
            return r3
        L_0x005e:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: all -> 0x007d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: all -> 0x007d
            r4.<init>()     // Catch: all -> 0x007d
            java.lang.Class r0 = r2.getClass()     // Catch: all -> 0x007d
            java.lang.String r0 = r0.getName()     // Catch: all -> 0x007d
            r4.append(r0)     // Catch: all -> 0x007d
            java.lang.String r0 = ".sizeOf() is reporting inconsistent results!"
            r4.append(r0)     // Catch: all -> 0x007d
            java.lang.String r4 = r4.toString()     // Catch: all -> 0x007d
            r3.<init>(r4)     // Catch: all -> 0x007d
            throw r3     // Catch: all -> 0x007d
        L_0x007d:
            r3 = move-exception
            monitor-exit(r2)     // Catch: all -> 0x007d
            throw r3
        L_0x0080:
            r3 = move-exception
            monitor-exit(r2)     // Catch: all -> 0x0080
            throw r3
        L_0x0083:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "key == null || value == null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o.f.b(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final synchronized String toString() {
        int i7;
        int i8;
        i7 = this.f5199d;
        i8 = this.e + i7;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f5198c), Integer.valueOf(this.f5199d), Integer.valueOf(this.e), Integer.valueOf(i8 != 0 ? (i7 * 100) / i8 : 0));
    }
}
