package i6;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f4529a;

    /* renamed from: b  reason: collision with root package name */
    public int f4530b;

    /* renamed from: c  reason: collision with root package name */
    public int f4531c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4532d;
    public boolean e;

    /* renamed from: f  reason: collision with root package name */
    public s f4533f;

    /* renamed from: g  reason: collision with root package name */
    public s f4534g;

    public s() {
        this.f4529a = new byte[2048];
        this.e = true;
        this.f4532d = false;
    }

    public s(s sVar) {
        byte[] bArr = sVar.f4529a;
        int i7 = sVar.f4530b;
        int i8 = sVar.f4531c;
        this.f4529a = bArr;
        this.f4530b = i7;
        this.f4531c = i8;
        this.e = false;
        this.f4532d = true;
        sVar.f4532d = true;
    }

    public final s a() {
        s sVar = this.f4533f;
        s sVar2 = sVar != this ? sVar : null;
        s sVar3 = this.f4534g;
        sVar3.f4533f = sVar;
        this.f4533f.f4534g = sVar3;
        this.f4533f = null;
        this.f4534g = null;
        return sVar2;
    }

    public final void b(s sVar) {
        sVar.f4534g = this;
        sVar.f4533f = this.f4533f;
        this.f4533f.f4534g = sVar;
        this.f4533f = sVar;
    }

    public final void c(s sVar, int i7) {
        if (sVar.e) {
            int i8 = sVar.f4531c;
            if (i8 + i7 > 2048) {
                if (!sVar.f4532d) {
                    int i9 = sVar.f4530b;
                    if ((i8 + i7) - i9 <= 2048) {
                        byte[] bArr = sVar.f4529a;
                        System.arraycopy(bArr, i9, bArr, 0, i8 - i9);
                        sVar.f4531c -= sVar.f4530b;
                        sVar.f4530b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f4529a, this.f4530b, sVar.f4529a, sVar.f4531c, i7);
            sVar.f4531c += i7;
            this.f4530b += i7;
            return;
        }
        throw new IllegalArgumentException();
    }
}
