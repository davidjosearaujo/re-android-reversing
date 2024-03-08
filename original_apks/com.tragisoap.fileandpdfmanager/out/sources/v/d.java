package v;

import g5.i;
import java.util.ArrayDeque;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f6129a;

    /* renamed from: b  reason: collision with root package name */
    public int f6130b;

    /* renamed from: c  reason: collision with root package name */
    public Object f6131c;

    /* renamed from: d  reason: collision with root package name */
    public Object f6132d;
    public Object e;

    public d(int i7) {
        if (i7 != 1) {
            this.f6131c = new int[16];
            this.f6132d = new int[16];
            int[] iArr = new int[16];
            int i8 = 0;
            while (i8 < 16) {
                int i9 = i8 + 1;
                iArr[i8] = i9;
                i8 = i9;
            }
            this.e = iArr;
            return;
        }
        this.f6129a = 64;
        this.f6130b = 5;
        this.f6131c = new ArrayDeque();
        this.f6132d = new ArrayDeque();
        this.e = new ArrayDeque();
    }

    public final int a(int i7) {
        int i8 = this.f6129a + 1;
        int[] iArr = (int[]) this.f6131c;
        int length = iArr.length;
        if (i8 > length) {
            int i9 = length * 2;
            int[] iArr2 = new int[i9];
            int[] iArr3 = new int[i9];
            i.X(iArr, iArr2, 0, 14);
            i.X((int[]) this.f6132d, iArr3, 0, 14);
            this.f6131c = iArr2;
            this.f6132d = iArr3;
        }
        int i10 = this.f6129a;
        this.f6129a = i10 + 1;
        int length2 = ((int[]) this.e).length;
        if (this.f6130b >= length2) {
            int i11 = length2 * 2;
            int[] iArr4 = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                iArr4[i12] = i13;
                i12 = i13;
            }
            i.X((int[]) this.e, iArr4, 0, 14);
            this.e = iArr4;
        }
        int i14 = this.f6130b;
        int[] iArr5 = (int[]) this.e;
        this.f6130b = iArr5[i14];
        Object obj = this.f6131c;
        ((int[]) obj)[i10] = i7;
        ((int[]) this.f6132d)[i10] = i14;
        iArr5[i14] = i10;
        int[] iArr6 = (int[]) obj;
        int i15 = iArr6[i10];
        while (i10 > 0) {
            int i16 = ((i10 + 1) >> 1) - 1;
            if (iArr6[i16] <= i15) {
                break;
            }
            b(i16, i10);
            i10 = i16;
        }
        return i14;
    }

    public final void b(int i7, int i8) {
        int[] iArr = (int[]) this.f6131c;
        int[] iArr2 = (int[]) this.f6132d;
        int[] iArr3 = (int[]) this.e;
        int i9 = iArr[i7];
        iArr[i7] = iArr[i8];
        iArr[i8] = i9;
        int i10 = iArr2[i7];
        iArr2[i7] = iArr2[i8];
        iArr2[i8] = i10;
        iArr3[iArr2[i7]] = i7;
        iArr3[iArr2[i8]] = i8;
    }
}
