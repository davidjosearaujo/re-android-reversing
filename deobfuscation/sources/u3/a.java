package u3;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public final int f6102a;

    /* renamed from: b */
    public float f6103b;

    /* renamed from: c */
    public int f6104c;

    /* renamed from: d */
    public int f6105d;
    public float e;

    /* renamed from: f */
    public float f6106f;

    /* renamed from: g */
    public final int f6107g;

    /* renamed from: h */
    public final float f6108h;

    /* JADX WARN: Code restructure failed: missing block: B:214:0x00ba, code lost:
        if (r8 > r3.f6103b) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x00c9, code lost:
        if (r3.f6106f <= r3.f6103b) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x00cb, code lost:
        r5 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int r4, float r5, float r6, float r7, int r8, float r9, int r10, float r11, int r12, float r13) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
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
                    int i12 = i11;
                    int i13 = length2;
                    int i14 = i9;
                    int i15 = length;
                    a aVar2 = new a(i7, f8, f9, f10, iArr[i11], f11, i10, f12, i8, f7);
                    if (aVar == null || aVar2.f6108h < aVar.f6108h) {
                        if (aVar2.f6108h == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    i7++;
                    i11 = i12 + 1;
                    length2 = i13;
                    i9 = i14;
                    length = i15;
                }
                i9++;
            }
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("Arrangement [priority=");
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
