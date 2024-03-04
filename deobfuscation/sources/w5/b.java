package w5;

import g5.s;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b extends s {

    /* renamed from: f */
    public final int f6414f;

    /* renamed from: g */
    public final int f6415g;

    /* renamed from: h */
    public boolean f6416h;

    /* renamed from: i */
    public int f6417i;

    public b(int i7, int i8, int i9) {
        this.f6414f = i9;
        this.f6415g = i8;
        boolean z6 = true;
        if (i9 <= 0 ? i7 < i8 : i7 > i8) {
            z6 = false;
        }
        this.f6416h = z6;
        this.f6417i = z6 ? i7 : i8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6416h;
    }

    @Override // g5.s
    public final int nextInt() {
        int i7 = this.f6417i;
        if (i7 != this.f6415g) {
            this.f6417i = this.f6414f + i7;
        } else if (!this.f6416h) {
            throw new NoSuchElementException();
        } else {
            this.f6416h = false;
        }
        return i7;
    }
}
