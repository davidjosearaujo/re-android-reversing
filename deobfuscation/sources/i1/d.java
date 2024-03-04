package i1;

import android.graphics.Path;
import android.util.Log;
import androidx.fragment.app.s0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public final class d {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public char f4467a;

        /* renamed from: b */
        public float[] f4468b;

        public a(char c7, float[] fArr) {
            this.f4467a = c7;
            this.f4468b = fArr;
        }

        public a(a aVar) {
            this.f4467a = aVar.f4467a;
            float[] fArr = aVar.f4468b;
            this.f4468b = d.b(fArr, fArr.length);
        }

        public static void a(Path path, float f7, float f8, float f9, float f10, float f11, float f12, float f13, boolean z6, boolean z7) {
            double d7;
            double d8;
            double radians = Math.toRadians(f13);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d9 = f7;
            double d10 = f8;
            double d11 = (d10 * sin) + (d9 * cos);
            double d12 = d9;
            double d13 = f11;
            double d14 = d11 / d13;
            double d15 = f12;
            double d16 = ((d10 * cos) + ((-f7) * sin)) / d15;
            double d17 = d10;
            double d18 = f10;
            double d19 = ((d18 * sin) + (f9 * cos)) / d13;
            double d20 = ((d18 * cos) + ((-f9) * sin)) / d15;
            double d21 = d14 - d19;
            double d22 = d16 - d20;
            double d23 = (d14 + d19) / 2.0d;
            double d24 = (d16 + d20) / 2.0d;
            double d25 = (d22 * d22) + (d21 * d21);
            if (d25 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d26 = (1.0d / d25) - 0.25d;
            if (d26 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d25);
                float sqrt = (float) (Math.sqrt(d25) / 1.99999d);
                a(path, f7, f8, f9, f10, f11 * sqrt, f12 * sqrt, f13, z6, z7);
                return;
            }
            double sqrt2 = Math.sqrt(d26);
            double d27 = d21 * sqrt2;
            double d28 = sqrt2 * d22;
            if (z6 == z7) {
                d7 = d23 - d28;
                d8 = d24 + d27;
            } else {
                d7 = d23 + d28;
                d8 = d24 - d27;
            }
            double atan2 = Math.atan2(d16 - d8, d14 - d7);
            double atan22 = Math.atan2(d20 - d8, d19 - d7) - atan2;
            int i7 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z7 != (i7 >= 0)) {
                atan22 = i7 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d29 = d7 * d13;
            double d30 = d8 * d15;
            double d31 = (d29 * cos) - (d30 * sin);
            double d32 = (d30 * cos) + (d29 * sin);
            int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
            double cos2 = Math.cos(radians);
            double sin2 = Math.sin(radians);
            double cos3 = Math.cos(atan2);
            double sin3 = Math.sin(atan2);
            double d33 = -d13;
            double d34 = d33 * cos2;
            double d35 = d15 * sin2;
            double d36 = (d34 * sin3) - (d35 * cos3);
            double d37 = d33 * sin2;
            double d38 = d15 * cos2;
            double d39 = (cos3 * d38) + (sin3 * d37);
            double d40 = d38;
            double d41 = atan22 / ceil;
            int i8 = 0;
            while (i8 < ceil) {
                double d42 = atan2 + d41;
                double sin4 = Math.sin(d42);
                double cos4 = Math.cos(d42);
                double d43 = d41;
                double d44 = (((d13 * cos2) * cos4) + d31) - (d35 * sin4);
                double d45 = d40;
                double d46 = d31;
                double d47 = (d45 * sin4) + (d13 * sin2 * cos4) + d32;
                double d48 = (d34 * sin4) - (d35 * cos4);
                double d49 = (cos4 * d45) + (sin4 * d37);
                double d50 = d42 - atan2;
                double tan = Math.tan(d50 / 2.0d);
                double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d50)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d36 * sqrt3) + d12), (float) ((d39 * sqrt3) + d17), (float) (d44 - (sqrt3 * d48)), (float) (d47 - (sqrt3 * d49)), (float) d44, (float) d47);
                i8++;
                atan2 = d42;
                d37 = d37;
                cos2 = cos2;
                ceil = ceil;
                d39 = d49;
                d13 = d13;
                d36 = d48;
                d12 = d44;
                d17 = d47;
                d31 = d46;
                d41 = d43;
                d40 = d45;
            }
        }

        public static void b(a[] aVarArr, Path path) {
            int i7;
            int i8;
            float[] fArr;
            char c7;
            int i9;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float f20;
            float f21;
            float f22;
            float f23;
            float f24;
            float f25;
            float f26;
            float f27;
            a[] aVarArr2 = aVarArr;
            int i10 = 6;
            float[] fArr2 = new float[6];
            char c8 = 'm';
            int i11 = 0;
            char c9 = 'm';
            int i12 = 0;
            while (i12 < aVarArr2.length) {
                a aVar = aVarArr2[i12];
                char c10 = aVar.f4467a;
                float[] fArr3 = aVar.f4468b;
                float f28 = fArr2[i11];
                float f29 = fArr2[1];
                float f30 = fArr2[2];
                float f31 = fArr2[3];
                float f32 = fArr2[4];
                float f33 = fArr2[5];
                switch (c10) {
                    case 'A':
                    case 'a':
                        i7 = 7;
                        break;
                    case 'C':
                    case 'c':
                        i7 = i10;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i7 = 1;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i7 = 4;
                        break;
                    case SubsamplingScaleImageView.ORIENTATION_90 /* 90 */:
                    case 'z':
                        path.close();
                        path.moveTo(f32, f33);
                        f28 = f32;
                        f30 = f28;
                        f29 = f33;
                        f31 = f29;
                    default:
                        i7 = 2;
                        break;
                }
                float f34 = f32;
                float f35 = f33;
                float f36 = f28;
                float f37 = f29;
                int i13 = i11;
                while (i13 < fArr3.length) {
                    if (c10 != 'A') {
                        if (c10 != 'C') {
                            if (c10 == 'H') {
                                i8 = i13;
                                fArr = fArr3;
                                c7 = c10;
                                i9 = i12;
                                int i14 = i8 + 0;
                                path.lineTo(fArr[i14], f37);
                                f36 = fArr[i14];
                            } else if (c10 == 'Q') {
                                i8 = i13;
                                fArr = fArr3;
                                c7 = c10;
                                i9 = i12;
                                int i15 = i8 + 0;
                                int i16 = i8 + 1;
                                int i17 = i8 + 2;
                                int i18 = i8 + 3;
                                path.quadTo(fArr[i15], fArr[i16], fArr[i17], fArr[i18]);
                                f7 = fArr[i15];
                                f8 = fArr[i16];
                                f36 = fArr[i17];
                                f37 = fArr[i18];
                            } else if (c10 == 'V') {
                                i8 = i13;
                                fArr = fArr3;
                                c7 = c10;
                                i9 = i12;
                                int i19 = i8 + 0;
                                path.lineTo(f36, fArr[i19]);
                                f37 = fArr[i19];
                            } else if (c10 != 'a') {
                                if (c10 != 'c') {
                                    if (c10 == 'h') {
                                        i8 = i13;
                                        int i20 = i8 + 0;
                                        path.rLineTo(fArr3[i20], 0.0f);
                                        f36 += fArr3[i20];
                                    } else if (c10 != 'q') {
                                        if (c10 != 'v') {
                                            if (c10 != 'L') {
                                                if (c10 == 'M') {
                                                    i8 = i13;
                                                    f18 = fArr3[i8 + 0];
                                                    f19 = fArr3[i8 + 1];
                                                    if (i8 > 0) {
                                                        path.lineTo(f18, f19);
                                                    } else {
                                                        path.moveTo(f18, f19);
                                                        f34 = f18;
                                                        f35 = f19;
                                                    }
                                                } else if (c10 == 'S') {
                                                    i8 = i13;
                                                    float f38 = f37;
                                                    float f39 = f36;
                                                    if (c9 == 'c' || c9 == 's' || c9 == 'C' || c9 == 'S') {
                                                        f20 = (f38 * 2.0f) - f31;
                                                        f21 = (f39 * 2.0f) - f30;
                                                    } else {
                                                        f21 = f39;
                                                        f20 = f38;
                                                    }
                                                    int i21 = i8 + 0;
                                                    int i22 = i8 + 1;
                                                    int i23 = i8 + 2;
                                                    int i24 = i8 + 3;
                                                    path.cubicTo(f21, f20, fArr3[i21], fArr3[i22], fArr3[i23], fArr3[i24]);
                                                    float f40 = fArr3[i21];
                                                    float f41 = fArr3[i22];
                                                    f15 = fArr3[i23];
                                                    f14 = fArr3[i24];
                                                    f30 = f40;
                                                    f31 = f41;
                                                    f36 = f15;
                                                    f37 = f14;
                                                } else if (c10 == 'T') {
                                                    i8 = i13;
                                                    float f42 = f37;
                                                    float f43 = f36;
                                                    if (c9 == 'q' || c9 == 't' || c9 == 'Q' || c9 == 'T') {
                                                        f22 = (f43 * 2.0f) - f30;
                                                        f23 = (f42 * 2.0f) - f31;
                                                    } else {
                                                        f22 = f43;
                                                        f23 = f42;
                                                    }
                                                    int i25 = i8 + 0;
                                                    int i26 = i8 + 1;
                                                    path.quadTo(f22, f23, fArr3[i25], fArr3[i26]);
                                                    f31 = f23;
                                                    f30 = f22;
                                                    fArr = fArr3;
                                                    c7 = c10;
                                                    i9 = i12;
                                                    f36 = fArr3[i25];
                                                    f37 = fArr3[i26];
                                                } else if (c10 == 'l') {
                                                    i8 = i13;
                                                    f16 = f37;
                                                    int i27 = i8 + 0;
                                                    int i28 = i8 + 1;
                                                    path.rLineTo(fArr3[i27], fArr3[i28]);
                                                    f36 += fArr3[i27];
                                                    f17 = fArr3[i28];
                                                } else if (c10 == c8) {
                                                    i8 = i13;
                                                    float f44 = fArr3[i8 + 0];
                                                    f36 += f44;
                                                    float f45 = fArr3[i8 + 1];
                                                    f37 += f45;
                                                    if (i8 > 0) {
                                                        path.rLineTo(f44, f45);
                                                    } else {
                                                        path.rMoveTo(f44, f45);
                                                        f35 = f37;
                                                        f34 = f36;
                                                    }
                                                } else if (c10 != 's') {
                                                    if (c10 == 't') {
                                                        if (c9 == 'q' || c9 == 't' || c9 == 'Q' || c9 == 'T') {
                                                            f26 = f36 - f30;
                                                            f27 = f37 - f31;
                                                        } else {
                                                            f27 = 0.0f;
                                                            f26 = 0.0f;
                                                        }
                                                        int i29 = i13 + 0;
                                                        int i30 = i13 + 1;
                                                        path.rQuadTo(f26, f27, fArr3[i29], fArr3[i30]);
                                                        float f46 = f26 + f36;
                                                        float f47 = f27 + f37;
                                                        f36 += fArr3[i29];
                                                        f37 += fArr3[i30];
                                                        f31 = f47;
                                                        f30 = f46;
                                                    }
                                                    i8 = i13;
                                                } else {
                                                    if (c9 == 'c' || c9 == 's' || c9 == 'C' || c9 == 'S') {
                                                        f24 = f37 - f31;
                                                        f25 = f36 - f30;
                                                    } else {
                                                        f25 = 0.0f;
                                                        f24 = 0.0f;
                                                    }
                                                    int i31 = i13 + 0;
                                                    int i32 = i13 + 1;
                                                    int i33 = i13 + 2;
                                                    int i34 = i13 + 3;
                                                    i8 = i13;
                                                    f9 = f37;
                                                    float f48 = f36;
                                                    path.rCubicTo(f25, f24, fArr3[i31], fArr3[i32], fArr3[i33], fArr3[i34]);
                                                    f10 = fArr3[i31] + f48;
                                                    f11 = fArr3[i32] + f9;
                                                    f12 = f48 + fArr3[i33];
                                                    f13 = fArr3[i34];
                                                }
                                                f36 = f34;
                                                f37 = f35;
                                            } else {
                                                i8 = i13;
                                                int i35 = i8 + 0;
                                                int i36 = i8 + 1;
                                                path.lineTo(fArr3[i35], fArr3[i36]);
                                                f18 = fArr3[i35];
                                                f19 = fArr3[i36];
                                            }
                                            f36 = f18;
                                            f37 = f19;
                                        } else {
                                            i8 = i13;
                                            f16 = f37;
                                            int i37 = i8 + 0;
                                            path.rLineTo(0.0f, fArr3[i37]);
                                            f17 = fArr3[i37];
                                        }
                                        f37 = f16 + f17;
                                    } else {
                                        i8 = i13;
                                        f9 = f37;
                                        float f49 = f36;
                                        int i38 = i8 + 0;
                                        int i39 = i8 + 1;
                                        int i40 = i8 + 2;
                                        int i41 = i8 + 3;
                                        path.rQuadTo(fArr3[i38], fArr3[i39], fArr3[i40], fArr3[i41]);
                                        f10 = fArr3[i38] + f49;
                                        f11 = fArr3[i39] + f9;
                                        float f50 = f49 + fArr3[i40];
                                        float f51 = fArr3[i41];
                                        f12 = f50;
                                        f13 = f51;
                                    }
                                    fArr = fArr3;
                                    c7 = c10;
                                    i9 = i12;
                                } else {
                                    i8 = i13;
                                    f9 = f37;
                                    float f52 = f36;
                                    int i42 = i8 + 2;
                                    int i43 = i8 + 3;
                                    int i44 = i8 + 4;
                                    int i45 = i8 + 5;
                                    path.rCubicTo(fArr3[i8 + 0], fArr3[i8 + 1], fArr3[i42], fArr3[i43], fArr3[i44], fArr3[i45]);
                                    f10 = fArr3[i42] + f52;
                                    f11 = fArr3[i43] + f9;
                                    f12 = f52 + fArr3[i44];
                                    f13 = fArr3[i45];
                                }
                                f14 = f9 + f13;
                                f30 = f10;
                                f31 = f11;
                                f15 = f12;
                                f36 = f15;
                                f37 = f14;
                                fArr = fArr3;
                                c7 = c10;
                                i9 = i12;
                            } else {
                                i8 = i13;
                                float f53 = f37;
                                float f54 = f36;
                                int i46 = i8 + 5;
                                int i47 = i8 + 6;
                                fArr = fArr3;
                                c7 = c10;
                                i9 = i12;
                                a(path, f54, f53, fArr3[i46] + f54, fArr3[i47] + f53, fArr3[i8 + 0], fArr3[i8 + 1], fArr3[i8 + 2], fArr3[i8 + 3] != 0.0f, fArr3[i8 + 4] != 0.0f);
                                f36 = f54 + fArr[i46];
                                f37 = f53 + fArr[i47];
                            }
                            i13 = i8 + i7;
                            c9 = c7;
                            c10 = c9;
                            fArr3 = fArr;
                            i12 = i9;
                            c8 = 'm';
                            i11 = 0;
                        } else {
                            i8 = i13;
                            fArr = fArr3;
                            c7 = c10;
                            i9 = i12;
                            int i48 = i8 + 2;
                            int i49 = i8 + 3;
                            int i50 = i8 + 4;
                            int i51 = i8 + 5;
                            path.cubicTo(fArr[i8 + 0], fArr[i8 + 1], fArr[i48], fArr[i49], fArr[i50], fArr[i51]);
                            float f55 = fArr[i50];
                            float f56 = fArr[i51];
                            f7 = fArr[i48];
                            f36 = f55;
                            f37 = f56;
                            f8 = fArr[i49];
                        }
                        f30 = f7;
                        f31 = f8;
                        i13 = i8 + i7;
                        c9 = c7;
                        c10 = c9;
                        fArr3 = fArr;
                        i12 = i9;
                        c8 = 'm';
                        i11 = 0;
                    } else {
                        i8 = i13;
                        fArr = fArr3;
                        c7 = c10;
                        i9 = i12;
                        int i52 = i8 + 5;
                        int i53 = i8 + 6;
                        a(path, f36, f37, fArr[i52], fArr[i53], fArr[i8 + 0], fArr[i8 + 1], fArr[i8 + 2], fArr[i8 + 3] != 0.0f, fArr[i8 + 4] != 0.0f);
                        f36 = fArr[i52];
                        f37 = fArr[i53];
                    }
                    f31 = f37;
                    f30 = f36;
                    i13 = i8 + i7;
                    c9 = c7;
                    c10 = c9;
                    fArr3 = fArr;
                    i12 = i9;
                    c8 = 'm';
                    i11 = 0;
                }
                int i54 = i12;
                fArr2[i11] = f36;
                fArr2[1] = f37;
                fArr2[2] = f30;
                fArr2[3] = f31;
                fArr2[4] = f34;
                fArr2[5] = f35;
                i12 = i54 + 1;
                i10 = 6;
                c8 = 'm';
                c9 = aVarArr[i54].f4467a;
                aVarArr2 = aVarArr;
            }
        }
    }

    public static boolean a(a[] aVarArr, a[] aVarArr2) {
        if (aVarArr == null || aVarArr2 == null || aVarArr.length != aVarArr2.length) {
            return false;
        }
        for (int i7 = 0; i7 < aVarArr.length; i7++) {
            a aVar = aVarArr[i7];
            char c7 = aVar.f4467a;
            a aVar2 = aVarArr2[i7];
            if (c7 != aVar2.f4467a || aVar.f4468b.length != aVar2.f4468b.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] b(float[] fArr, int i7) {
        if (i7 >= 0) {
            int length = fArr.length;
            if (length >= 0) {
                int i8 = i7 - 0;
                int min = Math.min(i8, length - 0);
                float[] fArr2 = new float[i8];
                System.arraycopy(fArr, 0, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:292:0x0088, code lost:
        if (r16 == 0) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0095 A[Catch: NumberFormatException -> 0x00b7, LOOP:3: B:281:0x006c->B:299:0x0095, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00b7, blocks: (B:278:0x0058, B:281:0x006c, B:283:0x0072, B:287:0x007e, B:299:0x0095, B:301:0x009b, B:304:0x00ab, B:306:0x00b0), top: B:321:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x009b A[Catch: NumberFormatException -> 0x00b7, TryCatch #0 {NumberFormatException -> 0x00b7, blocks: (B:278:0x0058, B:281:0x006c, B:283:0x0072, B:287:0x007e, B:299:0x0095, B:301:0x009b, B:304:0x00ab, B:306:0x00b0), top: B:321:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x00ab A[Catch: NumberFormatException -> 0x00b7, TryCatch #0 {NumberFormatException -> 0x00b7, blocks: (B:278:0x0058, B:281:0x006c, B:283:0x0072, B:287:0x007e, B:299:0x0095, B:301:0x009b, B:304:0x00ab, B:306:0x00b0), top: B:321:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static i1.d.a[] c(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.d.c(java.lang.String):i1.d$a[]");
    }

    public static Path d(String str) {
        Path path = new Path();
        a[] c7 = c(str);
        if (c7 != null) {
            try {
                a.b(c7, path);
                return path;
            } catch (RuntimeException e) {
                throw new RuntimeException(s0.h("Error in parsing ", str), e);
            }
        }
        return null;
    }

    public static a[] e(a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        a[] aVarArr2 = new a[aVarArr.length];
        for (int i7 = 0; i7 < aVarArr.length; i7++) {
            aVarArr2[i7] = new a(aVarArr[i7]);
        }
        return aVarArr2;
    }
}
