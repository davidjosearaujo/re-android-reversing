package b.a.a.a.c;

import java.lang.ref.WeakReference;
/* loaded from: /home/remnux/decompressedMalicious.dex */
abstract class n extends l {
    private static final WeakReference<byte[]> c = new WeakReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<byte[]> f128b = c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(byte[] bArr) {
        super(bArr);
    }

    @Override // b.a.a.a.c.l
    final byte[] x() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f128b.get();
            if (bArr == null) {
                bArr = z();
                this.f128b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] z();
}
