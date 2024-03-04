package m1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public static final d f5045a = new Comparator() { // from class: m1.d
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
    };

    /* loaded from: classes.dex */
    public static class a {
        public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:287:0x0090 A[LOOP:1: B:272:0x004b->B:287:0x0090, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0094 A[EDGE_INSN: B:337:0x0094->B:289:0x0094 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static m1.l a(android.content.Context r20, m1.f r21) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.e.a(android.content.Context, m1.f):m1.l");
    }
}
