package s2;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h implements a<int[]> {
    @Override // s2.a
    public final String a() {
        return "IntegerArrayPool";
    }

    @Override // s2.a
    public final int b(int[] iArr) {
        return iArr.length;
    }

    @Override // s2.a
    public final int c() {
        return 4;
    }

    @Override // s2.a
    public final int[] newArray(int i7) {
        return new int[i7];
    }
}
