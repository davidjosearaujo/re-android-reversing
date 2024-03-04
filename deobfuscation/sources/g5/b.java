package g5;

import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p5.a;

/* loaded from: classes.dex */
public abstract class b<T> implements Iterator<T>, s5.a {

    /* renamed from: f */
    public v f4268f = v.f4288g;

    /* renamed from: g */
    public T f4269g;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        T t5;
        File a7;
        v vVar = this.f4268f;
        v vVar2 = v.f4290i;
        if (vVar != vVar2) {
            int ordinal = vVar.ordinal();
            if (ordinal != 0) {
                if (ordinal != 2) {
                    this.f4268f = vVar2;
                    a.b bVar = (a.b) this;
                    while (true) {
                        a.c peek = bVar.f5576h.peek();
                        if (peek == null) {
                            t5 = null;
                            break;
                        }
                        a7 = peek.a();
                        if (a7 == null) {
                            bVar.f5576h.pop();
                        } else if (r5.h.a(a7, peek.f5586a) || !a7.isDirectory() || bVar.f5576h.size() >= p5.a.this.f5575c) {
                            break;
                        } else {
                            bVar.f5576h.push(bVar.a(a7));
                        }
                    }
                    t5 = (T) a7;
                    if (t5 != null) {
                        bVar.f4269g = t5;
                        bVar.f4268f = v.f4287f;
                    } else {
                        bVar.f4268f = v.f4289h;
                    }
                    if (this.f4268f == v.f4287f) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f4268f = v.f4288g;
            return this.f4269g;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
