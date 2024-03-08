package s2;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f implements a<byte[]> {
    @Override // s2.a
    public final String a() {
        return "ByteArrayPool";
    }

    @Override // s2.a
    public final int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // s2.a
    public final int c() {
        return 1;
    }

    @Override // s2.a
    public final byte[] newArray(int i7) {
        return new byte[i7];
    }
}
