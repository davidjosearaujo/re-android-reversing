package a5;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a */
    public int f267a;

    /* renamed from: b */
    public int f268b;

    /* renamed from: c */
    public int f269c;

    /* renamed from: d */
    public final int[] f270d = new int[10];

    public final int a(int i7) {
        int i8 = 1 << i7;
        int i9 = (this.f269c & i8) != 0 ? 2 : 0;
        return (this.f268b & i8) != 0 ? i9 | 1 : i9;
    }

    public final int b() {
        if ((this.f267a & 128) != 0) {
            return this.f270d[7];
        }
        return 65536;
    }

    public final void c(int i7, int i8, int i9) {
        int[] iArr = this.f270d;
        if (i7 >= iArr.length) {
            return;
        }
        int i10 = 1 << i7;
        this.f267a |= i10;
        this.f268b = (i8 & 1) != 0 ? this.f268b | i10 : this.f268b & (~i10);
        this.f269c = (i8 & 2) != 0 ? this.f269c | i10 : this.f269c & (~i10);
        iArr[i7] = i9;
    }
}
