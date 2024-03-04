package w0;

import androidx.activity.h;
import java.util.Arrays;
import java.util.Comparator;
import w0.b;

/* loaded from: classes.dex */
public final class e extends w0.b {

    /* renamed from: f */
    public f[] f6356f;

    /* renamed from: g */
    public f[] f6357g;

    /* renamed from: h */
    public int f6358h;

    /* renamed from: i */
    public b f6359i;

    /* loaded from: classes.dex */
    public class a implements Comparator<f> {
        @Override // java.util.Comparator
        public final int compare(f fVar, f fVar2) {
            return fVar.f6363g - fVar2.f6363g;
        }
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a */
        public f f6360a;

        public b() {
            e.this = r1;
        }

        public final String toString() {
            String str = "[ ";
            if (this.f6360a != null) {
                for (int i7 = 0; i7 < 9; i7++) {
                    StringBuilder d7 = h.d(str);
                    d7.append(this.f6360a.m[i7]);
                    d7.append(" ");
                    str = d7.toString();
                }
            }
            return str + "] " + this.f6360a;
        }
    }

    public e(c cVar) {
        super(cVar);
        this.f6356f = new f[128];
        this.f6357g = new f[128];
        this.f6358h = 0;
        this.f6359i = new b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x004d, code lost:
        if (r9 < r8) goto L32;
     */
    @Override // w0.b, w0.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final w0.f a(boolean[] r12) {
        /*
            r11 = this;
            r0 = -1
            r1 = 0
            r3 = r0
            r2 = r1
        L4:
            int r4 = r11.f6358h
            if (r2 >= r4) goto L57
            w0.f[] r4 = r11.f6356f
            r5 = r4[r2]
            int r6 = r5.f6363g
            boolean r6 = r12[r6]
            if (r6 == 0) goto L13
            goto L54
        L13:
            w0.e$b r6 = r11.f6359i
            r6.f6360a = r5
            r5 = 8
            r7 = 1
            if (r3 != r0) goto L36
        L1c:
            if (r5 < 0) goto L32
            w0.f r4 = r6.f6360a
            float[] r4 = r4.m
            r4 = r4[r5]
            r8 = 0
            int r9 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r9 <= 0) goto L2a
            goto L32
        L2a:
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 >= 0) goto L2f
            goto L33
        L2f:
            int r5 = r5 + (-1)
            goto L1c
        L32:
            r7 = r1
        L33:
            if (r7 == 0) goto L54
            goto L53
        L36:
            r4 = r4[r3]
        L38:
            if (r5 < 0) goto L50
            float[] r8 = r4.m
            r8 = r8[r5]
            w0.f r9 = r6.f6360a
            float[] r9 = r9.m
            r9 = r9[r5]
            int r10 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r10 != 0) goto L4b
            int r5 = r5 + (-1)
            goto L38
        L4b:
            int r4 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r4 >= 0) goto L50
            goto L51
        L50:
            r7 = r1
        L51:
            if (r7 == 0) goto L54
        L53:
            r3 = r2
        L54:
            int r2 = r2 + 1
            goto L4
        L57:
            if (r3 != r0) goto L5b
            r11 = 0
            return r11
        L5b:
            w0.f[] r11 = r11.f6356f
            r11 = r11[r3]
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.e.a(boolean[]):w0.f");
    }

    @Override // w0.b
    public final boolean e() {
        return this.f6358h == 0;
    }

    @Override // w0.b
    public final void i(d dVar, w0.b bVar, boolean z6) {
        f fVar = bVar.f6333a;
        if (fVar == null) {
            return;
        }
        b.a aVar = bVar.f6336d;
        int c7 = aVar.c();
        for (int i7 = 0; i7 < c7; i7++) {
            f g2 = aVar.g(i7);
            float a7 = aVar.a(i7);
            b bVar2 = this.f6359i;
            bVar2.f6360a = g2;
            boolean z7 = true;
            if (g2.f6362f) {
                for (int i8 = 0; i8 < 9; i8++) {
                    float[] fArr = bVar2.f6360a.m;
                    float f7 = (fVar.m[i8] * a7) + fArr[i8];
                    fArr[i8] = f7;
                    if (Math.abs(f7) < 1.0E-4f) {
                        bVar2.f6360a.m[i8] = 0.0f;
                    } else {
                        z7 = false;
                    }
                }
                if (z7) {
                    e.this.k(bVar2.f6360a);
                }
                z7 = false;
            } else {
                for (int i9 = 0; i9 < 9; i9++) {
                    float f8 = fVar.m[i9];
                    if (f8 != 0.0f) {
                        float f9 = f8 * a7;
                        if (Math.abs(f9) < 1.0E-4f) {
                            f9 = 0.0f;
                        }
                        bVar2.f6360a.m[i9] = f9;
                    } else {
                        bVar2.f6360a.m[i9] = 0.0f;
                    }
                }
            }
            if (z7) {
                j(g2);
            }
            this.f6334b = (bVar.f6334b * a7) + this.f6334b;
        }
        k(fVar);
    }

    public final void j(f fVar) {
        int i7;
        int i8 = this.f6358h + 1;
        f[] fVarArr = this.f6356f;
        if (i8 > fVarArr.length) {
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, fVarArr.length * 2);
            this.f6356f = fVarArr2;
            this.f6357g = (f[]) Arrays.copyOf(fVarArr2, fVarArr2.length * 2);
        }
        f[] fVarArr3 = this.f6356f;
        int i9 = this.f6358h;
        fVarArr3[i9] = fVar;
        int i10 = i9 + 1;
        this.f6358h = i10;
        if (i10 > 1 && fVarArr3[i10 - 1].f6363g > fVar.f6363g) {
            int i11 = 0;
            while (true) {
                i7 = this.f6358h;
                if (i11 >= i7) {
                    break;
                }
                this.f6357g[i11] = this.f6356f[i11];
                i11++;
            }
            Arrays.sort(this.f6357g, 0, i7, new a());
            for (int i12 = 0; i12 < this.f6358h; i12++) {
                this.f6356f[i12] = this.f6357g[i12];
            }
        }
        fVar.f6362f = true;
        fVar.a(this);
    }

    public final void k(f fVar) {
        int i7 = 0;
        while (i7 < this.f6358h) {
            if (this.f6356f[i7] == fVar) {
                while (true) {
                    int i8 = this.f6358h;
                    if (i7 >= i8 - 1) {
                        this.f6358h = i8 - 1;
                        fVar.f6362f = false;
                        return;
                    }
                    f[] fVarArr = this.f6356f;
                    int i9 = i7 + 1;
                    fVarArr[i7] = fVarArr[i9];
                    i7 = i9;
                }
            } else {
                i7++;
            }
        }
    }

    @Override // w0.b
    public final String toString() {
        String str = " goal -> (" + this.f6334b + ") : ";
        for (int i7 = 0; i7 < this.f6358h; i7++) {
            this.f6359i.f6360a = this.f6356f[i7];
            StringBuilder d7 = h.d(str);
            d7.append(this.f6359i);
            d7.append(" ");
            str = d7.toString();
        }
        return str;
    }
}
