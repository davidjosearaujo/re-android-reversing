package g5;

import java.util.AbstractList;
import s5.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class e<E> extends AbstractList<E> implements b {
    public abstract int a();

    public abstract E b(int i7);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i7) {
        return b(i7);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
