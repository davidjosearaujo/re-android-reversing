package cn.jiguang.aw;

import com.facebook.soloader.MinElf;
import java.util.Random;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d implements Cloneable {
    private static Random d = new Random();
    private int a;
    private int b;
    private int[] c;

    public d() {
        this.b = 256;
        d();
    }

    public d(int i) {
        this.b = 256;
        d();
        a(i);
    }

    public d(b bVar) {
        this(bVar.g());
        this.b = bVar.g();
        int i = 0;
        while (true) {
            int[] iArr = this.c;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = bVar.g();
            i++;
        }
    }

    private void d() {
        this.c = new int[4];
        this.b = 256;
        this.a = -1;
    }

    public int a() {
        int i;
        int i2 = this.a;
        if (i2 >= 0) {
            return i2;
        }
        synchronized (this) {
            if (this.a < 0) {
                this.a = d.nextInt(MinElf.PN_XNUM);
            }
            i = this.a;
        }
        return i;
    }

    public void a(int i) {
        if (i >= 0 && i <= 65535) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
    }

    public void a(c cVar) {
        cVar.c(a());
        cVar.c(this.b);
        int i = 0;
        while (true) {
            int[] iArr = this.c;
            if (i >= iArr.length) {
                return;
            }
            cVar.c(iArr[i]);
            i++;
        }
    }

    public int b() {
        return this.b & 15;
    }

    public void b(int i) {
        int[] iArr = this.c;
        if (iArr[i] == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i] = iArr[i] + 1;
    }

    public int c() {
        return this.b;
    }

    public int c(int i) {
        return this.c[i];
    }

    public Object clone() {
        d dVar = new d();
        dVar.a = this.a;
        dVar.b = this.b;
        int[] iArr = this.c;
        System.arraycopy(iArr, 0, dVar.c, 0, iArr.length);
        return dVar;
    }

    public String d(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(";; ->>HEADER<<- ");
        stringBuffer.append(", id: " + a());
        stringBuffer.append("\n");
        stringBuffer.append("; ");
        for (int i2 = 0; i2 < 4; i2++) {
            stringBuffer.append(n.a(i2) + ": " + c(i2) + " ");
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return d(b());
    }
}
