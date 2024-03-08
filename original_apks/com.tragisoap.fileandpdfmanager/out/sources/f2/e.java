package f2;

import androidx.activity.h;
import androidx.fragment.app.s0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4107a = {112, 114, 111, 0};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f4108b = {112, 114, 109, 0};

    public static byte[] a(b[] bVarArr, byte[] bArr) {
        int i7 = 0;
        int i8 = 0;
        for (b bVar : bVarArr) {
            i8 += (((((bVar.f4100g * 2) + 8) - 1) & -8) / 8) + (bVar.e * 2) + b(bVar.f4095a, bVar.f4096b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + bVar.f4099f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i8);
        if (Arrays.equals(bArr, f.f4111c)) {
            int length = bVarArr.length;
            while (i7 < length) {
                b bVar2 = bVarArr[i7];
                l(byteArrayOutputStream, bVar2, b(bVar2.f4095a, bVar2.f4096b, bArr));
                n(byteArrayOutputStream, bVar2);
                k(byteArrayOutputStream, bVar2);
                m(byteArrayOutputStream, bVar2);
                i7++;
            }
        } else {
            for (b bVar3 : bVarArr) {
                l(byteArrayOutputStream, bVar3, b(bVar3.f4095a, bVar3.f4096b, bArr));
            }
            int length2 = bVarArr.length;
            while (i7 < length2) {
                b bVar4 = bVarArr[i7];
                n(byteArrayOutputStream, bVar4);
                k(byteArrayOutputStream, bVar4);
                m(byteArrayOutputStream, bVar4);
                i7++;
            }
        }
        if (byteArrayOutputStream.size() == i8) {
            return byteArrayOutputStream.toByteArray();
        }
        StringBuilder d7 = h.d("The bytes saved do not match expectation. actual=");
        d7.append(byteArrayOutputStream.size());
        d7.append(" expected=");
        d7.append(i8);
        throw new IllegalStateException(d7.toString());
    }

    public static String b(String str, String str2, byte[] bArr) {
        byte[] bArr2 = f.e;
        String str3 = "!";
        String str4 = (!Arrays.equals(bArr, bArr2) && !Arrays.equals(bArr, f.f4112d)) ? str3 : ":";
        if (str.length() <= 0) {
            if (str3.equals(str4)) {
                return str2.replace(":", str3);
            }
            if (":".equals(str4)) {
                str2 = str2.replace(str3, ":");
            }
            return str2;
        } else if (str2.equals("classes.dex")) {
            return str;
        } else {
            if (str2.contains(str3) || str2.contains(":")) {
                if (str3.equals(str4)) {
                    return str2.replace(":", str3);
                }
                if (":".equals(str4)) {
                    str2 = str2.replace(str3, ":");
                }
                return str2;
            } else if (str2.endsWith(".apk")) {
                return str2;
            } else {
                StringBuilder d7 = h.d(str);
                if (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, f.f4112d)) {
                    str3 = ":";
                }
                return h.c(d7, str3, str2);
            }
        }
    }

    public static int c(int i7, int i8, int i9) {
        if (i7 == 1) {
            throw new IllegalStateException("HOT methods are not stored in the bitmap");
        } else if (i7 == 2) {
            return i8;
        } else {
            if (i7 == 4) {
                return i8 + i9;
            }
            throw new IllegalStateException(s0.g("Unexpected flag: ", i7));
        }
    }

    public static int[] d(ByteArrayInputStream byteArrayInputStream, int i7) {
        int[] iArr = new int[i7];
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            i8 += a0.e.A(byteArrayInputStream);
            iArr[i9] = i8;
        }
        return iArr;
    }

    public static b[] e(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, b[] bVarArr) {
        byte[] bArr3 = f.f4113f;
        if (Arrays.equals(bArr, bArr3)) {
            if (Arrays.equals(f.f4109a, bArr2)) {
                throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            } else if (Arrays.equals(bArr, bArr3)) {
                int z6 = (int) a0.e.z(fileInputStream, 1);
                byte[] y6 = a0.e.y(fileInputStream, (int) a0.e.z(fileInputStream, 4), (int) a0.e.z(fileInputStream, 4));
                if (fileInputStream.read() <= 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(y6);
                    try {
                        b[] f7 = f(byteArrayInputStream, z6, bVarArr);
                        byteArrayInputStream.close();
                        return f7;
                    } catch (Throwable th) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("Content found after the end of file");
                }
            } else {
                throw new IllegalStateException("Unsupported meta version");
            }
        } else if (Arrays.equals(bArr, f.f4114g)) {
            int A = a0.e.A(fileInputStream);
            byte[] y7 = a0.e.y(fileInputStream, (int) a0.e.z(fileInputStream, 4), (int) a0.e.z(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(y7);
                try {
                    b[] g2 = g(byteArrayInputStream2, bArr2, A, bVarArr);
                    byteArrayInputStream2.close();
                    return g2;
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } else {
                throw new IllegalStateException("Content found after the end of file");
            }
        } else {
            throw new IllegalStateException("Unsupported meta version");
        }
    }

    public static b[] f(ByteArrayInputStream byteArrayInputStream, int i7, b[] bVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new b[0];
        }
        if (i7 == bVarArr.length) {
            String[] strArr = new String[i7];
            int[] iArr = new int[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                int A = a0.e.A(byteArrayInputStream);
                iArr[i8] = a0.e.A(byteArrayInputStream);
                strArr[i8] = new String(a0.e.x(byteArrayInputStream, A), StandardCharsets.UTF_8);
            }
            for (int i9 = 0; i9 < i7; i9++) {
                b bVar = bVarArr[i9];
                if (bVar.f4096b.equals(strArr[i9])) {
                    int i10 = iArr[i9];
                    bVar.e = i10;
                    bVar.f4101h = d(byteArrayInputStream, i10);
                } else {
                    throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
                }
            }
            return bVarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static b[] g(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i7, b[] bVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new b[0];
        }
        if (i7 == bVarArr.length) {
            for (int i8 = 0; i8 < i7; i8++) {
                a0.e.A(byteArrayInputStream);
                String str = new String(a0.e.x(byteArrayInputStream, a0.e.A(byteArrayInputStream)), StandardCharsets.UTF_8);
                long z6 = a0.e.z(byteArrayInputStream, 4);
                int A = a0.e.A(byteArrayInputStream);
                b bVar = null;
                if (bVarArr.length > 0) {
                    int indexOf = str.indexOf("!");
                    if (indexOf < 0) {
                        indexOf = str.indexOf(":");
                    }
                    String substring = indexOf > 0 ? str.substring(indexOf + 1) : str;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= bVarArr.length) {
                            break;
                        } else if (bVarArr[i9].f4096b.equals(substring)) {
                            bVar = bVarArr[i9];
                            break;
                        } else {
                            i9++;
                        }
                    }
                }
                if (bVar != null) {
                    bVar.f4098d = z6;
                    int[] d7 = d(byteArrayInputStream, A);
                    if (Arrays.equals(bArr, f.e)) {
                        bVar.e = A;
                        bVar.f4101h = d7;
                    }
                } else {
                    throw new IllegalStateException(s0.h("Missing profile key: ", str));
                }
            }
            return bVarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static b[] h(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, f.f4110b)) {
            int z6 = (int) a0.e.z(fileInputStream, 1);
            byte[] y6 = a0.e.y(fileInputStream, (int) a0.e.z(fileInputStream, 4), (int) a0.e.z(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(y6);
                try {
                    b[] i7 = i(byteArrayInputStream, str, z6);
                    byteArrayInputStream.close();
                    return i7;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                throw new IllegalStateException("Content found after the end of file");
            }
        } else {
            throw new IllegalStateException("Unsupported version");
        }
    }

    public static b[] i(ByteArrayInputStream byteArrayInputStream, String str, int i7) {
        if (byteArrayInputStream.available() == 0) {
            return new b[0];
        }
        b[] bVarArr = new b[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            int A = a0.e.A(byteArrayInputStream);
            int A2 = a0.e.A(byteArrayInputStream);
            bVarArr[i8] = new b(str, new String(a0.e.x(byteArrayInputStream, A), StandardCharsets.UTF_8), a0.e.z(byteArrayInputStream, 4), A2, (int) a0.e.z(byteArrayInputStream, 4), (int) a0.e.z(byteArrayInputStream, 4), new int[A2], new TreeMap());
        }
        for (int i9 = 0; i9 < i7; i9++) {
            b bVar = bVarArr[i9];
            int available = byteArrayInputStream.available() - bVar.f4099f;
            int i10 = 0;
            while (byteArrayInputStream.available() > available) {
                i10 += a0.e.A(byteArrayInputStream);
                bVar.f4102i.put(Integer.valueOf(i10), 1);
                for (int A3 = a0.e.A(byteArrayInputStream); A3 > 0; A3--) {
                    a0.e.A(byteArrayInputStream);
                    int z6 = (int) a0.e.z(byteArrayInputStream, 1);
                    if (!(z6 == 6 || z6 == 7)) {
                        while (z6 > 0) {
                            a0.e.z(byteArrayInputStream, 1);
                            for (int z7 = (int) a0.e.z(byteArrayInputStream, 1); z7 > 0; z7--) {
                                a0.e.A(byteArrayInputStream);
                            }
                            z6--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() == available) {
                bVar.f4101h = d(byteArrayInputStream, bVar.e);
                BitSet valueOf = BitSet.valueOf(a0.e.x(byteArrayInputStream, ((((bVar.f4100g * 2) + 8) - 1) & -8) / 8));
                int i11 = 0;
                while (true) {
                    int i12 = bVar.f4100g;
                    if (i11 < i12) {
                        int i13 = valueOf.get(c(2, i11, i12)) ? 2 : 0;
                        if (valueOf.get(c(4, i11, i12))) {
                            i13 |= 4;
                        }
                        if (i13 != 0) {
                            Integer num = bVar.f4102i.get(Integer.valueOf(i11));
                            if (num == null) {
                                num = 0;
                            }
                            bVar.f4102i.put(Integer.valueOf(i11), Integer.valueOf(num.intValue() | i13));
                        }
                        i11++;
                    }
                }
            } else {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
        }
        return bVarArr;
    }

    public static boolean j(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, b[] bVarArr) {
        int i7;
        int i8 = 0;
        if (Arrays.equals(bArr, f.f4109a)) {
            ArrayList arrayList = new ArrayList(3);
            ArrayList arrayList2 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                a0.e.N(byteArrayOutputStream2, bVarArr.length);
                int i9 = 2;
                int i10 = 2;
                for (b bVar : bVarArr) {
                    a0.e.M(byteArrayOutputStream2, bVar.f4097c, 4);
                    a0.e.M(byteArrayOutputStream2, bVar.f4098d, 4);
                    a0.e.M(byteArrayOutputStream2, (long) bVar.f4100g, 4);
                    String b2 = b(bVar.f4095a, bVar.f4096b, f.f4109a);
                    int length = b2.getBytes(StandardCharsets.UTF_8).length;
                    a0.e.N(byteArrayOutputStream2, length);
                    i10 = i10 + 4 + 4 + 4 + 2 + (length * 1);
                    byteArrayOutputStream2.write(b2.getBytes(StandardCharsets.UTF_8));
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (i10 == byteArray.length) {
                    g gVar = new g(1, byteArray, false);
                    byteArrayOutputStream2.close();
                    arrayList.add(gVar);
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    int i11 = 0;
                    for (int i12 = 0; i12 < bVarArr.length; i12++) {
                        try {
                            b bVar2 = bVarArr[i12];
                            a0.e.N(byteArrayOutputStream3, i12);
                            a0.e.N(byteArrayOutputStream3, bVar2.e);
                            i11 = i11 + 2 + 2 + (bVar2.e * 2);
                            k(byteArrayOutputStream3, bVar2);
                        } finally {
                        }
                    }
                    byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                    if (i11 == byteArray2.length) {
                        g gVar2 = new g(3, byteArray2, true);
                        byteArrayOutputStream3.close();
                        arrayList.add(gVar2);
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        int i13 = 0;
                        int i14 = 0;
                        while (i13 < bVarArr.length) {
                            try {
                                b bVar3 = bVarArr[i13];
                                for (Map.Entry<Integer, Integer> entry : bVar3.f4102i.entrySet()) {
                                    i8 |= entry.getValue().intValue();
                                }
                                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                m(byteArrayOutputStream4, bVar3);
                                byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                                byteArrayOutputStream4.close();
                                ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                                n(byteArrayOutputStream5, bVar3);
                                byte[] byteArray4 = byteArrayOutputStream5.toByteArray();
                                byteArrayOutputStream5.close();
                                a0.e.N(byteArrayOutputStream2, i13);
                                int length2 = byteArray3.length + i9 + byteArray4.length;
                                int i15 = i14 + 2 + 4;
                                a0.e.M(byteArrayOutputStream2, (long) length2, 4);
                                a0.e.N(byteArrayOutputStream2, i8);
                                byteArrayOutputStream2.write(byteArray3);
                                byteArrayOutputStream2.write(byteArray4);
                                i14 = i15 + length2;
                                i13++;
                                arrayList2 = arrayList2;
                                i8 = 0;
                                i9 = 2;
                            } finally {
                            }
                        }
                        ArrayList arrayList3 = arrayList2;
                        byte[] byteArray5 = byteArrayOutputStream2.toByteArray();
                        if (i14 == byteArray5.length) {
                            g gVar3 = new g(4, byteArray5, true);
                            byteArrayOutputStream2.close();
                            arrayList.add(gVar3);
                            long j7 = (long) 4;
                            long size = j7 + j7 + 4 + ((long) (arrayList.size() * 16));
                            a0.e.M(byteArrayOutputStream, (long) arrayList.size(), 4);
                            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                                g gVar4 = (g) arrayList.get(i16);
                                a0.e.M(byteArrayOutputStream, h.a(gVar4.f4115a), 4);
                                a0.e.M(byteArrayOutputStream, size, 4);
                                if (gVar4.f4117c) {
                                    byte[] bArr2 = gVar4.f4116b;
                                    byte[] l6 = a0.e.l(bArr2);
                                    arrayList3 = arrayList3;
                                    arrayList3.add(l6);
                                    a0.e.M(byteArrayOutputStream, (long) l6.length, 4);
                                    a0.e.M(byteArrayOutputStream, (long) bArr2.length, 4);
                                    i7 = l6.length;
                                } else {
                                    arrayList3 = arrayList3;
                                    arrayList3.add(gVar4.f4116b);
                                    a0.e.M(byteArrayOutputStream, (long) gVar4.f4116b.length, 4);
                                    a0.e.M(byteArrayOutputStream, 0, 4);
                                    i7 = gVar4.f4116b.length;
                                }
                                size += (long) i7;
                            }
                            for (int i17 = 0; i17 < arrayList3.size(); i17++) {
                                byteArrayOutputStream.write((byte[]) arrayList3.get(i17));
                            }
                            return true;
                        }
                        throw new IllegalStateException("Expected size " + i14 + ", does not match actual size " + byteArray5.length);
                    } else {
                        throw new IllegalStateException("Expected size " + i11 + ", does not match actual size " + byteArray2.length);
                    }
                } else {
                    throw new IllegalStateException("Expected size " + i10 + ", does not match actual size " + byteArray.length);
                }
            } finally {
                try {
                    byteArrayOutputStream2.close();
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
        } else {
            byte[] bArr3 = f.f4110b;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] a7 = a(bVarArr, bArr3);
                a0.e.M(byteArrayOutputStream, (long) bVarArr.length, 1);
                a0.e.M(byteArrayOutputStream, (long) a7.length, 4);
                byte[] l7 = a0.e.l(a7);
                a0.e.M(byteArrayOutputStream, (long) l7.length, 4);
                byteArrayOutputStream.write(l7);
                return true;
            } else if (Arrays.equals(bArr, f.f4112d)) {
                a0.e.M(byteArrayOutputStream, (long) bVarArr.length, 1);
                for (b bVar4 : bVarArr) {
                    String b7 = b(bVar4.f4095a, bVar4.f4096b, f.f4112d);
                    a0.e.N(byteArrayOutputStream, b7.getBytes(StandardCharsets.UTF_8).length);
                    a0.e.N(byteArrayOutputStream, bVar4.f4101h.length);
                    a0.e.M(byteArrayOutputStream, (long) (bVar4.f4102i.size() * 4), 4);
                    a0.e.M(byteArrayOutputStream, bVar4.f4097c, 4);
                    byteArrayOutputStream.write(b7.getBytes(StandardCharsets.UTF_8));
                    for (Integer num : bVar4.f4102i.keySet()) {
                        a0.e.N(byteArrayOutputStream, num.intValue());
                        a0.e.N(byteArrayOutputStream, 0);
                    }
                    for (int i18 : bVar4.f4101h) {
                        a0.e.N(byteArrayOutputStream, i18);
                    }
                }
                return true;
            } else {
                byte[] bArr4 = f.f4111c;
                if (Arrays.equals(bArr, bArr4)) {
                    byte[] a8 = a(bVarArr, bArr4);
                    a0.e.M(byteArrayOutputStream, (long) bVarArr.length, 1);
                    a0.e.M(byteArrayOutputStream, (long) a8.length, 4);
                    byte[] l8 = a0.e.l(a8);
                    a0.e.M(byteArrayOutputStream, (long) l8.length, 4);
                    byteArrayOutputStream.write(l8);
                    return true;
                } else if (!Arrays.equals(bArr, f.e)) {
                    return false;
                } else {
                    a0.e.N(byteArrayOutputStream, bVarArr.length);
                    for (b bVar5 : bVarArr) {
                        String b8 = b(bVar5.f4095a, bVar5.f4096b, f.e);
                        a0.e.N(byteArrayOutputStream, b8.getBytes(StandardCharsets.UTF_8).length);
                        a0.e.N(byteArrayOutputStream, bVar5.f4102i.size());
                        a0.e.N(byteArrayOutputStream, bVar5.f4101h.length);
                        a0.e.M(byteArrayOutputStream, bVar5.f4097c, 4);
                        byteArrayOutputStream.write(b8.getBytes(StandardCharsets.UTF_8));
                        for (Integer num2 : bVar5.f4102i.keySet()) {
                            a0.e.N(byteArrayOutputStream, num2.intValue());
                        }
                        for (int i19 : bVar5.f4101h) {
                            a0.e.N(byteArrayOutputStream, i19);
                        }
                    }
                    return true;
                }
            }
        }
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, b bVar) {
        int i7 = 0;
        for (int i8 : bVar.f4101h) {
            Integer valueOf = Integer.valueOf(i8);
            a0.e.N(byteArrayOutputStream, valueOf.intValue() - i7);
            i7 = valueOf.intValue();
        }
    }

    public static void l(ByteArrayOutputStream byteArrayOutputStream, b bVar, String str) {
        a0.e.N(byteArrayOutputStream, str.getBytes(StandardCharsets.UTF_8).length);
        a0.e.N(byteArrayOutputStream, bVar.e);
        a0.e.M(byteArrayOutputStream, (long) bVar.f4099f, 4);
        a0.e.M(byteArrayOutputStream, bVar.f4097c, 4);
        a0.e.M(byteArrayOutputStream, (long) bVar.f4100g, 4);
        byteArrayOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, b bVar) {
        byte[] bArr = new byte[((((bVar.f4100g * 2) + 8) - 1) & -8) / 8];
        for (Map.Entry<Integer, Integer> entry : bVar.f4102i.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            if ((intValue2 & 2) != 0) {
                int c7 = c(2, intValue, bVar.f4100g);
                int i7 = c7 / 8;
                bArr[i7] = (byte) ((1 << (c7 % 8)) | bArr[i7]);
            }
            if ((intValue2 & 4) != 0) {
                int c8 = c(4, intValue, bVar.f4100g);
                int i8 = c8 / 8;
                bArr[i8] = (byte) ((1 << (c8 % 8)) | bArr[i8]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void n(ByteArrayOutputStream byteArrayOutputStream, b bVar) {
        int i7 = 0;
        for (Map.Entry<Integer, Integer> entry : bVar.f4102i.entrySet()) {
            int intValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                a0.e.N(byteArrayOutputStream, intValue - i7);
                a0.e.N(byteArrayOutputStream, 0);
                i7 = intValue;
            }
        }
    }
}
