package com.alibaba.fastjson.util;

import com.alibaba.fastjson.asm.Label;
import com.facebook.imageutils.JfifUtil;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class RyuFloat {
    private static final int[][] POW5_SPLIT = {new int[]{Label.FORWARD_REFERENCE_TYPE_WIDE, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{1000000000, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, AntiCollisionHashMap.MAXIMUM_CAPACITY}, new int[]{762939453, Label.FORWARD_REFERENCE_TYPE_SHORT}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};
    private static final int[][] POW5_INV_SPLIT = {new int[]{Label.FORWARD_REFERENCE_TYPE_SHORT, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};

    public static String toString(float f) {
        char[] cArr = new char[15];
        return new String(cArr, 0, toString(f, cArr, 0));
    }

    public static int toString(float f, char[] cArr, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        boolean z4;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (Float.isNaN(f)) {
            int i15 = i + 1;
            cArr[i] = 'N';
            int i16 = i15 + 1;
            cArr[i15] = 'a';
            i14 = i16 + 1;
            cArr[i16] = 'N';
        } else if (f == Float.POSITIVE_INFINITY) {
            int i17 = i + 1;
            cArr[i] = 'I';
            int i18 = i17 + 1;
            cArr[i17] = 'n';
            int i19 = i18 + 1;
            cArr[i18] = 'f';
            int i20 = i19 + 1;
            cArr[i19] = 'i';
            int i21 = i20 + 1;
            cArr[i20] = 'n';
            int i22 = i21 + 1;
            cArr[i21] = 'i';
            int i23 = i22 + 1;
            cArr[i22] = 't';
            cArr[i23] = 'y';
            return (i23 + 1) - i;
        } else if (f == Float.NEGATIVE_INFINITY) {
            int i24 = i + 1;
            cArr[i] = '-';
            int i25 = i24 + 1;
            cArr[i24] = 'I';
            int i26 = i25 + 1;
            cArr[i25] = 'n';
            int i27 = i26 + 1;
            cArr[i26] = 'f';
            int i28 = i27 + 1;
            cArr[i27] = 'i';
            int i29 = i28 + 1;
            cArr[i28] = 'n';
            int i30 = i29 + 1;
            cArr[i29] = 'i';
            int i31 = i30 + 1;
            cArr[i30] = 't';
            i14 = i31 + 1;
            cArr[i31] = 'y';
        } else {
            int floatToIntBits = Float.floatToIntBits(f);
            if (floatToIntBits != 0) {
                if (floatToIntBits == Integer.MIN_VALUE) {
                    int i32 = i + 1;
                    cArr[i] = '-';
                    int i33 = i32 + 1;
                    cArr[i32] = '0';
                    int i34 = i33 + 1;
                    cArr[i33] = '.';
                    cArr[i34] = '0';
                    return (i34 + 1) - i;
                }
                int i35 = (floatToIntBits >> 23) & JfifUtil.MARKER_FIRST_BYTE;
                int i36 = 8388607 & floatToIntBits;
                if (i35 == 0) {
                    i2 = -149;
                } else {
                    i2 = (i35 - 127) - 23;
                    i36 |= 8388608;
                }
                boolean z5 = floatToIntBits < 0;
                boolean z6 = (i36 & 1) == 0;
                int i37 = i36 * 4;
                int i38 = i37 + 2;
                int i39 = i37 - ((((long) i36) != 8388608 || i35 <= 1) ? 2 : 1);
                int i40 = i2 - 2;
                if (i40 >= 0) {
                    i7 = (int) ((i40 * 3010299) / 10000000);
                    int i41 = i7 == 0 ? 1 : (int) ((((i7 * 23219280) + 10000000) - 1) / 10000000);
                    int[][] iArr = POW5_INV_SPLIT;
                    long j = iArr[i7][0];
                    z = z6;
                    long j2 = iArr[i7][1];
                    long j3 = i37;
                    int i42 = (((i41 + 59) - 1) + ((-i40) + i7)) - 31;
                    i5 = (int) (((j3 * j) + ((j3 * j2) >> 31)) >> i42);
                    long j4 = i38;
                    i3 = (int) (((j4 * j) + ((j4 * j2) >> 31)) >> i42);
                    long j5 = i39;
                    i6 = (int) (((j * j5) + ((j5 * j2) >> 31)) >> i42);
                    if (i7 == 0 || (i3 - 1) / 10 > i6 / 10) {
                        i4 = 0;
                    } else {
                        i4 = (int) ((((iArr[i13][0] * j3) + ((iArr[i13][1] * j3) >> 31)) >> (((i12 - 1) + (((i7 - 1 == 0 ? 1 : (int) ((((i13 * 23219280) + 10000000) - 1) / 10000000)) + 59) - 1)) - 31)) % 10);
                    }
                    int i43 = i38;
                    int i44 = 0;
                    while (i43 > 0 && i43 % 5 == 0) {
                        i43 /= 5;
                        i44++;
                    }
                    int i45 = 0;
                    while (i37 > 0 && i37 % 5 == 0) {
                        i37 /= 5;
                        i45++;
                    }
                    int i46 = 0;
                    while (i39 > 0 && i39 % 5 == 0) {
                        i39 /= 5;
                        i46++;
                    }
                    z2 = i44 >= i7;
                    z4 = i45 >= i7;
                    z3 = i46 >= i7;
                } else {
                    z = z6;
                    int i47 = -i40;
                    int i48 = (int) ((i47 * 6989700) / 10000000);
                    int i49 = i47 - i48;
                    int[][] iArr2 = POW5_SPLIT;
                    long j6 = iArr2[i49][0];
                    long j7 = iArr2[i49][1];
                    int i50 = (i48 - ((i49 == 0 ? 1 : (int) ((((i49 * 23219280) + 10000000) - 1) / 10000000)) - 61)) - 31;
                    long j8 = i37;
                    int i51 = (int) (((j8 * j6) + ((j8 * j7) >> 31)) >> i50);
                    long j9 = i38;
                    i3 = (int) (((j9 * j6) + ((j9 * j7) >> 31)) >> i50);
                    long j10 = i39;
                    int i52 = (int) (((j6 * j10) + ((j10 * j7) >> 31)) >> i50);
                    if (i48 == 0 || (i3 - 1) / 10 > i52 / 10) {
                        i4 = 0;
                    } else {
                        i4 = (int) ((((iArr2[i8][0] * j8) + ((iArr2[i8][1] * j8) >> 31)) >> (((i48 - 1) - ((i49 + 1 == 0 ? 1 : (int) ((((i8 * 23219280) + 10000000) - 1) / 10000000)) - 61)) - 31)) % 10);
                    }
                    int i53 = i48 + i40;
                    boolean z7 = 1 >= i48;
                    boolean z8 = i48 < 23 && (((1 << (i48 + (-1))) - 1) & i37) == 0;
                    boolean z9 = (i39 % 2 == 1 ? 0 : 1) >= i48;
                    z2 = z7;
                    i5 = i51;
                    z3 = z9;
                    i6 = i52;
                    i7 = i53;
                    z4 = z8;
                }
                int i54 = 1000000000;
                int i55 = 10;
                while (i55 > 0 && i3 < i54) {
                    i54 /= 10;
                    i55--;
                }
                int i56 = (i7 + i55) - 1;
                boolean z10 = i56 < -3 || i56 >= 7;
                if (z2 && !z) {
                    i3--;
                }
                int i57 = 0;
                while (true) {
                    int i58 = i3 / 10;
                    int i59 = i6 / 10;
                    if (i58 <= i59 || (i3 < 100 && z10)) {
                        break;
                    }
                    z3 &= i6 % 10 == 0;
                    i4 = i5 % 10;
                    i5 /= 10;
                    i57++;
                    i3 = i58;
                    i6 = i59;
                }
                if (z3 && z) {
                    while (i6 % 10 == 0 && (i3 >= 100 || !z10)) {
                        i3 /= 10;
                        i4 = i5 % 10;
                        i5 /= 10;
                        i6 /= 10;
                        i57++;
                    }
                }
                if (z4 && i4 == 5 && i5 % 2 == 0) {
                    i4 = 4;
                }
                int i60 = i5 + (((i5 != i6 || (z3 && z)) && i4 < 5) ? 0 : 1);
                int i61 = i55 - i57;
                if (z5) {
                    i9 = i + 1;
                    cArr[i] = '-';
                } else {
                    i9 = i;
                }
                if (z10) {
                    for (int i62 = 0; i62 < i61 - 1; i62++) {
                        int i63 = i60 % 10;
                        i60 /= 10;
                        cArr[(i9 + i61) - i62] = (char) (i63 + 48);
                    }
                    cArr[i9] = (char) ((i60 % 10) + 48);
                    cArr[i9 + 1] = '.';
                    int i64 = i9 + i61 + 1;
                    if (i61 == 1) {
                        cArr[i64] = '0';
                        i64++;
                    }
                    int i65 = i64 + 1;
                    cArr[i64] = 'E';
                    if (i56 < 0) {
                        cArr[i65] = '-';
                        i56 = -i56;
                        i65++;
                    }
                    if (i56 >= 10) {
                        i11 = 48;
                        cArr[i65] = (char) ((i56 / 10) + 48);
                        i65++;
                    } else {
                        i11 = 48;
                    }
                    i10 = i65 + 1;
                    cArr[i65] = (char) ((i56 % 10) + i11);
                } else {
                    int i66 = 48;
                    if (i56 < 0) {
                        int i67 = i9 + 1;
                        cArr[i9] = '0';
                        int i68 = i67 + 1;
                        cArr[i67] = '.';
                        int i69 = -1;
                        while (i69 > i56) {
                            cArr[i68] = '0';
                            i69--;
                            i68++;
                        }
                        int i70 = i68;
                        int i71 = 0;
                        while (i71 < i61) {
                            cArr[((i68 + i61) - i71) - 1] = (char) ((i60 % 10) + i66);
                            i60 /= 10;
                            i70++;
                            i71++;
                            i66 = 48;
                        }
                        i10 = i70;
                    } else {
                        int i72 = i56 + 1;
                        if (i72 >= i61) {
                            for (int i73 = 0; i73 < i61; i73++) {
                                cArr[((i9 + i61) - i73) - 1] = (char) ((i60 % 10) + 48);
                                i60 /= 10;
                            }
                            int i74 = i9 + i61;
                            while (i61 < i72) {
                                cArr[i74] = '0';
                                i61++;
                                i74++;
                            }
                            int i75 = i74 + 1;
                            cArr[i74] = '.';
                            i10 = i75 + 1;
                            cArr[i75] = '0';
                        } else {
                            int i76 = i9 + 1;
                            for (int i77 = 0; i77 < i61; i77++) {
                                if ((i61 - i77) - 1 == i56) {
                                    cArr[((i76 + i61) - i77) - 1] = '.';
                                    i76--;
                                }
                                cArr[((i76 + i61) - i77) - 1] = (char) ((i60 % 10) + 48);
                                i60 /= 10;
                            }
                            i10 = i9 + i61 + 1;
                        }
                    }
                }
                return i10 - i;
            }
            int i78 = i + 1;
            cArr[i] = '0';
            int i79 = i78 + 1;
            cArr[i78] = '.';
            i14 = i79 + 1;
            cArr[i79] = '0';
        }
        return i14 - i;
    }
}
