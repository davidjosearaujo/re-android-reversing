package r;

import r5.h;
import w5.a;
import w5.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i<K, V> {

    /* renamed from: d */
    public static final i f5682d = new i(0, 0, new Object[0], null);

    /* renamed from: a */
    public int f5683a;

    /* renamed from: b */
    public int f5684b;

    /* renamed from: c */
    public Object[] f5685c;

    public i(int i7, int i8, Object[] objArr, g6.i iVar) {
        this.f5683a = i7;
        this.f5684b = i8;
        this.f5685c = objArr;
    }

    public final boolean a(K k6) {
        a Y = d.Y(d.Z(0, this.f5685c.length));
        int i7 = Y.f6411f;
        int i8 = Y.f6412g;
        int i9 = Y.f6413h;
        if ((i9 > 0 && i7 <= i8) || (i9 < 0 && i8 <= i7)) {
            while (!h.a(k6, this.f5685c[i7])) {
                if (i7 != i8) {
                    i7 += i9;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(int i7, int i8, Object obj) {
        int i9 = 1 << ((i7 >> i8) & 31);
        if (e(i9)) {
            return h.a(obj, this.f5685c[c(i9)]);
        } else if (!f(i9)) {
            return false;
        } else {
            i<K, V> g2 = g(h(i9));
            return i8 == 30 ? g2.a(obj) : g2.b(i7, i8 + 5, obj);
        }
    }

    public final int c(int i7) {
        return Integer.bitCount(this.f5683a & (i7 - 1)) * 2;
    }

    public final Object d(int i7, int i8, Object obj) {
        int i9 = 1 << ((i7 >> i8) & 31);
        if (e(i9)) {
            int c7 = c(i9);
            if (h.a(obj, this.f5685c[c7])) {
                return i(c7);
            }
            return null;
        } else if (!f(i9)) {
            return null;
        } else {
            i<K, V> g2 = g(h(i9));
            if (i8 != 30) {
                return g2.d(i7, i8 + 5, obj);
            }
            a Y = d.Y(d.Z(0, g2.f5685c.length));
            int i10 = Y.f6411f;
            int i11 = Y.f6412g;
            int i12 = Y.f6413h;
            if ((i12 <= 0 || i10 > i11) && (i12 >= 0 || i11 > i10)) {
                return null;
            }
            while (!h.a(obj, g2.f5685c[i10])) {
                if (i10 == i11) {
                    return null;
                }
                i10 += i12;
            }
            return g2.i(i10);
        }
    }

    public final boolean e(int i7) {
        return (this.f5683a & i7) != 0;
    }

    public final boolean f(int i7) {
        return (this.f5684b & i7) != 0;
    }

    public final i<K, V> g(int i7) {
        Object obj = this.f5685c[i7];
        h.d(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (i) obj;
    }

    public final int h(int i7) {
        return (this.f5685c.length - 1) - Integer.bitCount(this.f5684b & (i7 - 1));
    }

    public final V i(int i7) {
        return (V) this.f5685c[i7 + 1];
    }
}
