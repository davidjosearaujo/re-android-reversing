package cn.jiguang.aw;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private ByteBuffer a;
    private int b = -1;
    private int c = -1;

    public b(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    private void c(int i) {
        if (i > b()) {
            throw new IOException("end of input");
        }
    }

    public int a() {
        return this.a.position();
    }

    public void a(int i) {
        if (i > this.a.capacity() - this.a.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.a;
        byteBuffer.limit(byteBuffer.position() + i);
    }

    public void a(byte[] bArr, int i, int i2) {
        c(i2);
        this.a.get(bArr, i, i2);
    }

    public int b() {
        return this.a.remaining();
    }

    public void b(int i) {
        if (i >= this.a.capacity()) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.a.position(i);
        ByteBuffer byteBuffer = this.a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void c() {
        ByteBuffer byteBuffer = this.a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void d() {
        this.b = this.a.position();
        this.c = this.a.limit();
    }

    public void e() {
        int i = this.b;
        if (i < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.a.position(i);
        this.a.limit(this.c);
        this.b = -1;
        this.c = -1;
    }

    public int f() {
        c(1);
        return this.a.get() & 255;
    }

    public int g() {
        c(2);
        return this.a.getShort() & 65535;
    }

    public long h() {
        c(4);
        return this.a.getInt() & 4294967295L;
    }
}
