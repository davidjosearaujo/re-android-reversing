package i1;

import android.graphics.Path;
import android.util.Log;
import androidx.fragment.app.s0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public char f4467a;

        /* renamed from: b  reason: collision with root package name */
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
            double radians = Math.toRadians((double) f13);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d9 = (double) f7;
            double d10 = (double) f8;
            double d11 = (d10 * sin) + (d9 * cos);
            double d12 = d9;
            double d13 = (double) f11;
            double d14 = d11 / d13;
            double d15 = (double) f12;
            double d16 = ((d10 * cos) + (((double) (-f7)) * sin)) / d15;
            double d17 = d10;
            double d18 = (double) f10;
            double d19 = ((d18 * sin) + (((double) f9) * cos)) / d13;
            double d20 = ((d18 * cos) + (((double) (-f9)) * sin)) / d15;
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
                d8 = d23 - d28;
                d7 = d24 + d27;
            } else {
                d8 = d23 + d28;
                d7 = d24 - d27;
            }
            double atan2 = Math.atan2(d16 - d7, d14 - d8);
            double atan22 = Math.atan2(d20 - d7, d19 - d8) - atan2;
            int i7 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z7 != (i7 >= 0)) {
                atan22 = i7 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d29 = d8 * d13;
            double d30 = d7 * d15;
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
            double d41 = atan22 / ((double) ceil);
            int i8 = 0;
            while (i8 < ceil) {
                double d42 = atan2 + d41;
                double sin4 = Math.sin(d42);
                double cos4 = Math.cos(d42);
                double d43 = (((d13 * cos2) * cos4) + d31) - (d35 * sin4);
                double d44 = (d40 * sin4) + (d13 * sin2 * cos4) + d32;
                double d45 = (d34 * sin4) - (d35 * cos4);
                double d46 = (cos4 * d40) + (sin4 * d37);
                double d47 = d42 - atan2;
                double tan = Math.tan(d47 / 2.0d);
                double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d47)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d36 * sqrt3) + d12), (float) ((d39 * sqrt3) + d17), (float) (d43 - (sqrt3 * d45)), (float) (d44 - (sqrt3 * d46)), (float) d43, (float) d44);
                i8++;
                atan2 = d42;
                d37 = d37;
                cos2 = cos2;
                ceil = ceil;
                d39 = d46;
                d13 = d13;
                d36 = d45;
                d12 = d43;
                d17 = d44;
                d31 = d31;
                d41 = d41;
                d40 = d40;
            }
        }

        public static void b(a[] aVarArr, Path path) {
            int i7;
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
            a[] aVarArr2 = aVarArr;
            int i8 = 6;
            float[] fArr = new float[6];
            char c7 = 'm';
            int i9 = 0;
            char c8 = 'm';
            int i10 = 0;
            while (i10 < aVarArr2.length) {
                a aVar = aVarArr2[i10];
                char c9 = aVar.f4467a;
                float[] fArr2 = aVar.f4468b;
                float f19 = fArr[i9];
                float f20 = fArr[1];
                float f21 = fArr[2];
                float f22 = fArr[3];
                float f23 = fArr[4];
                float f24 = fArr[5];
                switch (c9) {
                    case 'A':
                    case 'a':
                        i8 = 7;
                        break;
                    case 'C':
                    case 'c':
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i8 = 1;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i8 = 4;
                        break;
                    case SubsamplingScaleImageView.ORIENTATION_90 /* 90 */:
                    case 'z':
                        path.close();
                        path.moveTo(f23, f24);
                        f19 = f23;
                        f21 = f19;
                        f20 = f24;
                        f22 = f20;
                    default:
                        i8 = 2;
                        break;
                }
                float f25 = f23;
                float f26 = f24;
                int i11 = i9;
                while (i11 < fArr2.length) {
                    if (c9 != 'A') {
                        if (c9 != 'C') {
                            if (c9 == 'H') {
                                i7 = i11;
                                fArr2 = fArr2;
                                c8 = c9;
                                i10 = i10;
                                int i12 = i7 + 0;
                                path.lineTo(fArr2[i12], f20);
                                f19 = fArr2[i12];
                            } else if (c9 == 'Q') {
                                i7 = i11;
                                fArr2 = fArr2;
                                c8 = c9;
                                i10 = i10;
                                int i13 = i7 + 0;
                                int i14 = i7 + 1;
                                int i15 = i7 + 2;
                                int i16 = i7 + 3;
                                path.quadTo(fArr2[i13], fArr2[i14], fArr2[i15], fArr2[i16]);
                                f21 = fArr2[i13];
                                f22 = fArr2[i14];
                                f19 = fArr2[i15];
                                f20 = fArr2[i16];
                            } else if (c9 == 'V') {
                                i7 = i11;
                                fArr2 = fArr2;
                                c8 = c9;
                                i10 = i10;
                                int i17 = i7 + 0;
                                path.lineTo(f19, fArr2[i17]);
                                f20 = fArr2[i17];
                            } else if (c9 != 'a') {
                                if (c9 != 'c') {
                                    if (c9 == 'h') {
                                        i7 = i11;
                                        int i18 = i7 + 0;
                                        path.rLineTo(fArr2[i18], 0.0f);
                                        f19 += fArr2[i18];
                                    } else if (c9 != 'q') {
                                        if (c9 == 'v') {
                                            i7 = i11;
                                            f9 = f20;
                                            int i19 = i7 + 0;
                                            path.rLineTo(0.0f, fArr2[i19]);
                                            f10 = fArr2[i19];
                                        } else if (c9 != 'L') {
                                            if (c9 == 'M') {
                                                i7 = i11;
                                                f19 = fArr2[i7 + 0];
                                                f20 = fArr2[i7 + 1];
                                                if (i7 > 0) {
                                                    path.lineTo(f19, f20);
                                                } else {
                                                    path.moveTo(f19, f20);
                                                    f25 = f19;
                                                    f26 = f20;
                                                }
                                            } else if (c9 == 'S') {
                                                i7 = i11;
                                                if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                    f12 = (f19 * 2.0f) - f21;
                                                    f11 = (f20 * 2.0f) - f22;
                                                } else {
                                                    f12 = f19;
                                                    f11 = f20;
                                                }
                                                int i20 = i7 + 0;
                                                int i21 = i7 + 1;
                                                int i22 = i7 + 2;
                                                int i23 = i7 + 3;
                                                path.cubicTo(f12, f11, fArr2[i20], fArr2[i21], fArr2[i22], fArr2[i23]);
                                                f21 = fArr2[i20];
                                                f22 = fArr2[i21];
                                                f19 = fArr2[i22];
                                                f20 = fArr2[i23];
                                            } else if (c9 == 'T') {
                                                i7 = i11;
                                                if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                    f13 = (f19 * 2.0f) - f21;
                                                    f14 = (f20 * 2.0f) - f22;
                                                } else {
                                                    f13 = f19;
                                                    f14 = f20;
                                                }
                                                int i24 = i7 + 0;
                                                int i25 = i7 + 1;
                                                path.quadTo(f13, f14, fArr2[i24], fArr2[i25]);
                                                f19 = fArr2[i24];
                                                f20 = fArr2[i25];
                                                f22 = f14;
                                                f21 = f13;
                                                fArr2 = fArr2;
                                                c8 = c9;
                                                i10 = i10;
                                            } else if (c9 == 'l') {
                                                i7 = i11;
                                                f9 = f20;
                                                int i26 = i7 + 0;
                                                int i27 = i7 + 1;
                                                path.rLineTo(fArr2[i26], fArr2[i27]);
                                                f19 += fArr2[i26];
                                                f10 = fArr2[i27];
                                            } else if (c9 == c7) {
                                                i7 = i11;
                                                float f27 = fArr2[i7 + 0];
                                                f19 += f27;
                                                float f28 = fArr2[i7 + 1];
                                                f20 += f28;
                                                if (i7 > 0) {
                                                    path.rLineTo(f27, f28);
                                                } else {
                                                    path.rMoveTo(f27, f28);
                                                    f26 = f20;
                                                    f25 = f19;
                                                }
                                            } else if (c9 != 's') {
                                                if (c9 == 't') {
                                                    if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                        f17 = f19 - f21;
                                                        f18 = f20 - f22;
                                                    } else {
                                                        f18 = 0.0f;
                                                        f17 = 0.0f;
                                                    }
                                                    int i28 = i11 + 0;
                                                    int i29 = i11 + 1;
                                                    path.rQuadTo(f17, f18, fArr2[i28], fArr2[i29]);
                                                    f21 = f17 + f19;
                                                    f22 = f18 + f20;
                                                    f19 += fArr2[i28];
                                                    f20 += fArr2[i29];
                                                }
                                                i7 = i11;
                                            } else {
                                                if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                    f16 = f19 - f21;
                                                    f15 = f20 - f22;
                                                } else {
                                                    f16 = 0.0f;
                                                    f15 = 0.0f;
                                                }
                                                int i30 = i11 + 0;
                                                int i31 = i11 + 1;
                                                int i32 = i11 + 2;
                                                int i33 = i11 + 3;
                                                i7 = i11;
                                                f7 = f20;
                                                path.rCubicTo(f16, f15, fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                                                f21 = fArr2[i30] + f19;
                                                f22 = fArr2[i31] + f7;
                                                f19 += fArr2[i32];
                                                f8 = fArr2[i33];
                                            }
                                            f19 = f25;
                                            f20 = f26;
                                        } else {
                                            i7 = i11;
                                            int i34 = i7 + 0;
                                            int i35 = i7 + 1;
                                            path.lineTo(fArr2[i34], fArr2[i35]);
                                            f19 = fArr2[i34];
                                            f20 = fArr2[i35];
                                        }
                                        f20 = f9 + f10;
                                    } else {
                                        i7 = i11;
                                        f7 = f20;
                                        int i36 = i7 + 0;
                                        int i37 = i7 + 1;
                                        int i38 = i7 + 2;
                                        int i39 = i7 + 3;
                                        path.rQuadTo(fArr2[i36], fArr2[i37], fArr2[i38], fArr2[i39]);
                                        f21 = fArr2[i36] + f19;
                                        f22 = fArr2[i37] + f7;
                                        f19 += fArr2[i38];
                                        f8 = fArr2[i39];
                                    }
                                    fArr2 = fArr2;
                                    c8 = c9;
                                    i10 = i10;
                                } else {
                                    i7 = i11;
                                    f7 = f20;
                                    int i40 = i7 + 2;
                                    int i41 = i7 + 3;
                                    int i42 = i7 + 4;
                                    int i43 = i7 + 5;
                                    path.rCubicTo(fArr2[i7 + 0], fArr2[i7 + 1], fArr2[i40], fArr2[i41], fArr2[i42], fArr2[i43]);
                                    f21 = fArr2[i40] + f19;
                                    f22 = fArr2[i41] + f7;
                                    f19 += fArr2[i42];
                                    f8 = fArr2[i43];
                                }
                                f20 = f7 + f8;
                                fArr2 = fArr2;
                                c8 = c9;
                                i10 = i10;
                            } else {
                                i7 = i11;
                                int i44 = i7 + 5;
                                int i45 = i7 + 6;
                                fArr2 = fArr2;
                                c8 = c9;
                                i10 = i10;
                                a(path, f19, f20, fArr2[i44] + f19, fArr2[i45] + f20, fArr2[i7 + 0], fArr2[i7 + 1], fArr2[i7 + 2], fArr2[i7 + 3] != 0.0f, fArr2[i7 + 4] != 0.0f);
                                f19 += fArr2[i44];
                                f20 += fArr2[i45];
                            }
                            i11 = i7 + i8;
                            c9 = c8;
                            c7 = 'm';
                            i9 = 0;
                        } else {
                            i7 = i11;
                            fArr2 = fArr2;
                            c8 = c9;
                            i10 = i10;
                            int i46 = i7 + 2;
                            int i47 = i7 + 3;
                            int i48 = i7 + 4;
                            int i49 = i7 + 5;
                            path.cubicTo(fArr2[i7 + 0], fArr2[i7 + 1], fArr2[i46], fArr2[i47], fArr2[i48], fArr2[i49]);
                            f19 = fArr2[i48];
                            f20 = fArr2[i49];
                            f21 = fArr2[i46];
                            f22 = fArr2[i47];
                        }
                        i11 = i7 + i8;
                        c9 = c8;
                        c7 = 'm';
                        i9 = 0;
                    } else {
                        i7 = i11;
                        fArr2 = fArr2;
                        c8 = c9;
                        i10 = i10;
                        int i50 = i7 + 5;
                        int i51 = i7 + 6;
                        a(path, f19, f20, fArr2[i50], fArr2[i51], fArr2[i7 + 0], fArr2[i7 + 1], fArr2[i7 + 2], fArr2[i7 + 3] != 0.0f, fArr2[i7 + 4] != 0.0f);
                        f19 = fArr2[i50];
                        f20 = fArr2[i51];
                    }
                    f22 = f20;
                    f21 = f19;
                    i11 = i7 + i8;
                    c9 = c8;
                    c7 = 'm';
                    i9 = 0;
                }
                fArr[i9] = f19;
                fArr[1] = f20;
                fArr[2] = f21;
                fArr[3] = f22;
                fArr[4] = f25;
                fArr[5] = f26;
                c8 = aVarArr[i10].f4467a;
                i10++;
                i8 = 6;
                c7 = 'm';
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
            if (!(c7 == aVar2.f4467a && aVar.f4468b.length == aVar2.f4468b.length)) {
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

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        if (r16 == 0) goto L_0x008a;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095 A[Catch: NumberFormatException -> 0x00b7, LOOP:3: B:26:0x006c->B:44:0x0095, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00b7, blocks: (B:23:0x0058, B:26:0x006c, B:28:0x0072, B:32:0x007e, B:44:0x0095, B:46:0x009b, B:49:0x00ab, B:51:0x00b0), top: B:66:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009b A[Catch: NumberFormatException -> 0x00b7, TryCatch #0 {NumberFormatException -> 0x00b7, blocks: (B:23:0x0058, B:26:0x006c, B:28:0x0072, B:32:0x007e, B:44:0x0095, B:46:0x009b, B:49:0x00ab, B:51:0x00b0), top: B:66:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ab A[Catch: NumberFormatException -> 0x00b7, TryCatch #0 {NumberFormatException -> 0x00b7, blocks: (B:23:0x0058, B:26:0x006c, B:28:0x0072, B:32:0x007e, B:44:0x0095, B:46:0x009b, B:49:0x00ab, B:51:0x00b0), top: B:66:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i1.d.a[] c(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.d.c(java.lang.String):i1.d$a[]");
    }

    public static Path d(String str) {
        Path path = new Path();
        a[] c7 = c(str);
        if (c7 == null) {
            return null;
        }
        try {
            a.b(c7, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(s0.h("Error in parsing ", str), e);
        }
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
