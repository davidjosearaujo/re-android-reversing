package cn.jiguang.aw;

import com.facebook.imageutils.JfifUtil;
import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class o {
    public long a;
    public SelectionKey b;

    public o(long j) {
        Selector selector;
        SocketChannel open = SocketChannel.open();
        this.a = j;
        try {
            selector = Selector.open();
        } catch (Throwable th) {
            th = th;
            selector = null;
        }
        try {
            open.configureBlocking(false);
            this.b = open.register(selector, 1);
        } catch (Throwable th2) {
            th = th2;
            if (selector != null) {
                selector.close();
            }
            open.close();
            throw th;
        }
    }

    public static void a(SelectionKey selectionKey, long j) {
        long currentTimeMillis = j - System.currentTimeMillis();
        if ((currentTimeMillis > 0 ? selectionKey.selector().select(currentTimeMillis) : currentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0) == 0) {
            throw new SocketTimeoutException();
        }
    }

    private byte[] a(int i) {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        byte[] bArr = new byte[i];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b.interestOps(1);
        int i2 = 0;
        while (i2 < i) {
            try {
                if (this.b.isReadable()) {
                    long read = socketChannel.read(wrap);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i2 += (int) read;
                    if (i2 < i && System.currentTimeMillis() > this.a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.b, this.a);
                }
            } finally {
                if (this.b.isValid()) {
                    this.b.interestOps(0);
                }
            }
        }
        return bArr;
    }

    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) {
        o oVar = new o(j);
        if (socketAddress != null) {
            try {
                oVar.a(socketAddress);
            } finally {
                oVar.b();
            }
        }
        oVar.b(socketAddress2);
        oVar.a(bArr);
        return oVar.a();
    }

    public void a(SocketAddress socketAddress) {
        ((SocketChannel) this.b.channel()).socket().bind(socketAddress);
    }

    public void a(byte[] bArr) {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & JfifUtil.MARKER_FIRST_BYTE)}), ByteBuffer.wrap(bArr)};
        this.b.interestOps(4);
        int i = 0;
        while (i < bArr.length + 2) {
            try {
                if (this.b.isWritable()) {
                    long write = socketChannel.write(byteBufferArr);
                    if (write < 0) {
                        throw new EOFException();
                    }
                    i += (int) write;
                    if (i < bArr.length + 2 && System.currentTimeMillis() > this.a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.b, this.a);
                }
            } finally {
                if (this.b.isValid()) {
                    this.b.interestOps(0);
                }
            }
        }
    }

    public byte[] a() {
        byte[] a = a(2);
        byte[] a2 = a(((a[0] & 255) << 8) + (a[1] & 255));
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        return a2;
    }

    public void b() {
        this.b.selector().close();
        this.b.channel().close();
    }

    public void b(SocketAddress socketAddress) {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        if (socketChannel.connect(socketAddress)) {
            return;
        }
        this.b.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!this.b.isConnectable()) {
                    a(this.b, this.a);
                }
            } finally {
                if (this.b.isValid()) {
                    this.b.interestOps(0);
                }
            }
        }
    }
}
