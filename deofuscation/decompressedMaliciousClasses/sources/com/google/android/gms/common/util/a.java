package com.google.android.gms.common.util;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
@Deprecated
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class a<E> extends AbstractSet<E> {

    /* renamed from: a  reason: collision with root package name */
    private final a.a.a.d.a<E, E> f288a = new a.a.a.d.a<>();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(E e) {
        if (this.f288a.containsKey(e)) {
            return false;
        }
        this.f288a.put(e, e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> collection) {
        if (!(collection instanceof a)) {
            return super.addAll(collection);
        }
        int size = size();
        this.f288a.i(((a) collection).f288a);
        return size() > size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f288a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f288a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<E> iterator() {
        return this.f288a.keySet().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!this.f288a.containsKey(obj)) {
            return false;
        }
        this.f288a.remove(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f288a.size();
    }
}
