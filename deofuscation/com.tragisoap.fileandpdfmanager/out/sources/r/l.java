package r;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends j {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f5689i;

    public /* synthetic */ l(int i7) {
        this.f5689i = i7;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5689i) {
            case 0:
                int i7 = this.f5688h + 2;
                this.f5688h = i7;
                return this.f5686f[i7 - 2];
            default:
                int i8 = this.f5688h + 2;
                this.f5688h = i8;
                return this.f5686f[i8 - 1];
        }
    }
}
