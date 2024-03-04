package p;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a */
    public Object f5445a;

    /* renamed from: b */
    public int f5446b;

    public o(int i7, int i8) {
        if (i8 != 2) {
            this.f5445a = new int[i7];
        } else if (i7 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        } else {
            this.f5445a = new Object[i7];
        }
    }

    public final void a(Object obj) {
        int i7 = this.f5446b;
        Object[] objArr = (Object[]) this.f5445a;
        if (i7 < objArr.length) {
            objArr[i7] = obj;
            this.f5446b = i7 + 1;
        }
    }
}
