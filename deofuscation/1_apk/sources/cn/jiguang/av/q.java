package cn.jiguang.av;

import android.content.Context;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class q extends cn.jiguang.be.b {
    private byte[] a;
    private Context b;

    public q(Context context, byte[] bArr) {
        this.b = context;
        this.a = bArr;
        this.h = "TcpRecvAction";
    }

    @Override // cn.jiguang.be.b
    public void a() {
        try {
            cn.jiguang.ax.h.a().a(this.b, "tcp_a22", null);
            cn.jiguang.az.a.a(this.b, this.a);
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("TcpRecvAction", "TcpRecvAction failed:" + th.getMessage());
        }
    }
}
