package w5;

import g5.s;
import java.util.NoSuchElementException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends s {

    /* renamed from: f  reason: collision with root package name */
    public final int f6414f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6415g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6416h;

    /* renamed from: i  reason: collision with root package name */
    public int f6417i;

    public b(int i7, int i8, int i9) {
        this.f6414f = i9;
        this.f6415g = i8;
        boolean z6 = true;
        z6 = false;
        if (i9 <= 0 ? i7 < i8 : i7 > i8) {
        }
        this.f6416h = z6;
        this.f6417i = !z6 ? i8 : i7;
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
        } else if (this.f6416h) {
            this.f6416h = false;
        } else {
            throw new NoSuchElementException();
        }
        return i7;
    }
}
