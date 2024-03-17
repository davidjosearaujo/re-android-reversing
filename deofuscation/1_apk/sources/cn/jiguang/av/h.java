package cn.jiguang.av;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class h extends cn.jiguang.be.b {
    public boolean a;
    private Context b;
    private cn.jiguang.ba.a c = new cn.jiguang.ba.b(8128, 20);

    static {
        cn.jiguang.at.b.a("NetworkingClient");
    }

    public h(Context context) {
        this.b = context;
        this.h = "NetworkingClient";
    }

    private void a(ByteBuffer byteBuffer) {
        cn.jiguang.at.b.b(new q(this.b, byteBuffer.array()), new int[0]);
    }

    private boolean a(int i) {
        if (this.a) {
            return false;
        }
        if (i <= 0) {
            cn.jiguang.ar.c.d("NetworkingClient", "login error,retry login too many times");
            g();
            f();
            return false;
        }
        cn.jiguang.ar.c.c("NetworkingClient", "loginTimes:" + i);
        if (e()) {
            int a = c.a(this.b, this.c);
            if (a < 0) {
                f();
                return false;
            } else if (a <= 0) {
                cn.jiguang.ax.h.a().a(this.b, "tcp_a10", null);
                return true;
            } else {
                g();
                if (a == 108) {
                    cn.jiguang.at.b.a(this.b);
                    return a(i - 1);
                }
                b(a);
                return false;
            }
        }
        return false;
    }

    private boolean a(Context context) {
        String str;
        cn.jiguang.ar.c.c("NetworkingClient", "google:true");
        cn.jiguang.bc.a.a(context);
        try {
            this.c = new j(k.a(context)).a(this);
        } catch (Exception e) {
            f();
            str = "sis and connect failed:" + e;
        }
        if (a(2)) {
            return true;
        }
        str = "login failed";
        cn.jiguang.ar.c.g("NetworkingClient", str);
        return false;
    }

    private void b(int i) {
        cn.jiguang.ar.c.a("NetworkingClient", "Action - onLoginFailed - respCode:" + i);
        Bundle bundle = new Bundle();
        bundle.putInt("resCode", i);
        cn.jiguang.ax.h.a().a(this.b, "tcp_a12", bundle);
    }

    private boolean e() {
        if (!cn.jiguang.d.b.a(this.b) || TextUtils.isEmpty(cn.jiguang.d.a.i(this.b))) {
            int b = c.b(this.b, this.c);
            if (b == 0) {
                cn.jiguang.ax.h.a().a(this.b, "tcp_a11", null);
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("resCode", b);
            cn.jiguang.ax.h.a().a(this.b, "tcp_a13", bundle);
            g();
            f();
            return false;
        }
        return true;
    }

    private void f() {
        cn.jiguang.ar.c.d("NetworkingClient", "Action - closeConnection");
        cn.jiguang.f.i.a(this.c);
        cn.jiguang.ax.h.a().a(this.b, "tcp_a19", null);
    }

    private void g() {
        c.b(this.b);
    }

    @Override // cn.jiguang.be.b
    public void a() {
        cn.jiguang.ar.c.f("NetworkingClient", "Begin to run in ConnectingThread - id:" + Thread.currentThread().getId());
        try {
        } catch (Throwable th) {
            cn.jiguang.ar.c.e("NetworkingClient", "run exception", th);
        }
        if (!a(this.b)) {
            cn.jiguang.ar.c.d("NetworkingClient", "prepare Push Channel failed , returned");
            return;
        }
        while (!this.a) {
            cn.jiguang.ar.c.d("NetworkingClient", "Network listening...");
            try {
                ByteBuffer a = this.c.a();
                a(a);
                cn.jiguang.ar.c.d("NetworkingClient", "Received bytes - len:" + a.array().length + ", pkg:" + cn.jiguang.f.a.b(this.b));
            } catch (cn.jiguang.ax.f e) {
                cn.jiguang.ar.c.g("NetworkingClient", " recv failed with error:" + e + " ,No Break!!");
            }
        }
        if (this.a) {
            cn.jiguang.ar.c.d("NetworkingClient", "Break receiving by wantStop");
        }
        f();
    }

    public synchronized void b() {
        try {
            cn.jiguang.be.d.a("TCP_CONN_TASK", this);
        } catch (Throwable th) {
            cn.jiguang.ar.c.h("NetworkingClient", "execute networkingClient exception :" + th);
        }
    }

    public synchronized void c() {
        cn.jiguang.ar.c.d("NetworkingClient", "Action - stop");
        cn.jiguang.f.i.a(this.c);
        this.a = true;
        cn.jiguang.be.d.a("TCP_CONN_TASK");
    }

    public cn.jiguang.ba.a d() {
        return this.c;
    }
}
