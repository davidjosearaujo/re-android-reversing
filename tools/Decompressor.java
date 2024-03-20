// Copyright 2024 David Araújo
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.InflaterOutputStream;

public class Decompressor {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        File in = new File("../deofuscation/1_apk/assets/iugke/yrqmkvf.vqr");
        File out = new File(".", "decompressedMalicious");
        inflater(new FileInputStream(in), new FileOutputStream(out));
    }

    public static void inflater(InputStream input, OutputStream output) throws Exception {
        InflaterInputStream is = new InflaterInputStream(input);
        InflaterOutputStream os = new InflaterOutputStream(output);
        decoder(is, os);
        os.close();
        is.close();
    }

    private static void decoder(InputStream inputStream, OutputStream outputStream) throws Exception {
        String ehsqpiefmxd = "捨뺑戚\ue684聳踖曡㒕躚\udafdﶃ킎";
        char[] key = ehsqpiefmxd.toCharArray();
        int i2 = 1 + 1;
        int i = i2 + 1;
        char c = key[i2];
        int i22 = i + 1;
        int i3 = i22 + 1;
        char c2 = key[i22];
        int i23 = i3 + 1;
        int i4 = i23 + 1;
        char c3 = key[i23];
        int i24 = i4 + 1;
        int[] iArr = { key[0] | (key[1] << 16), (key[i] << 16) | c, (key[i3] << 16) | c2, (key[i4] << 16) | c3 };
        int i5 = i24 + 1;
        char c4 = key[i24];
        int i25 = i5 + 1;
        int[] iArr2 = { (key[i5] << 16) | c4, key[i25] | (key[i25 + 1] << 16) };
        int[] iArr3 = yioqje(iArr);
        byte[] bArr = new byte[8192];
        int i32 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return;
            }
            int i42 = i32 + read;
            int i52 = 0;
            while (i32 < i42) {
                int i6 = i32 % 8;
                int i7 = i6 / 4;
                int i8 = i32 % 4;
                if (i6 == 0) {
                    kism(iArr3, iArr2);
                }
                bArr[i52] = (byte) (((byte) (iArr2[i7] >> (i8 * 8))) ^ bArr[i52]);
                i32++;
                i52++;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static int[] yioqje(int[] iArr) {
        int[] iArr2 = new int[27];
        int i = iArr[0];
        iArr2[0] = i;
        int[] iArr3 = new int[3];
        iArr3[0] = iArr[1];
        iArr3[1] = iArr[2];
        iArr3[2] = iArr[3];
        for (int i2 = 0; i2 < 26; i2++) {
            iArr3[i2 % 3] = (((iArr3[i2 % 3] >>> 8) | (iArr3[i2 % 3] << 24)) + i) ^ i2;
            i = ((i << 3) | (i >>> 29)) ^ iArr3[i2 % 3];
            iArr2[i2 + 1] = i;
        }
        return iArr2;
    }

    private static void kism(int[] iArr, int[] iArr2) {
        int i = iArr2[0];
        int i2 = iArr2[1];
        int i22 = (((i2 >>> 8) | (i2 << 24)) + i) ^ iArr[0];
        int i3 = ((i << 3) | (i >>> 29)) ^ i22;
        int i23 = (((i22 >>> 8) | (i22 << 24)) + i3) ^ iArr[1];
        int i4 = ((i3 << 3) | (i3 >>> 29)) ^ i23;
        int i24 = (((i23 >>> 8) | (i23 << 24)) + i4) ^ iArr[2];
        int i5 = ((i4 << 3) | (i4 >>> 29)) ^ i24;
        int i25 = (((i24 >>> 8) | (i24 << 24)) + i5) ^ iArr[3];
        int i6 = ((i5 << 3) | (i5 >>> 29)) ^ i25;
        int i26 = (((i25 >>> 8) | (i25 << 24)) + i6) ^ iArr[4];
        int i7 = ((i6 << 3) | (i6 >>> 29)) ^ i26;
        int i27 = (((i26 >>> 8) | (i26 << 24)) + i7) ^ iArr[5];
        int i8 = ((i7 << 3) | (i7 >>> 29)) ^ i27;
        int i28 = (((i27 >>> 8) | (i27 << 24)) + i8) ^ iArr[6];
        int i9 = ((i8 << 3) | (i8 >>> 29)) ^ i28;
        int i29 = (((i28 >>> 8) | (i28 << 24)) + i9) ^ iArr[7];
        int i10 = ((i9 << 3) | (i9 >>> 29)) ^ i29;
        int i210 = (((i29 >>> 8) | (i29 << 24)) + i10) ^ iArr[8];
        int i11 = ((i10 << 3) | (i10 >>> 29)) ^ i210;
        int i211 = (((i210 >>> 8) | (i210 << 24)) + i11) ^ iArr[9];
        int i12 = ((i11 << 3) | (i11 >>> 29)) ^ i211;
        int i212 = (((i211 >>> 8) | (i211 << 24)) + i12) ^ iArr[10];
        int i13 = ((i12 << 3) | (i12 >>> 29)) ^ i212;
        int i213 = (((i212 >>> 8) | (i212 << 24)) + i13) ^ iArr[11];
        int i14 = ((i13 << 3) | (i13 >>> 29)) ^ i213;
        int i214 = (((i213 >>> 8) | (i213 << 24)) + i14) ^ iArr[12];
        int i15 = ((i14 << 3) | (i14 >>> 29)) ^ i214;
        int i215 = (((i214 >>> 8) | (i214 << 24)) + i15) ^ iArr[13];
        int i16 = ((i15 << 3) | (i15 >>> 29)) ^ i215;
        int i216 = (((i215 >>> 8) | (i215 << 24)) + i16) ^ iArr[14];
        int i17 = ((i16 << 3) | (i16 >>> 29)) ^ i216;
        int i217 = (((i216 >>> 8) | (i216 << 24)) + i17) ^ iArr[15];
        int i18 = ((i17 << 3) | (i17 >>> 29)) ^ i217;
        int i218 = (((i217 >>> 8) | (i217 << 24)) + i18) ^ iArr[16];
        int i19 = ((i18 << 3) | (i18 >>> 29)) ^ i218;
        int i219 = (((i218 >>> 8) | (i218 << 24)) + i19) ^ iArr[17];
        int i20 = ((i19 << 3) | (i19 >>> 29)) ^ i219;
        int i220 = (((i219 >>> 8) | (i219 << 24)) + i20) ^ iArr[18];
        int i21 = ((i20 << 3) | (i20 >>> 29)) ^ i220;
        int i221 = (((i220 >>> 8) | (i220 << 24)) + i21) ^ iArr[19];
        int i30 = ((i21 << 3) | (i21 >>> 29)) ^ i221;
        int i222 = (((i221 >>> 8) | (i221 << 24)) + i30) ^ iArr[20];
        int i31 = ((i30 << 3) | (i30 >>> 29)) ^ i222;
        int i223 = (((i222 >>> 8) | (i222 << 24)) + i31) ^ iArr[21];
        int i32 = ((i31 << 3) | (i31 >>> 29)) ^ i223;
        int i224 = (((i223 >>> 8) | (i223 << 24)) + i32) ^ iArr[22];
        int i33 = ((i32 << 3) | (i32 >>> 29)) ^ i224;
        int i225 = (((i224 >>> 8) | (i224 << 24)) + i33) ^ iArr[23];
        int i34 = ((i33 << 3) | (i33 >>> 29)) ^ i225;
        int i226 = (((i225 >>> 8) | (i225 << 24)) + i34) ^ iArr[24];
        int i35 = ((i34 << 3) | (i34 >>> 29)) ^ i226;
        int i227 = (((i226 >>> 8) | (i226 << 24)) + i35) ^ iArr[25];
        int i36 = ((i35 << 3) | (i35 >>> 29)) ^ i227;
        int i228 = (((i227 >>> 8) | (i227 << 24)) + i36) ^ iArr[26];
        iArr2[0] = ((i36 << 3) | (i36 >>> 29)) ^ i228;
        iArr2[1] = i228;
    }
}
