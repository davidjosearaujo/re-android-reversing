package w0;

import androidx.activity.h;
import androidx.fragment.app.s0;
import java.util.Arrays;
import w0.b;

/* loaded from: classes.dex */
public final class a implements b.a {

    /* renamed from: b */
    public final b f6325b;

    /* renamed from: c */
    public final c f6326c;

    /* renamed from: a */
    public int f6324a = 0;

    /* renamed from: d */
    public int f6327d = 8;
    public int[] e = new int[8];

    /* renamed from: f */
    public int[] f6328f = new int[8];

    /* renamed from: g */
    public float[] f6329g = new float[8];

    /* renamed from: h */
    public int f6330h = -1;

    /* renamed from: i */
    public int f6331i = -1;

    /* renamed from: j */
    public boolean f6332j = false;

    public a(b bVar, c cVar) {
        this.f6325b = bVar;
        this.f6326c = cVar;
    }

    @Override // w0.b.a
    public final float a(int i7) {
        int i8 = this.f6330h;
        for (int i9 = 0; i8 != -1 && i9 < this.f6324a; i9++) {
            if (i9 == i7) {
                return this.f6329g[i8];
            }
            i8 = this.f6328f[i8];
        }
        return 0.0f;
    }

    @Override // w0.b.a
    public final void b(f fVar, float f7) {
        if (f7 == 0.0f) {
            h(fVar, true);
            return;
        }
        int i7 = this.f6330h;
        if (i7 == -1) {
            this.f6330h = 0;
            this.f6329g[0] = f7;
            this.e[0] = fVar.f6363g;
            this.f6328f[0] = -1;
            fVar.f6372q++;
            fVar.a(this.f6325b);
            this.f6324a++;
            if (this.f6332j) {
                return;
            }
            int i8 = this.f6331i + 1;
            this.f6331i = i8;
            int[] iArr = this.e;
            if (i8 >= iArr.length) {
                this.f6332j = true;
                this.f6331i = iArr.length - 1;
                return;
            }
            return;
        }
        int i9 = -1;
        for (int i10 = 0; i7 != -1 && i10 < this.f6324a; i10++) {
            int i11 = this.e[i7];
            int i12 = fVar.f6363g;
            if (i11 == i12) {
                this.f6329g[i7] = f7;
                return;
            }
            if (i11 < i12) {
                i9 = i7;
            }
            i7 = this.f6328f[i7];
        }
        int i13 = this.f6331i;
        int i14 = i13 + 1;
        if (this.f6332j) {
            int[] iArr2 = this.e;
            if (iArr2[i13] != -1) {
                i13 = iArr2.length;
            }
        } else {
            i13 = i14;
        }
        int[] iArr3 = this.e;
        if (i13 >= iArr3.length && this.f6324a < iArr3.length) {
            int i15 = 0;
            while (true) {
                int[] iArr4 = this.e;
                if (i15 >= iArr4.length) {
                    break;
                } else if (iArr4[i15] == -1) {
                    i13 = i15;
                    break;
                } else {
                    i15++;
                }
            }
        }
        int[] iArr5 = this.e;
        if (i13 >= iArr5.length) {
            i13 = iArr5.length;
            int i16 = this.f6327d * 2;
            this.f6327d = i16;
            this.f6332j = false;
            this.f6331i = i13 - 1;
            this.f6329g = Arrays.copyOf(this.f6329g, i16);
            this.e = Arrays.copyOf(this.e, this.f6327d);
            this.f6328f = Arrays.copyOf(this.f6328f, this.f6327d);
        }
        this.e[i13] = fVar.f6363g;
        this.f6329g[i13] = f7;
        int[] iArr6 = this.f6328f;
        if (i9 != -1) {
            iArr6[i13] = iArr6[i9];
            iArr6[i9] = i13;
        } else {
            iArr6[i13] = this.f6330h;
            this.f6330h = i13;
        }
        fVar.f6372q++;
        fVar.a(this.f6325b);
        int i17 = this.f6324a + 1;
        this.f6324a = i17;
        if (!this.f6332j) {
            this.f6331i++;
        }
        int[] iArr7 = this.e;
        if (i17 >= iArr7.length) {
            this.f6332j = true;
        }
        if (this.f6331i >= iArr7.length) {
            this.f6332j = true;
            this.f6331i = iArr7.length - 1;
        }
    }

