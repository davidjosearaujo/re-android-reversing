package f6;

import a6.m0;
import f6.x;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class w<T extends x & Comparable<? super T>> {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f4186b = AtomicIntegerFieldUpdater.newUpdater(w.class, "_size");
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    public T[] f4187a;

    public final void a(m0.b bVar) {
        bVar.b((m0.c) this);
        T[] tArr = this.f4187a;
        if (tArr == null) {
            tArr = (T[]) new x[4];
            this.f4187a = tArr;
        } else if (b() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, b() * 2);
            h.e(copyOf, "copyOf(this, newSize)");
            tArr = (T[]) ((x[]) copyOf);
            this.f4187a = tArr;
        }
        int b2 = b();
        f4186b.set(this, b2 + 1);
        tArr[b2] = bVar;
        bVar.f315g = b2;
        d(b2);
    }

    public final int b() {
        return f4186b.get(this);
    }

    public final T c(int i7) {
        T[] tArr = this.f4187a;
        h.c(tArr);
        f4186b.set(this, b() - 1);
        if (i7 < b()) {
            e(i7, b());
            int i8 = (i7 - 1) / 2;
            if (i7 > 0) {
                T t5 = tArr[i7];
                h.c(t5);
                T t6 = tArr[i8];
                h.c(t6);
                if (((Comparable) t5).compareTo(t6) < 0) {
                    e(i7, i8);
                    d(i8);
                }
            }
            while (true) {
                int i9 = (i7 * 2) + 1;
                if (i9 >= b()) {
                    break;
                }
                T[] tArr2 = this.f4187a;
                h.c(tArr2);
                int i10 = i9 + 1;
                if (i10 < b()) {
                    T t7 = tArr2[i10];
                    h.c(t7);
                    T t8 = tArr2[i9];
                    h.c(t8);
                    if (((Comparable) t7).compareTo(t8) < 0) {
                        i9 = i10;
                    }
                }
                T t9 = tArr2[i7];
                h.c(t9);
                T t10 = tArr2[i9];
                h.c(t10);
                if (((Comparable) t9).compareTo(t10) <= 0) {
                    break;
                }
                e(i7, i9);
                i7 = i9;
            }
        }
        T t11 = tArr[b()];
        h.c(t11);
        t11.b(null);
        t11.setIndex(-1);
        tArr[b()] = null;
        return t11;
    }

    public final void d(int i7) {
        while (i7 > 0) {
            T[] tArr = this.f4187a;
            h.c(tArr);
            int i8 = (i7 - 1) / 2;
            T t5 = tArr[i8];
            h.c(t5);
            T t6 = tArr[i7];
            h.c(t6);
            if (((Comparable) t5).compareTo(t6) > 0) {
                e(i7, i8);
                i7 = i8;
            } else {
                return;
            }
        }
    }

    public final void e(int i7, int i8) {
        T[] tArr = this.f4187a;
        h.c(tArr);
        T t5 = tArr[i8];
        h.c(t5);
        T t6 = tArr[i7];
        h.c(t6);
        tArr[i7] = t5;
        tArr[i8] = t6;
        t5.setIndex(i7);
        t6.setIndex(i8);
    }
}
