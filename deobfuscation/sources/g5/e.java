package g5;

import java.util.AbstractList;

/* loaded from: classes.dex */
public abstract class e<E> extends AbstractList<E> implements s5.b {
    public abstract int a();

    public abstract E b(int i7);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i7) {
        return b(i7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
