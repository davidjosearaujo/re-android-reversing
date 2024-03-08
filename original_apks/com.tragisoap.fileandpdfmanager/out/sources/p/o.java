package p;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public Object f5445a;

    /* renamed from: b  reason: collision with root package name */
    public int f5446b;

    public o(int i7, int i8) {
        if (i8 != 2) {
            this.f5445a = new int[i7];
        } else if (i7 > 0) {
            this.f5445a = new Object[i7];
        } else {
            throw new IllegalArgumentException("The max pool size must be > 0");
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
