package cn.jiguang.bd;

import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public int a;
    public int b;
    public int c;
    public Long d;
    public int e;
    public long f;
    private boolean g;

    public c(boolean z, int i, int i2, int i3, long j, int i4, long j2) {
        this.g = false;
        this.g = z;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = Long.valueOf(j);
        this.e = i4;
        this.f = j2;
    }

    public c(boolean z, int i, int i2, long j) {
        this(z, 0, i, i2, j, 0, 0L);
    }

    public c(boolean z, byte[] bArr) {
        this.g = false;
        this.g = z;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        short s = wrap.getShort();
        this.a = s;
        this.a = s & Short.MAX_VALUE;
        this.b = wrap.get();
        this.c = wrap.get();
        Long valueOf = Long.valueOf(wrap.getLong());
        this.d = valueOf;
        this.d = Long.valueOf(valueOf.longValue() & 65535);
        if (z) {
            this.e = wrap.getInt();
        }
        this.f = wrap.getLong();
    }

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public Long b() {
        return this.d;
    }

    public void b(int i) {
        this.e = i;
    }

    public long c() {
        return this.f;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.b;
    }

    public byte[] f() {
        if (this.a != 0) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            allocate.putShort((short) this.a);
            allocate.put((byte) this.b);
            allocate.put((byte) this.c);
            allocate.putLong(this.d.longValue());
            if (this.g) {
                allocate.putInt(this.e);
            }
            allocate.putLong(this.f);
            allocate.flip();
            return ProtocolUtil.getBytesConsumed(allocate);
        }
        throw new IllegalStateException("The head is not initialized yet.");
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[JHead] - len:");
        sb.append(this.a);
        sb.append(", version:");
        sb.append(this.b);
        sb.append(", command:");
        sb.append(this.c);
        sb.append(", rid:");
        sb.append(this.d);
        if (this.g) {
            str = ", sid:" + this.e;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f);
        return sb.toString();
    }
}
