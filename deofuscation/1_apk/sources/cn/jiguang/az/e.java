package cn.jiguang.az;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    public int a;
    public long b;
    public String c;
    public String d;
    public String e;
    private final c f;
    private ByteBuffer g;
    private String h;
    private String i;

    public e(c cVar, ByteBuffer byteBuffer) {
        this.f = cVar;
        if (byteBuffer == null) {
            cn.jiguang.ar.c.g("RegisterResponse", "No body to parse.");
            return;
        }
        this.g = byteBuffer;
        a();
    }

    private void a() {
        try {
            this.a = this.g.getShort();
        } catch (Throwable unused) {
            this.a = 10000;
        }
        if (this.a > 0) {
            cn.jiguang.ar.c.i("RegisterResponse", "Response error - code:" + this.a);
        }
        ByteBuffer byteBuffer = this.g;
        int i = this.a;
        try {
            if (i == 0) {
                this.b = byteBuffer.getLong();
                this.c = b.a(byteBuffer);
                this.d = b.a(byteBuffer);
            } else if (i != 1007) {
                if (i == 1012) {
                    try {
                        this.i = b.a(byteBuffer);
                    } catch (Throwable unused2) {
                        this.a = 10000;
                    }
                    cn.jiguang.au.a.a(JCoreManager.getAppContext(null), this.i);
                }
            } else {
                this.h = b.a(byteBuffer);
            }
        } catch (Throwable unused3) {
            this.a = 10000;
        }
    }

    public String toString() {
        return "[RegisterResponse] - code:" + this.a + ", juid:" + this.b + ", password:" + this.c + ", regId:" + this.d + ", deviceId:" + this.e + ", connectInfo:" + this.i;
    }
}
