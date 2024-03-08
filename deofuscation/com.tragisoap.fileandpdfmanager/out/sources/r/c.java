package r;

import java.util.Iterator;
import java.util.NoSuchElementException;
import r5.h;
import s5.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class c<K, V, T> implements Iterator<T>, a {

    /* renamed from: f  reason: collision with root package name */
    public final j<K, V, T>[] f5676f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5678h = true;

    /* renamed from: g  reason: collision with root package name */
    public int f5677g = 0;

    public c(i<K, V> iVar, j<K, V, T>[] jVarArr) {
        h.f(iVar, "node");
        this.f5676f = jVarArr;
        j<K, V, T> jVar = jVarArr[0];
        Object[] objArr = iVar.f5685c;
        jVar.getClass();
        h.f(objArr, "buffer");
        jVar.f5686f = objArr;
        jVar.f5687g = Integer.bitCount(iVar.f5683a) * 2;
        jVar.f5688h = 0;
        a();
    }

    public final void a() {
        j<K, V, T>[] jVarArr = this.f5676f;
        int i7 = this.f5677g;
        j<K, V, T> jVar = jVarArr[i7];
        if (!(jVar.f5688h < jVar.f5687g)) {
            while (-1 < i7) {
                int b2 = b(i7);
                if (b2 == -1) {
                    j<K, V, T> jVar2 = this.f5676f[i7];
                    int i8 = jVar2.f5688h;
                    Object[] objArr = jVar2.f5686f;
                    if (i8 < objArr.length) {
                        int length = objArr.length;
                        jVar2.f5688h = i8 + 1;
                        b2 = b(i7);
                    }
                }
                if (b2 != -1) {
                    this.f5677g = b2;
                    return;
                }
                if (i7 > 0) {
                    j<K, V, T> jVar3 = this.f5676f[i7 - 1];
                    int i9 = jVar3.f5688h;
                    int length2 = jVar3.f5686f.length;
                    jVar3.f5688h = i9 + 1;
                }
                j<K, V, T> jVar4 = this.f5676f[i7];
                Object[] objArr2 = i.f5682d.f5685c;
                jVar4.getClass();
                h.f(objArr2, "buffer");
                jVar4.f5686f = objArr2;
                jVar4.f5687g = 0;
                jVar4.f5688h = 0;
                i7--;
            }
            this.f5678h = false;
        }
    }

    public final int b(int i7) {
        j<K, V, T> jVar;
        j<K, V, T> jVar2 = this.f5676f[i7];
        int i8 = jVar2.f5688h;
        if (i8 < jVar2.f5687g) {
            return i7;
        }
        Object[] objArr = jVar2.f5686f;
        if (!(i8 < objArr.length)) {
            return -1;
        }
        int length = objArr.length;
        Object obj = objArr[i8];
        h.d(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        i iVar = (i) obj;
        if (i7 == 6) {
            jVar = this.f5676f[i7 + 1];
            Object[] objArr2 = iVar.f5685c;
            int length2 = objArr2.length;
            jVar.getClass();
            jVar.f5686f = objArr2;
            jVar.f5687g = length2;
        } else {
            jVar = this.f5676f[i7 + 1];
            Object[] objArr3 = iVar.f5685c;
            jVar.getClass();
            h.f(objArr3, "buffer");
            jVar.f5686f = objArr3;
            jVar.f5687g = Integer.bitCount(iVar.f5683a) * 2;
        }
        jVar.f5688h = 0;
        return b(i7 + 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5678h;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f5678h) {
            T next = this.f5676f[this.f5677g].next();
            a();
            return next;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
