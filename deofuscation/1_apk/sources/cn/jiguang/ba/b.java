package cn.jiguang.ba;

import cn.jiguang.ar.c;
import cn.jiguang.ax.f;
import cn.jiguang.f.i;
import com.alipay.sdk.app.PayTask;
import com.facebook.common.util.ByteConstants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends a {
    private final int g;
    private ByteBuffer h = ByteBuffer.allocate(8192);

    public b(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    private boolean b(byte[] bArr) {
        try {
            if (!b()) {
                c.c("NioSocketClient", "send error - connect was invalid");
                return false;
            }
            if (bArr != null && bArr.length > 0) {
                int write = this.b.write(ByteBuffer.wrap(bArr));
                if (write > 0) {
                    c.a("NioSocketClient", "isWritable has send len:" + write);
                    return true;
                } else if (write < 0) {
                    c.a("NioSocketClient", "isWritable error:" + write);
                    return false;
                } else {
                    return true;
                }
            }
            c.c("NioSocketClient", "send error - invalide buffer");
            return false;
        } catch (Exception e) {
            c.h("NioSocketClient", "send data error:" + e);
            close();
            return false;
        }
    }

    @Override // cn.jiguang.ba.a
    public synchronized int a(String str, int i) {
        super.a(str, i);
        this.b = SocketChannel.open();
        this.d = Selector.open();
        this.b.configureBlocking(false);
        this.b.connect(new InetSocketAddress(str, i));
        c.c("NioSocketClient", "tcp connecting...");
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.b.finishConnect()) {
            if (!this.e) {
                c.c("NioSocketClient", "has close channel when connect...");
                return -991;
            }
            Thread.sleep(10L);
            if (System.currentTimeMillis() - currentTimeMillis > PayTask.j) {
                close();
                return -994;
            }
        }
        if (!this.e) {
            c.c("NioSocketClient", "has close channel when connected...");
            return -991;
        }
        c.c("NioSocketClient", "tcp connected");
        this.b.register(this.d, 1);
        return 0;
    }

    @Override // cn.jiguang.ba.a
    public int a(byte[] bArr) {
        if (bArr == null) {
            c.c("NioSocketClient", "sendData failed, send data was null");
            return 103;
        }
        c.c("NioSocketClient", "send data length:" + bArr.length);
        if (bArr.length < this.g) {
            return b(bArr) ? 0 : 103;
        }
        c.c("NioSocketClient", "sendData failed, data length must less than " + this.g);
        return 6026;
    }

    @Override // cn.jiguang.ba.a
    public ByteBuffer a(int i) {
        ByteBuffer b;
        try {
            if (b()) {
                int c = c();
                if (c <= 0 || (b = b(c)) == null) {
                    int i2 = 0;
                    int i3 = ByteConstants.MB;
                    while (b() && this.c < i3) {
                        int select = i > 0 ? this.d.select(i) : this.d.select();
                        if (select == 0) {
                            c.c("NioSocketClient", "readSelect:" + select + ",time out:" + i);
                            if (i > 0) {
                                throw new f(-994, "recv time out");
                            }
                        } else {
                            Iterator<SelectionKey> it = this.d.selectedKeys().iterator();
                            while (it.hasNext()) {
                                SelectionKey next = it.next();
                                SocketChannel socketChannel = (SocketChannel) next.channel();
                                if (next.isReadable()) {
                                    int read = socketChannel.read(this.h);
                                    if (read < 0) {
                                        throw new f(-996, "read len < 0:" + read);
                                    }
                                    this.h.flip();
                                    int limit = this.h.limit();
                                    if (this.a.remaining() < limit) {
                                        throw new f(-996, "the total buf remaining less than readLen,remaining:" + this.a.remaining() + ",readLen:" + limit);
                                    }
                                    this.a.put(this.h);
                                    this.c += limit;
                                    this.h.compact();
                                    if (this.c < this.f) {
                                        c.c("NioSocketClient", "totalbuf can not parse head:" + this.c + ",peerNetData len:" + limit + ",read:" + read);
                                    } else {
                                        i3 = c();
                                    }
                                    i2 = limit;
                                } else {
                                    next.isWritable();
                                }
                                it.remove();
                            }
                            continue;
                        }
                    }
                    if (i3 != 1048576) {
                        c.c("NioSocketClient", "read len:" + i2 + ",recvTotalLen:" + this.c + ",shouldLen:" + i3);
                        ByteBuffer b2 = b(i3);
                        if (b2 != null) {
                            return b2;
                        }
                        throw new f(-1001, "parse error");
                    }
                    throw new f(-997, "recv empty data or tcp has close");
                }
                return b;
            }
            throw new f(-991, "recv error,the connect is invalid");
        } catch (Throwable th) {
            if (th instanceof SocketTimeoutException) {
                throw new f(-994, th.getMessage());
            }
            if (th instanceof f) {
                throw th;
            }
            throw new f(-997, th.getMessage());
        }
    }

    @Override // cn.jiguang.ba.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c.c("NioSocketClient", "close this connect");
        super.close();
        Selector selector = this.d;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException unused) {
            }
        }
        i.a(this.b);
        this.b = null;
    }
}
