package cn.jiguang.aw;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class i implements Serializable, Cloneable, Comparable {
    private static final DecimalFormat e;
    public g a;
    public int b;
    public int c;
    public long d;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        e = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    public static i a(b bVar, int i) {
        g gVar = new g(bVar);
        int g = bVar.g();
        int g2 = bVar.g();
        return i == 0 ? a(gVar, g, g2) : a(gVar, g, g2, bVar.h(), bVar.g(), bVar);
    }

    public static i a(g gVar, int i, int i2) {
        return a(gVar, i, i2, 0L);
    }

    public static i a(g gVar, int i, int i2, long j) {
        if (gVar.a()) {
            return a(gVar, i, i2, j, false);
        }
        throw new j(gVar);
    }

    private static i a(g gVar, int i, int i2, long j, int i3, b bVar) {
        i a = a(gVar, i, i2, j, bVar != null);
        if (bVar != null) {
            if (bVar.b() < i3) {
                throw new IOException("truncated record");
            }
            bVar.a(i3);
            a.a(bVar);
            if (bVar.b() > 0) {
                throw new IOException("invalid record length");
            }
            bVar.c();
        }
        return a;
    }

    private static final i a(g gVar, int i, int i2, long j, boolean z) {
        m mVar = new m();
        mVar.a = gVar;
        mVar.b = i;
        mVar.c = i2;
        mVar.d = j;
        return mVar;
    }

    private void a(c cVar, boolean z) {
        this.a.a(cVar);
        cVar.c(this.b);
        cVar.c(this.c);
        cVar.a(z ? 0L : this.d);
        int a = cVar.a();
        cVar.c(0);
        a(cVar, (a) null, true);
        cVar.a((cVar.a() - a) - 2, a);
    }

    private byte[] a(boolean z) {
        c cVar = new c();
        a(cVar, z);
        return cVar.b();
    }

    public void a(long j) {
        this.d = j;
    }

    public abstract void a(b bVar);

    public void a(c cVar, int i, a aVar) {
        this.a.a(cVar, aVar);
        cVar.c(this.b);
        cVar.c(this.c);
    }

    public abstract void a(c cVar, a aVar, boolean z);

    public boolean a(i iVar) {
        return f() == iVar.f() && this.c == iVar.c && this.a.equals(iVar.a);
    }

    public byte[] a() {
        c cVar = new c();
        a(cVar, (a) null, true);
        return cVar.b();
    }

    public abstract String b();

    public String c() {
        return b();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        i iVar = (i) obj;
        if (this == iVar) {
            return 0;
        }
        int compareTo = this.a.compareTo(iVar.a);
        if (compareTo != 0) {
            return compareTo;
        }
        int i = this.c - iVar.c;
        if (i != 0) {
            return i;
        }
        int i2 = this.b - iVar.b;
        if (i2 != 0) {
            return i2;
        }
        byte[] a = a();
        byte[] a2 = iVar.a();
        for (int i3 = 0; i3 < a.length && i3 < a2.length; i3++) {
            int i4 = (a[i3] & 255) - (a2[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
        }
        return a.length - a2.length;
    }

    public g d() {
        return this.a;
    }

    public int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof i)) {
            i iVar = (i) obj;
            if (this.b == iVar.b && this.c == iVar.c && this.a.equals(iVar.a)) {
                return Arrays.equals(a(), iVar.a());
            }
        }
        return false;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public long h() {
        return this.d;
    }

    public int hashCode() {
        int i = 0;
        for (byte b : a(true)) {
            i += (i << 3) + (b & 255);
        }
        return i;
    }

    public i i() {
        try {
            return (i) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String b = b();
        if (!b.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(b);
        }
        return stringBuffer.toString();
    }
}
