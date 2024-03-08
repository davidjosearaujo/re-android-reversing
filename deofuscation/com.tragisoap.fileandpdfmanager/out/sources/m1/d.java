package m1;

import java.util.Comparator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class d implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = (byte[]) obj2;
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i7 = 0; i7 < bArr.length; i7++) {
            byte b2 = bArr[i7];
            byte b7 = bArr2[i7];
            if (b2 != b7) {
                return b2 - b7;
            }
        }
        return 0;
    }
}
