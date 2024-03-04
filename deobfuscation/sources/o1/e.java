package o1;

/* loaded from: classes.dex */
public class e<T> implements d<T> {

    /* renamed from: a */
    public final Object[] f5271a;

    /* renamed from: b */
    public int f5272b;

    public e(int i7) {
        if (i7 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f5271a = new Object[i7];
    }

    @Override // o1.d
    public boolean a(T t5) {
        int i7;
        boolean z6;
        int i8 = 0;
        while (true) {
            i7 = this.f5272b;
            if (i8 >= i7) {
                z6 = false;
                break;
            } else if (this.f5271a[i8] == t5) {
                z6 = true;
                break;
            } else {
                i8++;
            }
        }
        if (z6) {
            throw new IllegalStateException("Already in the pool!");
        }
        Object[] objArr = this.f5271a;
        if (i7 < objArr.length) {
            objArr[i7] = t5;
            this.f5272b = i7 + 1;
            return true;
        }
        return false;
    }

    @Override // o1.d
    public T b() {
        int i7 = this.f5272b;
        if (i7 > 0) {
            int i8 = i7 - 1;
            Object[] objArr = this.f5271a;
            T t5 = (T) objArr[i8];
            objArr[i8] = null;
            this.f5272b = i7 - 1;
            return t5;
        }
        return null;
    }
}
