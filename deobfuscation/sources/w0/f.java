package w0;

import androidx.activity.h;
import java.util.Arrays;

/* loaded from: classes.dex */
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
            } else if (this.f6370o[i7] == bVar) {
                return;
            } else {
                i7++;
            }
        }
    }

    public final void b(b bVar) {
        int i7 = this.f6371p;
        int i8 = 0;
        while (i8 < i7) {
            if (this.f6370o[i8] == bVar) {
                while (i8 < i7 - 1) {
                    b[] bVarArr = this.f6370o;
                    int i9 = i8 + 1;
                    bVarArr[i8] = bVarArr[i9];
                    i8 = i9;
                }
                this.f6371p--;
                return;
            }
            i8++;
        }
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

    public final String toString() {
        StringBuilder d7 = h.d("");
        d7.append(this.f6363g);
        return d7.toString();
    }
}
