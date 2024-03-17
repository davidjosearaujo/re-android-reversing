package cn.jiguang.ba;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class a implements Closeable {
    public SocketChannel b;
    public int c;
    public Selector d;
    public int f = 20;
    public ByteBuffer a = ByteBuffer.allocate(49152);
    public boolean e = false;

    public int a(String str, int i) {
        if (this.a == null) {
            this.a = ByteBuffer.allocate(49152);
        }
        this.a.clear();
        this.c = 0;
        this.e = true;
        return 0;
    }

    public abstract int a(byte[] bArr);

    public ByteBuffer a() {
        return a(0);
    }

    public abstract ByteBuffer a(int i);

    public ByteBuffer b(int i) {
        int i2 = this.c;
        if (i2 >= i) {
            this.c = i2 - i;
            byte[] bArr = new byte[i];
            this.a.flip();
            this.a.get(bArr, 0, i);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.a.compact();
            return wrap;
        }
        return null;
    }

    public boolean b() {
        SocketChannel socketChannel;
        return this.e && (socketChannel = this.b) != null && socketChannel.isConnected();
    }

    public int c() {
        if (this.c < this.f) {
            return 0;
        }
        int position = this.a.position();
        this.a.position(0);
        int i = this.a.getShort() & Short.MAX_VALUE;
        this.a.position(position);
        return i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e = false;
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.c = 0;
    }
}
