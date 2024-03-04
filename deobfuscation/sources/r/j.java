package r;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class j<K, V, T> implements Iterator<T>, s5.a {

    /* renamed from: f */
    public Object[] f5686f;

    /* renamed from: g */
    public int f5687g;

    /* renamed from: h */
    public int f5688h;

    public j() {
        i iVar = i.f5682d;
        this.f5686f = i.f5682d.f5685c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5688h < this.f5687g;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
