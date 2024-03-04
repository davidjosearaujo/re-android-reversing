package l5;

import g5.c;
import java.io.Serializable;
import java.lang.Enum;
import r5.h;

/* loaded from: classes.dex */
public final class a<T extends Enum<T>> extends c<T> implements Serializable {

    /* renamed from: f */
    public final T[] f5038f;

    public a(T[] tArr) {
        this.f5038f = tArr;
    }

    @Override // g5.a
    public final int a() {
        return this.f5038f.length;
    }

    @Override // g5.a, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Enum) {
            Enum r42 = (Enum) obj;
            h.f(r42, "element");
            T[] tArr = this.f5038f;
            int ordinal = r42.ordinal();
            h.f(tArr, "<this>");
            return ((ordinal < 0 || ordinal > tArr.length + (-1)) ? null : tArr[ordinal]) == r42;
        }
        return false;
    }

    @Override // g5.c, java.util.List
    public final Object get(int i7) {
        T[] tArr = this.f5038f;
        int length = tArr.length;
        if (i7 < 0 || i7 >= length) {
            throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + length);
        }
        return tArr[i7];
    }

    @Override // g5.c, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Enum) {
            Enum r42 = (Enum) obj;
            h.f(r42, "element");
            int ordinal = r42.ordinal();
            T[] tArr = this.f5038f;
            h.f(tArr, "<this>");
            if (((ordinal < 0 || ordinal > tArr.length + (-1)) ? null : tArr[ordinal]) == r42) {
                return ordinal;
            }
            return -1;
        }
        return -1;
    }

    @Override // g5.c, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            Enum r22 = (Enum) obj;
            h.f(r22, "element");
            return indexOf(r22);
        }
        return -1;
    }
}
