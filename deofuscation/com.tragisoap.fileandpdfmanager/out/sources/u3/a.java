package u3;

import androidx.activity.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f6102a;

    /* renamed from: b  reason: collision with root package name */
    public float f6103b;

    /* renamed from: c  reason: collision with root package name */
    public int f6104c;

    /* renamed from: d  reason: collision with root package name */
    public int f6105d;
    public float e;

    /* renamed from: f  reason: collision with root package name */
    public float f6106f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6107g;

    /* renamed from: h  reason: collision with root package name */
    public final float f6108h;

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
        if (r8 > r3.f6103b) goto L_0x00cb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c9, code lost:
        if (r3.f6106f <= r3.f6103b) goto L_0x00cc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cb, code lost:
        r5 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(int r4, float r5, float r6, float r7, int r8, float r9, int r10, float r11, int r12, float r13) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.a.<init>(int, float, float, float, int, float, int, float, int, float):void");
    }

    public static a a(float f7, float f8, float f9, float f10, int[] iArr, float f11, int[] iArr2, float f12, int[] iArr3) {
        int i7 = 1;
        a aVar = null;
        for (int i8 : iArr3) {
            int length = iArr2.length;
            int i9 = 0;
            while (i9 < length) {
                int i10 = iArr2[i9];
                int length2 = iArr.length;
                int i11 = 0;
                while (i11 < length2) {
                    a aVar2 = new a(i7, f8, f9, f10, iArr[i11], f11, i10, f12, i8, f7);
                    if (aVar == null || aVar2.f6108h < aVar.f6108h) {
                        if (aVar2.f6108h == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    i7++;
                    i11++;
                    length2 = length2;
                    i9 = i9;
                    length = length;
                }
                i9++;
            }
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder d7 = h.d("Arrangement [priority=");
        d7.append(this.f6102a);
        d7.append(", smallCount=");
        d7.append(this.f6104c);
        d7.append(", smallSize=");
        d7.append(this.f6103b);
        d7.append(", mediumCount=");
        d7.append(this.f6105d);
        d7.append(", mediumSize=");
        d7.append(this.e);
        d7.append(", largeCount=");
        d7.append(this.f6107g);
        d7.append(", largeSize=");
        d7.append(this.f6106f);
        d7.append(", cost=");
        d7.append(this.f6108h);
        d7.append("]");
        return d7.toString();
    }
}
