package b.a.a.a.c;

import java.util.Arrays;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class m extends l {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f127b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f127b = bArr;
    }

    @Override // b.a.a.a.c.l
    final byte[] x() {
        return this.f127b;
    }
}