    @Override // w0.b.a
    public final int c() {
        return this.f6324a;
    }

    @Override // w0.b.a
    public final void clear() {
        int i7 = this.f6330h;
        for (int i8 = 0; i7 != -1 && i8 < this.f6324a; i8++) {
            f fVar = ((f[]) this.f6326c.f6340d)[this.e[i7]];
            if (fVar != null) {
                fVar.b(this.f6325b);
            }
            i7 = this.f6328f[i7];
        }
        this.f6330h = -1;
        this.f6331i = -1;
        this.f6332j = false;
        this.f6324a = 0;
    }

    @Override // w0.b.a
    public final void d(f fVar, float f7, boolean z6) {
        if (f7 <= -0.001f || f7 >= 0.001f) {
            int i7 = this.f6330h;
            if (i7 == -1) {
                this.f6330h = 0;
                this.f6329g[0] = f7;
                this.e[0] = fVar.f6363g;
                this.f6328f[0] = -1;
                fVar.f6372q++;
                fVar.a(this.f6325b);
                this.f6324a++;
                if (this.f6332j) {
                    return;
                }
                int i8 = this.f6331i + 1;
                this.f6331i = i8;
                int[] iArr = this.e;
                if (i8 >= iArr.length) {
                    this.f6332j = true;
                    this.f6331i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i9 = -1;
            for (int i10 = 0; i7 != -1 && i10 < this.f6324a; i10++) {
                int i11 = this.e[i7];
                int i12 = fVar.f6363g;
                if (i11 == i12) {
                    float[] fArr = this.f6329g;
                    float f8 = fArr[i7] + f7;
                    if (f8 > -0.001f && f8 < 0.001f) {
                        f8 = 0.0f;
                    }
                    fArr[i7] = f8;
                    if (f8 == 0.0f) {
                        if (i7 == this.f6330h) {
                            this.f6330h = this.f6328f[i7];
                        } else {
                            int[] iArr2 = this.f6328f;
                            iArr2[i9] = iArr2[i7];
                        }
                        if (z6) {
                            fVar.b(this.f6325b);
                        }
                        if (this.f6332j) {
                            this.f6331i = i7;
                        }
                        fVar.f6372q--;
                        this.f6324a--;
                        return;
                    }
                    return;
                }
                if (i11 < i12) {
                    i9 = i7;
                }
                i7 = this.f6328f[i7];
            }
            int i13 = this.f6331i;
            int i14 = i13 + 1;
            if (this.f6332j) {
                int[] iArr3 = this.e;
                if (iArr3[i13] != -1) {
                    i13 = iArr3.length;
                }
            } else {
                i13 = i14;
            }
            int[] iArr4 = this.e;
            if (i13 >= iArr4.length && this.f6324a < iArr4.length) {
                int i15 = 0;
                while (true) {
                    int[] iArr5 = this.e;
                    if (i15 >= iArr5.length) {
                        break;
                    } else if (iArr5[i15] == -1) {
                        i13 = i15;
                        break;
                    } else {
                        i15++;
                    }
                }
            }
            int[] iArr6 = this.e;
            if (i13 >= iArr6.length) {
                i13 = iArr6.length;
                int i16 = this.f6327d * 2;
                this.f6327d = i16;
                this.f6332j = false;
                this.f6331i = i13 - 1;
                this.f6329g = Arrays.copyOf(this.f6329g, i16);
                this.e = Arrays.copyOf(this.e, this.f6327d);
                this.f6328f = Arrays.copyOf(this.f6328f, this.f6327d);
            }
            this.e[i13] = fVar.f6363g;
            this.f6329g[i13] = f7;
            int[] iArr7 = this.f6328f;
            if (i9 != -1) {
                iArr7[i13] = iArr7[i9];
                iArr7[i9] = i13;
            } else {
                iArr7[i13] = this.f6330h;
                this.f6330h = i13;
            }
            fVar.f6372q++;
            fVar.a(this.f6325b);
            this.f6324a++;
            if (!this.f6332j) {
                this.f6331i++;
            }
            int i17 = this.f6331i;
            int[] iArr8 = this.e;
            if (i17 >= iArr8.length) {
                this.f6332j = true;
                this.f6331i = iArr8.length - 1;
            }
        }
    }

    @Override // w0.b.a
    public final float e(f fVar) {
        int i7 = this.f6330h;
        for (int i8 = 0; i7 != -1 && i8 < this.f6324a; i8++) {
            if (this.e[i7] == fVar.f6363g) {
                return this.f6329g[i7];
            }
            i7 = this.f6328f[i7];
        }
        return 0.0f;
    }

    @Override // w0.b.a
    public final boolean f(f fVar) {
        int i7 = this.f6330h;
        if (i7 == -1) {
            return false;
        }
        for (int i8 = 0; i7 != -1 && i8 < this.f6324a; i8++) {
            if (this.e[i7] == fVar.f6363g) {
                return true;
            }
            i7 = this.f6328f[i7];
        }
        return false;
    }

    @Override // w0.b.a
    public final f g(int i7) {
        int i8 = this.f6330h;
        for (int i9 = 0; i8 != -1 && i9 < this.f6324a; i9++) {
            if (i9 == i7) {
                return ((f[]) this.f6326c.f6340d)[this.e[i8]];
            }
            i8 = this.f6328f[i8];
        }
        return null;
    }

    @Override // w0.b.a
    public final float h(f fVar, boolean z6) {
        int i7 = this.f6330h;
        if (i7 == -1) {
            return 0.0f;
        }
        int i8 = 0;
        int i9 = -1;
        while (i7 != -1 && i8 < this.f6324a) {
            if (this.e[i7] == fVar.f6363g) {
                if (i7 == this.f6330h) {
                    this.f6330h = this.f6328f[i7];
                } else {
                    int[] iArr = this.f6328f;
                    iArr[i9] = iArr[i7];
                }
                if (z6) {
                    fVar.b(this.f6325b);
                }
                fVar.f6372q--;
                this.f6324a--;
                this.e[i7] = -1;
                if (this.f6332j) {
                    this.f6331i = i7;
                }
                return this.f6329g[i7];
            }
            i8++;
            i9 = i7;
            i7 = this.f6328f[i7];
        }
        return 0.0f;
    }

    @Override // w0.b.a
    public final void i(float f7) {
        int i7 = this.f6330h;
        for (int i8 = 0; i7 != -1 && i8 < this.f6324a; i8++) {
            float[] fArr = this.f6329g;
            fArr[i7] = fArr[i7] / f7;
            i7 = this.f6328f[i7];
        }
    }

    @Override // w0.b.a
    public final void j() {
        int i7 = this.f6330h;
        for (int i8 = 0; i7 != -1 && i8 < this.f6324a; i8++) {
            float[] fArr = this.f6329g;
            fArr[i7] = fArr[i7] * (-1.0f);
            i7 = this.f6328f[i7];
        }
    }

    @Override // w0.b.a
    public final float k(b bVar, boolean z6) {
        float e = e(bVar.f6333a);
        h(bVar.f6333a, z6);
        b.a aVar = bVar.f6336d;
        int c7 = aVar.c();
        for (int i7 = 0; i7 < c7; i7++) {
            f g2 = aVar.g(i7);
            d(g2, aVar.e(g2) * e, z6);
        }
        return e;
    }

    public final String toString() {
        int i7 = this.f6330h;
        String str = "";
        for (int i8 = 0; i7 != -1 && i8 < this.f6324a; i8++) {
            StringBuilder d7 = h.d(s0.h(str, " -> "));
            d7.append(this.f6329g[i7]);
            d7.append(" : ");
            StringBuilder d8 = h.d(d7.toString());
            d8.append(((f[]) this.f6326c.f6340d)[this.e[i7]]);
            str = d8.toString();
            i7 = this.f6328f[i7];
        }
        return str;
    }
}
