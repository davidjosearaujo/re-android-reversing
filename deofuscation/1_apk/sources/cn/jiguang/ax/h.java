package cn.jiguang.ax;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import com.alibaba.fastjson.JSONStreamContext;
import com.alipay.sdk.app.PayTask;
import com.facebook.GraphResponse;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.login.LoginStatusClient;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.hunantv.media.player.MgtvMediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class h {
    private static volatile h i;
    private static final Object j = new Object();
    private cn.jiguang.av.h a;
    private int b;
    private int c;
    private long f;
    private boolean g;
    private Context k;
    private int d = 0;
    private int e = 0;
    private boolean l = false;
    private final AtomicBoolean m = new AtomicBoolean(false);
    private cn.jiguang.bb.a n = new cn.jiguang.bb.a() { // from class: cn.jiguang.ax.h.1
        {
            h.this = this;
        }

        @Override // cn.jiguang.bb.a
        public void a(Message message) {
            h hVar;
            Context context;
            String str;
            Bundle bundle;
            boolean z;
            if (message != null) {
                int i2 = message.what;
                if (i2 == 1011) {
                    hVar = h.this;
                    context = hVar.k;
                    str = "tcp_a14";
                } else if (i2 != 1022) {
                    if (i2 == 2000) {
                        k.a().a(h.this.k);
                        return;
                    }
                    switch (i2) {
                        case JSONStreamContext.StartArray /* 1004 */:
                            bundle = new Bundle();
                            z = true;
                            break;
                        case JSONStreamContext.ArrayValue /* 1005 */:
                            bundle = new Bundle();
                            z = false;
                            break;
                        case 1006:
                        case 1007:
                            hVar = h.this;
                            context = hVar.k;
                            str = "tcp_a2";
                            break;
                        default:
                            return;
                    }
                    bundle.putBoolean("force", z);
                    h hVar2 = h.this;
                    hVar2.a(hVar2.k, "tcp_a16", bundle);
                    return;
                } else {
                    hVar = h.this;
                    context = hVar.k;
                    str = "tcp_a17";
                }
                hVar.a(context, str, null);
            }
        }
    };
    private boolean o = false;
    private int p = 0;
    private int q = 0;
    private boolean h = true;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends cn.jiguang.be.b {
        private Context b;
        private String c;
        private Bundle d;

        public a(Context context, String str, Bundle bundle) {
            h.this = r1;
            this.b = context;
            this.c = str;
            this.d = bundle;
            this.h = "TcpManager";
        }

        @Override // cn.jiguang.be.b
        public void a() {
            h hVar;
            long j;
            try {
                if (!this.c.equals("tcp_a1")) {
                    if (!this.c.equals("tcp_a3") && !this.c.equals("tcp_a4") && !this.c.equals("tcp_a20")) {
                        if (this.c.equals("tcp_a5")) {
                            Bundle bundle = this.d;
                            if (bundle != null) {
                                byte[] byteArray = bundle.getByteArray(SDKConstants.PARAM_A2U_BODY);
                                int i = this.d.getInt("cmd", -1);
                                int i2 = this.d.getInt("ver", -1);
                                long j2 = this.d.getLong("rid", -1L);
                                String string = this.d.getString(HianalyticsBaseData.SDK_TYPE);
                                long j3 = this.d.getLong(com.alipay.sdk.data.a.Q);
                                cn.jiguang.ar.c.c("JCoreTCPManager", "send quest,cmd:" + i + ",ver:" + i2 + ",rid:" + j2 + ",body size:" + byteArray.length);
                                if (i >= 0 && i2 >= 0 && j2 >= 0 && !TextUtils.isEmpty(string)) {
                                    j.a().a(this.b, j2, i, i2, byteArray, string, j3);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (this.c.equals("tcp_a19")) {
                            h.this.l();
                            return;
                        } else if (this.c.equals("tcp_a11")) {
                            cn.jiguang.ar.c.d("JCoreTCPManager", "resgiter success:" + cn.jiguang.d.a.b(this.b));
                            cn.jiguang.f.a.h(this.b);
                            b a = b.a();
                            Context context = this.b;
                            a.a(context, 0, 0, cn.jiguang.d.a.b(context));
                            e.a(this.b, "on_register", null);
                            return;
                        } else if (this.c.equals("tcp_a10")) {
                            h.this.j();
                            return;
                        } else if (this.c.equals("tcp_a9")) {
                            h.this.d(this.b);
                            return;
                        } else if (this.c.equals("tcp_a8")) {
                            h.this.b(this.b);
                            return;
                        } else if (this.c.equals("tcp_a2")) {
                            g.a().a(this.b, false);
                            h.this.a(this.d);
                            return;
                        } else if (this.c.equals("tcp_a13")) {
                            cn.jiguang.ar.c.d("JCoreTCPManager", "resgiter failed");
                            Bundle bundle2 = this.d;
                            if (bundle2 != null) {
                                int i3 = bundle2.getInt("resCode", 0);
                                h.this.c = i3;
                                cn.jiguang.av.c.a(this.b, i3);
                                return;
                            }
                            return;
                        } else if (this.c.equals("tcp_a12")) {
                            cn.jiguang.ar.c.d("JCoreTCPManager", "login failed");
                            Bundle bundle3 = this.d;
                            if (bundle3 != null) {
                                h.this.a(bundle3.getInt("resCode", 0));
                                return;
                            }
                            return;
                        } else if (this.c.equals("tcp_a14")) {
                            hVar = h.this;
                        } else if (this.c.equals("tcp_a15")) {
                            h.this.b(this.d);
                            return;
                        } else if (this.c.equals("tcp_a16")) {
                            h.this.c(this.d);
                            return;
                        } else if (this.c.equals("tcp_a17")) {
                            h.this.q();
                            return;
                        } else if (this.c.equals("tcp_a18")) {
                            h.this.s();
                            return;
                        } else if (this.c.equals("tcp_a6")) {
                            Bundle bundle4 = this.d;
                            if (bundle4 != null) {
                                long j4 = bundle4.getLong("rid", -1L);
                                if (j4 > 0) {
                                    j.a().b(this.b, j4);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (this.c.equals("tcp_a7")) {
                            Bundle bundle5 = this.d;
                            if (bundle5 != null) {
                                long j5 = bundle5.getLong("rid", -1L);
                                if (j5 > 0) {
                                    j.a().a(this.b, j5);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (this.c.equals("tcp_a21")) {
                            h.this.k();
                            return;
                        } else if (this.c.equals("tcp_a22")) {
                            h.this.b();
                            return;
                        } else if (this.c.equals("tcp_a23")) {
                            h.this.c(this.b);
                            return;
                        } else if (!this.c.equals("tcp_a24")) {
                            return;
                        } else {
                            h.this.m();
                            h.this.c = 0;
                            h.this.b = 0;
                            hVar = h.this;
                        }
                    }
                    if (h.this.a != null) {
                        if (h.this.a.d() != null) {
                            byte[] byteArray2 = this.d.getByteArray(SDKConstants.PARAM_A2U_BODY);
                            int i4 = this.d.getInt("cmd", -1);
                            int i5 = this.d.getInt("ver", -1);
                            long j6 = this.d.getLong("rid", -1L);
                            String string2 = this.d.getString(HianalyticsBaseData.SDK_TYPE);
                            cn.jiguang.ar.c.c("JCoreTCPManager", "send data,cmd:" + i4 + ",ver:" + i5 + ",rid:" + j6 + ",body size:" + byteArray2.length);
                            if (i4 >= 0 && i5 >= 0 && j6 >= 0) {
                                if (this.c.equals("tcp_a3")) {
                                    j.a().a(this.b, j6, i4, i5, byteArray2, string2);
                                    return;
                                }
                                if (this.c.equals("tcp_a20")) {
                                    long j7 = this.d.getLong(CommonConstant.KEY_UID, 0L);
                                    if (j7 == 0) {
                                        cn.jiguang.ar.c.g("JCoreTCPManager", "share response uid is 0");
                                        return;
                                    }
                                    j = j7;
                                } else {
                                    j = 0;
                                }
                                h.a().c().d().a(cn.jiguang.az.b.a(this.b, i4, i5, j6, byteArray2, j));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    cn.jiguang.ar.c.c("JCoreTCPManager", "send data failed:tcp breaked,will restart");
                    hVar = h.this;
                } else if (h.this.a != null) {
                    return;
                } else {
                    hVar = h.this;
                }
                hVar.o();
            } catch (Throwable th) {
                cn.jiguang.ar.c.h("JCoreTCPManager", "tcp action failed:" + th.getMessage());
            }
        }
    }

    private h() {
    }

    public static h a() {
        if (i == null) {
            synchronized (j) {
                if (i == null) {
                    i = new h();
                }
            }
        }
        return i;
    }

    public void a(int i2) {
        this.b = i2;
        if (i2 == 1012) {
            cn.jiguang.av.c.a(this.k);
        }
        m();
    }

    public void b(Context context) {
        cn.jiguang.ar.c.c("JCoreTCPManager", "handleStop...");
        if (((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.A())).booleanValue()) {
            cn.jiguang.ar.c.d("JCoreTCPManager", "tcp already stoped");
        } else if (!b.a().a(0)) {
            cn.jiguang.ar.c.c("JCoreTCPManager", "Action: handleStopPush - can't stop tcp");
        } else {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.A().a((cn.jiguang.g.a<Boolean>) Boolean.TRUE));
            m();
        }
    }

    public void c(Context context) {
        cn.jiguang.ar.c.c("JCoreTCPManager", "handleUnRegister...");
        if (!((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.n())).booleanValue()) {
            cn.jiguang.ar.c.d("JCoreTCPManager", "tcp already stoped");
        } else if (!b.a().a(0)) {
            cn.jiguang.ar.c.c("JCoreTCPManager", "Action: handleUnRegister - can't stop tcp");
        } else {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.n().a((cn.jiguang.g.a<Boolean>) Boolean.FALSE));
            m();
        }
    }

    public void c(Bundle bundle) {
        String str;
        if (this.m.get()) {
            str = "isBeating, skip this time";
        } else {
            if ((bundle != null ? bundle.getBoolean("force", false) : false) || !p()) {
                cn.jiguang.ar.c.d("JCoreTCPManager", "Send heart beat");
                cn.jiguang.bb.b.a().b(JSONStreamContext.ArrayValue);
                if (this.g) {
                    r();
                    return;
                } else {
                    cn.jiguang.ar.c.c("JCoreTCPManager", "socket is closed or push isn't login");
                    return;
                }
            }
            str = "No need to rtc, Because it have succeed recently";
        }
        cn.jiguang.ar.c.c("JCoreTCPManager", str);
    }

    public void d(Context context) {
        String str;
        cn.jiguang.ar.c.c("JCoreTCPManager", "handleResume...");
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.A().a((cn.jiguang.g.a<Boolean>) Boolean.FALSE));
        if (this.g) {
            str = "[handleResume] is loggedin";
        } else if (this.a == null) {
            o();
            return;
        } else {
            str = "[handleResume] tcp is connecting...";
        }
        cn.jiguang.ar.c.c("JCoreTCPManager", str);
    }

    public void j() {
        cn.jiguang.ar.c.d("JCoreTCPManager", "Action - onLoggedIn");
        if (!this.g) {
            this.g = true;
            b.a().a(this.k, 1, 0, GraphResponse.SUCCESS_KEY);
        }
        b();
        this.d = 0;
        this.e = 0;
        cn.jiguang.ar.c.c("JCoreTCPManager", "Force to send 12s heartbeat after login");
        cn.jiguang.a.a.a(this.k, true, 12000L);
        Bundle bundle = new Bundle();
        bundle.putBoolean("login", true);
        e.a(this.k, "periodtask", bundle);
        if (k()) {
            cn.jiguang.bb.b.a().b(MgtvMediaPlayer.MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS, this.n);
            cn.jiguang.e.a.b().a(this.k);
            j.a().a(this.k);
            g.a().a(this.k, true);
            cn.jiguang.aq.b.a(this.k);
        }
    }

    public boolean k() {
        if (cn.jiguang.aq.c.a().a(this.k) || k.a().b(this.k)) {
            return true;
        }
        cn.jiguang.ar.c.c("JCoreTCPManager", "not keep tcp");
        this.h = false;
        m();
        return false;
    }

    public void l() {
        cn.jiguang.ar.c.d("JCoreTCPManager", "Action - onDisconnected");
        if (this.g) {
            this.g = false;
            b.a().a(this.k, -1, -1, "push connect break");
        }
        if (this.a == null && ((Boolean) cn.jiguang.g.b.a(this.k, cn.jiguang.g.a.A())).booleanValue()) {
            cn.jiguang.ar.c.c("JCoreTCPManager", "push already stopped!!!");
            return;
        }
        this.e = 0;
        m();
        n();
        this.d++;
    }

    public void m() {
        cn.jiguang.av.h hVar = this.a;
        if (hVar == null) {
            cn.jiguang.ar.c.c("JCoreTCPManager", "tcp has stopeed");
            return;
        }
        hVar.c();
        this.a = null;
    }

    private void n() {
        String str;
        String str2;
        cn.jiguang.ar.c.d("JCoreTCPManager", "Action - retryConnect - disconnectedTimes:" + this.d);
        if (!cn.jiguang.f.a.d(this.k.getApplicationContext())) {
            str2 = "[retryConnect] network is not connect";
        } else if (this.c <= 0) {
            int c = cn.jiguang.f.a.c(this.k.getApplicationContext());
            int pow = (int) (Math.pow(2.0d, this.d) * 3.0d * 1000.0d);
            int f = f();
            int i2 = (f * 1000) / 2;
            if (pow > i2) {
                pow = i2;
            }
            cn.jiguang.ar.c.c("JCoreTCPManager", "[retryConnect] mDisconnectedTimes:" + this.d + ",chargedLever:" + c + ",heartbeatInterval:" + f + ",delayTime:" + pow);
            if (c != 1 ? this.d >= 5 : this.d >= 30) {
                str = "Give up to retry connect.";
            } else if (!cn.jiguang.bb.b.a().a(1011)) {
                cn.jiguang.bb.b.a().b(1011, pow, this.n);
                return;
            } else {
                str = "Already has MSG_RESTART_CONN";
            }
            cn.jiguang.ar.c.c("JCoreTCPManager", str);
            return;
        } else {
            str2 = "[retryConnect] registerErrCode >0,registerErrCode:" + this.c;
        }
        cn.jiguang.ar.c.c("JCoreTCPManager", str2);
    }

    public synchronized void o() {
        cn.jiguang.ar.c.d("JCoreTCPManager", "Action - restartNetworkingClient, pid:" + Process.myPid());
        if (!this.h) {
            cn.jiguang.ar.c.f("JCoreTCPManager", "need not keep tcp,next start app will re login");
        } else if (!cn.jiguang.f.a.d(this.k.getApplicationContext())) {
            cn.jiguang.ar.c.f("JCoreTCPManager", "No network connection. Give up to start connection thread.");
        } else if (((Boolean) cn.jiguang.g.b.a(this.k, cn.jiguang.g.a.A())).booleanValue()) {
            cn.jiguang.ar.c.d("JCoreTCPManager", "[restartNetworkingClient] tcp has close by active");
        } else if (!((Boolean) cn.jiguang.g.b.a(this.k, cn.jiguang.g.a.n())).booleanValue()) {
            cn.jiguang.ar.c.d("JCoreTCPManager", "[restartNetworkingClient] tcp has close by ups.unregister");
        } else {
            int i2 = this.c;
            if (i2 != 1005 && i2 != 1006 && i2 != 1008 && i2 != 1009) {
                if (this.b == 102) {
                    cn.jiguang.ar.c.h("JCoreTCPManager", "login failed:102,give up start connection thread.reset from next app start");
                    return;
                } else if (this.a != null) {
                    cn.jiguang.ar.c.d("JCoreTCPManager", "NetworkingClient is running");
                    return;
                } else {
                    cn.jiguang.av.h hVar = new cn.jiguang.av.h(this.k.getApplicationContext());
                    this.a = hVar;
                    hVar.b();
                    return;
                }
            }
            cn.jiguang.ar.c.c("JCoreTCPManager", "[restartNetworkingClient] registerErrCode >0,registerErrCode:" + this.c);
            b.a().a(this.k, 2002, this.c, "");
        }
    }

    private boolean p() {
        int i2 = this.p;
        long currentTimeMillis = System.currentTimeMillis() - this.f;
        return i2 > 0 ? currentTimeMillis < ((long) (this.p + (-4))) * 1000 : currentTimeMillis < 18000;
    }

    public void q() {
        this.m.set(false);
        this.e++;
        cn.jiguang.ar.c.d("JCoreTCPManager", "Action - onHeartbeatTimeout - timeoutTimes:" + this.e);
        cn.jiguang.ar.c.b("JCoreTCPManager", "============================================================");
        if (this.a != null && !this.g) {
            cn.jiguang.ar.c.d("JCoreTCPManager", "Is connecting now. Give up to retry.");
        } else if (!this.g || this.e > 1) {
            m();
            n();
        } else {
            cn.jiguang.ar.c.d("JCoreTCPManager", "Already logged in. Give up to retry.");
            cn.jiguang.bb.b.a().b(JSONStreamContext.ArrayValue, LoginStatusClient.DEFAULT_TOAST_DURATION_MS, this.n);
        }
    }

    private void r() {
        this.m.set(true);
        cn.jiguang.bb.b.a().b(1022);
        Long valueOf = Long.valueOf(cn.jiguang.av.c.c(this.k));
        long f = cn.jiguang.d.a.f(this.k);
        int i2 = cn.jiguang.at.b.b;
        cn.jiguang.ar.c.c("JCoreTCPManager", "heartbeat - juid:" + f + ", flag:1 ,userType:" + i2);
        byte[] a2 = cn.jiguang.az.b.a(this.k, cn.jiguang.az.b.a(valueOf.longValue(), JConstants.tcpSessionId, f, (short) 1, i2));
        if (a2 != null) {
            this.a.d().a(a2);
        } else {
            cn.jiguang.ar.c.h("JCoreTCPManager", "send hb failed:sendData is null");
        }
        cn.jiguang.bb.b.a().b(1022, 10000L, this.n);
    }

    public void s() {
        cn.jiguang.ar.c.d("JCoreTCPManager", "Action - onHeartbeatSucceed");
        b.a().a(this.k, 19, 0, "ack success");
    }

    public synchronized void a(Context context) {
        if (this.l) {
            return;
        }
        if (context == null) {
            cn.jiguang.ar.c.c("JCoreTCPManager", "init context is null");
            return;
        }
        cn.jiguang.ar.c.c("JCoreTCPManager", "init tcp manager...");
        this.k = context.getApplicationContext();
        cn.jiguang.at.b.a("JCoreTCPManager");
        cn.jiguang.bb.b.a().a(this.k);
        g.a().a(context, true);
        this.l = true;
    }

    public void a(Context context, String str, Bundle bundle) {
        a(context);
        cn.jiguang.at.b.c(new a(context, str, bundle), new int[0]);
    }

    public void a(Bundle bundle) {
        long j2;
        if (((Boolean) cn.jiguang.g.b.a(this.k, cn.jiguang.g.a.A())).booleanValue()) {
            cn.jiguang.ar.c.d("JCoreTCPManager", "[rtc] tcp has close by active");
            return;
        }
        boolean z = true;
        if (bundle != null) {
            z = bundle.getBoolean("force", true);
            j2 = bundle.getLong("delay_time", 0L);
        } else {
            j2 = 0;
        }
        if (this.a == null) {
            o();
            return;
        }
        if (j2 <= 0) {
            c(bundle);
        } else {
            int i2 = JSONStreamContext.StartArray;
            if (z) {
                cn.jiguang.bb.b.a().b(JSONStreamContext.ArrayValue);
                cn.jiguang.bb.b.a().b(JSONStreamContext.StartArray);
            }
            cn.jiguang.bb.b a2 = cn.jiguang.bb.b.a();
            if (!z) {
                i2 = JSONStreamContext.ArrayValue;
            }
            a2.b(i2, j2, this.n);
        }
        cn.jiguang.ar.c.e("JCoreTCPManager", "send rtc force=" + z + " delay=" + j2);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean optBoolean = jSONObject.optBoolean("use_ssp");
                this.o = optBoolean;
                if (optBoolean) {
                    int optInt = jSONObject.optInt("hb_interval");
                    if (optInt <= 0) {
                        cn.jiguang.ar.c.g("JCoreTCPManager", "hb_interval is less than 0, will use 15s");
                        this.p = 15;
                    } else if (optInt >= JConstants.DEFAULT_HEARTBEAT_INTERVAL / 2) {
                        cn.jiguang.ar.c.g("JCoreTCPManager", "hb_interval is more than " + JConstants.DEFAULT_HEARTBEAT_INTERVAL + ", will use " + JConstants.DEFAULT_HEARTBEAT_INTERVAL + "s");
                        this.p = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
                        this.p = 0;
                    } else {
                        cn.jiguang.ar.c.g("JCoreTCPManager", "set ssp heartbeat interval:" + optInt);
                        this.p = optInt;
                    }
                    if (this.p > 0) {
                        i();
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("JCoreTCPManager", "[TcpManager] handleCtrlHeartBeatCmd error:" + th);
            }
        }
    }

    public void b() {
        cn.jiguang.bb.b.a().b(1022);
        this.f = System.currentTimeMillis();
        this.e = 0;
        this.m.set(false);
        cn.jiguang.ar.c.e("JCoreTCPManager", "update rtc state");
    }

    public void b(Bundle bundle) {
        if (((Boolean) cn.jiguang.g.b.a(this.k, cn.jiguang.g.a.A())).booleanValue()) {
            cn.jiguang.ar.c.g("JCoreTCPManager", "[netWorkChanged] tcp has close by active");
            return;
        }
        cn.jiguang.bb.b.a().b(1006);
        cn.jiguang.bb.b.a().b(1007);
        if (!bundle.getBoolean("connected", false)) {
            cn.jiguang.ar.c.c("JCoreTCPManager", "Handle disconnected state.");
            cn.jiguang.bb.b.a().b(1007, PayTask.j, this.n);
            return;
        }
        cn.jiguang.ar.c.c("JCoreTCPManager", "Handle connected state.");
        if (this.a == null) {
            o();
        } else {
            cn.jiguang.bb.b.a().b(1006, PayTask.j, this.n);
        }
    }

    public cn.jiguang.av.h c() {
        return this.a;
    }

    public boolean d() {
        return this.g;
    }

    public void e() {
        cn.jiguang.ar.c.c("JCoreTCPManager", "updateHeartBeatInterval  -- current HeartBeatInterval = " + this.q);
        int i2 = this.p;
        if (i2 > 0) {
            int i3 = this.q;
            if (i3 == 0) {
                this.q = i2 * 2;
                return;
            }
            int i4 = i3 * 2;
            int i5 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
            if (i4 < i5 / 2) {
                this.q = i3 * 2;
            } else {
                this.q = i5;
            }
        }
    }

    public int f() {
        cn.jiguang.ar.c.c("JCoreTCPManager", "getHeartBeatInterval  -- current HeartBeatInterval = " + this.q);
        int i2 = this.p;
        if (i2 > 0) {
            int i3 = this.q;
            return i3 == 0 ? i2 : i3;
        }
        return JConstants.DEFAULT_HEARTBEAT_INTERVAL;
    }

    public int g() {
        cn.jiguang.ar.c.c("JCoreTCPManager", "getNextHbIntervalForLog  -- current HeartBeatInterval = " + this.q);
        int i2 = this.p;
        if (i2 > 0) {
            int i3 = this.q;
            if (i3 == 0) {
                int i4 = i2 * 2;
                int i5 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
                return i4 < i5 / 2 ? i2 * 2 : i5;
            }
            int i6 = i3 * 2;
            int i7 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
            return i6 < i7 / 2 ? i3 * 2 : i7;
        }
        return JConstants.DEFAULT_HEARTBEAT_INTERVAL;
    }

    public int h() {
        cn.jiguang.ar.c.c("JCoreTCPManager", "getAlarmDelay  -- current HeartBeatInterval = " + this.q);
        int i2 = this.p;
        if (i2 > 0) {
            int i3 = this.q;
            return i3 == 0 ? i2 + 5 : i3 + 5;
        }
        return JConstants.DEFAULT_ALARM_DELAY;
    }

    public void i() {
        this.q = 0;
        g.a().b();
    }
}
