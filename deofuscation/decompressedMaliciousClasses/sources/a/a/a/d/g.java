package a.a.a.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class g<F, S> {
    private static short[] $ = {22406, 22455, 22463, 22436, 22445, 18240, 22947};

    /* renamed from: a  reason: collision with root package name */
    public final F f102a;

    /* renamed from: b  reason: collision with root package name */
    public final S f103b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a(gVar.f102a, this.f102a) && a(gVar.f103b, this.f103b);
    }

    public int hashCode() {
        F f = this.f102a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f103b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return $(0, 5, 22486) + String.valueOf(this.f102a) + $(5, 6, 18272) + String.valueOf(this.f103b) + $(6, 7, 23006);
    }
}
