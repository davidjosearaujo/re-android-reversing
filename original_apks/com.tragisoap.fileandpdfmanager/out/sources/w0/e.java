package w0;

import androidx.activity.h;
import java.util.Arrays;
import java.util.Comparator;
import w0.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends b {

    /* renamed from: f  reason: collision with root package name */
    public f[] f6356f = new f[128];

    /* renamed from: g  reason: collision with root package name */
    public f[] f6357g = new f[128];

    /* renamed from: h  reason: collision with root package name */
    public int f6358h = 0;

    /* renamed from: i  reason: collision with root package name */
    public b f6359i = new b();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Comparator<f> {
        @Override // java.util.Comparator
        public final int compare(f fVar, f fVar2) {
            return fVar.f6363g - fVar2.f6363g;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public f f6360a;

        public b() {
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        if (r9 < r8) goto L_0x0051;
     */
    @Override // w0.b, w0.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w0.f a(boolean[] r12) {
        /*
            r11 = this;
            r0 = -1
            r1 = 0
            r3 = r0
            r2 = r1
        L_0x0004:
            int r4 = r11.f6358h
            if (r2 >= r4) goto L_0x0057
            w0.f[] r4 = r11.f6356f
            r5 = r4[r2]
            int r6 = r5.f6363g
            boolean r6 = r12[r6]
            if (r6 == 0) goto L_0x0013
            goto L_0x0054
        L_0x0013:
            w0.e$b r6 = r11.f6359i
            r6.f6360a = r5
            r5 = 8
            r7 = 1
            if (r3 != r0) goto L_0x0036
        L_0x001c:
            if (r5 < 0) goto L_0x0032
            w0.f r4 = r6.f6360a
            float[] r4 = r4.m
            r4 = r4[r5]
            r8 = 0
            int r9 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r9 <= 0) goto L_0x002a
            goto L_0x0032
        L_0x002a:
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x002f
            goto L_0x0033
        L_0x002f:
            int r5 = r5 + -1
            goto L_0x001c
        L_0x0032:
            r7 = r1
        L_0x0033:
            if (r7 == 0) goto L_0x0054
            goto L_0x0053
        L_0x0036:
            r4 = r4[r3]
        L_0x0038:
            if (r5 < 0) goto L_0x0050
            float[] r8 = r4.m
            r8 = r8[r5]
            w0.f r9 = r6.f6360a
            float[] r9 = r9.m
            r9 = r9[r5]
            int r10 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x004b
            int r5 = r5 + -1
            goto L_0x0038
        L_0x004b:
            int r4 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r7 = r1
        L_0x0051:
            if (r7 == 0) goto L_0x0054
        L_0x0053:
            r3 = r2
        L_0x0054:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0057:
            if (r3 != r0) goto L_0x005b
            r11 = 0
            return r11
        L_0x005b:
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
    public final void i(d dVar, b bVar, boolean z6) {
        f fVar = bVar.f6333a;
        if (fVar != null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r5.f6358h = r2 - 1;
        r6.f6362f = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        r2 = r5.f6358h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r1 >= (r2 - 1)) goto L_0x001c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r2 = r5.f6356f;
        r3 = r1 + 1;
        r2[r1] = r2[r3];
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(w0.f r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            int r2 = r5.f6358h
            if (r1 >= r2) goto L_0x0026
            w0.f[] r2 = r5.f6356f
            r2 = r2[r1]
            if (r2 != r6) goto L_0x0023
        L_0x000c:
            int r2 = r5.f6358h
            int r3 = r2 + -1
            if (r1 >= r3) goto L_0x001c
            w0.f[] r2 = r5.f6356f
            int r3 = r1 + 1
            r4 = r2[r3]
            r2[r1] = r4
            r1 = r3
            goto L_0x000c
        L_0x001c:
            int r2 = r2 + -1
            r5.f6358h = r2
            r6.f6362f = r0
            return
        L_0x0023:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.e.k(w0.f):void");
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
