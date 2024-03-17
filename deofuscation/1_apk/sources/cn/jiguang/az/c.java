package cn.jiguang.az;

import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public int a;
    public int b;
    public int c;
    public byte d;
    public long e;
    public int f;
    public long g;
    private boolean h;

    public c(boolean z, byte[] bArr) {
        this.h = false;
        try {
            this.h = z;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            short s = wrap.getShort();
            this.a = s;
            this.a = s & Short.MAX_VALUE;
            this.b = wrap.get();
            this.c = wrap.get();
            this.d = wrap.get();
            wrap.get();
            wrap.getInt();
            this.e = wrap.getShort();
            if (z) {
                this.f = wrap.getInt();
            }
            this.g = wrap.getLong();
        } catch (Throwable unused) {
        }
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
        sb.append(this.e);
        if (this.h) {
            str = ", sid:" + this.f;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.g);
        return sb.toString();
    }
}
