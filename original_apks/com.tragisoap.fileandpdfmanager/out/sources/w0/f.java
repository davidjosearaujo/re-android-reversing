package w0;

import androidx.activity.h;
import java.util.Arrays;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f implements Comparable<f> {

    /* renamed from: f */
    public boolean f6362f;

    /* renamed from: j */
    public float f6366j;

    /* renamed from: n */
    public int f6369n;

    /* renamed from: g */
    public int f6363g = -1;

    /* renamed from: h */
    public int f6364h = -1;

    /* renamed from: i */
    public int f6365i = 0;

    /* renamed from: k */
    public boolean f6367k = false;

    /* renamed from: l */
    public float[] f6368l = new float[9];
    public float[] m = new float[9];

    /* renamed from: o */
    public b[] f6370o = new b[16];

    /* renamed from: p */
    public int f6371p = 0;

    /* renamed from: q */
    public int f6372q = 0;

    public f(int i7) {
        this.f6369n = i7;
    }

    public final void a(b bVar) {
        int i7 = 0;
        while (true) {
            int i8 = this.f6371p;
            if (i7 >= i8) {
                b[] bVarArr = this.f6370o;
                if (i8 >= bVarArr.length) {
                    this.f6370o = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f6370o;
                int i9 = this.f6371p;
                bVarArr2[i9] = bVar;
                this.f6371p = i9 + 1;
                return;
            } else if (this.f6370o[i7] != bVar) {
                i7++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 >= (r0 - 1)) goto L_0x0019;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
        r5 = r4.f6370o;
        r2 = r1 + 1;
        r5[r1] = r5[r2];
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        r4.f6371p--;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(w0.b r5) {
        /*
            r4 = this;
            int r0 = r4.f6371p
            r1 = 0
        L_0x0003:
            if (r1 >= r0) goto L_0x0023
            w0.b[] r2 = r4.f6370o
            r2 = r2[r1]
            if (r2 != r5) goto L_0x0020
        L_0x000b:
            int r5 = r0 + -1
            if (r1 >= r5) goto L_0x0019
            w0.b[] r5 = r4.f6370o
            int r2 = r1 + 1
            r3 = r5[r2]
            r5[r1] = r3
            r1 = r2
            goto L_0x000b
        L_0x0019:
            int r5 = r4.f6371p
            int r5 = r5 + -1
            r4.f6371p = r5
            return
        L_0x0020:
            int r1 = r1 + 1
            goto L_0x0003
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.f.b(w0.b):void");
    }

    public final void c() {
        this.f6369n = 5;
        this.f6365i = 0;
        this.f6363g = -1;
        this.f6364h = -1;
        this.f6366j = 0.0f;
        this.f6367k = false;
        int i7 = this.f6371p;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f6370o[i8] = null;
        }
        this.f6371p = 0;
        this.f6372q = 0;
        this.f6362f = false;
        Arrays.fill(this.m, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(f fVar) {
        return this.f6363g - fVar.f6363g;
    }

    public final void d(d dVar, float f7) {
        this.f6366j = f7;
        this.f6367k = true;
        int i7 = this.f6371p;
        this.f6364h = -1;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f6370o[i8].h(dVar, this, false);
        }
        this.f6371p = 0;
    }

    public final void e(d dVar, b bVar) {
        int i7 = this.f6371p;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f6370o[i8].i(dVar, bVar, false);
        }
        this.f6371p = 0;
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("");
        d7.append(this.f6363g);
        return d7.toString();
    }
}
