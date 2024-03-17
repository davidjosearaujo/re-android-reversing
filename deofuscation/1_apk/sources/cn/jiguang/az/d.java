package cn.jiguang.az;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    public int a;
    public int b;
    public int c;
    public int d;
    private final c e;
    private ByteBuffer f;
    private int g;
    private String h;
    private String i;

    public d(c cVar, ByteBuffer byteBuffer) {
        this.e = cVar;
        if (byteBuffer == null) {
            cn.jiguang.ar.c.g("LoginResponse", "No body to parse.");
            return;
        }
        this.f = byteBuffer;
        a();
    }

    private void a() {
        try {
            this.a = this.f.getShort();
        } catch (Throwable unused) {
            this.a = 10000;
        }
        if (this.a > 0) {
            cn.jiguang.ar.c.i("LoginResponse", "Response error - code:" + this.a);
        }
        ByteBuffer byteBuffer = this.f;
        this.d = -1;
        int i = this.a;
        if (i != 0) {
            if (i == 1012) {
                try {
                    this.i = b.a(byteBuffer);
                } catch (Throwable unused2) {
                    this.a = 10000;
                }
                cn.jiguang.au.a.a(JCoreManager.getAppContext(null), this.i);
                return;
            }
            return;
        }
        try {
            this.b = byteBuffer.getInt();
            this.g = byteBuffer.getShort();
            this.h = b.a(byteBuffer);
            this.c = byteBuffer.getInt();
        } catch (Throwable unused3) {
            this.a = 10000;
        }
        try {
            this.d = byteBuffer.get();
            cn.jiguang.ar.c.c("LoginResponse", "idc parse success, value:" + this.d);
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("LoginResponse", "parse idc failed, error:" + th);
        }
    }

    public String toString() {
        return "[LoginResponse] - code:" + this.a + ",sid:" + this.b + ", serverVersion:" + this.g + ", sessionKey:" + this.h + ", serverTime:" + this.c + ", idc:" + this.d + ", connectInfo:" + this.i;
    }
}
