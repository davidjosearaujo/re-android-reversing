package z2;

import r2.v;

/* loaded from: classes.dex */
public final class b implements v<byte[]> {

    /* renamed from: f */
    public final byte[] f6929f;

    public b(byte[] bArr) {
        q2.a.i(bArr);
        this.f6929f = bArr;
    }

    @Override // r2.v
    public final int b() {
        return this.f6929f.length;
    }

    @Override // r2.v
    public final Class<byte[]> c() {
        return byte[].class;
    }

    @Override // r2.v
    public final byte[] get() {
        return this.f6929f;
    }

    @Override // r2.v
    public final void recycle() {
    }
}
