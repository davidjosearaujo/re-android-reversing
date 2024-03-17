package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    private static final BigInteger d = BigInteger.ONE.shiftLeft(64);
    private byte[] a;
    private int b;
    private int c;

    public e() {
        this(32);
    }

    public e(int i) {
        this.a = new byte[i];
        this.b = 0;
        this.c = -1;
    }

    private void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            Logger.w("OutputDataUtil", j + " out of range for " + i + " bit value max:" + j2);
        }
    }

    private void c(int i) {
        byte[] bArr = this.a;
        int length = bArr.length;
        int i2 = this.b;
        if (length - i2 >= i) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i2 + i) {
            length2 = i2 + i;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.a = bArr2;
    }

    public void a(int i) {
        a(i, 8);
        c(1);
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & JfifUtil.MARKER_FIRST_BYTE);
    }

    public void a(long j) {
        c(8);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        this.b = i3;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        this.b = i4;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        this.b = i5;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        this.b = i6;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        this.b = i7;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        this.b = i8;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        this.b = i8 + 1;
        bArr[i8] = (byte) (j & 255);
    }

    public void a(String str) {
        byte[] b = c.b(str);
        b(b.length);
        a(b, 0, b.length);
    }

    public void a(byte[] bArr) {
        b(bArr.length);
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i, int i2) {
        c(i2);
        System.arraycopy(bArr, i, this.a, this.b, i2);
        this.b += i2;
    }

    public byte[] a() {
        int i = this.b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.a, 0, bArr, 0, i);
        return bArr;
    }

    public void b(int i) {
        a(i, 16);
        c(2);
        byte[] bArr = this.a;
        int i2 = this.b;
        int i3 = i2 + 1;
        this.b = i3;
        bArr[i2] = (byte) ((i >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        this.b = i3 + 1;
        bArr[i3] = (byte) (i & JfifUtil.MARKER_FIRST_BYTE);
    }
}
